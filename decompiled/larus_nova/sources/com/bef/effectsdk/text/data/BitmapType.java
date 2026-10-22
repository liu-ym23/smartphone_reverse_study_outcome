package com.bef.effectsdk.text.data;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum BitmapType extends Enum<BitmapType> {
    private static final /* synthetic */ BitmapType[] $VALUES = null;
    public static final BitmapType TEXT_BITMAP_NEON_ALPHA = null;
    public static final BitmapType TEXT_BITMAP_NONE = null;
    public static final BitmapType TEXT_BITMAP_SHAKE_ALPHA = null;
    public static final BitmapType TEXT_BITMAP_SINGLE_CHAR_ALPHA = null;
    public static final BitmapType TEXT_BITMAP_TYPE_ALPHA = null;
    public static final BitmapType TEXT_BITMAP_TYPE_RGBA8888 = null;
    public int value;

    private static /* synthetic */ BitmapType[] $values() {
        return new BitmapType[]{TEXT_BITMAP_NONE, TEXT_BITMAP_TYPE_ALPHA, TEXT_BITMAP_TYPE_RGBA8888, TEXT_BITMAP_NEON_ALPHA, TEXT_BITMAP_SINGLE_CHAR_ALPHA, TEXT_BITMAP_SHAKE_ALPHA};
    }

    static {
        TEXT_BITMAP_NONE = new BitmapType("TEXT_BITMAP_NONE", 0, -1);
        TEXT_BITMAP_TYPE_ALPHA = new BitmapType("TEXT_BITMAP_TYPE_ALPHA", 1, 0);
        TEXT_BITMAP_TYPE_RGBA8888 = new BitmapType("TEXT_BITMAP_TYPE_RGBA8888", 2, 1);
        TEXT_BITMAP_NEON_ALPHA = new BitmapType("TEXT_BITMAP_NEON_ALPHA", 3, 2);
        TEXT_BITMAP_SINGLE_CHAR_ALPHA = new BitmapType("TEXT_BITMAP_SINGLE_CHAR_ALPHA", 4, 3);
        TEXT_BITMAP_SHAKE_ALPHA = new BitmapType("TEXT_BITMAP_SHAKE_ALPHA", 5, 4);
        $VALUES = $values();
    }

    public static BitmapType[] values() {
        return (BitmapType[]) $VALUES.clone();
    }

    public static BitmapType valueOf(int r100) {
        BitmapType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        BitmapType r104 = r101[r103];
        if (r104.value == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return TEXT_BITMAP_NONE;
    }

    public static BitmapType valueOf(String r100) {
        return (BitmapType) a.a(BitmapType.class, r100);
    }

    private BitmapType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
