package org.apache.http;

/* JADX INFO: loaded from: classes4.dex */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
