package com.android.server.hdmi;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceAttributes;
import android.media.AudioManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultAudioManagerWrapper implements AudioManagerWrapper {
    private static final String TAG = "DefaultAudioManagerWrapper";
    private final AudioManager mAudioManager;

    public DefaultAudioManagerWrapper(Context context) {
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
    }

    @Override // com.android.server.hdmi.AudioManagerWrapper
    public void adjustStreamVolume(int streamType, int direction, int flags) {
        this.mAudioManager.adjustStreamVolume(streamType, direction, flags);
    }

    @Override // com.android.server.hdmi.AudioManagerWrapper
    public void setStreamVolume(int streamType, int index, int flags) {
        this.mAudioManager.setStreamVolume(streamType, index, flags);
    }

    @Override // com.android.server.hdmi.AudioManagerWrapper
    public int getStreamVolume(int streamType) {
        return this.mAudioManager.getStreamVolume(streamType);
    }

    @Override // com.android.server.hdmi.AudioManagerWrapper
    public int getStreamMinVolume(int streamType) {
        return this.mAudioManager.getStreamMinVolume(streamType);
    }

    @Override // com.android.server.hdmi.AudioManagerWrapper
    public int getStreamMaxVolume(int streamType) {
        return this.mAudioManager.getStreamMaxVolume(streamType);
    }

    @Override // com.android.server.hdmi.AudioManagerWrapper
    public boolean isStreamMute(int streamType) {
        return this.mAudioManager.isStreamMute(streamType);
    }

    @Override // com.android.server.hdmi.AudioManagerWrapper
    public void setStreamMute(int streamType, boolean state) {
        this.mAudioManager.setStreamMute(streamType, state);
    }

    @Override // com.android.server.hdmi.AudioManagerWrapper
    public int setHdmiSystemAudioSupported(boolean on) {
        return this.mAudioManager.setHdmiSystemAudioSupported(on);
    }

    @Override // com.android.server.hdmi.AudioManagerWrapper
    public void setWiredDeviceConnectionState(AudioDeviceAttributes attributes, int state) {
        this.mAudioManager.setWiredDeviceConnectionState(attributes, state);
    }

    @Override // com.android.server.hdmi.AudioManagerWrapper
    public void setWiredDeviceConnectionState(int device, int state, String address, String name) {
        this.mAudioManager.setWiredDeviceConnectionState(device, state, address, name);
    }

    @Override // com.android.server.hdmi.AudioManagerWrapper
    public List<AudioDeviceAttributes> getDevicesForAttributes(AudioAttributes attributes) {
        return this.mAudioManager.getDevicesForAttributes(attributes);
    }
}
