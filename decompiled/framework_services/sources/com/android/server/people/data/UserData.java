package com.android.server.people.data;

import android.os.Environment;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Slog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class UserData {
    private static final int CONVERSATIONS_END_TOKEN = -1;
    private static final String TAG = null;
    private String mDefaultDialer;
    private String mDefaultSmsApp;
    private boolean mIsUnlocked;
    private Map<String, PackageData> mPackageDataMap;
    private final File mPerUserPeopleDataDir;
    private final ScheduledExecutorService mScheduledExecutorService;
    private final int mUserId;

    public static /* synthetic */ PackageData $r8$lambda$C8inqRDBg3fL_NeWpCQpPXVG8g4(UserData r0, String r1, String r2) {
        return r0.lambda$getOrCreatePackageData$0(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$DhoDUcyb5UQWmkgTM5aSCaEwprw(UserData r0, String r1) {
        return r0.isDefaultDialer(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Fo8Nkii5PlS-ioPWIjXKMq1wg2Y, reason: not valid java name */
    public static /* synthetic */ boolean m6562$r8$lambda$Fo8Nkii5PlSioPWIjXKMq1wg2Y(UserData r0, String r1) {
        return r0.isDefaultSmsApp(r1);
    }

    static {
        TAG = UserData.class.getSimpleName();
    }

    UserData(int userId, ScheduledExecutorService scheduledExecutorService) {
        this.mPackageDataMap = new ArrayMap();
        this.mUserId = userId;
        this.mPerUserPeopleDataDir = new File(Environment.getDataSystemCeDirectory(this.mUserId), "people");
        this.mScheduledExecutorService = scheduledExecutorService;
    }

    int getUserId() {
        return this.mUserId;
    }

    void forAllPackages(Consumer<PackageData> consumer) {
        Iterator<PackageData> r0 = this.mPackageDataMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        PackageData packageData = r0.next();
        consumer.accept(packageData);
        goto L4
    }

    void setUserUnlocked() {
        this.mIsUnlocked = true;
    }

    void setUserStopped() {
        this.mIsUnlocked = false;
    }

    boolean isUnlocked() {
        return this.mIsUnlocked;
    }

    void loadUserData() {
        this.mPerUserPeopleDataDir.mkdir();
        Map<String, PackageData> packageDataMap = PackageData.packagesDataFromDisk(this.mUserId, new UserData$$ExternalSyntheticLambda0(this), new UserData$$ExternalSyntheticLambda1(this), this.mScheduledExecutorService, this.mPerUserPeopleDataDir);
        this.mPackageDataMap.putAll(packageDataMap);
    }

    private /* synthetic */ PackageData lambda$getOrCreatePackageData$0(String packageName, String key) {
        return createPackageData(packageName);
    }

    PackageData getOrCreatePackageData(final String packageName) {
        return this.mPackageDataMap.computeIfAbsent(packageName, new UserData$$ExternalSyntheticLambda2(this, packageName));
    }

    PackageData getPackageData(String packageName) {
        return this.mPackageDataMap.get(packageName);
    }

    void deletePackageData(String packageName) {
        PackageData packageData = this.mPackageDataMap.remove(packageName);
        if (packageData == null) goto L6;
        packageData.onDestroy();
        return;
    }

    void setDefaultDialer(String packageName) {
        this.mDefaultDialer = packageName;
    }

    PackageData getDefaultDialer() {
        if (this.mDefaultDialer != null) goto L7;
        return null;
    L7:
        return getPackageData(this.mDefaultDialer);
    }

    void setDefaultSmsApp(String packageName) {
        this.mDefaultSmsApp = packageName;
    }

    PackageData getDefaultSmsApp() {
        if (this.mDefaultSmsApp != null) goto L7;
        return null;
    L7:
        return getPackageData(this.mDefaultSmsApp);
    }

    byte[] getBackupPayload() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        Iterator<PackageData> r2 = this.mPackageDataMap.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L20;
        PackageData packageData = r2.next();
        byte[] conversationsBackupPayload = packageData.getConversationStore().getBackupPayload();     // Catch: IOException -> L8
        out.writeInt(conversationsBackupPayload.length);     // Catch: IOException -> L8
        out.write(conversationsBackupPayload);     // Catch: IOException -> L8
        out.writeUTF(packageData.getPackageName());     // Catch: IOException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to write conversations to backup payload.", e);
        return null;
    L20:
        out.writeInt(-1);     // Catch: IOException -> L15
        return baos.toByteArray();
    L15:
        e = move-exception;
        Slog.e(TAG, "Failed to write conversations end token to backup payload.", e);
        return null;
    }

    void restore(byte[] payload) {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(payload));
        int conversationsPayloadSize = in.readInt();     // Catch: IOException -> L8
    L5:
        if (conversationsPayloadSize == (-1)) goto L16;
        byte[] conversationsPayload = new byte[conversationsPayloadSize];     // Catch: IOException -> L8
        in.readFully(conversationsPayload, 0, conversationsPayloadSize);     // Catch: IOException -> L8
        String packageName = in.readUTF();     // Catch: IOException -> L8
        getOrCreatePackageData(packageName).getConversationStore().restore(conversationsPayload);     // Catch: IOException -> L8
        conversationsPayloadSize = in.readInt();     // Catch: IOException -> L8
        goto L5
    L16:
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to restore conversations from backup payload.", e);
    }

    private PackageData createPackageData(String packageName) {
        return new PackageData(packageName, this.mUserId, new UserData$$ExternalSyntheticLambda0(this), new UserData$$ExternalSyntheticLambda1(this), this.mScheduledExecutorService, this.mPerUserPeopleDataDir);
    }

    private boolean isDefaultDialer(String packageName) {
        return TextUtils.equals(this.mDefaultDialer, packageName);
    }

    private boolean isDefaultSmsApp(String packageName) {
        return TextUtils.equals(this.mDefaultSmsApp, packageName);
    }
}
