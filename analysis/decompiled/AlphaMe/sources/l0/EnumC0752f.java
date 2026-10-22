package l0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: l0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0752f {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0752f f13431a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0752f f13432b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0752f f13433c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0752f f13434d;

    /* renamed from: e, reason: collision with root package name */
    public static final EnumC0752f f13435e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumC0752f[] f13436f;

    static {
        EnumC0752f enumC0752f = new EnumC0752f("ON_CONFIGURE", 0);
        f13431a = enumC0752f;
        EnumC0752f enumC0752f2 = new EnumC0752f("ON_CREATE", 1);
        f13432b = enumC0752f2;
        EnumC0752f enumC0752f3 = new EnumC0752f("ON_UPGRADE", 2);
        f13433c = enumC0752f3;
        EnumC0752f enumC0752f4 = new EnumC0752f("ON_DOWNGRADE", 3);
        f13434d = enumC0752f4;
        EnumC0752f enumC0752f5 = new EnumC0752f("ON_OPEN", 4);
        f13435e = enumC0752f5;
        f13436f = new EnumC0752f[]{enumC0752f, enumC0752f2, enumC0752f3, enumC0752f4, enumC0752f5};
    }

    public static EnumC0752f valueOf(String str) {
        return (EnumC0752f) Enum.valueOf(EnumC0752f.class, str);
    }

    public static EnumC0752f[] values() {
        return (EnumC0752f[]) f13436f.clone();
    }
}
