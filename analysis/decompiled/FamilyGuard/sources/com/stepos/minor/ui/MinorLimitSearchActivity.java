package com.stepos.minor.ui;

import C2.i;
import T1.h;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.C;
import androidx.lifecycle.U;
import com.stepos.common.widget.SearchEditText;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.A;
import com.stepos.familyguard.ui.usage.PackageLimitManagerSearchFragment;
import j2.u;
import org.libpag.BuildConfig;
import v2.C1183b;
import v2.d;
import v2.e;

/* loaded from: classes.dex */
public class MinorLimitSearchActivity extends com.stepos.familyguard.ui.base.a implements TextWatcher {

    /* renamed from: c, reason: collision with root package name */
    private A f15388c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f15389d = false;

    /* renamed from: e, reason: collision with root package name */
    private View f15390e;

    /* renamed from: f, reason: collision with root package name */
    private View f15391f;

    /* renamed from: g, reason: collision with root package name */
    private SearchEditText f15392g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f15393h;

    /* renamed from: i, reason: collision with root package name */
    private u f15394i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f15395j;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0() {
        i.b(this, this.f15392g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean e0(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f15395j = false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(View view) {
        this.f15392g.setText(BuildConfig.FLAVOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0() {
        i.c(this.f15392g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(DataToken dataToken) {
        try {
            this.f15388c.C();
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(boolean z5) {
        this.f15389d = z5;
        if (z5) {
            try {
                this.f15388c.C();
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    public static void k0(Context context, int i5, long j5) {
        Intent intent = new Intent(context, (Class<?>) MinorLimitSearchActivity.class);
        intent.putExtra("proxy", i5);
        intent.putExtra("operator_id", j5);
        context.startActivity(intent);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(this.f15392g.getText())) {
            this.f15393h.setVisibility(8);
        } else {
            this.f15393h.setVisibility(0);
        }
        this.f15388c.j0(editable.toString());
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    protected e c0() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("proxy", 0);
        long longExtra = intent.getLongExtra("operator_id", -1L);
        if (intExtra == 0) {
            return new C1183b(this);
        }
        d dVar = new d(longExtra);
        dVar.init();
        return dVar;
    }

    @Override // android.app.Activity
    public void finish() {
        i.b(this, this.f15392g);
        super.finish();
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().setWindowAnimations(R.style.Animation_StepOS_Activity_Search);
        A a6 = (A) new U(this).a(A.class);
        this.f15388c = a6;
        a6.c0(c0());
        this.f15388c.b().g(this, new C() { // from class: H2.I
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f2720a.j0(((Boolean) obj).booleanValue());
            }
        });
        this.f15388c.U().g(this, new C() { // from class: H2.J
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f2722a.i0((DataToken) obj);
            }
        });
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (!isFinishing()) {
            this.f15395j = true;
        }
        i.b(this, this.f15392g);
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        if (this.f15389d) {
            try {
                this.f15388c.x();
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        if (z5 && this.f15395j) {
            i.b(this, this.f15392g);
            SearchEditText searchEditText = this.f15392g;
            if (searchEditText != null) {
                searchEditText.post(new Runnable() { // from class: H2.K
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2724a.d0();
                    }
                });
            }
        }
    }

    @Override // i2.AbstractActivityC0758a
    protected void w(View view) {
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        u uVarC = u.c(getLayoutInflater());
        this.f15394i = uVarC;
        return uVarC.b();
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) {
        super.y(view, bundle);
        if (bundle == null) {
            PackageLimitManagerSearchFragment packageLimitManagerSearchFragment = new PackageLimitManagerSearchFragment();
            packageLimitManagerSearchFragment.G1(getIntent().getExtras());
            getSupportFragmentManager().m().s(R.id.fragment_container, packageLimitManagerSearchFragment).i();
        }
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        super.z();
        ColorDrawable colorDrawable = new ColorDrawable(h.a(this, R.attr.colorSurface));
        View viewInflate = getLayoutInflater().inflate(R.layout.mc_search_layout_button, (ViewGroup) null, false);
        this.f15390e = viewInflate;
        this.f15391f = viewInflate.findViewById(R.id.mc_cancel_textView);
        this.f15393h = (ImageView) this.f15390e.findViewById(R.id.mc_search_icon_input_clear);
        SearchEditText searchEditText = (SearchEditText) this.f15390e.findViewById(R.id.mc_search_edit);
        this.f15392g = searchEditText;
        searchEditText.setHintTextColor(h.a(this, R.attr.colorSurfaceContainerHighest));
        this.f15392g.setTextAppearance(R.style.TextAppearance_StepOS_Body_Medium);
        this.f15392g.setHintTextColor(h.a(this, R.attr.colorSurfaceContainerHighest));
        this.f15390e.findViewById(R.id.mc_voice_icon).setVisibility(8);
        this.f15392g.addTextChangedListener(this);
        this.f15392g.setOnTouchListener(new View.OnTouchListener() { // from class: H2.L
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f2739a.e0(view, motionEvent);
            }
        });
        this.f15393h.setOnClickListener(new View.OnClickListener() { // from class: H2.M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2742a.f0(view);
            }
        });
        this.f15391f.setOnClickListener(new View.OnClickListener() { // from class: H2.N
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2745a.g0(view);
            }
        });
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        supportActionBar.y(colorDrawable);
        supportActionBar.p().g(colorDrawable);
        supportActionBar.E(false);
        supportActionBar.J(false);
        supportActionBar.G(true);
        supportActionBar.B(this.f15390e);
        this.f15392g.requestFocus();
        this.f15392g.post(new Runnable() { // from class: H2.O
            @Override // java.lang.Runnable
            public final void run() {
                this.f2747a.h0();
            }
        });
    }
}
