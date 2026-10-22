package kotlinx.coroutines.android;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.g;
import d.h.b.h;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bf;
import kotlinx.coroutines.cm;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends cm implements aw {
    public /* synthetic */ b(h r1) {
        this();
    }

    private b() {
    }

    public bf a(long r3, Runnable r5, g r6) {
        return aw.a.a(this, r3, (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.aiagent.plugin"));
    }
}
