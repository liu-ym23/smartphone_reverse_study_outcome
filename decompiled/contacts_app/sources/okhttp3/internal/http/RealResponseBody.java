package okhttp3.internal.http;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes5.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;

    @Nullable
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(@Nullable String r1, long r2, BufferedSource r4) {
        this.contentTypeString = r1;
        this.contentLength = r2;
        this.source = r4;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        String r0 = this.contentTypeString;
        if (r0 != null) goto L7;
        return null;
    L7:
        return MediaType.parse(r0);
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        return this.source;
    }
}
