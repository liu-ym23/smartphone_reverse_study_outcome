package com.google.android.material.slider;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
final class BaseSlider$FullCornerDirection {

    /* renamed from: a, reason: collision with root package name */
    public static final BaseSlider$FullCornerDirection f2518a;
    public static final BaseSlider$FullCornerDirection b;
    public static final BaseSlider$FullCornerDirection c;
    public static final /* synthetic */ BaseSlider$FullCornerDirection[] d;

    /* JADX INFO: Fake field, exist only in values array */
    BaseSlider$FullCornerDirection EF0;

    static {
        BaseSlider$FullCornerDirection baseSlider$FullCornerDirection = new BaseSlider$FullCornerDirection("BOTH", 0);
        BaseSlider$FullCornerDirection baseSlider$FullCornerDirection2 = new BaseSlider$FullCornerDirection("LEFT", 1);
        f2518a = baseSlider$FullCornerDirection2;
        BaseSlider$FullCornerDirection baseSlider$FullCornerDirection3 = new BaseSlider$FullCornerDirection("RIGHT", 2);
        b = baseSlider$FullCornerDirection3;
        BaseSlider$FullCornerDirection baseSlider$FullCornerDirection4 = new BaseSlider$FullCornerDirection("NONE", 3);
        c = baseSlider$FullCornerDirection4;
        d = new BaseSlider$FullCornerDirection[]{baseSlider$FullCornerDirection, baseSlider$FullCornerDirection2, baseSlider$FullCornerDirection3, baseSlider$FullCornerDirection4};
    }

    public static BaseSlider$FullCornerDirection valueOf(String str) {
        return (BaseSlider$FullCornerDirection) Enum.valueOf(BaseSlider$FullCornerDirection.class, str);
    }

    public static BaseSlider$FullCornerDirection[] values() {
        return (BaseSlider$FullCornerDirection[]) d.clone();
    }
}
