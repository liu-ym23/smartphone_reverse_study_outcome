package ms.bd.c;

import android.content.Context;
import android.location.LocationManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes4.dex */
public final class o0 {
    public static p0 a(Context r2, String r3) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    L5:
        th = move-exception;
        return p0.a(th);
    }

    private static p0 b(Context r10, String r11) {
        LocationManager r12 = (LocationManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin")).getSystemService((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f9b15c", new byte[]{123, 52, 18, 68, 30, 125, 106, 22}), String.class, "com.obric.aiagent.plugin")), LocationManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        if (r12 != null) goto L7;
        return p0.a(-10);
    L7:
        Field[] r0 = r12.getClass().getDeclaredFields();
        if (r0 != null) goto L12;
        int r13 = -20;
    L11:
        return p0.a(r13);
    L12:
        int r1 = r0.length;
        int r2 = 0;
    L13:
        Object r3 = null;
        if (r2 >= r1) goto L33;
        Field r4 = r0[r2];
        r4.setAccessible(true);
        Object r5 = r4.get(r12);     // Catch: IllegalAccessException -> L32
        if (r5 == null) goto L31;
        if (ZeusTransformUtils.instanceOf(r5, String.class) == true) goto L31;
        Class<?>[] r6 = r5.getClass().getInterfaces();
        if (r6 == null) goto L31;
        if (r6.length == 0) goto L31;
        if (r11.equals(r6[0].getName()) == false) goto L31;
        Field r14 = r4;
        r3 = r5;
    L34:
        if (r3 != null) goto L37;
        r13 = -22;
        goto L11
    L37:
        return new p0(r14.getName(), r3.getClass().getName(), ZeusTransformUtils.instanceOf(r3, Proxy.class) ? 1 : 0);
    L31:
        r2 = r2 + 1;
    L32:
        r13 = -21;
        goto L11
    L33:
        r14 = null;
    L38:
        r13 = -11;
        goto L11
    }
}
