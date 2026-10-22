package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements w91.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TabAnimDelegate f100045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w91.f f100046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w91.c.a f100047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w91.f f100048d;

    @Override // w91.c.a
    public final void a() {
        String r100 = this.f100045a.f100032a;
        StringBuilder r101 = new StringBuilder("onEnterEnd：");
        w91.f r102 = this.f100048d;
        if (r102 == null) goto L5;
        w91.e r103 = e.c(r102);
    L6:
        r101.append(r103);
        ALogger.d(r100, r101.toString());
        this.f100047c.a();
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // w91.c.a
    public final void b() {
        String r100 = this.f100045a.f100032a;
        StringBuilder r101 = new StringBuilder("onExitStart：");
        w91.f r102 = this.f100046b;
        if (r102 == null) goto L5;
        w91.e r103 = e.c(r102);
    L6:
        r101.append(r103);
        ALogger.d(r100, r101.toString());
        this.f100047c.b();
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // w91.c.a
    public final void c() {
        String r100 = this.f100045a.f100032a;
        StringBuilder r101 = new StringBuilder("onExitEnd：");
        w91.f r102 = this.f100046b;
        if (r102 == null) goto L5;
        w91.e r103 = e.c(r102);
    L6:
        r101.append(r103);
        ALogger.d(r100, r101.toString());
        this.f100047c.c();
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // w91.c.a
    public final void d() {
        String r100 = this.f100045a.f100032a;
        StringBuilder r101 = new StringBuilder("onEnterStart：");
        w91.f r102 = this.f100048d;
        if (r102 == null) goto L5;
        w91.e r103 = e.c(r102);
    L6:
        r101.append(r103);
        ALogger.d(r100, r101.toString());
        this.f100047c.d();
        return;
    L5:
        r103 = null;
        goto L6
    }

    public f(TabAnimDelegate r100, w91.f r101, d r102, w91.f r103) {
        this.f100045a = r100;
        this.f100046b = r101;
        this.f100047c = r102;
        this.f100048d = r103;
    }
}
