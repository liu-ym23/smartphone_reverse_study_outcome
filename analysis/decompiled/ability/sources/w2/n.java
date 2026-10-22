package w2;

import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class n extends b {
    public final HttpURLConnection e;

    public n(Map map, String str, boolean z10) throws ProtocolException {
        super(z10);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.e = httpURLConnection;
        D2.b.g(httpURLConnection);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + this.f6831a);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                this.e.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!z10) {
            this.c = new j(this.e.getOutputStream());
        } else {
            this.e.setRequestProperty("Content-Encoding", "gzip");
            this.d = new p(this.e.getOutputStream());
        }
    }

    @Override // w2.b
    public final String a() throws IOException {
        super.a();
        ArrayList arrayList = new ArrayList();
        HttpURLConnection httpURLConnection = this.e;
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
        return sb.toString();
    }
}
