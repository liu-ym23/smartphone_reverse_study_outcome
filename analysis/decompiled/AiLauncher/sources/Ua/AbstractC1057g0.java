package Ua;

import Ua.AbstractC1055f0;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8$X¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"LUa/g0;", "LUa/e0;", "<init>", "()V", "LY8/t;", "H1", "", "now", "LUa/f0$c;", "delayedTask", "G1", "(JLUa/f0$c;)V", "Ljava/lang/Thread;", "F1", "()Ljava/lang/Thread;", "thread", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.g0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC1057g0 extends AbstractC1053e0 {
    /* renamed from: F1 */
    public abstract Thread getThread();

    public void G1(long now, AbstractC1055f0.c delayedTask) {
        O.f6337h.U1(now, delayedTask);
    }

    public final void H1() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            C1046b.a();
            LockSupport.unpark(thread);
        }
    }
}
