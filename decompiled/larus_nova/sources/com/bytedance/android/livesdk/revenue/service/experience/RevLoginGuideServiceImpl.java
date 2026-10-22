package com.bytedance.android.livesdk.revenue.service.experience;

import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.scope.o;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class RevLoginGuideServiceImpl implements o, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f157311a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.experience.b
    public final boolean qf() {
        return ((ILoginGuideService) this.f157311a.getValue()).intercept(new q61.c(new q61.b.a(cz.c.n.f466008c)));
    }

    public RevLoginGuideServiceImpl() {
        this.f157311a = LazyKt.lazy(RevLoginGuideServiceImpl$service$2.INSTANCE);
    }
}
