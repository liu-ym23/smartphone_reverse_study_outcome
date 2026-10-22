package com.android.server.media;

import android.R;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRoutesInfo;
import android.media.IAudioRoutesObserver;
import android.media.IAudioService;
import android.media.MediaRoute2Info;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Slog;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class LegacyDeviceRouteController implements DeviceRouteController {
    private static final String DEVICE_ROUTE_ID = "DEVICE_ROUTE";
    private static final String TAG = "LDeviceRouteController";
    private final AudioManager mAudioManager;
    private final AudioRoutesObserver mAudioRoutesObserver;
    private final IAudioService mAudioService;
    private final int mBuiltInSpeakerSuitabilityStatus;
    private final Context mContext;
    private MediaRoute2Info mDeviceRoute;
    private int mDeviceVolume;
    private final DeviceRouteController.OnDeviceRouteChangedListener mOnDeviceRouteChangedListener;

    private class AudioRoutesObserver extends IAudioRoutesObserver.Stub {
        final /* synthetic */ LegacyDeviceRouteController this$0;

        /* synthetic */ AudioRoutesObserver(LegacyDeviceRouteController r1, LegacyDeviceRouteControllerIA r2) {
            this(r1);
        }

        private AudioRoutesObserver(LegacyDeviceRouteController r1) {
            this.this$0 = r1;
        }

        public void dispatchAudioRoutesChanged(AudioRoutesInfo newAudioRoutes) {
            MediaRoute2Info deviceRoute = LegacyDeviceRouteController.m5544$$Nest$mcreateRouteFromAudioInfo(this.this$0, newAudioRoutes);
            LegacyDeviceRouteController r1 = this.this$0;
            monitor-enter(r1);
            LegacyDeviceRouteController.m5543$$Nest$fputmDeviceRoute(this.this$0, deviceRoute);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            LegacyDeviceRouteController.m5545$$Nest$mnotifyDeviceRouteUpdate(this.this$0);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDeviceRoute, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5543$$Nest$fputmDeviceRoute(LegacyDeviceRouteController r0, MediaRoute2Info r1) {
        r0.mDeviceRoute = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateRouteFromAudioInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaRoute2Info m5544$$Nest$mcreateRouteFromAudioInfo(LegacyDeviceRouteController r0, AudioRoutesInfo r1) {
        return r0.createRouteFromAudioInfo(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyDeviceRouteUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5545$$Nest$mnotifyDeviceRouteUpdate(LegacyDeviceRouteController r0) {
        r0.notifyDeviceRouteUpdate();
    }

    LegacyDeviceRouteController(Context context, AudioManager audioManager, IAudioService audioService, DeviceRouteController.OnDeviceRouteChangedListener onDeviceRouteChangedListener) {
        this.mAudioRoutesObserver = new AudioRoutesObserver(this, null);
        context.getClass();
        audioManager.getClass();
        audioService.getClass();
        onDeviceRouteChangedListener.getClass();
        this.mContext = context;
        this.mOnDeviceRouteChangedListener = onDeviceRouteChangedListener;
        this.mAudioManager = audioManager;
        this.mAudioService = audioService;
        this.mBuiltInSpeakerSuitabilityStatus = DeviceRouteController.getBuiltInSpeakerSuitabilityStatus(this.mContext);
        AudioRoutesInfo newAudioRoutes = null;
        newAudioRoutes = this.mAudioService.startWatchingRoutes(this.mAudioRoutesObserver);     // Catch: RemoteException -> L5
    L7:
        this.mDeviceRoute = createRouteFromAudioInfo(newAudioRoutes);
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "Cannot connect to audio service to start listen to routes", e);
        goto L7
    }

    @Override // com.android.server.media.DeviceRouteController
    public void start(UserHandle mUser) {
    }

    @Override // com.android.server.media.DeviceRouteController
    public void stop() {
    }

    @Override // com.android.server.media.DeviceRouteController
    public synchronized MediaRoute2Info getSelectedRoute() {
        monitor-enter(this);
        MediaRoute2Info r0 = this.mDeviceRoute;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.DeviceRouteController
    public synchronized List<MediaRoute2Info> getAvailableRoutes() {
        monitor-enter(this);
        List<MediaRoute2Info> r0 = List.of(this.mDeviceRoute);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.DeviceRouteController
    public synchronized void transferTo(String routeId) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.android.server.media.DeviceRouteController
    public synchronized boolean updateVolume(int volume) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mDeviceVolume != volume) goto L8;
        monitor-exit(this);
        return false;
    L8:
        this.mDeviceVolume = volume;     // Catch: Throwable -> L12
        this.mDeviceRoute = new MediaRoute2Info.Builder(this.mDeviceRoute).setVolume(volume).build();     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    }

    private MediaRoute2Info createRouteFromAudioInfo(AudioRoutesInfo newRoutes) {
        int name = R.string.duration_minutes_shortest_past;
        int type = 2;
        int r2 = 1;
        if (newRoutes != null) goto L5;
    L19:
        monitor-enter(this);
        MediaRoute2Info.Builder r4 = new MediaRoute2Info.Builder(DEVICE_ROUTE_ID, this.mContext.getResources().getText(name).toString());     // Catch: Throwable -> L27
        if (this.mAudioManager.isVolumeFixed() == false) goto L24;
        r2 = 0;
    L24:
        MediaRoute2Info.Builder builder = r4.setVolumeHandling(r2).setVolume(this.mDeviceVolume).setVolumeMax(this.mAudioManager.getStreamMaxVolume(3)).setType(type).addFeature("android.media.route.feature.LIVE_AUDIO").addFeature("android.media.route.feature.LIVE_VIDEO").addFeature("android.media.route.feature.LOCAL_PLAYBACK").setConnectionState(2);     // Catch: Throwable -> L27
        if (type != 2) goto L29;
        builder.setSuitabilityStatus(this.mBuiltInSpeakerSuitabilityStatus);     // Catch: Throwable -> L27
    L29:
        MediaRoute2Info r3 = builder.build();     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        return r3;
    L27:
        th = move-exception;
        throw th;
    L5:
        if ((newRoutes.mainType & 2) == 0) goto L8;
        type = 4;
        name = R.string.duration_years_medium_past;
        goto L19
    L8:
        if ((newRoutes.mainType & 1) == 0) goto L11;
        type = 3;
        name = R.string.duration_years_medium_past;
        goto L19
    L11:
        if ((newRoutes.mainType & 4) == 0) goto L14;
        type = 13;
        name = R.string.duration_years_medium;
        goto L19
    L14:
        if ((newRoutes.mainType & 8) == 0) goto L17;
        type = 9;
        name = R.string.duration_years_medium_future;
        goto L19
    L17:
        if ((newRoutes.mainType & 16) == 0) goto L19;
        type = 11;
        name = R.string.duration_years_relative;
        goto L19
    }

    private void notifyDeviceRouteUpdate() {
        this.mOnDeviceRouteChangedListener.onDeviceRouteChanged();
    }
}
