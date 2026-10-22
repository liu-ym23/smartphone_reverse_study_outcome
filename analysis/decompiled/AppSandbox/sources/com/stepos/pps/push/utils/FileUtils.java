package com.stepos.pps.push.utils;

import android.util.Log;
import com.stepos.pps.PPSApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class FileUtils {
    public static final String OUTFILENAME = "wechatspeed.dat";
    public static final String TAG = "DataSyncManager";
    private String mCacheRoot = PPSApplication.getInstance().getCacheDir().getAbsolutePath();

    public File createFileInCache(String str) throws IOException {
        File file = new File(this.mCacheRoot + File.separator + str);
        file.createNewFile();
        return file;
    }

    public File createCacheDir() throws IOException {
        File file = new File(this.mCacheRoot);
        file.mkdir();
        return file;
    }

    public boolean isFileExist(String str) {
        return new File(this.mCacheRoot + File.separator + str).exists();
    }

    public void writeFileFromInput(InputStream inputStream, String str) throws Throwable {
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(str + File.separator + OUTFILENAME);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder("writeFileFromInput: ");
                        sb.append(e);
                        Log.i(TAG, sb.toString());
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.i(TAG, "writeFileFromInput: " + e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e4) {
                    e = e4;
                    sb = new StringBuilder("writeFileFromInput: ");
                    sb.append(e);
                    Log.i(TAG, sb.toString());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e5) {
                    Log.i(TAG, "writeFileFromInput: " + e5);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0028 A[PHI: r4 r5
      0x0028: PHI (r4v5 java.io.File) = (r4v4 java.io.File), (r4v7 java.io.File) binds: [B:35:0x005d, B:15:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x0028: PHI (r5v7 'e' java.lang.Exception) = (r5v4 'e' java.lang.Exception), (r5v10 'e' java.lang.Exception) binds: [B:35:0x005d, B:15:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.File writeCacheFromInput(java.lang.String r5, java.io.InputStream r6) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r0 = "DataSyncManager"
            r1 = 0
            java.io.File r4 = r4.createFileInCache(r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L38
            r5.<init>(r4)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L38
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
        L10:
            int r2 = r6.read(r1)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r3 = -1
            if (r2 == r3) goto L1c
            r3 = 0
            r5.write(r1, r3, r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            goto L10
        L1c:
            r5.flush()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            r5.close()     // Catch: java.lang.Exception -> L23
            goto L60
        L23:
            r5 = move-exception
            boolean r6 = com.stepos.pps.push.DataSyncManager.DEBUG
            if (r6 == 0) goto L60
        L28:
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r0, r5)
            goto L60
        L30:
            r4 = move-exception
            r1 = r5
            goto L61
        L33:
            r6 = move-exception
            r1 = r5
            goto L3c
        L36:
            r6 = move-exception
            goto L3c
        L38:
            r4 = move-exception
            goto L61
        L3a:
            r6 = move-exception
            r4 = r1
        L3c:
            boolean r5 = com.stepos.pps.push.DataSyncManager.DEBUG     // Catch: java.lang.Throwable -> L38
            if (r5 == 0) goto L54
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r5.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = "写数据异常："
            r5.append(r2)     // Catch: java.lang.Throwable -> L38
            r5.append(r6)     // Catch: java.lang.Throwable -> L38
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L38
            android.util.Log.d(r0, r5)     // Catch: java.lang.Throwable -> L38
        L54:
            if (r1 == 0) goto L60
            r1.close()     // Catch: java.lang.Exception -> L5a
            goto L60
        L5a:
            r5 = move-exception
            boolean r6 = com.stepos.pps.push.DataSyncManager.DEBUG
            if (r6 == 0) goto L60
            goto L28
        L60:
            return r4
        L61:
            if (r1 == 0) goto L73
            r1.close()     // Catch: java.lang.Exception -> L67
            goto L73
        L67:
            r5 = move-exception
            boolean r6 = com.stepos.pps.push.DataSyncManager.DEBUG
            if (r6 == 0) goto L73
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r0, r5)
        L73:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.push.utils.FileUtils.writeCacheFromInput(java.lang.String, java.io.InputStream):java.io.File");
    }
}
