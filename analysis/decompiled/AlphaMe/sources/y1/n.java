package y1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.stepos.alphame.utils.Property;
import m1.AbstractC0769a;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public B0.f f16272a = new l();

    /* renamed from: b, reason: collision with root package name */
    public B0.f f16273b = new l();

    /* renamed from: c, reason: collision with root package name */
    public B0.f f16274c = new l();

    /* renamed from: d, reason: collision with root package name */
    public B0.f f16275d = new l();

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0990d f16276e = new C0987a(Property.DEFAULT_FLOAT_VALUE);

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC0990d f16277f = new C0987a(Property.DEFAULT_FLOAT_VALUE);

    /* renamed from: g, reason: collision with root package name */
    public InterfaceC0990d f16278g = new C0987a(Property.DEFAULT_FLOAT_VALUE);

    /* renamed from: h, reason: collision with root package name */
    public InterfaceC0990d f16279h = new C0987a(Property.DEFAULT_FLOAT_VALUE);

    /* renamed from: i, reason: collision with root package name */
    public f f16280i = B0.f.n();

    /* renamed from: j, reason: collision with root package name */
    public f f16281j = B0.f.n();

    /* renamed from: k, reason: collision with root package name */
    public f f16282k = B0.f.n();

    /* renamed from: l, reason: collision with root package name */
    public f f16283l = B0.f.n();

    public static m a(Context context, int i4, int i5, C0987a c0987a) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i4);
        if (i5 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i5, true);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(AbstractC0769a.f13528C);
        try {
            int i6 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i7 = typedArrayObtainStyledAttributes.getInt(3, i6);
            int i8 = typedArrayObtainStyledAttributes.getInt(4, i6);
            int i9 = typedArrayObtainStyledAttributes.getInt(2, i6);
            int i10 = typedArrayObtainStyledAttributes.getInt(1, i6);
            InterfaceC0990d interfaceC0990dC = c(typedArrayObtainStyledAttributes, 5, c0987a);
            InterfaceC0990d interfaceC0990dC2 = c(typedArrayObtainStyledAttributes, 8, interfaceC0990dC);
            InterfaceC0990d interfaceC0990dC3 = c(typedArrayObtainStyledAttributes, 9, interfaceC0990dC);
            InterfaceC0990d interfaceC0990dC4 = c(typedArrayObtainStyledAttributes, 7, interfaceC0990dC);
            InterfaceC0990d interfaceC0990dC5 = c(typedArrayObtainStyledAttributes, 6, interfaceC0990dC);
            m mVar = new m();
            B0.f fVarM = B0.f.m(i7);
            mVar.f16260a = fVarM;
            m.b(fVarM);
            mVar.f16264e = interfaceC0990dC2;
            B0.f fVarM2 = B0.f.m(i8);
            mVar.f16261b = fVarM2;
            m.b(fVarM2);
            mVar.f16265f = interfaceC0990dC3;
            B0.f fVarM3 = B0.f.m(i9);
            mVar.f16262c = fVarM3;
            m.b(fVarM3);
            mVar.f16266g = interfaceC0990dC4;
            B0.f fVarM4 = B0.f.m(i10);
            mVar.f16263d = fVarM4;
            m.b(fVarM4);
            mVar.f16267h = interfaceC0990dC5;
            return mVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static m b(Context context, AttributeSet attributeSet, int i4, int i5) {
        C0987a c0987a = new C0987a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13556v, i4, i5);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, c0987a);
    }

    public static InterfaceC0990d c(TypedArray typedArray, int i4, InterfaceC0990d interfaceC0990d) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i4);
        if (typedValuePeekValue == null) {
            return interfaceC0990d;
        }
        int i5 = typedValuePeekValue.type;
        return i5 == 5 ? new C0987a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i5 == 6 ? new k(typedValuePeekValue.getFraction(1.0f, 1.0f)) : interfaceC0990d;
    }

    public final boolean d() {
        return (this.f16273b instanceof l) && (this.f16272a instanceof l) && (this.f16274c instanceof l) && (this.f16275d instanceof l);
    }

    public final boolean e(RectF rectF) {
        boolean z4 = this.f16283l.getClass().equals(f.class) && this.f16281j.getClass().equals(f.class) && this.f16280i.getClass().equals(f.class) && this.f16282k.getClass().equals(f.class);
        float fA = this.f16276e.a(rectF);
        return z4 && ((this.f16277f.a(rectF) > fA ? 1 : (this.f16277f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f16279h.a(rectF) > fA ? 1 : (this.f16279h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f16278g.a(rectF) > fA ? 1 : (this.f16278g.a(rectF) == fA ? 0 : -1)) == 0) && d();
    }

    public final m f() {
        m mVar = new m();
        mVar.f16260a = new l();
        mVar.f16261b = new l();
        mVar.f16262c = new l();
        mVar.f16263d = new l();
        mVar.f16264e = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        mVar.f16265f = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        mVar.f16266g = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        mVar.f16267h = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        mVar.f16268i = B0.f.n();
        mVar.f16269j = B0.f.n();
        mVar.f16270k = B0.f.n();
        mVar.f16260a = this.f16272a;
        mVar.f16261b = this.f16273b;
        mVar.f16262c = this.f16274c;
        mVar.f16263d = this.f16275d;
        mVar.f16264e = this.f16276e;
        mVar.f16265f = this.f16277f;
        mVar.f16266g = this.f16278g;
        mVar.f16267h = this.f16279h;
        mVar.f16268i = this.f16280i;
        mVar.f16269j = this.f16281j;
        mVar.f16270k = this.f16282k;
        mVar.f16271l = this.f16283l;
        return mVar;
    }

    public final String toString() {
        return "[" + this.f16276e + ", " + this.f16277f + ", " + this.f16278g + ", " + this.f16279h + "]";
    }
}
