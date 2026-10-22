package com.obric.autogui.agents.a.k;

import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.status.SpaceStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n;
import d.o;

/* JADX INFO: compiled from: ActionEffectSecurityStateResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26530a = null;

    static {
        f26530a = new a();
    }

    private a() {
    }

    public final boolean a() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L13
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        AOOperatingSpace r4 = OperatingSpaceManager.INSTANCE.getActiveSpace();     // Catch: Throwable -> L13
        boolean r5 = true;
        if (r4 == null) goto L10;
        SpaceStatus r6 = r4.getSpaceStatus();     // Catch: Throwable -> L13
        if (r6 == null) goto L10;
        if (r6.isSecure() != true) goto L10;
    L11:
        Object r7 = n.f(Boolean.valueOf(r5));     // Catch: Throwable -> L13
    L16:
        if (n.b(r7) == false) goto L19;
        r7 = false;
    L19:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L10:
        r5 = false;
    L13:
        th = move-exception;
        n.a r8 = n.f38560a;
        r7 = n.f(o.a(th));
        goto L16
    }
}
