package t1;

import a1.C0418k;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* loaded from: classes.dex */
public class l {

    /* renamed from: m, reason: collision with root package name */
    public static final InterfaceC1111d f22385m = new j(0.5f);

    /* renamed from: a, reason: collision with root package name */
    C1112e f22386a;

    /* renamed from: b, reason: collision with root package name */
    C1112e f22387b;

    /* renamed from: c, reason: collision with root package name */
    C1112e f22388c;

    /* renamed from: d, reason: collision with root package name */
    C1112e f22389d;

    /* renamed from: e, reason: collision with root package name */
    InterfaceC1111d f22390e;

    /* renamed from: f, reason: collision with root package name */
    InterfaceC1111d f22391f;

    /* renamed from: g, reason: collision with root package name */
    InterfaceC1111d f22392g;

    /* renamed from: h, reason: collision with root package name */
    InterfaceC1111d f22393h;

    /* renamed from: i, reason: collision with root package name */
    C1114g f22394i;

    /* renamed from: j, reason: collision with root package name */
    C1114g f22395j;

    /* renamed from: k, reason: collision with root package name */
    C1114g f22396k;

    /* renamed from: l, reason: collision with root package name */
    C1114g f22397l;

    public interface c {
        InterfaceC1111d a(InterfaceC1111d interfaceC1111d);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i5, int i6) {
        return c(context, i5, i6, 0);
    }

    private static b c(Context context, int i5, int i6, int i7) {
        return d(context, i5, i6, new C1108a(i7));
    }

