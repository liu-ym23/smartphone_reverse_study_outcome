package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: classes10.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f145342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f145343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f145344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f145345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f145346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f145347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f145348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f145349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f145350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f145351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f145352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f145353l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f145354m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f145355n;

    public v() {
        this.f145342a = s1.y();
        this.f145343b = s1.f(15.0f);
        int r100 = s1.f(16.0f);
        int r101 = s1.f(56.0f);
        this.f145344c = r101;
        int r102 = r101 - r100;
        this.f145345d = r102;
        this.f145346e = s1.f(5.0f);
        this.f145347f = r102 + s1.f(5.0f);
        this.f145348g = 58;
        this.f145349h = 90;
        this.f145351j = 1180;
        this.f145352k = 4720;
        this.f145353l = 5900;
        s1.f(7.0f);
    }

    public final int a(float r100, int r101) {
        float r102 = r100 - this.f145344c;
        int r103 = this.f145349h;
        if (r101 < r103) goto L5;
        int r104 = this.f145346e;
    L13:
        return (int) (r104 + r102);
    L5:
        int r105 = this.f145348g;
        if (r101 != r105) goto L9;
        int r106 = this.f145346e;
        int r107 = this.f145345d;
    L8:
        r104 = r106 + r107;
        goto L13
    L9:
        if (r101 >= r105) goto L11;
        r104 = this.f145347f;
        goto L13
    L11:
        r106 = (int) (this.f145350i * (r103 - r101));
        r107 = this.f145346e;
        goto L8
    }
}
