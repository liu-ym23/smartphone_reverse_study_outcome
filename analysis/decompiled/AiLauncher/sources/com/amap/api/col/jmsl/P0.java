package com.amap.api.col.jmsl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;

/* loaded from: classes.dex */
public class P0 {

    /* renamed from: c, reason: collision with root package name */
    public View f16258c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f16259d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f16260e;

    /* renamed from: g, reason: collision with root package name */
    public Context f16262g;

    /* renamed from: h, reason: collision with root package name */
    public G0 f16263h;

    /* renamed from: i, reason: collision with root package name */
    public BaseOverlay f16264i;

    /* renamed from: a, reason: collision with root package name */
    public AMap.InfoWindowAdapter f16256a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16257b = true;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f16261f = null;

    /* renamed from: j, reason: collision with root package name */
    public AMap.InfoWindowAdapter f16265j = new a();

    /* renamed from: k, reason: collision with root package name */
    public AMap.CommonInfoWindowAdapter f16266k = new b();

    public class a implements AMap.InfoWindowAdapter {
        public a() {
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public View getInfoContents(Marker marker) {
            return null;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public View getInfoWindow(Marker marker) {
            try {
                if (P0.this.f16261f == null) {
                    P0 p02 = P0.this;
                    p02.f16261f = C1624x2.c(p02.f16262g, "infowindow_bg.9.png");
                }
                if (P0.this.f16258c == null) {
                    P0.this.f16258c = new LinearLayout(P0.this.f16262g);
                    P0.this.f16258c.setBackground(P0.this.f16261f);
                    P0.this.f16259d = new TextView(P0.this.f16262g);
                    P0.this.f16259d.setText(marker.getTitle());
                    P0.this.f16259d.setTextColor(-16777216);
                    P0.this.f16260e = new TextView(P0.this.f16262g);
                    P0.this.f16260e.setTextColor(-16777216);
                    P0.this.f16260e.setText(marker.getSnippet());
                    ((LinearLayout) P0.this.f16258c).setOrientation(1);
                    ((LinearLayout) P0.this.f16258c).addView(P0.this.f16259d);
                    ((LinearLayout) P0.this.f16258c).addView(P0.this.f16260e);
                }
            } catch (Throwable th) {
                C1541c2.b(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return P0.this.f16258c;
        }
    }

    public class b implements AMap.CommonInfoWindowAdapter {

        /* renamed from: a, reason: collision with root package name */
        public InfoWindowParams f16268a = null;

        public b() {
        }

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                if (this.f16268a == null) {
                    this.f16268a = new InfoWindowParams();
                    if (P0.this.f16261f == null) {
                        P0 p02 = P0.this;
                        p02.f16261f = C1624x2.c(p02.f16262g, "infowindow_bg.9.png");
                    }
                    P0.this.f16258c = new LinearLayout(P0.this.f16262g);
                    P0.this.f16258c.setBackground(P0.this.f16261f);
                    P0.this.f16259d = new TextView(P0.this.f16262g);
                    P0.this.f16259d.setText("标题");
                    P0.this.f16259d.setTextColor(-16777216);
                    P0.this.f16260e = new TextView(P0.this.f16262g);
                    P0.this.f16260e.setTextColor(-16777216);
                    P0.this.f16260e.setText("内容");
                    ((LinearLayout) P0.this.f16258c).setOrientation(1);
                    ((LinearLayout) P0.this.f16258c).addView(P0.this.f16259d);
                    ((LinearLayout) P0.this.f16258c).addView(P0.this.f16260e);
                    this.f16268a.setInfoWindowType(2);
                    this.f16268a.setInfoWindow(P0.this.f16258c);
                }
                return this.f16268a;
            } catch (Throwable th) {
                C1541c2.b(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    }

    public P0(Context context) {
        this.f16262g = context;
    }

    public View d(BasePointOverlay basePointOverlay) {
        AMap.InfoWindowAdapter infoWindowAdapter = this.f16256a;
        if (infoWindowAdapter != null) {
            return infoWindowAdapter.getInfoContents((Marker) basePointOverlay);
        }
        InfoWindowParams infoWindowParams = this.f16266k.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams != null) {
            return infoWindowParams.getInfoContents();
        }
        return null;
    }

    public synchronized G0 f() {
        return this.f16263h;
    }

    public BaseOverlay g(MotionEvent motionEvent) {
        G0 g0F = f();
        if (g0F == null || !((X0) g0F).h(motionEvent)) {
            return null;
        }
        return this.f16264i;
    }

    public final void h(View view, BasePointOverlay basePointOverlay) {
        if (view == null || basePointOverlay == null || basePointOverlay.getPosition() == null || !C1553f2.d()) {
            return;
        }
        String strQ = C1570k.q(view);
        if (TextUtils.isEmpty(strQ)) {
            return;
        }
        C1553f2.a().b(basePointOverlay.getPosition(), strQ, "");
    }

    public void i(G0 g02) {
        synchronized (this) {
            try {
                this.f16263h = g02;
                if (g02 != null) {
                    ((X0) g02).f16456k = this;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void j(AMap.InfoWindowAdapter infoWindowAdapter) {
        try {
            this.f16256a = infoWindowAdapter;
            if (infoWindowAdapter == null) {
                this.f16256a = this.f16265j;
                this.f16257b = true;
            } else {
                this.f16257b = false;
            }
            G0 g02 = this.f16263h;
            if (g02 != null) {
                ((X0) g02).c();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void k(BaseOverlay baseOverlay) throws RemoteException {
        G0 g0F = f();
        if (g0F == null || !(baseOverlay instanceof BasePointOverlay)) {
            return;
        }
        ((X0) g0F).g((BasePointOverlay) baseOverlay);
        this.f16264i = baseOverlay;
    }

    public void l(String str, String str2) {
        TextView textView = this.f16259d;
        if (textView != null) {
            textView.requestLayout();
            this.f16259d.setText(str);
        }
        TextView textView2 = this.f16260e;
        if (textView2 != null) {
            textView2.requestLayout();
            this.f16260e.setText(str2);
        }
        View view = this.f16258c;
        if (view != null) {
            view.requestLayout();
        }
    }

    public View n(BasePointOverlay basePointOverlay) {
        AMap.InfoWindowAdapter infoWindowAdapter = this.f16256a;
        if (infoWindowAdapter != null) {
            View infoWindow = infoWindowAdapter.getInfoWindow((Marker) basePointOverlay);
            h(infoWindow, basePointOverlay);
            return infoWindow;
        }
        InfoWindowParams infoWindowParams = this.f16266k.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams != null) {
            return infoWindowParams.getInfoWindow();
        }
        return null;
    }

    public boolean p() {
        G0 g0F = f();
        if (g0F != null) {
            return ((X0) g0F).j();
        }
        return false;
    }

    public synchronized boolean r() {
        return this.f16257b;
    }
}
