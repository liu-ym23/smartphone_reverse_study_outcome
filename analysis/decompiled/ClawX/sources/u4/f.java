package u4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final p0.b f5654a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ f[] f5655b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ i5.b f5656c;

    static {
        f[] fVarArr = {new f("MONDAY", 0), new f("TUESDAY", 1), new f("WEDNESDAY", 2), new f("THURSDAY", 3), new f("FRIDAY", 4), new f("SATURDAY", 5), new f("SUNDAY", 6)};
        f5655b = fVarArr;
        f5656c = a.a.F(fVarArr);
        f5654a = new p0.b(7);
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f5655b.clone();
    }
}
