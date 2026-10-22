package com.obric.autogui.net.ttnet.a.b;

import android.content.Context;
import com.google.gson.JsonObject;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TTNNetworkChangeCheckHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.obric.autogui.net.ttnet.a.a {
    private static final String TAG = "TTN/ExpAnal/NwChange";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f29211a = null;

    /* JADX INFO: compiled from: TTNNetworkChangeCheckHandler.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f29211a = new a(null);
    }

    public c() {
    }

    @Override // com.obric.autogui.net.ttnet.a.a
    public com.obric.autogui.net.ttnet.a.a.b a(Context r6, com.obric.autogui.net.ttnet.a.a.C0737a r7) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r7, "analyseCtx");
        Throwable r8 = r7.a();
        if (com.obric.autogui.net.ttnet.a.a.a.a(r8) == false) goto L16;
        int r0 = com.obric.autogui.net.ttnet.a.a.a.b(r8);
        if (r0 != (-106)) goto L7;
    L14:
        Loog.INSTANCE.e(TAG, " - CronetIOException (errCode=" + r0 + ") -> NetworkChanged");
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.f31485d, r8), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L7:
        if (r0 == (-21)) goto L14;
        if (r0 == (-109)) goto L11;
        return null;
    L11:
        if (a(r7) == false) goto L19;
        Loog.INSTANCE.e(TAG, " - CronetIOException (errCode=" + r0 + ", judgeFromEvent) -> ServerUnreachable");
        return (com.obric.autogui.net.ttnet.a.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.f31485d, r8), com.obric.autogui.net.ttnet.a.a.b.class, "com.obric.aiagent.plugin");
    L19:
        return null;
    L16:
        return null;
    }

    private final boolean a(com.obric.autogui.net.ttnet.a.a.C0737a r6) {
        JsonObject r7 = com.obric.autogui.net.ttnet.a.a.a.a(r6);
        if (r7 != null) goto L13;
        return false;
    L13:
        double r3 = AOSystemTools.INSTANCE.nowTimeMillis() - (r7.getAsJsonObject("event").get("network_change").getAsDouble() * ((double) 1000));
        Loog.INSTANCE.w(TAG, " - CronetIOException (errCode=UNREACHABLE), net-changed at: " + r3 + "/ms before.");
        if (r3 >= 10000.0d) goto L15;
        return true;
    L15:
        return false;
    L10:
        th = move-exception;
        Loog.INSTANCE.w(TAG, " - CronetIOException (errCode=UNREACHABLE), trying to get network_change event: " + th, th);
        return false;
    }
}
