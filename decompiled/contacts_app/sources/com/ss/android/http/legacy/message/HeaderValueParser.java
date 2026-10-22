package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.ss.android.http.legacy.HeaderElement;
import com.ss.android.http.legacy.NameValuePair;
import com.ss.android.http.legacy.ParseException;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface HeaderValueParser {
    HeaderElement[] parseElements(CharArrayBuffer r1, ParserCursor r2) throws ParseException;

    HeaderElement parseHeaderElement(CharArrayBuffer r1, ParserCursor r2) throws ParseException;

    NameValuePair parseNameValuePair(CharArrayBuffer r1, ParserCursor r2) throws ParseException;

    NameValuePair[] parseParameters(CharArrayBuffer r1, ParserCursor r2) throws ParseException;
}
