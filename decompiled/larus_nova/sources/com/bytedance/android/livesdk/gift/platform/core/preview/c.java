package com.bytedance.android.livesdk.gift.platform.core.preview;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f130982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f130983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f130984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f130985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.effect.a f130986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.message.d f130987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e1 f130988g;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public c(com.bytedance.android.livesdk.revenue.service.effect.a r100, com.bytedance.android.livesdk.revenue.service.message.d r101, e1 r102) {
        Intrinsics.checkNotNullParameter(r100, "notifyMessageSender");
        Intrinsics.checkNotNullParameter(r101, "messageManagerService");
        Intrinsics.checkNotNullParameter(r102, "listService");
        this.f130986e = r100;
        this.f130987f = r101;
        this.f130988g = r102;
        this.f130982a = com.bytedance.android.livesdk.gift.platform.business.a.d().a();
        this.f130983b = com.bytedance.android.livesdk.gift.platform.business.a.d().b();
        this.f130984c = com.bytedance.android.livesdk.gift.platform.business.a.d().c();
        this.f130985d = true;
    }
}
