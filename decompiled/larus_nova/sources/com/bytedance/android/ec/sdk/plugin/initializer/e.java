package com.bytedance.android.ec.sdk.plugin.initializer;

import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends com.bytedance.android.ec.sdk.initalizer.a {
    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object b() {
        return Boxing.boxBoolean(true);
    }

    public e() {
    }

    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object c(Continuation<? super Unit> r100) {
        Lazy r101 = ECFontHelper.f45588a;
        int r102 = ECSdk.f48106a;
        cj.b r103 = (cj.b) ECSdk.a(cj.b.class);
        if (r103 == null) goto L6;
        r103.c();
    L6:
        return Unit.INSTANCE;
    }
}
