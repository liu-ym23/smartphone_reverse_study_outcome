package com.baidu.platform.comapi.map.c0;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.c0.e.a;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private MapController f9066a;

    /* renamed from: b, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.e.b f9067b;

    /* renamed from: c, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.e.a f9068c;

    /* renamed from: d, reason: collision with root package name */
    a.InterfaceC0047a f9069d = new a();

    public class a implements a.InterfaceC0047a {
        public a() {
        }

        @Override // com.baidu.platform.comapi.map.c0.e.a.InterfaceC0047a
        public boolean a(com.baidu.platform.comapi.map.c0.e.a aVar) {
            if (!b.this.f9066a.isTwoTouchClickZoomEnabled()) {
                return false;
            }
            b.this.f9066a.setActingTwoClickZoom(true);
            b.this.f9066a.getGestureMonitor().b(b.this.f9066a.getZoomLevel() - 1.0f);
            b.this.f9066a.mapStatusChangeStart();
            b.this.f9066a.MapMsgProc(8193, 4, 0);
            if (b.this.f9066a.isNaviMode() && b.this.f9066a.getNaviMapViewListener() != null) {
                b.this.f9066a.getNaviMapViewListener().onAction(521, null);
            }
            return true;
        }
    }

    public b(MapController mapController) {
        this.f9066a = mapController;
        this.f9067b = new com.baidu.platform.comapi.map.c0.e.b(new com.baidu.platform.comapi.map.c0.f.b(mapController));
        this.f9068c = new com.baidu.platform.comapi.map.c0.e.a(this.f9069d, mapController);
    }

    public void a(MotionEvent motionEvent) {
        this.f9067b.b(motionEvent);
        this.f9068c.b(motionEvent);
    }
}
