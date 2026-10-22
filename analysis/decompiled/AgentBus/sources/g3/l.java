package g3;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.MultiInstanceInvalidationService;

/* loaded from: classes.dex */
public final class l extends Binder implements i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f3823c;

    public l(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f3823c = multiInstanceInvalidationService;
        attachInterface(this, i.f3809b);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // g3.i
    public final void b(h hVar, int i2) {
        q7.k.e(hVar, "callback");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f3823c;
        synchronized (multiInstanceInvalidationService.f1046h) {
            multiInstanceInvalidationService.f1046h.unregister(hVar);
        }
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i10) {
        String str = i.f3809b;
        if (i2 >= 1 && i2 <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i2 == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        h hVar = null;
        h hVar2 = null;
        if (i2 == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(h.f3808a);
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof h)) {
                    g gVar = new g();
                    gVar.f3807c = strongBinder;
                    hVar = gVar;
                } else {
                    hVar = (h) iInterfaceQueryLocalInterface;
                }
            }
            String string = parcel.readString();
            q7.k.e(hVar, "callback");
            int i11 = 0;
            if (string != null) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = this.f3823c;
                synchronized (multiInstanceInvalidationService.f1046h) {
                    try {
                        int i12 = multiInstanceInvalidationService.f1044f + 1;
                        multiInstanceInvalidationService.f1044f = i12;
                        if (multiInstanceInvalidationService.f1046h.register(hVar, Integer.valueOf(i12))) {
                            multiInstanceInvalidationService.f1045g.put(Integer.valueOf(i12), string);
                            i11 = i12;
                        } else {
                            multiInstanceInvalidationService.f1044f--;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            parcel2.writeNoException();
            parcel2.writeInt(i11);
            return true;
        }
        if (i2 == 2) {
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface(h.f3808a);
                if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof h)) {
                    g gVar2 = new g();
                    gVar2.f3807c = strongBinder2;
                    hVar2 = gVar2;
                } else {
                    hVar2 = (h) iInterfaceQueryLocalInterface2;
                }
            }
            b(hVar2, parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
        if (i2 != 3) {
            return super.onTransact(i2, parcel, parcel2, i10);
        }
        int i13 = parcel.readInt();
        String[] strArrCreateStringArray = parcel.createStringArray();
        q7.k.e(strArrCreateStringArray, "tables");
        MultiInstanceInvalidationService multiInstanceInvalidationService2 = this.f3823c;
        synchronized (multiInstanceInvalidationService2.f1046h) {
            String str2 = (String) multiInstanceInvalidationService2.f1045g.get(Integer.valueOf(i13));
            if (str2 == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
            } else {
                int iBeginBroadcast = multiInstanceInvalidationService2.f1046h.beginBroadcast();
                for (int i14 = 0; i14 < iBeginBroadcast; i14++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService2.f1046h.getBroadcastCookie(i14);
                        q7.k.c(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        Integer num = (Integer) broadcastCookie;
                        int iIntValue = num.intValue();
                        String str3 = (String) multiInstanceInvalidationService2.f1045g.get(num);
                        if (i13 != iIntValue && str2.equals(str3)) {
                            try {
                                ((h) multiInstanceInvalidationService2.f1046h.getBroadcastItem(i14)).a(strArrCreateStringArray);
                            } catch (RemoteException e10) {
                                Log.w("ROOM", "Error invoking a remote callback", e10);
                            }
                        }
                    } finally {
                        multiInstanceInvalidationService2.f1046h.finishBroadcast();
                    }
                }
            }
        }
        return true;
    }
}
