package com.android.server.pm;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.AuxiliaryResolveInfo;
import android.content.pm.InstantAppIntentFilter;
import android.content.pm.InstantAppRequest;
import android.content.pm.InstantAppRequestInfo;
import android.content.pm.InstantAppResolveInfo;
import android.metrics.LogMaker;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import com.android.internal.logging.MetricsLogger;
import com.android.server.pm.resolution.ComponentResolver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InstantAppResolver {
    private static final boolean DEBUG_INSTANT = false;
    private static final int RESOLUTION_BIND_TIMEOUT = 2;
    private static final int RESOLUTION_CALL_TIMEOUT = 3;
    private static final int RESOLUTION_FAILURE = 1;
    private static final int RESOLUTION_SUCCESS = 0;
    private static final String TAG = "PackageManager";
    private static MetricsLogger sMetricsLogger;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResolutionStatus {
    }

    /* JADX INFO: renamed from: -$$Nest$smfilterInstantAppIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ AuxiliaryResolveInfo m6683$$Nest$smfilterInstantAppIntent(Computer r0, UserManagerService r1, List r2, Intent r3, String r4, int r5, String r6, String r7, int[] r8) {
        return filterInstantAppIntent(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: -$$Nest$smlogMetrics, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6684$$Nest$smlogMetrics(int r0, long r1, String r3, int r4) {
        logMetrics(r0, r1, r3, r4);
    }

    public InstantAppResolver() {
    }

    static {
        DEBUG_INSTANT = Build.IS_DEBUGGABLE;
    }

    private static MetricsLogger getLogger() {
        if (sMetricsLogger != null) goto L6;
        sMetricsLogger = new MetricsLogger();
    L6:
        return sMetricsLogger;
    }

    public static Intent sanitizeIntent(Intent origIntent) {
        Intent sanitizedIntent = new Intent(origIntent.getAction());
        Set<String> categories = origIntent.getCategories();
        if (categories == null) goto L9;
        Iterator<String> r2 = categories.iterator();
    L6:
        if (r2.hasNext() == false) goto L9;
        String category = r2.next();
        sanitizedIntent.addCategory(category);
    L9:
        if (origIntent.getData() != null) goto L11;
        Uri sanitizedUri = null;
    L12:
        sanitizedIntent.setDataAndType(sanitizedUri, origIntent.getType());
        sanitizedIntent.addFlags(origIntent.getFlags());
        sanitizedIntent.setPackage(origIntent.getPackage());
        return sanitizedIntent;
    L11:
        sanitizedUri = Uri.fromParts(origIntent.getScheme(), "", "");
        goto L12
    }

    public static InstantAppResolveInfo.InstantAppDigest parseDigest(Intent origIntent) {
        if (origIntent.getData() == null) goto L9;
        if (TextUtils.isEmpty(origIntent.getData().getHost()) == true) goto L9;
        return new InstantAppResolveInfo.InstantAppDigest(origIntent.getData().getHost(), 5);
    L9:
        return InstantAppResolveInfo.InstantAppDigest.UNDEFINED;
    }

    public static AuxiliaryResolveInfo doInstantAppResolutionPhaseOne(Computer computer, UserManagerService userManager, InstantAppResolverConnection connection, InstantAppRequest requestObj) {
        long startTime = System.currentTimeMillis();
        String token = requestObj.token;
        if (DEBUG_INSTANT == false) goto L5;
        Log.d("PackageManager", "[" + token + "] Phase1; resolving");
    L5:
        AuxiliaryResolveInfo resolveInfo = null;
        Intent origIntent = requestObj.origIntent;
        List<InstantAppResolveInfo> instantAppResolveInfoList = connection.getInstantAppResolveInfoList(buildRequestInfo(requestObj));     // Catch: InstantAppResolverConnection.ConnectionException -> L16
        if (instantAppResolveInfoList != null) goto L9;
    L18:
        int r15 = 2;
        AuxiliaryResolveInfo resolveInfo2 = null;
    L19:
        resolveInfo = resolveInfo2;
        int resolutionStatus = 0;
    L28:
        if (requestObj.resolveForStart == false) goto L32;
        if (resolutionStatus != 0) goto L32;
        logMetrics(899, startTime, token, resolutionStatus);
    L32:
        if (DEBUG_INSTANT == false) goto L42;
        if (resolveInfo != null) goto L42;
        if (resolutionStatus != r15) goto L37;
        Log.d("PackageManager", "[" + token + "] Phase1; bind timed out");
        goto L42
    L37:
        if (resolutionStatus != 3) goto L39;
        Log.d("PackageManager", "[" + token + "] Phase1; call timed out");
        goto L42
    L39:
        if (resolutionStatus == 0) goto L41;
        Log.d("PackageManager", "[" + token + "] Phase1; service connection error");
        goto L42
    L41:
        Log.d("PackageManager", "[" + token + "] Phase1; No results matched");
    L42:
        if (resolveInfo == null) goto L44;
    L47:
        return resolveInfo;
    L44:
        if ((origIntent.getFlags() & 2048) == 0) goto L47;
        return new AuxiliaryResolveInfo(token, false, createFailureIntent(origIntent, token), null, requestObj.hostDigestPrefixSecure);
    L9:
        if (instantAppResolveInfoList.size() <= 0) goto L18;
        r15 = 2;
        resolveInfo2 = filterInstantAppIntent(computer, userManager, instantAppResolveInfoList, origIntent, requestObj.resolvedType, requestObj.userId, origIntent.getPackage(), token, requestObj.hostDigestPrefixSecure);     // Catch: InstantAppResolverConnection.ConnectionException -> L14
        token = token;
    L14:
        e = e;
        token = token;
    L21:
        if (e.failure != 1) goto L24;
        resolutionStatus = 2;
        goto L28
    L24:
        if (e.failure != r15) goto L26;
        resolutionStatus = 3;
        goto L28
    L26:
        resolutionStatus = 1;
    L16:
        e = e;
        r15 = 2;
        goto L21
    }

    public static void doInstantAppResolutionPhaseTwo(final Context context, final Computer computer, final UserManagerService userManager, InstantAppResolverConnection connection, final InstantAppRequest requestObj, final ActivityInfo instantAppInstaller, Handler callbackHandler) {
        long startTime = System.currentTimeMillis();
        final String token = requestObj.token;
        if (DEBUG_INSTANT == false) goto L5;
        Log.d("PackageManager", "[" + token + "] Phase2; resolving");
    L5:
        final Intent origIntent = requestObj.origIntent;
        final Intent sanitizedIntent = sanitizeIntent(origIntent);
        InstantAppResolverConnection.PhaseTwoCallback callback = new AnonymousClass1(computer, userManager, origIntent, token, requestObj, sanitizedIntent, instantAppInstaller, context);
        long startTime2 = startTime;
        connection.getInstantAppIntentFilterList(buildRequestInfo(requestObj), callback, callbackHandler, startTime2);     // Catch: InstantAppResolverConnection.ConnectionException -> L10
        return;
    L10:
        e = e;
    L14:
        int resolutionStatus = 1;
        if (e.failure != 1) goto L17;
        resolutionStatus = 2;
    L17:
        logMetrics(900, startTime2, token, resolutionStatus);
        if (DEBUG_INSTANT == true) goto L20;
        return;
    L20:
        if (resolutionStatus != 2) goto L22;
        Log.d("PackageManager", "[" + token + "] Phase2; bind timed out");
        return;
    L22:
        Log.d("PackageManager", "[" + token + "] Phase2; service connection error");
        return;
    L12:
        e = e;
        startTime2 = startTime;
        goto L14
    }

    public static Intent buildEphemeralInstallerIntent(Intent origIntent, Intent sanitizedIntent, Intent failureIntent, String callingPackage, String callingFeatureId, Bundle verificationBundle, String resolvedType, int userId, ComponentName installFailureActivity, String token, boolean needsPhaseTwo, List<AuxiliaryResolveInfo.AuxiliaryFilter> filters) {
        List<AuxiliaryResolveInfo.AuxiliaryFilter> r5 = filters;
        int flags = origIntent.getFlags();
        Intent intent = new Intent();
        intent.setFlags((1073741824 | flags) | 8388608);
        if (token == null) goto L6;
        intent.putExtra("android.intent.extra.INSTANT_APP_TOKEN", token);
    L6:
        if (origIntent.getData() == null) goto L8;
        intent.putExtra("android.intent.extra.INSTANT_APP_HOSTNAME", origIntent.getData().getHost());
    L8:
        intent.putExtra("android.intent.extra.INSTANT_APP_ACTION", origIntent.getAction());
        intent.putExtra("android.intent.extra.INTENT", sanitizedIntent);
        if (needsPhaseTwo == false) goto L11;
        intent.setAction("android.intent.action.RESOLVE_INSTANT_APP_PACKAGE");
    L47:
        return intent;
    L11:
        ActivityOptions options = ActivityOptions.makeBasic().setPendingIntentCreatorBackgroundActivityStartMode(1);
        if (failureIntent != null) goto L14;
        if (installFailureActivity != null) goto L14;
    L25:
        Intent successIntent = new Intent(origIntent);
        successIntent.setLaunchToken(token);
        IIntentSender successIntentTarget = ActivityManager.getService().getIntentSenderWithFeature(2, callingPackage, callingFeatureId, null, null, 0, new Intent[]{successIntent}, new String[]{resolvedType}, 1409286144, options.toBundle(), userId);     // Catch: RemoteException -> L28
        IntentSender successSender = new IntentSender(successIntentTarget);     // Catch: RemoteException -> L28
        intent.putExtra("android.intent.extra.INSTANT_APP_SUCCESS", successSender);     // Catch: RemoteException -> L28
    L29:
        if (verificationBundle == null) goto L31;
        intent.putExtra("android.intent.extra.VERIFICATION_BUNDLE", verificationBundle);
    L31:
        intent.putExtra("android.intent.extra.CALLING_PACKAGE", callingPackage);
        if (r5 == null) goto L46;
        Bundle[] resolvableFilters = new Bundle[r5.size()];
        int i = 0;
        int max = r5.size();
    L34:
        if (i >= max) goto L45;
        Bundle resolvableFilter = new Bundle();
        AuxiliaryResolveInfo.AuxiliaryFilter filter = r5.get(i);
        if (filter.resolveInfo != null) goto L38;
    L40:
        boolean r1 = false;
    L41:
        resolvableFilter.putBoolean("android.intent.extra.UNKNOWN_INSTANT_APP", r1);
        resolvableFilter.putString("android.intent.extra.PACKAGE_NAME", filter.packageName);
        resolvableFilter.putString("android.intent.extra.SPLIT_NAME", filter.splitName);
        resolvableFilter.putLong("android.intent.extra.LONG_VERSION_CODE", filter.versionCode);
        resolvableFilter.putBundle("android.intent.extra.INSTANT_APP_EXTRAS", filter.extras);
        resolvableFilters[i] = resolvableFilter;
        if (i != 0) goto L44;
        intent.putExtras(resolvableFilter);
        intent.putExtra("android.intent.extra.VERSION_CODE", (int) filter.versionCode);
    L44:
        i = i + 1;
        r5 = filters;
        goto L34
    L38:
        if (filter.resolveInfo.shouldLetInstallerDecide() == false) goto L40;
        r1 = true;
        goto L41
    L45:
        intent.putExtra("android.intent.extra.INSTANT_APP_BUNDLES", resolvableFilters);
    L46:
        intent.setAction("android.intent.action.INSTALL_INSTANT_APP_PACKAGE");
    L14:
        if (installFailureActivity != null) goto L48;
        Intent onFailureIntent = failureIntent;
    L24:
        IIntentSender failureIntentTarget = ActivityManager.getService().getIntentSenderWithFeature(2, callingPackage, callingFeatureId, null, null, 1, new Intent[]{onFailureIntent}, new String[]{resolvedType}, 1409286144, options.toBundle(), userId);     // Catch: RemoteException -> L20
        IntentSender failureSender = new IntentSender(failureIntentTarget);     // Catch: RemoteException -> L20
        intent.putExtra("android.intent.extra.INSTANT_APP_FAILURE", failureSender);     // Catch: RemoteException -> L20
        goto L25
    L48:
        onFailureIntent = new Intent();     // Catch: RemoteException -> L20
        onFailureIntent.setComponent(installFailureActivity);     // Catch: RemoteException -> L20
        if (r5 != null) goto L18;
    L22:
        onFailureIntent.putExtra("android.intent.extra.INTENT", origIntent);     // Catch: RemoteException -> L20
        goto L24
    L18:
        if (r5.size() != 1) goto L22;
        onFailureIntent.putExtra("android.intent.extra.SPLIT_NAME", r5.get(0).splitName);     // Catch: RemoteException -> L20
        goto L22
    }

    private static InstantAppRequestInfo buildRequestInfo(InstantAppRequest request) {
        return new InstantAppRequestInfo(sanitizeIntent(request.origIntent), request.hostDigestPrefixSecure, UserHandle.of(request.userId), request.isRequesterInstantApp, request.token);
    }

    private static AuxiliaryResolveInfo filterInstantAppIntent(Computer computer, UserManagerService userManager, List<InstantAppResolveInfo> instantAppResolveInfoList, Intent origIntent, String resolvedType, int userId, String packageName, String token, int[] hostDigestPrefixSecure) {
        InstantAppResolveInfo.InstantAppDigest digest = parseDigest(origIntent);
        int[] shaPrefix = digest.getDigestPrefix();
        byte[][] digestBytes = digest.getDigestBytes();
        if (origIntent.isWebIntent() == false) goto L5;
    L10:
        boolean requiresPrefixMatch = true;
    L11:
        Iterator<InstantAppResolveInfo> r7 = instantAppResolveInfoList.iterator();
        boolean requiresSecondPhase = false;
        ArrayList<AuxiliaryResolveInfo.AuxiliaryFilter> filters = null;
    L12:
        boolean requiresSecondPhase2 = r7.hasNext();
        if (requiresSecondPhase2 == false) goto L41;
        InstantAppResolveInfo instantAppResolveInfo = r7.next();
        if (requiresPrefixMatch == false) goto L19;
        if (instantAppResolveInfo.shouldLetInstallerDecide() == false) goto L19;
        Slog.d("PackageManager", "InstantAppResolveInfo with mShouldLetInstallerDecide=true when digest required; ignoring");
    L19:
        byte[] filterDigestBytes = instantAppResolveInfo.getDigestBytes();
        if (shaPrefix.length <= 0) goto L32;
        if (requiresPrefixMatch == false) goto L23;
    L24:
        boolean matchFound = false;
        int i = shaPrefix.length - 1;
    L25:
        if (i < 0) goto L30;
        if (Arrays.equals(digestBytes[i], filterDigestBytes) == true) goto L28;
        i = i - 1;
        goto L25
    L28:
        matchFound = true;
    L30:
        if (matchFound == true) goto L32;
    L23:
        if (filterDigestBytes.length > 0) goto L24;
    L32:
        List<AuxiliaryResolveInfo.AuxiliaryFilter> matchFilters = computeResolveFilters(computer, userManager, origIntent, resolvedType, userId, packageName, token, instantAppResolveInfo);
        if (matchFilters == null) goto L12;
        if (matchFilters.isEmpty() == false) goto L37;
        requiresSecondPhase = true;
    L37:
        if (filters == null) goto L38;
        filters.addAll(matchFilters);
        goto L12
    L38:
        filters = new ArrayList(matchFilters);
        goto L12
    L41:
        if (filters == null) goto L47;
        if (filters.isEmpty() == true) goto L47;
        return new AuxiliaryResolveInfo(token, requiresSecondPhase, createFailureIntent(origIntent, token), filters, hostDigestPrefixSecure);
    L47:
        return null;
    L5:
        if (shaPrefix.length > 0) goto L7;
    L9:
        requiresPrefixMatch = false;
        goto L11
    L7:
        if ((origIntent.getFlags() & 2048) != 0) goto L9;
        goto L9
    }

    private static Intent createFailureIntent(Intent origIntent, String token) {
        Intent failureIntent = new Intent(origIntent);
        failureIntent.setFlags(failureIntent.getFlags() | Integer.MIN_VALUE);
        failureIntent.setFlags(failureIntent.getFlags() & (-2049));
        failureIntent.setLaunchToken(token);
        return failureIntent;
    }

    private static List<AuxiliaryResolveInfo.AuxiliaryFilter> computeResolveFilters(Computer computer, UserManagerService userManager, Intent origIntent, String resolvedType, int userId, String packageName, String token, InstantAppResolveInfo instantAppInfo) {
        List<AuxiliaryResolveInfo.AuxiliaryFilter> r4 = null;
        if (instantAppInfo.shouldLetInstallerDecide() == true) goto L5;
        if (packageName != null) goto L8;
    L10:
        List<InstantAppIntentFilter> instantAppFilters = instantAppInfo.getIntentFilters();
        if (instantAppFilters == null) goto L54;
        if (instantAppFilters.isEmpty() == true) goto L54;
        ComponentResolver.InstantAppIntentResolver instantAppResolver = new ComponentResolver.InstantAppIntentResolver(userManager);
        int j = instantAppFilters.size() - 1;
    L16:
        if (j < 0) goto L42;
        InstantAppIntentFilter instantAppFilter = instantAppFilters.get(j);
        List<IntentFilter> splitFilters = instantAppFilter.getFilters();
        if (splitFilters == null) goto L41;
        if (splitFilters.isEmpty() == true) goto L41;
        int k = splitFilters.size() - 1;
    L23:
        if (k < 0) goto L41;
        IntentFilter filter = splitFilters.get(k);
        Iterator<IntentFilter.AuthorityEntry> authorities = filter.authoritiesIterator();
        if (authorities == null) goto L29;
        if (authorities.hasNext() == false) goto L29;
    L37:
        instantAppResolver.addFilter(computer, new AuxiliaryResolveInfo.AuxiliaryFilter(filter, instantAppInfo, instantAppFilter.getSplitName(), instantAppInfo.getExtras()));
    L38:
        k = k - 1;
        r4 = r4;
    L29:
        if (filter.hasDataScheme("http") == true) goto L33;
        if (filter.hasDataScheme("https") == false) goto L37;
    L33:
        if (filter.hasAction("android.intent.action.VIEW") == false) goto L37;
        if (filter.hasCategory("android.intent.category.BROWSABLE") == false) goto L37;
    L41:
        j = j - 1;
        r4 = r4;
        goto L16
    L42:
        List<AuxiliaryResolveInfo.AuxiliaryFilter> r16 = r4;
        List<AuxiliaryResolveInfo.AuxiliaryFilter> matchedResolveInfoList = instantAppResolver.queryIntent(computer, origIntent, resolvedType, false, userId);
        if (matchedResolveInfoList.isEmpty() == true) goto L49;
        if (DEBUG_INSTANT == false) goto L47;
        Log.d("PackageManager", "[" + token + "] Found match(es); " + matchedResolveInfoList);
    L47:
        return matchedResolveInfoList;
    L49:
        if (DEBUG_INSTANT == false) goto L51;
        Log.d("PackageManager", "[" + token + "] No matches found package: " + instantAppInfo.getPackageName() + ", versionCode: " + instantAppInfo.getVersionCode());
    L51:
        return r16;
    L54:
        if (origIntent.isWebIntent() == false) goto L57;
        return 0;
    L57:
        if (DEBUG_INSTANT == false) goto L60;
        Log.d("PackageManager", "No app filters; go to phase 2");
    L60:
        return Collections.emptyList();
    L8:
        if (packageName.equals(instantAppInfo.getPackageName()) == true) goto L10;
        return null;
    L5:
        return Collections.singletonList(new AuxiliaryResolveInfo.AuxiliaryFilter(instantAppInfo, null, instantAppInfo.getExtras()));
    }

    private static void logMetrics(int action, long startTime, String token, int status) {
        LogMaker logMaker = new LogMaker(action).setType(4).addTaggedData(901, new Long(System.currentTimeMillis() - startTime)).addTaggedData(903, token).addTaggedData(902, new Integer(status));
        getLogger().write(logMaker);
    }
}
