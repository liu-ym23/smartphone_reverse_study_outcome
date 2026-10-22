package com.bytedance.android.shopping.buynow.starter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f171141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ma3.b f171142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f171143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f171144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f171145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f171146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f171147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f171148h;

    public d(String r100, String r101, ma3.b r102, boolean r103, Throwable r104, Integer r105, int r110, boolean r111, boolean r112, int r113) {
        if ((r113 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r113 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r113 & 8) == 0) goto L12;
        r103 = false;
    L12:
        if ((r113 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r113 & 64) == 0) goto L18;
        r110 = 0;
    L18:
        if ((r113 & 128) == 0) goto L21;
        r111 = false;
    L21:
        if ((r113 & 256) == 0) goto L23;
        r112 = false;
    L23:
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f171141a = r101;
        this.f171142b = r102;
        this.f171143c = r103;
        this.f171144d = r104;
        this.f171145e = r105;
        this.f171146f = r110;
        this.f171147g = r111;
        this.f171148h = r112;
    }
}
