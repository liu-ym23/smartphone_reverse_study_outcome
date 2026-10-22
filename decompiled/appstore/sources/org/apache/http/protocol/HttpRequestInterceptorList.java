package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpRequestInterceptor;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface HttpRequestInterceptorList {
    void addRequestInterceptor(HttpRequestInterceptor r10);

    void addRequestInterceptor(HttpRequestInterceptor r10, int r11);

    void clearRequestInterceptors();

    HttpRequestInterceptor getRequestInterceptor(int r10);

    int getRequestInterceptorCount();

    void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> r10);

    void setInterceptors(List<?> r10);
}
