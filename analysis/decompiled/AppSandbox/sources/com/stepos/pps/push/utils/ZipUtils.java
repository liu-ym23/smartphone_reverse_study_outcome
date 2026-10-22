package com.stepos.pps.push.utils;

import android.util.Log;
import com.stepos.pps.push.DataSyncManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
public class ZipUtils {
    public static final String TAG = "ZIP11";

    public static void ZipFolder(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str2);
            try {
                try {
                    zipOutputStream = new ZipOutputStream(fileOutputStream);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            try {
                File file = new File(str);
                ZipFiles(file.getParent() + File.separator, file.getName(), zipOutputStream);
                try {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (Exception e3) {
                e = e3;
                zipOutputStream2 = zipOutputStream;
                if (DataSyncManager.DEBUG) {
                    Log.i(TAG, "ZipFolder: " + e);
                }
                if (zipOutputStream2 != null) {
                    try {
                        zipOutputStream2.finish();
                        zipOutputStream2.close();
                    } catch (Exception unused2) {
                    }
                }
                if (fileOutputStream == null) {
                    return;
                }
                fileOutputStream.close();
            } catch (Throwable th3) {
                th = th3;
                zipOutputStream2 = zipOutputStream;
                if (zipOutputStream2 != null) {
                    try {
                        zipOutputStream2.finish();
                        zipOutputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (Exception unused4) {
                        throw th;
                    }
                }
                throw th;
            }
            fileOutputStream.close();
        } catch (Exception unused5) {
        }
    }

    private static void ZipFiles(String str, String str2, ZipOutputStream zipOutputStream) throws Throwable {
        if (zipOutputStream == null) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    File file = new File(str + str2);
                    if (file.isFile()) {
                        ZipEntry zipEntry = new ZipEntry(str2);
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            zipOutputStream.putNextEntry(zipEntry);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i = fileInputStream2.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    zipOutputStream.write(bArr, 0, i);
                                }
                            }
                            zipOutputStream.closeEntry();
                            fileInputStream = fileInputStream2;
                        } catch (Exception e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            if (DataSyncManager.DEBUG) {
                                Log.i(TAG, "ZipFiles: " + e);
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        String[] list = file.list();
                        if (list == null || list.length <= 0) {
                            zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                            zipOutputStream.closeEntry();
                        }
                        for (int i2 = 0; list != null && i2 < list.length; i2++) {
                            ZipFiles(str, str2 + File.separator + list[i2], zipOutputStream);
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.InputStream UpZip(java.lang.String r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "UpZip: "
            r1 = 0
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            java.util.zip.ZipEntry r4 = r2.getEntry(r5)     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L3a
            java.io.InputStream r1 = r2.getInputStream(r4)     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L3a
            r2.close()     // Catch: java.lang.Exception -> L39
            if (r1 == 0) goto L39
            r1.close()     // Catch: java.lang.Exception -> L39
            goto L39
        L19:
            r4 = move-exception
            goto L1f
        L1b:
            r4 = move-exception
            goto L3c
        L1d:
            r4 = move-exception
            r2 = r1
        L1f:
            boolean r5 = com.stepos.pps.push.DataSyncManager.DEBUG     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L34
            java.lang.String r5 = "ZIP11"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L3a
            r3.append(r4)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = r3.toString()     // Catch: java.lang.Throwable -> L3a
            android.util.Log.i(r5, r4)     // Catch: java.lang.Throwable -> L3a
        L34:
            if (r2 == 0) goto L39
            r2.close()     // Catch: java.lang.Exception -> L39
        L39:
            return r1
        L3a:
            r4 = move-exception
            r1 = r2
        L3c:
            if (r1 == 0) goto L41
            r1.close()     // Catch: java.lang.Exception -> L41
        L41:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.push.utils.ZipUtils.UpZip(java.lang.String, java.lang.String):java.io.InputStream");
    }

    public static String UpZipStr(String str, String str2) throws Exception {
        InputStream inputStreamUpZip = UpZip(str, str2);
        if (inputStreamUpZip != null) {
            return convertStreamToString(inputStreamUpZip);
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0086 A[Catch: Exception -> 0x0089, TRY_LEAVE, TryCatch #4 {Exception -> 0x0089, blocks: (B:42:0x0081, B:44:0x0086), top: B:49:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<java.io.File> GetFileList(java.lang.String r5, boolean r6, boolean r7) throws java.lang.Throwable {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.util.zip.ZipInputStream r5 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
        L10:
            java.util.zip.ZipEntry r1 = r5.getNextEntry()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            if (r1 == 0) goto L41
            java.lang.String r3 = r1.getName()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            boolean r1 = r1.isDirectory()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            if (r1 == 0) goto L36
            int r1 = r3.length()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            int r1 = r1 + (-1)
            r4 = 0
            java.lang.String r1 = r3.substring(r4, r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            if (r6 == 0) goto L10
            r0.add(r3)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            goto L10
        L36:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            if (r7 == 0) goto L10
            r0.add(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            goto L10
        L41:
            r2.close()     // Catch: java.lang.Exception -> L7d
            r5.close()     // Catch: java.lang.Exception -> L7d
            return r0
        L48:
            r6 = move-exception
            goto L4e
        L4a:
            r6 = move-exception
            goto L52
        L4c:
            r6 = move-exception
            r5 = r1
        L4e:
            r1 = r2
            goto L7f
        L50:
            r6 = move-exception
            r5 = r1
        L52:
            r1 = r2
            goto L59
        L54:
            r6 = move-exception
            r5 = r1
            goto L7f
        L57:
            r6 = move-exception
            r5 = r1
        L59:
            boolean r7 = com.stepos.pps.push.DataSyncManager.DEBUG     // Catch: java.lang.Throwable -> L7e
            if (r7 == 0) goto L73
            java.lang.String r7 = "ZIP11"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e
            r2.<init>()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = "GetFileList: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L7e
            r2.append(r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L7e
            android.util.Log.i(r7, r6)     // Catch: java.lang.Throwable -> L7e
        L73:
            if (r1 == 0) goto L78
            r1.close()     // Catch: java.lang.Exception -> L7d
        L78:
            if (r5 == 0) goto L7d
            r5.close()     // Catch: java.lang.Exception -> L7d
        L7d:
            return r0
        L7e:
            r6 = move-exception
        L7f:
            if (r1 == 0) goto L84
            r1.close()     // Catch: java.lang.Exception -> L89
        L84:
            if (r5 == 0) goto L89
            r5.close()     // Catch: java.lang.Exception -> L89
        L89:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.push.utils.ZipUtils.GetFileList(java.lang.String, boolean, boolean):java.util.List");
    }

    public static String convertStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line + "\n");
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    inputStream.close();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        inputStream.close();
        return sb.toString();
    }
}
