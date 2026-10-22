package E6;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.ability.R;
import g1.AbstractC1451a;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class e {
    public static void a(View view, int i, float f, boolean z10, float f7) throws Resources.NotFoundException {
        k.f(view, "view");
        Context context = view.getContext();
        k.e(context, "getContext(...)");
        Resources resources = context.getResources();
        int integer = resources.getInteger(R.integer.stepos_hotspot_ripple_fade_percent);
        view.setForeground(new g(Math.max(0.0f, f7), i, Math.max(0.0f, f), resources.getInteger(R.integer.stepos_hotspot_ripple_enter_duration), 1.0f - (AbstractC1451a.u(integer, 0, 100) / 100.0f), resources.getInteger(R.integer.stepos_hotspot_ripple_exit_duration)));
        view.setOutlineProvider(new h(f));
        view.setClipToOutline(true);
        if (!z10) {
            view.setStateListAnimator(null);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else {
            Boolean bool = Boolean.TRUE;
            view.setTag(R.id.stepos_tag_press_scale, bool);
            view.setTag(R.id.stepos_tag_press_scale, bool);
            view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(view.getContext(), R.animator.stepos_button_press));
        }
    }

    public static void b(View view, boolean z10) {
        Object tag = view.getTag(R.id.stepos_tag_press_scale);
        Boolean bool = Boolean.TRUE;
        if (k.b(tag, bool)) {
            if (z10) {
                view.setTag(R.id.stepos_tag_press_scale, bool);
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(view.getContext(), R.animator.stepos_button_press));
            } else {
                view.setStateListAnimator(null);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                k.e(childAt, "getChildAt(...)");
                b(childAt, z10);
            }
        }
    }
}
