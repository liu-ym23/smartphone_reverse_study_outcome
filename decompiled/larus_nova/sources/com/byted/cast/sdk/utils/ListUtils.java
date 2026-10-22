package com.byted.cast.sdk.utils;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public class ListUtils {

    public interface Filter<T> {
        boolean keepItem(T r100);
    }

    public ListUtils() {
    }

    public static <T> List<T> filter(List<T> r100, Filter<T> r101) {
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (r101.keepItem(r102.next()) == true) goto L4;
        r102.remove();
        goto L4
    L8:
        return r100;
    }
}
