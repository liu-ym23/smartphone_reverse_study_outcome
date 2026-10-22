package com.stepos.ability.sdk.client;

import C7.r;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.sdk.client.AgentServiceClient;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class c implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object objA;
        IAgentServiceManager iAgentServiceManagerAsInterface = IAgentServiceManager.Stub.asInterface(iBinder);
        AgentServiceClient.serviceManager = iAgentServiceManagerAsInterface;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(AgentServiceClient.binderDeathRecipient, 0);
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
        }
        AtomicBoolean atomicBoolean = AgentServiceClient.currentBindCallbackInvoked;
        AgentServiceClient agentServiceClient = AgentServiceClient.INSTANCE;
        agentServiceClient.cancelBindTimeoutRunnableOnly();
        AgentServiceClient.currentBindCallbackInvoked = null;
        k.c(iAgentServiceManagerAsInterface);
        agentServiceClient.reRegisterAllTaskListeners(iAgentServiceManagerAsInterface);
        agentServiceClient.completeBindAttemptAfterConnection(true, atomicBoolean);
        S7.k kVar = AgentServiceClient.stateCallback;
        if (kVar != null) {
            kVar.invoke(Boolean.TRUE);
        }
        Iterator it = AgentServiceClient.connectionCallbacks.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            P3.b bVar = P3.c.f1086a;
            if (!zHasNext) {
                bVar.invoke(3, "Ability_".concat("Ability_AgentServiceClient"), "onServiceConnected", null);
                return;
            }
            try {
                ((AgentServiceClient.ConnectionCallback) it.next()).onConnected();
                objA = r.f317a;
            } catch (Throwable th2) {
                objA = kotlin.b.a(th2);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                bVar.invoke(5, "Ability_".concat("Ability_AgentServiceClient"), "onConnected callback threw", thA);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object objA;
        AgentServiceClient.serviceManager = null;
        AgentServiceClient.serviceBound = false;
        AtomicBoolean atomicBoolean = AgentServiceClient.currentBindCallbackInvoked;
        AgentServiceClient agentServiceClient = AgentServiceClient.INSTANCE;
        agentServiceClient.cancelBindTimeoutRunnableOnly();
        AgentServiceClient.currentBindCallbackInvoked = null;
        agentServiceClient.completeBindAttemptAfterConnection(false, atomicBoolean);
        S7.k kVar = AgentServiceClient.stateCallback;
        if (kVar != null) {
            kVar.invoke(Boolean.FALSE);
        }
        Iterator it = AgentServiceClient.connectionCallbacks.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            P3.b bVar = P3.c.f1086a;
            if (!zHasNext) {
                bVar.invoke(3, "Ability_".concat("Ability_AgentServiceClient"), "onServiceDisconnected", null);
                return;
            }
            try {
                ((AgentServiceClient.ConnectionCallback) it.next()).onDisconnected();
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                bVar.invoke(5, "Ability_".concat("Ability_AgentServiceClient"), "onDisconnected callback threw", thA);
            }
        }
    }
}
