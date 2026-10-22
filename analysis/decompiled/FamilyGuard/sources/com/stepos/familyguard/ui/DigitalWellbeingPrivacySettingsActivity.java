package com.stepos.familyguard.ui;

import D3.a;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.C;
import com.stepos.familyguard.R;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.widget.list.StepOSListItem;
import j2.C0786c;
import p2.g;
import v2.C1183b;
import w2.W0;
import w2.X0;
import x3.AbstractC1286b;

/* loaded from: classes.dex */
public class DigitalWellbeingPrivacySettingsActivity extends PrivacySettingsActivity {

    /* renamed from: c, reason: collision with root package name */
    private C0786c f14778c;

    /* renamed from: d, reason: collision with root package name */
    private X0 f14779d;

    private void f0() {
        this.f14778c.f17690c.setOnItemClickListener(new StepOSListItem.c() { // from class: q2.b
            @Override // com.stepos.widget.list.StepOSListItem.c
            public final void a(StepOSListItem stepOSListItem) {
                this.f19912a.g0(stepOSListItem);
            }
        });
        this.f14778c.f17691d.setOnItemClickListener(new StepOSListItem.c() { // from class: q2.c
            @Override // com.stepos.widget.list.StepOSListItem.c
            public final void a(StepOSListItem stepOSListItem) {
                this.f19913a.h0(stepOSListItem);
            }
        });
        this.f14778c.f17692e.setOnItemClickListener(new StepOSListItem.c() { // from class: q2.d
            @Override // com.stepos.widget.list.StepOSListItem.c
            public final void a(StepOSListItem stepOSListItem) {
                this.f19914a.j0(stepOSListItem);
            }
        });
        this.f14778c.f17689b.setOnItemClickListener(new StepOSListItem.c() { // from class: q2.e
            @Override // com.stepos.widget.list.StepOSListItem.c
            public final void a(StepOSListItem stepOSListItem) {
                this.f19915a.k0(stepOSListItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(StepOSListItem stepOSListItem) {
        q0(getString(R.string.fg_personal_information_collection_list_title), "picl");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(StepOSListItem stepOSListItem) {
        q0(getString(R.string.fg_privacy_policy_title), "pp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(boolean z5) {
        if (z5) {
            finishAffinity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(StepOSListItem stepOSListItem) {
        g.S(this, new g.l() { // from class: q2.i
            @Override // p2.g.l
            public final void a(boolean z5) {
                this.f19919a.i0(z5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(StepOSListItem stepOSListItem) {
        q0(getString(R.string.fg_child_personal_information_collection_list_title), "pcpi");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0() {
        this.f14779d.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            AbstractC1286b.c(new a() { // from class: q2.h
                @Override // D3.a
                public final void run() {
                    this.f19918a.l0();
                }
            }).j(T3.a.c()).f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(Long l5) {
        this.f14778c.f17692e.setVisibility(l5 != null && (l5.longValue() > (-1L) ? 1 : (l5.longValue() == (-1L) ? 0 : -1)) == 0 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(View view) {
        getOnBackPressedDispatcher().k();
    }

    private void p0() {
        W0 w02 = new W0(new C1183b(this));
        this.f14779d = w02;
        w02.H();
        this.f14779d.b().g(this, new C() { // from class: q2.f
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f19916a.m0((Boolean) obj);
            }
        });
        this.f14779d.J().g(this, new C() { // from class: q2.g
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f19917a.n0((Long) obj);
            }
        });
    }

    private void q0(String str, String str2) {
        g.C(this, str, str2, PolicySdkToolsUtils.Companion.getLanguage(), false);
    }

    @Override // com.stepos.familyguard.ui.PrivacySettingsActivity
    protected void V(Bundle bundle) throws Resources.NotFoundException {
        C0786c c0786cC = C0786c.c(getLayoutInflater());
        this.f14778c = c0786cC;
        LinearLayout linearLayoutB = c0786cC.b();
        super.y(linearLayoutB, bundle);
        setContentView(linearLayoutB);
        x2.g.e(this.f14778c.f17694g, getString(R.string.fg_privacy_settings_title), new View.OnClickListener() { // from class: q2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19911a.o0(view);
            }
        });
        f0();
        p0();
    }

    @Override // com.stepos.familyguard.ui.PrivacySettingsActivity, i2.AbstractActivityC0758a
    protected void z() {
        x2.g.d(this);
    }
}
