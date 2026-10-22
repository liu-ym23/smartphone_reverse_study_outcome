package Nb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/util/concurrent/atomic/AtomicInteger;", "", "bits", Const.INTENT_KEY_APIKEY, "(Ljava/util/concurrent/atomic/AtomicInteger;I)I", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class s {
    public static final int a(AtomicInteger atomicInteger, int i10) {
        int i11;
        int i12;
        kotlin.jvm.internal.p.i(atomicInteger, "<this>");
        do {
            i11 = atomicInteger.get();
            if ((i11 & i10) != 0) {
                return 0;
            }
            i12 = i11 | i10;
        } while (!atomicInteger.compareAndSet(i11, i12));
        return i12;
    }
}
