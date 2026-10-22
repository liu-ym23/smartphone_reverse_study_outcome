package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class LitePopupContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f6472a;

    public LitePopupContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6472a = -1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        if (this.f6472a == -1) {
            super.onMeasure(i, i6);
            return;
        }
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f6472a, mode));
        if (mode == 1073741824) {
            setMeasuredDimension(getMeasuredWidth(), size);
        }
    }

    public void setLimitHeight(int i) {
        this.f6472a = i;
    }
}
