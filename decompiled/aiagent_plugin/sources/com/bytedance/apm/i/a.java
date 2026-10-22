package com.bytedance.apm.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NpthUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f4655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f4656b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4657c = false;

    /* JADX INFO: renamed from: com.bytedance.apm.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NpthUtil.java */
    public interface InterfaceC0116a {
    }

    /* JADX INFO: compiled from: NpthUtil.java */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: NpthUtil.java */
    public interface c {
        void a(InterfaceC0116a r1);
    }

    static {
    }

    public static void a() {
        if (f4657c == false) goto L5;
        return;
    L5:
        b r0 = f4656b;
        if (r0 == null) goto L9;
        r0.a();
        f4657c = true;
        return;
    }

    public static void a(InterfaceC0116a r2) {
        InterfaceC0116a r3 = (InterfaceC0116a) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0116a.class, "com.obric.aiagent.plugin");
        c r0 = f4655a;
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }
}
