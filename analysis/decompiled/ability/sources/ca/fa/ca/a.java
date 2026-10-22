package ca.fa.ca;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: ca.fa.ca.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0140a extends Binder implements a {

        /* renamed from: ca.fa.ca.a$a$a, reason: collision with other inner class name */
        public static class C0141a implements a {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f2128a;

            public C0141a(IBinder iBinder) {
                this.f2128a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2128a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0141a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
