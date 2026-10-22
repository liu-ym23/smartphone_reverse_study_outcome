package com.obric.autogui.common.b;

import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.api.logging.IAutoActionLoggingApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LoggingConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f29001a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f29002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f29003c;

    static {
        f29001a = new b();
    }

    private b() {
    }

    public final boolean a() {
        return f29003c;
    }

    public final void b() {
        if (IAppContext.Companion.isDebug() == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        f29003c = r2;
        IAutoActionLoggingApi r3 = (IAutoActionLoggingApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionLoggingApi.class), IAutoActionLoggingApi.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L13;
        r3.reEvaluateLogPrintingPolicy();
        return;
    L13:
        return;
    L5:
        if (f29002b != 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void a(int r2) {
        f29002b = r2 | f29002b;
        b();
    }

    public final void b(int r2) {
        int r0 = f29002b;
        f29002b = (~r2) & r0;
        b();
    }
}
