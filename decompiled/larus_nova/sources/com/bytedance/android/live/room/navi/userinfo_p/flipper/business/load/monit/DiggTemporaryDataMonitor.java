package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/DiggTemporaryDataMonitor;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/BaseTabDataMonitor;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DiggTemporaryDataMonitor extends BaseTabDataMonitor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f100001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u91.a f100002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f100003j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f100004k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, s91.b
    public final void a() {
        INavigationProxyService r100 = (INavigationProxyService) k.f(INavigationProxyService.class);
        if (r100 == null) goto L14;
        l81.d r101 = r100.getDiggContext(this.f99998f);
        if (r101 == null) goto L15;
        m<Long> r102 = r101.c(this.f99997e);
        if (r102 == null) goto L16;
        Observable<Long> r103 = r102.a();
        if (r103 == null) goto L17;
        Disposable r104 = r103.subscribe(new d(this));
        if (r104 == null) goto L18;
        Intrinsics.checkNotNullParameter(r104, "$this$autoBind");
        this.f99994b.add(r104);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, s91.b
    public final void reset() {
        super.reset();
        Disposable r100 = this.f100001h;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f100001h = null;
    }

    public DiggTemporaryDataMonitor(int r100, int r101, DataContext r102, DataCenter r103, IRoom r104) {
        Intrinsics.checkNotNullParameter(r103, "dataCenter");
        super(r102, r103, r104);
        u91.a r105 = new u91.a(new o91.b.g());
        r105.f549198a = r100;
        r105.f549200c = r101;
        r105.f549199b = a0.d(r103, false);
        Unit r106 = Unit.INSTANCE;
        this.f100002i = r105;
        this.f100003j = LazyKt.lazy(new DiggTemporaryDataMonitor$addParams$2(this));
        this.f100004k = LazyKt.lazy(new DiggTemporaryDataMonitor$removeParams$2(this));
    }
}
