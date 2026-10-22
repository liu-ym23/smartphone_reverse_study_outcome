package com.bytedance.android.livesdk.arch.task;

import com.bytedance.android.livesdk.arch.lifecycle.ITbLifecycle;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends a {
    public g() {
        super(TaskId.MarkOnCreate);
    }

    @Override // com.bytedance.android.livesdk.arch.task.a
    public final void f(e r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        com.bytedance.android.livesdk.arch.comp.b r101 = r100.d();
        ITbLifecycle.State r102 = r101.f103726e.f64752a;
        ITbLifecycle.State r103 = ITbLifecycle.State.Created;
        if ((!r102.isAtLeast(r103)) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L8;
        r101.a(r103);
    L8:
        a.d(this);
    }
}
