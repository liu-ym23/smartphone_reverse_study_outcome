package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.internal.ah;

/* JADX INFO: compiled from: FlowCoroutine.kt */
/* JADX INFO: loaded from: classes4.dex */
final class n<T> extends ah<T> {
    public n(d.c.g r3, d.c.d<? super T> r4) {
        super((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.ci
    public boolean c(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, k.class) == false) goto L7;
        return true;
    L7:
        return e(r2);
    }
}
