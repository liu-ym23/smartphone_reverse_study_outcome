package com.bytedance.apm.agent.instrumentation.okhttp3;

import okhttp3.Call;
import okhttp3.EventListener;

/* JADX INFO: loaded from: classes.dex */
public class OkHttpEventFactory implements EventListener.Factory {
    public EventListener.Factory originFactory;

    public OkHttpEventFactory(EventListener.Factory r10) {
        this.originFactory = r10;
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call r10) {
        EventListener.Factory r11 = this.originFactory;
        if (r11 == null) goto L5;
        EventListener r12 = r11.create(r10);
    L7:
        return new OkHttpEventListener(r12);
    L5:
        r12 = null;
        goto L7
    }
}
