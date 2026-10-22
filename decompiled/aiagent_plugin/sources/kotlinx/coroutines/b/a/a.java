package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.aq;

/* JADX INFO: compiled from: FlowExceptions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Object f38870a;

    public a(Object r2) {
        super("Flow was aborted, no more elements needed");
        this.f38870a = r2;
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
