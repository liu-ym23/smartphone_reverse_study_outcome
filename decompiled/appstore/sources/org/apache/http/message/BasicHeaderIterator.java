package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class BasicHeaderIterator implements HeaderIterator {
    protected final Header[] allHeaders;
    protected int currentIndex;
    protected String headerName;

    public BasicHeaderIterator(Header[] r10, String r11) {
        this.allHeaders = (Header[]) Args.notNull(r10, "Header array");
        this.headerName = r11;
        this.currentIndex = findNext(-1);
    }

    public boolean filterHeader(int r10) {
        String r11 = this.headerName;
        if (r11 != null) goto L5;
    L8:
        return true;
    L5:
        if (r11.equalsIgnoreCase(this.allHeaders[r10].getName()) == true) goto L8;
        return false;
    }

    public int findNext(int r10) {
        if (r10 >= (-1)) goto L5;
        return -1;
    L5:
        int r11 = this.allHeaders.length - 1;
        boolean r12 = false;
    L6:
        if (r12 == true) goto L9;
        if (r10 >= r11) goto L9;
        r10 = r10 + 1;
        r12 = filterHeader(r10);
    L9:
        if (r12 == true) goto L11;
        return -1;
    L11:
        return r10;
    }

    @Override // org.apache.http.HeaderIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentIndex < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    @Override // org.apache.http.HeaderIterator
    public Header nextHeader() throws NoSuchElementException {
        int r10 = this.currentIndex;
        if (r10 < 0) goto L7;
        this.currentIndex = findNext(r10);
        return this.allHeaders[r10];
    L7:
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing headers is not supported.");
    }
}
