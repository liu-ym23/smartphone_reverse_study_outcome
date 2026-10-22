package org.apache.http;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpRequestFactory {
    HttpRequest newHttpRequest(String r10, String r11) throws MethodNotSupportedException;

    HttpRequest newHttpRequest(RequestLine r10) throws MethodNotSupportedException;
}
