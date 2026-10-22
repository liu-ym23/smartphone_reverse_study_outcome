package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f31895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f31896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[][] f31897c;

    public v(int r100, t1 r101) {
        this.f31895a = r101;
        this.f31896b = r100;
        this.f31897c = new byte[11][];
    }

    public final d a() throws IOException {
        int r100 = this.f31895a.read();
        if (r100 != (-1)) goto L6;
        return null;
    L6:
        InputStream r101 = this.f31895a;
        boolean r102 = false;
        if ((r101 instanceof q1) == false) goto L9;
        q1 r103 = (q1) r101;
        r103.f31880f = false;
        r103.c();
    L9:
        int r104 = i.b(r100, this.f31895a);
        if ((r100 & 32) == 0) goto L12;
        r102 = true;
    L12:
        int r105 = i.a(this.f31896b, this.f31895a);
        if (r105 >= 0) goto L36;
        if (r102 == false) goto L35;
        v r106 = new v(this.f31896b, new q1(this.f31896b, this.f31895a));
        if ((r100 & 64) == 0) goto L20;
        return new z(r104, r106);
    L20:
        if ((r100 & 128) != 0) goto L22;
        if (r104 == 4) goto L33;
        if (r104 == 8) goto L71;
        if (r104 == 16) goto L70;
        if (r104 == 17) goto L69;
        StringBuilder r107 = com.baidu.mapauto.auth.b.a("unknown BER object encountered: 0x");
        r107.append(Integer.toHexString(r104));
        throw new g(r107.toString());
    L69:
        return new g0(r106);
    L70:
        return new e0(r106);
    L71:
        return new o0(r106);
    L33:
        return new c0(r106);
    L22:
        return new i0(true, r104, r106);
    L35:
        throw new IOException("indefinite-length primitive encoding encountered");
    L36:
        o1 r108 = new o1(r105, this.f31895a);
        if ((r100 & 64) == 0) goto L41;
        return new k0(r102, r104, r108.c());
    L41:
        if ((r100 & 128) != 0) goto L43;
        if (r102 == false) goto L59;
        if (r104 == 4) goto L58;
        if (r104 == 8) goto L56;
        if (r104 == 16) goto L54;
        if (r104 != 17) goto L52;
        return new c1(new v(u1.a(r108), r108));
    L52:
        throw new IOException("unknown tag " + r104 + " encountered");
    L54:
        return new a1(new v(u1.a(r108), r108));
    L56:
        return new o0(new v(u1.a(r108), r108));
    L58:
        return new c0(new v(u1.a(r108), r108));
    L59:
        if (r104 == 4) goto L66;
        return i.a(r104, r108, this.f31897c);
    L62:
        e = move-exception;
        throw new g("corrupted stream detected", e);
    L66:
        return new w0(r108);
    L43:
        return new i0(r102, r104, new v(u1.a(r108), r108));
    }

    public final e b() throws IOException {
        e r100 = new e();
    L3:
        d r101 = a();
        if (r101 == null) goto L10;
        if ((r101 instanceof p1) == false) goto L8;
        r r102 = ((p1) r101).a();
    L9:
        r100.f31829a.addElement(r102);
        goto L3
    L8:
        r102 = r101.c();
        goto L9
    L10:
        return r100;
    }

    public final w a(boolean r100, int r101) throws IOException {
        if (r100 == false) goto L5;
        e r102 = b();
        if ((this.f31895a instanceof q1) == false) goto L18;
        if (r102.f31829a.size() == 1) goto L26;
        d0 r103 = a0.f31812a;
        if (r102.f31829a.size() < 1) goto L16;
        r103 = new d0(r102);
    L16:
        return new h0(false, r101, r103);
    L26:
        return new h0(true, r101, r102.a(0));
    L18:
        if (r102.f31829a.size() == 1) goto L27;
        d r104 = p0.f31871a;
        if (r102.f31829a.size() < 1) goto L25;
        r104 = new l1(r102);
    L25:
        return new e1(false, r101, r104);
    L27:
        return new e1(true, r101, r102.a(0));
    L5:
        return new e1(false, r101, new v0(((o1) this.f31895a).c()));
    }
}
