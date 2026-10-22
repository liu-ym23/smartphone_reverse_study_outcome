package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f39578a;

    public interface a {
        void a(String r1);
    }

    public p(a r3) {
        this.f39578a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    private static String a(String r27) {
        if (r27 != null) goto L10;
        return null;
    L10:
        Class r2 = ZeusTransformUtils.forName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "283ae9", new byte[]{34, 52, 68, 7, 85, 39, 53, 87, 109, 34, 109, 9, 89, 6, 78, 43, 60, 41, 112, 62, 51, 63, 82, 1, 83, 43, 34}), String.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        return (String) ZeusTransformUtils.preCheckCast(r2.getMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "4d45d2", new byte[]{34, 99, 83}), String.class, "com.obric.aiagent.plugin"), new Class[]{String.class, String.class}).invoke(r2, new Object[]{r27, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "eb0aa9", new byte[]{97, 110, 72, 27, 81, 57, 104}), String.class, "com.obric.aiagent.plugin")}), String.class, "com.obric.aiagent.plugin");
    L12:
        return null;
    }

    static String a(p r0) {
        r0.getClass();
        return Build.MANUFACTURER.toUpperCase();
    }

    public static boolean a() {
        String r0 = a((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "795023", new byte[]{52, 52, 8, 70, 24, 45, 56, 28, 42, 118, 35, 41, 85, 77, 2, 42, 122, 29, 105, 117, 47}), String.class, "com.obric.aiagent.plugin"));
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ae1c0f", new byte[]{101, 105, 73, 25, 0, 102, 108}), String.class, "com.obric.aiagent.plugin")) == true) goto L7;
        return true;
    }

    static /* synthetic */ a b(p r0) {
        return r0.f39578a;
    }

    public static boolean b() {
        String r0 = a((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "da1949", new byte[]{103, 108, 12, 64, 2, 59, 110, 14, 117, 96, 59, 117, 71, 95, 24, 39, 104, 78, 46, 103, 116, 110, 71}), String.class, "com.obric.aiagent.plugin"));
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e2d22e", new byte[]{97, 62, 28, 72, 2, 101, 104}), String.class, "com.obric.aiagent.plugin")) == true) goto L7;
        return true;
    }

    public final void a(Context r3) {
        new Thread(new o(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"))).start();
    }
}
