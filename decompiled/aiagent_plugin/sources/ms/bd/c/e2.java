package ms.bd.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public final class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class f39493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f39494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f39495d;

    public e2(Context r24) {
        this.f39492a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        Class r14 = ZeusTransformUtils.forName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2b9cee", new byte[]{32, 111, 71, 89, 91, 124, 53, 81, 103, 58, 39, 46, 67, 19, 20, 123, 60, 83, 100, 125, 10, 100, 122, 5, 85, 100, 56, 71, 109, 33, 10, 109, 90, 27}), String.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Exception -> L6
        this.f39493b = r14;     // Catch: Exception -> L6
        this.f39494c = r14.newInstance();     // Catch: Exception -> L6
    L10:
        this.f39495d = this.f39493b.getMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "71aa0b", new byte[]{33, 54, 6, 58, 46, 92, 16}), String.class, "com.obric.aiagent.plugin"), new Class[]{Context.class});     // Catch: Exception -> L7
        return;
    }

    public final String a() {
        if (this.f39493b != null) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (r0 == true) goto L13;
        return null;
    L13:
        Context r1 = this.f39492a;
        Method r4 = this.f39495d;
        Object r5 = this.f39494c;
        if (r5 == null) goto L22;
        if (r4 == null) goto L23;
        return (String) ZeusTransformUtils.preCheckCast(r4.invoke(r5, new Object[]{r1}), String.class, "com.obric.aiagent.plugin");
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L5:
        if (this.f39494c == null) goto L9;
        if (this.f39495d == null) goto L9;
        r0 = true;
        goto L11
    }
}
