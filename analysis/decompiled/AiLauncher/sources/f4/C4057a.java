package f4;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lf4/a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()I", "Ljava/util/concurrent/atomic/AtomicInteger;", "counter", "Ljava/util/concurrent/atomic/AtomicInteger;", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: f4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4057a {
    public static final C4057a INSTANCE = new C4057a();
    private static final AtomicInteger counter = new AtomicInteger(0);

    public final int a() {
        return counter.incrementAndGet();
    }
}
