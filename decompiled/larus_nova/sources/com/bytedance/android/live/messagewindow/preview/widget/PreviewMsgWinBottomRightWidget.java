package com.bytedance.android.live.messagewindow.preview.widget;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.messagewindow.framework.context.CardContext;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.ICardInnerService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import h71.d;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/messagewindow/preview/widget/PreviewMsgWinBottomRightWidget;", "Lcom/bytedance/android/live/messagewindow/preview/widget/PreviewMsgWinCommonWidget;", "Lcom/bytedance/android/livesdkapi/depend/handler/WeakHandler$IHandler;", "Lap2/b;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewMsgWinBottomRightWidget extends PreviewMsgWinCommonWidget implements WeakHandler.IHandler, ap2.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f83200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MsgWindowPosition f83201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintLayout f83202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WeakHandler f83203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f83204h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.messagewindow.business.util.a f83205i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f83206j;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.messagewindow.business.util.a.InterfaceC1263a {
        public b() {
        }

        @Override // com.bytedance.android.live.messagewindow.business.util.a.InterfaceC1263a
        public final WidgetElement a(Class<? extends Widget> r100, ViewGroup r101, boolean r102, Object[] r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r100, "widgetClass");
            Intrinsics.checkNotNullParameter(r101, "elementView");
            return null;
        }
    }

    public final class c implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f83207a;

        public c(Function1 r100) {
            this.f83207a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f83207a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_view_msg_window_card;
    }

    public PreviewMsgWinBottomRightWidget() {
        this.f83200d = "PreviewMsgWinBottomRightWidget";
        this.f83201e = MsgWindowPosition.BOTTOM_RIGHT;
        this.f83203g = new WeakHandler(Looper.getMainLooper(), this);
        this.f83205i = new com.bytedance.android.live.messagewindow.business.util.a(new b());
        this.f83206j = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        zq();
        i r100 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.preview.widget.PreviewMsgWinCommonWidget
    public final void zq() {
        super.zq();
        CardContext r100 = wq();
        if (r100 == null) goto L7;
        d71.d<v61.a, d71.b> r101 = r100.recordManager(MsgWindowPosition.BOTTOM_RIGHT);
        if (r101 == null) goto L7;
        r101.b();
    L7:
        this.f83203g.removeMessages(1001);
        this.f83203g.removeMessages(1002);
        this.f83203g.removeMessages(1003);
        this.f83203g.removeMessages(1004);
        d r102 = this.f83204h;
        if (r102 == null) goto L11;
        r102.unload();
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.preview.widget.PreviewMsgWinCommonWidget
    public final com.bytedance.android.live.messagewindow.business.util.a xq() {
        return this.f83205i;
    }

    @Override // com.bytedance.android.live.messagewindow.preview.widget.PreviewMsgWinCommonWidget
    public final String yq() {
        return this.f83200d;
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.what);
    L5:
        if (r101 != null) goto L8;
    L12:
        if (r101 != null) goto L15;
    L19:
        if (r101 != null) goto L22;
    L26:
        if (r101 != null) goto L29;
    L33:
        if (r101 != null) goto L36;
        return;
    L36:
        if (r101.intValue() != 1005) goto L49;
        d r102 = this.f83204h;
        if (r102 == null) goto L50;
        r102.d();
        return;
    L50:
        return;
    L49:
        return;
    L29:
        if (r101.intValue() != 1004) goto L33;
        d r103 = this.f83204h;
        if (r103 == null) goto L47;
        r103.e();
        return;
    L47:
        return;
    L22:
        if (r101.intValue() != 1003) goto L26;
        d r104 = this.f83204h;
        if (r104 == null) goto L45;
        r104.b();
        return;
    L45:
        return;
    L15:
        if (r101.intValue() != 1001) goto L19;
        d r105 = this.f83204h;
        if (r105 == null) goto L43;
        r105.c();
        return;
    L43:
        return;
    L8:
        if (r101.intValue() != 1002) goto L12;
        d r106 = this.f83204h;
        if (r106 == null) goto L41;
        r106.a();
        return;
    L41:
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void onEvent(o70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof z61.b) == false) goto L31;
        z61.b r101 = (z61.b) r100;
        if (r101.f570447e.f483968a == true) goto L11;
        if (this.f83203g.hasMessages(1005) == true) goto L11;
        this.f83203g.sendEmptyMessage(1005);
        return;
    L11:
        if (r101.f570444b == false) goto L16;
        if (this.f83203g.hasMessages(1002) == true) goto L16;
        this.f83203g.sendEmptyMessage(1002);
    L16:
        if (r101.f570443a == false) goto L21;
        if (this.f83203g.hasMessages(1001) == true) goto L21;
        this.f83203g.sendEmptyMessage(1001);
    L21:
        if (r101.f570445c == false) goto L26;
        if (this.f83203g.hasMessages(1003) == true) goto L26;
        this.f83203g.sendEmptyMessage(1003);
    L26:
        if (r101.f570446d == true) goto L28;
        return;
    L28:
        if (this.f83203g.hasMessages(1004) == true) goto L33;
        this.f83203g.sendEmptyMessage(1004);
        return;
    L33:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        View r101 = this.contentView;
        if (r101 == null) goto L7;
        this.f83202f = (ConstraintLayout) r101;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        MiddlewareRoomContext r101 = getMiddlewareRoomContext();
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(r101, "$this$getRoomDataCtxExt");
        o r102 = z51.a.g(r101);
        if (r102 == null) goto L9;
        Map<String, String> r103 = r102.F2();
        if (r103 == null) goto L9;
        String r104 = r103.put(WidgetCostModule.TYPE_ON_CREATE, "1");
    L9:
        DataCenter r105 = this.dataCenter;
        Integer r106 = null;
        if (r105 == null) goto L26;
        IRoom r107 = a0.f66111a;
        Object r108 = r105.get("data_room", null);
        if ((r108 instanceof IRoom) == true) goto L14;
        r108 = null;
    L14:
        IRoom r109 = (IRoom) r108;
        if (r109 == null) goto L18;
        r107 = r109;
    L18:
        if (r107 == null) goto L26;
        long r110 = r107.getId();
        MiddlewareRoomContext r111 = getMiddlewareRoomContext();
        if (r111 == null) goto L26;
        Intrinsics.checkNotNullParameter(r111, "$this$getExpRoomServiceExt");
        r r112 = z51.a.d(r111);
        if (r112 == null) goto L26;
        n<Pair<Long, Object>> r113 = r112.M();
        if (r113 == null) goto L26;
        r113.setValue(new Pair(Long.valueOf(r110), this));
    L26:
        ConstraintLayout r114 = this.f83202f;
        if (r114 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L29:
        ViewGroup r115 = (ViewGroup) r114.findViewById(R.id.card_container);
        if (r115 == null) goto L32;
        d r116 = ((ICardInnerService) k.n(ICardInnerService.class)).createMsgWindowPositionAdjuster(r115);
        r116.load();
        Unit r117 = Unit.INSTANCE;
        this.f83204h = r116;
    L33:
        this.f83210c = r115;
        CardContext r118 = wq();
        if (r118 == null) goto L36;
        r118.provideWindowContainer(this.f83201e, this);
    L36:
        CardContext r119 = wq();
        if (r119 == null) goto L66;
        d71.d<v61.a, d71.b> r120 = r119.recordManager(MsgWindowPosition.BOTTOM_RIGHT);
        if (r120 == null) goto L66;
        Iterable r121 = r120.o();
        if (r121 == null) goto L66;
        Iterator r122 = r121.iterator();
    L44:
        if (r122.hasNext() == false) goto L66;
        d71.b r123 = (d71.b) r122.next();
        CardContext r124 = wq();
        if (r124 == null) goto L56;
        i r125 = r124.getMonitor();
        if (r125 == null) goto L56;
        CardAlogParamsBuilder r126 = new CardAlogParamsBuilder();
        r126.d(this.f83200d);
        StringBuilder r127 = new StringBuilder("temporary card show, ");
        if (r123 == null) goto L54;
        v61.a r128 = (v61.a) r123.f467219b;
        if (r128 == null) goto L54;
        Object r129 = r128.f553379j;
    L55:
        r127.append(r129);
        r126.c(r127.toString());
        Unit r130 = Unit.INSTANCE;
        r125.d(r126.b());
    L54:
        r129 = null;
    L56:
        CardContext r131 = wq();
        if (r131 == null) goto L61;
        e71.a r132 = r131.getMsgManager();
        if (r132 == null) goto L61;
        r132.show(r123.f467219b);
    L61:
        CardContext r133 = wq();
        if (r133 == null) goto L44;
        d71.d<v61.a, d71.b> r134 = r133.recordManager(MsgWindowPosition.BOTTOM_RIGHT);
        if (r134 == null) goto L44;
        r134.e(r123.f467219b);
    L66:
        i r135 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r135 != null) goto L69;
    L73:
        xs2.b r136 = xs2.b.a();
        MiddlewareRoomContext r137 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.dataCenter, 0, 2);
        if (r137 == null) goto L78;
        m<Integer> r138 = r137.getReportScreenOrientation();
        if (r138 == null) goto L78;
        r106 = r138.getValue();
    L78:
        r136.post(new z61.c(r106));
        List r139 = CollectionsKt.listOf(z61.b.class);
        if (r139 == null) goto L84;
        Iterator r140 = r139.iterator();
    L82:
        if (r140.hasNext() == false) goto L93;
        RxUtilKt.c(xs2.b.a().b((Class) r140.next()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(new PreviewMsgWinBottomRightWidget$onLoad$5$1(this))), this.f83206j);
        goto L82
    L93:
        return;
    L84:
        return;
    L69:
        if (this.dataContext == null) goto L71;
        o r141 = IRoomContextService.a.a((IRoomContextService) k.n(IRoomContextService.class), this.dataCenter, 0, 2);
    L72:
        r135.a(r141);
        goto L73
    L71:
        r141 = null;
        goto L72
    L32:
        r115 = null;
        goto L33
    }
}
