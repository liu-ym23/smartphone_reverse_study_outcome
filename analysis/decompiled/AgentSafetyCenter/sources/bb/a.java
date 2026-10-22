package bb;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {
    public static void a(View view, int i, float f5, boolean z10, float f10) throws Resources.NotFoundException {
        view.getClass();
        Context context = view.getContext();
        context.getClass();
        Resources resources = context.getResources();
        int integer = resources.getInteger(R.integer.stepos_hotspot_ripple_fade_percent);
        int integer2 = resources.getInteger(R.integer.stepos_hotspot_ripple_enter_duration);
        int integer3 = resources.getInteger(R.integer.stepos_hotspot_ripple_exit_duration);
        float fMax = Math.max(0.0f, f10);
        float fMax2 = Math.max(0.0f, f5);
        e eVar = new e();
        eVar.f2056a = i;
        eVar.f2057b = integer2;
        eVar.f2058c = integer3;
        eVar.f2059d = fMax;
        eVar.f2060e = fMax2;
        eVar.f2061f = 1.0f - (p5.f.q(integer, 0, 100) / 100.0f);
        Paint paint = new Paint(1);
        eVar.f2062g = paint;
        eVar.f2063h = Color.alpha(i);
        paint.setColor(i);
        paint.setAlpha(0);
        VarHandle.storeStoreFence();
        view.setForeground(eVar);
        f fVar = new f();
        fVar.f2071a = f5;
        VarHandle.storeStoreFence();
        view.setOutlineProvider(fVar);
        view.setClipToOutline(true);
        if (!z10) {
            view.setStateListAnimator(null);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else {
            Object obj = Boolean.TRUE;
            view.setTag(R.id.stepos_tag_press_scale, obj);
            view.setTag(R.id.stepos_tag_press_scale, obj);
            view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(view.getContext(), R.animator.stepos_button_press));
        }
    }

    public static /* synthetic */ void b(View view, int i, float f5, boolean z10, float f10, int i3) throws Resources.NotFoundException {
        if ((i3 & 16) != 0) {
            z10 = true;
        }
        a(view, i, f5, z10, f10);
    }

    public static void c(View view, boolean z10) {
        Object tag = view.getTag(R.id.stepos_tag_press_scale);
        Boolean bool = Boolean.TRUE;
        if (k.a(tag, bool)) {
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
                childAt.getClass();
                c(childAt, z10);
            }
        }
    }
}
