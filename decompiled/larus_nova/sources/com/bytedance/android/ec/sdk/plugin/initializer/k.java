package com.bytedance.android.ec.sdk.plugin.initializer;

import com.bytedance.android.ec.sdk.ECSdk;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes44.dex */
public final class k extends com.bytedance.android.ec.sdk.initalizer.a {
    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object b() {
        return Boxing.boxBoolean(true);
    }

    public k() {
    }

    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object c(Continuation<? super Unit> r100) {
        AtomicBoolean r101 = com.bytedance.android.ec.core.anchorv3.f.f43800a;
        int r102 = ECSdk.f48106a;
        s83.g r103 = (s83.g) ECSdk.a(s83.g.class);
        if (r103 == null) goto L6;
        r103.v(com.bytedance.android.ec.core.anchorv3.d.f43799a);
    L6:
        return Unit.INSTANCE;
    }
}
