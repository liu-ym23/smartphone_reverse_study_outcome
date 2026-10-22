package com.bytedance.android.live.liveinteract.banner;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/banner/BannerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BannerWidget extends LiveWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f71633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ka0.b f71634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LabelBannerUrl f71635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f71636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRoom f71637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f71638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f71639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f71640h;

    public interface a {
        boolean a();

        void b(boolean r100, Map<String, String> r101);
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerWidget f71641a;

        public c(BannerWidget r100) {
            this.f71641a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            e r101 = (e) r100;
            if (r101 == null) goto L17;
            KtvActivityLinkResponse r102 = (KtvActivityLinkResponse) r101.data;
            if (r102 == null) goto L18;
            Map<Long, LabelBannerUrl> r103 = r102.getBannerUrl_links();
            if (r103 == null) goto L19;
            BannerWidget r104 = this.f71641a;
            r104.f71635c = r103.get(Long.valueOf(r104.f71638f));
            LabelBannerUrl r105 = this.f71641a.f71635c;
            if (r105 == null) goto L20;
            String r106 = r105.getUrl();
            if (r106 == null) goto L21;
            ka0.b r107 = this.f71641a.f71634b;
            if (r107 == null) goto L15;
            r107.release();
        L15:
            BannerWidget r108 = this.f71641a;
            r108.f71634b = null;
            com.bytedance.android.live.liveinteract.banner.c r109 = new com.bytedance.android.live.liveinteract.banner.c(r108, r108.context, x6.a.d(r106), s1.y());
            r108.f71634b = r109;
            r109.loadUrl(r106);
            StringCompanionObject r110 = StringCompanionObject.INSTANCE;
            ALogger.i("BannerWidget", String.format("updateBannerUrl getActivityLinks success, bannerId: %s, labelBannerUrl: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f71641a.f71638f), this.f71641a.f71635c}, 2)));
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f71642a = null;

        static {
            f71642a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("BannerWidget", "getActivityLinks failed", (Throwable) r100);
        }
    }

    static {
    }

    public final void wq() {
        StringCompanionObject r100 = StringCompanionObject.INSTANCE;
        ALogger.d("BannerWidget", String.format("onVisible, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f71638f)}, 1)));
        xq();
    }

    public final void xq() {
        StringCompanionObject r100 = StringCompanionObject.INSTANCE;
        ALogger.d("BannerWidget", String.format("tryReportPageView, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f71638f)}, 1)));
        if (this.f71636d == false) goto L5;
        return;
    L5:
        a r101 = this.f71640h;
        if (r101 == null) goto L11;
        if (r101.a() == true) goto L11;
        return;
    L11:
        if (this.f71635c == null) goto L14;
        ALogger.d("BannerWidget", String.format("tryReportPageView success, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f71638f)}, 1)));
        this.f71636d = true;
        return;
    }

    public final void yq() {
        IRoom r100 = this.f71637e;
        if (r100 == null) goto L6;
        long r101 = r100.getRoomId();
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        ALogger.i("BannerWidget", String.format("updateBannerUrl getActivityLinks start, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f71638f)}, 1)));
        RxUtilKt.c(((BannerApi) com.bytedance.android.live.network.c.b().e(BannerApi.class)).getActivityLinks(r101, String.valueOf(this.f71638f), "").compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.f71642a), this.f71633a);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        ViewGroup r100 = this.containerView;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        View r101 = this.f71639g;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        IRoom r102 = this.f71637e;
        if (r102 == null) goto L12;
        long r103 = r102.getRoomId();
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        ALogger.i("BannerWidget", String.format("getActivityLinks start, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f71638f)}, 1)));
        RxUtilKt.c(((BannerApi) com.bytedance.android.live.network.c.b().e(BannerApi.class)).getActivityLinks(r103, String.valueOf(this.f71638f), "").compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.banner.a(this), new com.bytedance.android.live.liveinteract.banner.b(this)), this.f71633a);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        this.f71633a.clear();
        ka0.b r100 = this.f71634b;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f71634b = null;
    }

    public /* synthetic */ BannerWidget(IRoom r100) {
        this(r100, 23, "connection_request_panel", null, null);
    }

    public BannerWidget(IRoom r100, long r101, String r102, View r103, a r104) {
        Intrinsics.checkNotNullParameter(r102, "showPage");
        this.f71637e = r100;
        this.f71638f = r101;
        this.f71639g = r103;
        this.f71640h = r104;
        this.f71633a = new CompositeDisposable();
    }
}
