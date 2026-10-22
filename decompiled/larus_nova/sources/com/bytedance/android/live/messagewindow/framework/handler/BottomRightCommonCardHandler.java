package com.bytedance.android.live.messagewindow.framework.handler;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.messagewindow.business.card.BottomRightCommonCard;
import com.bytedance.android.live.messagewindow.business.presenter.CommonCardServiceWidgetPresenter;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import com.bytedance.android.livesdk.config.ny0;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.android.livesdk.message.model.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import m71.e;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
public final class BottomRightCommonCardHandler extends com.bytedance.android.live.messagewindow.framework.handler.a<m1> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f83089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<Integer, m1> f83090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f83091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<Context> f83092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f83093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q71.a f83094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CommonCardServiceWidgetPresenter f83095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final y61.a f83096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> f83097j;

    public static final class a implements g71.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomRightCommonCardHandler f83098a;

        public a(BottomRightCommonCardHandler r100) {
            this.f83098a = r100;
        }

        @Override // g71.a
        public final void a(Integer r100) {
            this.f83098a.f(r100);
        }
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void g() {
        super.g();
        Disposable r100 = this.f83091d;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void h() {
        super.h();
        y61.a r100 = this.f83096i;
        if (r100 == null) goto L9;
        Map<Integer, m1> r101 = r100.getBottomRightCardData();
        if (r101 == null) goto L9;
        if ((!r101.isEmpty()) == false) goto L9;
        this.f83090c = r101;
    L9:
        y61.a r102 = this.f83096i;
        if (r102 == null) goto L12;
        r102.setBottomRightCardData(this.f83090c);
    L12:
        int r103 = e.f512327a;
        if (m71.b.f512324a.getValue().d() == true) goto L26;
        y61.a r104 = this.f83096i;
        if (r104 == null) goto L21;
        Map<MsgWindowPosition, Map<Integer, Pair<v61.a, g71.b>>> r105 = r104.getCardMapV2();
        if (r105 == null) goto L21;
        Map<Integer, Pair<v61.a, g71.b>> r106 = r105.get(MsgWindowPosition.BOTTOM_RIGHT);
        if (r106 == null) goto L21;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f83106a = r106;
    L21:
        y61.a r107 = this.f83096i;
        if (r107 == null) goto L50;
        Map<MsgWindowPosition, Map<Integer, Pair<v61.a, g71.b>>> r108 = r107.getCardMapV2();
        if (r108 == null) goto L51;
        Map<Integer, Pair<v61.a, g71.b>> r109 = r108.put(MsgWindowPosition.BOTTOM_RIGHT, this.f83106a);
        return;
    L51:
        return;
    L50:
        return;
    L26:
        y61.a r110 = this.f83096i;
        String r111 = null;
        if (r110 == null) goto L39;
        Map<w61.b, Map<Integer, Pair<v61.a, g71.b>>> r112 = r110.getCardMapV3();
        if (r112 == null) goto L39;
        DataCenter r113 = this.f83093f;
        if (r113 == null) goto L35;
        IRoom r114 = a0.n(r113);
        if (r114 == null) goto L35;
        String r115 = r114.getIdStr();
    L36:
        Map<Integer, Pair<v61.a, g71.b>> r116 = r112.get(new w61.b(r115, MsgWindowPosition.BOTTOM_RIGHT));
        if (r116 == null) goto L39;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        this.f83106a = r116;
    L35:
        r115 = null;
    L39:
        y61.a r117 = this.f83096i;
        if (r117 == null) goto L53;
        Map<w61.b, Map<Integer, Pair<v61.a, g71.b>>> r118 = r117.getCardMapV3();
        if (r118 == null) goto L54;
        DataCenter r119 = this.f83093f;
        if (r119 == null) goto L48;
        IRoom r120 = a0.n(r119);
        if (r120 == null) goto L48;
        r111 = r120.getIdStr();
    L48:
        Map<Integer, Pair<v61.a, g71.b>> r121 = r118.put(new w61.b(r111, MsgWindowPosition.BOTTOM_RIGHT), this.f83106a);
        return;
    L54:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final String c() {
        return this.f83089b;
    }

    @Override // a71.a
    public final y61.a getCommonCardContext() {
        return this.f83096i;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a, a71.a
    public WeakReference<Context> getContext() {
        return this.f83092e;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void a(final z61.a r100) {
        Intrinsics.checkNotNullParameter(r100, "commonCardEvent");
        super.a(r100);
        Map<Integer, m1> r101 = this.f83090c;
        if (r101 == null) goto L5;
        m1 r102 = r101.get(Integer.valueOf(r100.f570442b.getType()));
    L6:
        if (r102 == null) goto L20;
        Pair<v61.a, g71.b> r103 = this.f83106a.get(Integer.valueOf(r100.f570442b.getType()));
        if (r103 == null) goto L20;
        v61.a r104 = r103.getFirst();
        if (r104 == null) goto L20;
        if (this.f83097j.get(r104) != null) goto L20;
        this.f83097j.put(r104, r100.f570442b);
        y61.a r105 = this.f83096i;
        if (r105 == null) goto L20;
        final CompositeDisposable r106 = r105.registerCardCallback(r104, r100.f570442b.getType(), r100);
        if (r106 == null) goto L20;
        if (ny0.f120869a.getValue().booleanValue() == false) goto L20;
        r100.f570442b.f98965a = new BottomRightCommonCardHandler$combineTypeCardRefresh$$inlined$let$lambda$1(r106, this, r100);
    L20:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r107 = r100.f570442b;
        if (r107 != null) goto L23;
    L33:
        f(Integer.valueOf(r100.f570442b.getType()));
        return;
    L23:
        if (r107.f98971g == null) goto L33;
        Pair<v61.a, g71.b> r108 = this.f83106a.get(Integer.valueOf(r107.getType()));
        if (r108 == null) goto L33;
        v61.a r109 = r108.getFirst();
        if (r109 == null) goto L33;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r110 = r100.f570442b;
        if (r110 == null) goto L31;
        String r111 = r110.f98971g;
    L32:
        r109.e(null, r111);
        goto L33
    L31:
        r111 = null;
        goto L32
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void b(m1 r100) {
        m1 r101 = r100;
        super.b(r101);
        Integer r102 = r101.type;
        if (r102 == null) goto L25;
        int r103 = r102.intValue();
        Pair<v61.a, g71.b> r104 = this.f83106a.get(Integer.valueOf(r103));
        if (r104 == null) goto L9;
        g71.b r105 = r104.getSecond();
        if (r105 == null) goto L9;
        r105.reset();
    L9:
        Pair<v61.a, g71.b> r106 = this.f83106a.get(Integer.valueOf(r103));
        if (r106 == null) goto L14;
        v61.a r107 = r106.getFirst();
        if (r107 == null) goto L14;
        r107.dismiss();
    L14:
        this.f83106a.remove(Integer.valueOf(r103));
        this.f83090c.remove(Integer.valueOf(r103));
        Pair<v61.a, g71.b> r108 = this.f83106a.get(Integer.valueOf(r103));
        if (r108 == null) goto L26;
        v61.a r109 = r108.getFirst();
        if (r109 != null) goto L19;
        return;
    L19:
        if (e.b() == false) goto L23;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r110 = this.f83097j.get(r109);
        if (r110 == null) goto L23;
        r110.a();
    L23:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r111 = this.f83097j.remove(r109);
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void i(h r100) {
        m1 r101 = (m1) r100;
        super.i(r101);
        i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r102 == null) goto L6;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        r103.d(this.f83089b);
        r103.c("recreateCard");
        r103.a("cardData", r101.toString());
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
    L6:
        Pair<v61.a, g71.b> r105 = this.f83106a.get(r101.type);
        if (r105 == null) goto L11;
        v61.a r106 = r105.getFirst();
        if (r106 == null) goto L11;
        r106.dismiss();
    L11:
        if (r105 == null) goto L15;
        g71.b r107 = r105.getSecond();
        if (r107 == null) goto L15;
        r107.reset();
    L15:
        v61.a r108 = null;
        Disposable r109 = null;
        r109 = null;
        if (r105 == null) goto L36;
        v61.a r110 = r105.getFirst();
        if (r110 == null) goto L36;
        ICardLifecycle$State r111 = r110.A();
        if (r111 == null) goto L36;
        if (r111.isAtMost(ICardLifecycle$State.Showed) != true) goto L36;
        i r112 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r112 == null) goto L27;
        CardAlogParamsBuilder r113 = new CardAlogParamsBuilder();
        r113.d(this.f83089b);
        r113.c("cardDelayedToDisplay");
        Unit r114 = Unit.INSTANCE;
        r112.d(r113.b());
    L27:
        Disposable r115 = this.f83091d;
        if (r115 == null) goto L30;
        r115.dispose();
    L30:
        v61.a r116 = r105.getFirst();
        if (r116 == null) goto L35;
        Observable<ICardLifecycle$State> r117 = r116.v();
        if (r117 == null) goto L35;
        r109 = r117.subscribe(new b(this, r101, r105), new c(this));
    L35:
        this.f83091d = r109;
        return;
    L36:
        if (r105 == null) goto L38;
        r108 = r105.getFirst();
    L38:
        k(r101, r108);
    }

    public final void l(m1 r100) {
        i r101 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r101 == null) goto L6;
        CardAlogParamsBuilder r102 = new CardAlogParamsBuilder();
        r102.d(this.f83089b);
        r102.c("hideCard");
        Unit r103 = Unit.INSTANCE;
        r101.d(r102.b());
    L6:
        Integer r104 = r100.type;
        if (r104 == null) goto L14;
        int r105 = r104.intValue();
        Pair<v61.a, g71.b> r106 = this.f83106a.get(Integer.valueOf(r105));
        if (r106 == null) goto L15;
        v61.a r107 = r106.getFirst();
        if (r107 == null) goto L16;
        r107.hide();
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void e(m1 r100, CommonCardInitScene r101) {
        m1 r102 = r100;
        Intrinsics.checkNotNullParameter(r101, "initScene");
        super.e(r102, r101);
        if (r102 == null) goto L50;
        Map<Integer, m1> r103 = this.f83090c;
        if (r103 == null) goto L12;
        Integer r104 = r102.type;
        if (r104 == null) goto L10;
        int r105 = r104.intValue();
    L11:
        m1 r106 = r103.put(Integer.valueOf(r105), r102);
        goto L12
    L10:
        r105 = 0;
    L12:
        Pair<v61.a, g71.b> r107 = this.f83106a.get(r102.type);
        if (r107 == null) goto L38;
        v61.a r108 = r107.getFirst();
        if (r108 == null) goto L38;
        ICardLifecycle$State r109 = r108.A();
        if (r109 == null) goto L38;
        if (r109.isShowOrHide() != true) goto L38;
        if (this.f83095h != null) goto L45;
    L33:
        Pair<v61.a, g71.b> r110 = this.f83106a.get(r102.type);
        if (r110 == null) goto L47;
        v61.a r111 = r110.getFirst();
        if (r111 == null) goto L48;
        r111.e(r102, null);
        return;
    L48:
        return;
    L47:
        return;
    L45:
        l71.c r112 = ((IMsgWindowProxyService) k.n(IMsgWindowProxyService.class)).getExternalBrowserService();     // Catch: Exception -> L31
        if (r112 == null) goto L33;
        u1 r113 = r102.cardDisplayInfo;     // Catch: Exception -> L31
        if (r113 == null) goto L28;
        String r114 = r113.containerPayload;     // Catch: Exception -> L31
        if (r114 == null) goto L28;
    L29:
        r112.enqueueEvent("update_bottom_right_card", new JSONObject(r114));     // Catch: Exception -> L31
    L28:
        r114 = "";
    L31:
        e = move-exception;
        SafetyGuard.a(null, null, e.getMessage());
    L38:
        Pair<v61.a, g71.b> r115 = this.f83106a.get(r102.type);
        if (r115 == null) goto L43;
        g71.b r116 = r115.getSecond();
        if (r116 == null) goto L43;
        r116.reset();
    L43:
        m(r102, r101);
        return;
    }

    public final void k(m1 r100, v61.a r101) {
        if (e.b() == true) goto L6;
        if (r101 == null) goto L6;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r102 = this.f83097j.remove(r101);
    L6:
        if (r100 == null) goto L16;
        Map<Integer, m1> r103 = this.f83090c;
        if (r103 == null) goto L14;
        Integer r104 = r100.type;
        if (r104 == null) goto L12;
        int r105 = r104.intValue();
    L13:
        m1 r106 = r103.put(Integer.valueOf(r105), r100);
        goto L14
    L12:
        r105 = 0;
    L14:
        m(r100, CommonCardInitScene.ROOM_MSG);
        return;
    }

    public final void m(final m1 r110, final CommonCardInitScene r111) {
        Intrinsics.checkNotNullParameter(r111, "initScene");
        d(r110, r111);
        if (r110 != null) goto L5;
        return;
    L5:
        Integer r100 = r110.type;
        if (r100 == null) goto L48;
        int r112 = r100.intValue();
        gm0.b r113 = new gm0.b(r110, this.f83093f);
        a r101 = new a(this);
        Intrinsics.checkNotNullParameter(r101, "showCardCallback");
        r113.f481649b = r101;
        Context r102 = getContext().get();
        if (r102 == null) goto L46;
        Map<Integer, Pair<v61.a, g71.b>> r114 = this.f83106a;
        Integer r115 = Integer.valueOf(r112);
        DataCenter r103 = this.f83093f;
        Integer r104 = r110.priority;
        if (r104 == null) goto L12;
        int r105 = r104.intValue();
    L13:
        BottomRightCommonCard r106 = new BottomRightCommonCard(r110, r103, r112, r105, r102, r111);
        Integer r107 = r110.mockType;
        boolean r108 = true;
        if (r107 != null) goto L17;
    L19:
        boolean r109 = false;
    L20:
        if (r109 == true) goto L23;
        r108 = false;
    L23:
        r106.f553375f = r108;
        v61.d r116 = r106.f553376g;
        if (r116 == null) goto L30;
        Boolean r117 = r110.isPreloadingNeeded;
        if (r117 == null) goto L28;
        boolean r118 = r117.booleanValue();
    L29:
        r116.f553382a = r118;
        goto L30
    L28:
        r118 = false;
    L30:
        Unit r119 = Unit.INSTANCE;
        r114.put(r115, TuplesKt.to(r106, r113));
        if (e.b() == false) goto L46;
        Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r120 = this.f83097j;
        if (r120 == null) goto L46;
        Pair<v61.a, g71.b> r121 = this.f83106a.get(Integer.valueOf(r112));
        if (r121 == null) goto L37;
        v61.a r122 = r121.getFirst();
    L38:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r123 = r120.get(r122);
        if (r123 == null) goto L41;
        r123.a();
    L41:
        Pair<v61.a, g71.b> r124 = this.f83106a.get(Integer.valueOf(r112));
        if (r124 == null) goto L44;
        v61.a r125 = r124.getFirst();
    L45:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r126 = (com.bytedance.android.live.room.api.messagewindow.builder.card.b) TypeIntrinsics.asMutableMap(r120).remove(r125);
        goto L46
    L44:
        r125 = null;
        goto L45
    L37:
        r122 = null;
        goto L38
    L17:
        if (r107.intValue() != 1) goto L19;
        r109 = true;
        goto L20
    L12:
        r105 = 0;
    L46:
        r113.c();
    L48:
        if (Intrinsics.areEqual(r110.isPreloadingNeeded, Boolean.TRUE) == false) goto L95;
        final Integer r127 = r110.type;
        final BottomRightCommonCardHandler$cardPreLoading$1 r128 = BottomRightCommonCardHandler$cardPreLoading$1.INSTANCE;
        Uri r129 = mm0.c.c(r110);
        if (r129 == null) goto L105;
        WeakReference<Context> r130 = getContext();
        if (r130 == null) goto L64;
        Context r131 = r130.get();
        if (r131 == null) goto L64;
        if (this.f83095h == null) goto L64;
        Integer r132 = r110.type;
        u1 r133 = r110.cardDisplayInfo;
        if (r133 == null) goto L62;
        Integer r134 = r133.width;
        if (r134 == null) goto L62;
        int r135 = r134.intValue();
    L63:
        int r136 = UtilityKotlinExtentionsKt.i(r135);
        Intrinsics.checkNotNullParameter(r131, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r129, "uri");
        Intrinsics.checkNotNullParameter(r128, "failCallBack");
        HybridCard r137 = ((IBaseBrowserService) k.n(IBaseBrowserService.class)).getHybridCard(r131, r129, r136, new com.bytedance.android.live.messagewindow.business.presenter.d(r132, System.currentTimeMillis(), r128));
    L65:
        if (r137 == null) goto L106;
        y61.a r138 = this.f83096i;
        if (r138 == null) goto L71;
        final HybridCard r139 = r137;
        Pair<String, g<JSONObject, JSONObject>> r140 = r138.providePreLoadedJsMethod(new BottomRightCommonCardHandler$cardPreLoading$$inlined$let$lambda$1(r139, this, r110, r128, r127, r111));
        if (r140 == null) goto L71;
        r137.registerMethod(r140.getFirst(), r140.getSecond());
    L71:
        y61.a r141 = this.f83096i;
        if (r141 == null) goto L76;
        Pair<String, g<JSONObject, JSONObject>> r142 = r141.provideShowJsMethod(new BottomRightCommonCardHandler$cardPreLoading$$inlined$let$lambda$2(this, r110, r128, r127, r111));
        if (r142 == null) goto L76;
        r137.registerMethod(r142.getFirst(), r142.getSecond());
    L76:
        y61.a r143 = this.f83096i;
        if (r143 == null) goto L81;
        Pair<String, f.b> r144 = r143.provideWRDSJsMethod();
        if (r144 == null) goto L81;
        r137.registerMethod(r144.getFirst(), r144.getSecond());
    L81:
        y61.a r145 = this.f83096i;
        if (r145 == null) goto L90;
        Pair<v61.a, g71.b> r146 = this.f83106a.get(r127);
        if (r146 == null) goto L88;
        v61.a r147 = r146.getFirst();
        if (r147 == null) goto L88;
        Observable<p71.a> r148 = r147.w();
    L89:
        r145.registerJsEvent(r137, r148);
    L88:
        r148 = null;
    L90:
        y61.a r149 = this.f83096i;
        if (r149 == null) goto L93;
        Map<String, Object> r150 = r149.generateCardData(r110, r111);
    L94:
        r137.load(null, r150);
        return;
    L93:
        r150 = null;
        goto L94
    L106:
        return;
    L62:
        r135 = 112;
    L64:
        r137 = null;
        goto L65
    L105:
        return;
    L95:
        q71.a r151 = this.f83094g;
        if (r151 == null) goto L108;
        q71.d r152 = q71.a.C7292a.a(r151, r110.combineType);
        if (r152 == null) goto L109;
        int r153 = r71.f.f536400d;
        Integer r154 = r110.type;
        if (r154 == null) goto L102;
        int r155 = r154.intValue();
    L103:
        r152.b(r71.f.a.a(r155, CardDataState.SHOW, r111));
        return;
    L102:
        r155 = 0;
        goto L103
    L109:
        return;
    }

    public BottomRightCommonCardHandler(WeakReference<Context> r100, DataCenter r101, q71.a r102, CommonCardServiceWidgetPresenter r103, y61.a r104, Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "cardLifecycleMap");
        this.f83092e = r100;
        this.f83093f = r101;
        this.f83094g = r102;
        this.f83095h = r103;
        this.f83096i = r104;
        this.f83097j = r105;
        this.f83089b = "BottomRightCommonCardHandler";
        this.f83090c = new LinkedHashMap();
    }
}
