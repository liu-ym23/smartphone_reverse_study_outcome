package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class BasicHeaderElementIterator implements HeaderElementIterator {
    private CharArrayBuffer buffer;
    private HeaderElement currentElement;
    private ParserCursor cursor;
    private final HeaderIterator headerIt;
    private final HeaderValueParser parser;

    public BasicHeaderElementIterator(HeaderIterator r10, HeaderValueParser r11) {
        this.currentElement = null;
        this.buffer = null;
        this.cursor = null;
        this.headerIt = (HeaderIterator) Args.notNull(r10, "Header iterator");
        this.parser = (HeaderValueParser) Args.notNull(r11, "Parser");
    }

    private void bufferHeaderValue() {
        this.cursor = null;
        this.buffer = null;
    L4:
        if (this.headerIt.hasNext() == false) goto L17;
        Header r10 = this.headerIt.nextHeader();
        if ((r10 instanceof FormattedHeader) == true) goto L7;
        String r11 = r10.getValue();
        if (r11 == null) goto L4;
        CharArrayBuffer r12 = new CharArrayBuffer(r11.length());
        this.buffer = r12;
        r12.append(r11);
        this.cursor = new ParserCursor(0, this.buffer.length());
        return;
    L7:
        FormattedHeader r13 = (FormattedHeader) r10;
        CharArrayBuffer r14 = r13.getBuffer();
        this.buffer = r14;
        ParserCursor r15 = new ParserCursor(0, r14.length());
        this.cursor = r15;
        r15.updatePos(r13.getValuePos());
        return;
    }

    private void parseNextElement() {
    L3:
        if (this.headerIt.hasNext() == false) goto L5;
    L8:
        ParserCursor r10 = this.cursor;
        if (r10 != null) goto L11;
    L12:
        bufferHeaderValue();
    L14:
        if (this.cursor == null) goto L3;
    L16:
        if (this.cursor.atEnd() == true) goto L24;
        HeaderElement r11 = this.parser.parseHeaderElement(this.buffer, this.cursor);
        if (r11.getName().isEmpty() == false) goto L21;
        if (r11.getValue() == null) goto L16;
    L21:
        this.currentElement = r11;
        return;
    L24:
        if (this.cursor.atEnd() == false) goto L3;
        this.cursor = null;
        this.buffer = null;
        goto L3
    L11:
        if (r10.atEnd() == false) goto L14;
    L5:
        if (this.cursor != null) goto L8;
    }

    @Override // org.apache.http.HeaderElementIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentElement != null) goto L6;
        parseNextElement();
    L6:
        if (this.currentElement == null) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        return nextElement();
    }

    @Override // org.apache.http.HeaderElementIterator
    public HeaderElement nextElement() throws NoSuchElementException {
        if (this.currentElement != null) goto L5;
        parseNextElement();
    L5:
        HeaderElement r10 = this.currentElement;
        if (r10 == null) goto L10;
        this.currentElement = null;
        return r10;
    L10:
        throw new NoSuchElementException("No more header elements available");
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Remove not supported");
    }

    public BasicHeaderElementIterator(HeaderIterator r10) {
        this(r10, BasicHeaderValueParser.INSTANCE);
    }
}
