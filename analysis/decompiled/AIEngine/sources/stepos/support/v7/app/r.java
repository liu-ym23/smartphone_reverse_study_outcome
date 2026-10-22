package stepos.support.v7.app;

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
import com.stepos.aiengine.R;
import stepos.support.v7.widget.PopupNestedScrollingLayout;
import stepos.support.v7.widget.Toolbar;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class r extends f {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12256a;

    /* renamed from: b, reason: collision with root package name */
    public s f12257b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f12258c = Boolean.TRUE;

    /* renamed from: d, reason: collision with root package name */
    public int f12259d = R.style.Theme_StepOS_AppCompat_Light_LitePopupOverlay;

    @Override // stepos.support.v7.app.f, b.k, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f12258c.booleanValue()) {
            super.addContentView(view, layoutParams);
            return;
        }
        q();
        ((ViewGroup) findViewById(android.R.id.content)).addView(view, layoutParams);
        onContentChanged();
    }

    @Override // android.app.Activity
    public void finish() throws Settings.SettingNotFoundException {
        float f8;
        if (!this.f12258c.booleanValue()) {
            super.finish();
            overridePendingTransition(R.anim.stepos_activity_to_next_close_enter, R.anim.stepos_activity_to_next_close_exit);
            return;
        }
        s sVar = this.f12257b;
        h1.f fVar = sVar.f12267g;
        PopupNestedScrollingLayout popupNestedScrollingLayout = sVar.f12263c;
        AnimatorSet animatorSet = sVar.f12266f;
        if (animatorSet == null || !animatorSet.isRunning()) {
            sVar.f12266f = new AnimatorSet();
            int uncollapsibleHeight = popupNestedScrollingLayout.getCurrentScrollY() <= 0 ? popupNestedScrollingLayout.getUncollapsibleHeight() : popupNestedScrollingLayout.getMeasuredHeight();
            h1.g gVar = new h1.g();
            gVar.a(0.93f);
            gVar.b(400.0f);
            fVar.f9241t = gVar;
            float f9 = uncollapsibleHeight;
            gVar.f9251i = f9;
            try {
                f8 = Settings.Global.getFloat(sVar.f12264d.getContentResolver(), "transition_animation_scale");
            } catch (Exception unused) {
                f8 = 1.0f;
            }
            if (f8 != 0.0f) {
                fVar.h();
            } else {
                popupNestedScrollingLayout.setTranslationY(f9);
            }
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(sVar.f12261a, "alpha", sVar.f12265e, 0);
            objectAnimatorOfInt.setInterpolator(s.f12260i);
            objectAnimatorOfInt.setDuration(300L);
            sVar.f12266f.playTogether(objectAnimatorOfInt);
            sVar.f12266f.addListener(new com.google.android.material.appbar.h(sVar, 6));
            sVar.f12266f.start();
        }
    }

    @Override // stepos.support.v7.app.f, b.k, android.app.Activity
    public final void onBackPressed() {
        if (this.f12258c.booleanValue()) {
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // stepos.support.v7.app.f, androidx.fragment.app.o, b.k, androidx.core.app.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.f12258c = Boolean.valueOf(bundle.getBoolean("popup_activity", this.f12258c.booleanValue()));
            this.f12259d = bundle.getInt("popup_theme_id", this.f12259d);
        } else if (getIntent() != null) {
            Intent intent = getIntent();
            this.f12258c = Boolean.valueOf(intent.getBooleanExtra("popup_activity", this.f12258c.booleanValue()));
            this.f12259d = intent.getIntExtra("popup_theme_id", this.f12259d);
        }
        if (this.f12258c.booleanValue()) {
            getTheme().applyStyle(this.f12259d, true);
            q();
            s sVar = this.f12257b;
            r rVar = sVar.f12264d;
            rVar.getWindow().setBackgroundDrawable(sVar.f12261a);
            sVar.f12263c.getViewTreeObserver().addOnPreDrawListener(new t(sVar));
            rVar.overridePendingTransition(0, 0);
            sVar.h.setDecorFitsSystemWindows(false);
        } else {
            setTheme(this.f12259d);
            overridePendingTransition(R.anim.stepos_activity_to_next_open_enter, R.anim.stepos_activity_to_next_open_exit);
        }
        super.onCreate(bundle);
        getWindow().setWindowAnimations(R.style.StepOS_Popup_Window_Animation_Style);
        if (this.f12258c.booleanValue()) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1280);
        }
    }

    @Override // stepos.support.v7.app.f, androidx.fragment.app.o, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f12258c.booleanValue() && this.f12257b.a()) {
            Log.d("popup_stack", " bottom stack resume, to reset state ");
            w.a().getClass();
        }
    }

    @Override // stepos.support.v7.app.f, b.k, androidx.core.app.c, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("popup_activity", this.f12258c.booleanValue());
        bundle.putInt("popup_theme_id", this.f12259d);
    }

    public final void q() {
        if (this.f12256a) {
            return;
        }
        super.setContentView(R.layout.activity_lite_popup);
        View viewFindViewById = findViewById(R.id.content_panel);
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        if (viewGroup != null) {
            viewGroup.setId(-1);
            viewFindViewById.setId(android.R.id.content);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
        }
        this.f12256a = true;
        setSupportActionBar((Toolbar) findViewById(R.id.title_bar));
        this.f12257b = new s(this);
    }

    public final void r() {
        super.finish();
    }

    @Override // stepos.support.v7.app.f, b.k, android.app.Activity
    public final void setContentView(int i10) {
        if (!this.f12258c.booleanValue()) {
            super.setContentView(i10);
            return;
        }
        q();
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this).inflate(i10, viewGroup);
        onContentChanged();
    }

    @Override // stepos.support.v7.app.f, b.k, android.app.Activity
    public void setContentView(View view) {
        if (!this.f12258c.booleanValue()) {
            super.setContentView(view);
            return;
        }
        q();
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        onContentChanged();
    }

    @Override // stepos.support.v7.app.f, b.k, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f12258c.booleanValue()) {
            super.setContentView(view, layoutParams);
            return;
        }
        q();
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        onContentChanged();
    }
}
