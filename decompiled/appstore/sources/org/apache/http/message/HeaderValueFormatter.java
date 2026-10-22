package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public interface HeaderValueFormatter {
    CharArrayBuffer formatElements(CharArrayBuffer r10, HeaderElement[] r11, boolean r12);

    CharArrayBuffer formatHeaderElement(CharArrayBuffer r10, HeaderElement r11, boolean r12);

    CharArrayBuffer formatNameValuePair(CharArrayBuffer r10, NameValuePair r11, boolean r12);

    CharArrayBuffer formatParameters(CharArrayBuffer r10, NameValuePair[] r11, boolean r12);
}
