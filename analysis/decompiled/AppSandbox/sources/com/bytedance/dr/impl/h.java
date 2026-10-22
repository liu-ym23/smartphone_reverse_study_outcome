package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.bdtracker.e6;
import com.bytedance.dr.aidl.d;

/* loaded from: classes.dex */
public final class h extends b<com.bytedance.dr.aidl.d> {

    public class a implements e6.b<com.bytedance.dr.aidl.d, String> {
        public a(h hVar) {
        }

        @Override // com.bytedance.bdtracker.e6.b
        public com.bytedance.dr.aidl.d a(IBinder iBinder) {
            return d.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.e6.b
        public String a(com.bytedance.dr.aidl.d dVar) {
            com.bytedance.dr.aidl.d dVar2 = dVar;
            if (dVar2 == null) {
                return null;
            }
            d.a.C0006a c0006a = (d.a.C0006a) dVar2;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                c0006a.a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public h() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public e6.b<com.bytedance.dr.aidl.d, String> a() {
        return new a(this);
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Lenovo";
    }
}
