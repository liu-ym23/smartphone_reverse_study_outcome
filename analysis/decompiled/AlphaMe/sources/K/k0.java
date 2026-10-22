package K;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import c0.C0386a;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;

/* loaded from: classes.dex */
public abstract class k0 extends AbstractC0557a {
    static {
        new PathInterpolator(Property.DEFAULT_FLOAT_VALUE, 1.1f, Property.DEFAULT_FLOAT_VALUE, 1.0f);
        new C0386a();
        new DecelerateInterpolator();
    }

    public static void g0(View view) {
        i0(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                g0(viewGroup.getChildAt(i4));
            }
        }
    }

    public static void h0(View view, B0.e eVar) {
        i0(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                h0(viewGroup.getChildAt(i4), eVar);
            }
        }
    }

    public static p1.c i0(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (!(tag instanceof j0)) {
            return null;
        }
        ((j0) tag).getClass();
        return null;
    }
}
