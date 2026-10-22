package com.stepos.familyguard.ui.usage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.Y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.limit.CategoryLimitActivity;
import com.stepos.familyguard.ui.limit.PackageLimitActivity;
import com.stepos.familyguard.ui.main.DigitalWellbeingSettingsActivity;
import com.stepos.familyguard.ui.widget.MyRecyclerView;
import com.stepos.widget.toolbar.StepOSTitleBar;
import f2.C0697b;
import f2.C0702g;
import f2.C0711p;
import j2.C0785b;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;
import p2.g;
import stepos.support.v7.widget.r;
import v2.C1183b;
import w2.C1213c;
import w2.InterfaceC1258w0;
import w2.InterfaceC1260x0;
import w2.InterfaceC1262y0;
import x3.EnumC1285a;
import z3.C1347a;

/* loaded from: classes.dex */
public class DigitalWellbeingActivity extends q2.j implements InterfaceC1260x0, InterfaceC1258w0, InterfaceC1262y0 {

    /* renamed from: F, reason: collision with root package name */
    private static U f14873F;

    /* renamed from: A, reason: collision with root package name */
    private boolean f14874A;

    /* renamed from: D, reason: collision with root package name */
    private boolean f14877D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f14878E;

    /* renamed from: d, reason: collision with root package name */
    protected C0610t f14879d;

    /* renamed from: e, reason: collision with root package name */
    private AbstractViewOnTouchListenerC0592a f14880e;

    /* renamed from: f, reason: collision with root package name */
    private long f14881f;

    /* renamed from: g, reason: collision with root package name */
    private C0785b f14882g;

    /* renamed from: i, reason: collision with root package name */
    private D2.r<String, Drawable> f14884i;

    /* renamed from: l, reason: collision with root package name */
    private A3.c f14887l;

    /* renamed from: m, reason: collision with root package name */
    private x3.e<Object> f14888m;

    /* renamed from: o, reason: collision with root package name */
    private boolean f14890o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f14891p;

    /* renamed from: q, reason: collision with root package name */
    private long f14892q;

    /* renamed from: r, reason: collision with root package name */
    private long f14893r;

    /* renamed from: t, reason: collision with root package name */
    private boolean f14895t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f14896u;

    /* renamed from: v, reason: collision with root package name */
    private long f14897v;

    /* renamed from: w, reason: collision with root package name */
    private int f14898w;

    /* renamed from: x, reason: collision with root package name */
    private int f14899x;

    /* renamed from: h, reason: collision with root package name */
    private boolean f14883h = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14885j = false;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f14886k = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f14889n = false;

    /* renamed from: s, reason: collision with root package name */
    private long f14894s = -1;

    /* renamed from: y, reason: collision with root package name */
    private final Handler f14900y = new Handler(Looper.getMainLooper());

    /* renamed from: z, reason: collision with root package name */
    private final Runnable f14901z = new Runnable() { // from class: w2.y
        @Override // java.lang.Runnable
        public final void run() {
            this.f23684a.e1();
        }
    };

    /* renamed from: B, reason: collision with root package name */
    private final BroadcastReceiver f14875B = new a();

