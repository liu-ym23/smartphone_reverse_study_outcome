package com.obric.aiagent.utils.shared_state;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentControlSDK.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String TAG = "AgentControlSDK";

    public static void a(Context r3, Object[] r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "AgentControlSDK.enable() called, package: " + r5.getPackageName());
        a(r5, true, r4);
    }

    public static void b(Context r3, Object[] r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "AgentControlSDK.disable() called, package: " + r5.getPackageName());
        a(r5, false, r4);
    }

    public static boolean a(Context r3) {
        boolean r4 = b.f22344a.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        ILogDepend.Companion.d(TAG, "Checking enabled state from SharedStateManager: " + r4);
        return r4;
    }

    private static void a(Context r18, boolean r19, Object[] r20) {
        String r3 = "com.obric.aiagent.plugin";
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        PackageManager r4 = r0.getPackageManager();
        int r5 = 1;
        if (r19 == false) goto L5;
        int r6 = 1;
    L6:
        String r7 = r0.getPackageName();
        if (r20 != null) goto L9;
    L56:
        ILogDepend.Companion.w(TAG, "Components array is null or empty, skipping update");
        return;
    L9:
        if (r20.length == 0) goto L56;
        ILogDepend.Companion r1 = ILogDepend.Companion;
        StringBuilder r9 = new StringBuilder().append("Starting to update ").append(r20.length).append(" components to ");
        if (r19 == false) goto L14;
        String r12 = "ENABLED";
    L15:
        r1.d(TAG, r9.append(r12).toString());
        int r10 = r20.length;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L16:
        if (r13 >= r10) goto L54;
        Object r2 = r20[r13];
        if (ZeusTransformUtils.instanceOf(r2, Class.class) == false) goto L22;
        String r8 = ((Class) ZeusTransformUtils.preCheckCast(r2, Class.class, r3)).getName();
    L20:
        String r16 = r8;
        ZeusTransformUtils.setComponentEnabledSetting(r4, new ComponentName(r7, r16), r6, r5);     // Catch: Exception -> L38 IllegalArgumentException -> L41 SecurityException -> L44
        ILogDepend.Companion r11 = ILogDepend.Companion;     // Catch: Exception -> L38 IllegalArgumentException -> L41 SecurityException -> L44
        String r17 = r3;
        StringBuilder r21 = new StringBuilder().append("Update component ").append(r16).append(" state to ");     // Catch: Exception -> L32 IllegalArgumentException -> L34 SecurityException -> L36
        if (r19 == false) goto L29;
        String r22 = "ENABLED";
    L30:
        r11.d(TAG, r21.append(r22).toString());     // Catch: Exception -> L32 IllegalArgumentException -> L34 SecurityException -> L36
        r14 = r14 + 1;
        r4 = r4;
    L53:
        r13 = r13 + 1;
        r3 = r17;
        r4 = r4;
        r5 = 1;
        goto L16
    L29:
        r22 = "DISABLED";
    L34:
        e = e;
    L43:
        ILogDepend.Companion.e(TAG, "IllegalArgumentException: Component not found " + r16 + ": " + e.getMessage());
    L52:
        r15 = r15 + 1;
    L36:
        e = e;
    L46:
        ILogDepend.Companion.e(TAG, "SecurityException: Failed to update component " + r16 + ": " + e.getMessage());
    L32:
        e = e;
    L40:
        ILogDepend.Companion.e(TAG, "Exception: Failed to update component " + r16 + ": " + e.getMessage() + ", type: " + e.getClass().getSimpleName());
        goto L52
    L41:
        e = e;
        r17 = r3;
    L44:
        e = e;
        r17 = r3;
    L38:
        e = e;
        r17 = r3;
        goto L40
    L22:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L47;
        r8 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, r3);
        goto L20
    L47:
        r17 = r3;
        ILogDepend.Companion r23 = ILogDepend.Companion;
        StringBuilder r24 = new StringBuilder().append("Invalid component type: ");
        if (r2 == null) goto L50;
        String r25 = r2.getClass().getName();
    L51:
        r23.e(TAG, r24.append(r25).toString());
        goto L52
    L50:
        r25 = "null";
        goto L51
    L54:
        ILogDepend.Companion.d(TAG, "Update components completed. Success: " + r14 + ", Failed: " + r15 + ", Total: " + r20.length);
        return;
    L14:
        r12 = "DISABLED";
        goto L15
    L5:
        r6 = 2;
        goto L6
    }
}
