package bytedance.jvm.time.temporal;

import bytedance.jvm.time.Duration;

/* JADX INFO: loaded from: classes28.dex */
public interface m {
    <R extends b> R addTo(R r100, long r101);

    long between(b r100, b r101);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();

    boolean isSupportedBy(b r100);

    boolean isTimeBased();
}
