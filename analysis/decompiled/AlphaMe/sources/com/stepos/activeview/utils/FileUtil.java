package com.stepos.activeview.utils;

import B0.g;
import android.content.Context;
import android.os.Environment;
import androidx.room.AbstractC0351g;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.stepos.activeview.task.DownloadTask;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes.dex */
public class FileUtil {
    private static final String FILE_HEAD = "update_cache_";
    private static final String FILE_TAIL_JAR = ".jar";
    private static final String FILE_TAIL_TEMP = ".temp";
    private static final String LOG_TAG = "activeview.FileUtil";
    private static final String VOLLEY_DEFAULT_CACHE_DIR = "volley";

    public static void copyFile(String str, String str2) throws IOException {
        try {
            if (new File(str).exists()) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1444];
            while (true) {
                int i4 = fileInputStream.read(bArr);
                if (i4 == -1) {
                    fileInputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void copyFolder(String str, String str2) throws IOException {
        try {
            new File(str2).mkdirs();
            String[] list = new File(str).list();
            for (int i4 = 0; i4 < list.length; i4++) {
                String str3 = File.separator;
                File file = str.endsWith(str3) ? new File(str + list[i4]) : new File(str + str3 + list[i4]);
                if (file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + file.getName().toString());
                    byte[] bArr = new byte[BmLocated.HALF_LEFT_TOP];
                    while (true) {
                        int i5 = fileInputStream.read(bArr);
                        if (i5 == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i5);
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                } else if (file.isDirectory()) {
                    copyFolder(str + "/" + list[i4], str2 + "/" + list[i4]);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static int copyStream(InputStream inputStream, OutputStream outputStream) {
        return copyStream(inputStream, outputStream, null);
    }

    public static boolean deleteDirectory(String str) {
        File[] fileArrListFiles;
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = AbstractC0351g.p(str, str2);
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return false;
        }
        boolean zDeleteDirectory = true;
        for (int i4 = 0; i4 < fileArrListFiles.length; i4++) {
            if (fileArrListFiles[i4].isFile()) {
                zDeleteDirectory = deleteFile(fileArrListFiles[i4].getAbsolutePath());
                if (!zDeleteDirectory) {
                    break;
                }
            } else {
                zDeleteDirectory = deleteDirectory(fileArrListFiles[i4].getAbsolutePath());
                if (!zDeleteDirectory) {
                    break;
                }
            }
        }
        if (zDeleteDirectory) {
            return file.delete();
        }
        return false;
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String formatFileSize(long j4) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j4 < RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            return decimalFormat.format(j4) + "B";
        }
        if (j4 < 1048576) {
            return decimalFormat.format(j4 / 1024.0d) + "KB";
        }
        if (j4 < 1073741824) {
            return decimalFormat.format(j4 / 1048576.0d) + "MB";
        }
        return decimalFormat.format(j4 / 1.073741824E9d) + "G";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d A[Catch: SecurityException -> 0x001b, TRY_LEAVE, TryCatch #0 {SecurityException -> 0x001b, blocks: (B:4:0x0008, B:6:0x000e, B:9:0x0015, B:12:0x001d), top: B:21:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getActiveViewCachesDir(android.content.Context r3) {
        /*
            java.io.File r0 = r3.getExternalCacheDir()
            java.lang.String r1 = "activeview.FileUtil"
            if (r0 == 0) goto L1d
            boolean r2 = r0.canRead()     // Catch: java.lang.SecurityException -> L1b
            if (r2 == 0) goto L1d
            boolean r2 = r0.canWrite()     // Catch: java.lang.SecurityException -> L1b
            if (r2 != 0) goto L15
            goto L1d
        L15:
            java.lang.String r2 = "External storage available."
            com.stepos.activeview.utils.LogUtil.e(r1, r2)     // Catch: java.lang.SecurityException -> L1b
            goto L36
        L1b:
            r0 = move-exception
            goto L27
        L1d:
            java.lang.String r0 = "External storage does not exist"
            com.stepos.activeview.utils.LogUtil.e(r1, r0)     // Catch: java.lang.SecurityException -> L1b
            java.io.File r0 = r3.getCacheDir()     // Catch: java.lang.SecurityException -> L1b
            goto L36
        L27:
            java.io.File r3 = r3.getCacheDir()
            java.lang.String r2 = r0.getMessage()
            com.stepos.activeview.utils.LogUtil.e(r1, r2)
            r0.printStackTrace()
            r0 = r3
        L36:
            if (r0 == 0) goto L4e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = "/activecache"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            return r3
        L4e:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.utils.FileUtil.getActiveViewCachesDir(android.content.Context):java.lang.String");
    }

    private static final String getApkFileName(String str) {
        return g.n(FILE_HEAD, str, FILE_TAIL_JAR);
    }

    private static final String getCacheFileName(String str) {
        return g.n(FILE_HEAD, str, FILE_TAIL_TEMP);
    }

    private static final String getCachePath(String str) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str + "/InstallCache/";
    }

    public static String getDefaultNewActiveJarPath(Context context) {
        return context.getCacheDir() + "/NewActiveView.jar";
    }

    public static String getDirNameByFile(String str) {
        if (str == null) {
            return null;
        }
        String str2 = str.split("/")[r2.length - 1];
        LogUtil.i(LOG_TAG, "zipFileName zipFile=" + str2);
        return str2.substring(0, str2.length() - 4);
    }

    public static long getDirSize(File file) {
        long dirSize = 0;
        if (file == null || !file.isDirectory()) {
            return 0L;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                dirSize = file2.length() + dirSize;
            } else if (file2.isDirectory()) {
                dirSize = getDirSize(file2) + file2.length() + dirSize;
            }
        }
        return dirSize;
    }

    public static String getVollyCacheDir(Context context) {
        return context.getCacheDir() + "/volley";
    }

    public static String loadFile(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                File file = new File(str);
                if (file.isDirectory() || !file.exists()) {
                    LogUtil.e(LOG_TAG, "file.isDirectory()=" + file.isDirectory() + ", file.exists()=" + file.exists());
                    return null;
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    StringBuilder sb = new StringBuilder();
                    try {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line != null) {
                                    sb.append(line);
                                    sb.append("\n");
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e4) {
                                    }
                                }
                            }
                            return sb.toString();
                        } catch (IOException e5) {
                            LogUtil.e(LOG_TAG, "read file buffer error=" + e5.toString());
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                                LogUtil.e(LOG_TAG, "instream.close error=" + e6.toString());
                            }
                            return null;
                        }
                    } finally {
                        try {
                            fileInputStream.close();
                        } catch (IOException e42) {
                            LogUtil.e(LOG_TAG, "instream.close error=" + e42.toString());
                        }
                    }
                } catch (FileNotFoundException e7) {
                    LogUtil.e(LOG_TAG, "new FileInputStream error=" + e7.toString());
                    return null;
                }
            } catch (NullPointerException e8) {
                LogUtil.e(LOG_TAG, "new File error=" + e8.toString());
            }
        }
        return null;
    }

    public static final boolean renameFile(String str, String str2) {
        try {
            return new File(str).renameTo(new File(str2));
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static String unZipFromInputStream(InputStream inputStream, String str, boolean z4) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        byte[] bArr = new byte[BmLocated.ALIGN_TOP];
        String name = nextEntry.getName();
        while (nextEntry != null) {
            if (nextEntry.isDirectory()) {
                StringBuilder sbS = g.s(str);
                sbS.append(File.separator);
                sbS.append(nextEntry.getName());
                File file2 = new File(sbS.toString());
                if (z4 || !file2.exists()) {
                    file2.mkdir();
                }
            } else {
                StringBuilder sbS2 = g.s(str);
                sbS2.append(File.separator);
                sbS2.append(nextEntry.getName());
                File file3 = new File(sbS2.toString());
                if (z4 || !file3.exists()) {
                    file3.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    while (true) {
                        int i4 = zipInputStream.read(bArr);
                        if (i4 <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i4);
                    }
                    fileOutputStream.close();
                }
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        zipInputStream.close();
        return str + "/" + name;
    }

    public static int copyStream(InputStream inputStream, OutputStream outputStream, DownloadTask.DownloadProgressListener downloadProgressListener) throws IOException {
        StringBuilder sb;
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
        int i4 = 0;
        while (true) {
            try {
                try {
                    int i5 = bufferedInputStream.read(bArr, 0, 8192);
                    if (i5 == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, i5);
                    i4 += i5;
                    if (downloadProgressListener != null) {
                        downloadProgressListener.onProgress(i4);
                    }
                } finally {
                }
            } catch (IOException e4) {
                LogUtil.e(LOG_TAG, "Extracted IOException:" + e4.toString());
                try {
                    bufferedOutputStream.close();
                } catch (IOException e5) {
                    LogUtil.e(LOG_TAG, "out.close() IOException e=" + e5.toString());
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e6) {
                    e = e6;
                    sb = new StringBuilder("in.close() IOException e=");
                    sb.append(e.toString());
                    LogUtil.e(LOG_TAG, sb.toString());
                    return i4;
                }
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException e7) {
            LogUtil.e(LOG_TAG, "out.close() IOException e=" + e7.toString());
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e8) {
            e = e8;
            sb = new StringBuilder("in.close() IOException e=");
            sb.append(e.toString());
            LogUtil.e(LOG_TAG, sb.toString());
            return i4;
        }
        return i4;
    }
}
