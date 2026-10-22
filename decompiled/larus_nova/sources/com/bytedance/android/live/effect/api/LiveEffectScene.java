package com.bytedance.android.live.effect.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "", "", "page", "Ljava/lang/String;", "getPage", "()Ljava/lang/String;", "Preview", "Live", "GiftMenuPreview", "GiftMenuLive", "Vr", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveEffectScene extends Enum<LiveEffectScene> {
    public static final LiveEffectScene GiftMenuLive = null;
    public static final LiveEffectScene GiftMenuPreview = null;
    public static final LiveEffectScene Live = null;
    public static final LiveEffectScene Preview = null;
    public static final LiveEffectScene Vr = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveEffectScene[] f66744a = null;
    private final String page;

    static {
        LiveEffectScene r100 = new LiveEffectScene("Preview", 0, "live_take_page");
        Preview = r100;
        LiveEffectScene r101 = new LiveEffectScene("Live", 1, "live_take_detail");
        Live = r101;
        LiveEffectScene r102 = new LiveEffectScene("GiftMenuPreview", 2, "live_take_page_gift_menu");
        GiftMenuPreview = r102;
        LiveEffectScene r103 = new LiveEffectScene("GiftMenuLive", 3, "live_take_detail_gift_menu");
        GiftMenuLive = r103;
        LiveEffectScene r104 = new LiveEffectScene("Vr", 4, "live_vr");
        Vr = r104;
        f66744a = new LiveEffectScene[]{r100, r101, r102, r103, r104};
    }

    public static LiveEffectScene valueOf(String r100) {
        return (LiveEffectScene) r27.a.a(LiveEffectScene.class, r100);
    }

    public static LiveEffectScene[] values() {
        return (LiveEffectScene[]) f66744a.clone();
    }

    public final String getPage() {
        return this.page;
    }

    public LiveEffectScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.page = r102;
    }
}
