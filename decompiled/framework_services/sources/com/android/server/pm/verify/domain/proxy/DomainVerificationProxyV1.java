package com.android.server.pm.verify.domain.proxy;

import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.verify.domain.DomainVerificationInfo;
import android.os.Process;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.verify.domain.DomainVerificationCollector;
import com.android.server.pm.verify.domain.DomainVerificationManagerInternal;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationProxyV1 implements DomainVerificationProxy {
    private static final boolean DEBUG_BROADCASTS = false;
    private static final String TAG = "DomainVerificationProxyV1";
    private final DomainVerificationCollector mCollector;
    private final Connection mConnection;
    private final Context mContext;
    private final Object mLock;
    private final DomainVerificationManagerInternal mManager;
    private final ArrayMap<Integer, Pair<UUID, String>> mRequests;
    private int mVerificationToken;
    private final ComponentName mVerifierComponent;

    public interface Connection extends DomainVerificationProxy.BaseConnection {
        AndroidPackage getPackage(String r1);
    }

    private static class Response {
        public final int callingUid;
        public final List<String> failedDomains;
        public final int verificationCode;
        public final int verificationId;

        /* synthetic */ Response(int r1, int r2, int r3, List r4, DomainVerificationProxyV1IA r5) {
            this(r1, r2, r3, r4);
        }

        private Response(int callingUid, int verificationId, int verificationCode, List<String> failedDomains) {
            this.callingUid = callingUid;
            this.verificationId = verificationId;
            this.verificationCode = verificationCode;
            if (failedDomains != null) goto L5;
            List<String> r0 = Collections.emptyList();
        L6:
            this.failedDomains = r0;
            return;
        L5:
            r0 = failedDomains;
            goto L6
        }
    }

    public DomainVerificationProxyV1(Context context, DomainVerificationManagerInternal manager, DomainVerificationCollector collector, Connection connection, ComponentName verifierComponent) {
        this.mLock = new Object();
        this.mRequests = new ArrayMap();
        this.mVerificationToken = 0;
        this.mContext = context;
        this.mConnection = connection;
        this.mVerifierComponent = verifierComponent;
        this.mManager = manager;
        this.mCollector = collector;
    }

    public static void queueLegacyVerifyResult(Context context, Connection connection, int verificationId, int verificationCode, List<String> failedDomains, int callingUid) {
        context.enforceCallingOrSelfPermission("android.permission.INTENT_FILTER_VERIFICATION_AGENT", "Only the intent filter verification agent can verify applications");
        connection.schedule(3, new Response(callingUid, verificationId, verificationCode, failedDomains, null));
    }

    @Override // com.android.server.pm.verify.domain.proxy.DomainVerificationProxy
    public void sendBroadcastForPackages(Set<String> packageNames) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int size = this.mRequests.size();     // Catch: Throwable -> L9
        int index = size - 1;     // Catch: Throwable -> L9
    L5:
        if (index < 0) goto L13;
        Pair<UUID, String> pair = this.mRequests.valueAt(index);     // Catch: Throwable -> L9
        if (packageNames.contains(pair.second) == false) goto L11;
        this.mRequests.removeAt(index);     // Catch: Throwable -> L9
    L11:
        index = index - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mConnection.schedule(2, packageNames);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.verify.domain.proxy.DomainVerificationProxy
    public boolean runMessage(int messageCode, Object object) {
        switch(messageCode) {
            case 2: goto L60;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        Response response = (Response) object;
        Pair<UUID, String> pair = this.mRequests.get(Integer.valueOf(response.verificationId));
        if (pair != null) goto L9;
        return true;
    L9:
        UUID domainSetId = (UUID) pair.first;
        String packageName = (String) pair.second;
        DomainVerificationInfo info = this.mManager.getDomainVerificationInfo(packageName);     // Catch: PackageManager.NameNotFoundException -> L57
        if (info != null) goto L15;
        return true;
    L15:
        if (Objects.equals(domainSetId, info.getIdentifier()) == true) goto L17;
        return true;
    L17:
        AndroidPackage pkg = this.mConnection.getPackage(packageName);
        if (pkg != null) goto L20;
        return true;
    L20:
        ArraySet<? extends String> failedDomains = new ArraySet(response.failedDomains);
        Map<String, Integer> hostToStateMap = info.getHostToStateMap();
        Set<String> hostKeySet = hostToStateMap.keySet();
        ArraySet<String> successfulDomains = new ArraySet(hostKeySet);
        successfulDomains.removeAll(failedDomains);
        int size = successfulDomains.size();
        int index = size - 1;
    L21:
        if (index < 0) goto L30;
        String domain = successfulDomains.valueAt(index);
        if (domain.startsWith("*.") == false) goto L29;
        String nonWildcardDomain = domain.substring(2);
        if (failedDomains.contains(nonWildcardDomain) == false) goto L29;
        failedDomains.add(domain);
        successfulDomains.removeAt(index);
        if (hostKeySet.contains(nonWildcardDomain) == true) goto L29;
        failedDomains.remove(nonWildcardDomain);
    L29:
        index = index - 1;
        goto L21
    L30:
        int callingUid = response.callingUid;
        if (successfulDomains.isEmpty() == false) goto L77;
        boolean r16 = true;
    L47:
        if (failedDomains.isEmpty() == false) goto L83;
    L56:
        return r16;
    L83:
    L52:
        e = move-exception;
        Slog.e(TAG, "Failure reporting failed domains for " + packageName, e);
        goto L56
    L49:
        if (this.mManager.setDomainVerificationStatusInternal(callingUid, domainSetId, failedDomains, 6) == 0) goto L56;
        Slog.e(TAG, "Failure reporting failed domains for " + packageName);     // Catch: Exception -> L52
        goto L56
    L77:
    L40:
        e = e;
        r16 = true;
    L44:
        Slog.e(TAG, "Failure reporting successful domains for " + packageName, e);
        goto L47
    L33:
        if (this.mManager.setDomainVerificationStatusInternal(callingUid, domainSetId, successfulDomains, 1) == 0) goto L42;
        StringBuilder r15 = new StringBuilder();     // Catch: Exception -> L40
        r16 = true;
        r15.append("Failure reporting successful domains for ");     // Catch: Exception -> L38
        r15.append(packageName);     // Catch: Exception -> L38
        Slog.e(TAG, r15.toString());     // Catch: Exception -> L38
    L38:
        e = e;
        goto L44
    L42:
        r16 = true;
    L59:
        return true;
    L60:
        Set<String> packageNames = (Set) object;
        ArrayMap<Integer, Pair<UUID, String>> newRequests = new ArrayMap(packageNames.size());
        Object r4 = this.mLock;
        monitor-enter(r4);
        Iterator<String> r0 = packageNames.iterator();     // Catch: Throwable -> L69
    L64:
        if (r0.hasNext() == false) goto L71;
        String packageName2 = r0.next();     // Catch: Throwable -> L69
        UUID domainSetId2 = this.mManager.getDomainVerificationInfoId(packageName2);     // Catch: Throwable -> L69
        if (domainSetId2 == null) goto L64;
        int r7 = this.mVerificationToken;     // Catch: Throwable -> L69
        this.mVerificationToken = r7 + 1;     // Catch: Throwable -> L69
        newRequests.put(Integer.valueOf(r7), Pair.create(domainSetId2, packageName2));     // Catch: Throwable -> L69
        goto L64
    L71:
        this.mRequests.putAll(newRequests);     // Catch: Throwable -> L69
        monitor-exit(r4);     // Catch: Throwable -> L69
        sendBroadcasts(newRequests);
        return true;
    L69:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.verify.domain.proxy.DomainVerificationProxy
    public boolean isCallerVerifier(int callingUid) {
        return this.mConnection.isCallerPackage(callingUid, this.mVerifierComponent.getPackageName());
    }

    private void sendBroadcasts(ArrayMap<Integer, Pair<UUID, String>> verifications) {
        long allowListTimeout = this.mConnection.getPowerSaveTempWhitelistAppDuration();
        this.mConnection.getDeviceIdleInternal().addPowerSaveTempWhitelistApp(Process.myUid(), this.mVerifierComponent.getPackageName(), allowListTimeout, 0, true, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_DOMAIN_VERIFICATION_V1, "domain verification agent");
        int size = verifications.size();
        int index = 0;
    L3:
        if (index >= size) goto L10;
        int verificationId = verifications.keyAt(index).intValue();
        String packageName = (String) verifications.valueAt(index).second;
        AndroidPackage pkg = this.mConnection.getPackage(packageName);
        if (pkg == null) goto L8;
        String hostsString = buildHostsString(pkg);
        Intent intent = new Intent("android.intent.action.INTENT_FILTER_NEEDS_VERIFICATION").setComponent(this.mVerifierComponent).putExtra("android.content.pm.extra.INTENT_FILTER_VERIFICATION_ID", verificationId).putExtra("android.content.pm.extra.INTENT_FILTER_VERIFICATION_URI_SCHEME", "https").putExtra("android.content.pm.extra.INTENT_FILTER_VERIFICATION_HOSTS", hostsString).putExtra("android.content.pm.extra.INTENT_FILTER_VERIFICATION_PACKAGE_NAME", packageName).addFlags(268435456);
        BroadcastOptions options = BroadcastOptions.makeBasic();
        long allowListTimeout2 = allowListTimeout;
        options.setTemporaryAppAllowlist(allowListTimeout2, 0, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_DOMAIN_VERIFICATION_V1, "");
        allowListTimeout = allowListTimeout2;
        this.mContext.sendBroadcastAsUser(intent, UserHandle.SYSTEM, null, options.toBundle());
    L8:
        index = index + 1;
        goto L3
    }

    private String buildHostsString(AndroidPackage pkg) {
        ArraySet<String> domains = this.mCollector.collectValidAutoVerifyDomains(pkg);
        StringBuilder builder = new StringBuilder();
        int size = domains.size();
        int index = 0;
    L3:
        if (index >= size) goto L11;
        if (index <= 0) goto L6;
        builder.append(" ");
    L6:
        String domain = domains.valueAt(index);
        if (domain.startsWith("*.") == false) goto L9;
        domain = domain.substring(2);
    L9:
        builder.append(domain);
        index = index + 1;
        goto L3
    L11:
        return builder.toString();
    }

    @Override // com.android.server.pm.verify.domain.proxy.DomainVerificationProxy
    public ComponentName getComponentName() {
        return this.mVerifierComponent;
    }
}
