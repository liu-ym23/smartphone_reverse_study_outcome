package s0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: s0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0843a {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0843a f14167a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0843a f14168b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumC0843a[] f14169c;

    static {
        EnumC0843a enumC0843a = new EnumC0843a("EXPONENTIAL", 0);
        f14167a = enumC0843a;
        EnumC0843a enumC0843a2 = new EnumC0843a("LINEAR", 1);
        f14168b = enumC0843a2;
        f14169c = new EnumC0843a[]{enumC0843a, enumC0843a2};
    }

    public static EnumC0843a valueOf(String str) {
        return (EnumC0843a) Enum.valueOf(EnumC0843a.class, str);
    }

    public static EnumC0843a[] values() {
        return (EnumC0843a[]) f14169c.clone();
    }
}
