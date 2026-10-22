package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.model.b1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import s91.f;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/DoubleLikeDataMonitor;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/BaseTabDataMonitor;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleLikeDataMonitor extends BaseTabDataMonitor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u91.a f100005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f100006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f100007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f100008k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, s91.b
    public final void a() {
        this.f99998f.observe("cmd_user_info_sub_title_anim", this);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, s91.b
    public final void reset() {
        super.reset();
        Disposable r100 = this.f100008k;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f100008k = null;
        this.f99998f.removeObserver(this);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor
    public final void f(KVData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getKey();
        if (r101.hashCode() == (-777370727)) goto L8;
        return;
    L8:
        if (r101.equals("cmd_user_info_sub_title_anim") == false) goto L19;
        Object r102 = r100.getData();
        if ((r102 instanceof b1) == true) goto L12;
        r102 = null;
    L12:
        b1 r103 = (b1) r102;
        if (r103 == null) goto L20;
        this.f100005h.f549201d = r103;
        e((f) this.f100006i.getValue());
        Disposable r104 = this.f100008k;
        if (r104 == null) goto L17;
        r104.dispose();
    L17:
        long r105 = r103.f153931c + 300;
        this.f100008k = Observable.just("").delay(r105, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this));
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit.BaseTabDataMonitor, androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        f((KVData) r100);
    }

    public DoubleLikeDataMonitor(int r100, int r101, DataContext r102, DataCenter r103, IRoom r104) {
        Intrinsics.checkNotNullParameter(r103, "dataCenter");
        super(r102, r103, r104);
        u91.a r105 = new u91.a(new o91.b.h());
        r105.f549198a = r100;
        r105.f549200c = r101;
        r105.f549199b = a0.d(r103, false);
        Unit r106 = Unit.INSTANCE;
        this.f100005h = r105;
        this.f100006i = LazyKt.lazy(new DoubleLikeDataMonitor$addParams$2(this));
        this.f100007j = LazyKt.lazy(new DoubleLikeDataMonitor$removeParams$2(this));
    }
}
