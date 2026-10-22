package com.obric.autogui.util;

import android.os.IBinder;
import com.obric.autoaction.BuildConfig;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.lang.reflect.Method;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: SleepModeController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private static final String TAG = "SleepModeController";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f31551a = null;

    /* JADX INFO: compiled from: SleepModeController.kt */
    @d.c.b.a.f(b = "SleepModeController.kt", c = {95, 96}, d = "tryRecoverFromSleepMode", e = "com.obric.autogui.util.SleepModeController")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f31553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f31555d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31556e;

        a(g r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31555d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31554c = r3;
            this.f31556e |= Integer.MIN_VALUE;
            return this.f31555d.a(null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31551a = new g();
    }

    private g() {
    }

    public final Object a() {
        Method r1 = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.aiagent.plugin").getMethod("getService", new Class[]{String.class});     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        Object r2 = r1.invoke(null, new Object[]{"poweradvisor"});     // Catch: Exception -> L5
        return ZeusTransformUtils.forName("android.os.IPowerAdvisor$Stub", "com.obric.aiagent.plugin").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r2});
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final boolean b() {
        Object r5 = a();     // Catch: Exception -> L10
        if (r5 != null) goto L6;
        return false;
    L6:
        Object r6 = r5.getClass().getMethod("inSleepMode", new Class[0]).invoke(r5, new Object[0]);     // Catch: Exception -> L10
        o.a(r6, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L10
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Exception -> L10
        if (r7 == false) goto L9;
        Loog.INSTANCE.i(TAG, "inSleepMode: " + r7);     // Catch: Exception -> L10
    L9:
        return r7;
    L10:
        e = move-exception;
        Loog.INSTANCE.i(TAG, "get Sleep Mode failed " + e.getMessage());
        e.printStackTrace();
        return false;
    }

    public final void a(String r10, String r11) {
        o.e(r10, "pkgName");
        o.e(r11, "event");
        Object r9 = a();     // Catch: Exception -> L8
        if (r9 != null) goto L6;
        return;
    L6:
        r9.getClass().getMethod("forceExitSleepMode", new Class[]{String.class, String.class}).invoke(r9, new Object[]{r10, r11});     // Catch: Exception -> L8
        Loog.INSTANCE.d(TAG, "exitSleepMode: " + r10 + ' ' + r11);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Loog.INSTANCE.d(TAG, "exitSleepMode Failed " + r10 + ' ' + r11 + ' ' + e.getMessage());
        e.printStackTrace();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a5 -> B:27:0x00a8). Please report as a decompilation issue!!! */
    public final Object a(String r9, int r10, d.c.d<? super x> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.aiagent.plugin");
        if ((r0.f31556e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31556e -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f31554c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31556e;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        int r8 = r0.f31553b;
        int r14 = r0.f31552a;
        d.o.a(r13);
    L28:
        if (((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin")).g() == false) goto L31;
        Loog.INSTANCE.i(TAG, "try recovery from sleep mode success");
        return x.f38692a;
    L31:
        int r7 = r14;
        int r15 = r8 + 1;
        int r16 = r7;
    L19:
        if (r15 >= r16) goto L32;
        r0.f31552a = r16;
        r0.f31553b = r15;
        r0.f31556e = 1;
        if (ax.a(2000, r0) != r2) goto L23;
        return r2;
    L23:
        int r17 = r15;
        r14 = r16;
        r8 = r17;
    L24:
        com.obric.autogui.session.state.c r18 = com.obric.autogui.session.state.c.f31395a;
        r0.f31552a = r14;
        r0.f31553b = r8;
        r0.f31556e = 2;
        r13 = r18.a(r0);
        if (r13 != r2) goto L28;
        return r2;
    L32:
        Loog.INSTANCE.i(TAG, "try recovery from sleep mode failed");
    L35:
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = r0.f31553b;
        r14 = r0.f31552a;
        d.o.a(r13);
        goto L24
    L16:
        d.o.a(r13);
        if (b() == false) goto L33;
        Loog.INSTANCE.i(TAG, "in sleep mode try recovery from sleep mode");
        a(BuildConfig.LIBRARY_PACKAGE_NAME, r9 + '#' + r10);
        r16 = 30;
        r15 = 0;
        goto L19
    L33:
        Loog.INSTANCE.i(TAG, "not in sleep mode ");
    L7:
        r0 = new a(this, r12);
        goto L8
    }
}
