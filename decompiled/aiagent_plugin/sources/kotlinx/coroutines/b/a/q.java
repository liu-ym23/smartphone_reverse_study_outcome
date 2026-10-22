package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface q<T> extends kotlinx.coroutines.b.h<T> {

    /* JADX INFO: compiled from: ChannelFlow.kt */
    public static final class a {
        public static /* synthetic */ kotlinx.coroutines.b.h a(q r2, d.c.g r3, int r4, kotlinx.coroutines.a.a r5, int r6, Object r7) {
            q r8 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.aiagent.plugin");
            d.c.g r9 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L16;
            if ((r6 & 1) == 0) goto L8;
            r9 = (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
        L8:
            if ((r6 & 2) == 0) goto L11;
            r4 = -3;
        L11:
            if ((r6 & 4) == 0) goto L14;
            r5 = kotlinx.coroutines.a.a.f38771a;
        L14:
            return r8.a_(r9, r4, r5);
        L16:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    kotlinx.coroutines.b.h<T> a_(d.c.g r1, int r2, kotlinx.coroutines.a.a r3);
}
