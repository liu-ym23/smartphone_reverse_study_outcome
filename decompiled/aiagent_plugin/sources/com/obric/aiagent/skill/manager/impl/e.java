package com.obric.aiagent.skill.manager.impl;

import android.util.Log;
import com.obric.aiagent.platform.depend.IAppContext;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: SkillTrackingReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements hc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f19796a = null;

    static {
        f19796a = new e();
    }

    private e() {
    }

    @Override // com.obric.aiagent.skill.manager.impl.hc
    public void a(String r3, JSONObject r4) {
        d.h.b.o.e(r3, "event");
        d.h.b.o.e(r4, "params");
        if (IAppContext.Companion.isDebug() == false) goto L5;
        a("SkillManager", "report event=" + r3 + " params=" + r4);
        return;
    L5:
        a("SkillManager", "report event=" + r3);
    }

    @Override // com.obric.aiagent.skill.manager.impl.hc
    public void a(String r3, Throwable r4) {
        d.h.b.o.e(r3, "event");
        d.h.b.o.e(r4, "throwable");
        if (IAppContext.Companion.isDebug() == false) goto L5;
        a("SkillManager", "report failed event=" + r3, r4);
        return;
    L5:
        b("SkillManager", "report failed event=" + r3);
    }

    @Override // com.obric.aiagent.skill.manager.impl.hc
    public void c(String r3, String r4) {
        d.h.b.o.e(r3, "event");
        d.h.b.o.e(r4, "reason");
        if (IAppContext.Companion.isDebug() == false) goto L5;
        b("SkillManager", "report dropped event=" + r3 + " reason=" + r4);
        return;
    L5:
        b("SkillManager", "report dropped event=" + r3);
    }

    @Override // com.obric.aiagent.skill.manager.impl.hc
    public void a(fc r3) {
        d.h.b.o.e(r3, "snapshot");
        if (IAppContext.Companion.isDebug() == false) goto L9;
        StringBuilder r2 = new StringBuilder().append("server report queued skillId=").append(r3.a()).append(" operation=").append(r3.g().a()).append(" isEnable=").append(r3.b()).append(" isAuditPass=").append(r3.c()).append(" isDelete=").append(r3.d()).append(" fileDownloaded=").append(r3.e()).append(" hasFailReason=");
        if (r3.f() == null) goto L7;
        boolean r4 = true;
    L8:
        a("SkillManager", r2.append(r4).toString());
        return;
    L7:
        r4 = false;
        goto L8
    L9:
        a("SkillManager", "server report queued operation=" + r3.g().a());
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
