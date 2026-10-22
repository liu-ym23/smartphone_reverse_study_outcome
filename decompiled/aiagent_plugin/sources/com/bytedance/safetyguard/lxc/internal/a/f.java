package com.bytedance.safetyguard.lxc.internal.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SafetyGuardLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final String a(String r4) {
        o.e(r4, "tag");
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "SafetyGuard.Unknown";
    L9:
        if (o.a(r5, "SafetyGuard") == false) goto L11;
        return r5;
    L11:
        if (d.o.o.b(r5, "SafetyGuard.", false, 2, null) == false) goto L14;
        return r5;
    L14:
        return "SafetyGuard." + r5;
    L5:
        r0 = false;
        goto L6
    }
}
