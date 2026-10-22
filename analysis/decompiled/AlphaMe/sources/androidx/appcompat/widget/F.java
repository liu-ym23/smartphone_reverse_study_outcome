package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import g.AbstractC0560a;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f2815a;

    /* renamed from: b, reason: collision with root package name */
    public X0 f2816b;

    /* renamed from: c, reason: collision with root package name */
    public int f2817c = 0;

    public F(ImageView imageView) {
        this.f2815a = imageView;
    }

    public final void a() {
        X0 x02;
        ImageView imageView = this.f2815a;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            Rect rect = AbstractC0220p0.f3149a;
        }
        if (drawable == null || (x02 = this.f2816b) == null) {
            return;
        }
        A.d(drawable, x02, imageView.getDrawableState());
    }

    public final void b(AttributeSet attributeSet, int i4) {
        int iR;
        ImageView imageView = this.f2815a;
        Context context = imageView.getContext();
        int[] iArr = AbstractC0560a.f12593f;
        android.support.v4.media.session.c cVarY = android.support.v4.media.session.c.y(i4, 0, context, attributeSet, iArr);
        ImageView imageView2 = this.f2815a;
        Context context2 = imageView2.getContext();
        TypedArray typedArray = (TypedArray) cVarY.f2365c;
        WeakHashMap weakHashMap = K.S.f939a;
        K.O.d(imageView2, context2, iArr, attributeSet, typedArray, i4, 0);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (iR = cVarY.r(1, -1)) != -1 && (drawable = Z2.I.o(imageView.getContext(), iR)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                Rect rect = AbstractC0220p0.f3149a;
            }
            if (cVarY.v(2)) {
                androidx.core.widget.e.c(imageView, cVarY.h(2));
            }
            if (cVarY.v(3)) {
                androidx.core.widget.e.d(imageView, AbstractC0220p0.b(cVarY.p(3, -1), null));
            }
            cVarY.A();
        } catch (Throwable th) {
            cVarY.A();
            throw th;
        }
    }
}
