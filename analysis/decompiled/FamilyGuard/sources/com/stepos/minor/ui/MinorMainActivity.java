package com.stepos.minor.ui;

import A3.c;
import F2.z;
import G2.u;
import G2.v;
import H2.ViewOnClickListenerC0321j0;
import I2.b;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.ComponentCallbacksC0511f;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.familyguard.R;
import com.stepos.widget.toolbar.StepOSTitleBar;
import f2.C0702g;
import j2.C0788e;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.libpag.BuildConfig;
import p2.g;
import q2.j;
import stepos.support.v7.widget.r;
import x2.g;
import x3.AbstractC1286b;
import x3.f;
import z3.C1347a;

/* loaded from: classes.dex */
public class MinorMainActivity extends j {

    /* renamed from: d, reason: collision with root package name */
    private F2.j f15396d;

    /* renamed from: g, reason: collision with root package name */
    private int f15399g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f15401i;

    /* renamed from: j, reason: collision with root package name */
    private C0788e f15402j;

    /* renamed from: k, reason: collision with root package name */
    private StepOSTitleBar f15403k;

    /* renamed from: e, reason: collision with root package name */
    private c f15397e = null;

    /* renamed from: f, reason: collision with root package name */
    private c f15398f = null;

    /* renamed from: h, reason: collision with root package name */
    private int f15400h = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(View view) {
        r rVar = new r(this, view, 8388613);
        rVar.h(R.menu.menu_minor_main);
        final MenuItem menuItemFindItem = rVar.f().findItem(R.id.menu_shortcut);
        if (menuItemFindItem != null) {
            f.x(new Callable() { // from class: H2.Q
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f2749a.w0();
                }
            }).X(T3.a.c()).G(C1347a.a()).T(new D3.c() { // from class: H2.S
                @Override // D3.c
                public final void accept(Object obj) {
                    Boolean bool = (Boolean) obj;
                    menuItemFindItem.setEnabled(!bool.booleanValue());
                }
            }, S1.a.b());
        }
        rVar.j(new r.b() { // from class: H2.T
            @Override // stepos.support.v7.widget.r.b
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f2754a.x0(menuItem);
            }
        });
        rVar.k();
    }

    private void h0() {
        u uVarF = j0().f();
        if (uVarF == null) {
            return;
        }
        z id = uVarF.getId();
        if (id == z.MINOR_MODE_ON) {
            y0();
        } else if (id == z.MINOR_MODE_OFF) {
            A0();
        } else if (id == z.INIT_MINOR_AND_START) {
            z0();
        }
    }

    private void i0() {
        super.finish();
        if (m0()) {
            overridePendingTransition(R.anim.stepos_activity_to_next_close_enter, R.anim.stepos_activity_to_next_close_exit);
        }
    }

    private boolean m0() {
        return TextUtils.equals(getIntent().getAction(), "stepos.minor.intent.action.CONFIG");
    }

    private boolean n0() {
        u uVarF = j0().f();
        if (uVarF == null) {
            return false;
        }
        z id = uVarF.getId();
        return id == z.MINOR_MODE_ON || id == z.MINOR_MODE_OFF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(DialogInterface dialogInterface, int i5) {
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(DialogInterface dialogInterface, int i5) {
        I2.c.e(this);
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(int i5, int i6, Intent intent) {
        j0().k(i5, i6, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(boolean z5) {
        u uVarF = this.f15396d.k().f();
        C0702g.b("MinorMainActivity", "timer called with: state = [" + uVarF + "]");
        if (uVarF == null) {
            this.f15396d.k().q(z.INIT);
        } else if (uVarF.f() && !uVarF.b()) {
            uVarF.d(this);
        } else if (!uVarF.f()) {
            if (!z5 || uVarF.e()) {
                if (z5) {
                    C0702g.b("MinorMainActivity", "relaunch overlay after restore, state = [" + uVarF + "]");
                }
                uVarF.h(this, null);
            } else {
                C0702g.b("MinorMainActivity", "skip onEnter on restore, state = [" + uVarF + "]");
            }
        }
        int iB = j0().b();
        if (iB < 0 || isFinishing()) {
            return;
        }
        C0702g.b("MinorMainActivity", "relaunch password after uiMode recreate, requestCode = [" + iB + "]");
        b.c(this, iB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(boolean z5) {
        if (z5) {
            AppWidgetManagerService.n(this);
        } else {
            finish();
            R1.a.a("MinorMainActivity", "no per finish");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        getOnBackPressedDispatcher().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(View view) {
        getOnBackPressedDispatcher().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View view) {
        getOnBackPressedDispatcher().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean w0() {
        return Boolean.valueOf(I2.c.j(this, getPackageName(), MinorMainActivity.class.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean x0(MenuItem menuItem) {
        ComponentCallbacksC0511f componentCallbacksC0511fF0 = getSupportFragmentManager().f0(R.id.fragment_container);
        if (componentCallbacksC0511fF0 instanceof ViewOnClickListenerC0321j0) {
            return componentCallbacksC0511fF0.J0(menuItem);
        }
        return false;
    }

    public void A0() {
        StepOSTitleBar stepOSTitleBar = this.f15403k;
        if (stepOSTitleBar == null) {
            return;
        }
        stepOSTitleBar.setVisibility(0);
        g.h(this.f15403k, BuildConfig.FLAVOR, new View.OnClickListener() { // from class: H2.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2769a.v0(view);
            }
        });
        setTitle(BuildConfig.FLAVOR);
    }

    public void C0() {
        StepOSTitleBar stepOSTitleBar = this.f15403k;
        if (stepOSTitleBar != null) {
            stepOSTitleBar.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.f15401i || isChangingConfigurations() || !n0() || I2.c.k(this)) {
            i0();
            return;
        }
        this.f15401i = true;
        I2.c.h(this, true);
        new AlertDialog.Builder(this).setView(R.layout.minorshortcuts_dialog_custom_view).setCancelable(false).setPositiveButton(R.string.fg_minor_add_shortcuts_dialog_positive_btn, new DialogInterface.OnClickListener() { // from class: H2.V
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f2757a.p0(dialogInterface, i5);
            }
        }).setNegativeButton(R.string.fg_minor_add_shortcuts_dialog_negative_btn, new DialogInterface.OnClickListener() { // from class: H2.W
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f2760a.o0(dialogInterface, i5);
            }
        }).show();
    }

    public v j0() {
        return F2.j.j(getApplication()).k();
    }

    public void k0(int i5) {
        if (isFinishing() || isDestroyed() || i5 == this.f15399g) {
            return;
        }
        this.f15399g = i5;
        G();
        int iH = j0().h();
        if (iH >= 0) {
            this.f15400h = iH;
            C0702g.b("MinorMainActivity", "finish password for uiMode refresh, requestCode = [" + iH + "]");
            try {
                finishActivity(iH);
                return;
            } catch (Exception e6) {
                this.f15400h = -1;
                C0702g.r("MinorMainActivity", e6);
                return;
            }
        }
        u uVarF = j0().f();
        if (uVarF == null || !uVarF.e()) {
            C0702g.b("MinorMainActivity", "recreate for uiMode refresh");
            recreate();
            return;
        }
        C0702g.b("MinorMainActivity", "skip recreate for overlay, state = [" + uVarF + "]");
    }

    public void l0() {
        StepOSTitleBar stepOSTitleBar = this.f15403k;
        if (stepOSTitleBar != null) {
            stepOSTitleBar.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.ActivityC0516k, androidx.activity.h, android.app.Activity
    protected void onActivityResult(final int i5, final int i6, final Intent intent) {
        super.onActivityResult(i5, i6, intent);
        C0702g.b("MinorMainActivity", "onActivityResult() called with: requestCode = [" + i5 + "], resultCode = [" + i6 + "], data = [" + intent + "] this = " + this);
        j0().c(i5);
        if (i5 == this.f15400h) {
            this.f15400h = -1;
            if (i6 == 0 && !isFinishing()) {
                C0702g.b("MinorMainActivity", "recreate then relaunch password after uiMode, requestCode = [" + i5 + "]");
                j0().p(i5);
                recreate();
                return;
            }
        }
        u uVarF = j0().f();
        if (i6 != 0 || uVarF == null || (uVarF.getId() != z.VERIFY_PASSWORD_TO_START && uVarF.getId() != z.VERIFY_PASSWORD_TO_START_HOME)) {
            c cVar = this.f15397e;
            if (cVar != null && !cVar.g()) {
                this.f15397e.dispose();
            }
            this.f15397e = AbstractC1286b.k(10L, TimeUnit.MILLISECONDS).e(C1347a.a()).g(new D3.a() { // from class: H2.c0
                @Override // D3.a
                public final void run() {
                    this.f2771a.q0(i5, i6, intent);
                }
            });
            return;
        }
        C0702g.b("MinorMainActivity", "finish immediately after entry password canceled");
        if (m0()) {
            finish();
            overridePendingTransition(R.anim.stepos_activity_to_next_close_enter, R.anim.stepos_activity_to_next_close_exit);
        } else {
            overridePendingTransition(R.anim.fg_no_anim, R.anim.fg_no_anim);
            finishAndRemoveTask();
            overridePendingTransition(R.anim.fg_no_anim, R.anim.fg_no_anim);
        }
    }

    @Override // stepos.support.v7.app.d, androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        k0(configuration.uiMode & 48);
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0702g.b("MinorMainActivity", "onCreate() called with: savedInstanceState = [" + bundle + "]");
        this.f15396d = F2.j.j(getApplication());
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 34 && !m0()) {
            overrideActivityTransition(1, R.anim.fg_no_anim, R.anim.fg_no_anim);
        }
        this.f15396d.k().n(this);
        this.f15399g = getResources().getConfiguration().uiMode & 48;
        final boolean z5 = bundle != null;
        this.f15398f = AbstractC1286b.k(0L, TimeUnit.MILLISECONDS).e(C1347a.a()).g(new D3.a() { // from class: H2.a0
            @Override // D3.a
            public final void run() {
                this.f2766a.r0(z5);
            }
        });
    }

    @Override // com.stepos.familyguard.ui.base.a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C0702g.b("MinorMainActivity", "onDestroy() called");
        c cVar = this.f15397e;
        if (cVar != null && !cVar.g()) {
            this.f15397e.dispose();
        }
        c cVar2 = this.f15398f;
        if (cVar2 == null || cVar2.g()) {
            return;
        }
        this.f15398f.dispose();
    }

    @Override // androidx.activity.h, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C0702g.b("MinorMainActivity", "onNewIntent() called with: intent = [" + intent + "]");
        this.f15396d.k().n(this);
        c cVar = this.f15397e;
        if (cVar != null && !cVar.g()) {
            this.f15397e.dispose();
        }
        v vVarK = this.f15396d.k();
        if (vVarK != null) {
            vVarK.j(9);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        C0702g.b("MinorMainActivity", "onRestart() called");
    }

    @Override // com.stepos.familyguard.ui.base.a, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (p2.g.P(this)) {
            p2.g.R(this, new g.k() { // from class: H2.X
                @Override // p2.g.k
                public final void a(boolean z5) {
                    this.f2761a.s0(z5);
                }
            });
        }
        C0702g.b("MinorMainActivity", "onStart() called this = " + this);
    }

    @Override // com.stepos.familyguard.ui.base.a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStop() {
        super.onStop();
        C0702g.b("MinorMainActivity", "onStop() called");
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        C0788e c0788eC = C0788e.c(getLayoutInflater());
        this.f15402j = c0788eC;
        this.f15403k = c0788eC.f17703c;
        return c0788eC.b();
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) {
        h0();
    }

    public void y0() {
        StepOSTitleBar stepOSTitleBar = this.f15403k;
        if (stepOSTitleBar == null) {
            return;
        }
        stepOSTitleBar.setVisibility(0);
        x2.g.i(this.f15403k, getString(R.string.mm_minor_mode), new View.OnClickListener() { // from class: H2.Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2762a.t0(view);
            }
        }, R.drawable.stepos_icon_more, getString(R.string.fg_settings), new View.OnClickListener() { // from class: H2.Z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2763a.B0(view);
            }
        });
        setTitle(R.string.mm_minor_mode);
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        x2.g.d(this);
    }

    public void z0() {
        StepOSTitleBar stepOSTitleBar = this.f15403k;
        if (stepOSTitleBar == null) {
            return;
        }
        stepOSTitleBar.setVisibility(0);
        x2.g.h(this.f15403k, getString(R.string.mm_title_add_minor), new View.OnClickListener() { // from class: H2.U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2756a.u0(view);
            }
        });
        setTitle(R.string.mm_title_add_minor);
    }
}
