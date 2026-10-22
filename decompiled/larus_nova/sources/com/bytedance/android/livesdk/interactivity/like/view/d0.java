package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f137920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f137921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f137922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f137923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f137924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f137925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f137926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f137927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f137928i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f137929j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f137930k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f137931l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f137932m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f137933n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TimeInterpolator f137934o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f137935p;

    public d0(int r100, int r101, float r102, float r110, float r111, TimeInterpolator r112, TimeInterpolator r113, TimeInterpolator r114, int r115) {
        if ((r115 & 1) == 0) goto L6;
        r100 = g.f137939a;
    L6:
        if ((r115 & 2) == 0) goto L9;
        r101 = g.f137939a;
    L9:
        if ((r115 & 4) == 0) goto L12;
        r102 = 0.6f;
    L12:
        if ((r115 & 8) == 0) goto L14;
        float r103 = 1.0f;
    L16:
        if ((r115 & 16) == 0) goto L19;
        r110 = 0.0f;
    L19:
        if ((r115 & 32) == 0) goto L22;
        r111 = 0.0f;
    L22:
        if ((r115 & 64) == 0) goto L25;
        r112 = new AccelerateDecelerateInterpolator();
    L25:
        if ((r115 & 128) == 0) goto L27;
        r113 = new AccelerateDecelerateInterpolator();
    L27:
        int r104 = 0;
        if ((r115 & 256) == 0) goto L30;
        int r105 = g.f137940b;
    L32:
        if ((r115 & 512) == 0) goto L35;
        r104 = g.f137940b;
    L35:
        if ((r115 & 16384) == 0) goto L38;
        r114 = new AccelerateDecelerateInterpolator();
    L38:
        if ((r115 & 32768) == 0) goto L40;
        long r106 = 1000;
    L41:
        Intrinsics.checkNotNullParameter(r112, "avatarPathInterpolator");
        Intrinsics.checkNotNullParameter(r113, "avatarAlphaInterpolator");
        Intrinsics.checkNotNullParameter(r114, "normalPathInterpolator");
        this.f137920a = r100;
        this.f137921b = r101;
        this.f137922c = r102;
        this.f137923d = r103;
        this.f137924e = r110;
        this.f137925f = r111;
        this.f137926g = r112;
        this.f137927h = r113;
        this.f137928i = r105;
        this.f137929j = r104;
        this.f137930k = 0.0f;
        this.f137931l = 0.0f;
        this.f137932m = 0.0f;
        this.f137933n = 0.0f;
        this.f137934o = r114;
        this.f137935p = r106;
        return;
    L40:
        r106 = 0;
        goto L41
    L30:
        r105 = 0;
        goto L32
    L14:
        r103 = 0.0f;
        goto L16
    }
}
