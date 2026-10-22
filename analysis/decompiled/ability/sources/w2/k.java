package w2;

import androidx.compose.runtime.ComposerKt;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public final class k implements f2.a {
    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    M0.i.i(byteArrayOutputStream);
                }
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    @Override // f2.a
    public final f2.b c(String str, byte[] bArr, Map map) {
        Throwable th;
        InputStream inputStream;
        GZIPInputStream gZIPInputStream;
        Throwable th2;
        byte[] bArrA;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                D2.b.g(httpURLConnection2);
                httpURLConnection2.setDoOutput(true);
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                httpURLConnection2.setRequestMethod("POST");
                if (bArr != null && bArr.length > 0) {
                    try {
                        dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                            M0.i.i(dataOutputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            M0.i.i(dataOutputStream);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        dataOutputStream = null;
                    }
                }
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    f2.b bVar = new f2.b(ComposerKt.referenceKey, ("http response code " + responseCode).getBytes());
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused) {
                    }
                    return bVar;
                }
                inputStream = httpURLConnection2.getInputStream();
                try {
                    if ("gzip".equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                        try {
                            gZIPInputStream = new GZIPInputStream(inputStream);
                        } catch (Throwable th5) {
                            gZIPInputStream = null;
                            th2 = th5;
                        }
                        try {
                            bArrA = a(gZIPInputStream);
                            M0.i.i(gZIPInputStream);
                        } catch (Throwable th6) {
                            th2 = th6;
                            M0.i.i(gZIPInputStream);
                            throw th2;
                        }
                    } else {
                        bArrA = a(inputStream);
                    }
                    f2.b bVar2 = new f2.b(200, bArrA);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused2) {
                    }
                    M0.i.i(inputStream);
                    return bVar2;
                } catch (Throwable th7) {
                    th = th7;
                    httpURLConnection = httpURLConnection2;
                    try {
                        S0.b.R(th);
                        return new f2.b(ComposerKt.reuseKey, ("http response " + th.getMessage()).getBytes());
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused3) {
                            }
                        }
                        M0.i.i(inputStream);
                    }
                }
            } catch (Throwable th8) {
                inputStream = null;
                httpURLConnection = httpURLConnection2;
                th = th8;
            }
        } catch (Throwable th9) {
            th = th9;
            inputStream = null;
        }
    }
}
