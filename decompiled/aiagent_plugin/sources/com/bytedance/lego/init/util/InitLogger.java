package com.bytedance.lego.init.util;

import android.util.Log;
import com.bytedance.lego.init.InitScheduler;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import d.h.b.o;
import d.t;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: InitLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InitLogger {
    public static final InitLogger INSTANCE = null;
    private static final int MAX_LENGTH = 3072;
    private static final String TAG = "#inittask#";

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.v(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public final void d(String r3) {
        d$default(this, null, r3, 1, null);
    }

    public final void e(String r3) {
        e$default(this, null, r3, 1, null);
    }

    public final void i(String r3) {
        i$default(this, null, r3, 1, null);
    }

    public final void v(String r3) {
        v$default(this, null, r3, 1, null);
    }

    static {
        INSTANCE = new InitLogger();
    }

    private InitLogger() {
    }

    public static /* synthetic */ void v$default(InitLogger r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.v(r1, r2);
    }

    public final void v(String r9, String r10) {
        o.d(r9, "classname");
        o.d(r10, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r8 = r9 + ' ' + r10;
        int r11 = r8.length();
        int r1 = 0;
        int r12 = MAX_LENGTH;
        int r2 = 1;
    L6:
        if (r2 > 100) goto L23;
        if (r11 <= r12) goto L14;
        String r5 = TAG + r2;
        if (r8 == null) goto L13;
        String r3 = r8.substring(r1, r12);
        o.b(r3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        INVOKESTATIC_com_bytedance_lego_init_util_InitLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(r5, r3);
        r2 = r2 + 1;
        r1 = r12;
        r12 = r12 + MAX_LENGTH;
        goto L6
    L13:
        throw new t("null cannot be cast to non-null type java.lang.String");
    L14:
        String r13 = TAG + r2;
        if (r8 == null) goto L18;
        String r14 = r8.substring(r1, r11);
        o.b(r14, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        INVOKESTATIC_com_bytedance_lego_init_util_InitLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(r13, r14);
        return;
    L18:
        throw new t("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ void d$default(InitLogger r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.d(r1, r2);
    }

    public final void d(String r9, String r10) {
        o.d(r9, "classname");
        o.d(r10, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r8 = r9 + ' ' + r10;
        int r11 = r8.length();
        int r1 = 0;
        int r12 = MAX_LENGTH;
        int r2 = 1;
    L6:
        if (r2 > 100) goto L23;
        if (r11 <= r12) goto L14;
        String r5 = TAG + r2;
        if (r8 == null) goto L13;
        String r3 = r8.substring(r1, r12);
        o.b(r3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        INVOKESTATIC_com_bytedance_lego_init_util_InitLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(r5, r3);
        r2 = r2 + 1;
        r1 = r12;
        r12 = r12 + MAX_LENGTH;
        goto L6
    L13:
        throw new t("null cannot be cast to non-null type java.lang.String");
    L14:
        String r13 = TAG + r2;
        if (r8 == null) goto L18;
        String r14 = r8.substring(r1, r11);
        o.b(r14, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        INVOKESTATIC_com_bytedance_lego_init_util_InitLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(r13, r14);
        return;
    L18:
        throw new t("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ void i$default(InitLogger r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.i(r1, r2);
    }

    public final void i(String r9, String r10) {
        o.d(r9, "classname");
        o.d(r10, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r8 = r9 + ' ' + r10;
        int r11 = r8.length();
        int r1 = 0;
        int r12 = MAX_LENGTH;
        int r2 = 1;
    L6:
        if (r2 > 100) goto L23;
        if (r11 <= r12) goto L14;
        String r5 = TAG + r2;
        if (r8 == null) goto L13;
        String r3 = r8.substring(r1, r12);
        o.b(r3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        INVOKESTATIC_com_bytedance_lego_init_util_InitLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r5, r3);
        r2 = r2 + 1;
        r1 = r12;
        r12 = r12 + MAX_LENGTH;
        goto L6
    L13:
        throw new t("null cannot be cast to non-null type java.lang.String");
    L14:
        String r13 = TAG + r2;
        if (r8 == null) goto L18;
        String r14 = r8.substring(r1, r11);
        o.b(r14, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        INVOKESTATIC_com_bytedance_lego_init_util_InitLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r13, r14);
        return;
    L18:
        throw new t("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ void e$default(InitLogger r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.e(r1, r2);
    }

    public final void e(String r1, String r2) {
        o.d(r1, "classname");
        o.d(r2, "message");
        INVOKESTATIC_com_bytedance_lego_init_util_InitLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, r1 + ' ' + r2);
    }

    public final boolean isDebug() {
        return InitScheduler.INSTANCE.isDebug$initscheduler_release();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_lego_init_util_InitLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_lego_init_util_InitLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_lego_init_util_InitLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_lego_init_util_InitLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
