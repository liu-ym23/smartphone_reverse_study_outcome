package u0;

import H.h;
import android.text.TextUtils;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* renamed from: u0.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2030b extends AbstractC2029a {
    public final HttpURLConnection f;

    public C2030b(String str, String str2, Map map, boolean z10) throws ProtocolException {
        super(str2, z10);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f = httpURLConnection;
        D2.b.g(httpURLConnection);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + this.f6685a);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                this.f.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        HttpURLConnection httpURLConnection2 = this.f;
        if (httpURLConnection2 != null && !TextUtils.isEmpty(h.f718w)) {
            httpURLConnection2.setRequestProperty("aid", h.a());
            httpURLConnection2.setRequestProperty("x-auth-token", h.f718w);
        }
        if (!z10) {
            this.d = new DataOutputStream(this.f.getOutputStream());
        } else {
            this.f.setRequestProperty("Content-Encoding", "gzip");
            this.e = new GZIPOutputStream(this.f.getOutputStream());
        }
    }

    @Override // u0.AbstractC2029a, B.e
    public final B.b a() throws IOException {
        super.a();
        ArrayList arrayList = new ArrayList();
        HttpURLConnection httpURLConnection = this.f;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException(B7.a.h(responseCode, "Server returned non-OK status: "));
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            arrayList.add(line);
        }
        bufferedReader.close();
        httpURLConnection.disconnect();
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        return new B.b(responseCode, sb.toString().getBytes());
    }
}
