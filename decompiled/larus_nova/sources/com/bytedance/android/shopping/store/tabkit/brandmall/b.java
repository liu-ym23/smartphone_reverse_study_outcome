package com.bytedance.android.shopping.store.tabkit.brandmall;

import com.bytedance.android.shopping.store.tabkit.model.z;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TabkitFirstFramePref f186577a;

    public b(TabkitFirstFramePref r100) {
        this.f186577a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        z r101 = (z) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        TabkitFirstFramePref r102 = this.f186577a;
        if (r102 == null) goto L5;
        TabkitFramePref.recordTime$default(r102, TabkitFirstFramePref.T_REQUEST_END, null, 2, null);
    L5:
        return r101;
    }
}
