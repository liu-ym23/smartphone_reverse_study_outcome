package org.apache.http.message;

/* JADX INFO: loaded from: classes4.dex */
public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int r10, int r11) {
        if (r10 < 0) goto L10;
        if (r10 > r11) goto L8;
        this.lowerBound = r10;
        this.upperBound = r11;
        this.pos = r10;
        return;
    L8:
        throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
    L10:
        throw new IndexOutOfBoundsException("Lower bound cannot be negative");
    }

    public boolean atEnd() {
        if (this.pos < this.upperBound) goto L5;
        return true;
    L5:
        return false;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getPos() {
        return this.pos;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public String toString() {
        return '[' + Integer.toString(this.lowerBound) + '>' + Integer.toString(this.pos) + '>' + Integer.toString(this.upperBound) + ']';
    }

    public void updatePos(int r10) {
        if (r10 < this.lowerBound) goto L11;
        if (r10 > this.upperBound) goto L9;
        this.pos = r10;
        return;
    L9:
        throw new IndexOutOfBoundsException("pos: " + r10 + " > upperBound: " + this.upperBound);
    L11:
        throw new IndexOutOfBoundsException("pos: " + r10 + " < lowerBound: " + this.lowerBound);
    }
}
