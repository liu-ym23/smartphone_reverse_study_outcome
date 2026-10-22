package Z2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$styleable;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: m, reason: collision with root package name */
    public static final d f7183m = new j(0.5f);

    /* renamed from: a, reason: collision with root package name */
    public e f7184a;

    /* renamed from: b, reason: collision with root package name */
    public e f7185b;

    /* renamed from: c, reason: collision with root package name */
    public e f7186c;

    /* renamed from: d, reason: collision with root package name */
    public e f7187d;

    /* renamed from: e, reason: collision with root package name */
    public d f7188e;

    /* renamed from: f, reason: collision with root package name */
    public d f7189f;

    /* renamed from: g, reason: collision with root package name */
    public d f7190g;

    /* renamed from: h, reason: collision with root package name */
    public d f7191h;

    /* renamed from: i, reason: collision with root package name */
    public g f7192i;

    /* renamed from: j, reason: collision with root package name */
    public g f7193j;

    /* renamed from: k, reason: collision with root package name */
    public g f7194k;

    /* renamed from: l, reason: collision with root package name */
    public g f7195l;

    public interface c {
        d a(d dVar);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i10, int i11) {
        return c(context, i10, i11, 0);
    }

    public static b c(Context context, int i10, int i11, int i12) {
        return d(context, i10, i11, new Z2.a(i12));
    }

    public static b d(Context context, int i10, int i11, d dVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        if (i11 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i11, true);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.ShapeAppearance);
        try {
            int i12 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i13 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i12);
            int i14 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i12);
            int i15 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i12);
            int i16 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i12);
            d dVarM = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, dVar);
            d dVarM2 = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, dVarM);
            d dVarM3 = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, dVarM);
            d dVarM4 = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, dVarM);
            return new b().A(i13, dVarM2).E(i14, dVarM3).w(i15, dVarM4).s(i16, m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, dVarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i10, int i11) {
        return f(context, attributeSet, i10, i11, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i10, int i11, int i12) {
        return g(context, attributeSet, i10, i11, new Z2.a(i12));
    }

    public static b g(Context context, AttributeSet attributeSet, int i10, int i11, d dVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, dVar);
    }

    public static d m(TypedArray typedArray, int i10, d dVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i10);
        if (typedValuePeekValue != null) {
            int i11 = typedValuePeekValue.type;
            if (i11 == 5) {
                return new Z2.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i11 == 6) {
                return new j(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return dVar;
    }

    public g h() {
        return this.f7194k;
    }

    public e i() {
        return this.f7187d;
    }

    public d j() {
        return this.f7191h;
    }

    public e k() {
        return this.f7186c;
    }

    public d l() {
        return this.f7190g;
    }

    public g n() {
        return this.f7195l;
    }

    public g o() {
        return this.f7193j;
    }

    public g p() {
        return this.f7192i;
    }

    public e q() {
        return this.f7184a;
    }

    public d r() {
        return this.f7188e;
    }

    public e s() {
        return this.f7185b;
    }

    public d t() {
        return this.f7189f;
    }

    public String toString() {
        return "[" + r() + ", " + t() + ", " + l() + ", " + j() + "]";
    }

    public boolean u() {
        return (this.f7185b instanceof k) && (this.f7184a instanceof k) && (this.f7186c instanceof k) && (this.f7187d instanceof k);
    }

    public boolean v(RectF rectF) {
        boolean z10 = this.f7195l.getClass().equals(g.class) && this.f7193j.getClass().equals(g.class) && this.f7192i.getClass().equals(g.class) && this.f7194k.getClass().equals(g.class);
        float fA = this.f7188e.a(rectF);
        return z10 && ((this.f7189f.a(rectF) > fA ? 1 : (this.f7189f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f7191h.a(rectF) > fA ? 1 : (this.f7191h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f7190g.a(rectF) > fA ? 1 : (this.f7190g.a(rectF) == fA ? 0 : -1)) == 0) && u();
    }

    public b w() {
        return new b(this);
    }

    public l x(float f10) {
        return w().o(f10).m();
    }

    public l y(d dVar) {
        return w().p(dVar).m();
    }

    public l z(c cVar) {
        return w().D(cVar.a(r())).H(cVar.a(t())).v(cVar.a(j())).z(cVar.a(l())).m();
    }

    public l(b bVar) {
        this.f7184a = bVar.f7196a;
        this.f7185b = bVar.f7197b;
        this.f7186c = bVar.f7198c;
        this.f7187d = bVar.f7199d;
        this.f7188e = bVar.f7200e;
        this.f7189f = bVar.f7201f;
        this.f7190g = bVar.f7202g;
        this.f7191h = bVar.f7203h;
        this.f7192i = bVar.f7204i;
        this.f7193j = bVar.f7205j;
        this.f7194k = bVar.f7206k;
        this.f7195l = bVar.f7207l;
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public e f7196a;

        /* renamed from: b, reason: collision with root package name */
        public e f7197b;

        /* renamed from: c, reason: collision with root package name */
        public e f7198c;

        /* renamed from: d, reason: collision with root package name */
        public e f7199d;

        /* renamed from: e, reason: collision with root package name */
        public d f7200e;

        /* renamed from: f, reason: collision with root package name */
        public d f7201f;

        /* renamed from: g, reason: collision with root package name */
        public d f7202g;

        /* renamed from: h, reason: collision with root package name */
        public d f7203h;

        /* renamed from: i, reason: collision with root package name */
        public g f7204i;

        /* renamed from: j, reason: collision with root package name */
        public g f7205j;

        /* renamed from: k, reason: collision with root package name */
        public g f7206k;

        /* renamed from: l, reason: collision with root package name */
        public g f7207l;

        public b() {
            this.f7196a = i.b();
            this.f7197b = i.b();
            this.f7198c = i.b();
            this.f7199d = i.b();
            this.f7200e = new Z2.a(0.0f);
            this.f7201f = new Z2.a(0.0f);
            this.f7202g = new Z2.a(0.0f);
            this.f7203h = new Z2.a(0.0f);
            this.f7204i = i.c();
            this.f7205j = i.c();
            this.f7206k = i.c();
            this.f7207l = i.c();
        }

        public static float n(e eVar) {
            if (eVar instanceof k) {
                return ((k) eVar).f7182a;
            }
            if (eVar instanceof f) {
                return ((f) eVar).f7119a;
            }
            return -1.0f;
        }

        public b A(int i10, d dVar) {
            return B(i.a(i10)).D(dVar);
        }

        public b B(e eVar) {
            this.f7196a = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                C(fN);
            }
            return this;
        }

        public b C(float f10) {
            this.f7200e = new Z2.a(f10);
            return this;
        }

        public b D(d dVar) {
            this.f7200e = dVar;
            return this;
        }

        public b E(int i10, d dVar) {
            return F(i.a(i10)).H(dVar);
        }

        public b F(e eVar) {
            this.f7197b = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                G(fN);
            }
            return this;
        }

        public b G(float f10) {
            this.f7201f = new Z2.a(f10);
            return this;
        }

        public b H(d dVar) {
            this.f7201f = dVar;
            return this;
        }

        public l m() {
            return new l(this);
        }

        public b o(float f10) {
            return C(f10).G(f10).y(f10).u(f10);
        }

        public b p(d dVar) {
            return D(dVar).H(dVar).z(dVar).v(dVar);
        }

        public b q(int i10, float f10) {
            return r(i.a(i10)).o(f10);
        }

        public b r(e eVar) {
            return B(eVar).F(eVar).x(eVar).t(eVar);
        }

        public b s(int i10, d dVar) {
            return t(i.a(i10)).v(dVar);
        }

        public b t(e eVar) {
            this.f7199d = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                u(fN);
            }
            return this;
        }

        public b u(float f10) {
            this.f7203h = new Z2.a(f10);
            return this;
        }

        public b v(d dVar) {
            this.f7203h = dVar;
            return this;
        }

        public b w(int i10, d dVar) {
            return x(i.a(i10)).z(dVar);
        }

        public b x(e eVar) {
            this.f7198c = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                y(fN);
            }
            return this;
        }

        public b y(float f10) {
            this.f7202g = new Z2.a(f10);
            return this;
        }

        public b z(d dVar) {
            this.f7202g = dVar;
            return this;
        }

        public b(l lVar) {
            this.f7196a = i.b();
            this.f7197b = i.b();
            this.f7198c = i.b();
            this.f7199d = i.b();
            this.f7200e = new Z2.a(0.0f);
            this.f7201f = new Z2.a(0.0f);
            this.f7202g = new Z2.a(0.0f);
            this.f7203h = new Z2.a(0.0f);
            this.f7204i = i.c();
            this.f7205j = i.c();
            this.f7206k = i.c();
            this.f7207l = i.c();
            this.f7196a = lVar.f7184a;
            this.f7197b = lVar.f7185b;
            this.f7198c = lVar.f7186c;
            this.f7199d = lVar.f7187d;
            this.f7200e = lVar.f7188e;
            this.f7201f = lVar.f7189f;
            this.f7202g = lVar.f7190g;
            this.f7203h = lVar.f7191h;
            this.f7204i = lVar.f7192i;
            this.f7205j = lVar.f7193j;
            this.f7206k = lVar.f7194k;
            this.f7207l = lVar.f7195l;
        }
    }

    public l() {
        this.f7184a = i.b();
        this.f7185b = i.b();
        this.f7186c = i.b();
        this.f7187d = i.b();
        this.f7188e = new Z2.a(0.0f);
        this.f7189f = new Z2.a(0.0f);
        this.f7190g = new Z2.a(0.0f);
        this.f7191h = new Z2.a(0.0f);
        this.f7192i = i.c();
        this.f7193j = i.c();
        this.f7194k = i.c();
        this.f7195l = i.c();
    }
}
