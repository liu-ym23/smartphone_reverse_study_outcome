package ca.da.da.ca;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* renamed from: ca.da.da.ca.b$a$a, reason: collision with other inner class name */
        public static class C0135a implements b {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f2111a;

            public C0135a(IBinder iBinder) {
                this.f2111a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2111a;
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0135a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }
    }
}
