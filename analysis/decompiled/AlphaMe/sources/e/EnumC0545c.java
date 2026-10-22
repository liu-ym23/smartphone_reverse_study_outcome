package e;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: e.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0545c {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0545c f12489a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0545c f12490b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumC0545c[] f12491c;

    static {
        EnumC0545c enumC0545c = new EnumC0545c("WARNING", 0);
        f12489a = enumC0545c;
        EnumC0545c enumC0545c2 = new EnumC0545c("ERROR", 1);
        f12490b = enumC0545c2;
        f12491c = new EnumC0545c[]{enumC0545c, enumC0545c2};
    }

    public static EnumC0545c valueOf(String str) {
        return (EnumC0545c) Enum.valueOf(EnumC0545c.class, str);
    }

    public static EnumC0545c[] values() {
        return (EnumC0545c[]) f12491c.clone();
    }
}
