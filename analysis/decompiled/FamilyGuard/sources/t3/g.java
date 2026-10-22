package t3;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import l3.C0846d;

/* loaded from: classes.dex */
public final class g {
    public static final StateListDrawable a(Context context, float[] fArr, int i5, boolean z5) {
        j4.k.g(context, "context");
        j4.k.g(fArr, "radii");
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (z5) {
            stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, new LayerDrawable(new GradientDrawable[]{b(fArr, i5), b(fArr, context.getColor(C0846d.f18312s))}));
        }
        stateListDrawable.addState(new int[0], b(fArr, i5));
        return stateListDrawable;
    }

    private static final GradientDrawable b(float[] fArr, int i5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii((float[]) fArr.clone());
        gradientDrawable.setColor(i5);
        return gradientDrawable;
    }
}
