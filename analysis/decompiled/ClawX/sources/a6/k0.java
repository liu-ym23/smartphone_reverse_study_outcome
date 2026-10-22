package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final n0 f185a;

    static {
        String property;
        n0 n0Var;
        int i8 = f6.s.f2661a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            h6.e eVar = r0.f210a;
            b6.f fVar = f6.m.f2657a;
            b6.f fVar2 = fVar.f930e;
            n0Var = fVar;
            if (fVar == null) {
                n0Var = j0.f182k;
            }
        } else {
            n0Var = j0.f182k;
        }
        f185a = n0Var;
    }
}
