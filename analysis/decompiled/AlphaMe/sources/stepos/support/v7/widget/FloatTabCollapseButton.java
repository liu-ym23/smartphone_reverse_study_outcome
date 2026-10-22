package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.alphame.R;
import j.C0622a;

/* loaded from: classes2.dex */
public class FloatTabCollapseButton extends p0 {

    /* renamed from: e, reason: collision with root package name */
    public final int f14820e;

    static {
        M.a.b(0.18f, 0.236f, 0.1f, 1.0f);
    }

    public FloatTabCollapseButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposFloatTabContainerCollapseButtonStyle);
        this.f14820e = C0622a.c(context).f13046b.getResources().getDimensionPixelSize(R.dimen.stepos_action_bar_stacked_max_height);
        setVisibility(8);
        float f4 = getResources().getDisplayMetrics().density;
        setBackgroundDrawable(null);
    }

    @Override // stepos.support.v7.widget.p0
    public final j.m e(boolean z4) {
        return super.e(z4);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(this.f14820e, 1073741824));
    }
}
