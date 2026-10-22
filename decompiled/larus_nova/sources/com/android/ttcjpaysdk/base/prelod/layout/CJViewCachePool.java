package com.android.ttcjpaysdk.base.prelod.layout;

import android.view.View;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/prelod/layout/CJViewCachePool;", "", "()V", "viewCache", "", "", "Landroid/view/View;", "cacheView", "", "layoutId", "view", "clear", "hasView", "", "popView", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJViewCachePool {
    private volatile Map<Integer, View> viewCache;

    public final void clear() {
        this.viewCache.clear();
    }

    public CJViewCachePool() {
        this.viewCache = new ConcurrentHashMap();
    }

    public final boolean hasView(int r100) {
        if (this.viewCache.get(Integer.valueOf(r100)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final View popView(int r100) {
        View r101 = this.viewCache.get(Integer.valueOf(r100));
        if (r101 == null) goto L5;
        this.viewCache.remove(Integer.valueOf(r100));
    L5:
        return r101;
    }

    public final void cacheView(int r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        Integer r102 = Integer.valueOf(r100);
        this.viewCache.put(r102, r101);
    }
}
