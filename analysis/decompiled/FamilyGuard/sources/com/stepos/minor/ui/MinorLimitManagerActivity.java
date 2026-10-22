package com.stepos.minor.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.C;
import androidx.lifecycle.U;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.PackageLimitManagerFragment;
import com.stepos.familyguard.ui.usage.z;
import j2.t;
import v2.C1183b;
import v2.e;

/* loaded from: classes.dex */
public class MinorLimitManagerActivity extends com.stepos.familyguard.ui.base.a {

    /* renamed from: c, reason: collision with root package name */
    private z f15384c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f15385d = false;

    /* renamed from: e, reason: collision with root package name */
    private t f15386e;

    /* renamed from: f, reason: collision with root package name */
    private long f15387f;

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(DataToken dataToken) {
        try {
            this.f15384c.C();
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z5) {
        this.f15385d = z5;
        if (z5) {
            try {
                this.f15384c.C();
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    public static void a0(Context context, int i5, long j5) {
        Intent intent = new Intent(context, (Class<?>) MinorLimitManagerActivity.class);
        intent.putExtra("proxy", i5);
        intent.putExtra("operator_id", j5);
        context.startActivity(intent);
    }

    private void b0() {
        Intent intent = getIntent();
        MinorLimitSearchActivity.k0(this, intent.getIntExtra("proxy", 0), intent.getLongExtra("operator_id", this.f15387f));
    }

    protected e X() {
        if (getIntent().getIntExtra("proxy", 0) == 0) {
            return new C1183b(this);
        }
        return null;
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.f15387f = intent.getLongExtra("operator_id", -1L);
        } else {
            this.f15387f = -1L;
        }
        z zVar = (z) new U(this).a(z.class);
        this.f15384c = zVar;
        zVar.c0(X());
        this.f15384c.b().g(this, new C() { // from class: H2.G
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f2715a.Z(((Boolean) obj).booleanValue());
            }
        });
        this.f15384c.U().g(this, new C() { // from class: H2.H
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f2717a.Y((DataToken) obj);
            }
        });
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_limit_manager, menu);
        return true;
    }

    @Override // com.stepos.familyguard.ui.base.a, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_search) {
            menuItem.getActionView();
            b0();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        if (this.f15385d) {
            try {
                this.f15384c.C();
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        t tVarC = t.c(getLayoutInflater());
        this.f15386e = tVarC;
        return tVarC.b();
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) {
        super.y(view, bundle);
        if (bundle == null) {
            PackageLimitManagerFragment packageLimitManagerFragment = new PackageLimitManagerFragment();
            packageLimitManagerFragment.G1(getIntent().getExtras());
            getSupportFragmentManager().m().s(R.id.fragment_container, packageLimitManagerFragment).i();
        }
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        super.z();
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.E(true);
        }
    }
}
