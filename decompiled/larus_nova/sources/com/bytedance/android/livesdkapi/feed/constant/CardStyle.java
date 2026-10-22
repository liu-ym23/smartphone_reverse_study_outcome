package com.bytedance.android.livesdkapi.feed.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/constant/CardStyle;", "", "(Ljava/lang/String;I)V", "SMALL_CARD_D", "PREVIEW_CARD_H", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardStyle extends Enum<CardStyle> {
    private static final /* synthetic */ CardStyle[] $VALUES = null;
    public static final CardStyle PREVIEW_CARD_H = null;
    public static final CardStyle SMALL_CARD_D = null;

    static {
        CardStyle r100 = new CardStyle("SMALL_CARD_D", 0);
        SMALL_CARD_D = r100;
        CardStyle r101 = new CardStyle("PREVIEW_CARD_H", 1);
        PREVIEW_CARD_H = r101;
        $VALUES = new CardStyle[]{r100, r101};
    }

    public static CardStyle valueOf(String r100) {
        return (CardStyle) a.a(CardStyle.class, r100);
    }

    public static CardStyle[] values() {
        return (CardStyle[]) $VALUES.clone();
    }

    private CardStyle(String r100, int r101) {
        super(r100, r101);
    }
}
