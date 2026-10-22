package ac2;

import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.ugc.live.sdk.msg.network.HttpMethod;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HttpMethod f2652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<String, String> f2654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<String, String> f2655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap<String, String> f2656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.network.b f2657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.network.n f2658h;

    public w() {
        this.f2651a = "";
        this.f2654d = new LinkedHashMap();
        this.f2655e = new LinkedHashMap();
        this.f2656f = new LinkedHashMap();
    }

    public final String d(String r100) {
        String r101 = this.f2651a;
        if (r101 == null) goto L10;
        if (r101.startsWith("http://") == true) goto L11;
        if (this.f2651a.startsWith("https://") == false) goto L10;
    L11:
        return this.f2651a;
    L10:
        return UriProtector.parse(r100).buildUpon().encodedPath(this.f2651a).build().toString();
    }

    public final void b(String r100, String r101) {
        this.f2654d.put(r100, r101);
    }

    public final void a(String r100, String r101, boolean r102) {
        if (r100 == null) goto L19;
        if (r102 == true) goto L20;
    L8:
        if (r102 == false) goto L10;
        r101 = URLEncoder.encode(r101, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L10:
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.isEmpty() == true) goto L22;
        this.f2656f.put(r100, r101);     // Catch: UnsupportedEncodingException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r100 + "\" value to UTF-8: " + r101, e);
    L22:
        return;
    L20:
        r100 = URLEncoder.encode(r100, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
        goto L8
    L19:
        throw new IllegalArgumentException("field param name must not be null.");
    }

    public final void c(String r100, String r101, boolean r102) {
        if (r100 == null) goto L19;
        if (r102 == true) goto L20;
    L8:
        if (r102 == false) goto L10;
        r101 = URLEncoder.encode(r101, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L10:
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.isEmpty() == true) goto L22;
        this.f2655e.put(r100, r101);     // Catch: UnsupportedEncodingException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r100 + "\" value to UTF-8: " + r101, e);
    L22:
        return;
    L20:
        r100 = URLEncoder.encode(r100, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
        goto L8
    L19:
        throw new IllegalArgumentException("Query param name must not be null.");
    }
}
