package org.apache.http.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class HeaderGroup implements Cloneable, Serializable {
    private static final long serialVersionUID = 2608834160639271617L;
    private final Header[] EMPTY;
    private final List<Header> headers;

    public HeaderGroup() {
        this.EMPTY = new Header[0];
        this.headers = new ArrayList(16);
    }

    public void addHeader(Header r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.headers.add(r10);
    }

    public void clear() {
        this.headers.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean containsHeader(String r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.headers.size()) goto L10;
        if (this.headers.get(r11).getName().equalsIgnoreCase(r10) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public HeaderGroup copy() {
        HeaderGroup r10 = new HeaderGroup();
        r10.headers.addAll(this.headers);
        return r10;
    }

    public Header[] getAllHeaders() {
        List<Header> r10 = this.headers;
        return (Header[]) r10.toArray(new Header[r10.size()]);
    }

    public Header getCondensedHeader(String r10) {
        Header[] r11 = getHeaders(r10);
        if (r11.length != 0) goto L6;
        return null;
    L6:
        int r12 = 1;
        if (r11.length == 1) goto L9;
        CharArrayBuffer r13 = new CharArrayBuffer(128);
        r13.append(r11[0].getValue());
    L12:
        if (r12 >= r11.length) goto L15;
        r13.append(", ");
        r13.append(r11[r12].getValue());
        r12 = r12 + 1;
        goto L12
    L15:
        return new BasicHeader(r10.toLowerCase(Locale.ROOT), r13.toString());
    L9:
        return r11[0];
    }

    public Header getFirstHeader(String r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.headers.size()) goto L9;
        Header r12 = this.headers.get(r11);
        if (r12.getName().equalsIgnoreCase(r10) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r12;
    L9:
        return null;
    }

    public Header[] getHeaders(String r10) {
        ArrayList r11 = null;
        int r12 = 0;
    L4:
        if (r12 >= this.headers.size()) goto L11;
        Header r13 = this.headers.get(r12);
        if (r13.getName().equalsIgnoreCase(r10) == false) goto L10;
        if (r11 != null) goto L9;
        r11 = new ArrayList();
    L9:
        r11.add(r13);
    L10:
        r12 = r12 + 1;
        goto L4
    L11:
        if (r11 == null) goto L14;
        return (Header[]) r11.toArray(new Header[r11.size()]);
    L14:
        return this.EMPTY;
    }

    public Header getLastHeader(String r10) {
        int r11 = this.headers.size() - 1;
    L3:
        if (r11 < 0) goto L8;
        Header r12 = this.headers.get(r11);
        if (r12.getName().equalsIgnoreCase(r10) == true) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        return r12;
    L8:
        return null;
    }

    public HeaderIterator iterator() {
        return new BasicListHeaderIterator(this.headers, null);
    }

    public void removeHeader(Header r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.headers.remove(r10);
    }

    public void setHeaders(Header[] r10) {
        clear();
        if (r10 != null) goto L5;
        return;
    L5:
        Collections.addAll(this.headers, r10);
    }

    public String toString() {
        return this.headers.toString();
    }

    public void updateHeader(Header r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = 0;
    L6:
        if (r11 >= this.headers.size()) goto L12;
        if (this.headers.get(r11).getName().equalsIgnoreCase(r10.getName()) == true) goto L9;
        r11 = r11 + 1;
        goto L6
    L9:
        this.headers.set(r11, r10);
        return;
    L12:
        this.headers.add(r10);
    }

    public HeaderIterator iterator(String r10) {
        return new BasicListHeaderIterator(this.headers, r10);
    }
}
