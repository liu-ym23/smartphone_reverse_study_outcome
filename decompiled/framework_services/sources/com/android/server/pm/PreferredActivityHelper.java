package com.android.server.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.Xml;
import com.android.internal.util.ArrayUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.net.NetworkPolicyManagerInternal;
import com.android.server.pm.pkg.PackageStateInternal;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class PreferredActivityHelper {
    private static final String TAG_DEFAULT_APPS = "da";
    private static final String TAG_PREFERRED_BACKUP = "pa";
    private final BroadcastHelper mBroadcastHelper;
    private final PackageManagerService mPm;

    private interface BlobXmlRestorer {
        void apply(TypedXmlPullParser r1, int r2) throws IOException, XmlPullParserException;
    }

    public static /* synthetic */ void $r8$lambda$Aks2ICOp_hNourBwhBzdiqPyMQM(PreferredActivityHelper r0, int r1, Boolean r2) {
        r0.lambda$updateDefaultHomeNotLocked$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$bKq6HYe2CK6GmfD6XXGEZix7pRI(PreferredActivityHelper r0, TypedXmlPullParser r1, int r2) {
        r0.lambda$restoreDefaultApps$2(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$ipe1UDUqF_Trmw2ff0zpCaFof-Y, reason: not valid java name */
    public static /* synthetic */ void m6885$r8$lambda$ipe1UDUqF_Trmw2ff0zpCaFofY(PreferredActivityHelper r0, TypedXmlPullParser r1, int r2) {
        r0.lambda$restorePreferredActivities$1(r1, r2);
    }

    PreferredActivityHelper(PackageManagerService pm, BroadcastHelper broadcastHelper) {
        this.mPm = pm;
        this.mBroadcastHelper = broadcastHelper;
    }

    private ResolveInfo findPreferredActivityNotLocked(Computer snapshot, Intent intent, String resolvedType, long flags, List<ResolveInfo> query, boolean always, boolean removeMatches, boolean debug, int userId) {
        if (UserHandle.getAppId(Binder.getCallingUid()) < 10000) goto L6;
        boolean r0 = true;
    L8:
        return findPreferredActivityNotLocked(snapshot, intent, resolvedType, flags, query, always, removeMatches, debug, userId, r0);
    L6:
        r0 = false;
        goto L8
    }

    public ResolveInfo findPreferredActivityNotLocked(Computer snapshot, Intent intent, String resolvedType, long flags, List<ResolveInfo> query, boolean always, boolean removeMatches, boolean debug, int userId, boolean queryMayBeFiltered) {
        if (Thread.holdsLock(this.mPm.mLock) == false) goto L6;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Calling thread " + Thread.currentThread().getName() + " is holding mLock", new Throwable());
    L6:
        if (this.mPm.mUserManager.exists(userId) == true) goto L9;
        return null;
    L9:
        PackageManagerService.FindPreferredActivityBodyResult body = snapshot.findPreferredActivityInternal(intent, resolvedType, flags, query, always, removeMatches, debug, userId, queryMayBeFiltered);
        if (body.mChanged == false) goto L12;
        this.mPm.scheduleWritePackageRestrictions(userId);
    L12:
        if (debug == false) goto L17;
        if (body.mPreferredResolveInfo != null) goto L17;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "No preferred activity to return");
    L17:
        return body.mPreferredResolveInfo;
    }

    public void clearPackagePreferredActivities(String packageName, int userId) {
        SparseBooleanArray changedUsers = new SparseBooleanArray();
        PackageManagerTracedLock r1 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        this.mPm.clearPackagePreferredActivitiesLPw(packageName, changedUsers, userId);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (changedUsers.size() <= 0) goto L16;
        updateDefaultHomeNotLocked(this.mPm.snapshotComputer(), changedUsers);
        this.mBroadcastHelper.sendPreferredActivityChangedBroadcast(userId);
        this.mPm.scheduleWritePackageRestrictions(userId);
        return;
    L16:
        return;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public boolean updateDefaultHomeNotLocked(Computer snapshot, final int userId) {
        if (Thread.holdsLock(this.mPm.mLock) == false) goto L6;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Calling thread " + Thread.currentThread().getName() + " is holding mLock", new Throwable());
    L6:
        if (this.mPm.isSystemReady() == true) goto L8;
        return false;
    L8:
        Intent intent = snapshot.getHomeIntent();
        List<ResolveInfo> resolveInfos = snapshot.queryIntentActivitiesInternal(intent, null, 786432, userId);
        ResolveInfo preferredResolveInfo = findPreferredActivityNotLocked(snapshot, intent, null, 0, resolveInfos, true, false, false, userId);
        if (preferredResolveInfo != null) goto L11;
    L13:
        String packageName = null;
    L14:
        String currentPackageName = this.mPm.getActiveLauncherPackageName(userId);
        if (TextUtils.equals(currentPackageName, packageName) == false) goto L17;
        return false;
    L17:
        String[] callingPackages = snapshot.getPackagesForUid(Binder.getCallingUid());
        if (callingPackages != null) goto L20;
    L22:
        if (packageName != null) goto L25;
        return false;
    L25:
        return this.mPm.setActiveLauncherPackage(packageName, userId, new PreferredActivityHelper$$ExternalSyntheticLambda0(this, userId));
    L20:
        if (ArrayUtils.contains(callingPackages, this.mPm.mRequiredPermissionControllerPackage) == false) goto L22;
        return false;
    L11:
        if (preferredResolveInfo.activityInfo == null) goto L13;
        packageName = preferredResolveInfo.activityInfo.packageName;
        goto L14
    }

    private /* synthetic */ void lambda$updateDefaultHomeNotLocked$0(int userId, Boolean successful) {
        if (successful.booleanValue() == false) goto L6;
        this.mBroadcastHelper.sendPreferredActivityChangedBroadcast(userId);
        return;
    }

    public void addPreferredActivity(Computer snapshot, WatchedIntentFilter filter, int match, ComponentName[] set, ComponentName activity, boolean always, int userId, String opname, boolean removeExisting) {
        int callingUid = Binder.getCallingUid();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "add preferred activity");
        if (this.mPm.mContext.checkCallingOrSelfPermission("android.permission.SET_PREFERRED_APPLICATIONS") == 0) goto L10;
        if (snapshot.getUidTargetSdkVersion(callingUid) >= 8) goto L8;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Ignoring addPreferredActivity() from uid " + callingUid);
        return;
    L8:
        this.mPm.mContext.enforceCallingOrSelfPermission("android.permission.SET_PREFERRED_APPLICATIONS", null);
    L10:
        if (filter.countActions() != 0) goto L13;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot set a preferred activity with no filter actions");
        return;
    L13:
        PackageManagerTracedLock r9 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r9);
        PreferredIntentResolver pir = this.mPm.mSettings.editPreferredActivitiesLPw(userId);     // Catch: Throwable -> L19
        ArrayList<PreferredActivity> existing = pir.findFilters(filter);     // Catch: Throwable -> L19
        if (removeExisting == false) goto L21;
        if (existing == null) goto L21;
        Settings.removeFilters(pir, filter, existing);     // Catch: Throwable -> L19
    L21:
        pir.addFilter(this.mPm.snapshotComputer(), new PreferredActivity(filter, match, set, activity, always));     // Catch: Throwable -> L19
        this.mPm.scheduleWritePackageRestrictions(userId);     // Catch: Throwable -> L19
        monitor-exit(r9);     // Catch: Throwable -> L19
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (isHomeFilter(filter) == true) goto L26;
    L27:
        this.mBroadcastHelper.sendPreferredActivityChangedBroadcast(userId);
        return;
    L26:
        if (updateDefaultHomeNotLocked(this.mPm.snapshotComputer(), userId) == false) goto L27;
        return;
    L19:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void replacePreferredActivity(Computer snapshot, WatchedIntentFilter filter, int match, ComponentName[] set, ComponentName activity, int userId) {
        if (filter.countActions() != 1) goto L73;
        if (filter.countDataAuthorities() != 0) goto L71;
        if (filter.countDataPaths() != 0) goto L71;
        if (filter.countDataSchemes() > 1) goto L71;
        if (filter.countDataTypes() != 0) goto L71;
        int callingUid = Binder.getCallingUid();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "replace preferred activity");
        if (this.mPm.mContext.checkCallingOrSelfPermission("android.permission.SET_PREFERRED_APPLICATIONS") == 0) goto L29;
        PackageManagerTracedLock r4 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
    L22:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L17:
        if (this.mPm.snapshotComputer().getUidTargetSdkVersion(callingUid) >= 8) goto L24;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Ignoring replacePreferredActivity() from uid " + Binder.getCallingUid());     // Catch: Throwable -> L22
        monitor-exit(r4);     // Catch: Throwable -> L22
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L24:
        monitor-exit(r4);     // Catch: Throwable -> L22
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mPm.mContext.enforceCallingOrSelfPermission("android.permission.SET_PREFERRED_APPLICATIONS", null);
    L29:
        PackageManagerTracedLock r5 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        PreferredIntentResolver pir = this.mPm.mSettings.getPreferredActivities(userId);     // Catch: Throwable -> L52
        if (pir != null) goto L74;
        ComponentName r8 = activity;
    L64:
        monitor-exit(r5);     // Catch: Throwable -> L52
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        addPreferredActivity(this.mPm.snapshotComputer(), filter, match, set, r8, true, userId, "Replacing preferred", false);
        return;
    L74:
        ArrayList<PreferredActivity> existing = pir.findFilters(filter);     // Catch: Throwable -> L57
        if (existing != null) goto L36;
    L60:
        r8 = activity;
    L61:
        if (existing == null) goto L64;
        Settings.removeFilters(pir, filter, existing);     // Catch: Throwable -> L52
        goto L64
    L36:
        if (existing.size() != 1) goto L60;
        PreferredActivity cur = existing.get(0);     // Catch: Throwable -> L57
        if (cur.mPref.mAlways == false) goto L59;
        r8 = activity;
    L54:
        th = th;
    L67:
        monitor-exit(r5);     // Catch: Throwable -> L52
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L42:
        if (cur.mPref.mComponent.equals(r8) == false) goto L61;
        if (cur.mPref.mMatch != (268369920 & match)) goto L61;
        if (cur.mPref.sameSet(set) == false) goto L61;
        monitor-exit(r5);     // Catch: Throwable -> L52
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L59:
        r8 = activity;
    L57:
        th = th;
    L52:
        th = th;
    L71:
        throw new IllegalArgumentException("replacePreferredActivity expects filter to have no data authorities, paths, or types; and at most one scheme.");
    L73:
        throw new IllegalArgumentException("replacePreferredActivity expects filter to have only 1 action.");
    }

    public void clearPackagePreferredActivities(Computer snapshot, String packageName) {
        int callingUid = Binder.getCallingUid();
        if (snapshot.getInstantAppPackageName(callingUid) == null) goto L5;
        return;
    L5:
        PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
        if (packageState == null) goto L10;
        if (snapshot.isCallerSameApp(packageName, callingUid) == false) goto L10;
    L16:
        if (packageState != null) goto L18;
    L20:
        int callingUserId = UserHandle.getCallingUserId();
        clearPackagePreferredActivities(packageName, callingUserId);
        return;
    L18:
        if (snapshot.shouldFilterApplication(packageState, callingUid, UserHandle.getUserId(callingUid)) == false) goto L20;
        return;
    L10:
        if (this.mPm.mContext.checkCallingOrSelfPermission("android.permission.SET_PREFERRED_APPLICATIONS") == 0) goto L16;
        if (snapshot.getUidTargetSdkVersion(callingUid) >= 8) goto L15;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Ignoring clearPackagePreferredActivities() from uid " + callingUid);
        return;
    L15:
        this.mPm.mContext.enforceCallingOrSelfPermission("android.permission.SET_PREFERRED_APPLICATIONS", null);
        goto L16
    }

    void updateDefaultHomeNotLocked(Computer snapshot, SparseBooleanArray userIds) {
        if (Thread.holdsLock(this.mPm.mLock) == false) goto L5;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Calling thread " + Thread.currentThread().getName() + " is holding mLock", new Throwable());
    L5:
        int i = userIds.size() - 1;
    L6:
        if (i < 0) goto L9;
        int userId = userIds.keyAt(i);
        updateDefaultHomeNotLocked(snapshot, userId);
        i = i - 1;
        goto L6
    }

    public void setHomeActivity(Computer snapshot, ComponentName comp, int userId) {
        if (snapshot.getInstantAppPackageName(Binder.getCallingUid()) == null) goto L5;
        return;
    L5:
        ArrayList<ResolveInfo> homeActivities = new ArrayList();
        snapshot.getHomeActivitiesAsUser(homeActivities, userId);
        boolean found = false;
        int size = homeActivities.size();
        ComponentName[] set = new ComponentName[size];
        int i = 0;
    L6:
        if (i >= size) goto L14;
        ResolveInfo candidate = homeActivities.get(i);
        ActivityInfo info = candidate.activityInfo;
        ComponentName activityName = new ComponentName(info.packageName, info.name);
        set[i] = activityName;
        if (found == true) goto L12;
        if (activityName.equals(comp) == false) goto L12;
        found = true;
    L12:
        i = i + 1;
        goto L6
    L14:
        if (found == false) goto L18;
        replacePreferredActivity(snapshot, getHomeFilter(), 1048576, set, comp, userId);
        return;
    L18:
        throw new IllegalArgumentException("Component " + comp + " cannot be home on user " + userId);
    }

    private WatchedIntentFilter getHomeFilter() {
        WatchedIntentFilter filter = new WatchedIntentFilter("android.intent.action.MAIN");
        filter.addCategory("android.intent.category.HOME");
        filter.addCategory("android.intent.category.DEFAULT");
        return filter;
    }

    public void addPersistentPreferredActivity(WatchedIntentFilter filter, ComponentName activity, int userId) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 1000) goto L26;
        if (filter.checkDataPathAndSchemeSpecificParts() == true) goto L7;
        EventLog.writeEvent(1397638484, new Object[]{"246749702", Integer.valueOf(callingUid)});
        throw new IllegalArgumentException("Invalid intent data paths or scheme specific parts in the filter.");
    L7:
        if (filter.countActions() != 0) goto L10;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot set a preferred activity with no filter actions");
        return;
    L10:
        PackageManagerTracedLock r1 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        this.mPm.mSettings.editPersistentPreferredActivitiesLPw(userId).addFilter(this.mPm.snapshotComputer(), new PersistentPreferredActivity(filter, activity, true));     // Catch: Throwable -> L19
        this.mPm.scheduleWritePackageRestrictions(userId);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (isHomeFilter(filter) == false) goto L17;
        updateDefaultHomeNotLocked(this.mPm.snapshotComputer(), userId);
    L17:
        this.mBroadcastHelper.sendPreferredActivityChangedBroadcast(userId);
        return;
    L19:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L26:
        throw new SecurityException("addPersistentPreferredActivity can only be run by the system");
    }

    public void clearPackagePersistentPreferredActivities(String packageName, int userId) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 1000) goto L17;
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        boolean changed = this.mPm.mSettings.clearPackagePersistentPreferredActivities(packageName, userId);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (changed == false) goto L20;
        updateDefaultHomeNotLocked(this.mPm.snapshotComputer(), userId);
        this.mBroadcastHelper.sendPreferredActivityChangedBroadcast(userId);
        this.mPm.scheduleWritePackageRestrictions(userId);
        return;
    L20:
        return;
    L12:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L17:
        throw new SecurityException("clearPackagePersistentPreferredActivities can only be run by the system");
    }

    public void clearPersistentPreferredActivity(IntentFilter filter, int userId) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 1000) goto L17;
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        boolean changed = this.mPm.mSettings.clearPersistentPreferredActivity(filter, userId);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (changed == false) goto L20;
        updateDefaultHomeNotLocked(this.mPm.snapshotComputer(), userId);
        this.mBroadcastHelper.sendPreferredActivityChangedBroadcast(userId);
        this.mPm.scheduleWritePackageRestrictions(userId);
        return;
    L20:
        return;
    L12:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L17:
        throw new SecurityException("clearPersistentPreferredActivity can only be run by the system");
    }

    private boolean isHomeFilter(WatchedIntentFilter filter) {
        if (filter.hasAction("android.intent.action.MAIN") == true) goto L5;
    L9:
        return false;
    L5:
        if (filter.hasCategory("android.intent.category.HOME") == false) goto L9;
        if (filter.hasCategory("android.intent.category.DEFAULT") == false) goto L9;
        return true;
    }

    private void restoreFromXml(TypedXmlPullParser parser, int userId, String expectedStartTag, BlobXmlRestorer functor) throws IOException, XmlPullParserException {
    L2:
        int type = parser.next();
        if (type == 2) goto L7;
        if (type != 1) goto L2;
    L7:
        if (type == 2) goto L10;
        return;
    L10:
        if (expectedStartTag.equals(parser.getName()) == true) goto L13;
        return;
    L13:
        if (parser.next() == 4) goto L13;
        functor.apply(parser, userId);
    }

    public byte[] getPreferredActivityBackup(int userId) {
        if (Binder.getCallingUid() != 1000) goto L21;
        ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
        TypedXmlSerializer serializer = Xml.newFastSerializer();     // Catch: Exception -> L12
        serializer.setOutput(dataStream, StandardCharsets.UTF_8.name());     // Catch: Exception -> L12
        serializer.startDocument(null, true);     // Catch: Exception -> L12
        serializer.startTag(null, TAG_PREFERRED_BACKUP);     // Catch: Exception -> L12
        PackageManagerTracedLock r4 = this.mPm.mLock;     // Catch: Exception -> L12
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Exception -> L12
        monitor-enter(r4);     // Catch: Exception -> L12
        this.mPm.mSettings.writePreferredActivitiesLPr(serializer, userId, true);     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Exception -> L12
        serializer.endTag(null, TAG_PREFERRED_BACKUP);     // Catch: Exception -> L12
        serializer.endDocument();     // Catch: Exception -> L12
        serializer.flush();     // Catch: Exception -> L12
        return dataStream.toByteArray();
    L14:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Exception -> L12
        throw th;     // Catch: Exception -> L12
    L19:
        return null;
    L21:
        throw new SecurityException("Only the system may call getPreferredActivityBackup()");
    }

    public void restorePreferredActivities(byte[] backup, int userId) {
        if (Binder.getCallingUid() != 1000) goto L9;
        TypedXmlPullParser parser = Xml.newFastPullParser();     // Catch: Exception -> L6
        parser.setInput(new ByteArrayInputStream(backup), StandardCharsets.UTF_8.name());     // Catch: Exception -> L6
        restoreFromXml(parser, userId, TAG_PREFERRED_BACKUP, new PreferredActivityHelper$$ExternalSyntheticLambda2(this));     // Catch: Exception -> L6
        return;
    L7:
        return;
    L9:
        throw new SecurityException("Only the system may call restorePreferredActivities()");
    }

    private /* synthetic */ void lambda$restorePreferredActivities$1(TypedXmlPullParser readParser, int readUserId) throws IOException, XmlPullParserException {
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mPm.mSettings.readPreferredActivitiesLPw(readParser, readUserId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        updateDefaultHomeNotLocked(this.mPm.snapshotComputer(), readUserId);
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public byte[] getDefaultAppsBackup(int userId) {
        if (Binder.getCallingUid() != 1000) goto L11;
        ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
        TypedXmlSerializer serializer = Xml.newFastSerializer();     // Catch: Exception -> L8
        serializer.setOutput(dataStream, StandardCharsets.UTF_8.name());     // Catch: Exception -> L8
        serializer.startDocument(null, true);     // Catch: Exception -> L8
        serializer.startTag(null, TAG_DEFAULT_APPS);     // Catch: Exception -> L8
        String defaultBrowser = this.mPm.getDefaultBrowser(userId);     // Catch: Exception -> L8
        Settings.writeDefaultApps(serializer, defaultBrowser);     // Catch: Exception -> L8
        serializer.endTag(null, TAG_DEFAULT_APPS);     // Catch: Exception -> L8
        serializer.endDocument();     // Catch: Exception -> L8
        serializer.flush();     // Catch: Exception -> L8
        return dataStream.toByteArray();
    L9:
        return null;
    L11:
        throw new SecurityException("Only the system may call getDefaultAppsBackup()");
    }

    public void restoreDefaultApps(byte[] backup, int userId) {
        if (Binder.getCallingUid() != 1000) goto L9;
        TypedXmlPullParser parser = Xml.newFastPullParser();     // Catch: Exception -> L6
        parser.setInput(new ByteArrayInputStream(backup), StandardCharsets.UTF_8.name());     // Catch: Exception -> L6
        restoreFromXml(parser, userId, TAG_DEFAULT_APPS, new PreferredActivityHelper$$ExternalSyntheticLambda1(this));     // Catch: Exception -> L6
        return;
    L7:
        return;
    L9:
        throw new SecurityException("Only the system may call restoreDefaultApps()");
    }

    private /* synthetic */ void lambda$restoreDefaultApps$2(TypedXmlPullParser parser1, int userId1) throws IOException, XmlPullParserException {
        String defaultBrowser = Settings.readDefaultApps(parser1);
        if (defaultBrowser == null) goto L18;
        PackageStateInternal packageState = this.mPm.snapshotComputer().getPackageStateInternal(defaultBrowser);
        if (packageState != null) goto L7;
    L9:
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        this.mPm.mSettings.setPendingDefaultBrowserLPw(defaultBrowser, userId1);     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L14:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L7:
        if (packageState.getUserStateOrDefault(userId1).isInstalled() == false) goto L9;
        this.mPm.setDefaultBrowser(defaultBrowser, userId1);
        return;
    }

    public void resetApplicationPreferences(int userId) {
        this.mPm.mContext.enforceCallingOrSelfPermission("android.permission.SET_PREFERRED_APPLICATIONS", null);
        long identity = Binder.clearCallingIdentity();
        SparseBooleanArray changedUsers = new SparseBooleanArray();     // Catch: Throwable -> L10
        PackageManagerTracedLock r4 = this.mPm.mLock;     // Catch: Throwable -> L10
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r4);     // Catch: Throwable -> L10
        this.mPm.clearPackagePreferredActivitiesLPw(null, changedUsers, userId);     // Catch: Throwable -> L23
        monitor-exit(r4);     // Catch: Throwable -> L23
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L10
        if (changedUsers.size() <= 0) goto L12;
        this.mBroadcastHelper.sendPreferredActivityChangedBroadcast(userId);     // Catch: Throwable -> L10
    L12:
        PackageManagerTracedLock r2 = this.mPm.mLock;     // Catch: Throwable -> L10
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L10
        monitor-enter(r2);     // Catch: Throwable -> L10
        this.mPm.mSettings.applyDefaultPreferredAppsLPw(userId);     // Catch: Throwable -> L19
        this.mPm.mDomainVerificationManager.clearUser(userId);     // Catch: Throwable -> L19
        this.mPm.mPermissionManager.resetRuntimePermissionsForUser(userId);     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L10
        updateDefaultHomeNotLocked(this.mPm.snapshotComputer(), userId);     // Catch: Throwable -> L10
        resetNetworkPolicies(userId);     // Catch: Throwable -> L10
        this.mPm.scheduleWritePackageRestrictions(userId);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L19:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L23:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void resetNetworkPolicies(int userId) {
        ((NetworkPolicyManagerInternal) this.mPm.mInjector.getLocalService(NetworkPolicyManagerInternal.class)).resetUserState(userId);
    }

    public int getPreferredActivities(Computer snapshot, List<IntentFilter> outFilters, List<ComponentName> outActivities, String packageName) {
        List<WatchedIntentFilter> temp = WatchedIntentFilter.toWatchedIntentFilterList(outFilters);
        int result = getPreferredActivitiesInternal(snapshot, temp, outActivities, packageName);
        outFilters.clear();
        int i = 0;
    L4:
        if (i >= temp.size()) goto L7;
        outFilters.add(temp.get(i).getIntentFilter());
        i = i + 1;
        goto L4
    L7:
        return result;
    }

    private int getPreferredActivitiesInternal(Computer snapshot, List<WatchedIntentFilter> outFilters, List<ComponentName> outActivities, String packageName) {
        int callingUid = Binder.getCallingUid();
        if (snapshot.getInstantAppPackageName(callingUid) == null) goto L6;
        return 0;
    L6:
        int userId = UserHandle.getCallingUserId();
        PreferredIntentResolver pir = snapshot.getPreferredActivities(userId);
        if (pir == null) goto L29;
        Iterator<F> r4 = pir.filterIterator();
    L10:
        if (r4.hasNext() == false) goto L29;
        PreferredActivity pa = (PreferredActivity) r4.next();
        if (pa == null) goto L10;
        String prefPackageName = pa.mPref.mComponent.getPackageName();
        if (packageName == null) goto L22;
        if (prefPackageName.equals(packageName) == false) goto L10;
        if (pa.mPref.mAlways == false) goto L10;
    L22:
        if (snapshot.shouldFilterApplication(snapshot.getPackageStateInternal(prefPackageName), callingUid, userId) == true) goto L10;
        if (outFilters == null) goto L26;
        outFilters.add(new WatchedIntentFilter(pa.getIntentFilter()));
    L26:
        if (outActivities == null) goto L10;
        outActivities.add(pa.mPref.mComponent);
    L29:
        return 0;
    }

    public ResolveInfo findPersistentPreferredActivity(Computer snapshot, Intent intent, int userId) {
        if (UserHandle.isSameApp(Binder.getCallingUid(), 1000) == false) goto L11;
        if (this.mPm.mUserManager.exists(userId) == true) goto L8;
        return null;
    L8:
        int callingUid = Binder.getCallingUid();
        Intent intent2 = PackageManagerServiceUtils.updateIntentForResolve(intent);
        String resolvedType = intent2.resolveTypeIfNeeded(this.mPm.mContext.getContentResolver());
        long flags = snapshot.updateFlagsForResolve(0, userId, callingUid, false, snapshot.isImplicitImageCaptureIntentAndNotSetByDpc(intent2, userId, resolvedType, 0));
        List<ResolveInfo> query = snapshot.queryIntentActivitiesInternal(intent2, resolvedType, flags, userId);
        return snapshot.findPersistentPreferredActivity(intent2, resolvedType, flags, query, false, userId);
    L11:
        throw new SecurityException("findPersistentPreferredActivity can only be run by the system");
    }

    public void setLastChosenActivity(Computer snapshot, Intent intent, String resolvedType, int flags, WatchedIntentFilter filter, int match, ComponentName activity) {
        if (snapshot.getInstantAppPackageName(Binder.getCallingUid()) == null) goto L5;
        return;
    L5:
        int userId = UserHandle.getCallingUserId();
        intent.setComponent(null);
        List<ResolveInfo> query = snapshot.queryIntentActivitiesInternal(intent, resolvedType, flags, userId);
        findPreferredActivityNotLocked(snapshot, intent, resolvedType, flags, query, false, true, false, userId);
        addPreferredActivity(snapshot, filter, match, null, activity, false, userId, "Setting last chosen", false);
    }

    public ResolveInfo getLastChosenActivity(Computer snapshot, Intent intent, String resolvedType, int flags) {
        if (snapshot.getInstantAppPackageName(Binder.getCallingUid()) == null) goto L6;
        return null;
    L6:
        int userId = UserHandle.getCallingUserId();
        List<ResolveInfo> query = snapshot.queryIntentActivitiesInternal(intent, resolvedType, flags, userId);
        return findPreferredActivityNotLocked(snapshot, intent, resolvedType, flags, query, false, false, false, userId);
    }
}
