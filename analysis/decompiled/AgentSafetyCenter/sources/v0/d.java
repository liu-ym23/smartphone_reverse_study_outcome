package v0;

import java.lang.invoke.VarHandle;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends RuntimeException {

    /* renamed from: c, reason: collision with root package name */
    public List f14320c;

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        StringBuilder sb2 = new StringBuilder("Composition stack when thrown:\n");
        List list = this.f14320c;
        lb.c cVarO = ac.a.o();
        list.getClass();
        hc.e eVar = new hc.e(false, 1);
        eVar.f5460g = list;
        VarHandle.storeStoreFence();
        if (eVar.a() > 0) {
            ((a) eVar.get(0)).getClass();
            throw null;
        }
        lb.c cVarK = ac.a.k(cVarO);
        cVarK.getClass();
        hc.e eVar2 = new hc.e(false, 1);
        eVar2.f5460g = cVarK;
        VarHandle.storeStoreFence();
        int iA = eVar2.a();
        for (int i = 0; i < iA; i++) {
            sb2.append("\tat " + ((String) eVar2.get(i)));
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
