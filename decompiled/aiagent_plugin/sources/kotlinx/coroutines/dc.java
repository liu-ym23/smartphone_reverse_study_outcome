package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ThreadPoolDispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class dc {
    /* JADX INFO: renamed from: lambda$KXBS2S6Ec-emWPP4-IGKj0ITa-s, reason: not valid java name */
    public static /* synthetic */ Thread m1251lambda$KXBS2S6EcemWPP4IGKj0ITas(int r0, String r1, AtomicInteger r2, Runnable r3) {
        return a(r0, r1, r2, r3);
    }

    public static final bp a(final int r2, final String r3) {
        boolean r0 = true;
        if (r2 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L10;
        final AtomicInteger r1 = new AtomicInteger();
        return br.a((ExecutorService) ZeusTransformUtils.preCheckCast(Executors.newScheduledThreadPool(r2, new $$Lambda$dc$KXBS2S6EcemWPP4IGKj0ITas(r2, r3, r1)), ExecutorService.class, "com.obric.aiagent.plugin"));
    L10:
        throw new IllegalArgumentException(("Expected at least one thread, but " + r2 + " specified").toString());
    }

    private static final Thread a(int r2, String r3, AtomicInteger r4, Runnable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        if (r2 == 1) goto L6;
        r3 = r3 + '-' + r4.incrementAndGet();
    L6:
        Thread r0 = new Thread(r6, r3);
        r0.setDaemon(true);
        return r0;
    }
}
