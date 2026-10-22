package com.bytedance.common.wschannel.client;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BaseIntentParse.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final b.a f6936a;

    public a(b.a r3) {
        this.f6936a = (b.a) ZeusTransformUtils.wrapperContextForParams(r3, b.a.class, "com.obric.aiagent.plugin");
    }

    public com.bytedance.common.wschannel.b.c a(int r4, int r5, boolean r6) {
        com.bytedance.common.wschannel.b.c r0 = com.bytedance.common.wschannel.b.c.f6776a;
        if (r5 != 0) goto L6;
        r0 = com.bytedance.common.wschannel.b.c.f6776a;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d(AbsWsClientService.TAG, "state = " + r5 + " connectionState = " + r0);
    L20:
        this.f6936a.syncState(r4, r0, r6);
        return r0;
    L6:
        if (r5 != 1) goto L9;
        r0 = com.bytedance.common.wschannel.b.c.f6777b;
        goto L18
    L9:
        if (r5 != 2) goto L12;
        r0 = com.bytedance.common.wschannel.b.c.f6778c;
        goto L18
    L12:
        if (r5 != 3) goto L15;
        r0 = com.bytedance.common.wschannel.b.c.f6779d;
        goto L18
    L15:
        if (r5 != 4) goto L18;
        r0 = com.bytedance.common.wschannel.b.c.f6780e;
        goto L18
    }
}
