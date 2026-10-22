package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.stepos.ability.R;

/* loaded from: classes4.dex */
public class FloatTabCollapseButton extends x0 {
    public final int e;

    static {
        PathInterpolatorCompat.create(0.18f, 0.236f, 0.1f, 1.0f);
    }

    public FloatTabCollapseButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposFloatTabContainerCollapseButtonStyle);
        this.f6646a = true;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnClickListener(new ViewOnClickListenerC1983d(this, 1));
        setBackgroundDrawable(null);
        this.e = Ua.a.a(context).f1279a.getResources().getDimensionPixelSize(R.dimen.stepos_action_bar_stacked_max_height);
        setVisibility(8);
        float f = getResources().getDisplayMetrics().density;
        setBackgroundDrawable(null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.e, BasicMeasure.EXACTLY));
    }
}
