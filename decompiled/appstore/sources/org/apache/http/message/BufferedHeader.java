package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class BufferedHeader implements FormattedHeader, Cloneable, Serializable {
    private static final long serialVersionUID = -2768352615787625448L;
    private final CharArrayBuffer buffer;
    private final String name;
    private final int valuePos;

    public BufferedHeader(CharArrayBuffer r10) throws ParseException {
        Args.notNull(r10, "Char array buffer");
        int r11 = r10.indexOf(58);
        if (r11 == (-1)) goto L11;
        String r12 = r10.substringTrimmed(0, r11);
        if (r12.isEmpty() == true) goto L9;
        this.buffer = r10;
        this.name = r12;
        this.valuePos = r11 + 1;
        return;
    L9:
        throw new ParseException("Invalid header: " + r10.toString());
    L11:
        throw new ParseException("Invalid header: " + r10.toString());
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.http.FormattedHeader
    public CharArrayBuffer getBuffer() {
        return this.buffer;
    }

    @Override // org.apache.http.Header
    public HeaderElement[] getElements() throws ParseException {
        ParserCursor r10 = new ParserCursor(0, this.buffer.length());
        r10.updatePos(this.valuePos);
        return BasicHeaderValueParser.INSTANCE.parseElements(this.buffer, r10);
    }

    @Override // org.apache.http.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // org.apache.http.NameValuePair
    public String getValue() {
        CharArrayBuffer r10 = this.buffer;
        return r10.substringTrimmed(this.valuePos, r10.length());
    }

    @Override // org.apache.http.FormattedHeader
    public int getValuePos() {
        return this.valuePos;
    }

    public String toString() {
        return this.buffer.toString();
    }
}
