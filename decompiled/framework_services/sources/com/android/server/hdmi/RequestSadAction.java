package com.android.server.hdmi;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.util.Slog;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: loaded from: classes2.dex */
final class RequestSadAction extends HdmiCecFeatureAction {
    private static final int MAX_SAD_PER_REQUEST = 4;
    public static final int RETRY_COUNTER_MAX = 3;
    private static final int STATE_WAITING_FOR_REPORT_SAD = 1;
    private static final String TAG = "RequestSadAction";
    private final RequestSadCallback mCallback;
    private final List<Integer> mCecCodecsToQuery;
    private int mQueriedSadCount;
    private final List<byte[]> mSupportedSads;
    private final int mTargetAddress;
    private int mTimeoutRetry;

    interface RequestSadCallback {
        void onRequestSadDone(List<byte[]> r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$BBMOFjOREzo49KdrD-UBpHXG_sg, reason: not valid java name */
    public static /* synthetic */ int m4426$r8$lambda$BBMOFjOREzo49KdrDUBpHXG_sg(Integer r0) {
        return lambda$querySad$0(r0);
    }

    RequestSadAction(HdmiCecLocalDevice source, int targetAddress, RequestSadCallback callback) {
        super(source);
        this.mCecCodecsToQuery = new ArrayList();
        this.mSupportedSads = new ArrayList();
        this.mQueriedSadCount = 0;
        this.mTimeoutRetry = 0;
        this.mTargetAddress = targetAddress;
        callback.getClass();
        this.mCallback = callback;
        HdmiCecConfig hdmiCecConfig = localDevice().mService.getHdmiCecConfig();
        if (hdmiCecConfig.getIntValue("query_sad_lpcm") != 1) goto L6;
        this.mCecCodecsToQuery.add(1);
    L6:
        if (hdmiCecConfig.getIntValue("query_sad_dd") != 1) goto L9;
        this.mCecCodecsToQuery.add(2);
    L9:
        if (hdmiCecConfig.getIntValue("query_sad_mpeg1") != 1) goto L12;
        this.mCecCodecsToQuery.add(3);
    L12:
        if (hdmiCecConfig.getIntValue("query_sad_mp3") != 1) goto L15;
        this.mCecCodecsToQuery.add(4);
    L15:
        if (hdmiCecConfig.getIntValue("query_sad_mpeg2") != 1) goto L18;
        this.mCecCodecsToQuery.add(5);
    L18:
        if (hdmiCecConfig.getIntValue("query_sad_aac") != 1) goto L21;
        this.mCecCodecsToQuery.add(6);
    L21:
        if (hdmiCecConfig.getIntValue("query_sad_dts") != 1) goto L24;
        this.mCecCodecsToQuery.add(7);
    L24:
        if (hdmiCecConfig.getIntValue("query_sad_atrac") != 1) goto L27;
        this.mCecCodecsToQuery.add(8);
    L27:
        if (hdmiCecConfig.getIntValue("query_sad_onebitaudio") != 1) goto L30;
        this.mCecCodecsToQuery.add(9);
    L30:
        if (hdmiCecConfig.getIntValue("query_sad_ddp") != 1) goto L33;
        this.mCecCodecsToQuery.add(10);
    L33:
        if (hdmiCecConfig.getIntValue("query_sad_dtshd") != 1) goto L36;
        this.mCecCodecsToQuery.add(11);
    L36:
        if (hdmiCecConfig.getIntValue("query_sad_truehd") != 1) goto L39;
        this.mCecCodecsToQuery.add(12);
    L39:
        if (hdmiCecConfig.getIntValue("query_sad_dst") != 1) goto L42;
        this.mCecCodecsToQuery.add(13);
    L42:
        if (hdmiCecConfig.getIntValue("query_sad_wmapro") != 1) goto L45;
        this.mCecCodecsToQuery.add(14);
    L45:
        if (hdmiCecConfig.getIntValue("query_sad_max") != 1) goto L48;
        this.mCecCodecsToQuery.add(15);
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        querySad();
        return true;
    }

    private void querySad() {
        if (this.mQueriedSadCount < this.mCecCodecsToQuery.size()) goto L6;
        wrapUpAndFinish();
        return;
    L6:
        int[] codecsToQuery = this.mCecCodecsToQuery.subList(this.mQueriedSadCount, Math.min(this.mCecCodecsToQuery.size(), this.mQueriedSadCount + 4)).stream().mapToInt(new RequestSadAction$$ExternalSyntheticLambda0()).toArray();
        sendCommand(HdmiCecMessageBuilder.buildRequestShortAudioDescriptor(getSourceAddress(), this.mTargetAddress, codecsToQuery));
        this.mState = 1;
        addTimer(this.mState, 2000);
    }

    private static /* synthetic */ int lambda$querySad$0(Integer i) {
        return i.intValue();
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        if (this.mState == 1) goto L5;
    L40:
        return false;
    L5:
        if (this.mTargetAddress != cmd.getSource()) goto L40;
        if (cmd.getOpcode() != 163) goto L28;
        if (cmd.getParams() != null) goto L12;
    L26:
        return true;
    L12:
        if (cmd.getParams().length == 0) goto L26;
        if ((cmd.getParams().length % 3) != 0) goto L26;
        int i = 0;
    L18:
        if (i >= (cmd.getParams().length - 2)) goto L24;
        if (isValidCodec(cmd.getParams()[i]) == false) goto L22;
        byte[] sad = {cmd.getParams()[i], cmd.getParams()[i + 1], cmd.getParams()[i + 2]};
        updateResult(sad);
    L23:
        i = i + 3;
        goto L18
    L22:
        Slog.w(TAG, "Dropped invalid codec " + cmd.getParams()[i] + ".");
        goto L23
    L24:
        this.mQueriedSadCount += 4;
        this.mTimeoutRetry = 0;
        querySad();
        return true;
    L28:
        if (cmd.getOpcode() == 0) goto L30;
    L39:
        return false;
    L30:
        if ((cmd.getParams()[0] & CecDeviceType.INACTIVE) != 164) goto L39;
        if ((cmd.getParams()[1] & CecDeviceType.INACTIVE) != 0) goto L36;
        wrapUpAndFinish();
        return true;
    L36:
        if ((cmd.getParams()[1] & CecDeviceType.INACTIVE) != 3) goto L39;
        this.mQueriedSadCount += 4;
        this.mTimeoutRetry = 0;
        querySad();
        return true;
    }

    private boolean isValidCodec(byte codec) {
        if ((codec & 128) == 0) goto L5;
        return false;
    L5:
        int audioFormatCode = (codec & TarConstants.LF_PAX_EXTENDED_HEADER_LC) >> 3;
        if (audioFormatCode > 0) goto L8;
        return false;
    L8:
        if (audioFormatCode > 15) goto L12;
        return true;
    L12:
        return false;
    }

    private void updateResult(byte[] sad) {
        this.mSupportedSads.add(sad);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        return;
    L6:
        if (state != 1) goto L13;
        int r1 = this.mTimeoutRetry + 1;
        this.mTimeoutRetry = r1;
        if (r1 > 3) goto L11;
        querySad();
        return;
    L11:
        wrapUpAndFinish();
        return;
    }

    private void wrapUpAndFinish() {
        this.mCallback.onRequestSadDone(this.mSupportedSads);
        finish();
    }
}
