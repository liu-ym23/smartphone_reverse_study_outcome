package com.ss.android.http.legacy.message;

import bf.a;
import com.bytedance.frameworks.baselib.network.http.util.b;
import com.ss.android.http.legacy.HeaderElement;
import com.ss.android.http.legacy.NameValuePair;
import com.ss.android.http.legacy.ParseException;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface HeaderValueParser {
    HeaderElement[] parseElements(b r10, a r11) throws ParseException;

    HeaderElement parseHeaderElement(b r10, a r11) throws ParseException;

    NameValuePair parseNameValuePair(b r10, a r11) throws ParseException;

    NameValuePair[] parseParameters(b r10, a r11) throws ParseException;
}
