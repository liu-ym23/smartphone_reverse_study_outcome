package com.bytedance.android.livesdk.gift.platform.business.anchor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/anchor/AnchorGiftPanelSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "MoreFunction", "UserGiftTabIcon", "UserGiftPanel", "Undefined", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnchorGiftPanelSource extends Enum<AnchorGiftPanelSource> {
    public static final AnchorGiftPanelSource MoreFunction = null;
    public static final AnchorGiftPanelSource Undefined = null;
    public static final AnchorGiftPanelSource UserGiftPanel = null;
    public static final AnchorGiftPanelSource UserGiftTabIcon = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnchorGiftPanelSource[] f126518a = null;
    private final String value;

    static {
        AnchorGiftPanelSource r100 = new AnchorGiftPanelSource("MoreFunction", 0, "more_function");
        MoreFunction = r100;
        AnchorGiftPanelSource r101 = new AnchorGiftPanelSource("UserGiftTabIcon", 1, "gift_icon");
        UserGiftTabIcon = r101;
        AnchorGiftPanelSource r102 = new AnchorGiftPanelSource("UserGiftPanel", 2, "user_gift_tab");
        UserGiftPanel = r102;
        AnchorGiftPanelSource r103 = new AnchorGiftPanelSource("Undefined", 3, "undefined");
        Undefined = r103;
        f126518a = new AnchorGiftPanelSource[]{r100, r101, r102, r103};
    }

    public static AnchorGiftPanelSource valueOf(String r100) {
        return (AnchorGiftPanelSource) r27.a.a(AnchorGiftPanelSource.class, r100);
    }

    public static AnchorGiftPanelSource[] values() {
        return (AnchorGiftPanelSource[]) f126518a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public AnchorGiftPanelSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
