package com.baidu.mapsdkplatform.comapi.map.z;

import com.baidu.platform.comapi.map.InnerOverlay;
import com.baidu.platform.comapi.map.f;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class a extends InnerOverlay {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32246g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f32247h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f32248i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f32249j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<f> f32250k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f32251l;

    public void a() {
        this.f32251l = true;
        UpdateOverlay();
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public void clear() {
        this.f32248i = false;
        this.f32249j = false;
        List<f> r100 = this.f32250k;
        monitor-enter(r100);
        this.f32250k.clear();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        super.clear();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public a() {
        super(36);
        this.f32243d = false;
        this.f32244e = 0;
        this.f32245f = 0;
        this.f32246g = 0;
        this.f32247h = true;
        this.f32248i = false;
        this.f32249j = false;
        this.f32250k = new ArrayList();
        this.f32251l = true;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getData() {
        if (this.f32251l == false) goto L35;
        List<f> r100 = this.f32250k;
        monitor-enter(r100);
    L31:
        th = move-exception;
        throw th;
    L7:
        if (this.f32250k.size() == 0) goto L9;
        JsonBuilder r101 = new JsonBuilder();     // Catch: Throwable -> L31
        r101.object();     // Catch: Throwable -> L31
        if (this.f32249j == false) goto L16;
        r101.key("statuschange").value(1);     // Catch: Throwable -> L31
        r101.key("onpause").value(this.f32248i ? 1 : 0);     // Catch: Throwable -> L31
        r101.endObject();     // Catch: Throwable -> L31
        setData(r101.getJson());     // Catch: Throwable -> L31
        this.f32251l = false;     // Catch: Throwable -> L31
        String r102 = super.getData();     // Catch: Throwable -> L31
        monitor-exit(r100);     // Catch: Throwable -> L31
        return r102;
    L16:
        r101.key("dataset").arrayValue();     // Catch: Throwable -> L31
        Iterator<f> r103 = this.f32250k.iterator();     // Catch: Throwable -> L31
    L18:
        if (r103.hasNext() == false) goto L20;
        r101.objectValue(r103.next().a());     // Catch: Throwable -> L31
        goto L18
    L20:
        r101.endArrayValue();     // Catch: Throwable -> L31
        r101.key("startValue").value(0);     // Catch: Throwable -> L31
        r101.key("endValue").value(1);     // Catch: Throwable -> L31
        if (this.f32243d == false) goto L23;
        r101.key("isNeedRouteAnimate").value(1);     // Catch: Throwable -> L31
        r101.key("durationTime").value(this.f32244e);     // Catch: Throwable -> L31
        r101.key("delayTime").value(this.f32245f);     // Catch: Throwable -> L31
        r101.key("easingCurve").value(this.f32246g);     // Catch: Throwable -> L31
        this.f32243d = false;     // Catch: Throwable -> L31
    L25:
        if (this.f32247h == false) goto L27;
        r101.key("isRotateWhenTrack").value(1);     // Catch: Throwable -> L31
    L28:
        r101.endObject();     // Catch: Throwable -> L31
        setData(r101.getJson());     // Catch: Throwable -> L31
        this.f32251l = false;     // Catch: Throwable -> L31
        monitor-exit(r100);     // Catch: Throwable -> L31
        goto L35
    L27:
        r101.key("isRotateWhenTrack").value(0);     // Catch: Throwable -> L31
        goto L28
    L23:
        r101.key("isNeedRouteAnimate").value(0);     // Catch: Throwable -> L31
        r101.key("durationTime").value(0);     // Catch: Throwable -> L31
        r101.key("delayTime").value(0);     // Catch: Throwable -> L31
        r101.key("easingCurve").value(0);     // Catch: Throwable -> L31
        goto L25
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L31
        return "";
    L35:
        return super.getData();
    }

    public boolean b() {
        return this.f32248i;
    }

    public boolean c() {
        return this.f32249j;
    }

    public boolean a(f r100) {
        List<f> r101 = this.f32250k;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f32250k.contains(r100) == false) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L12
        return false;
    L9:
        boolean r102 = this.f32250k.add(r100);     // Catch: Throwable -> L12
        this.f32251l = r102;     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    }

    public void b(boolean r100) {
        this.f32247h = r100;
    }

    public void c(boolean r100) {
        this.f32249j = r100;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public void setData(String r100) {
        super.setData(r100);
        this.f32251l = true;
    }

    public void a(boolean r100) {
        this.f32248i = r100;
    }

    public void a(boolean r100, int r101, int r102, int r103) {
        this.f32243d = r100;
        this.f32244e = r101;
        this.f32245f = r102;
        this.f32246g = r103;
    }
}
