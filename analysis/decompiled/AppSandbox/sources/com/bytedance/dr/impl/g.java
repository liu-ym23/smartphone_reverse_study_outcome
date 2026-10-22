package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.e6;
import com.bytedance.dr.OaidApi;
import com.bytedance.dr.aidl.g;

/* loaded from: classes.dex */
public class g extends b<com.bytedance.dr.aidl.g> {
    public final com.bytedance.dr.honor.a c;
    public final com.bytedance.dr.honor.b d;

    public class a implements e6.b<com.bytedance.dr.aidl.g, String> {
        public a() {
        }

        @Override // com.bytedance.bdtracker.e6.b
        public com.bytedance.dr.aidl.g a(IBinder iBinder) {
            return g.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.e6.b
        public String a(com.bytedance.dr.aidl.g gVar) {
            com.bytedance.dr.aidl.g gVar2 = gVar;
            if (gVar2 == null) {
                LoggerImpl.global().error("honor# service is null", new Object[0]);
                return null;
            }
            com.bytedance.dr.honor.a aVar = g.this.c;
            g.a.C0008a c0008a = (g.a.C0008a) gVar2;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                c0008a.a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                com.bytedance.dr.honor.b bVar = g.this.d;
                parcelObtain = Parcel.obtain();
                parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    c0008a.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return "";
                } finally {
                }
            } finally {
            }
        }
    }

    public g() {
        super("com.hihonor.id");
        this.c = new com.bytedance.dr.honor.a();
        this.d = new com.bytedance.dr.honor.b();
    }

    @Override // com.bytedance.dr.impl.b
    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.bytedance.dr.impl.b
    public e6.b<com.bytedance.dr.aidl.g, String> a() {
        return new a();
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "HONOR";
    }

    @Override // com.bytedance.dr.impl.b, com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
        new e6(context, a(context), a()).a();
        OaidApi.a aVar = new OaidApi.a();
        aVar.a = this.c.a;
        aVar.b = this.d.a;
        IAppLogLogger iAppLogLoggerGlobal = LoggerImpl.global();
        StringBuilder sbA = com.bytedance.bdtracker.a.a("getOaid ");
        sbA.append(aVar.a);
        iAppLogLoggerGlobal.debug("honor# ", sbA.toString());
        return aVar;
    }
}
