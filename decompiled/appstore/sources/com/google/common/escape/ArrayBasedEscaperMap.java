package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public final class ArrayBasedEscaperMap {
    private static final char[][] EMPTY_REPLACEMENT_ARRAY = null;
    private final char[][] replacementArray;

    static {
        EMPTY_REPLACEMENT_ARRAY = (char[][]) Array.newInstance(Character.TYPE, new int[]{0, 0});
    }

    private ArrayBasedEscaperMap(char[][] r10) {
        this.replacementArray = r10;
    }

    public static ArrayBasedEscaperMap create(Map<Character, String> r10) {
        return new ArrayBasedEscaperMap(createReplacementArray(r10));
    }

    @VisibleForTesting
    public static char[][] createReplacementArray(Map<Character, String> r10) {
        Preconditions.checkNotNull(r10);
        if (r10.isEmpty() == true) goto L5;
        char[][] r11 = new char[((Character) Collections.max(r10.keySet())).charValue() + 1][];
        Iterator<Character> r12 = r10.keySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        Character r13 = r12.next();
        r11[r13.charValue()] = r10.get(r13).toCharArray();
        goto L8
    L10:
        return r11;
    L5:
        return EMPTY_REPLACEMENT_ARRAY;
    }

    public char[][] getReplacementArray() {
        return this.replacementArray;
    }
}
