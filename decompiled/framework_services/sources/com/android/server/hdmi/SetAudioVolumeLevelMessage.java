package com.android.server.hdmi;

/* JADX INFO: loaded from: classes2.dex */
public class SetAudioVolumeLevelMessage extends HdmiCecMessage {
    private final int mAudioVolumeLevel;

    private SetAudioVolumeLevelMessage(int source, int destination, byte[] params, int audioVolumeLevel) {
        super(source, destination, 115, params, 0);
        this.mAudioVolumeLevel = audioVolumeLevel;
    }

    public static HdmiCecMessage build(int source, int destination, int audioVolumeLevel) {
        byte[] params = {(byte) (audioVolumeLevel & 255)};
        int addressValidationResult = validateAddress(source, destination);
        if (addressValidationResult != 0) goto L7;
        return new SetAudioVolumeLevelMessage(source, destination, params, audioVolumeLevel);
    L7:
        return new HdmiCecMessage(source, destination, 115, params, addressValidationResult);
    }

    public static HdmiCecMessage build(int source, int destination, byte[] params) {
        if (params.length == 0) goto L5;
        int audioVolumeLevel = params[0];
        int addressValidationResult = validateAddress(source, destination);
        if (addressValidationResult != 0) goto L11;
        return new SetAudioVolumeLevelMessage(source, destination, params, audioVolumeLevel);
    L11:
        return new HdmiCecMessage(source, destination, 115, params, addressValidationResult);
    L5:
        return new HdmiCecMessage(source, destination, 115, params, 4);
    }

    public static int validateAddress(int source, int destination) {
        return HdmiCecMessageValidator.validateAddress(source, destination, 32767, 32767);
    }

    public int getAudioVolumeLevel() {
        return this.mAudioVolumeLevel;
    }
}
