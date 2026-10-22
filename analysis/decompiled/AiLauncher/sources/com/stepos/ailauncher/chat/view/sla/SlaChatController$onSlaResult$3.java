package com.stepos.ailauncher.chat.view.sla;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.send.SlaSessionAnchor;
import com.stepos.aiengine.algorithm.sla.SlaResult;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$3", f = "SlaChatController.kt", l = {882, 883}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaChatController$onSlaResult$3 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ SlaSessionAnchor $anchor;
    final /* synthetic */ String $query;
    final /* synthetic */ SlaResult $result;
    final /* synthetic */ InterfaceC5063a<t> $routeToBackend;
    final /* synthetic */ String $traceId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SlaChatController this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$3$2", f = "SlaChatController.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$3$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ String $query;
        final /* synthetic */ InterfaceC5063a<t> $routeToBackend;
        final /* synthetic */ String $traceId;
        int label;
        final /* synthetic */ SlaChatController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SlaChatController slaChatController, String str, String str2, InterfaceC5063a<t> interfaceC5063a, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = slaChatController;
            this.$traceId = str;
            this.$query = str2;
            this.$routeToBackend = interfaceC5063a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.this$0, this.$traceId, this.$query, this.$routeToBackend, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.this$0.U0(this.$traceId, this.$query, this.$routeToBackend, "result-fail");
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaChatController$onSlaResult$3(SlaChatController slaChatController, String str, SlaResult slaResult, String str2, SlaSessionAnchor slaSessionAnchor, InterfaceC5063a<t> interfaceC5063a, InterfaceC4014c<? super SlaChatController$onSlaResult$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = slaChatController;
        this.$query = str;
        this.$result = slaResult;
        this.$traceId = str2;
        this.$anchor = slaSessionAnchor;
        this.$routeToBackend = interfaceC5063a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SlaChatController$onSlaResult$3 slaChatController$onSlaResult$3 = new SlaChatController$onSlaResult$3(this.this$0, this.$query, this.$result, this.$traceId, this.$anchor, this.$routeToBackend, interfaceC4014c);
        slaChatController$onSlaResult$3.L$0 = obj;
        return slaChatController$onSlaResult$3;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SlaChatController$onSlaResult$3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
    
        if (Ua.C1056g.j(r0, r9, r15) == r7) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r16) throws java.lang.Throwable {
        /*
            r15 = this;
            java.lang.Object r0 = r15.L$0
            r6 = r0
            Ua.M r6 = (Ua.M) r6
            java.lang.Object r7 = f9.C4063a.g()
            int r0 = r15.label
            r8 = 2
            r1 = 1
            if (r0 == 0) goto L2a
            if (r0 == r1) goto L20
            if (r0 != r8) goto L18
            kotlin.C4849c.b(r16)
            goto L89
        L18:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L20:
            java.lang.Object r0 = r15.L$1
            Ua.M r0 = (Ua.M) r0
            kotlin.C4849c.b(r16)     // Catch: java.lang.Throwable -> L28
            goto L56
        L28:
            r0 = move-exception
            goto L5c
        L2a:
            kotlin.C4849c.b(r16)
            com.stepos.ailauncher.chat.view.sla.SlaChatController r0 = r15.this$0
            java.lang.String r2 = r15.$query
            r3 = r2
            com.stepos.aiengine.algorithm.sla.SlaResult r2 = r15.$result
            r4 = r3
            java.lang.String r3 = r15.$traceId
            r9 = r4
            com.stepos.agentframework.chatcore.send.l r4 = r15.$anchor
            kotlin.Result$a r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L28
            java.lang.Object r10 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L28
            r15.L$0 = r10     // Catch: java.lang.Throwable -> L28
            java.lang.Object r10 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L28
            r15.L$1 = r10     // Catch: java.lang.Throwable -> L28
            r10 = 0
            r15.I$0 = r10     // Catch: java.lang.Throwable -> L28
            r15.label = r1     // Catch: java.lang.Throwable -> L28
            r5 = r15
            r1 = r9
            java.lang.Object r0 = com.stepos.ailauncher.chat.view.sla.SlaChatController.J(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L28
            if (r0 != r7) goto L56
            goto L88
        L56:
            Y8.t r0 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L28
            kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L28
            goto L65
        L5c:
            kotlin.Result$a r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            kotlin.Result.b(r0)
        L65:
            Ua.A0 r0 = Ua.Y.c()
            com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$3$2 r9 = new com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$3$2
            com.stepos.ailauncher.chat.view.sla.SlaChatController r10 = r15.this$0
            java.lang.String r11 = r15.$traceId
            java.lang.String r12 = r15.$query
            p9.a<Y8.t> r13 = r15.$routeToBackend
            r14 = 0
            r9.<init>(r10, r11, r12, r13, r14)
            java.lang.Object r1 = g9.h.a(r6)
            r15.L$0 = r1
            r1 = 0
            r15.L$1 = r1
            r15.label = r8
            java.lang.Object r0 = Ua.C1056g.j(r0, r9, r15)
            if (r0 != r7) goto L89
        L88:
            return r7
        L89:
            Y8.t r0 = Y8.t.f7040a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
