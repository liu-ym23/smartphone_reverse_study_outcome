package org.bouncycastle.asn1.x509;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes.dex */
public class X509NameTokenizer {
    private StringBuffer buf;
    private int index;
    private char separator;
    private String value;

    public X509NameTokenizer(String str) {
        this(str, AbstractJsonLexerKt.COMMA);
    }

    public boolean hasMoreTokens() {
        return this.index < this.value.length();
    }

    public String nextToken() {
        if (this.index >= this.value.length()) {
            return null;
        }
        int i8 = this.index + 1;
        this.buf.setLength(0);
        boolean z = false;
        boolean z2 = false;
        while (i8 != this.value.length()) {
            char cCharAt = this.value.charAt(i8);
            if (cCharAt != '\"') {
                if (!z && !z2) {
                    if (cCharAt == '\\') {
                        this.buf.append(cCharAt);
                        z = true;
                    } else {
                        if (cCharAt == this.separator) {
                            break;
                        }
                        this.buf.append(cCharAt);
                    }
                }
                i8++;
            } else if (!z) {
                z2 = !z2;
            }
            this.buf.append(cCharAt);
            z = false;
            i8++;
        }
        this.index = i8;
        return this.buf.toString();
    }

    public X509NameTokenizer(String str, char c3) {
        this.buf = new StringBuffer();
        this.value = str;
        this.index = str.length() < 1 ? 0 : -1;
        this.separator = c3;
    }
}
