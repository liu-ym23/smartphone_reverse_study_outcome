package ms.bd.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q0 f39586a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f39587b;

    static {
        f39586a = new q0();
    }

    public q0() {
    }

    public static q0 a() {
        return f39586a;
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L6:
        this.f39587b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final Context b() {
        return this.f39587b;
    }
}
