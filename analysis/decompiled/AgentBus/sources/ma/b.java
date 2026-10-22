package ma;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: f, reason: collision with root package name */
    public d[] f6476f;

    /* renamed from: g, reason: collision with root package name */
    public int f6477g;

    /* renamed from: h, reason: collision with root package name */
    public int f6478h;

    /* renamed from: i, reason: collision with root package name */
    public w f6479i;

    public final d a() {
        d dVarB;
        w wVar;
        synchronized (this) {
            try {
                d[] dVarArrC = this.f6476f;
                if (dVarArrC == null) {
                    dVarArrC = c();
                    this.f6476f = dVarArrC;
                } else if (this.f6477g >= dVarArrC.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(dVarArrC, dVarArrC.length * 2);
                    q7.k.d(objArrCopyOf, "copyOf(...)");
                    this.f6476f = (d[]) objArrCopyOf;
                    dVarArrC = (d[]) objArrCopyOf;
                }
                int i2 = this.f6478h;
                do {
                    dVarB = dVarArrC[i2];
                    if (dVarB == null) {
                        dVarB = b();
                        dVarArrC[i2] = dVarB;
                    }
                    i2++;
                    if (i2 >= dVarArrC.length) {
                        i2 = 0;
                    }
                } while (!dVarB.a(this));
                this.f6478h = i2;
                this.f6477g++;
                wVar = this.f6479i;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (wVar != null) {
            wVar.s(1);
        }
        return dVarB;
    }

    public abstract d b();

    public abstract d[] c();

    public final void d(d dVar) {
        w wVar;
        int i2;
        g7.d[] dVarArrB;
        synchronized (this) {
            try {
                int i10 = this.f6477g - 1;
                this.f6477g = i10;
                wVar = this.f6479i;
                if (i10 == 0) {
                    this.f6478h = 0;
                }
                q7.k.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                dVarArrB = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (g7.d dVar2 : dVarArrB) {
            if (dVar2 != null) {
                dVar2.resumeWith(c7.r.f1986a);
            }
        }
        if (wVar != null) {
            wVar.s(-1);
        }
    }

    public final w e() {
        w wVar;
        synchronized (this) {
            wVar = this.f6479i;
            if (wVar == null) {
                int i2 = this.f6477g;
                wVar = new w(1, Integer.MAX_VALUE, ka.a.f5662g);
                wVar.M(Integer.valueOf(i2));
                this.f6479i = wVar;
            }
        }
        return wVar;
    }
}
