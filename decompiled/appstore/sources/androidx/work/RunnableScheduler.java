package androidx.work;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface RunnableScheduler {
    void cancel(@NonNull Runnable r10);

    void scheduleWithDelay(@IntRange(from = 0) long r10, @NonNull Runnable r11);
}
