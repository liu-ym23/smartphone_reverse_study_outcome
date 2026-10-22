package io.ktor.websocket;

import Ua.C1060i;
import Ua.CoroutineName;
import Ua.InterfaceC1089x;
import Ua.M;
import Wa.s;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.websocket.Frame;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.JobKt__JobKt;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"LUa/M;", "LWa/s;", "Lio/ktor/websocket/Frame$Pong;", "outgoing", "Lio/ktor/websocket/Frame$Ping;", "ponger", "(LUa/M;LWa/s;)LWa/s;", "Lio/ktor/websocket/Frame;", "", "periodMillis", "timeoutMillis", "Lkotlin/Function2;", "Lio/ktor/websocket/CloseReason;", "Le9/c;", "LY8/t;", "", "onTimeout", "pinger", "(LUa/M;LWa/s;JJLp9/p;)LWa/s;", "LUa/L;", "PongerCoroutineName", "LUa/L;", "PingerCoroutineName", "ktor-websockets"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PingPongKt {
    private static final CoroutineName PongerCoroutineName = new CoroutineName("ws-ponger");
    private static final CoroutineName PingerCoroutineName = new CoroutineName("ws-pinger");

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.websocket.PingPongKt$pinger$1", f = "PingPong.kt", l = {66, 75, 97}, m = "invokeSuspend")
    /* renamed from: io.ktor.websocket.PingPongKt$pinger$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ Wa.g<Frame.Pong> $channel;
        final /* synthetic */ p<CloseReason, InterfaceC4014c<? super t>, Object> $onTimeout;
        final /* synthetic */ s<Frame> $outgoing;
        final /* synthetic */ long $periodMillis;
        final /* synthetic */ long $timeoutMillis;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "io.ktor.websocket.PingPongKt$pinger$1$1", f = "PingPong.kt", l = {68}, m = "invokeSuspend")
        /* renamed from: io.ktor.websocket.PingPongKt$pinger$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04161 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
            final /* synthetic */ Wa.g<Frame.Pong> $channel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C04161(Wa.g<Frame.Pong> gVar, InterfaceC4014c<? super C04161> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.$channel = gVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new C04161(this.$channel, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((C04161) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Wa.g<Frame.Pong> gVar;
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 != 0 && i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                do {
                    gVar = this.$channel;
                    this.label = 1;
                } while (gVar.receive(this) != objG);
                return objG;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(long j10, long j11, p<? super CloseReason, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, Wa.g<Frame.Pong> gVar, s<? super Frame> sVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$periodMillis = j10;
            this.$timeoutMillis = j11;
            this.$onTimeout = pVar;
            this.$channel = gVar;
            this.$outgoing = sVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$periodMillis, this.$timeoutMillis, this.$onTimeout, this.$channel, this.$outgoing, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0115, code lost:
        
            if (r3.invoke(r4, r13) == r0) goto L31;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[PHI: r1 r6 r7 r14
          0x003e: PHI (r1v11 java.lang.String) = (r1v9 java.lang.String), (r1v18 java.lang.String) binds: [B:25:0x00dc, B:13:0x003b] A[DONT_GENERATE, DONT_INLINE]
          0x003e: PHI (r6v9 byte[]) = (r6v6 byte[]), (r6v14 byte[]) binds: [B:25:0x00dc, B:13:0x003b] A[DONT_GENERATE, DONT_INLINE]
          0x003e: PHI (r7v2 kotlin.random.Random) = (r7v0 kotlin.random.Random), (r7v5 kotlin.random.Random) binds: [B:25:0x00dc, B:13:0x003b] A[DONT_GENERATE, DONT_INLINE]
          0x003e: PHI (r14v7 java.lang.Object) = (r14v5 java.lang.Object), (r14v0 java.lang.Object) binds: [B:25:0x00dc, B:13:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00e3 A[Catch: ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x011b, ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x011b, ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x011b, ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x011b, TRY_LEAVE, TryCatch #0 {ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x011b, blocks: (B:8:0x0022, B:13:0x003b, B:13:0x003b, B:13:0x003b, B:13:0x003b, B:27:0x00df, B:27:0x00df, B:27:0x00df, B:27:0x00df, B:29:0x00e3, B:29:0x00e3, B:29:0x00e3, B:29:0x00e3, B:20:0x0089, B:20:0x0089, B:20:0x0089, B:20:0x0089, B:24:0x00a4, B:24:0x00a4, B:24:0x00a4, B:24:0x00a4, B:16:0x004b, B:16:0x004b, B:16:0x004b, B:16:0x004b), top: B:36:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0118  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00dc -> B:14:0x003e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 286
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.websocket.PingPongKt$ponger$1", f = "PingPong.kt", l = {119, 33}, m = "invokeSuspend")
    /* renamed from: io.ktor.websocket.PingPongKt$ponger$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44601 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ Wa.g<Frame.Ping> $channel;
        final /* synthetic */ s<Frame.Pong> $outgoing;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C44601(Wa.g<Frame.Ping> gVar, s<? super Frame.Pong> sVar, InterfaceC4014c<? super C44601> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$channel = gVar;
            this.$outgoing = sVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C44601(this.$channel, this.$outgoing, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C44601) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b2 A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:7:0x002f, B:24:0x00aa, B:26:0x00b2, B:31:0x0109, B:14:0x0064, B:18:0x0071), top: B:45:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0109 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #2 {all -> 0x003e, blocks: (B:7:0x002f, B:24:0x00aa, B:26:0x00b2, B:31:0x0109, B:14:0x0064, B:18:0x0071), top: B:45:0x000b }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00fb -> B:30:0x0106). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 283
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt.C44601.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final s<Frame.Pong> pinger(M m10, s<? super Frame> outgoing, long j10, long j11, p<? super CloseReason, ? super InterfaceC4014c<? super t>, ? extends Object> onTimeout) {
        kotlin.jvm.internal.p.i(m10, "<this>");
        kotlin.jvm.internal.p.i(outgoing, "outgoing");
        kotlin.jvm.internal.p.i(onTimeout, "onTimeout");
        final InterfaceC1089x interfaceC1089xB = JobKt__JobKt.b(null, 1, null);
        Wa.g gVarB = Wa.j.b(Integer.MAX_VALUE, null, null, 6, null);
        C1060i.d(m10, interfaceC1089xB.plus(PingerCoroutineName), null, new AnonymousClass1(j10, j11, onTimeout, gVarB, outgoing, null), 2, null);
        d.b bVar = m10.getCoroutineContext().get(kotlinx.coroutines.g.INSTANCE);
        kotlin.jvm.internal.p.f(bVar);
        ((kotlinx.coroutines.g) bVar).J(new InterfaceC5074l() { // from class: io.ktor.websocket.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PingPongKt.pinger$lambda$0(interfaceC1089xB, (Throwable) obj);
            }
        });
        return gVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t pinger$lambda$0(InterfaceC1089x interfaceC1089x, Throwable th) {
        kotlinx.coroutines.g.Y0(interfaceC1089x, null, 1, null);
        return t.f7040a;
    }

    public static final s<Frame.Ping> ponger(M m10, s<? super Frame.Pong> outgoing) {
        kotlin.jvm.internal.p.i(m10, "<this>");
        kotlin.jvm.internal.p.i(outgoing, "outgoing");
        Wa.g gVarB = Wa.j.b(5, null, null, 6, null);
        C1060i.d(m10, PongerCoroutineName, null, new C44601(gVarB, outgoing, null), 2, null);
        return gVarB;
    }
}
