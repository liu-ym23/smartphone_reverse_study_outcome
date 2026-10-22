package com.bytedance.android.live.ktv.common.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tb0.a f70684a;

    public d(tb0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "lc");
        this.f70684a = r100;
    }

    @Override // com.bytedance.android.live.ktv.common.util.m
    public final void b(tb0.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.bytedance.android.live.ktv.common.util.m
    public final void a(tb0.b r100, tb0.c r101) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Intrinsics.checkNotNullParameter(r101, "state");
        if ((r100 instanceof tb0.b.a) == false) goto L6;
        this.f70684a.onBizEnterRoom();
        return;
    L6:
        if ((r100 instanceof tb0.b.C7706b) == false) goto L9;
        this.f70684a.onBizLeaveRoom();
        return;
    L9:
        if ((r100 instanceof tb0.b.d) == false) goto L12;
        this.f70684a.onBizShow();
        return;
    L12:
        if ((r100 instanceof tb0.b.c) == false) goto L15;
        this.f70684a.onBizHide();
        return;
    L15:
        if ((r100 instanceof tb0.b.e) == false) goto L22;
        this.f70684a.onBizDestory();
        return;
    }
}
