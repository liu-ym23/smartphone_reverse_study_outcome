package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TTNetRequestLogReporterBridge.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements af.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k f8401a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f8403c;

    public k() {
    }

    static {
        f8401a = new k();
        f8402b = false;
        f8403c = false;
    }

    private void a(Object r3) {
        if (((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin")).v == null) goto L6;
        Logger.e("TTNetCallMonitor", "monitor cast error" + ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin")).v.getPath());
        return;
    }

    public static void a() {
        af.a(f8401a);
    }

    public static void a(boolean r0) {
        f8402b = r0;
    }

    public static void b(boolean r0) {
        f8403c = r0;
    }

    @Override // com.bytedance.retrofit2.af.b
    public void a(String r5, Object r6) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin");     // Catch: ClassCastException -> L12
        if (f8403c == false) goto L8;
        if (r0.ac.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (f8402b == false) goto L10;
        g.b(r5, r0);     // Catch: ClassCastException -> L12
        return;
    L10:
        g.a(r5, r0);     // Catch: ClassCastException -> L12
        return;
    L12:
        a(r6);
    }

    @Override // com.bytedance.retrofit2.af.b
    public void a(String r5, Object r6, Throwable r7) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin");     // Catch: ClassCastException -> L12
        if (f8403c == false) goto L8;
        if (r0.ac.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (f8402b == false) goto L10;
        g.b(r5, r0, r7);     // Catch: ClassCastException -> L12
        return;
    L10:
        g.a(r5, r0, r7);     // Catch: ClassCastException -> L12
        return;
    L12:
        a(r6);
    }

    @Override // com.bytedance.retrofit2.af.b
    public boolean b() {
        return g.e();
    }
}
