package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class LitePopupContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f14834a;

    public LitePopupContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f14834a = -1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        if (this.f14834a == -1) {
            super.onMeasure(i4, i5);
            return;
        }
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(this.f14834a, mode));
        if (mode == 1073741824) {
            setMeasuredDimension(getMeasuredWidth(), size);
        }
    }

    public void setLimitHeight(int i4) {
        this.f14834a = i4;
    }
}
