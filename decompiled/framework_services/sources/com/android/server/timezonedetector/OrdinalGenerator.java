package com.android.server.timezonedetector;

import android.util.ArraySet;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
class OrdinalGenerator<T> {
    private final Function<T, T> mCanonicalizationFunction;
    private final ArraySet<T> mKnownIds;

    OrdinalGenerator(Function<T, T> canonicalizationFunction) {
        this.mKnownIds = new ArraySet();
        canonicalizationFunction.getClass();
        this.mCanonicalizationFunction = canonicalizationFunction;
    }

    int ordinal(T object) {
        T canonical = this.mCanonicalizationFunction.apply(object);
        int ordinal = this.mKnownIds.indexOf(canonical);
        if (ordinal >= 0) goto L6;
        int ordinal2 = this.mKnownIds.size();
        this.mKnownIds.add(canonical);
        return ordinal2;
    L6:
        return ordinal;
    }

    int[] ordinals(List<T> objects) {
        int[] ordinals = new int[objects.size()];
        int i = 0;
    L4:
        if (i >= ordinals.length) goto L7;
        ordinals[i] = ordinal(objects.get(i));
        i = i + 1;
        goto L4
    L7:
        return ordinals;
    }
}
