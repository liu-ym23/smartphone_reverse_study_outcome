package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class BasicTokenIterator implements TokenIterator {
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    protected String currentHeader;
    protected String currentToken;
    protected final HeaderIterator headerIt;
    protected int searchPos;

    public BasicTokenIterator(HeaderIterator r10) {
        this.headerIt = (HeaderIterator) Args.notNull(r10, "Header iterator");
        this.searchPos = findNext(-1);
    }

    public String createToken(String r10, int r11, int r12) {
        return r10.substring(r11, r12);
    }

    public int findNext(int r10) throws ParseException {
        if (r10 < 0) goto L5;
        int r11 = findTokenSeparator(r10);
    L9:
        int r12 = findTokenStart(r11);
        if (r12 >= 0) goto L13;
        this.currentToken = null;
        return -1;
    L13:
        int r13 = findTokenEnd(r12);
        this.currentToken = createToken(this.currentHeader, r12, r13);
        return r13;
    L5:
        if (this.headerIt.hasNext() == true) goto L7;
        return -1;
    L7:
        this.currentHeader = this.headerIt.nextHeader().getValue();
        r11 = 0;
        goto L9
    }

    public int findTokenEnd(int r10) {
        Args.notNegative(r10, "Search position");
        int r11 = this.currentHeader.length();
    L3:
        r10 = r10 + 1;
        if (r10 >= r11) goto L8;
        if (isTokenChar(this.currentHeader.charAt(r10)) == true) goto L3;
    L8:
        return r10;
    }

    public int findTokenSeparator(int r10) {
        int r11 = Args.notNegative(r10, "Search position");
        int r12 = this.currentHeader.length();
        boolean r13 = false;
    L3:
        if (r13 == true) goto L17;
        if (r11 >= r12) goto L17;
        char r14 = this.currentHeader.charAt(r11);
        if (isTokenSeparator(r14) == true) goto L7;
        if (isWhitespace(r14) == false) goto L12;
        r11 = r11 + 1;
        goto L3
    L12:
        if (isTokenChar(r14) == false) goto L16;
        throw new ParseException("Tokens without separator (pos " + r11 + "): " + this.currentHeader);
    L16:
        throw new ParseException("Invalid character after token (pos " + r11 + "): " + this.currentHeader);
    L7:
        r13 = true;
    L17:
        return r11;
    }

    public int findTokenStart(int r10) {
        int r11 = Args.notNegative(r10, "Search position");
        boolean r12 = false;
    L3:
        if (r12 == true) goto L25;
        String r13 = this.currentHeader;
        if (r13 == null) goto L25;
        int r14 = r13.length();
    L7:
        if (r12 == true) goto L20;
        if (r11 >= r14) goto L20;
        char r15 = this.currentHeader.charAt(r11);
        if (isTokenSeparator(r15) == true) goto L19;
        if (isWhitespace(r15) == true) goto L19;
        if (isTokenChar(this.currentHeader.charAt(r11)) == false) goto L18;
        r12 = true;
        goto L7
    L18:
        throw new ParseException("Invalid character before token (pos " + r11 + "): " + this.currentHeader);
    L19:
        r11 = r11 + 1;
    L20:
        if (r12 == true) goto L3;
        if (this.headerIt.hasNext() == true) goto L23;
        this.currentHeader = null;
        goto L3
    L23:
        this.currentHeader = this.headerIt.nextHeader().getValue();
        r11 = 0;
    L25:
        if (r12 == true) goto L47;
        return -1;
    L47:
        return r11;
    }

    @Override // org.apache.http.TokenIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentToken == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHttpSeparator(char r10) {
        if (HTTP_SEPARATORS.indexOf(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTokenChar(char r10) {
        if (Character.isLetterOrDigit(r10) == false) goto L6;
        return true;
    L6:
        if (Character.isISOControl(r10) == false) goto L9;
        return false;
    L9:
        if (isHttpSeparator(r10) == false) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean isTokenSeparator(char r10) {
        if (r10 != ',') goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isWhitespace(char r10) {
        if (r10 != '\t') goto L5;
    L8:
        return true;
    L5:
        if (Character.isSpaceChar(r10) == true) goto L8;
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException, ParseException {
        return nextToken();
    }

    @Override // org.apache.http.TokenIterator
    public String nextToken() throws NoSuchElementException, ParseException {
        String r10 = this.currentToken;
        if (r10 == null) goto L7;
        this.searchPos = findNext(this.searchPos);
        return r10;
    L7:
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public final void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing tokens is not supported.");
    }
}
