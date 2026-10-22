package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

/* JADX INFO: loaded from: classes4.dex */
public class BasicHeaderElement implements HeaderElement, Cloneable {
    private final String name;
    private final NameValuePair[] parameters;
    private final String value;

    public BasicHeaderElement(String r10, String r11, NameValuePair[] r12) {
        this.name = (String) Args.notNull(r10, "Name");
        this.value = r11;
        if (r12 == null) goto L5;
        this.parameters = r12;
        return;
    L5:
        this.parameters = new NameValuePair[0];
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof HeaderElement) == false) goto L16;
        BasicHeaderElement r11 = (BasicHeaderElement) r10;
        if (this.name.equals(r11.name) == false) goto L15;
        if (LangUtils.equals(this.value, r11.value) == false) goto L15;
        if (LangUtils.equals(this.parameters, r11.parameters) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // org.apache.http.HeaderElement
    public String getName() {
        return this.name;
    }

    @Override // org.apache.http.HeaderElement
    public NameValuePair getParameter(int r10) {
        return this.parameters[r10];
    }

    @Override // org.apache.http.HeaderElement
    public NameValuePair getParameterByName(String r10) {
        Args.notNull(r10, "Name");
        NameValuePair[] r11 = this.parameters;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        NameValuePair r14 = r11[r13];
        if (r14.getName().equalsIgnoreCase(r10) == true) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return r14;
    L8:
        return null;
    }

    @Override // org.apache.http.HeaderElement
    public int getParameterCount() {
        return this.parameters.length;
    }

    @Override // org.apache.http.HeaderElement
    public NameValuePair[] getParameters() {
        return (NameValuePair[]) this.parameters.clone();
    }

    @Override // org.apache.http.HeaderElement
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int r10 = LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
        NameValuePair[] r11 = this.parameters;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10 = LangUtils.hashCode(r10, r11[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.name);
        if (this.value == null) goto L5;
        r10.append("=");
        r10.append(this.value);
    L5:
        NameValuePair[] r11 = this.parameters;
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L9;
        NameValuePair r14 = r11[r13];
        r10.append("; ");
        r10.append(r14);
        r13 = r13 + 1;
        goto L6
    L9:
        return r10.toString();
    }

    public BasicHeaderElement(String r10, String r11) {
        this(r10, r11, null);
    }
}
