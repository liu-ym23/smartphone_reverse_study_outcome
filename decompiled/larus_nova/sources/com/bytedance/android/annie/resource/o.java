package com.bytedance.android.annie.resource;

import android.webkit.WebResourceResponse;
import com.bytedance.forest.model.ResourceFrom2;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.pollyfill.ttnet.ForestNetAPI;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import java.io.InputStream;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o extends com.bytedance.android.annie.service.resource.i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Response f39804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public transient CloseableReference<CloseableBitmap> f39805j;

    @Override // com.bytedance.android.annie.service.resource.i
    public final byte[] a() {
        return this.f39804i.j();
    }

    @Override // com.bytedance.android.annie.service.resource.i
    public final CloseableReference<CloseableBitmap> b() {
        if (this.f39805j != null) goto L6;
        this.f39805j = this.f39804i.f();
    L6:
        return this.f39805j;
    }

    @Override // com.bytedance.android.annie.service.resource.i
    public final InputStream c() {
        return this.f39804i.l();
    }

    @Override // com.bytedance.android.annie.service.resource.i
    public final Map<String, Long> d() {
        return this.f39804i.f244301c;
    }

    @Override // com.bytedance.android.annie.service.resource.i
    public final WebResourceResponse e() {
        return this.f39804i.m();
    }

    public o(Response r100) {
        Intrinsics.checkNotNullParameter(r100, "realResponse");
        boolean r101 = r100.f244316r;
        this.f39804i = r100;
        this.f40042e = r100.f244299a;
        if (r100.f244316r == true) goto L5;
        String r102 = r100.f244317s.toString();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f40039b = r102;
    L5:
        this.f40038a = r100.f244318t;
        if (r100.f244309k == false) goto L9;
        String r103 = "preloaded";
    L12:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f40040c = r103;
        if (Intrinsics.areEqual(r103, "preloaded") == false) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L21;
        ResourceFrom2 r105 = r100.f244320v;
        if (r105 != ResourceFrom2.MEMORY) goto L20;
        String r106 = Response.h(r100.f244322x);
    L22:
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f40041d = r106;
        this.f40043f = r100.B;
        this.f39805j = r100.f();
        ForestNetAPI.HttpResponse r107 = r100.f244303e;
        Map<String, String> r108 = null;
        if (r107 == null) goto L25;
        Integer r109 = Integer.valueOf(r107.f244420a);
    L26:
        this.f40044g = r109;
        if (r107 == null) goto L29;
        r108 = r107.f244422c;
    L29:
        this.f40045h = r108;
        return;
    L25:
        r109 = null;
        goto L26
    L20:
        r106 = Response.h(r105);
        goto L22
    L21:
        r106 = Response.h(r100.f244320v);
        goto L22
    L15:
        r104 = Intrinsics.areEqual(r103, "request_reuse");
        goto L16
    L9:
        if (r100.f244310l == false) goto L11;
        r103 = "request_reuse";
        goto L12
    L11:
        r103 = Response.h(r100.f244320v);
        goto L12
    }
}
