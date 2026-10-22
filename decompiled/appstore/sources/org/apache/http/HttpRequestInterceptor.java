package org.apache.http;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpRequestInterceptor {
    void process(HttpRequest r10, HttpContext r11) throws HttpException, IOException;
}
