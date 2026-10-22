package obric.widget.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import obric.view.ViewPager;

/* JADX INFO: loaded from: classes5.dex */
public class WrapContentViewPager extends ViewPager {
    public WrapContentViewPager(Context context) {
        super(context);
    }

    public WrapContentViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // obric.view.ViewPager, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (View.MeasureSpec.getMode(heightMeasureSpec) != Integer.MIN_VALUE) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L12;
        int r6 = getMeasuredWidth();
        int r1 = getMeasuredHeight();
        int r7 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
        if (getChildCount() <= 0) goto L10;
        View r8 = getChildAt(0);
        r8.measure(r7, View.MeasureSpec.makeMeasureSpec(r1, Integer.MIN_VALUE));
        r1 = r8.getMeasuredHeight();
    L10:
        super.onMeasure(r7, View.MeasureSpec.makeMeasureSpec(r1, 1073741824));
        return;
    L12:
        return;
    L5:
        r5 = false;
        goto L6
    }
}
