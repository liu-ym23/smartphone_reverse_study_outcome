package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import com.lynx.tasm.TemplateBundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f35136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, TemplateBundle> f35137b = null;

    static {
        f35136a = MapsKt.mapOf(new Pair[]{TuplesKt.to("/doubao-apps-framework.template.js", "apps_sdk/doubao-apps-framework.template.js"), TuplesKt.to("/doubao-apps-react.template.js", "apps_sdk/doubao-apps-react.template.js"), TuplesKt.to("/doubao-apps-react-dev.template.js", "apps_sdk/doubao-apps-react-dev.template.js"), TuplesKt.to("/doubao-apps-api.template.js", "apps_sdk/doubao-apps-api.template.js")});
        f35137b = new ConcurrentHashMap();
    }

    public static TemplateBundle a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "assetPath");
        ConcurrentHashMap<String, TemplateBundle> r102 = f35137b;
        TemplateBundle r103 = r102.get(r101);
        if (r103 != null) goto L25;
        InputStream r104 = r100.getAssets().open(r101);
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L19
        byte[] r105 = ByteStreamsKt.readBytes(r104);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r104, null);
        r103 = TemplateBundle.b(r105);
        if (r103 == null) goto L11;
        boolean r106 = true;
        if (r103.i() != true) goto L11;
    L12:
        if (r106 == false) goto L18;
        TemplateBundle r107 = r102.putIfAbsent(r101, r103);
        if (r107 == null) goto L25;
        r103 = r107;
        goto L25
    L18:
        throw new IllegalStateException("invalid builtin lynx template: ".concat(r101));
    L11:
        r106 = false;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    L25:
        return r103;
    }
}
