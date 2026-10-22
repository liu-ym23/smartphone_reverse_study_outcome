package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface aw {

    /* JADX INFO: compiled from: Delay.kt */
    public static final class a {
        public static bf a(aw r2, long r3, Runnable r5, d.c.g r6) {
            aw r4 = (aw) ZeusTransformUtils.wrapperContextForParams(r2, aw.class, "com.obric.aiagent.plugin");
            Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
            d.c.g r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r6, d.c.g.class, "com.obric.aiagent.plugin");
            return at.a().a(r3, r7, r8);
        }
    }

    bf a(long r1, Runnable r3, d.c.g r4);

    void a(long r1, n<? super d.x> r3);
}
