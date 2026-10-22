package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.e6;
import com.bytedance.dr.OaidApi;
import com.bytedance.dr.aidl.a;

/* loaded from: classes.dex */
public class m extends b<com.bytedance.dr.aidl.a> {
    public IBinder c;

    public class a implements e6.b<com.bytedance.dr.aidl.a, String> {
        public a(m mVar) {
        }

        @Override // com.bytedance.bdtracker.e6.b
        public com.bytedance.dr.aidl.a a(IBinder iBinder) {
            return a.AbstractBinderC0002a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.e6.b
        public String a(com.bytedance.dr.aidl.a aVar) {
            com.bytedance.dr.aidl.a aVar2 = aVar;
            if (aVar2 == null) {
                return null;
            }
            return ((a.AbstractBinderC0002a.C0003a) aVar2).a();
        }
    }

    public m() {
        super("com.qiku.id");
        this.c = null;
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent("qiku.service.action.id");
        intent.setPackage("com.qiku.id");
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public e6.b<com.bytedance.dr.aidl.a, String> a() {
        return new a(this);
    }

    public boolean b() {
        try {
            IBinder iBinder = (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "qikuid");
            this.c = iBinder;
            if (iBinder != null) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    this.c.transact(2, parcelObtain, parcelObtain2, 0);
                    boolean z = parcelObtain2.readInt() == 1;
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    return z;
                } catch (Throwable unused) {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            }
            return false;
        } catch (Throwable unused2) {
            LoggerImpl.global().debug("Oaid#Qiku360OaidImpl isOld360OSSupport error", new Object[0]);
            return false;
        }
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "qiku360";
    }

    @Override // com.bytedance.dr.impl.b, com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
        String string;
        if (super.support(context)) {
            return super.getOaid(context);
        }
        OaidApi.a aVar = null;
        if (this.c != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                this.c.transact(4, parcelObtain, parcelObtain2, 0);
                string = parcelObtain2.readString();
                parcelObtain.recycle();
                parcelObtain2.recycle();
            } catch (Throwable unused) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        } else {
            string = null;
        }
        if (!TextUtils.isEmpty(string)) {
            aVar = new OaidApi.a();
            aVar.a = string;
        }
        if (this.c != null) {
            Parcel parcelObtain3 = Parcel.obtain();
            Parcel parcelObtain4 = Parcel.obtain();
            try {
                this.c.transact(7, parcelObtain3, parcelObtain4, 0);
            } catch (Throwable unused2) {
            }
            parcelObtain3.recycle();
            parcelObtain4.recycle();
        }
        return aVar;
    }

    @Override // com.bytedance.dr.impl.b, com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        boolean zSupport = super.support(context);
        LoggerImpl.global().debug("Oaid#Qiku360OaidImpl super.support " + zSupport, new Object[0]);
        if (zSupport) {
            return zSupport;
        }
        boolean zB = b();
        LoggerImpl.global().debug("Oaid#Qiku360OaidImpl isOld360OSSupport " + zB, new Object[0]);
        return zB;
    }
}
