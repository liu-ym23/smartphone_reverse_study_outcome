package com.stepos.pps.push;

import android.util.Log;
import com.stepos.pps.push.DataSyncManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public class HttpDownloader {
    private static final String TAG = "HttpDownloader";
    String line = null;
    StringBuffer strBuffer = new StringBuffer();
    BufferedReader bufferReader = null;

    public interface IActionResult<T> {
        void onFail(String str);

        void onSuccess(T t);
    }

    public String downloadFiles(String str) throws IOException {
        InputStream inputStreamFromUrl = null;
        try {
            try {
                inputStreamFromUrl = getInputStreamFromUrl(str);
                String dataFromInputStream = getDataFromInputStream(inputStreamFromUrl);
                if (inputStreamFromUrl != null) {
                    try {
                        inputStreamFromUrl.close();
                        return dataFromInputStream;
                    } catch (Exception e) {
                        if (DataSyncManager.DEBUG) {
                            Log.i(TAG, "getInputStreamFromUrl: " + e);
                        }
                    }
                }
                return dataFromInputStream;
            } catch (Exception e2) {
                if (DataSyncManager.DEBUG) {
                    Log.d(TAG, "读取数据异常:" + e2);
                }
                if (inputStreamFromUrl != null) {
                    try {
                        inputStreamFromUrl.close();
                    } catch (Exception e3) {
                        if (DataSyncManager.DEBUG) {
                            Log.i(TAG, "getInputStreamFromUrl: " + e3);
                        }
                    }
                }
                return this.strBuffer.toString();
            }
        } catch (Throwable th) {
            if (inputStreamFromUrl != null) {
                try {
                    inputStreamFromUrl.close();
                } catch (Exception e4) {
                    if (DataSyncManager.DEBUG) {
                        Log.i(TAG, "getInputStreamFromUrl: " + e4);
                    }
                }
            }
            throw th;
        }
    }

    public String dataToString(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
            }
            if (DataSyncManager.DEBUG) {
                Log.i(TAG, "dataToString2: " + stringBuffer.length() + " " + stringBuffer.toString());
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            Log.i(TAG, "dataToString3: " + e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String downloadFile(java.lang.String r5, java.lang.String r6, boolean r7) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r0 = "HttpDownloader"
            java.lang.String r1 = "downloadFile: "
            r2 = 0
            java.io.InputStream r5 = r4.getInputStreamFromUrl(r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            com.stepos.pps.push.utils.FileUtils r3 = new com.stepos.pps.push.utils.FileUtils     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            r3.<init>()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            if (r5 == 0) goto L1a
            if (r7 == 0) goto L17
            java.lang.String r2 = r4.dataToString(r5)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            goto L1a
        L17:
            r3.writeFileFromInput(r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
        L1a:
            if (r5 == 0) goto L56
            r5.close()     // Catch: java.lang.Exception -> L20
            goto L56
        L20:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
        L26:
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            android.util.Log.i(r0, r4)
            goto L56
        L31:
            r4 = move-exception
            r2 = r5
            goto L57
        L34:
            r4 = move-exception
            goto L3a
        L36:
            r4 = move-exception
            goto L57
        L38:
            r4 = move-exception
            r5 = r2
        L3a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L31
            r6.append(r4)     // Catch: java.lang.Throwable -> L31
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L31
            android.util.Log.i(r0, r4)     // Catch: java.lang.Throwable -> L31
            if (r5 == 0) goto L56
            r5.close()     // Catch: java.lang.Exception -> L4f
            goto L56
        L4f:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
            goto L26
        L56:
            return r2
        L57:
            if (r2 == 0) goto L6d
            r2.close()     // Catch: java.lang.Exception -> L5d
            goto L6d
        L5d:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r1)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            android.util.Log.i(r0, r5)
        L6d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.push.HttpDownloader.downloadFile(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String downloadFile(java.lang.String r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r0 = "HttpDownloader"
            java.lang.String r1 = "downloadFile: "
            r2 = 0
            java.io.InputStream r5 = r4.getInputStreamFromUrl(r5)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            if (r5 == 0) goto L15
            java.lang.String r2 = r4.dataToString(r5)     // Catch: java.lang.Throwable -> L10 java.lang.Exception -> L13
            goto L15
        L10:
            r4 = move-exception
            r2 = r5
            goto L4d
        L13:
            r4 = move-exception
            goto L30
        L15:
            if (r5 == 0) goto L4c
            r5.close()     // Catch: java.lang.Exception -> L1b
            goto L4c
        L1b:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
        L21:
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            android.util.Log.i(r0, r4)
            goto L4c
        L2c:
            r4 = move-exception
            goto L4d
        L2e:
            r4 = move-exception
            r5 = r2
        L30:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L10
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L10
            r3.append(r4)     // Catch: java.lang.Throwable -> L10
            java.lang.String r4 = r3.toString()     // Catch: java.lang.Throwable -> L10
            android.util.Log.i(r0, r4)     // Catch: java.lang.Throwable -> L10
            if (r5 == 0) goto L4c
            r5.close()     // Catch: java.lang.Exception -> L45
            goto L4c
        L45:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
            goto L21
        L4c:
            return r2
        L4d:
            if (r2 == 0) goto L63
            r2.close()     // Catch: java.lang.Exception -> L53
            goto L63
        L53:
            r5 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            android.util.Log.i(r0, r5)
        L63:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.push.HttpDownloader.downloadFile(java.lang.String):java.lang.String");
    }

    public String getData(String str, Map<String, String> map, final DataSyncManager.DownloadListener downloadListener) {
        OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().build();
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        String str2 = map.get("sign");
        if (str2 == null) {
            str2 = "";
        }
        okHttpClientBuild.newCall(new Request.Builder().url(str).post(builder.build()).header("sign", str2).build()).enqueue(new Callback(this) { // from class: com.stepos.pps.push.HttpDownloader.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                downloadListener.downFailed();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    downloadListener.downSucceeded(responseBodyBody.string());
                } else {
                    downloadListener.downFailed();
                }
            }
        });
        return null;
    }

    private String getDataFromInputStream(InputStream inputStream) throws IOException {
        try {
            try {
                try {
                    this.bufferReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        String line = this.bufferReader.readLine();
                        this.line = line;
                        if (line == null) {
                            break;
                        }
                        this.strBuffer.append(this.line + '\n');
                    }
                    BufferedReader bufferedReader = this.bufferReader;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception e) {
                    if (DataSyncManager.DEBUG) {
                        Log.d(TAG, "读取数据异常:" + e);
                    }
                    BufferedReader bufferedReader2 = this.bufferReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return this.strBuffer.toString();
        } catch (Throwable th) {
            try {
                BufferedReader bufferedReader3 = this.bufferReader;
                if (bufferedReader3 != null) {
                    bufferedReader3.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            throw th;
        }
    }

    public InputStream getInputStreamFromUrl(String str) {
        try {
            return ((HttpURLConnection) new URL(str).openConnection()).getInputStream();
        } catch (Exception e) {
            if (!DataSyncManager.DEBUG) {
                return null;
            }
            Log.i(TAG, "getInputStreamFromUrl: " + e);
            return null;
        }
    }
}
