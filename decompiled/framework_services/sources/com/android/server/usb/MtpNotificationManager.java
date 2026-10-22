package com.android.server.usb;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.os.UserHandle;
import com.android.server.ExtconUEventObserver;

/* JADX INFO: loaded from: classes3.dex */
class MtpNotificationManager {
    private static final String ACTION_OPEN_IN_APPS = "com.android.server.usb.ACTION_OPEN_IN_APPS";
    private static final int PROTOCOL_MTP = 0;
    private static final int PROTOCOL_PTP = 1;
    private static final int SUBCLASS_MTP = 255;
    private static final int SUBCLASS_STILL_IMAGE_CAPTURE = 1;
    private static final String TAG = "UsbMtpNotificationManager";
    private final Context mContext;
    private final OnOpenInAppListener mListener;
    private final Receiver mReceiver;

    interface OnOpenInAppListener {
        void onOpenInApp(UsbDevice r1);
    }

    private class Receiver extends BroadcastReceiver {
        final /* synthetic */ MtpNotificationManager this$0;

        /* synthetic */ Receiver(MtpNotificationManager r1, MtpNotificationManagerIA r2) {
            this(r1);
        }

        private Receiver(MtpNotificationManager r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            UsbDevice device = (UsbDevice) intent.getExtras().getParcelable("device", UsbDevice.class);
            if (device != null) goto L5;
            return;
        L5:
            String r1 = intent.getAction();
            switch(r1.hashCode()) {
                case 768361239: goto L9;
                default: goto L11;
            };
        L11:
            byte r2 = -1;
        L12:
            switch(r2) {
                case 0: goto L14;
                default: goto L16;
            };
        L14:
            MtpNotificationManager.m9147$$Nest$fgetmListener(this.this$0).onOpenInApp(device);
            return;
        L16:
            return;
        L9:
            if (r1.equals(MtpNotificationManager.ACTION_OPEN_IN_APPS) == false) goto L11;
            r2 = 0;
            goto L12
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ OnOpenInAppListener m9147$$Nest$fgetmListener(MtpNotificationManager r0) {
        return r0.mListener;
    }

    MtpNotificationManager(Context context, OnOpenInAppListener listener) {
        this.mContext = context;
        this.mListener = listener;
        this.mReceiver = new Receiver(this, null);
        context.registerReceiver(this.mReceiver, new IntentFilter(ACTION_OPEN_IN_APPS));
    }

    void showNotification(UsbDevice device) {
        Resources resources = this.mContext.getResources();
        String title = resources.getString(17042301, new Object[]{device.getProductName()});
        String description = resources.getString(17042300);
        Notification.Builder builder = new Notification.Builder(this.mContext, ExtconUEventObserver.ExtconInfo.EXTCON_USB).setContentTitle(title).setContentText(description).setSmallIcon(17305206).setCategory("sys");
        Intent intent = new Intent(ACTION_OPEN_IN_APPS);
        intent.putExtra("device", device);
        intent.addFlags(1342177280);
        PendingIntent openIntent = PendingIntent.getBroadcastAsUser(this.mContext, device.getDeviceId(), intent, AudioFormat.DTS_HD, UserHandle.SYSTEM);
        builder.setContentIntent(openIntent);
        Notification notification = builder.build();
        notification.flags |= 256;
        ((NotificationManager) this.mContext.getSystemService(NotificationManager.class)).notify(Integer.toString(device.getDeviceId()), 25, notification);
    }

    void hideNotification(int deviceId) {
        ((NotificationManager) this.mContext.getSystemService(NotificationManager.class)).cancel(Integer.toString(deviceId), 25);
    }

    static boolean shouldShowNotification(PackageManager packageManager, UsbDevice device) {
        if (packageManager.hasSystemFeature("android.hardware.type.automotive") == false) goto L5;
    L7:
        return false;
    L5:
        if (isMtpDevice(device) == false) goto L7;
        return true;
    }

    private static boolean isMtpDevice(UsbDevice device) {
        int i = 0;
    L4:
        if (i >= device.getInterfaceCount()) goto L22;
        UsbInterface usbInterface = device.getInterface(i);
        if (usbInterface.getInterfaceClass() != 6) goto L13;
        if (usbInterface.getInterfaceSubclass() != 1) goto L13;
        if (usbInterface.getInterfaceProtocol() != 1) goto L13;
        return true;
    L13:
        if (usbInterface.getInterfaceClass() != 255) goto L21;
        if (usbInterface.getInterfaceSubclass() != 255) goto L21;
        if (usbInterface.getInterfaceProtocol() != 0) goto L21;
        if ("MTP".equals(usbInterface.getName()) == false) goto L21;
        return true;
    L21:
        i = i + 1;
        goto L4
    L22:
        return false;
    }

    public void unregister() {
        this.mContext.unregisterReceiver(this.mReceiver);
    }
}
