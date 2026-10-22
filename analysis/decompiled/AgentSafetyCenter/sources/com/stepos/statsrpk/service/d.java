package com.stepos.statsrpk.service;

import a2.i;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.Window;
import androidx.room.b0;
import com.google.android.material.behavior.SwipeDismissBehavior;
import g5.u;
import h5.d0;
import ie.r;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import kc.q0;
import kc.w;
import l5.k;
import m.o0;
import p5.p;
import pc.g;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.l;
import stepos.support.v7.widget.q;
import td.h;
import te.j;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2884c;

    /* renamed from: f, reason: collision with root package name */
    public Object f2885f;

    /* renamed from: g, reason: collision with root package name */
    public Object f2886g;

    public d(g gVar, Runnable runnable) {
        this.f2884c = 10;
        this.f2886g = gVar;
        this.f2885f = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar;
        switch (this.f2884c) {
            case 0:
                e eVar = (e) this.f2886g;
                String str = (String) this.f2885f;
                ua.c.a("a", "environmentChanged. changeName: ".concat(str));
                ArrayList arrayListH = eVar.f2888b.h();
                int i = 0;
                if ("CHANGE_NAME_NETWORKCONNECT".equals(str)) {
                    int size = arrayListH.size();
                    while (i < size) {
                        Object obj = arrayListH.get(i);
                        i++;
                        eVar.c((String) obj);
                    }
                    return;
                }
                if ("CHANGE_NAME_POWER".equals(str)) {
                    int size2 = arrayListH.size();
                    while (i < size2) {
                        Object obj2 = arrayListH.get(i);
                        i++;
                        eVar.c((String) obj2);
                    }
                    return;
                }
                return;
            case 1:
                l7.a aVar = (l7.a) this.f2885f;
                boolean zIsCancelled = aVar.isCancelled();
                kc.g gVar = (kc.g) this.f2886g;
                if (zIsCancelled) {
                    gVar.f(null);
                    return;
                }
                boolean z10 = false;
                while (true) {
                    try {
                        try {
                            Object obj3 = aVar.get();
                            if (z10) {
                                Thread.currentThread().interrupt();
                            }
                            gVar.resumeWith(obj3);
                            return;
                        } catch (InterruptedException unused) {
                            z10 = true;
                        } catch (Throwable th) {
                            if (z10) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    } catch (ExecutionException e10) {
                        Throwable cause = e10.getCause();
                        cause.getClass();
                        gVar.resumeWith(id.c.l(cause));
                        return;
                    }
                }
            case 2:
                u uVarD = u.d();
                String str2 = i5.a.f5777e;
                StringBuilder sb2 = new StringBuilder("Scheduling work ");
                p pVar2 = (p) this.f2885f;
                sb2.append(pVar2.f9764a);
                uVarD.a(str2, sb2.toString());
                ((i5.a) this.f2886g).f5778a.d(pVar2);
                return;
            case 3:
                h.y((r) this.f2885f).resumeWith(id.c.l((Exception) this.f2886g));
                return;
            case 4:
                try {
                    Window window = ((Activity) this.f2885f).getWindow();
                    if (window != null) {
                        window.setSoftInputMode(((Integer) this.f2886g).intValue());
                        return;
                    }
                    return;
                } catch (Exception unused2) {
                    return;
                }
            case 5:
                i iVar = (i) this.f2885f;
                Typeface typeface = (Typeface) this.f2886g;
                o0 o0Var = (o0) iVar.f49f;
                if (o0Var != null) {
                    o0Var.c(typeface);
                    return;
                }
                return;
            case 6:
                ((k3.e) this.f2885f).accept(this.f2886g);
                return;
            case 7:
                ((kc.g) this.f2886g).B((q0) this.f2885f);
                return;
            case 8:
                ((kc.g) this.f2885f).B((lc.d) this.f2886g);
                return;
            case 9:
                h5.d dVar = ((o5.a) this.f2886g).f9224c.f5375f;
                String str3 = (String) this.f2885f;
                synchronized (dVar.f5324j) {
                    try {
                        d0 d0VarC = dVar.c(str3);
                        pVar = d0VarC != null ? d0VarC.f5325a : null;
                    } finally {
                    }
                }
                if (pVar == null || !pVar.b()) {
                    return;
                }
                synchronized (((o5.a) this.f2886g).f9226g) {
                    ((o5.a) this.f2886g).f9228j.put(h.r(pVar), pVar);
                    o5.a aVar2 = (o5.a) this.f2886g;
                    ((o5.a) this.f2886g).f9229k.put(h.r(pVar), k.a(aVar2.f9230l, pVar, (kc.p) aVar2.f9225f.f9731f, aVar2));
                }
                return;
            case 10:
                g gVar2 = (g) this.f2886g;
                kc.p pVar3 = gVar2.f9961g;
                int i3 = 0;
                while (true) {
                    try {
                        ((Runnable) this.f2885f).run();
                    } catch (Throwable th2) {
                        w.p(nb.h.f8811c, th2);
                    }
                    Runnable runnableQ = gVar2.Q();
                    if (runnableQ == null) {
                        return;
                    }
                    this.f2885f = runnableQ;
                    i3++;
                    if (i3 >= 16 && pVar3.O(gVar2)) {
                        pVar3.M(gVar2, this);
                        return;
                    }
                }
                break;
            case 11:
                try {
                    ((Runnable) this.f2886g).run();
                    synchronized (((b0) this.f2885f).f1509f) {
                        ((b0) this.f2885f).a();
                    }
                    return;
                } catch (Throwable th3) {
                    synchronized (((b0) this.f2885f).f1509f) {
                        ((b0) this.f2885f).a();
                        throw th3;
                    }
                }
            case 12:
                u3.b bVar = ((SwipeDismissBehavior) this.f2886g).f2403a;
                if (bVar == null || !bVar.f()) {
                    return;
                }
                ((View) this.f2885f).postOnAnimation(this);
                return;
            case 13:
                ActionBarCoordinatorLayout.L((ActionBarCoordinatorLayout) this.f2886g, (StepOSRecyclerView) this.f2885f);
                return;
            case 14:
                View view = (View) this.f2885f;
                if (view == null || view.getWindowToken() == null || !((q) this.f2886g).F.i()) {
                    return;
                }
                view.setAlpha(0.2f);
                return;
            default:
                l lVar = (l) this.f2885f;
                q qVar = (q) this.f2886g;
                te.l lVar2 = qVar.f12803g;
                j jVar = lVar2.f13346d;
                if (jVar != null) {
                    jVar.d(lVar2);
                }
                View view2 = (View) qVar.f12807l;
                if (view2 != null && view2.getWindowToken() != null && lVar.j()) {
                    qVar.E = lVar;
                    qVar.f12808m.setAlpha(0.2f);
                }
                qVar.G = null;
                return;
        }
    }

    public /* synthetic */ d(int i) {
        this.f2884c = i;
    }
}
