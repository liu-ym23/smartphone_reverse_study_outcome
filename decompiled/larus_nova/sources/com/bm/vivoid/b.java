package com.bm.vivoid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes39.dex */
public abstract class b extends Binder implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f33678a = 0;

    public b() {
        attachInterface(this, "com.bm.vivoid.ITransfer");
    }

    public static c a(IBinder r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IInterface r101 = r100.queryLocalInterface("com.bm.vivoid.ITransfer");
        if (r101 == null) goto L12;
        if ((r101 instanceof c) == false) goto L12;
        return (c) r101;
    L12:
        return new a(r100);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
        if (r100 != 1) goto L5;
        r101.enforceInterface("com.bm.vivoid.ITransfer");
        boolean r104 = a(r101.readStrongBinder(), r101.readStrongBinder());
        r102.writeNoException();
        r102.writeInt(r104 ? 1 : 0);
        return true;
    L5:
        if (r100 != 1598968902) goto L7;
        r102.writeString("com.bm.vivoid.ITransfer");
        return true;
    L7:
        return super.onTransact(r100, r101, r102, r103);
    }
}
