package com.obric.autogui.util.f;

import android.app.Application;
import android.content.Context;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.IAutoActionLoggingApi;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

/* JADX INFO: compiled from: ZipForLogcat.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "ZipExample";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31549a = null;

    static {
        f31549a = new a();
    }

    private a() {
    }

    public final File a(String r9, File r10) {
        o.e(r9, "sourceDir");
        o.e(r10, "targetDir");
        String r2 = "compressed_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Long.valueOf(System.currentTimeMillis())) + ".zip";
        List<String> r0 = p.b(new String[]{((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir().getAbsolutePath() + "/ologs", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir().getAbsolutePath() + "/olog_cache"});     // Catch: Exception -> L14
        b();     // Catch: Throwable -> L6
        Thread.sleep(1000);     // Catch: Throwable -> L6
    L9:
        if (b.f31550a.a(r9, r2, r10, r0) == false) goto L12;
        Loog.INSTANCE.d(TAG, "文件夹压缩成功: " + r10 + " /// " + r2);     // Catch: Exception -> L14
        return new File(r10, r2);
    L12:
        Loog.INSTANCE.e(TAG, "文件夹压缩失败");     // Catch: Exception -> L14
        return null;
    L6:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "triggerLogFlush 失败 ", th);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "压缩过程中发生错误: " + e.getMessage());
        e.printStackTrace();
        return null;
    }

    private final Application a() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r2, "null cannot be cast to non-null type android.app.Application");
        return (Application) ZeusTransformUtils.preCheckCast(r2, Application.class, "com.obric.aiagent.plugin");
    }

    private final void b() {
        IAutoActionLoggingApi r2 = (IAutoActionLoggingApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionLoggingApi.class), IAutoActionLoggingApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.triggerLogFlush();
        return;
    }
}
