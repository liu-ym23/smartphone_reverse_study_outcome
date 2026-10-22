package com.android.server.storage;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.WindowManager;
import com.android.server.BasePermissionDialog;

/* JADX INFO: loaded from: classes3.dex */
class StorageFullDialog extends BasePermissionDialog {
    static final int ACTION_DISMISS_SELF = 1;
    private static final String TAG = "StorageFullDialog";
    private Context mContext;
    private final Handler mHandler;
    private DeviceStorageMonitorService mService;

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceStorageMonitorService m8433$$Nest$fgetmService(StorageFullDialog r0) {
        return r0.mService;
    }

    public StorageFullDialog(Context context, DeviceStorageMonitorService service) {
        super(context);
        this.mHandler = new AnonymousClass1(this);
        this.mContext = context;
        this.mService = service;
        Resources res = context.getResources();
        setCancelable(false);
        setButton(-1, res.getString(R.string.ok), this.mHandler.obtainMessage(1));
        setTitle(res.getString(R.string.immersive_cling_description));
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.setTitle("StorageFull");
        attrs.privateFlags |= 272;
        getWindow().setAttributes(attrs);
        setMessage(res.getString(R.string.imei));
    }
}
