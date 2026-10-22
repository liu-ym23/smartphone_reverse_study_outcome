package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public interface HeaderValueParser {
    HeaderElement[] parseElements(CharArrayBuffer r10, ParserCursor r11) throws ParseException;

    HeaderElement parseHeaderElement(CharArrayBuffer r10, ParserCursor r11) throws ParseException;

    NameValuePair parseNameValuePair(CharArrayBuffer r10, ParserCursor r11) throws ParseException;

    NameValuePair[] parseParameters(CharArrayBuffer r10, ParserCursor r11) throws ParseException;
}
