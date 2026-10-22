package com.stepos.mcp.sdk.java.transport;

import android.os.RemoteException;
import com.stepos.mcp.sdk.IMCPBinderCallback;
import java.util.function.BiConsumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2736c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ AIDLServerTransportProvider f2737f;

    public /* synthetic */ c(int i) {
        this.f2736c = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) throws RemoteException {
        int i = this.f2736c;
        AIDLServerTransportProvider aIDLServerTransportProvider = this.f2737f;
        String str = (String) obj;
        IMCPBinderCallback iMCPBinderCallback = (IMCPBinderCallback) obj2;
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
