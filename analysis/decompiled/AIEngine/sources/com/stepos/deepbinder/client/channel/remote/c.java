package com.stepos.deepbinder.client.channel.remote;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import com.stepos.deepbinder.annotation.method.Synchronize;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: a, reason: collision with root package name */
    public final ComponentName f7625a;

    /* renamed from: b, reason: collision with root package name */
    public b f7626b;

    /* renamed from: c, reason: collision with root package name */
    public volatile HookedRemoteChannel f7627c;

    public c(ComponentName remoteComponentName) {
        g.f(remoteComponentName, "remoteComponentName");
        this.f7625a = remoteComponentName;
        this.f7626b = new b(remoteComponentName);
        this.f7627c = new HookedRemoteChannel(remoteComponentName);
    }

    @Synchronize
    public final void a(Call call) {
        if (this.f7627c == null) {
            j9.a aVar = j9.a.f9742a;
            aVar.b(this.f7625a, this);
            this.f7626b = new b(this.f7625a);
            this.f7627c = new HookedRemoteChannel(this.f7625a);
            a aVarA = aVar.a(this.f7625a);
            Call callCreate = Call.CREATOR.create();
            callCreate.setServiceWrapper(call.getServiceWrapper());
            callCreate.setMethodWrapper(call.getMethodWrapper());
            callCreate.setParameterWrappers(call.getParameterWrappers());
            callCreate.setRemoteComponentName(call.getRemoteComponentName());
            aVarA.sendCall(callCreate);
            IPCLog.INSTANCE.i("MixRemoteChannel", "reConnect " + this.f7627c, new Object[0]);
        }
    }

    @Override // com.stepos.deepbinder.client.channel.remote.a
    public final void internalConnect() throws Throwable {
        HookedRemoteChannel hookedRemoteChannel = this.f7627c;
        if (hookedRemoteChannel == null) {
            IPCLog.INSTANCE.w("MixRemoteChannel", "internalConnect already connected", new Object[0]);
            return;
        }
        try {
            hookedRemoteChannel.internalConnect();
        } catch (IPCException e10) {
            if (e10.getErrorCode() != 19) {
                throw e10;
            }
            b bVar = this.f7626b;
            if (bVar == null) {
                throw new IPCException(19, "Default channel not initialized");
            }
            bVar.internalConnect();
        }
    }

    @Override // o9.b
    public final void internalRecycle(Long[] lArr) {
        HookedRemoteChannel hookedRemoteChannel = this.f7627c;
        if (hookedRemoteChannel == null) {
            IPCLog.INSTANCE.i("MixRemoteChannel", "internalRecycle already released", new Object[0]);
            a.Companion.getClass();
            Uri uri = a.cacheUri;
            g.c(uri);
            Bundle bundle = new Bundle();
            bundle.putInt("pid", Process.myPid());
            bundle.putLongArray("timeStamps", l.r0(lArr));
            DeepBinderClient.INSTANCE.getContext().getContentResolver().call(uri, "recycle_remote", "", bundle);
            return;
        }
        try {
            hookedRemoteChannel.internalRecycle(lArr);
        } catch (IPCException e10) {
            if (e10.getErrorCode() != 19) {
                throw e10;
            }
            b bVar = this.f7626b;
            if (bVar == null) {
                throw new IPCException(19, "Default channel not initialized");
            }
            bVar.internalRecycle(lArr);
        }
    }

    @Override // com.stepos.deepbinder.client.channel.remote.a
    public final Reply internalSendCall(Call call) {
        Reply replyInternalSendCall;
        g.f(call, "call");
        a(call);
        try {
            HookedRemoteChannel hookedRemoteChannel = this.f7627c;
            if (hookedRemoteChannel == null || (replyInternalSendCall = hookedRemoteChannel.internalSendCall(call)) == null) {
                throw new IPCException(19, "Channel not initialized");
            }
            return replyInternalSendCall;
        } catch (IPCException e10) {
            if (e10.getErrorCode() != 19) {
                throw e10;
            }
            a(call);
            b bVar = this.f7626b;
            if (bVar != null) {
                return bVar.internalSendCall(call);
            }
            throw new IPCException(19, "Default channel not initialized");
        }
    }

    @Override // com.stepos.deepbinder.client.channel.remote.a
    public final void release() {
        IPCLog.INSTANCE.i("MixRemoteChannel", "release " + this.f7627c, new Object[0]);
        HookedRemoteChannel hookedRemoteChannel = this.f7627c;
        if (hookedRemoteChannel != null) {
            hookedRemoteChannel.release();
        }
        b bVar = this.f7626b;
        if (bVar != null) {
            bVar.release();
        }
        this.f7627c = null;
        this.f7626b = null;
    }
}
