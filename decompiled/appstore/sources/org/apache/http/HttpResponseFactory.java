package org.apache.http;

import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpResponseFactory {
    HttpResponse newHttpResponse(ProtocolVersion r10, int r11, HttpContext r12);

    HttpResponse newHttpResponse(StatusLine r10, HttpContext r11);
}
