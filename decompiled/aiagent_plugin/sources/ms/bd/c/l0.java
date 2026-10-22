package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile i0 f39545a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f39546b = false;

    private static String a(Intent r9) {
        Bundle r10 = r9.getBundleExtra((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "34c5f2", new byte[]{46, 63, 6, 68, 102, 49, 53, 6}), String.class, "com.obric.aiagent.plugin"));
        if (r10 != null) goto L5;
        return null;
    L5:
        CharSequence r11 = r10.getCharSequence((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "da9c46", new byte[]{116, 115, 90, 62, 47}), String.class, "com.obric.aiagent.plugin"));
        if (TextUtils.isEmpty(r11) == false) goto L9;
        return null;
    L9:
        return r11.toString();
    }

    public static void a() {
        if (f39545a != null) goto L5;
        return;
    L5:
        if (f39546b == false) goto L9;
        f39545a.b();
        f39546b = false;
        return;
    }

    public static synchronized void a(Context r3, Intent r4) {
        monitor-enter(l0.class);
        b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);     // Catch: Throwable -> L9
        if (f39546b == true) goto L7;
        f39545a.a();     // Catch: Throwable -> L9
        f39546b = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(l0.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static String b() {
        if (f39545a != null) goto L7;
        return "";
    L7:
        return f39545a.c();
    }

    private static void b(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (f39545a == null) goto L5;
        return;
    L5:
        monitor-enter(i0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f39545a != null) goto L9;
        String r6 = a(r4);     // Catch: Throwable -> L11
        f39545a = new i0(new k0(r5), r6);     // Catch: Throwable -> L11
    L9:
        monitor-exit(i0.class);     // Catch: Throwable -> L11
    }
}
