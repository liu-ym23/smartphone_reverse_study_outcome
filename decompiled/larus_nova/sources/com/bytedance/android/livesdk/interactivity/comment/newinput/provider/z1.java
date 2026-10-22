package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class z1 implements com.bytedance.android.livesdk.interactivity.comment.mention.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t1.c f136025a;

    public z1(t1.c r100) {
        this.f136025a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.mention.k
    public final void a(boolean r100) {
        t1.c r101 = this.f136025a;
        if (r101.f135513b.m0() == true) goto L5;
        if (r100 == true) goto L5;
    L6:
        r101.f135985l = true;
        x62.c r102 = r101.f135983j;
        if (r102 == null) goto L10;
        MainThreadPostUtils.e(new x62.b(r102));
        return;
    L10:
        return;
    L5:
        r101.h();
        goto L6
    }
}
