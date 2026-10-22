package org.apache.http.impl;

import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultHttpResponseFactory implements HttpResponseFactory {
    public static final DefaultHttpResponseFactory INSTANCE = null;
    protected final ReasonPhraseCatalog reasonCatalog;

    static {
        INSTANCE = new DefaultHttpResponseFactory();
    }

    public DefaultHttpResponseFactory(ReasonPhraseCatalog r10) {
        this.reasonCatalog = (ReasonPhraseCatalog) Args.notNull(r10, "Reason phrase catalog");
    }

    public Locale determineLocale(HttpContext r10) {
        return Locale.getDefault();
    }

    @Override // org.apache.http.HttpResponseFactory
    public HttpResponse newHttpResponse(ProtocolVersion r10, int r11, HttpContext r12) {
        Args.notNull(r10, "HTTP version");
        Locale r13 = determineLocale(r12);
        return new BasicHttpResponse(new BasicStatusLine(r10, r11, this.reasonCatalog.getReason(r11, r13)), this.reasonCatalog, r13);
    }

    public DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
    }

    @Override // org.apache.http.HttpResponseFactory
    public HttpResponse newHttpResponse(StatusLine r10, HttpContext r11) {
        Args.notNull(r10, "Status line");
        return new BasicHttpResponse(r10, this.reasonCatalog, determineLocale(r11));
    }
}
