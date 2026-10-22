package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import g.C0728a;

/* renamed from: androidx.appcompat.widget.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0452w extends RatingBar {

    /* renamed from: a, reason: collision with root package name */
    private final C0450u f8616a;

    public C0452w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16816M);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        Bitmap bitmapB = this.f8616a.b();
        if (bitmapB != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapB.getWidth() * getNumStars(), i5, 0), getMeasuredHeight());
        }
    }

    public C0452w(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        V.a(this, getContext());
        C0450u c0450u = new C0450u(this);
        this.f8616a = c0450u;
        c0450u.c(attributeSet, i5);
    }
}
