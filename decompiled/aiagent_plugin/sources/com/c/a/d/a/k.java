package com.c.a.d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;

/* JADX INFO: compiled from: ObversableMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements com.c.a.d.b {
    public k() {
    }

    @Override // com.c.a.d.b
    public boolean a(com.c.a.c.a r1) {
        return b(r1);
    }

    public boolean b(com.c.a.c.a r8) {
        Enumeration r7 = com.c.a.a.a().c();
        if (r7 != null) goto L5;
        return false;
    L5:
        if (r7.hasMoreElements() == false) goto L20;
        com.c.a.f.a r0 = (com.c.a.f.a) ZeusTransformUtils.preCheckCast(r7.nextElement(), com.c.a.f.a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        if (r0.a(r8) == false) goto L5;
        com.c.a.h.a.a(new com.c.a.h.b.b(0, false, r8.d(), null));
        return true;
    L20:
        return false;
    }
}
