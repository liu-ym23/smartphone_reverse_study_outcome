package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k implements cc0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f143826a;

    @Override // cc0.c
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("TuningEffectManager", "downloadTuningEffect onTuningEffectDownloadSuccess filePath: " + r100);
        this.f143826a.a();
    }

    public k(g r100, com.bytedance.android.live.ktv.common.model.bean.h r101) {
        this.f143826a = r100;
    }
}
