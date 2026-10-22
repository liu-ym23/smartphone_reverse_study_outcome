package com.baidu.bbalbscesium.k.d;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* JADX INFO: loaded from: classes39.dex */
public final class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte[] f30364j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f30365k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f30366l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f30367m = 3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f30368n = 4;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f30369o = "NoPadding";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f30370p = "PKCS1Padding";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f30371q = "OAEP";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f30373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f30374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OAEPParameterSpec f30375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f30376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f30377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f30378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f30379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f30380i;

    static {
        f30364j = new byte[0];
    }

    public c() {
        this.f30375d = null;
        this.f30380i = "SHA-1";
        this.f30373b = f30370p;
    }

    private void a(int r100, d r101, SecureRandom r110, AlgorithmParameterSpec r111) throws InvalidKeyException, InvalidAlgorithmParameterException {
        int r102 = 2;
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L10;
        if (r100 == 3) goto L11;
        if (r100 == 4) goto L10;
        throw new InvalidKeyException("Unknown mode: " + r100);
    L10:
        boolean r103 = false;
    L13:
        if ((r101 instanceof d) == false) goto L54;
        if (r103 == false) goto L16;
        int r104 = 1;
    L17:
        this.f30372a = r104;
        this.f30379h = r101;
        int r105 = b.a(r101.a());
        this.f30378g = r105;
        this.f30377f = 0;
        String r106 = this.f30373b;
        if (r106 != f30369o) goto L24;
        if (r111 != null) goto L22;
        this.f30374c = f.a(3, r105, r110);
        this.f30376e = new byte[r105];
        return;
    L22:
        throw new InvalidAlgorithmParameterException("Parameters not supported");
    L24:
        if (r106 != f30370p) goto L36;
        if (r111 != null) goto L35;
        if (this.f30372a <= 2) goto L30;
        r102 = 1;
    L30:
        f r112 = f.a(r102, r105, r110);
        this.f30374c = r112;
        if (r103 == false) goto L33;
        this.f30376e = new byte[r112.a()];
        return;
    L33:
        this.f30376e = new byte[r105];
        return;
    L35:
        throw new InvalidAlgorithmParameterException("Parameters not supported");
    L36:
        int r107 = this.f30372a;
        if (r107 == 3) goto L52;
        if (r107 == 4) goto L52;
        if (r111 != null) goto L41;
        OAEPParameterSpec r113 = new OAEPParameterSpec(this.f30380i, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
    L46:
        f r114 = f.a(4, r105, r110, r113);
        this.f30374c = r114;
        if (r103 == false) goto L49;
        this.f30376e = new byte[r114.a()];
        return;
    L49:
        this.f30376e = new byte[r105];
        return;
    L41:
        if ((r111 instanceof OAEPParameterSpec) == false) goto L44;
        r113 = (OAEPParameterSpec) r111;
        goto L46
    L44:
        throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
    L52:
        throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
    L16:
        r104 = 4;
        goto L17
    L54:
        throw new InvalidKeyException("only support helios key");
    L11:
        r103 = true;
        goto L13
    }

    private byte[] a() throws BadPaddingException, IllegalBlockSizeException {
        int r100 = this.f30377f;
        byte[] r101 = this.f30376e;
        if (r100 > r101.length) goto L30;
        int r102 = this.f30372a;     // Catch: Throwable -> L26
        if (r102 != 1) goto L9;
        byte[] r103 = b.a(this.f30374c.a(r101, 0, r100), this.f30379h);     // Catch: Throwable -> L26
        this.f30377f = 0;
        return r103;
    L9:
        if (r102 == 2) goto L22;
        if (r102 == 3) goto L20;
        if (r102 != 4) goto L18;
        byte[] r104 = this.f30374c.d(b.a(b.a(r101, 0, r100), this.f30379h));     // Catch: Throwable -> L26
        this.f30377f = 0;
        return r104;
    L18:
        throw new AssertionError("Internal error");     // Catch: Throwable -> L26
    L20:
        throw new UnsupportedOperationException("only verify supported");     // Catch: Throwable -> L26
    L22:
        throw new UnsupportedOperationException("only verify supported");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        this.f30377f = 0;
        throw th;
    L30:
        throw new IllegalBlockSizeException("Data must not be longer than " + this.f30376e.length + " bytes");
    }

    private void b(byte[] r100, int r101, int r102) {
        if (r102 == 0) goto L11;
        if (r100 == null) goto L12;
        int r103 = this.f30377f;
        int r104 = r103 + r102;
        byte[] r105 = this.f30376e;
        if (r104 <= r105.length) goto L10;
        int r106 = r105.length + 1;
    L8:
        this.f30377f = r106;
        return;
    L10:
        System.arraycopy(r100, r101, r105, r103, r102);
        r106 = this.f30377f + r102;
        goto L8
    L12:
        return;
    }

    public void a(int r100, d r101, SecureRandom r102) throws InvalidKeyException {
        a(r100, r101, r102, null);     // Catch: InvalidAlgorithmParameterException -> L5
        return;
    L5:
        e = move-exception;
        InvalidKeyException r103 = new InvalidKeyException("Wrong parameters");
        r103.initCause(e);
        throw r103;
    }

    public void a(String r100) throws NoSuchAlgorithmException {
        if (r100.equalsIgnoreCase("ECB") == false) goto L6;
        return;
    L6:
        throw new NoSuchAlgorithmException("Unsupported mode ".concat(r100));
    }

    public byte[] a(byte[] r100, int r101, int r102) throws BadPaddingException, IllegalBlockSizeException {
        b(r100, r101, r102);
        return a();
    }

    public void b(String r100) throws NoSuchPaddingException {
        String r101 = f30369o;
        if (r100.equalsIgnoreCase(f30369o) == false) goto L5;
    L4:
        this.f30373b = r101;
        return;
    L5:
        r101 = f30370p;
        if (r100.equalsIgnoreCase(f30370p) == true) goto L4;
        String r102 = r100.toLowerCase(Locale.ENGLISH);
        if (r102.equals("oaeppadding") == false) goto L13;
        this.f30373b = f30371q;
        return;
    L13:
        if (r102.startsWith("oaepwith") == false) goto L19;
        if (r102.endsWith("andmgf1padding") == false) goto L19;
        this.f30373b = f30371q;
        this.f30380i = r100.substring(8, r100.length() - 14);
        throw new NoSuchPaddingException("MessageDigest not available for ".concat(r100));
    L19:
        throw new NoSuchPaddingException("Padding " + r100 + " not supported");
    }
}
