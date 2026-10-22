package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import com.bytedance.android.livesdk.utils.MVIWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ro1.a;
import ro1.f;
import vo1.e;
import vo1.i;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/base/BaseBannerWidget;", "Lro1/a;", "M", "Lcom/bytedance/android/livesdk/utils/MVIWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/a;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/ActivityTopBannerViewIntent;", "<init>", "()V", "BannerPosition", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseBannerWidget<M extends ro1.a> extends MVIWidget<com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a, ActivityTopBannerViewIntent, M> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f115163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f115164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f115165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f115166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseHybridParamVo.HybridType f115167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GestureDetector f115168g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/base/BaseBannerWidget$BannerPosition;", "", "TOP_RIGHT", "BOTTOM_RIGHT", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum BannerPosition extends Enum<BannerPosition> {
        public static final BannerPosition BOTTOM_RIGHT = null;
        public static final BannerPosition TOP_RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BannerPosition[] f115169a = null;

        static {
            BannerPosition r100 = new BannerPosition("TOP_RIGHT", 0);
            TOP_RIGHT = r100;
            BannerPosition r101 = new BannerPosition("BOTTOM_RIGHT", 1);
            BOTTOM_RIGHT = r101;
            f115169a = new BannerPosition[]{r100, r101};
        }

        public static BannerPosition valueOf(String r100) {
            return (BannerPosition) r27.a.a(BannerPosition.class, r100);
        }

        public static BannerPosition[] values() {
            return (BannerPosition[]) f115169a.clone();
        }

        public BannerPosition(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements IBaseBrowserService.PageFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseBannerWidget f115170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BannerInRoomCollection.BannerInfo f115171b;

        public a(BaseBannerWidget r100, BannerInRoomCollection.BannerInfo r101) {
            this.f115170a = r100;
            this.f115171b = r101;
        }

        @Override // com.bytedance.android.live.browser.IBaseBrowserService.PageFinishedListener
        public final void onPageFinished(WebView r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "webView");
            Intrinsics.checkNotNullParameter(r101, "url");
            this.f115170a.Aq(r100, r101, this.f115171b);
        }
    }

    public static final class b implements IBaseBrowserService.PageErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseBannerWidget f115172a;

        public b(BaseBannerWidget r100) {
            this.f115172a = r100;
        }

        @Override // com.bytedance.android.live.browser.IBaseBrowserService.PageErrorListener
        public final void onReceiveError(WebView r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "webView");
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r102, "msg");
            BaseBannerWidget r103 = this.f115172a;
            r103.f115163b = true;
            r103.Bq(r100, r101, r102);
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseBannerWidget f115173a;

        public c(BaseBannerWidget r100) {
            this.f115173a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f115173a.zq();
            return false;
        }
    }

    public void Aq(View r100, String r101, BannerInRoomCollection.BannerInfo r102) {
    }

    public void Bq(View r100, String r101, String r102) {
    }

    public void Cq(BannerInRoomCollection.BannerInfo r100) {
    }

    public void zq() {
    }

    public void Eq() {
        i r100 = this.f115166e;
        if (r100 == null) goto L6;
        r100.release();
    L6:
        if (com.bytedance.android.live.core.setting.a.f65201a.getValue().booleanValue() == true) goto L9;
        this.f115166e = null;
        return;
    }

    public BaseBannerWidget() {
        this.f115165d = "";
        this.f115167f = BaseHybridParamVo.HybridType.H5;
        this.f115168g = new GestureDetector(getContext(), new c(this));
    }

    @Override // com.bytedance.android.live.core.arch.mvi.widgetcompat.MVIDataWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        super.onUnload();
        this.f115163b = false;
        Eq();
        i0.k(c50.b.b(this.dataCenter), this.f115164c);
        this.f115164c = null;
    }

    public final void Fq(String r100, JSONObject r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == true) goto L13;
        if (r101 == null) goto L13;
        i r103 = this.f115166e;
        if (r103 == null) goto L13;
        r103.sendJsEvent(r100, r101);
    L13:
        ALogger.i("tag_banner_001", "sendJsEvent-> eventName=" + r100);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    public final void yq(Activity r100, BannerInRoomCollection.BannerInfo r101) {
        if (this.f115166e != null) goto L9;
        int r102 = e.f556493a;
        if (com.bytedance.android.live.core.setting.a.f65201a.getValue().booleanValue() == false) goto L7;
        i r103 = new vo1.f();
    L8:
        this.f115166e = r103;
        goto L9
    L7:
        r103 = new vo1.a();
    L9:
        i r104 = this.f115166e;
        if (r104 != null) goto L12;
    L23:
        this.f115167f = BaseHybridParamVo.HybridType.H5;
        return;
    L12:
        if (r101 == null) goto L17;
        String r105 = r101.getUrl();
        if (r105 == null) goto L17;
        String r106 = r105;
    L18:
        a r107 = new a(this, r101);
        b r108 = new b(this);
        String r109 = getSpm();
        if (r109 != null) goto L21;
        String r110 = "";
    L22:
        r104.d(r100, r106, r107, r108, r110);
        goto L23
    L21:
        r110 = r109;
    L17:
        r106 = "";
        goto L18
    }
}
