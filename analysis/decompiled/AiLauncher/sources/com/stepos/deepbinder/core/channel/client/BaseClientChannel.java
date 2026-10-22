package com.stepos.deepbinder.core.channel.client;

import android.os.SystemClock;
import com.stepos.deepbinder.core.channel.IChannel;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.monitor.IPCMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H$¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/stepos/deepbinder/core/channel/client/BaseClientChannel;", "Lcom/stepos/deepbinder/core/channel/IChannel;", "<init>", "()V", "Lcom/stepos/deepbinder/core/entity/Callback;", "callback", "Lcom/stepos/deepbinder/core/entity/Reply;", "internalSendCallback", "(Lcom/stepos/deepbinder/core/entity/Callback;)Lcom/stepos/deepbinder/core/entity/Reply;", "", "", Constants.PARAM_TIMESTAMPS, "LY8/t;", "recycleClient", "([Ljava/lang/Long;)V", "sendCallback", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseClientChannel implements IChannel {
    public abstract Reply internalSendCallback(Callback callback);

    public final void recycleClient(Long[] timeStamps) {
        p.i(timeStamps, "timeStamps");
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(5);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        try {
            internalRecycle(timeStamps);
            ipcState.setResult(0);
            e = null;
        } catch (IPCException e10) {
            e = e10;
        }
        ipcState.setCostTime(SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis);
        ipcState.commit();
        if (e != null) {
            throw e;
        }
    }

    public final Reply sendCallback(Callback callback) {
        Reply replyInternalSendCallback;
        p.i(callback, "callback");
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(3);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        IPCException iPCException = null;
        long invokeTime = 0;
        try {
            replyInternalSendCallback = internalSendCallback(callback);
            try {
                ipcState.setDataSize(callback.getDataSize());
                invokeTime = replyInternalSendCallback.getInvokeTime();
                IPCException ipcException = replyInternalSendCallback.getIpcException();
                ipcState.setResult(ipcException != null ? ipcException.getErrorCode() : 0);
            } catch (IPCException e10) {
                iPCException = e10;
            }
        } catch (IPCException e11) {
            iPCException = e11;
            replyInternalSendCallback = null;
        }
        if (iPCException != null) {
            ipcState.setResult(iPCException.getErrorCode());
        }
        ipcState.setCostTime((SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis) - invokeTime);
        ipcState.commit();
        if (iPCException == null) {
            return replyInternalSendCallback;
        }
        throw iPCException;
    }
}
