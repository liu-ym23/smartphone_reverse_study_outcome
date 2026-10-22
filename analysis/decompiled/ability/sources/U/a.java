package U;

import F9.s;
import F9.t;

/* loaded from: classes2.dex */
public final class a implements s {

    /* renamed from: a, reason: collision with root package name */
    public final s f1239a;

    public a(s sVar) {
        this.f1239a = sVar;
    }

    @Override // F9.s
    public final t i(J9.i iVar) {
        s sVar = this.f1239a;
        t tVarI = sVar != null ? sVar.i(iVar) : null;
        b bVar = new b();
        bVar.e = true;
        bVar.f1241q = new StringBuilder();
        bVar.b = tVarI;
        bVar.c = new i();
        if (!C4.a.c().b()) {
            bVar.e = false;
        }
        return bVar;
    }
}
