package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.kmp.livesdk.gift.platform.GiftContext;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftKmpInRoomService implements v2, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<GiftContext, ? extends Disposable> f131286a;

    public GiftKmpInRoomService() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.v2
    public final GiftContext bl() {
        Pair<GiftContext, ? extends Disposable> r100 = this.f131286a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getFirst();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        jy0.b.a("GiftKmpInRoomService", WidgetCostModule.TYPE_ON_START);
        this.f131286a = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        jy0.b.a("GiftKmpInRoomService", "onStop");
        Pair<GiftContext, ? extends Disposable> r100 = this.f131286a;
        if (r100 == null) goto L8;
        Disposable r101 = r100.getSecond();
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    L9:
        return;
    }
}
