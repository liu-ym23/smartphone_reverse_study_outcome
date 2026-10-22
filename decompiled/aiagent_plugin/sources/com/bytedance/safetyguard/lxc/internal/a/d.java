package com.bytedance.safetyguard.lxc.internal.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SafetyGuardLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9723a = null;

    static {
        f9723a = new d();
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void a(String r2, d.h.a.a<String> r3) {
        d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r2, "tag");
        o.e(r1, "message");
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void a(String r1, Throwable r2, d.h.a.a<String> r3) {
        d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "tag");
        o.e(r0, "message");
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void b(String r2, d.h.a.a<String> r3) {
        d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r2, "tag");
        o.e(r1, "message");
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void b(String r1, Throwable r2, d.h.a.a<String> r3) {
        d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r1, "tag");
        o.e(r0, "message");
    }

    private d() {
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public String a(String r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return "empty";
    L11:
        return "redacted";
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r3 = false;
        goto L9
    }
}
