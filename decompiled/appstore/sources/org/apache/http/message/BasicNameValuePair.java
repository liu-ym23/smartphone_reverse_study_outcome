package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class BasicNameValuePair implements NameValuePair, Cloneable, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public BasicNameValuePair(String r10, String r11) {
        this.name = (String) Args.notNull(r10, "Name");
        this.value = r11;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof NameValuePair) == false) goto L14;
        BasicNameValuePair r11 = (BasicNameValuePair) r10;
        if (this.name.equals(r11.name) == false) goto L13;
        if (LangUtils.equals(this.value, r11.value) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // org.apache.http.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // org.apache.http.NameValuePair
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
    }

    public String toString() {
        if (this.value == null) goto L5;
        StringBuilder r10 = new StringBuilder((this.name.length() + 1) + this.value.length());
        r10.append(this.name);
        r10.append("=");
        r10.append(this.value);
        return r10.toString();
    L5:
        return this.name;
    }
}
