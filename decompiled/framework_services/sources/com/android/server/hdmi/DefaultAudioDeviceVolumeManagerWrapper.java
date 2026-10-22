package com.android.server.hdmi;

import android.content.Context;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceVolumeManager;
import android.media.AudioManager;
import android.media.VolumeInfo;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultAudioDeviceVolumeManagerWrapper implements AudioDeviceVolumeManagerWrapper {
    private static final String TAG = "AudioDeviceVolumeManagerWrapper";
    private final AudioDeviceVolumeManager mAudioDeviceVolumeManager;
    private final AudioManager mAudioManager;

    public DefaultAudioDeviceVolumeManagerWrapper(Context context) {
        this.mAudioDeviceVolumeManager = new AudioDeviceVolumeManager(context);
        this.mAudioManager = (AudioManager) context.getSystemService(AudioManager.class);
    }

    @Override // com.android.server.hdmi.AudioDeviceVolumeManagerWrapper
    public void addOnDeviceVolumeBehaviorChangedListener(Executor executor, AudioDeviceVolumeManager.OnDeviceVolumeBehaviorChangedListener listener) throws SecurityException {
        this.mAudioDeviceVolumeManager.addOnDeviceVolumeBehaviorChangedListener(executor, listener);
    }

    @Override // com.android.server.hdmi.AudioDeviceVolumeManagerWrapper
    public void removeOnDeviceVolumeBehaviorChangedListener(AudioDeviceVolumeManager.OnDeviceVolumeBehaviorChangedListener listener) {
        this.mAudioDeviceVolumeManager.removeOnDeviceVolumeBehaviorChangedListener(listener);
    }

    @Override // com.android.server.hdmi.AudioDeviceVolumeManagerWrapper
    public void setDeviceAbsoluteVolumeBehavior(AudioDeviceAttributes device, VolumeInfo volume, boolean handlesVolumeAdjustment, Executor executor, AudioDeviceVolumeManager.OnAudioDeviceVolumeChangedListener vclistener) {
        this.mAudioDeviceVolumeManager.setDeviceAbsoluteVolumeBehavior(device, volume, handlesVolumeAdjustment, executor, vclistener);
    }

    @Override // com.android.server.hdmi.AudioDeviceVolumeManagerWrapper
    public void setDeviceAbsoluteVolumeAdjustOnlyBehavior(AudioDeviceAttributes device, VolumeInfo volume, boolean handlesVolumeAdjustment, Executor executor, AudioDeviceVolumeManager.OnAudioDeviceVolumeChangedListener vclistener) {
        this.mAudioDeviceVolumeManager.setDeviceAbsoluteVolumeAdjustOnlyBehavior(device, volume, handlesVolumeAdjustment, executor, vclistener);
    }

    @Override // com.android.server.hdmi.AudioDeviceVolumeManagerWrapper
    public int getDeviceVolumeBehavior(AudioDeviceAttributes device) {
        int deviceBehavior = this.mAudioManager.getDeviceVolumeBehavior(device);
        return deviceBehavior;
    }

    @Override // com.android.server.hdmi.AudioDeviceVolumeManagerWrapper
    public void setDeviceVolumeBehavior(AudioDeviceAttributes device, int deviceVolumeBehavior) {
        this.mAudioManager.setDeviceVolumeBehavior(device, deviceVolumeBehavior);
        this.mAudioDeviceVolumeManager.setDeviceVolumeBehavior(device, deviceVolumeBehavior);
    }
}
