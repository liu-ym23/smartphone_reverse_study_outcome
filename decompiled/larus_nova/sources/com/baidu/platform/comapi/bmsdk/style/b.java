package com.baidu.platform.comapi.bmsdk.style;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f32855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f32856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f32857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f32858d;

    public b() {
        this.f32855a = new int[4];
    }

    public static b a(byte[] r100) {
        ByteBuffer r101 = ByteBuffer.wrap(r100).order(ByteOrder.nativeOrder());
        if (r101.get() != 0) goto L6;
        return null;
    L6:
        b r102 = new b();
        r102.f32856b = new int[r101.get()];
        r102.f32857c = new int[r101.get()];
        r102.f32858d = new int[r101.get()];
        a(r102.f32856b.length);
        a(r102.f32857c.length);
        r101.getInt();
        r101.getInt();
        r102.f32855a[0] = r101.getInt();
        r102.f32855a[1] = r101.getInt();
        r102.f32855a[2] = r101.getInt();
        r102.f32855a[3] = r101.getInt();
        r101.getInt();
        a(r102.f32856b, r101);
        a(r102.f32857c, r101);
        a(r102.f32858d, r101);
        return r102;
    }

    private static void a(int r100) {
        if (r100 == 0) goto L7;
        if ((r100 & 1) != 0) goto L7;
        return;
    L7:
        throw new RuntimeException("invalid nine-patch: " + r100);
    }

    private static void a(int[] r100, ByteBuffer r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100[r103] = r101.getInt();
        r103 = r103 + 1;
        goto L3
    }
}
