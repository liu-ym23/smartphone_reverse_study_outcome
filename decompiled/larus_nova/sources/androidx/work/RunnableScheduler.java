package androidx.work;

/* JADX INFO: loaded from: classes3.dex */
public interface RunnableScheduler {
    void cancel(Runnable r100);

    void scheduleWithDelay(long r100, Runnable r101);
}
