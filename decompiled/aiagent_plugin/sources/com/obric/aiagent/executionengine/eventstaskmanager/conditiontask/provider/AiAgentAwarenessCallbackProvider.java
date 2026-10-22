package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.provider;

import android.os.Bundle;
import com.obric.aiagent.executionengine.eventstaskmanager.b.b;
import com.obric.memorydata.sdk.awareness.BaseAwarenessCallbackProvider;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AiAgentAwarenessCallbackProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AiAgentAwarenessCallbackProvider extends BaseAwarenessCallbackProvider {
    public static final a Companion = null;
    private static final String TAG = "AiAgentAwarenessCallbackProvider";

    /* JADX INFO: compiled from: AiAgentAwarenessCallbackProvider.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public AiAgentAwarenessCallbackProvider() {
    }

    @Override // com.obric.memorydata.sdk.awareness.BaseAwarenessCallbackProvider
    public void onFeatureEvent(String r3, String r4, Object r5, Object r6, Bundle r7) {
        o.e(r3, "subscriptionId");
        o.e(r4, "featureName");
        b.f16676a.b(TAG, "onFeatureEvent subscriptionId=" + r3 + " feature=" + r4 + " old=" + r5 + " new=" + r6);
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r3, r4, r6, r7);
    }

    @Override // com.obric.memorydata.sdk.awareness.BaseAwarenessCallbackProvider
    public void onContextEvent(String r3, String r4, Bundle r5) {
        o.e(r3, "subscriptionId");
        o.e(r4, "eventName");
        b.f16676a.b(TAG, "onContextEvent subscriptionId=" + r3 + " event=" + r4 + " extras=" + r5);
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a.a(r3, r4, r5);
    }
}
