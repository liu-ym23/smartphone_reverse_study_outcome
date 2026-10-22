package com.bytedance.android.annie.service.network;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedHashMap<String, String> f39898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f39899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f39900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinkedHashMap<String, File> f39901e;

    public g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f39897a = r100;
    }
}
