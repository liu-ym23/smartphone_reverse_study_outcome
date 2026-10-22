package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.Gson;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.o.d;

/* JADX INFO: compiled from: OPushEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "OAppAction";

    public static final OPushEvent a(byte[] r4) {
        o.e(r4, "<this>");
        String r0 = new String(r4, d.f38623b);
        n.a r5 = n.f38560a;     // Catch: Throwable -> L5
        return (OPushEvent) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r0, OPushEvent.class), OPushEvent.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r1 = n.f38560a;
        Throwable r6 = n.c(n.f(d.o.a(th)));
        if (r6 == null) goto L13;
        ILogDepend.Companion.w(TAG, "toAppAction error " + r0 + " ex=" + d.a.a(r6));
        return null;
    L13:
        return null;
    }
}
