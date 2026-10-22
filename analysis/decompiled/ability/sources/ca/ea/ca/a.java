package ca.ea.ca;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: ca.ea.ca.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0138a extends Binder implements a {

        /* renamed from: ca.ea.ca.a$a$a, reason: collision with other inner class name */
        public static class C0139a implements a {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f2114a;

            public C0139a(IBinder iBinder) {
                this.f2114a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2114a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0139a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
