package com.android.server.hdmi;

import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceVolumeManager;
import android.media.VolumeInfo;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public interface AudioDeviceVolumeManagerWrapper {
    void addOnDeviceVolumeBehaviorChangedListener(Executor r1, AudioDeviceVolumeManager.OnDeviceVolumeBehaviorChangedListener r2);

    int getDeviceVolumeBehavior(AudioDeviceAttributes r1);

    void removeOnDeviceVolumeBehaviorChangedListener(AudioDeviceVolumeManager.OnDeviceVolumeBehaviorChangedListener r1);

    void setDeviceAbsoluteVolumeAdjustOnlyBehavior(AudioDeviceAttributes r1, VolumeInfo r2, boolean r3, Executor r4, AudioDeviceVolumeManager.OnAudioDeviceVolumeChangedListener r5);

    void setDeviceAbsoluteVolumeBehavior(AudioDeviceAttributes r1, VolumeInfo r2, boolean r3, Executor r4, AudioDeviceVolumeManager.OnAudioDeviceVolumeChangedListener r5);

    void setDeviceVolumeBehavior(AudioDeviceAttributes r1, int r2);
}
