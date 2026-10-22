package com.stepos.architecture.ui.stepos;

import Z2.I;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.NonNull;
import androidx.lifecycle.n0;
import androidx.lifecycle.u0;
import com.stepos.alphame.R;
import stepos.support.v7.app.AbstractActivityC0866k;
import stepos.support.v7.app.AbstractC0860e;

/* loaded from: classes.dex */
public abstract class b extends AbstractActivityC0866k {
    private static final String TAG = "BaseActivity";
    public static b instance;
    private final S1.a mViewModelScope = new S1.a();

    public final void fitStatusBarWithUiMode() {
        boolean z4 = ((UiModeManager) getSystemService(UiModeManager.class)).getNightMode() == 2;
        WindowInsetsController insetsController = getWindow().getInsetsController();
        insetsController.setSystemBarsAppearance(z4 ? 0 : 8, 8);
        insetsController.setSystemBarsAppearance(z4 ? 0 : 16, 16);
    }

    public <T extends n0> T getActivityScopeViewModel(@NonNull Class<T> cls) {
        S1.a aVar = this.mViewModelScope;
        if (aVar.f1789a == null) {
            aVar.f1789a = new android.support.v4.media.session.c((u0) this);
        }
        return (T) aVar.f1789a.e(cls);
    }

    public <T extends n0> T getApplicationScopeViewModel(@NonNull Class<T> cls) {
        S1.a aVar = this.mViewModelScope;
        if (aVar.f1790b == null) {
            aVar.f1790b = new android.support.v4.media.session.c(O1.a.f1534b);
        }
        return (T) aVar.f1790b.e(cls);
    }

    public void initActionBar() {
        AbstractC0860e supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.l(true);
        }
        if (supportActionBar == null || supportActionBar.e() == null) {
            return;
        }
        supportActionBar.e().d(I.o(this, R.drawable.base_action_bar_bg));
    }

    public abstract void initViewModel();

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.activity.o, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fitStatusBarWithUiMode();
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        instance = this;
        fitStatusBarWithUiMode();
        initActionBar();
        initViewModel();
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.fragment.app.G, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            return super.registerReceiver(broadcastReceiver, intentFilter, 2);
        } catch (Exception e4) {
            Log.w(TAG, "registerReceiver exception:" + e4.getMessage());
            return null;
        }
    }

    public void setActionBarBackground(int i4) {
        AbstractC0860e supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.j(androidx.core.content.a.b(this, i4));
        }
    }

    public void setActionBarTitle(String str) {
        AbstractC0860e supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(str);
        }
    }

    public void setViewPadding(View view) {
        View viewFindViewById = findViewById(android.R.id.content);
        if (viewFindViewById != null) {
            viewFindViewById.setOnApplyWindowInsetsListener(new a(viewFindViewById, view));
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Exception e4) {
            Log.w(TAG, "registerReceiver exception:" + e4.getMessage());
        }
    }

    public void setActionBarTitle(int i4) {
        AbstractC0860e supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.q(i4);
        }
    }
}
