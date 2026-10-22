package com.bytedance.apm.agent.instrumentation.okhttp3;

import okhttp3.Call;
import okhttp3.i;

/* JADX INFO: loaded from: classes14.dex */
public class OkHttpEventFactory implements i.c {
    public i.c originFactory;

    public OkHttpEventFactory(i.c r100) {
        this.originFactory = r100;
    }

    @Override // okhttp3.i.c
    public i create(Call r100) {
        i.c r101 = this.originFactory;
        if (r101 == null) goto L5;
        i r102 = r101.create(r100);
    L7:
        return new OkHttpEventListener(r102);
    L5:
        r102 = null;
        goto L7
    }
}
