package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.Iterator;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
class n {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.m f38597a;

        public a(d.h.a.m r3) {
            this.f38597a = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        }

        @Override // d.n.j
        public Iterator<T> a() {
            return m.b(this.f38597a);
        }
    }

    public static final <T> j<T> a(d.h.a.m<? super l<? super T>, ? super d.c.d<? super x>, ? extends Object> r2) {
        d.h.a.m r3 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "block");
        return (j) ZeusTransformUtils.preCheckCast(new a(r3), j.class, "com.obric.aiagent.plugin");
    }

    public static final <T> Iterator<T> b(d.h.a.m<? super l<? super T>, ? super d.c.d<? super x>, ? extends Object> r3) {
        d.h.a.m r4 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "block");
        k r0 = new k();
        r0.a(d.c.a.b.b(r4, r0, (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin")));
        return (Iterator) ZeusTransformUtils.preCheckCast(r0, Iterator.class, "com.obric.aiagent.plugin");
    }
}
