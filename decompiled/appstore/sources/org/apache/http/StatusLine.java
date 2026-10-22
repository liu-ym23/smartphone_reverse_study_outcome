package org.apache.http;

/* JADX INFO: loaded from: classes4.dex */
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
