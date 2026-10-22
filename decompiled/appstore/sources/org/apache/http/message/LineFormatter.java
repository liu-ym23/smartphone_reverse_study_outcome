package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public interface LineFormatter {
    CharArrayBuffer appendProtocolVersion(CharArrayBuffer r10, ProtocolVersion r11);

    CharArrayBuffer formatHeader(CharArrayBuffer r10, Header r11);

    CharArrayBuffer formatRequestLine(CharArrayBuffer r10, RequestLine r11);

    CharArrayBuffer formatStatusLine(CharArrayBuffer r10, StatusLine r11);
}