    private static b d(Context context, int i5, int i6, InterfaceC1111d interfaceC1111d) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i5);
        if (i6 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i6, true);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(C0418k.f7077X3);
        try {
            int i7 = typedArrayObtainStyledAttributes.getInt(C0418k.f7083Y3, 0);
            int i8 = typedArrayObtainStyledAttributes.getInt(C0418k.f7103b4, i7);
            int i9 = typedArrayObtainStyledAttributes.getInt(C0418k.f7110c4, i7);
            int i10 = typedArrayObtainStyledAttributes.getInt(C0418k.f7096a4, i7);
            int i11 = typedArrayObtainStyledAttributes.getInt(C0418k.f7089Z3, i7);
            InterfaceC1111d interfaceC1111dM = m(typedArrayObtainStyledAttributes, C0418k.f7117d4, interfaceC1111d);
            InterfaceC1111d interfaceC1111dM2 = m(typedArrayObtainStyledAttributes, C0418k.f7137g4, interfaceC1111dM);
            InterfaceC1111d interfaceC1111dM3 = m(typedArrayObtainStyledAttributes, C0418k.f7143h4, interfaceC1111dM);
            InterfaceC1111d interfaceC1111dM4 = m(typedArrayObtainStyledAttributes, C0418k.f7131f4, interfaceC1111dM);
            return new b().A(i8, interfaceC1111dM2).E(i9, interfaceC1111dM3).w(i10, interfaceC1111dM4).s(i11, m(typedArrayObtainStyledAttributes, C0418k.f7124e4, interfaceC1111dM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i5, int i6) {
        return f(context, attributeSet, i5, i6, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i5, int i6, int i7) {
        return g(context, attributeSet, i5, i6, new C1108a(i7));
    }

    public static b g(Context context, AttributeSet attributeSet, int i5, int i6, InterfaceC1111d interfaceC1111d) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7178n3, i5, i6);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(C0418k.f7184o3, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(C0418k.f7190p3, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, interfaceC1111d);
    }

    public static InterfaceC1111d m(TypedArray typedArray, int i5, InterfaceC1111d interfaceC1111d) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i5);
        if (typedValuePeekValue != null) {
            int i6 = typedValuePeekValue.type;
            if (i6 == 5) {
                return new C1108a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i6 == 6) {
                return new j(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return interfaceC1111d;
    }

    public C1114g h() {
        return this.f22396k;
    }

    public C1112e i() {
        return this.f22389d;
    }

    public InterfaceC1111d j() {
        return this.f22393h;
    }

    public C1112e k() {
        return this.f22388c;
    }

    public InterfaceC1111d l() {
        return this.f22392g;
    }

    public C1114g n() {
        return this.f22397l;
    }

    public C1114g o() {
        return this.f22395j;
    }

    public C1114g p() {
        return this.f22394i;
    }

    public C1112e q() {
        return this.f22386a;
    }

    public InterfaceC1111d r() {
        return this.f22390e;
    }

    public C1112e s() {
        return this.f22387b;
    }

    public InterfaceC1111d t() {
        return this.f22391f;
    }

    public String toString() {
        return "[" + r() + ", " + t() + ", " + l() + ", " + j() + "]";
    }

    public boolean u() {
        return (this.f22387b instanceof k) && (this.f22386a instanceof k) && (this.f22388c instanceof k) && (this.f22389d instanceof k);
    }

    public boolean v(RectF rectF) {
        boolean z5 = this.f22397l.getClass().equals(C1114g.class) && this.f22395j.getClass().equals(C1114g.class) && this.f22394i.getClass().equals(C1114g.class) && this.f22396k.getClass().equals(C1114g.class);
        float fA = this.f22390e.a(rectF);
        return z5 && ((this.f22391f.a(rectF) > fA ? 1 : (this.f22391f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f22393h.a(rectF) > fA ? 1 : (this.f22393h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f22392g.a(rectF) > fA ? 1 : (this.f22392g.a(rectF) == fA ? 0 : -1)) == 0) && u();
    }

    public b w() {
        return new b(this);
    }

    public l x(float f5) {
        return w().o(f5).m();
    }

    public l y(InterfaceC1111d interfaceC1111d) {
        return w().p(interfaceC1111d).m();
    }

    public l z(c cVar) {
        return w().D(cVar.a(r())).H(cVar.a(t())).v(cVar.a(j())).z(cVar.a(l())).m();
    }

    private l(b bVar) {
        this.f22386a = bVar.f22398a;
        this.f22387b = bVar.f22399b;
        this.f22388c = bVar.f22400c;
        this.f22389d = bVar.f22401d;
        this.f22390e = bVar.f22402e;
        this.f22391f = bVar.f22403f;
        this.f22392g = bVar.f22404g;
        this.f22393h = bVar.f22405h;
        this.f22394i = bVar.f22406i;
        this.f22395j = bVar.f22407j;
        this.f22396k = bVar.f22408k;
        this.f22397l = bVar.f22409l;
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private C1112e f22398a;

        /* renamed from: b, reason: collision with root package name */
        private C1112e f22399b;

        /* renamed from: c, reason: collision with root package name */
        private C1112e f22400c;

        /* renamed from: d, reason: collision with root package name */
        private C1112e f22401d;

        /* renamed from: e, reason: collision with root package name */
        private InterfaceC1111d f22402e;

        /* renamed from: f, reason: collision with root package name */
        private InterfaceC1111d f22403f;

        /* renamed from: g, reason: collision with root package name */
        private InterfaceC1111d f22404g;

        /* renamed from: h, reason: collision with root package name */
        private InterfaceC1111d f22405h;

        /* renamed from: i, reason: collision with root package name */
        private C1114g f22406i;

        /* renamed from: j, reason: collision with root package name */
        private C1114g f22407j;

        /* renamed from: k, reason: collision with root package name */
        private C1114g f22408k;

        /* renamed from: l, reason: collision with root package name */
        private C1114g f22409l;

        public b() {
            this.f22398a = C1116i.b();
            this.f22399b = C1116i.b();
            this.f22400c = C1116i.b();
            this.f22401d = C1116i.b();
            this.f22402e = new C1108a(0.0f);
            this.f22403f = new C1108a(0.0f);
            this.f22404g = new C1108a(0.0f);
            this.f22405h = new C1108a(0.0f);
            this.f22406i = C1116i.c();
            this.f22407j = C1116i.c();
            this.f22408k = C1116i.c();
            this.f22409l = C1116i.c();
        }

        private static float n(C1112e c1112e) {
            if (c1112e instanceof k) {
                return ((k) c1112e).f22384a;
            }
            if (c1112e instanceof C1113f) {
                return ((C1113f) c1112e).f22321a;
            }
            return -1.0f;
        }

        public b A(int i5, InterfaceC1111d interfaceC1111d) {
            return B(C1116i.a(i5)).D(interfaceC1111d);
        }

        public b B(C1112e c1112e) {
            this.f22398a = c1112e;
            float fN = n(c1112e);
            if (fN != -1.0f) {
                C(fN);
            }
            return this;
        }

        public b C(float f5) {
            this.f22402e = new C1108a(f5);
            return this;
        }

        public b D(InterfaceC1111d interfaceC1111d) {
            this.f22402e = interfaceC1111d;
            return this;
        }

        public b E(int i5, InterfaceC1111d interfaceC1111d) {
            return F(C1116i.a(i5)).H(interfaceC1111d);
        }

        public b F(C1112e c1112e) {
            this.f22399b = c1112e;
            float fN = n(c1112e);
            if (fN != -1.0f) {
                G(fN);
            }
            return this;
        }

        public b G(float f5) {
            this.f22403f = new C1108a(f5);
            return this;
        }

        public b H(InterfaceC1111d interfaceC1111d) {
            this.f22403f = interfaceC1111d;
            return this;
        }

        public l m() {
            return new l(this);
        }

        public b o(float f5) {
            return C(f5).G(f5).y(f5).u(f5);
        }

        public b p(InterfaceC1111d interfaceC1111d) {
            return D(interfaceC1111d).H(interfaceC1111d).z(interfaceC1111d).v(interfaceC1111d);
        }

        public b q(int i5, float f5) {
            return r(C1116i.a(i5)).o(f5);
        }

        public b r(C1112e c1112e) {
            return B(c1112e).F(c1112e).x(c1112e).t(c1112e);
        }

        public b s(int i5, InterfaceC1111d interfaceC1111d) {
            return t(C1116i.a(i5)).v(interfaceC1111d);
        }

        public b t(C1112e c1112e) {
            this.f22401d = c1112e;
            float fN = n(c1112e);
            if (fN != -1.0f) {
                u(fN);
            }
            return this;
        }

        public b u(float f5) {
            this.f22405h = new C1108a(f5);
            return this;
        }

        public b v(InterfaceC1111d interfaceC1111d) {
            this.f22405h = interfaceC1111d;
            return this;
        }

        public b w(int i5, InterfaceC1111d interfaceC1111d) {
            return x(C1116i.a(i5)).z(interfaceC1111d);
        }

        public b x(C1112e c1112e) {
            this.f22400c = c1112e;
            float fN = n(c1112e);
            if (fN != -1.0f) {
                y(fN);
            }
            return this;
        }

        public b y(float f5) {
            this.f22404g = new C1108a(f5);
            return this;
        }

        public b z(InterfaceC1111d interfaceC1111d) {
            this.f22404g = interfaceC1111d;
            return this;
        }

        public b(l lVar) {
            this.f22398a = C1116i.b();
            this.f22399b = C1116i.b();
            this.f22400c = C1116i.b();
            this.f22401d = C1116i.b();
            this.f22402e = new C1108a(0.0f);
            this.f22403f = new C1108a(0.0f);
            this.f22404g = new C1108a(0.0f);
            this.f22405h = new C1108a(0.0f);
            this.f22406i = C1116i.c();
            this.f22407j = C1116i.c();
            this.f22408k = C1116i.c();
            this.f22409l = C1116i.c();
            this.f22398a = lVar.f22386a;
            this.f22399b = lVar.f22387b;
            this.f22400c = lVar.f22388c;
            this.f22401d = lVar.f22389d;
            this.f22402e = lVar.f22390e;
            this.f22403f = lVar.f22391f;
            this.f22404g = lVar.f22392g;
            this.f22405h = lVar.f22393h;
            this.f22406i = lVar.f22394i;
            this.f22407j = lVar.f22395j;
            this.f22408k = lVar.f22396k;
            this.f22409l = lVar.f22397l;
        }
    }

    public l() {
        this.f22386a = C1116i.b();
        this.f22387b = C1116i.b();
        this.f22388c = C1116i.b();
        this.f22389d = C1116i.b();
        this.f22390e = new C1108a(0.0f);
        this.f22391f = new C1108a(0.0f);
        this.f22392g = new C1108a(0.0f);
        this.f22393h = new C1108a(0.0f);
        this.f22394i = C1116i.c();
        this.f22395j = C1116i.c();
        this.f22396k = C1116i.c();
        this.f22397l = C1116i.c();
    }
}
