package s4;

/* renamed from: s4.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1093v {
    public static final <T> InterfaceC1091t<T> a(n0 n0Var) {
        return new C1092u(n0Var);
    }

    public static /* synthetic */ InterfaceC1091t b(n0 n0Var, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            n0Var = null;
        }
        return a(n0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean c(InterfaceC1091t<T> interfaceC1091t, Object obj) {
        Throwable thB = V3.n.b(obj);
        return thB == null ? interfaceC1091t.O(obj) : interfaceC1091t.L(thB);
    }
}
