package com.bytedance.memory.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: MemoryWidgetThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8776a;

    public f(String r3) {
        this.f8776a = "MemoryWidget_" + r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r3) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), this.f8776a);
    }
}
