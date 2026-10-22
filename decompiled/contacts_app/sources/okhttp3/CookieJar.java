package okhttp3;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = null;

    List<Cookie> loadForRequest(HttpUrl r1);

    void saveFromResponse(HttpUrl r1, List<Cookie> r2);

    static {
        NO_COOKIES = new AnonymousClass1();
    }
}
