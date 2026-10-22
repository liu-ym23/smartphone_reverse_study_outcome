package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes28.dex */
public final class dl extends dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f26578a = 13;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f26579b = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f26580e;

    private static byte[] a(Context r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[0];
        bs.a(r101, "1.2." + f26578a + "." + f26579b);     // Catch: Throwable -> L8
        bs.a(r101, "Android");     // Catch: Throwable -> L8
        bs.a(r101, bm.t(r100));     // Catch: Throwable -> L8
        bs.a(r101, bm.m(r100));     // Catch: Throwable -> L8
        bs.a(r101, bm.h(r100));     // Catch: Throwable -> L8
        bs.a(r101, Build.MANUFACTURER);     // Catch: Throwable -> L8
        bs.a(r101, Build.MODEL);     // Catch: Throwable -> L8
        bs.a(r101, Build.DEVICE);     // Catch: Throwable -> L8
        bs.a(r101, bm.v(r100));     // Catch: Throwable -> L8
        bs.a(r101, bi.c(r100));     // Catch: Throwable -> L8
        bs.a(r101, bi.d(r100));     // Catch: Throwable -> L8
        bs.a(r101, bi.f(r100));     // Catch: Throwable -> L8
        r101.write(new byte[]{0});     // Catch: Throwable -> L8
        r102 = r101.toByteArray();     // Catch: Throwable -> L8
        r101.close();     // Catch: Throwable -> L6
    L20:
    L11:
        return r102;
    L6:
        th = move-exception;
        th.printStackTrace();
    L8:
        th = move-exception;
        cg.c(th, SRStrategy.KEY_SR_STRATEGY_MODE, "gh");     // Catch: Throwable -> L12
        r101.close();     // Catch: Throwable -> L6
    L12:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    @Override // com.amap.api.col.s.dn
    public final byte[] a(byte[] r100) {
        byte[] r101 = a(this.f26580e);
        byte[] r102 = new byte[r101.length + r100.length];
        System.arraycopy(r101, 0, r102, 0, r101.length);
        System.arraycopy(r100, 0, r102, r101.length, r100.length);
        return r102;
    }

    public dl(Context r100, dn r101) {
        super(r101);
        this.f26580e = r100;
    }
}
