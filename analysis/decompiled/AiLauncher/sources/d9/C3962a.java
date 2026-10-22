package d9;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/concurrent/atomics/AtomicLong;", "", Const.INTENT_KEY_APIKEY, "(Ljava/util/concurrent/atomic/AtomicLong;)J", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/concurrent/atomics/AtomicsKt")
/* renamed from: d9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C3962a {
    public static long a(AtomicLong atomicLong) {
        p.i(atomicLong, "<this>");
        return atomicLong.addAndGet(1L);
    }
}
