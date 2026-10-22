package p9;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.stepos.deepbinder.core.api.IClientService;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.proxy.ClientServiceProxy;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: a, reason: collision with root package name */
    public final IClientService f11469a;

    public b(IBinder iBinder) {
        ClientServiceProxy.Companion.getClass();
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(q9.a.f11629a);
        this.f11469a = iInterfaceQueryLocalInterface instanceof IClientService ? (IClientService) iInterfaceQueryLocalInterface : new ClientServiceProxy(iBinder, null);
    }

    @Override // p9.a
    public final Reply a(Callback callback) {
        try {
            return this.f11469a.sendCallback(callback);
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

    @Override // o9.b
    public final void internalRecycle(Long[] lArr) {
        try {
            IClientService iClientService = this.f11469a;
            int length = lArr.length;
            long[] jArr = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                jArr[i10] = lArr[i10].longValue();
            }
            iClientService.recycle(-1, jArr);
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
}
