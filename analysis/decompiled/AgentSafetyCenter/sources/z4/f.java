package z4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f16390c;

    /* renamed from: f, reason: collision with root package name */
    public static final f f16391f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f16392g;

    /* renamed from: h, reason: collision with root package name */
    public static final f f16393h;
    public static final f i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ f[] f16394j;

    static {
        f fVar = new f("ON_CONFIGURE", 0);
        f16390c = fVar;
        f fVar2 = new f("ON_CREATE", 1);
        f16391f = fVar2;
        f fVar3 = new f("ON_UPGRADE", 2);
        f16392g = fVar3;
        f fVar4 = new f("ON_DOWNGRADE", 3);
        f16393h = fVar4;
        f fVar5 = new f("ON_OPEN", 4);
        i = fVar5;
        f[] fVarArr = {fVar, fVar2, fVar3, fVar4, fVar5};
        f16394j = fVarArr;
        a.a.p(fVarArr);
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f16394j.clone();
    }
}
