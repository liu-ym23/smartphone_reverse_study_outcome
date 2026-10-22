package com.alipay.sdk.m.h;

import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public class a extends com.alipay.sdk.m.g.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f25318d = false;

    static {
        f25318d = true;
    }

    public static a c() {
        return a(com.alipay.sdk.m.g.a.f25307c, 0, new c(""), 0, new f());
    L5:
        return null;
    }

    public a(byte[] r100) {
        super(r100);
    }

    public static a a(String r110, long r111, b r112, short r210, e r211) throws Exception {
        byte[] r100 = com.alipay.sdk.m.g.c.a((byte) 1);
        boolean r101 = f25318d;
        if (r101 == false) goto L5;
    L9:
        byte[] r102 = com.alipay.sdk.m.g.c.a(r110.charAt(0), r110.charAt(1));
        if (r101 == false) goto L12;
    L16:
        byte[] r103 = com.alipay.sdk.m.g.c.a(r111);
        if (r101 == false) goto L19;
    L23:
        byte[] r113 = com.alipay.sdk.m.g.c.b();
        if (r101 == false) goto L26;
    L30:
        r112.a();
        byte[] r114 = com.alipay.sdk.m.g.c.a(r112.f25321a);
        if (r101 == false) goto L33;
    L37:
        byte[] r115 = com.alipay.sdk.m.g.c.a(r112.f25322b);
        if (r101 == false) goto L40;
    L44:
        byte[] r116 = (byte[]) r112.f25323c.clone();
        if (r101 == false) goto L47;
    L51:
        byte[] r104 = com.alipay.sdk.m.g.c.a(r210);
        if (r101 == false) goto L54;
    L58:
        byte[] r117 = com.alipay.sdk.m.g.c.b();
        if (r101 == false) goto L61;
    L65:
        r211.a();
        byte[] r118 = com.alipay.sdk.m.g.c.a(r211.f25325a);
        if (r101 == false) goto L68;
    L72:
        byte[] r105 = (byte[]) r211.f25326b.clone();
        if (r101 == false) goto L75;
    L79:
        byte[] r106 = com.alipay.sdk.m.g.c.c();
        if (r101 == true) goto L87;
        if (r106.length == 4) goto L87;
        throw new AssertionError();
    L87:
        return new a(com.alipay.sdk.m.g.c.a(new byte[][]{r100, r102, r103, r113, r114, r115, r116, r104, r117, r118, r105, r106}));
    L75:
        if (r105.length == (r211.f25325a & UByte.MAX_VALUE)) goto L79;
        throw new AssertionError();
    L68:
        if (r118.length == 1) goto L72;
        throw new AssertionError();
    L61:
        if (r117.length == 2) goto L65;
        throw new AssertionError();
    L54:
        if (r104.length == 2) goto L58;
        throw new AssertionError();
    L47:
        if (r116.length == (r112.f25322b & UByte.MAX_VALUE)) goto L51;
        throw new AssertionError();
    L40:
        if (r115.length == 1) goto L44;
        throw new AssertionError();
    L33:
        if (r114.length == 1) goto L37;
        throw new AssertionError();
    L26:
        if (r113.length == 2) goto L30;
        throw new AssertionError();
    L19:
        if (r103.length == 8) goto L23;
        throw new AssertionError();
    L12:
        if (r102.length == 2) goto L16;
        throw new AssertionError();
    L5:
        if (r100.length == 1) goto L9;
        throw new AssertionError();
    }
}
