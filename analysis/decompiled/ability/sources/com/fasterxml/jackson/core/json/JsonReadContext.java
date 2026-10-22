package com.fasterxml.jackson.core.json;

import B7.a;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.io.ContentReference;

/* loaded from: classes2.dex */
public class JsonReadContext extends JsonStreamContext {
    protected JsonReadContext _child;
    protected int _columnNr;
    protected String _currentName;
    protected Object _currentValue;
    protected DupDetector _dups;
    protected int _lineNr;
    protected final JsonReadContext _parent;

    public JsonReadContext(JsonReadContext jsonReadContext, int i, DupDetector dupDetector, int i6, int i10, int i11) {
        this._parent = jsonReadContext;
        this._dups = dupDetector;
        this._type = i6;
        this._lineNr = i10;
        this._columnNr = i11;
        this._index = -1;
        this._nestingDepth = i;
    }

    private void _checkDup(DupDetector dupDetector, String str) throws JsonProcessingException {
        if (dupDetector.isDup(str)) {
            Object source = dupDetector.getSource();
            throw new JsonParseException(source instanceof JsonParser ? (JsonParser) source : null, a.m("Duplicate field '", str, "'"));
        }
    }

    public static JsonReadContext createRootContext(int i, int i6, DupDetector dupDetector) {
        return new JsonReadContext(null, 0, dupDetector, 0, i, i6);
    }

    public JsonReadContext clearAndGetParent() {
        this._currentValue = null;
        return this._parent;
    }

    public JsonReadContext createChildArrayContext(int i, int i6) {
        JsonReadContext jsonReadContext = this._child;
        if (jsonReadContext != null) {
            jsonReadContext.reset(1, i, i6);
            return jsonReadContext;
        }
        int i10 = this._nestingDepth + 1;
        DupDetector dupDetector = this._dups;
        JsonReadContext jsonReadContext2 = new JsonReadContext(this, i10, dupDetector == null ? null : dupDetector.child(), 1, i, i6);
        this._child = jsonReadContext2;
        return jsonReadContext2;
    }

    public JsonReadContext createChildObjectContext(int i, int i6) {
        JsonReadContext jsonReadContext = this._child;
        if (jsonReadContext != null) {
            jsonReadContext.reset(2, i, i6);
            return jsonReadContext;
        }
        int i10 = this._nestingDepth + 1;
        DupDetector dupDetector = this._dups;
        JsonReadContext jsonReadContext2 = new JsonReadContext(this, i10, dupDetector == null ? null : dupDetector.child(), 2, i, i6);
        this._child = jsonReadContext2;
        return jsonReadContext2;
    }

    public boolean expectComma() {
        int i = this._index + 1;
        this._index = i;
        return this._type != 0 && i > 0;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public String getCurrentName() {
        return this._currentName;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public Object getCurrentValue() {
        return this._currentValue;
    }

    public DupDetector getDupDetector() {
        return this._dups;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    @Deprecated
    public JsonLocation getStartLocation(Object obj) {
        return startLocation(ContentReference.rawReference(obj));
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public boolean hasCurrentName() {
        return this._currentName != null;
    }

    public void reset(int i, int i6, int i10) {
        this._type = i;
        this._index = -1;
        this._lineNr = i6;
        this._columnNr = i10;
        this._currentName = null;
        this._currentValue = null;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            dupDetector.reset();
        }
    }

    public void setCurrentName(String str) throws JsonProcessingException {
        this._currentName = str;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            _checkDup(dupDetector, str);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public void setCurrentValue(Object obj) {
        this._currentValue = obj;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public JsonLocation startLocation(ContentReference contentReference) {
        return new JsonLocation(contentReference, -1L, this._lineNr, this._columnNr);
    }

    public JsonReadContext withDupDetector(DupDetector dupDetector) {
        this._dups = dupDetector;
        return this;
    }

    public static JsonReadContext createRootContext(DupDetector dupDetector) {
        return new JsonReadContext(null, 0, dupDetector, 0, 1, 0);
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public JsonReadContext getParent() {
        return this._parent;
    }

    @Deprecated
    public JsonReadContext(JsonReadContext jsonReadContext, DupDetector dupDetector, int i, int i6, int i10) {
        this._parent = jsonReadContext;
        this._dups = dupDetector;
        this._type = i;
        this._lineNr = i6;
        this._columnNr = i10;
        this._index = -1;
        this._nestingDepth = jsonReadContext == null ? 0 : jsonReadContext._nestingDepth + 1;
    }
}
