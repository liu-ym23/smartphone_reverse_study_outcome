package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.k;
import androidx.appcompat.widget.d1;
import androidx.appcompat.widget.n0;
import androidx.core.app.p;
import com.stepos.aiengine.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class i extends androidx.fragment.app.o implements j, p.a {

    /* renamed from: a, reason: collision with root package name */
    public AppCompatDelegateImpl f327a;

    public i() {
        getSavedStateRegistry().c("androidx:appcompat", new g(this));
        addOnContextAvailableListener(new h(this));
    }

    @Override // b.k, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        q().c(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) q();
        appCompatDelegateImpl.S = true;
        int i10 = appCompatDelegateImpl.W;
        if (i10 == -100) {
            i10 = k.f329b;
        }
        int iH = appCompatDelegateImpl.H(i10, context);
        if (k.i(context) && k.i(context)) {
            if (Build.VERSION.SDK_INT < 33) {
                synchronized (k.f335l) {
                    try {
                        r0.d dVar = k.f330c;
                        if (dVar == null) {
                            if (k.f331d == null) {
                                k.f331d = r0.d.a(androidx.core.app.b.b(context));
                            }
                            if (!k.f331d.f11677a.f11679a.isEmpty()) {
                                k.f330c = k.f331d;
                            }
                        } else if (!dVar.equals(k.f331d)) {
                            r0.d dVar2 = k.f330c;
                            k.f331d = dVar2;
                            androidx.core.app.b.a(context, dVar2.f11677a.f11679a.toLanguageTags());
                        }
                    } finally {
                    }
                }
            } else if (!k.h) {
                k.f328a.execute(new a6.e(context, 1));
            }
        }
        r0.d dVarU = AppCompatDelegateImpl.u(context);
        Configuration configuration = null;
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(AppCompatDelegateImpl.y(context, iH, dVarU, null, false));
            } catch (IllegalStateException unused) {
            }
        } else if (context instanceof k.c) {
            try {
                ((k.c) context).a(AppCompatDelegateImpl.y(context, iH, dVarU, null, false));
            } catch (IllegalStateException unused2) {
            }
        } else if (AppCompatDelegateImpl.f260n0) {
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
                    float f8 = configuration3.fontScale;
                    float f9 = configuration4.fontScale;
                    if (f8 != f9) {
                        configuration.fontScale = f9;
                    }
                    int i11 = configuration3.mcc;
                    int i12 = configuration4.mcc;
                    if (i11 != i12) {
                        configuration.mcc = i12;
                    }
                    int i13 = configuration3.mnc;
                    int i14 = configuration4.mnc;
                    if (i13 != i14) {
                        configuration.mnc = i14;
                    }
                    AppCompatDelegateImpl.e.a(configuration3, configuration4, configuration);
                    int i15 = configuration3.touchscreen;
                    int i16 = configuration4.touchscreen;
                    if (i15 != i16) {
                        configuration.touchscreen = i16;
                    }
                    int i17 = configuration3.keyboard;
                    int i18 = configuration4.keyboard;
                    if (i17 != i18) {
                        configuration.keyboard = i18;
                    }
                    int i19 = configuration3.keyboardHidden;
                    int i20 = configuration4.keyboardHidden;
                    if (i19 != i20) {
                        configuration.keyboardHidden = i20;
                    }
                    int i21 = configuration3.navigation;
                    int i22 = configuration4.navigation;
                    if (i21 != i22) {
                        configuration.navigation = i22;
                    }
                    int i23 = configuration3.navigationHidden;
                    int i24 = configuration4.navigationHidden;
                    if (i23 != i24) {
                        configuration.navigationHidden = i24;
                    }
                    int i25 = configuration3.orientation;
                    int i26 = configuration4.orientation;
                    if (i25 != i26) {
                        configuration.orientation = i26;
                    }
                    int i27 = configuration3.screenLayout & 15;
                    int i28 = configuration4.screenLayout & 15;
                    if (i27 != i28) {
                        configuration.screenLayout |= i28;
                    }
                    int i29 = configuration3.screenLayout & 192;
                    int i30 = configuration4.screenLayout & 192;
                    if (i29 != i30) {
                        configuration.screenLayout |= i30;
                    }
                    int i31 = configuration3.screenLayout & 48;
                    int i32 = configuration4.screenLayout & 48;
                    if (i31 != i32) {
                        configuration.screenLayout |= i32;
                    }
                    int i33 = configuration3.screenLayout & 768;
                    int i34 = configuration4.screenLayout & 768;
                    if (i33 != i34) {
                        configuration.screenLayout |= i34;
                    }
                    int i35 = configuration3.colorMode & 3;
                    int i36 = configuration4.colorMode & 3;
                    if (i35 != i36) {
                        configuration.colorMode |= i36;
                    }
                    int i37 = configuration3.colorMode & 12;
                    int i38 = configuration4.colorMode & 12;
                    if (i37 != i38) {
                        configuration.colorMode |= i38;
                    }
                    int i39 = configuration3.uiMode & 15;
                    int i40 = configuration4.uiMode & 15;
                    if (i39 != i40) {
                        configuration.uiMode |= i40;
                    }
                    int i41 = configuration3.uiMode & 48;
                    int i42 = configuration4.uiMode & 48;
                    if (i41 != i42) {
                        configuration.uiMode |= i42;
                    }
                    int i43 = configuration3.screenWidthDp;
                    int i44 = configuration4.screenWidthDp;
                    if (i43 != i44) {
                        configuration.screenWidthDp = i44;
                    }
                    int i45 = configuration3.screenHeightDp;
                    int i46 = configuration4.screenHeightDp;
                    if (i45 != i46) {
                        configuration.screenHeightDp = i46;
                    }
                    int i47 = configuration3.smallestScreenWidthDp;
                    int i48 = configuration4.smallestScreenWidthDp;
                    if (i47 != i48) {
                        configuration.smallestScreenWidthDp = i48;
                    }
                    int i49 = configuration3.densityDpi;
                    int i50 = configuration4.densityDpi;
                    if (i49 != i50) {
                        configuration.densityDpi = i50;
                    }
                }
            }
            Configuration configurationY = AppCompatDelegateImpl.y(context, iH, dVarU, configuration, true);
            k.c cVar = new k.c(context, R.style.Theme_AppCompat_Empty);
            cVar.a(configurationY);
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

    @Override // android.app.Activity
    public final void closeOptionsMenu() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ((AppCompatDelegateImpl) q()).F();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // androidx.core.app.c, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        keyEvent.getKeyCode();
        ((AppCompatDelegateImpl) q()).F();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final <T extends View> T findViewById(int i10) {
        return (T) q().d(i10);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) q();
        if (appCompatDelegateImpl.f275s == null) {
            appCompatDelegateImpl.F();
            w wVar = appCompatDelegateImpl.r;
            appCompatDelegateImpl.f275s = new k.f(wVar != null ? wVar.c() : appCompatDelegateImpl.f271n);
        }
        return appCompatDelegateImpl.f275s;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i10 = d1.f791a;
        return super.getResources();
    }

    @Override // androidx.core.app.p.a
    public final Intent getSupportParentActivityIntent() {
        return androidx.core.app.e.a(this);
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        q().h();
    }

    @Override // b.k, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, NoSuchMethodException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onConfigurationChanged(configuration);
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) q();
        if (appCompatDelegateImpl.J && appCompatDelegateImpl.D) {
            appCompatDelegateImpl.F();
            w wVar = appCompatDelegateImpl.r;
            if (wVar != null) {
                wVar.f(wVar.f373a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
            }
        }
        androidx.appcompat.widget.j jVarA = androidx.appcompat.widget.j.a();
        Context context = appCompatDelegateImpl.f271n;
        synchronized (jVarA) {
            n0 n0Var = jVarA.f848a;
            synchronized (n0Var) {
                p.e<WeakReference<Drawable.ConstantState>> eVar = n0Var.f899b.get(context);
                if (eVar != null) {
                    eVar.b();
                }
            }
        }
        appCompatDelegateImpl.V = new Configuration(appCompatDelegateImpl.f271n.getResources().getConfiguration());
        appCompatDelegateImpl.s(false, false);
    }

    @Override // androidx.fragment.app.o, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        q().k();
    }

    @Override // androidx.fragment.app.o, b.k, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Intent intentA;
        if (!super.onMenuItemSelected(i10, menuItem)) {
            AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) q();
            appCompatDelegateImpl.F();
            w wVar = appCompatDelegateImpl.r;
            if (menuItem.getItemId() != 16908332 || wVar == null || (wVar.f377e.p() & 4) == 0 || (intentA = androidx.core.app.e.a(this)) == null) {
                return false;
            }
            if (!shouldUpRecreateTask(intentA)) {
                navigateUpTo(intentA);
                return true;
            }
            androidx.core.app.p pVar = new androidx.core.app.p(this);
            pVar.a(this);
            pVar.b();
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
        ((AppCompatDelegateImpl) q()).B();
    }

    @Override // androidx.fragment.app.o, android.app.Activity
    public final void onPostResume() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onPostResume();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) q();
        appCompatDelegateImpl.F();
        w wVar = appCompatDelegateImpl.r;
        if (wVar != null) {
            wVar.f390t = true;
        }
    }

    @Override // androidx.fragment.app.o, android.app.Activity
    public final void onStart() throws PackageManager.NameNotFoundException {
        super.onStart();
        ((AppCompatDelegateImpl) q()).s(true, false);
    }

    @Override // androidx.fragment.app.o, android.app.Activity
    public void onStop() {
        super.onStop();
        q().l();
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        q().r(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ((AppCompatDelegateImpl) q()).F();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    public final k q() {
        if (this.f327a == null) {
            k.c cVar = k.f328a;
            this.f327a = new AppCompatDelegateImpl(this, null, this, this);
        }
        return this.f327a;
    }

    @Override // b.k, android.app.Activity
    public final void setContentView(int i10) {
        initializeViewTreeOwners();
        q().o(i10);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i10) {
        super.setTheme(i10);
        ((AppCompatDelegateImpl) q()).X = i10;
    }

    @Override // androidx.fragment.app.o
    public final void supportInvalidateOptionsMenu() {
        q().h();
    }

    @Override // b.k, android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        q().p(view);
    }

    @Override // b.k, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        q().q(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }
}
