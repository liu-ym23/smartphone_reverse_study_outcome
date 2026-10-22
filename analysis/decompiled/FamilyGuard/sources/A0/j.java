package A0;

import A0.d;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import z0.C1339e;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public class j implements d<InputStream> {

    /* renamed from: g, reason: collision with root package name */
    static final b f15g = new a();

    /* renamed from: a, reason: collision with root package name */
    private final H0.g f16a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17b;

    /* renamed from: c, reason: collision with root package name */
    private final b f18c;

    /* renamed from: d, reason: collision with root package name */
    private HttpURLConnection f19d;

    /* renamed from: e, reason: collision with root package name */
    private InputStream f20e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f21f;

    private static class a implements b {
        a() {
        }

        @Override // A0.j.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface b {
        HttpURLConnection a(URL url);
    }

    public j(H0.g gVar, int i5) {
        this(gVar, i5, f15g);
    }

    private InputStream c(HttpURLConnection httpURLConnection) {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f20e = X0.c.c(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f20e = httpURLConnection.getInputStream();
        }
        return this.f20e;
    }

    private static boolean f(int i5) {
        return i5 / 100 == 2;
    }

    private static boolean g(int i5) {
        return i5 / 100 == 3;
    }

    private InputStream h(URL url, int i5, URL url2, Map<String, String> map) throws IOException {
        if (i5 >= 5) {
            throw new C1339e("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new C1339e("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.f19d = this.f18c.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f19d.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.f19d.setConnectTimeout(this.f17b);
        this.f19d.setReadTimeout(this.f17b);
        this.f19d.setUseCaches(false);
        this.f19d.setDoInput(true);
        this.f19d.setInstanceFollowRedirects(false);
        this.f19d.connect();
        this.f20e = this.f19d.getInputStream();
        if (this.f21f) {
            return null;
        }
        int responseCode = this.f19d.getResponseCode();
        if (f(responseCode)) {
            return c(this.f19d);
        }
        if (!g(responseCode)) {
            if (responseCode == -1) {
                throw new C1339e(responseCode);
            }
            throw new C1339e(this.f19d.getResponseMessage(), responseCode);
        }
        String headerField = this.f19d.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            throw new C1339e("Received empty or null redirect url");
        }
        URL url3 = new URL(url, headerField);
        b();
        return h(url3, i5 + 1, url, map);
    }

    @Override // A0.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // A0.d
    public void b() throws IOException {
        InputStream inputStream = this.f20e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f19d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f19d = null;
    }

    @Override // A0.d
    public void cancel() {
        this.f21f = true;
    }

    @Override // A0.d
    public EnumC1335a d() {
        return EnumC1335a.REMOTE;
    }

    @Override // A0.d
    public void e(v0.g gVar, d.a<? super InputStream> aVar) {
        long jB = X0.f.b();
        try {
            try {
                aVar.f(h(this.f16a.i(), 0, null, this.f16a.e()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + X0.f.a(jB));
                }
            } catch (IOException e6) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e6);
                }
                aVar.c(e6);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + X0.f.a(jB));
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + X0.f.a(jB));
            }
            throw th;
        }
    }

    j(H0.g gVar, int i5, b bVar) {
        this.f16a = gVar;
        this.f17b = i5;
        this.f18c = bVar;
    }
}
