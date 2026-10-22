package ms.bd.c;

import android.content.Context;
import android.os.Process;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class f1 {
    public static boolean a() {
        return a(new String[]{(String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "066dd3", new byte[]{32, 58, 65, 2, 84, 45, 55, 89, 119, 49, 51, 57, 76, 3, 72, 45, 60, 25, 41, 21, 2, 23, 96, 35, 104, 27, 4, 62, 65, 29, 30, 7, 113, 49, 111, 1}), String.class, "com.obric.aiagent.plugin")});
    }

    public static boolean a(String... r7) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        int r2 = r7.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L9;
        if (r0.checkPermission(r7[r3], Process.myPid(), Process.myUid()) != 0) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    L11:
        return false;
    }
}
