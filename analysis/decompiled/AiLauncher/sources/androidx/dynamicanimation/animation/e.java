package androidx.dynamicanimation.animation;

import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.N;
import androidx.dynamicanimation.animation.b;
import androidx.dynamicanimation.animation.e;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class e<T extends e<T>> implements b.c {

    /* renamed from: a, reason: collision with root package name */
    public float f13703a;

    /* renamed from: b, reason: collision with root package name */
    public float f13704b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13705c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f13706d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.f f13707e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13708f;

    /* renamed from: g, reason: collision with root package name */
    public float f13709g;

    /* renamed from: h, reason: collision with root package name */
    public float f13710h;

    /* renamed from: i, reason: collision with root package name */
    public long f13711i;

    /* renamed from: j, reason: collision with root package name */
    public float f13712j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList<q> f13713k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList<r> f13714l;

    /* renamed from: m, reason: collision with root package name */
    public androidx.dynamicanimation.animation.b f13715m;

    /* renamed from: n, reason: collision with root package name */
    public static final s f13690n = new g("translationX");

    /* renamed from: o, reason: collision with root package name */
    public static final s f13691o = new h("translationY");

    /* renamed from: p, reason: collision with root package name */
    public static final s f13692p = new i("translationZ");

    /* renamed from: q, reason: collision with root package name */
    public static final s f13693q = new j("scaleX");

    /* renamed from: r, reason: collision with root package name */
    public static final s f13694r = new k("scaleY");

    /* renamed from: s, reason: collision with root package name */
    public static final s f13695s = new l("rotation");

    /* renamed from: t, reason: collision with root package name */
    public static final s f13696t = new m("rotationX");

    /* renamed from: u, reason: collision with root package name */
    public static final s f13697u = new n("rotationY");

    /* renamed from: v, reason: collision with root package name */
    public static final s f13698v = new o("x");

    /* renamed from: w, reason: collision with root package name */
    public static final s f13699w = new a("y");

    /* renamed from: x, reason: collision with root package name */
    public static final s f13700x = new b("z");

    /* renamed from: y, reason: collision with root package name */
    public static final s f13701y = new c(ConstConfig.KEY_VIEW_ALPHA_PROPERTY);

    /* renamed from: z, reason: collision with root package name */
    public static final s f13702z = new d("scrollX");

    /* renamed from: A, reason: collision with root package name */
    public static final s f13689A = new C0166e("scrollY");

    public class a extends s {
        public a(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setY(f10);
        }
    }

    public class b extends s {
        public b(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return N.I(view);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            N.F0(view, f10);
        }
    }

    public class c extends s {
        public c(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setAlpha(f10);
        }
    }

    public class d extends s {
        public d(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setScrollX((int) f10);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.e$e, reason: collision with other inner class name */
    public class C0166e extends s {
        public C0166e(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setScrollY((int) f10);
        }
    }

    public class f extends androidx.dynamicanimation.animation.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.dynamicanimation.animation.g f13716a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, androidx.dynamicanimation.animation.g gVar) {
            super(str);
            this.f13716a = gVar;
        }

        @Override // androidx.dynamicanimation.animation.f
        public float getValue(Object obj) {
            return this.f13716a.a();
        }

        @Override // androidx.dynamicanimation.animation.f
        public void setValue(Object obj, float f10) {
            this.f13716a.b(f10);
        }
    }

    public class g extends s {
        public g(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setTranslationX(f10);
        }
    }

    public class h extends s {
        public h(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setTranslationY(f10);
        }
    }

    public class i extends s {
        public i(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return N.F(view);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            N.D0(view, f10);
        }
    }

    public class j extends s {
        public j(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setScaleX(f10);
        }
    }

    public class k extends s {
        public k(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setScaleY(f10);
        }
    }

    public class l extends s {
        public l(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setRotation(f10);
        }
    }

    public class m extends s {
        public m(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setRotationX(f10);
        }
    }

    public class n extends s {
        public n(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setRotationY(f10);
        }
    }

    public class o extends s {
        public o(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float f10) {
            view.setX(f10);
        }
    }

    public static class p {

        /* renamed from: a, reason: collision with root package name */
        public float f13718a;

        /* renamed from: b, reason: collision with root package name */
        public float f13719b;
    }

    public interface q {
        void a(e eVar, boolean z10, float f10, float f11);
    }

    public interface r {
        void b(e eVar, float f10, float f11);
    }

    public static abstract class s extends androidx.dynamicanimation.animation.f<View> {
        public /* synthetic */ s(String str, g gVar) {
            this(str);
        }

        public s(String str) {
            super(str);
        }
    }

    public e(androidx.dynamicanimation.animation.g gVar) {
        this.f13703a = 0.0f;
        this.f13704b = Float.MAX_VALUE;
        this.f13705c = false;
        this.f13708f = false;
        this.f13709g = Float.MAX_VALUE;
        this.f13710h = -Float.MAX_VALUE;
        this.f13711i = 0L;
        this.f13713k = new ArrayList<>();
        this.f13714l = new ArrayList<>();
        this.f13706d = null;
        this.f13707e = new f("FloatValueHolder", gVar);
        this.f13712j = 1.0f;
    }

    public static <T> void k(ArrayList<T> arrayList, T t10) {
        int iIndexOf = arrayList.indexOf(t10);
        if (iIndexOf >= 0) {
            arrayList.set(iIndexOf, null);
        }
    }

    public static <T> void l(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // androidx.dynamicanimation.animation.b.c
    public boolean a(long j10) {
        long j11 = this.f13711i;
        if (j11 == 0) {
            this.f13711i = j10;
            p(this.f13704b);
            return false;
        }
        long j12 = j10 - j11;
        this.f13711i = j10;
        float fG = f().g();
        boolean zV = v(fG == 0.0f ? 2147483647L : (long) (j12 / fG));
        float fMin = Math.min(this.f13704b, this.f13709g);
        this.f13704b = fMin;
        float fMax = Math.max(fMin, this.f13710h);
        this.f13704b = fMax;
        p(fMax);
        if (zV) {
            e(false);
        }
        return zV;
    }

    public T b(q qVar) {
        if (!this.f13713k.contains(qVar)) {
            this.f13713k.add(qVar);
        }
        return this;
    }

    public T c(r rVar) {
        if (i()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.f13714l.contains(rVar)) {
            this.f13714l.add(rVar);
        }
        return this;
    }

    public void d() {
        if (!f().j()) {
            throw new AndroidRuntimeException("Animations may only be canceled from the same thread as the animation handler");
        }
        if (this.f13708f) {
            e(true);
        }
    }

    public final void e(boolean z10) {
        this.f13708f = false;
        f().k(this);
        this.f13711i = 0L;
        this.f13705c = false;
        for (int i10 = 0; i10 < this.f13713k.size(); i10++) {
            if (this.f13713k.get(i10) != null) {
                this.f13713k.get(i10).a(this, z10, this.f13704b, this.f13703a);
            }
        }
        l(this.f13713k);
    }

    public androidx.dynamicanimation.animation.b f() {
        androidx.dynamicanimation.animation.b bVar = this.f13715m;
        return bVar != null ? bVar : androidx.dynamicanimation.animation.b.h();
    }

    public final float g() {
        return this.f13707e.getValue(this.f13706d);
    }

    public float h() {
        return this.f13712j * 0.75f;
    }

    public boolean i() {
        return this.f13708f;
    }

    public void j(q qVar) {
        k(this.f13713k, qVar);
    }

    public T m(float f10) {
        this.f13709g = f10;
        return this;
    }

    public T n(float f10) {
        this.f13710h = f10;
        return this;
    }

    public T o(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.f13712j = f10;
        s(f10 * 0.75f);
        return this;
    }

    public void p(float f10) {
        this.f13707e.setValue(this.f13706d, f10);
        for (int i10 = 0; i10 < this.f13714l.size(); i10++) {
            if (this.f13714l.get(i10) != null) {
                this.f13714l.get(i10).b(this, this.f13704b, this.f13703a);
            }
        }
        l(this.f13714l);
    }

    public T q(float f10) {
        this.f13704b = f10;
        this.f13705c = true;
        return this;
    }

    public T r(float f10) {
        this.f13703a = f10;
        return this;
    }

    public abstract void s(float f10);

    public void t() {
        if (!f().j()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f13708f) {
            return;
        }
        u();
    }

    public final void u() {
        if (this.f13708f) {
            return;
        }
        this.f13708f = true;
        if (!this.f13705c) {
            this.f13704b = g();
        }
        float f10 = this.f13704b;
        if (f10 > this.f13709g || f10 < this.f13710h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        f().d(this, 0L);
    }

    public abstract boolean v(long j10);

    public <K> e(K k10, androidx.dynamicanimation.animation.f<K> fVar) {
        this.f13703a = 0.0f;
        this.f13704b = Float.MAX_VALUE;
        this.f13705c = false;
        this.f13708f = false;
        this.f13709g = Float.MAX_VALUE;
        this.f13710h = -Float.MAX_VALUE;
        this.f13711i = 0L;
        this.f13713k = new ArrayList<>();
        this.f13714l = new ArrayList<>();
        this.f13706d = k10;
        this.f13707e = fVar;
        if (fVar != f13695s && fVar != f13696t && fVar != f13697u) {
            if (fVar == f13701y) {
                this.f13712j = 0.00390625f;
                return;
            } else if (fVar != f13693q && fVar != f13694r) {
                this.f13712j = 1.0f;
                return;
            } else {
                this.f13712j = 0.002f;
                return;
            }
        }
        this.f13712j = 0.1f;
    }
}
