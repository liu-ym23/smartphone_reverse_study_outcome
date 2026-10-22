package com.bytedance.android.ec.sdk.plugin.initializer;

import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes44.dex */
public final class h extends com.bytedance.android.ec.sdk.initalizer.a {
    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object b() {
        return Boxing.boxBoolean(true);
    }

    public h() {
    }

    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object c(Continuation<? super Unit> r100) {
        ColdLaunchExpFilter.f45205e.getClass();
        if (ColdLaunchExpFilter.a() == false) goto L6;
        ColdLaunchExpFilter.f45202b = true;
    L6:
        return Unit.INSTANCE;
    }
}
