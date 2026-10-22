package com.stepos.agentframework.chatcore.send;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.send.SessionPrefetchStage$start$d$1", f = "SessionPrefetchStage.kt", l = {47}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionPrefetchStage$start$d$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super String>, Object> {
    int label;
    final /* synthetic */ SessionPrefetchStage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionPrefetchStage$start$d$1(SessionPrefetchStage sessionPrefetchStage, InterfaceC4014c<? super SessionPrefetchStage$start$d$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.this$0 = sessionPrefetchStage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new SessionPrefetchStage$start$d$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super String> interfaceC4014c) {
        return ((SessionPrefetchStage$start$d$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
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
        InterfaceC5074l interfaceC5074l = this.this$0.fetch;
        this.label = 1;
        Object objInvoke = interfaceC5074l.invoke(this);
        return objInvoke == objG ? objG : objInvoke;
    }
}
