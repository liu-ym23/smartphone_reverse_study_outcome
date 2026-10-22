package com.amap.api.mapcore.util;

import com.byted.cast.common.api.FirewallError;

/* JADX INFO: loaded from: classes28.dex */
public final class b6 extends v8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f27067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f27068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f27069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f27070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f27071f;

    @Override // com.amap.api.mapcore.util.v8
    public final int a() {
        return 320000;
    }

    @Override // com.amap.api.mapcore.util.v8
    public final boolean c() {
        if (this.f27069d == false) goto L8;
        if (this.f27071f > this.f27070e) goto L8;
        return true;
    L8:
        if (this.f27068c == true) goto L11;
        return false;
    L11:
        if (this.f27071f < this.f27070e) goto L13;
        return false;
    L13:
        long r100 = System.currentTimeMillis();
        if ((r100 - this.f27067b) >= FirewallError.FIREWALL_OK) goto L16;
        return false;
    L16:
        this.f27067b = r100;
        return true;
    }

    public final long d() {
        return this.f27071f;
    }

    public final void b(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f27071f += (long) r100;
    }

    public final void b(boolean r100) {
        this.f27069d = r100;
    }

    public b6(boolean r100, v8 r101, long r102, int r103) {
        super(r101);
        this.f27069d = false;
        this.f27068c = r100;
        this.f27071f = r102;
        this.f27070e = r103;
    }
}
