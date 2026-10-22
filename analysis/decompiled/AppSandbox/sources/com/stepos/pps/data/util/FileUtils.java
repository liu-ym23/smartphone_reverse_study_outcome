package com.stepos.pps.data.util;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
public class FileUtils {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String TAG = "FileUtils";

    public static boolean ensureDir(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        for (int i = 0; i < 3 && !file.mkdirs(); i++) {
        }
        return file.exists();
    }

    public static byte[] getFileMd5(File file) throws Throwable {
        StringBuilder sb;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                }
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    byte[] bArr = new byte[524288];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            byte[] bArrDigest = messageDigest.digest();
                            try {
                                fileInputStream.close();
                                return bArrDigest;
                            } catch (IOException e4) {
                                Log.w(TAG, "Exception : " + e4.toString() + " - Cause: " + e4.getCause());
                                return bArrDigest;
                            }
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    fileInputStream2 = fileInputStream;
                    Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                            e = e6;
                            sb = new StringBuilder("Exception : ");
                            sb.append(e.toString());
                            sb.append(" - Cause: ");
                            sb.append(e.getCause());
                            Log.w(TAG, sb.toString());
                            return new byte[0];
                        }
                    }
                    return new byte[0];
                } catch (IOException e7) {
                    e = e7;
                    fileInputStream2 = fileInputStream;
                    Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e8) {
                            e = e8;
                            sb = new StringBuilder("Exception : ");
                            sb.append(e.toString());
                            sb.append(" - Cause: ");
                            sb.append(e.getCause());
                            Log.w(TAG, sb.toString());
                            return new byte[0];
                        }
                    }
                    return new byte[0];
                } catch (NoSuchAlgorithmException e9) {
                    e = e9;
                    fileInputStream2 = fileInputStream;
                    Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e10) {
                            e = e10;
                            sb = new StringBuilder("Exception : ");
                            sb.append(e.toString());
                            sb.append(" - Cause: ");
                            sb.append(e.getCause());
                            Log.w(TAG, sb.toString());
                            return new byte[0];
                        }
                    }
                    return new byte[0];
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e11) {
                            Log.w(TAG, "Exception : " + e11.toString() + " - Cause: " + e11.getCause());
                        }
                    }
                    throw th;
                }
            }
            return new byte[0];
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] getMD5(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
            return new byte[0];
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] gzip(byte[] r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = " - Cause: "
            java.lang.String r1 = "FileUtils"
            java.lang.String r2 = "Exception : "
            r3 = 0
            if (r8 != 0) goto La
            return r3
        La:
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            int r6 = r8.length     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            r7 = 0
            r5.write(r8, r7, r6)     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            r5.flush()     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            r5.close()     // Catch: java.io.IOException -> L20
            goto L3e
        L20:
            r8 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r5 = r8.toString()
            r3.append(r5)
            r3.append(r0)
            java.lang.Throwable r8 = r8.getCause()
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            android.util.Log.w(r1, r8)
        L3e:
            byte[] r8 = r4.toByteArray()
            r4.close()     // Catch: java.io.IOException -> L46
            goto L64
        L46:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            java.lang.String r2 = r3.toString()
            r4.append(r2)
            r4.append(r0)
            java.lang.Throwable r0 = r3.getCause()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.w(r1, r0)
        L64:
            return r8
        L65:
            r8 = move-exception
            r3 = r5
            goto Lb0
        L68:
            r8 = move-exception
            goto L6e
        L6a:
            r8 = move-exception
            goto Lb0
        L6c:
            r8 = move-exception
            r5 = r3
        L6e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L65
            java.lang.String r6 = r8.toString()     // Catch: java.lang.Throwable -> L65
            r4.append(r6)     // Catch: java.lang.Throwable -> L65
            r4.append(r0)     // Catch: java.lang.Throwable -> L65
            java.lang.Throwable r8 = r8.getCause()     // Catch: java.lang.Throwable -> L65
            r4.append(r8)     // Catch: java.lang.Throwable -> L65
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L65
            android.util.Log.w(r1, r8)     // Catch: java.lang.Throwable -> L65
            if (r5 == 0) goto Laf
            r5.close()     // Catch: java.io.IOException -> L91
            goto Laf
        L91:
            r8 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            java.lang.String r2 = r8.toString()
            r4.append(r2)
            r4.append(r0)
            java.lang.Throwable r8 = r8.getCause()
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            android.util.Log.w(r1, r8)
        Laf:
            return r3
        Lb0:
            if (r3 == 0) goto Ld4
            r3.close()     // Catch: java.io.IOException -> Lb6
            goto Ld4
        Lb6:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            java.lang.String r2 = r3.toString()
            r4.append(r2)
            r4.append(r0)
            java.lang.Throwable r0 = r3.getCause()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.w(r1, r0)
        Ld4:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.data.util.FileUtils.gzip(byte[]):byte[]");
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = DIGITS;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static boolean zipFile(File file, File file2) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file2.exists()) {
            file2.delete();
        }
        if (file.isDirectory()) {
            return zipDir(file, file2);
        }
        return gZipFile(file, file2);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0147 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean gZipFile(java.io.File r8, java.io.File r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.data.util.FileUtils.gZipFile(java.io.File, java.io.File):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean zipDir(java.io.File r9, java.io.File r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.data.util.FileUtils.zipDir(java.io.File, java.io.File):boolean");
    }

    private static boolean zipDir(Stack<File> stack, String str, File file, ZipOutputStream zipOutputStream) {
        String absolutePath = file.getAbsolutePath();
        if (absolutePath != null && absolutePath.length() >= 1) {
            try {
                try {
                    if (absolutePath.length() <= str.length() + File.separator.length()) {
                        return false;
                    }
                    String strSubstring = absolutePath.substring(str.length() + File.separator.length());
                    if (!strSubstring.endsWith(File.separator)) {
                        strSubstring = strSubstring + File.separator;
                    }
                    zipOutputStream.putNextEntry(new ZipEntry(strSubstring));
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length >= 1) {
                        byte[] bArr = new byte[1048576];
                        for (File file2 : fileArrListFiles) {
                            if (file2 != null && file2.exists()) {
                                if (file2.isDirectory()) {
                                    stack.push(file2);
                                } else {
                                    FileInputStream fileInputStream = new FileInputStream(file2);
                                    zipOutputStream.putNextEntry(new ZipEntry(strSubstring + file2.getName()));
                                    while (true) {
                                        int i = fileInputStream.read(bArr);
                                        if (i <= 0) {
                                            break;
                                        }
                                        zipOutputStream.write(bArr, 0, i);
                                    }
                                    zipOutputStream.flush();
                                    zipOutputStream.closeEntry();
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e) {
                                        Log.w(TAG, "Exception : " + e.toString() + " - Cause: " + e.getCause());
                                    }
                                }
                            }
                        }
                    }
                    return true;
                } catch (IOException e2) {
                    Log.w(TAG, "Exception : " + e2.toString() + " - Cause: " + e2.getCause());
                }
            } catch (Exception e3) {
                Log.w(TAG, "Exception : " + e3.toString() + " - Cause: " + e3.getCause());
            }
        }
        return false;
    }

    public static boolean delete(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            return delDir(file);
        }
        boolean zDelete = file.delete();
        if (!zDelete) {
            System.out.println("delete file " + file + " unsuccessfully.");
        }
        return zDelete;
    }

    private static boolean delDir(File file) {
        Stack stack = new Stack();
        if (!delDir(stack, file)) {
            return false;
        }
        while (stack.size() > 0) {
            if (!delDir(stack, (File) stack.pop())) {
                return false;
            }
        }
        return true;
    }

    private static boolean delDir(Stack<File> stack, File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length < 1) {
            if (file.delete()) {
                return true;
            }
            System.out.println("delete dir " + file + " unsuccessfully.");
            return false;
        }
        stack.push(file);
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                stack.push(file2);
            } else if (!file2.delete()) {
                System.out.println("delete file " + file2.getAbsolutePath() + " unsuccessfully.");
                return false;
            }
        }
        return true;
    }

    public static File readFileFromDropbox(String str) throws IOException {
        File[] fileArrListFiles;
        File file = new File("/data/system/dropbox/");
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.getName().contains(str)) {
                return file2;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0061 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String readFile(java.io.File r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L45
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L45
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3d
            r6.<init>()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3d
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L64
        Lf:
            int r3 = r1.read(r2)     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L64
            r4 = -1
            if (r3 == r4) goto L1b
            r4 = 0
            r6.write(r2, r4, r3)     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L64
            goto Lf
        L1b:
            byte[] r2 = r6.toByteArray()     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L64
            java.lang.String r3 = new java.lang.String     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L64
            r3.<init>(r2)     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L64
            r1.close()     // Catch: java.io.IOException -> L28
            goto L2c
        L28:
            r0 = move-exception
            r0.printStackTrace()
        L2c:
            r6.close()     // Catch: java.io.IOException -> L30
            goto L34
        L30:
            r6 = move-exception
            r6.printStackTrace()
        L34:
            r0 = r3
            goto L5f
        L36:
            r2 = move-exception
            goto L48
        L38:
            r6 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
            goto L65
        L3d:
            r2 = move-exception
            r6 = r0
            goto L48
        L40:
            r6 = move-exception
            r1 = r0
            r0 = r6
            r6 = r1
            goto L65
        L45:
            r2 = move-exception
            r6 = r0
            r1 = r6
        L48:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L55
            r1.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r1 = move-exception
            r1.printStackTrace()
        L55:
            if (r6 == 0) goto L5f
            r6.close()     // Catch: java.io.IOException -> L5b
            goto L5f
        L5b:
            r6 = move-exception
            r6.printStackTrace()
        L5f:
            if (r0 != 0) goto L63
            java.lang.String r0 = ""
        L63:
            return r0
        L64:
            r0 = move-exception
        L65:
            if (r1 == 0) goto L6f
            r1.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r1 = move-exception
            r1.printStackTrace()
        L6f:
            if (r6 == 0) goto L79
            r6.close()     // Catch: java.io.IOException -> L75
            goto L79
        L75:
            r6 = move-exception
            r6.printStackTrace()
        L79:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.data.util.FileUtils.readFile(java.io.File):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void copyDir(java.io.File r13, java.io.File r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.data.util.FileUtils.copyDir(java.io.File, java.io.File):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0027 -> B:60:0x0071). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void copyFileUsingFileStreams(java.io.File r4, java.io.File r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3a
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3a
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L33
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L33
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
        Lf:
            int r0 = r1.read(r5)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            if (r0 <= 0) goto L1a
            r2 = 0
            r4.write(r5, r2, r0)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            goto Lf
        L1a:
            r1.close()     // Catch: java.io.IOException -> L1e
            goto L22
        L1e:
            r5 = move-exception
            r5.printStackTrace()
        L22:
            r4.close()     // Catch: java.io.IOException -> L26
            goto L71
        L26:
            r4 = move-exception
            r4.printStackTrace()
            goto L71
        L2b:
            r5 = move-exception
            goto L31
        L2d:
            r5 = move-exception
            goto L35
        L2f:
            r5 = move-exception
            r4 = r0
        L31:
            r0 = r1
            goto L73
        L33:
            r5 = move-exception
            r4 = r0
        L35:
            r0 = r1
            goto L3c
        L37:
            r5 = move-exception
            r4 = r0
            goto L73
        L3a:
            r5 = move-exception
            r4 = r0
        L3c:
            java.lang.String r1 = "FileUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72
            r2.<init>()     // Catch: java.lang.Throwable -> L72
            java.lang.String r3 = "Exception : "
            r2.append(r3)     // Catch: java.lang.Throwable -> L72
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L72
            r2.append(r3)     // Catch: java.lang.Throwable -> L72
            java.lang.String r3 = " - Cause: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L72
            java.lang.Throwable r5 = r5.getCause()     // Catch: java.lang.Throwable -> L72
            r2.append(r5)     // Catch: java.lang.Throwable -> L72
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L72
            android.util.Log.w(r1, r5)     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L6c
            r0.close()     // Catch: java.io.IOException -> L68
            goto L6c
        L68:
            r5 = move-exception
            r5.printStackTrace()
        L6c:
            if (r4 == 0) goto L71
            r4.close()     // Catch: java.io.IOException -> L26
        L71:
            return
        L72:
            r5 = move-exception
        L73:
            if (r0 == 0) goto L7d
            r0.close()     // Catch: java.io.IOException -> L79
            goto L7d
        L79:
            r0 = move-exception
            r0.printStackTrace()
        L7d:
            if (r4 == 0) goto L87
            r4.close()     // Catch: java.io.IOException -> L83
            goto L87
        L83:
            r4 = move-exception
            r4.printStackTrace()
        L87:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.data.util.FileUtils.copyFileUsingFileStreams(java.io.File, java.io.File):void");
    }

    public static double getDirSize(File file) {
        double dirSize = 0.0d;
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        dirSize += getDirSize(file2);
                    }
                }
                return dirSize;
            }
            return file.length() / 1024.0d;
        }
        System.out.println("文件或者文件夹不存在，请检查路径是否正确！");
        return 0.0d;
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
