package kotlinx.coroutines.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: Mutex.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: kotlinx.coroutines.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Mutex.kt */
    public static final class C1058a {
        public static /* synthetic */ boolean a(a r2, Object r3, int r4, Object r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L8;
            r3 = null;
        L8:
            return r6.a(r3);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }

        public static /* synthetic */ Object a(a r2, Object r3, d.c.d r4, int r5, Object r6) {
            a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 1) == 0) goto L8;
            r3 = null;
        L8:
            return r7.a(r3, r8);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }

        public static /* synthetic */ void b(a r2, Object r3, int r4, Object r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L7;
            r3 = null;
        L7:
            r6.b(r3);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }

    Object a(Object r1, d.c.d<? super x> r2);

    boolean a();

    boolean a(Object r1);

    void b(Object r1);
}
