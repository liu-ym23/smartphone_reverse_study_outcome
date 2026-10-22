package f7;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public td.h f3986a = new k();

    /* renamed from: b, reason: collision with root package name */
    public td.h f3987b = new k();

    /* renamed from: c, reason: collision with root package name */
    public td.h f3988c = new k();

    /* renamed from: d, reason: collision with root package name */
    public td.h f3989d = new k();

    /* renamed from: e, reason: collision with root package name */
    public d f3990e = new a(0.0f);

    /* renamed from: f, reason: collision with root package name */
    public d f3991f = new a(0.0f);

    /* renamed from: g, reason: collision with root package name */
    public d f3992g = new a(0.0f);

    /* renamed from: h, reason: collision with root package name */
    public d f3993h = new a(0.0f);
    public f i;

    /* renamed from: j, reason: collision with root package name */
    public f f3994j;

    /* renamed from: k, reason: collision with root package name */
    public f f3995k;

    /* renamed from: l, reason: collision with root package name */
    public f f3996l;

    public m() {
        int i = 0;
        this.i = new f(i);
        this.f3994j = new f(i);
        this.f3995k = new f(i);
        this.f3996l = new f(i);
    }

    public static l a(Context context, int i, int i3, a aVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i3 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i3, true);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(p6.a.f9825r);
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
            l lVar = new l();
            lVar.f3975a = a.a.o(i11);
            lVar.f3979e = dVarC2;
            lVar.f3976b = a.a.o(i12);
            lVar.f3980f = dVarC3;
            lVar.f3977c = a.a.o(i13);
            lVar.f3981g = dVarC4;
            lVar.f3978d = a.a.o(i14);
            lVar.f3982h = dVarC5;
            return lVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static l b(Context context, AttributeSet attributeSet, int i, int i3) {
        a aVar = new a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p6.a.f9820m, i, i3);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static d c(TypedArray typedArray, int i, d dVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i3 = typedValuePeekValue.type;
            if (i3 == 5) {
                return new a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i3 == 6) {
                float fraction = typedValuePeekValue.getFraction(1.0f, 1.0f);
                j jVar = new j();
                jVar.f3974a = fraction;
                VarHandle.storeStoreFence();
                return jVar;
            }
        }
        return dVar;
    }

    public final boolean d() {
        return (this.f3987b instanceof k) && (this.f3986a instanceof k) && (this.f3988c instanceof k) && (this.f3989d instanceof k);
    }

    public final boolean e(RectF rectF) {
        boolean z10 = this.f3996l.getClass().equals(f.class) && this.f3994j.getClass().equals(f.class) && this.i.getClass().equals(f.class) && this.f3995k.getClass().equals(f.class);
        float fA = this.f3990e.a(rectF);
        return z10 && ((this.f3991f.a(rectF) > fA ? 1 : (this.f3991f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f3993h.a(rectF) > fA ? 1 : (this.f3993h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f3992g.a(rectF) > fA ? 1 : (this.f3992g.a(rectF) == fA ? 0 : -1)) == 0) && d();
    }

    public final l f() {
        l lVar = new l();
        lVar.f3975a = this.f3986a;
        lVar.f3976b = this.f3987b;
        lVar.f3977c = this.f3988c;
        lVar.f3978d = this.f3989d;
        lVar.f3979e = this.f3990e;
        lVar.f3980f = this.f3991f;
        lVar.f3981g = this.f3992g;
        lVar.f3982h = this.f3993h;
        lVar.i = this.i;
        lVar.f3983j = this.f3994j;
        lVar.f3984k = this.f3995k;
        lVar.f3985l = this.f3996l;
        return lVar;
    }

    public final String toString() {
        return "[" + this.f3990e + ", " + this.f3991f + ", " + this.f3992g + ", " + this.f3993h + "]";
    }
}
