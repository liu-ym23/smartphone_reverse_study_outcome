package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpRequestHandler {
    void handle(HttpRequest r10, HttpResponse r11, HttpContext r12) throws HttpException, IOException;
}
