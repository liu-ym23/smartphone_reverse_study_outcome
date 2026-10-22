package com.bytedance.android.live.effect.sticker.ui.aigc;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/aigc/AigcTaskPanelStatusBundleKey;", "", "", "keyName", "Ljava/lang/String;", "getKeyName", "()Ljava/lang/String;", "Keyword", "ShowAnimation", "CanApplyBackgroundImage", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AigcTaskPanelStatusBundleKey extends Enum<AigcTaskPanelStatusBundleKey> {
    public static final AigcTaskPanelStatusBundleKey CanApplyBackgroundImage = null;
    public static final AigcTaskPanelStatusBundleKey Keyword = null;
    public static final AigcTaskPanelStatusBundleKey ShowAnimation = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AigcTaskPanelStatusBundleKey[] f68527a = null;
    private final String keyName;

    static {
        AigcTaskPanelStatusBundleKey r100 = new AigcTaskPanelStatusBundleKey("Keyword", 0, "keyword");
        Keyword = r100;
        AigcTaskPanelStatusBundleKey r101 = new AigcTaskPanelStatusBundleKey("ShowAnimation", 1, "show_animation");
        ShowAnimation = r101;
        AigcTaskPanelStatusBundleKey r102 = new AigcTaskPanelStatusBundleKey("CanApplyBackgroundImage", 2, "can_apply_background_image");
        CanApplyBackgroundImage = r102;
        f68527a = new AigcTaskPanelStatusBundleKey[]{r100, r101, r102};
    }

    public static AigcTaskPanelStatusBundleKey valueOf(String r100) {
        return (AigcTaskPanelStatusBundleKey) r27.a.a(AigcTaskPanelStatusBundleKey.class, r100);
    }

    public static AigcTaskPanelStatusBundleKey[] values() {
        return (AigcTaskPanelStatusBundleKey[]) f68527a.clone();
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public AigcTaskPanelStatusBundleKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.keyName = r102;
    }
}
