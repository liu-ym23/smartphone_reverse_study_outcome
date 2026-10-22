package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public final class JavaCronetEngine extends d {
    private static final String TAG = "JavaCronetEngine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f38035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f38036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f38037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f38038d;

    static {
    }

    @Override // com.ttnet.org.chromium.net.d
    public com.ttnet.org.chromium.net.ab a() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.impl.d
    public com.ttnet.org.chromium.net.ac a(com.ttnet.org.chromium.net.ac.b r1, Executor r2, int r3, List<String> r4, int r5, int r6, int r7) {
        com.ttnet.org.chromium.net.ac.b r0 = (com.ttnet.org.chromium.net.ac.b) ZeusTransformUtils.wrapperContextForParams(r1, com.ttnet.org.chromium.net.ac.b.class, "com.obric.aiagent.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        return null;
    }

    @Override // com.ttnet.org.chromium.net.impl.d
    public com.ttnet.org.chromium.net.ae a(com.ttnet.org.chromium.net.ae.b r4, Executor r5, List<String> r6, int r7, String r8, long r9, int r11, long r12, String r14, int r15, String r16, Map<String, String> r17, Map<String, String> r18, boolean r19) {
        Executor r0 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        return null;
    }

    @Override // com.ttnet.org.chromium.net.impl.d
    public com.ttnet.org.chromium.net.ae a(com.ttnet.org.chromium.net.ae.b r1, Executor r2, List<String> r3, Map<String, String> r4, Map<String, String> r5, boolean r6) {
        Executor r0 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.aiagent.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        return null;
    }

    @Override // com.ttnet.org.chromium.net.h
    public int b() {
        return 0;
    }

    @Override // com.ttnet.org.chromium.net.h
    public int k() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.h
    public int l() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.h
    public int m() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.impl.d, com.ttnet.org.chromium.net.h, com.ttnet.org.chromium.net.d
    public /* synthetic */ com.ttnet.org.chromium.net.ai.a a(String r3, com.ttnet.org.chromium.net.ai.b r4, Executor r5) {
        return super.b(r3, r4, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin"));
    }

    int n() {
        return this.f38037c;
    }

    h o() {
        return this.f38038d;
    }

    @Override // com.ttnet.org.chromium.net.impl.d
    public af a(String r14, com.ttnet.org.chromium.net.ai.b r15, Executor r16, int r17, Collection<Object> r18, boolean r19, boolean r20, boolean r21, boolean r22, int r23, boolean r24, int r25, com.ttnet.org.chromium.net.w.a r26, int r27, long r28) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r16, Executor.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r18, Collection.class, "com.obric.aiagent.plugin");
        if (r28 != (-1)) goto L7;
        return new s(this, r15, this.f38036b, r4, r14, this.f38035a, r21, r22, r23, r24, r25);
    L7:
        throw new UnsupportedOperationException("The multi-network API is not supported by the Java implementation of Cronet Engine");
    }

    @Override // com.ttnet.org.chromium.net.d
    public URLConnection a(URL r1, Proxy r2, boolean r3) {
        return r1.openConnection(r2);
    }
}
