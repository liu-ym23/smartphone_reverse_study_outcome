package com.fasterxml.jackson.dataformat.yaml.snakeyaml.error;

import com.fasterxml.jackson.core.JsonParser;

@Deprecated
/* loaded from: classes3.dex */
public class MarkedYAMLException extends YAMLException {
    private static final long serialVersionUID = 1;
    protected final org.yaml.snakeyaml.error.MarkedYAMLException _source;

    public MarkedYAMLException(JsonParser jsonParser, org.yaml.snakeyaml.error.MarkedYAMLException markedYAMLException) {
        super(jsonParser, markedYAMLException);
        this._source = markedYAMLException;
    }

    public static MarkedYAMLException from(JsonParser jsonParser, org.yaml.snakeyaml.error.MarkedYAMLException markedYAMLException) {
        return new MarkedYAMLException(jsonParser, markedYAMLException);
    }

    public String getContext() {
        return this._source.f5524a;
    }

    public Mark getContextMark() {
        return Mark.from(this._source.b);
    }

    public String getProblem() {
        return this._source.c;
    }

    public Mark getProblemMark() {
        return Mark.from(this._source.d);
    }
}
