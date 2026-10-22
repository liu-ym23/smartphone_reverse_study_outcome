package com.stepos.agentsafetycenter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.h0;
import androidx.activity.p;
import androidx.activity.r;
import b.j;
import e9.h;
import h5.t;
import java.lang.invoke.VarHandle;
import k0.c1;
import k0.k1;
import k0.z;
import k8.a0;
import k8.d0;
import k8.g;
import k8.x;
import kb.l;
import lb.i;
import o8.n;
import p5.f;
import s0.c;
import xb.a;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class MainActivity extends p {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f2491h = 0;

    /* renamed from: c, reason: collision with root package name */
    public final k1 f2492c = z.v(null);

    /* renamed from: f, reason: collision with root package name */
    public final k1 f2493f;

    /* renamed from: g, reason: collision with root package name */
    public final k1 f2494g;

    public MainActivity() {
        Boolean bool = Boolean.FALSE;
        this.f2493f = z.v(bool);
        this.f2494g = z.v(bool);
    }

    public static final d0 e(MainActivity mainActivity, a aVar, d0 d0Var) {
        if (!((Boolean) mainActivity.f2493f.getValue()).booleanValue()) {
            return x.f7359a;
        }
        aVar.invoke();
        return d0Var;
    }

    public static final void f(c1 c1Var, boolean z10) {
        c1Var.setValue(Boolean.valueOf(z10));
    }

    public final void c() {
        h0 h0Var = new h0();
        VarHandle.storeStoreFence();
        h0 h0Var2 = new h0();
        VarHandle.storeStoreFence();
        r.a(this, h0Var, h0Var2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final void d(Intent intent) {
        Object obj = null;
        String action = intent != null ? intent.getAction() : null;
        x xVar = x.f7359a;
        k1 k1Var = this.f2492c;
        k1 k1Var2 = this.f2493f;
        if (action != null && action.hashCode() == 458853595 && action.equals("stepos.intent.action.AGENT_SAFETY_CENTER_LAUNCHER")) {
            k1Var2.setValue(Boolean.FALSE);
            k1Var.setValue(xVar);
            return;
        }
        i iVar = new i();
        iVar.add("stepos.intent.action.AGENT_PERMISSION_MANAGER");
        iVar.add("stepos.intent.action.AGENT_SCREEN_PERCEPTION");
        k1Var2.setValue(Boolean.valueOf(l.s0(t.n(iVar), intent != null ? intent.getAction() : null)));
        String action2 = intent != null ? intent.getAction() : null;
        if (action2 != null) {
            switch (action2.hashCode()) {
                case -1564245094:
                    if (action2.equals("stepos.intent.action.AGENT_SCREEN_PERCEPTION")) {
                        obj = a0.f7278a;
                        break;
                    }
                    break;
                case -1119458277:
                    if (action2.equals("stepos.intent.action.AGENT_PERMISSION_MANAGER")) {
                        obj = k8.z.f7361a;
                        break;
                    }
                    break;
                case 458853595:
                    if (action2.equals("stepos.intent.action.AGENT_SAFETY_CENTER_LAUNCHER")) {
                        obj = xVar;
                        break;
                    }
                    break;
                case 788727029:
                    action2.equals("stepos.intent.action.AGENT_OPERATE_PHONE");
                    break;
            }
        }
        if (obj != null) {
            k1Var.setValue(obj);
        }
    }

    @Override // androidx.activity.p, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        configuration.getClass();
        super.onConfigurationChanged(configuration);
        c();
    }

    @Override // androidx.activity.p, d3.c, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d(getIntent());
        if (d3.a.a(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 1001);
        }
        c();
        g gVar = new g(0);
        gVar.f7302f = this;
        VarHandle.storeStoreFence();
        j.a(this, new c(-1957330425, true, gVar));
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            Intent intent = getIntent();
            if (k.a(intent != null ? intent.getAction() : null, "stepos.intent.action.AGENT_OPERATE_PHONE")) {
                h hVarL = h.f3655f.l(this);
                if (!((e9.z) hVarL.f3660d.getValue()).f3740a) {
                    Log.d("OperatePhoneRepo", "notifyHostActivityDismissed skipped: master switch off");
                    return;
                }
                Log.i("OperatePhoneRepo", "notifyHostActivityDismissed scheduling (master switch on)");
                a4.t tVar = new a4.t(10);
                tVar.f200f = hVarL;
                VarHandle.storeStoreFence();
                new Thread(tVar).start();
            }
        }
    }

    @Override // androidx.activity.p, android.app.Activity
    public final void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        setIntent(intent);
        d(intent);
    }

    @Override // android.app.Activity
    public final void onPause() {
        if (f.C(this)) {
            this.f2494g.setValue(Boolean.TRUE);
            ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
            View childAt = viewGroup != null ? viewGroup.getChildAt(0) : null;
            if (childAt != null) {
                childAt.setVisibility(4);
            }
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onResume() {
        View childAt;
        super.onResume();
        boolean zA = n.a();
        k1 k1Var = this.f2494g;
        if (zA) {
            k1Var.setValue(Boolean.FALSE);
            ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
            childAt = viewGroup != null ? viewGroup.getChildAt(0) : null;
            if (childAt != null) {
                childAt.setVisibility(0);
                return;
            }
            return;
        }
        if (f.C(this)) {
            k1Var.setValue(Boolean.TRUE);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(android.R.id.content);
            childAt = viewGroup2 != null ? viewGroup2.getChildAt(0) : null;
            if (childAt != null) {
                childAt.setVisibility(4);
                return;
            }
            return;
        }
        k1Var.setValue(Boolean.FALSE);
        ViewGroup viewGroup3 = (ViewGroup) findViewById(android.R.id.content);
        childAt = viewGroup3 != null ? viewGroup3.getChildAt(0) : null;
        if (childAt != null) {
            childAt.setVisibility(0);
        }
    }
}
