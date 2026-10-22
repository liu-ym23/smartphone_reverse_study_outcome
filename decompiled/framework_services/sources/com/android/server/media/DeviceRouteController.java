package com.android.server.media;

import android.R;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.media.AudioManager;
import android.media.IAudioService;
import android.media.MediaRoute2Info;
import android.media.audiopolicy.AudioProductStrategy;
import android.os.Looper;
import android.os.ServiceManager;
import android.os.UserHandle;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
interface DeviceRouteController {

    public interface OnDeviceRouteChangedListener {
        void onDeviceRouteChanged();
    }

    List<MediaRoute2Info> getAvailableRoutes();

    MediaRoute2Info getSelectedRoute();

    void start(UserHandle r1);

    void stop();

    void transferTo(String r1);

    boolean updateVolume(int r1);

    static DeviceRouteController createInstance(Context context, Looper looper, OnDeviceRouteChangedListener onDeviceRouteChangedListener) {
        AudioManager audioManager = (AudioManager) context.getSystemService(AudioManager.class);
        AudioProductStrategy strategyForMedia = AudioRoutingUtils.getMediaAudioProductStrategy();
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService(BluetoothManager.class);
        if (bluetoothManager == null) goto L5;
        BluetoothAdapter btAdapter = bluetoothManager.getAdapter();
    L6:
        if (strategyForMedia == null) goto L10;
        if (btAdapter == null) goto L10;
        AudioManagerRouteController controller = AudioManagerRouteController.getInstance(context, audioManager, looper, strategyForMedia, btAdapter);
        controller.registerRouteChangeListener(onDeviceRouteChangedListener);
        return controller;
    L10:
        IAudioService audioService = IAudioService.Stub.asInterface(ServiceManager.getService("audio"));
        return new LegacyDeviceRouteController(context, audioManager, audioService, onDeviceRouteChangedListener);
    L5:
        btAdapter = null;
        goto L6
    }

    static int getBuiltInSpeakerSuitabilityStatus(Context context) {
        int availabilityStatus = context.getResources().getInteger(R.integer.config_networkAvoidBadWifi);
        switch(availabilityStatus) {
            case 0: goto L6;
            case 1: goto L6;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return availabilityStatus;
    }
}
