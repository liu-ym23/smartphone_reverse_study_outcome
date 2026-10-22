package M9;

import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes4.dex */
public final class i extends I9.a {
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(int i, String str, Object obj, Object obj2) {
        super(str, true);
        this.e = i;
        this.f = obj;
        this.g = obj2;
    }

    @Override // I9.a
    public final long a() {
        long jA;
        int i;
        w[] wVarArr;
        switch (this.e) {
            case 0:
                o oVar = (o) this.f;
                oVar.f984a.a(oVar, (B) ((Ref$ObjectRef) this.g).f4920a);
                return -1L;
            case 1:
                w wVar = (w) this.g;
                o oVar2 = (o) this.f;
                try {
                    oVar2.f984a.b(wVar);
                    return -1L;
                } catch (IOException e) {
                    N9.m.Companion.getClass();
                    N9.m.platform.log("Http2Connection.Listener failure for " + oVar2.c, 4, e);
                    try {
                        wVar.c(ErrorCode.PROTOCOL_ERROR, e);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            default:
                J4.e eVar = (J4.e) this.f;
                B b = (B) this.g;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                o oVar3 = (o) eVar.c;
                synchronized (oVar3.f991w) {
                    synchronized (oVar3) {
                        try {
                            B b5 = oVar3.f986q;
                            B b10 = new B();
                            b10.b(b5);
                            b10.b(b);
                            ref$ObjectRef.f4920a = b10;
                            jA = b10.a() - b5.a();
                            wVarArr = (jA == 0 || oVar3.b.isEmpty()) ? null : (w[]) oVar3.b.values().toArray(new w[0]);
                            B b11 = (B) ref$ObjectRef.f4920a;
                            kotlin.jvm.internal.k.f(b11, "<set-?>");
                            oVar3.f986q = b11;
                            oVar3.f985j.c(new i(0, oVar3.c + " onSettings", oVar3, ref$ObjectRef), 0L);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    try {
                        oVar3.f991w.b((B) ref$ObjectRef.f4920a);
                    } catch (IOException e6) {
                        oVar3.c(e6);
                    }
                }
                if (wVarArr == null) {
                    return -1L;
                }
                for (w wVar2 : wVarArr) {
                    synchronized (wVar2) {
                        wVar2.f += jA;
                        if (jA > 0) {
                            wVar2.notifyAll();
                        }
                    }
                }
                return -1L;
        }
    }
}
