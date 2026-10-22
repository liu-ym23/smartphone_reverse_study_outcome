package com.android.server.audio;

import android.media.AudioDeviceAttributes;
import android.media.AudioSystem;
import android.util.Slog;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class UuidUtils {
    private static final long LSB_PREFIX_BT = 4779445104546938880L;
    private static final long LSB_PREFIX_MASK = -281474976710656L;
    private static final long LSB_SUFFIX_MASK = 281474976710655L;
    public static final UUID STANDALONE_UUID = null;
    private static final String TAG = "AudioService.UuidUtils";

    UuidUtils() {
    }

    static {
        STANDALONE_UUID = new UUID(0, 0);
    }

    public static UUID uuidFromAudioDeviceAttributes(AudioDeviceAttributes device) {
        if (AudioSystem.isBluetoothA2dpOutDevice(device.getInternalType()) == false) goto L5;
    L7:
        String address = device.getAddress().replace(":", "");
        if (address.length() == 12) goto L16;
        return null;
    L16:
        long lsb = LSB_PREFIX_BT | Long.decode("0x" + address).longValue();
        Slog.i(TAG, "uuidFromAudioDeviceAttributes lsb: " + Long.toHexString(lsb));
        return new UUID(0, lsb);
    L15:
        return null;
    L5:
        if (AudioSystem.isBluetoothLeOutDevice(device.getInternalType()) == true) goto L7;
        return null;
    }
}
