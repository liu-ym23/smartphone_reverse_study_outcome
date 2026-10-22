package com.stepos.deepbinder.core.proxy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.stepos.deepbinder.core.api.IClientService;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.log.IPCLog;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public final class ClientServiceProxy extends Binder implements IClientService {
    public static final a Companion = new a();
    private static final String TAG = "ClientServiceProxy";
    private static final int TRANSACTION_RECYCLE = 4;
    private static final int TRANSACTION_SEND_CALLBACK = 3;
    private final IBinder remote;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    public /* synthetic */ ClientServiceProxy(IBinder iBinder, e eVar) {
        this(iBinder);
    }

    public static final IClientService getProxy(IBinder iBinder) {
        Companion.getClass();
        e eVar = null;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(q9.a.f11629a);
        return iInterfaceQueryLocalInterface instanceof IClientService ? (IClientService) iInterfaceQueryLocalInterface : new ClientServiceProxy(iBinder, eVar);
    }

    @Override // android.os.IInterface
    @f.a
    public IBinder asBinder() {
        return this.remote;
    }

    @Override // com.stepos.deepbinder.core.api.IService
    public void recycle(int i10, long[] timestamps) {
        g.f(timestamps, "timestamps");
        if (!this.remote.isBinderAlive()) {
            IPCLog.INSTANCE.e(TAG, "recycle: remote binder is not alive", new Object[0]);
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        g.e(parcelObtain, "obtain(...)");
        try {
            parcelObtain.writeInt(i10);
            parcelObtain.writeLongArray(timestamps);
            this.remote.transact(4, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.deepbinder.core.api.IClientService
    public Reply sendCallback(Callback callback) {
        MethodWrapper methodWrapper;
        g.f(callback, "callback");
        int i10 = 0;
        if (!this.remote.isBinderAlive()) {
            IPCLog.INSTANCE.e(TAG, "sendCallback: remote binder is not alive", new Object[0]);
            return Reply.CREATOR.obtain().withResult(null);
        }
        Parcel parcelObtain = Parcel.obtain();
        g.e(parcelObtain, "obtain(...)");
        Parcel parcelObtain2 = Parcel.obtain();
        g.e(parcelObtain2, "obtain(...)");
        try {
            callback.writeToParcel(parcelObtain, 0);
            if (callback.isOneway() && (methodWrapper = callback.getMethodWrapper()) != null && methodWrapper.isVoid()) {
                i10 = 1;
            }
            this.remote.transact(3, parcelObtain, parcelObtain2, i10);
            Reply replyWithResult = parcelObtain2.dataSize() == 0 ? Reply.CREATOR.obtain().withResult(null) : Reply.CREATOR.createFromParcel(parcelObtain2);
            parcelObtain.recycle();
            parcelObtain2.recycle();
            return replyWithResult;
        } catch (Throwable th) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            throw th;
        }
    }

    private ClientServiceProxy(IBinder iBinder) {
        this.remote = iBinder;
    }
}
