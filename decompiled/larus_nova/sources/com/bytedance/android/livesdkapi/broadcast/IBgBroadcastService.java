package com.bytedance.android.livesdkapi.broadcast;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Binder;
import android.view.SurfaceView;
import com.bytedance.android.livesdkapi.broadcastgame.Interceptor;
import com.bytedance.android.livesdkapi.broadcastgame.NotificationConfig;

/* JADX INFO: loaded from: classes12.dex */
public abstract class IBgBroadcastService extends Binder {

    public interface LiveStatusListener {
        void onLiveFinished(int r100);
    }

    public abstract void bindService(Service r100);

    public abstract void closeLive();

    public abstract NotificationConfig getNotificationConfig();

    public abstract Intent getNotificationIntent();

    public abstract boolean isLiveFinished();

    public abstract void onConfigurationChanged(Configuration r100);

    public abstract void onCreate();

    public abstract void onDestroy();

    public void setData(Intent r100, boolean r101) {
    }

    public void setData(Intent r100, boolean r101, Runnable r102) {
    }

    public void setInterceptor(Interceptor r100) {
    }

    public abstract void setLiveStatusListener(LiveStatusListener r100);

    public void setSurfaceView(SurfaceView r100, Bitmap r101) {
    }

    public abstract void startAudio();

    public abstract void startBgActivity();

    public abstract boolean startStream(boolean r100);

    public abstract void stopAudio();

    public abstract void stopService(String r100);

    public abstract void stopStream(int r100);

    public abstract void unBindService(Service r100);

    public IBgBroadcastService() {
    }
}
