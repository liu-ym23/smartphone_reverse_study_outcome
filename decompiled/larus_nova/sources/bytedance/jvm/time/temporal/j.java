package bytedance.jvm.time.temporal;

import bytedance.jvm.time.format.ResolverStyle;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public interface j {
    <R extends b> R adjustInto(R r100, long r101);

    long getFrom(d r100);

    boolean isDateBased();

    boolean isSupportedBy(d r100);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(d r100);

    d resolve(Map<j, Long> r100, d r101, ResolverStyle r102);

    String toString();
}
