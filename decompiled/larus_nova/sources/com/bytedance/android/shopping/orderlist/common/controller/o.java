package com.bytedance.android.shopping.orderlist.common.controller;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f179738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f179739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f179740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f179741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f179742e;

    public o(String r100, String r101, String r102, String r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        Intrinsics.checkNotNullParameter(r104, "triggerParams");
        this.f179738a = r100;
        this.f179739b = r101;
        this.f179740c = r102;
        this.f179741d = r103;
        this.f179742e = r104;
    }
}
