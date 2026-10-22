package com.stepos.deepbinder.core.channel.client;

import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.deepbinder.core.api.IClientService;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.proxy.ClientServiceProxy;
import com.stepos.deepbinder.core.utils.ConvertUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/deepbinder/core/channel/client/DefaultClientChannel;", "Lcom/stepos/deepbinder/core/channel/client/BaseClientChannel;", "Landroid/os/IBinder;", "binder", "<init>", "(Landroid/os/IBinder;)V", "", "", "ids", "LY8/t;", "internalRecycle", "([Ljava/lang/Long;)V", "Lcom/stepos/deepbinder/core/entity/Callback;", "callback", "Lcom/stepos/deepbinder/core/entity/Reply;", "internalSendCallback", "(Lcom/stepos/deepbinder/core/entity/Callback;)Lcom/stepos/deepbinder/core/entity/Reply;", "Lcom/stepos/deepbinder/core/api/IClientService;", "clientService", "Lcom/stepos/deepbinder/core/api/IClientService;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DefaultClientChannel extends BaseClientChannel {
    private final IClientService clientService;

    public DefaultClientChannel(IBinder binder) {
        p.i(binder, "binder");
        IClientService proxy = ClientServiceProxy.INSTANCE.getProxy(binder);
        p.f(proxy);
        this.clientService = proxy;
    }

    @Override // com.stepos.deepbinder.core.channel.IChannel
    public void internalRecycle(Long[] ids) {
        p.i(ids, "ids");
        try {
            this.clientService.recycle(-1, ConvertUtils.INSTANCE.toPrimitive(ids));
        } catch (Throwable th) {
            if (th instanceof IPCException) {
                throw th;
            }
            if (!(th instanceof RemoteException)) {
                throw new IPCException(9, th);
            }
            throw new IPCException(26, th);
        }
    }

    @Override // com.stepos.deepbinder.core.channel.client.BaseClientChannel
    public Reply internalSendCallback(Callback callback) {
        p.i(callback, "callback");
        try {
            return this.clientService.sendCallback(callback);
        } catch (Throwable th) {
            if (th instanceof IPCException) {
                throw th;
            }
            if (th instanceof RemoteException) {
                throw new IPCException(2, th);
            }
            throw new IPCException(9, th);
        }
    }
}
