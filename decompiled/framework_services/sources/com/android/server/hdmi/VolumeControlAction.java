package com.android.server.hdmi;

/* JADX INFO: loaded from: classes2.dex */
final class VolumeControlAction extends HdmiCecFeatureAction {
    private static final int MAX_VOLUME = 100;
    private static final int STATE_WAIT_FOR_NEXT_VOLUME_PRESS = 1;
    private static final String TAG = "VolumeControlAction";
    private static final int UNKNOWN_AVR_VOLUME = -1;
    private final int mAvrAddress;
    private boolean mIsVolumeUp;
    private boolean mLastAvrMute;
    private int mLastAvrVolume;
    private long mLastKeyUpdateTime;
    private boolean mSentKeyPressed;

    public static int scaleToCecVolume(int volume, int scale) {
        return (volume * 100) / scale;
    }

    public static int scaleToCustomVolume(int cecVolume, int scale) {
        return (cecVolume * scale) / 100;
    }

    VolumeControlAction(HdmiCecLocalDevice source, int avrAddress, boolean isVolumeUp) {
        super(source);
        this.mAvrAddress = avrAddress;
        this.mIsVolumeUp = isVolumeUp;
        this.mLastAvrVolume = -1;
        this.mLastAvrMute = false;
        this.mSentKeyPressed = false;
        updateLastKeyUpdateTime();
    }

    private void updateLastKeyUpdateTime() {
        this.mLastKeyUpdateTime = System.currentTimeMillis();
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        this.mState = 1;
        sendVolumeKeyPressed();
        resetTimer();
        return true;
    }

    private void sendVolumeKeyPressed() {
        int r0 = getSourceAddress();
        int r1 = this.mAvrAddress;
        if (this.mIsVolumeUp == false) goto L5;
        int r2 = 65;
    L6:
        sendCommand(HdmiCecMessageBuilder.buildUserControlPressed(r0, r1, r2));
        this.mSentKeyPressed = true;
        return;
    L5:
        r2 = 66;
        goto L6
    }

    private void resetTimer() {
        this.mActionTimer.clearTimerMessage();
        addTimer(1, 300);
    }

    void handleVolumeChange(boolean isVolumeUp) {
        if (this.mIsVolumeUp == isVolumeUp) goto L5;
        HdmiLogger.debug("Volume Key Status Changed[old:%b new:%b]", new Object[]{Boolean.valueOf(this.mIsVolumeUp), Boolean.valueOf(isVolumeUp)});
        sendVolumeKeyReleased();
        this.mIsVolumeUp = isVolumeUp;
        sendVolumeKeyPressed();
        resetTimer();
    L5:
        updateLastKeyUpdateTime();
    }

    private void sendVolumeKeyReleased() {
        sendCommand(HdmiCecMessageBuilder.buildUserControlReleased(getSourceAddress(), this.mAvrAddress));
        this.mSentKeyPressed = false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L5;
    L14:
        return false;
    L5:
        if (cmd.getSource() != this.mAvrAddress) goto L14;
        switch(cmd.getOpcode()) {
            case 0: goto L13;
            case 122: goto L11;
            default: goto L9;
        };
    L9:
        return false;
    L11:
        return handleReportAudioStatus(cmd);
    L13:
        return handleFeatureAbort(cmd);
    }

    private boolean handleReportAudioStatus(HdmiCecMessage cmd) {
        boolean mute = HdmiUtils.isAudioStatusMute(cmd);
        int volume = HdmiUtils.getAudioStatusVolume(cmd);
        this.mLastAvrVolume = volume;
        this.mLastAvrMute = mute;
        if (shouldUpdateAudioVolume(mute) == false) goto L7;
        HdmiLogger.debug("Force volume change[mute:%b, volume=%d]", new Object[]{Boolean.valueOf(mute), Integer.valueOf(volume)});
        tv().setAudioStatus(mute, volume);
        this.mLastAvrVolume = -1;
        this.mLastAvrMute = false;
        return true;
    L7:
        return true;
    }

    private boolean shouldUpdateAudioVolume(boolean mute) {
        if (mute == false) goto L5;
        return true;
    L5:
        AudioManagerWrapper audioManager = tv().getService().getAudioManager();
        int currentVolume = audioManager.getStreamVolume(3);
        if (this.mIsVolumeUp == false) goto L12;
        int maxVolume = audioManager.getStreamMaxVolume(3);
        if (currentVolume != maxVolume) goto L11;
        return true;
    L11:
        return false;
    L12:
        if (currentVolume != 0) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean handleFeatureAbort(HdmiCecMessage cmd) {
        int originalOpcode = cmd.getParams()[0] & 255;
        if (originalOpcode != 68) goto L6;
        finish();
        return true;
    L6:
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    protected void clear() {
        super.clear();
        if (this.mSentKeyPressed == false) goto L6;
        sendVolumeKeyReleased();
    L6:
        if (this.mLastAvrVolume == (-1)) goto L9;
        tv().setAudioStatus(this.mLastAvrMute, this.mLastAvrVolume);
        this.mLastAvrVolume = -1;
        this.mLastAvrMute = false;
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (state == 1) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - this.mLastKeyUpdateTime) < 300) goto L8;
        finish();
        return;
    L8:
        sendVolumeKeyPressed();
        resetTimer();
    }
}
