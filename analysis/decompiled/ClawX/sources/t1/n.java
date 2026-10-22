package t1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public k4.v f5508a = new l();

    /* renamed from: b, reason: collision with root package name */
    public k4.v f5509b = new l();

    /* renamed from: c, reason: collision with root package name */
    public k4.v f5510c = new l();
    public k4.v d = new l();

    /* renamed from: e, reason: collision with root package name */
    public d f5511e = new a(0.0f);

    /* renamed from: f, reason: collision with root package name */
    public d f5512f = new a(0.0f);

    /* renamed from: g, reason: collision with root package name */
    public d f5513g = new a(0.0f);

    /* renamed from: h, reason: collision with root package name */
    public d f5514h = new a(0.0f);

    /* renamed from: i, reason: collision with root package name */
    public f f5515i;

    /* renamed from: j, reason: collision with root package name */
    public f f5516j;

    /* renamed from: k, reason: collision with root package name */
    public f f5517k;

    /* renamed from: l, reason: collision with root package name */
    public f f5518l;

    public n() {
        int i8 = 0;
        this.f5515i = new f(i8);
        this.f5516j = new f(i8);
        this.f5517k = new f(i8);
        this.f5518l = new f(i8);
    }

    public static m a(Context context, int i8, int i9, a aVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i8);
        if (i9 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i9, true);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(d1.a.f1777s);
        try {
            int i10 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i11 = typedArrayObtainStyledAttributes.getInt(3, i10);
            int i12 = typedArrayObtainStyledAttributes.getInt(4, i10);
            int i13 = typedArrayObtainStyledAttributes.getInt(2, i10);
            int i14 = typedArrayObtainStyledAttributes.getInt(1, i10);
            d dVarC = c(typedArrayObtainStyledAttributes, 5, aVar);
            d dVarC2 = c(typedArrayObtainStyledAttributes, 8, dVarC);
            d dVarC3 = c(typedArrayObtainStyledAttributes, 9, dVarC);
            d dVarC4 = c(typedArrayObtainStyledAttributes, 7, dVarC);
            d dVarC5 = c(typedArrayObtainStyledAttributes, 6, dVarC);
            m mVar = new m();
            mVar.f5497a = k4.z.m(i11);
            mVar.f5500e = dVarC2;
            mVar.f5498b = k4.z.m(i12);
            mVar.f5501f = dVarC3;
            mVar.f5499c = k4.z.m(i13);
            mVar.f5502g = dVarC4;
            mVar.d = k4.z.m(i14);
            mVar.f5503h = dVarC5;
            return mVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static m b(Context context, AttributeSet attributeSet, int i8, int i9) {
        a aVar = new a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d1.a.f1771m, i8, i9);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static d c(TypedArray typedArray, int i8, d dVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i8);
        if (typedValuePeekValue != null) {
            int i9 = typedValuePeekValue.type;
            if (i9 == 5) {
                return new a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i9 == 6) {
                return new k(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return dVar;
    }

    public final boolean d() {
        return (this.f5509b instanceof l) && (this.f5508a instanceof l) && (this.f5510c instanceof l) && (this.d instanceof l);
    }

    public final boolean e(RectF rectF) {
        boolean z = this.f5518l.getClass().equals(f.class) && this.f5516j.getClass().equals(f.class) && this.f5515i.getClass().equals(f.class) && this.f5517k.getClass().equals(f.class);
        float fA = this.f5511e.a(rectF);
        return z && ((this.f5512f.a(rectF) > fA ? 1 : (this.f5512f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f5514h.a(rectF) > fA ? 1 : (this.f5514h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f5513g.a(rectF) > fA ? 1 : (this.f5513g.a(rectF) == fA ? 0 : -1)) == 0) && d();
    }

    public final m f() {
        m mVar = new m();
        mVar.f5497a = this.f5508a;
        mVar.f5498b = this.f5509b;
        mVar.f5499c = this.f5510c;
        mVar.d = this.d;
        mVar.f5500e = this.f5511e;
        mVar.f5501f = this.f5512f;
        mVar.f5502g = this.f5513g;
        mVar.f5503h = this.f5514h;
        mVar.f5504i = this.f5515i;
        mVar.f5505j = this.f5516j;
        mVar.f5506k = this.f5517k;
        mVar.f5507l = this.f5518l;
        return mVar;
    }

    public final String toString() {
        return "[" + this.f5511e + ", " + this.f5512f + ", " + this.f5513g + ", " + this.f5514h + "]";
    }
}
