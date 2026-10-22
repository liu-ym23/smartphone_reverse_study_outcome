package com.bytedance.android.livesdk.vscore_api.paidlive.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f159472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f159473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f159474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f159475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f159476e;

    public /* synthetic */ a(long r110, String r111, String r112, String r113, boolean r114, int r115) {
        if ((r115 & 8) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r115 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r115 & 32) == 0) goto L13;
        boolean r102 = false;
    L14:
        this(r110, r111, r112, r100, r101, r102);
        return;
    L13:
        r102 = r114;
        goto L14
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public a(long r100, String r101, String r102, String r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "ticketOwnerId");
        Intrinsics.checkNotNullParameter(r102, "jumpUrl");
        Intrinsics.checkNotNullParameter(r103, "ticketTypeStr");
        this.f159472a = r100;
        this.f159473b = r101;
        this.f159474c = r102;
        this.f159475d = r104;
        this.f159476e = r105;
    }
}
