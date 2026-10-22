package com.autonavi.extra;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<a> f30035a;

    public String a() {
        monitor-enter(b.class);
        StringBuffer r100 = new StringBuffer();     // Catch: Throwable -> L17
        Iterator<a> r101 = this.f30035a.iterator();     // Catch: Throwable -> L17
    L6:
        if (r101.hasNext() == false) goto L14;
        a r102 = r101.next();     // Catch: Throwable -> L17
        if (r102 == null) goto L6;
        String r103 = r102.a();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r103) == true) goto L6;
        r100.append(r103);     // Catch: Throwable -> L17
        if (r103.endsWith(i.f25853b) == true) goto L6;
        r100.append(i.f25853b);     // Catch: Throwable -> L17
        goto L6
    L14:
        String r104 = r100.toString();     // Catch: Throwable -> L17
        monitor-exit(b.class);     // Catch: Throwable -> L17
        return r104;
    L17:
        th = move-exception;
        throw th;
    }

    public void b() {
        monitor-enter(b.class);
        Iterator<a> r100 = this.f30035a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r100.hasNext() == false) goto L10;
        a r101 = r100.next();     // Catch: Throwable -> L13
        if (r101 == null) goto L6;
        r101.onDestroy();     // Catch: Throwable -> L13
        goto L6
    L10:
        this.f30035a.clear();     // Catch: Throwable -> L13
        monitor-exit(b.class);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f30035a = new ArrayList();
    }

    public Object a(String r100) {
        monitor-enter(b.class);
        Iterator<a> r101 = this.f30035a.iterator();     // Catch: Throwable -> L16
    L6:
        if (r101.hasNext() == false) goto L13;
        a r102 = r101.next();     // Catch: Throwable -> L16
        if (r102 == null) goto L6;
        Object r103 = r102.a(r100);     // Catch: Throwable -> L16
        if (r103 == null) goto L6;
        monitor-exit(b.class);     // Catch: Throwable -> L16
        return r103;
    L13:
        monitor-exit(b.class);     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    public void a(JSONObject r100) {
        monitor-enter(b.class);
        Iterator<a> r101 = this.f30035a.iterator();     // Catch: Throwable -> L12
    L6:
        if (r101.hasNext() == false) goto L10;
        a r102 = r101.next();     // Catch: Throwable -> L12
        if (r102 == null) goto L6;
        r102.a(r100);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(b.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void a(a r100) {
        monitor-enter(b.class);
        List<a> r101 = this.f30035a;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.add(null);     // Catch: Throwable -> L9
    L7:
        monitor-exit(b.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void a(IGLMapState r100, IMapConfig r101) {
        monitor-enter(b.class);
        Iterator<a> r102 = this.f30035a.iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        a r103 = r102.next();     // Catch: Throwable -> L12
        if (r103 == null) goto L6;
        r103.a(r100, r101);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(b.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void a(String r100, Object r101) {
        monitor-enter(b.class);
        Iterator<a> r102 = this.f30035a.iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        a r103 = r102.next();     // Catch: Throwable -> L12
        if (r103 == null) goto L6;
        r103.a(r100, r101);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(b.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void a(GL10 r100, EGLConfig r101) {
        monitor-enter(b.class);
        Iterator<a> r102 = this.f30035a.iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        a r103 = r102.next();     // Catch: Throwable -> L12
        if (r103 == null) goto L6;
        r103.onSurfaceCreated(r100, r101);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(b.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void a(Context r100, IAMapDelegate r101, boolean r102) {
        monitor-enter(b.class);
        Iterator<a> r103 = this.f30035a.iterator();     // Catch: Throwable -> L12
    L6:
        if (r103.hasNext() == false) goto L10;
        a r104 = r103.next();     // Catch: Throwable -> L12
        if (r104 == null) goto L6;
        r104.a(r100, r101, r102);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(b.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void a(GL10 r100, int r101, int r102) {
        monitor-enter(b.class);
        Iterator<a> r103 = this.f30035a.iterator();     // Catch: Throwable -> L12
    L6:
        if (r103.hasNext() == false) goto L10;
        a r104 = r103.next();     // Catch: Throwable -> L12
        if (r104 == null) goto L6;
        r104.onSurfaceChanged(r100, r101, r102);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(b.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
