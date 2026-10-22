package com.bytedance.agentrobots.operation;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class AgentOperationStateMachine {

    /* JADX INFO: renamed from: com.bytedance.agentrobots.operation.AgentOperationStateMachine$1, reason: invalid class name */
    public class AnonymousClass1 extends LinkedHashMap<String, Object> {
        final /* synthetic */ AgentOperationStateMachine this$0;

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Object> r100) {
            if (size() <= 64) goto L5;
            return true;
        L5:
            return false;
        }

        public AnonymousClass1(AgentOperationStateMachine r100, int r101, float r102, boolean r103) {
            super(r101, r102, r103);
        }
    }
}
