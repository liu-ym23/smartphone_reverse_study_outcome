package d.k.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: PlatformThreadLocalRandom.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends d.k.a {
    public a() {
    }

    @Override // d.k.a
    public Random a() {
        ThreadLocalRandom r2 = ThreadLocalRandom.current();
        o.c(r2, "current(...)");
        return (Random) ZeusTransformUtils.preCheckCast(r2, Random.class, "com.obric.aiagent.plugin");
    }

    @Override // d.k.c
    public long a(long r1, long r3) {
        return ThreadLocalRandom.current().nextLong(r1, r3);
    }
}
