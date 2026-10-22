package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$querySessionHasMessages$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$querySessionHasMessages$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ InterfaceC5074l<Map<String, Boolean>, Y8.t> $callback;
    final /* synthetic */ Collection<String> $sessionIds;
    int label;
    final /* synthetic */ AgentSession this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$querySessionHasMessages$1$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$querySessionHasMessages$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<Map<String, Boolean>, Y8.t> $callback;
        final /* synthetic */ HashMap<String, Boolean> $map;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super Map<String, Boolean>, Y8.t> interfaceC5074l, HashMap<String, Boolean> map, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$callback = interfaceC5074l;
            this.$map = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$callback, this.$map, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$callback.invoke(this.$map);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentSession$querySessionHasMessages$1(Collection<String> collection, AgentSession agentSession, InterfaceC5074l<? super Map<String, Boolean>, Y8.t> interfaceC5074l, InterfaceC4014c<? super AgentSession$querySessionHasMessages$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$sessionIds = collection;
        this.this$0 = agentSession;
        this.$callback = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$querySessionHasMessages$1(this.$sessionIds, this.this$0, this.$callback, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$querySessionHasMessages$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        HashMap map = new HashMap(this.$sessionIds.size());
        for (String str : this.$sessionIds) {
            boolean z10 = true;
            try {
                if (this.this$0.messageRepository.w(str) == null) {
                    z10 = false;
                }
            } catch (Throwable th) {
                C4148a.t(this.this$0.TAG, "querySessionHasMessages error sessionId:" + str, th, false, 8, null);
            }
            map.put(str, C4109a.a(z10));
        }
        Function2.b(new AnonymousClass1(this.$callback, map, null));
        return Y8.t.f7040a;
    }
}
