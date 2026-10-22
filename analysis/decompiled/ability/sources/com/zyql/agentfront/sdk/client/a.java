package com.zyql.agentfront.sdk.client;

import C7.r;
import S7.k;
import android.os.RemoteException;
import com.zyql.agentfront.IMessageBridge;
import com.zyql.agentfront.bean.Message;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4240a;
    public final /* synthetic */ b b;

    public /* synthetic */ a(b bVar, int i) {
        this.f4240a = i;
        this.b = bVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) throws RemoteException {
        int i = this.f4240a;
        b bVar = this.b;
        Message msg = (Message) obj;
        switch (i) {
            case 0:
                kotlin.jvm.internal.k.f(msg, "msg");
                b.f4243s.b("AgentFrontClient", "Resending pending message: " + msg.getMessageId());
                IMessageBridge iMessageBridge = bVar.f5289a;
                if (iMessageBridge != null) {
                    iMessageBridge.sendMessage(msg);
                }
                break;
            default:
                kotlin.jvm.internal.k.f(msg, "msg");
                try {
                    IMessageBridge iMessageBridge2 = bVar.f5289a;
                    if (iMessageBridge2 != null) {
                        iMessageBridge2.sendMessage(msg);
                    }
                } catch (RemoteException e) {
                    b.f4243s.a("AgentFrontClient", "Failed to send pending message: " + e.getMessage(), null);
                }
                break;
        }
        return r.f317a;
    }
}
