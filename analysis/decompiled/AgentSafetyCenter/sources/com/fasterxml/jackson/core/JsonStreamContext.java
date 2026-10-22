package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.ContentReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class JsonStreamContext {
    public static final int TYPE_ARRAY = 1;
    public static final int TYPE_OBJECT = 2;
    public static final int TYPE_ROOT = 0;
    protected int _index;
    protected int _nestingDepth;
    protected int _type;

    public JsonStreamContext(JsonStreamContext jsonStreamContext) {
        this._type = jsonStreamContext._type;
        this._index = jsonStreamContext._index;
    }

    public final int getCurrentIndex() {
        int i = this._index;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public abstract String getCurrentName();

    public Object getCurrentValue() {
        return null;
    }

    public final int getEntryCount() {
        return this._index + 1;
    }

    public final int getNestingDepth() {
        return this._nestingDepth;
    }

    public abstract JsonStreamContext getParent();

    @Deprecated
    public JsonLocation getStartLocation(Object obj) {
        return JsonLocation.NA;
    }

    @Deprecated
    public final String getTypeDesc() {
        int i = this._type;
        return i != 0 ? i != 1 ? i != 2 ? "?" : "OBJECT" : "ARRAY" : "ROOT";
    }

    public boolean hasCurrentIndex() {
        return this._index >= 0;
    }

    public boolean hasCurrentName() {
        return getCurrentName() != null;
    }

    public boolean hasPathSegment() {
        int i = this._type;
        if (i == 2) {
            return hasCurrentName();
        }
        if (i == 1) {
            return hasCurrentIndex();
        }
        return false;
    }

    public final boolean inArray() {
        return this._type == 1;
    }

    public final boolean inObject() {
        return this._type == 2;
    }

    public final boolean inRoot() {
        return this._type == 0;
    }

    public JsonPointer pathAsPointer() {
        return JsonPointer.forPath(this, false);
    }

    public JsonLocation startLocation(ContentReference contentReference) {
        return JsonLocation.NA;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        int i = this._type;
        if (i == 0) {
            sb2.append("/");
        } else if (i != 1) {
            sb2.append('{');
            String currentName = getCurrentName();
            if (currentName != null) {
                sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                CharTypes.appendQuoted(sb2, currentName);
                sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            } else {
                sb2.append('?');
            }
            sb2.append('}');
        } else {
            sb2.append('[');
            sb2.append(getCurrentIndex());
            sb2.append(']');
        }
        return sb2.toString();
    }

    public String typeDesc() {
        int i = this._type;
        return i != 0 ? i != 1 ? i != 2 ? "?" : "Object" : "Array" : "root";
    }

    public JsonPointer pathAsPointer(boolean z10) {
        return JsonPointer.forPath(this, z10);
    }

    public JsonStreamContext() {
    }

    public JsonStreamContext(int i, int i3) {
        this._type = i;
        this._index = i3;
    }

    public void setCurrentValue(Object obj) {
    }
}
