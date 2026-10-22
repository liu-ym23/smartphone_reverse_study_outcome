package com.bytedance.android.ec.opt.asyncInflate;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static /* synthetic */ View a(ShoppingAsyncInflater r100, int r101, ViewGroup r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.aU(r101, r102, false);
    }
}
