package G3;

import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import java.nio.charset.StandardCharsets;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f2783a;

    /* renamed from: b, reason: collision with root package name */
    public SymbolShapeHint f2784b;

    /* renamed from: c, reason: collision with root package name */
    public A3.a f2785c;

    /* renamed from: d, reason: collision with root package name */
    public A3.a f2786d;

    /* renamed from: e, reason: collision with root package name */
    public final StringBuilder f2787e;

    /* renamed from: f, reason: collision with root package name */
    public int f2788f;

    /* renamed from: g, reason: collision with root package name */
    public int f2789g;

    /* renamed from: h, reason: collision with root package name */
    public k f2790h;

    /* renamed from: i, reason: collision with root package name */
    public int f2791i;

    public h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb2 = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i10 = 0; i10 < length; i10++) {
            char c10 = (char) (bytes[i10] & 255);
            if (c10 == '?' && str.charAt(i10) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb2.append(c10);
        }
        this.f2783a = sb2.toString();
        this.f2784b = SymbolShapeHint.FORCE_NONE;
        this.f2787e = new StringBuilder(str.length());
        this.f2789g = -1;
    }

    public int a() {
        return this.f2787e.length();
    }

    public StringBuilder b() {
        return this.f2787e;
    }

    public char c() {
        return this.f2783a.charAt(this.f2788f);
    }

    public String d() {
        return this.f2783a;
    }

    public int e() {
        return this.f2789g;
    }

    public int f() {
        return h() - this.f2788f;
    }

    public k g() {
        return this.f2790h;
    }

    public final int h() {
        return this.f2783a.length() - this.f2791i;
    }

    public boolean i() {
        return this.f2788f < h();
    }

    public void j() {
        this.f2789g = -1;
    }

    public void k() {
        this.f2790h = null;
    }

    public void l(A3.a aVar, A3.a aVar2) {
        this.f2785c = aVar;
        this.f2786d = aVar2;
    }

    public void m(int i10) {
        this.f2791i = i10;
    }

    public void n(SymbolShapeHint symbolShapeHint) {
        this.f2784b = symbolShapeHint;
    }

    public void o(int i10) {
        this.f2789g = i10;
    }

    public void p() {
        q(a());
    }

    public void q(int i10) {
        k kVar = this.f2790h;
        if (kVar == null || i10 > kVar.a()) {
            this.f2790h = k.l(i10, this.f2784b, this.f2785c, this.f2786d, true);
        }
    }

    public void r(char c10) {
        this.f2787e.append(c10);
    }

    public void s(String str) {
        this.f2787e.append(str);
    }
}
