package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* renamed from: com.amap.api.col.jmsl.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1558h {

    /* renamed from: a, reason: collision with root package name */
    public Context f16644a;

    /* renamed from: b, reason: collision with root package name */
    public String f16645b;

    /* renamed from: c, reason: collision with root package name */
    public String f16646c;

    /* renamed from: d, reason: collision with root package name */
    public String f16647d;

    /* renamed from: e, reason: collision with root package name */
    public String f16648e;

    public C1558h(Context context, String str, String str2, String str3) throws g5 {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new g5("无效的参数 - IllegalArgumentException");
        }
        this.f16644a = context.getApplicationContext();
        this.f16646c = str;
        this.f16647d = str2;
        this.f16645b = str3;
    }

    public void a(String str) throws g5 {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new g5("无效的参数 - IllegalArgumentException");
        }
        this.f16648e = str;
    }

    public byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream;
        int iCurrentTimeMillis;
        byte[] bArrT;
        byte[] byteArray = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            C1604s2.h(byteArrayOutputStream, this.f16646c);
            C1604s2.h(byteArrayOutputStream, this.f16647d);
            C1604s2.h(byteArrayOutputStream, this.f16645b);
            C1604s2.h(byteArrayOutputStream, String.valueOf(S0.s(this.f16644a)));
            try {
                iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable unused) {
                iCurrentTimeMillis = 0;
            }
            byteArrayOutputStream.write(new byte[]{(byte) ((iCurrentTimeMillis >> 24) & 255), (byte) ((iCurrentTimeMillis >> 16) & 255), (byte) ((iCurrentTimeMillis >> 8) & 255), (byte) (iCurrentTimeMillis & 255)});
            byte[] bArrK = (TextUtils.isEmpty(this.f16648e) || (bArrT = C1604s2.t(this.f16648e)) == null) ? new byte[]{0, 0} : C1604s2.k(bArrT.length, 2);
            byteArrayOutputStream.write(bArrK);
            byteArrayOutputStream.write(C1604s2.t(this.f16648e));
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            try {
                C1541c2.b(th, "se", "tds");
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return byteArray;
            } catch (Throwable th4) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th4;
            }
        }
        return byteArray;
    }
}
