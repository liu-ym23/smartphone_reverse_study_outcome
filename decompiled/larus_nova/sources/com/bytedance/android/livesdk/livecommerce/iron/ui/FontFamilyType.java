package com.bytedance.android.livesdk.livecommerce.iron.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/FontFamilyType;", "", "", "type", "I", "getType", "()I", "DOUYIN_SANS", "DOUYIN_NUMBER_ABC", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FontFamilyType extends Enum<FontFamilyType> {
    public static final FontFamilyType DOUYIN_NUMBER_ABC = null;
    public static final FontFamilyType DOUYIN_SANS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FontFamilyType[] f148911a = null;
    private final int type;

    static {
        FontFamilyType r100 = new FontFamilyType("DOUYIN_SANS", 0, 1);
        DOUYIN_SANS = r100;
        FontFamilyType r101 = new FontFamilyType("DOUYIN_NUMBER_ABC", 1, 2);
        DOUYIN_NUMBER_ABC = r101;
        f148911a = new FontFamilyType[]{r100, r101};
    }

    public static FontFamilyType valueOf(String r100) {
        return (FontFamilyType) r27.a.a(FontFamilyType.class, r100);
    }

    public static FontFamilyType[] values() {
        return (FontFamilyType[]) f148911a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public FontFamilyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
