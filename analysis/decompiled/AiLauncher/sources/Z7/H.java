package Z7;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class H extends G {

    /* renamed from: k, reason: collision with root package name */
    public static HashMap<String, byte[]> f7320k;

    /* renamed from: l, reason: collision with root package name */
    public static HashMap<String, HashMap<String, byte[]>> f7321l;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.bugly.proguard.g f7322i;

    /* renamed from: j, reason: collision with root package name */
    public int f7323j;

    public H() {
        com.tencent.bugly.proguard.g gVar = new com.tencent.bugly.proguard.g();
        this.f7322i = gVar;
        this.f7323j = 0;
        gVar.f31687a = (short) 2;
    }

    @Override // Z7.G, Z7.F
    public final <T> void b(String str, T t10) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, UnsupportedEncodingException {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is ".concat(str));
        }
        super.b(str, t10);
    }

    @Override // Z7.G
    public final void e() {
        super.e();
        this.f7322i.f31687a = (short) 3;
    }

    public final void g(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            K k10 = new K(bArr, (byte) 0);
            k10.f(this.f7315d);
            this.f7322i.a(k10);
            com.tencent.bugly.proguard.g gVar = this.f7322i;
            if (gVar.f31687a == 3) {
                K k11 = new K(gVar.f31693g);
                k11.f(this.f7315d);
                if (f7320k == null) {
                    HashMap<String, byte[]> map = new HashMap<>();
                    f7320k = map;
                    map.put("", new byte[0]);
                }
                this.f7317f = k11.j(f7320k, 0, false);
                return;
            }
            K k12 = new K(gVar.f31693g);
            k12.f(this.f7315d);
            if (f7321l == null) {
                f7321l = new HashMap<>();
                HashMap<String, byte[]> map2 = new HashMap<>();
                map2.put("", new byte[0]);
                f7321l.put("", map2);
            }
            this.f7312a = k12.j(f7321l, 0, false);
            this.f7313b = new HashMap<>();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    public final byte[] h() throws UnsupportedEncodingException {
        com.tencent.bugly.proguard.g gVar = this.f7322i;
        if (gVar.f31687a != 2) {
            if (gVar.f31691e == null) {
                gVar.f31691e = "";
            }
            if (gVar.f31692f == null) {
                gVar.f31692f = "";
            }
        } else {
            if (gVar.f31691e.equals("")) {
                throw new IllegalArgumentException("servantName can not is null");
            }
            if (this.f7322i.f31692f.equals("")) {
                throw new IllegalArgumentException("funcName can not is null");
            }
        }
        L l10 = new L(0);
        l10.a(this.f7315d);
        if (this.f7322i.f31687a == 2) {
            l10.l(this.f7312a, 0);
        } else {
            l10.l(this.f7317f, 0);
        }
        this.f7322i.f31693g = M.e(l10.f7332a);
        L l11 = new L(0);
        l11.a(this.f7315d);
        this.f7322i.d(l11);
        byte[] bArrE = M.e(l11.f7332a);
        int length = bArrE.length + 4;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length).put(bArrE).flip();
        return byteBufferAllocate.array();
    }

    public final void i(String str) {
        this.f7322i.f31691e = str;
    }

    public final void j() {
        this.f7322i.f31690d = 1;
    }

    public final void k(String str) {
        this.f7322i.f31692f = str;
    }
}
