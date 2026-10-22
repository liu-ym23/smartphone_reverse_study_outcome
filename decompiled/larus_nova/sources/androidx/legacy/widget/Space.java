package androidx.legacy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class Space extends View {
    @Override // android.view.View
    public void draw(Canvas r100) {
    }

    public Space(Context r100) {
        this(r100, null);
    }

    public Space(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    private static int getDefaultSize2(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r101);
        int r103 = View.MeasureSpec.getSize(r101);
        if (r102 == Integer.MIN_VALUE) goto L9;
        if (r102 == 1073741824) goto L10;
        return r100;
    L10:
        return r103;
    L9:
        return Math.min(r100, r103);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), r100), getDefaultSize2(getSuggestedMinimumHeight(), r101));
    }

    public Space(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        if (getVisibility() != 0) goto L6;
        setVisibility(4);
        return;
    }
}
