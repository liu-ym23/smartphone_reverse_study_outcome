package com.stepos.deepbinder.client.proxy;

import Y8.t;
import android.app.ActivityThread;
import android.content.IContentProvider;
import android.os.IBinder;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.deepbinder.core.api.IRemoteService;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.log.IPCLog;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/deepbinder/client/proxy/RemoteServiceProxy;", "Lcom/stepos/deepbinder/core/api/IRemoteService;", "Landroid/content/IContentProvider;", "contentProvider", "<init>", "(Landroid/content/IContentProvider;)V", "Landroid/os/IBinder;", "asBinder", "()Landroid/os/IBinder;", "LY8/t;", Constants.METHOD_CONNECT, "()V", "disconnect", "", "isRemote", "()Z", "", "pid", "", "timestamps", "recycle", "(I[J)V", "Lcom/stepos/deepbinder/core/entity/Call;", "call", "Lcom/stepos/deepbinder/core/entity/Reply;", "sendCall", "(Lcom/stepos/deepbinder/core/entity/Call;)Lcom/stepos/deepbinder/core/entity/Reply;", "Landroid/content/IContentProvider;", "Companion", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RemoteServiceProxy implements IRemoteService {
    private static final String CLASS_DEEPBINDERPROVIDER = "com.stepos.deepbinder.service.core.provider.DeepBinderProvider";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "RemoteServiceProxy";
    private static IRemoteService localRemoteService;
    private final IContentProvider contentProvider;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/deepbinder/client/proxy/RemoteServiceProxy$Companion;", "", "<init>", "()V", "TAG", "", "CLASS_DEEPBINDERPROVIDER", "localRemoteService", "Lcom/stepos/deepbinder/core/api/IRemoteService;", "getProxy", Const.JSON_KEY_PROVIDER, "Landroid/content/IContentProvider;", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final IRemoteService getProxy(IContentProvider provider) {
            p.i(provider, "provider");
            if (provider.asBinder().queryLocalInterface(Constants.DEFAULT_CONTENT_DESCRIPTOR) == null) {
                return new RemoteServiceProxy(provider);
            }
            if (RemoteServiceProxy.localRemoteService == null) {
                synchronized (RemoteServiceProxy.class) {
                    try {
                        if (RemoteServiceProxy.localRemoteService == null) {
                            try {
                                Object objNewInstance = Class.forName(RemoteServiceProxy.CLASS_DEEPBINDERPROVIDER).newInstance();
                                p.g(objNewInstance, "null cannot be cast to non-null type com.stepos.deepbinder.core.api.IRemoteService");
                                RemoteServiceProxy.localRemoteService = (IRemoteService) objNewInstance;
                            } catch (Exception e10) {
                                throw new RuntimeException(e10);
                            }
                        }
                        t tVar = t.f7040a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            IRemoteService iRemoteService = RemoteServiceProxy.localRemoteService;
            p.f(iRemoteService);
            return iRemoteService;
        }

        private Companion() {
        }
    }

    public RemoteServiceProxy(IContentProvider contentProvider) {
        p.i(contentProvider, "contentProvider");
        this.contentProvider = contentProvider;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        IBinder iBinderAsBinder = this.contentProvider.asBinder();
        p.h(iBinderAsBinder, "asBinder(...)");
        return iBinderAsBinder;
    }

    @Override // com.stepos.deepbinder.core.api.IRemoteService
    public void connect() {
        Parcel parcelObtain = Parcel.obtain();
        p.h(parcelObtain, "obtain(...)");
        try {
            this.contentProvider.asBinder().transact(2, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.deepbinder.core.api.IRemoteService
    public void disconnect() {
        try {
            IPCLog.INSTANCE.e(TAG, "disconnect " + this.contentProvider, new Object[0]);
            ActivityThread.currentActivityThread().releaseProvider(this.contentProvider, false);
        } catch (Exception e10) {
            IPCLog.INSTANCE.w(TAG, "[disconnect] exception: " + e10, new Object[0]);
        }
    }

    @Override // com.stepos.deepbinder.core.api.IRemoteService
    public boolean isRemote() {
        return this.contentProvider.asBinder().queryLocalInterface(Constants.DEFAULT_CONTENT_DESCRIPTOR) == null;
    }

    @Override // com.stepos.deepbinder.core.api.IService
    public void recycle(int pid, long[] timestamps) {
        p.i(timestamps, "timestamps");
        Parcel parcelObtain = Parcel.obtain();
        p.h(parcelObtain, "obtain(...)");
        try {
            parcelObtain.writeLongArray(timestamps);
            parcelObtain.writeInt(pid);
            this.contentProvider.asBinder().transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.deepbinder.core.api.IRemoteService
    public Reply sendCall(Call call) {
        Reply replyCreateFromParcel;
        p.i(call, "call");
        Parcel parcelObtain = Parcel.obtain();
        p.h(parcelObtain, "obtain(...)");
        Parcel parcelObtain2 = Parcel.obtain();
        p.h(parcelObtain2, "obtain(...)");
        try {
            call.writeToParcel(parcelObtain, 0);
            this.contentProvider.asBinder().transact(0, parcelObtain, parcelObtain2, (call.getMethodWrapper().getIsOneway() && call.getMethodWrapper().getIsVoid()) ? 1 : 0);
            if (parcelObtain2.dataSize() == 0) {
                replyCreateFromParcel = Reply.INSTANCE.obtain();
                replyCreateFromParcel.setResult(null);
            } else {
                replyCreateFromParcel = Reply.INSTANCE.createFromParcel(parcelObtain2);
            }
            parcelObtain.recycle();
            parcelObtain2.recycle();
            return replyCreateFromParcel;
        } catch (Throwable th) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            throw th;
        }
    }
}
