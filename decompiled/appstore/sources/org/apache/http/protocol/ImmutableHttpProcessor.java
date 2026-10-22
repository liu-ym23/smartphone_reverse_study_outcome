package org.apache.http.protocol;

import java.io.IOException;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public final class ImmutableHttpProcessor implements HttpProcessor {
    private final HttpRequestInterceptor[] requestInterceptors;
    private final HttpResponseInterceptor[] responseInterceptors;

    public ImmutableHttpProcessor(HttpRequestInterceptor[] r10, HttpResponseInterceptor[] r11) {
        if (r10 == null) goto L5;
        int r12 = r10.length;
        HttpRequestInterceptor[] r13 = new HttpRequestInterceptor[r12];
        this.requestInterceptors = r13;
        System.arraycopy(r10, 0, r13, 0, r12);
    L6:
        if (r11 == null) goto L8;
        int r14 = r11.length;
        HttpResponseInterceptor[] r15 = new HttpResponseInterceptor[r14];
        this.responseInterceptors = r15;
        System.arraycopy(r11, 0, r15, 0, r14);
        return;
    L8:
        this.responseInterceptors = new HttpResponseInterceptor[0];
        return;
    L5:
        this.requestInterceptors = new HttpRequestInterceptor[0];
        goto L6
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest r10, HttpContext r11) throws IOException, HttpException {
        HttpRequestInterceptor[] r12 = this.requestInterceptors;
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r14].process(r10, r11);
        r14 = r14 + 1;
        goto L3
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse r10, HttpContext r11) throws IOException, HttpException {
        HttpResponseInterceptor[] r12 = this.responseInterceptors;
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r14].process(r10, r11);
        r14 = r14 + 1;
        goto L3
    }

    public ImmutableHttpProcessor(List<HttpRequestInterceptor> r10, List<HttpResponseInterceptor> r11) {
        if (r10 == null) goto L5;
        this.requestInterceptors = (HttpRequestInterceptor[]) r10.toArray(new HttpRequestInterceptor[r10.size()]);
    L6:
        if (r11 == null) goto L8;
        this.responseInterceptors = (HttpResponseInterceptor[]) r11.toArray(new HttpResponseInterceptor[r11.size()]);
        return;
    L8:
        this.responseInterceptors = new HttpResponseInterceptor[0];
        return;
    L5:
        this.requestInterceptors = new HttpRequestInterceptor[0];
        goto L6
    }

    @Deprecated
    public ImmutableHttpProcessor(HttpRequestInterceptorList r10, HttpResponseInterceptorList r11) {
        int r12 = 0;
        if (r10 == null) goto L7;
        int r13 = r10.getRequestInterceptorCount();
        this.requestInterceptors = new HttpRequestInterceptor[r13];
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L8;
        this.requestInterceptors[r14] = r10.getRequestInterceptor(r14);
        r14 = r14 + 1;
    L8:
        if (r11 == null) goto L12;
        int r15 = r11.getResponseInterceptorCount();
        this.responseInterceptors = new HttpResponseInterceptor[r15];
    L10:
        if (r12 >= r15) goto L16;
        this.responseInterceptors[r12] = r11.getResponseInterceptor(r12);
        r12 = r12 + 1;
        goto L10
    L16:
        return;
    L12:
        this.responseInterceptors = new HttpResponseInterceptor[0];
        return;
    L7:
        this.requestInterceptors = new HttpRequestInterceptor[0];
        goto L8
    }

    public ImmutableHttpProcessor(HttpRequestInterceptor... r10) {
        this(r10, null);
    }

    public ImmutableHttpProcessor(HttpResponseInterceptor... r10) {
        this(null, r10);
    }
}
