package com.bytedance.dr.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.e6;
import com.bytedance.bdtracker.k5;
import com.bytedance.bdtracker.w5;
import com.bytedance.dr.OaidApi;
import com.bytedance.dr.aidl.h;
import java.security.MessageDigest;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class l implements OaidApi {
    public final OaidApi a;
    public w5<Boolean> b = new a(this);

    public class a extends w5<Boolean> {
        public a(l lVar) {
        }

        @Override // com.bytedance.bdtracker.w5
        public Boolean a(Object[] objArr) {
            try {
                PackageInfo packageInfoA = k5.a((Context) objArr[0], "com.heytap.openid", 0);
                if (packageInfoA == null) {
                    LoggerImpl.global().warn("Oaid#OnePlusOaidImpl pi == null ", new Object[0]);
                    return false;
                }
                long longVersionCode = packageInfoA.getLongVersionCode();
                LoggerImpl.global().debug("Oaid#OnePlusOaidImpl versionCode -> " + longVersionCode, new Object[0]);
                return Boolean.valueOf(longVersionCode >= 1);
            } catch (Throwable th) {
                LoggerImpl.global().error(1, "Oaid#Get package:{} info failed", th, "com.heytap.openid");
                return false;
            }
        }
    }

    public class b implements e6.b<com.bytedance.dr.aidl.h, String> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ long b;

        public b(Context context, long j) {
            this.a = context;
            this.b = j;
        }

        @Override // com.bytedance.bdtracker.e6.b
        public com.bytedance.dr.aidl.h a(IBinder iBinder) {
            return h.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.e6.b
        public String a(com.bytedance.dr.aidl.h hVar) {
            com.bytedance.dr.aidl.h hVar2 = hVar;
            if (hVar2 == null) {
                return null;
            }
            String strA = l.this.a(this.a);
            LoggerImpl.global().debug(com.bytedance.bdtracker.a.a("Oaid#OnePlusOaidImpl fetchResult sign -> ", strA), new Object[0]);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            IAppLogLogger iAppLogLoggerGlobal = LoggerImpl.global();
            StringBuilder sbA = com.bytedance.bdtracker.a.a("Oaid#OnePlusOaidImpl fetchResult finish -> ");
            sbA.append(System.currentTimeMillis() - this.b);
            iAppLogLoggerGlobal.debug(sbA.toString(), new Object[0]);
            String packageName = this.a.getPackageName();
            h.a.C0009a c0009a = (h.a.C0009a) hVar2;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(packageName);
                parcelObtain.writeString(strA);
                parcelObtain.writeString("OUID");
                c0009a.a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public l(OaidApi oaidApi) {
        this.a = oaidApi;
    }

    public final String a(Context context) {
        PackageInfo packageInfoA;
        try {
            packageInfoA = k5.a(context, context.getPackageName(), 64);
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "getPackageInfo failed", th, new Object[0]);
        }
        Signature[] signatureArr = packageInfoA != null ? packageInfoA.signatures : null;
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArrDigest) {
                        sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3));
                    }
                    return sb.toString();
                }
            } catch (Throwable th2) {
                LoggerImpl.global().error(1, "Sign package info failed", th2, new Object[0]);
            }
        }
        return null;
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return (this.a == null || this.b.b(new Object[0]).booleanValue()) ? "OnePlus/Oppo" : this.a.getName();
    }

    @Override // com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
        if (this.a != null && !this.b.b(new Object[0]).booleanValue()) {
            return this.a.getOaid(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        long jCurrentTimeMillis = System.currentTimeMillis();
        LoggerImpl.global().debug("Oaid#OnePlusOaidImpl getOaid start -> ", new Object[0]);
        String str = (String) new e6(context, intent, new b(context, jCurrentTimeMillis)).a();
        OaidApi.a aVar = new OaidApi.a();
        aVar.a = str;
        return aVar;
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolB = this.b.b(context);
        LoggerImpl.global().debug("Oaid#OnePlusOaidImpl originSupport -> " + boolB, new Object[0]);
        if (this.a == null || boolB.booleanValue()) {
            return boolB.booleanValue();
        }
        IAppLogLogger iAppLogLoggerGlobal = LoggerImpl.global();
        StringBuilder sbA = com.bytedance.bdtracker.a.a("Oaid#OnePlusOaidImpl mCallback.support(context) -> ");
        sbA.append(this.a.support(context));
        iAppLogLoggerGlobal.debug(sbA.toString(), new Object[0]);
        return this.a.support(context);
    }
}
