package f;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: f.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0554a {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0554a f12507a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumC0554a[] f12508b;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0554a EF0;

    static {
        EnumC0554a enumC0554a = new EnumC0554a("WARNING", 0);
        EnumC0554a enumC0554a2 = new EnumC0554a("ERROR", 1);
        f12507a = enumC0554a2;
        f12508b = new EnumC0554a[]{enumC0554a, enumC0554a2};
    }

    public static EnumC0554a valueOf(String str) {
        return (EnumC0554a) Enum.valueOf(EnumC0554a.class, str);
    }

    public static EnumC0554a[] values() {
        return (EnumC0554a[]) f12508b.clone();
    }
}
