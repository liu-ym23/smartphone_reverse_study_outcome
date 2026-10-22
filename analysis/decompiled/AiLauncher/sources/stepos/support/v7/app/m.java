package stepos.support.v7.app;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.stepos.common.R$anim;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.appcompat.R$style;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes5.dex */
public abstract class m extends d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f40524a;

    /* renamed from: b, reason: collision with root package name */
    public Toolbar f40525b;

    /* renamed from: c, reason: collision with root package name */
    public n f40526c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f40527d = Boolean.TRUE;

    /* renamed from: e, reason: collision with root package name */
    public int f40528e = R$style.Theme_StepOS_AppCompat_Light_LitePopupOverlay;

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R$id.title_bar);
        this.f40525b = toolbar;
        setSupportActionBar(toolbar);
        this.f40526c = new n(this);
    }

    public void A() {
        x();
    }

    public void B() {
        super.finish();
    }

    public void C() {
        super.onBackPressed();
        z();
    }

    @Override // stepos.support.v7.app.d, b.q, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f40527d.booleanValue()) {
            super.addContentView(view, layoutParams);
            return;
        }
        r();
        ((ViewGroup) findViewById(R.id.content)).addView(view, layoutParams);
        onContentChanged();
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.f40527d.booleanValue()) {
            this.f40526c.m();
        } else {
            super.finish();
            overridePendingTransition(R$anim.stepos_activity_to_next_close_enter, R$anim.stepos_activity_to_next_close_exit);
        }
    }

    @Override // stepos.support.v7.app.d, b.q, android.app.Activity
    public void onBackPressed() {
        if (this.f40527d.booleanValue()) {
            this.f40526c.o();
        } else {
            super.onBackPressed();
        }
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.f40527d = Boolean.valueOf(bundle.getBoolean("popup_activity", this.f40527d.booleanValue()));
            this.f40528e = bundle.getInt("popup_theme_id", this.f40528e);
        } else if (getIntent() != null) {
            Intent intent = getIntent();
            this.f40527d = Boolean.valueOf(intent.getBooleanExtra("popup_activity", this.f40527d.booleanValue()));
            this.f40528e = intent.getIntExtra("popup_theme_id", this.f40528e);
        }
        if (u()) {
            getTheme().applyStyle(this.f40528e, true);
            r();
            this.f40526c.l();
        } else {
            setTheme(this.f40528e);
            overridePendingTransition(R$anim.stepos_activity_to_next_open_enter, R$anim.stepos_activity_to_next_open_exit);
        }
        super.onCreate(bundle);
        getWindow().setWindowAnimations(com.stepos.common.R$style.StepOS_Popup_Window_Animation_Style);
        if (u()) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1280);
        }
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f40527d.booleanValue()) {
            this.f40526c.n();
        }
    }

    @Override // stepos.support.v7.app.d, b.q, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("popup_activity", this.f40527d.booleanValue());
        bundle.putInt("popup_theme_id", this.f40528e);
    }

    public final void r() {
        if (this.f40524a) {
            return;
        }
        super.setContentView(R$layout.activity_lite_popup);
        View viewFindViewById = findViewById(R$id.content_panel);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        if (viewGroup != null) {
            viewGroup.setId(-1);
            viewFindViewById.setId(R.id.content);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
        }
        this.f40524a = true;
        initView();
    }

    public void s(boolean z10) {
        finish();
    }

    @Override // stepos.support.v7.app.d, b.q, android.app.Activity
    public void setContentView(int i10) {
        if (!this.f40527d.booleanValue()) {
            super.setContentView(i10);
            return;
        }
        r();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this).inflate(i10, viewGroup);
        onContentChanged();
    }

    public l t() {
        return this.f40526c;
    }

    public boolean u() {
        return this.f40527d.booleanValue();
    }

    public void v(float f10) {
    }

    public void w() {
    }

    public void x() {
    }

    public void y(float f10) {
        v(f10);
    }

    public void z() {
        w();
    }

    @Override // stepos.support.v7.app.d, b.q, android.app.Activity
    public void setContentView(View view) {
        if (!this.f40527d.booleanValue()) {
            super.setContentView(view);
            return;
        }
        r();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        onContentChanged();
    }

    @Override // stepos.support.v7.app.d, b.q, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f40527d.booleanValue()) {
            super.setContentView(view, layoutParams);
            return;
        }
        r();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        onContentChanged();
    }
}
