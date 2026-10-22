package com.baidu.b.a;

import java.util.Arrays;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    g[] f4708a = {new h(8, 0), new j(0, 1), new j(1, 1), new h(7, 1)};

    public byte[] a(byte[] bArr) {
        f fVar = new f();
        byte[] bArrA = c.a(bArr, ((this.f4708a.length + 1) * f.f4714a) + bArr.length);
        c.a(bArrA, fVar.a(), bArr.length);
        int i4 = 0;
        while (true) {
            g[] gVarArr = this.f4708a;
            if (i4 >= gVarArr.length) {
                return Arrays.copyOf(fVar.a(), f.f4714a);
            }
            g gVar = gVarArr[i4];
            i4++;
            int length = (f.f4714a * i4) + bArr.length;
            fVar.a(gVar.a(bArrA, 0, length), gVar.a(), gVar.b(), gVar.c());
            c.a(bArrA, fVar.a(), length);
        }
    }
}
