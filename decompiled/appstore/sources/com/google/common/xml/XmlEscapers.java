package com.google.common.xml;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public class XmlEscapers {
    private static final char MAX_ASCII_CONTROL_CHAR = 31;
    private static final char MIN_ASCII_CONTROL_CHAR = 0;
    private static final Escaper XML_ATTRIBUTE_ESCAPER = null;
    private static final Escaper XML_CONTENT_ESCAPER = null;
    private static final Escaper XML_ESCAPER = null;

    static {
        Escapers.Builder r10 = Escapers.builder();
        char r11 = 0;
        r10.setSafeRange(0, 65533);
        r10.setUnsafeReplacement("�");
    L4:
        if (r11 > 31) goto L10;
        if (r11 == '\t') goto L9;
        if (r11 == '\n') goto L9;
        if (r11 == '\r') goto L9;
        r10.addEscape(r11, "�");
    L9:
        r11 = (char) (r11 + 1);
        goto L4
    L10:
        r10.addEscape('&', "&amp;");
        r10.addEscape('<', "&lt;");
        r10.addEscape('>', "&gt;");
        XML_CONTENT_ESCAPER = r10.build();
        r10.addEscape('\'', "&apos;");
        r10.addEscape(TokenParser.DQUOTE, "&quot;");
        XML_ESCAPER = r10.build();
        r10.addEscape('\t', "&#x9;");
        r10.addEscape('\n', "&#xA;");
        r10.addEscape(TokenParser.CR, "&#xD;");
        XML_ATTRIBUTE_ESCAPER = r10.build();
    }

    private XmlEscapers() {
    }

    public static Escaper xmlAttributeEscaper() {
        return XML_ATTRIBUTE_ESCAPER;
    }

    public static Escaper xmlContentEscaper() {
        return XML_CONTENT_ESCAPER;
    }
}
