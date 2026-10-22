package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.familyguard.R;
import j2.C0778A;
import java.lang.reflect.InvocationTargetException;
import stepos.support.v7.app.a;
import x2.ViewOnClickListenerC1283a;

/* loaded from: classes.dex */
public class UsageActivity extends q2.j {

    /* renamed from: e, reason: collision with root package name */
    private UsageFragment f14936e;

    /* renamed from: f, reason: collision with root package name */
    private UsageFragment f14937f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.fragment.app.x f14938g;

    /* renamed from: j, reason: collision with root package name */
    private ViewOnClickListenerC1283a f14941j;

    /* renamed from: k, reason: collision with root package name */
    private C0778A f14942k;

    /* renamed from: d, reason: collision with root package name */
    private int f14935d = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f14939h = -1;

    /* renamed from: i, reason: collision with root package name */
    private long f14940i = -1;

    private int X(String str) {
        return (str == null || str.equals(getString(R.string.us_today)) || !str.equals(getString(R.string.us_last_7_days))) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Y(MenuItem menuItem) {
        if (menuItem == null) {
            return false;
        }
        this.f14941j.setTitle(menuItem.getTitle().toString());
        menuItem.setChecked(true);
        Z(X(menuItem.getTitle().toString()));
        return false;
    }

    private void Z(int i5) {
        UsageFragment usageFragment;
        UsageFragment usageFragment2;
        if (this.f14935d != i5) {
            if (i5 == 0) {
                usageFragment = this.f14936e;
                usageFragment2 = this.f14937f;
            } else if (i5 == 1) {
                usageFragment = this.f14937f;
                usageFragment2 = this.f14936e;
            } else {
                usageFragment = null;
                usageFragment2 = null;
            }
            if (usageFragment != null) {
                this.f14938g.m().w(usageFragment).p(usageFragment2).i();
            }
            this.f14935d = i5;
            if (this.f14939h == 1) {
                B2.a.c(i5);
            } else {
                B2.b.f(i5);
            }
        }
    }

    private void a0() {
        DigitalWellbeingService.d0(this);
    }

    private void b0(int i5) {
        if (this.f14941j == null) {
            ViewOnClickListenerC1283a viewOnClickListenerC1283a = new ViewOnClickListenerC1283a(this, R.menu.us_pick_range_title_menu);
            this.f14941j = viewOnClickListenerC1283a;
            viewOnClickListenerC1283a.setOnMenuItemClickListener(new ViewOnClickListenerC1283a.d() { // from class: w2.K0
                @Override // x2.ViewOnClickListenerC1283a.d
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return this.f23573a.Y(menuItem);
                }
            });
            Menu menu = this.f14941j.getMenu();
            this.f14941j.setCurrentMenuItem(menu.getItem(i5));
            this.f14941j.setTitle(menu.getItem(i5).getTitle().toString());
            menu.getItem(i5).setChecked(true);
            getSupportActionBar().C(this.f14941j, new a.e(-2, -2, 8388613));
            getSupportActionBar().P(R.string.us_usage_statistics);
        }
    }

    public static void c0(Context context, int i5, long j5) {
        Intent intent = new Intent(context, (Class<?>) UsageActivity.class);
        intent.putExtra("proxy", i5);
        intent.putExtra("operator_id", j5);
        context.startActivity(intent);
    }

    private void d0(Intent intent) {
        int intExtra = intent.getIntExtra("proxy", 0);
        long longExtra = intent.getLongExtra("operator_id", -1L);
        if (intExtra == this.f14939h && this.f14940i == longExtra) {
            return;
        }
        this.f14939h = intExtra;
        this.f14940i = longExtra;
        this.f14936e = W(com.stepos.digitalwellbeing.server.data.a.DAY, intExtra, longExtra);
        this.f14937f = W(com.stepos.digitalwellbeing.server.data.a.WEEK, this.f14939h, longExtra);
    }

    UsageFragment W(com.stepos.digitalwellbeing.server.data.a aVar, int i5, long j5) {
        UsageFragment usageFragment = new UsageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("interval", aVar.ordinal());
        bundle.putInt("proxy", i5);
        bundle.putLong("operator_id", j5);
        usageFragment.G1(bundle);
        return usageFragment;
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (T1.b.h()) {
            R1.a.e("UsageActivity", "Monkey return");
            finish();
        }
    }

    @Override // com.stepos.familyguard.ui.base.a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (T1.b.h()) {
            return;
        }
        this.f14941j.k();
        this.f14941j = null;
    }

    @Override // androidx.activity.h, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (T1.b.h()) {
            return;
        }
        d0(intent);
    }

    @Override // stepos.support.v7.app.d, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("pos", this.f14935d);
    }

    @Override // com.stepos.familyguard.ui.base.a, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStart() {
        super.onStart();
        AppWidgetManagerService.n(this);
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        C0778A c0778aC = C0778A.c(getLayoutInflater());
        this.f14942k = c0778aC;
        return c0778aC.b();
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.y(view, bundle);
        T1.i.a(getWindow());
        this.f14938g = getSupportFragmentManager();
        if (bundle == null) {
            b0(0);
            d0(getIntent());
            this.f14938g.m().c(R.id.fragment_container, this.f14936e, "today").c(R.id.fragment_container, this.f14937f, "week").p(this.f14937f).j();
            a0();
            return;
        }
        int i5 = bundle.getInt("pos");
        this.f14935d = i5;
        b0(i5);
        this.f14936e = (UsageFragment) this.f14938g.g0("today");
        this.f14937f = (UsageFragment) this.f14938g.g0("week");
    }
}
