package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import android.app.Application;
import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionRegistrationAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w {
    private static final String TAG = "AppFunctionRegAuth";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f18308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f18309b = null;

    /* JADX INFO: renamed from: lambda$85H-JhH1DO3xSupl3OQDojhdH_o, reason: not valid java name */
    public static /* synthetic */ com.obric.aiagent.authentication.license.a m183lambda$85HJhH1DO3xSupl3OQDojhdH_o() {
        return b();
    }

    private w() {
    }

    static {
        f18308a = new w();
        f18309b = d.g.a($$Lambda$w$85HJhH1DO3xSupl3OQDojhdH_o.INSTANCE);
    }

    private final com.obric.aiagent.authentication.license.a a() {
        return (com.obric.aiagent.authentication.license.a) ZeusTransformUtils.preCheckCast(f18309b.b(), com.obric.aiagent.authentication.license.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.authentication.license.a b() {
        return com.obric.aiagent.authentication.license.a.f16384a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public final boolean a(m r5) {
        d.h.b.o.e(r5, "entry");
        String r0 = b(r5);
        if (r0 != null) goto L6;
        return false;
    L6:
        boolean r4 = a().a(r5.c(), "intent_register", r0);
        if (r4 == true) goto L9;
        ILogDepend.Companion.w(TAG, "registration denied: pkg=" + r5.c() + ", action=" + r0 + ", schema=" + r5.a() + '/' + r5.b());
    L9:
        return r4;
    }

    private final String b(m r2) {
        String r1 = r2.a();
        if (r1 != null) goto L5;
        return null;
    L5:
        String r3 = r2.b();
        if (r3 != null) goto L9;
        return null;
    L9:
        return r1 + '_' + r3;
    }
}
