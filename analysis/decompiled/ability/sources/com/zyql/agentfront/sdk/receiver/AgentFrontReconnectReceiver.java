package com.zyql.agentfront.sdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.zyql.agentfront.IMessageBridge;
import com.zyql.agentfront.sdk.client.b;
import com.zyql.agentfront.sdk.client.e;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/zyql/agentfront/sdk/receiver/AgentFrontReconnectReceiver;", "Landroid/content/BroadcastReceiver;", AppAgent.CONSTRUCT, "()V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentFrontReconnectReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        k.f(context, "context");
        k.f(intent, "intent");
        if (k.b(intent.getAction(), "com.zyql.agentfront.ACTION_PUSH_RECONNECT")) {
            e eVar = b.p;
            e eVar2 = b.p;
            if (eVar2 == null) {
                Log.d("AgentFrontReconnectReceiver", "No saved PushMessageListener, ignoring");
                return;
            }
            Log.i("AgentFrontReconnectReceiver", "Received reconnect broadcast, reconnecting...");
            b bVar = b.f4242r;
            if (bVar == null) {
                Context context2 = b.f4241q;
                if (context2 != null) {
                    context = context2;
                }
                new b(context).n(eVar2);
                return;
            }
            Log.i("AgentFrontReconnectReceiver", "Reusing existing AgentFrontClient instance");
            bVar.n(eVar2);
            boolean zIsReady = false;
            try {
                IMessageBridge iMessageBridge = bVar.f5289a;
                b.f4243s.b("AgentFrontClient", "[API] isServiceReady. ready:" + (iMessageBridge != null ? Boolean.valueOf(iMessageBridge.isReady()) : null));
                if (iMessageBridge != null) {
                    zIsReady = iMessageBridge.isReady();
                }
            } catch (RemoteException unused) {
            }
            if (zIsReady) {
                return;
            }
            bVar.h();
        }
    }
}
