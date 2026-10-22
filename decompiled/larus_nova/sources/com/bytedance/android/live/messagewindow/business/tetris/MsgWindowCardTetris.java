package com.bytedance.android.live.messagewindow.business.tetris;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer;
import com.bytedance.android.live.messagewindow.framework.context.CardContext;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.ICardInnerService;
import com.bytedance.android.live.room.api.panel.PanelCoverListener;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.live.room.api.panel.e;
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
import d90.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t70.k;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/messagewindow/business/tetris/MsgWindowCardTetris;", "Lcom/bytedance/android/live/messagewindow/framework/container/AbsMsgWindowContainer;", "Ld90/d;", "Lcom/bytedance/android/livesdkapi/depend/handler/WeakHandler$IHandler;", "Lo70/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MsgWindowCardTetris extends AbsMsgWindowContainer<d> implements WeakHandler.IHandler, o70.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f82979y = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f82980r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final MsgWindowPosition f82981s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ConstraintLayout f82982t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final WeakHandler f82983u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h71.d f82984v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bytedance.android.live.messagewindow.business.util.a f82985w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f82986x;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.messagewindow.business.util.a.InterfaceC1263a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MsgWindowCardTetris f82987a;

        public b(MsgWindowCardTetris r100) {
            this.f82987a = r100;
        }

        @Override // com.bytedance.android.live.messagewindow.business.util.a.InterfaceC1263a
        public final WidgetElement a(Class<? extends Widget> r100, ViewGroup r101, boolean r110, Object[] r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r100, "widgetClass");
            Intrinsics.checkNotNullParameter(r101, "elementView");
            return this.f82987a.P(r100, r101, r110, r111, r112);
        }
    }

    public static final class c extends PanelCoverListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MsgWindowCardTetris f82988c;

        @Override // com.bytedance.android.live.room.api.panel.a
        public final String getName() {
            return "MsgWindowCardTetris";
        }

        @Override // com.bytedance.android.live.room.api.panel.a
        public final View d() {
            MsgWindowCardTetris r100 = this.f82988c;
            int r101 = MsgWindowCardTetris.f82979y;
            return r100.f83062q;
        }

        public c(MsgWindowCardTetris r100) {
            this.f82988c = r100;
        }

        @Override // com.bytedance.android.live.room.api.panel.a
        public final boolean e(e r100) {
            Intrinsics.checkNotNullParameter(r100, "panelInfo");
            if (r100.f99049a == PanelName.RightCard) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
    }

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(z61.b.class);
    }

    public MsgWindowCardTetris() {
        this.f82980r = "MsgWindowCardTetris";
        this.f82981s = MsgWindowPosition.BOTTOM_RIGHT;
        this.f82983u = new WeakHandler(Looper.getMainLooper(), this);
        this.f82985w = new com.bytedance.android.live.messagewindow.business.util.a(new b(this));
        this.f82986x = new c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        DataCenter r100 = ((d) K()).f467480h;
        if (r100 == null) goto L11;
        IRoom r101 = lu2.c.f(r100);
        if (r101 == null) goto L11;
        long r102 = r101.getId();
        r r103 = z51.a.e(((d) K()).f467480h);
        if (r103 == null) goto L11;
        n<Pair<Long, Object>> r104 = r103.M();
        if (r104 == null) goto L11;
        r104.setValue(new Pair(Long.valueOf(r102), this));
    L11:
        CardContext r105 = V();
        if (r105 == null) goto L14;
        r105.provideWindowContainer(this.f82981s, this);
    L14:
        CardContext r106 = V();
        Integer r107 = null;
        if (r106 == null) goto L44;
        d71.d<v61.a, d71.b> r108 = r106.recordManager(MsgWindowPosition.BOTTOM_RIGHT);
        if (r108 == null) goto L44;
        Iterable r109 = r108.o();
        if (r109 == null) goto L44;
        Iterator r110 = r109.iterator();
    L22:
        if (r110.hasNext() == false) goto L44;
        d71.b r111 = (d71.b) r110.next();
        CardContext r112 = V();
        if (r112 == null) goto L34;
        i r113 = r112.getMonitor();
        if (r113 == null) goto L34;
        CardAlogParamsBuilder r114 = new CardAlogParamsBuilder();
        r114.d(this.f82980r);
        StringBuilder r115 = new StringBuilder("temporary card show, ");
        if (r111 == null) goto L32;
        v61.a r116 = (v61.a) r111.f467219b;
        if (r116 == null) goto L32;
        Object r117 = r116.f553379j;
    L33:
        r115.append(r117);
        r114.c(r115.toString());
        Unit r118 = Unit.INSTANCE;
        r113.d(r114.b());
    L32:
        r117 = null;
    L34:
        CardContext r119 = V();
        if (r119 == null) goto L39;
        e71.a r120 = r119.getMsgManager();
        if (r120 == null) goto L39;
        r120.show(r111.f467219b);
    L39:
        CardContext r121 = V();
        if (r121 == null) goto L22;
        d71.d<v61.a, d71.b> r122 = r121.recordManager(MsgWindowPosition.BOTTOM_RIGHT);
        if (r122 == null) goto L22;
        r122.e(r111.f467219b);
    L44:
        i r123 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r123 == null) goto L47;
        o r124 = z51.a.h(((d) K()).f467480h, 2);
        DataCenter r125 = ((d) K()).f467480h;
        r123.a(r124);
    L47:
        xs2.b r126 = xs2.b.a();
        o r127 = z51.a.h(((d) K()).f467480h, 2);
        if (r127 == null) goto L52;
        m<Integer> r128 = r127.v2();
        if (r128 == null) goto L52;
        r107 = r128.getValue();
    L52:
        r126.post(new z61.c(r107));
        List<Class<? extends o70.b>> r129 = Mg();
        if (r129 == null) goto L58;
        Iterator<T> r130 = r129.iterator();
    L56:
        if (r130.hasNext() == false) goto L67;
        T((Class) r130.next(), new MsgWindowCardTetris$onViewCreated$3$1(this));
        goto L56
    L67:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer
    public final DataCenter Z() {
        return ((d) K()).f467480h;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer
    public final void b0() {
        super.b0();
        CardContext r100 = V();
        if (r100 == null) goto L7;
        d71.d<v61.a, d71.b> r101 = r100.recordManager(MsgWindowPosition.BOTTOM_RIGHT);
        if (r101 == null) goto L7;
        r101.b();
    L7:
        this.f82983u.removeMessages(1001);
        this.f82983u.removeMessages(1002);
        this.f82983u.removeMessages(1003);
        this.f82983u.removeMessages(1004);
        h71.d r102 = this.f82984v;
        if (r102 == null) goto L14;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L11:
        if (r102 == null) goto L15;
        r102.unload();
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        b0();
        i r100 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r100 == null) goto L5;
        r100.c();
    L5:
        int r101 = com.bytedance.android.live.room.api.panel.d.f99047a;
        com.bytedance.android.live.room.api.panel.c r102 = com.bytedance.android.live.room.api.panel.d.c(((d) K()).f467480h, 2);
        if (r102 == null) goto L9;
        r102.unregisterPanelListener(this.f82986x);
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer
    public final com.bytedance.android.live.messagewindow.business.util.a W() {
        return this.f82985w;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.container.AbsMsgWindowContainer
    public final String a0() {
        return this.f82980r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        o r101 = z51.a.h(((d) K()).f467480h, 2);
        if (r101 == null) goto L7;
        Map<String, String> r102 = r101.F2();
        if (r102 == null) goto L7;
        String r103 = r102.put(WidgetCostModule.TYPE_ON_CREATE, "1");
    L7:
        DataCenter r104 = ((d) K()).f467480h;
        if (r104 == null) goto L16;
        IRoom r105 = a0.n(r104);
        if (r105 == null) goto L16;
        long r106 = r105.getId();
        r r107 = z51.a.e(((d) K()).f467480h);
        if (r107 == null) goto L16;
        n<Pair<Long, Object>> r108 = r107.M();
        if (r108 == null) goto L16;
        r108.setValue(new Pair(Long.valueOf(r106), this));
    L16:
        View r109 = r100.b(R.layout.ttlive_view_msg_window_card);
        if (r109 == null) goto L32;
        ConstraintLayout r110 = (ConstraintLayout) r109;
        this.f82982t = r110;
        ViewGroup r111 = (ViewGroup) r110.findViewById(R.id.card_container);
        if (r111 == null) goto L21;
        h71.d r112 = ((ICardInnerService) jc1.k.n(ICardInnerService.class)).createMsgWindowPositionAdjuster(r111);
        r112.load();
        Unit r113 = Unit.INSTANCE;
        this.f82984v = r112;
    L22:
        this.f83062q = r111;
        if (d90.e.h((d) K()) == false) goto L27;
        int r114 = com.bytedance.android.live.room.api.panel.d.f99047a;
        com.bytedance.android.live.room.api.panel.c r115 = com.bytedance.android.live.room.api.panel.d.c(((d) K()).f467480h, 2);
        if (r115 == null) goto L27;
        r115.registerPanelListener(this.f82986x);
    L27:
        ConstraintLayout r116 = this.f82982t;
        if (r116 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L30:
        return r116;
    L21:
        r111 = null;
        goto L22
    L32:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.what);
    L6:
        if (r101 != null) goto L9;
    L14:
        if (r101 != null) goto L17;
    L22:
        if (r101 != null) goto L25;
    L30:
        if (r101 != null) goto L33;
    L38:
        if (r101 != null) goto L41;
        return;
    L41:
        if (r101.intValue() != 1005) goto L51;
        h71.d r102 = this.f82984v;
        if (r102 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L45:
        r102.d();
        return;
    L51:
        return;
    L33:
        if (r101.intValue() != 1004) goto L38;
        h71.d r103 = this.f82984v;
        if (r103 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L37:
        r103.e();
        return;
    L25:
        if (r101.intValue() != 1003) goto L30;
        h71.d r104 = this.f82984v;
        if (r104 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L29:
        r104.b();
        return;
    L17:
        if (r101.intValue() != 1001) goto L22;
        h71.d r105 = this.f82984v;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L21:
        r105.c();
        return;
    L9:
        if (r101.intValue() != 1002) goto L14;
        h71.d r106 = this.f82984v;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L13:
        r106.a();
        return;
    L4:
        r101 = null;
        goto L6
    }

    @Override // o70.a
    public void onEvent(o70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof z61.b) == false) goto L31;
        z61.b r101 = (z61.b) r100;
        if (r101.f570447e.f483968a == true) goto L11;
        if (this.f82983u.hasMessages(1005) == true) goto L11;
        this.f82983u.sendEmptyMessage(1005);
        return;
    L11:
        if (r101.f570444b == false) goto L16;
        if (this.f82983u.hasMessages(1002) == true) goto L16;
        this.f82983u.sendEmptyMessage(1002);
    L16:
        if (r101.f570443a == false) goto L21;
        if (this.f82983u.hasMessages(1001) == true) goto L21;
        this.f82983u.sendEmptyMessage(1001);
    L21:
        if (r101.f570445c == false) goto L26;
        if (this.f82983u.hasMessages(1003) == true) goto L26;
        this.f82983u.sendEmptyMessage(1003);
    L26:
        if (r101.f570446d == true) goto L28;
        return;
    L28:
        if (this.f82983u.hasMessages(1004) == true) goto L33;
        this.f82983u.sendEmptyMessage(1004);
        return;
    L33:
        return;
    }
}
