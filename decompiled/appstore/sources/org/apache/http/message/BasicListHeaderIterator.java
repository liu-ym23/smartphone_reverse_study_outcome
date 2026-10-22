package org.apache.http.message;

import java.util.List;
import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

/* JADX INFO: loaded from: classes4.dex */
public class BasicListHeaderIterator implements HeaderIterator {
    protected final List<Header> allHeaders;
    protected int currentIndex;
    protected String headerName;
    protected int lastIndex;

    public BasicListHeaderIterator(List<Header> r10, String r11) {
        this.allHeaders = (List) Args.notNull(r10, "Header list");
        this.headerName = r11;
        this.currentIndex = findNext(-1);
        this.lastIndex = -1;
    }

    public boolean filterHeader(int r10) {
        if (this.headerName != null) goto L6;
        return true;
    L6:
        String r11 = this.allHeaders.get(r10).getName();
        return this.headerName.equalsIgnoreCase(r11);
    }

    public int findNext(int r10) {
        if (r10 >= (-1)) goto L5;
        return -1;
    L5:
        int r11 = this.allHeaders.size() - 1;
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
        this.lastIndex = r10;
        this.currentIndex = findNext(r10);
        return this.allHeaders.get(r10);
    L7:
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        if (this.lastIndex < 0) goto L5;
        boolean r10 = true;
    L6:
        Asserts.check(r10, "No header to remove");
        this.allHeaders.remove(this.lastIndex);
        this.lastIndex = -1;
        this.currentIndex--;
        return;
    L5:
        r10 = false;
        goto L6
    }
}
