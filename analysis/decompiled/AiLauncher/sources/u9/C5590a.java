package u9;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import t9.AbstractC5524a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lu9/a;", "Lt9/a;", "<init>", "()V", "", "from", "until", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(II)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)J", "k", "(JJ)J", "Ljava/util/Random;", "l", "()Ljava/util/Random;", "impl", "kotlin-stdlib-jdk8"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5590a extends AbstractC5524a {
    @Override // kotlin.random.Random
    public int h(int from, int until) {
        return ThreadLocalRandom.current().nextInt(from, until);
    }

    @Override // kotlin.random.Random
    public long j(long until) {
        return ThreadLocalRandom.current().nextLong(until);
    }

    @Override // kotlin.random.Random
    public long k(long from, long until) {
        return ThreadLocalRandom.current().nextLong(from, until);
    }

    @Override // t9.AbstractC5524a
    public Random l() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        p.h(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
