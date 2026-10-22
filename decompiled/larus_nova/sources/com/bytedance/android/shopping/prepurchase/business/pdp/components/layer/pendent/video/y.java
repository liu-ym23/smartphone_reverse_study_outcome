package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import kotlin.Pair;

/* JADX INFO: loaded from: classes13.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f181586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f181587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f181588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f181589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f181590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f181591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Pair<Integer, Integer> f181592g;

    public y(boolean r100, String r101, String r102, int r103) {
        boolean r104 = true;
        if ((r103 & 2) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r104 = false;
    L9:
        if ((r103 & 8) == 0) goto L12;
        r101 = null;
    L12:
        if ((r103 & 16) == 0) goto L14;
        r102 = null;
    L14:
        this.f181586a = 0;
        this.f181587b = r100;
        this.f181588c = r104;
        this.f181589d = r101;
        this.f181590e = r102;
        this.f181591f = false;
        this.f181592g = null;
    }
}
