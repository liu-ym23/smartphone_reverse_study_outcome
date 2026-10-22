package com.stepos.common.widget;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: com.stepos.common.widget.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0493i {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0493i f11911a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0493i f11912b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0493i f11913c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0493i f11914d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumC0493i[] f11915e;

    static {
        EnumC0493i enumC0493i = new EnumC0493i("PROGRESS", 0);
        f11911a = enumC0493i;
        EnumC0493i enumC0493i2 = new EnumC0493i("IDLE", 1);
        f11912b = enumC0493i2;
        EnumC0493i enumC0493i3 = new EnumC0493i("COMPLETE", 2);
        f11913c = enumC0493i3;
        EnumC0493i enumC0493i4 = new EnumC0493i("ERROR", 3);
        f11914d = enumC0493i4;
        f11915e = new EnumC0493i[]{enumC0493i, enumC0493i2, enumC0493i3, enumC0493i4};
    }

    public static EnumC0493i valueOf(String str) {
        return (EnumC0493i) Enum.valueOf(EnumC0493i.class, str);
    }

    public static EnumC0493i[] values() {
        return (EnumC0493i[]) f11915e.clone();
    }
}
