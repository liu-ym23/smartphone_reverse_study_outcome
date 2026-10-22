package com.obric.autogui.net.ttnet.b;

import android.util.Pair;
import com.bytedance.article.common.network.ICommonApi;
import com.bytedance.common.utility.g;
import com.bytedance.retrofit2.e.j;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: OAutoHttpClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29231a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f29232b = null;

    /* JADX INFO: compiled from: OAutoHttpClient.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public e() {
    }

    static {
        f29231a = new a(null);
        f29232b = new byte[0];
    }

    public final com.bytedance.retrofit2.e<String> a(Map<String, String> r3, String r4, String r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r6, "requestHeaders");
        o.e(r5, "url");
        if (r4 == null) goto L6;
        byte[] r7 = r4.getBytes(d.o.d.f38623b);
        o.c(r7, "getBytes(...)");
        if (r7 == null) goto L6;
    L8:
        return a(r5, r7, r6, new g.a());
    L6:
        r7 = f29232b;
        goto L8
    }

    private final com.bytedance.retrofit2.e<String> a(String r10, byte[] r11, Map<String, String> r12, g.a r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        Pair<String, String> r15 = c.a(r10);     // Catch: Exception -> L12
        Object r2 = r15.first;     // Catch: Exception -> L12
        o.a(r2, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L12
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        Object r16 = r15.second;     // Catch: Exception -> L12
        o.a(r16, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L12
        String r5 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        Object r9 = com.bytedance.ttnet.utils.d.a(r3, ICommonApi.class);     // Catch: Exception -> L12
        o.a(r9, "null cannot be cast to non-null type com.bytedance.article.common.network.ICommonApi");     // Catch: Exception -> L12
        ICommonApi r4 = (ICommonApi) ZeusTransformUtils.preCheckCast(r9, ICommonApi.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        String r17 = null;
        if (r14 == null) goto L6;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r14.get(DownloadHelper.CONTENT_TYPE), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        r14.remove(DownloadHelper.CONTENT_TYPE);     // Catch: Exception -> L12
        r17 = r18;
    L6:
        List<com.bytedance.retrofit2.b.b> r7 = c.a(r14);     // Catch: Exception -> L12
        if (r13 == null) goto L9;
        boolean r8 = r13.f6725a;     // Catch: Exception -> L12
    L10:
        com.bytedance.retrofit2.e<String> r19 = r4.postData(-1, r5, (j) ZeusTransformUtils.preCheckCast(new com.bytedance.retrofit2.e.g(r17, r11, new String[0]), j.class, "com.obric.aiagent.plugin"), r7, r8);     // Catch: Exception -> L12
        o.c(r19, "postData(...)");     // Catch: Exception -> L12
        return r19;
    L9:
        r8 = false;
    L12:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, com.bytedance.frameworks.baselib.network.http.c.d.class) == true) goto L22;
        if (ZeusTransformUtils.instanceOf(e, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == true) goto L18;
        Loog.INSTANCE.e("CNC", "unhandled TTNet Exception: " + e.getClass(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw new b(0, 0, e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L18:
        throw new b(((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(e, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).c(), ((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(e, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).d(), e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L22:
        throw new b(((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(e, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a(), 0, e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
