package com.android.server.devicepolicy;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Handler;
import android.os.RemoteException;
import android.os.UserHandle;
import android.security.Credentials;
import android.security.KeyChain;
import android.util.PluralsMessageFormatter;
import com.android.server.am.AssistDataRequester;
import com.android.server.utils.Slogf;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CertificateMonitor {
    protected static final int MONITORING_CERT_NOTIFICATION_ID = 33;
    private final Handler mHandler;
    private final DevicePolicyManagerService.Injector mInjector;
    private final BroadcastReceiver mRootCaReceiver;
    private final DevicePolicyManagerService mService;

    /* JADX INFO: renamed from: $r8$lambda$52arGP7OZuhV4ouuk8M5sQd-Mtc, reason: not valid java name */
    public static /* synthetic */ void m3323$r8$lambda$52arGP7OZuhV4ouuk8M5sQdMtc(CertificateMonitor r0, int r1) {
        r0.lambda$onCertificateApprovalsChanged$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateInstalledCertificates, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3324$$Nest$mupdateInstalledCertificates(CertificateMonitor r0, UserHandle r1) {
        r0.updateInstalledCertificates(r1);
    }

    public CertificateMonitor(DevicePolicyManagerService service, DevicePolicyManagerService.Injector injector, Handler handler) {
        this.mRootCaReceiver = new AnonymousClass1(this);
        this.mService = service;
        this.mInjector = injector;
        this.mHandler = handler;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_STARTED");
        filter.addAction("android.intent.action.USER_UNLOCKED");
        filter.addAction("android.security.action.TRUST_STORE_CHANGED");
        filter.setPriority(1000);
        this.mInjector.mContext.registerReceiverAsUser(this.mRootCaReceiver, UserHandle.ALL, filter, null, this.mHandler);
    }

    public String installCaCert(UserHandle userHandle, byte[] certBuffer) {
        X509Certificate cert = parseCert(certBuffer);     // Catch: Throwable -> L23
        byte[] pemCert = Credentials.convertToPem(new Certificate[]{cert});     // Catch: Throwable -> L23
        KeyChain.KeyChainConnection keyChainConnection = this.mInjector.keyChainBindAsUser(userHandle);     // Catch: InterruptedException -> L8 RemoteException -> L10
        String r5 = keyChainConnection.getService().installCaCertificate(pemCert);     // Catch: Throwable -> L12
        keyChainConnection.close();     // Catch: InterruptedException -> L8 RemoteException -> L10
        return r5;
    L12:
        th = move-exception;
        if (keyChainConnection != null) goto L26;
    L19:
        throw th;     // Catch: InterruptedException -> L8 RemoteException -> L10
    L26:
        keyChainConnection.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: InterruptedException -> L8 RemoteException -> L10
    L10:
        e = move-exception;
        Slogf.e("DevicePolicyManager", "installCaCertsToKeyChain(): ", e);
    L22:
        return null;
    L8:
        e1 = move-exception;
        Slogf.w("DevicePolicyManager", "installCaCertsToKeyChain(): ", e1);
        Thread.currentThread().interrupt();
    L23:
        ce = move-exception;
        Slogf.e("DevicePolicyManager", "Problem converting cert", ce);
        return null;
    }

    public void uninstallCaCerts(UserHandle userHandle, String[] aliases) {
        KeyChain.KeyChainConnection keyChainConnection = this.mInjector.keyChainBindAsUser(userHandle);     // Catch: InterruptedException -> L15 RemoteException -> L17
        int i = 0;
    L30:
    L9:
        th = move-exception;
        if (keyChainConnection != null) goto L32;
    L26:
        throw th;     // Catch: InterruptedException -> L15 RemoteException -> L17
    L32:
        keyChainConnection.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: InterruptedException -> L15 RemoteException -> L17
        goto L26
    L6:
        if (i >= aliases.length) goto L12;
        keyChainConnection.getService().deleteCaCertificate(aliases[i]);     // Catch: Throwable -> L9
        i = i + 1;
        goto L30
    L12:
        if (keyChainConnection == null) goto L36;
        keyChainConnection.close();     // Catch: InterruptedException -> L15 RemoteException -> L17
        return;
    L36:
        return;
    L17:
        e = move-exception;
        Slogf.e("DevicePolicyManager", "from CaCertUninstaller: ", e);
        return;
    L15:
        ie = move-exception;
        Slogf.w("DevicePolicyManager", "CaCertUninstaller: ", ie);
        Thread.currentThread().interrupt();
    }

    private List<String> getInstalledCaCertificates(UserHandle userHandle) throws RemoteException, RuntimeException {
        KeyChain.KeyChainConnection conn = this.mInjector.keyChainBindAsUser(userHandle);     // Catch: AssertionError -> L6 InterruptedException -> L8
        List<String> r1 = conn.getService().getUserCaAliases().getList();     // Catch: Throwable -> L10
        conn.close();     // Catch: AssertionError -> L6 InterruptedException -> L8
        return r1;
    L10:
        th = move-exception;
        if (conn != null) goto L22;
    L17:
        throw th;     // Catch: AssertionError -> L6 InterruptedException -> L8
    L22:
        conn.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: AssertionError -> L6 InterruptedException -> L8
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    L8:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    }

    private /* synthetic */ void lambda$onCertificateApprovalsChanged$0(int userId) {
        updateInstalledCertificates(UserHandle.of(userId));
    }

    public void onCertificateApprovalsChanged(final int userId) {
        this.mHandler.post(new CertificateMonitor$$ExternalSyntheticLambda0(this, userId));
    }

    private void updateInstalledCertificates(UserHandle userHandle) {
        int userId = userHandle.getIdentifier();
        if (this.mInjector.getUserManager().isUserUnlocked(userId) == true) goto L14;
        return;
    L14:
        List<String> installedCerts = getInstalledCaCertificates(userHandle);     // Catch: Throwable -> L11
        this.mService.onInstalledCertificatesChanged(userHandle, installedCerts);
        int pendingCertificateCount = installedCerts.size() - this.mService.getAcceptedCaCertificates(userHandle).size();
        if (pendingCertificateCount == 0) goto L9;
        Notification noti = buildNotification(userHandle, pendingCertificateCount);
        this.mInjector.getNotificationManager().notifyAsUser("DevicePolicyManager", 33, noti, userHandle);
        return;
    L9:
        this.mInjector.getNotificationManager().cancelAsUser("DevicePolicyManager", 33, userHandle);
        return;
    L11:
        e = move-exception;
        Slogf.e("DevicePolicyManager", e, "Could not retrieve certificates from KeyChain service for user %d", new Object[]{Integer.valueOf(userId)});
    }

    private Notification buildNotification(UserHandle userHandle, int pendingCertificateCount) {
        Context userContext = this.mInjector.createContextAsUser(userHandle);     // Catch: PackageManager.NameNotFoundException -> L15
        Resources resources = this.mInjector.getResources();
        int parentUserId = userHandle.getIdentifier();
        if (this.mService.getProfileOwnerAsUser(userHandle.getIdentifier()) == null) goto L7;
        String contentText = resources.getString(R.string.wifi_no_internet_detailed, new Object[]{this.mService.getProfileOwnerName(userHandle.getIdentifier())});
        int parentUserId2 = this.mService.getProfileParentId(userHandle.getIdentifier());
        String contentText2 = contentText;
        int smallIconId = 17305205;
    L10:
        Intent dialogIntent = new Intent("com.android.settings.MONITORING_CERT_INFO");
        dialogIntent.setFlags(268468224);
        dialogIntent.putExtra("android.settings.extra.number_of_certificates", pendingCertificateCount);
        dialogIntent.putExtra("android.intent.extra.USER_ID", userHandle.getIdentifier());
        ActivityInfo targetInfo = dialogIntent.resolveActivityInfo(this.mInjector.getPackageManager(), 1048576);
        if (targetInfo == null) goto L13;
        dialogIntent.setComponent(targetInfo.getComponentName());
    L13:
        PendingIntent notifyIntent = this.mInjector.pendingIntentGetActivityAsUser(userContext, 0, dialogIntent, AudioFormat.DTS_HD, null, UserHandle.of(parentUserId2));
        Map<String, Object> arguments = new HashMap();
        arguments.put(AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT, Integer.valueOf(pendingCertificateCount));
        return new Notification.Builder(userContext, "SECURITY").setSmallIcon(smallIconId).setContentTitle(PluralsMessageFormatter.format(resources, arguments, R.string.window_magnification_prompt_content)).setContentText(contentText2).setContentIntent(notifyIntent).setShowWhen(false).setColor(R.color.system_notification_accent_color).build();
    L7:
        if (this.mService.getDeviceOwnerUserId() != userHandle.getIdentifier()) goto L9;
        String contentText3 = resources.getString(R.string.wifi_no_internet_detailed, new Object[]{this.mService.getDeviceOwnerName()});
        parentUserId2 = parentUserId;
        contentText2 = contentText3;
        smallIconId = 17305205;
        goto L10
    L9:
        String contentText4 = resources.getString(R.string.wifi_no_internet);
        parentUserId2 = parentUserId;
        contentText2 = contentText4;
        smallIconId = 17301642;
    L15:
        e = move-exception;
        Slogf.e("DevicePolicyManager", e, "Create context as %s failed", new Object[]{userHandle});
        return null;
    }

    private static X509Certificate parseCert(byte[] certBuffer) throws CertificateException {
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        return (X509Certificate) certFactory.generateCertificate(new ByteArrayInputStream(certBuffer));
    }
}
