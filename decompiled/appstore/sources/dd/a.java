package dd;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import com.obric.oui.utils.log.L;
import java.lang.reflect.Method;
import kotlin.jvm.internal.q;
import td.c;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class f19179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f19180c;

    static {
        f19178a = new a();
    }

    public a() {
    }

    public static final void b(Context r10, int r11) {
        c r12 = c.f24796a;
        Object r13 = null;
        if (r10 != null) goto L5;
        Object r14 = null;
    L6:
        if (r14 != null) goto L9;
    L11:
        Vibrator r15 = (Vibrator) r13;
        if (r15 == null) goto L14;
        c(r15, r11);
        return;
    L14:
        if (r10 != null) goto L16;
        boolean r16 = true;
    L17:
        L.b("VibratorSmt", q.p("vibrateEffectWithHapticPlayer error: vibrator is null, context is null? ", Boolean.valueOf(r16)));
        return;
    L16:
        r16 = false;
        goto L17
    L9:
        if ((r14 instanceof Vibrator) == false) goto L11;
        r13 = r14;
        goto L11
    L5:
        r14 = r10.getSystemService("vibrator");
        goto L6
    }

    public static final void c(Vibrator r10, int r11) {
        q.g(r10, "target");
    L6:
        e = move-exception;
        L.b("VibratorSmt", q.p("vibrateEffectWithHapticPlayer error: ", e));
        return;
    L4:
        if (f19179b != null) goto L9;
        f19179b = Class.forName("bytedanceos.api.VibratorSmt");     // Catch: Exception -> L6
    L9:
        if (f19180c != null) goto L14;
        Class r12 = f19179b;     // Catch: Exception -> L6
        q.d(r12);     // Catch: Exception -> L6
        Method r13 = r12.getDeclaredMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L6
        f19180c = r13;     // Catch: Exception -> L6
        if (r13 == null) goto L14;
        r13.setAccessible(true);     // Catch: Exception -> L6
    L14:
        Method r14 = f19180c;     // Catch: Exception -> L6
        if (r14 == null) goto L23;
        r14.invoke(f19179b, new Object[]{r10, Integer.valueOf(r11)});     // Catch: Exception -> L6
        return;
    }

    public final void a(View r10, int r11) {
        if (r10 == null) goto L11;
        r10.performHapticFeedback(r11);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        L.b("VibratorSmt", q.p("performHapticFeedbackAOSP error: ", e));
        return;
    }
}
