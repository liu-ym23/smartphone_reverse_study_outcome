package kotlinx.coroutines.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.x;
import kotlinx.coroutines.internal.ad;
import kotlinx.coroutines.internal.au;

/* JADX INFO: compiled from: ConflatedBufferedChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
public class n<E> extends b<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f38815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f38816d;

    @Override // kotlinx.coroutines.a.b, kotlinx.coroutines.a.t
    public Object a(E r3, d.c.d<? super x> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public n(int r3, a r4, d.h.a.b<? super E, x> r5) {
        super(r3, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin"));
        this.f38815c = r3;
        this.f38816d = r4;
        boolean r6 = false;
        if (r4 == a.f38771a) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L14;
        if (r3 < 1) goto L9;
        r6 = true;
    L9:
        if (r6 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + r3 + " was specified").toString());
    L14:
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + aa.b(b.class).b() + " instead").toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // kotlinx.coroutines.a.b
    public boolean k() {
        if (this.f38816d != a.f38772b) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ <E> Object a(n<E> r3, E r4, d.c.d<? super x> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r7 = r3.a(r4, true);
        if (ZeusTransformUtils.instanceOf(r7, h.a.class) == false) goto L13;
        h.e(r7);
        d.h.a.b<E, x> r8 = r3.f38777a;
        if (r8 == null) goto L11;
        au r9 = ad.a(r8, r4, null, 2, null);
        if (r9 == null) goto L11;
        d.a.a((Throwable) ZeusTransformUtils.preCheckCast(r9, Throwable.class, "com.obric.aiagent.plugin"), r3.i());
        throw r9;
    L11:
        throw r3.i();
    L13:
        return x.f38692a;
    }

    @Override // kotlinx.coroutines.a.b, kotlinx.coroutines.a.t
    public Object a_(E r2) {
        return a(r2, false);
    }

    private final Object a(E r3, boolean r4) {
        if (this.f38816d != a.f38773c) goto L6;
        return b(r3, r4);
    L6:
        return b(r3);
    }

    private final Object b(E r3, boolean r4) {
        Object r0 = super.a_(r3);
        if (h.a(r0) == false) goto L5;
    L16:
        return r0;
    L5:
        if (h.c(r0) == true) goto L16;
        if (r4 == false) goto L15;
        d.h.a.b<E, x> r2 = this.f38777a;
        if (r2 == null) goto L15;
        au r5 = ad.a(r2, r3, null, 2, null);
        if (r5 == null) goto L15;
        throw r5;
    L15:
        return h.f38809a.a(x.f38692a);
    }
}
