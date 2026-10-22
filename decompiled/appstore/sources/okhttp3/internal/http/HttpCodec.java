package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Sink;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    Sink createRequestBody(Request r10, long r11);

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    ResponseBody openResponseBody(Response r10) throws IOException;

    Response.Builder readResponseHeaders(boolean r10) throws IOException;

    void writeRequestHeaders(Request r10) throws IOException;
}
