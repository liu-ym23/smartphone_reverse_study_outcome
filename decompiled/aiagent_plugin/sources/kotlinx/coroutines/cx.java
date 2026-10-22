package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Supervisor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class cx {
    public static final z a(ca r2) {
        return (z) ZeusTransformUtils.preCheckCast(new cw((ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin")), z.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ z a(ca r1, int r2, Object r3) {
        ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r1, ca.class, "com.obric.aiagent.plugin");
        if ((r2 & 1) == 0) goto L6;
        r4 = null;
    L6:
        return a(r4);
    }
}
