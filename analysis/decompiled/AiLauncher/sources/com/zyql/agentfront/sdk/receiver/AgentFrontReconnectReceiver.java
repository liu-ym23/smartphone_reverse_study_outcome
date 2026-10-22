package com.zyql.agentfront.sdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import com.zyql.agentfront.sdk.client.AgentFrontClient;
import com.zyql.agentfront.sdk.client.o;
import d8.InterfaceC3961a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/zyql/agentfront/sdk/receiver/AgentFrontReconnectReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", Const.INTENT_KEY_APIKEY, "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AgentFrontReconnectReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        p.i(context, "context");
        p.i(intent, "intent");
        if (p.d(intent.getAction(), "com.zyql.agentfront.ACTION_PUSH_RECONNECT")) {
            AgentFrontClient.Companion companion = AgentFrontClient.INSTANCE;
            o oVarC = companion.c();
            if (oVarC == null) {
                InterfaceC3961a.INSTANCE.a().a("AgentFrontReconnectReceiver", "No saved PushMessageListener, ignoring");
                return;
            }
            InterfaceC3961a.Companion companion2 = InterfaceC3961a.INSTANCE;
            companion2.a().e("AgentFrontReconnectReceiver", "Received reconnect broadcast, reconnecting...");
            AgentFrontClient agentFrontClientA = companion.a();
            if (agentFrontClientA == null) {
                Context contextB = companion.b();
                if (contextB != null) {
                    context = contextB;
                }
                new AgentFrontClient(context, null, 2, null).m0(oVarC);
                return;
            }
            companion2.a().e("AgentFrontReconnectReceiver", "Reusing existing AgentFrontClient instance");
            agentFrontClientA.m0(oVarC);
            if (agentFrontClientA.d0()) {
                return;
            }
            agentFrontClientA.V();
        }
    }
}
