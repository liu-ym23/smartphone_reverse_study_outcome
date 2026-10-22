package com.bytedance.android.shopping.sku.inner.tracker;

import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f182975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f182976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PageFinder f182977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f182978d;

    public a(String r100, String r101, PageFinder r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "params");
        this.f182975a = r100;
        this.f182976b = r101;
        this.f182977c = r102;
        this.f182978d = r103;
    }
}
