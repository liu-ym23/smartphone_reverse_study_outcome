package com.fasterxml.jackson.dataformat.yaml.snakeyaml.error;

@Deprecated
/* loaded from: classes3.dex */
public class Mark {
    protected final org.yaml.snakeyaml.error.Mark _source;

    public Mark(org.yaml.snakeyaml.error.Mark mark) {
        this._source = mark;
    }

    public static Mark from(org.yaml.snakeyaml.error.Mark mark) {
        if (mark == null) {
            return null;
        }
        return new Mark(mark);
    }

    public int getColumn() {
        return this._source.c;
    }

    public int getIndex() {
        return this._source.f5523a;
    }

    public int getLine() {
        return this._source.b;
    }

    public String getName() {
        this._source.getClass();
        return "'reader'";
    }

    public String get_snippet() {
        return this._source.a(4, 75);
    }

    public String get_snippet(int i, int i6) {
        return this._source.a(i, i6);
    }
}
