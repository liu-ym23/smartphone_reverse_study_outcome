package com.bytedance.android.live.revenuelink.rtc;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f91955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f91956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f91957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f91958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f91959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f91960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f91961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f91962h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Pair<Integer, Integer> f91963i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f91964j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f91965k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f91966l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f91967m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f91968n;

    public static final class a {
    }

    static {
    }

    public o() {
        throw null;
    }

    public final int a() {
        Integer r100 = this.f91968n;
        if (r100 != null) goto L5;
        return 0;
    L5:
        if ((r100.intValue() & 1) == 1) goto L11;
        return 2;
    L11:
        return 1;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("RtcUser{");
        r100.append(this.f91956b);
        r100.append(",");
        boolean r101 = true;
        if (this.f91957c == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r100.append("NoFirstFrame,");
    L12:
        if ((!Intrinsics.areEqual(this.f91966l, Boolean.TRUE)) == false) goto L15;
        r100.append("renderVideo=" + this.f91966l + ',');
    L15:
        if (this.f91959e == false) goto L18;
        r100.append("remoteVideoMute,");
    L18:
        if (this.f91960f == false) goto L21;
        r100.append("remoteAudioMute,");
    L21:
        if (this.f91961g == false) goto L29;
        r100.append("audioMuteBySelf,");
        if (this.f91955a.length() > 0) goto L26;
        r101 = false;
    L26:
        if (r101 == false) goto L29;
        r100.append("audioMuteReason=" + this.f91955a + ',');
    L29:
        if (this.f91962h == false) goto L32;
        r100.append("videoMuteBySelf,");
    L32:
        if (this.f91967m == false) goto L35;
        r100.append("mutePlayVolume,");
    L35:
        if (this.f91964j == false) goto L37;
        r100.append("chorusMuteBySelf,");
    L37:
        r100.append("videoSize=");
        r100.append(this.f91963i);
        r100.append(com.alipay.sdk.m.u.i.f25855d);
        return r100.toString();
    L9:
        if (this.f91958d == true) goto L12;
        r100.append("FrameNotRender,");
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    public o(String r100, Object r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = false;
    L8:
        Intrinsics.checkNotNullParameter(r100, "linkMicId");
        this.f91956b = r100;
        this.f91957c = r101;
        this.f91958d = r102;
        this.f91959e = false;
        this.f91960f = false;
        this.f91961g = false;
        this.f91962h = false;
        this.f91963i = null;
        this.f91964j = false;
        this.f91965k = false;
        this.f91966l = null;
        this.f91967m = false;
        this.f91968n = null;
        this.f91955a = "";
    }
}
