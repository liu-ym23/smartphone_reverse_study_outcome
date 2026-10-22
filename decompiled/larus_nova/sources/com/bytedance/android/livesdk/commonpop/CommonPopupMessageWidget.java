package com.bytedance.android.livesdk.commonpop;

import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.livesdkapi.LiveSdkApiForSaaS;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.common.Constants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.LinkedList;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.s;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/commonpop/CommonPopupMessageWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/commonpop/ICommonPopupMessageView;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonPopupMessageWidget extends LiveRecyclableWidget implements ICommonPopupMessageView, WeakHandler.IHandler {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f119708g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f119709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HybridCard f119710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<b> f119711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f119712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakHandler f119713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f119714f;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f119715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f119716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f119717c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f119715a, r101.f119715a) == true) goto L8;
            return false;
        L8:
            if (this.f119716b == r101.f119716b) goto L10;
            return false;
        L10:
            if (this.f119717c == r101.f119717c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public final int hashCode() {
            String r100 = this.f119715a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = ((r101 * 31) + this.f119716b) * 31;
            boolean r103 = this.f119717c;
            ?? r104 = r103;
            if (r103 == false) goto L10;
            r104 = 1;
        L10:
            return r102 + r104;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "ShowItem(url=" + this.f119715a + ", duration=" + this.f119716b + ", lynxEnabled=" + this.f119717c + ")";
        }

        public b(String r100, int r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f119715a = r100;
            this.f119716b = r101;
            this.f119717c = r102;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonPopupMessageWidget f119718a;

        public c(CommonPopupMessageWidget r100) {
            this.f119718a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.commonpop.b r101 = (com.bytedance.android.livesdk.commonpop.b) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            CommonPopupMessageWidget r102 = this.f119718a;
            int r103 = CommonPopupMessageWidget.f119708g;
            r102.getClass();
            String r104 = UriProtector.getQueryParameter(r101.f119723a, "url");
            if (r104 != null) goto L5;
            return;
        L5:
            if (r104.length() <= 0) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == false) goto L10;
            String r106 = r104;
        L11:
            if (r106 == null) goto L18;
            String r107 = UriProtector.getQueryParameter(r101.f119723a, "duration");
            if (r107 != null) goto L15;
            r107 = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        L15:
            b r108 = new b(r104, CastIntegerProtector.parseInt(r107), r101.f119724b);
            r102.f119711c.push(r108);
            r102.xq();
            return;
        L18:
            return;
        L10:
            r106 = null;
            goto L11
        L7:
            r105 = false;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonPopupMessageWidget f119719a;

        public d(CommonPopupMessageWidget r100) {
            this.f119719a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ToolbarClearScreenEvent r101 = (ToolbarClearScreenEvent) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            CommonPopupMessageWidget r102 = this.f119719a;
            int r103 = CommonPopupMessageWidget.f119708g;
            r102.getClass();
            r102.yq(r101.f106204b);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonPopupMessageWidget f119720a;

        public e(CommonPopupMessageWidget r100) {
            this.f119720a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            s r101 = (s) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            CommonPopupMessageWidget r102 = this.f119720a;
            int r103 = CommonPopupMessageWidget.f119708g;
            r102.getClass();
            r102.yq(r101.f571933a);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonPopupMessageWidget f119721a;

        public f(CommonPopupMessageWidget r100) {
            this.f119721a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.commonpop.a) r100, "event");
            CommonPopupMessageWidget r101 = this.f119721a;
            int r102 = CommonPopupMessageWidget.f119708g;
            r101.wq();
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonPopupMessageWidget f119722a;

        public g(CommonPopupMessageWidget r100) {
            this.f119722a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            i r101 = (i) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            final CommonPopupMessageWidget r102 = this.f119722a;
            int r103 = CommonPopupMessageWidget.f119708g;
            r102.getClass();
            LiveSdkApiForSaaS.Companion.getClass();
            LiveSdkApiForSaaS.a.a().commonPopupMessageWidgetOnInRoomPushEvent(r102, r102.f119713e, r101, 1, new CommonPopupMessageWidget$onEvent$1(r102));
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_common_popup_widget;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    public final void wq() {
        this.f119712d = false;
        View r100 = this.contentView;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        HybridCard r101 = this.f119710b;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        View r102 = this.contentView;
        if (r102 == null) goto L28;
        ((ViewGroup) r102).removeAllViews();
        HybridCard r103 = this.f119710b;
        if (r103 == null) goto L13;
        r103.release();
    L13:
        this.f119710b = null;
        if (this.f119711c.isEmpty() == true) goto L16;
    L25:
        xq();
        return;
    L16:
        if (k.f(IGiftServiceExternal.class) == null) goto L18;
        ((IGiftServiceExternal) k.n(IGiftServiceExternal.class)).toggleVideoGiftView(true);
    L18:
        RoomContext r104 = (RoomContext) com.bytedance.live.datacontext.d.e(Integer.valueOf(this.dataCenter.hashCode()), RoomContext.class);
        if (r104 == null) goto L25;
        m<com.bytedance.android.livesdk.chatroom.viewmodel.b> r105 = r104.getCommonPopupModel();
        if (r105 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodel.b r106 = r105.getValue();
        if (r106 == null) goto L25;
        r106.f114781a = false;
        goto L25
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        h r100 = this.f119709a;
        Intrinsics.checkNotNull(r100);
        r100.detachView();
        View r101 = this.contentView;
        if (r101 == null) goto L10;
        ((ViewGroup) r101).removeAllViews();
        HybridCard r102 = this.f119710b;
        if (r102 == null) goto L7;
        r102.release();
    L7:
        this.f119710b = null;
        this.f119711c.clear();
        this.f119712d = false;
        this.f119713e.removeCallbacksAndMessages(null);
        this.contentView.setVisibility(0);
        this.contentView.setTranslationX(0.0f);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void xq() {
        if ((!this.f119711c.isEmpty()) == true) goto L5;
        return;
    L5:
        if (this.f119712d == true) goto L38;
        b r100 = this.f119711c.poll();
        this.f119712d = true;
        boolean r101 = r100.f119717c;
        String r102 = r100.f119715a;
        if (r101 == true) goto L9;
        Uri r103 = x6.a.b(r102);
    L10:
        HybridCard r104 = ((IBrowserService) k.n(IBrowserService.class)).getHybridCard(this.context, r103, new com.bytedance.android.livesdk.commonpop.d(this));
        if (r104 == null) goto L22;
        r104.registerMethod("close", new com.bytedance.android.livesdk.commonpop.c(this));
        this.f119710b = r104;
        if (r104.hybridType() != IHybridComponent.HybridType.H5) goto L16;
        r104.setBackgroundColor(0);
        r104.setVisibility(4);
    L16:
        if (r104.getParent() != null) goto L22;
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View r105 = this.contentView;
        if (r105 == null) goto L21;
        ((ViewGroup) r105).addView(r104, 0);
        goto L22
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L22:
        this.contentView.setVisibility(4);
        HybridCard r106 = this.f119710b;
        if (r106 == null) goto L25;
        r106.setVisibility(4);
    L25:
        String r107 = r100.f119715a;
        HybridCard r108 = this.f119710b;
        if (r108 == null) goto L28;
        View r109 = r108.getHybridView();
    L30:
        if ((r109 instanceof WebView) == false) goto L32;
        r107 = ((IBrowserService) k.n(IBrowserService.class)).appendCommonParams(r107);
    L32:
        HybridCard r110 = this.f119710b;
        if (r110 == null) goto L35;
        a7.a.a(r110, r107, null, 2);
    L35:
        Message r111 = this.f119713e.obtainMessage(1);
        this.f119713e.removeCallbacksAndMessages(null);
        this.f119713e.sendMessageDelayed(r111, r100.f119716b * 1000);
        return;
    L28:
        r109 = null;
        goto L30
    L9:
        r103 = x6.a.d(r102);
        goto L10
    }

    public CommonPopupMessageWidget() {
        this.f119711c = new LinkedList();
        this.f119713e = new WeakHandler(this);
        this.f119714f = 200;
    }

    @Override // com.bytedance.android.livesdk.commonpop.ICommonPopupMessageView
    public final void J2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        ((IRoomService) k.n(IRoomService.class)).actionHandler().handle(getContext(), r100);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.what != 1) goto L8;
        wq();
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f119709a = new h();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        h r101 = this.f119709a;
        Intrinsics.checkNotNull(r101);
        r101.g0(this);
        L7(com.bytedance.android.livesdk.commonpop.b.class, new c(this));
        L7(ToolbarClearScreenEvent.class, new d(this));
        L7(s.class, new e(this));
        L7(com.bytedance.android.livesdk.commonpop.a.class, new f(this));
        L7(i.class, new g(this));
        this.contentView.setVisibility(4);
    }

    public final void yq(boolean r100) {
        float r101 = 0.0f;
        if (ClearScreenHelper.c() == false) goto L9;
        ViewPropertyAnimator r102 = this.contentView.animate();
        if (r100 == true) goto L8;
        r101 = 1.0f;
    L8:
        r102.alpha(r101).setDuration(this.f119714f).setInterpolator(new com.bytedance.android.live.core.widget.g()).start();
        return;
    L9:
        if (r100 == false) goto L11;
        r101 = this.contentView.getWidth();
    L11:
        this.contentView.animate().x(r101).setDuration(this.f119714f).setInterpolator(new com.bytedance.android.live.core.widget.g()).start();
    }

    public final <T> void L7(Class<T> r100, Consumer<T> r101) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r100).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r101);
    }
}
