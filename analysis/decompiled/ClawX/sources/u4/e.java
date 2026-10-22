package u4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final p0.b f5651a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ e[] f5652b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ i5.b f5653c;

    static {
        e[] eVarArr = {new e("JANUARY", 0), new e("FEBRUARY", 1), new e("MARCH", 2), new e("APRIL", 3), new e("MAY", 4), new e("JUNE", 5), new e("JULY", 6), new e("AUGUST", 7), new e("SEPTEMBER", 8), new e("OCTOBER", 9), new e("NOVEMBER", 10), new e("DECEMBER", 11)};
        f5652b = eVarArr;
        f5653c = a.a.F(eVarArr);
        f5651a = new p0.b(6);
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f5652b.clone();
    }
}
