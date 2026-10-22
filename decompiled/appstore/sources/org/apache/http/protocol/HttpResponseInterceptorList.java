package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpResponseInterceptor;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface HttpResponseInterceptorList {
    void addResponseInterceptor(HttpResponseInterceptor r10);

    void addResponseInterceptor(HttpResponseInterceptor r10, int r11);

    void clearResponseInterceptors();

    HttpResponseInterceptor getResponseInterceptor(int r10);

    int getResponseInterceptorCount();

    void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> r10);

    void setInterceptors(List<?> r10);
}
