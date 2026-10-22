package com.jeffmony.async.http;

/* JADX INFO: loaded from: classes3.dex */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
