package com.baidu.bbalbscesium.k.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Random;

/* JADX INFO: loaded from: classes39.dex */
public class b implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f30347b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f30348c = 64;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f30349d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f30350e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f30351f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f30352g = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30353a;

    static {
        f30351f = c(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    }

    public b(int r100) {
        this.f30353a = r100;
    }

    private static int a(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (-r101)) | r102;
    }

    private void a(byte[] r100, byte[] r101, ByteBuffer r102, ByteBuffer r110) throws GeneralSecurityException {
        int r103 = r110.remaining();
        int r104 = (r103 / 64) + 1;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        ByteBuffer r106 = a(r100, r101, this.f30353a + r105);
        if (r105 != (r104 - 1)) goto L7;
        a.a(r102, r110, r106, r103 % 64);
    L8:
        r105 = r105 + 1;
        goto L3
    L7:
        a.a(r102, r110, r106, 64);
        goto L8
    }

    public static void a(int[] r110) {
        int r100 = 0;
    L4:
        if (r100 >= 10) goto L6;
        a(r110, 0, 4, 8, 12);
        a(r110, 1, 5, 9, 13);
        a(r110, 2, 6, 10, 14);
        a(r110, 3, 7, 11, 15);
        a(r110, 0, 5, 10, 15);
        a(r110, 1, 6, 11, 12);
        a(r110, 2, 7, 8, 13);
        a(r110, 3, 4, 9, 14);
        r100 = r100 + 1;
        goto L4
    }

    public static void a(int[] r100, int r101, int r102, int r103, int r104) {
        int r105 = r100[r101] + r100[r102];
        r100[r101] = r105;
        int r106 = a(r105 ^ r100[r104], 16);
        r100[r104] = r106;
        int r107 = r100[r103] + r106;
        r100[r103] = r107;
        int r108 = a(r100[r102] ^ r107, 12);
        r100[r102] = r108;
        int r109 = r100[r101] + r108;
        r100[r101] = r109;
        int r110 = a(r100[r104] ^ r109, 8);
        r100[r104] = r110;
        int r111 = r100[r103] + r110;
        r100[r103] = r111;
        r100[r102] = a(r100[r102] ^ r111, 7);
    }

    public static void a(int[] r100, int[] r101) {
        int[] r102 = f30351f;
        System.arraycopy(r102, 0, r100, 0, r102.length);
        System.arraycopy(r101, 0, r100, r102.length, 8);
    }

    public static int[] c(byte[] r100) {
        IntBuffer r101 = ByteBuffer.wrap(r100).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] r102 = new int[r101.remaining()];
        r101.get(r102);
        return r102;
    }

    public int a() {
        return 12;
    }

    public ByteBuffer a(byte[] r100, byte[] r101, int r102) {
        int[] r103 = a(c(r100), c(r101), r102);
        int[] r104 = (int[]) r103.clone();
        a(r104);
        int r105 = 0;
    L4:
        if (r105 >= r103.length) goto L6;
        r103[r105] = r103[r105] + r104[r105];
        r105 = r105 + 1;
        goto L4
    L6:
        ByteBuffer r106 = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        r106.asIntBuffer().put(r103, 0, 16);
        return r106;
    }

    public void a(ByteBuffer r100, byte[] r101, byte[] r102) throws GeneralSecurityException {
        if ((r100.remaining() - a()) < r101.length) goto L9;
        if (r102 != null) goto L6;
        r102 = new byte[a()];
        new Random().nextBytes(r102);
    L6:
        r100.put(r102);
        a(r102, com.baidu.bbalbscesium.k.c.b.b(), r100, ByteBuffer.wrap(r101));
        return;
    L9:
        throw new IllegalArgumentException("data output is too small");
    }

    public byte[] a(ByteBuffer r100) throws GeneralSecurityException {
        if (r100.remaining() < a()) goto L7;
        byte[] r101 = new byte[a()];
        r100.get(r101);
        ByteBuffer r102 = ByteBuffer.allocate(r100.remaining());
        a(r101, com.baidu.bbalbscesium.k.c.b.a(), r102, r100);
        return r102.array();
    L7:
        throw new GeneralSecurityException("data too short");
    }

    @Override // com.baidu.bbalbscesium.k.b.d
    public byte[] a(byte[] r100) throws GeneralSecurityException {
        return a(ByteBuffer.wrap(r100));
    }

    public byte[] a(byte[] r100, byte[] r101) throws GeneralSecurityException {
        if (r100.length > (Integer.MAX_VALUE - a())) goto L7;
        ByteBuffer r102 = ByteBuffer.allocate(a() + r100.length);
        a(r102, r100, r101);
        return r102.array();
    L7:
        throw new GeneralSecurityException("data too long");
    }

    public int[] a(int[] r100, int[] r101, int r102) {
        if (r100.length != (a() / 4)) goto L7;
        int[] r103 = new int[16];
        a(r103, r101);
        r103[12] = r102;
        System.arraycopy(r100, 0, r103, 13, r100.length);
        return r103;
    L7:
        throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", new Object[]{Integer.valueOf(r100.length * 32)}));
    }

    @Override // com.baidu.bbalbscesium.k.b.d
    public byte[] b(byte[] r100) throws GeneralSecurityException {
        return a(r100, null);
    }
}
