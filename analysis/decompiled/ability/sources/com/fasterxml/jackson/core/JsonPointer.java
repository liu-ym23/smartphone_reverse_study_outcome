package com.fasterxml.jackson.core;

import B7.a;
import androidx.collection.SieveCacheKt;
import androidx.compose.foundation.b;
import com.fasterxml.jackson.core.io.NumberInput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class JsonPointer implements Serializable {
    protected static final JsonPointer EMPTY = new JsonPointer();
    public static final char ESC = '~';
    public static final String ESC_SLASH = "~1";
    public static final String ESC_TILDE = "~0";
    public static final char SEPARATOR = '/';
    private static final long serialVersionUID = 1;
    protected final String _asString;
    protected final int _asStringOffset;
    protected int _hashCode;
    protected volatile JsonPointer _head;
    protected final int _matchingElementIndex;
    protected final String _matchingPropertyName;
    protected final JsonPointer _nextSegment;

    public static class PointerParent {
        public final int fullPathOffset;
        public final PointerParent parent;
        public final String segment;

        public PointerParent(PointerParent pointerParent, int i, String str) {
            this.parent = pointerParent;
            this.fullPathOffset = i;
            this.segment = str;
        }
    }

    public static class PointerSegment {
        public final int index;
        public final PointerSegment next;
        public int pathOffset;
        public PointerSegment prev;
        public final String property;

        public PointerSegment(PointerSegment pointerSegment, String str, int i) {
            this.next = pointerSegment;
            this.property = str;
            this.index = i;
            if (pointerSegment != null) {
                pointerSegment.prev = this;
            }
        }
    }

    public static class Serialization implements Externalizable {
        private String _fullPath;

        public Serialization() {
        }

        private Object readResolve() throws ObjectStreamException {
            return JsonPointer.compile(this._fullPath);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            this._fullPath = objectInput.readUTF();
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeUTF(this._fullPath);
        }

        public Serialization(String str) {
            this._fullPath = str;
        }
    }

    public JsonPointer() {
        this._nextSegment = null;
        this._matchingPropertyName = null;
        this._matchingElementIndex = -1;
        this._asString = "";
        this._asStringOffset = 0;
    }

    private static int _appendEscape(StringBuilder sb, char c) {
        if (c == '0') {
            sb.append(ESC);
            return 1;
        }
        if (c == '1') {
            sb.append(SEPARATOR);
            return 1;
        }
        sb.append(ESC);
        return 0;
    }

    private static void _appendEscaped(StringBuilder sb, String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '/') {
                sb.append(ESC_SLASH);
            } else if (cCharAt == '~') {
                sb.append(ESC_TILDE);
            } else {
                sb.append(cCharAt);
            }
        }
    }

    private static JsonPointer _buildPath(String str, int i, String str2, PointerParent pointerParent) {
        JsonPointer jsonPointer = new JsonPointer(str, i, str2, EMPTY);
        while (pointerParent != null) {
            JsonPointer jsonPointer2 = new JsonPointer(str, pointerParent.fullPathOffset, pointerParent.segment, jsonPointer);
            pointerParent = pointerParent.parent;
            jsonPointer = jsonPointer2;
        }
        return jsonPointer;
    }

    private final boolean _compare(String str, int i, String str2, int i6) {
        int length = str.length();
        if (length - i != str2.length() - i6) {
            return false;
        }
        while (i < length) {
            int i10 = i + 1;
            int i11 = i6 + 1;
            if (str.charAt(i) != str2.charAt(i6)) {
                return false;
            }
            i = i10;
            i6 = i11;
        }
        return true;
    }

    public static int _extractEscapedSegment(String str, int i, int i6, StringBuilder sb) {
        int length = str.length();
        int i10 = i6 - 1;
        if (i10 - i > 0) {
            sb.append((CharSequence) str, i, i10);
        }
        int i_appendEscape = _appendEscape(sb, str.charAt(i6));
        while (true) {
            i6 += i_appendEscape;
            while (i6 < length) {
                char cCharAt = str.charAt(i6);
                if (cCharAt == '/') {
                    return i6;
                }
                i6++;
                if (cCharAt != '~' || i6 >= length) {
                    sb.append(cCharAt);
                }
            }
            return -1;
            i_appendEscape = _appendEscape(sb, str.charAt(i6));
        }
    }

    private static final int _parseIndex(String str) throws NumberFormatException {
        int length = str.length();
        if (length == 0 || length > 10) {
            return -1;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt <= '0') {
            return (length == 1 && cCharAt == '0') ? 0 : -1;
        }
        if (cCharAt > '9') {
            return -1;
        }
        for (int i = 1; i < length; i++) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                return -1;
            }
        }
        if (length != 10) {
            return NumberInput.parseInt(str);
        }
        long j5 = Long.parseLong(str);
        if (j5 > SieveCacheKt.NodeLinkMask) {
            return -1;
        }
        return (int) j5;
    }

    public static JsonPointer _parseTail(String str) {
        int length = str.length();
        PointerParent pointerParent = null;
        int i = 1;
        int i6 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '/') {
                PointerParent pointerParent2 = new PointerParent(pointerParent, i6, str.substring(i6 + 1, i));
                i6 = i;
                i++;
                pointerParent = pointerParent2;
            } else {
                i++;
                if (cCharAt == '~' && i < length) {
                    StringBuilder sb = new StringBuilder(32);
                    int i_extractEscapedSegment = _extractEscapedSegment(str, i6 + 1, i, sb);
                    String string = sb.toString();
                    if (i_extractEscapedSegment < 0) {
                        return _buildPath(str, i6, string, pointerParent);
                    }
                    PointerParent pointerParent3 = new PointerParent(pointerParent, i6, string);
                    i6 = i_extractEscapedSegment;
                    i = i_extractEscapedSegment + 1;
                    pointerParent = pointerParent3;
                }
            }
        }
        return _buildPath(str, i6, str.substring(i6 + 1), pointerParent);
    }

    public static JsonPointer compile(String str) throws IllegalArgumentException {
        if (str == null || str.length() == 0) {
            return EMPTY;
        }
        if (str.charAt(0) == '/') {
            return _parseTail(str);
        }
        throw new IllegalArgumentException(a.m("Invalid input: JSON Pointer expression must start with '/': \"", str, "\""));
    }

    public static JsonPointer empty() {
        return EMPTY;
    }

    public static JsonPointer forPath(JsonStreamContext jsonStreamContext, boolean z10) {
        if (jsonStreamContext == null) {
            return EMPTY;
        }
        if (!jsonStreamContext.hasPathSegment() && (!z10 || !jsonStreamContext.inRoot() || !jsonStreamContext.hasCurrentIndex())) {
            jsonStreamContext = jsonStreamContext.getParent();
        }
        int i = 0;
        PointerSegment pointerSegment = null;
        while (jsonStreamContext != null) {
            if (jsonStreamContext.inObject()) {
                String currentName = jsonStreamContext.getCurrentName();
                if (currentName == null) {
                    currentName = "";
                }
                int length = currentName.length() + 2 + i;
                pointerSegment = new PointerSegment(pointerSegment, currentName, -1);
                i = length;
            } else if (jsonStreamContext.inArray() || z10) {
                i += 6;
                pointerSegment = new PointerSegment(pointerSegment, null, jsonStreamContext.getCurrentIndex());
            }
            jsonStreamContext = jsonStreamContext.getParent();
        }
        if (pointerSegment == null) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder(i);
        PointerSegment pointerSegment2 = null;
        PointerSegment pointerSegment3 = pointerSegment;
        while (pointerSegment3 != null) {
            pointerSegment3.pathOffset = sb.length();
            sb.append(SEPARATOR);
            String str = pointerSegment3.property;
            if (str != null) {
                _appendEscaped(sb, str);
            } else {
                sb.append(pointerSegment3.index);
            }
            PointerSegment pointerSegment4 = pointerSegment3;
            pointerSegment3 = pointerSegment3.next;
            pointerSegment2 = pointerSegment4;
        }
        String string = sb.toString();
        JsonPointer jsonPointer = EMPTY;
        while (pointerSegment2 != null) {
            String str2 = pointerSegment2.property;
            if (str2 != null) {
                jsonPointer = new JsonPointer(string, pointerSegment2.pathOffset, str2, jsonPointer);
            } else {
                int i6 = pointerSegment2.index;
                jsonPointer = new JsonPointer(string, pointerSegment2.pathOffset, String.valueOf(i6), i6, jsonPointer);
            }
            pointerSegment2 = pointerSegment2.prev;
        }
        return jsonPointer;
    }

    public static JsonPointer valueOf(String str) {
        return compile(str);
    }

    private Object writeReplace() {
        return new Serialization(toString());
    }

    public JsonPointer _constructHead() {
        JsonPointer jsonPointerLast = last();
        if (jsonPointerLast == this) {
            return EMPTY;
        }
        ArrayList arrayList = new ArrayList();
        String string = toString();
        String strSubstring = string.substring(0, string.length() - jsonPointerLast.length());
        int i = -this._asStringOffset;
        while (this != jsonPointerLast) {
            arrayList.add(new JsonPointer(this, strSubstring, this._asStringOffset + i));
            this = this._nextSegment;
        }
        JsonPointer jsonPointer = EMPTY;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            JsonPointer jsonPointer2 = new JsonPointer((JsonPointer) arrayList.get(size), jsonPointer);
            size--;
            jsonPointer = jsonPointer2;
        }
        return jsonPointer;
    }

    public JsonPointer append(JsonPointer jsonPointer) {
        JsonPointer jsonPointer2 = EMPTY;
        if (this == jsonPointer2) {
            return jsonPointer;
        }
        if (jsonPointer == jsonPointer2) {
            return this;
        }
        StringBuilder sbV = b.v(toString());
        sbV.append(jsonPointer.toString());
        return compile(sbV.toString());
    }

    public JsonPointer appendIndex(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative index cannot be appended");
        }
        StringBuilder stringBuilder = toStringBuilder(8);
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(i);
        return compile(stringBuilder.toString());
    }

    public JsonPointer appendProperty(String str) {
        if (str == null) {
            return this;
        }
        StringBuilder stringBuilder = toStringBuilder(str.length() + 2);
        stringBuilder.append(SEPARATOR);
        _appendEscaped(stringBuilder, str);
        return compile(stringBuilder.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonPointer)) {
            return false;
        }
        JsonPointer jsonPointer = (JsonPointer) obj;
        return _compare(this._asString, this._asStringOffset, jsonPointer._asString, jsonPointer._asStringOffset);
    }

    public int getMatchingIndex() {
        return this._matchingElementIndex;
    }

    public String getMatchingProperty() {
        return this._matchingPropertyName;
    }

    public int hashCode() {
        int iHashCode = this._hashCode;
        if (iHashCode == 0) {
            iHashCode = toString().hashCode();
            if (iHashCode == 0) {
                iHashCode = -1;
            }
            this._hashCode = iHashCode;
        }
        return iHashCode;
    }

    public JsonPointer head() {
        JsonPointer jsonPointer_constructHead = this._head;
        if (jsonPointer_constructHead == null) {
            if (this != EMPTY) {
                jsonPointer_constructHead = _constructHead();
            }
            this._head = jsonPointer_constructHead;
        }
        return jsonPointer_constructHead;
    }

    public JsonPointer last() {
        if (this == EMPTY) {
            return null;
        }
        while (true) {
            JsonPointer jsonPointer = this._nextSegment;
            if (jsonPointer == EMPTY) {
                return this;
            }
            this = jsonPointer;
        }
    }

    public int length() {
        return this._asString.length() - this._asStringOffset;
    }

    public JsonPointer matchElement(int i) {
        if (i != this._matchingElementIndex || i < 0) {
            return null;
        }
        return this._nextSegment;
    }

    public JsonPointer matchProperty(String str) {
        if (this._nextSegment == null || !this._matchingPropertyName.equals(str)) {
            return null;
        }
        return this._nextSegment;
    }

    public boolean matches() {
        return this._nextSegment == null;
    }

    public boolean matchesElement(int i) {
        return i == this._matchingElementIndex && i >= 0;
    }

    public boolean matchesProperty(String str) {
        return this._nextSegment != null && this._matchingPropertyName.equals(str);
    }

    public boolean mayMatchElement() {
        return this._matchingElementIndex >= 0;
    }

    public boolean mayMatchProperty() {
        return this._matchingPropertyName != null;
    }

    public JsonPointer tail() {
        return this._nextSegment;
    }

    public String toString() {
        int i = this._asStringOffset;
        return i <= 0 ? this._asString : this._asString.substring(i);
    }

    public StringBuilder toStringBuilder(int i) {
        if (this._asStringOffset <= 0) {
            return new StringBuilder(this._asString);
        }
        int length = this._asString.length();
        StringBuilder sb = new StringBuilder((length - this._asStringOffset) + i);
        sb.append((CharSequence) this._asString, this._asStringOffset, length);
        return sb;
    }

    public JsonPointer(String str, int i, String str2, JsonPointer jsonPointer) {
        this._asString = str;
        this._asStringOffset = i;
        this._nextSegment = jsonPointer;
        this._matchingPropertyName = str2;
        this._matchingElementIndex = _parseIndex(str2);
    }

    public JsonPointer(String str, int i, String str2, int i6, JsonPointer jsonPointer) {
        this._asString = str;
        this._asStringOffset = i;
        this._nextSegment = jsonPointer;
        this._matchingPropertyName = str2;
        this._matchingElementIndex = i6;
    }

    public JsonPointer(JsonPointer jsonPointer, JsonPointer jsonPointer2) {
        this._asString = jsonPointer._asString;
        this._asStringOffset = jsonPointer._asStringOffset;
        this._nextSegment = jsonPointer2;
        this._matchingPropertyName = jsonPointer._matchingPropertyName;
        this._matchingElementIndex = jsonPointer._matchingElementIndex;
    }

    public JsonPointer(JsonPointer jsonPointer, String str, int i) {
        this._asString = str;
        this._asStringOffset = i;
        this._nextSegment = null;
        this._matchingPropertyName = jsonPointer._matchingPropertyName;
        this._matchingElementIndex = jsonPointer._matchingElementIndex;
    }
}
