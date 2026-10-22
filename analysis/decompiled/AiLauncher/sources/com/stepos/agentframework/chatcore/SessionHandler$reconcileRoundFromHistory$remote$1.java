package com.stepos.agentframework.chatcore;

import Ua.M;
import Ua.Q;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lw4/c;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$reconcileRoundFromHistory$remote$1", f = "SessionHandler.kt", l = {2541}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$reconcileRoundFromHistory$remote$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super List<? extends ChatMessage>>, Object> {
    final /* synthetic */ Q<List<ChatMessage>> $pullJob;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SessionHandler$reconcileRoundFromHistory$remote$1(Q<? extends List<ChatMessage>> q10, InterfaceC4014c<? super SessionHandler$reconcileRoundFromHistory$remote$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$pullJob = q10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$reconcileRoundFromHistory$remote$1(this.$pullJob, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<ChatMessage>> interfaceC4014c) {
        return ((SessionHandler$reconcileRoundFromHistory$remote$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
        Q<List<ChatMessage>> q10 = this.$pullJob;
        this.label = 1;
        Object objA1 = q10.a1(this);
        return objA1 == objG ? objG : objA1;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends ChatMessage>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<ChatMessage>>) interfaceC4014c);
    }
}
