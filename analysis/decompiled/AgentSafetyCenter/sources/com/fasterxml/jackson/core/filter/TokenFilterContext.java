package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class TokenFilterContext extends JsonStreamContext {
    protected TokenFilterContext _child;
    protected String _currentName;
    protected TokenFilter _filter;
    protected boolean _needToHandleName;
    protected final TokenFilterContext _parent;
    protected boolean _startHandled;

    public TokenFilterContext(int i, TokenFilterContext tokenFilterContext, TokenFilter tokenFilter, boolean z10) {
        this._type = i;
        this._parent = tokenFilterContext;
        this._nestingDepth = tokenFilterContext == null ? 0 : tokenFilterContext._nestingDepth + 1;
        this._filter = tokenFilter;
        this._index = -1;
        this._startHandled = z10;
        this._needToHandleName = false;
    }

    private void _writePath(JsonGenerator jsonGenerator) {
        TokenFilter tokenFilter = this._filter;
        if (tokenFilter == null || tokenFilter == TokenFilter.INCLUDE_ALL) {
            return;
        }
        TokenFilterContext tokenFilterContext = this._parent;
        if (tokenFilterContext != null) {
            tokenFilterContext._writePath(jsonGenerator);
        }
        if (this._startHandled) {
            if (this._needToHandleName) {
                this._needToHandleName = false;
                jsonGenerator.writeFieldName(this._currentName);
                return;
            }
            return;
        }
        this._startHandled = true;
        int i = this._type;
        if (i != 2) {
            if (i == 1) {
                jsonGenerator.writeStartArray();
            }
        } else {
            jsonGenerator.writeStartObject();
            if (this._needToHandleName) {
                this._needToHandleName = false;
                jsonGenerator.writeFieldName(this._currentName);
            }
        }
    }

    public static TokenFilterContext createRootContext(TokenFilter tokenFilter) {
        return new TokenFilterContext(0, null, tokenFilter, true);
    }

    public void appendDesc(StringBuilder sb2) {
        TokenFilterContext tokenFilterContext = this._parent;
        if (tokenFilterContext != null) {
            tokenFilterContext.appendDesc(sb2);
        }
        int i = this._type;
        if (i != 2) {
            if (i != 1) {
                sb2.append("/");
                return;
            }
            sb2.append('[');
            sb2.append(getCurrentIndex());
            sb2.append(']');
            return;
        }
        sb2.append('{');
        if (this._currentName != null) {
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            sb2.append(this._currentName);
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        } else {
            sb2.append('?');
        }
        sb2.append('}');
    }

    public TokenFilter checkValue(TokenFilter tokenFilter) {
        int i = this._type;
        if (i == 2) {
            return tokenFilter;
        }
        int i3 = this._index + 1;
        this._index = i3;
        return i == 1 ? tokenFilter.includeElement(i3) : tokenFilter.includeRootValue(i3);
    }

    public TokenFilterContext closeArray(JsonGenerator jsonGenerator) {
        if (this._startHandled) {
            jsonGenerator.writeEndArray();
        } else {
            TokenFilter tokenFilter = this._filter;
            if (tokenFilter != null && tokenFilter != TokenFilter.INCLUDE_ALL && tokenFilter.includeEmptyArray(hasCurrentIndex())) {
                TokenFilterContext tokenFilterContext = this._parent;
                if (tokenFilterContext != null) {
                    tokenFilterContext._writePath(jsonGenerator);
                }
                jsonGenerator.writeStartArray();
                jsonGenerator.writeEndArray();
            }
        }
        TokenFilter tokenFilter2 = this._filter;
        if (tokenFilter2 != null && tokenFilter2 != TokenFilter.INCLUDE_ALL) {
            tokenFilter2.filterFinishArray();
        }
        return this._parent;
    }

    public TokenFilterContext closeObject(JsonGenerator jsonGenerator) {
        if (this._startHandled) {
            jsonGenerator.writeEndObject();
        } else {
            TokenFilter tokenFilter = this._filter;
            if (tokenFilter != null && tokenFilter != TokenFilter.INCLUDE_ALL && tokenFilter.includeEmptyObject(hasCurrentName())) {
                TokenFilterContext tokenFilterContext = this._parent;
                if (tokenFilterContext != null) {
                    tokenFilterContext._writePath(jsonGenerator);
                }
                jsonGenerator.writeStartObject();
                jsonGenerator.writeEndObject();
            }
        }
        TokenFilter tokenFilter2 = this._filter;
        if (tokenFilter2 != null && tokenFilter2 != TokenFilter.INCLUDE_ALL) {
            tokenFilter2.filterFinishObject();
        }
        return this._parent;
    }

    public TokenFilterContext createChildArrayContext(TokenFilter tokenFilter, boolean z10) {
        TokenFilterContext tokenFilterContext = this._child;
        if (tokenFilterContext != null) {
            return tokenFilterContext.reset(1, tokenFilter, z10);
        }
        TokenFilterContext tokenFilterContext2 = new TokenFilterContext(1, this, tokenFilter, z10);
        this._child = tokenFilterContext2;
        return tokenFilterContext2;
    }

    public TokenFilterContext createChildObjectContext(TokenFilter tokenFilter, boolean z10) {
        TokenFilterContext tokenFilterContext = this._child;
        if (tokenFilterContext != null) {
            return tokenFilterContext.reset(2, tokenFilter, z10);
        }
        TokenFilterContext tokenFilterContext2 = new TokenFilterContext(2, this, tokenFilter, z10);
        this._child = tokenFilterContext2;
        return tokenFilterContext2;
    }

    public void ensureFieldNameWritten(JsonGenerator jsonGenerator) {
        if (this._needToHandleName) {
            this._needToHandleName = false;
            jsonGenerator.writeFieldName(this._currentName);
        }
    }

    public TokenFilterContext findChildOf(TokenFilterContext tokenFilterContext) {
        TokenFilterContext tokenFilterContext2 = this._parent;
        if (tokenFilterContext2 == tokenFilterContext) {
            return this;
        }
        while (tokenFilterContext2 != null) {
            TokenFilterContext tokenFilterContext3 = tokenFilterContext2._parent;
            if (tokenFilterContext3 == tokenFilterContext) {
                return tokenFilterContext2;
            }
            tokenFilterContext2 = tokenFilterContext3;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final String getCurrentName() {
        return this._currentName;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public Object getCurrentValue() {
        return null;
    }

    public TokenFilter getFilter() {
        return this._filter;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public boolean hasCurrentName() {
        return this._currentName != null;
    }

    public boolean isStartHandled() {
        return this._startHandled;
    }

    public JsonToken nextTokenToRead() {
        if (!this._startHandled) {
            this._startHandled = true;
            return this._type == 2 ? JsonToken.START_OBJECT : JsonToken.START_ARRAY;
        }
        if (!this._needToHandleName || this._type != 2) {
            return null;
        }
        this._needToHandleName = false;
        return JsonToken.FIELD_NAME;
    }

    public TokenFilterContext reset(int i, TokenFilter tokenFilter, boolean z10) {
        this._type = i;
        this._filter = tokenFilter;
        this._index = -1;
        this._currentName = null;
        this._startHandled = z10;
        this._needToHandleName = false;
        return this;
    }

    public TokenFilter setFieldName(String str) {
        this._currentName = str;
        this._needToHandleName = true;
        return this._filter;
    }

    public void skipParentChecks() {
        this._filter = null;
        while (true) {
            this = this._parent;
            if (this == null) {
                return;
            } else {
                this._filter = null;
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        appendDesc(sb2);
        return sb2.toString();
    }

    public void writePath(JsonGenerator jsonGenerator) {
        TokenFilter tokenFilter = this._filter;
        if (tokenFilter == null || tokenFilter == TokenFilter.INCLUDE_ALL) {
            return;
        }
        TokenFilterContext tokenFilterContext = this._parent;
        if (tokenFilterContext != null) {
            tokenFilterContext._writePath(jsonGenerator);
        }
        if (this._startHandled) {
            if (this._needToHandleName) {
                jsonGenerator.writeFieldName(this._currentName);
                return;
            }
            return;
        }
        this._startHandled = true;
        int i = this._type;
        if (i == 2) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName(this._currentName);
        } else if (i == 1) {
            jsonGenerator.writeStartArray();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final TokenFilterContext getParent() {
        return this._parent;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public void setCurrentValue(Object obj) {
    }
}
