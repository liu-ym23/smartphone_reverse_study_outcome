package com.bytedance.frameworks.baselib.network.http.g;

import com.bytedance.frameworks.baselib.network.c.d;
import com.bytedance.frameworks.baselib.network.c.f;
import com.bytedance.retrofit2.al;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SsHttpExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f8346a;

    static {
    }

    public c() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r8) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L32;
        com.bytedance.frameworks.baselib.network.c.c.a r7 = com.bytedance.frameworks.baselib.network.c.c.a.f8012c;
        if (ZeusTransformUtils.instanceOf(r5, al.class) == false) goto L23;
        int r9 = ((al) ZeusTransformUtils.preCheckCast(r5, al.class, "com.obric.aiagent.plugin")).a();
        if (r9 != 0) goto L10;
        com.bytedance.frameworks.baselib.network.c.c.a r10 = com.bytedance.frameworks.baselib.network.c.c.a.f8011b;
    L22:
        boolean r1 = ((al) ZeusTransformUtils.preCheckCast(r5, al.class, "com.obric.aiagent.plugin")).b();
        com.bytedance.frameworks.baselib.network.c.c.a r3 = r10;
        int r4 = ((al) ZeusTransformUtils.preCheckCast(r5, al.class, "com.obric.aiagent.plugin")).c();
        boolean r11 = r1;
    L25:
        if (f8346a != null) goto L27;
        f8346a = f.b();
    L27:
        com.bytedance.frameworks.baselib.network.c.a r12 = new com.bytedance.frameworks.baselib.network.c.a("NetExecutor", r3, r4, r5, r11);
        if (r11 == false) goto L30;
        f8346a.a(r12);
        return;
    L30:
        f8346a.b(r12);
        return;
    L10:
        if (1 != r9) goto L13;
        r10 = com.bytedance.frameworks.baselib.network.c.c.a.f8012c;
        goto L22
    L13:
        if (2 != r9) goto L16;
        r10 = com.bytedance.frameworks.baselib.network.c.c.a.f8013d;
        goto L22
    L16:
        if (3 != r9) goto L19;
        r10 = com.bytedance.frameworks.baselib.network.c.c.a.f8014e;
        goto L22
    L19:
        if ((-1) != r9) goto L21;
        r10 = com.bytedance.frameworks.baselib.network.c.c.a.f8010a;
        goto L22
    L21:
        r10 = com.bytedance.frameworks.baselib.network.c.c.a.f8012c;
        goto L22
    L23:
        r3 = r7;
        r11 = false;
        r4 = 0;
        goto L25
    }
}
