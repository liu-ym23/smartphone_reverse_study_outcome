package com.obric.autogui.net.ttnet.a.b;

import android.content.Context;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.tools.api.net.IAutoActionNetStatusApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TTNNetAvailabilityCheckHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.obric.autogui.net.ttnet.a.a {
    private static final String TAG = "TTN/ExpAnal/NetAvail";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f29210a = null;

    /* JADX INFO: compiled from: TTNNetAvailabilityCheckHandler.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f29210a = new a(null);
    }

    public b() {
    }

    @Override // com.obric.autogui.net.ttnet.a.a
    public com.obric.autogui.net.ttnet.a.a.b a(Context r5, com.obric.autogui.net.ttnet.a.a.C0737a r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        o.e(r6, "analyseCtx");
        Throwable r7 = r6.a();
        if (ZeusTransformUtils.instanceOf(r7, com.bytedance.frameworks.baselib.network.http.c.e.class) == false) goto L7;
        Loog.INSTANCE.e(TAG, " - NetworkNotAvailableException -> NetNotAvailable");
        return new com.obric.autogui.net.ttnet.a.a.b(com.obric.autogui.tools.api.net.c.f31484c, (Throwable) ZeusTransformUtils.preCheckCast((com.bytedance.frameworks.baselib.network.http.c.e) ZeusTransformUtils.preCheckCast(r7, com.bytedance.frameworks.baselib.network.http.c.e.class, "com.obric.aiagent.plugin"), Throwable.class, "com.obric.aiagent.plugin"), "NetworkNotAvailableException");
    L7:
        if (com.obric.autogui.net.ttnet.a.a.a.a(r7) == false) goto L17;
        IAutoActionNetStatusApi r8 = (IAutoActionNetStatusApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionNetStatusApi.class), IAutoActionNetStatusApi.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (r8 != null) goto L11;
    L13:
        r2 = false;
    L14:
        if (r2 == true) goto L19;
        Loog.INSTANCE.e(TAG, " - CronetIOException -> NetStatusApiGivesError (" + com.obric.autogui.net.ttnet.a.a.a.b(r7) + ')');
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.f31484c, r7), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L19:
        return null;
    L11:
        if (r8.isInternetConnected(r4) != true) goto L13;
    L17:
        return null;
    }
}
