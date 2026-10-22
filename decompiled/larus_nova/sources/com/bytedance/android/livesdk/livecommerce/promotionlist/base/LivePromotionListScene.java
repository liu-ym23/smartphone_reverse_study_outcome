package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/LivePromotionListScene;", "", "", "scene", "I", "getScene", "()I", EffectConstants.NORMAL, "INSTANT_RETAIL_FUSION", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePromotionListScene extends Enum<LivePromotionListScene> {
    public static final LivePromotionListScene INSTANT_RETAIL_FUSION = null;
    public static final LivePromotionListScene NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LivePromotionListScene[] f150885a = null;
    private final int scene;

    static {
        LivePromotionListScene r100 = new LivePromotionListScene(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        LivePromotionListScene r101 = new LivePromotionListScene("INSTANT_RETAIL_FUSION", 1, 1);
        INSTANT_RETAIL_FUSION = r101;
        f150885a = new LivePromotionListScene[]{r100, r101};
    }

    public static LivePromotionListScene valueOf(String r100) {
        return (LivePromotionListScene) r27.a.a(LivePromotionListScene.class, r100);
    }

    public static LivePromotionListScene[] values() {
        return (LivePromotionListScene[]) f150885a.clone();
    }

    public final int getScene() {
        return this.scene;
    }

    public LivePromotionListScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
