package com.bytedance.android.ec.store.repository.vo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/TextFontType;", "", "", "type", "I", "getType", "()I", "DEFAULT", "DOUYIN_TEXT", "DOUYIN_NUMBER", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TextFontType extends Enum<TextFontType> {
    public static final TextFontType DEFAULT = null;
    public static final TextFontType DOUYIN_NUMBER = null;
    public static final TextFontType DOUYIN_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextFontType[] f48451a = null;
    private final int type;

    static {
        TextFontType r100 = new TextFontType("DEFAULT", 0, 0);
        DEFAULT = r100;
        TextFontType r101 = new TextFontType("DOUYIN_TEXT", 1, 1);
        DOUYIN_TEXT = r101;
        TextFontType r102 = new TextFontType("DOUYIN_NUMBER", 2, 2);
        DOUYIN_NUMBER = r102;
        f48451a = new TextFontType[]{r100, r101, r102};
    }

    public static TextFontType valueOf(String r100) {
        return (TextFontType) r27.a.a(TextFontType.class, r100);
    }

    public static TextFontType[] values() {
        return (TextFontType[]) f48451a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public TextFontType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
