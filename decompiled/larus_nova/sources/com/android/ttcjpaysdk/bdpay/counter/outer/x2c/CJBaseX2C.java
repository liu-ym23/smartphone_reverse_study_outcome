package com.android.ttcjpaysdk.bdpay.counter.outer.x2c;

import android.util.SparseArray;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/x2c/CJBaseX2C;", "", "()V", "viewCache", "Landroid/util/SparseArray;", "Landroid/view/View;", "getViewCache", "()Landroid/util/SparseArray;", "setViewCache", "(Landroid/util/SparseArray;)V", "getLayoutId", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJBaseX2C {
    private SparseArray<View> viewCache;

    public abstract int getLayoutId();

    public CJBaseX2C() {
        this.viewCache = new SparseArray();
    }

    public final SparseArray<View> getViewCache() {
        return this.viewCache;
    }

    public final void setViewCache(SparseArray<View> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.viewCache = r100;
    }
}
