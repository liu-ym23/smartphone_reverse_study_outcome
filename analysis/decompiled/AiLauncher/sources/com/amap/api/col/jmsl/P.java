package com.amap.api.col.jmsl;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class P {
    public static Map<String, byte[]> a(byte[] bArr, String[] strArr) {
        InputStream gZIPInputStream;
        HashMap map = new HashMap();
        if (bArr != null && bArr.length != 0) {
            InputStream inputStream = null;
            try {
                if (bArr.length == 0) {
                    gZIPInputStream = null;
                } else {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    gZIPInputStream = ((bArr[1] & 255) | (bArr[0] << 8)) == 8075 ? new GZIPInputStream(byteArrayInputStream) : new ZipInputStream(byteArrayInputStream);
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (gZIPInputStream instanceof ZipInputStream) {
                    ZipInputStream zipInputStream = (ZipInputStream) gZIPInputStream;
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        if (!nextEntry.isDirectory()) {
                            try {
                                String name = nextEntry.getName();
                                if (name.contains("..") || name.contains("\\") || name.contains("%")) {
                                    Log.e("gzip compress error.", "gzip name contains ../ " + name);
                                    g(gZIPInputStream);
                                    return null;
                                }
                                byte[] bArrD = d(zipInputStream);
                                if (bArrD != null) {
                                    map.put(name, bArrD);
                                }
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        zipInputStream.closeEntry();
                    }
                }
                g(gZIPInputStream);
            } catch (Throwable th2) {
                inputStream = gZIPInputStream;
                th = th2;
                try {
                    Log.e("gzip compress error.", th.getMessage());
                    return map;
                } finally {
                    g(inputStream);
                }
            }
        }
        return map;
    }

    public static boolean b(File file) {
        File file2;
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath == null) {
            file2 = null;
        } else {
            int length = absolutePath.length();
            for (int i10 = 0; i10 < length; i10++) {
                if (!Character.isWhitespace(absolutePath.charAt(i10))) {
                    file2 = new File(absolutePath);
                    break;
                }
            }
            file2 = null;
        }
        return file2 != null && file2.exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(java.io.File r5, byte[] r6, boolean r7, boolean r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "FileIOUtils"
            r1 = 0
            if (r6 != 0) goto Lb
            java.lang.String r5 = "bytes is null."
            android.util.Log.e(r0, r5)
            return r1
        Lb:
            if (r5 != 0) goto Le
            goto L3b
        Le:
            boolean r2 = r5.exists()
            if (r2 == 0) goto L19
            boolean r2 = r5.isFile()
            goto L3c
        L19:
            java.io.File r2 = r5.getParentFile()
            if (r2 == 0) goto L3b
            boolean r3 = r2.exists()
            if (r3 == 0) goto L2c
            boolean r2 = r2.isDirectory()
            if (r2 == 0) goto L3b
            goto L32
        L2c:
            boolean r2 = r2.mkdirs()
            if (r2 == 0) goto L3b
        L32:
            boolean r2 = r5.createNewFile()     // Catch: java.io.IOException -> L37
            goto L3c
        L37:
            r2 = move-exception
            r2.printStackTrace()
        L3b:
            r2 = r1
        L3c:
            if (r2 != 0) goto L58
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "create file <"
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = "> failed."
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            android.util.Log.e(r0, r5)
            return r1
        L58:
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            r3.<init>(r5, r7)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            java.nio.channels.FileChannel r2 = r3.getChannel()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            if (r2 != 0) goto L78
            java.lang.String r5 = "fc is null."
            android.util.Log.e(r0, r5)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            if (r2 == 0) goto L73
            r2.close()     // Catch: java.io.IOException -> L6f
            goto L73
        L6f:
            r5 = move-exception
            r5.printStackTrace()
        L73:
            return r1
        L74:
            r5 = move-exception
            goto La3
        L76:
            r5 = move-exception
            goto L95
        L78:
            long r3 = r2.size()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            r2.position(r3)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r6)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            r2.write(r5)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
            r5 = 1
            if (r8 == 0) goto L8c
            r2.force(r5)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76
        L8c:
            r2.close()     // Catch: java.io.IOException -> L90
            goto L94
        L90:
            r6 = move-exception
            r6.printStackTrace()
        L94:
            return r5
        L95:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto La2
            r2.close()     // Catch: java.io.IOException -> L9e
            goto La2
        L9e:
            r5 = move-exception
            r5.printStackTrace()
        La2:
            return r1
        La3:
            if (r2 == 0) goto Lad
            r2.close()     // Catch: java.io.IOException -> La9
            goto Lad
        La9:
            r6 = move-exception
            r6.printStackTrace()
        Lad:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.P.c(java.io.File, byte[], boolean, boolean):boolean");
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                try {
                    int i10 = inputStream.read(bArr);
                    if (i10 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                } catch (IOException e10) {
                    throw e10;
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Throwable unused2) {
        }
        return byteArray;
    }

    public static byte[] e(byte[] bArr) {
        return h(bArr) ? f(bArr, 14, bArr.length) : bArr;
    }

    public static byte[] f(byte[] bArr, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 >= 0) {
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i10, bArr2, 0, Math.min(bArr.length - i10, i12));
            return bArr2;
        }
        throw new IllegalArgumentException(i10 + " > " + i11);
    }

    public static void g(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream instanceof ZipInputStream) {
                    ((ZipInputStream) inputStream).closeEntry();
                }
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean h(byte[] bArr) {
        return bArr != null && bArr.length >= 14 && bArr[0] == 95 && bArr[1] == 36 && bArr[12] == 36 && bArr[13] == 95;
    }

    public static boolean i(byte[] bArr) {
        long j10;
        if (h(bArr)) {
            try {
                j10 = Long.parseLong(new String(f(bArr, 2, 12))) * 1000;
            } catch (NumberFormatException unused) {
            }
        } else {
            j10 = -1;
        }
        return j10 != -1 && System.currentTimeMillis() > j10;
    }
}
