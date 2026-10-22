package com.bytedance.android.ec.store.utils.playable;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/store/utils/playable/PlayAbleType;", "", FlowDoraWifiScene.OTHER, "VIDEO", "MAIN_IMAGE", "SELL_POINT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayAbleType extends Enum<PlayAbleType> {
    public static final PlayAbleType MAIN_IMAGE = null;
    public static final PlayAbleType OTHER = null;
    public static final PlayAbleType SELL_POINT = null;
    public static final PlayAbleType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayAbleType[] f48672a = null;

    static {
        PlayAbleType r100 = new PlayAbleType(FlowDoraWifiScene.OTHER, 0);
        OTHER = r100;
        PlayAbleType r101 = new PlayAbleType("VIDEO", 1);
        VIDEO = r101;
        PlayAbleType r102 = new PlayAbleType("MAIN_IMAGE", 2);
        MAIN_IMAGE = r102;
        PlayAbleType r103 = new PlayAbleType("SELL_POINT", 3);
        SELL_POINT = r103;
        f48672a = new PlayAbleType[]{r100, r101, r102, r103};
    }

    public static PlayAbleType valueOf(String r100) {
        return (PlayAbleType) a.a(PlayAbleType.class, r100);
    }

    public static PlayAbleType[] values() {
        return (PlayAbleType[]) f48672a.clone();
    }

    public PlayAbleType(String r100, int r101) {
        super(r100, r101);
    }
}
