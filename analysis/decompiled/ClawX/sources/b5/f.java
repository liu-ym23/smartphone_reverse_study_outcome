package b5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f889a;

    /* renamed from: b, reason: collision with root package name */
    public static final f f890b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ f[] f891c;

    static {
        f fVar = new f("SYNCHRONIZED", 0);
        f fVar2 = new f("PUBLICATION", 1);
        f889a = fVar2;
        f fVar3 = new f("NONE", 2);
        f890b = fVar3;
        f[] fVarArr = {fVar, fVar2, fVar3};
        f891c = fVarArr;
        a.a.F(fVarArr);
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f891c.clone();
    }
}
