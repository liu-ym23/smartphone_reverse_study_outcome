package com.android.server.hdmi;

import android.media.AudioAttributes;
import android.media.AudioDeviceAttributes;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AudioManagerWrapper {
    void adjustStreamVolume(int r1, int r2, int r3);

    List<AudioDeviceAttributes> getDevicesForAttributes(AudioAttributes r1);

    int getStreamMaxVolume(int r1);

    int getStreamMinVolume(int r1);

    int getStreamVolume(int r1);

    boolean isStreamMute(int r1);

    int setHdmiSystemAudioSupported(boolean r1);

    void setStreamMute(int r1, boolean r2);

    void setStreamVolume(int r1, int r2, int r3);

    void setWiredDeviceConnectionState(int r1, int r2, String r3, String r4);

    void setWiredDeviceConnectionState(AudioDeviceAttributes r1, int r2);
}
