package com.stepos.familyguard.ui.usage;

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
import androidx.fragment.app.ComponentCallbacksC0511f;
import com.stepos.common.widget.SearchEditText;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.familyguard.R;
import org.libpag.BuildConfig;
import v2.C1183b;
import w2.I0;

/* loaded from: classes.dex */
public class LimitSearchActivity extends I0 implements TextWatcher {

    /* renamed from: d, reason: collision with root package name */
    private A f14911d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f14912e = false;

    /* renamed from: f, reason: collision with root package name */
    private View f14913f;

    /* renamed from: g, reason: collision with root package name */
    private View f14914g;

    /* renamed from: h, reason: collision with root package name */
    private SearchEditText f14915h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f14916i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14917j;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0() {
        C2.i.b(this, this.f14915h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean g0(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f14917j = false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(View view) {
        this.f14915h.setText(BuildConfig.FLAVOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(DataToken dataToken) {
        try {
            this.f14911d.q(dataToken);
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(boolean z5) {
        this.f14912e = z5;
        if (z5) {
            try {
                this.f14911d.C();
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    public static void l0(Context context, int i5, long j5) {
        Intent intent = new Intent(context, (Class<?>) LimitSearchActivity.class);
        intent.putExtra("proxy", i5);
        intent.putExtra("operator_id", j5);
        context.startActivity(intent);
    }

    @Override // w2.I0
    protected ComponentCallbacksC0511f V(int i5) {
        return i5 == 0 ? new PackageLimitManagerSearchFragment() : new CategoryLimitManagerSearchFragment();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(this.f14915h.getText())) {
            this.f14916i.setVisibility(8);
        } else {
            this.f14916i.setVisibility(0);
        }
        this.f14911d.j0(editable.toString());
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    protected v2.e e0() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("proxy", 0);
        long longExtra = intent.getLongExtra("operator_id", -1L);
        if (intExtra == 0) {
            return new C1183b(this);
        }
        v2.d dVar = new v2.d(longExtra);
        dVar.init();
        return dVar;
    }

    @Override // android.app.Activity
    public void finish() {
        C2.i.b(this, this.f14915h);
        super.finish();
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setWindowAnimations(R.style.Animation_StepOS_Activity_Search);
        A a6 = (A) new androidx.lifecycle.U(this).a(A.class);
        this.f14911d = a6;
        a6.c0(e0());
        this.f14911d.b().g(this, new androidx.lifecycle.C() { // from class: w2.q0
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23641a.k0(((Boolean) obj).booleanValue());
            }
        });
        this.f14911d.U().g(this, new androidx.lifecycle.C() { // from class: w2.r0
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23659a.j0((DataToken) obj);
            }
        });
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (!isFinishing()) {
            this.f14917j = true;
        }
        C2.i.b(this, this.f14915h);
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        if (this.f14912e) {
            try {
                this.f14911d.x();
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
        if (z5 && this.f14917j) {
            C2.i.b(this, this.f14915h);
            SearchEditText searchEditText = this.f14915h;
            if (searchEditText != null) {
                searchEditText.post(new Runnable() { // from class: w2.s0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f23662a.f0();
                    }
                });
            }
        }
    }

    @Override // i2.AbstractActivityC0758a
    protected void w(View view) {
    }

    @Override // w2.I0, i2.AbstractActivityC0758a
    protected void z() {
        super.z();
        ColorDrawable colorDrawable = new ColorDrawable(T1.h.a(this, R.attr.colorSurface));
        View viewInflate = getLayoutInflater().inflate(R.layout.mc_search_layout_button, (ViewGroup) null, false);
        this.f14913f = viewInflate;
        this.f14914g = viewInflate.findViewById(R.id.mc_cancel_textView);
        this.f14916i = (ImageView) this.f14913f.findViewById(R.id.mc_search_icon_input_clear);
        SearchEditText searchEditText = (SearchEditText) this.f14913f.findViewById(R.id.mc_search_edit);
        this.f14915h = searchEditText;
        searchEditText.setHintTextColor(T1.h.a(this, R.attr.colorSurfaceContainerHighest));
        this.f14915h.setTextAppearance(R.style.TextAppearance_StepOS_Body_Medium);
        this.f14915h.setHintTextColor(T1.h.a(this, R.attr.colorSurfaceContainerHighest));
        this.f14913f.findViewById(R.id.mc_voice_icon).setVisibility(8);
        this.f14915h.addTextChangedListener(this);
        this.f14915h.setOnTouchListener(new View.OnTouchListener() { // from class: w2.t0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f23668a.g0(view, motionEvent);
            }
        });
        this.f14916i.setOnClickListener(new View.OnClickListener() { // from class: w2.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23670a.h0(view);
            }
        });
        this.f14914g.setOnClickListener(new View.OnClickListener() { // from class: w2.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f23674a.i0(view);
            }
        });
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        supportActionBar.y(colorDrawable);
        supportActionBar.p().g(colorDrawable);
        supportActionBar.E(false);
        supportActionBar.B(this.f14913f);
    }
}
