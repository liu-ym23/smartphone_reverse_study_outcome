package com.bytedance.android.live.base.model.user;

import com.bytedance.android.livesdk.utils.d5;

/* JADX INFO: loaded from: classes45.dex */
public final class p0 implements o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f58949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f58950c;

    @Override // com.bytedance.android.live.base.model.user.o0
    public final long getAwemeUserId() {
        return d5.c(this.f58949b);
    }

    @Override // com.bytedance.android.live.base.model.user.o0
    public final String getOpenUserId() {
        String r100 = this.f58950c;
        if (r100 != null) goto L6;
        return "0";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.live.base.model.user.o0
    public final boolean a() {
        return o0.b.a(this);
    }

    @Override // com.bytedance.android.live.base.model.user.o0
    public final String getUserId() {
        return getOpenUserId();
    }

    public p0(String r100, String r101) {
        this.f58949b = r100;
        this.f58950c = r101;
    }
}
