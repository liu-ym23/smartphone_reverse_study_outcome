package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.graphics.Path;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pn0.f f79807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f79808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f79809d;

    @Override // com.bytedance.android.live.liveinteract.videotalk.utils.c
    public final Path b(int r110, int r111, int r112) {
        int r100 = this.f79807b.f529924d.size();
        if (r110 < 0) goto L17;
        if (r110 >= r100) goto L17;
        pn0.f r101 = this.f79807b;
        pn0.f.b r102 = r101.f529923c;
        int r103 = r102.f529929a;
        if (r103 > 0) goto L10;
        r103 = 0;
    L10:
        int r104 = r102.f529930b;
        if (r104 > 0) goto L14;
        r104 = 0;
    L14:
        pn0.f.c r105 = (pn0.f.c) ListProtector.get(r101.f529924d, r110);
        int r106 = ((r105.f529935c + r103) + this.f79808c) + r111;
        int r113 = ((r105.f529936d + r104) + this.f79809d) + r112;
        int r114 = r105.f529937e + r106;
        int r107 = r105.f529938f + r113;
        boolean r108 = gh0.b.f481244a;
        gh0.b.a("LayoutConfigV2", "[MultiLinkCommonClipStrategyV2] call getPathFromPosition: " + r110 + ", rect[" + r106 + ", " + r113 + ", " + r114 + ", " + r107 + "], seatItem[" + r105.f529935c + ", " + r105.f529936d + ", " + r105.f529937e + ", " + r105.f529938f + "], originOffset[" + r103 + ", " + r104 + ']', false);
        Path r115 = new Path();
        r115.addRect((float) r106, (float) r113, (float) r114, (float) r107, Path.Direction.CW);
        return r115;
    L17:
        return new Path();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.utils.c
    public final Path c(int r210, float r211, float r212) {
        int r100 = this.f79807b.f529924d.size();
        if (r210 < 0) goto L22;
        if (r210 >= r100) goto L22;
        pn0.f r101 = this.f79807b;
        pn0.f.b r102 = r101.f529923c;
        int r103 = r102.f529929a;
        if (r103 > 0) goto L10;
        r103 = 0;
    L10:
        int r104 = r102.f529930b;
        if (r104 > 0) goto L14;
        r104 = 0;
    L14:
        pn0.f.c r105 = (pn0.f.c) ListProtector.get(r101.f529924d, r210);
        int r106 = (r105.f529935c + r103) + this.f79808c;
        int r107 = (r105.f529936d + r104) + this.f79809d;
        int r110 = r105.f529937e + r106;
        int r111 = r105.f529938f + r107;
        boolean r112 = gh0.b.f481244a;
        gh0.b.a("LayoutConfigV2", "[MultiLinkCommonClipStrategyV2] call getPathFromPosition: " + r210 + ", rect[" + r106 + ", " + r107 + ", " + r110 + ", " + r111 + "], seatItem[" + r105.f529935c + ", " + r105.f529936d + ", " + r105.f529937e + ", " + r105.f529938f + "], originOffset[" + r103 + ", " + r104 + "], rx=" + r211 + ", ry=" + r212, false);
        Path r113 = new Path();
        if (r211 == 0.0f) goto L17;
    L19:
        r113.addRoundRect(r106, r107, r110, r111, r211, r212, Path.Direction.CW);
    L20:
        return r113;
    L17:
        if (r212 != 0.0f) goto L19;
        r113.addRect(r106, r107, r110, r111, Path.Direction.CW);
    L22:
        return new Path();
    }

    public h(int r100, int r101, int r102, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r103) {
        Intrinsics.checkNotNullParameter(r103, "layoutConfig");
        this.f79808c = 0;
        this.f79809d = r100;
        pn0.f r104 = r103.f75842d;
        if (r104 != null) goto L5;
        int r105 = x8.a.f562881a;
        x8.a.c("ttlive_link", new Exception("MultiLinkCommonClipStrategyV2 layoutConfigV2Result is null"), false);
        Pair r106 = ug0.b.a();
        ln0.a r107 = yg0.h.f567472a;
        this.f79807b = yg0.h.a(r103, new Triple(Integer.valueOf(r101), Integer.valueOf(r102), "init MultiLinkCommonClipStrategyV2#backup"), r106);
        return;
    L5:
        Intrinsics.checkNotNull(r104);
        this.f79807b = r104;
    }
}
