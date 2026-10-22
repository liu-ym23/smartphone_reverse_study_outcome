package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/model/GiftPanelIconSource;", "", "GIFT_LIST", "BUFF_CARD", "DIY_CARD", "DIY_CACHE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftPanelIconSource extends Enum<GiftPanelIconSource> {
    public static final GiftPanelIconSource BUFF_CARD = null;
    public static final GiftPanelIconSource DIY_CACHE = null;
    public static final GiftPanelIconSource DIY_CARD = null;
    public static final GiftPanelIconSource GIFT_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftPanelIconSource[] f127490a = null;

    static {
        GiftPanelIconSource r100 = new GiftPanelIconSource("GIFT_LIST", 0);
        GIFT_LIST = r100;
        GiftPanelIconSource r101 = new GiftPanelIconSource("BUFF_CARD", 1);
        BUFF_CARD = r101;
        GiftPanelIconSource r102 = new GiftPanelIconSource("DIY_CARD", 2);
        DIY_CARD = r102;
        GiftPanelIconSource r103 = new GiftPanelIconSource("DIY_CACHE", 3);
        DIY_CACHE = r103;
        f127490a = new GiftPanelIconSource[]{r100, r101, r102, r103};
    }

    public static GiftPanelIconSource valueOf(String r100) {
        return (GiftPanelIconSource) a.a(GiftPanelIconSource.class, r100);
    }

    public static GiftPanelIconSource[] values() {
        return (GiftPanelIconSource[]) f127490a.clone();
    }

    public GiftPanelIconSource(String r100, int r101) {
        super(r100, r101);
    }
}
