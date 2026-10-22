package j3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: j3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC0637a {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0637a f13133a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0637a f13134b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0637a f13135c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC0637a[] f13136d;

    static {
        EnumC0637a enumC0637a = new EnumC0637a("NONE", 0);
        f13133a = enumC0637a;
        EnumC0637a enumC0637a2 = new EnumC0637a("BASIC", 1);
        EnumC0637a enumC0637a3 = new EnumC0637a("HEADERS", 2);
        f13134b = enumC0637a3;
        EnumC0637a enumC0637a4 = new EnumC0637a("BODY", 3);
        f13135c = enumC0637a4;
        f13136d = new EnumC0637a[]{enumC0637a, enumC0637a2, enumC0637a3, enumC0637a4};
    }

    public static EnumC0637a valueOf(String str) {
        return (EnumC0637a) Enum.valueOf(EnumC0637a.class, str);
    }

    public static EnumC0637a[] values() {
        return (EnumC0637a[]) f13136d.clone();
    }
}
