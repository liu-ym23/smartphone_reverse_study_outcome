package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f142700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d f142701b;

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.d
    public final void a(com.bytedance.android.live.ktv.common.model.bean.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r101 = this.f142701b;
        if (r101 == null) goto L8;
        r101.removeWaitingSongUser(r100, this.f142700a);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.d
    public final void b(com.bytedance.android.live.ktv.common.model.bean.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r101 = this.f142701b;
        if (r101 == null) goto L8;
        r101.permitWaitingSongUser(r100, this.f142700a);
        return;
    }

    public a(y r100, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r101) {
        Intrinsics.checkNotNullParameter(r100, "secondLevelTabData");
        this.f142700a = r100;
        this.f142701b = r101;
    }
}
