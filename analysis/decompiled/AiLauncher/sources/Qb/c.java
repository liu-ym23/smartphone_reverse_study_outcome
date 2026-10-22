package Qb;

import Yb.u;
import com.fasterxml.jackson.core.JsonPointer;
import dc.InterfaceC3968b;
import dc.e;
import java.io.IOException;
import java.util.Set;

/* loaded from: classes5.dex */
public class c extends b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC3968b f5516a;

    /* renamed from: b, reason: collision with root package name */
    public final e f5517b;

    public c(InterfaceC3968b interfaceC3968b) {
        this.f5516a = interfaceC3968b;
        this.f5517b = interfaceC3968b.c();
    }

    @Override // cc.InterfaceC1510a
    public void a(u uVar) throws IOException {
        this.f5517b.f(JsonPointer.SEPARATOR);
        b(uVar);
        this.f5517b.f(JsonPointer.SEPARATOR);
    }

    public final void b(u uVar) {
        u uVarC = uVar.c();
        while (uVarC != null) {
            u uVarE = uVarC.e();
            this.f5516a.a(uVarC);
            uVarC = uVarE;
        }
    }

    @Override // Qb.b, cc.InterfaceC1510a
    public /* bridge */ /* synthetic */ Set y() {
        return super.y();
    }
}
