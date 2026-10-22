package M9;

import D7.N;
import android.opengl.GLES20;
import java.io.IOException;
import java.util.ArrayList;
import okio.ByteString;

/* renamed from: M9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0248b {

    /* renamed from: a, reason: collision with root package name */
    public int f977a;
    public int b;
    public int c;
    public int d;
    public final Object e;
    public final Object f;
    public Object g;

    public C0248b() {
        this.f = N.R(new float[8]);
        this.g = new float[8];
        int iX = N.x("attribute vec4 aPos;\nattribute vec2 aTex;\nvarying vec2 vTex;\nvoid main() {\n    gl_Position = aPos;\n    vTex = aTex;\n}", "precision mediump float;\nvarying vec2 vTex;\nuniform sampler2D sTex;\nvoid main() {\n    gl_FragColor = texture2D(sTex, vTex);\n}");
        this.f977a = iX;
        this.b = GLES20.glGetAttribLocation(iX, "aPos");
        this.c = GLES20.glGetAttribLocation(iX, "aTex");
        this.d = GLES20.glGetUniformLocation(iX, "sTex");
        this.e = N.R(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public int a(int i) {
        int i6;
        int i10 = 0;
        if (i > 0) {
            int length = ((C0247a[]) this.g).length;
            while (true) {
                length--;
                i6 = this.b;
                if (length < i6 || i <= 0) {
                    break;
                }
                C0247a c0247a = ((C0247a[]) this.g)[length];
                kotlin.jvm.internal.k.c(c0247a);
                int i11 = c0247a.c;
                i -= i11;
                this.d -= i11;
                this.c--;
                i10++;
            }
            C0247a[] c0247aArr = (C0247a[]) this.g;
            System.arraycopy(c0247aArr, i6 + 1, c0247aArr, i6 + 1 + i10, this.c);
            this.b += i10;
        }
        return i10;
    }

    public ByteString b(int i) throws IOException {
        if (i >= 0) {
            C0247a[] c0247aArr = d.f979a;
            if (i <= c0247aArr.length - 1) {
                return c0247aArr[i].f976a;
            }
        }
        int length = this.b + 1 + (i - d.f979a.length);
        if (length >= 0) {
            C0247a[] c0247aArr2 = (C0247a[]) this.g;
            if (length < c0247aArr2.length) {
                C0247a c0247a = c0247aArr2[length];
                kotlin.jvm.internal.k.c(c0247a);
                return c0247a.f976a;
            }
        }
        throw new IOException("Header index too large " + (i + 1));
    }

    public void c(C0247a c0247a) {
        ((ArrayList) this.e).add(c0247a);
        int i = c0247a.c;
        int i6 = this.f977a;
        if (i > i6) {
            C0247a[] c0247aArr = (C0247a[]) this.g;
            D7.q.f0(null, 0, c0247aArr, c0247aArr.length);
            this.b = ((C0247a[]) this.g).length - 1;
            this.c = 0;
            this.d = 0;
            return;
        }
        a((this.d + i) - i6);
        int i10 = this.c + 1;
        C0247a[] c0247aArr2 = (C0247a[]) this.g;
        if (i10 > c0247aArr2.length) {
            C0247a[] c0247aArr3 = new C0247a[c0247aArr2.length * 2];
            System.arraycopy(c0247aArr2, 0, c0247aArr3, c0247aArr2.length, c0247aArr2.length);
            this.b = ((C0247a[]) this.g).length - 1;
            this.g = c0247aArr3;
        }
        int i11 = this.b;
        this.b = i11 - 1;
        ((C0247a[]) this.g)[i11] = c0247a;
        this.c++;
        this.d += i;
    }

    public ByteString d() {
        V9.r source = (V9.r) this.f;
        byte b = source.readByte();
        byte[] bArr = G9.b.f704a;
        int i = b & 255;
        int i6 = 0;
        boolean z10 = (b & 128) == 128;
        long jE = e(i, 127);
        if (!z10) {
            return source.v(jE);
        }
        V9.g gVar = new V9.g();
        int[] iArr = z.f1002a;
        kotlin.jvm.internal.k.f(source, "source");
        y yVar = z.c;
        y yVar2 = yVar;
        int i10 = 0;
        for (long j5 = 0; j5 < jE; j5++) {
            byte b5 = source.readByte();
            byte[] bArr2 = G9.b.f704a;
            i6 = (i6 << 8) | (b5 & 255);
            i10 += 8;
            while (i10 >= 8) {
                y[] yVarArr = (y[]) yVar2.d;
                kotlin.jvm.internal.k.c(yVarArr);
                yVar2 = yVarArr[(i6 >>> (i10 - 8)) & 255];
                kotlin.jvm.internal.k.c(yVar2);
                if (((y[]) yVar2.d) == null) {
                    gVar.L(yVar2.b);
                    i10 -= yVar2.c;
                    yVar2 = yVar;
                } else {
                    i10 -= 8;
                }
            }
        }
        while (i10 > 0) {
            y[] yVarArr2 = (y[]) yVar2.d;
            kotlin.jvm.internal.k.c(yVarArr2);
            y yVar3 = yVarArr2[(i6 << (8 - i10)) & 255];
            kotlin.jvm.internal.k.c(yVar3);
            int i11 = yVar3.c;
            if (((y[]) yVar3.d) != null || i11 > i10) {
                break;
            }
            gVar.L(yVar3.b);
            i10 -= i11;
            yVar2 = yVar;
        }
        return gVar.v(gVar.b);
    }

    public int e(int i, int i6) {
        int i10 = i & i6;
        if (i10 < i6) {
            return i10;
        }
        int i11 = 0;
        while (true) {
            byte b = ((V9.r) this.f).readByte();
            byte[] bArr = G9.b.f704a;
            int i12 = b & 255;
            if ((b & 128) == 0) {
                return i6 + (i12 << i11);
            }
            i6 += (b & 127) << i11;
            i11 += 7;
        }
    }

    public C0248b(r rVar) {
        this.f977a = 4096;
        this.e = new ArrayList();
        this.f = new V9.r(rVar);
        this.g = new C0247a[8];
        this.b = 7;
    }
}
