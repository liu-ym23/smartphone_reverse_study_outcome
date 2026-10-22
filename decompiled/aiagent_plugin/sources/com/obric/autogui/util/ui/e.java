package com.obric.autogui.util.ui;

import android.content.Context;
import android.os.Vibrator;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VibratorSmt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "VibratorSmt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f31581a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f31582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f31583c;

    static {
        f31581a = new e();
    }

    private e() {
    }

    public static final void a(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Vibrator r0 = null;
        if (r6 == null) goto L5;
        Object r2 = r6.getSystemService("vibrator");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Vibrator.class) == false) goto L9;
        r0 = (Vibrator) ZeusTransformUtils.preCheckCast(r2, Vibrator.class, "com.obric.aiagent.plugin");
    L9:
        if (r0 == null) goto L11;
        a(r0, r5);
        return;
    L11:
        Loog r7 = Loog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("vibrateEffectWithHapticPlayer error: vibrator is null, context is null? ");
        if (r6 != null) goto L14;
        boolean r8 = true;
    L15:
        r7.e(TAG, r1.append(r8).toString());
        return;
    L14:
        r8 = false;
        goto L15
    L5:
        r2 = null;
        goto L7
    }

    public static final void a(Vibrator r7, int r8) {
        o.e(r7, "target");
    L15:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "vibrateEffectWithHapticPlayer error: " + e);
        return;
    L4:
        if (f31582b != null) goto L7;
        f31582b = ZeusTransformUtils.forName("bytedanceos.api.VibratorSmt", "com.obric.aiagent.plugin");     // Catch: Exception -> L15
    L7:
        if (f31583c != null) goto L11;
        Class<?> r0 = f31582b;     // Catch: Exception -> L15
        o.a(r0);     // Catch: Exception -> L15
        Method r1 = r0.getDeclaredMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L15
        f31583c = r1;     // Catch: Exception -> L15
        if (r1 == null) goto L11;
        r1.setAccessible(true);     // Catch: Exception -> L15
    L11:
        Method r2 = f31583c;     // Catch: Exception -> L15
        if (r2 == null) goto L20;
        r2.invoke(f31582b, new Object[]{r7, Integer.valueOf(r8)});     // Catch: Exception -> L15
        return;
    }
}
