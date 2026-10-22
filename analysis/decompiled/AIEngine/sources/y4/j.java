package y4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public xb.a f14062a = new i();

    /* renamed from: b, reason: collision with root package name */
    public xb.a f14063b = new i();

    /* renamed from: c, reason: collision with root package name */
    public xb.a f14064c = new i();

    /* renamed from: d, reason: collision with root package name */
    public xb.a f14065d = new i();

    /* renamed from: e, reason: collision with root package name */
    public d f14066e = new y4.a(0.0f);

    /* renamed from: f, reason: collision with root package name */
    public d f14067f = new y4.a(0.0f);

    /* renamed from: g, reason: collision with root package name */
    public d f14068g = new y4.a(0.0f);
    public d h = new y4.a(0.0f);

    /* renamed from: i, reason: collision with root package name */
    public f f14069i = new f();

    /* renamed from: j, reason: collision with root package name */
    public f f14070j = new f();

    /* renamed from: k, reason: collision with root package name */
    public f f14071k = new f();

    /* renamed from: l, reason: collision with root package name */
    public f f14072l = new f();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public xb.a f14073a = new i();

        /* renamed from: b, reason: collision with root package name */
        public xb.a f14074b = new i();

        /* renamed from: c, reason: collision with root package name */
        public xb.a f14075c = new i();

        /* renamed from: d, reason: collision with root package name */
        public xb.a f14076d = new i();

        /* renamed from: e, reason: collision with root package name */
        public d f14077e = new y4.a(0.0f);

        /* renamed from: f, reason: collision with root package name */
        public d f14078f = new y4.a(0.0f);

        /* renamed from: g, reason: collision with root package name */
        public d f14079g = new y4.a(0.0f);
        public d h = new y4.a(0.0f);

        /* renamed from: i, reason: collision with root package name */
        public f f14080i = new f();

        /* renamed from: j, reason: collision with root package name */
        public f f14081j = new f();

        /* renamed from: k, reason: collision with root package name */
        public f f14082k = new f();

        /* renamed from: l, reason: collision with root package name */
        public f f14083l = new f();

        public final j a() {
            j jVar = new j();
            jVar.f14062a = this.f14073a;
            jVar.f14063b = this.f14074b;
            jVar.f14064c = this.f14075c;
            jVar.f14065d = this.f14076d;
            jVar.f14066e = this.f14077e;
            jVar.f14067f = this.f14078f;
            jVar.f14068g = this.f14079g;
            jVar.h = this.h;
            jVar.f14069i = this.f14080i;
            jVar.f14070j = this.f14081j;
            jVar.f14071k = this.f14082k;
            jVar.f14072l = this.f14083l;
            return jVar;
        }

        public final void b(float f8) {
            e(f8);
            f(f8);
            d(f8);
            c(f8);
        }

        public final void c(float f8) {
            this.h = new y4.a(f8);
        }

        public final void d(float f8) {
            this.f14079g = new y4.a(f8);
        }

        public final void e(float f8) {
            this.f14077e = new y4.a(f8);
        }

        public final void f(float f8) {
            this.f14078f = new y4.a(f8);
        }
    }

    public static a a(Context context, int i10, int i11, y4.a aVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        if (i11 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i11, true);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(k4.a.D);
        try {
            int i12 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i13 = typedArrayObtainStyledAttributes.getInt(3, i12);
            int i14 = typedArrayObtainStyledAttributes.getInt(4, i12);
            int i15 = typedArrayObtainStyledAttributes.getInt(2, i12);
            int i16 = typedArrayObtainStyledAttributes.getInt(1, i12);
            d dVarC = c(typedArrayObtainStyledAttributes, 5, aVar);
            d dVarC2 = c(typedArrayObtainStyledAttributes, 8, dVarC);
            d dVarC3 = c(typedArrayObtainStyledAttributes, 9, dVarC);
            d dVarC4 = c(typedArrayObtainStyledAttributes, 7, dVarC);
            d dVarC5 = c(typedArrayObtainStyledAttributes, 6, dVarC);
            a aVar2 = new a();
            aVar2.f14073a = xb.a.b(i13);
            aVar2.f14077e = dVarC2;
            aVar2.f14074b = xb.a.b(i14);
            aVar2.f14078f = dVarC3;
            aVar2.f14075c = xb.a.b(i15);
            aVar2.f14079g = dVarC4;
            aVar2.f14076d = xb.a.b(i16);
            aVar2.h = dVarC5;
            return aVar2;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static a b(Context context, AttributeSet attributeSet, int i10, int i11) {
        y4.a aVar = new y4.a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k4.a.f9916v, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static d c(TypedArray typedArray, int i10, d dVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i10);
        if (typedValuePeekValue != null) {
            int i11 = typedValuePeekValue.type;
            if (i11 == 5) {
                return new y4.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i11 == 6) {
                return new h(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return dVar;
    }

    public final boolean d() {
        return (this.f14063b instanceof i) && (this.f14062a instanceof i) && (this.f14064c instanceof i) && (this.f14065d instanceof i);
    }

    public final boolean e(RectF rectF) {
        boolean z = this.f14072l.getClass().equals(f.class) && this.f14070j.getClass().equals(f.class) && this.f14069i.getClass().equals(f.class) && this.f14071k.getClass().equals(f.class);
        float fA = this.f14066e.a(rectF);
        return z && ((this.f14067f.a(rectF) > fA ? 1 : (this.f14067f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f14068g.a(rectF) > fA ? 1 : (this.f14068g.a(rectF) == fA ? 0 : -1)) == 0) && d();
    }

    public final a f() {
        a aVar = new a();
        aVar.f14073a = new i();
        aVar.f14074b = new i();
        aVar.f14075c = new i();
        aVar.f14076d = new i();
        aVar.f14077e = new y4.a(0.0f);
        aVar.f14078f = new y4.a(0.0f);
        aVar.f14079g = new y4.a(0.0f);
        aVar.h = new y4.a(0.0f);
        aVar.f14080i = new f();
        aVar.f14081j = new f();
        aVar.f14082k = new f();
        new f();
        aVar.f14073a = this.f14062a;
        aVar.f14074b = this.f14063b;
        aVar.f14075c = this.f14064c;
        aVar.f14076d = this.f14065d;
        aVar.f14077e = this.f14066e;
        aVar.f14078f = this.f14067f;
        aVar.f14079g = this.f14068g;
        aVar.h = this.h;
        aVar.f14080i = this.f14069i;
        aVar.f14081j = this.f14070j;
        aVar.f14082k = this.f14071k;
        aVar.f14083l = this.f14072l;
        return aVar;
    }

    public final String toString() {
        return "[" + this.f14066e + ", " + this.f14067f + ", " + this.f14068g + ", " + this.h + "]";
    }
}
