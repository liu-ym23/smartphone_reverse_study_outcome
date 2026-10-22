package b46;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class g<T> implements Comparator<T> {
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((f16.b) r101).f475063d), Long.valueOf(((f16.b) r100).f475063d));
    }
}
