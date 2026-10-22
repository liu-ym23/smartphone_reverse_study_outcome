package org.apache.http.protocol;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpContext {
    public static final String RESERVED_PREFIX = "http.";

    Object getAttribute(String r10);

    Object removeAttribute(String r10);

    void setAttribute(String r10, Object r11);
}
