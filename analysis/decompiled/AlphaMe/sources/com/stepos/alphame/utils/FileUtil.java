package com.stepos.alphame.utils;

import B0.g;
import android.content.Context;
import com.stepos.alphame.ApplicationImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class FileUtil {
    private static final int BUFF_SIZE = 1048576;

    public static void clearFolder(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.isDirectory()) {
                file2.delete();
            }
        }
    }

    public static boolean copyDir(String str, String str2) throws Throwable {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (!file.isDirectory()) {
            copyFileToDir(str, str2);
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        for (int i4 = 0; i4 < fileArrListFiles.length; i4++) {
            if (fileArrListFiles[i4].isDirectory()) {
                String str3 = fileArrListFiles[i4].getPath() + "/";
                StringBuilder sbS = g.s(str2);
                sbS.append(fileArrListFiles[i4].getName());
                sbS.append("/");
                copyDir(str3, sbS.toString());
            } else {
                String path = fileArrListFiles[i4].getPath();
                StringBuilder sbS2 = g.s(str2);
                sbS2.append(fileArrListFiles[i4].getName());
                copyFile(path, sbS2.toString());
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005c A[Catch: Exception -> 0x0058, TRY_LEAVE, TryCatch #4 {Exception -> 0x0058, blocks: (B:41:0x0054, B:45:0x005c), top: B:53:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean copyFile(java.lang.String r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "copyFile close steam error!!"
            r1 = 0
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1f
        L12:
            int r2 = r3.read(r5)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1f
            if (r2 <= 0) goto L22
            r4.write(r5, r1, r2)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1f
            goto L12
        L1c:
            r5 = move-exception
        L1d:
            r2 = r3
            goto L52
        L1f:
            r5 = move-exception
        L20:
            r2 = r3
            goto L3a
        L22:
            r3.close()     // Catch: java.lang.Exception -> L29
            r4.close()     // Catch: java.lang.Exception -> L29
            goto L2d
        L29:
            r4 = move-exception
            com.stepos.alphame.utils.AlphaMeLogger.exceptionLog(r0, r4)
        L2d:
            r4 = 1
            return r4
        L2f:
            r5 = move-exception
            r4 = r2
            goto L1d
        L32:
            r5 = move-exception
            r4 = r2
            goto L20
        L35:
            r5 = move-exception
            r4 = r2
            goto L52
        L38:
            r5 = move-exception
            r4 = r2
        L3a:
            java.lang.String r3 = "copyFile error!!"
            com.stepos.alphame.utils.AlphaMeLogger.exceptionLog(r3, r5)     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L47
            r2.close()     // Catch: java.lang.Exception -> L45
            goto L47
        L45:
            r4 = move-exception
            goto L4d
        L47:
            if (r4 == 0) goto L50
            r4.close()     // Catch: java.lang.Exception -> L45
            goto L50
        L4d:
            com.stepos.alphame.utils.AlphaMeLogger.exceptionLog(r0, r4)
        L50:
            return r1
        L51:
            r5 = move-exception
        L52:
            if (r2 == 0) goto L5a
            r2.close()     // Catch: java.lang.Exception -> L58
            goto L5a
        L58:
            r4 = move-exception
            goto L60
        L5a:
            if (r4 == 0) goto L63
            r4.close()     // Catch: java.lang.Exception -> L58
            goto L63
        L60:
            com.stepos.alphame.utils.AlphaMeLogger.exceptionLog(r0, r4)
        L63:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.utils.FileUtil.copyFile(java.lang.String, java.lang.String):boolean");
    }

    public static boolean copyFileToDir(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        StringBuilder sbV = g.v(str2, "/");
        sbV.append(new File(str).getName());
        String string = sbV.toString();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(string);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i4 = fileInputStream2.read(bArr);
                        if (i4 <= 0) {
                            try {
                                fileInputStream2.close();
                                fileOutputStream.close();
                                return true;
                            } catch (Exception e4) {
                                AlphaMeLogger.exceptionLog("copyFile close steam error!!", e4);
                                return true;
                            }
                        }
                        fileOutputStream.write(bArr, 0, i4);
                    }
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                            AlphaMeLogger.exceptionLog("copyFile close steam error!!", e5);
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                            AlphaMeLogger.exceptionLog("copyFile close steam error!!", e6);
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Exception unused3) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static void deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static String getAssetPath(String str) {
        return g.m("file:///android_asset/", str);
    }

    public static String getCacheDir() {
        return ApplicationImpl.getApplication().getCacheDir().toString();
    }

    public static List<String> ll(File file) {
        if (!file.isDirectory()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : file.listFiles()) {
            arrayList.add(StringUtil.formatDateFull(file2.lastModified()) + "   " + file2.getName());
        }
        return arrayList;
    }

    public static boolean moveFile(String str, String str2) {
        if (!copyDir(str, str2)) {
            return false;
        }
        deleteFile(new File(str));
        return true;
    }

    public static String readRawTxtFile(Context context, int i4) throws IOException {
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i4)));
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
            } finally {
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return line;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String readTxtFile(String str) throws Throwable {
        File file = new File(str);
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        bufferedReader = null;
        if (!file.exists()) {
            return null;
        }
        String string = "";
        try {
            try {
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String line = bufferedReader3.readLine();
                            if (line == null) {
                                break;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(string);
                            sb.append(line);
                            string = sb.toString();
                            bufferedReader2 = sb;
                        } catch (IOException e4) {
                            e = e4;
                            bufferedReader = bufferedReader3;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                                bufferedReader = bufferedReader;
                            }
                            return string;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader3;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader3.close();
                    bufferedReader3.close();
                    bufferedReader = bufferedReader2;
                } catch (IOException unused2) {
                }
            } catch (IOException e5) {
                e = e5;
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void unzipAssertFile(Context context, String str, String str2) throws IOException {
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipInputStream zipInputStream = new ZipInputStream(context.getAssets().open(str));
        byte[] bArr = new byte[1048576];
        for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
            if (nextEntry.isDirectory()) {
                StringBuilder sbS = g.s(str2);
                sbS.append(File.separator);
                sbS.append(nextEntry.getName());
                new File(sbS.toString()).mkdir();
            } else {
                StringBuilder sbS2 = g.s(str2);
                sbS2.append(File.separator);
                sbS2.append(nextEntry.getName());
                File file2 = new File(sbS2.toString());
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    int i4 = zipInputStream.read(bArr);
                    if (i4 <= 0) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, i4);
                    }
                }
                fileOutputStream.close();
            }
        }
        zipInputStream.close();
    }

    public static boolean unzipFile(String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        AlphaMeLogger.dLog("unzipFile " + str + " to " + str2);
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        boolean z4 = false;
        try {
            ZipFile zipFile = new ZipFile(new File(str));
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                boolean z5 = false;
                while (enumerationEntries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        String name = zipEntryNextElement.getName();
                        String str3 = File.separator;
                        if (!name.endsWith(str3)) {
                            try {
                                InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                                try {
                                    File file2 = new File(new String((str2 + str3 + zipEntryNextElement.getName()).getBytes("8859_1"), "GB2312"));
                                    if (!file2.exists()) {
                                        File parentFile = file2.getParentFile();
                                        if (!parentFile.exists()) {
                                            parentFile.mkdirs();
                                        }
                                        file2.createNewFile();
                                    }
                                    try {
                                        fileOutputStream = new FileOutputStream(file2);
                                    } catch (Throwable th) {
                                        AlphaMeLogger.wLog("unzipFile Exception1 : " + th.getMessage());
                                    }
                                    try {
                                        byte[] bArr = new byte[1048576];
                                        while (true) {
                                            int i4 = inputStream.read(bArr);
                                            if (i4 <= 0) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, i4);
                                            AlphaMeLogger.dLog("unzipFile progress " + i4);
                                        }
                                        z5 = true;
                                        fileOutputStream.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Throwable th2) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Throwable th3) {
                                            th2.addSuppressed(th3);
                                        }
                                        throw th2;
                                    }
                                } catch (Throwable th4) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th5) {
                                            th4.addSuppressed(th5);
                                        }
                                    }
                                    throw th4;
                                }
                            } catch (Throwable th6) {
                                AlphaMeLogger.wLog("unzipFile Exception2 : " + th6.getMessage());
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        z4 = z5;
                        try {
                            zipFile.close();
                        } catch (Throwable th8) {
                            th.addSuppressed(th8);
                        }
                        throw th;
                    }
                }
                try {
                    zipFile.close();
                    return z5;
                } catch (Throwable th9) {
                    th = th9;
                    z4 = z5;
                    AlphaMeLogger.wLog("unzipFile Exception3 : " + th.getMessage());
                    return z4;
                }
            } catch (Throwable th10) {
                th = th10;
            }
        } catch (Throwable th11) {
            th = th11;
            AlphaMeLogger.wLog("unzipFile Exception3 : " + th.getMessage());
            return z4;
        }
    }

    public static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    deleteFile(file2);
                }
            }
        } else {
            file.delete();
        }
        file.delete();
    }
}
