package com.obric.autogui.net.ttnet.a.b;

import android.content.Context;
import com.obric.autogui.common.api.logging.Loog;
import com.ttnet.org.chromium.net.urlconnection.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: TTNExceptionPreCheckHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.autogui.net.ttnet.a.a {
    private static final String TAG = "TTN/ExpAnal/Cancelled";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0738a f29209a = null;

    /* JADX INFO: renamed from: com.obric.autogui.net.ttnet.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTNExceptionPreCheckHandler.kt */
    private static final class C0738a {
        public /* synthetic */ C0738a(h r1) {
            this();
        }

        private C0738a() {
        }
    }

    static {
        f29209a = new C0738a(null);
    }

    public a() {
    }

    @Override // com.obric.autogui.net.ttnet.a.a
    public com.obric.autogui.net.ttnet.a.a.b a(Context r8, com.obric.autogui.net.ttnet.a.a.C0737a r9) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r9, "analyseCtx");
        Throwable r3 = r9.a();
        if (ZeusTransformUtils.instanceOf(r3, CancellationException.class) == false) goto L7;
        Loog.INSTANCE.e(TAG, " - CancellationException -> Cancelled");
        return new com.obric.autogui.net.ttnet.a.a.b(com.obric.autogui.tools.api.net.c.f31482a, (Throwable) ZeusTransformUtils.preCheckCast((CancellationException) ZeusTransformUtils.preCheckCast(r3, CancellationException.class, "com.obric.aiagent.plugin"), Throwable.class, "com.obric.aiagent.plugin"), "CANCELLED-Job");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.net.ttnet.a.c.class) == false) goto L11;
        Loog.INSTANCE.e(TAG, " - TTNetInvalidStateException -> ApiError");
        return new com.obric.autogui.net.ttnet.a.a.b(com.obric.autogui.tools.api.net.c.f31483b, r3, null, 4, null);
    L11:
        if (ZeusTransformUtils.instanceOf(r3, i.class) == false) goto L15;
        Loog.INSTANCE.e(TAG, " - TTRequestCanceledException -> UserCancelled");
        return new com.obric.autogui.net.ttnet.a.a.b(com.obric.autogui.tools.api.net.c.f31482a, (Throwable) ZeusTransformUtils.preCheckCast((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), Throwable.class, "com.obric.aiagent.plugin"), "CANCELLED");
    L15:
        if (com.obric.autogui.net.ttnet.a.a.a.a(r3) == true) goto L17;
        return null;
    L17:
        if (com.obric.autogui.net.ttnet.a.a.a.b(r3) != (-999)) goto L22;
        Loog.INSTANCE.e(TAG, " - TTNetErr -> UserCanceled (" + com.obric.autogui.net.ttnet.a.a.a.b(r3) + ')');
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.f31482a, r3), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L22:
        return null;
    }
}
