package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes28.dex */
public class n8 extends p8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f27696c;

    @Override // com.amap.api.mapcore.util.p8
    public byte[] b(byte[] r100) {
        Context r101 = this.f27696c;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        byte[] r103 = new byte[0];
        x5.a(r102, "1.2.13.6");     // Catch: Throwable -> L7
        x5.a(r102, "Android");     // Catch: Throwable -> L7
        x5.a(r102, o5.b());     // Catch: Throwable -> L7
        x5.a(r102, o5.c());     // Catch: Throwable -> L7
        x5.a(r102, o5.s(r101));     // Catch: Throwable -> L7
        x5.a(r102, Build.MANUFACTURER);     // Catch: Throwable -> L7
        x5.a(r102, Build.MODEL);     // Catch: Throwable -> L7
        x5.a(r102, Build.DEVICE);     // Catch: Throwable -> L7
        x5.a(r102, "");     // Catch: Throwable -> L7
        x5.a(r102, l5.f(r101));     // Catch: Throwable -> L7
        x5.a(r102, l5.c(r101));     // Catch: Throwable -> L7
        x5.a(r102, l5.e(r101));     // Catch: Throwable -> L7
        r102.write(new byte[]{0});     // Catch: Throwable -> L7
        r103 = r102.toByteArray();     // Catch: Throwable -> L7
    L27:
        r102.close();     // Catch: Throwable -> L11
    L13:
        byte[] r104 = new byte[r103.length + r100.length];
        System.arraycopy(r103, 0, r104, 0, r103.length);
        System.arraycopy(r100, 0, r104, r103.length, r100.length);
        return r104;
    L11:
        th = move-exception;
        th.printStackTrace();
    L7:
        th = move-exception;
        t6.a(th, SRStrategy.KEY_SR_STRATEGY_MODE, "gh");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public n8(Context r100, p8 r101) {
        super(r101);
        this.f27696c = r100;
    }
}
