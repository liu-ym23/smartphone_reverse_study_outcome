package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.arch.mvvm.f;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.settings.config.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import jc1.k;
import ju1.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseTimingUpdater<c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f139448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IPublicScreenSpeedConfig f139449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Disposable f139450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f139451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j0 f139452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InterfaceC2205a f139453h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.a$a, reason: collision with other inner class name */
    public interface InterfaceC2205a {
        void update(int r100, long r101);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void c() {
        e(new c(this.f139451f.f133485b));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final long d() {
        return this.f139451f.f133484a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void i() {
        super.i();
        Disposable r100 = this.f139450e;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public a(DataCenter r100, j0 r101, com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.c r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "speedListener");
        this.f139452g = r101;
        this.f139453h = r102;
        this.f139448c = 2;
        IRoomContextService r103 = (IRoomContextService) k.f(IRoomContextService.class);
        Disposable r104 = null;
        if (r103 == null) goto L11;
        o r105 = IRoomContextService.a.a(r103, r100, 0, 2);
        if (r105 == null) goto L11;
        j<IDynamicStrategyContext> r106 = r105.r2();
        if (r106 == null) goto L11;
        IDynamicStrategyContext r107 = r106.getValue();
        if (r107 == null) goto L11;
        PropertyOwner<n> r108 = r107.getStrategy("public_screen_speed_strategy");
    L12:
        int r109 = q.f133648a;
        IPublicScreenSpeedConfig r110 = q.g((IRoom) r100.get("data_room"));
        this.f139449d = r110;
        if (r108 == null) goto L19;
        Observable r111 = f.b(r108);
        if (r111 == null) goto L19;
        Observable r112 = RxUtilKt.h(r111);
        if (r112 == null) goto L19;
        r104 = r112.subscribe(new b(this));
    L19:
        this.f139450e = r104;
        e r113 = q.h(r101, -1, r110);
        this.f139451f = r113;
        int r114 = ga2.d.f480547a;
        ga2.d.c(r113.f133484a, r113.f133485b, r113.f133487d);
        e r115 = this.f139451f;
        r102.update(r115.f133487d, r115.f133484a);
        return;
    L11:
        r108 = null;
        goto L12
    }
}
