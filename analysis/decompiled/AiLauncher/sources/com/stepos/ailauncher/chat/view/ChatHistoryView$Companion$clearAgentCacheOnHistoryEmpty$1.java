package com.stepos.ailauncher.chat.view;

import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ChatHistoryView$Companion$clearAgentCacheOnHistoryEmpty$1", f = "ChatHistoryView.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatHistoryView$Companion$clearAgentCacheOnHistoryEmpty$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public ChatHistoryView$Companion$clearAgentCacheOnHistoryEmpty$1(InterfaceC4014c<? super ChatHistoryView$Companion$clearAgentCacheOnHistoryEmpty$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ChatHistoryView$Companion$clearAgentCacheOnHistoryEmpty$1 chatHistoryView$Companion$clearAgentCacheOnHistoryEmpty$1 = new ChatHistoryView$Companion$clearAgentCacheOnHistoryEmpty$1(interfaceC4014c);
        chatHistoryView$Companion$clearAgentCacheOnHistoryEmpty$1.L$0 = obj;
        return chatHistoryView$Companion$clearAgentCacheOnHistoryEmpty$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatHistoryView$Companion$clearAgentCacheOnHistoryEmpty$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C4109a.a(AgentCacheSdk.INSTANCE.clearCache()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("ChatHistoryView", "AgentCacheSdk.clearCache failed", thE, false, 8, null);
        }
        Boolean boolA = C4109a.a(false);
        if (Result.g(objB)) {
            objB = boolA;
        }
        C4148a.k("ChatHistoryView", "history emptied by delete -> clearCache delivered=" + ((Boolean) objB).booleanValue(), false, 4, null);
        return Y8.t.f7040a;
    }
}
