package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 {
    public static w a(Object obj, long j10) {
        w wVar = (w) j1.f1140c.h(obj, j10);
        if (((u0) wVar).f1211c) {
            return wVar;
        }
        u0 u0Var = (u0) wVar;
        int i = u0Var.f1213g;
        u0 u0VarC = u0Var.c(i == 0 ? 10 : i * 2);
        j1.o(obj, j10, u0VarC);
        return u0VarC;
    }
}
