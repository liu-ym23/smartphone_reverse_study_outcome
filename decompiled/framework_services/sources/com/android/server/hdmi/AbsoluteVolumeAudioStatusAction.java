package com.android.server.hdmi;

/* JADX INFO: loaded from: classes2.dex */
final class AbsoluteVolumeAudioStatusAction extends HdmiCecFeatureAction {
    private static final int STATE_MONITOR_AUDIO_STATUS = 2;
    private static final int STATE_WAIT_FOR_INITIAL_AUDIO_STATUS = 1;
    private static final String TAG = "AbsoluteVolumeAudioStatusAction";
    private int mInitialAudioStatusRetriesLeft;
    private AudioStatus mLastAudioStatus;
    private final int mTargetAddress;

    AbsoluteVolumeAudioStatusAction(HdmiCecLocalDevice source, int targetAddress) {
        super(source);
        this.mInitialAudioStatusRetriesLeft = 2;
        this.mTargetAddress = targetAddress;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        this.mState = 1;
        sendGiveAudioStatus();
        return true;
    }

    void updateVolume(int volumeIndex) {
        this.mLastAudioStatus = new AudioStatus(volumeIndex, this.mLastAudioStatus.getMute());
    }

    private void sendGiveAudioStatus() {
        addTimer(this.mState, 2000);
        sendCommand(HdmiCecMessageBuilder.buildGiveAudioStatus(getSourceAddress(), this.mTargetAddress));
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        switch(cmd.getOpcode()) {
            case 122: goto L7;
            default: goto L4;
        };
    L4:
        return false;
    L7:
        return handleReportAudioStatus(cmd);
    }

    void requestAndUpdateAudioStatus() {
        if (this.mState != 2) goto L6;
        sendGiveAudioStatus();
        return;
    }

    private boolean handleReportAudioStatus(HdmiCecMessage cmd) {
        boolean updateVolume = false;
        if (this.mTargetAddress == cmd.getSource()) goto L5;
    L28:
        return false;
    L5:
        if (cmd.getParams().length == 0) goto L28;
        boolean mute = HdmiUtils.isAudioStatusMute(cmd);
        int volume = HdmiUtils.getAudioStatusVolume(cmd);
        if (volume != (-1)) goto L10;
        return true;
    L10:
        AudioStatus audioStatus = new AudioStatus(volume, mute);
        if (this.mState != 1) goto L14;
        localDevice().getService().enableAbsoluteVolumeBehavior(audioStatus);
        this.mState = 2;
    L26:
        this.mLastAudioStatus = audioStatus;
        return true;
    L14:
        if (this.mState != 2) goto L26;
        if (audioStatus.getVolume() == this.mLastAudioStatus.getVolume()) goto L18;
        updateVolume = true;
    L18:
        if (updateVolume == false) goto L21;
        localDevice().getService().notifyAvbVolumeChange(audioStatus.getVolume());
    L21:
        if (audioStatus.getMute() != this.mLastAudioStatus.getMute()) goto L25;
        if (updateVolume == true) goto L25;
        if (localDevice().getService().isTvDevice() == false) goto L26;
    L25:
        localDevice().getService().notifyAvbMuteChange(audioStatus.getMute());
        goto L26
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        return;
    L6:
        if (this.mInitialAudioStatusRetriesLeft <= 0) goto L9;
        this.mInitialAudioStatusRetriesLeft--;
        sendGiveAudioStatus();
        return;
    }
}
