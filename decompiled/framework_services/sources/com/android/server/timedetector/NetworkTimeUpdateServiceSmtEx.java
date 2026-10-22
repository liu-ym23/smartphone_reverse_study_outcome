package com.android.server.timedetector;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkTimeUpdateServiceSmtEx {
    public static final int EVENT_DEVICE_PROVISIONED = 100;
    private static final String TAG = "NetworkTimeUpdateService";
    private Context mContext;
    private Handler mHandler;
    ProvisionedObserver mProvisionedObserver;
    private NetworkTimeUpdateService mService;

    class ProvisionedObserver extends ContentObserver {
        private Handler mHandler;
        private int mMsg;
        final /* synthetic */ NetworkTimeUpdateServiceSmtEx this$0;

        public ProvisionedObserver(NetworkTimeUpdateServiceSmtEx this$0, Handler handler, int msg) {
            this.this$0 = this$0;
            super(handler);
            this.mHandler = handler;
            this.mMsg = msg;
        }

        void observe(Context context) {
            ContentResolver resolver = context.getContentResolver();
            resolver.registerContentObserver(Settings.Global.getUriFor("device_provisioned"), false, this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            ContentResolver resolver = NetworkTimeUpdateServiceSmtEx.m8554$$Nest$fgetmContext(this.this$0).getContentResolver();
            if (Settings.Global.getInt(resolver, "device_provisioned", 0) == 0) goto L6;
            this.mHandler.obtainMessage(this.mMsg).sendToTarget();
            resolver.unregisterContentObserver(this);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8554$$Nest$fgetmContext(NetworkTimeUpdateServiceSmtEx r0) {
        return r0.mContext;
    }

    public NetworkTimeUpdateServiceSmtEx(Context context, NetworkTimeUpdateService service) {
        this.mContext = context;
        this.mService = service;
    }

    public static long getPollingInterval(Context context) {
        return context.getResources().getInteger(R.integer.config_pinnerCameraPinBytes) / 2;
    }

    public void systemRunning(Handler handler) {
        this.mHandler = handler;
        boolean deviceProvisioned = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "device_provisioned", 0) == 0) goto L5;
        deviceProvisioned = true;
    L5:
        Log.d(TAG, "systemRunning(), deviceProvisioned=" + deviceProvisioned);
        if (deviceProvisioned == true) goto L9;
        this.mProvisionedObserver = new ProvisionedObserver(this, this.mHandler, 100);
        this.mProvisionedObserver.observe(this.mContext);
        return;
    }

    public boolean isAutomaticTimeRequested() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "auto_time", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }
}
