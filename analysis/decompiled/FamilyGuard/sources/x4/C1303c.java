package x4;

/* renamed from: x4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1303c {

    /* renamed from: a, reason: collision with root package name */
    private static final C1294F f23850a = new C1294F("CLOSED");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [x4.d] */
    public static final <N extends AbstractC1304d<N>> N b(N n5) {
        while (true) {
            Object objG = n5.g();
            if (objG == f23850a) {
                return n5;
            }
            ?? r02 = (AbstractC1304d) objG;
            if (r02 != 0) {
                n5 = r02;
            } else if (n5.m()) {
                return n5;
            }
        }
    }

    public static final <S extends AbstractC1291C<S>> Object c(S s5, long j5, i4.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s5.f23829c >= j5 && !s5.k()) {
                return C1292D.a(s5);
            }
            Object objG = s5.g();
            if (objG == f23850a) {
                return C1292D.a(f23850a);
            }
            S sInvoke = (S) ((AbstractC1304d) objG);
            if (sInvoke == null) {
                sInvoke = pVar.invoke(Long.valueOf(s5.f23829c + 1), s5);
                if (s5.o(sInvoke)) {
                    if (s5.k()) {
                        s5.n();
                    }
                }
            }
            s5 = sInvoke;
        }
    }
}
