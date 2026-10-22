package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class BasicHeader implements Header, Cloneable, Serializable {
    private static final HeaderElement[] EMPTY_HEADER_ELEMENTS = null;
    private static final long serialVersionUID = -5427236326487562174L;
    private final String name;
    private final String value;

    static {
        EMPTY_HEADER_ELEMENTS = new HeaderElement[0];
    }

    public BasicHeader(String r10, String r11) {
        this.name = (String) Args.notNull(r10, "Name");
        this.value = r11;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.http.Header
    public HeaderElement[] getElements() throws ParseException {
        if (getValue() == null) goto L7;
        return BasicHeaderValueParser.parseElements(getValue(), null);
    L7:
        return EMPTY_HEADER_ELEMENTS;
    }

    @Override // org.apache.http.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // org.apache.http.NameValuePair
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatHeader(null, this).toString();
    }
}
