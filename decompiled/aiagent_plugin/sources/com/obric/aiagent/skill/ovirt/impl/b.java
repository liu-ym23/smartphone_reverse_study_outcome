package com.obric.aiagent.skill.ovirt.impl;

import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import d.h.b.o;

/* JADX INFO: compiled from: SafeLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f21110a = null;

    static {
        f21110a = new b();
    }

    private b() {
    }

    public final void a(String r2, String r3, String r4) {
        o.e(r2, "tag");
        o.e(r3, "releaseMessage");
        o.e(r4, "debugMessage");
        ILogDepend.Companion r1 = ILogDepend.Companion;
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r3 = r4;
    L5:
        r1.i(r2, r3);
    }

    public static /* synthetic */ void a(b r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = r2;
    L5:
        r0.b(r1, r2, r3);
    }

    public final void b(String r2, String r3, String r4) {
        o.e(r2, "tag");
        o.e(r3, "releaseMessage");
        o.e(r4, "debugMessage");
        ILogDepend.Companion r1 = ILogDepend.Companion;
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r3 = r4;
    L5:
        r1.w(r2, r3);
    }

    public final void a(String r1, String r2, String r3, Throwable r4) {
        o.e(r1, "tag");
        o.e(r2, "releaseMessage");
        o.e(r3, "debugMessage");
        if (IAppContext.Companion.isDebug() == false) goto L6;
        if (r4 == null) goto L6;
        ILogDepend.Companion.e(r1, r3, r4);
        return;
    L6:
        ILogDepend.Companion r0 = ILogDepend.Companion;
        if (IAppContext.Companion.isDebug() == false) goto L9;
        r2 = r3;
    L9:
        r0.e(r1, r2);
    }
}
