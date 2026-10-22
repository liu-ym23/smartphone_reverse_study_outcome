package org.apache.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpClientConnection extends HttpConnection {
    void flush() throws IOException;

    boolean isResponseAvailable(int r10) throws IOException;

    void receiveResponseEntity(HttpResponse r10) throws HttpException, IOException;

    HttpResponse receiveResponseHeader() throws HttpException, IOException;

    void sendRequestEntity(HttpEntityEnclosingRequest r10) throws HttpException, IOException;

    void sendRequestHeader(HttpRequest r10) throws HttpException, IOException;
}
