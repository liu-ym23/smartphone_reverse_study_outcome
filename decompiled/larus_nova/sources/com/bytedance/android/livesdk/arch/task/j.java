package com.bytedance.android.livesdk.arch.task;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j extends a {
    public j() {
        super(TaskId.PreloadContent);
    }

    @Override // com.bytedance.android.livesdk.arch.task.a
    public final void f(e r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        a.e(r100, new ne1.b.c());
        a.d(this);
    }
}
