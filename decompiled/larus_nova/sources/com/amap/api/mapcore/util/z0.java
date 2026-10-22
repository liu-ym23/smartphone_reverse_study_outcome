package com.amap.api.mapcore.util;

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
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* JADX INFO: loaded from: classes28.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AMap.InfoWindowAdapter f28530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    AMap.CommonInfoWindowAdapter f28531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f28533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f28534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f28535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f28536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Context f28537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private IInfoWindowAction f28538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private IInfoWindowAction f28539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BaseOverlay f28540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AMap.InfoWindowAdapter f28541l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private AMap.CommonInfoWindowAdapter f28542m;

    public class a implements AMap.InfoWindowAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z0 f28543a;

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public View getInfoContents(Marker r100) {
            return null;
        }

        public a(z0 r100) {
            this.f28543a = r100;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public View getInfoWindow(Marker r100) {
        L9:
            th = move-exception;
            t6.a(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
            th.printStackTrace();
        L12:
            return z0.b(this.f28543a);
        L3:
            if (z0.a(this.f28543a) != null) goto L6;
            z0 r101 = this.f28543a;     // Catch: Throwable -> L9
            z0.a(r101, q3.a(r101.f28537h, "infowindow_bg.9.png"));     // Catch: Throwable -> L9
        L6:
            if (z0.b(this.f28543a) != null) goto L12;
            z0.a(this.f28543a, new LinearLayout(this.f28543a.f28537h));     // Catch: Throwable -> L9
            z0.b(this.f28543a).setBackground(z0.a(this.f28543a));     // Catch: Throwable -> L9
            z0.a(this.f28543a, new TextView(this.f28543a.f28537h));     // Catch: Throwable -> L9
            z0.c(this.f28543a).setText(r100.getTitle());     // Catch: Throwable -> L9
            z0.c(this.f28543a).setTextColor(-16777216);     // Catch: Throwable -> L9
            z0.b(this.f28543a, new TextView(this.f28543a.f28537h));     // Catch: Throwable -> L9
            z0.d(this.f28543a).setTextColor(-16777216);     // Catch: Throwable -> L9
            z0.d(this.f28543a).setText(r100.getSnippet());     // Catch: Throwable -> L9
            ((LinearLayout) z0.b(this.f28543a)).setOrientation(1);     // Catch: Throwable -> L9
            ((LinearLayout) z0.b(this.f28543a)).addView(z0.c(this.f28543a));     // Catch: Throwable -> L9
            ((LinearLayout) z0.b(this.f28543a)).addView(z0.d(this.f28543a));     // Catch: Throwable -> L9
            goto L12
        }
    }

    public class b implements AMap.CommonInfoWindowAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private InfoWindowParams f28544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z0 f28545b;

        public b(z0 r100) {
            this.f28545b = r100;
            this.f28544a = null;
        }

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public InfoWindowParams getInfoWindowParams(BasePointOverlay r100) {
        L10:
            th = move-exception;
            t6.a(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
            th.printStackTrace();
            return null;
        L3:
            if (this.f28544a != null) goto L8;
            this.f28544a = new InfoWindowParams();     // Catch: Throwable -> L10
            if (z0.a(this.f28545b) != null) goto L7;
            z0 r101 = this.f28545b;     // Catch: Throwable -> L10
            z0.a(r101, q3.a(r101.f28537h, "infowindow_bg.9.png"));     // Catch: Throwable -> L10
        L7:
            z0.a(this.f28545b, new LinearLayout(this.f28545b.f28537h));     // Catch: Throwable -> L10
            z0.b(this.f28545b).setBackground(z0.a(this.f28545b));     // Catch: Throwable -> L10
            z0.a(this.f28545b, new TextView(this.f28545b.f28537h));     // Catch: Throwable -> L10
            z0.c(this.f28545b).setText(p0.a(2131034180));     // Catch: Throwable -> L10
            z0.c(this.f28545b).setTextColor(-16777216);     // Catch: Throwable -> L10
            z0.b(this.f28545b, new TextView(this.f28545b.f28537h));     // Catch: Throwable -> L10
            z0.d(this.f28545b).setTextColor(-16777216);     // Catch: Throwable -> L10
            z0.d(this.f28545b).setText(p0.a(2131034181));     // Catch: Throwable -> L10
            ((LinearLayout) z0.b(this.f28545b)).setOrientation(1);     // Catch: Throwable -> L10
            ((LinearLayout) z0.b(this.f28545b)).addView(z0.c(this.f28545b));     // Catch: Throwable -> L10
            ((LinearLayout) z0.b(this.f28545b)).addView(z0.d(this.f28545b));     // Catch: Throwable -> L10
            this.f28544a.setInfoWindowType(2);     // Catch: Throwable -> L10
            this.f28544a.setInfoWindow(z0.b(this.f28545b));     // Catch: Throwable -> L10
        L8:
            return this.f28544a;
        }
    }

    public synchronized IInfoWindowAction a() {
        monitor-enter(this);
        AMap.InfoWindowAdapter r100 = this.f28530a;     // Catch: Throwable -> L25
        if (r100 != null) goto L6;
    L15:
        AMap.CommonInfoWindowAdapter r101 = this.f28531b;     // Catch: Throwable -> L25
        if (r101 != null) goto L18;
    L22:
        IInfoWindowAction r102 = this.f28538i;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r102;
    L18:
        if (r101.getInfoWindowParams(null).getInfoWindowType() != 1) goto L22;
        IInfoWindowAction r103 = this.f28539j;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r103;
    L6:
        if ((r100 instanceof AMap.ImageInfoWindowAdapter) == false) goto L11;
        IInfoWindowAction r104 = this.f28539j;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r104;
    L11:
        if ((r100 instanceof AMap.MultiPositionInfoWindowAdapter) == false) goto L15;
        IInfoWindowAction r105 = this.f28539j;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r105;
    L25:
        th = move-exception;
        throw th;
    }

    public synchronized boolean b() {
        monitor-enter(this);
        boolean r100 = this.f28532c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public z0(Context r100) {
        this.f28530a = null;
        this.f28531b = null;
        this.f28532c = true;
        this.f28536g = null;
        this.f28541l = new a(this);
        this.f28542m = new b(this);
        this.f28537h = r100;
    }

    public static /* synthetic */ TextView d(z0 r100) {
        return r100.f28535f;
    }

    public synchronized void a(AMap.InfoWindowAdapter r100) {
        monitor-enter(this);
        this.f28530a = r100;     // Catch: Throwable -> L26
        this.f28531b = null;     // Catch: Throwable -> L26
        if (r100 != null) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L13;
        Marker r102 = new Marker(null, null, new MarkerOptions(), "check");     // Catch: Throwable -> L26
        if (r100.getInfoWindow(r102) == null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L17;
        this.f28530a = this.f28541l;     // Catch: Throwable -> L26
        this.f28532c = true;     // Catch: Throwable -> L26
    L18:
        IInfoWindowAction r104 = this.f28539j;     // Catch: Throwable -> L26
        if (r104 == null) goto L21;
        r104.hideInfoWindow();     // Catch: Throwable -> L26
    L21:
        IInfoWindowAction r105 = this.f28538i;     // Catch: Throwable -> L26
        if (r105 == null) goto L24;
        r105.hideInfoWindow();     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return;
    L17:
        this.f28532c = false;     // Catch: Throwable -> L26
        goto L18
    L12:
        if (r100.getInfoContents(r102) != null) goto L14;
    L13:
        r103 = true;
        goto L15
    L6:
        r101 = false;
    L26:
        th = move-exception;
        throw th;
    }

    public View b(BasePointOverlay r100) {
        AMap.InfoWindowAdapter r101 = this.f28530a;
        if (r101 == null) goto L6;
        View r102 = r101.getInfoWindow((Marker) r100);
        a(r102, r100);
        return r102;
    L6:
        AMap.CommonInfoWindowAdapter r103 = this.f28531b;
        if (r103 == null) goto L12;
        InfoWindowParams r104 = r103.getInfoWindowParams(r100);
        if (r104 == null) goto L12;
        View r105 = r104.getInfoWindow();
        a(r105, r100);
        return r105;
    L12:
        InfoWindowParams r106 = this.f28542m.getInfoWindowParams(r100);
        if (r106 != null) goto L15;
        return null;
    L15:
        return r106.getInfoWindow();
    }

    public long c(BasePointOverlay r100) {
        AMap.InfoWindowAdapter r101 = this.f28530a;
        if (r101 != null) goto L5;
    L8:
        AMap.CommonInfoWindowAdapter r102 = this.f28531b;
        if (r102 == null) goto L14;
        InfoWindowParams r103 = r102.getInfoWindowParams(r100);
        if (r103 != null) goto L13;
        return 0;
    L13:
        return r103.getInfoWindowUpdateTime();
    L14:
        return 0;
    L5:
        if ((r101 instanceof AMap.ImageInfoWindowAdapter) == false) goto L8;
        return ((AMap.ImageInfoWindowAdapter) r101).getInfoWindowUpdateTime();
    }

    public static /* synthetic */ TextView c(z0 r100) {
        return r100.f28534e;
    }

    public View a(BasePointOverlay r100) {
        AMap.InfoWindowAdapter r101 = this.f28530a;
        if (r101 == null) goto L6;
        View r102 = r101.getInfoContents((Marker) r100);
        a(r102, r100);
        return r102;
    L6:
        AMap.CommonInfoWindowAdapter r103 = this.f28531b;
        if (r103 == null) goto L12;
        InfoWindowParams r104 = r103.getInfoWindowParams(r100);
        if (r104 == null) goto L12;
        View r105 = r104.getInfoContents();
        a(r105, r100);
        return r105;
    L12:
        InfoWindowParams r106 = this.f28542m.getInfoWindowParams(r100);
        if (r106 != null) goto L15;
        return null;
    L15:
        return r106.getInfoContents();
    }

    public void b(IInfoWindowAction r100) {
        monitor-enter(this);
        this.f28538i = r100;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        ((h4) r100).setInfoWindowAdapterManager(this);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ View b(z0 r100) {
        return r100.f28533d;
    }

    public synchronized void a(AMap.CommonInfoWindowAdapter r100) {
        monitor-enter(this);
        this.f28531b = r100;     // Catch: Throwable -> L15
        this.f28530a = null;     // Catch: Throwable -> L15
        if (r100 != null) goto L6;
        this.f28531b = this.f28542m;     // Catch: Throwable -> L15
        this.f28532c = true;     // Catch: Throwable -> L15
    L7:
        IInfoWindowAction r101 = this.f28539j;     // Catch: Throwable -> L15
        if (r101 == null) goto L10;
        r101.hideInfoWindow();     // Catch: Throwable -> L15
    L10:
        IInfoWindowAction r102 = this.f28538i;     // Catch: Throwable -> L15
        if (r102 == null) goto L13;
        r102.hideInfoWindow();     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L6:
        this.f28532c = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public void a(BaseOverlay r100) throws RemoteException {
        IInfoWindowAction r101 = a();
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof BasePointOverlay) == false) goto L9;
        r101.showInfoWindow((BasePointOverlay) r100);
        this.f28540k = r100;
        return;
    }

    public BaseOverlay a(MotionEvent r100) {
        IInfoWindowAction r101 = a();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.onInfoWindowTap(r100) == true) goto L7;
        return null;
    L7:
        return this.f28540k;
    }

    public void a(IInfoWindowAction r100) {
        monitor-enter(this);
        this.f28539j = r100;     // Catch: Throwable -> L11
        q2 r101 = (q2) r100;     // Catch: Throwable -> L11
        monitor-enter(r101);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Drawable a(z0 r100) {
        return r100.f28536g;
    }

    private void a(View r100, BasePointOverlay r101) {
        if (r100 == null) goto L12;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getPosition() != null) goto L7;
        return;
    L7:
        if (o3.c() == false) goto L15;
        String r102 = w3.b(r100);
        if (TextUtils.isEmpty(r102) == true) goto L16;
        o3.b().a(r101.getPosition(), r102, "");
        return;
    L16:
        return;
    L15:
        return;
    }

    public static /* synthetic */ TextView b(z0 r100, TextView r101) {
        r100.f28535f = r101;
        return r101;
    }

    public void a(String r100, String r101) {
        TextView r102 = this.f28534e;
        if (r102 == null) goto L5;
        r102.requestLayout();
        this.f28534e.setText(r100);
    L5:
        TextView r103 = this.f28535f;
        if (r103 == null) goto L8;
        r103.requestLayout();
        this.f28535f.setText(r101);
    L8:
        View r104 = this.f28533d;
        if (r104 == null) goto L12;
        r104.requestLayout();
        return;
    }

    public static /* synthetic */ Drawable a(z0 r100, Drawable r101) {
        r100.f28536g = r101;
        return r101;
    }

    public static /* synthetic */ View a(z0 r100, View r101) {
        r100.f28533d = r101;
        return r101;
    }

    public static /* synthetic */ TextView a(z0 r100, TextView r101) {
        r100.f28534e = r101;
        return r101;
    }
}
