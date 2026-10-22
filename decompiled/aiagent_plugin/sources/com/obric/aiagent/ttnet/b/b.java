package com.obric.aiagent.ttnet.b;

import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;
import d.s;

/* JADX INFO: compiled from: Trace.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22206a;

    public b(String r2) {
        o.e(r2, "event");
        this.f22206a = r2;
    }

    public final void a(String r7, String r8) {
        o.e(r7, "tag");
        o.e(r8, AutoTestConstant.PARAM);
        ILogDepend.Companion.i(this.f22206a, '[' + r7 + "] " + r8);
        IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.report(this.f22206a, androidx.core.os.e.a(new m[]{s.a("tag", r7), s.a(AutoTestConstant.PARAM, r8)}));
        return;
    }
}
