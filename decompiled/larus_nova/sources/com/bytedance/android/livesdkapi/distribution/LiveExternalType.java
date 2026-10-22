package com.bytedance.android.livesdkapi.distribution;

import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/LiveExternalType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "Single", "Multi", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveExternalType extends Enum<LiveExternalType> {
    private static final /* synthetic */ LiveExternalType[] $VALUES = null;
    public static final LiveExternalType Multi = null;
    public static final LiveExternalType Single = null;
    private final String type;

    static {
        LiveExternalType r100 = new LiveExternalType("Single", 0, "single");
        Single = r100;
        LiveExternalType r101 = new LiveExternalType("Multi", 1, PriorityModule.SCENE_MULTI);
        Multi = r101;
        $VALUES = new LiveExternalType[]{r100, r101};
    }

    public static LiveExternalType valueOf(String r100) {
        return (LiveExternalType) a.a(LiveExternalType.class, r100);
    }

    public static LiveExternalType[] values() {
        return (LiveExternalType[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }

    private LiveExternalType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
