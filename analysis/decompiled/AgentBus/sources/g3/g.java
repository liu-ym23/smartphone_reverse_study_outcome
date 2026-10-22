package g3;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class g implements h {

    /* renamed from: c, reason: collision with root package name */
    public IBinder f3807c;

    @Override // g3.h
    public final void a(String[] strArr) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(h.f3808a);
            parcelObtain.writeStringArray(strArr);
            this.f3807c.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3807c;
    }
}
