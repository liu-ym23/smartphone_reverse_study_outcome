package com.bytedance.android.ecom.arch.slice.render;

/* JADX INFO: loaded from: classes44.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f50682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SlcElement f50683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f50684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f50685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f50686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f50687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f50688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f50689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f50690i;

    public /* synthetic */ o(r r110, SlcElement r111, boolean r112, String r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r r100 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        SlcElement r101 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r114 & 64) == 0) goto L17;
        String r115 = null;
    L18:
        this(r100, r101, r102, 0, 0, null, r115, null, null);
        return;
    L17:
        r115 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public o(r r100, SlcElement r101, boolean r102, long r103, int r104, String r105, String r106, String r107, String r110) {
        this.f50682a = r100;
        this.f50683b = r101;
        this.f50684c = r102;
        this.f50685d = r103;
        this.f50686e = r104;
        this.f50687f = r105;
        this.f50688g = r106;
        this.f50689h = r107;
        this.f50690i = r110;
    }
}
