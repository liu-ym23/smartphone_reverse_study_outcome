package org.apache.http.impl.io;

import org.apache.http.HttpResponse;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineFormatter;
import org.apache.http.message.LineFormatter;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultHttpResponseWriterFactory implements HttpMessageWriterFactory<HttpResponse> {
    public static final DefaultHttpResponseWriterFactory INSTANCE = null;
    private final LineFormatter lineFormatter;

    static {
        INSTANCE = new DefaultHttpResponseWriterFactory();
    }

    public DefaultHttpResponseWriterFactory(LineFormatter r10) {
        if (r10 != null) goto L6;
        r10 = BasicLineFormatter.INSTANCE;
    L6:
        this.lineFormatter = r10;
    }

    @Override // org.apache.http.io.HttpMessageWriterFactory
    public HttpMessageWriter<HttpResponse> create(SessionOutputBuffer r10) {
        return new DefaultHttpResponseWriter(r10, this.lineFormatter);
    }

    public DefaultHttpResponseWriterFactory() {
        this(null);
    }
}
