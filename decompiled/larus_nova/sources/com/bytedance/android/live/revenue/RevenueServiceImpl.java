package com.bytedance.android.live.revenue;

import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016R\u001b\u0010\r\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/revenue/RevenueServiceImpl;", "Lcom/bytedance/android/live/revenue/IRevenueService;", "Lcom/bytedance/android/live/revenue/ILiveRevenueService;", "Lcom/bytedance/live/kmp/core/a;", "createLiveRoomInstance", "roomInstance", "Lcom/bytedance/android/live/revenue/core/b;", "createRevenueInstance", "Lgy0/a;", "hybridService$delegate", "Lkotlin/Lazy;", "getHybridService", "()Lgy0/a;", "hybridService", "Lp01/a;", "roomRequestService$delegate", "getRoomRequestService", "()Lp01/a;", "roomRequestService", "Lfy0/a;", "widgetService$delegate", "getWidgetService", "()Lfy0/a;", "widgetService", "<init>", "()V", "revenue-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RevenueServiceImpl implements IRevenueService, ILiveRevenueService {
    private final Lazy hybridService$delegate;
    private final Lazy roomRequestService$delegate;
    private final Lazy widgetService$delegate;

    @Override // com.bytedance.android.live.revenue.ILiveRevenueService
    public gy0.a getHybridService() {
        return (gy0.a) this.hybridService$delegate.getValue();
    }

    @Override // com.bytedance.android.live.revenue.ILiveRevenueService
    public p01.a getRoomRequestService() {
        return (p01.a) this.roomRequestService$delegate.getValue();
    }

    @Override // com.bytedance.android.live.revenue.ILiveRevenueService
    public fy0.a getWidgetService() {
        return (fy0.a) this.widgetService$delegate.getValue();
    }

    @Override // com.bytedance.android.live.revenue.ILiveRevenueService
    public com.bytedance.live.kmp.core.a createLiveRoomInstance() {
        return new ab0.a();
    }

    public RevenueServiceImpl() {
        LiveInitAssistant r100 = LiveInitAssistant.INSTANCE;
        r100.markTimeStart("revenue_service_init_duration");
        if (r100.getInitConfigInner().isLiveInitArcOpt() == true) goto L5;
        RevenueInitializer.INSTANCE.ensureInitialized();
    L5:
        r100.markTimeEnd("revenue_service_init_duration");
        this.hybridService$delegate = LazyKt.lazy(RevenueServiceImpl$hybridService$2.INSTANCE);
        this.roomRequestService$delegate = LazyKt.lazy(RevenueServiceImpl$roomRequestService$2.INSTANCE);
        this.widgetService$delegate = LazyKt.lazy(RevenueServiceImpl$widgetService$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.revenue.ILiveRevenueService
    public com.bytedance.android.live.revenue.core.b createRevenueInstance(com.bytedance.live.kmp.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "roomInstance");
        RevenueInitializer.INSTANCE.ensureInitialized();
        return new com.bytedance.android.live.revenue.core.e(r100);
    }
}
