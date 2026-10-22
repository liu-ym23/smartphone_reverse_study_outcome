package stepos.support.v7.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class ActionBarDropDownView extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    public static final PathInterpolator f12575j = new PathInterpolator(0.12f, 0.31f, 0.1f, 1.0f);

    /* renamed from: k, reason: collision with root package name */
    public static final PathInterpolator f12576k = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);

    /* renamed from: c, reason: collision with root package name */
    public final int f12577c;

    /* renamed from: f, reason: collision with root package name */
    public int f12578f;

    /* renamed from: g, reason: collision with root package name */
    public final View f12579g;

    /* renamed from: h, reason: collision with root package name */
    public AnimatorSet f12580h;
    public final f i;

    public ActionBarDropDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12577c = -1;
        this.f12578f = 1;
        new f(this, 0);
        this.i = new f(this, 1);
        View view = new View(context);
        this.f12579g = view;
        view.setBackgroundColor(context.getResources().getColor(R.color.stepos_action_bar_drop_down_view_background));
        addView(view, -1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        getVisibility();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (action == 0) {
            return true;
        }
        if (action == 1 && (i = this.f12578f) != 1 && i != 0) {
            AnimatorSet animatorSet = this.f12580h;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat((Object) null, "translationY", -this.f12577c);
            objectAnimatorOfFloat.setInterpolator(f12575j);
            AnimatorSet.Builder builderPlay = animatorSet2.play(objectAnimatorOfFloat);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f12579g, "alpha", 0.0f);
            objectAnimatorOfFloat2.setInterpolator(f12576k);
            builderPlay.with(objectAnimatorOfFloat2);
            animatorSet2.setDuration(350L);
            animatorSet2.addListener(this.i);
            animatorSet2.start();
            this.f12580h = animatorSet2;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarDropDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarDropDownView(Context context) {
        this(context, null);
    }

    public void setCallback(stepos.support.v7.app.a aVar) {
    }
}
