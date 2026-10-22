package com.bytedance.android.shopping.card_list.utils;

import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f171915a;

    public d(Function0 r100) {
        this.f171915a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f171915a.invoke();
    }
}
