package com.android.server.usb;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.os.UserHandle;
import android.util.Slog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class UsbHandlerManager {
    private static final String LOG_TAG = null;
    private final Context mContext;

    static {
        LOG_TAG = UsbHandlerManager.class.getSimpleName();
    }

    UsbHandlerManager(Context context) {
        this.mContext = context;
    }

    void showUsbAccessoryUriActivity(UsbAccessory accessory, UserHandle user) {
        String uri = accessory.getUri();
        if (uri != null) goto L5;
        return;
    L5:
        if (uri.length() <= 0) goto L15;
        Intent dialogIntent = createDialogIntent();
        dialogIntent.setComponent(ComponentName.unflattenFromString(this.mContext.getResources().getString(R.string.data_saver_enable_button)));
        dialogIntent.putExtra("accessory", accessory);
        dialogIntent.putExtra("uri", uri);
        this.mContext.startActivityAsUser(dialogIntent, user);     // Catch: ActivityNotFoundException -> L9
        return;
    L10:
        Slog.e(LOG_TAG, "unable to start UsbAccessoryUriActivity");
        return;
    }

    void confirmUsbHandler(ResolveInfo rInfo, UsbDevice device, UsbAccessory accessory) {
        Intent resolverIntent = createDialogIntent();
        resolverIntent.setComponent(ComponentName.unflattenFromString(this.mContext.getResources().getString(R.string.data_saver_enable_title)));
        resolverIntent.putExtra("rinfo", rInfo);
        UserHandle user = UserHandle.getUserHandleForUid(rInfo.activityInfo.applicationInfo.uid);
        if (device == null) goto L5;
        resolverIntent.putExtra("device", device);
    L11:
        this.mContext.startActivityAsUser(resolverIntent, user);     // Catch: ActivityNotFoundException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(LOG_TAG, "unable to start activity " + resolverIntent, e);
        return;
    L5:
        resolverIntent.putExtra("accessory", accessory);
        goto L11
    }

    void selectUsbHandler(ArrayList<ResolveInfo> matches, UserHandle user, Intent intent) {
        Intent resolverIntent = createDialogIntent();
        resolverIntent.setComponent(ComponentName.unflattenFromString(this.mContext.getResources().getString(R.string.data_usage_mobile_limit_snoozed_title)));
        resolverIntent.putParcelableArrayListExtra("rlist", matches);
        resolverIntent.putExtra("android.intent.extra.INTENT", intent);
        this.mContext.startActivityAsUser(resolverIntent, user);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(LOG_TAG, "unable to start activity " + resolverIntent, e);
    }

    private Intent createDialogIntent() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        return intent;
    }
}
