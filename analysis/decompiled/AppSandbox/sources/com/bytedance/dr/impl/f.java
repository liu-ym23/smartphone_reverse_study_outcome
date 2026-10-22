package com.bytedance.dr.impl;

import android.os.IBinder;
import android.os.Parcel;
import android.util.Pair;
import com.bytedance.bdtracker.e6;
import com.bytedance.dr.aidl.j;

/* loaded from: classes.dex */
public class f implements e6.b<com.bytedance.dr.aidl.j, Pair<String, Boolean>> {
    public f(e eVar) {
    }

    @Override // com.bytedance.bdtracker.e6.b
    public com.bytedance.dr.aidl.j a(IBinder iBinder) {
        return j.a.a(iBinder);
    }

    @Override // com.bytedance.bdtracker.e6.b
    public Pair<String, Boolean> a(com.bytedance.dr.aidl.j jVar) {
        com.bytedance.dr.aidl.j jVar2 = jVar;
        if (jVar2 == null) {
            return null;
        }
        j.a.C0011a c0011a = (j.a.C0011a) jVar2;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            c0011a.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            parcelObtain = Parcel.obtain();
            parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                c0011a.a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                boolean z = parcelObtain2.readInt() != 0;
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return new Pair<>(string, Boolean.valueOf(z));
            } finally {
            }
        } finally {
        }
    }
}
