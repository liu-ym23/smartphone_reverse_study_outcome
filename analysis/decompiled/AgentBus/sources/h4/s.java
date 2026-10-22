package h4;

import android.graphics.Paint;
import android.graphics.Shader;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class s implements e4.a {

    /* renamed from: f, reason: collision with root package name */
    public int f4154f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f4155g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4156h;

    /* renamed from: i, reason: collision with root package name */
    public Object f4157i;

    public s(Paint paint) {
        this.f4155g = paint;
        this.f4154f = 3;
    }

    public int a() {
        Paint.Cap strokeCap = ((Paint) this.f4155g).getStrokeCap();
        int i2 = strokeCap == null ? -1 : u0.e.$EnumSwitchMapping$1[strokeCap.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 2;
        }
        return 1;
    }

    public int b() {
        Paint.Join strokeJoin = ((Paint) this.f4155g).getStrokeJoin();
        int i2 = strokeJoin == null ? -1 : u0.e.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 1;
        }
        return 2;
    }

    public void c(float f10) {
        ((Paint) this.f4155g).setAlpha((int) Math.rint(f10 * 255.0f));
    }

    public void d(int i2) {
        if (this.f4154f == i2) {
            return;
        }
        this.f4154f = i2;
        ((Paint) this.f4155g).setBlendMode(u0.z.m(i2));
    }

    public void e(long j2) {
        ((Paint) this.f4155g).setColor(u0.z.o(j2));
    }

    public void f(u0.i iVar) {
        this.f4157i = iVar;
        ((Paint) this.f4155g).setColorFilter(iVar != null ? iVar.f9908a : null);
    }

    public void g(Shader shader) {
        this.f4156h = shader;
        ((Paint) this.f4155g).setShader(shader);
    }

    public void h(int i2) {
        ((Paint) this.f4155g).setStrokeCap(i2 == 2 ? Paint.Cap.SQUARE : i2 == 1 ? Paint.Cap.ROUND : i2 == 0 ? Paint.Cap.BUTT : Paint.Cap.BUTT);
    }

    @Override // e4.a
    public byte[] i(int i2, byte[] bArr) throws IllegalStateException, InvalidAlgorithmParameterException {
        r rVar = (r) this.f4155g;
        if (i2 > this.f4154f) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ((Mac) rVar.get()).update(bArr);
        return Arrays.copyOf(((Mac) rVar.get()).doFinal(), i2);
    }

    public void j() {
        ((Paint) this.f4155g).setStrokeJoin(Paint.Join.MITER);
    }

    public void k(int i2) {
        ((Paint) this.f4155g).setStyle(i2 == 1 ? Paint.Style.STROKE : Paint.Style.FILL);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s(java.lang.String r4, javax.crypto.spec.SecretKeySpec r5) throws java.security.GeneralSecurityException {
        /*
            r3 = this;
            r3.<init>()
            h4.r r0 = new h4.r
            r0.<init>(r3)
            r3.f4155g = r0
            r1 = 2
            boolean r2 = m.x.b(r1)
            if (r2 == 0) goto L8f
            r3.f4156h = r4
            r3.f4157i = r5
            byte[] r5 = r5.getEncoded()
            int r5 = r5.length
            r2 = 16
            if (r5 < r2) goto L87
            int r5 = r4.hashCode()
            r2 = -1
            switch(r5) {
                case -1823053428: goto L52;
                case 392315023: goto L47;
                case 392315118: goto L3e;
                case 392316170: goto L33;
                case 392317873: goto L28;
                default: goto L26;
            }
        L26:
            r1 = r2
            goto L5c
        L28:
            java.lang.String r5 = "HMACSHA512"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L31
            goto L26
        L31:
            r1 = 4
            goto L5c
        L33:
            java.lang.String r5 = "HMACSHA384"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L3c
            goto L26
        L3c:
            r1 = 3
            goto L5c
        L3e:
            java.lang.String r5 = "HMACSHA256"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L5c
            goto L26
        L47:
            java.lang.String r5 = "HMACSHA224"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L50
            goto L26
        L50:
            r1 = 1
            goto L5c
        L52:
            java.lang.String r5 = "HMACSHA1"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L5b
            goto L26
        L5b:
            r1 = 0
        L5c:
            switch(r1) {
                case 0: goto L7f;
                case 1: goto L7a;
                case 2: goto L75;
                case 3: goto L70;
                case 4: goto L6b;
                default: goto L5f;
            }
        L5f:
            java.security.NoSuchAlgorithmException r3 = new java.security.NoSuchAlgorithmException
            java.lang.String r5 = "unknown Hmac algorithm: "
            java.lang.String r4 = r5.concat(r4)
            r3.<init>(r4)
            throw r3
        L6b:
            r4 = 64
            r3.f4154f = r4
            goto L83
        L70:
            r4 = 48
            r3.f4154f = r4
            goto L83
        L75:
            r4 = 32
            r3.f4154f = r4
            goto L83
        L7a:
            r4 = 28
            r3.f4154f = r4
            goto L83
        L7f:
            r4 = 20
            r3.f4154f = r4
        L83:
            r0.get()
            return
        L87:
            java.security.InvalidAlgorithmParameterException r3 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r4 = "key size too small, need at least 16 bytes"
            r3.<init>(r4)
            throw r3
        L8f:
            java.security.GeneralSecurityException r3 = new java.security.GeneralSecurityException
            java.lang.String r4 = "Can not use HMAC in FIPS-mode, as BoringCrypto module is not available."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.s.<init>(java.lang.String, javax.crypto.spec.SecretKeySpec):void");
    }

    public s(int i2, g7.l lVar, ka.a aVar, la.j jVar) {
        this.f4155g = jVar;
        this.f4154f = i2;
        this.f4156h = aVar;
        this.f4157i = lVar;
    }
}
