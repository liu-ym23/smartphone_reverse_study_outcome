package com.android.server.devicepolicy;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Pair;
import com.android.server.utils.Slogf;
import java.io.FileNotFoundException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class RemoteBugreportManager {
    static final String BUGREPORT_MIMETYPE = "application/vnd.android.bugreport";
    private static final String CTL_STOP = "ctl.stop";
    private static final int NOTIFICATION_ID = 678432343;
    private static final String REMOTE_BUGREPORT_SERVICE = "bugreportd";
    private static final long REMOTE_BUGREPORT_TIMEOUT_MILLIS = 600000;
    private final Context mContext;
    private final Handler mHandler;
    private final DevicePolicyManagerService.Injector mInjector;
    private final BroadcastReceiver mRemoteBugreportConsentReceiver;
    private final BroadcastReceiver mRemoteBugreportFinishedReceiver;
    private final AtomicLong mRemoteBugreportNonce;
    private final AtomicBoolean mRemoteBugreportServiceIsActive;
    private final AtomicBoolean mRemoteBugreportSharingAccepted;
    private final Runnable mRemoteBugreportTimeoutRunnable;
    private final SecureRandom mRng;
    private final DevicePolicyManagerService mService;

    @Retention(RetentionPolicy.SOURCE)
    @interface RemoteBugreportNotificationType {
    }

    /* JADX INFO: renamed from: $r8$lambda$VE2dz49Yt1jxw-m8vvQ6RX31lM0, reason: not valid java name */
    public static /* synthetic */ void m3519$r8$lambda$VE2dz49Yt1jxwm8vvQ6RX31lM0(RemoteBugreportManager r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m3520$$Nest$fgetmContext(RemoteBugreportManager r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteBugreportConsentReceiver, reason: not valid java name */
    static /* bridge */ /* synthetic */ BroadcastReceiver m3521$$Nest$fgetmRemoteBugreportConsentReceiver(RemoteBugreportManager r0) {
        return r0.mRemoteBugreportConsentReceiver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteBugreportServiceIsActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m3522$$Nest$fgetmRemoteBugreportServiceIsActive(RemoteBugreportManager r0) {
        return r0.mRemoteBugreportServiceIsActive;
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3523$$Nest$mcancelNotification(RemoteBugreportManager r0) {
        r0.cancelNotification();
    }

    /* JADX INFO: renamed from: -$$Nest$monBugreportFinished, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3524$$Nest$monBugreportFinished(RemoteBugreportManager r0, Intent r1) {
        r0.onBugreportFinished(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monBugreportSharingAccepted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3525$$Nest$monBugreportSharingAccepted(RemoteBugreportManager r0) {
        r0.onBugreportSharingAccepted();
    }

    /* JADX INFO: renamed from: -$$Nest$monBugreportSharingDeclined, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3526$$Nest$monBugreportSharingDeclined(RemoteBugreportManager r0) {
        r0.onBugreportSharingDeclined();
    }

    private /* synthetic */ void lambda$new$0() {
        if (this.mRemoteBugreportServiceIsActive.get() == false) goto L6;
        onBugreportFailed();
        return;
    }

    public RemoteBugreportManager(DevicePolicyManagerService service, DevicePolicyManagerService.Injector injector) {
        this.mRng = new SecureRandom();
        this.mRemoteBugreportNonce = new AtomicLong();
        this.mRemoteBugreportServiceIsActive = new AtomicBoolean();
        this.mRemoteBugreportSharingAccepted = new AtomicBoolean();
        this.mRemoteBugreportTimeoutRunnable = new RemoteBugreportManager$$ExternalSyntheticLambda0(this);
        this.mRemoteBugreportFinishedReceiver = new AnonymousClass1(this);
        this.mRemoteBugreportConsentReceiver = new AnonymousClass2(this);
        this.mService = service;
        this.mInjector = injector;
        this.mContext = service.mContext;
        this.mHandler = service.mHandler;
    }

    private Notification buildNotification(int type) {
        Intent dialogIntent = new Intent("android.settings.SHOW_REMOTE_BUGREPORT_DIALOG");
        dialogIntent.addFlags(268468224);
        dialogIntent.putExtra("android.app.extra.bugreport_notification_type", type);
        ActivityInfo targetInfo = dialogIntent.resolveActivityInfo(this.mContext.getPackageManager(), 1048576);
        if (targetInfo == null) goto L5;
        dialogIntent.setComponent(targetInfo.getComponentName());
    L6:
        PendingIntent pendingDialogIntent = PendingIntent.getActivityAsUser(this.mContext, type, dialogIntent, 67108864, null, UserHandle.CURRENT);
        Notification.Builder builder = new Notification.Builder(this.mContext, "DEVICE_ADMIN_ALERTS").setSmallIcon(17305175).setOngoing(true).setLocalOnly(true).setContentIntent(pendingDialogIntent).setColor(this.mContext.getColor(R.color.system_notification_accent_color)).extend(new Notification.TvExtender());
        if (type != 2) goto L9;
        builder.setContentTitle(this.mContext.getString(R.string.weeks)).setProgress(0, 0, true);
    L15:
        return builder.build();
    L9:
        if (type != 1) goto L12;
        builder.setContentTitle(this.mContext.getString(17042214)).setProgress(0, 0, true);
        goto L15
    L12:
        if (type != 3) goto L15;
        PendingIntent pendingIntentAccept = PendingIntent.getBroadcast(this.mContext, NOTIFICATION_ID, new Intent("com.android.server.action.REMOTE_BUGREPORT_SHARING_ACCEPTED"), AudioFormat.AAC_ADIF);
        PendingIntent pendingIntentDecline = PendingIntent.getBroadcast(this.mContext, NOTIFICATION_ID, new Intent("com.android.server.action.REMOTE_BUGREPORT_SHARING_DECLINED"), AudioFormat.AAC_ADIF);
        builder.addAction(new Notification.Action.Builder(null, this.mContext.getString(R.string.duration_hours_shortest_future), pendingIntentDecline).build()).addAction(new Notification.Action.Builder(null, this.mContext.getString(R.string.wait), pendingIntentAccept).build()).setContentTitle(this.mContext.getString(R.string.webpage_unresponsive)).setContentText(this.mContext.getString(R.string.wallpaper_binding_label)).setStyle(new Notification.BigTextStyle().bigText(this.mContext.getString(R.string.wallpaper_binding_label)));
        goto L15
    L5:
        Slogf.wtf("DevicePolicyManager", "Failed to resolve intent for remote bugreport dialog");
        goto L6
    }

    public boolean requestBugreport() {
        if (this.mRemoteBugreportServiceIsActive.get() == false) goto L5;
    L21:
        Slogf.d("DevicePolicyManager", "Remote bugreport wasn't started because there's already one running");
        return false;
    L5:
        if (this.mService.getDeviceOwnerRemoteBugreportUriAndHash() != null) goto L21;
        long callingIdentity = this.mInjector.binderClearCallingIdentity();
    L23:
        long nonce = this.mRng.nextLong();     // Catch: Throwable -> L13 RemoteException -> L15
        if (nonce == 0) goto L23;
        this.mInjector.getIActivityManager().requestRemoteBugReport(nonce);     // Catch: Throwable -> L13 RemoteException -> L15
        this.mRemoteBugreportNonce.set(nonce);     // Catch: Throwable -> L13 RemoteException -> L15
        this.mRemoteBugreportServiceIsActive.set(true);     // Catch: Throwable -> L13 RemoteException -> L15
        this.mRemoteBugreportSharingAccepted.set(false);     // Catch: Throwable -> L13 RemoteException -> L15
        registerRemoteBugreportReceivers();     // Catch: Throwable -> L13 RemoteException -> L15
        notify(1);     // Catch: Throwable -> L13 RemoteException -> L15
        this.mHandler.postDelayed(this.mRemoteBugreportTimeoutRunnable, 600000);     // Catch: Throwable -> L13 RemoteException -> L15
        this.mInjector.binderRestoreCallingIdentity(callingIdentity);
        return true;
    L13:
        th = move-exception;
        this.mInjector.binderRestoreCallingIdentity(callingIdentity);
        throw th;
    L15:
        re = move-exception;
        Slogf.e("DevicePolicyManager", "Failed to make remote calls to start bugreportremote service", re);     // Catch: Throwable -> L13
        this.mInjector.binderRestoreCallingIdentity(callingIdentity);
        return false;
    }

    private void registerRemoteBugreportReceivers() {
        IntentFilter filterFinished = new IntentFilter("android.intent.action.REMOTE_BUGREPORT_DISPATCH", BUGREPORT_MIMETYPE);     // Catch: IntentFilter.MalformedMimeTypeException -> L5
        this.mContext.registerReceiver(this.mRemoteBugreportFinishedReceiver, filterFinished, 2);     // Catch: IntentFilter.MalformedMimeTypeException -> L5
    L7:
        IntentFilter filterConsent = new IntentFilter();
        filterConsent.addAction("com.android.server.action.REMOTE_BUGREPORT_SHARING_DECLINED");
        filterConsent.addAction("com.android.server.action.REMOTE_BUGREPORT_SHARING_ACCEPTED");
        this.mContext.registerReceiver(this.mRemoteBugreportConsentReceiver, filterConsent);
        return;
    L5:
        e = move-exception;
        Slogf.w("DevicePolicyManager", e, "Failed to set type %s", new Object[]{BUGREPORT_MIMETYPE});
        goto L7
    }

    private void onBugreportFinished(Intent intent) {
        long nonce = intent.getLongExtra("android.intent.extra.REMOTE_BUGREPORT_NONCE", 0);
        if (nonce != 0) goto L5;
    L16:
        Slogf.w("DevicePolicyManager", "Invalid nonce provided, ignoring " + nonce);
        return;
    L5:
        if (this.mRemoteBugreportNonce.get() != nonce) goto L16;
        this.mHandler.removeCallbacks(this.mRemoteBugreportTimeoutRunnable);
        this.mRemoteBugreportServiceIsActive.set(false);
        Uri bugreportUri = intent.getData();
        String bugreportUriString = null;
        if (bugreportUri == null) goto L10;
        bugreportUriString = bugreportUri.toString();
    L10:
        String bugreportHash = intent.getStringExtra("android.intent.extra.REMOTE_BUGREPORT_HASH");
        if (this.mRemoteBugreportSharingAccepted.get() == false) goto L13;
        shareBugreportWithDeviceOwnerIfExists(bugreportUriString, bugreportHash);
        cancelNotification();
    L14:
        this.mContext.unregisterReceiver(this.mRemoteBugreportFinishedReceiver);
        return;
    L13:
        this.mService.setDeviceOwnerRemoteBugreportUriAndHash(bugreportUriString, bugreportHash);
        notify(3);
        goto L14
    }

    private void onBugreportFailed() {
        this.mRemoteBugreportServiceIsActive.set(false);
        this.mInjector.systemPropertiesSet(CTL_STOP, REMOTE_BUGREPORT_SERVICE);
        this.mRemoteBugreportSharingAccepted.set(false);
        this.mService.setDeviceOwnerRemoteBugreportUriAndHash(null, null);
        cancelNotification();
        Bundle extras = new Bundle();
        extras.putInt("android.app.extra.BUGREPORT_FAILURE_REASON", 0);
        this.mService.sendDeviceOwnerCommand("android.app.action.BUGREPORT_FAILED", extras);
        this.mContext.unregisterReceiver(this.mRemoteBugreportConsentReceiver);
        this.mContext.unregisterReceiver(this.mRemoteBugreportFinishedReceiver);
    }

    private void onBugreportSharingAccepted() {
        this.mRemoteBugreportSharingAccepted.set(true);
        Pair<String, String> uriAndHash = this.mService.getDeviceOwnerRemoteBugreportUriAndHash();
        if (uriAndHash == null) goto L6;
        shareBugreportWithDeviceOwnerIfExists((String) uriAndHash.first, (String) uriAndHash.second);
        return;
    L6:
        if (this.mRemoteBugreportServiceIsActive.get() == false) goto L10;
        notify(2);
        return;
    }

    private void onBugreportSharingDeclined() {
        if (this.mRemoteBugreportServiceIsActive.get() == false) goto L5;
        this.mInjector.systemPropertiesSet(CTL_STOP, REMOTE_BUGREPORT_SERVICE);
        this.mRemoteBugreportServiceIsActive.set(false);
        this.mHandler.removeCallbacks(this.mRemoteBugreportTimeoutRunnable);
        this.mContext.unregisterReceiver(this.mRemoteBugreportFinishedReceiver);
    L5:
        this.mRemoteBugreportSharingAccepted.set(false);
        this.mService.setDeviceOwnerRemoteBugreportUriAndHash(null, null);
        this.mService.sendDeviceOwnerCommand("android.app.action.BUGREPORT_SHARING_DECLINED", null);
    }

    private void shareBugreportWithDeviceOwnerIfExists(String bugreportUriString, String bugreportHash) {
        if (bugreportUriString == null) goto L11;
        Uri bugreportUri = Uri.parse(bugreportUriString);     // Catch: Throwable -> L6 FileNotFoundException -> L8
        this.mService.sendBugreportToDeviceOwner(bugreportUri, bugreportHash);     // Catch: Throwable -> L6 FileNotFoundException -> L8
    L5:
        this.mRemoteBugreportSharingAccepted.set(false);
        this.mService.setDeviceOwnerRemoteBugreportUriAndHash(null, null);
        return;
    L11:
        throw new FileNotFoundException();     // Catch: Throwable -> L6 FileNotFoundException -> L8
    L6:
        th = move-exception;
        this.mRemoteBugreportSharingAccepted.set(false);
        this.mService.setDeviceOwnerRemoteBugreportUriAndHash(null, null);
        throw th;
    L13:
        Bundle extras = new Bundle();     // Catch: Throwable -> L6
        extras.putInt("android.app.extra.BUGREPORT_FAILURE_REASON", 1);     // Catch: Throwable -> L6
        this.mService.sendDeviceOwnerCommand("android.app.action.BUGREPORT_FAILED", extras);     // Catch: Throwable -> L6
        goto L5
    }

    public void checkForPendingBugreportAfterBoot() {
        if (this.mService.getDeviceOwnerRemoteBugreportUriAndHash() != null) goto L5;
        return;
    L5:
        IntentFilter filterConsent = new IntentFilter();
        filterConsent.addAction("com.android.server.action.REMOTE_BUGREPORT_SHARING_DECLINED");
        filterConsent.addAction("com.android.server.action.REMOTE_BUGREPORT_SHARING_ACCEPTED");
        this.mContext.registerReceiver(this.mRemoteBugreportConsentReceiver, filterConsent);
        notify(3);
    }

    private void notify(int type) {
        this.mInjector.getNotificationManager().notifyAsUser("DevicePolicyManager", NOTIFICATION_ID, buildNotification(type), UserHandle.ALL);
    }

    private void cancelNotification() {
        this.mInjector.getNotificationManager().cancelAsUser("DevicePolicyManager", NOTIFICATION_ID, UserHandle.ALL);
    }
}
