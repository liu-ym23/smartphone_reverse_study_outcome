package com.bytedance.android.livesdk.revenue.service.performance;

import com.bytedance.android.livesdkapi.wto.IWTOManager;
import com.bytedance.android.scope.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class RevWTOManagerImpl implements e, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f157422a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public RevWTOManagerImpl() {
        this.f157422a = LazyKt.lazy(RevWTOManagerImpl$service$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.e
    public final void ni(yz1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "repeatableTask");
        IWTOManager r101 = (IWTOManager) this.f157422a.getValue();
        if (r101 == null) goto L6;
        r101.commitRepeatableTask(new lq2.d(r100));
        return;
    }
}
