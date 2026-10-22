package io.ktor.network.selector;

import M5.c;
import Ua.C1060i;
import Ua.CoroutineName;
import Ua.M;
import Ua.W0;
import Y8.t;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.io.Closeable;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.n;
import p9.InterfaceC5063a;
import p9.p;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\rH\u0082H¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0017\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\t0\bH\u0082@¢\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u001b\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\t0\bH\u0082@¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b \u0010\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R&\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010(R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lio/ktor/network/selector/ActorSelectorManager;", "Lio/ktor/network/selector/SelectorManagerSupport;", "Ljava/io/Closeable;", "LUa/M;", "Lkotlin/coroutines/d;", "context", "<init>", "(Lkotlin/coroutines/d;)V", "Lio/ktor/network/selector/LockFreeMPSCQueue;", "Lio/ktor/network/selector/Selectable;", "mb", "Ljava/nio/channels/Selector;", "selector", "LY8/t;", "process", "(Lio/ktor/network/selector/LockFreeMPSCQueue;Ljava/nio/channels/Selector;Le9/c;)Ljava/lang/Object;", "", c.ACTION_SELECT, "(Ljava/nio/channels/Selector;Le9/c;)Ljava/lang/Object;", "dispatchIfNeeded", "(Le9/c;)Ljava/lang/Object;", "selectWakeup", "()V", "processInterests", "(Lio/ktor/network/selector/LockFreeMPSCQueue;Ljava/nio/channels/Selector;)V", "receiveOrNull", "(Lio/ktor/network/selector/LockFreeMPSCQueue;Le9/c;)Ljava/lang/Object;", "receiveOrNullSuspend", "selectable", "notifyClosed", "(Lio/ktor/network/selector/Selectable;)V", "publishInterest", "close", "selectorRef", "Ljava/nio/channels/Selector;", "Ljava/util/concurrent/atomic/AtomicLong;", "wakeup", "Ljava/util/concurrent/atomic/AtomicLong;", "", "inSelect", "Z", "Lio/ktor/network/selector/ActorSelectorManager$ContinuationHolder;", "Le9/c;", "continuation", "Lio/ktor/network/selector/ActorSelectorManager$ContinuationHolder;", AlipayXuiIsland.REASON_CLOSED, "selectionQueue", "Lio/ktor/network/selector/LockFreeMPSCQueue;", "coroutineContext", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "ContinuationHolder", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ActorSelectorManager extends SelectorManagerSupport implements Closeable, M {
    private volatile boolean closed;
    private final ContinuationHolder<t, InterfaceC4014c<t>> continuation;
    private final d coroutineContext;
    private volatile boolean inSelect;
    private final LockFreeMPSCQueue<Selectable> selectionQueue;
    private volatile Selector selectorRef;
    private final AtomicLong wakeup;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.network.selector.ActorSelectorManager$1", f = "ActorSelectorManager.kt", l = {44}, m = "invokeSuspend")
    /* renamed from: io.ktor.network.selector.ActorSelectorManager$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return ActorSelectorManager.this.new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00a3 A[Catch: all -> 0x006f, LOOP:0: B:28:0x008f->B:33:0x00a3, LOOP_END, TRY_ENTER, TryCatch #4 {all -> 0x006f, blocks: (B:19:0x005e, B:20:0x006b, B:28:0x008f, B:30:0x009b, B:33:0x00a3, B:27:0x0081, B:35:0x00af, B:36:0x00bf, B:26:0x0074), top: B:51:0x0008, inners: #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x009b A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r6.label
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L2a
                if (r1 != r2) goto L22
                java.lang.Object r0 = r6.L$3
                java.nio.channels.spi.AbstractSelector r0 = (java.nio.channels.spi.AbstractSelector) r0
                java.lang.Object r1 = r6.L$2
                io.ktor.network.selector.ActorSelectorManager r1 = (io.ktor.network.selector.ActorSelectorManager) r1
                java.lang.Object r4 = r6.L$1
                java.io.Closeable r4 = (java.io.Closeable) r4
                java.lang.Object r6 = r6.L$0
                java.nio.channels.spi.AbstractSelector r6 = (java.nio.channels.spi.AbstractSelector) r6
                kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L20
                goto L5e
            L20:
                r6 = move-exception
                goto L74
            L22:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L2a:
                kotlin.C4849c.b(r7)
                io.ktor.network.selector.ActorSelectorManager r7 = io.ktor.network.selector.ActorSelectorManager.this
                java.nio.channels.spi.SelectorProvider r7 = r7.getProvider()
                java.nio.channels.spi.AbstractSelector r7 = r7.openSelector()
                if (r7 == 0) goto Lc6
                io.ktor.network.selector.ActorSelectorManager r1 = io.ktor.network.selector.ActorSelectorManager.this
                io.ktor.network.selector.ActorSelectorManager.access$setSelectorRef$p(r1, r7)
                io.ktor.network.selector.ActorSelectorManager r1 = io.ktor.network.selector.ActorSelectorManager.this
                io.ktor.network.selector.LockFreeMPSCQueue r4 = io.ktor.network.selector.ActorSelectorManager.access$getSelectionQueue$p(r1)     // Catch: java.lang.Throwable -> L71
                java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L71
                r6.L$0 = r5     // Catch: java.lang.Throwable -> L71
                r6.L$1 = r7     // Catch: java.lang.Throwable -> L71
                r6.L$2 = r1     // Catch: java.lang.Throwable -> L71
                r6.L$3 = r7     // Catch: java.lang.Throwable -> L71
                r5 = 0
                r6.I$0 = r5     // Catch: java.lang.Throwable -> L71
                r6.label = r2     // Catch: java.lang.Throwable -> L71
                java.lang.Object r6 = io.ktor.network.selector.ActorSelectorManager.access$process(r1, r4, r7, r6)     // Catch: java.lang.Throwable -> L71
                if (r6 != r0) goto L5c
                return r0
            L5c:
                r0 = r7
                r4 = r0
            L5e:
                io.ktor.network.selector.ActorSelectorManager.access$setClosed$p(r1, r2)     // Catch: java.lang.Throwable -> L6f
                io.ktor.network.selector.LockFreeMPSCQueue r6 = io.ktor.network.selector.ActorSelectorManager.access$getSelectionQueue$p(r1)     // Catch: java.lang.Throwable -> L6f
                r6.close()     // Catch: java.lang.Throwable -> L6f
                io.ktor.network.selector.ActorSelectorManager.access$setSelectorRef$p(r1, r3)     // Catch: java.lang.Throwable -> L6f
            L6b:
                r1.cancelAllSuspensions(r0, r3)     // Catch: java.lang.Throwable -> L6f
                goto L8f
            L6f:
                r6 = move-exception
                goto Lc0
            L71:
                r6 = move-exception
                r0 = r7
                r4 = r0
            L74:
                io.ktor.network.selector.ActorSelectorManager.access$setClosed$p(r1, r2)     // Catch: java.lang.Throwable -> Lae
                io.ktor.network.selector.LockFreeMPSCQueue r7 = io.ktor.network.selector.ActorSelectorManager.access$getSelectionQueue$p(r1)     // Catch: java.lang.Throwable -> Lae
                r7.close()     // Catch: java.lang.Throwable -> Lae
                r1.cancelAllSuspensions(r0, r6)     // Catch: java.lang.Throwable -> Lae
                io.ktor.network.selector.ActorSelectorManager.access$setClosed$p(r1, r2)     // Catch: java.lang.Throwable -> L6f
                io.ktor.network.selector.LockFreeMPSCQueue r6 = io.ktor.network.selector.ActorSelectorManager.access$getSelectionQueue$p(r1)     // Catch: java.lang.Throwable -> L6f
                r6.close()     // Catch: java.lang.Throwable -> L6f
                io.ktor.network.selector.ActorSelectorManager.access$setSelectorRef$p(r1, r3)     // Catch: java.lang.Throwable -> L6f
                goto L6b
            L8f:
                io.ktor.network.selector.LockFreeMPSCQueue r6 = io.ktor.network.selector.ActorSelectorManager.access$getSelectionQueue$p(r1)     // Catch: java.lang.Throwable -> L6f
                java.lang.Object r6 = r6.removeFirstOrNull()     // Catch: java.lang.Throwable -> L6f
                io.ktor.network.selector.Selectable r6 = (io.ktor.network.selector.Selectable) r6     // Catch: java.lang.Throwable -> L6f
                if (r6 != 0) goto La3
                Y8.t r6 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L6f
                l9.b.a(r4, r3)
                Y8.t r6 = Y8.t.f7040a
                return r6
            La3:
                kotlinx.coroutines.channels.ClosedSendChannelException r7 = new kotlinx.coroutines.channels.ClosedSendChannelException     // Catch: java.lang.Throwable -> L6f
                java.lang.String r0 = "Failed to apply interest: selector closed"
                r7.<init>(r0)     // Catch: java.lang.Throwable -> L6f
                r1.cancelAllSuspensions(r6, r7)     // Catch: java.lang.Throwable -> L6f
                goto L8f
            Lae:
                r6 = move-exception
                io.ktor.network.selector.ActorSelectorManager.access$setClosed$p(r1, r2)     // Catch: java.lang.Throwable -> L6f
                io.ktor.network.selector.LockFreeMPSCQueue r7 = io.ktor.network.selector.ActorSelectorManager.access$getSelectionQueue$p(r1)     // Catch: java.lang.Throwable -> L6f
                r7.close()     // Catch: java.lang.Throwable -> L6f
                io.ktor.network.selector.ActorSelectorManager.access$setSelectorRef$p(r1, r3)     // Catch: java.lang.Throwable -> L6f
                r1.cancelAllSuspensions(r0, r3)     // Catch: java.lang.Throwable -> L6f
                throw r6     // Catch: java.lang.Throwable -> L6f
            Lc0:
                throw r6     // Catch: java.lang.Throwable -> Lc1
            Lc1:
                r7 = move-exception
                l9.b.a(r4, r6)
                throw r7
            Lc6:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "openSelector() = null"
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.selector.ActorSelectorManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00028\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"Lio/ktor/network/selector/ActorSelectorManager$ContinuationHolder;", "R", "Le9/c;", "C", "", "<init>", "()V", UxipConstants.f30680s, "", "resume", "(Ljava/lang/Object;)Z", "continuation", "Lkotlin/Function0;", "condition", "suspendIf", "(Le9/c;Lp9/a;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicReference;", "ref", "Ljava/util/concurrent/atomic/AtomicReference;", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ContinuationHolder<R, C extends InterfaceC4014c<? super R>> {
        private final AtomicReference<C> ref = new AtomicReference<>(null);

        public final boolean resume(R value) {
            C andSet = this.ref.getAndSet(null);
            if (andSet == null) {
                return false;
            }
            andSet.resumeWith(Result.b(value));
            return true;
        }

        public final Object suspendIf(C continuation, InterfaceC5063a<Boolean> condition) {
            kotlin.jvm.internal.p.i(continuation, "continuation");
            kotlin.jvm.internal.p.i(condition, "condition");
            if (!condition.invoke().booleanValue()) {
                return null;
            }
            if (!this.ref.compareAndSet(null, continuation)) {
                throw new IllegalStateException("Continuation is already set");
            }
            if (condition.invoke().booleanValue() || !this.ref.compareAndSet(continuation, null)) {
                return C4063a.g();
            }
            return null;
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", l = {70, 74, 90}, m = "process")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.selector.ActorSelectorManager$process$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C43021(InterfaceC4014c<? super C43021> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActorSelectorManager.this.process(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", l = {168}, m = "receiveOrNullSuspend")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.selector.ActorSelectorManager$receiveOrNullSuspend$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C43031(InterfaceC4014c<? super C43031> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActorSelectorManager.this.receiveOrNullSuspend(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", l = {210}, m = c.ACTION_SELECT)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.selector.ActorSelectorManager$select$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43041 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C43041(InterfaceC4014c<? super C43041> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActorSelectorManager.this.select(null, this);
        }
    }

    public ActorSelectorManager(d context) {
        kotlin.jvm.internal.p.i(context, "context");
        this.wakeup = new AtomicLong();
        this.continuation = new ContinuationHolder<>();
        this.selectionQueue = new LockFreeMPSCQueue<>();
        this.coroutineContext = context.plus(new CoroutineName("selector"));
        C1060i.d(this, null, null, new AnonymousClass1(null), 3, null);
    }

    private final Object dispatchIfNeeded(InterfaceC4014c<? super t> interfaceC4014c) {
        n.c(0);
        W0.a(interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f5, code lost:
    
        if (r12 == r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0092 -> B:19:0x006c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ac -> B:19:0x006c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00c0 -> B:19:0x006c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00f5 -> B:44:0x00f8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object process(io.ktor.network.selector.LockFreeMPSCQueue<io.ktor.network.selector.Selectable> r10, java.nio.channels.Selector r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.selector.ActorSelectorManager.process(io.ktor.network.selector.LockFreeMPSCQueue, java.nio.channels.Selector, e9.c):java.lang.Object");
    }

    private final void processInterests(LockFreeMPSCQueue<Selectable> mb2, Selector selector) {
        while (true) {
            Selectable selectableRemoveFirstOrNull = mb2.removeFirstOrNull();
            if (selectableRemoveFirstOrNull == null) {
                return;
            } else {
                applyInterest(selector, selectableRemoveFirstOrNull);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object receiveOrNull(LockFreeMPSCQueue<Selectable> lockFreeMPSCQueue, InterfaceC4014c<? super Selectable> interfaceC4014c) {
        Selectable selectableRemoveFirstOrNull = lockFreeMPSCQueue.removeFirstOrNull();
        return selectableRemoveFirstOrNull == null ? receiveOrNullSuspend(lockFreeMPSCQueue, interfaceC4014c) : selectableRemoveFirstOrNull;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object receiveOrNullSuspend(io.ktor.network.selector.LockFreeMPSCQueue<io.ktor.network.selector.Selectable> r6, e9.InterfaceC4014c<? super io.ktor.network.selector.Selectable> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.network.selector.ActorSelectorManager.C43031
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.network.selector.ActorSelectorManager$receiveOrNullSuspend$1 r0 = (io.ktor.network.selector.ActorSelectorManager.C43031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.selector.ActorSelectorManager$receiveOrNullSuspend$1 r0 = new io.ktor.network.selector.ActorSelectorManager$receiveOrNullSuspend$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$1
            io.ktor.network.selector.Selectable r6 = (io.ktor.network.selector.Selectable) r6
            java.lang.Object r6 = r0.L$0
            io.ktor.network.selector.LockFreeMPSCQueue r6 = (io.ktor.network.selector.LockFreeMPSCQueue) r6
            goto L36
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.C4849c.b(r7)
        L39:
            java.lang.Object r7 = r6.removeFirstOrNull()
            io.ktor.network.selector.Selectable r7 = (io.ktor.network.selector.Selectable) r7
            if (r7 == 0) goto L42
            return r7
        L42:
            boolean r2 = r5.closed
            r4 = 0
            if (r2 == 0) goto L48
            return r4
        L48:
            r0.L$0 = r6
            java.lang.Object r7 = g9.h.a(r7)
            r0.L$1 = r7
            r0.label = r3
            io.ktor.network.selector.ActorSelectorManager$ContinuationHolder<Y8.t, e9.c<Y8.t>> r7 = r5.continuation
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto L8b
            boolean r2 = r5.closed
            if (r2 != 0) goto L8b
            java.util.concurrent.atomic.AtomicReference r2 = io.ktor.network.selector.ActorSelectorManager.ContinuationHolder.access$getRef$p(r7)
            boolean r2 = r2.compareAndSet(r4, r0)
            if (r2 == 0) goto L83
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto L73
            boolean r2 = r5.closed
            if (r2 != 0) goto L73
            goto L7e
        L73:
            java.util.concurrent.atomic.AtomicReference r7 = io.ktor.network.selector.ActorSelectorManager.ContinuationHolder.access$getRef$p(r7)
            boolean r7 = r7.compareAndSet(r0, r4)
            if (r7 == 0) goto L7e
            goto L8b
        L7e:
            java.lang.Object r4 = f9.C4063a.g()
            goto L8b
        L83:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Continuation is already set"
            r5.<init>(r6)
            throw r5
        L8b:
            if (r4 != 0) goto L8f
            Y8.t r4 = Y8.t.f7040a
        L8f:
            java.lang.Object r7 = f9.C4063a.g()
            if (r4 != r7) goto L98
            g9.f.c(r0)
        L98:
            if (r4 != r1) goto L39
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.selector.ActorSelectorManager.receiveOrNullSuspend(io.ktor.network.selector.LockFreeMPSCQueue, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object select(java.nio.channels.Selector r7, e9.InterfaceC4014c<? super java.lang.Integer> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.network.selector.ActorSelectorManager.C43041
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.network.selector.ActorSelectorManager$select$1 r0 = (io.ktor.network.selector.ActorSelectorManager.C43041) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.selector.ActorSelectorManager$select$1 r0 = new io.ktor.network.selector.ActorSelectorManager$select$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r7 = r0.L$1
            io.ktor.network.selector.ActorSelectorManager r7 = (io.ktor.network.selector.ActorSelectorManager) r7
            java.lang.Object r7 = r0.L$0
            java.nio.channels.Selector r7 = (java.nio.channels.Selector) r7
            kotlin.C4849c.b(r8)
            goto L52
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.C4849c.b(r8)
            r6.inSelect = r4
            r0.L$0 = r7
            java.lang.Object r8 = g9.h.a(r6)
            r0.L$1 = r8
            r0.I$0 = r3
            r0.label = r4
            java.lang.Object r8 = Ua.W0.a(r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            java.util.concurrent.atomic.AtomicLong r8 = r6.wakeup
            long r0 = r8.get()
            r4 = 0
            int r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r8 != 0) goto L67
            r0 = 500(0x1f4, double:2.47E-321)
            int r7 = r7.select(r0)
            r6.inSelect = r3
            goto L72
        L67:
            r6.inSelect = r3
            java.util.concurrent.atomic.AtomicLong r6 = r6.wakeup
            r6.set(r4)
            int r7 = r7.selectNow()
        L72:
            java.lang.Integer r6 = g9.C4109a.f(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.selector.ActorSelectorManager.select(java.nio.channels.Selector, e9.c):java.lang.Object");
    }

    private final void selectWakeup() {
        Selector selector;
        if (this.wakeup.incrementAndGet() == 1 && this.inSelect && (selector = this.selectorRef) != null) {
            selector.wakeup();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        this.selectionQueue.close();
        if (this.continuation.resume(t.f7040a)) {
            return;
        }
        selectWakeup();
    }

    @Override // io.ktor.network.selector.SelectorManagerSupport, io.ktor.network.selector.SelectorManager, Ua.M
    public d getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.network.selector.SelectorManager
    public void notifyClosed(Selectable selectable) {
        SelectionKey selectionKeyKeyFor;
        kotlin.jvm.internal.p.i(selectable, "selectable");
        cancelAllSuspensions(selectable, new ClosedChannelException());
        Selector selector = this.selectorRef;
        if (selector == null || (selectionKeyKeyFor = selectable.getChannel().keyFor(selector)) == null) {
            return;
        }
        selectionKeyKeyFor.cancel();
        selectWakeup();
    }

    @Override // io.ktor.network.selector.SelectorManagerSupport
    public void publishInterest(Selectable selectable) {
        kotlin.jvm.internal.p.i(selectable, "selectable");
        try {
            if (this.selectionQueue.addLast(selectable)) {
                this.continuation.resume(t.f7040a);
                selectWakeup();
            } else {
                if (!selectable.getChannel().isOpen()) {
                    throw new ClosedChannelException();
                }
                throw new ClosedSelectorException();
            }
        } catch (Throwable th) {
            cancelAllSuspensions(selectable, th);
        }
    }
}
