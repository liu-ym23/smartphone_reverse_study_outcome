package x3;

/* loaded from: classes.dex */
public abstract class m<T> implements n<T> {

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23812a;

        static {
            int[] iArr = new int[EnumC1285a.values().length];
            f23812a = iArr;
            try {
                iArr[EnumC1285a.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23812a[EnumC1285a.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23812a[EnumC1285a.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23812a[EnumC1285a.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // x3.n
    public final void a(o<? super T> oVar) {
        F3.b.d(oVar, "observer is null");
        try {
            o<? super T> oVarY = S3.a.y(this, oVar);
            F3.b.d(oVarY, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            e(oVarY);
        } catch (NullPointerException e6) {
            throw e6;
        } catch (Throwable th) {
            B3.b.b(th);
            S3.a.r(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final AbstractC1286b b() {
        return S3.a.k(new L3.b(this));
    }

    public final j<T> c() {
        return S3.a.m(new L3.c(this));
    }

    public final q<T> d() {
        return S3.a.o(new L3.d(this, null));
    }

    protected abstract void e(o<? super T> oVar);

    public final m<T> f(p pVar) {
        F3.b.d(pVar, "scheduler is null");
        return S3.a.n(new L3.e(this, pVar));
    }

    public final f<T> g(EnumC1285a enumC1285a) {
        J3.l lVar = new J3.l(this);
        int i5 = a.f23812a[enumC1285a.ordinal()];
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? lVar.I() : S3.a.l(new J3.u(lVar)) : lVar : lVar.L() : lVar.K();
    }
}
