package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0011H\u0096\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\u00028\u00008\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/ProduceStateScopeImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/ProduceStateScope;", "Landroidx/compose/runtime/MutableState;", "state", "LH7/h;", "coroutineContext", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/MutableState;LH7/h;)V", "Lkotlin/Function0;", "LC7/r;", "onDispose", "", "awaitDispose", "(LS7/a;LH7/c;)Ljava/lang/Object;", "component1", "()Ljava/lang/Object;", "Lkotlin/Function1;", "component2", "()LS7/k;", "LH7/h;", "getCoroutineContext", "()LH7/h;", "getValue", "setValue", "(Ljava/lang/Object;)V", "value", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class ProduceStateScopeImpl<T> implements ProduceStateScope<T>, MutableState<T> {
    private final /* synthetic */ MutableState<T> $$delegate_0;
    private final H7.h coroutineContext;

    @J7.c(c = "androidx.compose.runtime.ProduceStateScopeImpl", f = "ProduceState.kt", l = {208}, m = "awaitDispose")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProduceStateScopeImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ProduceStateScopeImpl<T> produceStateScopeImpl, H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.this$0 = produceStateScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitDispose(null, this);
        }
    }

    public ProduceStateScopeImpl(MutableState<T> mutableState, H7.h hVar) {
        this.$$delegate_0 = mutableState;
        this.coroutineContext = hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.runtime.ProduceStateScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object awaitDispose(S7.a r5, H7.c<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.runtime.ProduceStateScopeImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1 r0 = (androidx.compose.runtime.ProduceStateScopeImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1 r0 = new androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 == r2) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2b:
            java.lang.Object r5 = r0.L$0
            S7.a r5 = (S7.a) r5
            kotlin.b.b(r4)     // Catch: java.lang.Throwable -> L33
            goto L4f
        L33:
            r4 = move-exception
            goto L55
        L35:
            kotlin.b.b(r4)
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L33
            r0.label = r2     // Catch: java.lang.Throwable -> L33
            m9.k r4 = new m9.k     // Catch: java.lang.Throwable -> L33
            H7.c r0 = U7.a.I(r0)     // Catch: java.lang.Throwable -> L33
            r4.<init>(r2, r0)     // Catch: java.lang.Throwable -> L33
            r4.y()     // Catch: java.lang.Throwable -> L33
            java.lang.Object r4 = r4.x()     // Catch: java.lang.Throwable -> L33
            if (r4 != r6) goto L4f
            return r6
        L4f:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L33
            r4.<init>()     // Catch: java.lang.Throwable -> L33
            throw r4     // Catch: java.lang.Throwable -> L33
        L55:
            r5.invoke()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ProduceStateScopeImpl.awaitDispose(S7.a, H7.c):java.lang.Object");
    }

    @Override // androidx.compose.runtime.MutableState
    public T component1() {
        return this.$$delegate_0.component1();
    }

    @Override // androidx.compose.runtime.MutableState
    public S7.k component2() {
        return this.$$delegate_0.component2();
    }

    @Override // androidx.compose.runtime.ProduceStateScope, m9.InterfaceC1733z
    public H7.h getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.compose.runtime.MutableState, androidx.compose.runtime.State
    public T getValue() {
        return this.$$delegate_0.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public void setValue(T t9) {
        this.$$delegate_0.setValue(t9);
    }
}
