package com.bytedance.safetyguard.lxc.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxySessionLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f10244a = null;

    static {
        f10244a = new l();
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void a(String r1, String r2) {
        d.h.b.o.e(r1, "tag");
        d.h.b.o.e(r2, "message");
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void a(String r1, String r2, Throwable r3) {
        d.h.b.o.e(r1, "tag");
        d.h.b.o.e(r2, "message");
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void b(String r1, String r2) {
        d.h.b.o.e(r1, "tag");
        d.h.b.o.e(r2, "message");
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
    public void b(String r1, String r2, Throwable r3) {
        d.h.b.o.e(r1, "tag");
        d.h.b.o.e(r2, "message");
    }

    private l() {
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.s
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
