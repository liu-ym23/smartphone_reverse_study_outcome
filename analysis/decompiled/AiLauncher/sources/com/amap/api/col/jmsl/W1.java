package com.amap.api.col.jmsl;

import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.amap.mapcore.FPoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class W1 {

    /* renamed from: a, reason: collision with root package name */
    public final V0 f16416a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1552f1 f16417b;

    /* renamed from: c, reason: collision with root package name */
    public final R2 f16418c;

    /* renamed from: g, reason: collision with root package name */
    public P0 f16422g;

    /* renamed from: d, reason: collision with root package name */
    public int f16419d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final Object f16420e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, BaseOverlay> f16421f = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public Runnable f16423h = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            G0 g0F;
            try {
                if (W1.this.f16422g == null || !W1.this.f16422g.p() || (g0F = W1.this.f16422g.f()) == null) {
                    return;
                }
                ((X0) g0F).k();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public W1(InterfaceC1552f1 interfaceC1552f1, V0 v02, R2 r22) {
        this.f16416a = v02;
        this.f16417b = interfaceC1552f1;
        this.f16418c = r22;
    }

    public InterfaceC1552f1 b() {
        return this.f16417b;
    }

    public BaseOverlay c(MotionEvent motionEvent) {
        return this.f16422g.g(motionEvent);
    }

    public void d(P0 p02) {
        this.f16422g = p02;
    }

    public void e(MarkerOptions markerOptions) {
        if (markerOptions.getIcon() == null) {
            this.f16418c.c("localhost_amap_bimap:default_marker");
        } else {
            this.f16418c.b(markerOptions.getIcon());
        }
    }

    public final void f(String str) {
        if ((str.contains("position") || str.contains("icon")) && this.f16422g.p()) {
            this.f16417b.m(this.f16423h);
        }
    }

    public void g(String str, BaseOptions baseOptions) {
        if (str == null || baseOptions == null) {
            return;
        }
        boolean z10 = baseOptions instanceof MarkerOptions;
        if (z10) {
            MarkerOptions markerOptions = (MarkerOptions) baseOptions;
            if (markerOptions.getIcon() == null) {
                this.f16418c.c("localhost_amap_bimap:default_marker");
            } else {
                this.f16418c.b(markerOptions.getIcon());
            }
        } else if (baseOptions instanceof PolylineOptions) {
        }
        String json = baseOptions.toJson();
        if (z10) {
            f(json);
        }
        this.f16416a.q(str, json);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0023 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:6:0x0006, B:9:0x0010, B:16:0x0023, B:14:0x001b, B:18:0x003a, B:19:0x003d), top: B:26:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void h(java.lang.String r6, com.amap.api.maps.model.BaseOverlay r7, com.amap.api.maps.model.BaseOptions r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L4b
            if (r8 != 0) goto L6
            goto L4b
        L6:
            java.lang.String r0 = r8.toJson()     // Catch: java.lang.Throwable -> L19
            boolean r1 = r8 instanceof com.amap.api.maps.model.MarkerOptions     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L38
            if (r0 == 0) goto L1b
            java.lang.String r2 = "position"
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L23
            goto L1b
        L19:
            r6 = move-exception
            goto L49
        L1b:
            java.lang.String r2 = "title"
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L38
        L23:
            com.amap.api.col.jmsl.f2 r2 = com.amap.api.col.jmsl.C1553f2.a()     // Catch: java.lang.Throwable -> L19
            com.amap.api.maps.model.MarkerOptions r8 = (com.amap.api.maps.model.MarkerOptions) r8     // Catch: java.lang.Throwable -> L19
            com.amap.api.maps.model.LatLng r3 = r8.getPosition()     // Catch: java.lang.Throwable -> L19
            java.lang.String r4 = r8.getTitle()     // Catch: java.lang.Throwable -> L19
            java.lang.String r8 = r8.getSnippet()     // Catch: java.lang.Throwable -> L19
            r2.b(r3, r4, r8)     // Catch: java.lang.Throwable -> L19
        L38:
            if (r1 == 0) goto L3d
            r5.f(r0)     // Catch: java.lang.Throwable -> L19
        L3d:
            com.amap.api.col.jmsl.V0 r8 = r5.f16416a     // Catch: java.lang.Throwable -> L19
            r8.k(r6, r0)     // Catch: java.lang.Throwable -> L19
            java.util.HashMap<java.lang.String, com.amap.api.maps.model.BaseOverlay> r8 = r5.f16421f     // Catch: java.lang.Throwable -> L19
            r8.put(r6, r7)     // Catch: java.lang.Throwable -> L19
            monitor-exit(r5)
            return
        L49:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L19
            throw r6
        L4b:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.W1.h(java.lang.String, com.amap.api.maps.model.BaseOverlay, com.amap.api.maps.model.BaseOptions):void");
    }

    public void i(String str, FPoint fPoint) {
        BaseOverlay baseOverlay = this.f16421f.get(str);
        if (baseOverlay instanceof Marker) {
            ((Marker) baseOverlay).getRealInfoWindowOffset(fPoint);
        }
    }

    public synchronized void j(String[] strArr) {
        G0 g0F;
        try {
            for (String str : this.f16421f.keySet()) {
                if (k(strArr, str)) {
                    this.f16416a.p(str);
                }
            }
            Iterator<Map.Entry<String, BaseOverlay>> it = this.f16421f.entrySet().iterator();
            while (it.hasNext()) {
                if (k(strArr, it.next().getKey())) {
                    it.remove();
                }
            }
            P0 p02 = this.f16422g;
            if (p02 != null && (g0F = p02.f()) != null) {
                ((X0) g0F).c();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean k(String[] strArr, String str) {
        if (strArr == null) {
            return true;
        }
        for (String str2 : strArr) {
            if (str2 != null && str2.contains(str)) {
                return false;
            }
        }
        return true;
    }

    public String l(String str) {
        String str2;
        synchronized (this.f16420e) {
            this.f16419d++;
            str2 = str + this.f16419d;
        }
        return str2;
    }

    public void m() {
        G0 g0F;
        P0 p02 = this.f16422g;
        if (p02 == null || (g0F = p02.f()) == null) {
            return;
        }
        ((X0) g0F).c();
    }

    public BaseOverlay n(String str) {
        return this.f16421f.get(str);
    }

    public boolean o() {
        P0 p02 = this.f16422g;
        if (p02 != null) {
            return p02.p();
        }
        return false;
    }

    public void p() {
        if (this.f16422g.p()) {
            this.f16417b.m(this.f16423h);
        }
    }

    public synchronized void q(String str) {
        if (str == null) {
            return;
        }
        this.f16416a.p(str);
        this.f16421f.remove(str);
    }

    public void r(String str) {
        BaseOverlay baseOverlay = this.f16421f.get(str);
        if (baseOverlay instanceof Marker) {
            Marker marker = (Marker) baseOverlay;
            P0 p02 = this.f16422g;
            if (p02 != null) {
                try {
                    p02.k(marker);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }
}
