package com.stepos.agentframework.adapter.agentbus;

import Z8.C1174w;
import a4.Message;
import com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.SyncHistoryResult;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LK6/D;", "<anonymous>", "(LUa/M;)LK6/D;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusChannelOpsKt$syncHistory$2", f = "AgentBusChannelOps.kt", l = {99}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusChannelOpsKt$syncHistory$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super SyncHistoryResult>, Object> {
    final /* synthetic */ int $limit;
    final /* synthetic */ String $sessionKey;
    final /* synthetic */ ClawChannelAgentBusBinding $this_syncHistory;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusChannelOpsKt$syncHistory$2(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, int i10, InterfaceC4014c<? super AgentBusChannelOpsKt$syncHistory$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$this_syncHistory = clawChannelAgentBusBinding;
        this.$sessionKey = str;
        this.$limit = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusChannelOpsKt$syncHistory$2 agentBusChannelOpsKt$syncHistory$2 = new AgentBusChannelOpsKt$syncHistory$2(this.$this_syncHistory, this.$sessionKey, this.$limit, interfaceC4014c);
        agentBusChannelOpsKt$syncHistory$2.L$0 = obj;
        return agentBusChannelOpsKt$syncHistory$2;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super SyncHistoryResult> interfaceC4014c) {
        return ((AgentBusChannelOpsKt$syncHistory$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                ClawChannelAgentBusBinding clawChannelAgentBusBinding = this.$this_syncHistory;
                String str = this.$sessionKey;
                int i11 = this.$limit;
                Result.Companion companion = Result.INSTANCE;
                ClawChannelAgentBusBinding.ChatApi chat = clawChannelAgentBusBinding.getChat();
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = ClawChannelAgentBusBinding.ChatApi.d(chat, str, i11, null, 10000L, null, this, 20, null);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((List) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            return new SyncHistoryResult(null, false, thE.getMessage(), null, 9, null);
        }
        List list = (List) objB;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(AgentBusChannelOpsKt.N((Message) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Z8.A.E(arrayList2, AgentBusChannelOpsKt.q((Message) it2.next()));
        }
        return new SyncHistoryResult(arrayList, true, null, arrayList2, 4, null);
    }
}
