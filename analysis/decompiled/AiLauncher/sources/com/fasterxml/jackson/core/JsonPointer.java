package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.NumberInput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
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

        public PointerParent(PointerParent pointerParent, int i10, String str) {
            this.parent = pointerParent;
            this.fullPathOffset = i10;
            this.segment = str;
        }
    }

    public static class PointerSegment {
        public final int index;
        public final PointerSegment next;
        public int pathOffset;
        public PointerSegment prev;
        public final String property;

        public PointerSegment(PointerSegment pointerSegment, String str, int i10) {
            this.next = pointerSegment;
            this.property = str;
            this.index = i10;
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

    private static int _appendEscape(StringBuilder sb2, char c10) {
        if (c10 == '0') {
            sb2.append(ESC);
            return 1;
        }
        if (c10 == '1') {
            sb2.append(SEPARATOR);
            return 1;
        }
        sb2.append(ESC);
        return 0;
    }

    private static void _appendEscaped(StringBuilder sb2, String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '/') {
                sb2.append(ESC_SLASH);
            } else if (cCharAt == '~') {
                sb2.append(ESC_TILDE);
            } else {
                sb2.append(cCharAt);
            }
        }
    }

    private static JsonPointer _buildPath(String str, int i10, String str2, PointerParent pointerParent) {
        JsonPointer jsonPointer = new JsonPointer(str, i10, str2, EMPTY);
        while (pointerParent != null) {
            JsonPointer jsonPointer2 = new JsonPointer(str, pointerParent.fullPathOffset, pointerParent.segment, jsonPointer);
            pointerParent = pointerParent.parent;
            jsonPointer = jsonPointer2;
        }
        return jsonPointer;
    }

    private final boolean _compare(String str, int i10, String str2, int i11) {
        int length = str.length();
        if (length - i10 != str2.length() - i11) {
            return false;
        }
        while (i10 < length) {
            int i12 = i10 + 1;
            int i13 = i11 + 1;
            if (str.charAt(i10) != str2.charAt(i11)) {
                return false;
            }
            i10 = i12;
            i11 = i13;
        }
        return true;
    }

    public static int _extractEscapedSegment(String str, int i10, int i11, StringBuilder sb2) {
        int length = str.length();
        int i12 = i11 - 1;
        if (i12 - i10 > 0) {
            sb2.append((CharSequence) str, i10, i12);
        }
        int i_appendEscape = _appendEscape(sb2, str.charAt(i11));
        while (true) {
            i11 += i_appendEscape;
            while (i11 < length) {
                char cCharAt = str.charAt(i11);
                if (cCharAt == '/') {
                    return i11;
                }
                i11++;
                if (cCharAt != '~' || i11 >= length) {
                    sb2.append(cCharAt);
                }
            }
            return -1;
            i_appendEscape = _appendEscape(sb2, str.charAt(i11));
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
        for (int i10 = 1; i10 < length; i10++) {
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                return -1;
            }
        }
        if (length != 10) {
            return NumberInput.parseInt(str);
        }
        long j10 = Long.parseLong(str);
        if (j10 > 2147483647L) {
            return -1;
        }
        return (int) j10;
    }

    public static JsonPointer _parseTail(String str) {
        int length = str.length();
        PointerParent pointerParent = null;
        int i10 = 1;
        int i11 = 0;
        while (i10 < length) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '/') {
                PointerParent pointerParent2 = new PointerParent(pointerParent, i11, str.substring(i11 + 1, i10));
                i11 = i10;
                i10++;
                pointerParent = pointerParent2;
            } else {
                i10++;
                if (cCharAt == '~' && i10 < length) {
                    StringBuilder sb2 = new StringBuilder(32);
                    int i_extractEscapedSegment = _extractEscapedSegment(str, i11 + 1, i10, sb2);
                    String string = sb2.toString();
                    if (i_extractEscapedSegment < 0) {
                        return _buildPath(str, i11, string, pointerParent);
                    }
                    PointerParent pointerParent3 = new PointerParent(pointerParent, i11, string);
                    i11 = i_extractEscapedSegment;
                    i10 = i_extractEscapedSegment + 1;
                    pointerParent = pointerParent3;
                }
            }
        }
        return _buildPath(str, i11, str.substring(i11 + 1), pointerParent);
    }

    public static JsonPointer compile(String str) throws IllegalArgumentException {
        if (str == null || str.length() == 0) {
            return EMPTY;
        }
        if (str.charAt(0) == '/') {
            return _parseTail(str);
        }
        throw new IllegalArgumentException("Invalid input: JSON Pointer expression must start with '/': \"" + str + "\"");
    }

    public static JsonPointer empty() {
        return EMPTY;
    }

    public static JsonPointer forPath(JsonStreamContext jsonStreamContext, boolean z10) {
        PointerSegment pointerSegment;
        if (jsonStreamContext == null) {
            return EMPTY;
        }
        if (!jsonStreamContext.hasPathSegment() && (!z10 || !jsonStreamContext.inRoot() || !jsonStreamContext.hasCurrentIndex())) {
            jsonStreamContext = jsonStreamContext.getParent();
        }
        int length = 0;
        PointerSegment pointerSegment2 = null;
        while (jsonStreamContext != null) {
            if (jsonStreamContext.inObject()) {
                String currentName = jsonStreamContext.getCurrentName();
                if (currentName == null) {
                    currentName = "";
                }
                length += currentName.length() + 2;
                pointerSegment = new PointerSegment(pointerSegment2, currentName, -1);
            } else if (jsonStreamContext.inArray() || z10) {
                length += 6;
                pointerSegment = new PointerSegment(pointerSegment2, null, jsonStreamContext.getCurrentIndex());
            } else {
                jsonStreamContext = jsonStreamContext.getParent();
            }
            pointerSegment2 = pointerSegment;
            jsonStreamContext = jsonStreamContext.getParent();
        }
        if (pointerSegment2 == null) {
            return EMPTY;
        }
        StringBuilder sb2 = new StringBuilder(length);
        PointerSegment pointerSegment3 = null;
        PointerSegment pointerSegment4 = pointerSegment2;
        while (pointerSegment4 != null) {
            pointerSegment4.pathOffset = sb2.length();
            sb2.append(SEPARATOR);
            String str = pointerSegment4.property;
            if (str != null) {
                _appendEscaped(sb2, str);
            } else {
                sb2.append(pointerSegment4.index);
            }
            PointerSegment pointerSegment5 = pointerSegment4;
            pointerSegment4 = pointerSegment4.next;
            pointerSegment3 = pointerSegment5;
        }
        String string = sb2.toString();
        JsonPointer jsonPointer = EMPTY;
        while (pointerSegment3 != null) {
            String str2 = pointerSegment3.property;
            if (str2 != null) {
                jsonPointer = new JsonPointer(string, pointerSegment3.pathOffset, str2, jsonPointer);
            } else {
                int i10 = pointerSegment3.index;
                jsonPointer = new JsonPointer(string, pointerSegment3.pathOffset, String.valueOf(i10), i10, jsonPointer);
            }
            pointerSegment3 = pointerSegment3.prev;
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
        int i10 = -this._asStringOffset;
        while (this != jsonPointerLast) {
            arrayList.add(new JsonPointer(this, strSubstring, this._asStringOffset + i10));
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
        return compile(toString() + jsonPointer.toString());
    }

    public JsonPointer appendIndex(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Negative index cannot be appended");
        }
        StringBuilder stringBuilder = toStringBuilder(8);
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(i10);
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

    public JsonPointer matchElement(int i10) {
        if (i10 != this._matchingElementIndex || i10 < 0) {
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

    public boolean matchesElement(int i10) {
        return i10 == this._matchingElementIndex && i10 >= 0;
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
        int i10 = this._asStringOffset;
        return i10 <= 0 ? this._asString : this._asString.substring(i10);
    }

    public StringBuilder toStringBuilder(int i10) {
        if (this._asStringOffset <= 0) {
            return new StringBuilder(this._asString);
        }
        int length = this._asString.length();
        StringBuilder sb2 = new StringBuilder((length - this._asStringOffset) + i10);
        sb2.append((CharSequence) this._asString, this._asStringOffset, length);
        return sb2;
    }

    public JsonPointer(String str, int i10, String str2, JsonPointer jsonPointer) {
        this._asString = str;
        this._asStringOffset = i10;
        this._nextSegment = jsonPointer;
        this._matchingPropertyName = str2;
        this._matchingElementIndex = _parseIndex(str2);
    }

    public JsonPointer(String str, int i10, String str2, int i11, JsonPointer jsonPointer) {
        this._asString = str;
        this._asStringOffset = i10;
        this._nextSegment = jsonPointer;
        this._matchingPropertyName = str2;
        this._matchingElementIndex = i11;
    }

    public JsonPointer(JsonPointer jsonPointer, JsonPointer jsonPointer2) {
        this._asString = jsonPointer._asString;
        this._asStringOffset = jsonPointer._asStringOffset;
        this._nextSegment = jsonPointer2;
        this._matchingPropertyName = jsonPointer._matchingPropertyName;
        this._matchingElementIndex = jsonPointer._matchingElementIndex;
    }

    public JsonPointer(JsonPointer jsonPointer, String str, int i10) {
        this._asString = str;
        this._asStringOffset = i10;
        this._nextSegment = null;
        this._matchingPropertyName = jsonPointer._matchingPropertyName;
        this._matchingElementIndex = jsonPointer._matchingElementIndex;
    }
}
