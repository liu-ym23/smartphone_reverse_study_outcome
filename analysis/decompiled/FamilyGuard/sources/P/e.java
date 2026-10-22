package P;

import P.b;
import P.e;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.H;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class e<T extends e<T>> implements b.c {

    /* renamed from: a, reason: collision with root package name */
    float f4501a;

    /* renamed from: b, reason: collision with root package name */
    float f4502b;

    /* renamed from: c, reason: collision with root package name */
    boolean f4503c;

    /* renamed from: d, reason: collision with root package name */
    final Object f4504d;

    /* renamed from: e, reason: collision with root package name */
    final P.f f4505e;

    /* renamed from: f, reason: collision with root package name */
    boolean f4506f;

    /* renamed from: g, reason: collision with root package name */
    float f4507g;

    /* renamed from: h, reason: collision with root package name */
    float f4508h;

    /* renamed from: i, reason: collision with root package name */
    private long f4509i;

    /* renamed from: j, reason: collision with root package name */
    private float f4510j;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList<q> f4511k;

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList<r> f4512l;

    /* renamed from: m, reason: collision with root package name */
    private P.b f4513m;

    /* renamed from: n, reason: collision with root package name */
    public static final s f4488n = new g("translationX");

    /* renamed from: o, reason: collision with root package name */
    public static final s f4489o = new h("translationY");

    /* renamed from: p, reason: collision with root package name */
    public static final s f4490p = new i("translationZ");

    /* renamed from: q, reason: collision with root package name */
    public static final s f4491q = new j("scaleX");

    /* renamed from: r, reason: collision with root package name */
    public static final s f4492r = new k("scaleY");

    /* renamed from: s, reason: collision with root package name */
    public static final s f4493s = new l("rotation");

    /* renamed from: t, reason: collision with root package name */
    public static final s f4494t = new m("rotationX");

    /* renamed from: u, reason: collision with root package name */
    public static final s f4495u = new n("rotationY");

    /* renamed from: v, reason: collision with root package name */
    public static final s f4496v = new o("x");

    /* renamed from: w, reason: collision with root package name */
    public static final s f4497w = new a("y");

    /* renamed from: x, reason: collision with root package name */
    public static final s f4498x = new b("z");

    /* renamed from: y, reason: collision with root package name */
    public static final s f4499y = new c("alpha");

    /* renamed from: z, reason: collision with root package name */
    public static final s f4500z = new d("scrollX");

    /* renamed from: A, reason: collision with root package name */
    public static final s f4487A = new C0072e("scrollY");

    class a extends s {
        a(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setY(f5);
        }
    }

    class b extends s {
        b(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return H.L(view);
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            H.I0(view, f5);
        }
    }

    class c extends s {
        c(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setAlpha(f5);
        }
    }

    class d extends s {
        d(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setScrollX((int) f5);
        }
    }

    /* renamed from: P.e$e, reason: collision with other inner class name */
    class C0072e extends s {
        C0072e(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setScrollY((int) f5);
        }
    }

    class f extends P.f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ P.g f4514b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, P.g gVar) {
            super(str);
            this.f4514b = gVar;
        }

        @Override // P.f
        public float a(Object obj) {
            return this.f4514b.a();
        }

        @Override // P.f
        public void b(Object obj, float f5) {
            this.f4514b.b(f5);
        }
    }

    class g extends s {
        g(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setTranslationX(f5);
        }
    }

    class h extends s {
        h(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setTranslationY(f5);
        }
    }

    class i extends s {
        i(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return H.I(view);
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            H.G0(view, f5);
        }
    }

    class j extends s {
        j(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setScaleX(f5);
        }
    }

    class k extends s {
        k(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setScaleY(f5);
        }
    }

    class l extends s {
        l(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setRotation(f5);
        }
    }

    class m extends s {
        m(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setRotationX(f5);
        }
    }

    class n extends s {
        n(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setRotationY(f5);
        }
    }

    class o extends s {
        o(String str) {
            super(str, null);
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f5) {
            view.setX(f5);
        }
    }

    static class p {

        /* renamed from: a, reason: collision with root package name */
        float f4516a;

        /* renamed from: b, reason: collision with root package name */
        float f4517b;

        p() {
        }
    }

    public interface q {
        void a(e eVar, boolean z5, float f5, float f6);
    }

    public interface r {
        void a(e eVar, float f5, float f6);
    }

    public static abstract class s extends P.f<View> {
        /* synthetic */ s(String str, g gVar) {
            this(str);
        }

        private s(String str) {
            super(str);
        }
    }

    e(P.g gVar) {
        this.f4501a = 0.0f;
        this.f4502b = Float.MAX_VALUE;
        this.f4503c = false;
        this.f4506f = false;
        this.f4507g = Float.MAX_VALUE;
        this.f4508h = -Float.MAX_VALUE;
        this.f4509i = 0L;
        this.f4511k = new ArrayList<>();
        this.f4512l = new ArrayList<>();
        this.f4504d = null;
        this.f4505e = new f("FloatValueHolder", gVar);
        this.f4510j = 1.0f;
    }

    private void e(boolean z5) {
        this.f4506f = false;
        f().k(this);
        this.f4509i = 0L;
        this.f4503c = false;
        for (int i5 = 0; i5 < this.f4511k.size(); i5++) {
            if (this.f4511k.get(i5) != null) {
                this.f4511k.get(i5).a(this, z5, this.f4502b, this.f4501a);
            }
        }
        j(this.f4511k);
    }

    private float g() {
        return this.f4505e.a(this.f4504d);
    }

    private static <T> void j(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void q() {
        if (this.f4506f) {
            return;
        }
        this.f4506f = true;
        if (!this.f4503c) {
            this.f4502b = g();
        }
        float f5 = this.f4502b;
        if (f5 > this.f4507g || f5 < this.f4508h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        f().d(this, 0L);
    }

    @Override // P.b.c
    public boolean a(long j5) {
        long j6 = this.f4509i;
        if (j6 == 0) {
            this.f4509i = j5;
            l(this.f4502b);
            return false;
        }
        long j7 = j5 - j6;
        this.f4509i = j5;
        float fG = f().g();
        boolean zR = r(fG == 0.0f ? 2147483647L : (long) (j7 / fG));
        float fMin = Math.min(this.f4502b, this.f4507g);
        this.f4502b = fMin;
        float fMax = Math.max(fMin, this.f4508h);
        this.f4502b = fMax;
        l(fMax);
        if (zR) {
            e(false);
        }
        return zR;
    }

    public T b(q qVar) {
        if (!this.f4511k.contains(qVar)) {
            this.f4511k.add(qVar);
        }
        return this;
    }

    public T c(r rVar) {
        if (i()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.f4512l.contains(rVar)) {
            this.f4512l.add(rVar);
        }
        return this;
    }

    public void d() {
        if (!f().j()) {
            throw new AndroidRuntimeException("Animations may only be canceled from the same thread as the animation handler");
        }
        if (this.f4506f) {
            e(true);
        }
    }

    public P.b f() {
        P.b bVar = this.f4513m;
        return bVar != null ? bVar : P.b.h();
    }

    float h() {
        return this.f4510j * 0.75f;
    }

    public boolean i() {
        return this.f4506f;
    }

    public T k(float f5) {
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.f4510j = f5;
        o(f5 * 0.75f);
        return this;
    }

    void l(float f5) {
        this.f4505e.b(this.f4504d, f5);
        for (int i5 = 0; i5 < this.f4512l.size(); i5++) {
            if (this.f4512l.get(i5) != null) {
                this.f4512l.get(i5).a(this, this.f4502b, this.f4501a);
            }
        }
        j(this.f4512l);
    }

    public T m(float f5) {
        this.f4502b = f5;
        this.f4503c = true;
        return this;
    }

    public T n(float f5) {
        this.f4501a = f5;
        return this;
    }

    abstract void o(float f5);

    public void p() {
        if (!f().j()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f4506f) {
            return;
        }
        q();
    }

    abstract boolean r(long j5);

    <K> e(K k5, P.f<K> fVar) {
        this.f4501a = 0.0f;
        this.f4502b = Float.MAX_VALUE;
        this.f4503c = false;
        this.f4506f = false;
        this.f4507g = Float.MAX_VALUE;
        this.f4508h = -Float.MAX_VALUE;
        this.f4509i = 0L;
        this.f4511k = new ArrayList<>();
        this.f4512l = new ArrayList<>();
        this.f4504d = k5;
        this.f4505e = fVar;
        if (fVar != f4493s && fVar != f4494t && fVar != f4495u) {
            if (fVar == f4499y) {
                this.f4510j = 0.00390625f;
                return;
            } else if (fVar != f4491q && fVar != f4492r) {
                this.f4510j = 1.0f;
                return;
            } else {
                this.f4510j = 0.002f;
                return;
            }
        }
        this.f4510j = 0.1f;
    }
}
