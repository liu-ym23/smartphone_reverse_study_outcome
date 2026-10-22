package com.bytedance.android.window.shop.holder.presenter;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class i implements com.bytedance.android.ec.window.base.common.bubble.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f188134a;

    @Override // com.bytedance.android.ec.window.base.common.bubble.g
    public final void onShow() {
    }

    @Override // com.bytedance.android.ec.window.base.common.bubble.g
    public final void onDismiss() {
        Function0 r100 = this.f188134a.f188139e;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
        return;
    }

    public i(j r100) {
        this.f188134a = r100;
    }
}
