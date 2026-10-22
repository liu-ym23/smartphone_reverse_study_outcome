package com.bytedance.android.standard.tools.file;

import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import u0.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class FileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f6273a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f6274b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f6275c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f6276d = null;

    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType GIF = null;
        public static final ImageType JPG = null;
        public static final ImageType PNG = null;
        public static final ImageType UNKNOWN = null;

        static {
            ImageType r10 = new ImageType("UNKNOWN", 0);
            UNKNOWN = r10;
            ImageType r11 = new ImageType("JPG", 1);
            JPG = r11;
            ImageType r12 = new ImageType("PNG", 2);
            PNG = r12;
            ImageType r13 = new ImageType("GIF", 3);
            GIF = r13;
            $VALUES = new ImageType[]{r10, r11, r12, r13};
        }

        private ImageType(String r10, int r11) {
            super(r10, r11);
        }

        public static ImageType valueOf(String r10) {
            return (ImageType) Enum.valueOf(ImageType.class, r10);
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }
    }

    static {
        f6273a = new byte[]{71, 73, 70, 56, 55, 97};
        f6274b = new byte[]{71, 73, 70, 56, 57, 97};
        f6275c = new byte[]{-1, -40, -1};
        f6276d = new byte[]{-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
    }

    public static boolean a(String r10, String r11, String r12) {
        if (a.b(r10) == false) goto L5;
    L37:
        return false;
    L5:
        if (a.b(r11) == true) goto L37;
        if (a.b(r12) == true) goto L37;
        FileInputStream r13 = null;
        FileInputStream r14 = new FileInputStream(r10);     // Catch: Throwable -> L21 Exception -> L23
        boolean r15 = b(r14, r11, r12);     // Catch: Throwable -> L17 Exception -> L19
        r14.close();     // Catch: Exception -> L14
    L16:
        return r15;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L19:
        e = e;
        r13 = r14;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r13 != null) goto L40;
    L30:
        return false;
    L40:
        r13.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
        r13 = r14;
    L31:
        if (r13 != null) goto L42;
    L36:
        throw th;
    L42:
        r13.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = e;
    L21:
        th = th;
        goto L31
    }

    public static boolean b(InputStream r10, String r11, String r12) {
        if (r10 != null) goto L5;
        return false;
    L5:
        FileOutputStream r13 = null;
        File r14 = new File(r11);     // Catch: Throwable -> L15 Exception -> L17
        if (r14.exists() == false) goto L9;
    L19:
        FileOutputStream r15 = new FileOutputStream(new File(r14, r12));     // Catch: Throwable -> L15 Exception -> L17
        byte[] r16 = new byte[1024];     // Catch: Throwable -> L25 Exception -> L27
    L22:
        int r17 = r10.read(r16);     // Catch: Throwable -> L25 Exception -> L27
        if (r17 == (-1)) goto L29;
        r15.write(r16, 0, r17);     // Catch: Throwable -> L25 Exception -> L27
        goto L22
    L29:
        r15.flush();     // Catch: Throwable -> L25 Exception -> L27
        r15.close();     // Catch: Throwable -> L25 Exception -> L27
        r10.close();     // Catch: Throwable -> L15 Exception -> L17
        r10.close();     // Catch: Exception -> L33
        return true;
    L33:
        e = move-exception;
        e.printStackTrace();
        return true;
    L27:
        e = e;
        r13 = r15;
    L37:
        r0.a.c("FileUtils", "save inputstream error: " + e);     // Catch: Throwable -> L15
        if (r13 == null) goto L62;
        r13.close();     // Catch: Exception -> L53
    L62:
        r10.close();     // Catch: Exception -> L42
    L44:
        return false;
    L42:
        e = move-exception;
        e.printStackTrace();
    L25:
        th = th;
        r13 = r15;
    L45:
        if (r13 == null) goto L64;
        r13.close();     // Catch: Exception -> L52
    L64:
        r10.close();     // Catch: Exception -> L49
        throw th;
    L49:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L9:
        if (r14.mkdirs() == true) goto L19;
        r10.close();     // Catch: Exception -> L12
    L14:
        return false;
    L12:
        e = move-exception;
        e.printStackTrace();
    L17:
        e = e;
    L15:
        th = th;
        goto L45
    }
}
