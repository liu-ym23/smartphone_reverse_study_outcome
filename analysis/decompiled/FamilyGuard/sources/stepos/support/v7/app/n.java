package stepos.support.v7.app;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes.dex */
public abstract class n extends d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f20848a;

    /* renamed from: b, reason: collision with root package name */
    private Toolbar f20849b;

    /* renamed from: c, reason: collision with root package name */
    private o f20850c;

    /* renamed from: d, reason: collision with root package name */
    private Boolean f20851d = Boolean.TRUE;

    /* renamed from: e, reason: collision with root package name */
    private int f20852e = X4.k.f6076d;

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(X4.f.f6018t0);
        this.f20849b = toolbar;
        setSupportActionBar(toolbar);
        this.f20850c = new o(this);
    }

    private void t() {
        if (this.f20848a) {
            return;
        }
        super.setContentView(X4.h.f6029a);
        View viewFindViewById = findViewById(X4.f.f6015s);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        if (viewGroup != null) {
            viewGroup.setId(-1);
            viewFindViewById.setId(R.id.content);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
        }
        this.f20848a = true;
        initView();
    }

    void A(float f5) {
        x(f5);
    }

    void B() {
        y();
    }

    void C() {
        z();
    }

    void D() {
        super.finish();
    }

    void E() {
        super.onBackPressed();
        B();
    }

    @Override // stepos.support.v7.app.d, androidx.activity.h, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f20851d.booleanValue()) {
            super.addContentView(view, layoutParams);
            return;
        }
        t();
        ((ViewGroup) findViewById(R.id.content)).addView(view, layoutParams);
        onContentChanged();
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.f20851d.booleanValue()) {
            this.f20850c.n();
        } else {
            super.finish();
            overridePendingTransition(H1.a.f2046a, H1.a.f2047b);
        }
    }

    @Override // stepos.support.v7.app.d, androidx.activity.h, android.app.Activity
    public void onBackPressed() {
        if (this.f20851d.booleanValue()) {
            this.f20850c.p();
        } else {
            super.onBackPressed();
        }
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.f20851d = Boolean.valueOf(bundle.getBoolean("popup_activity", this.f20851d.booleanValue()));
            this.f20852e = bundle.getInt("popup_theme_id", this.f20852e);
        } else if (getIntent() != null) {
            Intent intent = getIntent();
            this.f20851d = Boolean.valueOf(intent.getBooleanExtra("popup_activity", this.f20851d.booleanValue()));
            this.f20852e = intent.getIntExtra("popup_theme_id", this.f20852e);
        }
        if (w()) {
            getTheme().applyStyle(this.f20852e, true);
            t();
            this.f20850c.m();
        } else {
            setTheme(this.f20852e);
            overridePendingTransition(H1.a.f2048c, H1.a.f2049d);
        }
        super.onCreate(bundle);
        getWindow().setWindowAnimations(H1.l.f2378j);
        if (w()) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1280);
        }
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f20851d.booleanValue()) {
            this.f20850c.o();
        }
    }

    @Override // stepos.support.v7.app.d, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("popup_activity", this.f20851d.booleanValue());
        bundle.putInt("popup_theme_id", this.f20852e);
    }

    @Override // stepos.support.v7.app.d, androidx.activity.h, android.app.Activity
    public void setContentView(int i5) {
        if (!this.f20851d.booleanValue()) {
            super.setContentView(i5);
            return;
        }
        t();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this).inflate(i5, viewGroup);
        onContentChanged();
    }

    protected void u(boolean z5) {
        finish();
    }

    public m v() {
        return this.f20850c;
    }

    protected boolean w() {
        return this.f20851d.booleanValue();
    }

    protected void x(float f5) {
    }

    protected void y() {
    }

    protected void z() {
    }

    @Override // stepos.support.v7.app.d, androidx.activity.h, android.app.Activity
    public void setContentView(View view) {
        if (!this.f20851d.booleanValue()) {
            super.setContentView(view);
            return;
        }
        t();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        onContentChanged();
    }

    @Override // stepos.support.v7.app.d, androidx.activity.h, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f20851d.booleanValue()) {
            super.setContentView(view, layoutParams);
            return;
        }
        t();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        onContentChanged();
    }
}
