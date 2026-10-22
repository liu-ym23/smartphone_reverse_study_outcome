package com.bytedance.android.shopping.orderlist.common.controller;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f179756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f179757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f179758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f179759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f179760e;

    public w(float r100, String r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r103, "renderNodeKey");
        this.f179758c = r100;
        this.f179759d = r101;
        this.f179760e = r103;
        this.f179756a = r102;
        this.f179757b = true;
    }
}
