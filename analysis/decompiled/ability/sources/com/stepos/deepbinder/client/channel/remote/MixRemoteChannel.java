package com.stepos.deepbinder.client.channel.remote;

import D7.q;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.annotation.method.Synchronize;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.client.channel.ClientChannelManager;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/stepos/deepbinder/client/channel/remote/MixRemoteChannel;", "Lcom/stepos/deepbinder/client/channel/remote/BaseRemoteChannel;", "Landroid/content/ComponentName;", "remoteComponentName", AppAgent.CONSTRUCT, "(Landroid/content/ComponentName;)V", "Lcom/stepos/deepbinder/core/entity/Call;", "call", "LC7/r;", "reConnect", "(Lcom/stepos/deepbinder/core/entity/Call;)V", "Landroid/net/Uri;", "uri", "", "", "ids", "recycleRemoteWhenDisconnect", "(Landroid/net/Uri;[Ljava/lang/Long;)V", "internalConnect", "()V", "internalRecycle", "([Ljava/lang/Long;)V", "Lcom/stepos/deepbinder/core/entity/Reply;", "internalSendCall", "(Lcom/stepos/deepbinder/core/entity/Call;)Lcom/stepos/deepbinder/core/entity/Reply;", "release", "Landroid/content/ComponentName;", "defaultRemoteChannel", "Lcom/stepos/deepbinder/client/channel/remote/BaseRemoteChannel;", "quickRemoteChannel", "Companion", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MixRemoteChannel extends BaseRemoteChannel {
    private static final String TAG = "MixRemoteChannel";
    private BaseRemoteChannel defaultRemoteChannel;
    private volatile BaseRemoteChannel quickRemoteChannel;
    private final ComponentName remoteComponentName;

    public MixRemoteChannel(ComponentName remoteComponentName) {
        k.f(remoteComponentName, "remoteComponentName");
        this.remoteComponentName = remoteComponentName;
        this.defaultRemoteChannel = new DefaultRemoteChannel(remoteComponentName);
        this.quickRemoteChannel = new HookedRemoteChannel(remoteComponentName);
    }

    @Synchronize
    private final void reConnect(Call call) {
        if (this.quickRemoteChannel == null) {
            ClientChannelManager clientChannelManager = ClientChannelManager.INSTANCE;
            clientChannelManager.getRemoteChannel(this.remoteComponentName, this);
            this.defaultRemoteChannel = new DefaultRemoteChannel(this.remoteComponentName);
            this.quickRemoteChannel = new HookedRemoteChannel(this.remoteComponentName);
            BaseRemoteChannel remoteChannel = clientChannelManager.getRemoteChannel(this.remoteComponentName);
            Call callCreate = Call.INSTANCE.create();
            callCreate.setServiceWrapper(call.getServiceWrapper());
            callCreate.setMethodWrapper(call.getMethodWrapper());
            callCreate.setParameterWrappers(call.getParameterWrappers());
            callCreate.setRemoteComponentName(call.getRemoteComponentName());
            remoteChannel.sendCall(callCreate);
            IPCLog.INSTANCE.i(TAG, "reConnect " + this.quickRemoteChannel, new Object[0]);
        }
    }

    private final void recycleRemoteWhenDisconnect(Uri uri, Long[] ids) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.PARAM_PID, Process.myPid());
        bundle.putLongArray(Constants.PARAM_TIMESTAMPS, q.J0(ids));
        DeepBinderClient.INSTANCE.getContext().getContentResolver().call(uri, Constants.METHOD_RECYCLE_REMOTE, "", bundle);
    }

    @Override // com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel
    public void internalConnect() {
        BaseRemoteChannel baseRemoteChannel = this.quickRemoteChannel;
        if (baseRemoteChannel == null) {
            IPCLog.INSTANCE.w(TAG, "internalConnect already connected", new Object[0]);
            return;
        }
        try {
            baseRemoteChannel.internalConnect();
        } catch (IPCException e) {
            if (e.getErrorCode() != 19) {
                throw e;
            }
            BaseRemoteChannel baseRemoteChannel2 = this.defaultRemoteChannel;
            if (baseRemoteChannel2 == null) {
                throw new IPCException(19, "Default channel not initialized");
            }
            baseRemoteChannel2.internalConnect();
        }
    }

    @Override // com.stepos.deepbinder.core.channel.IChannel
    public void internalRecycle(Long[] ids) {
        k.f(ids, "ids");
        BaseRemoteChannel baseRemoteChannel = this.quickRemoteChannel;
        if (baseRemoteChannel == null) {
            IPCLog.INSTANCE.i(TAG, "internalRecycle already released", new Object[0]);
            Uri cacheUri = BaseRemoteChannel.INSTANCE.getCacheUri();
            k.c(cacheUri);
            recycleRemoteWhenDisconnect(cacheUri, ids);
            return;
        }
        try {
            baseRemoteChannel.internalRecycle(ids);
        } catch (IPCException e) {
            if (e.getErrorCode() != 19) {
                throw e;
            }
            BaseRemoteChannel baseRemoteChannel2 = this.defaultRemoteChannel;
            if (baseRemoteChannel2 == null) {
                throw new IPCException(19, "Default channel not initialized");
            }
            baseRemoteChannel2.internalRecycle(ids);
        }
    }

    @Override // com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel
    public Reply internalSendCall(Call call) {
        Reply replyInternalSendCall;
        Reply replyInternalSendCall2;
        k.f(call, "call");
        reConnect(call);
        try {
            BaseRemoteChannel baseRemoteChannel = this.quickRemoteChannel;
            if (baseRemoteChannel == null || (replyInternalSendCall2 = baseRemoteChannel.internalSendCall(call)) == null) {
                throw new IPCException(19, "Channel not initialized");
            }
            return replyInternalSendCall2;
        } catch (IPCException e) {
            if (e.getErrorCode() != 19) {
                throw e;
            }
            reConnect(call);
            BaseRemoteChannel baseRemoteChannel2 = this.defaultRemoteChannel;
            if (baseRemoteChannel2 == null || (replyInternalSendCall = baseRemoteChannel2.internalSendCall(call)) == null) {
                throw new IPCException(19, "Default channel not initialized");
            }
            return replyInternalSendCall;
        }
    }

    @Override // com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel
    public void release() {
        IPCLog.INSTANCE.i(TAG, "release " + this.quickRemoteChannel, new Object[0]);
        BaseRemoteChannel baseRemoteChannel = this.quickRemoteChannel;
        if (baseRemoteChannel != null) {
            baseRemoteChannel.release();
        }
        BaseRemoteChannel baseRemoteChannel2 = this.defaultRemoteChannel;
        if (baseRemoteChannel2 != null) {
            baseRemoteChannel2.release();
        }
        this.quickRemoteChannel = null;
        this.defaultRemoteChannel = null;
    }
}
