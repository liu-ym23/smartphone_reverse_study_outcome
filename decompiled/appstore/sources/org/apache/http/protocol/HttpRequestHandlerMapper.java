package org.apache.http.protocol;

import org.apache.http.HttpRequest;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpRequestHandlerMapper {
    HttpRequestHandler lookup(HttpRequest r10);
}
