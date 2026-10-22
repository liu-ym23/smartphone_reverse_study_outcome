package org.yaml.snakeyaml.scanner;

import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes5.dex */
final class SimpleKey {
    private final int column;
    private final int index;
    private final int line;
    private final Mark mark;
    private final boolean required;
    private final int tokenNumber;

    public SimpleKey(int i10, boolean z10, int i11, int i12, int i13, Mark mark) {
        this.tokenNumber = i10;
        this.required = z10;
        this.index = i11;
        this.line = i12;
        this.column = i13;
        this.mark = mark;
    }

    public int getColumn() {
        return this.column;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLine() {
        return this.line;
    }

    public Mark getMark() {
        return this.mark;
    }

    public int getTokenNumber() {
        return this.tokenNumber;
    }

    public boolean isRequired() {
        return this.required;
    }

    public String toString() {
        return "SimpleKey - tokenNumber=" + this.tokenNumber + " required=" + this.required + " index=" + this.index + " line=" + this.line + " column=" + this.column;
    }
}
