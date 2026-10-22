package com.obric.agent.intents.skill.a;

import com.obric.agent.ObricService;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;

/* JADX INFO: compiled from: IntentActionJson.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f14888a = null;

    static {
        f14888a = new e();
    }

    private e() {
    }

    public final <T> T a(String r4, Class<T> r5, String r6) {
        o.e(r4, "raw");
        o.e(r5, "clazz");
        o.e(r6, "tag");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        e r3 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        T r7 = (T) n.f(ObricService.INSTANCE.getGson().fromJson(r4, r5));
    L7:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L14;
        if (IAppContext.Companion.isDebug() == false) goto L12;
        ILogDepend.Companion.e(r6, "parse actionArgs failed clazz=" + r5.getSimpleName(), r8);
        goto L14
    L12:
        ILogDepend.Companion.e(r6, "parse actionArgs failed");
    L14:
        if (n.b(r7) == false) goto L19;
        return null;
    L19:
        return r7;
    L5:
        th = move-exception;
        n.a r9 = n.f38560a;
        r7 = (T) n.f(d.o.a(th));
        goto L7
    }
}
