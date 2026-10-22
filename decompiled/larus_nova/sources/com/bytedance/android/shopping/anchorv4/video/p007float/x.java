package com.bytedance.android.shopping.anchorv4.video.p007float;

import kotlin.Pair;

/* JADX INFO: loaded from: classes12.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f167659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f167660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f167661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f167662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f167663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f167664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Pair<Integer, Integer> f167665g;

    public x(boolean r100, String r101, String r102, int r103) {
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
        this.f167659a = 0;
        this.f167660b = r100;
        this.f167661c = r104;
        this.f167662d = r101;
        this.f167663e = r102;
        this.f167664f = false;
        this.f167665g = null;
    }
}
