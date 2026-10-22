package com.stepos.agentframework.chatcore.session;

import Ua.C1056g;
import com.stepos.agentframework.chatcore.SessionHandler;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.PushMessageCenter$adoptServerInitiatedRound$1", f = "PushMessageCenter.kt", l = {157}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class PushMessageCenter$adoptServerInitiatedRound$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ SessionHandler $handler;
    final /* synthetic */ String $outboundId;
    final /* synthetic */ String $sessionId;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.PushMessageCenter$adoptServerInitiatedRound$1$1", f = "PushMessageCenter.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.PushMessageCenter$adoptServerInitiatedRound$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
        final /* synthetic */ SessionHandler $handler;
        final /* synthetic */ String $outboundId;
        final /* synthetic */ String $sessionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SessionHandler sessionHandler, String str, String str2, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$handler = sessionHandler;
            this.$sessionId = str;
            this.$outboundId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$handler, this.$sessionId, this.$outboundId, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return C4109a.a(this.$handler.C0(this.$sessionId, this.$outboundId));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushMessageCenter$adoptServerInitiatedRound$1(SessionHandler sessionHandler, String str, String str2, InterfaceC4014c<? super PushMessageCenter$adoptServerInitiatedRound$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$handler = sessionHandler;
        this.$sessionId = str;
        this.$outboundId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PushMessageCenter$adoptServerInitiatedRound$1(this.$handler, this.$sessionId, this.$outboundId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((PushMessageCenter$adoptServerInitiatedRound$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        Ua.A0 immediate = Ua.Y.c().getImmediate();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, this.$sessionId, this.$outboundId, null);
        this.label = 1;
        Object objJ = C1056g.j(immediate, anonymousClass1, this);
        return objJ == objG ? objG : objJ;
    }
}
