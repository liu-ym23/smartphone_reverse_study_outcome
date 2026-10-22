package com.stepos.common.widget;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    public static final H f11629a;

    /* renamed from: b, reason: collision with root package name */
    public static final H f11630b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ H[] f11631c;

    static {
        H h4 = new H("ClipPath", 0);
        f11629a = h4;
        H h5 = new H("ClearPixel", 1);
        f11630b = h5;
        f11631c = new H[]{h4, h5};
    }

    public static H valueOf(String str) {
        return (H) Enum.valueOf(H.class, str);
    }

    public static H[] values() {
        return (H[]) f11631c.clone();
    }
}
