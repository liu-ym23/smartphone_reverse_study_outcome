package com.obric.autogui.net.ttnet.a.b;

import android.content.Context;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TTNTransferFailureHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.obric.autogui.net.ttnet.a.a {
    private static final String TAG = "TTN/ExpAnal/TrsFail";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f29213a = null;

    /* JADX INFO: compiled from: TTNTransferFailureHandler.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f29213a = new a(null);
    }

    public e() {
    }

    @Override // com.obric.autogui.net.ttnet.a.a
    public com.obric.autogui.net.ttnet.a.a.b a(Context r10, com.obric.autogui.net.ttnet.a.a.C0737a r11) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r11, "analyseCtx");
        Throwable r9 = r11.a();
        String r12 = r9.getClass().getSimpleName();
        if (com.obric.autogui.net.ttnet.a.a.a.a(r9) == false) goto L22;
        int r13 = com.obric.autogui.net.ttnet.a.a.a.c(r9);
        int r3 = com.obric.autogui.net.ttnet.a.a.a.b(r9);
        boolean r5 = false;
        if (400 > r13) goto L10;
        if (r13 >= 500) goto L10;
        r5 = true;
    L10:
        if (r5 == false) goto L14;
        Loog.INSTANCE.e(TAG, " - ClientFailure (th=" + r12 + ", c=" + r3 + ", s=" + r13 + ") -> FailedForBadRequest");
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.i, r9), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L14:
        if (r3 != (-192)) goto L17;
        Loog.INSTANCE.e(TAG, " - TimedOutErrCode (th=" + r12 + ", c=" + r3 + ", s=" + r13 + ") -> TimedOut");
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.g, r9), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L17:
        if (r13 != 0) goto L20;
        Loog.INSTANCE.e(TAG, " - StatusCodeNotObtained/H2Exception (th=" + r12 + ", c=" + r3 + ", s=" + r13 + ") -> FailedDuringTransfer");
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.h, r9), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L20:
        Loog.INSTANCE.e(TAG, " - TTNetFailure (th=" + r12 + ", c=" + r3 + ", s=" + r13 + ") -> RespondedError");
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.j, r9), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L22:
        Loog.INSTANCE.e(TAG, " - UnknownFailure (th=" + r12 + ") -> FailedDuringTransfer");
        return new com.obric.autogui.net.ttnet.a.a.b(com.obric.autogui.tools.api.net.c.h, r9, "NONTTN_" + r12);
    }
}
