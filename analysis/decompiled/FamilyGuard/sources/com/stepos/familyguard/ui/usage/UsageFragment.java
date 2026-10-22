package com.stepos.familyguard.ui.usage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ActivityC0516k;
import androidx.fragment.app.ComponentCallbacksC0511f;
import androidx.lifecycle.AbstractC0545z;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.stepos.common.widget.StepOSButton;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageNotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.limit.CategoryLimitActivity;
import com.stepos.familyguard.ui.limit.PackageLimitActivity;
import com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i;
import com.stepos.familyguard.ui.widget.MyRecyclerView;
import f2.C0702g;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p2.g;
import v2.C1183b;
import w2.C1213c;
import w2.C1216d;
import w2.C1257w;
import w2.F1;
import w2.InterfaceC1258w0;
import w2.InterfaceC1262y0;

/* loaded from: classes.dex */
public class UsageFragment extends ComponentCallbacksC0511f implements AbstractViewOnTouchListenerC0600i.k, InterfaceC1262y0, InterfaceC1258w0 {

    /* renamed from: A0, reason: collision with root package name */
    private boolean f14944A0;

    /* renamed from: g0, reason: collision with root package name */
    private MyRecyclerView f14946g0;

    /* renamed from: h0, reason: collision with root package name */
    private AbstractViewOnTouchListenerC0600i f14947h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f14948i0;

    /* renamed from: j0, reason: collision with root package name */
    private com.stepos.digitalwellbeing.server.data.a f14949j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f14950k0;

    /* renamed from: l0, reason: collision with root package name */
    private long f14951l0;

    /* renamed from: n0, reason: collision with root package name */
    private b f14953n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f14954o0;

    /* renamed from: p0, reason: collision with root package name */
    private DataToken f14955p0;

    /* renamed from: q0, reason: collision with root package name */
    private View f14956q0;

    /* renamed from: r0, reason: collision with root package name */
    private UsingTimeStats[] f14957r0;

    /* renamed from: s0, reason: collision with root package name */
    private NotificationTimesStats[] f14958s0;

    /* renamed from: t0, reason: collision with root package name */
    private PickupTimesStats[] f14959t0;

    /* renamed from: u0, reason: collision with root package name */
    private PackageNotificationTimesStats[] f14960u0;

    /* renamed from: v0, reason: collision with root package name */
    private ArrayList<C1216d> f14961v0;

    /* renamed from: w0, reason: collision with root package name */
    private ArrayList<C1257w> f14962w0;

    /* renamed from: y0, reason: collision with root package name */
    private View f14964y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f14965z0;

