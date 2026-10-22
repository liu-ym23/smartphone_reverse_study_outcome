package com.stepos.alphame.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
public class HttpRequestHelper {
    public static boolean downloadFile(String str, String str2) throws Throwable {
        RandomAccessFile randomAccessFile;
        AlphaMeLogger.iLog("downloadFile " + str + ", to " + str2);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(30000);
            if (httpURLConnection.getContentLength() <= 0) {
                AlphaMeLogger.wLog("downloadFile error: content length <= 0");
                return false;
            }
            InputStream inputStream = null;
            try {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                try {
                    int contentLength = httpURLConnection.getContentLength();
                    int pathLastIndex = getPathLastIndex(str2);
                    if (pathLastIndex > 0) {
                        File file = new File(str2.substring(0, pathLastIndex));
                        if (!file.isDirectory()) {
                            file.mkdirs();
                        }
                    }
                    File file2 = new File(str2);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    randomAccessFile = new RandomAccessFile(file2, "rw");
                    try {
                        randomAccessFile.seek(0L);
                        byte[] bArr = new byte[1024];
                        int i4 = 0;
                        while (true) {
                            int i5 = inputStream2.read(bArr, 0, 1024);
                            if (i5 <= 0) {
                                AlphaMeLogger.wLog("downloadFile success, url = " + str);
                                Utils.closeSilently(inputStream2);
                                Utils.closeSilently(randomAccessFile);
                                httpURLConnection.disconnect();
                                return true;
                            }
                            if (Thread.interrupted()) {
                                AlphaMeLogger.wLog("downloadFile interrupted, url = " + str);
                                Utils.closeSilently(inputStream2);
                                Utils.closeSilently(randomAccessFile);
                                httpURLConnection.disconnect();
                                return false;
                            }
                            randomAccessFile.write(bArr, 0, i5);
                            i4 += i5;
                            AlphaMeLogger.dLog("downloadFile progress " + i4 + Consts.SPLITTER_DETAIL + contentLength);
                        }
                    } catch (IOException e4) {
                        e = e4;
                        inputStream = inputStream2;
                        try {
                            AlphaMeLogger.wLog("downloadFile exception: " + e.getMessage());
                            e.printStackTrace();
                            Utils.closeSilently(inputStream);
                            Utils.closeSilently(randomAccessFile);
                            httpURLConnection.disconnect();
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            Utils.closeSilently(inputStream);
                            Utils.closeSilently(randomAccessFile);
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        Utils.closeSilently(inputStream);
                        Utils.closeSilently(randomAccessFile);
                        httpURLConnection.disconnect();
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    randomAccessFile = null;
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFile = null;
                }
            } catch (IOException e6) {
                e = e6;
                randomAccessFile = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
            }
        } catch (IOException e7) {
            AlphaMeLogger.wLog("downloadFile error: " + e7.getMessage());
            e7.printStackTrace();
            return false;
        }
    }

    private static int getPathLastIndex(String str) {
        int iLastIndexOf = str.lastIndexOf(47);
        return iLastIndexOf == -1 ? str.lastIndexOf(92) : iLastIndexOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getTxt(java.lang.String r5) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "doGetTxt() Exception : "
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "getTxt "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.stepos.alphame.utils.AlphaMeLogger.iLog(r1)
            int r1 = r5.length()
            java.lang.String r2 = ""
            if (r1 <= 0) goto L63
            r1 = 0
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.net.URLConnection r5 = r3.openConnection()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            int r1 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            r3 = 200(0xc8, float:2.8E-43)
            if (r1 != r3) goto L3d
            java.io.InputStream r1 = r5.getInputStream()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            java.lang.String r2 = readStream(r1)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3b
            goto L3d
        L38:
            r0 = move-exception
            r1 = r5
            goto L5d
        L3b:
            r1 = move-exception
            goto L47
        L3d:
            r5.disconnect()
            goto L63
        L41:
            r0 = move-exception
            goto L5d
        L43:
            r5 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
        L47:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L38
            r3.append(r0)     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L38
            com.stepos.alphame.utils.AlphaMeLogger.wLog(r0)     // Catch: java.lang.Throwable -> L38
            if (r5 == 0) goto L63
            goto L3d
        L5d:
            if (r1 == 0) goto L62
            r1.disconnect()
        L62:
            throw r0
        L63:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.utils.HttpRequestHelper.getTxt(java.lang.String):java.lang.String");
    }

    public static String readStream(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return sb.toString();
                }
                sb.append(line);
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }
}
