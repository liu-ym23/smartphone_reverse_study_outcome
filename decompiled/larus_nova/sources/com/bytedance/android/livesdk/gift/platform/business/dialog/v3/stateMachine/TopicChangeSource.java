package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/TopicChangeSource;", "", "(Ljava/lang/String;I)V", "SLIDE", FlowDoraWifiScene.OTHER, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TopicChangeSource extends Enum<TopicChangeSource> {
    private static final /* synthetic */ TopicChangeSource[] $VALUES = null;
    public static final TopicChangeSource OTHER = null;
    public static final TopicChangeSource SLIDE = null;

    static {
        TopicChangeSource r100 = new TopicChangeSource("SLIDE", 0);
        SLIDE = r100;
        TopicChangeSource r101 = new TopicChangeSource(FlowDoraWifiScene.OTHER, 1);
        OTHER = r101;
        $VALUES = new TopicChangeSource[]{r100, r101};
    }

    public static TopicChangeSource valueOf(String r100) {
        return (TopicChangeSource) a.a(TopicChangeSource.class, r100);
    }

    public static TopicChangeSource[] values() {
        return (TopicChangeSource[]) $VALUES.clone();
    }

    private TopicChangeSource(String r100, int r101) {
        super(r100, r101);
    }
}
