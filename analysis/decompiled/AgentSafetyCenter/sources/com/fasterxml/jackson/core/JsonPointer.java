package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.NumberInput;
import g5.f;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import k0.a;
import w2.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    public JsonPointer(JsonPointer jsonPointer, JsonPointer jsonPointer2) {
        this._asString = jsonPointer._asString;
        this._asStringOffset = jsonPointer._asStringOffset;
        this._nextSegment = jsonPointer2;
        this._matchingPropertyName = jsonPointer._matchingPropertyName;
        this._matchingElementIndex = jsonPointer._matchingElementIndex;
    }

    private static int _appendEscape(StringBuilder sb2, char c9) {
        if (c9 == '0') {
            sb2.append(ESC);
            return 1;
        }
        if (c9 == '1') {
            sb2.append(SEPARATOR);
            return 1;
        }
        sb2.append(ESC);
        return 0;
    }

    private static void _appendEscaped(StringBuilder sb2, String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '/') {
                sb2.append(ESC_SLASH);
            } else if (cCharAt == '~') {
                sb2.append(ESC_TILDE);
            } else {
                sb2.append(cCharAt);
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

    private final boolean _compare(String str, int i, String str2, int i3) {
        int length = str.length();
        if (length - i != str2.length() - i3) {
            return false;
        }
        while (i < length) {
            int i10 = i + 1;
            int i11 = i3 + 1;
            if (str.charAt(i) != str2.charAt(i3)) {
                return false;
            }
            i = i10;
            i3 = i11;
        }
        return true;
    }

    public static int _extractEscapedSegment(String str, int i, int i3, StringBuilder sb2) {
        int length = str.length();
        int i10 = i3 - 1;
        if (i10 - i > 0) {
            sb2.append((CharSequence) str, i, i10);
        }
        int i_appendEscape = _appendEscape(sb2, str.charAt(i3));
        while (true) {
            i3 += i_appendEscape;
            while (i3 < length) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == '/') {
                    return i3;
                }
                i3++;
                if (cCharAt != '~' || i3 >= length) {
                    sb2.append(cCharAt);
                }
            }
            return -1;
            i_appendEscape = _appendEscape(sb2, str.charAt(i3));
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
        long j10 = Long.parseLong(str);
        if (j10 > 2147483647L) {
            return -1;
        }
        return (int) j10;
    }

    public static JsonPointer _parseTail(String str) {
        int length = str.length();
        PointerParent pointerParent = null;
        int i = 1;
        int i3 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '/') {
                PointerParent pointerParent2 = new PointerParent(pointerParent, i3, str.substring(i3 + 1, i));
                i3 = i;
                i++;
                pointerParent = pointerParent2;
            } else {
                i++;
                if (cCharAt == '~' && i < length) {
                    StringBuilder sb2 = new StringBuilder(32);
                    int i_extractEscapedSegment = _extractEscapedSegment(str, i3 + 1, i, sb2);
                    String string = sb2.toString();
                    if (i_extractEscapedSegment < 0) {
                        return _buildPath(str, i3, string, pointerParent);
                    }
                    PointerParent pointerParent3 = new PointerParent(pointerParent, i3, string);
                    i3 = i_extractEscapedSegment;
                    i = i_extractEscapedSegment + 1;
                    pointerParent = pointerParent3;
                }
            }
        }
        return _buildPath(str, i3, str.substring(i3 + 1), pointerParent);
    }

    public static JsonPointer compile(String str) {
        if (str == null || str.length() == 0) {
            return EMPTY;
        }
        if (str.charAt(0) == '/') {
            return _parseTail(str);
        }
        f.s(a.C("Invalid input: JSON Pointer expression must start with '/': \"", str, "\""));
        return null;
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
        StringBuilder sb2 = new StringBuilder(i);
        PointerSegment pointerSegment2 = null;
        PointerSegment pointerSegment3 = pointerSegment;
        while (pointerSegment3 != null) {
            pointerSegment3.pathOffset = sb2.length();
            sb2.append(SEPARATOR);
            String str = pointerSegment3.property;
            if (str != null) {
                _appendEscaped(sb2, str);
            } else {
                sb2.append(pointerSegment3.index);
            }
            PointerSegment pointerSegment4 = pointerSegment3;
            pointerSegment3 = pointerSegment3.next;
            pointerSegment2 = pointerSegment4;
        }
        String string = sb2.toString();
        JsonPointer jsonPointer = EMPTY;
        while (pointerSegment2 != null) {
            String str2 = pointerSegment2.property;
            if (str2 != null) {
                jsonPointer = new JsonPointer(string, pointerSegment2.pathOffset, str2, jsonPointer);
            } else {
                int i3 = pointerSegment2.index;
                jsonPointer = new JsonPointer(string, pointerSegment2.pathOffset, String.valueOf(i3), i3, jsonPointer);
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
        StringBuilder sbC = c.c(toString());
        sbC.append(jsonPointer.toString());
        return compile(sbC.toString());
    }

    public JsonPointer appendIndex(int i) {
        if (i < 0) {
            f.s("Negative index cannot be appended");
            return null;
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
        String str = this._asString;
        return i <= 0 ? str : str.substring(i);
    }

    public StringBuilder toStringBuilder(int i) {
        int i3 = this._asStringOffset;
        String str = this._asString;
        if (i3 <= 0) {
            return new StringBuilder(str);
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder((length - this._asStringOffset) + i);
        sb2.append((CharSequence) this._asString, this._asStringOffset, length);
        return sb2;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Serialization implements Externalizable {
        private String _fullPath;

        public Serialization(String str) {
            this._fullPath = str;
        }

        private Object readResolve() {
            return JsonPointer.compile(this._fullPath);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) {
            this._fullPath = objectInput.readUTF();
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeUTF(this._fullPath);
        }

        public Serialization() {
        }
    }

    public JsonPointer(String str, int i, String str2, JsonPointer jsonPointer) {
        this._asString = str;
        this._asStringOffset = i;
        this._nextSegment = jsonPointer;
        this._matchingPropertyName = str2;
        this._matchingElementIndex = _parseIndex(str2);
    }

    public JsonPointer(String str, int i, String str2, int i3, JsonPointer jsonPointer) {
        this._asString = str;
        this._asStringOffset = i;
        this._nextSegment = jsonPointer;
        this._matchingPropertyName = str2;
        this._matchingElementIndex = i3;
    }

    public JsonPointer() {
        this._nextSegment = null;
        this._matchingPropertyName = null;
        this._matchingElementIndex = -1;
        this._asString = "";
        this._asStringOffset = 0;
    }

    public JsonPointer(JsonPointer jsonPointer, String str, int i) {
        this._asString = str;
        this._asStringOffset = i;
        this._nextSegment = null;
        this._matchingPropertyName = jsonPointer._matchingPropertyName;
        this._matchingElementIndex = jsonPointer._matchingElementIndex;
    }
}
