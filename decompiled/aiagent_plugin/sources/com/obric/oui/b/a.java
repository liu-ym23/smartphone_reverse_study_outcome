package com.obric.oui.b;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import com.obric.oui.d.a.b;
import com.obric.oui.d.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VibratorSmt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "VibratorSmt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f34003a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f34004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f34005c;

    static {
        f34003a = new a();
    }

    private a() {
    }

    public static final void a(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        c r0 = c.f35012a;
        Object r1 = null;
        if (r6 != null) goto L5;
        Object r2 = null;
    L6:
        if (r2 != null) goto L9;
    L11:
        Vibrator r3 = (Vibrator) ZeusTransformUtils.preCheckCast(r1, Vibrator.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L14;
        a(r3, r5);
        return;
    L14:
        if (r6 != null) goto L16;
        boolean r7 = true;
    L17:
        b.e(TAG, o.a("vibrateEffectWithHapticPlayer error: vibrator is null, context is null? ", Boolean.valueOf(r7)));
        return;
    L16:
        r7 = false;
        goto L17
    L9:
        if (ZeusTransformUtils.instanceOf(r2, Vibrator.class) == false) goto L11;
        r1 = r2;
        goto L11
    L5:
        r2 = r6.getSystemService("vibrator");
        goto L6
    }

    public final void a(View r1, int r2) {
        if (r1 == null) goto L11;
        r1.performHapticFeedback(r2);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        b.e(TAG, o.a("performHapticFeedbackAOSP error: ", e));
        return;
    }

    public static final void a(Vibrator r7, int r8) {
        o.e(r7, "target");
    L17:
        e = move-exception;
        b.e(TAG, o.a("vibrateEffectWithHapticPlayer error: ", e));
        return;
    L4:
        if (f34004b != null) goto L7;
        f34004b = ZeusTransformUtils.forName("bytedanceos.api.VibratorSmt", "com.obric.aiagent.plugin");     // Catch: Exception -> L17
    L7:
        if (f34005c != null) goto L12;
        Class<?> r0 = f34004b;     // Catch: Exception -> L17
        o.a(r0);     // Catch: Exception -> L17
        Method r1 = r0.getDeclaredMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L17
        f34005c = r1;     // Catch: Exception -> L17
        if (r1 == null) goto L12;
        r1.setAccessible(true);     // Catch: Exception -> L17
    L12:
        Method r2 = f34005c;     // Catch: Exception -> L17
        if (r2 == null) goto L22;
        r2.invoke(f34004b, new Object[]{r7, Integer.valueOf(r8)});     // Catch: Exception -> L17
        return;
    }
}
