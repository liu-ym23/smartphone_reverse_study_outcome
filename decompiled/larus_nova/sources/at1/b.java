package at1;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.android.livesdk.coupon.a) r100).f121824e), Integer.valueOf(((com.bytedance.android.livesdk.coupon.a) r101).f121824e));
    }
}
