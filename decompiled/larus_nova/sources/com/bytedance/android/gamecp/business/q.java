package com.bytedance.android.gamecp.business;

import com.bytedance.android.gamecp.hybrid_impl.jsb.f1;

/* JADX INFO: loaded from: classes44.dex */
public final class q implements com.bytedance.android.gamecp.business.props.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.u f56413a;

    public q(f1 r100) {
        this.f56413a = r100;
    }

    @Override // com.bytedance.android.gamecp.business.props.c
    public final void a(boolean r100) {
        com.bytedance.android.gamecp.base.core.service.depend.u r101 = this.f56413a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
