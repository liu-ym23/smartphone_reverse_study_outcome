package com.baidu.bbalbscesium.k.d;

import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f30383h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f30384i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f30385j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f30386k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map f30387l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f30389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SecureRandom f30390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f30391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MessageDigest f30392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MessageDigest f30393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f30394g;

    static {
        f30387l = Collections.synchronizedMap(new HashMap());
    }

    private f(int r100, int r101, SecureRandom r102, OAEPParameterSpec r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.f30388a = r100;
        this.f30389b = r101;
        this.f30390c = r102;
        if (r101 < 64) goto L42;
        if (r100 != 1) goto L7;
    L38:
        r101 = r101 - 11;
    L39:
        this.f30391d = r101;
        return;
    L7:
        if (r100 == 2) goto L38;
        if (r100 == 3) goto L39;
        if (r100 != 4) goto L37;
        String r104 = "SHA-1";
        if (r103 != null) goto L43;
        byte[] r105 = null;
        String r106 = "SHA-1";
    L44:
        this.f30392e = MessageDigest.getInstance(r106);     // Catch: NoSuchAlgorithmException -> L32
        this.f30393f = MessageDigest.getInstance(r104);     // Catch: NoSuchAlgorithmException -> L32
        byte[] r107 = a(this.f30392e, r105);
        this.f30394g = r107;
        int r108 = (r101 - 2) - (r107.length * 2);
        this.f30391d = r108;
        if (r108 <= 0) goto L31;
        return;
    L31:
        throw new InvalidKeyException("Key is too short for encryption using OAEPPadding with " + r106 + " and MGF1" + r104);
    L32:
        e = e;
        r104 = r106;
    L35:
        throw new InvalidKeyException("Digest " + r104 + " not available", e);
    L43:
        String r109 = r103.getDigestAlgorithm();     // Catch: NoSuchAlgorithmException -> L23
        String r110 = r103.getMGFAlgorithm();     // Catch: NoSuchAlgorithmException -> L23
        if (r110.equalsIgnoreCase("MGF1") == false) goto L22;
        String r111 = ((MGF1ParameterSpec) r103.getMGFParameters()).getDigestAlgorithm();     // Catch: NoSuchAlgorithmException -> L23
        PSource r112 = r103.getPSource();     // Catch: NoSuchAlgorithmException -> L23
        String r113 = r112.getAlgorithm();     // Catch: NoSuchAlgorithmException -> L23
        if (r113.equalsIgnoreCase("PSpecified") == false) goto L20;
        r105 = ((PSource.PSpecified) r112).getValue();     // Catch: NoSuchAlgorithmException -> L23
        r106 = r109;
        r104 = r111;
        goto L44
    L20:
        throw new InvalidAlgorithmParameterException("Unsupported pSource algo: ".concat(r113));     // Catch: NoSuchAlgorithmException -> L23
    L22:
        throw new InvalidAlgorithmParameterException("Unsupported MGF algo: ".concat(r110));     // Catch: NoSuchAlgorithmException -> L23
    L23:
        e = e;
        goto L35
    L37:
        throw new InvalidKeyException("Invalid padding: " + r100);
    L42:
        throw new InvalidKeyException("Padded size must be at least 64");
    }

    public static f a(int r100, int r101) throws InvalidKeyException, InvalidAlgorithmParameterException {
        return new f(r100, r101, null, null);
    }

    public static f a(int r100, int r101, SecureRandom r102) throws InvalidKeyException, InvalidAlgorithmParameterException {
        return new f(r100, r101, r102, null);
    }

    public static f a(int r100, int r101, SecureRandom r102, OAEPParameterSpec r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        return new f(r100, r101, r102, r103);
    }

    private void a(byte[] r100, int r101, int r110, byte[] r111, int r112, int r113) throws BadPaddingException {
        byte[] r102 = new byte[4];
        byte[] r103 = new byte[20];
    L3:
        if (r113 <= 0) goto L18;
        this.f30393f.update(r100, r101, r110);
        this.f30393f.update(r102);
        int r104 = 0;
        this.f30393f.digest(r103, 0, 20);     // Catch: DigestException -> L15
    L6:
        if (r104 >= 20) goto L9;
        if (r113 <= 0) goto L9;
        r111[r112] = (byte) (r103[r104] ^ r111[r112]);
        r113 = r113 - 1;
        r112 = r112 + 1;
        r104 = r104 + 1;
    L9:
        if (r113 <= 0) goto L3;
        int r105 = 3;
    L11:
        byte r106 = (byte) (r102[r105] + 1);
        r102[r105] = r106;
        if (r106 != 0) goto L3;
        if (r105 <= 0) goto L3;
        r105 = r105 - 1;
    L15:
        e = move-exception;
        throw new BadPaddingException(e.toString());
    }

    private static byte[] a(MessageDigest r100, byte[] r101) {
        if (r101 != null) goto L4;
    L7:
        String r102 = r100.getAlgorithm();
        Map r103 = f30387l;
        byte[] r104 = (byte[]) r103.get(r102);
        if (r104 != null) goto L11;
        byte[] r105 = r100.digest();
        r103.put(r102, r105);
        return r105;
    L11:
        return r104;
    L4:
        if (r101.length == 0) goto L7;
        return r100.digest(r101);
    }

    private byte[] b(byte[] r110) throws BadPaddingException {
        if (this.f30390c != null) goto L5;
        this.f30390c = b.f30363a;
    L5:
        int r100 = this.f30394g.length;
        byte[] r101 = new byte[r100];
        this.f30390c.nextBytes(r101);
        int r102 = this.f30389b;
        byte[] r103 = new byte[r102];
        System.arraycopy(r101, 0, r103, 1, r100);
        int r104 = r100 + 1;
        int r111 = r102 - r104;
        int r105 = this.f30389b - r110.length;
        System.arraycopy(this.f30394g, 0, r103, r104, r100);
        r103[r105 - 1] = 1;
        System.arraycopy(r110, 0, r103, r105, r110.length);
        a(r103, 1, r100, r103, r104, r111);
        a(r103, r104, r111, r103, 1, r100);
        return r103;
    }

    private byte[] c(byte[] r100) throws BadPaddingException {
        int r101 = this.f30389b;
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, 0, r102, r101 - r100.length, r100.length);
        int r103 = (this.f30389b - 3) - r100.length;
        r102[0] = 0;
        int r104 = this.f30388a;
        r102[1] = (byte) r104;
        int r105 = -1;
        int r106 = 2;
        if (r104 != 1) goto L8;
    L4:
        int r107 = r103 - 1;
        if (r103 <= 0) goto L19;
        r102[r106] = -1;
        r106 = r106 + 1;
        r103 = r107;
    L19:
        return r102;
    L8:
        if (this.f30390c != null) goto L10;
        this.f30390c = b.f30363a;
    L10:
        byte[] r108 = new byte[64];
    L11:
        int r109 = r103 - 1;
        if (r103 <= 0) goto L19;
    L13:
        if (r105 >= 0) goto L15;
        this.f30390c.nextBytes(r108);
        r105 = 63;
    L15:
        int r110 = r105 - 1;
        int r111 = r108[r105] & UByte.MAX_VALUE;
        if (r111 != 0) goto L17;
        r105 = r110;
        goto L13
    L17:
        r102[r106] = (byte) r111;
        r105 = r110;
        r103 = r109;
        r106 = r106 + 1;
        goto L11
    }

    private byte[] e(byte[] r110) throws BadPaddingException {
        int r100 = this.f30394g.length;
        if (r110[0] != 0) goto L26;
        int r101 = r100 + 1;
        int r111 = r110.length - r101;
        a(r110, r101, r111, r110, 1, r100);
        a(r110, 1, r100, r110, r101, r111);
        int r102 = 0;
    L5:
        if (r102 >= r100) goto L11;
        if (this.f30394g[r102] != r110[r101 + r102]) goto L10;
        r102 = r102 + 1;
        goto L5
    L10:
        throw new BadPaddingException("lHash mismatch");
    L11:
        int r103 = r101 + r100;
    L12:
        byte r104 = r110[r103];
        if (r104 != 0) goto L19;
        r103 = r103 + 1;
        if (r103 < r110.length) goto L12;
        throw new BadPaddingException("Padding string not terminated");
    L19:
        int r105 = r103 + 1;
        if (r104 != 1) goto L24;
        int r106 = r110.length - r105;
        byte[] r107 = new byte[r106];
        System.arraycopy(r110, r105, r107, 0, r106);
        return r107;
    L24:
        throw new BadPaddingException("Padding string not terminated by 0x01 byte");
    L26:
        throw new BadPaddingException("Data must start with zero");
    }

    private byte[] f(byte[] r100) throws BadPaddingException {
        if (r100[0] != 0) goto L29;
        if (r100[1] != this.f30388a) goto L27;
        int r101 = 2;
    L7:
        int r102 = r101 + 1;
        int r103 = r100[r101] & UByte.MAX_VALUE;
        if (r103 == 0) goto L9;
        if (r102 == r100.length) goto L25;
        if (this.f30388a != 1) goto L23;
        if (r103 == 255) goto L23;
        throw new BadPaddingException("Padding byte not 0xff: " + r103);
    L23:
        r101 = r102;
        goto L7
    L25:
        throw new BadPaddingException("Padding string not terminated");
    L9:
        int r104 = r100.length - r102;
        if (r104 > this.f30391d) goto L14;
        byte[] r105 = new byte[r104];
        System.arraycopy(r100, r100.length - r104, r105, 0, r104);
        return r105;
    L14:
        throw new BadPaddingException("Padding string too short");
    L27:
        throw new BadPaddingException("Blocktype mismatch: " + r100[1]);
    L29:
        throw new BadPaddingException("Data must start with zero");
    }

    public int a() {
        return this.f30391d;
    }

    public byte[] a(byte[] r100) throws BadPaddingException {
        if (r100.length > this.f30391d) goto L20;
        int r101 = this.f30388a;
        if (r101 == 1) goto L18;
        if (r101 == 2) goto L18;
        if (r101 != 3) goto L11;
        return r100;
    L11:
        if (r101 != 4) goto L15;
        return b(r100);
    L15:
        throw new AssertionError();
    L18:
        return c(r100);
    L20:
        throw new BadPaddingException("Data must be shorter than " + (this.f30391d + 1) + " bytes");
    }

    public byte[] a(byte[] r100, int r101, int r102) throws BadPaddingException {
        return a(b.a(r100, r101, r102));
    }

    public byte[] b(byte[] r100, int r101, int r102) throws BadPaddingException {
        return d(b.a(r100, r101, r102));
    }

    public byte[] d(byte[] r100) throws BadPaddingException {
        if (r100.length != this.f30389b) goto L20;
        int r101 = this.f30388a;
        if (r101 == 1) goto L18;
        if (r101 == 2) goto L18;
        if (r101 != 3) goto L11;
        return r100;
    L11:
        if (r101 != 4) goto L15;
        return e(r100);
    L15:
        throw new AssertionError();
    L18:
        return f(r100);
    L20:
        throw new BadPaddingException("Padded length must be " + this.f30389b);
    }
}
