package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public interface LineParser {
    boolean hasProtocolVersion(CharArrayBuffer r10, ParserCursor r11);

    Header parseHeader(CharArrayBuffer r10) throws ParseException;

    ProtocolVersion parseProtocolVersion(CharArrayBuffer r10, ParserCursor r11) throws ParseException;

    RequestLine parseRequestLine(CharArrayBuffer r10, ParserCursor r11) throws ParseException;

    StatusLine parseStatusLine(CharArrayBuffer r10, ParserCursor r11) throws ParseException;
}
