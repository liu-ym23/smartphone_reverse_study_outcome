package ms.bd.c;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.HashSet;

/* JADX INFO: loaded from: classes4.dex */
public final class n {
    public static int a(Context r2) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    L5:
        return 0;
    }

    public static String a() {
        String[] r1 = {(String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "286e7e", new byte[]{44, 42, 85, 30}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b3d496", new byte[]{126, 56, 2, 73}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e1a36c", new byte[]{98, 58, 4, 72}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "807197", new byte[]{36, 55, 77, 95, 19}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "28b728", new byte[]{49, 63, 21, 78, 4}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "47866f", new byte[]{61, 60, 74, 77, 4, 120}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e1a30c", new byte[]{124, 38, 19, 80, 10, 125}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f8fb86", new byte[]{120, 52, 16, 6, 11, 52, 118}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fd7f93", new byte[]{123, 111, 74, 23, 7, 35, 96}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d03245", new byte[]{102, 51, 77, 85, 30, 44, 96}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "829fd1", new byte[]{49, 32, 69, 1, 94, 34}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "85f739", new byte[]{103, 59, 16, 86, 5, 96}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "27db51", new byte[]{49, 48, 22, 26, 7, 35}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "dfde60", new byte[]{116, 119, 2, 2}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ff0e95", new byte[]{117, 104, 66, 18, 13, 49, 109, 70, 115, 62}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "773097", new byte[]{43, 48, 73, 80, 19}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8666b9", new byte[]{37, 61, 71, 81, 72}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b28a79", new byte[]{124, 32, 71, 0, 27}), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7b81ec", new byte[]{46, 111, 69, 74, 72}), String.class, "com.obric.aiagent.plugin")};
        HashSet r0 = new HashSet();
        Method r2 = ZeusTransformUtils.forName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "40ac29", new byte[]{36, 60, 22, 5, 2, 39, 51, 95, 63, 32, 107, 1, 23, 5, 27, 39, 52, 20, 29, 50, 43, 51, 21, 18, 31}), String.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDeclaredMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "da560b", new byte[]{121, 106, 85, 86, 60, 112, 117, 86, 109, 101, 112, 112}), String.class, "com.obric.aiagent.plugin"), new Class[0]);     // Catch: Exception -> L16
        r2.setAccessible(true);     // Catch: Exception -> L16
        String[] r3 = (String[]) ZeusTransformUtils.preCheckCast(r2.invoke(null, new Object[0]), String[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16
        if (r3 == null) goto L15;
        int r4 = r3.length;     // Catch: Exception -> L16
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L15;
        String r6 = r3[r5];     // Catch: Exception -> L16
        int r7 = 0;
    L8:
        if (r7 >= 19) goto L13;
        String r9 = r1[r7];     // Catch: Exception -> L16
        if (r6.toLowerCase().contains(r9) == false) goto L12;
        r0.add(r9);     // Catch: Exception -> L16
    L12:
        r7 = r7 + 1;
        goto L8
    L13:
        r5 = r5 + 1;
    L15:
        return r0.toString();
    }

    private static int b(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        PowerManager r0 = (PowerManager) ZeusTransformUtils.preCheckCast(r10.getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ccaec9", new byte[]{98, 110, 5, 20, 78}), String.class, "com.obric.aiagent.plugin")), PowerManager.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (Build.VERSION.SDK_INT < 20) goto L8;
        boolean r1 = r0.isInteractive();
    L9:
        if (r1 == true) goto L12;
        return 1;
    L12:
        KeyguardManager r11 = (KeyguardManager) ZeusTransformUtils.preCheckCast(r10.getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f3e549", new byte[]{124, 52, 15, 70, 30, 47, 119, 22}), String.class, "com.obric.aiagent.plugin")), KeyguardManager.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L16;
        return 0;
    L16:
        if (r11.inKeyguardRestrictedInputMode() == false) goto L19;
        return 2;
    L19:
        return 3;
    L8:
        r1 = r0.isScreenOn();
        goto L9
    }
}
