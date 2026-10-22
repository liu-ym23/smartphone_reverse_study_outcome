package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.larus.im.internal.network.proto2.AvCmd;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"com/bytedance/android/live/broadcastgame/opengame/cloud/CloudResultType$OpenPlatformServerResultType", "", "Lcom/bytedance/android/live/broadcastgame/opengame/cloud/CloudResultType$OpenPlatformServerResultType;", "", "errNo", "I", "getErrNo", "()I", "", "errMsg", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "Success", "SystemError", "SidNotExist", "BadBaseToken", "BadCloudCode", "BadAnonymousCloudCode", "NotFaasFunction", "BadParams", "BadAppId", "BadCloudToken", "BadSid", "BadBaseAppId", "UnknownError", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CloudResultType$OpenPlatformServerResultType extends Enum<CloudResultType$OpenPlatformServerResultType> {
    public static final CloudResultType$OpenPlatformServerResultType BadAnonymousCloudCode = null;
    public static final CloudResultType$OpenPlatformServerResultType BadAppId = null;
    public static final CloudResultType$OpenPlatformServerResultType BadBaseAppId = null;
    public static final CloudResultType$OpenPlatformServerResultType BadBaseToken = null;
    public static final CloudResultType$OpenPlatformServerResultType BadCloudCode = null;
    public static final CloudResultType$OpenPlatformServerResultType BadCloudToken = null;
    public static final CloudResultType$OpenPlatformServerResultType BadParams = null;
    public static final CloudResultType$OpenPlatformServerResultType BadSid = null;
    public static final CloudResultType$OpenPlatformServerResultType NotFaasFunction = null;
    public static final CloudResultType$OpenPlatformServerResultType SidNotExist = null;
    public static final CloudResultType$OpenPlatformServerResultType Success = null;
    public static final CloudResultType$OpenPlatformServerResultType SystemError = null;
    public static final CloudResultType$OpenPlatformServerResultType UnknownError = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CloudResultType$OpenPlatformServerResultType[] f59806a = null;
    private final String errMsg;
    private final int errNo;

    public static CloudResultType$OpenPlatformServerResultType valueOf(String r100) {
        return (CloudResultType$OpenPlatformServerResultType) r27.a.a(CloudResultType$OpenPlatformServerResultType.class, r100);
    }

    public static CloudResultType$OpenPlatformServerResultType[] values() {
        return (CloudResultType$OpenPlatformServerResultType[]) f59806a.clone();
    }

    static {
        CloudResultType$OpenPlatformServerResultType r100 = new CloudResultType$OpenPlatformServerResultType("Success", 0, 0, "success");
        Success = r100;
        CloudResultType$OpenPlatformServerResultType r101 = new CloudResultType$OpenPlatformServerResultType("SystemError", 1, 11000, "system error");
        SystemError = r101;
        CloudResultType$OpenPlatformServerResultType r102 = new CloudResultType$OpenPlatformServerResultType("SidNotExist", 2, AvCmd.CommandEventType.TRIGGER_NOISY_VALUE, "sid not exist");
        SidNotExist = r102;
        CloudResultType$OpenPlatformServerResultType r103 = new CloudResultType$OpenPlatformServerResultType("BadBaseToken", 3, AvCmd.CommandEventType.TRIGGER_AUTH_FAILED_VALUE, "bad base token");
        BadBaseToken = r103;
        CloudResultType$OpenPlatformServerResultType r104 = new CloudResultType$OpenPlatformServerResultType("BadCloudCode", 4, AvCmd.CommandEventType.TRIGGER_ONBOARDING_START_VALUE, "bad cloud code");
        BadCloudCode = r104;
        CloudResultType$OpenPlatformServerResultType r105 = new CloudResultType$OpenPlatformServerResultType("BadAnonymousCloudCode", 5, 13004, "bad anonymous cloud code");
        BadAnonymousCloudCode = r105;
        CloudResultType$OpenPlatformServerResultType r106 = new CloudResultType$OpenPlatformServerResultType("NotFaasFunction", 6, AvCmd.CommandEventType.TRIGGER_MUSIC_PLAYED_VALUE, "not available faas function");
        NotFaasFunction = r106;
        CloudResultType$OpenPlatformServerResultType r107 = new CloudResultType$OpenPlatformServerResultType("BadParams", 7, 40014, "bad params");
        BadParams = r107;
        CloudResultType$OpenPlatformServerResultType r108 = new CloudResultType$OpenPlatformServerResultType("BadAppId", 8, 40015, "bad appId");
        BadAppId = r108;
        CloudResultType$OpenPlatformServerResultType r109 = new CloudResultType$OpenPlatformServerResultType("BadCloudToken", 9, 40022, "bad cloud token");
        BadCloudToken = r109;
        CloudResultType$OpenPlatformServerResultType r110 = new CloudResultType$OpenPlatformServerResultType("BadSid", 10, 40023, "bad sid");
        BadSid = r110;
        CloudResultType$OpenPlatformServerResultType r111 = new CloudResultType$OpenPlatformServerResultType("BadBaseAppId", 11, 40026, "bad base appId");
        BadBaseAppId = r111;
        CloudResultType$OpenPlatformServerResultType r112 = new CloudResultType$OpenPlatformServerResultType("UnknownError", 12, -1, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        UnknownError = r112;
        f59806a = new CloudResultType$OpenPlatformServerResultType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final int getErrNo() {
        return this.errNo;
    }

    public CloudResultType$OpenPlatformServerResultType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.errNo = r102;
        this.errMsg = r103;
    }
}
