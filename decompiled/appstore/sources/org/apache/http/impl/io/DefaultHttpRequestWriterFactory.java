package org.apache.http.impl.io;

import org.apache.http.HttpRequest;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineFormatter;
import org.apache.http.message.LineFormatter;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultHttpRequestWriterFactory implements HttpMessageWriterFactory<HttpRequest> {
    public static final DefaultHttpRequestWriterFactory INSTANCE = null;
    private final LineFormatter lineFormatter;

    static {
        INSTANCE = new DefaultHttpRequestWriterFactory();
    }

    public DefaultHttpRequestWriterFactory(LineFormatter r10) {
        if (r10 != null) goto L6;
        r10 = BasicLineFormatter.INSTANCE;
    L6:
        this.lineFormatter = r10;
    }

    @Override // org.apache.http.io.HttpMessageWriterFactory
    public HttpMessageWriter<HttpRequest> create(SessionOutputBuffer r10) {
        return new DefaultHttpRequestWriter(r10, this.lineFormatter);
    }

    public DefaultHttpRequestWriterFactory() {
        this(null);
    }
}
