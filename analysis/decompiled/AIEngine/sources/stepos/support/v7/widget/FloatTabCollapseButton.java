package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class FloatTabCollapseButton extends a0 {

    /* renamed from: k, reason: collision with root package name */
    public final int f12539k;

    static {
        x0.a.a(0.18f, 0.236f, 0.1f, 1.0f);
    }

    public FloatTabCollapseButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposFloatTabContainerCollapseButtonStyle);
        this.f12539k = fe.a.a(context).f8850a.getResources().getDimensionPixelSize(R.dimen.stepos_action_bar_stacked_max_height);
        setVisibility(8);
        float f8 = getResources().getDisplayMetrics().density;
        setBackgroundDrawable(null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(this.f12539k, 1073741824));
    }
}
