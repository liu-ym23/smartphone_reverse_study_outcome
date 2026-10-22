package w8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: f, reason: collision with root package name */
    public static final f f10894f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f10895g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ f[] f10896h;

    static {
        f fVar = new f("READ_ONLY", 0);
        f10894f = fVar;
        f fVar2 = new f("MUTABLE", 1);
        f10895g = fVar2;
        f10896h = new f[]{fVar, fVar2};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f10896h.clone();
    }
}
