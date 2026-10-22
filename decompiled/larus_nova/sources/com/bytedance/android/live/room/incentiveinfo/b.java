package com.bytedance.android.live.room.incentiveinfo;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements u81.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u81.d f99621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u81.e.a f99622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u81.d f99623c;

    @Override // u81.e.a
    public final void a() {
        StringBuilder r100 = new StringBuilder("onEnterEnd：");
        u81.d r101 = this.f99623c;
        if (r101 == null) goto L5;
        w81.a r102 = x81.a.c(r101);
    L6:
        r100.append(r102);
        ALogger.d("CarouselAnimController", r100.toString());
        this.f99622b.a();
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // u81.e.a
    public final void b() {
        StringBuilder r100 = new StringBuilder("onExitStart：");
        u81.d r101 = this.f99621a;
        if (r101 == null) goto L5;
        w81.a r102 = x81.a.c(r101);
    L6:
        r100.append(r102);
        ALogger.d("CarouselAnimController", r100.toString());
        this.f99622b.b();
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // u81.e.a
    public final void c() {
        StringBuilder r100 = new StringBuilder("onExitEnd：");
        u81.d r101 = this.f99621a;
        if (r101 == null) goto L5;
        w81.a r102 = x81.a.c(r101);
    L6:
        r100.append(r102);
        ALogger.d("CarouselAnimController", r100.toString());
        this.f99622b.c();
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // u81.e.a
    public final void d() {
        StringBuilder r100 = new StringBuilder("onEnterStart：");
        u81.d r101 = this.f99623c;
        if (r101 == null) goto L5;
        w81.a r102 = x81.a.c(r101);
    L6:
        r100.append(r102);
        ALogger.d("CarouselAnimController", r100.toString());
        this.f99622b.d();
        return;
    L5:
        r102 = null;
        goto L6
    }

    public b(u81.d r100, f r101, u81.d r102) {
        this.f99621a = r100;
        this.f99622b = r101;
        this.f99623c = r102;
    }
}
