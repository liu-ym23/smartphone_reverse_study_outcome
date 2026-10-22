package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class b extends h8a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f35135a;

    public static final class a {
    }

    static {
    }

    public abstract void d(String r100, e8a.a<h8a.b> r101);

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f35135a = r100;
    }

    public static LynxResourceResponse c(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        LynxResourceResponse r101 = LynxResourceResponse.a(r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<com.lynx.tasm.resourceprovider.template.TemplateProviderResult?>");
        return r101;
    }

    @Override // h8a.a
    public final void a(LynxResourceRequest r100, LynxTemplateRender.j r101) {
        LynxResourceResponse<byte[]> r102 = LynxResourceResponse.a(new UnsupportedOperationException("SSRData is not supported"));
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.ByteArray?>");
        r101.onResponse(r102);
    }

    @Override // h8a.a
    public final void b(LynxResourceRequest r100, e8a.a<h8a.b> r110) {
        String r101 = r100.f383704a;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        String r103 = null;
        if (r102 == false) goto L13;
        com.bytedance.ai.applet.base.log.a.b("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: requestUrl is empty", null);
        r110.onResponse(c(new IllegalArgumentException("template url is empty")));
        return;
    L13:
        com.bytedance.ai.applet.base.log.b r104 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: requestUrl = " + r101);
        Map<String, String> r105 = c.f35136a;
        if (r101 == null) goto L16;
        r103 = c.f35136a.get(r101);
    L16:
        if (r103 != null) goto L24;
        com.bytedance.ai.applet.base.log.a.c("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: requestUrl = " + r101 + ", assetPath = null");
        d(r101, r110);
        return;
    L24:
        com.bytedance.ai.applet.base.log.a.c("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: assetPath = ".concat(r103));     // Catch: Throwable -> L19
        long r106 = System.currentTimeMillis();     // Catch: Throwable -> L19
        TemplateBundle r107 = c.a(this.f35135a, r103);     // Catch: Throwable -> L19
        com.bytedance.ai.applet.base.log.a.c("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: assetPath = " + r103 + ", cost = " + (System.currentTimeMillis() - r106) + "ms");     // Catch: Throwable -> L19
        h8a.b r108 = new h8a.b();     // Catch: Throwable -> L19
        r108.f484296b = r107;     // Catch: Throwable -> L19
        r110.onResponse(LynxResourceResponse.b(r108));     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        com.bytedance.ai.applet.base.log.b r109 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("BuiltinAssetTemplateResourceFetcher", "fetchTemplate: assetPath = ".concat(r103), th);
        r110.onResponse(c(th));
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
