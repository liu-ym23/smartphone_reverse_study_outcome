package com.stepos.agentsafetycenter.auth;

import a4.t;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.f0;
import androidx.activity.h0;
import androidx.activity.p;
import androidx.activity.r;
import androidx.fragment.app.s;
import b.j;
import com.stepos.agentsafetycenter.MainActivity;
import d.c;
import e.b;
import e9.m;
import id.k;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import k0.k1;
import k0.z;
import o8.f;
import o8.g;
import o8.h;
import o8.i;
import o8.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class LaunchAuthActivity extends p {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f2495l = 0;

    /* renamed from: c, reason: collision with root package name */
    public c f2496c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2497f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2499h;

    /* renamed from: j, reason: collision with root package name */
    public final t f2500j;

    /* renamed from: k, reason: collision with root package name */
    public final f0 f2501k;

    /* renamed from: g, reason: collision with root package name */
    public final k1 f2498g = z.v(h.f9314a);
    public boolean i = true;

    public LaunchAuthActivity() {
        t tVar = new t(19);
        tVar.f200f = this;
        VarHandle.storeStoreFence();
        this.f2500j = tVar;
        this.f2501k = new f0(this, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(boolean z10) {
        h hVar;
        List listQ = k.Q(this);
        if (listQ.isEmpty()) {
            hVar = h.f9314a;
        } else {
            f fVar = new f();
            fVar.f9312a = listQ;
            VarHandle.storeStoreFence();
            hVar = fVar;
        }
        this.f2498g.setValue(hVar);
        if (z10 && (hVar instanceof h)) {
            if (!this.i) {
                g();
                return;
            }
            View decorView = getWindow().getDecorView();
            t tVar = this.f2500j;
            decorView.removeCallbacks(tVar);
            getWindow().getDecorView().post(tVar);
        }
    }

    public final void d(Bundle bundle) {
        super.onCreate(bundle);
        b sVar = new s(2);
        b.b bVar = new b.b(6);
        bVar.f1685f = this;
        VarHandle.storeStoreFence();
        this.f2496c = registerForActivityResult(sVar, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        g gVar;
        this.f2499h = false;
        if (this.f2497f) {
            return;
        }
        n.b();
        List listQ = k.Q(this);
        if (listQ.isEmpty()) {
            finish();
            return;
        }
        if (listQ.isEmpty()) {
            gVar = g.f9313a;
        } else {
            f fVar = new f();
            fVar.f9312a = listQ;
            VarHandle.storeStoreFence();
            gVar = fVar;
        }
        this.f2498g.setValue(gVar);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [xb.a, yb.i] */
    public void f() {
        List listQ = k.Q(this);
        if (!listQ.isEmpty()) {
            this.f2499h = false;
            n.b();
            k1 k1Var = this.f2498g;
            f fVar = new f();
            fVar.f9312a = listQ;
            k1Var.setValue(fVar);
            return;
        }
        f0 f0Var = this.f2501k;
        f0Var.f699a = false;
        ?? r02 = f0Var.f701c;
        if (r02 != 0) {
            r02.invoke();
        }
        Stack stack = n.f9321a;
        n.f9325e = false;
        n.c(true);
        n.f9326f = true;
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setAction(getIntent().getAction());
        intent.setData(getIntent().getData());
        Set<String> categories = getIntent().getCategories();
        if (categories != null) {
            Iterator<T> it = categories.iterator();
            while (it.hasNext()) {
                intent.addCategory((String) it.next());
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.addFlags(335544320);
        finish();
        startActivity(intent);
        if (this instanceof ResumeAuthActivity) {
            overridePendingTransition(0, 0);
        }
    }

    public final void g() {
        if (!p5.f.C(this)) {
            Stack stack = n.f9321a;
            n.f9325e = false;
            n.c(true);
            n.f9326f = true;
            if (this.f2497f) {
                return;
            }
            this.f2497f = true;
            f();
            return;
        }
        if (this.f2497f || this.f2499h) {
            return;
        }
        this.f2499h = true;
        Intent intent = new Intent("stepos.intent.action.CONFIRM_PASSWORD");
        intent.putExtra("password_from", 8);
        intent.setPackage("com.android.settings");
        if (intent.resolveActivity(getPackageManager()) == null) {
            e();
            return;
        }
        c cVar = this.f2496c;
        if (cVar != null) {
            cVar.a(intent);
        }
    }

    @Override // androidx.activity.p, d3.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        d(bundle);
        List listQ = k.Q(this);
        if (bundle == null) {
            n.b();
        }
        Stack stack = n.f9321a;
        if (n.f9325e) {
            n.b();
        }
        n.a();
        if (!listQ.isEmpty()) {
            n.b();
        }
        getOnBackPressedDispatcher().a(this, this.f2501k);
        h0 h0Var = new h0();
        VarHandle.storeStoreFence();
        h0 h0Var2 = new h0();
        VarHandle.storeStoreFence();
        r.a(this, h0Var, h0Var2);
        m mVar = new m(7);
        mVar.f3688f = this;
        VarHandle.storeStoreFence();
        j.a(this, new s0.c(600380345, true, mVar));
        c(bundle == null);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        getWindow().getDecorView().removeCallbacks(this.f2500j);
        super.onDestroy();
    }

    @Override // androidx.activity.p, android.app.Activity
    public final void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        setIntent(intent);
        if (yb.k.a(intent.getAction(), "stepos.intent.action.AGENT_SAFETY_CENTER_LAUNCHER")) {
            List listQ = k.Q(this);
            n.b();
            if (n.f9325e) {
                n.b();
            }
            n.a();
            if (!listQ.isEmpty()) {
                n.b();
            }
            c(true);
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        i iVar;
        super.onResume();
        if (this.f2497f) {
            return;
        }
        List listQ = k.Q(this);
        k1 k1Var = this.f2498g;
        i iVar2 = (i) k1Var.getValue();
        iVar2.getClass();
        boolean z10 = iVar2 instanceof f;
        h hVar = h.f9314a;
        if (z10) {
            iVar = hVar;
            if (!listQ.isEmpty()) {
                if (listQ.equals(((f) iVar2).f9312a)) {
                    iVar = null;
                } else {
                    f fVar = new f();
                    fVar.f9312a = listQ;
                    iVar = fVar;
                }
            }
        } else {
            if (iVar2.equals(g.f9313a)) {
                if (!listQ.isEmpty()) {
                    f fVar2 = new f();
                    fVar2.f9312a = listQ;
                    iVar = fVar2;
                }
            } else if (!iVar2.equals(hVar)) {
                g5.f.a();
                return;
            }
            iVar = null;
        }
        if (iVar == null) {
            iVar = iVar2;
        }
        k1Var.setValue(iVar);
        if ((iVar2 instanceof h) || !(iVar instanceof h)) {
            return;
        }
        g();
    }
}
