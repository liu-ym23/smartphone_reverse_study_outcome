package com.google.protobuf;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class TextFormatParseLocation {
    public static final TextFormatParseLocation EMPTY = null;
    private final int column;
    private final int line;

    static {
        EMPTY = new TextFormatParseLocation(-1, -1);
    }

    private TextFormatParseLocation(int r10, int r11) {
        this.line = r10;
        this.column = r11;
    }

    public static TextFormatParseLocation create(int r10, int r11) {
        if (r10 != (-1)) goto L7;
        if (r11 != (-1)) goto L7;
        return EMPTY;
    L7:
        if (r10 < 0) goto L12;
        if (r11 < 0) goto L12;
        return new TextFormatParseLocation(r10, r11);
    L12:
        throw new IllegalArgumentException(String.format("line and column values must be >= 0: line %d, column: %d", new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)}));
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof TextFormatParseLocation) == true) goto L8;
        return false;
    L8:
        TextFormatParseLocation r11 = (TextFormatParseLocation) r10;
        if (this.line != r11.getLine()) goto L14;
        if (this.column != r11.getColumn()) goto L14;
        return true;
    L14:
        return false;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int hashCode() {
        return Arrays.hashCode(new int[]{this.line, this.column});
    }

    public String toString() {
        return String.format("ParseLocation{line=%d, column=%d}", new Object[]{Integer.valueOf(this.line), Integer.valueOf(this.column)});
    }
}
