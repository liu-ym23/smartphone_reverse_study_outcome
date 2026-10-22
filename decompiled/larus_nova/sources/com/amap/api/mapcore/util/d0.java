package com.amap.api.mapcore.util;

import android.graphics.Rect;
import android.view.View;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.DPoint;

/* JADX INFO: loaded from: classes28.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Marker f27147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f27148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f27149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f27150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f27151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f27152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f27153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f27154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f27155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f27156j;

    public synchronized int a() {
        monitor-enter(this);
        int r100 = this.f27150d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int b() {
        monitor-enter(this);
        int r100 = this.f27151e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public View d() {
        MarkerOptions r100 = this.f27147a.getOptions();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getIconView();
    }

    public int e() {
        MarkerOptions r100 = this.f27147a.getOptions();
        if (r100 != null) goto L6;
        return 0;
    L6:
        View r101 = r100.getIconView();
        int r102 = r101.getWidth();
        if (r102 != 0) goto L10;
        a(r101);
        return this.f27155i;
    L10:
        return r102;
    }

    public void i() {
        MarkerOptions r100 = this.f27147a.getOptions();
        if (r100 != null) goto L5;
        return;
    L5:
        View r101 = r100.getIconView();
        if (r101 != null) goto L8;
        return;
    L8:
        boolean r102 = r100.isVisible();
        int r103 = 0;
        if (r101.getVisibility() != 0) goto L11;
        boolean r104 = true;
    L12:
        if (r102 != r104) goto L15;
        return;
    L15:
        if (r100.isVisible() == true) goto L18;
        r103 = 8;
    L18:
        r101.setVisibility(r103);
        return;
    L11:
        r104 = false;
        goto L12
    }

    public BaseOverlay c() {
        return this.f27147a;
    }

    public boolean f() {
        return this.f27154h;
    }

    public boolean g() {
        return this.f27153g;
    }

    public boolean h() {
        return this.f27152f;
    }

    public d0(Marker r100) {
        this.f27148b = 0;
        this.f27149c = 0;
        this.f27150d = 0;
        this.f27151e = 0;
        this.f27152f = false;
        this.f27153g = false;
        this.f27154h = false;
        this.f27155i = 0;
        this.f27156j = 0;
        this.f27147a = r100;
    }

    public boolean a(DPoint r100) {
        View r101 = this.f27147a.getOptions().getIconView();
        Rect r102 = new Rect();
        if (r101 == null) goto L6;
        r101.getHitRect(r102);
    L6:
        if (r102.contains((int) r100.f30021x, (int) r100.f30022y) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public void b(boolean r100) {
        this.f27153g = r100;
    }

    private void a(View r100) {
        if (this.f27155i == 0) goto L5;
        return;
    L5:
        if (this.f27156j != 0) goto L9;
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f27155i = r100.getMeasuredWidth();
        this.f27156j = r100.getMeasuredHeight();
        return;
    }

    public void a(boolean r100) {
        this.f27154h = r100;
    }

    public synchronized void a(int r100, int r101) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f27152f == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        MarkerOptions r102 = this.f27147a.getOptions();     // Catch: Throwable -> L23
        if (r102 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        View r103 = r102.getIconView();     // Catch: Throwable -> L23
        if (r103 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        r103.setX(this.f27150d);     // Catch: Throwable -> L23
        r103.setY(this.f27151e);     // Catch: Throwable -> L23
        r103.setZ(r102.getZIndex());     // Catch: Throwable -> L23
        if (r100 == (-1)) goto L18;
        this.f27148b = r100;     // Catch: Throwable -> L23
    L18:
        if (r101 == (-1)) goto L20;
        this.f27149c = r101;     // Catch: Throwable -> L23
    L20:
        this.f27152f = false;     // Catch: Throwable -> L23
        monitor-exit(this);
    }

    public synchronized void b(int r100, int r101) {
        monitor-enter(this);
        MarkerOptions r102 = this.f27147a.getOptions();     // Catch: Throwable -> L30
        if (r102 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        float r103 = r102.getAnchorU();     // Catch: Throwable -> L30
        float r104 = r102.getAnchorV();     // Catch: Throwable -> L30
        View r105 = r102.getIconView();     // Catch: Throwable -> L30
        int r106 = 0;
        if (r105 == null) goto L15;
        int r107 = e();     // Catch: Throwable -> L30
        MarkerOptions r108 = this.f27147a.getOptions();     // Catch: Throwable -> L30
        if (r108 == null) goto L16;
        View r109 = r108.getIconView();     // Catch: Throwable -> L30
        int r110 = r109.getHeight();     // Catch: Throwable -> L30
        if (r110 != 0) goto L17;
        a(r109);     // Catch: Throwable -> L30
        r110 = this.f27156j;     // Catch: Throwable -> L30
    L17:
        if (r105 == null) goto L19;
        r106 = (int) (r107 * r103);     // Catch: Throwable -> L30
        int r111 = (int) (r110 * r104);     // Catch: Throwable -> L30
    L20:
        if (r106 == 0) goto L28;
        if (r111 == 0) goto L28;
        if (Math.abs(this.f27148b - r100) <= 2) goto L26;
        this.f27150d = r100 - r106;     // Catch: Throwable -> L30
        this.f27152f = true;     // Catch: Throwable -> L30
    L26:
        if (Math.abs(this.f27149c - r101) <= 2) goto L28;
        this.f27151e = r101 - r111;     // Catch: Throwable -> L30
        this.f27152f = true;     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return;
    L19:
        r111 = 0;
    L16:
        r110 = 0;
        goto L17
    L15:
        r107 = 0;
    L30:
        th = move-exception;
        throw th;
    }

    public void a(boolean r100, int r101, int r102) {
        this.f27152f = r100;
        this.f27148b = r101;
        this.f27149c = r102;
    }
}
