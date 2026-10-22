package com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor;

import android.util.LruCache;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Map;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class LivePromotionListRepositoryMonitor implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f150929c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f150930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache<String, Stack<pj2.a>> f150931b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b
    public final void clear() {
        new AnonymousClass1(this).invoke();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public LivePromotionListRepositoryMonitor() {
        this.f150930a = LazyKt.lazy(LivePromotionListRepositoryMonitor$liveRoomParams$2.INSTANCE);
        this.f150931b = new LruCache(10);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b
    public final void b(final pj2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        new LivePromotionListRepositoryMonitor$monitorDuration$1(this, r100).invoke();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.b
    public final void a(final c r100, final Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        new LivePromotionListRepositoryMonitor$report$1(this, r100, r101).invoke();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
