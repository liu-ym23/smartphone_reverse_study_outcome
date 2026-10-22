package io.ktor.util.pipeline;

import e9.InterfaceC4014c;
import g9.InterfaceC4111c;
import io.ktor.util.StackFramesJvmKt;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/ktor/util/pipeline/StackWalkingFailedFrame;", "Lg9/c;", "Lio/ktor/util/CoroutineStackFrame;", "Le9/c;", "", "<init>", "()V", "Ljava/lang/StackTraceElement;", "Lio/ktor/util/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "LY8/t;", "resumeWith", "(Ljava/lang/Object;)V", "getCallerFrame", "()Lg9/c;", "callerFrame", "Lkotlin/coroutines/d;", "getContext", "()Lkotlin/coroutines/d;", "context", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StackWalkingFailedFrame implements InterfaceC4111c, InterfaceC4014c<?> {
    public static final StackWalkingFailedFrame INSTANCE = new StackWalkingFailedFrame();

    private StackWalkingFailedFrame() {
    }

    @Override // g9.InterfaceC4111c
    public InterfaceC4111c getCallerFrame() {
        return null;
    }

    @Override // e9.InterfaceC4014c
    public d getContext() {
        return EmptyCoroutineContext.f34779a;
    }

    public StackTraceElement getStackTraceElement() {
        InterfaceC5745d interfaceC5745dB = t.b(StackWalkingFailed.class);
        StackWalkingFailed stackWalkingFailed = StackWalkingFailed.INSTANCE;
        return StackFramesJvmKt.createStackTraceElement(interfaceC5745dB, "failedToCaptureStackFrame", "StackWalkingFailed.kt", 8);
    }

    @Override // e9.InterfaceC4014c
    public void resumeWith(Object result) {
        StackWalkingFailed.INSTANCE.failedToCaptureStackFrame();
    }
}
