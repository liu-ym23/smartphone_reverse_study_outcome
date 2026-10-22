package com.jeffmony.async.http;

import com.jeffmony.async.AsyncSocket;
import com.jeffmony.async.DataEmitter;
import com.jeffmony.async.DataSink;
import com.jeffmony.async.future.Cancellable;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncHttpClientMiddleware {

    public interface ResponseHead {
        int code();

        ResponseHead code(int r10);

        DataEmitter emitter();

        ResponseHead emitter(DataEmitter r10);

        ResponseHead headers(Headers r10);

        Headers headers();

        ResponseHead message(String r10);

        String message();

        ResponseHead protocol(String r10);

        String protocol();

        DataSink sink();

        ResponseHead sink(DataSink r10);

        AsyncSocket socket();
    }

    public static class a extends e {
    }

    public static class b extends d {
    }

    public static class c extends a {
    }

    public static class d extends f {
    }

    public static class e {
    }

    public static class f extends c {
    }

    public static class g extends h {
    }

    public static class h extends b {
    }

    boolean exchangeHeaders(c r10);

    Cancellable getSocket(a r10);

    void onBodyDecoder(b r10);

    void onHeadersReceived(d r10);

    void onRequest(e r10);

    void onRequestSent(f r10);

    void onResponseComplete(g r10);

    com.jeffmony.async.http.a onResponseReady(h r10);
}
