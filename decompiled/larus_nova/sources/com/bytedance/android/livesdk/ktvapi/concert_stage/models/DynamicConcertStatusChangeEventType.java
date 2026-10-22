package com.bytedance.android.livesdk.ktvapi.concert_stage.models;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/concert_stage/models/DynamicConcertStatusChangeEventType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "onCheckPermissionFinished", "onAudioDeviceLoopDelayUpdate", "onNetworkDetectionResult", "onNetworkQuality", "onFirstRemoteVideoFrameDecode", "onNtpTimeSynchronizationCompleted", "onUserPublishStreamAudio", "onRtcAdvanceLinkSuccess", "onRtcLinkSuccessPre", "onRtcLinkSuccess", "onRtcLinkFail", "onRtcInitSuccess", "onRtcInitFail", "onLiveClientInitSuccess", "onLiveClientInitFail", "onRtcLeaveSuccess", "onHeadSetChange", "onExternalSoundCard", "onScreenOrientationChange", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DynamicConcertStatusChangeEventType extends Enum<DynamicConcertStatusChangeEventType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DynamicConcertStatusChangeEventType[] f142297a = null;
    public static final DynamicConcertStatusChangeEventType onAudioDeviceLoopDelayUpdate = null;
    public static final DynamicConcertStatusChangeEventType onCheckPermissionFinished = null;
    public static final DynamicConcertStatusChangeEventType onExternalSoundCard = null;
    public static final DynamicConcertStatusChangeEventType onFirstRemoteVideoFrameDecode = null;
    public static final DynamicConcertStatusChangeEventType onHeadSetChange = null;
    public static final DynamicConcertStatusChangeEventType onLiveClientInitFail = null;
    public static final DynamicConcertStatusChangeEventType onLiveClientInitSuccess = null;
    public static final DynamicConcertStatusChangeEventType onNetworkDetectionResult = null;
    public static final DynamicConcertStatusChangeEventType onNetworkQuality = null;
    public static final DynamicConcertStatusChangeEventType onNtpTimeSynchronizationCompleted = null;
    public static final DynamicConcertStatusChangeEventType onRtcAdvanceLinkSuccess = null;
    public static final DynamicConcertStatusChangeEventType onRtcInitFail = null;
    public static final DynamicConcertStatusChangeEventType onRtcInitSuccess = null;
    public static final DynamicConcertStatusChangeEventType onRtcLeaveSuccess = null;
    public static final DynamicConcertStatusChangeEventType onRtcLinkFail = null;
    public static final DynamicConcertStatusChangeEventType onRtcLinkSuccess = null;
    public static final DynamicConcertStatusChangeEventType onRtcLinkSuccessPre = null;
    public static final DynamicConcertStatusChangeEventType onScreenOrientationChange = null;
    public static final DynamicConcertStatusChangeEventType onUserPublishStreamAudio = null;
    private final String typeName;

    public static DynamicConcertStatusChangeEventType valueOf(String r100) {
        return (DynamicConcertStatusChangeEventType) a.a(DynamicConcertStatusChangeEventType.class, r100);
    }

    public static DynamicConcertStatusChangeEventType[] values() {
        return (DynamicConcertStatusChangeEventType[]) f142297a.clone();
    }

    static {
        DynamicConcertStatusChangeEventType r100 = new DynamicConcertStatusChangeEventType("onCheckPermissionFinished", 0, "onCheckPermissionFinished");
        onCheckPermissionFinished = r100;
        DynamicConcertStatusChangeEventType r101 = new DynamicConcertStatusChangeEventType("onAudioDeviceLoopDelayUpdate", 1, "onAudioDeviceLoopDelayUpdate");
        onAudioDeviceLoopDelayUpdate = r101;
        DynamicConcertStatusChangeEventType r102 = new DynamicConcertStatusChangeEventType("onNetworkDetectionResult", 2, "onNetworkDetectionResult");
        onNetworkDetectionResult = r102;
        DynamicConcertStatusChangeEventType r103 = new DynamicConcertStatusChangeEventType("onNetworkQuality", 3, "onNetworkQuality");
        onNetworkQuality = r103;
        DynamicConcertStatusChangeEventType r104 = new DynamicConcertStatusChangeEventType("onFirstRemoteVideoFrameDecode", 4, "onFirstRemoteVideoFrameDecode");
        onFirstRemoteVideoFrameDecode = r104;
        DynamicConcertStatusChangeEventType r105 = new DynamicConcertStatusChangeEventType("onNtpTimeSynchronizationCompleted", 5, "onNtpTimeSynchronizationCompleted");
        onNtpTimeSynchronizationCompleted = r105;
        DynamicConcertStatusChangeEventType r106 = new DynamicConcertStatusChangeEventType("onUserPublishStreamAudio", 6, "onUserPublishStreamAudio");
        onUserPublishStreamAudio = r106;
        DynamicConcertStatusChangeEventType r107 = new DynamicConcertStatusChangeEventType("onRtcAdvanceLinkSuccess", 7, "onRtcAdvanceLinkSuccess");
        onRtcAdvanceLinkSuccess = r107;
        DynamicConcertStatusChangeEventType r108 = new DynamicConcertStatusChangeEventType("onRtcLinkSuccessPre", 8, "onRtcLinkSuccessPre");
        onRtcLinkSuccessPre = r108;
        DynamicConcertStatusChangeEventType r109 = new DynamicConcertStatusChangeEventType("onRtcLinkSuccess", 9, "onRtcLinkSuccess");
        onRtcLinkSuccess = r109;
        DynamicConcertStatusChangeEventType r110 = new DynamicConcertStatusChangeEventType("onRtcLinkFail", 10, "onRtcLinkFail");
        onRtcLinkFail = r110;
        DynamicConcertStatusChangeEventType r111 = new DynamicConcertStatusChangeEventType("onRtcInitSuccess", 11, "onRtcInitSuccess");
        onRtcInitSuccess = r111;
        DynamicConcertStatusChangeEventType r112 = new DynamicConcertStatusChangeEventType("onRtcInitFail", 12, "onRtcInitFail");
        onRtcInitFail = r112;
        DynamicConcertStatusChangeEventType r113 = new DynamicConcertStatusChangeEventType("onLiveClientInitSuccess", 13, "onLiveClientInitSuccess");
        onLiveClientInitSuccess = r113;
        DynamicConcertStatusChangeEventType r114 = new DynamicConcertStatusChangeEventType("onLiveClientInitFail", 14, "onLiveClientInitFail");
        onLiveClientInitFail = r114;
        DynamicConcertStatusChangeEventType r115 = new DynamicConcertStatusChangeEventType("onRtcLeaveSuccess", 15, "onRtcLeaveSuccess");
        onRtcLeaveSuccess = r115;
        DynamicConcertStatusChangeEventType r116 = new DynamicConcertStatusChangeEventType("onHeadSetChange", 16, "onHeadSetChange");
        onHeadSetChange = r116;
        DynamicConcertStatusChangeEventType r117 = new DynamicConcertStatusChangeEventType("onExternalSoundCard", 17, "onExternalSoundCard");
        onExternalSoundCard = r117;
        DynamicConcertStatusChangeEventType r118 = new DynamicConcertStatusChangeEventType("onScreenOrientationChange", 18, "onScreenOrientationChange");
        onScreenOrientationChange = r118;
        f142297a = new DynamicConcertStatusChangeEventType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118};
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public DynamicConcertStatusChangeEventType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
