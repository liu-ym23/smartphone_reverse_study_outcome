package com.stepos.familyguard.ui.base;

import V1.l;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.activity.o;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.base.j;
import com.stepos.familyguard.ui.common.LoadingDialogFragment;
import f2.C0702g;
import i2.AbstractActivityC0758a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import z3.C1347a;

/* loaded from: classes.dex */
public abstract class a extends AbstractActivityC0758a {

    /* renamed from: a, reason: collision with root package name */
    private int f14784a;

    /* renamed from: b, reason: collision with root package name */
    private Q1.c<A3.c> f14785b = Q1.c.a();

    /* renamed from: com.stepos.familyguard.ui.base.a$a, reason: collision with other inner class name */
    class C0181a extends o {
        C0181a(boolean z5) {
            super(z5);
        }

        @Override // androidx.activity.o
        public void d() {
            if (a.this.getSupportFragmentManager().W0()) {
                return;
            }
            a.this.finish();
        }
    }

    public static /* synthetic */ DialogInterfaceOnCancelListenerC0510e F(String str) {
        LoadingDialogFragment loadingDialogFragment = new LoadingDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key_dialog_msg", str);
        loadingDialogFragment.G1(bundle);
        return loadingDialogFragment;
    }

    private void H() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        int blurBehindRadius = attributes.getBlurBehindRadius();
        if (blurBehindRadius <= 0) {
            return;
        }
        this.f14784a = blurBehindRadius;
        attributes.setBlurBehindRadius(0);
        getWindow().setAttributes(attributes);
    }

    public static void J(Context context) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        try {
            Field declaredField = inputMethodManager.getClass().getDeclaredField("mCurRootView");
            Field declaredField2 = inputMethodManager.getClass().getDeclaredField("mNextServedView");
            Field declaredField3 = inputMethodManager.getClass().getDeclaredField("mServedView");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            if (!declaredField2.isAccessible()) {
                declaredField2.setAccessible(true);
            }
            if (!declaredField3.isAccessible()) {
                declaredField3.setAccessible(true);
            }
            Object obj = declaredField.get(inputMethodManager);
            if (obj != null) {
                Context context2 = (Context) N1.h.a(obj.getClass()).b("mContext").get(obj);
                if (((Context) ((WeakReference) N1.h.b(context2).b("mContext").get(context2)).get()) == context) {
                    declaredField.set(inputMethodManager, null);
                    declaredField2.set(inputMethodManager, null);
                    declaredField3.set(inputMethodManager, null);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void K(boolean z5, final String str) {
        if (z5) {
            C2.f.a(getSupportFragmentManager()).b("LoadingDialogFragment", new Q1.d() { // from class: r2.b
                @Override // Q1.d
                public final Object get() {
                    return com.stepos.familyguard.ui.base.a.F(str);
                }
            });
        } else {
            C2.f.a(getSupportFragmentManager()).a("LoadingDialogFragment");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(String str, Long l5) {
        K(true, str);
    }

    private void R() {
        if (this.f14784a <= 0) {
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.setBlurBehindRadius(this.f14784a);
        getWindow().setAttributes(attributes);
    }

    protected void G() {
        boolean z5 = (getResources().getConfiguration().uiMode & 48) == 32;
        boolean z6 = !z5;
        WindowInsetsController insetsController = getWindow().getInsetsController();
        if (insetsController != null) {
            insetsController.setSystemBarsAppearance(z5 ? 0 : 24, 24);
        }
        N1.f.b(getWindow(), z6, true);
        T1.a.d(this, z6);
        T1.a.e(this, z6);
        T1.a.f(this, z6, true);
    }

    protected void I() {
    }

    protected boolean M() {
        finish();
        return true;
    }

    protected void N(j.b bVar) {
        C0702g.b("BaseActivity", "onDialogChanged() called with: dialogState = [" + bVar + "]");
        int i5 = bVar.f14810a;
        if (i5 == 1) {
            String str = bVar.f14812c;
            if (str == null) {
                T(R.string.fg_common_loading, true);
            } else {
                U(str, true);
            }
            bVar.f14811b.Q();
            return;
        }
        if (i5 == 2) {
            Q();
            bVar.f14811b.Q();
            return;
        }
        if (i5 != 3) {
            if (i5 == 4) {
                Q();
                Toast.makeText(P1.a.a(), bVar.f14812c, 0).show();
                return;
            } else {
                if (i5 != 5) {
                    return;
                }
                O(bVar.f14817h);
                Q();
                bVar.f14811b.Q();
                return;
            }
        }
        Q();
        C2.b bVar2 = new C2.b(this);
        bVar2.y(bVar.f14812c);
        String str2 = bVar.f14813d;
        if (str2 != null) {
            bVar2.v(str2, bVar.f14814e);
        } else {
            bVar2.u(R.string.fg_common_ok, null);
        }
        String str3 = bVar.f14815f;
        if (str3 != null) {
            bVar2.p(str3, bVar.f14816g);
        }
        bVar.f14811b.Q();
        if (P(bVar.f14812c)) {
            return;
        }
        bVar2.A();
    }

    protected void O(Object obj) {
    }

    protected boolean P(String str) {
        return false;
    }

    public void Q() {
        this.f14785b.c(new l());
        K(false, null);
    }

    public void S() {
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.Q(null);
        supportActionBar.y(null);
        supportActionBar.p().g(null);
    }

    public void T(int i5, boolean z5) {
        U(getString(i5), z5);
    }

    public void U(final String str, boolean z5) {
        this.f14785b.c(new l());
        if (z5) {
            this.f14785b = Q1.c.e(x3.f.b0(500L, TimeUnit.MILLISECONDS).G(C1347a.a()).S(new D3.c() { // from class: r2.a
                @Override // D3.c
                public final void accept(Object obj) {
                    this.f19961a.L(str, (Long) obj);
                }
            }));
        } else {
            K(true, str);
        }
    }

    @Override // i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        G();
        getOnBackPressedDispatcher().h(this, new C0181a(true));
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        J(this);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return (menuItem == null || menuItem.getItemId() != 16908332) ? super.onOptionsItemSelected(menuItem) : M();
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onResume() {
        super.onResume();
        G();
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStart() {
        super.onStart();
        R();
        I();
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStop() {
        H();
        super.onStop();
    }

    @Override // i2.AbstractActivityC0758a
    public View x() {
        return null;
    }
}
