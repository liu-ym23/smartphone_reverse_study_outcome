package com.bytedance.anniex.bd.foundation.impl;

import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f190146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f190147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f190148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f190149d;

    public l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rgba");
        Intrinsics.checkNotNullParameter(r100, "hex");
        if (com.bytedance.rts.foundation.r.g(r100, "#") == false) goto L6;
        r100 = com.bytedance.rts.foundation.r.e(r100, 1, r100.length());
    L6:
        if (r100.length() != 3) goto L9;
        r100 = com.bytedance.rts.foundation.j.g(com.bytedance.rts.foundation.j.h(com.bytedance.rts.foundation.r.f(r100, "", -1), BDAnnieXSLBaseColorKt$normalizeRgba$1.INSTANCE), "") + "ff";
    L14:
        IntCompanionObject r101 = IntCompanionObject.INSTANCE;
        int r102 = 0;
        Integer r103 = com.bytedance.rts.foundation.k.a(r101, com.bytedance.rts.foundation.r.e(r100, 0, 2), 16);
        if (r103 == null) goto L17;
        int r104 = r103.intValue();
    L18:
        this.f190146a = r104;
        Integer r105 = com.bytedance.rts.foundation.k.a(r101, com.bytedance.rts.foundation.r.e(r100, 2, 4), 16);
        if (r105 == null) goto L21;
        int r106 = r105.intValue();
    L22:
        this.f190147b = r106;
        Integer r107 = com.bytedance.rts.foundation.k.a(r101, com.bytedance.rts.foundation.r.e(r100, 4, 6), 16);
        if (r107 == null) goto L25;
        r102 = r107.intValue();
    L25:
        this.f190148c = r102;
        Integer r108 = com.bytedance.rts.foundation.k.a(r101, com.bytedance.rts.foundation.r.e(r100, 6, 8), 16);
        if (r108 == null) goto L28;
        int r109 = r108.intValue();
    L29:
        this.f190149d = r109;
        return;
    L28:
        r109 = 255;
        goto L29
    L21:
        r106 = 0;
        goto L22
    L17:
        r104 = 0;
        goto L18
    L9:
        if (r100.length() != 4) goto L12;
        r100 = com.bytedance.rts.foundation.j.g(com.bytedance.rts.foundation.j.h(com.bytedance.rts.foundation.r.f(r100, "", -1), BDAnnieXSLBaseColorKt$normalizeRgba$2.INSTANCE), "");
        goto L14
    L12:
        if (r100.length() != 6) goto L14;
        r100 = r100.concat("ff");
        goto L14
    }

    public l(int r100, int r101, int r102, int r103) {
        this.f190146a = r100;
        this.f190147b = r101;
        this.f190148c = r102;
        this.f190149d = r103;
    }
}
