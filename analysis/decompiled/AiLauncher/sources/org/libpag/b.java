package org.libpag;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes5.dex */
abstract class b {
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0069: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:29:0x0069 */
    public static byte[] a(String str) throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        InputStream inputStream2;
        byte[] bArrReadFile = PAGDiskCache.ReadFile(str);
        if (bArrReadFile != null && bArrReadFile.length > 0) {
            return bArrReadFile;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream3 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th) {
                th = th;
                inputStream3 = inputStream2;
            }
            try {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode / 100 != 2) {
                    Log.e("NetworkFetcher", "Error: HTTP response code " + responseCode);
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    httpURLConnection.disconnect();
                    return null;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i10 = inputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i10);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    PAGDiskCache.WriteFile(str, byteArray);
                    try {
                        inputStream.close();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                    httpURLConnection.disconnect();
                    return byteArray;
                } catch (IOException e13) {
                    e = e13;
                    Log.e("NetworkFetcher", "Error: " + e.getMessage());
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                            e14.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e15) {
                        e15.printStackTrace();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
            } catch (IOException e16) {
                e = e16;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
                if (httpURLConnection == null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (IOException e19) {
            e = e19;
            httpURLConnection = null;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }
}
