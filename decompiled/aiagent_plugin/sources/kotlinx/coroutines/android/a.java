package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bf;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.cm;
import kotlinx.coroutines.cp;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends kotlinx.coroutines.android.b implements aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f38843a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f38844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f38845e;
    private final a f;

    /* JADX INFO: renamed from: kotlinx.coroutines.android.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Runnable.kt */
    public static final class RunnableC1045a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f38846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f38847b;

        public RunnableC1045a(n r3, a r4) {
            this.f38846a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
            this.f38847b = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f38846a.a((ai) ZeusTransformUtils.preCheckCast(this.f38847b, ai.class, "com.obric.aiagent.plugin"), x.f38692a);
        }
    }

    /* JADX INFO: compiled from: HandlerDispatcher.kt */
    static final class b extends p implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f38848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f38849b;

        b(a r3, Runnable r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
            this.f38848a = r3;
            this.f38849b = r5;
            super(1);
        }

        public final void a(Throwable r1) {
            a.a(this.f38848a).removeCallbacks(this.f38849b);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static /* synthetic */ void lambda$1COKpqEUbkopAsdBxXcVTiQdeaE(a r0, Runnable r1) {
        a(r0, r1);
    }

    public static final /* synthetic */ Handler a(a r0) {
        return r0.f38843a;
    }

    @Override // kotlinx.coroutines.cm
    public /* synthetic */ cm a() {
        return (cm) ZeusTransformUtils.preCheckCast(c(), cm.class, "com.obric.aiagent.plugin");
    }

    private a(Handler r2, String r3, boolean r4) {
        super(null);
        this.f38843a = r2;
        this.f38844d = r3;
        this.f38845e = r4;
        if (r4 == false) goto L5;
        a r5 = this;
    L6:
        this.f = r5;
        return;
    L5:
        r5 = new a(r2, r3, true);
        goto L6
    }

    public /* synthetic */ a(Handler r1, String r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public a(Handler r2, String r3) {
        this(r2, r3, false);
    }

    public a c() {
        return this.f;
    }

    @Override // kotlinx.coroutines.ai
    public boolean a(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        if (this.f38845e == true) goto L5;
    L8:
        return true;
    L5:
        if (o.a(Looper.myLooper(), this.f38843a.getLooper()) == false) goto L8;
        return false;
    }

    @Override // kotlinx.coroutines.ai
    public void a(g r3, Runnable r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        if (this.f38843a.post(r6) == true) goto L6;
        c(r5, r6);
        return;
    }

    @Override // kotlinx.coroutines.android.b, kotlinx.coroutines.aw
    public bf a(long r5, Runnable r7, g r8) {
        final Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin");
        g r10 = (g) ZeusTransformUtils.wrapperContextForParams(r8, g.class, "com.obric.aiagent.plugin");
        if (this.f38843a.postDelayed(r9, d.l.n.b(r5, 4611686018427387903L)) == true) goto L5;
        c(r10, r9);
        return (bf) ZeusTransformUtils.preCheckCast(cp.f39210a, bf.class, "com.obric.aiagent.plugin");
    L5:
        return new $$Lambda$a$1COKpqEUbkopAsdBxXcVTiQdeaE(this, r9);
    }

    private static final void a(a r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        r2.f38843a.removeCallbacks(r4);
    }

    private final void c(g r4, Runnable r5) {
        g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        ce.a(r6, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        bd.c().a(r6, r7);
    }

    @Override // kotlinx.coroutines.cm, kotlinx.coroutines.ai
    public String toString() {
        String r0 = b();
        if (r0 != null) goto L11;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        String r1 = r2.f38844d;
        if (r1 != null) goto L8;
        r1 = r2.f38843a.toString();
    L8:
        if (r2.f38845e == true) goto L10;
        return r1;
    L10:
        return r1 + ".immediate";
    L11:
        return r0;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).f38843a != this.f38843a) goto L9;
        if (((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin")).f38845e != this.f38845e) goto L9;
        return true;
    }

    public int hashCode() {
        int r0 = System.identityHashCode(this.f38843a);
        if (this.f38845e == false) goto L5;
        int r1 = 1231;
    L7:
        return r1 ^ r0;
    L5:
        r1 = 1237;
        goto L7
    }

    @Override // kotlinx.coroutines.aw
    public void a(long r6, n<? super x> r8) {
        n r9 = (n) ZeusTransformUtils.wrapperContextForParams(r8, n.class, "com.obric.aiagent.plugin");
        Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(new RunnableC1045a(r9, this), Runnable.class, "com.obric.aiagent.plugin");
        if (this.f38843a.postDelayed(r0, d.l.n.b(r6, 4611686018427387903L)) == false) goto L5;
        r9.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(this, r0), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        c(r9.getContext(), r0);
    }
}