    /* renamed from: C, reason: collision with root package name */
    private final Runnable f14876C = new Runnable() { // from class: w2.J
        @Override // java.lang.Runnable
        public final void run() {
            this.f23571a.f1();
        }
    };

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"com.stepos.digitalwellbeing.ACTION_USAGE_DATA_INVALIDATED".equals(intent.getAction())) {
                return;
            }
            C0702g.b("DWA", "usage invalidated broadcast, force refresh after clock jump");
            DigitalWellbeingActivity.f14873F = null;
            DigitalWellbeingActivity.this.f14894s = -1L;
            if (DigitalWellbeingActivity.this.f14883h && DigitalWellbeingActivity.this.f14889n) {
                DigitalWellbeingActivity.this.f14886k = false;
                DigitalWellbeingActivity.this.f14885j = false;
                DigitalWellbeingActivity.this.f14895t = true;
                DigitalWellbeingService.c0(DigitalWellbeingActivity.this);
                if (p2.g.u()) {
                    DigitalWellbeingActivity.this.J1();
                    DigitalWellbeingActivity.this.O1();
                }
                DigitalWellbeingActivity.this.f14900y.removeCallbacks(DigitalWellbeingActivity.this.f14876C);
                DigitalWellbeingActivity.this.f14900y.postDelayed(DigitalWellbeingActivity.this.f14876C, 1000L);
                DigitalWellbeingActivity.this.f14897v = SystemClock.elapsedRealtime() + 8000;
                DigitalWellbeingActivity.this.F1();
            }
        }
    }

    private void A1(boolean z5) {
        if (!p2.g.v(this)) {
            this.f14882g.f17685j.setVisibility(0);
            if (p2.g.N(this)) {
                I1();
                return;
            }
            if (this.f14877D) {
                return;
            }
            boolean zE = p2.g.E(this);
            this.f14877D = zE;
            if (zE) {
                return;
            }
            I1();
            return;
        }
        p2.g.j(this);
        this.f14877D = false;
        this.f14878E = false;
        if (z5) {
            R0();
            return;
        }
        if (p2.g.M(this)) {
            Z0();
            this.f14882g.f17677b.setVisibility(0);
            return;
        }
        this.f14882g.f17677b.setVisibility(8);
        if (!p2.g.x(this)) {
            this.f14882g.f17685j.setVisibility(0);
            return;
        }
        this.f14882g.f17685j.setVisibility(8);
        if (this.f14883h) {
            Y0();
        }
    }

    private void B1() {
        if (this.f14883h && p2.g.u()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.f14886k && jCurrentTimeMillis - this.f14893r > 8000) {
                C0702g.O("DWA", "refreshUsageDataInPlace() reset stuck in-flight load");
                this.f14886k = false;
            }
            if (this.f14886k) {
                C0702g.b("DWA", "refreshUsageDataInPlace() skipped, load in flight");
                return;
            }
            C0702g.b("DWA", "refreshUsageDataInPlace() this = " + this);
            this.f14895t = true;
            N1();
        }
    }

    private void C1() {
        if (this.f14874A) {
            return;
        }
        androidx.core.content.a.i(this, this.f14875B, new IntentFilter("com.stepos.digitalwellbeing.ACTION_USAGE_DATA_INVALIDATED"), 4);
        this.f14874A = true;
    }

    private void D1() {
        C0785b c0785b = this.f14882g;
        if (c0785b == null || c0785b.f17686k == null) {
            return;
        }
        Q0();
        Runnable runnable = new Runnable() { // from class: w2.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f23687a.p1();
            }
        };
        runnable.run();
        this.f14882g.f17686k.post(runnable);
        this.f14882g.f17686k.postDelayed(runnable, 50L);
    }

    private void E1() {
        DigitalWellbeingService.d0(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1() {
        this.f14900y.removeCallbacks(this.f14901z);
        if (this.f14889n && SystemClock.elapsedRealtime() < this.f14897v) {
            this.f14900y.postDelayed(this.f14901z, 2000L);
        }
    }

    private void G1() throws Resources.NotFoundException {
        final int iV0 = V0();
        if (iV0 != 0) {
            x2.g.f(this.f14882g.f17687l, getTitle(), new View.OnClickListener() { // from class: w2.E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f23545a.q1(view);
                }
            }, R.drawable.stepos_icon_more, getString(R.string.fg_settings), new View.OnClickListener() { // from class: w2.F
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f23553a.r1(iV0, view);
                }
            });
        } else {
            x2.g.e(this.f14882g.f17687l, getTitle(), new View.OnClickListener() { // from class: w2.G
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f23560a.s1(view);
                }
            });
        }
        K0();
    }

    private boolean H0() {
        AbstractViewOnTouchListenerC0592a abstractViewOnTouchListenerC0592a;
        U u5 = f14873F;
        if (u5 == null || W0(u5) == null || (abstractViewOnTouchListenerC0592a = this.f14880e) == null) {
            return false;
        }
        if (this.f14885j) {
            return true;
        }
        abstractViewOnTouchListenerC0592a.W(u5);
        this.f14885j = true;
        Z0();
        C0702g.b("DWA", "applySharedUsageCacheIfPresent() applied cache this = " + this);
        return true;
    }

    private boolean H1() {
        Intent intent = getIntent();
        return intent != null && intent.getBooleanExtra("force_refresh_usage", false);
    }

    private static void I0(View view, View view2) {
        int height = view.getHeight();
        if (height <= 0 || !(view2 instanceof RecyclerView)) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view2;
        int i5 = view2.getContext() instanceof DigitalWellbeingActivity ? ((DigitalWellbeingActivity) view2.getContext()).f14899x : 0;
        if (recyclerView.getPaddingTop() == height && recyclerView.getPaddingBottom() == i5) {
            return;
        }
        int paddingTop = recyclerView.getPaddingTop();
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        recyclerView.setPadding(recyclerView.getPaddingLeft(), height, recyclerView.getPaddingRight(), i5);
        if (iComputeVerticalScrollOffset > 0 || height <= paddingTop || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(0, 0);
    }

    private void I1() {
        if (this.f14878E) {
            return;
        }
        this.f14878E = true;
        K1(this);
    }

    private void J0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Window window = getWindow();
        window.setDecorFitsSystemWindows(false);
        window.setNavigationBarContrastEnforced(false);
        T1.i.a(window);
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1() {
        this.f14882g.f17682g.setVisibility(0);
    }

    private void K0() {
        this.f14882g.f17687l.setBackdropBlurEnabled(true);
        this.f14882g.f17686k.setClipToPadding(false);
        this.f14882g.f17687l.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: w2.O
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                this.f23580a.b1(view, i5, i6, i7, i8, i9, i10, i11, i12);
            }
        });
        androidx.core.view.H.w0(this.f14882g.b(), new InterfaceC0479y() { // from class: w2.P
            @Override // androidx.core.view.InterfaceC0479y
            public final androidx.core.view.Y a(View view, androidx.core.view.Y y5) {
                return this.f23582a.c1(view, y5);
            }
        });
        androidx.core.view.H.g0(this.f14882g.b());
        Q0();
    }

    private void K1(Context context) {
        new C2.b(context).x(R.string.us_request_app_list_permission_title).m(R.string.us_request_app_list_permission_des).u(R.string.fg_to_open, new DialogInterface.OnClickListener() { // from class: w2.K
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f23572a.t1(dialogInterface, i5);
            }
        }).o(R.string.fg_relation_manager_logout, new DialogInterface.OnClickListener() { // from class: w2.L
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f23574a.u1(dialogInterface, i5);
            }
        }).g(false).c().show();
    }

    private void L0() {
        this.f14900y.removeCallbacks(this.f14901z);
        this.f14900y.removeCallbacks(this.f14876C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public void r1(View view, int i5) {
        stepos.support.v7.widget.r rVar = new stepos.support.v7.widget.r(this, view, 8388613);
        rVar.h(i5);
        rVar.j(new r.b() { // from class: w2.N
            @Override // stepos.support.v7.widget.r.b
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f23578a.onOptionsItemSelected(menuItem);
            }
        });
        rVar.k();
    }

    private void M0() {
        Intent intent = getIntent();
        if (intent != null) {
            intent.removeExtra("force_refresh_usage");
        }
    }

    public static void M1(Activity activity, long j5) {
        Intent intent = activity.getIntent();
        boolean zEquals = TextUtils.equals("com.stepos.digitalwellbeing.VIEW", intent == null ? null : intent.getAction());
        Intent intent2 = new Intent();
        intent2.setClass(activity, DigitalWellbeingActivity.class);
        intent2.putExtra("from_settings", zEquals);
        intent2.putExtra("operator_id", j5);
        intent2.putExtra("force_refresh_usage", true);
        intent2.addFlags(872448000);
        activity.startActivity(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        C0702g.b("DWA", "startLoadWithRetry() called this = " + this);
        if (!p2.g.u()) {
            Z0();
            this.f14882g.f17677b.setVisibility(0);
        } else {
            if (H0()) {
                N1();
                return;
            }
            this.f14885j = false;
            x3.e<Object> eVar = this.f14888m;
            if (eVar != null) {
                eVar.d(Long.valueOf(System.currentTimeMillis()));
            } else {
                C0702g.O("DWA", "mEmitter == null");
            }
        }
    }

    private static long P1(StatsDataSet statsDataSet) {
        long jLongValue = 0;
        if (statsDataSet != null && statsDataSet.getPackageUsingTimeMap() != null) {
            for (Long l5 : statsDataSet.getPackageUsingTimeMap().values()) {
                if (l5 != null) {
                    jLongValue += l5.longValue();
                }
            }
        }
        return jLongValue;
    }

    private void Q0() {
        MyRecyclerView myRecyclerView;
        C0785b c0785b = this.f14882g;
        if (c0785b == null || c0785b.f17687l == null || (myRecyclerView = c0785b.f17686k) == null) {
            return;
        }
        myRecyclerView.setClipToPadding(false);
        Runnable runnable = new Runnable() { // from class: w2.A
            @Override // java.lang.Runnable
            public final void run() {
                this.f23525a.d1();
            }
        };
        runnable.run();
        this.f14882g.f17687l.post(runnable);
        this.f14882g.f17686k.post(runnable);
    }

    private void Q1() {
        if (this.f14874A) {
            unregisterReceiver(this.f14875B);
            this.f14874A = false;
        }
    }

    private void R0() {
        if (p2.g.M(this)) {
            Z0();
            this.f14882g.f17677b.setVisibility(0);
            return;
        }
        this.f14882g.f17677b.setVisibility(8);
        this.f14882g.f17685j.setVisibility(8);
        O1();
        B2.e.c();
        AppWidgetManagerService.n(this);
    }

    private void S0() {
        C0702g.b("DWA", "forceReloadUsageDataOnStart() this = " + this);
        this.f14895t = true;
        if (!this.f14885j) {
            H0();
        }
        O1();
    }

    private StatsDataSet W0(U u5) {
        StatsDataSet[] statsDataSetArrU;
        StatsDataSet statsDataSet;
        if (u5 == null || (statsDataSetArrU = u5.u()) == null || statsDataSetArrU.length < 2 || (statsDataSet = statsDataSetArrU[1]) == null || statsDataSet.getChildren() == null) {
            return null;
        }
        int iB = C0711p.B(System.currentTimeMillis());
        if (iB == 0) {
            iB = 7;
        }
        int i5 = iB - 1;
        StatsDataSet[] children = statsDataSet.getChildren();
        if (i5 < 0 || i5 >= children.length) {
            return null;
        }
        return children[i5];
    }

    private void X0(DataToken dataToken) {
        Z0();
        C0702g.O("DWA", "handleInvalidDataToken() called with: dataToken = [" + dataToken + "]");
        if (dataToken.getInvalidType() == -3 || dataToken.getInvalidType() == -2) {
            if (p2.g.u()) {
                return;
            }
            this.f14882g.f17677b.setVisibility(0);
        } else if (dataToken.getInvalidType() == -1) {
            this.f14882g.f17685j.setVisibility(0);
        }
    }

    private void Y0() {
        if (H1()) {
            M0();
        }
        if (this.f14890o) {
            this.f14890o = false;
            this.f14891p = false;
            C0702g.b("DWA", "handleUsageRefreshOnStart() in-place refresh after sub-page");
            B1();
            return;
        }
        this.f14891p = false;
        if (!C0697b.n()) {
            if (!this.f14885j) {
                C0702g.b("DWA", "handleUsageRefreshOnStart() force reload on entry");
                S0();
                return;
            } else {
                C0702g.b("DWA", "handleUsageRefreshOnStart() immediate in-place refresh on entry");
                this.f14895t = true;
                B1();
                return;
            }
        }
        C0702g.b("DWA", "handleUsageRefreshOnStart() immediate reload during jump sanitize");
        this.f14886k = false;
        this.f14885j = false;
        this.f14895t = true;
        f14873F = null;
        this.f14894s = -1L;
        DigitalWellbeingService.c0(this);
        if (p2.g.u()) {
            J1();
            N1();
        }
    }

    private void Z0() {
        this.f14882g.f17682g.setVisibility(8);
    }

    private boolean a1() {
        return getIntent().getBooleanExtra("from_settings", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        I0(view, this.f14882g.f17686k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Y c1(View view, Y y5) {
        androidx.core.graphics.b bVarF = y5.f(Y.l.e());
        androidx.core.graphics.b bVarF2 = y5.f(Y.l.d());
        this.f14898w = bVarF.f9643b;
        this.f14899x = bVarF2.f9645d;
        if (view.getPaddingTop() != this.f14898w) {
            view.setPadding(view.getPaddingLeft(), this.f14898w, view.getPaddingRight(), 0);
        }
        C0785b c0785b = this.f14882g;
        I0(c0785b.f17687l, c0785b.f17686k);
        return y5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1() {
        StepOSTitleBar stepOSTitleBar;
        MyRecyclerView myRecyclerView;
        C0785b c0785b = this.f14882g;
        if (c0785b == null || (stepOSTitleBar = c0785b.f17687l) == null || (myRecyclerView = c0785b.f17686k) == null) {
            return;
        }
        I0(stepOSTitleBar, myRecyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1() {
        if (this.f14883h && this.f14889n && !this.f14890o && SystemClock.elapsedRealtime() < this.f14897v) {
            if (this.f14885j) {
                C0702g.b("DWA", "clock-jump window auto refresh usage");
                B1();
            } else {
                C0702g.b("DWA", "clock-jump window retry usage load");
                N1();
            }
        }
        F1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f1() {
        if (this.f14883h && this.f14889n && p2.g.u()) {
            C0702g.b("DWA", "clock-jump follow-up refresh");
            this.f14886k = false;
            f14873F = null;
            this.f14894s = -1L;
            DigitalWellbeingService.c0(this);
            N1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1(Long l5) {
        this.f14881f = l5.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(x3.g gVar) {
        this.f14888m = gVar;
        C0702g.b("DWA", "Flowable.create() called with: emitter = [" + gVar + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean i1(Long l5) {
        C0702g.b("DWA", "takeWhile() called with: mLoaded = [" + this.f14885j + "] mStarted " + this.f14889n + " this = " + this);
        return !this.f14885j && this.f14889n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Q4.a j1(Object obj) {
        C0702g.b("DWA", "Flowable.flatMap() called with: aLong = [" + obj + "]");
        return x3.f.B(0L, 7L, 0L, 2L, TimeUnit.SECONDS).a0(new D3.j() { // from class: w2.H
            @Override // D3.j
            public final boolean test(Object obj2) {
                return this.f23564a.i1((Long) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1() {
        if (this.f14885j || !this.f14889n) {
            return;
        }
        C0702g.O("DWA", "retry exhausted, final load attempt this = " + this);
        N1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1(Long l5) {
        C0702g.b("DWA", "subscribe() called with: mLoaded = [" + this.f14885j + "] this = " + this);
        if (this.f14885j) {
            Z0();
        } else if (p2.g.u()) {
            J1();
            N1();
        } else {
            Z0();
            this.f14882g.f17677b.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1(boolean z5) {
        if (!z5) {
            finish();
            this.f14882g.f17685j.postDelayed(new Runnable() { // from class: w2.I
                @Override // java.lang.Runnable
                public final void run() {
                    T1.b.k();
                }
            }, 100L);
            R1.a.a("DWA", "no per finish");
        } else {
            try {
                this.f14879d.a();
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
            A1(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1(DialogInterface dialogInterface, int i5) {
        w1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1(View view) {
        C1213c.d(this, new DialogInterface.OnClickListener() { // from class: w2.M
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f23576a.n1(dialogInterface, i5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p1() {
        C0785b c0785b = this.f14882g;
        if (c0785b == null || c0785b.f17686k == null) {
            return;
        }
        Q0();
        this.f14882g.f17686k.stopScroll();
        if (this.f14882g.f17686k.getLayoutManager() instanceof LinearLayoutManager) {
            ((LinearLayoutManager) this.f14882g.f17686k.getLayoutManager()).scrollToPositionWithOffset(0, 0);
        } else {
            this.f14882g.f17686k.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q1(View view) {
        getOnBackPressedDispatcher().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s1(View view) {
        getOnBackPressedDispatcher().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(DialogInterface dialogInterface, int i5) {
        this.f14878E = false;
        p2.g.s(k(), "android.permission.QUERY_ALL_PACKAGES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(DialogInterface dialogInterface, int i5) {
        this.f14878E = false;
        dialogInterface.dismiss();
        k().finish();
    }

    private void v1() {
        this.f14890o = true;
    }

    private void w1() {
        if (!p2.g.W(true)) {
            Z0();
            this.f14882g.f17677b.setVisibility(0);
            return;
        }
        this.f14882g.f17677b.setVisibility(8);
        this.f14882g.f17685j.setVisibility(8);
        try {
            this.f14879d.a();
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
        B2.e.c();
        AppWidgetManagerService.n(this);
        O1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(DataToken dataToken) {
        C0702g.b("DWA", "dataToken = " + dataToken);
        if (!p2.g.u()) {
            Z0();
            this.f14882g.f17677b.setVisibility(0);
            return;
        }
        if (dataToken == null) {
            this.f14886k = false;
            Z0();
        } else if (!dataToken.isValid()) {
            this.f14886k = false;
            X0(dataToken);
        } else {
            try {
                this.f14879d.q(dataToken);
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(boolean z5) {
        C0702g.b("DWA", "onInitChanged() called with: init = [" + z5 + "]");
        this.f14883h = z5;
        if (z5 && p2.g.x(this) && p2.g.u()) {
            O1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(U u5) {
        this.f14886k = false;
        StatsDataSet statsDataSetW0 = W0(u5);
        this.f14885j = statsDataSetW0 != null;
        C0702g.b("DWA", "onUsageLimitDataSetLoaded() called with: usageLimitDataSet updateTime = [" + (statsDataSetW0 == null ? "invalid" : C0702g.t(statsDataSetW0.getUpdateTime(), true)) + "]");
        if (!this.f14885j) {
            Z0();
            if (p2.g.u()) {
                return;
            }
            this.f14882g.f17677b.setVisibility(0);
            return;
        }
        Z0();
        StatsDataSet statsDataSetW02 = W0(f14873F);
        if (statsDataSetW02 != null && this.f14894s == statsDataSetW0.getUsingTime() && statsDataSetW0.getUpdateTime() == statsDataSetW02.getUpdateTime() && statsDataSetW0.getUsingTime() == statsDataSetW02.getUsingTime() && P1(statsDataSetW0) == P1(statsDataSetW02)) {
            C0702g.b("DWA", "onUsageLimitDataSetLoaded() skip notify, data unchanged");
            return;
        }
        this.f14880e.W(u5);
        this.f14894s = statsDataSetW0.getUsingTime();
        if (this.f14896u) {
            this.f14896u = false;
            D1();
        }
        f14873F = u5;
        this.f14892q = System.currentTimeMillis();
    }

    @Override // com.stepos.familyguard.ui.base.a
    protected void I() {
        B2.b.a();
    }

    protected AbstractViewOnTouchListenerC0592a N0(D2.r<String, Drawable> rVar) {
        return new C0609s(this, rVar);
    }

    public void N1() {
        C0702g.b("DWA", "startLoad() called");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f14886k && jCurrentTimeMillis - this.f14893r > 8000) {
            C0702g.O("DWA", "startLoad() reset stuck in-flight load");
            this.f14886k = false;
        }
        if (this.f14886k) {
            C0702g.b("DWA", "startLoad() skipped, load in flight");
            return;
        }
        if (p2.g.u()) {
            this.f14886k = true;
            this.f14893r = jCurrentTimeMillis;
            try {
                this.f14879d.r();
                this.f14879d.g();
            } catch (RemoteException e6) {
                this.f14886k = false;
                e6.printStackTrace();
            }
        }
    }

    protected D2.r<String, Drawable> O0() {
        return new D2.b(D2.j.a().b());
    }

    protected v2.e P0() {
        return new C1183b(this);
    }

    protected int T0() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return 0;
        }
        return extras.getInt("proxy", 0);
    }

    protected long U0() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return -1L;
        }
        return extras.getLong("operator_id", -1L);
    }

    protected int V0() {
        return R.menu.us_digital_wellbeing_activity_menu;
    }

    @Override // w2.InterfaceC1258w0
    public void e(int i5, String str) {
        v1();
        CategoryLimitActivity.Z(this, T0(), i5, str, U0());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (a1()) {
            overridePendingTransition(R.anim.stepos_activity_to_next_close_enter, R.anim.stepos_activity_to_next_close_exit);
        }
    }

    @Override // w2.InterfaceC1260x0
    public void h(String str, String str2, int i5) {
        v1();
        C2.m.a(this, str, i5, str2);
    }

    @Override // w2.InterfaceC1262y0
    public void i(String str, String str2) {
        v1();
        PackageLimitActivity.Z(this, T0(), str, str2, U0());
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14879d = (C0610t) new androidx.lifecycle.U(this).a(C0610t.class);
        v2.e eVarP0 = P0();
        C0702g.b("DWA", "onCreate() called with: proxyImpl = [" + eVarP0 + "] this = " + this);
        this.f14879d.c0(eVarP0);
        this.f14879d.S().g(this, new androidx.lifecycle.C() { // from class: w2.Q
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23584a.x1((DataToken) obj);
            }
        });
        this.f14879d.V().g(this, new androidx.lifecycle.C() { // from class: w2.S
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23585a.z1((com.stepos.familyguard.ui.usage.U) obj);
            }
        });
        this.f14879d.b().g(this, new androidx.lifecycle.C() { // from class: w2.T
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23586a.y1(((Boolean) obj).booleanValue());
            }
        });
        this.f14879d.R().g(this, new androidx.lifecycle.C() { // from class: w2.U
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f23587a.g1((Long) obj);
            }
        });
        this.f14887l = x3.f.h(new x3.h() { // from class: w2.V
            @Override // x3.h
            public final void a(x3.g gVar) {
                this.f23588a.h1(gVar);
            }
        }, EnumC1285a.LATEST).i(150L, TimeUnit.MILLISECONDS).r(new D3.h() { // from class: w2.W
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f23589a.j1(obj);
            }
        }).G(C1347a.a()).X(T3.a.c()).m(new D3.a() { // from class: w2.X
            @Override // D3.a
            public final void run() {
                this.f23590a.k1();
            }
        }).T(new D3.c() { // from class: w2.Y
            @Override // D3.c
            public final void accept(Object obj) {
                this.f23596a.l1((Long) obj);
            }
        }, S1.a.b());
        C0702g.b("DWA", "onCreate() END");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // com.stepos.familyguard.ui.base.a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C0702g.b("DWA", "onDestroy() called this = " + this);
        this.f14879d.J();
        this.f14880e.w();
        this.f14884i.a();
        this.f14888m = null;
        A3.c cVar = this.f14887l;
        if (cVar != null) {
            cVar.dispose();
        }
        L0();
        Q1();
    }

    @Override // androidx.activity.h, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f14896u = true;
        D1();
        if (H1()) {
            C0702g.b("DWA", "onNewIntent() force refresh usage from widget/settings entry");
            M0();
            S0();
        } else if (this.f14883h && p2.g.x(this) && p2.g.u()) {
            C0702g.b("DWA", "onNewIntent() refresh usage for launcher re-entry");
            S0();
        }
    }

    @Override // com.stepos.familyguard.ui.base.a, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_every_week) {
            Intent intent = new Intent();
            intent.setClass(this, WeekDigitalWellbeingActivity.class);
            v1();
            startActivity(intent);
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_usage_limit) {
            v1();
            LimitManagerActivity.m0(this);
            return true;
        }
        if (menuItem.getItemId() != R.id.menu_settings) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent2 = new Intent();
        intent2.setClass(this, DigitalWellbeingSettingsActivity.class);
        v1();
        startActivity(intent2);
        return true;
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f14884i.c();
        L0();
    }

    @Override // androidx.fragment.app.ActivityC0516k, androidx.activity.h, android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 != 19415) {
            return;
        }
        this.f14877D = false;
        if (!p2.g.v(this)) {
            p2.g.A(this);
            finish();
            this.f14882g.f17685j.postDelayed(new Runnable() { // from class: w2.B
                @Override // java.lang.Runnable
                public final void run() {
                    T1.b.k();
                }
            }, 100L);
        } else {
            try {
                this.f14879d.a();
            } catch (RemoteException e6) {
                e6.printStackTrace();
            }
            A1(true);
        }
    }

    @Override // com.stepos.familyguard.ui.base.a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onResume() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onResume();
        J0();
        Q0();
        if (this.f14896u) {
            D1();
        }
        this.f14884i.b();
        if (this.f14895t) {
            this.f14895t = false;
        } else if (this.f14883h && !this.f14890o && p2.g.u()) {
            C0702g.b("DWA", "onResume() immediate refresh usage");
            B1();
        }
        F1();
    }

    @Override // com.stepos.familyguard.ui.base.a, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStart() {
        super.onStart();
        C0785b c0785b = this.f14882g;
        if (c0785b != null) {
            c0785b.f17687l.setBackdropBlurEnabled(true);
        }
        this.f14889n = true;
        C0702g.b("DWA", "onStart() START this = " + this);
        AppWidgetManagerService.y(this);
        E1();
        if (p2.g.O(this)) {
            this.f14882g.f17685j.setVisibility(0);
            p2.g.Q(this, new g.k() { // from class: w2.C
                @Override // p2.g.k
                public final void a(boolean z5) {
                    this.f23535a.m1(z5);
                }
            });
        } else {
            A1(false);
        }
        C0702g.b("DWA", "onStart() END");
        C1();
    }

    @Override // com.stepos.familyguard.ui.base.a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStop() {
        C0785b c0785b = this.f14882g;
        if (c0785b != null) {
            c0785b.f17687l.setBackdropBlurEnabled(false);
        }
        super.onStop();
        this.f14889n = false;
        this.f14891p = true;
        L0();
        Q1();
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        C0785b c0785bC = C0785b.c(getLayoutInflater());
        this.f14882g = c0785bC;
        return c0785bC.b();
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.y(view, bundle);
        D2.r<String, Drawable> rVarO0 = O0();
        this.f14884i = rVarO0;
        AbstractViewOnTouchListenerC0592a abstractViewOnTouchListenerC0592aN0 = N0(rVarO0);
        this.f14880e = abstractViewOnTouchListenerC0592aN0;
        abstractViewOnTouchListenerC0592aN0.T(this);
        this.f14880e.V(this);
        this.f14880e.U(this);
        this.f14882g.f17686k.setLayoutManager(new LinearLayoutManager(this));
        this.f14882g.f17686k.setAdapter(this.f14880e);
        this.f14882g.f17686k.X0();
        if (!H1()) {
            H0();
        }
        this.f14882g.f17678c.setOnClickListener(new View.OnClickListener() { // from class: w2.D
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f23541a.o1(view2);
            }
        });
        G1();
        J0();
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        x2.g.d(this);
    }
}
