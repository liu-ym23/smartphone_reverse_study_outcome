package com.bytedance.reparo.core.e;

import android.app.Application;
import android.os.Looper;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.g;
import com.bytedance.reparo.core.i.i;
import com.bytedance.reparo.core.i.k;
import com.bytedance.reparo.core.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JavaLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends b<com.bytedance.reparo.core.h.c> {
    private static final String TAG = "JavaLoader";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f9184c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.reparo.core.h.c f9185b;

    /* JADX INFO: compiled from: JavaLoader.java */
    public interface a {
        boolean a(String r1);
    }

    static {
    }

    public c(g r1) {
        super(r1);
    }

    public void a(com.bytedance.reparo.core.h.c r6, com.bytedance.reparo.core.e.a r7, com.bytedance.reparo.core.h.b r8) {
        com.bytedance.reparo.core.h.c r0 = this.f9185b;
        if (r0 != null) goto L5;
    L10:
        a(r6);
        k r1 = new k(r6.f().f9261b, "_init.info", 2, i.a(null));
        r6.a(r8);     // Catch: Throwable -> L27 com.bytedance.reparo.core.b.d -> L30
    L13:
        if (k.f9292b == true) goto L15;
    L32:
        b(r6, r7, r8);     // Catch: Throwable -> L24
        r1.e();
        return;
    L24:
        th = move-exception;
        r1.e();
        throw th;
    L15:
        if (r1.d() == false) goto L32;
        if (a(r6.f().g().n()) == false) goto L20;
        j.d(TAG, "skip loadProtect for " + r6.f().g().n());
        r1.e();
        goto L32
    L20:
        throw new com.bytedance.reparo.core.b.a(String.format("load java patch %s failed due to last crash.", new Object[]{r6.f().f9261b.getAbsolutePath()}), 101);
    L30:
        e = move-exception;
        throw e;
    L27:
        th = move-exception;
        throw new com.bytedance.reparo.core.b.a(String.format("load java patch %s failed2.", new Object[]{r6.k().getAbsolutePath()}), th, 103);
    L5:
        if (r0.a() == false) goto L10;
        if (r6.equals(this.f9185b) == false) goto L10;
        r7.b();
    }

    private void a(com.bytedance.reparo.core.h.c r1) {
        if (r1.d() == true) goto L4;
    }

    private void b(com.bytedance.reparo.core.h.c r17, com.bytedance.reparo.core.e.a r18, com.bytedance.reparo.core.h.b r19) {
        WandTrick.a r3 = WandTrick.b().a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f9183a.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), this.f9183a.f(), r17.g(), r17.h(), r17.i(), r17.j(), r19, r17.f());     // Catch: Throwable -> L5 com.bytedance.reparo.core.b.d -> L8 com.bytedance.reparo.core.a.C0210a -> L10
    L26:
        a(r17, r3, r18);     // Catch: Exception -> L15 com.bytedance.reparo.core.b.d -> L18
        this.f9185b = r17;
        return;
    L18:
        e = move-exception;
        throw e;
    L15:
        e = move-exception;
        throw new com.bytedance.reparo.core.b.a(String.format("load java patch %s failed.", new Object[]{r17.k().getAbsolutePath()}), e, 103);
    L10:
        r3 = WandTrick.b().a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f9183a.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), this.f9183a.f(), r17.g(), r17.h(), r17.i(), r17.j(), r19, r17.f());     // Catch: Throwable -> L21 com.bytedance.reparo.core.b.d -> L24
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        r17.c();
        throw new com.bytedance.reparo.core.b.a(String.format("load java patch %s failed.", new Object[]{r17.k().getAbsolutePath()}), th, 103);
    L24:
        e = move-exception;
        throw e;
    L21:
        th = move-exception;
        r17.c();
        throw new com.bytedance.reparo.core.b.a(String.format("load java patch %s failed2.", new Object[]{r17.k().getAbsolutePath()}), th, 103);
    }

    private void a(final com.bytedance.reparo.core.h.c r2, final WandTrick.a r3, final com.bytedance.reparo.core.e.a r4) {
        final WandTrick.a r0 = new AnonymousClass1(this, r3, r2, r4);
        Runnable r5 = new AnonymousClass2(this, r0, r4, r2);
        if (r0.b() == false) goto L6;
        return;
    L6:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L8;
        com.bytedance.reparo.core.i.c.a().execute(r5);
        return;
    L8:
        r5.run();
    }

    public void a() {
        com.bytedance.reparo.core.h.c r1 = this.f9185b;
        if (r1 == null) goto L6;
        r1.a(false);
        return;
    }

    public static void a(a r2) {
        f9184c = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
    }

    private boolean a(String r1) {
        a r0 = f9184c;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r1);
    }
}
