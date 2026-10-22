package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes28.dex */
public class h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f27404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f27405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f27406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f27407e;

    public byte[] a() {
        byte[] r100 = new byte[0];
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Throwable -> L21
        x5.a(r101, this.f27405c);     // Catch: Throwable -> L19
        x5.a(r101, this.f27406d);     // Catch: Throwable -> L19
        x5.a(r101, this.f27404b);     // Catch: Throwable -> L19
        x5.a(r101, String.valueOf(o5.h(this.f27403a)));     // Catch: Throwable -> L19
        int r102 = (int) (System.currentTimeMillis() / 1000);
    L9:
        r101.write(new byte[]{(byte) ((r102 >> 24) & 255), (byte) ((r102 >> 16) & 255), (byte) ((r102 >> 8) & 255), (byte) (r102 & 255)});     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(this.f27407e) == false) goto L12;
        byte[] r103 = {0, 0};     // Catch: Throwable -> L19
    L16:
        r101.write(r103);     // Catch: Throwable -> L19
        r101.write(x5.e(this.f27407e));     // Catch: Throwable -> L19
        r100 = r101.toByteArray();     // Catch: Throwable -> L19
        r101.close();     // Catch: Throwable -> L27
    L41:
    L29:
        return r100;
    L12:
        byte[] r104 = x5.e(this.f27407e);     // Catch: Throwable -> L19
        if (r104 != null) goto L15;
        r103 = new byte[]{0, 0};     // Catch: Throwable -> L19
        goto L16
    L15:
        r103 = x5.a(r104.length, 2);     // Catch: Throwable -> L19
    L7:
        r102 = 0;
    L19:
        th = th;
    L47:
        t6.a(th, "se", "tds");     // Catch: Throwable -> L30
        if (r101 == null) goto L29;
        r101.close();     // Catch: Throwable -> L27
    L30:
        th = move-exception;
        if (r101 != null) goto L37;
    L36:
        throw th;
    L37:
        r101.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();
    L27:
        th = move-exception;
        th.printStackTrace();
    L21:
        th = th;
        r101 = null;
        goto L47
    }

    public void a(String r100) throws k5 {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r100.length() > 65536) goto L9;
        this.f27407e = r100;
        return;
    L9:
        throw new k5(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
    }

    public h8(Context r100, String r101, String r102, String r103) throws k5 {
        if (TextUtils.isEmpty(r103) == true) goto L9;
        if (r103.length() > 256) goto L9;
        this.f27403a = r100.getApplicationContext();
        this.f27405c = r101;
        this.f27406d = r102;
        this.f27404b = r103;
        return;
    L9:
        throw new k5(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
    }
}
