package com.stepos.activeview.download;

import android.util.Pair;
import com.stepos.activeview.task.DownloadTask;
import com.stepos.activeview.utils.Constants;
import com.stepos.activeview.utils.HttpLoadException;
import com.stepos.activeview.utils.LogUtil;
import com.stepos.activeview.utils.Utility;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes.dex */
public class HttpsRequest {
    private File mDownloadFile;
    private String mFilePath;

    public HttpsRequest(String str) {
        this.mFilePath = str;
        this.mDownloadFile = new File(this.mFilePath);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static String request(String str, List<Pair<String, String>> list) throws Throwable {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        ?? r22 = 0;
        r22 = 0;
        try {
            try {
                URL url = new URL(str);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                if (url.getProtocol().toLowerCase().equals("https")) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(DownloadHostnameVerifier.INSTANCE);
                }
                httpURLConnection.setRequestProperty("User-Agent", "STEPOS");
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                outputStream = httpURLConnection.getOutputStream();
            } catch (Throwable th) {
                th = th;
                outputStream = null;
                r22 = list;
            }
            try {
                outputStream.write(Utility.encodePostParameters(list, Constants.UTF_8_CODE));
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    throw new HttpLoadException(responseCode, "Server response code : " + responseCode);
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Constants.UTF_8_CODE));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuffer.append(line);
                    stringBuffer.append("\n");
                }
                String string = stringBuffer.toString();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                outputStream.close();
                return string;
            } catch (HttpLoadException e5) {
                throw e5;
            } catch (Exception e6) {
                e = e6;
                LogUtil.e("UrlRequest --> request Error: " + e.getMessage());
                throw new HttpLoadException(e.getMessage());
            } catch (Throwable th2) {
                th = th2;
                if (r22 != 0) {
                    try {
                        r22.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        } catch (HttpLoadException e8) {
            throw e8;
        } catch (Exception e9) {
            e = e9;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    public boolean download(String str, List<Pair<String, String>> list, DownloadTask.DownloadProgressListener downloadProgressListener) {
        try {
            return download(new URL(str), list, downloadProgressListener);
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
            return false;
        } catch (MalformedURLException e5) {
            e5.printStackTrace();
            return false;
        } catch (SocketException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0150 A[PHI: r1 r2 r5
      0x0150: PHI (r1v6 java.io.InputStream) = (r1v3 java.io.InputStream), (r1v4 java.io.InputStream), (r1v7 java.io.InputStream) binds: [B:91:0x014e, B:106:0x016d, B:119:0x0187] A[DONT_GENERATE, DONT_INLINE]
      0x0150: PHI (r2v9 java.net.HttpURLConnection) = (r2v6 java.net.HttpURLConnection), (r2v7 java.net.HttpURLConnection), (r2v10 java.net.HttpURLConnection) binds: [B:91:0x014e, B:106:0x016d, B:119:0x0187] A[DONT_GENERATE, DONT_INLINE]
      0x0150: PHI (r5v9 java.io.FileOutputStream) = (r5v6 java.io.FileOutputStream), (r5v7 java.io.FileOutputStream), (r5v10 java.io.FileOutputStream) binds: [B:91:0x014e, B:106:0x016d, B:119:0x0187] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean download(java.net.URL r9, java.util.List<android.util.Pair<java.lang.String, java.lang.String>> r10, final com.stepos.activeview.task.DownloadTask.DownloadProgressListener r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.download.HttpsRequest.download(java.net.URL, java.util.List, com.stepos.activeview.task.DownloadTask$DownloadProgressListener):boolean");
    }
}
