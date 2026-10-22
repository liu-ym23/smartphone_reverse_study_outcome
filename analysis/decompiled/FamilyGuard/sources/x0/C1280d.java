package x0;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: x0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1280d {

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f23759b;

    /* renamed from: c, reason: collision with root package name */
    private C1279c f23760c;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f23758a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    private int f23761d = 0;

    private boolean b() {
        return this.f23760c.f23746b != 0;
    }

    private int d() {
        try {
            return this.f23759b.get() & 255;
        } catch (Exception unused) {
            this.f23760c.f23746b = 1;
            return 0;
        }
    }

    private void e() {
        this.f23760c.f23748d.f23734a = n();
        this.f23760c.f23748d.f23735b = n();
        this.f23760c.f23748d.f23736c = n();
        this.f23760c.f23748d.f23737d = n();
        int iD = d();
        boolean z5 = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        C1278b c1278b = this.f23760c.f23748d;
        c1278b.f23738e = (iD & 64) != 0;
        if (z5) {
            c1278b.f23744k = g(iPow);
        } else {
            c1278b.f23744k = null;
        }
        this.f23760c.f23748d.f23743j = this.f23759b.position();
        r();
        if (b()) {
            return;
        }
        C1279c c1279c = this.f23760c;
        c1279c.f23747c++;
        c1279c.f23749e.add(c1279c.f23748d);
    }

    private void f() {
        int iD = d();
        this.f23761d = iD;
        if (iD <= 0) {
            return;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            try {
                i6 = this.f23761d;
                if (i5 >= i6) {
                    return;
                }
                i6 -= i5;
                this.f23759b.get(this.f23758a, i5, i6);
                i5 += i6;
            } catch (Exception e6) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i5 + " count: " + i6 + " blockSize: " + this.f23761d, e6);
                }
                this.f23760c.f23746b = 1;
                return;
            }
        }
    }

    private int[] g(int i5) {
        byte[] bArr = new byte[i5 * 3];
        int[] iArr = null;
        try {
            this.f23759b.get(bArr);
            iArr = new int[256];
            int i6 = 0;
            int i7 = 0;
            while (i6 < i5) {
                int i8 = bArr[i7] & 255;
                int i9 = i7 + 2;
                int i10 = bArr[i7 + 1] & 255;
                i7 += 3;
                int i11 = i6 + 1;
                iArr[i6] = (i10 << 8) | (i8 << 16) | (-16777216) | (bArr[i9] & 255);
                i6 = i11;
            }
            return iArr;
        } catch (BufferUnderflowException e6) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e6);
            }
            this.f23760c.f23746b = 1;
            return iArr;
        }
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i5) {
        boolean z5 = false;
        while (!z5 && !b() && this.f23760c.f23747c <= i5) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 == 1) {
                    q();
                } else if (iD2 == 249) {
                    this.f23760c.f23748d = new C1278b();
                    j();
                } else if (iD2 == 254) {
                    q();
                } else if (iD2 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i6 = 0; i6 < 11; i6++) {
                        sb.append((char) this.f23758a[i6]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (iD == 44) {
                C1279c c1279c = this.f23760c;
                if (c1279c.f23748d == null) {
                    c1279c.f23748d = new C1278b();
                }
                e();
            } else if (iD != 59) {
                this.f23760c.f23746b = 1;
            } else {
                z5 = true;
            }
        }
    }

    private void j() {
        d();
        int iD = d();
        C1278b c1278b = this.f23760c.f23748d;
        int i5 = (iD & 28) >> 2;
        c1278b.f23740g = i5;
        if (i5 == 0) {
            c1278b.f23740g = 1;
        }
        c1278b.f23739f = (iD & 1) != 0;
        int iN = n();
        if (iN < 2) {
            iN = 10;
        }
        C1278b c1278b2 = this.f23760c.f23748d;
        c1278b2.f23742i = iN * 10;
        c1278b2.f23741h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < 6; i5++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f23760c.f23746b = 1;
            return;
        }
        l();
        if (!this.f23760c.f23752h || b()) {
            return;
        }
        C1279c c1279c = this.f23760c;
        c1279c.f23745a = g(c1279c.f23753i);
        C1279c c1279c2 = this.f23760c;
        c1279c2.f23756l = c1279c2.f23745a[c1279c2.f23754j];
    }

    private void l() {
        this.f23760c.f23750f = n();
        this.f23760c.f23751g = n();
        int iD = d();
        C1279c c1279c = this.f23760c;
        c1279c.f23752h = (iD & 128) != 0;
        c1279c.f23753i = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.f23760c.f23754j = d();
        this.f23760c.f23755k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.f23758a;
            if (bArr[0] == 1) {
                this.f23760c.f23757m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f23761d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.f23759b.getShort();
    }

    private void o() {
        this.f23759b = null;
        Arrays.fill(this.f23758a, (byte) 0);
        this.f23760c = new C1279c();
        this.f23761d = 0;
    }

    private void q() {
        int iD;
        do {
            iD = d();
            this.f23759b.position(Math.min(this.f23759b.position() + iD, this.f23759b.limit()));
        } while (iD > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f23759b = null;
        this.f23760c = null;
    }

    public C1279c c() {
        if (this.f23759b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f23760c;
        }
        k();
        if (!b()) {
            h();
            C1279c c1279c = this.f23760c;
            if (c1279c.f23747c < 0) {
                c1279c.f23746b = 1;
            }
        }
        return this.f23760c;
    }

    public C1280d p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f23759b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f23759b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
