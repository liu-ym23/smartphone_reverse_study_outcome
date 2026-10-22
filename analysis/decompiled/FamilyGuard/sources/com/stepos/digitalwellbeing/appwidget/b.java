package com.stepos.digitalwellbeing.appwidget;

import A3.c;
import V1.A;
import V1.o;
import V1.q;
import V1.s;
import Y1.l;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.UsageDirectActivity;
import f2.C0702g;
import java.util.ArrayList;
import p2.g;
import x3.f;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final A f14493a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f14494b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f14495c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f14496d;

    /* renamed from: e, reason: collision with root package name */
    private final ComponentName f14497e;

    /* renamed from: f, reason: collision with root package name */
    private Context f14498f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f14499g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f14500h;

    /* renamed from: i, reason: collision with root package name */
    private final AppWidgetManager f14501i;

    /* renamed from: j, reason: collision with root package name */
    protected c f14502j;

    public b(Context context, A a6, ComponentName componentName) {
        this.f14493a = a6;
        this.f14497e = componentName;
        this.f14498f = context;
        this.f14501i = (AppWidgetManager) context.getSystemService("appwidget");
    }

    public static void C(Context context, AppWidgetManager appWidgetManager, A a6, int[] iArr) {
        b bVarB;
        if (context == null || appWidgetManager == null || iArr == null || iArr.length == 0 || (bVarB = o.b(context, a6, o.c(context, a6))) == null) {
            return;
        }
        bVarB.z(false);
        bVarB.B(true);
        bVarB.y(l.c1());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 : iArr) {
            if (f(appWidgetManager.getAppWidgetOptions(i5))) {
                arrayList2.add(Integer.valueOf(i5));
            } else {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        if (!arrayList2.isEmpty()) {
            bVarB.A(true);
            RemoteViews remoteViewsI = bVarB.i(context);
            bVarB.k(remoteViewsI);
            bVarB.c(context, remoteViewsI);
            appWidgetManager.updateAppWidget(C2.c.c(arrayList2), remoteViewsI);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        bVarB.A(false);
        RemoteViews remoteViewsI2 = bVarB.i(context);
        bVarB.k(remoteViewsI2);
        bVarB.c(context, remoteViewsI2);
        appWidgetManager.updateAppWidget(C2.c.c(arrayList), remoteViewsI2);
    }

    private void F(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        RemoteViews remoteViewsI;
        try {
            remoteViewsI = G(context, appWidgetManager);
        } catch (Throwable th) {
            R1.a.b("DigitalAppWidgetBase", "updateWidget failed, fallback RemoteViews: " + Log.getStackTraceString(th));
            remoteViewsI = i(context);
        }
        try {
            k(remoteViewsI);
            c(context, remoteViewsI);
            appWidgetManager.updateAppWidget(iArr, remoteViewsI);
        } catch (Throwable th2) {
            R1.a.b("DigitalAppWidgetBase", "bind/update AppWidget failed: " + Log.getStackTraceString(th2));
            try {
                e(context, appWidgetManager, this.f14493a, iArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(applicationContext);
        for (A a6 : A.values()) {
            if (a6 == A.UNKNOWN) {
                return;
            }
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(o.c(applicationContext, a6));
            if (appWidgetIds != null && appWidgetIds.length > 0) {
                e(applicationContext, appWidgetManager, a6, appWidgetIds);
            }
        }
    }

    public static void e(Context context, AppWidgetManager appWidgetManager, A a6, int[] iArr) {
        b bVarB;
        if (context == null || appWidgetManager == null || iArr == null || iArr.length == 0 || (bVarB = o.b(context, a6, o.c(context, a6))) == null) {
            return;
        }
        for (int i5 : iArr) {
            bVarB.A(f(appWidgetManager.getAppWidgetOptions(i5)));
            RemoteViews remoteViewsI = bVarB.i(context);
            bVarB.c(context, remoteViewsI);
            appWidgetManager.partiallyUpdateAppWidget(i5, remoteViewsI);
        }
    }

    static boolean f(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return ((double) (((float) bundle.getInt("appWidgetMinWidth")) / ((float) bundle.getInt("appWidgetMaxHeight")))) < 0.72d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(Bundle bundle) {
        try {
            t(bundle);
        } catch (Throwable th) {
            R1.a.b("DigitalAppWidgetBase", "onDataChanged failed: " + Log.getStackTraceString(th));
            try {
                e(this.f14498f, this.f14501i, this.f14493a, this.f14501i.getAppWidgetIds(this.f14497e));
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(Throwable th) {
        R1.a.b("DigitalAppWidgetBase", Log.getStackTraceString(th));
        try {
            e(this.f14498f, this.f14501i, this.f14493a, this.f14501i.getAppWidgetIds(this.f14497e));
        } catch (Throwable unused) {
        }
    }

    public static void u(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(applicationContext);
        for (A a6 : A.values()) {
            if (a6 == A.UNKNOWN) {
                return;
            }
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(o.c(applicationContext, a6));
            if (appWidgetIds != null && appWidgetIds.length > 0) {
                C(applicationContext, appWidgetManager, a6, appWidgetIds);
            }
        }
    }

    public static void v(Context context, AppWidgetManager appWidgetManager, A a6, int[] iArr) {
        if (context == null || appWidgetManager == null || iArr == null || iArr.length == 0 || g.x(context)) {
            return;
        }
        C(context, appWidgetManager, a6, iArr);
    }

    public void A(boolean z5) {
        this.f14499g = z5;
    }

    public void B(boolean z5) {
        this.f14495c = z5;
    }

    public void D() {
        c cVar = this.f14502j;
        if (cVar == null || cVar.g()) {
            return;
        }
        this.f14502j.dispose();
    }

    public void E(Context context, AppWidgetManager appWidgetManager) {
        int[] appWidgetIds = this.f14501i.getAppWidgetIds(this.f14497e);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 : appWidgetIds) {
            if (f(this.f14501i.getAppWidgetOptions(i5))) {
                arrayList2.add(Integer.valueOf(i5));
            } else {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        if (!arrayList2.isEmpty()) {
            A(true);
            F(context, appWidgetManager, C2.c.c(arrayList2));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        A(false);
        F(context, appWidgetManager, C2.c.c(arrayList));
    }

    public abstract RemoteViews G(Context context, AppWidgetManager appWidgetManager);

    protected void c(Context context, RemoteViews remoteViews) {
        Intent intent = new Intent();
        intent.setClass(context, UsageDirectActivity.class);
        intent.setFlags(335544320);
        PendingIntent activity = PendingIntent.getActivity(context, j().ordinal(), intent, 201326592);
        remoteViews.setOnClickPendingIntent(R.id.widget_container, activity);
        remoteViews.setOnClickPendingIntent(R.id.error_layer, activity);
        remoteViews.setOnClickPendingIntent(R.id.empty_layer, activity);
        remoteViews.setOnClickPendingIntent(R.id.data_layer, activity);
    }

    public AppWidgetManager g() {
        return this.f14501i;
    }

    protected Context h() {
        return this.f14498f;
    }

    public abstract RemoteViews i(Context context);

    public A j() {
        return this.f14493a;
    }

    protected void k(RemoteViews remoteViews) {
        boolean zM = m();
        boolean zO = o();
        boolean zL = l();
        C0702g.b("DigitalAppWidgetBase", "handleErrorLayerDisplay: hasPermission = " + zM + " isSupport = " + zO + " isDigitalWellbeingEnable = " + zL + " mDataPending = " + this.f14500h);
        if (this.f14500h) {
            remoteViews.setViewVisibility(R.id.error_layer, 0);
            remoteViews.setViewVisibility(R.id.empty_layer, 8);
            remoteViews.setViewVisibility(R.id.data_layer, 8);
            remoteViews.setTextViewText(R.id.error_message, this.f14498f.getString(R.string.us_loading));
            return;
        }
        if (zM && o() && zL) {
            remoteViews.setViewVisibility(R.id.error_layer, 8);
            remoteViews.setViewVisibility(R.id.empty_layer, 8);
            remoteViews.setViewVisibility(R.id.data_layer, 0);
            return;
        }
        if (!zL) {
            remoteViews.setViewVisibility(R.id.error_layer, 8);
            remoteViews.setViewVisibility(R.id.empty_layer, 0);
            remoteViews.setViewVisibility(R.id.data_layer, 8);
            remoteViews.setTextViewText(R.id.empty_text, ((this instanceof q) || (this instanceof s)) ? this.f14498f.getString(R.string.us_enable_digital_wellbeing_n) : this.f14498f.getString(R.string.us_enable_digital_wellbeing));
            return;
        }
        remoteViews.setViewVisibility(R.id.error_layer, 0);
        remoteViews.setViewVisibility(R.id.empty_layer, 8);
        remoteViews.setViewVisibility(R.id.data_layer, 8);
        if (!zM) {
            remoteViews.setTextViewText(R.id.error_message, this.f14498f.getString(R.string.us_widget_need_allow_permission));
        } else {
            if (zO) {
                return;
            }
            remoteViews.setTextViewText(R.id.error_message, this.f14498f.getString(R.string.us_not_support_widget));
        }
    }

    public boolean l() {
        return this.f14496d;
    }

    public boolean m() {
        return this.f14494b;
    }

    public boolean n() {
        return this.f14499g;
    }

    public boolean o() {
        return this.f14495c;
    }

    protected boolean r(Bundle bundle) {
        boolean z5 = bundle.getBoolean("HAS_PERMISSIONS", true);
        boolean z6 = bundle.getBoolean("SUPPORT", true);
        boolean z7 = bundle.getBoolean("ENABLE", true);
        C0702g.b("DigitalAppWidgetBase", "onBindData() called with: hasPermission = " + z5 + ", support = " + z6 + ", enable = " + z7);
        StringBuilder sb = new StringBuilder();
        sb.append("onBindData() data = ");
        sb.append(bundle);
        C0702g.b("DigitalAppWidgetBase", sb.toString());
        z(z5);
        B(z6);
        y(z7);
        return z5 && z6 && z7;
    }

    public void s(Configuration configuration) {
        C0702g.b("DigitalAppWidgetBase", "onConfigurationChanged() called with: newConfig = [" + configuration + "]");
    }

    protected void t(Bundle bundle) {
        boolean z5 = false;
        if (bundle.getBoolean("SKIP_UPDATE", false)) {
            int[] appWidgetIds = this.f14501i.getAppWidgetIds(this.f14497e);
            if (g.x(this.f14498f)) {
                e(this.f14498f, this.f14501i, this.f14493a, appWidgetIds);
                return;
            } else {
                v(this.f14498f, this.f14501i, this.f14493a, appWidgetIds);
                return;
            }
        }
        if (bundle.containsKey("HAS_PERMISSIONS") && !bundle.getBoolean("HAS_PERMISSIONS") && !bundle.getBoolean("DATA_ERROR", false)) {
            C(this.f14498f, this.f14501i, this.f14493a, this.f14501i.getAppWidgetIds(this.f14497e));
            return;
        }
        if (!bundle.getBoolean("DATA_ERROR", false)) {
            this.f14500h = false;
            r(bundle);
            E(this.f14498f, this.f14501i);
            return;
        }
        z(bundle.containsKey("HAS_PERMISSIONS") ? bundle.getBoolean("HAS_PERMISSIONS") : g.x(this.f14498f));
        if (bundle.containsKey("SUPPORT")) {
            B(bundle.getBoolean("SUPPORT", true));
        }
        if (bundle.containsKey("ENABLE")) {
            y(bundle.getBoolean("ENABLE", true));
        }
        if (m() && o() && l()) {
            z5 = true;
        }
        this.f14500h = z5;
        E(this.f14498f, this.f14501i);
    }

    public String toString() {
        return "DigitalAppWidgetBase{mWidgetType=" + this.f14493a + " mSmallGrid=" + this.f14499g + '}';
    }

    public void w(f<Bundle> fVar) {
        Q1.c.f(this.f14502j).c(new V1.l());
        this.f14502j = fVar.T(new D3.c() { // from class: V1.m
            @Override // D3.c
            public final void accept(Object obj) {
                this.f5489a.p((Bundle) obj);
            }
        }, new D3.c() { // from class: V1.n
            @Override // D3.c
            public final void accept(Object obj) {
                this.f5490a.q((Throwable) obj);
            }
        });
    }

    protected void x(Context context) {
        this.f14498f = context;
    }

    public void y(boolean z5) {
        this.f14496d = z5;
    }

    public void z(boolean z5) {
        this.f14494b = z5;
    }
}
