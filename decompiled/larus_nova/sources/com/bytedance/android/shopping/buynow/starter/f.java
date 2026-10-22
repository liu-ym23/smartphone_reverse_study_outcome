package com.bytedance.android.shopping.buynow.starter;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements nl.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.shopping.buynow.cache.a f171154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f171155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f171156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f171157d;

    public static final class a {
    }

    static {
    }

    @Override // nl.c
    public final String a() {
        JSONObject r100 = this.f171156c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    @Override // nl.c
    public final Map<String, String> b() {
        return this.f171155b;
    }

    @Override // nl.c
    public final nl.b getCacheKey() {
        return this.f171154a;
    }

    @Override // nl.c
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter("pass_through", "key");
        Map<String, String> r101 = this.f171155b;
        if (r101 == null) goto L6;
        String r102 = r101.remove("pass_through");
        return;
    }

    @Override // nl.c, com.bytedance.android.ec.model.abscontainer.ISchemaModel
    public final String getQueryParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "queryName");
        Map<String, String> r101 = this.f171155b;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public f(Map r100, JSONObject r101) {
        this.f171155b = r100;
        this.f171156c = r101;
        this.f171157d = null;
    }

    @Override // nl.c, com.bytedance.android.ec.model.abscontainer.ISchemaModel
    public final void replaceOrAppendParam(String r100, String r101) {
        Intrinsics.checkNotNullParameter("pass_through", "queryName");
        Intrinsics.checkNotNullParameter(r101, "value");
        Map<String, String> r102 = this.f171155b;
        if (r102 == null) goto L6;
        String r103 = r102.put("pass_through", r101);
        return;
    }
}
