package org.apache.http;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpResponse extends HttpMessage {
    HttpEntity getEntity();

    Locale getLocale();

    StatusLine getStatusLine();

    void setEntity(HttpEntity r10);

    void setLocale(Locale r10);

    void setReasonPhrase(String r10) throws IllegalStateException;

    void setStatusCode(int r10) throws IllegalStateException;

    void setStatusLine(ProtocolVersion r10, int r11);

    void setStatusLine(ProtocolVersion r10, int r11, String r12);

    void setStatusLine(StatusLine r10);
}
