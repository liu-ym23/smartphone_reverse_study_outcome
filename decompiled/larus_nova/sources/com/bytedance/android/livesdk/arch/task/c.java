package com.bytedance.android.livesdk.arch.task;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ne1.b.C6918b f103895e;

    public c(ne1.b.C6918b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(TaskId.HandleBehavior);
        this.f103895e = r100;
    }

    @Override // com.bytedance.android.livesdk.arch.task.a
    public final void f(e r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        a.e(r100, this.f103895e);
        a.d(this);
    }
}
