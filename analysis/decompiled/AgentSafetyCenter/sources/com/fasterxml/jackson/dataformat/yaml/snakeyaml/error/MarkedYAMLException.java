package com.fasterxml.jackson.dataformat.yaml.snakeyaml.error;

import com.fasterxml.jackson.core.JsonParser;
import yd.b;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public class MarkedYAMLException extends YAMLException {
    private static final long serialVersionUID = 1;
    protected final b _source;

    public MarkedYAMLException(JsonParser jsonParser, b bVar) {
        super(jsonParser, bVar);
        this._source = bVar;
    }

    public static MarkedYAMLException from(JsonParser jsonParser, b bVar) {
        return new MarkedYAMLException(jsonParser, bVar);
    }

    public String getContext() {
        return this._source.f16123c;
    }

    public Mark getContextMark() {
        return Mark.from(this._source.f16124f);
    }

    public String getProblem() {
        return this._source.f16125g;
    }

    public Mark getProblemMark() {
        return Mark.from(this._source.f16126h);
    }
}
