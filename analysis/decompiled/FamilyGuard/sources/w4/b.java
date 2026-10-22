package w4;

import V3.n;
import V3.v;
import java.util.Arrays;
import w4.d;

/* loaded from: classes.dex */
public abstract class b<S extends d<?>> {

    /* renamed from: a, reason: collision with root package name */
    private S[] f23713a;

    /* renamed from: b, reason: collision with root package name */
    private int f23714b;

    /* renamed from: c, reason: collision with root package name */
    private int f23715c;

    protected final S b() {
        S s5;
        synchronized (this) {
            try {
                S[] sArr = this.f23713a;
                if (sArr == null) {
                    sArr = (S[]) d(2);
                    this.f23713a = sArr;
                } else if (this.f23714b >= sArr.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    j4.k.f(objArrCopyOf, "copyOf(...)");
                    this.f23713a = (S[]) ((d[]) objArrCopyOf);
                    sArr = (S[]) ((d[]) objArrCopyOf);
                }
                int i5 = this.f23715c;
                do {
                    s5 = sArr[i5];
                    if (s5 == null) {
                        s5 = (S) c();
                        sArr[i5] = s5;
                    }
                    i5++;
                    if (i5 >= sArr.length) {
                        i5 = 0;
                    }
                    j4.k.e(s5, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!s5.a(this));
                this.f23715c = i5;
                this.f23714b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return s5;
    }

    protected abstract S c();

    protected abstract S[] d(int i5);

    protected final void e(S s5) {
        int i5;
        Z3.e<v>[] eVarArrB;
        synchronized (this) {
            try {
                int i6 = this.f23714b - 1;
                this.f23714b = i6;
                if (i6 == 0) {
                    this.f23715c = 0;
                }
                j4.k.e(s5, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                eVarArrB = s5.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Z3.e<v> eVar : eVarArrB) {
            if (eVar != null) {
                n.a aVar = n.f5531a;
                eVar.resumeWith(n.a(v.f5542a));
            }
        }
    }

    protected final S[] f() {
        return this.f23713a;
    }
}
