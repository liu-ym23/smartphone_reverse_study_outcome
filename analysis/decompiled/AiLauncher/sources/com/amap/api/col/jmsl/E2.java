package com.amap.api.col.jmsl;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;

/* loaded from: classes.dex */
public class E2 {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1552f1 f16052a;

    /* renamed from: b, reason: collision with root package name */
    public Marker f16053b;

    /* renamed from: c, reason: collision with root package name */
    public Circle f16054c;

    /* renamed from: e, reason: collision with root package name */
    public LatLng f16056e;

    /* renamed from: f, reason: collision with root package name */
    public double f16057f;

    /* renamed from: g, reason: collision with root package name */
    public Context f16058g;

    /* renamed from: h, reason: collision with root package name */
    public Y2 f16059h;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f16068q;

    /* renamed from: d, reason: collision with root package name */
    public MyLocationStyle f16055d = new MyLocationStyle();

    /* renamed from: i, reason: collision with root package name */
    public int f16060i = 4;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16061j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f16062k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16063l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f16064m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f16065n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f16066o = false;

    /* renamed from: p, reason: collision with root package name */
    public c f16067p = null;

    /* renamed from: r, reason: collision with root package name */
    public Animator.AnimatorListener f16069r = new a();

    /* renamed from: s, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f16070s = new b();

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            E2.this.j();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (E2.this.f16054c != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    E2.this.f16054c.setCenter(latLng);
                    E2.this.f16053b.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static class c implements TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f10, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d10 = latLng.latitude;
            double d11 = f10;
            double d12 = d10 + ((latLng2.latitude - d10) * d11);
            double d13 = latLng.longitude;
            return new LatLng(d12, d13 + (d11 * (latLng2.longitude - d13)));
        }
    }

    public E2(InterfaceC1552f1 interfaceC1552f1, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f16058g = applicationContext;
        this.f16052a = interfaceC1552f1;
        this.f16059h = new Y2(applicationContext, interfaceC1552f1);
        b(4, true);
    }

    public final void a() {
        try {
            if (this.f16054c == null) {
                this.f16054c = this.f16052a.N(new CircleOptions().zIndex(1.0f));
            }
            Circle circle = this.f16054c;
            if (circle != null) {
                if (circle.getStrokeWidth() != this.f16055d.getStrokeWidth()) {
                    this.f16054c.setStrokeWidth(this.f16055d.getStrokeWidth());
                }
                if (this.f16054c.getFillColor() != this.f16055d.getRadiusFillColor()) {
                    this.f16054c.setFillColor(this.f16055d.getRadiusFillColor());
                }
                if (this.f16054c.getStrokeColor() != this.f16055d.getStrokeColor()) {
                    this.f16054c.setStrokeColor(this.f16055d.getStrokeColor());
                }
                LatLng latLng = this.f16056e;
                if (latLng != null) {
                    this.f16054c.setCenter(latLng);
                }
                this.f16054c.setRadius(this.f16057f);
                this.f16054c.setVisible(true);
            }
            if (this.f16053b == null) {
                this.f16053b = this.f16052a.J(new MarkerOptions().visible(false));
            }
            Marker marker = this.f16053b;
            if (marker != null) {
                if (marker.getAnchorU() != this.f16055d.getAnchorU() || this.f16053b.getAnchorV() != this.f16055d.getAnchorV()) {
                    this.f16053b.setAnchor(this.f16055d.getAnchorU(), this.f16055d.getAnchorV());
                }
                if (this.f16053b.getIcon() == null) {
                    this.f16053b.setIcon(this.f16055d.getMyLocationIcon());
                } else if (this.f16055d.getMyLocationIcon() != null && !this.f16053b.getIcon().equals(this.f16055d.getMyLocationIcon())) {
                    this.f16053b.setIcon(this.f16055d.getMyLocationIcon());
                }
                LatLng latLng2 = this.f16056e;
                if (latLng2 != null) {
                    this.f16053b.setPosition(latLng2);
                    this.f16053b.setVisible(true);
                }
            }
            j();
            this.f16059h.e(this.f16053b);
        } catch (Throwable th) {
            C1541c2.b(th, "MyLocationOverlay", "myLocStyle");
            th.printStackTrace();
        }
    }

    public final void b(int i10, boolean z10) {
        this.f16060i = i10;
        this.f16061j = false;
        this.f16063l = false;
        this.f16062k = false;
        this.f16065n = false;
        this.f16066o = false;
        if (i10 == 1) {
            this.f16062k = true;
            this.f16063l = true;
            this.f16064m = true;
        } else if (i10 == 2) {
            this.f16062k = true;
            this.f16064m = true;
        } else if (i10 == 3) {
            this.f16062k = true;
            this.f16066o = true;
        } else if (i10 == 4) {
            this.f16062k = true;
            this.f16065n = true;
            this.f16064m = false;
        } else if (i10 == 5) {
            this.f16065n = true;
            this.f16064m = false;
        } else if (i10 == 7) {
            this.f16066o = true;
        }
        if (!this.f16065n && !this.f16066o) {
            InterfaceC1552f1 interfaceC1552f1 = this.f16052a;
            if (interfaceC1552f1 != null) {
                try {
                    interfaceC1552f1.H(CameraUpdateFactory.changeBearing(0.0f));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            InterfaceC1552f1 interfaceC1552f12 = this.f16052a;
            if (interfaceC1552f12 != null) {
                try {
                    interfaceC1552f12.H(CameraUpdateFactory.changeTilt(0.0f));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            this.f16059h.h();
            return;
        }
        if (this.f16066o) {
            this.f16059h.f(true);
            if (!z10) {
                try {
                    this.f16052a.H(CameraUpdateFactory.zoomTo(17.0f));
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            InterfaceC1552f1 interfaceC1552f13 = this.f16052a;
            if (interfaceC1552f13 != null) {
                try {
                    interfaceC1552f13.H(CameraUpdateFactory.changeTilt(45.0f));
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
        } else {
            this.f16059h.f(false);
        }
        this.f16059h.d();
    }

    public void c(Location location) {
        f(this.f16055d.isMyLocationShowing());
        if (this.f16055d.isMyLocationShowing()) {
            this.f16056e = new LatLng(location.getLatitude(), location.getLongitude());
            this.f16057f = location.getAccuracy();
            if (this.f16053b == null && this.f16054c == null) {
                l();
            }
            Circle circle = this.f16054c;
            if (circle != null) {
                try {
                    double d10 = this.f16057f;
                    if (d10 != -1.0d) {
                        circle.setRadius(d10);
                    }
                } catch (Throwable th) {
                    C1541c2.b(th, "MyLocationOverlay", "setCentAndRadius");
                    th.printStackTrace();
                }
            }
            float bearing = location.getBearing();
            if (this.f16064m) {
                float f10 = bearing % 360.0f;
                if (f10 > 180.0f) {
                    f10 -= 360.0f;
                } else if (f10 < -180.0f) {
                    f10 += 360.0f;
                }
                Marker marker = this.f16053b;
                if (marker != null) {
                    marker.setRotateAngle(-f10);
                }
            }
            if (this.f16056e.equals(this.f16053b.getPosition())) {
                j();
                return;
            }
            LatLng latLng = this.f16056e;
            LatLng position = this.f16053b.getPosition();
            if (position == null) {
                position = new LatLng(0.0d, 0.0d);
            }
            if (this.f16067p == null) {
                this.f16067p = new c();
            }
            ValueAnimator valueAnimator = this.f16068q;
            if (valueAnimator == null) {
                ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new c(), position, latLng);
                this.f16068q = valueAnimatorOfObject;
                valueAnimatorOfObject.addListener(this.f16069r);
                this.f16068q.addUpdateListener(this.f16070s);
            } else {
                valueAnimator.setObjectValues(position, latLng);
                this.f16068q.setEvaluator(this.f16067p);
            }
            if (position.latitude == 0.0d && position.longitude == 0.0d) {
                this.f16068q.setDuration(1L);
            } else {
                this.f16068q.setDuration(1000L);
            }
            this.f16068q.start();
        }
    }

    public void e(MyLocationStyle myLocationStyle) {
        try {
            this.f16055d = myLocationStyle;
            f(myLocationStyle.isMyLocationShowing());
            if (!this.f16055d.isMyLocationShowing()) {
                this.f16059h.f(false);
                this.f16060i = this.f16055d.getMyLocationType();
                return;
            }
            l();
            Marker marker = this.f16053b;
            if (marker == null && this.f16054c == null) {
                return;
            }
            this.f16059h.e(marker);
            b(this.f16055d.getMyLocationType(), false);
        } catch (Throwable th) {
            C1541c2.b(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public void f(boolean z10) {
        Circle circle = this.f16054c;
        if (circle != null && circle.isVisible() != z10) {
            this.f16054c.setVisible(z10);
        }
        Marker marker = this.f16053b;
        if (marker == null || marker.isVisible() == z10) {
            return;
        }
        this.f16053b.setVisible(z10);
    }

    public MyLocationStyle h() {
        return this.f16055d;
    }

    public final void j() {
        LatLng latLng = this.f16056e;
        if (latLng != null && this.f16062k) {
            if (this.f16063l && this.f16061j) {
                return;
            }
            this.f16061j = true;
            try {
                this.f16052a.F(CameraUpdateFactory.changeLatLng(latLng));
            } catch (Throwable th) {
                C1541c2.b(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    public void k() throws RemoteException {
        Circle circle = this.f16054c;
        if (circle != null) {
            try {
                this.f16052a.h(circle.getId());
            } catch (Throwable th) {
                C1541c2.b(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.f16054c = null;
        }
        Marker marker = this.f16053b;
        if (marker != null) {
            marker.remove();
            this.f16053b = null;
            this.f16059h.e(null);
        }
        Y2 y22 = this.f16059h;
        if (y22 != null) {
            y22.h();
            this.f16059h = null;
        }
    }

    public final void l() {
        MyLocationStyle myLocationStyle = this.f16055d;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.f16055d = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            a();
            return;
        }
        if (myLocationStyle.getMyLocationIcon() == null || this.f16055d.getMyLocationIcon().getBitmap() == null) {
            this.f16055d.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        a();
    }
}
