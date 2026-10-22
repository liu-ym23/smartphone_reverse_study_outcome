package com.stepos.agentframework.adapter.agentbus;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$BffApi$onMessage$job$1", f = "ClawChannelAgentBusBinding.kt", l = {275}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ClawChannelAgentBusBinding$BffApi$onMessage$job$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ p9.p<byte[], InterfaceC4014c<? super Y8.t>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClawChannelAgentBusBinding this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$BffApi$onMessage$job$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Xa.c {
        final /* synthetic */ Ua.M $$this$launch;
        final /* synthetic */ p9.p<byte[], InterfaceC4014c<? super Y8.t>, Object> $handler;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ua.M m10, p9.p<? super byte[], ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
            this.$$this$launch = m10;
            this.$handler = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(byte[] r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$BffApi$onMessage$job$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$BffApi$onMessage$job$1$1$emit$1 r0 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$BffApi$onMessage$job$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$BffApi$onMessage$job$1$1$emit$1 r0 = new com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$BffApi$onMessage$job$1$1$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L39
                if (r2 != r3) goto L31
                java.lang.Object r4 = r0.L$1
                Ua.M r4 = (Ua.M) r4
                java.lang.Object r4 = r0.L$0
                byte[] r4 = (byte[]) r4
                kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L60
                goto L5a
            L31:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L39:
                kotlin.C4849c.b(r6)
                Ua.M r6 = r4.$$this$launch
                p9.p<byte[], e9.c<? super Y8.t>, java.lang.Object> r4 = r4.$handler
                kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L60
                java.lang.Object r2 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L60
                r0.L$0 = r2     // Catch: java.lang.Throwable -> L60
                java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L60
                r0.L$1 = r6     // Catch: java.lang.Throwable -> L60
                r6 = 0
                r0.I$0 = r6     // Catch: java.lang.Throwable -> L60
                r0.label = r3     // Catch: java.lang.Throwable -> L60
                java.lang.Object r4 = r4.invoke(r5, r0)     // Catch: java.lang.Throwable -> L60
                if (r4 != r1) goto L5a
                return r1
            L5a:
                Y8.t r4 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L60
                kotlin.Result.b(r4)     // Catch: java.lang.Throwable -> L60
                goto L6a
            L60:
                r4 = move-exception
                kotlin.Result$a r5 = kotlin.Result.INSTANCE
                java.lang.Object r4 = kotlin.C4849c.a(r4)
                kotlin.Result.b(r4)
            L6a:
                Y8.t r4 = Y8.t.f7040a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$BffApi$onMessage$job$1.AnonymousClass1.emit(byte[], e9.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ClawChannelAgentBusBinding$BffApi$onMessage$job$1(ClawChannelAgentBusBinding clawChannelAgentBusBinding, p9.p<? super byte[], ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super ClawChannelAgentBusBinding$BffApi$onMessage$job$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = clawChannelAgentBusBinding;
        this.$handler = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ClawChannelAgentBusBinding$BffApi$onMessage$job$1 clawChannelAgentBusBinding$BffApi$onMessage$job$1 = new ClawChannelAgentBusBinding$BffApi$onMessage$job$1(this.this$0, this.$handler, interfaceC4014c);
        clawChannelAgentBusBinding$BffApi$onMessage$job$1.L$0 = obj;
        return clawChannelAgentBusBinding$BffApi$onMessage$job$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ClawChannelAgentBusBinding$BffApi$onMessage$job$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.j jVar = this.this$0.incomingBffMessages;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(m10, this.$handler);
            this.L$0 = g9.h.a(m10);
            this.label = 1;
            if (jVar.collect(anonymousClass1, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
