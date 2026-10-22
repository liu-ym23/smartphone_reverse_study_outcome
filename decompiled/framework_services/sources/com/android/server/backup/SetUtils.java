package com.android.server.backup;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SetUtils {
    private SetUtils() {
    }

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet(set1);
        unionSet.addAll(set2);
        return unionSet;
    }
}
