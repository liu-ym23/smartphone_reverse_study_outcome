package com.bytedance.anniex.bd.foundation.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f190158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f190159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f190160c;

    public v(String r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Intrinsics.checkNotNullParameter(r101, "relativePath");
        Intrinsics.checkNotNullParameter(r102, "queryMap");
        this.f190158a = "";
        this.f190159b = "";
        this.f190158a = r100;
        this.f190159b = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f190160c = r102;
    }
}
