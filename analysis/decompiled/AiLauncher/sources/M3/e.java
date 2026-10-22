package M3;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public Mode f4511a;

    /* renamed from: b, reason: collision with root package name */
    public ErrorCorrectionLevel f4512b;

    /* renamed from: c, reason: collision with root package name */
    public L3.a f4513c;

    /* renamed from: d, reason: collision with root package name */
    public int f4514d = -1;

    /* renamed from: e, reason: collision with root package name */
    public b f4515e;

    public static boolean b(int i10) {
        return i10 >= 0 && i10 < 8;
    }

    public b a() {
        return this.f4515e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f4512b = errorCorrectionLevel;
    }

    public void d(int i10) {
        this.f4514d = i10;
    }

    public void e(b bVar) {
        this.f4515e = bVar;
    }

    public void f(Mode mode) {
        this.f4511a = mode;
    }

    public void g(L3.a aVar) {
        this.f4513c = aVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.f4511a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.f4512b);
        sb2.append("\n version: ");
        sb2.append(this.f4513c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f4514d);
        if (this.f4515e == null) {
            sb2.append("\n matrix: null\n");
        } else {
            sb2.append("\n matrix:\n");
            sb2.append(this.f4515e);
        }
        sb2.append(">>\n");
        return sb2.toString();
    }
}
