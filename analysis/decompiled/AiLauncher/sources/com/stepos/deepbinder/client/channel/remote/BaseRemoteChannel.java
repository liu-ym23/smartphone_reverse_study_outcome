package com.stepos.deepbinder.client.channel.remote;

import android.net.Uri;
import android.os.SystemClock;
import com.stepos.deepbinder.core.channel.IChannel;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.monitor.IPCMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000bH&¢\u0006\u0004\b\u0019\u0010\u0003J\u0015\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/stepos/deepbinder/client/channel/remote/BaseRemoteChannel;", "Lcom/stepos/deepbinder/core/channel/IChannel;", "<init>", "()V", "Lcom/stepos/deepbinder/core/monitor/IPCMonitor$IpcState;", "ipcState", "Lcom/stepos/deepbinder/core/exception/IPCException;", "exception", "", "startTime", "invokeTime", "LY8/t;", "commitIPCState", "(Lcom/stepos/deepbinder/core/monitor/IPCMonitor$IpcState;Lcom/stepos/deepbinder/core/exception/IPCException;JJ)V", Constants.METHOD_CONNECT, "internalConnect", "Lcom/stepos/deepbinder/core/entity/Call;", "call", "Lcom/stepos/deepbinder/core/entity/Reply;", "internalSendCall", "(Lcom/stepos/deepbinder/core/entity/Call;)Lcom/stepos/deepbinder/core/entity/Reply;", "", "ids", "recycleRemote", "([Ljava/lang/Long;)V", "release", "sendCall", "Companion", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseRemoteChannel implements IChannel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Uri cacheUri;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/deepbinder/client/channel/remote/BaseRemoteChannel$Companion;", "", "<init>", "()V", "cacheUri", "Landroid/net/Uri;", "getCacheUri", "()Landroid/net/Uri;", "setCacheUri", "(Landroid/net/Uri;)V", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Uri getCacheUri() {
            return BaseRemoteChannel.cacheUri;
        }

        public final void setCacheUri(Uri uri) {
            BaseRemoteChannel.cacheUri = uri;
        }

        private Companion() {
        }
    }

    private final void commitIPCState(IPCMonitor.IpcState ipcState, IPCException exception, long startTime, long invokeTime) {
        ipcState.setResult(exception != null ? exception.getErrorCode() : 0);
        ipcState.changeDegrade(false);
        ipcState.setCostTime(SystemClock.currentThreadTimeMillis() - (startTime + invokeTime));
        ipcState.setInvokeTime(invokeTime);
        ipcState.commit();
        if (exception != null) {
            throw exception;
        }
    }

    public final void connect() {
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(6);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        try {
            internalConnect();
            e = null;
        } catch (IPCException e10) {
            e = e10;
        }
        commitIPCState(ipcState, e, jCurrentThreadTimeMillis, 0L);
    }

    public abstract void internalConnect();

    public abstract Reply internalSendCall(Call call);

    public final void recycleRemote(Long[] ids) {
        IPCException iPCException;
        p.i(ids, "ids");
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(4);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        try {
            internalRecycle(ids);
            iPCException = null;
        } catch (IPCException e10) {
            iPCException = e10;
        }
        commitIPCState(ipcState, iPCException, jCurrentThreadTimeMillis, 0L);
    }

    public abstract void release();

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.deepbinder.core.entity.Reply sendCall(com.stepos.deepbinder.core.entity.Call r11) {
        /*
            r10 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.p.i(r11, r0)
            com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper r0 = r11.getServiceWrapper()
            r1 = 0
            if (r0 == 0) goto L11
            int r0 = r0.getType()
            goto L12
        L11:
            r0 = r1
        L12:
            r2 = 1
            if (r0 == 0) goto L3b
            if (r0 == r2) goto L2a
            com.stepos.deepbinder.core.monitor.IPCMonitor$IpcState r0 = new com.stepos.deepbinder.core.monitor.IPCMonitor$IpcState
            r3 = 2
            r0.<init>(r3)
            com.stepos.deepbinder.core.entity.wrapper.MethodWrapper r3 = r11.getMethodWrapper()
            java.lang.String r3 = r3.getName()
            r0.setMethodName(r3)
        L28:
            r4 = r0
            goto L41
        L2a:
            com.stepos.deepbinder.core.monitor.IPCMonitor$IpcState r0 = new com.stepos.deepbinder.core.monitor.IPCMonitor$IpcState
            r0.<init>(r2)
            com.stepos.deepbinder.core.entity.wrapper.MethodWrapper r3 = r11.getMethodWrapper()
            java.lang.String r3 = r3.getName()
            r0.setMethodName(r3)
            goto L28
        L3b:
            com.stepos.deepbinder.core.monitor.IPCMonitor$IpcState r0 = new com.stepos.deepbinder.core.monitor.IPCMonitor$IpcState
            r0.<init>(r1)
            goto L28
        L41:
            com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper r0 = r11.getServiceWrapper()
            r3 = 0
            if (r0 == 0) goto L4d
            java.lang.String r0 = r0.getName()
            goto L4e
        L4d:
            r0 = r3
        L4e:
            r4.setServiceName(r0)
            long r6 = android.os.SystemClock.currentThreadTimeMillis()
            com.stepos.deepbinder.core.entity.Reply r3 = r10.internalSendCall(r11)     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L78
            int r0 = r11.getDataSize()     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L78
            r4.setDataSize(r0)     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L78
            r3.getInvokeTime()     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L78
            com.stepos.deepbinder.core.exception.IPCException r0 = r3.getIpcException()     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L78
            if (r0 == 0) goto L7b
            int r5 = r0.getErrorCode()     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L78
            r8 = 22
            if (r5 != r8) goto L7b
            boolean r11 = r11.getAutoRecover()     // Catch: com.stepos.deepbinder.core.exception.IPCException -> L78
            if (r11 == 0) goto L7b
            goto L7c
        L78:
            r0 = move-exception
            r11 = r0
            goto L7c
        L7b:
            r1 = r2
        L7c:
            r5 = r0
            r11 = r3
            if (r1 == 0) goto L96
            if (r11 == 0) goto L89
            long r0 = r11.getInvokeTime()
        L86:
            r3 = r10
            r8 = r0
            goto L8c
        L89:
            r0 = 0
            goto L86
        L8c:
            r3.commitIPCState(r4, r5, r6, r8)
            if (r11 == 0) goto L92
            return r11
        L92:
            kotlin.jvm.internal.p.f(r5)
            throw r5
        L96:
            kotlin.jvm.internal.p.f(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel.sendCall(com.stepos.deepbinder.core.entity.Call):com.stepos.deepbinder.core.entity.Reply");
    }
}
