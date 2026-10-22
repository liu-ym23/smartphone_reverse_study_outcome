package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001f\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/AgentEntranceCache;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/aispace/connect/data/j;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/aispace/connect/data/j;", "", "deviceId", "LY8/t;", "c", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LXa/k;", "_state", "LXa/k;", "LXa/t;", VoiceWakeupReceiver.EXTRA_STATE, "LXa/t;", Const.INTENT_KEY_PKGNAME, "()LXa/t;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentEntranceCache {
    public static final AgentEntranceCache INSTANCE = new AgentEntranceCache();
    private static final Xa.k<AgentEntranceResponseData> _state;
    private static final Xa.t<AgentEntranceResponseData> state;

    static {
        Xa.k<AgentEntranceResponseData> kVarA = Xa.u.a(null);
        _state = kVarA;
        state = Xa.d.c(kVarA);
    }

    public static /* synthetic */ Object d(AgentEntranceCache agentEntranceCache, String str, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return agentEntranceCache.c(str, interfaceC4014c);
    }

    public final AgentEntranceResponseData a() {
        return _state.getValue();
    }

    public final Xa.t<AgentEntranceResponseData> b() {
        return state;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache$refresh$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache$refresh$1 r0 = (com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache$refresh$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache$refresh$1 r0 = new com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache$refresh$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r4)
            kotlin.Result r4 = (kotlin.Result) r4
            java.lang.Object r4 = r4.getValue()
            goto L4f
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.C4849c.b(r4)
            com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository r4 = com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.INSTANCE
            java.lang.Object r1 = g9.h.a(r5)
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r4 = r4.t(r5, r0)
            if (r4 != r6) goto L4f
            return r6
        L4f:
            boolean r5 = kotlin.Result.h(r4)
            if (r5 == 0) goto L5c
            com.stepos.ailauncher.agent.aispace.connect.data.j r4 = (com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceResponseData) r4
            Xa.k<com.stepos.ailauncher.agent.aispace.connect.data.j> r5 = com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache._state
            r5.setValue(r4)
        L5c:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache.c(java.lang.String, e9.c):java.lang.Object");
    }
}
