package w4;

import Z3.i;
import i4.p;
import j4.l;
import s4.n0;
import x4.C1290B;

/* loaded from: classes.dex */
public final class k {

    static final class a extends l implements p<Integer, i.b, Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i<?> f23732a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(i<?> iVar) {
            super(2);
            this.f23732a = iVar;
        }

        public final Integer b(int i5, i.b bVar) {
            i.c<?> key = bVar.getKey();
            i.b bVarA = this.f23732a.f23725b.a(key);
            if (key != n0.f20363P) {
                return Integer.valueOf(bVar != bVarA ? Integer.MIN_VALUE : i5 + 1);
            }
            n0 n0Var = (n0) bVarA;
            j4.k.e(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            n0 n0VarB = k.b((n0) bVar, n0Var);
            if (n0VarB == n0Var) {
                if (n0Var != null) {
                    i5++;
                }
                return Integer.valueOf(i5);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + n0VarB + ", expected child of " + n0Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // i4.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, i.b bVar) {
            return b(num.intValue(), bVar);
        }
    }

    public static final void a(i<?> iVar, Z3.i iVar2) {
        if (((Number) iVar2.o(0, new a(iVar))).intValue() == iVar.f23726c) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + iVar.f23725b + ",\n\t\tbut emission happened in " + iVar2 + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final n0 b(n0 n0Var, n0 n0Var2) {
        while (n0Var != null) {
            if (n0Var == n0Var2 || !(n0Var instanceof C1290B)) {
                return n0Var;
            }
            n0Var = n0Var.getParent();
        }
        return null;
    }
}
