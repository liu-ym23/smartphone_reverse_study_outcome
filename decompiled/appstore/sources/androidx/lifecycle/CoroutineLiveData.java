package androidx.lifecycle;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.x1;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutineLiveData extends u {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BlockRunner f3419m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public EmittedSource f3420n;

    public CoroutineLiveData(CoroutineContext r10, long r11, Function2 r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r12, "block");
        CompletableJob r13 = x1.a((Job) r10.get(Job.Key));
        this.f3419m = new BlockRunner(this, r12, r11, kotlinx.coroutines.d0.a(kotlinx.coroutines.l0.c().e().plus(r10).plus(r13)), new AnonymousClass1(this));
    }

    public static final /* synthetic */ void s(CoroutineLiveData r10, BlockRunner r11) {
        r10.f3419m = r11;
    }

    @Override // androidx.lifecycle.u, androidx.lifecycle.LiveData
    public void k() {
        super.k();
        BlockRunner r10 = this.f3419m;
        if (r10 == null) goto L6;
        r10.h();
        return;
    }

    @Override // androidx.lifecycle.u, androidx.lifecycle.LiveData
    public void l() {
        super.l();
        BlockRunner r10 = this.f3419m;
        if (r10 == null) goto L6;
        r10.g();
        return;
    }

    public final Object t(Continuation r10) {
        if ((r10 instanceof CoroutineLiveData$clearSource$1) == false) goto L7;
        CoroutineLiveData$clearSource$1 r11 = (CoroutineLiveData$clearSource$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        CoroutineLiveData this = (CoroutineLiveData) r11.L$0;
        kotlin.c.b(r13);
    L19:
        this.f3420n = null;
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r13);
        EmittedSource r16 = this.f3420n;
        if (r16 == null) goto L19;
        r11.L$0 = this;
        r11.label = 1;
        if (r16.b(r11) != r14) goto L19;
        return r14;
    L7:
        r11 = new CoroutineLiveData$clearSource$1(this, r10);
        goto L8
    }

    public final Object u(LiveData r10, Continuation r11) {
        if ((r11 instanceof CoroutineLiveData$emitSource$1) == false) goto L7;
        CoroutineLiveData$emitSource$1 r12 = (CoroutineLiveData$emitSource$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        CoroutineLiveData this = (CoroutineLiveData) r12.L$0;
        kotlin.c.b(r14);
    L22:
        EmittedSource r17 = (EmittedSource) r14;
        this.f3420n = r17;
        return r17;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (LiveData) r12.L$1;
        this = (CoroutineLiveData) r12.L$0;
        kotlin.c.b(r14);
    L19:
        r12.L$0 = this;
        r12.L$1 = null;
        r12.label = 2;
        r14 = CoroutineLiveDataKt.a(this, r10, r12);
        if (r14 != r15) goto L22;
        return r15;
    L16:
        kotlin.c.b(r14);
        r12.L$0 = this;
        r12.L$1 = r10;
        r12.label = 1;
        if (t(r12) != r15) goto L19;
        return r15;
    L7:
        r12 = new CoroutineLiveData$emitSource$1(this, r11);
        goto L8
    }
}
