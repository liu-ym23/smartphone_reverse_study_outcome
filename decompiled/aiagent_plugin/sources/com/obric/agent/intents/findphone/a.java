package com.obric.agent.intents.findphone;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;

/* JADX INFO: compiled from: FlashlightUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f14694b;

    static {
        f14693a = new a();
    }

    private a() {
    }

    public final int a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return f14694b;
    }

    public final void a(Context r10, int r11) {
        CameraManager r12 = b((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin"));
        if (r12 != null) goto L5;
        return;
    L5:
        int r0 = 0;
        if (r11 != 1) goto L8;
        boolean r13 = true;
    L25:
        String[] r3 = r12.getCameraIdList();     // Catch: Throwable -> L22
        int r4 = r3.length;     // Catch: Throwable -> L22
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L18;
        String r6 = r3[r5];     // Catch: Throwable -> L22
        CameraCharacteristics r7 = r12.getCameraCharacteristics(r6);     // Catch: Throwable -> L22
        o.c(r7, "getCameraCharacteristics(...)");     // Catch: Throwable -> L22
        if (o.a((Boolean) ZeusTransformUtils.preCheckCast(r7.get(CameraCharacteristics.FLASH_INFO_AVAILABLE), Boolean.class, "com.obric.aiagent.plugin"), true) == false) goto L17;
        n.a r8 = n.f38560a;     // Catch: Throwable -> L15
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        r12.setTorchMode(r6, r13);     // Catch: Throwable -> L15
        n.f(x.f38692a);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        n.a r14 = n.f38560a;     // Catch: Throwable -> L22 Throwable -> L22
        n.f(d.o.a(th));     // Catch: Throwable -> L22 Throwable -> L22
    L17:
        r5 = r5 + 1;     // Catch: Throwable -> L22 Throwable -> L22
        goto L10
    L18:
        if (r13 == false) goto L20;
        r0 = 1;
    L20:
        f14694b = r0;     // Catch: Throwable -> L22 Throwable -> L22
        return;
    L31:
        return;
    L8:
        r13 = false;
        goto L25
    }

    private final CameraManager b(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return null;
    L5:
        Object r4 = r2.getSystemService("camera");
        if (ZeusTransformUtils.instanceOf(r4, CameraManager.class) == true) goto L8;
        return null;
    L8:
        return (CameraManager) ZeusTransformUtils.preCheckCast(r4, CameraManager.class, "com.obric.aiagent.plugin");
    }
}
