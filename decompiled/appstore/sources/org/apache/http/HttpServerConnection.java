package org.apache.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpServerConnection extends HttpConnection {
    void flush() throws IOException;

    void receiveRequestEntity(HttpEntityEnclosingRequest r10) throws HttpException, IOException;

    HttpRequest receiveRequestHeader() throws HttpException, IOException;

    void sendResponseEntity(HttpResponse r10) throws HttpException, IOException;

    void sendResponseHeader(HttpResponse r10) throws HttpException, IOException;
}
