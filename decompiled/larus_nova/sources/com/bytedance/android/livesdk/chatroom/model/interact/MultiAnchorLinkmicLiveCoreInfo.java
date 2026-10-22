package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class MultiAnchorLinkmicLiveCoreInfo extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.p1> implements com.bytedance.android.livesdk.link.model.bridge.p1 {

    @SerializedName("live_core_info_map")
    public Map<Long, String> liveCoreExtInfoMap;

    @SerializedName("push_stream_mode_live_core_map")
    public Map<Long, String> pushStreamModeLiveCoreMap;

    public static final enum AnchorPushStreamMode extends Enum<AnchorPushStreamMode> {
        public static final AnchorPushStreamMode AnchorPushStreamMode1V1 = null;
        public static final AnchorPushStreamMode AnchorPushStreamMode1V2ForLargest = null;
        public static final AnchorPushStreamMode AnchorPushStreamMode1V3ForLargest = null;
        public static final AnchorPushStreamMode AnchorPushStreamMode1V3ForSecond = null;
        public static final AnchorPushStreamMode AnchorPushStreamMode2V2Equal = null;
        public static final AnchorPushStreamMode AnchorPushStreamModeBigSmallForBig = null;
        public static final AnchorPushStreamMode AnchorPushStreamModeBigSmallForSmall = null;
        public static final AnchorPushStreamMode AnchorPushStreamModeUnknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnchorPushStreamMode[] f106934a = null;

        static {
            AnchorPushStreamMode r100 = new AnchorPushStreamMode("AnchorPushStreamModeUnknown", 0);
            AnchorPushStreamModeUnknown = r100;
            AnchorPushStreamMode r101 = new AnchorPushStreamMode("AnchorPushStreamMode1V2ForLargest", 1);
            AnchorPushStreamMode1V2ForLargest = r101;
            AnchorPushStreamMode r102 = new AnchorPushStreamMode("AnchorPushStreamMode2V2Equal", 2);
            AnchorPushStreamMode2V2Equal = r102;
            AnchorPushStreamMode r103 = new AnchorPushStreamMode("AnchorPushStreamMode1V3ForLargest", 3);
            AnchorPushStreamMode1V3ForLargest = r103;
            AnchorPushStreamMode r104 = new AnchorPushStreamMode("AnchorPushStreamMode1V3ForSecond", 4);
            AnchorPushStreamMode1V3ForSecond = r104;
            AnchorPushStreamMode r105 = new AnchorPushStreamMode("AnchorPushStreamMode1V1", 5);
            AnchorPushStreamMode1V1 = r105;
            AnchorPushStreamMode r110 = new AnchorPushStreamMode("AnchorPushStreamModeBigSmallForBig", 6);
            AnchorPushStreamModeBigSmallForBig = r110;
            AnchorPushStreamMode r111 = new AnchorPushStreamMode("AnchorPushStreamModeBigSmallForSmall", 7);
            AnchorPushStreamModeBigSmallForSmall = r111;
            f106934a = new AnchorPushStreamMode[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static AnchorPushStreamMode[] values() {
            return (AnchorPushStreamMode[]) f106934a.clone();
        }

        public static AnchorPushStreamMode valueOf(String r100) {
            return (AnchorPushStreamMode) r27.a.a(AnchorPushStreamMode.class, r100);
        }

        public AnchorPushStreamMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public MultiAnchorLinkmicLiveCoreInfo() {
        super(com.bytedance.android.livesdk.link.model.bridge.p1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.p1
    public Map<Long, String> getLiveCoreExtInfoMap() {
        return this.liveCoreExtInfoMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.p1
    public Map<Long, String> getPushStreamModeLiveCoreMap() {
        return this.pushStreamModeLiveCoreMap;
    }
}
