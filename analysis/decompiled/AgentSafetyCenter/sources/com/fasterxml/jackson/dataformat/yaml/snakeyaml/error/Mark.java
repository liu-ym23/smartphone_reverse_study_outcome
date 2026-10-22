package com.fasterxml.jackson.dataformat.yaml.snakeyaml.error;

import yd.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public class Mark {
    protected final a _source;

    public Mark(a aVar) {
        this._source = aVar;
    }

    public static Mark from(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new Mark(aVar);
    }

    public int getColumn() {
        return this._source.f16121g;
    }

    public int getIndex() {
        return this._source.f16119c;
    }

    public int getLine() {
        return this._source.f16120f;
    }

    public String getName() {
        this._source.getClass();
        return "'reader'";
    }

    public String get_snippet() {
        return this._source.a(4, 75);
    }

    public String get_snippet(int i, int i3) {
        return this._source.a(i, i3);
    }
}
