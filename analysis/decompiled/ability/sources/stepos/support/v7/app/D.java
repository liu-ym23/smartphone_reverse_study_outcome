package stepos.support.v7.app;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.stepos.common.widget.ViewTreeObserverOnPreDrawListenerC1114t;
import stepos.support.v7.widget.PopupNestedScrollingLayout;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes4.dex */
public abstract class D extends AbstractActivityC1962k {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6214a;
    public F b;
    public Boolean c;
    public int d;

    @Override // stepos.support.v7.app.AbstractActivityC1962k, android.view.ComponentActivity, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.c.booleanValue()) {
            super.addContentView(view, layoutParams);
            return;
        }
        q();
        ((ViewGroup) findViewById(R.id.content)).addView(view, layoutParams);
        onContentChanged();
    }

    @Override // android.app.Activity
    public void finish() throws Settings.SettingNotFoundException {
        float f;
        if (!this.c.booleanValue()) {
            super.finish();
            overridePendingTransition(com.stepos.ability.R.anim.stepos_activity_to_next_close_enter, com.stepos.ability.R.anim.stepos_activity_to_next_close_exit);
            return;
        }
        F f7 = this.b;
        SpringAnimation springAnimation = f7.g;
        PopupNestedScrollingLayout popupNestedScrollingLayout = f7.c;
        AnimatorSet animatorSet = f7.f;
        if (animatorSet == null || !animatorSet.isRunning()) {
            f7.f = new AnimatorSet();
            int uncollapsibleHeight = popupNestedScrollingLayout.getCurrentScrollY() <= 0 ? popupNestedScrollingLayout.getUncollapsibleHeight() : popupNestedScrollingLayout.getMeasuredHeight();
            springAnimation.setSpring(new SpringForce().setDampingRatio(0.93f).setStiffness(400.0f));
            float f9 = uncollapsibleHeight;
            springAnimation.getSpring().setFinalPosition(f9);
            try {
                f = Settings.Global.getFloat(f7.d.getContentResolver(), "transition_animation_scale");
            } catch (Exception unused) {
                f = 1.0f;
            }
            if (f != 0.0f) {
                springAnimation.start();
            } else {
                popupNestedScrollingLayout.setTranslationY(f9);
            }
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(f7.f6216a, "alpha", f7.e, 0);
            objectAnimatorOfInt.setInterpolator(F.i);
            objectAnimatorOfInt.setDuration(300L);
            f7.f.playTogether(objectAnimatorOfInt);
            f7.f.addListener(new E(f7, 1));
            f7.f.start();
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, android.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (this.c.booleanValue()) {
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.c = Boolean.valueOf(bundle.getBoolean("popup_activity", this.c.booleanValue()));
            this.d = bundle.getInt("popup_theme_id", this.d);
        } else if (getIntent() != null) {
            Intent intent = getIntent();
            this.c = Boolean.valueOf(intent.getBooleanExtra("popup_activity", this.c.booleanValue()));
            this.d = intent.getIntExtra("popup_theme_id", this.d);
        }
        if (this.c.booleanValue()) {
            getTheme().applyStyle(this.d, true);
            q();
            F f = this.b;
            D d = f.d;
            d.getWindow().setBackgroundDrawable(f.f6216a);
            f.c.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC1114t(f, 1));
            d.overridePendingTransition(0, 0);
            f.h.setDecorFitsSystemWindows(false);
        } else {
            setTheme(this.d);
            overridePendingTransition(com.stepos.ability.R.anim.stepos_activity_to_next_open_enter, com.stepos.ability.R.anim.stepos_activity_to_next_open_exit);
        }
        super.onCreate(bundle);
        getWindow().setWindowAnimations(com.stepos.ability.R.style.StepOS_Popup_Window_Animation_Style);
        if (this.c.booleanValue()) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1280);
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.c.booleanValue() && this.b.a()) {
            Log.d("popup_stack", " bottom stack resume, to reset state ");
            I.a().getClass();
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("popup_activity", this.c.booleanValue());
        bundle.putInt("popup_theme_id", this.d);
    }

    public final void q() {
        if (this.f6214a) {
            return;
        }
        super.setContentView(com.stepos.ability.R.layout.activity_lite_popup);
        View viewFindViewById = findViewById(com.stepos.ability.R.id.content_panel);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        if (viewGroup != null) {
            viewGroup.setId(-1);
            viewFindViewById.setId(R.id.content);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
        }
        this.f6214a = true;
        setSupportActionBar((Toolbar) findViewById(com.stepos.ability.R.id.title_bar));
        this.b = new F(this);
    }

    public final void r() {
        super.finish();
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, android.view.ComponentActivity, android.app.Activity
    public final void setContentView(int i) {
        if (!this.c.booleanValue()) {
            super.setContentView(i);
            return;
        }
        q();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this).inflate(i, viewGroup);
        onContentChanged();
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, android.view.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        if (!this.c.booleanValue()) {
            super.setContentView(view);
            return;
        }
        q();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        onContentChanged();
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, android.view.ComponentActivity, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.c.booleanValue()) {
            super.setContentView(view, layoutParams);
            return;
        }
        q();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        onContentChanged();
    }
}
