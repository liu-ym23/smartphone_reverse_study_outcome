package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes28.dex */
public final class de {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f26556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f26557e;

    public final byte[] a() {
        byte[] r100 = new byte[0];
        ByteArrayOutputStream r101 = null;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L23
        bs.a(r102, this.f26555c);     // Catch: Throwable -> L21
        bs.a(r102, this.f26556d);     // Catch: Throwable -> L21
        bs.a(r102, this.f26554b);     // Catch: Throwable -> L21
        bs.a(r102, String.valueOf(bm.p(this.f26553a)));     // Catch: Throwable -> L21
        int r103 = (int) (System.currentTimeMillis() / 1000);
    L9:
        r102.write(new byte[]{(byte) ((r103 >> 24) & 255), (byte) ((r103 >> 16) & 255), (byte) ((r103 >> 8) & 255), (byte) (r103 & 255)});     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(this.f26557e) == false) goto L12;
        byte[] r104 = {0, 0};     // Catch: Throwable -> L21
    L16:
        r102.write(r104);     // Catch: Throwable -> L21
        r102.write(bs.a(this.f26557e));     // Catch: Throwable -> L21
        r100 = r102.toByteArray();     // Catch: Throwable -> L21
        r102.close();     // Catch: Throwable -> L19
    L41:
    L27:
        return r100;
    L12:
        byte[] r105 = bs.a(this.f26557e);     // Catch: Throwable -> L21
        if (r105 != null) goto L15;
        r104 = new byte[]{0, 0};     // Catch: Throwable -> L21
        goto L16
    L15:
        r104 = bs.a(r105.length);     // Catch: Throwable -> L21
    L7:
        r103 = 0;
    L21:
        th = th;
        r101 = r102;
    L35:
        cg.c(th, "se", "tds");     // Catch: Throwable -> L28
        if (r101 == null) goto L27;
        r101.close();     // Catch: Throwable -> L19
    L28:
        th = move-exception;
        if (r101 != null) goto L39;
    L34:
        throw th;
    L39:
        r101.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();
    L23:
        th = th;
    L19:
        th = move-exception;
        th.printStackTrace();
        goto L27
    }

    public final void a(String r100) throws bh {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r100.length() > 65536) goto L9;
        this.f26557e = r100;
        return;
    L9:
        throw new bh(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
    }

    public de(Context r100, String r101, String r102, String r103) throws bh {
        if (TextUtils.isEmpty(r103) == true) goto L9;
        if (r103.length() > 256) goto L9;
        this.f26553a = r100.getApplicationContext();
        this.f26555c = r101;
        this.f26556d = r102;
        this.f26554b = r103;
        return;
    L9:
        throw new bh(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
    }
}
