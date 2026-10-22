package e;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: e.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0544b {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0544b f12487a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumC0544b[] f12488b;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0544b EF0;

    static {
        EnumC0544b enumC0544b = new EnumC0544b("NONE", 0);
        EnumC0544b enumC0544b2 = new EnumC0544b("INFERRED", 1);
        f12487a = enumC0544b2;
        f12488b = new EnumC0544b[]{enumC0544b, enumC0544b2, new EnumC0544b("INT_ENUM", 2), new EnumC0544b("INT_FLAG", 3), new EnumC0544b("COLOR", 4), new EnumC0544b("GRAVITY", 5), new EnumC0544b("RESOURCE_ID", 6)};
    }

    public static EnumC0544b valueOf(String str) {
        return (EnumC0544b) Enum.valueOf(EnumC0544b.class, str);
    }

    public static EnumC0544b[] values() {
        return (EnumC0544b[]) f12488b.clone();
    }
}
