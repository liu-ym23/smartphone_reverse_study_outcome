package v0;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class i<TranscodeType> extends T0.a<i<TranscodeType>> implements Cloneable {

    /* renamed from: R, reason: collision with root package name */
    protected static final T0.h f23274R = new T0.h().h(C0.j.f396c).O(g.LOW).T(true);

    /* renamed from: A, reason: collision with root package name */
    private final Context f23275A;

    /* renamed from: B, reason: collision with root package name */
    private final j f23276B;

    /* renamed from: C, reason: collision with root package name */
    private final Class<TranscodeType> f23277C;

    /* renamed from: D, reason: collision with root package name */
    private final ComponentCallbacks2C1180c f23278D;

    /* renamed from: E, reason: collision with root package name */
    private final e f23279E;

    /* renamed from: F, reason: collision with root package name */
    private k<?, ? super TranscodeType> f23280F;

    /* renamed from: G, reason: collision with root package name */
    private Object f23281G;

    /* renamed from: H, reason: collision with root package name */
    private List<T0.g<TranscodeType>> f23282H;

    /* renamed from: I, reason: collision with root package name */
    private i<TranscodeType> f23283I;

    /* renamed from: J, reason: collision with root package name */
    private i<TranscodeType> f23284J;

    /* renamed from: K, reason: collision with root package name */
    private Float f23285K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f23286L = true;

    /* renamed from: M, reason: collision with root package name */
    private boolean f23287M;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f23288Q;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23289a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f23290b;

        static {
            int[] iArr = new int[g.values().length];
            f23290b = iArr;
            try {
                iArr[g.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23290b[g.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23290b[g.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23290b[g.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f23289a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23289a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23289a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23289a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23289a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23289a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f23289a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f23289a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    protected i(ComponentCallbacks2C1180c componentCallbacks2C1180c, j jVar, Class<TranscodeType> cls, Context context) {
        this.f23278D = componentCallbacks2C1180c;
        this.f23276B = jVar;
        this.f23277C = cls;
        this.f23275A = context;
        this.f23280F = jVar.r(cls);
        this.f23279E = componentCallbacks2C1180c.i();
        f0(jVar.p());
        b(jVar.q());
    }

    private T0.d a0(U0.e<TranscodeType> eVar, T0.g<TranscodeType> gVar, T0.a<?> aVar, Executor executor) {
        return b0(eVar, gVar, null, this.f23280F, aVar.w(), aVar.t(), aVar.s(), aVar, executor);
    }

    private T0.d b0(U0.e<TranscodeType> eVar, T0.g<TranscodeType> gVar, T0.e eVar2, k<?, ? super TranscodeType> kVar, g gVar2, int i5, int i6, T0.a<?> aVar, Executor executor) {
        T0.b bVar;
        if (this.f23284J != null) {
            bVar = new T0.b(eVar2);
            eVar2 = bVar;
        } else {
            bVar = null;
        }
        T0.d dVarC0 = c0(eVar, gVar, eVar2, kVar, gVar2, i5, i6, aVar, executor);
        if (bVar == null) {
            return dVarC0;
        }
        int iT = this.f23284J.t();
        int iS = this.f23284J.s();
        if (X0.k.s(i5, i6) && !this.f23284J.K()) {
            iT = aVar.t();
            iS = aVar.s();
        }
        int i7 = iS;
        i<TranscodeType> iVar = this.f23284J;
        T0.b bVar2 = bVar;
        bVar2.s(dVarC0, iVar.b0(eVar, gVar, bVar2, iVar.f23280F, iVar.w(), iT, i7, this.f23284J, executor));
        return bVar2;
    }

    private T0.d c0(U0.e<TranscodeType> eVar, T0.g<TranscodeType> gVar, T0.e eVar2, k<?, ? super TranscodeType> kVar, g gVar2, int i5, int i6, T0.a<?> aVar, Executor executor) {
        i<TranscodeType> iVar = this.f23283I;
        if (iVar == null) {
            if (this.f23285K == null) {
                return o0(eVar, gVar, aVar, eVar2, kVar, gVar2, i5, i6, executor);
            }
            T0.k kVar2 = new T0.k(eVar2);
            kVar2.r(o0(eVar, gVar, aVar, kVar2, kVar, gVar2, i5, i6, executor), o0(eVar, gVar, aVar.clone().S(this.f23285K.floatValue()), kVar2, kVar, e0(gVar2), i5, i6, executor));
            return kVar2;
        }
        if (this.f23288Q) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        k<?, ? super TranscodeType> kVar3 = iVar.f23286L ? kVar : iVar.f23280F;
        g gVarW = iVar.F() ? this.f23283I.w() : e0(gVar2);
        int iT = this.f23283I.t();
        int iS = this.f23283I.s();
        if (X0.k.s(i5, i6) && !this.f23283I.K()) {
            iT = aVar.t();
            iS = aVar.s();
        }
        T0.k kVar4 = new T0.k(eVar2);
        T0.d dVarO0 = o0(eVar, gVar, aVar, kVar4, kVar, gVar2, i5, i6, executor);
        this.f23288Q = true;
        i iVar2 = (i<TranscodeType>) this.f23283I;
        T0.d dVarB0 = iVar2.b0(eVar, gVar, kVar4, kVar3, gVarW, iT, iS, iVar2, executor);
        this.f23288Q = false;
        kVar4.r(dVarO0, dVarB0);
        return kVar4;
    }

    private g e0(g gVar) {
        int i5 = a.f23290b[gVar.ordinal()];
        if (i5 == 1) {
            return g.NORMAL;
        }
        if (i5 == 2) {
            return g.HIGH;
        }
        if (i5 == 3 || i5 == 4) {
            return g.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + w());
    }

    private void f0(List<T0.g<Object>> list) {
        Iterator<T0.g<Object>> it = list.iterator();
        while (it.hasNext()) {
            Y((T0.g) it.next());
        }
    }

    private <Y extends U0.e<TranscodeType>> Y h0(Y y5, T0.g<TranscodeType> gVar, T0.a<?> aVar, Executor executor) {
        X0.j.d(y5);
        if (!this.f23287M) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        T0.d dVarA0 = a0(y5, gVar, aVar, executor);
        T0.d dVarK = y5.k();
        if (!dVarA0.e(dVarK) || j0(aVar, dVarK)) {
            this.f23276B.o(y5);
            y5.c(dVarA0);
            this.f23276B.v(y5, dVarA0);
            return y5;
        }
        dVarA0.b();
        if (!((T0.d) X0.j.d(dVarK)).isRunning()) {
            dVarK.k();
        }
        return y5;
    }

    private boolean j0(T0.a<?> aVar, T0.d dVar) {
        return !aVar.E() && dVar.m();
    }

    private i<TranscodeType> n0(Object obj) {
        this.f23281G = obj;
        this.f23287M = true;
        return this;
    }

    private T0.d o0(U0.e<TranscodeType> eVar, T0.g<TranscodeType> gVar, T0.a<?> aVar, T0.e eVar2, k<?, ? super TranscodeType> kVar, g gVar2, int i5, int i6, Executor executor) {
        Context context = this.f23275A;
        e eVar3 = this.f23279E;
        return T0.j.B(context, eVar3, this.f23281G, this.f23277C, aVar, i5, i6, gVar2, eVar, gVar, this.f23282H, eVar2, eVar3.e(), kVar.d(), executor);
    }

    public i<TranscodeType> Y(T0.g<TranscodeType> gVar) {
        if (gVar != null) {
            if (this.f23282H == null) {
                this.f23282H = new ArrayList();
            }
            this.f23282H.add(gVar);
        }
        return this;
    }

    @Override // T0.a
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> b(T0.a<?> aVar) {
        X0.j.d(aVar);
        return (i) super.b(aVar);
    }

    @Override // T0.a
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> clone() {
        i<TranscodeType> iVar = (i) super.clone();
        iVar.f23280F = iVar.f23280F.clone();
        return iVar;
    }

    public <Y extends U0.e<TranscodeType>> Y g0(Y y5) {
        return (Y) i0(y5, null, X0.e.b());
    }

    <Y extends U0.e<TranscodeType>> Y i0(Y y5, T0.g<TranscodeType> gVar, Executor executor) {
        return (Y) h0(y5, gVar, this, executor);
    }

    public i<TranscodeType> k0(T0.g<TranscodeType> gVar) {
        this.f23282H = null;
        return Y(gVar);
    }

    public i<TranscodeType> l0(Uri uri) {
        return n0(uri);
    }

    public i<TranscodeType> m0(Object obj) {
        return n0(obj);
    }

    public T0.c<TranscodeType> p0() {
        return q0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public T0.c<TranscodeType> q0(int i5, int i6) {
        T0.f fVar = new T0.f(i5, i6);
        return (T0.c) i0(fVar, fVar, X0.e.a());
    }
}
