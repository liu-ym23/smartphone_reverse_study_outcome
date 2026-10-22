package com.google.android.material.color.utilities;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class QuantizerCelebi {
    private QuantizerCelebi() {
    }

    public static Map<Integer, Integer> quantize(int[] r5, int r6) {
        Set<Integer> r0 = new QuantizerWu().quantize(r5, r6).colorToCount.keySet();
        int[] r1 = new int[r0.size()];
        Iterator<Integer> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L7;
        r1[r3] = r2.next().intValue();
        r3 = r3 + 1;
        goto L4
    L7:
        return QuantizerWsmeans.quantize(r5, r1, r6);
    }
}
