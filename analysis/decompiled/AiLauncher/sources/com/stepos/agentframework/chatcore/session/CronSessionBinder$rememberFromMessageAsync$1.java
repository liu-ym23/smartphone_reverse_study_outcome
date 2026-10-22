package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.CronSessionBinder$rememberFromMessageAsync$1", f = "CronSessionBinder.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class CronSessionBinder$rememberFromMessageAsync$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $agentId;
    final /* synthetic */ List<String> $jobIds;
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CronSessionBinder$rememberFromMessageAsync$1(List<String> list, String str, String str2, InterfaceC4014c<? super CronSessionBinder$rememberFromMessageAsync$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$jobIds = list;
        this.$sessionId = str;
        this.$agentId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CronSessionBinder$rememberFromMessageAsync$1(this.$jobIds, this.$sessionId, this.$agentId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((CronSessionBinder$rememberFromMessageAsync$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        CronSessionBinder.INSTANCE.i(this.$jobIds, this.$sessionId, this.$agentId);
        return Y8.t.f7040a;
    }
}
