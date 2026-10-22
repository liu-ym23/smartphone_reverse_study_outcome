package stepos.support.v7.app;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import java.lang.invoke.VarHandle;
import stepos.support.v7.widget.PopupNestedScrollingLayout;
import stepos.support.v7.widget.Toolbar;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class u extends j {

    /* renamed from: c, reason: collision with root package name */
    public boolean f12504c;

    /* renamed from: f, reason: collision with root package name */
    public w f12505f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f12506g;

    /* renamed from: h, reason: collision with root package name */
    public int f12507h;

    @Override // stepos.support.v7.app.j, androidx.activity.p, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f12506g.booleanValue()) {
            super.addContentView(view, layoutParams);
            return;
        }
        c();
        ((ViewGroup) findViewById(R.id.content)).addView(view, layoutParams);
        onContentChanged();
    }

    public final void c() {
        if (this.f12504c) {
            return;
        }
        super.setContentView(com.stepos.agentsafetycenter.R.layout.activity_lite_popup);
        View viewFindViewById = findViewById(com.stepos.agentsafetycenter.R.id.content_panel);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        if (viewGroup != null) {
            viewGroup.setId(-1);
            viewFindViewById.setId(R.id.content);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
        }
        this.f12504c = true;
        setSupportActionBar((Toolbar) findViewById(com.stepos.agentsafetycenter.R.id.title_bar));
        w wVar = new w();
        f fVar = new f(1);
        fVar.f12315f = wVar;
        VarHandle.storeStoreFence();
        wVar.f12513d = this;
        wVar.f12517h = getWindow();
        PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) findViewById(com.stepos.agentsafetycenter.R.id.nested_scrolling_layout);
        wVar.f12512c = popupNestedScrollingLayout;
        popupNestedScrollingLayout.setUncollapsibleHeight(getResources().getDimensionPixelSize(com.stepos.agentsafetycenter.R.dimen.stepos_lite_popup_middle_state_height));
        getSupportActionBar();
        wVar.f12510a = new ColorDrawable(getResources().getColor(com.stepos.agentsafetycenter.R.color.stepos_lite_popup_window_dim));
        popupNestedScrollingLayout.setOnDismissedListener(fVar);
        wVar.f12511b = 255;
        wVar.f12514e = 255;
        wVar.f12516g = new z3.g(popupNestedScrollingLayout, z3.g.f16353o);
        r2.i iVar = new r2.i(3);
        VarHandle.storeStoreFence();
        popupNestedScrollingLayout.setScrollListener(iVar);
        VarHandle.storeStoreFence();
        this.f12505f = wVar;
    }

    public final void d() {
        super.finish();
    }

    @Override // android.app.Activity
    public void finish() throws Settings.SettingNotFoundException {
        float f5;
        if (!this.f12506g.booleanValue()) {
            super.finish();
            overridePendingTransition(com.stepos.agentsafetycenter.R.anim.stepos_activity_to_next_close_enter, com.stepos.agentsafetycenter.R.anim.stepos_activity_to_next_close_exit);
            return;
        }
        w wVar = this.f12505f;
        z3.g gVar = wVar.f12516g;
        PopupNestedScrollingLayout popupNestedScrollingLayout = wVar.f12512c;
        AnimatorSet animatorSet = wVar.f12515f;
        if (animatorSet == null || !animatorSet.isRunning()) {
            wVar.f12515f = new AnimatorSet();
            int uncollapsibleHeight = popupNestedScrollingLayout.getCurrentScrollY() <= 0 ? popupNestedScrollingLayout.getUncollapsibleHeight() : popupNestedScrollingLayout.getMeasuredHeight();
            z3.h hVar = new z3.h();
            hVar.a(0.93f);
            hVar.b(400.0f);
            gVar.f16369k = hVar;
            float f10 = uncollapsibleHeight;
            hVar.i = f10;
            try {
                f5 = Settings.Global.getFloat(wVar.f12513d.getContentResolver(), "transition_animation_scale");
            } catch (Exception unused) {
                f5 = 1.0f;
            }
            if (f5 != 0.0f) {
                gVar.g();
            } else {
                popupNestedScrollingLayout.setTranslationY(f10);
            }
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(wVar.f12510a, "alpha", wVar.f12514e, 0);
            objectAnimatorOfInt.setInterpolator(w.i);
            objectAnimatorOfInt.setDuration(300L);
            wVar.f12515f.playTogether(objectAnimatorOfInt);
            wVar.f12515f.addListener(new v(wVar, 1));
            wVar.f12515f.start();
        }
    }

    @Override // stepos.support.v7.app.j, androidx.activity.p, android.app.Activity
    public final void onBackPressed() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (this.f12506g.booleanValue()) {
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // stepos.support.v7.app.j, androidx.fragment.app.j, androidx.activity.p, d3.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.f12506g = Boolean.valueOf(bundle.getBoolean("popup_activity", this.f12506g.booleanValue()));
            this.f12507h = bundle.getInt("popup_theme_id", this.f12507h);
        } else if (getIntent() != null) {
            Intent intent = getIntent();
            this.f12506g = Boolean.valueOf(intent.getBooleanExtra("popup_activity", this.f12506g.booleanValue()));
            this.f12507h = intent.getIntExtra("popup_theme_id", this.f12507h);
        }
        if (this.f12506g.booleanValue()) {
            getTheme().applyStyle(this.f12507h, true);
            c();
            w wVar = this.f12505f;
            u uVar = wVar.f12513d;
            uVar.getWindow().setBackgroundDrawable(wVar.f12510a);
            ViewTreeObserver viewTreeObserver = wVar.f12512c.getViewTreeObserver();
            aa.l lVar = new aa.l(3);
            lVar.f332f = wVar;
            VarHandle.storeStoreFence();
            viewTreeObserver.addOnPreDrawListener(lVar);
            uVar.overridePendingTransition(0, 0);
            wVar.f12517h.setDecorFitsSystemWindows(false);
        } else {
            setTheme(this.f12507h);
            overridePendingTransition(com.stepos.agentsafetycenter.R.anim.stepos_activity_to_next_open_enter, com.stepos.agentsafetycenter.R.anim.stepos_activity_to_next_open_exit);
        }
        super.onCreate(bundle);
        getWindow().setWindowAnimations(com.stepos.agentsafetycenter.R.style.StepOS_Popup_Window_Animation_Style);
        if (this.f12506g.booleanValue()) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1280);
        }
    }

    @Override // stepos.support.v7.app.j, androidx.fragment.app.j, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f12506g.booleanValue() && this.f12505f.a()) {
            Log.d("popup_stack", " bottom stack resume, to reset state ");
            r2.i.m().getClass();
        }
    }

    @Override // stepos.support.v7.app.j, androidx.activity.p, d3.c, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("popup_activity", this.f12506g.booleanValue());
        bundle.putInt("popup_theme_id", this.f12507h);
    }

    @Override // stepos.support.v7.app.j, androidx.activity.p, android.app.Activity
    public final void setContentView(int i) {
        if (!this.f12506g.booleanValue()) {
            super.setContentView(i);
            return;
        }
        c();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this).inflate(i, viewGroup);
        onContentChanged();
    }

    @Override // stepos.support.v7.app.j, androidx.activity.p, android.app.Activity
    public void setContentView(View view) {
        if (!this.f12506g.booleanValue()) {
            super.setContentView(view);
            return;
        }
        c();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        onContentChanged();
    }

    @Override // stepos.support.v7.app.j, androidx.activity.p, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f12506g.booleanValue()) {
            super.setContentView(view, layoutParams);
            return;
        }
        c();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        onContentChanged();
    }
}
