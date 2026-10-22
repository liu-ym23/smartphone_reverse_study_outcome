package stepos.support.v7.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.stepos.activeview.graphicsanim.renderable.Renderable;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import stepos.support.v7.app.InterfaceC0857b;

/* loaded from: classes2.dex */
public class ActionBarDropDownView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public static final Interpolator f14745f = M.a.b(0.12f, 0.31f, 0.1f, 1.0f);

    /* renamed from: g, reason: collision with root package name */
    public static final Interpolator f14746g = M.a.b(0.33f, Property.DEFAULT_FLOAT_VALUE, 0.66f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final int f14747a;

    /* renamed from: b, reason: collision with root package name */
    public int f14748b;

    /* renamed from: c, reason: collision with root package name */
    public final View f14749c;

    /* renamed from: d, reason: collision with root package name */
    public AnimatorSet f14750d;

    /* renamed from: e, reason: collision with root package name */
    public final C0886f f14751e;

    public ActionBarDropDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f14747a = -1;
        this.f14748b = 1;
        new C0886f(this, 0);
        this.f14751e = new C0886f(this, 1);
        View view = new View(context);
        this.f14749c = view;
        view.setBackgroundColor(context.getResources().getColor(R.color.stepos_action_bar_drop_down_view_background));
        addView(view, -1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        getVisibility();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i4;
        int action = motionEvent.getAction();
        if (action == 0) {
            return true;
        }
        if (action == 1 && (i4 = this.f14748b) != 1 && i4 != 0) {
            AnimatorSet animatorSet = this.f14750d;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat((Object) null, Renderable.ATTR_TRANSLATION_Y, -this.f14747a);
            objectAnimatorOfFloat.setInterpolator(f14745f);
            AnimatorSet.Builder builderPlay = animatorSet2.play(objectAnimatorOfFloat);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f14749c, ViewTweenItem.ALPHA, Property.DEFAULT_FLOAT_VALUE);
            objectAnimatorOfFloat2.setInterpolator(f14746g);
            builderPlay.with(objectAnimatorOfFloat2);
            animatorSet2.setDuration(350L);
            animatorSet2.addListener(this.f14751e);
            animatorSet2.start();
            this.f14750d = animatorSet2;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCallback(InterfaceC0857b interfaceC0857b) {
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
    }
}
