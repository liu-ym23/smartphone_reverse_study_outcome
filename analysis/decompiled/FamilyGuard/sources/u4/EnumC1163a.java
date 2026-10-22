package u4;

import b4.C0567b;
import b4.InterfaceC0566a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: u4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC1163a {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC1163a f22914a = new EnumC1163a("SUSPEND", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC1163a f22915b = new EnumC1163a("DROP_OLDEST", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC1163a f22916c = new EnumC1163a("DROP_LATEST", 2);

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ EnumC1163a[] f22917d;

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ InterfaceC0566a f22918e;

    static {
        EnumC1163a[] enumC1163aArrB = b();
        f22917d = enumC1163aArrB;
        f22918e = C0567b.a(enumC1163aArrB);
    }

    private EnumC1163a(String str, int i5) {
    }

    private static final /* synthetic */ EnumC1163a[] b() {
        return new EnumC1163a[]{f22914a, f22915b, f22916c};
    }

    public static EnumC1163a valueOf(String str) {
        return (EnumC1163a) Enum.valueOf(EnumC1163a.class, str);
    }

    public static EnumC1163a[] values() {
        return (EnumC1163a[]) f22917d.clone();
    }
}
