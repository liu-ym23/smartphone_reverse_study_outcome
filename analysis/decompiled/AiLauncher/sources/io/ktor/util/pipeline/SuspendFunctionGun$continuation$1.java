package io.ktor.util.pipeline;

import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4111c;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0015\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"io/ktor/util/pipeline/SuspendFunctionGun$continuation$1", "Le9/c;", "LY8/t;", "Lg9/c;", "Lio/ktor/util/CoroutineStackFrame;", "peekContinuation", "()Le9/c;", "Ljava/lang/StackTraceElement;", "Lio/ktor/util/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "currentIndex", "I", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "getCallerFrame", "()Lg9/c;", "callerFrame", "Lkotlin/coroutines/d;", "getContext", "()Lkotlin/coroutines/d;", "context", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SuspendFunctionGun$continuation$1 implements InterfaceC4014c<t>, InterfaceC4111c {
    private int currentIndex = Integer.MIN_VALUE;
    final /* synthetic */ SuspendFunctionGun<TSubject, TContext> this$0;

    public SuspendFunctionGun$continuation$1(SuspendFunctionGun<TSubject, TContext> suspendFunctionGun) {
        this.this$0 = suspendFunctionGun;
    }

    private final InterfaceC4014c<?> peekContinuation() {
        if (this.currentIndex == Integer.MIN_VALUE) {
            this.currentIndex = ((SuspendFunctionGun) this.this$0).lastSuspensionIndex;
        }
        if (this.currentIndex < 0) {
            this.currentIndex = Integer.MIN_VALUE;
            return null;
        }
        try {
            InterfaceC4014c<?>[] interfaceC4014cArr = ((SuspendFunctionGun) this.this$0).suspensions;
            int i10 = this.currentIndex;
            InterfaceC4014c<?> interfaceC4014c = interfaceC4014cArr[i10];
            if (interfaceC4014c == null) {
                return StackWalkingFailedFrame.INSTANCE;
            }
            this.currentIndex = i10 - 1;
            return interfaceC4014c;
        } catch (Throwable unused) {
            return StackWalkingFailedFrame.INSTANCE;
        }
    }

    @Override // g9.InterfaceC4111c
    public InterfaceC4111c getCallerFrame() {
        InterfaceC4014c<?> interfaceC4014cPeekContinuation = peekContinuation();
        if (interfaceC4014cPeekContinuation instanceof InterfaceC4111c) {
            return (InterfaceC4111c) interfaceC4014cPeekContinuation;
        }
        return null;
    }

    @Override // e9.InterfaceC4014c
    public d getContext() {
        InterfaceC4014c interfaceC4014c = ((SuspendFunctionGun) this.this$0).suspensions[((SuspendFunctionGun) this.this$0).lastSuspensionIndex];
        if (interfaceC4014c != this && interfaceC4014c != null) {
            return interfaceC4014c.getContext();
        }
        int i10 = ((SuspendFunctionGun) this.this$0).lastSuspensionIndex - 1;
        while (i10 >= 0) {
            int i11 = i10 - 1;
            InterfaceC4014c interfaceC4014c2 = ((SuspendFunctionGun) this.this$0).suspensions[i10];
            if (interfaceC4014c2 != this && interfaceC4014c2 != null) {
                return interfaceC4014c2.getContext();
            }
            i10 = i11;
        }
        throw new IllegalStateException("Not started");
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // e9.InterfaceC4014c
    public void resumeWith(Object result) {
        if (!Result.g(result)) {
            this.this$0.loop(false);
            return;
        }
        SuspendFunctionGun<TSubject, TContext> suspendFunctionGun = this.this$0;
        Throwable thE = Result.e(result);
        p.f(thE);
        suspendFunctionGun.resumeRootWith(Result.b(C4849c.a(thE)));
    }

    public final void setCurrentIndex(int i10) {
        this.currentIndex = i10;
    }
}
