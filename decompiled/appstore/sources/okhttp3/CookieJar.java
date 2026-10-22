package okhttp3;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = null;

    public static class a implements CookieJar {
        public a() {
        }

        @Override // okhttp3.CookieJar
        public List loadForRequest(HttpUrl r10) {
            return Collections.emptyList();
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(HttpUrl r10, List r11) {
        }
    }

    static {
        NO_COOKIES = new a();
    }

    List<e> loadForRequest(HttpUrl r10);

    void saveFromResponse(HttpUrl r10, List<e> r11);
}
