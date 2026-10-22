package com.bytedance.applog.log;

import com.bytedance.bdinstall.ah;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CustomLogProcessor.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f5703a;

    public d(ah r3) {
        this.f5703a = (ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.applog.log.g
    public void a(h r3) {
        if (this.f5703a == null) goto L18;
        int r0 = r3.b();
        if (r0 != 1) goto L7;
        this.f5703a.b(r3.i(), r3.c());
        return;
    L7:
        if (r0 != 2) goto L9;
        this.f5703a.d(r3.i(), r3.c());
        return;
    L9:
        if (r0 != 3) goto L11;
        this.f5703a.c(r3.i(), r3.c());
        return;
    L11:
        if (r0 == 4) goto L13;
        this.f5703a.a(r3.i(), r3.c());
        return;
    L13:
        this.f5703a.e(r3.i(), r3.c());
        return;
    }
}
