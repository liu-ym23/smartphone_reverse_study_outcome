package com.bytedance.dr.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.bdtracker.e6;
import com.bytedance.dr.aidl.e;

/* loaded from: classes.dex */
public final class a extends b<com.bytedance.dr.aidl.e> {

    /* renamed from: com.bytedance.dr.impl.a$a, reason: collision with other inner class name */
    public class C0012a implements e6.b<com.bytedance.dr.aidl.e, String> {
        public C0012a(a aVar) {
        }

        @Override // com.bytedance.bdtracker.e6.b
        public com.bytedance.dr.aidl.e a(IBinder iBinder) {
            return e.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.e6.b
        public String a(com.bytedance.dr.aidl.e eVar) {
            com.bytedance.dr.aidl.e eVar2 = eVar;
            if (eVar2 == null) {
                return null;
            }
            e.a.C0007a c0007a = (e.a.C0007a) eVar2;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                c0007a.a.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public a() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public e6.b<com.bytedance.dr.aidl.e, String> a() {
        return new C0012a(this);
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "ASUS";
    }
}
