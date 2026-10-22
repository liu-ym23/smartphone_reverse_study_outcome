package com.bytedance.android.ecom.arch.slice.render;

/* JADX INFO: loaded from: classes44.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f50673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ISlcElement f50674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f50675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f50676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f50677e;

    public j() {
        this(null, null, null, 2047);
    }

    public j(r r100, SlcElement r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 64) == 0) goto L11;
        r102 = null;
    L11:
        this.f50673a = r100;
        this.f50674b = r101;
        this.f50675c = r102;
        this.f50676d = false;
        this.f50677e = null;
    }
}
