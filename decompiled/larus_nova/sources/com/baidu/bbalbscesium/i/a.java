package com.baidu.bbalbscesium.i;

import java.util.Arrays;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f30127b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f30128c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    k[] f30129a;

    public a() {
        this.f30129a = new k[]{new l(8, 0), new m(0, 1), new m(1, 1), new l(7, 1)};
    }

    public byte[] a(byte[] r110) {
        j r100 = new j();
        byte[] r101 = d.a(r110, r110.length + ((this.f30129a.length + 1) * j.f30152e));
        d.a(r101, r100.b(), r110.length);
        int r102 = 0;
    L3:
        k[] r103 = this.f30129a;
        if (r102 >= r103.length) goto L7;
        k r104 = r103[r102];
        r102 = r102 + 1;
        int r105 = r110.length + (j.f30152e * r102);
        r100.a(r104.a(r101, 0, r105), r104.c(), r104.a(), r104.b());
        d.a(r101, r100.b(), r105);
        goto L3
    L7:
        return Arrays.copyOf(r100.b(), j.f30152e);
    }
}
