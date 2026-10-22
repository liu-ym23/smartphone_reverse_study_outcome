package h;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import m.d2;
import m.v2;
import m.x2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k extends androidx.fragment.app.j implements l, d3.h {

    /* renamed from: c, reason: collision with root package name */
    public e0 f4845c;

    @Override // androidx.activity.p, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        initializeViewTreeOwners();
        e0 e0Var = (e0) c();
        e0Var.u();
        ((ViewGroup) e0Var.C.findViewById(R.id.content)).addView(view, layoutParams);
        e0Var.f4796n.a(e0Var.f4795m.getCallback());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        e0 e0Var = (e0) c();
        e0Var.Q = true;
        int i = e0Var.U;
        if (i == -100) {
            i = q.f4886f;
        }
        int iA = e0Var.A(i, context);
        int i3 = 0;
        if (q.b(context) && q.b(context) && !q.f4888h) {
            androidx.room.b0 b0Var = q.f4885c;
            m mVar = new m(i3);
            mVar.f4853f = context;
            VarHandle.storeStoreFence();
            b0Var.execute(mVar);
        }
        Configuration configuration = null;
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(e0.r(context, iA, null, false));
            } catch (IllegalStateException unused) {
            }
        } else if (context instanceof k.c) {
            try {
                ((k.c) context).a(e0.r(context, iA, null, false));
            } catch (IllegalStateException unused2) {
            }
        } else if (e0.f4785l0) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f5 = configuration3.fontScale;
                    float f10 = configuration4.fontScale;
                    if (f5 != f10) {
                        configuration.fontScale = f10;
                    }
                    int i10 = configuration3.mcc;
                    int i11 = configuration4.mcc;
                    if (i10 != i11) {
                        configuration.mcc = i11;
                    }
                    int i12 = configuration3.mnc;
                    int i13 = configuration4.mnc;
                    if (i12 != i13) {
                        configuration.mnc = i13;
                    }
                    w.a(configuration3, configuration4, configuration);
                    int i14 = configuration3.touchscreen;
                    int i15 = configuration4.touchscreen;
                    if (i14 != i15) {
                        configuration.touchscreen = i15;
                    }
                    int i16 = configuration3.keyboard;
                    int i17 = configuration4.keyboard;
                    if (i16 != i17) {
                        configuration.keyboard = i17;
                    }
                    int i18 = configuration3.keyboardHidden;
                    int i19 = configuration4.keyboardHidden;
                    if (i18 != i19) {
                        configuration.keyboardHidden = i19;
                    }
                    int i20 = configuration3.navigation;
                    int i21 = configuration4.navigation;
                    if (i20 != i21) {
                        configuration.navigation = i21;
                    }
                    int i22 = configuration3.navigationHidden;
                    int i23 = configuration4.navigationHidden;
                    if (i22 != i23) {
                        configuration.navigationHidden = i23;
                    }
                    int i24 = configuration3.orientation;
                    int i25 = configuration4.orientation;
                    if (i24 != i25) {
                        configuration.orientation = i25;
                    }
                    int i26 = configuration3.screenLayout & 15;
                    int i27 = configuration4.screenLayout & 15;
                    if (i26 != i27) {
                        configuration.screenLayout |= i27;
                    }
                    int i28 = configuration3.screenLayout & 192;
                    int i29 = configuration4.screenLayout & 192;
                    if (i28 != i29) {
                        configuration.screenLayout |= i29;
                    }
                    int i30 = configuration3.screenLayout & 48;
                    int i31 = configuration4.screenLayout & 48;
                    if (i30 != i31) {
                        configuration.screenLayout |= i31;
                    }
                    int i32 = configuration3.screenLayout & 768;
                    int i33 = configuration4.screenLayout & 768;
                    if (i32 != i33) {
                        configuration.screenLayout |= i33;
                    }
                    int i34 = configuration3.colorMode & 3;
                    int i35 = configuration4.colorMode & 3;
                    if (i34 != i35) {
                        configuration.colorMode |= i35;
                    }
                    int i36 = configuration3.colorMode & 12;
                    int i37 = configuration4.colorMode & 12;
                    if (i36 != i37) {
                        configuration.colorMode |= i37;
                    }
                    int i38 = configuration3.uiMode & 15;
                    int i39 = configuration4.uiMode & 15;
                    if (i38 != i39) {
                        configuration.uiMode |= i39;
                    }
                    int i40 = configuration3.uiMode & 48;
                    int i41 = configuration4.uiMode & 48;
                    if (i40 != i41) {
                        configuration.uiMode |= i41;
                    }
                    int i42 = configuration3.screenWidthDp;
                    int i43 = configuration4.screenWidthDp;
                    if (i42 != i43) {
                        configuration.screenWidthDp = i43;
                    }
                    int i44 = configuration3.screenHeightDp;
                    int i45 = configuration4.screenHeightDp;
                    if (i44 != i45) {
                        configuration.screenHeightDp = i45;
                    }
                    int i46 = configuration3.smallestScreenWidthDp;
                    int i47 = configuration4.smallestScreenWidthDp;
                    if (i46 != i47) {
                        configuration.smallestScreenWidthDp = i47;
                    }
                    int i48 = configuration3.densityDpi;
                    int i49 = configuration4.densityDpi;
                    if (i48 != i49) {
                        configuration.densityDpi = i49;
                    }
                }
            }
            Configuration configurationR = e0.r(context, iA, configuration, true);
            k.c cVar = new k.c(context, com.stepos.agentsafetycenter.R.style.Theme_AppCompat_Empty);
            cVar.a(configurationR);
            try {
                if (context.getTheme() != null) {
                    cVar.getTheme().rebase();
                }
            } catch (NullPointerException unused3) {
            }
            context = cVar;
        }
        super.attachBaseContext(context);
    }

    public final q c() {
        if (this.f4845c == null) {
            androidx.room.b0 b0Var = q.f4885c;
            this.f4845c = new e0(this, null, this, this);
        }
        return this.f4845c;
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ((e0) c()).y();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // d3.c, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        keyEvent.getKeyCode();
        ((e0) c()).y();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final View findViewById(int i) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        e0 e0Var = (e0) c();
        e0Var.u();
        return e0Var.f4795m.findViewById(i);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        e0 e0Var = (e0) c();
        if (e0Var.f4799q == null) {
            e0Var.y();
            o0 o0Var = e0Var.f4798p;
            e0Var.f4799q = new k.i(o0Var != null ? o0Var.b() : e0Var.f4794l);
        }
        return e0Var.f4799q;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i = x2.f8138a;
        return super.getResources();
    }

    @Override // d3.h
    public final Intent getSupportParentActivityIntent() {
        return d3.a.b(this);
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        e0 e0Var = (e0) c();
        if (e0Var.f4798p != null) {
            e0Var.y();
            e0Var.f4798p.getClass();
            e0Var.z(0);
        }
    }

    @Override // androidx.activity.p, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, NoSuchMethodException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onConfigurationChanged(configuration);
        e0 e0Var = (e0) c();
        if (e0Var.H && e0Var.B) {
            e0Var.y();
            o0 o0Var = e0Var.f4798p;
            if (o0Var != null) {
                o0Var.e(o0Var.f4862a.getResources().getBoolean(com.stepos.agentsafetycenter.R.bool.abc_action_bar_embed_tabs));
            }
        }
        m.s sVarA = m.s.a();
        Context context = e0Var.f4794l;
        synchronized (sVarA) {
            d2 d2Var = sVarA.f8062a;
            synchronized (d2Var) {
                p.n nVar = (p.n) d2Var.f7892b.get(context);
                if (nVar != null) {
                    nVar.a();
                }
            }
        }
        e0Var.T = new Configuration(e0Var.f4794l.getResources().getConfiguration());
        e0Var.m(false);
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c().d();
    }

    @Override // androidx.fragment.app.j, androidx.activity.p, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Intent intentB;
        if (!super.onMenuItemSelected(i, menuItem)) {
            e0 e0Var = (e0) c();
            e0Var.y();
            o0 o0Var = e0Var.f4798p;
            if (menuItem.getItemId() != 16908332 || o0Var == null || (((v2) o0Var.f4866e).f8098b & 4) == 0 || (intentB = d3.a.b(this)) == null) {
                return false;
            }
            if (!shouldUpRecreateTask(intentB)) {
                navigateUpTo(intentB);
                return true;
            }
            d3.i iVar = new d3.i();
            iVar.f3187c = new ArrayList();
            iVar.f3188f = this;
            VarHandle.storeStoreFence();
            iVar.a(this);
            iVar.b();
            try {
                finishAffinity();
            } catch (IllegalStateException unused) {
                finish();
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onPostCreate(bundle);
        ((e0) c()).u();
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public final void onPostResume() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onPostResume();
        e0 e0Var = (e0) c();
        e0Var.y();
        o0 o0Var = e0Var.f4798p;
        if (o0Var != null) {
            o0Var.f4880t = true;
        }
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public void onStart() throws PackageManager.NameNotFoundException {
        super.onStart();
        ((e0) c()).m(true);
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public void onStop() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onStop();
        e0 e0Var = (e0) c();
        e0Var.y();
        o0 o0Var = e0Var.f4798p;
        if (o0Var != null) {
            o0Var.f4880t = false;
            k.k kVar = o0Var.f4879s;
            if (kVar != null) {
                kVar.a();
            }
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        c().l(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ((e0) c()).y();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    @Override // androidx.activity.p, android.app.Activity
    public final void setContentView(int i) {
        initializeViewTreeOwners();
        c().h(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        super.setTheme(i);
        ((e0) c()).V = i;
    }

    @Override // androidx.activity.p, android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        c().i(view);
    }

    @Override // androidx.activity.p, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        c().k(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }
}
