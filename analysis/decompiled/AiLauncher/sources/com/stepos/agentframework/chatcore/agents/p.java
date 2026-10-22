package com.stepos.agentframework.chatcore.agents;

import La.H;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a7\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\t\u001a\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "Lcom/stepos/agentframework/chatcore/intent/e;", "cachedTools", "", "showTools", Const.INTENT_KEY_UMID, "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "resultTools", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Ljava/util/List;)Z", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class p {
    public static final boolean b(List<AgentTool> cachedTools, List<AgentTool> resultTools) {
        AgentTool agentTool;
        kotlin.jvm.internal.p.i(cachedTools, "cachedTools");
        kotlin.jvm.internal.p.i(resultTools, "resultTools");
        Ka.j jVarF = SequencesKt___SequencesKt.F(F.d0(resultTools), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.agents.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(p.c((AgentTool) obj));
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : jVarF) {
            linkedHashMap.put(((AgentTool) obj).getToolCallId(), obj);
        }
        boolean z10 = false;
        for (AgentTool agentTool2 : cachedTools) {
            if (!H.x0(agentTool2.getToolCallId()) && (agentTool = (AgentTool) linkedHashMap.get(agentTool2.getToolCallId())) != null) {
                AgentTool agentToolB = AgentTool.b(agentTool, null, null, null, null, null, null, null, false, null, null, null, null, null, 0, false, null, 0, 0L, false, 524287, null);
                com.stepos.agentframework.chatcore.intent.f.a(agentToolB, agentTool2);
                agentTool2.z(agentToolB.getDisplayName());
                agentTool2.B(agentToolB.getHidden());
                agentTool2.K(agentTool.getResult());
                agentTool2.x(agentTool.getAppUIData());
                z10 = true;
                agentTool2.A(true);
            }
        }
        return z10;
    }

    public static final boolean c(AgentTool it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !H.x0(it.getToolCallId());
    }

    public static final List<AgentTool> d(List<AgentTool> list, List<AgentTool> list2) {
        List<AgentTool> list3 = list2;
        if (list3 != null && !list3.isEmpty()) {
            if (list == null) {
                list = new ArrayList<>();
            }
            for (AgentTool agentTool : list2) {
                Iterator<AgentTool> it = list.iterator();
                int i10 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i10 = -1;
                        break;
                    }
                    AgentTool next = it.next();
                    if (kotlin.jvm.internal.p.d(next.getToolCallId(), agentTool.getToolCallId()) && !H.x0(next.getToolCallId())) {
                        break;
                    }
                    i10++;
                }
                if (i10 >= 0) {
                    list.set(i10, agentTool);
                } else {
                    list.add(agentTool);
                }
            }
        }
        return list;
    }
}
