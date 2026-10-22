package org.apache.http;

import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes4.dex */
public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpResponse r10, HttpContext r11);
}
