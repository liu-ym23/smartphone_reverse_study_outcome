package kotlinx.coroutines.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.bo;

/* JADX INFO: compiled from: Channels.common.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class k {
    public static final void a(s<?> r3, Throwable r4) {
        s r5 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.aiagent.plugin");
        CancellationException r0 = null;
        if (r4 != null) goto L5;
    L9:
        r5.a(r0);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, CancellationException.class) == false) goto L7;
        r0 = (CancellationException) ZeusTransformUtils.preCheckCast(r4, CancellationException.class, "com.obric.aiagent.plugin");
    L7:
        if (r0 != null) goto L9;
        r0 = bo.a("Channel was consumed, consumer had failed", r4);
        goto L9
    }
}
