package androidx.datastore.core;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.b0;
import m9.c0;
import o9.C1780f;
import o9.C1781g;
import o9.C1782h;
import o9.InterfaceC1779e;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bh\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\t\u0012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R3\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/datastore/core/SimpleActor;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lm9/z;", "scope", "Lkotlin/Function1;", "", "LC7/r;", "onComplete", "Lkotlin/Function2;", "onUndeliveredElement", "LH7/c;", "consumeMessage", AppAgent.CONSTRUCT, "(Lm9/z;LS7/k;LS7/n;LS7/n;)V", NotificationCompat.CATEGORY_MESSAGE, "offer", "(Ljava/lang/Object;)V", "Lm9/z;", "LS7/n;", "Lo9/e;", "messageQueue", "Lo9/e;", "Ljava/util/concurrent/atomic/AtomicInteger;", "remainingMessages", "Ljava/util/concurrent/atomic/AtomicInteger;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleActor<T> {
    private final n consumeMessage;
    private final InterfaceC1779e messageQueue;
    private final AtomicInteger remainingMessages;
    private final InterfaceC1733z scope;

    @c(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.datastore.core.SimpleActor$offer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        Object L$0;
        int label;
        final /* synthetic */ SimpleActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SimpleActor<T> simpleActor, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.this$0 = simpleActor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.this$0, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
        
            if (r1.invoke(r6, r5) != r0) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0053 A[PHI: r1 r6
          0x0053: PHI (r1v1 S7.n) = (r1v2 S7.n), (r1v4 S7.n) binds: [B:13:0x0050, B:9:0x0018] A[DONT_GENERATE, DONT_INLINE]
          0x0053: PHI (r6v5 java.lang.Object) = (r6v13 java.lang.Object), (r6v0 java.lang.Object) binds: [B:13:0x0050, B:9:0x0018] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005c -> B:18:0x005f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.b.b(r6)
                goto L5f
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L18:
                java.lang.Object r1 = r5.L$0
                S7.n r1 = (S7.n) r1
                kotlin.b.b(r6)
                goto L53
            L20:
                kotlin.b.b(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                java.util.concurrent.atomic.AtomicInteger r6 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r6)
                int r6 = r6.get()
                if (r6 <= 0) goto L6e
            L2f:
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                m9.z r6 = androidx.datastore.core.SimpleActor.access$getScope$p(r6)
                H7.h r6 = r6.getCoroutineContext()
                kotlinx.coroutines.a.g(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                S7.n r1 = androidx.datastore.core.SimpleActor.access$getConsumeMessage$p(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                o9.e r6 = androidx.datastore.core.SimpleActor.access$getMessageQueue$p(r6)
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r6.u(r5)
                if (r6 != r0) goto L53
                goto L5e
            L53:
                r4 = 0
                r5.L$0 = r4
                r5.label = r2
                java.lang.Object r6 = r1.invoke(r6, r5)
                if (r6 != r0) goto L5f
            L5e:
                return r0
            L5f:
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                java.util.concurrent.atomic.AtomicInteger r6 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r6)
                int r6 = r6.decrementAndGet()
                if (r6 != 0) goto L2f
                C7.r r5 = C7.r.f317a
                return r5
            L6e:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "Check failed."
                r5.<init>(r6)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public SimpleActor(InterfaceC1733z scope, final k onComplete, final n onUndeliveredElement, n consumeMessage) {
        kotlin.jvm.internal.k.f(scope, "scope");
        kotlin.jvm.internal.k.f(onComplete, "onComplete");
        kotlin.jvm.internal.k.f(onUndeliveredElement, "onUndeliveredElement");
        kotlin.jvm.internal.k.f(consumeMessage, "consumeMessage");
        this.scope = scope;
        this.consumeMessage = consumeMessage;
        this.messageQueue = Z6.k.b(Integer.MAX_VALUE, 6, null);
        this.remainingMessages = new AtomicInteger(0);
        c0 c0Var = (c0) scope.getCoroutineContext().get(b0.f5325a);
        if (c0Var == null) {
            return;
        }
        c0Var.w(new k() { // from class: androidx.datastore.core.SimpleActor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return r.f317a;
            }

            public final void invoke(Throwable th) {
                r rVar;
                onComplete.invoke(th);
                ((SimpleActor) this).messageQueue.s(th);
                do {
                    Object objA = C1782h.a(((SimpleActor) this).messageQueue.q());
                    if (objA == null) {
                        rVar = null;
                    } else {
                        onUndeliveredElement.invoke(objA, th);
                        rVar = r.f317a;
                    }
                } while (rVar != null);
            }
        });
    }

    public final void offer(T msg) {
        Object objA = this.messageQueue.a(msg);
        if (objA instanceof C1780f) {
            C1780f c1780f = objA != null ? (C1780f) objA : null;
            Throwable th = c1780f != null ? c1780f.f5456a : null;
            if (th != null) {
                throw th;
            }
            throw new ClosedSendChannelException("Channel was closed normally");
        }
        if (objA instanceof C1781g) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.remainingMessages.getAndIncrement() == 0) {
            AbstractC1683A.n(this.scope, null, new AnonymousClass2(this, null), 3);
        }
    }
}
