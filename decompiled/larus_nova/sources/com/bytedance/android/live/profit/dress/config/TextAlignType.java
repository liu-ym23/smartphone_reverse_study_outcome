package com.bytedance.android.live.profit.dress.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/TextAlignType;", "", "Middle", "Left", "Right", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TextAlignType extends Enum<TextAlignType> {
    public static final TextAlignType Left = null;
    public static final TextAlignType Middle = null;
    public static final TextAlignType Right = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextAlignType[] f87095a = null;

    static {
        TextAlignType r100 = new TextAlignType("Middle", 0);
        Middle = r100;
        TextAlignType r101 = new TextAlignType("Left", 1);
        Left = r101;
        TextAlignType r102 = new TextAlignType("Right", 2);
        Right = r102;
        f87095a = new TextAlignType[]{r100, r101, r102};
    }

    public static TextAlignType valueOf(String r100) {
        return (TextAlignType) r27.a.a(TextAlignType.class, r100);
    }

    public static TextAlignType[] values() {
        return (TextAlignType[]) f87095a.clone();
    }

    public TextAlignType(String r100, int r101) {
        super(r100, r101);
    }
}
