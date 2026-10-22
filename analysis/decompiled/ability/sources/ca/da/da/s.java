package ca.da.da;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public interface s extends IInterface {

    public static abstract class a extends Binder implements s {

        /* renamed from: ca.da.da.s$a$a, reason: collision with other inner class name */
        public static class C0137a implements s {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f2113a;

            public C0137a(IBinder iBinder) {
                this.f2113a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2113a;
            }
        }

        public static s a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof s)) ? new C0137a(iBinder) : (s) iInterfaceQueryLocalInterface;
        }
    }
}
