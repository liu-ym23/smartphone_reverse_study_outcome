package com.stepos.deepbinder.core.proxy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.api.IClientService;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.log.IPCLog;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/deepbinder/core/proxy/ClientServiceProxy;", "Landroid/os/Binder;", "Lcom/stepos/deepbinder/core/api/IClientService;", "Landroid/os/IBinder;", "remote", AppAgent.CONSTRUCT, "(Landroid/os/IBinder;)V", "asBinder", "()Landroid/os/IBinder;", "", Constants.PARAM_PID, "", "timestamps", "LC7/r;", "recycle", "(I[J)V", "Lcom/stepos/deepbinder/core/entity/Callback;", "callback", "Lcom/stepos/deepbinder/core/entity/Reply;", "sendCallback", "(Lcom/stepos/deepbinder/core/entity/Callback;)Lcom/stepos/deepbinder/core/entity/Reply;", "Landroid/os/IBinder;", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClientServiceProxy extends Binder implements IClientService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ClientServiceProxy";
    private static final int TRANSACTION_RECYCLE = 4;
    private static final int TRANSACTION_SEND_CALLBACK = 3;
    private final IBinder remote;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/deepbinder/core/proxy/ClientServiceProxy$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "TRANSACTION_SEND_CALLBACK", "", "TRANSACTION_RECYCLE", "getProxy", "Lcom/stepos/deepbinder/core/api/IClientService;", "binder", "Landroid/os/IBinder;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final IClientService getProxy(IBinder binder) {
            e eVar = null;
            if (binder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = binder.queryLocalInterface(Constants.INSTANCE.getCLIENT_SERVICE_DESCRIPTOR());
            return iInterfaceQueryLocalInterface instanceof IClientService ? (IClientService) iInterfaceQueryLocalInterface : new ClientServiceProxy(binder, eVar);
        }

        private Companion() {
        }
    }

    public /* synthetic */ ClientServiceProxy(IBinder iBinder, e eVar) {
        this(iBinder);
    }

    public static final IClientService getProxy(IBinder iBinder) {
        return INSTANCE.getProxy(iBinder);
    }

    @Override // android.os.IInterface
    @Keep
    public IBinder asBinder() {
        return this.remote;
    }

    @Override // com.stepos.deepbinder.core.api.IService
    public void recycle(int pid, long[] timestamps) {
        k.f(timestamps, "timestamps");
        if (!this.remote.isBinderAlive()) {
            IPCLog.INSTANCE.e(TAG, "recycle: remote binder is not alive", new Object[0]);
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        k.e(parcelObtain, "obtain(...)");
        try {
            parcelObtain.writeInt(pid);
            parcelObtain.writeLongArray(timestamps);
            this.remote.transact(4, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // com.stepos.deepbinder.core.api.IClientService
    public Reply sendCallback(Callback callback) {
        MethodWrapper methodWrapper;
        k.f(callback, "callback");
        int i = 0;
        if (!this.remote.isBinderAlive()) {
            IPCLog.INSTANCE.e(TAG, "sendCallback: remote binder is not alive", new Object[0]);
            return Reply.INSTANCE.obtain().withResult(null);
        }
        Parcel parcelObtain = Parcel.obtain();
        k.e(parcelObtain, "obtain(...)");
        Parcel parcelObtain2 = Parcel.obtain();
        k.e(parcelObtain2, "obtain(...)");
        try {
            callback.writeToParcel(parcelObtain, 0);
            if (callback.getIsOneway() && (methodWrapper = callback.getMethodWrapper()) != null && methodWrapper.getIsVoid()) {
                i = 1;
            }
            this.remote.transact(3, parcelObtain, parcelObtain2, i);
            Reply replyWithResult = parcelObtain2.dataSize() == 0 ? Reply.INSTANCE.obtain().withResult(null) : Reply.INSTANCE.createFromParcel(parcelObtain2);
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
