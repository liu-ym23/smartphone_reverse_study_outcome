package androidx.lifecycle;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class BlockRunner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineLiveData f3412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2 f3413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f3415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0 f3416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Job f3417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f3418g;

    public BlockRunner(CoroutineLiveData r10, Function2 r11, long r12, CoroutineScope r13, Function0 r14) {
        kotlin.jvm.internal.q.g(r10, "liveData");
        kotlin.jvm.internal.q.g(r11, "block");
        kotlin.jvm.internal.q.g(r13, "scope");
        kotlin.jvm.internal.q.g(r14, "onDone");
        this.f3412a = r10;
        this.f3413b = r11;
        this.f3414c = r12;
        this.f3415d = r13;
        this.f3416e = r14;
    }

    public static final /* synthetic */ Function2 a(BlockRunner r10) {
        return r10.f3413b;
    }

    public static final /* synthetic */ CoroutineLiveData b(BlockRunner r10) {
        return r10.f3412a;
    }

    public static final /* synthetic */ Function0 c(BlockRunner r10) {
        return r10.f3416e;
    }

    public static final /* synthetic */ Job d(BlockRunner r10) {
        return r10.f3417f;
    }

    public static final /* synthetic */ long e(BlockRunner r10) {
        return r10.f3414c;
    }

    public static final /* synthetic */ void f(BlockRunner r10, Job r11) {
        r10.f3417f = r11;
    }

    public final void g() {
        if (this.f3418g != null) goto L7;
        this.f3418g = kotlinx.coroutines.h.d(this.f3415d, kotlinx.coroutines.l0.c().e(), null, new BlockRunner$cancel$1(this, null), 2, null);
        return;
    L7:
        throw new IllegalStateException("Cancel call cannot happen without a maybeRun");
    }

    public final void h() {
        Job r10 = this.f3418g;
        if (r10 == null) goto L5;
        Job.a.b(r10, null, 1, null);
    L5:
        this.f3418g = null;
        if (this.f3417f == null) goto L8;
        return;
    L8:
        this.f3417f = kotlinx.coroutines.h.d(this.f3415d, null, null, new BlockRunner$maybeRun$1(this, null), 3, null);
    }
}
