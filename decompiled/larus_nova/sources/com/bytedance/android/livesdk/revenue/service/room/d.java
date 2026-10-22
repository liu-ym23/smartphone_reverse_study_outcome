package com.bytedance.android.livesdk.revenue.service.room;

import com.bytedance.android.livesdkapi.service.IFloatWindowDegradeManager;
import com.bytedance.android.scope.o;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements o, a {
    public d() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.room.a
    public final void checkDegradeForNative(String r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        IFloatWindowDegradeManager r101 = (IFloatWindowDegradeManager) k.f(IFloatWindowDegradeManager.class);
        if (r101 == null) goto L6;
        r101.checkDegradeForNative(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.room.a
    public final void checkRecoverForNative(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter("dismiss", "source");
        IFloatWindowDegradeManager r102 = (IFloatWindowDegradeManager) k.f(IFloatWindowDegradeManager.class);
        if (r102 == null) goto L6;
        r102.checkRecoverForNative(r100, "dismiss");
        return;
    }
}
