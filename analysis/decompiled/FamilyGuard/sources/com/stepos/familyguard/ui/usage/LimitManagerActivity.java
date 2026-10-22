package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.ComponentCallbacksC0511f;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.familyguard.R;
import j2.C0779B;
import j2.C0787d;
import stepos.support.v7.app.a;
import v2.C1183b;
import w2.I0;

/* loaded from: classes.dex */
public class LimitManagerActivity extends I0 implements a.j {

    /* renamed from: d, reason: collision with root package name */
    private z f14907d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f14908e = false;

    /* renamed from: f, reason: collision with root package name */
    private long f14909f;

    /* renamed from: g, reason: collision with root package name */
    private C0787d f14910g;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(View view) {
        getOnBackPressedDispatcher().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(View view) throws Resources.NotFoundException {
        this.f23565c.f17634b.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) throws Resources.NotFoundException {
        this.f23565c.f17634b.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(DataToken dataToken) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(boolean z5) {
        this.f14908e = z5;
        if (z5) {
            try {
                this.f14907d.C();
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    private void l0(TextView textView, boolean z5) {
        textView.setSelected(z5);
    }

    public static void m0(Context context) {
        n0(context, 0, -1L);
    }

    public static void n0(Context context, int i5, long j5) {
        Intent intent = new Intent(context, (Class<?>) LimitManagerActivity.class);
        intent.putExtra("proxy", i5);
        intent.putExtra("operator_id", j5);
        context.startActivity(intent);
    }

    private void o0() {
        Intent intent = getIntent();
        LimitSearchActivity.l0(this, intent.getIntExtra("proxy", 0), intent.getLongExtra("operator_id", this.f14909f));
    }

    private void p0(int i5) {
        C0787d c0787d = this.f14910g;
        if (c0787d == null) {
            return;
        }
        boolean z5 = i5 == 0;
        l0(c0787d.f17696b, z5);
        l0(this.f14910g.f17697c, !z5);
    }

    @Override // w2.I0
    protected ComponentCallbacksC0511f V(int i5) {
        return i5 == 0 ? new PackageLimitManagerFragment() : new CategoryLimitManagerFragment();
    }

    @Override // w2.I0
    protected void X(int i5) {
        p0(i5);
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

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14909f = getIntent().getLongExtra("operator_id", -1L);
        z zVar = (z) new androidx.lifecycle.U(this).a(z.class);
        this.f14907d = zVar;
        zVar.c0(e0());
        this.f14907d.b().g(this, new androidx.lifecycle.C() { // from class: w2.j0
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23624a.k0(((Boolean) obj).booleanValue());
            }
        });
        this.f14907d.U().g(this, new androidx.lifecycle.C() { // from class: w2.k0
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23627a.j0((DataToken) obj);
            }
        });
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        if (this.f14908e) {
            try {
                this.f14907d.C();
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // w2.I0, com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        C0787d c0787dC = C0787d.c(getLayoutInflater());
        this.f14910g = c0787dC;
        this.f23565c = C0779B.a(c0787dC.f17700f);
        return this.f14910g.b();
    }

    @Override // w2.I0, i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) throws Resources.NotFoundException {
        super.y(view, bundle);
        x2.g.f(this.f14910g.f17699e, getString(R.string.us_usage_limit), new View.OnClickListener() { // from class: w2.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f23630a.f0(view2);
            }
        }, R.drawable.stepos_icon_search, getString(R.string.mc_search), new View.OnClickListener() { // from class: w2.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f23632a.g0(view2);
            }
        });
        this.f14910g.f17696b.setOnClickListener(new View.OnClickListener() { // from class: w2.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws Resources.NotFoundException {
                this.f23634a.h0(view2);
            }
        });
        this.f14910g.f17697c.setOnClickListener(new View.OnClickListener() { // from class: w2.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws Resources.NotFoundException {
                this.f23638a.i0(view2);
            }
        });
        p0(0);
    }

    @Override // w2.I0, i2.AbstractActivityC0758a
    protected void z() {
        x2.g.d(this);
    }
}
