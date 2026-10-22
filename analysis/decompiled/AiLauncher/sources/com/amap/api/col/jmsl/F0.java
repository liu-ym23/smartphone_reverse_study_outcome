package com.amap.api.col.jmsl;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapCallback;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.AmapDelegateListenerManager;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class F0 implements O0 {

    /* renamed from: a, reason: collision with root package name */
    public final W0 f16073a;

    /* renamed from: b, reason: collision with root package name */
    public final AmapDelegateListenerManager f16074b;

    /* renamed from: c, reason: collision with root package name */
    public final W1 f16075c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16076d = false;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f16077a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MotionEvent f16078b;

        /* renamed from: com.amap.api.col.jmsl.F0$a$a, reason: collision with other inner class name */
        public class C0200a implements AMapCallback<LatLng> {
            public C0200a() {
            }

            @Override // com.amap.api.maps.AMapCallback
            public void onCallback(LatLng latLng) {
                LatLng latLng2 = latLng;
                for (int i10 = 0; i10 < a.this.f16077a.size(); i10++) {
                    ((AMap.OnMapLongClickListener) a.this.f16077a.get(i10)).onMapLongClick(latLng2);
                }
            }
        }

        public a(List list, MotionEvent motionEvent) {
            this.f16077a = list;
            this.f16078b = motionEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (this.f16077a) {
                    F0.this.f16075c.b().a().fromScreenLocation(new Point((int) this.f16078b.getX(), (int) this.f16078b.getY()), new C0200a());
                }
            } catch (Throwable th) {
                th.printStackTrace();
                C1570k.j(th);
            }
        }
    }

    public F0(InterfaceC1552f1 interfaceC1552f1, Context context, AmapDelegateListenerManager amapDelegateListenerManager, W1 w12) {
        this.f16074b = amapDelegateListenerManager;
        W0 w02 = new W0(interfaceC1552f1, context);
        this.f16073a = w02;
        w02.b(this);
        this.f16075c = w12;
    }

    public void b(MotionEvent motionEvent) {
        try {
            List listenerList = this.f16074b.getListenerList(AMap.OnMapLongClickListener.class.hashCode());
            if (listenerList == null) {
                return;
            }
            this.f16075c.b().m(new a(listenerList, motionEvent));
        } catch (Throwable th) {
            th.printStackTrace();
            C1570k.j(th);
        }
    }

    public boolean c(MotionEvent motionEvent) {
        try {
            List listenerList = this.f16074b.getListenerList(AMap.OnInfoWindowClickListener.class.hashCode());
            BaseOverlay baseOverlayC = this.f16075c.c(motionEvent);
            if (baseOverlayC != null && (baseOverlayC instanceof Marker)) {
                synchronized (listenerList) {
                    for (int i10 = 0; i10 < listenerList.size(); i10++) {
                        try {
                            ((AMap.OnInfoWindowClickListener) listenerList.get(i10)).onInfoWindowClick((Marker) baseOverlayC);
                        } finally {
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f16073a.a();
            this.f16076d = true;
        } else if (action == 1) {
            this.f16076d = true;
        }
        if (this.f16076d) {
            try {
                this.f16073a.c(motionEvent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            List listenerList = this.f16074b.getListenerList(AMap.OnMapTouchListener.class.hashCode());
            if (listenerList == null || listenerList.size() <= 0) {
                return false;
            }
            synchronized (listenerList) {
                try {
                    Iterator it = listenerList.iterator();
                    while (it.hasNext()) {
                        ((AMap.OnMapTouchListener) it.next()).onTouch(motionEvent);
                    }
                } finally {
                }
            }
            return false;
        } catch (Throwable th2) {
            try {
                C1541c2.b(th2, "AMapGesture", "onTouchHandler");
                th2.printStackTrace();
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
