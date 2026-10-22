package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: androidx.lifecycle.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0327y {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0327y f3983a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0327y f3984b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0327y f3985c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0327y f3986d;

    /* renamed from: e, reason: collision with root package name */
    public static final EnumC0327y f3987e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumC0327y[] f3988f;

    static {
        EnumC0327y enumC0327y = new EnumC0327y("DESTROYED", 0);
        f3983a = enumC0327y;
        EnumC0327y enumC0327y2 = new EnumC0327y("INITIALIZED", 1);
        f3984b = enumC0327y2;
        EnumC0327y enumC0327y3 = new EnumC0327y("CREATED", 2);
        f3985c = enumC0327y3;
        EnumC0327y enumC0327y4 = new EnumC0327y("STARTED", 3);
        f3986d = enumC0327y4;
        EnumC0327y enumC0327y5 = new EnumC0327y("RESUMED", 4);
        f3987e = enumC0327y5;
        f3988f = new EnumC0327y[]{enumC0327y, enumC0327y2, enumC0327y3, enumC0327y4, enumC0327y5};
    }

    public static EnumC0327y valueOf(String str) {
        return (EnumC0327y) Enum.valueOf(EnumC0327y.class, str);
    }

    public static EnumC0327y[] values() {
        return (EnumC0327y[]) f3988f.clone();
    }

    public final boolean a(EnumC0327y state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return compareTo(state) >= 0;
    }
}
