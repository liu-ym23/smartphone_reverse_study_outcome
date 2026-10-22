package com.baidu.location.b;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static j f5309a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f5310b = "Temp_in.dat";

    /* renamed from: c, reason: collision with root package name */
    private static File f5311c = new File(com.baidu.location.e.g.f5888a, f5310b);

    /* renamed from: d, reason: collision with root package name */
    private static StringBuffer f5312d = null;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f5313e = true;

    /* renamed from: f, reason: collision with root package name */
    private static int f5314f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static int f5315g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static long f5316h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static long f5317i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static long f5318j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static double f5319k = 0.0d;

    /* renamed from: l, reason: collision with root package name */
    private static double f5320l = 0.0d;

    /* renamed from: m, reason: collision with root package name */
    private static int f5321m = 0;

    /* renamed from: n, reason: collision with root package name */
    private static int f5322n = 0;

    /* renamed from: o, reason: collision with root package name */
    private static int f5323o = 0;

    public static String a() throws IOException {
        RandomAccessFile randomAccessFile;
        int i4;
        int i5;
        int i6;
        int i7;
        File file = f5311c;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(f5311c, "rw");
            randomAccessFile.seek(0L);
            i4 = randomAccessFile.readInt();
            i5 = randomAccessFile.readInt();
            i6 = randomAccessFile.readInt();
        } catch (IOException unused) {
        }
        if (!a(i4, i5, i6)) {
            randomAccessFile.close();
            c();
            return null;
        }
        if (i5 != 0 && i5 != i6) {
            long j4 = ((i5 - 1) * 1024) + 12;
            randomAccessFile.seek(j4);
            int i8 = randomAccessFile.readInt();
            byte[] bArr = new byte[i8];
            randomAccessFile.seek(j4 + 4);
            for (int i9 = 0; i9 < i8; i9++) {
                bArr[i9] = randomAccessFile.readByte();
            }
            String str = new String(bArr);
            int i10 = com.baidu.location.e.h.ae;
            int i11 = 1;
            if (i4 < i10) {
                i7 = i5 + 1;
            } else {
                if (i5 != i10) {
                    i11 = 1 + i5;
                }
                i7 = i11;
            }
            randomAccessFile.seek(4L);
            randomAccessFile.writeInt(i7);
            randomAccessFile.close();
            return str;
        }
        randomAccessFile.close();
        return null;
    }

    private static void b() {
        f5313e = true;
        f5312d = null;
        f5314f = 0;
        f5315g = 0;
        f5316h = 0L;
        f5317i = 0L;
        f5318j = 0L;
        f5319k = 0.0d;
        f5320l = 0.0d;
        f5321m = 0;
        f5322n = 0;
        f5323o = 0;
    }

    private static boolean c() throws IOException {
        if (f5311c.exists()) {
            f5311c.delete();
        }
        if (!f5311c.getParentFile().exists()) {
            f5311c.getParentFile().mkdirs();
        }
        try {
            f5311c.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(f5311c, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            b();
            return f5311c.exists();
        } catch (IOException unused) {
            return false;
        }
    }

    private static boolean a(int i4, int i5, int i6) {
        int i7;
        int i8;
        return i4 >= 0 && i4 <= (i7 = com.baidu.location.e.h.ae) && i5 >= 0 && i5 <= (i8 = i4 + 1) && i6 >= 1 && i6 <= i8 && i6 <= i7;
    }
}
