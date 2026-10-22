package com.baidu.platform.comapi.map.c0.e;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.c0.a;
import com.baidu.platform.comapi.map.c0.d;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public a.C0046a f9093a;

    /* renamed from: b, reason: collision with root package name */
    public a.C0046a f9094b;

    /* renamed from: c, reason: collision with root package name */
    public a.C0046a f9095c;

    /* renamed from: d, reason: collision with root package name */
    public MotionEvent f9096d;

    /* renamed from: f, reason: collision with root package name */
    private a f9098f;

    /* renamed from: e, reason: collision with root package name */
    public d f9097e = new d();

    /* renamed from: g, reason: collision with root package name */
    private boolean f9099g = false;

    public interface a {
        boolean a(b bVar);

        boolean a(b bVar, MotionEvent motionEvent);

        boolean b(b bVar);
    }

    public b(a aVar) {
        this.f9098f = aVar;
    }

    private void a() {
        this.f9097e.b();
        this.f9093a = null;
        this.f9094b = null;
        this.f9095c = null;
        this.f9099g = true;
        this.f9098f.b(this);
    }

    private void c(MotionEvent motionEvent) {
        a.C0046a c0046aA = a.C0046a.a(motionEvent);
        a.C0046a c0046a = this.f9095c;
        if (c0046a == null) {
            c0046a = c0046aA;
        }
        this.f9094b = c0046a;
        this.f9095c = c0046aA;
        if (this.f9093a == null) {
            this.f9093a = c0046aA;
        }
    }

    public void b(MotionEvent motionEvent) {
        this.f9096d = motionEvent;
        int action = motionEvent.getAction();
        if (action == 2) {
            if (this.f9099g) {
                a(motionEvent);
                return;
            } else {
                if (motionEvent.getPointerCount() == 2) {
                    a();
                    return;
                }
                return;
            }
        }
        if (action != 6) {
            if (action == 261) {
                if (this.f9099g) {
                    return;
                }
                a();
                return;
            } else if (action != 262) {
                return;
            }
        }
        if (this.f9099g) {
            b();
        }
    }

    private void a(MotionEvent motionEvent) {
        this.f9097e.a(motionEvent);
        Pair<a.d, a.d> pairC = this.f9097e.c();
        if (motionEvent.getPointerCount() == 2) {
            if (Math.abs(((a.d) pairC.first).f9064a) > 0.0d || Math.abs(((a.d) pairC.first).f9065b) > 0.0d || Math.abs(((a.d) pairC.second).f9064a) > 0.0d || Math.abs(((a.d) pairC.second).f9065b) > 0.0d) {
                c(motionEvent);
                this.f9098f.a(this, motionEvent);
            }
        }
    }

    private void b() {
        this.f9097e.a();
        this.f9099g = false;
        this.f9098f.a(this);
    }
}
