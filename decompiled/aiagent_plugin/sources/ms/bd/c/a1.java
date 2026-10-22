package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.volcengine.zeus.LocalBroadcastManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class a1 extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39447a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f39448b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a1 f39449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f39450d;

    static {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6a77c4", new byte[]{41, 108, 80, 74, 90, 42, 54, 65, 114, 110, 40, 109}), String.class, "com.obric.aiagent.plugin");
        f39447a = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8024ef", new byte[]{42, 61, 76, 14, 88, 104, 47, 20, 103, 101, 39, 49, 68, 14, 87, 116, 47, 16, 112, 97, 42, 124, 79, 79, 78, 120, 61, 24, 96, 101, 61, 59, 78, 78, 20, 125, 50, 7, 102, 42, 38, 60}), String.class, "com.obric.aiagent.plugin");
        f39448b = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3a24db", new byte[]{33, 108, 76, 14, 89, 108, 36, 69, 103, 101, 44, 96, 68, 14, 86, 112, 36, 65, 112, 97, 33, 45, 79, 79, 79, 124, 54, 73, 96, 101, 54, 106, 78, 78, 21, 121, 57, 86, 102, 42, 45, 101, 71}), String.class, "com.obric.aiagent.plugin");
        f39450d = false;
    }

    public a1() {
    }

    public static void a(Context r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
        if (f39450d == true) goto L15;
        String r0 = null;
        boolean r3 = false;
        BufferedReader r5 = new BufferedReader(new FileReader(String.format(Locale.US, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d03448", new byte[]{58, 34, 82, 79, 8, 96, 34, 21, 45, 103, 120, 54, 76, 73, 5, 42}), String.class, "com.obric.aiagent.plugin"), new Object[]{Integer.valueOf(Process.myPid())})));     // Catch: Exception -> L12
        r0 = r5.readLine().trim();     // Catch: Exception -> L12
        r5.close();     // Catch: Exception -> L12
    L6:
        if (r0 == null) goto L9;
        r3 = r0.equals(r16.getPackageName());
    L9:
        if (r3 == false) goto L16;
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d9a5d4", new byte[]{71, 62, 21, 72, 72, 55, 98, 10, 112, 107, 122, 47, 27, 71, 82, 32, 102, 12, 57, 106, 123, 40, 92}), String.class, "com.obric.aiagent.plugin");
        f39449c = new a1();
        IntentFilter r2 = new IntentFilter();
        r2.addAction(f39447a);
        r2.addAction(f39448b);
        LocalBroadcastManager.getInstance(r16).registerReceiver(f39449c, r2);
        f39450d = true;
        return;
    L16:
        return;
    }

    public final void onReceive(Context r9, Intent r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        String r11 = r10.getAction();
        String r1 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b4a2d9", new byte[]{93, 57, 6, 79, 93, 39, 98, 20, 36, 107, 124, 56, 82, 84, 94, 45, 100, 28, 38, 103, 119, 108, 82, 71, 88, 58, 104, 26, 62, 34, 46, 118, 87, 85, 21}), String.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L5;
        return;
    L5:
        byte r2 = -1;
        int r3 = r11.hashCode();
        if (r3 == (-1125048048)) goto L14;
        if (r3 == (-516751266)) goto L11;
    L16:
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        String r12 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "28ff03", new byte[]{22, 52, 30, 28, 0, 51, 63, 89, 57, 57, 55, 51, 19, 27, 12, 37, 37, 16, 56, 56, 99, 40, 16, 17, 10, 45, 39, 28, 51, 120}), String.class, "com.obric.aiagent.plugin");
        return;
    L19:
        l0.a();
        return;
    L20:
        l0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r10);
        return;
    L11:
        if (r11.equals(f39448b) == false) goto L16;
        r2 = 1;
        goto L16
    L14:
        if (r11.equals(f39447a) == false) goto L16;
        r2 = 0;
        goto L16
    }
}
