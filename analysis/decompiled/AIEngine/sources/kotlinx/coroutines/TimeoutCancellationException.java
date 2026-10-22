package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TimeoutCancellationException extends CancellationException {
    public final transient Job coroutine;

    public TimeoutCancellationException(String str, Job job) {
        super(str);
        this.coroutine = job;
    }

    public TimeoutCancellationException(String str) {
        this(str, null);
    }
}
