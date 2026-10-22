package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f113655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f113656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f113657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f113658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f113659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f113660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f113661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AudienceResolutionType f113662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c8 f113663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f113664j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f113665k;

    public static final class a {
    }

    static {
    }

    public final AudienceResolutionType getType() {
        return this.f113662h;
    }

    public l5(String r100, String r101, int r102, String r103, boolean r104, String r110, c8 r111, String r112, int r113) {
        String r105 = "";
        if ((r113 & 32) == 0) goto L6;
        r110 = "";
    L6:
        if ((r113 & 64) == 0) goto L8;
        AudienceResolutionType r106 = AudienceResolutionType.normal;
    L10:
        if ((r113 & 128) == 0) goto L13;
        r111 = new c8(false, false);
    L13:
        if ((r113 & 256) == 0) goto L16;
        r112 = "";
    L16:
        if ((r113 & 512) != 0) goto L19;
        r105 = null;
    L19:
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "subname");
        Intrinsics.checkNotNullParameter(r103, "status");
        Intrinsics.checkNotNullParameter(r110, "sdkKey");
        Intrinsics.checkNotNullParameter(r106, "type");
        Intrinsics.checkNotNullParameter(r111, "paidInfo");
        Intrinsics.checkNotNullParameter(r112, "resolutionKey");
        Intrinsics.checkNotNullParameter(r105, "bottomDesc");
        this.f113656b = r100;
        this.f113657c = r101;
        this.f113658d = r102;
        this.f113659e = r103;
        this.f113660f = r104;
        this.f113661g = r110;
        this.f113662h = r106;
        this.f113663i = r111;
        this.f113664j = r112;
        this.f113665k = r105;
        return;
    L8:
        r106 = null;
        goto L10
    }
}
