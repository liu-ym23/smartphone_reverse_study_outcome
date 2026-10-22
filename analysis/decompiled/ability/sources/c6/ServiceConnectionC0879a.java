package c6;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.taskrobot.app.init.TaskRobotInit;
import com.zyql.agentfront.IMessageBridge;
import f6.AbstractC1436a;
import kotlin.jvm.internal.k;
import l7.AbstractC1663a;

/* renamed from: c6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ServiceConnectionC0879a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2090a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ServiceConnectionC0879a(Object obj, int i) {
        this.f2090a = i;
        this.b = obj;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName name, IBinder service) {
        switch (this.f2090a) {
            case 0:
                k.f(name, "name");
                k.f(service, "service");
                AbstractC1436a.a(((TaskRobotInit) this.b).tag, "KeyboardIME connected", true);
                break;
            default:
                if (!((AbstractC1663a) this.b).h) {
                    AbstractC1663a abstractC1663a = (AbstractC1663a) this.b;
                    if (!abstractC1663a.e) {
                        k.c(service);
                        IMessageBridge iMessageBridgeAsInterface = IMessageBridge.Stub.asInterface(service);
                        k.e(iMessageBridgeAsInterface, "asInterface(...)");
                        abstractC1663a.f5289a = iMessageBridgeAsInterface;
                        AbstractC1663a abstractC1663a2 = (AbstractC1663a) this.b;
                        abstractC1663a2.b = 2;
                        abstractC1663a2.d = 0;
                        com.zyql.agentfront.sdk.client.b bVar = (com.zyql.agentfront.sdk.client.b) abstractC1663a2;
                        try {
                            IMessageBridge iMessageBridge = bVar.f5289a;
                            if (iMessageBridge != null) {
                                iMessageBridge.registerListener(bVar.o, "business", bVar.f4244j.getPackageName());
                            }
                            com.zyql.agentfront.sdk.client.b.f4243s.b("AgentFrontClient", "Re-registered listener after reconnection.");
                            bVar.e(new com.zyql.agentfront.sdk.client.a(bVar, 0));
                        } catch (RemoteException e) {
                            com.zyql.agentfront.sdk.client.b.f4243s.a("AgentFrontClient", "Failed to register listener: " + e.getMessage(), null);
                        }
                        l7.b bVar2 = ((AbstractC1663a) this.b).c;
                        if (bVar2 != null) {
                            bVar2.onConnected();
                            break;
                        }
                    }
                }
                break;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName name) {
        switch (this.f2090a) {
            case 0:
                k.f(name, "name");
                AbstractC1436a.a(((TaskRobotInit) this.b).tag, "KeyboardIME disconnected", true);
                break;
            default:
                AbstractC1663a abstractC1663a = (AbstractC1663a) this.b;
                abstractC1663a.f5289a = null;
                abstractC1663a.b = 0;
                l7.b bVar = abstractC1663a.c;
                if (bVar != null) {
                    bVar.onDisconnected();
                }
                AbstractC1663a abstractC1663a2 = (AbstractC1663a) this.b;
                if (!abstractC1663a2.e && !abstractC1663a2.h) {
                    ((AbstractC1663a) this.b).f(null);
                    break;
                }
                break;
        }
    }
}
