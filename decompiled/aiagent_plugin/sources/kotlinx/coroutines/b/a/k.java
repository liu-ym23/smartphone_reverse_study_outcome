package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.aq;

/* JADX INFO: compiled from: FlowExceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends CancellationException {
    public k() {
        super("Child of the scoped flow was cancelled");
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (aq.b() == true) goto L5;
        setStackTrace(new StackTraceElement[0]);
        return (Throwable) ZeusTransformUtils.preCheckCast(this, Throwable.class, "com.obric.aiagent.plugin");
    L5:
        return super.fillInStackTrace();
    }
}
