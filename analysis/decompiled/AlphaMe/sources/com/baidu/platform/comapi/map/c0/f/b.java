package com.baidu.platform.comapi.map.c0.f;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.c0.a;
import com.baidu.platform.comapi.map.c0.e.b;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class b implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<a.C0046a> f9101a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.d f9102b;

    /* renamed from: c, reason: collision with root package name */
    private MapController f9103c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9104d;

    /* renamed from: e, reason: collision with root package name */
    private a f9105e;

    /* renamed from: f, reason: collision with root package name */
    private int f9106f;

    public b(MapController mapController) {
        com.baidu.platform.comapi.map.c0.d dVar = new com.baidu.platform.comapi.map.c0.d();
        this.f9102b = dVar;
        this.f9104d = false;
        this.f9103c = mapController;
        this.f9106f = dVar.f9087c / 3;
    }

    private void c(com.baidu.platform.comapi.map.c0.e.b bVar) {
        if (this.f9103c.isOverlookGestureEnable()) {
            this.f9105e.a(bVar, (Pair<a.d, a.d>) null);
            c cVar = new c(this.f9103c);
            this.f9105e = cVar;
            cVar.a(bVar);
        }
    }

    private void d(com.baidu.platform.comapi.map.c0.e.b bVar) {
        if (this.f9101a.size() < 5) {
            this.f9101a.addLast(bVar.f9095c);
            this.f9102b.a(bVar.f9096d);
        } else if (!this.f9104d && this.f9101a.size() == 5 && a()) {
            c(bVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.c0.e.b.a
    public boolean a(com.baidu.platform.comapi.map.c0.e.b bVar, MotionEvent motionEvent) {
        d(bVar);
        if (this.f9101a.size() == 1) {
            this.f9105e.a(bVar);
        }
        this.f9105e.a(bVar, motionEvent);
        return true;
    }

    @Override // com.baidu.platform.comapi.map.c0.e.b.a
    public boolean b(com.baidu.platform.comapi.map.c0.e.b bVar) {
        this.f9101a.clear();
        this.f9102b.b();
        this.f9105e = new d(this.f9103c);
        this.f9104d = false;
        return true;
    }

    @Override // com.baidu.platform.comapi.map.c0.e.b.a
    public boolean a(com.baidu.platform.comapi.map.c0.e.b bVar) {
        Pair<a.d, a.d> pairC = this.f9102b.c();
        this.f9102b.a();
        this.f9105e.a(bVar, pairC);
        return true;
    }

    private boolean a() {
        int iA;
        double dA;
        this.f9104d = true;
        Iterator<a.C0046a> it = this.f9101a.iterator();
        while (it.hasNext()) {
            double dA2 = a.d.a(com.baidu.platform.comapi.map.c0.a.f9054a.c(), it.next().c());
            if (Math.abs(dA2) > 45.0d && Math.abs(dA2) < 135.0d) {
                return false;
            }
        }
        Pair<a.d, a.d> pairC = this.f9102b.c();
        a.d dVar = (a.d) pairC.first;
        a.d dVar2 = (a.d) pairC.second;
        boolean z4 = Math.abs(dVar.f9065b) > ((double) this.f9106f) && Math.abs(dVar2.f9065b) > ((double) this.f9106f);
        a.C0046a first = this.f9101a.getFirst();
        a.C0046a last = this.f9101a.getLast();
        a.C0046a c0046a = new a.C0046a(last.f9057a, first.f9057a);
        a.C0046a c0046a2 = new a.C0046a(last.f9058b, first.f9058b);
        if (dVar.f9065b > 0.0d && dVar2.f9065b > 0.0d) {
            a.d dVarC = c0046a.c();
            a.C0046a c0046a3 = com.baidu.platform.comapi.map.c0.a.f9056c;
            iA = (int) a.d.a(dVarC, c0046a3.c());
            dA = a.d.a(c0046a2.c(), c0046a3.c());
        } else {
            a.d dVarC2 = c0046a.c();
            a.C0046a c0046a4 = com.baidu.platform.comapi.map.c0.a.f9055b;
            iA = (int) a.d.a(dVarC2, c0046a4.c());
            dA = a.d.a(c0046a2.c(), c0046a4.c());
        }
        return z4 && (Math.abs(iA) < 40 && Math.abs((int) dA) < 40);
    }
}
