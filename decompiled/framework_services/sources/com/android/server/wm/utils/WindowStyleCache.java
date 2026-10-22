package com.android.server.wm.utils;

import android.content.res.TypedArray;
import android.util.ArrayMap;
import android.util.SparseArray;
import com.android.internal.R;
import com.android.internal.policy.AttributeCache;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class WindowStyleCache<T> {
    private final ArrayMap<String, SparseArray<T>> mCache;
    private final Function<TypedArray, T> mEntryFactory;

    public WindowStyleCache(Function<TypedArray, T> entryFactory) {
        this.mCache = new ArrayMap();
        this.mEntryFactory = entryFactory;
    }

    public T get(String packageName, int theme, int userId) {
        ArrayMap<String, SparseArray<T>> r0 = this.mCache;
        monitor-enter(r0);
        SparseArray<T> themeMap = this.mCache.get(packageName);     // Catch: Throwable -> L10
        if (themeMap == null) goto L12;
        T style = themeMap.get(theme);     // Catch: Throwable -> L10
        if (style == null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return style;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        AttributeCache attributeCache = AttributeCache.instance();
        if (attributeCache != null) goto L16;
        return null;
    L16:
        AttributeCache.Entry ent = attributeCache.get(packageName, theme, R.styleable.Window, userId);
        if (ent != null) goto L19;
        return null;
    L19:
        T style2 = this.mEntryFactory.apply(ent.array);
        ArrayMap<String, SparseArray<T>> r5 = this.mCache;
        monitor-enter(r5);
        if (themeMap == null) goto L32;
    L25:
        themeMap.put(theme, style2);     // Catch: Throwable -> L23
        monitor-exit(r5);     // Catch: Throwable -> L23
        return style2;
    L23:
        th = move-exception;
        throw th;
    L32:
        ArrayMap<String, SparseArray<T>> r1 = this.mCache;     // Catch: Throwable -> L23
        SparseArray<T> r6 = new SparseArray();     // Catch: Throwable -> L23
        themeMap = r6;
        r1.put(packageName, r6);     // Catch: Throwable -> L23
    L10:
        th = move-exception;
        throw th;
    }

    public void invalidatePackage(String packageName) {
        ArrayMap<String, SparseArray<T>> r0 = this.mCache;
        monitor-enter(r0);
        this.mCache.remove(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
