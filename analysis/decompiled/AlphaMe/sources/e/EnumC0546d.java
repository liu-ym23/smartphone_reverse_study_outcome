package e;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: e.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0546d {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0546d f12492a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0546d f12493b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0546d f12494c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC0546d[] f12495d;

    static {
        EnumC0546d enumC0546d = new EnumC0546d("LIBRARY", 0);
        f12492a = enumC0546d;
        EnumC0546d enumC0546d2 = new EnumC0546d("LIBRARY_GROUP", 1);
        f12493b = enumC0546d2;
        EnumC0546d enumC0546d3 = new EnumC0546d("LIBRARY_GROUP_PREFIX", 2);
        f12494c = enumC0546d3;
        f12495d = new EnumC0546d[]{enumC0546d, enumC0546d2, enumC0546d3, new EnumC0546d("GROUP_ID", 3), new EnumC0546d("TESTS", 4), new EnumC0546d("SUBCLASSES", 5)};
    }

    public static EnumC0546d valueOf(String str) {
        return (EnumC0546d) Enum.valueOf(EnumC0546d.class, str);
    }

    public static EnumC0546d[] values() {
        return (EnumC0546d[]) f12495d.clone();
    }
}
