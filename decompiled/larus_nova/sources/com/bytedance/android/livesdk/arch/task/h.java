package com.bytedance.android.livesdk.arch.task;

import com.bytedance.android.livesdk.arch.lifecycle.ITbLifecycle;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends a {
    public h() {
        super(TaskId.MarkOnDestroy);
    }

    @Override // com.bytedance.android.livesdk.arch.task.a
    public final void f(e r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        r100.d().a(ITbLifecycle.State.Destroyed);
        a.d(this);
    }
}
