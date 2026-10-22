package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopicShowFrom;", "", "from", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "DEFAULT_SHOW", "CLICK_UNFOLD", "SLIDE_UNFOLD", "DISCOVER_TAB_GUIDE", "UNKNOWN", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftTopicShowFrom extends Enum<GiftTopicShowFrom> {
    private static final /* synthetic */ GiftTopicShowFrom[] $VALUES = null;
    public static final GiftTopicShowFrom CLICK_UNFOLD = null;
    public static final GiftTopicShowFrom DEFAULT_SHOW = null;
    public static final GiftTopicShowFrom DISCOVER_TAB_GUIDE = null;
    public static final GiftTopicShowFrom SLIDE_UNFOLD = null;
    public static final GiftTopicShowFrom UNKNOWN = null;
    private final String from;

    static {
        GiftTopicShowFrom r100 = new GiftTopicShowFrom("DEFAULT_SHOW", 0, "default_show");
        DEFAULT_SHOW = r100;
        GiftTopicShowFrom r101 = new GiftTopicShowFrom("CLICK_UNFOLD", 1, "click_unfold");
        CLICK_UNFOLD = r101;
        GiftTopicShowFrom r102 = new GiftTopicShowFrom("SLIDE_UNFOLD", 2, "slide_unfold");
        SLIDE_UNFOLD = r102;
        GiftTopicShowFrom r103 = new GiftTopicShowFrom("DISCOVER_TAB_GUIDE", 3, "discover_tab");
        DISCOVER_TAB_GUIDE = r103;
        GiftTopicShowFrom r104 = new GiftTopicShowFrom("UNKNOWN", 4, "unknown");
        UNKNOWN = r104;
        $VALUES = new GiftTopicShowFrom[]{r100, r101, r102, r103, r104};
    }

    public static GiftTopicShowFrom valueOf(String r100) {
        return (GiftTopicShowFrom) a.a(GiftTopicShowFrom.class, r100);
    }

    public static GiftTopicShowFrom[] values() {
        return (GiftTopicShowFrom[]) $VALUES.clone();
    }

    public final String getFrom() {
        return this.from;
    }

    private GiftTopicShowFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.from = r102;
    }
}
