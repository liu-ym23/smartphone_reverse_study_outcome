package com.fasterxml.jackson.databind.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class CompactStringObjectMap implements Serializable {
    private static final CompactStringObjectMap EMPTY = new CompactStringObjectMap(1, 0, new Object[4]);
    private static final long serialVersionUID = 1;
    private final Object[] _hashArea;
    private final int _hashMask;
    private final int _spillCount;

    private CompactStringObjectMap(int i, int i3, Object[] objArr) {
        this._hashMask = i;
        this._spillCount = i3;
        this._hashArea = objArr;
    }

    private final Object _find2(String str, int i, Object obj) {
        if (obj == null) {
            return null;
        }
        int i3 = this._hashMask + 1;
        int i10 = ((i >> 1) + i3) << 1;
        Object obj2 = this._hashArea[i10];
        if (str.equals(obj2)) {
            return this._hashArea[i10 + 1];
        }
        if (obj2 != null) {
            int i11 = (i3 + (i3 >> 1)) << 1;
            int i12 = this._spillCount + i11;
            while (i11 < i12) {
                Object obj3 = this._hashArea[i11];
                if (obj3 == str || str.equals(obj3)) {
                    return this._hashArea[i11 + 1];
                }
                i11 += 2;
            }
        }
        return null;
    }

    public static <T> CompactStringObjectMap construct(Map<String, T> map) {
        if (map.isEmpty()) {
            return EMPTY;
        }
        int iFindSize = findSize(map.size());
        int i = iFindSize - 1;
        int i3 = (iFindSize >> 1) + iFindSize;
        Object[] objArrCopyOf = new Object[i3 * 2];
        int i10 = 0;
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                int iHashCode = key.hashCode() & i;
                int i11 = iHashCode + iHashCode;
                if (objArrCopyOf[i11] != null) {
                    i11 = ((iHashCode >> 1) + iFindSize) << 1;
                    if (objArrCopyOf[i11] != null) {
                        i11 = (i3 << 1) + i10;
                        i10 += 2;
                        if (i11 >= objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, objArrCopyOf.length + 4);
                        }
                    }
                }
                objArrCopyOf[i11] = key;
                objArrCopyOf[i11 + 1] = entry.getValue();
            }
        }
        return new CompactStringObjectMap(i, i10, objArrCopyOf);
    }

    private static final int findSize(int i) {
        if (i <= 5) {
            return 8;
        }
        if (i <= 12) {
            return 16;
        }
        int i3 = 32;
        while (i3 < i + (i >> 2)) {
            i3 += i3;
        }
        return i3;
    }

    public Object find(String str) {
        int iHashCode = str.hashCode() & this._hashMask;
        int i = iHashCode << 1;
        Object obj = this._hashArea[i];
        return (obj == str || str.equals(obj)) ? this._hashArea[i + 1] : _find2(str, iHashCode, obj);
    }

    public Object findCaseInsensitive(String str) {
        int length = this._hashArea.length;
        for (int i = 0; i < length; i += 2) {
            Object obj = this._hashArea[i];
            if (obj != null && ((String) obj).equalsIgnoreCase(str)) {
                return this._hashArea[i + 1];
            }
        }
        return null;
    }

    public List<String> keys() {
        int length = this._hashArea.length;
        ArrayList arrayList = new ArrayList(length >> 2);
        for (int i = 0; i < length; i += 2) {
            Object obj = this._hashArea[i];
            if (obj != null) {
                arrayList.add((String) obj);
            }
        }
        return arrayList;
    }
}
