package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest;
import com.bytedance.platform.aio.ServiceHub;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes47.dex */
public abstract class m implements dy0.c, ny0.a, com.bytedance.android.live.revenue.platform.container.impl.core.g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f91312e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BehaviorSubject<a> f91313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ServiceHub f91314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<KClass<?>, Object> f91315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f91316d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.platform.aio.a f91317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final NotifyServiceCenterStateRequest.State f91318b;

        public a() {
            this(0);
        }

        public /* synthetic */ a(int r100) {
            this(null, NotifyServiceCenterStateRequest.State.STOPPED);
        }

        public a(com.bytedance.platform.aio.a r100, NotifyServiceCenterStateRequest.State r101) {
            Intrinsics.checkNotNullParameter(r101, "state");
            this.f91317a = r100;
            this.f91318b = r101;
        }
    }

    public static final class b {
    }

    static {
        f91312e = CollectionsKt.listOf(new String[]{"webcast.revenue.biz.gift.dialog.expansion_controls.ExpansionControlsDataUseCase", "webcast.revenue.biz.gift.dialog.top.GiftTopPanelDataUseCase", "webcast.revenue.biz.gift.dialog.top.GiftDIYCardService", "webcast.revenue.biz.gift.dialog.top.GiftBuffCardService", "webcast.revenue.biz.gift.dialog.top.GiftOperationDataUseCase"});
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final void E() {
        this.f91313a.onNext(new a(0));
        ((ArrayList) this.f91316d).clear();
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final NotifyServiceCenterStateRequest.State b0() {
        a r100 = this.f91313a.getValue();
        Intrinsics.checkNotNull(r100);
        return r100.f91318b;
    }

    public m() {
        int r100 = com.bytedance.revenue.platform.api.core.rx.c.f267509a;
        this.f91313a = BehaviorSubject.createDefault(new a(0));
        this.f91314b = new ServiceHub();
        this.f91315c = new LinkedHashMap();
        this.f91316d = new ArrayList();
    }

    @Override // ny0.a
    public final void J0(com.bytedance.platform.aio.a r100) {
        Intrinsics.checkNotNullParameter(r100, "driver");
        ServiceHub r101 = this.f91314b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "driver");
        if (r101.f266546a.add(r100) == false) goto L6;
        r100.g(r101);
        return;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final void L0(RevenueJsDriver r100) {
        Intrinsics.checkNotNullParameter(r100, "driver");
        jy0.b.d("[AioLink]", "preloadCenterDriver");
        this.f91313a.onNext(new a(r100, NotifyServiceCenterStateRequest.State.PRE_STARTED));
        ((ArrayList) this.f91316d).clear();
    }

    @Override // ny0.a
    public final void g(com.bytedance.platform.aio.a r100) {
        Intrinsics.checkNotNullParameter(r100, "driver");
        this.f91314b.c(r100);
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final void I(List r100, RevenueJsDriver r101) {
        Intrinsics.checkNotNullParameter(r100, "interfaceIds");
        Intrinsics.checkNotNullParameter(r101, "driver");
        jy0.b.d("[AioLink]", "loadedCenterDriver");
        a r102 = this.f91313a.getValue();
        Intrinsics.checkNotNull(r102);
        if (Intrinsics.areEqual(r101, r102.f91317a) == false) goto L7;
        a r103 = this.f91313a.getValue();
        Intrinsics.checkNotNull(r103);
        if (r103.f91318b != NotifyServiceCenterStateRequest.State.STARTED) goto L7;
        this.f91313a.onNext(new a(r101, NotifyServiceCenterStateRequest.State.SCRIPTS_LOADED));
        ((ArrayList) this.f91316d).addAll(r100);
        return;
    L7:
        jy0.b.c("RevenueContainerRpcServiceImpl", "wrong centerDriver state", null, 4);
        int r104 = com.bytedance.android.live.core.utils.w.f66424a;
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L11;
        return;
    L11:
        throw new IllegalStateException("wrong centerDriver state");
    }

    @Override // ny0.a
    public final void a(String r100, com.bytedance.platform.aio.a r101) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        Intrinsics.checkNotNullParameter(r101, "driver");
        this.f91314b.a(r100, r101);
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final void w0(List r100, RevenueJsDriver r101) {
        Intrinsics.checkNotNullParameter(r100, "interfaceIds");
        Intrinsics.checkNotNullParameter(r101, "driver");
        jy0.b.d("[AioLink]", "startCenterDriver");
        this.f91313a.onNext(new a(r101, NotifyServiceCenterStateRequest.State.STARTED));
        ((ArrayList) this.f91316d).clear();
        ArrayList r102 = (ArrayList) this.f91316d;
        r102.addAll(r100);
    }

    @Override // ny0.a
    public final Object A(String r110, String r111, JsonObject r112, String r113, i57.g r114) {
        Intrinsics.checkNotNullParameter(r110, "interfaceId");
        Intrinsics.checkNotNullParameter(r111, "methodId");
        Intrinsics.checkNotNullParameter(r112, "argument");
        Intrinsics.checkNotNullParameter(r113, "url");
        Intrinsics.checkNotNullParameter(r114, "callContext");
        com.bytedance.platform.aio.a r100 = this.f91314b.b(r110);
        if (r100 == null) goto L5;
        j57.a r115 = r100.c(r110, r111, new v(r112, null, r113, "initial_prop", r114));
    L6:
        if (r115 == null) goto L11;
        Exception r116 = r115.f497467c;
        if (r116 == null) goto L11;
        throw r116;
    L11:
        if (r115 != null) goto L13;
        return null;
    L13:
        return r115.f497466b;
    L5:
        r115 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final Observable K(Set r100, String r110, String r111, z r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "waitForState");
        Intrinsics.checkNotNullParameter(r110, "interfaceId");
        Intrinsics.checkNotNullParameter(r111, "methodId");
        Intrinsics.checkNotNullParameter(r112, "arguments");
        CompositeDisposable r101 = new CompositeDisposable();
        if (r113 == false) goto L14;
        a r114 = this.f91313a.getValue();
        if (r114 == null) goto L10;
        NotifyServiceCenterStateRequest.State r115 = r114.f91318b;
        if (r115 == null) goto L10;
        boolean r116 = r100.contains(r115);
    L11:
        if (r116 == true) goto L14;
        com.bytedance.revenue.platform.api.core.rx.l r102 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        return Observable.error(com.bytedance.platform.aio.d.f(r110));
    L10:
        r116 = false;
    L14:
        com.bytedance.revenue.platform.api.core.rx.l r117 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        return Observable.create(new p(this, r101, r100, r110, r111, r112));
    }
}
