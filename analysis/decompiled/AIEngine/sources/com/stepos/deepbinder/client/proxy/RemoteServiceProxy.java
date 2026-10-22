package com.stepos.deepbinder.client.proxy;

import android.app.ActivityThread;
import android.content.IContentProvider;
import android.os.IBinder;
import android.os.Parcel;
import com.stepos.deepbinder.core.api.IRemoteService;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.log.IPCLog;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public final class RemoteServiceProxy implements IRemoteService {
    private static final String CLASS_DEEPBINDERPROVIDER = "com.stepos.deepbinder.service.core.provider.DeepBinderProvider";
    public static final a Companion = new a();
    private static final String TAG = "RemoteServiceProxy";
    private static IRemoteService localRemoteService;
    private final IContentProvider contentProvider;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    public RemoteServiceProxy(IContentProvider contentProvider) {
        g.f(contentProvider, "contentProvider");
        this.contentProvider = contentProvider;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        IBinder iBinderAsBinder = this.contentProvider.asBinder();
        g.e(iBinderAsBinder, "asBinder(...)");
        return iBinderAsBinder;
    }

    @Override // com.stepos.deepbinder.core.api.IRemoteService
    public void connect() {
        Parcel parcelObtain = Parcel.obtain();
        g.e(parcelObtain, "obtain(...)");
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
        return this.contentProvider.asBinder().queryLocalInterface("android.content.IContentProvider") == null;
    }

    @Override // com.stepos.deepbinder.core.api.IService
    public void recycle(int i10, long[] timestamps) {
        g.f(timestamps, "timestamps");
        Parcel parcelObtain = Parcel.obtain();
        g.e(parcelObtain, "obtain(...)");
        try {
            parcelObtain.writeLongArray(timestamps);
            parcelObtain.writeInt(i10);
            this.contentProvider.asBinder().transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.deepbinder.core.api.IRemoteService
    public Reply sendCall(Call call) {
        Reply replyCreateFromParcel;
        g.f(call, "call");
        Parcel parcelObtain = Parcel.obtain();
        g.e(parcelObtain, "obtain(...)");
        Parcel parcelObtain2 = Parcel.obtain();
        g.e(parcelObtain2, "obtain(...)");
        try {
            call.writeToParcel(parcelObtain, 0);
            this.contentProvider.asBinder().transact(0, parcelObtain, parcelObtain2, (call.getMethodWrapper().isOneway() && call.getMethodWrapper().isVoid()) ? 1 : 0);
            if (parcelObtain2.dataSize() == 0) {
                replyCreateFromParcel = Reply.CREATOR.obtain();
                replyCreateFromParcel.setResult(null);
            } else {
                replyCreateFromParcel = Reply.CREATOR.createFromParcel(parcelObtain2);
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
