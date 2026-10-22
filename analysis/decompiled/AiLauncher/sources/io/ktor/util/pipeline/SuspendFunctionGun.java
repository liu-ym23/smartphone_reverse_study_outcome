package io.ktor.util.pipeline;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.f;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.p;
import p9.q;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004Bc\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012J\u0010\f\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000b0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001a\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0090@¢\u0006\u0004\b\u001f\u0010\u001eJ\u001d\u0010$\u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0000¢\u0006\u0004\b\"\u0010#RX\u0010\f\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010%R \u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010&\u001a\u0004\b'\u0010(R\"\u0010\u001c\u001a\u00028\u00008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0016R\"\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00102R\u0014\u00107\u001a\u0002048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lio/ktor/util/pipeline/SuspendFunctionGun;", "", "TSubject", "TContext", "Lio/ktor/util/pipeline/PipelineContext;", "initial", "context", "", "Lkotlin/Function3;", "Le9/c;", "LY8/t;", "Lio/ktor/util/pipeline/PipelineInterceptor;", "blocks", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/List;)V", "", "direct", "loop", "(Z)Z", "Lkotlin/Result;", "result", "resumeRootWith", "(Ljava/lang/Object;)V", "discardLastRootContinuation", "()V", "finish", "proceed", "(Le9/c;)Ljava/lang/Object;", "subject", "proceedWith", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "execute$ktor_utils", "execute", "continuation", "addContinuation$ktor_utils", "(Le9/c;)V", "addContinuation", "Ljava/util/List;", "Le9/c;", "getContinuation$ktor_utils", "()Le9/c;", "Ljava/lang/Object;", "getSubject", "()Ljava/lang/Object;", "setSubject", "", "suspensions", "[Le9/c;", "", "lastSuspensionIndex", "I", "index", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "coroutineContext", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SuspendFunctionGun<TSubject, TContext> extends PipelineContext<TSubject, TContext> {
    private final List<q<PipelineContext<TSubject, TContext>, TSubject, InterfaceC4014c<? super t>, Object>> blocks;
    private final InterfaceC4014c<t> continuation;
    private int index;
    private int lastSuspensionIndex;
    private TSubject subject;
    private final InterfaceC4014c<TSubject>[] suspensions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuspendFunctionGun(TSubject initial, TContext context, List<? extends q<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super InterfaceC4014c<? super t>, ? extends Object>> blocks) {
        super(context);
        p.i(initial, "initial");
        p.i(context, "context");
        p.i(blocks, "blocks");
        this.blocks = blocks;
        this.continuation = new SuspendFunctionGun$continuation$1(this);
        this.subject = initial;
        this.suspensions = new InterfaceC4014c[blocks.size()];
        this.lastSuspensionIndex = -1;
    }

    private final void discardLastRootContinuation() {
        int i10 = this.lastSuspensionIndex;
        if (i10 < 0) {
            throw new IllegalStateException("No more continuations to resume");
        }
        InterfaceC4014c<TSubject>[] interfaceC4014cArr = this.suspensions;
        this.lastSuspensionIndex = i10 - 1;
        interfaceC4014cArr[i10] = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean loop(boolean direct) {
        int i10;
        do {
            i10 = this.index;
            if (i10 == this.blocks.size()) {
                if (direct) {
                    return true;
                }
                Result.Companion companion = Result.INSTANCE;
                resumeRootWith(Result.b(getSubject()));
                return false;
            }
            this.index = i10 + 1;
            try {
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                resumeRootWith(Result.b(C4849c.a(th)));
                return false;
            }
        } while (PipelineJvmKt.pipelineStartCoroutineUninterceptedOrReturn(this.blocks.get(i10), this, getSubject(), this.continuation) != C4063a.g());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeRootWith(Object result) {
        int i10 = this.lastSuspensionIndex;
        if (i10 < 0) {
            throw new IllegalStateException("No more continuations to resume");
        }
        InterfaceC4014c<TSubject> interfaceC4014c = this.suspensions[i10];
        p.f(interfaceC4014c);
        InterfaceC4014c<TSubject>[] interfaceC4014cArr = this.suspensions;
        int i11 = this.lastSuspensionIndex;
        this.lastSuspensionIndex = i11 - 1;
        interfaceC4014cArr[i11] = null;
        if (!Result.g(result)) {
            interfaceC4014c.resumeWith(result);
            return;
        }
        Throwable thE = Result.e(result);
        p.f(thE);
        interfaceC4014c.resumeWith(Result.b(C4849c.a(StackTraceRecoverKt.recoverStackTraceBridge(thE, interfaceC4014c))));
    }

    public final void addContinuation$ktor_utils(InterfaceC4014c<? super TSubject> continuation) {
        p.i(continuation, "continuation");
        InterfaceC4014c<TSubject>[] interfaceC4014cArr = this.suspensions;
        int i10 = this.lastSuspensionIndex + 1;
        this.lastSuspensionIndex = i10;
        interfaceC4014cArr[i10] = continuation;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object execute$ktor_utils(TSubject tsubject, InterfaceC4014c<? super TSubject> interfaceC4014c) {
        this.index = 0;
        if (this.blocks.size() == 0) {
            return tsubject;
        }
        setSubject(tsubject);
        if (this.lastSuspensionIndex < 0) {
            return proceed(interfaceC4014c);
        }
        throw new IllegalStateException("Already started");
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public void finish() {
        this.index = this.blocks.size();
    }

    public final InterfaceC4014c<t> getContinuation$ktor_utils() {
        return this.continuation;
    }

    @Override // io.ktor.util.pipeline.PipelineContext, Ua.M
    public d getCoroutineContext() {
        return this.continuation.getContext();
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public TSubject getSubject() {
        return this.subject;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object proceed(InterfaceC4014c<? super TSubject> interfaceC4014c) {
        Object objG;
        if (this.index == this.blocks.size()) {
            objG = getSubject();
        } else {
            addContinuation$ktor_utils(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c));
            if (loop(true)) {
                discardLastRootContinuation();
                objG = getSubject();
            } else {
                objG = C4063a.g();
            }
        }
        if (objG == C4063a.g()) {
            f.c(interfaceC4014c);
        }
        return objG;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object proceedWith(TSubject tsubject, InterfaceC4014c<? super TSubject> interfaceC4014c) {
        setSubject(tsubject);
        return proceed(interfaceC4014c);
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public void setSubject(TSubject tsubject) {
        p.i(tsubject, "<set-?>");
        this.subject = tsubject;
    }
}
