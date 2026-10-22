package okhttp3.internal.cache;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public interface InternalCache {
    Response get(Request r10) throws IOException;

    CacheRequest put(Response r10) throws IOException;

    void remove(Request r10) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(CacheStrategy r10);

    void update(Response r10, Response r11);
}
