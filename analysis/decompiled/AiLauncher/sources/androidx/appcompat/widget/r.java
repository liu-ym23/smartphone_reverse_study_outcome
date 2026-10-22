package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class r extends RatingBar {
    private final C1303p mAppCompatProgressBarHelper;

    public r(Context context) {
        this(context, null);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Bitmap bitmapB = this.mAppCompatProgressBarHelper.b();
        if (bitmapB != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapB.getWidth() * getNumStars(), i10, 0), getMeasuredHeight());
        }
    }

    public r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.ratingBarStyle);
    }

    public r(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        O.a(this, getContext());
        C1303p c1303p = new C1303p(this);
        this.mAppCompatProgressBarHelper = c1303p;
        c1303p.c(attributeSet, i10);
    }
}
