package com.fasterxml.jackson.dataformat.yaml.snakeyaml.error;

@Deprecated
/* loaded from: classes2.dex */
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
        return this._source.getColumn();
    }

    public int getIndex() {
        return this._source.getIndex();
    }

    public int getLine() {
        return this._source.getLine();
    }

    public String getName() {
        return this._source.getName();
    }

    public String get_snippet() {
        return this._source.get_snippet();
    }

    public String get_snippet(int i10, int i11) {
        return this._source.get_snippet(i10, i11);
    }
}
