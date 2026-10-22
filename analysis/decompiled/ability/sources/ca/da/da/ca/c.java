package ca.da.da.ca;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* renamed from: ca.da.da.ca.c$a$a, reason: collision with other inner class name */
        public static class C0136a implements c {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f2112a;

            public C0136a(IBinder iBinder) {
                this.f2112a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2112a;
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0136a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }
    }
}
