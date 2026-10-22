package com.stepos.familyguard.ui.main;

import android.animation.AnimatorInflater;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.C;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.DigitalWellbeingPrivacySettingsActivity;
import com.stepos.familyguard.ui.base.a;
import com.stepos.familyguard.ui.usage.DigitalWellbeingActivity;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.list.StepOSListItem;
import j2.m;
import p2.g;
import p3.j;
import p3.w;
import v2.C1183b;
import v2.e;
import w2.W0;
import w2.X0;
import x3.AbstractC1286b;
import z3.C1347a;

/* loaded from: classes.dex */
public class DigitalWellbeingSettingsActivity extends a {

    /* renamed from: c, reason: collision with root package name */
    private m f14856c;

    /* renamed from: d, reason: collision with root package name */
    private Dialog f14857d;

    /* renamed from: e, reason: collision with root package name */
    private X0 f14858e;

    private void e0() {
        Intent intent = new Intent(this, (Class<?>) DigitalWellbeingActivity.class);
        intent.setFlags(67141632);
        startActivity(intent);
        finish();
    }

    private void f0() {
        AbstractC1286b.d(new Runnable() { // from class: u2.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f22864a.j0();
            }
        }).j(T3.a.c()).e(C1347a.a()).g(new D3.a() { // from class: u2.i
            @Override // D3.a
            public final void run() {
                this.f22865a.k0();
            }
        });
    }

    private static void h0(View view) {
        while (view != null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                viewGroup.setClipChildren(false);
                viewGroup.setClipToPadding(false);
            }
            if (view.getId() == R.id.stepos_dialog_parent_panel) {
                return;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
    }

    private void i0(j jVar, View view) {
        StepOSButton stepOSButtonB = jVar.b(-2);
        if (stepOSButtonB != null) {
            stepOSButtonB.setText(R.string.fg_common_cancel);
            stepOSButtonB.setStateListAnimator(AnimatorInflater.loadStateListAnimator(this, R.animator.stepos_button_press));
            h0(stepOSButtonB);
        }
        h0(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0() {
        try {
            this.f14858e.setEnable(false);
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0() {
        if (!isFinishing()) {
            finishAffinity();
        }
        AppWidgetManagerService.n(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            try {
                this.f14858e.g();
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        getOnBackPressedDispatcher().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(StepOSListItem stepOSListItem) {
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(StepOSListItem stepOSListItem) throws Resources.NotFoundException {
        s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://beian.miit.gov.cn/"));
        intent.setPackage("com.android.browser");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(j jVar, View view) {
        jVar.dismiss();
        f0();
    }

    private void r0() {
        Intent intent = new Intent();
        intent.setClass(this, DigitalWellbeingPrivacySettingsActivity.class);
        intent.putExtra("from", 2);
        startActivity(intent);
    }

    private void s0() throws Resources.NotFoundException {
        Dialog dialog = this.f14857d;
        if (dialog != null && dialog.isShowing()) {
            this.f14857d.cancel();
        }
        X0 x02 = this.f14858e;
        if (x02 == null || x02.J().e() == null) {
            return;
        }
        if (this.f14858e.J().e().longValue() != -1) {
            j jVarB = new j.a(this).h(R.string.us_can_not_close_digital_wellbeing_minor_mode).g(R.string.us_known, new DialogInterface.OnClickListener() { // from class: u2.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    dialogInterface.cancel();
                }
            }).b();
            this.f14857d = jVarB;
            jVarB.show();
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_dialog_button_height);
        int iMax = Math.max(1, Math.round(dimensionPixelSize * 0.03f));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setClipChildren(false);
        linearLayout.setClipToPadding(false);
        linearLayout.setPadding(iMax, iMax, iMax, iMax);
        StepOSButton stepOSButton = new StepOSButton(this, null, 0, R.style.StepOSWidget_Button_Secondary_Destructive);
        stepOSButton.setText(R.string.us_close_digital_wellbeing);
        linearLayout.addView(stepOSButton, new LinearLayout.LayoutParams(-1, dimensionPixelSize));
        final j jVarB2 = new w.a(this).h(R.string.us_close_digital_wellbeing_des).i(linearLayout).b();
        stepOSButton.setOnClickListener(new View.OnClickListener() { // from class: u2.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22862a.q0(jVarB2, view);
            }
        });
        this.f14857d = jVarB2;
        jVarB2.show();
        i0(jVarB2, stepOSButton);
    }

    protected e g0() {
        return new C1183b(this);
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!g.x(this)) {
            e0();
            return;
        }
        W0 w02 = new W0(g0());
        this.f14858e = w02;
        w02.H();
        this.f14858e.b().g(this, new C() { // from class: u2.e
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f22861a.l0((Boolean) obj);
            }
        });
    }

    @Override // com.stepos.familyguard.ui.base.a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (g.x(this)) {
            return;
        }
        e0();
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        m mVarC = m.c(getLayoutInflater());
        this.f14856c = mVarC;
        return mVarC.b();
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) throws Resources.NotFoundException {
        super.y(view, bundle);
        x2.g.e(this.f14856c.f17734f, getString(R.string.fg_settings), new View.OnClickListener() { // from class: u2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f22857a.m0(view2);
            }
        });
        this.f14856c.f17732d.setOnItemClickListener(new StepOSListItem.c() { // from class: u2.b
            @Override // com.stepos.widget.list.StepOSListItem.c
            public final void a(StepOSListItem stepOSListItem) {
                this.f22858a.n0(stepOSListItem);
            }
        });
        this.f14856c.f17731c.setOnItemClickListener(new StepOSListItem.c() { // from class: u2.c
            @Override // com.stepos.widget.list.StepOSListItem.c
            public final void a(StepOSListItem stepOSListItem) throws Resources.NotFoundException {
                this.f22859a.o0(stepOSListItem);
            }
        });
        this.f14856c.f17730b.setSingleLine(false);
        this.f14856c.f17730b.setMaxLines(2);
        this.f14856c.f17730b.setEllipsize(null);
        this.f14856c.f17730b.setText(R.string.fg_app_icp);
        this.f14856c.f17730b.setOnClickListener(new View.OnClickListener() { // from class: u2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f22860a.p0(view2);
            }
        });
        T1.g.c(1.18f, this.f14856c.f17730b);
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        x2.g.d(this);
    }
}
