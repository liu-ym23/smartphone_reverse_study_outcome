package kotlinx.coroutines.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface t<E> {

    /* JADX INFO: compiled from: Channel.kt */
    public static final class a {
        public static /* synthetic */ boolean a(t r2, Throwable r3, int r4, Object r5) {
            t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L8;
            r3 = null;
        L8:
            return r6.a(r3);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    Object a(E r1, d.c.d<? super x> r2);

    void a(d.h.a.b<? super Throwable, x> r1);

    boolean a(Throwable r1);

    Object a_(E r1);

    boolean l();
}
