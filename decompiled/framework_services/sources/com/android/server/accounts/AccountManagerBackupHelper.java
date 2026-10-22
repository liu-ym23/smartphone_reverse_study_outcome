package com.android.server.accounts;

import android.accounts.Account;
import android.accounts.AccountManagerInternal;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.util.PackageUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.content.PackageMonitor;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AccountManagerBackupHelper {
    private static final String ATTR_ACCOUNT_SHA_256 = "account-sha-256";
    private static final String ATTR_DIGEST = "digest";
    private static final String ATTR_PACKAGE = "package";
    private static final long PENDING_RESTORE_TIMEOUT_MILLIS = 3600000;
    private static final String TAG = "AccountManagerBackupHelper";
    private static final String TAG_PERMISSION = "permission";
    private static final String TAG_PERMISSIONS = "permissions";
    private final AccountManagerInternal mAccountManagerInternal;
    private final AccountManagerService mAccountManagerService;
    private final Object mLock;
    private Runnable mRestoreCancelCommand;
    private RestorePackageMonitor mRestorePackageMonitor;
    private List<PendingAppPermission> mRestorePendingAppPermissions;

    private final class CancelRestoreCommand implements Runnable {
        final /* synthetic */ AccountManagerBackupHelper this$0;

        /* synthetic */ CancelRestoreCommand(AccountManagerBackupHelper r1, AccountManagerBackupHelperIA r2) {
            this(r1);
        }

        private CancelRestoreCommand(AccountManagerBackupHelper r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = AccountManagerBackupHelper.m882$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            AccountManagerBackupHelper.m888$$Nest$fputmRestorePendingAppPermissions(this.this$0, null);     // Catch: Throwable -> L7
            if (AccountManagerBackupHelper.m884$$Nest$fgetmRestorePackageMonitor(this.this$0) == null) goto L9;
            AccountManagerBackupHelper.m884$$Nest$fgetmRestorePackageMonitor(this.this$0).unregister();     // Catch: Throwable -> L7
            AccountManagerBackupHelper.m887$$Nest$fputmRestorePackageMonitor(this.this$0, null);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private final class PendingAppPermission {
        private final String accountDigest;
        private final String certDigest;
        private final String packageName;
        final /* synthetic */ AccountManagerBackupHelper this$0;
        private final int userId;

        /* JADX INFO: renamed from: -$$Nest$fgetpackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m889$$Nest$fgetpackageName(PendingAppPermission r0) {
            return r0.packageName;
        }

        public PendingAppPermission(AccountManagerBackupHelper r1, String accountDigest, String packageName, String certDigest, int userId) {
            this.this$0 = r1;
            this.accountDigest = accountDigest;
            this.packageName = packageName;
            this.certDigest = certDigest;
            this.userId = userId;
        }

        public boolean apply(PackageManager packageManager) {
            Account account = null;
            AccountManagerService.UserAccounts accounts = AccountManagerBackupHelper.m881$$Nest$fgetmAccountManagerService(this.this$0).getUserAccounts(this.userId);
            Object r2 = accounts.dbLock;
            monitor-enter(r2);
            Object r3 = accounts.cacheLock;     // Catch: Throwable -> L38
            monitor-enter(r3);     // Catch: Throwable -> L38
            Iterator<Account[]> r4 = accounts.accountCache.values().iterator();     // Catch: Throwable -> L15
        L8:
            if (r4.hasNext() == false) goto L20;
            Account[] accountsPerType = r4.next();     // Catch: Throwable -> L15
            int r7 = accountsPerType.length;     // Catch: Throwable -> L15
            int r8 = 0;
        L10:
            if (r8 >= r7) goto L17;
            Account accountPerType = accountsPerType[r8];     // Catch: Throwable -> L15
            if (this.accountDigest.equals(PackageUtils.computeSha256Digest(accountPerType.name.getBytes())) == true) goto L13;
            r8 = r8 + 1;     // Catch: Throwable -> L15
            goto L10
        L13:
            account = accountPerType;
        L17:
            if (account == null) goto L8;
        L20:
            monitor-exit(r3);     // Catch: Throwable -> L15
            monitor-exit(r2);     // Catch: Throwable -> L38
            if (account != null) goto L47;
            return false;
        L47:
            PackageInfo packageInfo = packageManager.getPackageInfoAsUser(this.packageName, 64, this.userId);     // Catch: PackageManager.NameNotFoundException -> L36
            String[] signaturesSha256Digests = PackageUtils.computeSignaturesSha256Digests(packageInfo.signatures);
            String signaturesSha256Digest = PackageUtils.computeSignaturesSha256Digest(signaturesSha256Digests);
            if (this.certDigest.equals(signaturesSha256Digest) == false) goto L28;
        L32:
            int uid = packageInfo.applicationInfo.uid;
            if (AccountManagerBackupHelper.m880$$Nest$fgetmAccountManagerInternal(this.this$0).hasAccountAccess(account, uid) == true) goto L35;
            AccountManagerBackupHelper.m881$$Nest$fgetmAccountManagerService(this.this$0).grantAppPermission(account, "com.android.AccountManager.ACCOUNT_ACCESS_TOKEN_TYPE", uid);
        L35:
            return true;
        L28:
            if (packageInfo.signatures.length > 1) goto L30;
        L31:
            return false;
        L30:
            if (this.certDigest.equals(signaturesSha256Digests[0]) == true) goto L32;
        L37:
            return false;
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            throw th;
        }
    }

    private final class RestorePackageMonitor extends PackageMonitor {
        final /* synthetic */ AccountManagerBackupHelper this$0;

        /* synthetic */ RestorePackageMonitor(AccountManagerBackupHelper r1, AccountManagerBackupHelperIA r2) {
            this(r1);
        }

        private RestorePackageMonitor(AccountManagerBackupHelper r1) {
            this.this$0 = r1;
        }

        public void onPackageAdded(String packageName, int uid) {
            Object r0 = AccountManagerBackupHelper.m882$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (AccountManagerBackupHelper.m885$$Nest$fgetmRestorePendingAppPermissions(this.this$0) != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (UserHandle.getUserId(uid) == 0) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L14:
            int count = AccountManagerBackupHelper.m885$$Nest$fgetmRestorePendingAppPermissions(this.this$0).size();     // Catch: Throwable -> L8
            int i = count - 1;     // Catch: Throwable -> L8
        L15:
            if (i < 0) goto L24;
            PendingAppPermission pendingAppPermission = (PendingAppPermission) AccountManagerBackupHelper.m885$$Nest$fgetmRestorePendingAppPermissions(this.this$0).get(i);     // Catch: Throwable -> L8
            if (PendingAppPermission.m889$$Nest$fgetpackageName(pendingAppPermission).equals(packageName) == true) goto L20;
        L22:
            i = i - 1;     // Catch: Throwable -> L8
            goto L15
        L20:
            if (pendingAppPermission.apply(AccountManagerBackupHelper.m881$$Nest$fgetmAccountManagerService(this.this$0).mContext.getPackageManager()) == false) goto L22;
            AccountManagerBackupHelper.m885$$Nest$fgetmRestorePendingAppPermissions(this.this$0).remove(i);     // Catch: Throwable -> L8
            goto L22
        L24:
            if (AccountManagerBackupHelper.m885$$Nest$fgetmRestorePendingAppPermissions(this.this$0).isEmpty() == true) goto L26;
        L28:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L26:
            if (AccountManagerBackupHelper.m883$$Nest$fgetmRestoreCancelCommand(this.this$0) == null) goto L28;
            AccountManagerBackupHelper.m881$$Nest$fgetmAccountManagerService(this.this$0).mHandler.removeCallbacks(AccountManagerBackupHelper.m883$$Nest$fgetmRestoreCancelCommand(this.this$0));     // Catch: Throwable -> L8
            AccountManagerBackupHelper.m883$$Nest$fgetmRestoreCancelCommand(this.this$0).run();     // Catch: Throwable -> L8
            AccountManagerBackupHelper.m886$$Nest$fputmRestoreCancelCommand(this.this$0, null);     // Catch: Throwable -> L8
            goto L28
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccountManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccountManagerInternal m880$$Nest$fgetmAccountManagerInternal(AccountManagerBackupHelper r0) {
        return r0.mAccountManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccountManagerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccountManagerService m881$$Nest$fgetmAccountManagerService(AccountManagerBackupHelper r0) {
        return r0.mAccountManagerService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m882$$Nest$fgetmLock(AccountManagerBackupHelper r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRestoreCancelCommand, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m883$$Nest$fgetmRestoreCancelCommand(AccountManagerBackupHelper r0) {
        return r0.mRestoreCancelCommand;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRestorePackageMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ RestorePackageMonitor m884$$Nest$fgetmRestorePackageMonitor(AccountManagerBackupHelper r0) {
        return r0.mRestorePackageMonitor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRestorePendingAppPermissions, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m885$$Nest$fgetmRestorePendingAppPermissions(AccountManagerBackupHelper r0) {
        return r0.mRestorePendingAppPermissions;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRestoreCancelCommand, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m886$$Nest$fputmRestoreCancelCommand(AccountManagerBackupHelper r0, Runnable r1) {
        r0.mRestoreCancelCommand = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRestorePackageMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m887$$Nest$fputmRestorePackageMonitor(AccountManagerBackupHelper r0, RestorePackageMonitor r1) {
        r0.mRestorePackageMonitor = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRestorePendingAppPermissions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m888$$Nest$fputmRestorePendingAppPermissions(AccountManagerBackupHelper r0, List r1) {
        r0.mRestorePendingAppPermissions = r1;
    }

    public AccountManagerBackupHelper(AccountManagerService accountManagerService, AccountManagerInternal accountManagerInternal) {
        this.mLock = new Object();
        this.mAccountManagerService = accountManagerService;
        this.mAccountManagerInternal = accountManagerInternal;
    }

    public byte[] backupAccountAccessPermissions(int userId) {
        int r2 = userId;
        AccountManagerService.UserAccounts accounts = this.mAccountManagerService.getUserAccounts(r2);
        Object r4 = accounts.dbLock;
        monitor-enter(r4);
        Object r5 = accounts.cacheLock;     // Catch: Throwable -> L63
        monitor-enter(r5);     // Catch: Throwable -> L63
        List<Pair<String, Integer>> allAccountGrants = accounts.accountsDb.findAllAccountGrants();     // Catch: Throwable -> L40
        if (allAccountGrants.isEmpty() == false) goto L76;
        monitor-exit(r5);     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L12
        return null;
    L12:
        th = th;
    L65:
        monitor-exit(r4);     // Catch: Throwable -> L53
        throw th;
    L14:
        e = th;
    L61:
        monitor-exit(r5);     // Catch: Throwable -> L34
        throw e;     // Catch: Throwable -> L53
    L76:
        ByteArrayOutputStream dataStream = new ByteArrayOutputStream();     // Catch: Throwable -> L40 IOException -> L42
        TypedXmlSerializer serializer = Xml.newFastSerializer();     // Catch: Throwable -> L40 IOException -> L42
        serializer.setOutput(dataStream, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L40 IOException -> L42
        serializer.startDocument(null, true);     // Catch: Throwable -> L40 IOException -> L42
        serializer.startTag(null, TAG_PERMISSIONS);     // Catch: Throwable -> L40 IOException -> L42
        PackageManager packageManager = this.mAccountManagerService.mContext.getPackageManager();     // Catch: Throwable -> L40 IOException -> L42
        Iterator<Pair<String, Integer>> r11 = allAccountGrants.iterator();     // Catch: Throwable -> L40 IOException -> L42
    L18:
        if (r11.hasNext() == false) goto L49;
        Pair<String, Integer> grant = r11.next();     // Catch: Throwable -> L40 IOException -> L42
        String accountName = (String) grant.first;     // Catch: Throwable -> L40 IOException -> L42
        int uid = ((Integer) grant.second).intValue();     // Catch: Throwable -> L40 IOException -> L42
        String[] packageNames = packageManager.getPackagesForUid(uid);     // Catch: Throwable -> L40 IOException -> L42
        if (packageNames == null) goto L18;
        int r7 = packageNames.length;     // Catch: Throwable -> L40 IOException -> L42
        int r1 = 0;
    L23:
        if (r1 >= r7) goto L48;
        String packageName = packageNames[r1];     // Catch: Throwable -> L40 IOException -> L42
        int r18 = r1;
        PackageInfo packageInfo = packageManager.getPackageInfoAsUser(packageName, 64, r2);     // Catch: Throwable -> L40 IOException -> L42 PackageManager.NameNotFoundException -> L45
        String digest = PackageUtils.computeSignaturesSha256Digest(packageInfo.signatures);     // Catch: Throwable -> L40 IOException -> L42
        if (digest == null) goto L47;
        serializer.startTag(null, TAG_PERMISSION);     // Catch: Throwable -> L34 IOException -> L38
        serializer.attribute(null, ATTR_ACCOUNT_SHA_256, PackageUtils.computeSha256Digest(accountName.getBytes()));     // Catch: Throwable -> L34 IOException -> L36
        serializer.attribute(null, "package", packageName);     // Catch: Throwable -> L34 IOException -> L36
        serializer.attribute(null, ATTR_DIGEST, digest);     // Catch: Throwable -> L34 IOException -> L36
        serializer.endTag(null, TAG_PERMISSION);     // Catch: Throwable -> L34 IOException -> L36
    L36:
        e = e;
    L56:
        Log.e(TAG, "Error backing up account access grants", e);     // Catch: Throwable -> L34
        monitor-exit(r5);     // Catch: Throwable -> L34
        monitor-exit(r4);     // Catch: Throwable -> L53
        return null;
    L34:
        e = th;
    L38:
        e = e;
    L47:
        r1 = r18 + 1;     // Catch: Throwable -> L34 IOException -> L36
        r2 = userId;
        accounts = accounts;
        allAccountGrants = allAccountGrants;
        goto L23
    L46:
        Slog.i(TAG, "Skipping backup of account access grant for non-existing package: " + packageName);     // Catch: Throwable -> L34 IOException -> L36
        goto L47
    L48:
        r2 = userId;
        goto L18
    L49:
        serializer.endTag(null, TAG_PERMISSIONS);     // Catch: Throwable -> L34 IOException -> L36
        serializer.endDocument();     // Catch: Throwable -> L34 IOException -> L36
        serializer.flush();     // Catch: Throwable -> L34 IOException -> L36
        byte[] r0 = dataStream.toByteArray();     // Catch: Throwable -> L34 IOException -> L36
        monitor-exit(r5);     // Catch: Throwable -> L34
        monitor-exit(r4);     // Catch: Throwable -> L53
        return r0;
    L42:
        e = e;
    L40:
        e = th;
    L53:
        th = th;
    L63:
        th = th;
        goto L65
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.android.server.accounts.AccountManagerBackupHelper-IA, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    public void restoreAccountAccessPermissions(byte[] data, int userId) {
        ByteArrayInputStream dataStream = new ByteArrayInputStream(data);     // Catch: Throwable -> L20
        TypedXmlPullParser parser = Xml.newFastPullParser();     // Catch: Throwable -> L20
        parser.setInput(dataStream, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L20
        PackageManager packageManager = this.mAccountManagerService.mContext.getPackageManager();     // Catch: Throwable -> L20
        int permissionsOuterDepth = parser.getDepth();     // Catch: Throwable -> L20
    L6:
        ?? r11 = 0;
        if (XmlUtils.nextElementWithin(parser, permissionsOuterDepth) == false) goto L47;
        if (TAG_PERMISSIONS.equals(parser.getName()) == false) goto L6;
        int permissionOuterDepth = parser.getDepth();     // Catch: Throwable -> L20
    L13:
        if (XmlUtils.nextElementWithin(parser, permissionOuterDepth) == false) goto L6;
        if (TAG_PERMISSION.equals(parser.getName()) == false) goto L13;
        String accountDigest = parser.getAttributeValue(r11, ATTR_ACCOUNT_SHA_256);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(accountDigest) == false) goto L22;
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L20
    L22:
        String packageName = parser.getAttributeValue(r11, "package");     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(packageName) == false) goto L25;
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L20
    L25:
        String digest = parser.getAttributeValue(r11, ATTR_DIGEST);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(digest) == false) goto L28;
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L20
    L28:
        PendingAppPermission pendingAppPermission = new PendingAppPermission(this, accountDigest, packageName, digest, userId);     // Catch: Throwable -> L20
        if (pendingAppPermission.apply(packageManager) == true) goto L45;
        Object r13 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r13);     // Catch: Throwable -> L20
        if (this.mRestorePackageMonitor != null) goto L38;
        this.mRestorePackageMonitor = new RestorePackageMonitor(this, r11);     // Catch: Throwable -> L35
        this.mRestorePackageMonitor.register(this.mAccountManagerService.mContext, this.mAccountManagerService.mHandler.getLooper(), true);     // Catch: Throwable -> L35
    L38:
        if (this.mRestorePendingAppPermissions != null) goto L40;
        this.mRestorePendingAppPermissions = new ArrayList();     // Catch: Throwable -> L35
    L40:
        this.mRestorePendingAppPermissions.add(pendingAppPermission);     // Catch: Throwable -> L35
        monitor-exit(r13);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20 Throwable -> L20
    L45:
        r11 = 0;
        goto L13
    L47:
        this.mRestoreCancelCommand = new CancelRestoreCommand(this, null);     // Catch: Throwable -> L20 Throwable -> L20
        this.mAccountManagerService.mHandler.postDelayed(this.mRestoreCancelCommand, 3600000);     // Catch: Throwable -> L20 Throwable -> L20
        return;
    L20:
        e = e;
    L51:
        Log.e(TAG, "Error restoring app permissions", e);
        return;
    L49:
        e = e;
        goto L51
    }
}
