package com.baidu.platform.comapi.map.c0.e;

import android.util.Pair;
import android.view.MotionEvent;
import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.map.c0.d;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.baidu.platform.comapi.map.c0.a.C0664a f33198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.baidu.platform.comapi.map.c0.a.C0664a f33199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.baidu.platform.comapi.map.c0.a.C0664a f33200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MotionEvent f33201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f33202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f33203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f33204g;

    public interface a {
        boolean a(b r100);

        boolean a(b r100, MotionEvent r101);

        boolean b(b r100);
    }

    private void a() {
        this.f33202e.b();
        this.f33198a = null;
        this.f33199b = null;
        this.f33200c = null;
        this.f33204g = true;
        this.f33203f.b(this);
    }

    private void b() {
        this.f33202e.a();
        this.f33204g = false;
        this.f33203f.a(this);
    }

    public b(a r100) {
        this.f33202e = new d();
        this.f33204g = false;
        this.f33203f = r100;
    }

    private void a(MotionEvent r100) {
        this.f33202e.a(r100);
        Pair<com.baidu.platform.comapi.map.c0.a.d, com.baidu.platform.comapi.map.c0.a.d> r101 = this.f33202e.c();
        if (r100.getPointerCount() == 2) goto L5;
        return;
    L5:
        if (Math.abs(((com.baidu.platform.comapi.map.c0.a.d) r101.first).f33169a) <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
    L12:
        c(r100);
        this.f33203f.a(this, r100);
        return;
    L7:
        if (Math.abs(((com.baidu.platform.comapi.map.c0.a.d) r101.first).f33170b) > AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        if (Math.abs(((com.baidu.platform.comapi.map.c0.a.d) r101.second).f33169a) > AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        if (Math.abs(((com.baidu.platform.comapi.map.c0.a.d) r101.second).f33170b) > AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
    }

    private void c(MotionEvent r100) {
        com.baidu.platform.comapi.map.c0.a.C0664a r101 = com.baidu.platform.comapi.map.c0.a.C0664a.a(r100);
        com.baidu.platform.comapi.map.c0.a.C0664a r102 = this.f33200c;
        if (r102 != null) goto L6;
        r102 = r101;
    L6:
        this.f33199b = r102;
        this.f33200c = r101;
        if (this.f33198a != null) goto L10;
        this.f33198a = r101;
        return;
    }

    public void b(MotionEvent r100) {
        this.f33201d = r100;
        int r101 = r100.getAction();
        if (r101 == 2) goto L18;
        if (r101 == 6) goto L15;
        if (r101 == 261) goto L12;
        if (r101 == 262) goto L15;
        return;
    L12:
        if (this.f33204g == true) goto L24;
        a();
        return;
    L24:
        return;
    L15:
        if (this.f33204g == false) goto L26;
        b();
        return;
    L26:
        return;
    L18:
        if (this.f33204g == false) goto L21;
        a(r100);
        return;
    L21:
        if (r100.getPointerCount() != 2) goto L29;
        a();
        return;
    }
}
