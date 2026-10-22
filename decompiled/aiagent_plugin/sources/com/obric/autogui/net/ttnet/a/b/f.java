package com.obric.autogui.net.ttnet.a.b;

import android.content.Context;
import com.bytedance.ttnet.TTNetInit;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TTNWeakConnectionCheckHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.obric.autogui.net.ttnet.a.a {
    private static final String TAG = "TTN/ExpAnal/WeakConn";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f29214a = null;

    /* JADX INFO: compiled from: TTNWeakConnectionCheckHandler.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f29214a = new a(null);
    }

    public f() {
    }

    @Override // com.obric.autogui.net.ttnet.a.a
    public com.obric.autogui.net.ttnet.a.a.b a(Context r3, com.obric.autogui.net.ttnet.a.a.C0737a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "analyseCtx");
        return a(r5, r4.a());
    }

    private final com.obric.autogui.net.ttnet.a.a.b a(Context r5, Throwable r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        int r7 = TTNetInit.getEffectiveConnectionType();
        if (r7 < 5) goto L7;
        return null;
    L7:
        if (r7 > 2) goto L10;
        Loog.INSTANCE.e(TAG, " - NQE_EffectiveConnType_" + r7 + " -> NetworkNotAvailable");
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.f31484c, r6), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L10:
        Loog.INSTANCE.e(TAG, " - NQE_EffectiveConnType_" + r7 + " -> WeakConnection");
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.f31486e, r6), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    }
}
