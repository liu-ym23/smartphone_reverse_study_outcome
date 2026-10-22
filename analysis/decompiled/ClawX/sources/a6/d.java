package a6;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d implements j {

    /* renamed from: a, reason: collision with root package name */
    public final c[] f148a;

    public d(c[] cVarArr) {
        this.f148a = cVarArr;
    }

    @Override // a6.j
    public final void a(Throwable th) {
        b();
    }

    public final void b() {
        for (c cVar : this.f148a) {
            s0 s0Var = cVar.f140f;
            if (s0Var == null) {
                kotlin.jvm.internal.p.l("handle");
                throw null;
            }
            s0Var.b();
        }
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.f148a + AbstractJsonLexerKt.END_LIST;
    }
}
