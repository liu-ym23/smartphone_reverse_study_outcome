package q9;

import C7.r;
import java.util.Arrays;
import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public c[] f5622a;
    public int b;
    public int c;
    public l d;

    public final c d() {
        c cVarE;
        l lVar;
        synchronized (this) {
            try {
                c[] cVarArrF = this.f5622a;
                if (cVarArrF == null) {
                    cVarArrF = f();
                    this.f5622a = cVarArrF;
                } else if (this.b >= cVarArrF.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(cVarArrF, cVarArrF.length * 2);
                    kotlin.jvm.internal.k.e(objArrCopyOf, "copyOf(...)");
                    this.f5622a = (c[]) objArrCopyOf;
                    cVarArrF = (c[]) objArrCopyOf;
                }
                int i = this.c;
                do {
                    cVarE = cVarArrF[i];
                    if (cVarE == null) {
                        cVarE = e();
                        cVarArrF[i] = cVarE;
                    }
                    i++;
                    if (i >= cVarArrF.length) {
                        i = 0;
                    }
                } while (!cVarE.a(this));
                this.c = i;
                this.b++;
                lVar = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (lVar != null) {
            lVar.v(1);
        }
        return cVarE;
    }

    public abstract c e();

    public abstract c[] f();

    public final void g(c cVar) {
        l lVar;
        int i;
        H7.c[] cVarArrB;
        synchronized (this) {
            try {
                int i6 = this.b - 1;
                this.b = i6;
                lVar = this.d;
                if (i6 == 0) {
                    this.c = 0;
                }
                kotlin.jvm.internal.k.d(cVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                cVarArrB = cVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (H7.c cVar2 : cVarArrB) {
            if (cVar2 != null) {
                cVar2.resumeWith(r.f317a);
            }
        }
        if (lVar != null) {
            lVar.v(-1);
        }
    }

    public final l h() {
        l lVar;
        synchronized (this) {
            lVar = this.d;
            if (lVar == null) {
                int i = this.b;
                lVar = new l(1, Integer.MAX_VALUE, BufferOverflow.b);
                lVar.a(Integer.valueOf(i));
                this.d = lVar;
            }
        }
        return lVar;
    }
}
