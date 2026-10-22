package com.amap.api.col.jmsl;

import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;

/* loaded from: classes.dex */
public class P1 {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1552f1 f16270a;

    /* renamed from: b, reason: collision with root package name */
    public final W1 f16271b;

    /* renamed from: c, reason: collision with root package name */
    public final C1549e2 f16272c = new C1549e2();

    public P1(InterfaceC1552f1 interfaceC1552f1, W1 w12) {
        this.f16270a = interfaceC1552f1;
        this.f16271b = w12;
    }

    public CameraPosition a() {
        return CameraPosition.builder().target(this.f16272c.f16606a).zoom(this.f16272c.f16607b).bearing(this.f16272c.f16609d).tilt(this.f16272c.f16608c).build();
    }

    public void b(double d10, double d11, float f10, float f11, float f12) {
        C1549e2 c1549e2 = this.f16272c;
        LatLng latLng = c1549e2.f16606a;
        if (latLng.latitude != d10 && latLng.longitude != d11) {
            c1549e2.f16606a = new LatLng(d10, d11);
        }
        C1549e2 c1549e22 = this.f16272c;
        c1549e22.f16607b = f10;
        c1549e22.f16609d = f11;
        c1549e22.f16608c = f12;
        this.f16271b.p();
    }

    public void c(float f10) {
        C1549e2 c1549e2 = this.f16272c;
        if (f10 > 20.0f) {
            f10 = 20.0f;
        }
        if (f10 < 3.0f) {
            f10 = 3.0f;
        }
        float f11 = c1549e2.f16611f;
        if (f10 < f11) {
            f10 = f11;
        }
        c1549e2.f16610e = f10;
    }

    public C1549e2 d() {
        return this.f16272c;
    }

    public void e(float f10) {
        C1549e2 c1549e2 = this.f16272c;
        if (f10 < 3.0f) {
            f10 = 3.0f;
        }
        if (f10 > 20.0f) {
            f10 = 20.0f;
        }
        float f11 = c1549e2.f16610e;
        if (f10 > f11) {
            f10 = f11;
        }
        c1549e2.f16611f = f10;
    }

    public float f() {
        return this.f16272c.f16610e;
    }

    public float g() {
        return this.f16272c.f16611f;
    }
}
