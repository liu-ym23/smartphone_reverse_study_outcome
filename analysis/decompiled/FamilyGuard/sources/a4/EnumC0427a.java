package a4;

import b4.C0567b;
import b4.InterfaceC0566a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: a4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0427a {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0427a f7277a = new EnumC0427a("COROUTINE_SUSPENDED", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0427a f7278b = new EnumC0427a("UNDECIDED", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0427a f7279c = new EnumC0427a("RESUMED", 2);

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ EnumC0427a[] f7280d;

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ InterfaceC0566a f7281e;

    static {
        EnumC0427a[] enumC0427aArrB = b();
        f7280d = enumC0427aArrB;
        f7281e = C0567b.a(enumC0427aArrB);
    }

    private EnumC0427a(String str, int i5) {
    }

    private static final /* synthetic */ EnumC0427a[] b() {
        return new EnumC0427a[]{f7277a, f7278b, f7279c};
    }

    public static EnumC0427a valueOf(String str) {
        return (EnumC0427a) Enum.valueOf(EnumC0427a.class, str);
    }

    public static EnumC0427a[] values() {
        return (EnumC0427a[]) f7280d.clone();
    }
}
