package kotlinx.coroutines.scheduling;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class Task implements Runnable {
    public long submissionTime;
    public boolean taskContext;

    public Task(long j10, boolean z) {
        this.submissionTime = j10;
        this.taskContext = z;
    }

    public Task() {
        this(0L, false);
    }
}
