package com.amap.api.mapcore.util;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes28.dex */
public class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f28273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f28274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f28275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f28276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f28277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f28278f;

    public w2(int r100, int[] r101, String r102, String r103, String r104) {
        this.f28273a = r100;
        this.f28274b = r101;
        this.f28277e = r102;
        this.f28278f = r103;
        if (TextUtils.isEmpty(r102) == false) goto L5;
        r102 = r103;
    L5:
        this.f28275c = -1000;
        if ("regions".equals(r102) == false) goto L9;
        this.f28275c = 1001;
    L23:
        this.f28276d = (r100 * 1000) + r101.hashCode();
        return;
    L9:
        if ("water".equals(r102) == false) goto L12;
        this.f28275c = 1002;
        goto L23
    L12:
        if ("buildings".equals(r102) == false) goto L15;
        this.f28275c = 1003;
        goto L23
    L15:
        if ("roads".equals(r102) == false) goto L18;
        this.f28275c = 1004;
        goto L23
    L18:
        if ("labels".equals(r102) == false) goto L21;
        this.f28275c = 1005;
        goto L23
    L21:
        if ("borders".equals(r102) == false) goto L23;
        this.f28275c = 1006;
        goto L23
    }
}
