package com.stepos.agentframework.adapter.dify;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.adapter.netcore.h;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1", f = "DifyCoreAgentClient.kt", l = {108, 122}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class DifyCoreAgentClient$chat$eventSource$1$onClosed$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ Ref$ObjectRef<C0917m> $lastReplyInfo;
    final /* synthetic */ h $listener;
    final /* synthetic */ Ref$ObjectRef<String> $messageId;
    final /* synthetic */ C0918n $request;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$1", f = "DifyCoreAgentClient.kt", l = {110}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ Ref$ObjectRef<C0917m> $lastReplyInfo;
        final /* synthetic */ h $listener;
        final /* synthetic */ Ref$ObjectRef<String> $messageId;
        final /* synthetic */ C0918n $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(C0918n c0918n, Ref$ObjectRef<String> ref$ObjectRef, Ref$ObjectRef<C0917m> ref$ObjectRef2, h hVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$request = c0918n;
            this.$messageId = ref$ObjectRef;
            this.$lastReplyInfo = ref$ObjectRef2;
            this.$listener = hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$request, this.$messageId, this.$lastReplyInfo, this.$listener, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    c cVarA = c.INSTANCE.a();
                    String agentId = this.$request.getAgentId();
                    String str = this.$messageId.f34820a;
                    if (str == null) {
                        str = "";
                    }
                    this.label = 1;
                    obj = cVarA.g(agentId, str, this);
                    if (obj == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                j4.d dVar = (j4.d) obj;
                C0917m c0917m = this.$lastReplyInfo.f34820a;
                if (c0917m == null) {
                    return null;
                }
                h hVar = this.$listener;
                C0918n c0918n = this.$request;
                c0917m.U(dVar != null ? dVar.a() : null);
                hVar.g(c0918n, c0917m);
                return t.f7040a;
            } catch (Exception e10) {
                e10.printStackTrace();
                return t.f7040a;
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$2", f = "DifyCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ h $listener;
        final /* synthetic */ C0918n $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(h hVar, C0918n c0918n, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$listener = hVar;
            this.$request = c0918n;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$listener, this.$request, interfaceC4014c);
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
            this.$listener.j(this.$request);
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DifyCoreAgentClient$chat$eventSource$1$onClosed$1(C0918n c0918n, Ref$ObjectRef<String> ref$ObjectRef, Ref$ObjectRef<C0917m> ref$ObjectRef2, h hVar, InterfaceC4014c<? super DifyCoreAgentClient$chat$eventSource$1$onClosed$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$request = c0918n;
        this.$messageId = ref$ObjectRef;
        this.$lastReplyInfo = ref$ObjectRef2;
        this.$listener = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DifyCoreAgentClient$chat$eventSource$1$onClosed$1(this.$request, this.$messageId, this.$lastReplyInfo, this.$listener, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((DifyCoreAgentClient$chat$eventSource$1$onClosed$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
    
        if (Ua.C1056g.j(r11, r1, r10) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r11)
            goto L53
        L12:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L1a:
            kotlin.C4849c.b(r11)
            goto L3c
        L1e:
            kotlin.C4849c.b(r11)
            Ua.I r11 = Ua.Y.b()
            com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$1 r4 = new com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$1
            K6.n r5 = r10.$request
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r6 = r10.$messageId
            kotlin.jvm.internal.Ref$ObjectRef<K6.m> r7 = r10.$lastReplyInfo
            com.stepos.agentframework.adapter.netcore.h r8 = r10.$listener
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            r10.label = r3
            java.lang.Object r11 = Ua.C1056g.j(r11, r4, r10)
            if (r11 != r0) goto L3c
            goto L52
        L3c:
            Ua.I r11 = Ua.Y.b()
            com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$2 r1 = new com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1$2
            com.stepos.agentframework.adapter.netcore.h r3 = r10.$listener
            K6.n r4 = r10.$request
            r5 = 0
            r1.<init>(r3, r4, r5)
            r10.label = r2
            java.lang.Object r10 = Ua.C1056g.j(r11, r1, r10)
            if (r10 != r0) goto L53
        L52:
            return r0
        L53:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1$onClosed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
