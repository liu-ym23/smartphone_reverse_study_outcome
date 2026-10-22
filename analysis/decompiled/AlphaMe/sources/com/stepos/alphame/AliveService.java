package com.stepos.alphame;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.stepos.alphame.utils.AlphaMeLogger;

/* loaded from: classes.dex */
public class AliveService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        AlphaMeLogger.iLog("onBind()");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        AlphaMeLogger.iLog("onCreate()");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        AlphaMeLogger.iLog("onDestroy()");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        AlphaMeLogger.iLog("onStartCommand()");
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        AlphaMeLogger.iLog("onTaskRemoved()");
        super.onTaskRemoved(intent);
    }
}