    /* renamed from: f0, reason: collision with root package name */
    private F1 f14945f0 = null;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f14952m0 = false;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f14963x0 = false;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            T1.b.k();
        }
    }

    private class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (T1.f.a() && UsageFragment.this.f14952m0 && UsageFragment.this.f14955p0 != null) {
                R1.a.a("UsageFragment", "onReceive");
                UsageFragment.this.f14945f0.h(UsageFragment.this.w(), UsageFragment.this.f14949j0, UsageFragment.this.f14955p0);
            }
        }

        private b() {
        }
    }

    private void A2(Context context) {
        new C2.b(context).x(R.string.us_request_app_list_permission_title).m(R.string.us_request_app_list_permission_des).u(R.string.fg_to_open, new DialogInterface.OnClickListener() { // from class: w2.N0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f23579a.l2(dialogInterface, i5);
            }
        }).o(R.string.fg_relation_manager_logout, new DialogInterface.OnClickListener() { // from class: w2.O0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f23581a.m2(dialogInterface, i5);
            }
        }).g(false).c().show();
    }

    private void B2() {
        ActivityC0516k activityC0516kQ = q();
        if (activityC0516kQ instanceof stepos.support.v7.app.d) {
            stepos.support.v7.app.d dVar = (stepos.support.v7.app.d) activityC0516kQ;
            if (dVar.getSupportActionBar() == null || dVar.getSupportActionBar().l() == null) {
                return;
            }
            dVar.getSupportActionBar().l().setVisibility(0);
        }
    }

    private void D2() {
        if (this.f14953n0 == null || !this.f14954o0) {
            return;
        }
        w().unregisterReceiver(this.f14953n0);
        this.f14954o0 = false;
    }

    private void f2() {
        if (q() != null) {
            AppWidgetManagerService.n(w());
        }
    }

    private void h2() {
        ActivityC0516k activityC0516kQ = q();
        if (activityC0516kQ instanceof stepos.support.v7.app.d) {
            stepos.support.v7.app.d dVar = (stepos.support.v7.app.d) activityC0516kQ;
            if (dVar.getSupportActionBar() == null || dVar.getSupportActionBar().l() == null) {
                return;
            }
            dVar.getSupportActionBar().l().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(boolean z5) {
        if (z5) {
            this.f14945f0.a();
            w2(true);
        } else {
            q().finish();
            this.f14956q0.postDelayed(new a(), 20L);
            R1.a.a("UsageFragment", "no per finish");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(DialogInterface dialogInterface, int i5) {
        n2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(View view) {
        C1213c.d(y1(), new DialogInterface.OnClickListener() { // from class: w2.M0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f23577a.j2(dialogInterface, i5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(DialogInterface dialogInterface, int i5) {
        this.f14944A0 = false;
        p2.g.s(q(), "android.permission.QUERY_ALL_PACKAGES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(DialogInterface dialogInterface, int i5) {
        this.f14944A0 = false;
        dialogInterface.dismiss();
        if (q() != null) {
            q().finish();
        }
    }

    private void n2() {
        if (w() == null) {
            return;
        }
        if (!p2.g.W(true)) {
            this.f14964y0.setVisibility(0);
            return;
        }
        this.f14964y0.setVisibility(8);
        this.f14956q0.setVisibility(8);
        this.f14945f0.a();
        this.f14952m0 = true;
        B2.e.c();
        C2();
        f2();
        stepos.support.v7.app.d dVar = (stepos.support.v7.app.d) q();
        if (dVar == null || dVar.getSupportActionBar() == null || dVar.getSupportActionBar().l() == null) {
            return;
        }
        dVar.getSupportActionBar().l().setVisibility(0);
    }

    private void w2(boolean z5) {
        Context contextW = w();
        ActivityC0516k activityC0516kQ = q();
        if (contextW == null || activityC0516kQ == null || this.f14956q0 == null) {
            return;
        }
        if (!p2.g.v(contextW)) {
            h2();
            this.f14956q0.setVisibility(0);
            if (p2.g.N(contextW)) {
                y2();
                return;
            }
            if (this.f14965z0) {
                return;
            }
            try {
                x1(new String[]{"com.android.permission.GET_INSTALLED_APPS"}, 19415);
                this.f14965z0 = true;
                return;
            } catch (Exception e6) {
                this.f14965z0 = false;
                C0702g.p("UsageFragment", "app list request failed");
                C0702g.r("UsageFragment", e6);
                y2();
                return;
            }
        }
        p2.g.j(contextW);
        this.f14965z0 = false;
        this.f14944A0 = false;
        if (z5) {
            this.f14952m0 = true;
            C2();
            B2.e.c();
        }
        if (p2.g.M(contextW)) {
            h2();
            this.f14964y0.setVisibility(0);
            return;
        }
        this.f14964y0.setVisibility(8);
        if (p2.g.x(contextW) || p2.g.y(contextW)) {
            this.f14956q0.setVisibility(8);
            B2();
        } else {
            this.f14956q0.setVisibility(0);
            h2();
        }
    }

    private void x2() {
        if (this.f14953n0 == null) {
            this.f14953n0 = new b();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (w() != null) {
            if (Build.VERSION.SDK_INT > 33) {
                w().registerReceiver(this.f14953n0, intentFilter, 2);
            } else {
                w().registerReceiver(this.f14953n0, intentFilter);
            }
        }
        this.f14954o0 = true;
    }

    private void y2() {
        if (this.f14944A0 || w() == null) {
            return;
        }
        this.f14944A0 = true;
        A2(w());
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void A0() {
        super.A0();
        this.f14945f0.b().m(this);
        this.f14945f0 = null;
    }

    public void C2() {
        AbstractC0545z<Boolean> abstractC0545zB;
        Boolean boolE;
        C0702g.b("UsageFragment", "start load");
        F1 f12 = this.f14945f0;
        if (f12 == null || (abstractC0545zB = f12.b()) == null || (boolE = abstractC0545zB.e()) == null || !boolE.booleanValue() || h0() || this.f14963x0) {
            return;
        }
        z2();
        this.f14945f0.c(this.f14949j0);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void F0(boolean z5) {
        super.F0(z5);
        this.f14963x0 = false;
        if (z5) {
            return;
        }
        C2();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void L0() {
        super.L0();
        D2();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void P0(int i5, String[] strArr, int[] iArr) {
        super.P0(i5, strArr, iArr);
        if (i5 != 19415) {
            return;
        }
        this.f14965z0 = false;
        if (p2.g.v(w())) {
            this.f14945f0.a();
            w2(true);
            return;
        }
        p2.g.A(w());
        ActivityC0516k activityC0516kQ = q();
        if (activityC0516kQ != null) {
            activityC0516kQ.finish();
            View view = this.f14956q0;
            if (view != null) {
                view.postDelayed(new Y1.v(), 20L);
            }
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void Q0() {
        super.Q0();
        if (!p2.g.v(w()) || p2.g.M(w())) {
            return;
        }
        if (p2.g.x(w()) || p2.g.y(w())) {
            this.f14956q0.setVisibility(8);
            if (!this.f14952m0) {
                this.f14945f0.a();
                this.f14952m0 = true;
            }
            C2();
            x2();
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void R0(Bundle bundle) {
        super.R0(bundle);
        if (this.f14947h0 != null) {
            try {
                bundle.putParcelable("dataToken", this.f14955p0);
                bundle.putParcelableArray("using_time_stats", this.f14957r0);
                bundle.putParcelableArray("notification_times_stats", this.f14958s0);
                bundle.putParcelableArray("pickup_times_stats", this.f14959t0);
                bundle.putParcelableArray("package_notification_times_stats", this.f14960u0);
                bundle.putParcelableArrayList("app_usage_limit_data_list", this.f14961v0);
                bundle.putParcelableArrayList("category_usage_limit_data_list", this.f14962w0);
                this.f14947h0.i0(bundle);
                C0702g.b("UsageFragment", "onSaveInstanceState = " + bundle);
                this.f14963x0 = false;
            } catch (NoSuchMethodError e6) {
                e6.printStackTrace();
            }
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void S0() {
        super.S0();
        com.stepos.digitalwellbeing.server.data.a aVar = this.f14949j0;
        if (aVar == com.stepos.digitalwellbeing.server.data.a.DAY) {
            if (this.f14950k0 == 1) {
                B2.a.a(aVar.ordinal());
            } else {
                B2.b.d(aVar.ordinal());
                f2();
            }
            g.m mVar = (g.m) q();
            if (!p2.g.O(mVar)) {
                w2(false);
                return;
            }
            this.f14956q0.setVisibility(0);
            stepos.support.v7.app.a supportActionBar = ((stepos.support.v7.app.d) q()).getSupportActionBar();
            Objects.requireNonNull(supportActionBar);
            supportActionBar.l().setVisibility(8);
            p2.g.Q(mVar, new g.k() { // from class: w2.L0
                @Override // p2.g.k
                public final void a(boolean z5) {
                    this.f23575a.i2(z5);
                }
            });
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void T0() {
        int i5;
        super.T0();
        if (this.f14949j0 == com.stepos.digitalwellbeing.server.data.a.DAY) {
            List<C1216d> listE = this.f14945f0.U(w()).e();
            int i6 = 0;
            if (listE != null) {
                i5 = 0;
                for (C1216d c1216d : listE) {
                    if (c1216d.c() != null && c1216d.c().isEnable()) {
                        i5++;
                    }
                }
            } else {
                i5 = 0;
            }
            List<C1257w> listE2 = this.f14945f0.V(w()).e();
            if (listE2 != null) {
                for (C1257w c1257w : listE2) {
                    if (c1257w.c() != null && c1257w.c().isEnable()) {
                        i6++;
                    }
                }
            }
            if (this.f14950k0 == 1) {
                B2.a.b(i5, i6);
            } else {
                B2.b.e(i5, i6);
            }
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void U0(View view, Bundle bundle) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super.U0(view, bundle);
        C0702g.b("UsageFragment", "onViewCreated = " + bundle);
        MyRecyclerView myRecyclerView = (MyRecyclerView) view.findViewById(R.id.recycler_view);
        this.f14946g0 = myRecyclerView;
        myRecyclerView.setLayoutManager(new LinearLayoutManager(q()));
        this.f14946g0.setAdapter(this.f14947h0);
        this.f14947h0.o0(this);
        this.f14946g0.setOnTouchListener(this.f14947h0);
        this.f14946g0.setItemAnimator(new stepos.support.v7.widget.t(this.f14946g0));
        this.f14946g0.setSelector(R.drawable.us_recycler_view_selector);
        this.f14948i0 = view.findViewById(R.id.loadingViewLayout);
        this.f14956q0 = view.findViewById(R.id.mask);
        View viewFindViewById = view.findViewById(R.id.aicy_request_layer);
        this.f14964y0 = viewFindViewById;
        ((StepOSButton) viewFindViewById.findViewById(R.id.aicy_request_layer_btn)).setOnClickListener(new View.OnClickListener() { // from class: w2.P0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f23583a.k2(view2);
            }
        });
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void V0(Bundle bundle) {
        super.V0(bundle);
        if (this.f14947h0 == null || bundle == null || this.f14963x0) {
            return;
        }
        try {
            C0702g.p("UsageFragment", "onViewStateRestored savedInstanceState = " + bundle);
            this.f14955p0 = (DataToken) bundle.getParcelable("dataToken", DataToken.class);
            this.f14947h0.h0(bundle);
            this.f14957r0 = (UsingTimeStats[]) bundle.getParcelableArray("using_time_stats", UsingTimeStats.class);
            this.f14958s0 = (NotificationTimesStats[]) bundle.getParcelableArray("notification_times_stats", NotificationTimesStats.class);
            this.f14959t0 = (PickupTimesStats[]) bundle.getParcelableArray("pickup_times_stats", PickupTimesStats.class);
            this.f14960u0 = (PackageNotificationTimesStats[]) bundle.getParcelableArray("package_notification_times_stats", PackageNotificationTimesStats.class);
            this.f14961v0 = bundle.getParcelableArrayList("app_usage_limit_data_list", C1216d.class);
            this.f14962w0 = bundle.getParcelableArrayList("category_usage_limit_data_list", C1257w.class);
            C0702g.b("UsageFragment", "mUsingTimeStats = " + this.f14957r0);
            C0702g.b("UsageFragment", "mNotificationTimesStats = " + C0702g.h(this.f14958s0));
            C0702g.b("UsageFragment", "mPackageNotificationTimesStats = " + C0702g.h(this.f14960u0));
            C0702g.b("UsageFragment", "mAppUsageLimitDataList = " + C0702g.k(this.f14961v0));
            C0702g.b("UsageFragment", "mCategoryUsageDataList = " + C0702g.k(this.f14962w0));
            this.f14947h0.x0(this.f14957r0);
            this.f14947h0.v0(this.f14958s0);
            this.f14947h0.w0(this.f14959t0);
            this.f14947h0.k0(this.f14961v0);
            this.f14947h0.l0(this.f14962w0);
            this.f14947h0.j0(this.f14960u0);
            this.f14947h0.h0(bundle);
            this.f14963x0 = true;
        } catch (NoSuchMethodError e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractViewOnTouchListenerC0600i.k
    public void b(int i5) {
        this.f14946g0.setScrollable(i5 <= 0);
    }

    protected void d2(F1 f12) {
        f12.b().g(this, new androidx.lifecycle.C() { // from class: com.stepos.familyguard.ui.usage.L
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f14906a.r2(((Boolean) obj).booleanValue());
            }
        });
        f12.Z().g(this, new androidx.lifecycle.C() { // from class: com.stepos.familyguard.ui.usage.M
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f14918a.q2((DataToken) obj);
            }
        });
        f12.a0().g(this, new androidx.lifecycle.C() { // from class: com.stepos.familyguard.ui.usage.N
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f14919a.v2((UsingTimeStats[]) obj);
            }
        });
        f12.U(w()).g(this, new androidx.lifecycle.C() { // from class: com.stepos.familyguard.ui.usage.O
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f14920a.o2((List) obj);
            }
        });
        f12.V(w()).g(this, new androidx.lifecycle.C() { // from class: com.stepos.familyguard.ui.usage.P
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f14921a.p2((List) obj);
            }
        });
        if (this.f14950k0 == 0) {
            f12.X().g(this, new androidx.lifecycle.C() { // from class: com.stepos.familyguard.ui.usage.Q
                @Override // androidx.lifecycle.C
                public final void a(Object obj) {
                    this.f14926a.t2((PackageNotificationTimesStats[]) obj);
                }
            });
            f12.W().g(this, new androidx.lifecycle.C() { // from class: com.stepos.familyguard.ui.usage.S
                @Override // androidx.lifecycle.C
                public final void a(Object obj) {
                    this.f14927a.s2((NotificationTimesStats[]) obj);
                }
            });
            f12.Y().g(this, new androidx.lifecycle.C() { // from class: com.stepos.familyguard.ui.usage.T
                @Override // androidx.lifecycle.C
                public final void a(Object obj) {
                    this.f14928a.u2((PickupTimesStats[]) obj);
                }
            });
        }
    }

    @Override // w2.InterfaceC1258w0
    public void e(int i5, String str) {
        CategoryLimitActivity.Z(y1(), u().getInt("proxy", 0), i5, str, this.f14951l0);
    }

    protected AbstractViewOnTouchListenerC0600i e2(com.stepos.digitalwellbeing.server.data.a aVar, int i5) {
        return i5 == 0 ? aVar == com.stepos.digitalwellbeing.server.data.a.DAY ? new J(w()) : new W(w()) : aVar == com.stepos.digitalwellbeing.server.data.a.DAY ? new C0611u(w(), this.f14951l0) : new C0612v(w(), this.f14951l0);
    }

    protected void g2() {
        View view = this.f14948i0;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // w2.InterfaceC1262y0
    public void i(String str, String str2) {
        PackageLimitActivity.Z(q(), u().getInt("proxy", 0), str, str2, this.f14951l0);
    }

    protected void o2(List<C1216d> list) {
        C0702g.b("UsageFragment", "onAppUsageLimitDataLoaded appUsageLimitDataList = " + C0702g.k(list));
        this.f14961v0 = (ArrayList) list;
        this.f14947h0.k0(list);
        g2();
    }

    protected void p2(List<C1257w> list) {
        C0702g.b("UsageFragment", "onCategoryUsageLimitListLoaded dataList = " + C0702g.k(list));
        this.f14962w0 = (ArrayList) list;
        this.f14947h0.l0(list);
    }

    protected void q2(DataToken dataToken) {
        C0702g.b("UsageFragment", "onDataChanged dataToken = " + dataToken);
        if (dataToken == null) {
            return;
        }
        this.f14955p0 = dataToken;
        this.f14945f0.z(this.f14949j0, dataToken);
        this.f14945f0.f(w(), this.f14949j0, dataToken);
        this.f14945f0.h(w(), this.f14949j0, dataToken);
        this.f14947h0.q0(dataToken.getUpdateTime());
        if (this.f14950k0 == 0) {
            this.f14945f0.l(this.f14949j0, dataToken);
            this.f14945f0.n(this.f14949j0, dataToken);
            this.f14945f0.d(this.f14949j0, dataToken);
        }
    }

    protected void r2(boolean z5) {
        C2();
    }

    protected void s2(NotificationTimesStats[] notificationTimesStatsArr) {
        C0702g.b("UsageFragment", "onNotificationTimesLoaded usingTimeStats = " + C0702g.h(notificationTimesStatsArr));
        this.f14958s0 = notificationTimesStatsArr;
        this.f14947h0.v0(notificationTimesStatsArr);
    }

    protected void t2(PackageNotificationTimesStats[] packageNotificationTimesStatsArr) {
        C0702g.b("UsageFragment", "onPackageNotificationTimesLoaded packageNotificationTimesStats = " + C0702g.h(packageNotificationTimesStatsArr));
        this.f14960u0 = packageNotificationTimesStatsArr;
        this.f14947h0.j0(packageNotificationTimesStatsArr);
    }

    protected void u2(PickupTimesStats[] pickupTimesStatsArr) {
        C0702g.b("UsageFragment", "onPickupTimesLoaded usingTimeStats = " + C0702g.h(pickupTimesStatsArr));
        this.f14959t0 = pickupTimesStatsArr;
        this.f14947h0.w0(pickupTimesStatsArr);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        C0702g.p("UsageFragment", "onSaveInstanceState = " + bundle);
        this.f14949j0 = com.stepos.digitalwellbeing.server.data.a.values()[u().getInt("interval", com.stepos.digitalwellbeing.server.data.a.DAY.ordinal())];
        this.f14950k0 = u().getInt("proxy", 0);
        this.f14951l0 = u().getLong("operator_id", -1L);
        F1 f12 = (F1) androidx.lifecycle.V.b(y1()).b(this.f14949j0.name(), F1.class);
        this.f14945f0 = f12;
        if (this.f14950k0 == 0) {
            f12.j0(new C1183b(w()));
        } else {
            v2.d dVar = new v2.d(this.f14951l0);
            dVar.init();
            this.f14945f0.j0(dVar);
        }
        AbstractViewOnTouchListenerC0600i abstractViewOnTouchListenerC0600iE2 = e2(this.f14949j0, this.f14950k0);
        this.f14947h0 = abstractViewOnTouchListenerC0600iE2;
        abstractViewOnTouchListenerC0600iE2.p0(this);
        this.f14947h0.n0(this);
        getLifecycle().a(this.f14947h0);
        d2(this.f14945f0);
        if (bundle != null) {
            try {
                this.f14955p0 = (DataToken) bundle.getParcelable("dataToken", DataToken.class);
                this.f14947h0.h0(bundle);
                this.f14957r0 = (UsingTimeStats[]) bundle.getParcelableArray("using_time_stats", UsingTimeStats.class);
                this.f14958s0 = (NotificationTimesStats[]) bundle.getParcelableArray("notification_times_stats", NotificationTimesStats.class);
                this.f14959t0 = (PickupTimesStats[]) bundle.getParcelableArray("pickup_times_stats", PickupTimesStats.class);
                this.f14960u0 = (PackageNotificationTimesStats[]) bundle.getParcelableArray("package_notification_times_stats", PackageNotificationTimesStats.class);
                this.f14961v0 = bundle.getParcelableArrayList("app_usage_limit_data_list", C1216d.class);
                this.f14962w0 = bundle.getParcelableArrayList("category_usage_limit_data_list", C1257w.class);
                this.f14947h0.x0(this.f14957r0);
                this.f14947h0.v0(this.f14958s0);
                this.f14947h0.w0(this.f14959t0);
                this.f14947h0.k0(this.f14961v0);
                this.f14947h0.l0(this.f14962w0);
                this.f14947h0.j0(this.f14960u0);
                this.f14947h0.h0(bundle);
                this.f14963x0 = true;
            } catch (NoSuchMethodError e6) {
                e6.printStackTrace();
            }
        }
    }

    protected void v2(UsingTimeStats[] usingTimeStatsArr) {
        C0702g.b("UsageFragment", "onUsingTimeStatsLoaded usingTimeStats = " + C0702g.h(usingTimeStatsArr));
        this.f14957r0 = usingTimeStatsArr;
        this.f14947h0.x0(usingTimeStatsArr);
        if (this.f14950k0 != 1 || usingTimeStatsArr == null || usingTimeStatsArr.length <= 0) {
            return;
        }
        long updateTime = usingTimeStatsArr[0].getUpdateTime();
        R1.a.a("UPDATE_TIME", "UF onUsingTimeStatsLoaded usingTimeStats updateTime = " + updateTime);
        this.f14947h0.q0(updateTime);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void y0(Menu menu, MenuInflater menuInflater) {
        super.y0(menu, menuInflater);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.us_usage_fragment, viewGroup, false);
    }

    protected void z2() {
        View view = this.f14948i0;
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
