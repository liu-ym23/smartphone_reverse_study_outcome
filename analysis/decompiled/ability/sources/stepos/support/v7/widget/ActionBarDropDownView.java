package stepos.support.v7.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.stepos.ability.R;
import stepos.support.v7.app.InterfaceC1952a;

/* loaded from: classes4.dex */
public class ActionBarDropDownView extends FrameLayout {
    public static final Interpolator f = PathInterpolatorCompat.create(0.12f, 0.31f, 0.1f, 1.0f);
    public static final Interpolator g = PathInterpolatorCompat.create(0.33f, 0.0f, 0.66f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final int f6416a;
    public int b;
    public final View c;
    public AnimatorSet d;
    public final C1991h e;

    public ActionBarDropDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6416a = -1;
        this.b = 1;
        new C1991h(this, 0);
        this.e = new C1991h(this, 1);
        View view = new View(context);
        this.c = view;
        view.setBackgroundColor(context.getResources().getColor(R.color.stepos_action_bar_drop_down_view_background));
        addView(view, -1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        getVisibility();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (action == 0) {
            return true;
        }
        if (action == 1 && (i = this.b) != 1 && i != 0) {
            AnimatorSet animatorSet = this.d;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat((Object) null, "translationY", -this.f6416a);
            objectAnimatorOfFloat.setInterpolator(f);
            AnimatorSet.Builder builderPlay = animatorSet2.play(objectAnimatorOfFloat);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "alpha", 0.0f);
            objectAnimatorOfFloat2.setInterpolator(g);
            builderPlay.with(objectAnimatorOfFloat2);
            animatorSet2.setDuration(350L);
            animatorSet2.addListener(this.e);
            animatorSet2.start();
            this.d = animatorSet2;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCallback(InterfaceC1952a interfaceC1952a) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}
