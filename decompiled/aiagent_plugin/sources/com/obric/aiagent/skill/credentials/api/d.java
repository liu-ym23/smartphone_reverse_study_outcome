package com.obric.aiagent.skill.credentials.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import java.util.Set;

/* JADX INFO: compiled from: CredentialModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f18947a = null;

    public static final boolean a(h r4) {
        d.h.b.o.e(r4, "<this>");
        if (b(r4) == false) goto L6;
        return false;
    L6:
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(f18947a, Iterable.class, "com.obric.aiagent.plugin"), r4.c()) == true) goto L14;
        Integer r0 = r4.b();
        if (r0 != null) goto L11;
        return false;
    L11:
        if (r0.intValue() == 409) goto L13;
        return false;
    L13:
        if (d.h.b.o.a(r4.getType(), "config") == true) goto L14;
        return false;
    L14:
        return true;
    }

    public static final boolean b(h r2) {
        d.h.b.o.e(r2, "<this>");
        Integer r0 = r2.b();
        if (r0 != null) goto L6;
    L12:
        return false;
    L6:
        if (r0.intValue() != 409) goto L12;
        if (d.h.b.o.a(r2.getType(), "config") == false) goto L12;
        if (d.h.b.o.a(r2.c(), "operation_in_progress") == false) goto L12;
        return true;
    }

    static {
        f18947a = ax.a(new String[]{"app_already_configured", "app_not_found", "invalid_app", "no_app"});
    }
}
