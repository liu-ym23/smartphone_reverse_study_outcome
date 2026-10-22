package com.bytedance.android.live.openplatform.impl.miniappanchor.coupon;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.CouponApi;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.CompletableSubject;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/coupon/AnchorCouponContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorCouponContextService extends OpenPlatformContextService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, com.bytedance.android.live.openplatform.api.model.coupon.a> f84333a;

    public static final class a {
    }

    static {
    }

    public final void g() {
        autoDispose(f(this, 3, AnchorCouponContextService$initCouponEntranceInfoOnMorePanel$1.INSTANCE));
    }

    public AnchorCouponContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f84333a = new LinkedHashMap();
    }

    public static Disposable f(AnchorCouponContextService r100, int r101, Function1 r102) {
        AnchorCouponContextService$fetchCouponEntranceInfo$1 r103 = AnchorCouponContextService$fetchCouponEntranceInfo$1.INSTANCE;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "onFail");
        int r104 = qo0.a.f534145a;
        qo0.a.c("AnchorCouponContextService", "fetch send coupon entrance info, scene: " + r101);
        Lazy r105 = LiveOpenPlatformClient.f84032c;
        CouponApi r106 = (CouponApi) LiveOpenPlatformClient.a.a().a(CouponApi.class);
        int r107 = 1;
        if (((IHostContext) k.n(IHostContext.class)).isBoe() == false) goto L7;
        if (r101 != 2) goto L6;
        r107 = 2;
    L6:
        Observable<e<com.bytedance.android.live.openplatform.api.model.coupon.a>> r108 = r106.fetchSendCouponEntranceInfoBOE("https://boe-webcast.amemv.com/open/promotion/show_coupon_entrance/", r107);
    L11:
        return new CompletableSubject().doOnDispose(new com.bytedance.android.live.openplatform.impl.miniappanchor.coupon.a(r100, r108.compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r100, r101, r102, r103), new c(r103)), r101)).subscribe();
    L7:
        if (r101 != 2) goto L9;
        r107 = 2;
    L9:
        r108 = r106.fetchSendCouponEntranceInfo(r107);
        goto L11
    }

    public final void h(Context r100, int r101, List<String> r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.live.openplatform.api.model.coupon.a r102 = (com.bytedance.android.live.openplatform.api.model.coupon.a) ((LinkedHashMap) this.f84333a).get(Integer.valueOf(r101));
        int r103 = qo0.a.f534145a;
        StringBuilder r104 = new StringBuilder("open coupon page, scene: ");
        r104.append(r101);
        r104.append(", info: ");
        if (r102 != null) goto L5;
        Object r105 = "null";
    L6:
        r104.append(r105);
        qo0.a.c("AnchorCouponContextService", r104.toString());
        if (r102 != null) goto L9;
        return;
    L9:
        String r106 = r102.a();
        Uri r107 = null;
        StringBuilder r108 = null;
        if (r106 == null) goto L39;
        u6 r109 = new u6(r106);
        u6 r111 = r109.d("url");
        List<String> r112 = r110;
        if (r112 != null) goto L15;
    L18:
        boolean r113 = true;
    L19:
        if (r113 == true) goto L35;
        Iterator<String> r114 = r110.iterator();
    L22:
        if (r114.hasNext() == false) goto L32;
        String r115 = r114.next();
        if (r115.length() <= 0) goto L26;
        boolean r116 = true;
    L27:
        if (r116 == false) goto L22;
        if (r108 != null) goto L30;
        r108 = new StringBuilder();
    L31:
        r108.append(r115);
        goto L22
    L30:
        r108.append(",");
        goto L31
    L26:
        r116 = false;
        goto L27
    L32:
        if (r108 == null) goto L35;
        String r117 = URLEncoder.encode(r108.toString(), "UTF-8");
        r109.b("app_id", r117);
        r111.b("app_id", r117);
    L35:
        if (getOpenPlatformContext().isInLive() == false) goto L37;
        String r118 = "1";
    L38:
        r109.b(AbsOpenFeaturePanelViewModel.IS_IN_LIVE, r118);
        r111.b(AbsOpenFeaturePanelViewModel.IS_IN_LIVE, r118);
        r107 = r109.c();
        goto L39
    L37:
        r118 = "0";
        goto L38
    L15:
        if (r112.isEmpty() == true) goto L18;
        r113 = false;
    L39:
        if (r107 != null) goto L41;
        return;
    L41:
        int r119 = qo0.a.f534145a;
        qo0.a.c("AnchorCouponContextService", "coupon page result uri: " + r107);
        ((ILiveActionHandler) k.n(ILiveActionHandler.class)).handle(r100, r107);
        return;
    L5:
        r105 = r102;
        goto L6
    }
}
