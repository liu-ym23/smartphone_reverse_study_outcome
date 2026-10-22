package com.bytedance.android.shopping.sku.common.utils;

import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f182784a;

    public f(Function0 r100) {
        this.f182784a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f182784a.invoke();
    }
}
