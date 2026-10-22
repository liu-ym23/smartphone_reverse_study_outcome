package com.baidu.platform.comapi.map.c0.f;

import android.util.Pair;
import android.view.MotionEvent;
import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.map.MapController;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes39.dex */
public class b implements com.baidu.platform.comapi.map.c0.e.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<com.baidu.platform.comapi.map.c0.a.C0664a> f33206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.baidu.platform.comapi.map.c0.d f33207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MapController f33208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f33209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f33210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f33211f;

    private boolean a() {
        this.f33209d = true;
        Iterator<com.baidu.platform.comapi.map.c0.a.C0664a> r100 = this.f33206a.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Double r101 = Double.valueOf(com.baidu.platform.comapi.map.c0.a.d.a(com.baidu.platform.comapi.map.c0.a.f33159a.c(), r100.next().c()));
        if (Math.abs(r101.doubleValue()) <= 45.0d) goto L4;
        if (Math.abs(r101.doubleValue()) >= 135.0d) goto L4;
        return false;
    L10:
        Pair<com.baidu.platform.comapi.map.c0.a.d, com.baidu.platform.comapi.map.c0.a.d> r102 = this.f33207b.c();
        com.baidu.platform.comapi.map.c0.a.d r103 = (com.baidu.platform.comapi.map.c0.a.d) r102.first;
        com.baidu.platform.comapi.map.c0.a.d r104 = (com.baidu.platform.comapi.map.c0.a.d) r102.second;
        if (Math.abs(r103.f33170b) > this.f33211f) goto L13;
    L15:
        boolean r105 = false;
    L16:
        com.baidu.platform.comapi.map.c0.a.C0664a r106 = this.f33206a.getFirst();
        com.baidu.platform.comapi.map.c0.a.C0664a r107 = this.f33206a.getLast();
        com.baidu.platform.comapi.map.c0.a.C0664a r108 = new com.baidu.platform.comapi.map.c0.a.C0664a(r107.f33162a, r106.f33162a);
        com.baidu.platform.comapi.map.c0.a.C0664a r109 = new com.baidu.platform.comapi.map.c0.a.C0664a(r107.f33163b, r106.f33163b);
        if (r103.f33170b > AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
    L21:
        com.baidu.platform.comapi.map.c0.a.d r110 = r108.c();
        com.baidu.platform.comapi.map.c0.a.C0664a r111 = com.baidu.platform.comapi.map.c0.a.f33160b;
        int r112 = (int) com.baidu.platform.comapi.map.c0.a.d.a(r110, r111.c());
        double r113 = com.baidu.platform.comapi.map.c0.a.d.a(r109.c(), r111.c());
    L22:
        int r114 = (int) r113;
        if (Math.abs(r112) < 40) goto L25;
    L27:
        boolean r115 = false;
    L28:
        if (r105 == false) goto L31;
        if (r115 == false) goto L31;
        return true;
    L31:
        return false;
    L25:
        if (Math.abs(r114) >= 40) goto L27;
        r115 = true;
        goto L28
    L19:
        if (r104.f33170b <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L21;
        com.baidu.platform.comapi.map.c0.a.d r116 = r108.c();
        com.baidu.platform.comapi.map.c0.a.C0664a r117 = com.baidu.platform.comapi.map.c0.a.f33161c;
        r112 = (int) com.baidu.platform.comapi.map.c0.a.d.a(r116, r117.c());
        r113 = com.baidu.platform.comapi.map.c0.a.d.a(r109.c(), r117.c());
        goto L22
    L13:
        if (Math.abs(r104.f33170b) <= this.f33211f) goto L15;
        r105 = true;
        goto L16
    }

    public b(MapController r100) {
        this.f33206a = new LinkedList();
        com.baidu.platform.comapi.map.c0.d r101 = new com.baidu.platform.comapi.map.c0.d();
        this.f33207b = r101;
        this.f33209d = false;
        this.f33208c = r100;
        this.f33211f = r101.f33192c / 3;
    }

    private void c(com.baidu.platform.comapi.map.c0.e.b r100) {
        if (this.f33208c.isOverlookGestureEnable() == false) goto L6;
        this.f33210e.a(r100, null);
        c r101 = new c(this.f33208c);
        this.f33210e = r101;
        r101.a(r100);
        return;
    }

    private void d(com.baidu.platform.comapi.map.c0.e.b r100) {
        if (this.f33206a.size() >= 5) goto L6;
        this.f33206a.addLast(r100.f33200c);
        this.f33207b.a(r100.f33201d);
        return;
    L6:
        if (this.f33209d == false) goto L8;
        return;
    L8:
        if (this.f33206a.size() == 5) goto L10;
        return;
    L10:
        if (a() == false) goto L16;
        c(r100);
        return;
    }

    @Override // com.baidu.platform.comapi.map.c0.e.b.a
    public boolean a(com.baidu.platform.comapi.map.c0.e.b r100) {
        Pair<com.baidu.platform.comapi.map.c0.a.d, com.baidu.platform.comapi.map.c0.a.d> r101 = this.f33207b.c();
        this.f33207b.a();
        this.f33210e.a(r100, r101);
        return true;
    }

    @Override // com.baidu.platform.comapi.map.c0.e.b.a
    public boolean b(com.baidu.platform.comapi.map.c0.e.b r100) {
        this.f33206a.clear();
        this.f33207b.b();
        this.f33210e = new d(this.f33208c);
        this.f33209d = false;
        return true;
    }

    @Override // com.baidu.platform.comapi.map.c0.e.b.a
    public boolean a(com.baidu.platform.comapi.map.c0.e.b r100, MotionEvent r101) {
        d(r100);
        if (this.f33206a.size() != 1) goto L5;
        this.f33210e.a(r100);
    L5:
        this.f33210e.a(r100, r101);
        return true;
    }
}
