package com.stepos.launcher.assistant.widgetstack.component;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.MessageQueue;
import android.os.RemoteException;
import android.util.Log;
import com.stepos.launcher.assistant.utils.Executors;
import com.stepos.launcher.client.widget.ILauncherWidgetCallback;

/* loaded from: classes.dex */
public class WidgetRecommendComponent {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_SCROLL_IDLE = "scrollIdle";
    public static final String AICY_RECOMMEND_CLASS = "com.stepos.suggestion.widget.apps.service.WidgetStackService";
    public static final String AICY_RECOMMEND_PKG = "com.stepos.suggestion";
    private static final int RETRY_MAX_COUNT = 3;
    public static final String TAG = "WidgetRecommend";
    private Context mContext;
    private ILauncherWidgetCallback mLauncherWidgetCallback;
    private ServiceConnection mServiceConnection;
    private final Object sLock = new Object();
    private int mRetryCount = 3;

    public WidgetRecommendComponent(Context context) {
        this.mContext = context;
    }

    private void bindToService() {
        if (this.mRetryCount > 0) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(AICY_RECOMMEND_PKG, AICY_RECOMMEND_CLASS));
            if (this.mContext.bindService(intent, this.mServiceConnection, 1)) {
                this.mRetryCount = 0;
            } else {
                this.mRetryCount--;
                this.mContext.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.stepos.launcher.assistant.widgetstack.component.c
                    @Override // android.os.MessageQueue.IdleHandler
                    public final boolean queueIdle() {
                        return this.f30180a.lambda$bindToService$0();
                    }
                });
            }
        }
    }

    private void initServiceConnection() {
        this.mServiceConnection = new ServiceConnection() { // from class: com.stepos.launcher.assistant.widgetstack.component.WidgetRecommendComponent.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                WidgetRecommendComponent.this.mLauncherWidgetCallback = ILauncherWidgetCallback.Stub.asInterface(iBinder);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                WidgetRecommendComponent.this.mLauncherWidgetCallback = null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$bindToService$0() {
        bindToService();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performWidgetStackAction$1(int i10, int i11, String str, String str2, int i12, String str3) {
        if (this.mLauncherWidgetCallback == null) {
            synchronized (this.sLock) {
                try {
                    if (this.mLauncherWidgetCallback == null) {
                        if (this.mServiceConnection == null) {
                            initServiceConnection();
                        }
                        this.mRetryCount = 3;
                        bindToService();
                    }
                } finally {
                }
            }
        }
        if (this.mLauncherWidgetCallback != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("sourcePkg", this.mContext.getPackageName());
                bundle.putInt("widgetId", i10);
                bundle.putInt("widgetStackId", i11);
                bundle.putString("packageName", str);
                bundle.putString("componentName", str2);
                bundle.putInt("screen", i12);
                Log.d(TAG, "performWidgetStackAction: " + str3 + " ,bundle=" + bundle);
                this.mLauncherWidgetCallback.onWidgetStackAction(str3, bundle);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    private void unbindFromService() {
        ServiceConnection serviceConnection = this.mServiceConnection;
        if (serviceConnection == null || this.mLauncherWidgetCallback == null) {
            return;
        }
        this.mContext.unbindService(serviceConnection);
        this.mServiceConnection = null;
        this.mLauncherWidgetCallback = null;
    }

    public void destroy() {
        unbindFromService();
        this.mLauncherWidgetCallback = null;
    }

    public void onWidgetStackClick(int i10, int i11, String str, String str2, int i12) {
        performWidgetStackAction("click", i10, i11, str, str2, i12);
    }

    public void onWidgetStackScrollIdle(int i10, int i11, String str, String str2, int i12) {
        performWidgetStackAction(ACTION_SCROLL_IDLE, i10, i11, str, str2, i12);
    }

    public void performWidgetStackAction(final String str, final int i10, final int i11, final String str2, final String str3, final int i12) {
        Executors.BACKGROUND_ABERRANT_EXECUTOR.execute(new Runnable() { // from class: com.stepos.launcher.assistant.widgetstack.component.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f30181a.lambda$performWidgetStackAction$1(i10, i11, str2, str3, i12, str);
            }
        });
    }
}
