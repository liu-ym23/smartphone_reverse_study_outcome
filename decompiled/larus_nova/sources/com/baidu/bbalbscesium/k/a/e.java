package com.baidu.bbalbscesium.k.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes39.dex */
public final class e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f30325k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f30326l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f30327m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f30328n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f30329o = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f30330p = 5;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f30331q = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f30332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f30334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f30335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f30336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f30337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private i f30338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private f f30339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f30340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f30341j;

    public e(b r100, int r101) {
        this.f30332a = null;
        this.f30335d = 0;
        this.f30336e = 0;
        this.f30338g = null;
        this.f30339h = null;
        this.f30340i = 1;
        this.f30341j = false;
        this.f30333b = r101;
        this.f30334c = r101;
        this.f30337f = r101;
        this.f30332a = new byte[r101 * 2];
        this.f30339h = new d(r100);
        this.f30338g = new h(this.f30333b);
    }

    private int a(byte[] r100, int r110, byte[] r111, int r112, int r113) throws IllegalBlockSizeException {
        if (r100 == null) goto L24;
        if (r113 == 0) goto L26;
        int r101 = this.f30340i;
        if (r101 == 2) goto L20;
        if (r101 == 3) goto L20;
        if ((r113 % this.f30334c) == 0) goto L20;
        if (r101 == 6) goto L20;
        if (this.f30338g == null) goto L18;
        throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f30334c + " bytes");
    L18:
        throw new IllegalBlockSizeException("Input length not multiple of " + this.f30334c + " bytes");
    L20:
        if (this.f30341j == false) goto L22;
        this.f30339h.b(r100, r110, r113, r111, r112);
    L23:
        return r113;
    L22:
        this.f30339h.d(r100, r110, r113, r111, r112);
        goto L23
    L26:
        return 0;
    L24:
        return 0;
    }

    public static byte[] a(Key r100) throws InvalidKeyException {
        if (r100 == null) goto L13;
        if ("RAW".equalsIgnoreCase(r100.getFormat()) == false) goto L11;
        byte[] r101 = r100.getEncoded();
        if (r101 == null) goto L9;
        return r101;
    L9:
        throw new InvalidKeyException("RAW key bytes missing");
    L11:
        throw new InvalidKeyException("Wrong format: RAW bytes needed");
    L13:
        throw new InvalidKeyException("No key given");
    }

    public int a(int r100) {
        int r101 = this.f30335d + r100;
        i r102 = this.f30338g;
        if (r102 != null) goto L6;
        return r101;
    L6:
        if (this.f30341j == false) goto L8;
        return r101;
    L8:
        int r103 = this.f30334c;
        int r104 = this.f30333b;
        if (r103 == r104) goto L16;
        int r105 = this.f30337f;
        if (r101 >= r105) goto L14;
        return r105;
    L14:
        return (r101 + r104) - ((r101 - r105) % r104);
    L16:
        return r101 + r102.a(r101);
    }

    public int a(byte[] r110, int r111, int r112, byte[] r113, int r210) throws IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        int r100 = this.f30335d + r112;
        int r101 = this.f30334c;
        int r102 = this.f30333b;
        if (r101 == r102) goto L8;
        int r103 = this.f30337f;
        if (r100 >= r103) goto L7;
        int r104 = r103 - r100;
    L12:
        if (r104 > 0) goto L14;
    L22:
        boolean r105 = this.f30341j;
        if (r105 == false) goto L25;
    L27:
        int r106 = r100;
    L28:
        if (r113 == null) goto L81;
        int r107 = r113.length - r210;
        if (r105 == true) goto L32;
    L33:
        if (r107 < r106) goto L79;
    L34:
        if (r105 == true) goto L36;
    L37:
        int r108 = this.f30335d;
        if (r108 != 0) goto L44;
        if (r105 == false) goto L41;
    L43:
        byte[] r109 = r110;
        int r114 = r111;
    L56:
        if (this.f30341j == false) goto L73;
        if (r107 >= r106) goto L59;
        this.f30339h.g();
    L59:
        byte[] r115 = new byte[r100];
        int r116 = a(r109, r114, r115, 0, r100);
        i r117 = this.f30338g;
        if (r117 == null) goto L67;
        r116 = r117.a(r115, 0, r116);
        if (r116 >= 0) goto L67;
        throw new BadPaddingException("Given final block not properly padded");
    L67:
        if ((r113.length - r210) < r116) goto L71;
        int r118 = 0;
    L69:
        if (r118 >= r116) goto L74;
        r113[r210 + r118] = r115[r118];
        r118 = r118 + 1;
    L74:
        this.f30335d = 0;
        this.f30337f = this.f30333b;
        if (this.f30340i == 0) goto L77;
        this.f30339h.e();
    L77:
        return r116;
    L71:
        this.f30339h.f();
        throw new ShortBufferException("Output buffer too short: " + (r113.length - r210) + " bytes given, " + r116 + " bytes needed");
    L73:
        r116 = a(r109, r114, r113, r210, r106);
        goto L74
    L41:
        if (this.f30338g == null) goto L43;
    L44:
        byte[] r119 = new byte[r106];
        if (r108 == 0) goto L47;
        System.arraycopy(this.f30332a, 0, r119, 0, r108);
    L47:
        if (r112 == 0) goto L50;
        System.arraycopy(r110, r111, r119, this.f30335d, r112);
    L50:
        if (this.f30341j == true) goto L54;
        i r120 = this.f30338g;
        if (r120 == null) goto L54;
        r120.b(r119, r100, r104);
    L54:
        r109 = r119;
        r114 = 0;
        goto L56
    L36:
        if (r107 >= (r106 - this.f30333b)) goto L37;
    L79:
        throw new ShortBufferException("Output buffer too short: " + r107 + " bytes given, " + r106 + " bytes needed");
    L32:
        if (this.f30338g != null) goto L34;
    L81:
        throw new ShortBufferException("Output buffer is null");
    L25:
        if (this.f30338g == null) goto L27;
        r106 = r100 + r104;
        goto L28
    L14:
        if (r104 == this.f30333b) goto L22;
        if (this.f30338g == null) goto L22;
        if (this.f30341j == false) goto L22;
        throw new IllegalBlockSizeException("Input length must be multiple of " + this.f30333b + " when decrypting with padded cipher");
    L7:
        r104 = r102 - ((r100 - r103) % r102);
        goto L12
    L8:
        i r121 = this.f30338g;
        if (r121 == null) goto L11;
        r104 = r121.a(r100);
        goto L12
    L11:
        r104 = 0;
        goto L12
    }

    public Key a(byte[] r100, String r101) throws InvalidKeyException {
    L4:
        return new SecretKeySpec(a(r100, 0, r100.length), r101);
    L8:
        throw new InvalidKeyException("The wrapped key is not padded correctly");
    L6:
        throw new InvalidKeyException("The wrapped key does not have the correct length");
    }

    public void a(int r100, Key r101, AlgorithmParameterSpec r102, SecureRandom r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (r100 != 2) goto L5;
    L8:
        boolean r104 = true;
    L9:
        this.f30341j = r104;
        byte[] r105 = a(r101);
        if (r102 != null) goto L13;
        byte[] r106 = null;
    L30:
        a(r100, r105, r106, r103);
        return;
    L13:
        if ((r102 instanceof IvParameterSpec) == false) goto L22;
        r106 = ((IvParameterSpec) r102).getIV();
        if (r106 == null) goto L20;
        if (r106.length == this.f30333b) goto L30;
    L20:
        throw new InvalidAlgorithmParameterException("Wrong IV length: must be " + this.f30333b + " bytes long");
    L22:
        if ((r102 instanceof RC2ParameterSpec) == false) goto L33;
        r106 = ((RC2ParameterSpec) r102).getIV();
        if (r106 == null) goto L30;
        if (r106.length == this.f30333b) goto L30;
        throw new InvalidAlgorithmParameterException("Wrong IV length: must be " + this.f30333b + " bytes long");
    L33:
        throw new InvalidAlgorithmParameterException("Wrong parameter type: IV expected");
    L5:
        if (r100 == 4) goto L8;
        r104 = false;
        goto L9
    }

    public void a(int r100, byte[] r101, byte[] r102, SecureRandom r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (r100 != 2) goto L5;
    L8:
        boolean r104 = true;
    L9:
        this.f30341j = r104;
        if (this.f30340i != 0) goto L15;
        if (r102 != null) goto L14;
    L22:
        this.f30335d = 0;
        this.f30337f = this.f30333b;
        this.f30339h.a(this.f30341j, "", r101, r102);
        return;
    L14:
        throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
    L15:
        if (r102 != null) goto L22;
        if (r104 == true) goto L21;
        if (r103 != null) goto L19;
        r103 = c.f30320b;
    L19:
        r102 = new byte[this.f30333b];
        r103.nextBytes(r102);
        goto L22
    L21:
        throw new InvalidAlgorithmParameterException("Parameters missing");
    L5:
        if (r100 == 4) goto L8;
        r104 = false;
        goto L9
    }

    public void a(String r100) throws NoSuchAlgorithmException {
        if (r100 == null) goto L10;
        String r101 = r100.toUpperCase(Locale.ENGLISH);
        b r102 = this.f30339h.b();
        if (r101.equals("CBC") == false) goto L8;
        this.f30340i = 1;
        this.f30339h = new d(r102);
        return;
    L8:
        throw new NoSuchAlgorithmException("Cipher mode: " + r100 + " not found");
    L10:
        throw new NoSuchAlgorithmException("null mode");
    }

    public byte[] a(byte[] r100, int r110, int r111) throws IllegalBlockSizeException, BadPaddingException {
        int r101 = a(r111);     // Catch: ShortBufferException -> L9
        byte[] r102 = new byte[r101];     // Catch: ShortBufferException -> L9
        int r103 = a(r100, r110, r111, r102, 0);     // Catch: ShortBufferException -> L9
        if (r103 >= r101) goto L16;
        byte[] r112 = new byte[r103];     // Catch: ShortBufferException -> L9
        if (r103 == 0) goto L17;
        System.arraycopy(r102, 0, r112, 0, r103);     // Catch: ShortBufferException -> L11
    L17:
        return r112;
    L16:
        return r102;
    L10:
        return null;
    }

    public int b(byte[] r110, int r111, int r112, byte[] r113, int r114) throws ShortBufferException {
        int r100 = r111;
        int r101 = this.f30335d;
        int r102 = (r101 + r112) - this.f30336e;
        if (this.f30338g == null) goto L8;
        if (this.f30341j == false) goto L8;
        r102 = r102 - this.f30333b;
    L8:
        if (r102 <= 0) goto L10;
        int r115 = r102 - (r102 % this.f30334c);
    L11:
        if (r113 == null) goto L42;
        if ((r113.length - r114) < r115) goto L42;
        if (r115 == 0) goto L36;
        byte[] r103 = new byte[r115];
        int r104 = r115 - r101;
        if (r104 >= 0) goto L18;
        int r116 = r115;
        int r117 = 0;
    L19:
        if (r101 == 0) goto L21;
        System.arraycopy(this.f30332a, 0, r103, 0, r116);
    L21:
        if (r117 <= 0) goto L24;
        System.arraycopy(r110, r111, r103, r116, r117);
    L24:
        if (this.f30341j == false) goto L26;
        this.f30339h.a(r103, 0, r115, r113, r114);
    L27:
        int r105 = this.f30334c;
        int r106 = this.f30333b;
        if (r105 == r106) goto L33;
        int r107 = this.f30337f;
        if (r115 >= r107) goto L32;
        this.f30337f = r107 - r115;
        goto L33
    L32:
        this.f30337f = r106 - ((r115 - r107) % r106);
    L33:
        int r108 = r112 - r117;
        r100 = r100 + r117;
        int r109 = this.f30335d - r116;
        this.f30335d = r109;
        if (r109 <= 0) goto L37;
        byte[] r118 = this.f30332a;
        System.arraycopy(r118, r116, r118, 0, r109);
    L37:
        if (r108 <= 0) goto L39;
        System.arraycopy(r110, r100, this.f30332a, this.f30335d, r108);
    L39:
        this.f30335d += r108;
        return r115;
    L26:
        this.f30339h.c(r103, 0, r115, r113, r114);
        goto L27
    L18:
        r116 = r101;
        r117 = r104;
        goto L19
    L36:
        r108 = r112;
    L42:
        throw new ShortBufferException("Output buffer must be (at least) " + r115 + " bytes long");
    L10:
        r115 = 0;
        goto L11
    }

    public byte[] b(Key r100) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] r101 = r100.getEncoded();     // Catch: BadPaddingException -> L9
        if (r101 == null) goto L8;
        if (r101.length == 0) goto L8;
        return a(r101, 0, r101.length);
    L8:
        throw new InvalidKeyException("Cannot get an encoding of the key to be wrapped");     // Catch: BadPaddingException -> L9
    L9:
        return null;
    }

    public byte[] b(byte[] r100, int r110, int r111) {
        int r101 = a(r111);     // Catch: ShortBufferException -> L9
        byte[] r102 = new byte[r101];     // Catch: ShortBufferException -> L9
        int r103 = b(r100, r110, r111, r102, 0);     // Catch: ShortBufferException -> L9
        if (r103 == r101) goto L16;
        byte[] r112 = new byte[r103];     // Catch: ShortBufferException -> L9
        System.arraycopy(r102, 0, r112, 0, r103);     // Catch: ShortBufferException -> L11
    L17:
        return r112;
    L16:
        return r102;
    L9:
        return null;
    }
}
