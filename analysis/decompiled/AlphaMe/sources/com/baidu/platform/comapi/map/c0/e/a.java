package com.baidu.platform.comapi.map.c0.e;

import android.graphics.Point;
import android.view.MotionEvent;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.c0.a;
import com.baidu.platform.comapi.map.v;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private long f9088a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f9089b = false;

    /* renamed from: c, reason: collision with root package name */
    private a.C0046a f9090c;

    /* renamed from: d, reason: collision with root package name */
    private MapController f9091d;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC0047a f9092e;

    /* renamed from: com.baidu.platform.comapi.map.c0.e.a$a, reason: collision with other inner class name */
    public interface InterfaceC0047a {
        boolean a(a aVar);
    }

    public a(InterfaceC0047a interfaceC0047a, MapController mapController) {
        this.f9092e = interfaceC0047a;
        this.f9091d = mapController;
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2 || this.f9090c == null) {
            return;
        }
        a.C0046a c0046aA = a.C0046a.a(motionEvent);
        a.C0046a c0046a = new a.C0046a(this.f9090c.f9057a, c0046aA.f9057a);
        a.C0046a c0046a2 = new a.C0046a(this.f9090c.f9058b, c0046aA.f9058b);
        double dAbs = Math.abs(c0046a.b());
        boolean z4 = dAbs < 20.0d && Math.abs(c0046a2.b()) < 20.0d;
        boolean z5 = System.currentTimeMillis() - this.f9088a < 200;
        if (this.f9091d != null) {
            float x4 = motionEvent.getX(1) - motionEvent.getX(0);
            float y4 = motionEvent.getY(1) - motionEvent.getY();
            Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            Point point2 = new Point((int) (motionEvent.getRawX() + x4), (int) (motionEvent.getRawY() + y4));
            this.f9091d.getMapView();
            if (z4 && z5 && this.f9089b) {
                List<v> listeners = this.f9091d.getListeners();
                s mapStatusInner = this.f9091d.getMapStatusInner();
                if (listeners != null) {
                    for (int i4 = 0; i4 < listeners.size(); i4++) {
                        v vVar = listeners.get(i4);
                        if (vVar != null && vVar.a(point, point2, mapStatusInner)) {
                            return;
                        }
                    }
                }
                this.f9092e.a(this);
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return;
        }
        this.f9090c = a.C0046a.a(motionEvent);
        this.f9089b = true;
    }

    public void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f9088a = System.currentTimeMillis();
            return;
        }
        if (action != 5) {
            if (action != 6) {
                if (action != 261) {
                    if (action != 262) {
                        return;
                    }
                }
            }
            a(motionEvent);
            a();
            return;
        }
        c(motionEvent);
    }

    private void a() {
        this.f9089b = false;
        this.f9090c = null;
        this.f9088a = 0L;
    }
}
