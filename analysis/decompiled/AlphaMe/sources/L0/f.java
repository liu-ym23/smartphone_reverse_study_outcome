package L0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f1175a;

    /* renamed from: b, reason: collision with root package name */
    public static final f f1176b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ f[] f1177c;

    static {
        f fVar = new f("Linear", 0);
        f1175a = fVar;
        f fVar2 = new f("Radial", 1);
        f1176b = fVar2;
        f1177c = new f[]{fVar, fVar2};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f1177c.clone();
    }
}
