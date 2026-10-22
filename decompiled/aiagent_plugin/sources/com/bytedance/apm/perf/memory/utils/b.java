package com.bytedance.apm.perf.memory.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: KeyedWeakReference.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends WeakReference<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4855b;

    public b(Object r3, String r4, String r5, ReferenceQueue<Object> r6) {
        super(a(r3, "referent"), (ReferenceQueue) ZeusTransformUtils.preCheckCast(a(r6, "referenceQueue"), ReferenceQueue.class, "com.obric.aiagent.plugin"));
        this.f4854a = (String) ZeusTransformUtils.preCheckCast(a(r4, "key"), String.class, "com.obric.aiagent.plugin");
        this.f4855b = (String) ZeusTransformUtils.preCheckCast(a(r5, "name"), String.class, "com.obric.aiagent.plugin");
    }

    static <T> T a(T r1, String r2) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        throw new NullPointerException(r2 + " must not be null");
    }
}
