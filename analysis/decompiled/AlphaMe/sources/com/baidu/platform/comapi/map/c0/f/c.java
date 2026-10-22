package com.baidu.platform.comapi.map.c0.f;

import android.graphics.Point;
import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.c0.a;
import com.baidu.platform.comapi.map.v;
import java.util.List;

/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name */
    private boolean f9107b;

    /* renamed from: c, reason: collision with root package name */
    private long f9108c;

    /* renamed from: d, reason: collision with root package name */
    private MapController f9109d;

    public c(MapController mapController) {
        super(mapController);
        this.f9107b = true;
        this.f9109d = mapController;
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b bVar, MotionEvent motionEvent) {
        a.C0046a c0046a = bVar.f9094b;
        a.C0046a c0046a2 = bVar.f9095c;
        MapStatus mapStatus = this.f9109d.getMapStatus();
        double d4 = c0046a2.f9057a.f9060b - c0046a.f9057a.f9060b;
        double d5 = c0046a2.f9058b.f9060b - c0046a.f9058b.f9060b;
        double d6 = d4 * d5;
        if (d6 > 0.0d) {
            a(d4, mapStatus);
        } else if (d6 == 0.0d) {
            if (d4 != 0.0d) {
                a(d4, mapStatus);
            } else if (d5 != 0.0d) {
                a(d5, mapStatus);
            }
        } else if (Math.abs(d4) > Math.abs(d5)) {
            a(d4, mapStatus);
        } else {
            a(d5, mapStatus);
        }
        float x4 = motionEvent.getX(1) - motionEvent.getX(0);
        float y4 = motionEvent.getY(1) - motionEvent.getY(0);
        Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        Point point2 = new Point((int) (motionEvent.getRawX() + x4), (int) (motionEvent.getRawY() + y4));
        List<v> listeners = this.f9109d.getListeners();
        if (listeners != null) {
            s mapStatusInner = this.f9109d.getMapStatusInner();
            for (int i4 = 0; i4 < listeners.size(); i4++) {
                v vVar = listeners.get(i4);
                if (vVar != null && vVar.b(point, point2, mapStatusInner)) {
                    return;
                }
            }
        }
        this.f9109d.setMapStatus(mapStatus);
        if (this.f9107b) {
            this.f9107b = false;
            this.f9109d.getGestureMonitor().b();
        }
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b bVar, Pair<a.d, a.d> pair) {
        MapStatus mapStatus = this.f9109d.getMapStatus();
        if (mapStatus.bOverlookSpringback) {
            if (mapStatus.overlooking > 0.0d) {
                mapStatus.overlooking = 0.0d;
            } else {
                mapStatus.overlooking = mapStatus.minOverlooking;
            }
            this.f9109d.setMapStatusWithAnimation(mapStatus, 200);
        }
    }

    private void a(double d4, MapStatus mapStatus) {
        if (this.f9108c == 0) {
            this.f9108c = System.currentTimeMillis();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f9108c = jCurrentTimeMillis;
        if (jCurrentTimeMillis - jCurrentTimeMillis > 50 || Math.abs(d4) < 4.0d) {
            return;
        }
        if (d4 > 0.0d) {
            mapStatus.overlooking -= 4.0d;
        } else {
            mapStatus.overlooking += 2.0d;
        }
    }
}
