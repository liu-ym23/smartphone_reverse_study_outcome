package com.stepos.mcp.sdk.java.transport;

import android.os.RemoteException;
import com.stepos.mcp.sdk.IMCPBinderCallback;
import java.util.function.BiConsumer;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3834a;
    public final /* synthetic */ AIDLServerTransportProvider b;

    public /* synthetic */ c(AIDLServerTransportProvider aIDLServerTransportProvider, int i) {
        this.f3834a = i;
        this.b = aIDLServerTransportProvider;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) throws RemoteException {
        int i = this.f3834a;
        String str = (String) obj;
        IMCPBinderCallback iMCPBinderCallback = (IMCPBinderCallback) obj2;
        AIDLServerTransportProvider aIDLServerTransportProvider = this.b;
        switch (i) {
            case 0:
                aIDLServerTransportProvider.createSession(str, iMCPBinderCallback);
                break;
            default:
                aIDLServerTransportProvider.unregisterDeathRecipient(str, iMCPBinderCallback);
                break;
        }
    }
}
