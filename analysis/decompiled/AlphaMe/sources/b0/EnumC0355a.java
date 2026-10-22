package b0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: b0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0355a {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0355a f4352a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0355a f4353b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0355a f4354c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0355a f4355d;

    /* renamed from: e, reason: collision with root package name */
    public static final EnumC0355a f4356e;

    /* renamed from: f, reason: collision with root package name */
    public static final EnumC0355a f4357f;

    /* renamed from: g, reason: collision with root package name */
    public static final EnumC0355a f4358g;

    /* renamed from: h, reason: collision with root package name */
    public static final EnumC0355a f4359h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ EnumC0355a[] f4360i;

    static {
        EnumC0355a enumC0355a = new EnumC0355a("PENALTY_LOG", 0);
        f4352a = enumC0355a;
        EnumC0355a enumC0355a2 = new EnumC0355a("PENALTY_DEATH", 1);
        f4353b = enumC0355a2;
        EnumC0355a enumC0355a3 = new EnumC0355a("DETECT_FRAGMENT_REUSE", 2);
        f4354c = enumC0355a3;
        EnumC0355a enumC0355a4 = new EnumC0355a("DETECT_FRAGMENT_TAG_USAGE", 3);
        f4355d = enumC0355a4;
        EnumC0355a enumC0355a5 = new EnumC0355a("DETECT_RETAIN_INSTANCE_USAGE", 4);
        f4356e = enumC0355a5;
        EnumC0355a enumC0355a6 = new EnumC0355a("DETECT_SET_USER_VISIBLE_HINT", 5);
        f4357f = enumC0355a6;
        EnumC0355a enumC0355a7 = new EnumC0355a("DETECT_TARGET_FRAGMENT_USAGE", 6);
        f4358g = enumC0355a7;
        EnumC0355a enumC0355a8 = new EnumC0355a("DETECT_WRONG_FRAGMENT_CONTAINER", 7);
        f4359h = enumC0355a8;
        f4360i = new EnumC0355a[]{enumC0355a, enumC0355a2, enumC0355a3, enumC0355a4, enumC0355a5, enumC0355a6, enumC0355a7, enumC0355a8};
    }

    public static EnumC0355a valueOf(String str) {
        return (EnumC0355a) Enum.valueOf(EnumC0355a.class, str);
    }

    public static EnumC0355a[] values() {
        return (EnumC0355a[]) f4360i.clone();
    }
}
