package com.obric.autogui.net.ttnet.a.b;

import android.content.Context;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TTNServiceReachabilityHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.obric.autogui.net.ttnet.a.a {
    private static final String TAG = "TTN/ExpAnal/ServReach";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f29212a = null;

    /* JADX INFO: compiled from: TTNServiceReachabilityHandler.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f29212a = new a(null);
    }

    public d() {
    }

    @Override // com.obric.autogui.net.ttnet.a.a
    public com.obric.autogui.net.ttnet.a.a.b a(Context r6, com.obric.autogui.net.ttnet.a.a.C0737a r7) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r7, "analyseCtx");
        Throwable r5 = r7.a();
        if (com.obric.autogui.net.ttnet.a.a.a.a(r5) == false) goto L16;
        int r8 = com.obric.autogui.net.ttnet.a.a.a.b(r5);
        if (r8 != (-200)) goto L9;
        Loog.INSTANCE.e(TAG, " - CertNameInvalid (errCode=" + r8 + ") -> AddUnreachable");
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.f, r5), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L9:
        if (r8 != (-109)) goto L13;
        Loog.INSTANCE.e(TAG, " - CronetIOException (errCode=" + r8 + ") -> AddUnreachable");
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.f, r5), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L13:
        if (r8 != (-102)) goto L18;
        Loog.INSTANCE.e(TAG, " - CronetIOException (errCode=" + r8 + ") -> AddUnreachable");
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.f, r5), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L18:
        return null;
    L16:
        return null;
    }
}
