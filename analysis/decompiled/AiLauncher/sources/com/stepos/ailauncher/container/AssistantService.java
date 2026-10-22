package com.stepos.ailauncher.container;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.IBinder;
import android.util.Log;
import android.view.ServiceC1402u;
import com.stepos.launcher.assistant.slidepanel.LauncherScrollOverlayBinder;

/* loaded from: classes3.dex */
public class AssistantService extends ServiceC1402u {
    private static final String TAG = "AssistantService";

    @Override // android.view.ServiceC1402u, android.app.Service
    public IBinder onBind(Intent intent) {
        super.onBind(intent);
        Log.d(TAG, "onBind");
        return C5.a.a(this, TAG, new LauncherScrollOverlayBinder(this, new MainScrollOverlayComponent(createDisplayContext(((DisplayManager) getSystemService(DisplayManager.class)).getDisplay(0)))));
    }

    @Override // android.view.ServiceC1402u, android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override // android.view.ServiceC1402u, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override // android.view.ServiceC1402u, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, i10, i11);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        MainScrollOverlayComponent.a2();
        return super.onUnbind(intent);
    }
}
