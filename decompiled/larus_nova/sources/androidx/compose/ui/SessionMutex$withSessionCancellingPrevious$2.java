package androidx.compose.ui;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.SessionMutex$withSessionCancellingPrevious$2", f = "SessionMutex.kt", i = {0, 1}, l = {61, 63}, m = "invokeSuspend", n = {"newSession", "newSession"}, s = {"L$0", "L$0"})
public final class SessionMutex$withSessionCancellingPrevious$2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ AtomicReference<SessionMutex.Session<T>> $arg0;
    final /* synthetic */ Function2<T, Continuation<? super R>, Object> $session;
    final /* synthetic */ Function1<CoroutineScope, T> $sessionInitializer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SessionMutex$withSessionCancellingPrevious$2(Function1<? super CoroutineScope, ? extends T> r100, AtomicReference<SessionMutex.Session<T>> r101, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r102, Continuation<? super SessionMutex$withSessionCancellingPrevious$2> r103) {
        this.$sessionInitializer = r100;
        this.$arg0 = r101;
        this.$session = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        SessionMutex$withSessionCancellingPrevious$2 r102 = new SessionMutex$withSessionCancellingPrevious$2(this.$sessionInitializer, this.$arg0, this.$session, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
        return invoke(r100, (Continuation) r101);
    }

    public final Object invoke(CoroutineScope r100, Continuation<? super R> r101) {
        return ((SessionMutex$withSessionCancellingPrevious$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.compose.ui.SessionMutex$withSessionCancellingPrevious$2<R> for r7v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r7.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L11;
        java.lang.Object r0 = r7.L$0;
        androidx.compose.ui.SessionMutex.Session r0 = (androidx.compose.ui.SessionMutex.Session) r0;
        kotlin.ResultKt.throwOnFailure(r8);     // Catch: java.lang.Throwable -> L9
    L25:
        java.util.concurrent.atomic.AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> r3 = r7.$arg0;
    L26:
        androidx.compose.ui.SessionMutex.Session<T> r0 = (androidx.compose.ui.SessionMutex.Session<T>) r0;
        boolean r1 = r3.compareAndSet(r0, null);
        if (r1 == true) goto L31;
        java.lang.Object r1 = r3.get();
        if (r1 == r0) goto L26;
    L31:
        return r8;
    L9:
        r8 = th;
    L34:
        java.util.concurrent.atomic.AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> r1 = r7.$arg0;
    L35:
        androidx.compose.ui.SessionMutex.Session<T> r0 = (androidx.compose.ui.SessionMutex.Session<T>) r0;
        boolean r3 = r1.compareAndSet(r0, null);
        if (r3 == true) goto L40;
        java.lang.Object r3 = r1.get();
        if (r3 == r0) goto L35;
    L40:
        throw r8;
    L11:
        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r8;
    L13:
        java.lang.Object r1 = r7.L$0;
        androidx.compose.ui.SessionMutex.Session r1 = (androidx.compose.ui.SessionMutex.Session) r1;
        kotlin.ResultKt.throwOnFailure(r8);
    L41:
        kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r8 = r7.$session;     // Catch: java.lang.Throwable -> L32
        java.lang.Object r4 = r1.getValue();     // Catch: java.lang.Throwable -> L32
        r7.L$0 = r1;     // Catch: java.lang.Throwable -> L32
        r7.label = 2;     // Catch: java.lang.Throwable -> L32
        T r4 = (T) r4;
        java.lang.Object r7 = (kotlin.coroutines.Continuation<? super R>) r7;
        r8 = r8.invoke(r4, r7);     // Catch: java.lang.Throwable -> L32
        if (r8 != r0) goto L24;
        return r0;
    L24:
        r0 = r1;
    L32:
        r8 = move-exception;
        r0 = r1;
        goto L34
    L14:
        kotlin.ResultKt.throwOnFailure(r8);
        java.lang.Object r8 = r7.L$0;
        kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8;
        kotlin.coroutines.CoroutineContext r5 = r8.getCoroutineContext();
        kotlinx.coroutines.Job r5 = kotlinx.coroutines.JobKt.getJob(r5);
        kotlin.jvm.functions.Function1<kotlinx.coroutines.CoroutineScope, T> r6 = r7.$sessionInitializer;
        java.lang.Object r8 = r6.invoke(r8);
        r1 = new androidx.compose.ui.SessionMutex.Session(r5, r8);
        java.util.concurrent.atomic.AtomicReference<androidx.compose.ui.SessionMutex.Session<T>> r8 = r7.$arg0;
        androidx.compose.ui.SessionMutex.Session<T> r1 = (androidx.compose.ui.SessionMutex.Session<T>) r1;
        java.lang.Object r8 = r8.getAndSet(r1);
        androidx.compose.ui.SessionMutex.Session r8 = (androidx.compose.ui.SessionMutex.Session) r8;
        if (r8 == null) goto L41;
        kotlinx.coroutines.Job r8 = r8.getJob();
        if (r8 == null) goto L41;
        r7.L$0 = r1;
        r7.label = 1;
        java.lang.Object r8 = kotlinx.coroutines.JobKt.cancelAndJoin(r8, r7);
        if (r8 != r0) goto L41;
        return r0;
    }
}
