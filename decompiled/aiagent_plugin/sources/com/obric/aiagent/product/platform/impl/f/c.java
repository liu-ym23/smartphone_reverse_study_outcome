package com.obric.aiagent.product.platform.impl.f;

import android.app.Application;
import android.os.Vibrator;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SystemHiddenApiHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String TAG = "SystemHiddenApiHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f18847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f18848b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f f18849c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f18850d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f f18851e = null;

    public static /* synthetic */ Class lambda$5DYQKNEbDfUqCUGltMC02cVu2Jc() {
        return f();
    }

    public static /* synthetic */ Vibrator lambda$UzlMU2rtfSs80jx6Hho9YevpShk() {
        return e();
    }

    /* JADX INFO: renamed from: lambda$gRw9zG4QhvQ-oTTO7l0lUDZl4YQ, reason: not valid java name */
    public static /* synthetic */ Method m228lambda$gRw9zG4QhvQoTTO7l0lUDZl4YQ() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$m_p70GXduykKVMY2PTA4S-qrEvg, reason: not valid java name */
    public static /* synthetic */ Object m229lambda$m_p70GXduykKVMY2PTA4SqrEvg() {
        return d();
    }

    private c() {
    }

    static {
        f18847a = new c();
        f18848b = g.a($$Lambda$c$m_p70GXduykKVMY2PTA4SqrEvg.INSTANCE);
        f18849c = g.a($$Lambda$c$UzlMU2rtfSs80jx6Hho9YevpShk.INSTANCE);
        f18850d = g.a($$Lambda$c$5DYQKNEbDfUqCUGltMC02cVu2Jc.INSTANCE);
        f18851e = g.a($$Lambda$c$gRw9zG4QhvQoTTO7l0lUDZl4YQ.INSTANCE);
    }

    private static final Object d() {
        return ZeusTransformUtils.forName("android.view.WindowManagerGlobal", "com.obric.aiagent.plugin").getMethod("getWindowSession", new Class[0]).invoke(null, new Object[0]);
    L5:
        th = move-exception;
        ISysLogDepend.Companion.e(TAG, "get windowSessionObj error!", th);
        return null;
    }

    private final Vibrator a() {
        return (Vibrator) ZeusTransformUtils.preCheckCast(f18849c.b(), Vibrator.class, "com.obric.aiagent.plugin");
    }

    private static final Vibrator e() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("vibrator");
        o.a(r0, "null cannot be cast to non-null type android.os.Vibrator");
        return (Vibrator) ZeusTransformUtils.preCheckCast(r0, Vibrator.class, "com.obric.aiagent.plugin");
    }

    private final Class<?> b() {
        return (Class) ZeusTransformUtils.preCheckCast(f18850d.b(), Class.class, "com.obric.aiagent.plugin");
    }

    private static final Class f() {
        return ZeusTransformUtils.forName("bytedanceos.api.VibratorSmt", "com.obric.aiagent.plugin");
    L4:
        th = move-exception;
        ISysLogDepend.Companion.e(TAG, "get vibratorSmtClass error!", th);
        return null;
    }

    private final Method c() {
        return (Method) ZeusTransformUtils.preCheckCast(f18851e.b(), Method.class, "com.obric.aiagent.plugin");
    }

    private static final Method g() {
        Class<?> r1 = f18847a.b();     // Catch: Throwable -> L7
        if (r1 == null) goto L12;
        return r1.getMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});
    L12:
        return null;
    L7:
        th = move-exception;
        ISysLogDepend.Companion.e(TAG, "get vibratePlayer error!", th);
        return null;
    }

    public final void a(String r6) {
        o.e(r6, "effect");
        ISysLogDepend.Companion.d(TAG, "performVibratorSmtFeedback " + r6);
        Class<?> r5 = b();     // Catch: Throwable -> L14
        if (r5 == null) goto L8;
        Field r7 = r5.getField(r6);     // Catch: Throwable -> L14
        if (r7 == null) goto L8;
        Integer r8 = Integer.valueOf(r7.getInt(null));     // Catch: Throwable -> L14
    L9:
        if (r8 == null) goto L19;
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L14
        c r10 = f18847a;     // Catch: Throwable -> L14
        Method r1 = r10.c();     // Catch: Throwable -> L14
        if (r1 == null) goto L20;
        r1.invoke(null, new Object[]{r10.a(), Integer.valueOf(r9)});     // Catch: Throwable -> L14
        return;
    L20:
        return;
    L19:
        return;
    L8:
        r8 = null;
    L14:
        th = move-exception;
        ISysLogDepend.Companion.e(TAG, "vibrator invoke failed", th);
    }
}
