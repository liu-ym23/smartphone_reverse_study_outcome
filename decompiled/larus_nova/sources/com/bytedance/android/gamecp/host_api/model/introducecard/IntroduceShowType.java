package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/IntroduceShowType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "MANUAL", "AUTO", "TIMER", "RULE", FlowDoraWifiScene.TEST, "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IntroduceShowType extends Enum<IntroduceShowType> {
    public static final IntroduceShowType AUTO = null;
    public static final IntroduceShowType MANUAL = null;
    public static final IntroduceShowType RULE = null;
    public static final IntroduceShowType TEST = null;
    public static final IntroduceShowType TIMER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntroduceShowType[] f57380a = null;
    private final String type;

    static {
        IntroduceShowType r100 = new IntroduceShowType("MANUAL", 0, "manual");
        MANUAL = r100;
        IntroduceShowType r101 = new IntroduceShowType("AUTO", 1, "auto");
        AUTO = r101;
        IntroduceShowType r102 = new IntroduceShowType("TIMER", 2, UploadTypeInf.TIMER);
        TIMER = r102;
        IntroduceShowType r103 = new IntroduceShowType("RULE", 3, com.heytap.mcssdk.constant.b.f276366p);
        RULE = r103;
        IntroduceShowType r104 = new IntroduceShowType(FlowDoraWifiScene.TEST, 4, EffectConstants.CHANNEL_TEST);
        TEST = r104;
        f57380a = new IntroduceShowType[]{r100, r101, r102, r103, r104};
    }

    public static IntroduceShowType valueOf(String r100) {
        return (IntroduceShowType) r27.a.a(IntroduceShowType.class, r100);
    }

    public static IntroduceShowType[] values() {
        return (IntroduceShowType[]) f57380a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public IntroduceShowType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
