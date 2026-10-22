package com.stepos.agentframework.adapter.agentbus;

import a4.Message;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$ChatApi$onMessage$job$1", f = "ClawChannelAgentBusBinding.kt", l = {397}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ClawChannelAgentBusBinding$ChatApi$onMessage$job$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ p9.q<String, Message, InterfaceC4014c<? super Y8.t>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClawChannelAgentBusBinding this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$ChatApi$onMessage$job$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Xa.c {
        final /* synthetic */ Ua.M $$this$launch;
        final /* synthetic */ p9.q<String, Message, InterfaceC4014c<? super Y8.t>, Object> $handler;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ua.M m10, p9.q<? super String, ? super Message, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar) {
            this.$$this$launch = m10;
            this.$handler = qVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(kotlin.Pair<java.lang.String, a4.Message> r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$ChatApi$onMessage$job$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r7
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$ChatApi$onMessage$job$1$1$emit$1 r0 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$ChatApi$onMessage$job$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$ChatApi$onMessage$job$1$1$emit$1 r0 = new com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$ChatApi$onMessage$job$1$1$emit$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3d
                if (r2 != r3) goto L35
                java.lang.Object r5 = r0.L$2
                Ua.M r5 = (Ua.M) r5
                java.lang.Object r5 = r0.L$1
                a4.w r5 = (a4.Message) r5
                java.lang.Object r5 = r0.L$0
                java.lang.String r5 = (java.lang.String) r5
                kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L76
                goto L70
            L35:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L3d:
                kotlin.C4849c.b(r7)
                java.lang.Object r7 = r6.a()
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r6 = r6.b()
                a4.w r6 = (a4.Message) r6
                Ua.M r2 = r5.$$this$launch
                p9.q<java.lang.String, a4.w, e9.c<? super Y8.t>, java.lang.Object> r5 = r5.$handler
                kotlin.Result$a r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L76
                java.lang.Object r4 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L76
                r0.L$0 = r4     // Catch: java.lang.Throwable -> L76
                java.lang.Object r4 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L76
                r0.L$1 = r4     // Catch: java.lang.Throwable -> L76
                java.lang.Object r2 = g9.h.a(r2)     // Catch: java.lang.Throwable -> L76
                r0.L$2 = r2     // Catch: java.lang.Throwable -> L76
                r2 = 0
                r0.I$0 = r2     // Catch: java.lang.Throwable -> L76
                r0.label = r3     // Catch: java.lang.Throwable -> L76
                java.lang.Object r5 = r5.invoke(r7, r6, r0)     // Catch: java.lang.Throwable -> L76
                if (r5 != r1) goto L70
                return r1
            L70:
                Y8.t r5 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L76
                kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L76
                goto L80
            L76:
                r5 = move-exception
                kotlin.Result$a r6 = kotlin.Result.INSTANCE
                java.lang.Object r5 = kotlin.C4849c.a(r5)
                kotlin.Result.b(r5)
            L80:
                Y8.t r5 = Y8.t.f7040a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$ChatApi$onMessage$job$1.AnonymousClass1.emit(kotlin.Pair, e9.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ClawChannelAgentBusBinding$ChatApi$onMessage$job$1(ClawChannelAgentBusBinding clawChannelAgentBusBinding, p9.q<? super String, ? super Message, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC4014c<? super ClawChannelAgentBusBinding$ChatApi$onMessage$job$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = clawChannelAgentBusBinding;
        this.$handler = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ClawChannelAgentBusBinding$ChatApi$onMessage$job$1 clawChannelAgentBusBinding$ChatApi$onMessage$job$1 = new ClawChannelAgentBusBinding$ChatApi$onMessage$job$1(this.this$0, this.$handler, interfaceC4014c);
        clawChannelAgentBusBinding$ChatApi$onMessage$job$1.L$0 = obj;
        return clawChannelAgentBusBinding$ChatApi$onMessage$job$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ClawChannelAgentBusBinding$ChatApi$onMessage$job$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o oVarB = Xa.d.b(this.this$0.incomingMessages);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(m10, this.$handler);
            this.L$0 = g9.h.a(m10);
            this.label = 1;
            if (oVarB.collect(anonymousClass1, this) == objG) {
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
