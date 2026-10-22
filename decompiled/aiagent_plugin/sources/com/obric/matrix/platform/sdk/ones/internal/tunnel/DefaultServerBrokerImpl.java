package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.os.IBinder;
import com.obric.matrix.platform.server.IServerBroker;
import com.obric.matrix.platform.server.IServerCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class DefaultServerBrokerImpl implements IServerBroker {
    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.obric.matrix.platform.server.IServerBroker
    public byte[] invoke(int r1, byte[] r2) {
        return new byte[0];
    }

    @Override // com.obric.matrix.platform.server.IServerBroker
    public void invokeAsyn(int r1, byte[] r2, IServerCallback r3) {
        IServerCallback r0 = (IServerCallback) ZeusTransformUtils.wrapperContextForParams(r3, IServerCallback.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.matrix.platform.server.IServerBroker
    public void registerServerCallback(String r1, IServerCallback r2) {
        IServerCallback r0 = (IServerCallback) ZeusTransformUtils.wrapperContextForParams(r2, IServerCallback.class, "com.obric.aiagent.plugin");
    }

    DefaultServerBrokerImpl() {
    }
}
