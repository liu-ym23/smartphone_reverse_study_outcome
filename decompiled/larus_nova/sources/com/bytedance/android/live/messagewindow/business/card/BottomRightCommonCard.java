package com.bytedance.android.live.messagewindow.business.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter;
import com.bytedance.android.live.messagewindow.business.presenter.JsEventType;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant$Position;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant$Result;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.strategy.showintercept.ConditionId;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.android.livesdk.message.model.t1;
import com.bytedance.android.livesdk.message.model.u;
import com.bytedance.android.livesdk.message.model.u1;
import com.bytedance.android.livesdk.message.model.vd;
import com.bytedance.android.livesdk.message.model.w1;
import com.bytedance.android.livesdk.message.model.x1;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zg1.f1;
import zg1.i1;
import zl0.l;
import zl0.m;

/* JADX INFO: loaded from: classes46.dex */
public final class BottomRightCommonCard extends v61.a implements AbsCommonCardPresenter.a {
    public static final /* synthetic */ int I = 0;
    public long A;
    public long B;
    public long C;
    public m1 D;
    public final DataCenter E;
    public final Context F;
    public HybridCard G;
    public final CommonCardInitScene H;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f82906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f82907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f82908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HybridCard f82909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f82910q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public t61.c f82911r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Animator f82912s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Animator f82913t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f82914u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f82915v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f82916w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.bytedance.android.live.messagewindow.business.presenter.b f82917x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public IRoom f82918y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Disposable f82919z;

    public static final class a {
    }

    public static final class b implements t61.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomRightCommonCard f82920a;

        public static final class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f82921a;

            public a(b r100) {
                this.f82921a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                t61.c r101 = this.f82921a.f82920a.f82911r;
                if (r101 == null) goto L8;
                Function0<Unit> r102 = r101.f544657b;
                if (r102 == null) goto L9;
                Unit r103 = r102.invoke();
                return;
            L9:
                return;
            }
        }

        public b(BottomRightCommonCard r100) {
            this.f82920a = r100;
        }

        @Override // t61.a
        public final Animator a(View r100) {
            int r101 = yl0.a.f568302a;
            m1 r102 = this.f82920a.D;
            if (r102 == null) goto L7;
            u r103 = r102.animConfig;
            if (r103 == null) goto L7;
            Integer r104 = r103.enterAnimType;
        L9:
            return yl0.a.a(r104, true, r100);
        L7:
            r104 = null;
            goto L9
        }

        @Override // t61.a
        public final Animator c(View r100) {
            int r101 = yl0.a.f568302a;
            m1 r102 = this.f82920a.D;
            if (r102 == null) goto L7;
            u r103 = r102.animConfig;
            if (r103 == null) goto L7;
            Integer r104 = r103.exitAnimType;
        L9:
            return yl0.a.a(r104, false, r100);
        L7:
            r104 = null;
            goto L9
        }

        @Override // t61.a
        public final boolean b(View r100, boolean r101, t61.c r102) {
            Intrinsics.checkNotNullParameter(r100, "animView");
            Intrinsics.checkNotNullParameter(r102, "listener");
            BottomRightCommonCard r103 = this.f82920a;
            if (r103.G != null) goto L23;
            r103.f82911r = r102;
            if (r101 == true) goto L24;
            Animator r104 = r103.f82913t;
            if (r104 == null) goto L9;
            r104.cancel();
        L9:
            BottomRightCommonCard r105 = this.f82920a;
            int r106 = yl0.a.f568302a;
            m1 r107 = r105.D;
            Animator r108 = null;
            if (r107 == null) goto L14;
            u r109 = r107.animConfig;
            if (r109 == null) goto L14;
            Integer r110 = r109.exitAnimType;
        L15:
            Animator r111 = yl0.a.a(r110, false, r105.f82908o);
            if (r111 == null) goto L18;
            r111.addListener(new a(this));
            Unit r112 = Unit.INSTANCE;
            r108 = r111;
        L18:
            r105.f82913t = r108;
            Animator r113 = this.f82920a.f82913t;
            if (r113 == null) goto L25;
            r113.start();
            return true;
        L25:
            return true;
        L14:
            r110 = null;
            goto L15
        L24:
            return true;
        L23:
            return false;
        }
    }

    public static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomRightCommonCard f82922a;

        public c(BottomRightCommonCard r100) {
            this.f82922a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (r101 != null) goto L4;
            return false;
        L4:
            if (r101.getAction() != 0) goto L22;
            i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r102 == null) goto L23;
            com.bytedance.android.live.room.api.messagewindow.monitor.c r103 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_click");
            r103.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
            m1 r104 = this.f82922a.D;
            if (r104 == null) goto L11;
            Integer r105 = r104.type;
        L12:
            r103.b("type", r105);
            if ((r100.getBottom() - r101.getY()) != 0.0f) goto L15;
        L17:
            String r106 = "picture";
        L18:
            r103.b(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r106);
            Unit r107 = Unit.INSTANCE;
            r102.b(r103.a());
            return false;
        L15:
            if (((r100.getBottom() - r100.getTop()) / (r100.getBottom() - r101.getY())) <= 4) goto L17;
            r106 = "action";
            goto L18
        L11:
            r105 = null;
            goto L12
        L23:
            return false;
        L22:
            return false;
        }
    }

    static {
    }

    @Override // v61.a
    public final void I() {
        m1 r100 = this.D;
        Boolean r101 = null;
        if (r100 == null) goto L7;
        u1 r102 = r100.cardDisplayInfo;
        if (r102 == null) goto L7;
        w1 r103 = r102.preDefeatStrategy;
    L8:
        if (r100 == null) goto L12;
        u1 r104 = r100.cardDisplayInfo;
        if (r104 == null) goto L12;
        x1 r105 = r104.showDefeatStrategy;
    L13:
        t(new am0.b(r103, r105));
        int r106 = m71.e.f512327a;
        if (m71.b.f512324a.getValue().j() == false) goto L71;
        m1 r107 = this.D;
        if (r107 == null) goto L46;
        u1 r108 = r107.cardDisplayInfo;
        if (r108 == null) goto L46;
        List<t1> r109 = r108.conditionList;
        if (r109 == null) goto L46;
        Iterator<T> r110 = r109.iterator();
    L23:
        if (r110.hasNext() == false) goto L46;
        t1 r111 = (t1) r110.next();
        DataCenter r112 = this.E;
        int r113 = r111.type;
        Long r114 = r111.value;
        m1 r115 = this.D;
        if (r115 == null) goto L27;
        Integer r116 = r115.type;
    L28:
        int r117 = mm0.d.f514413a;
        if (r113 != ConditionId.ANCHOR_EXIT_MIC_NOT_DISPLAY.getValue()) goto L32;
        t71.a r118 = new zl0.b(r112, r114);
    L44:
        if (r118 == null) goto L23;
        i(r118);
        goto L23
    L32:
        if (r113 != ConditionId.SAME_ANCHOR_NOT_DISPLAY.getValue()) goto L35;
        r118 = new l(r112, r114, r116, this);
        goto L44
    L35:
        if (r113 != ConditionId.ALREADY_FOLLOWED_NOT_DISPLAY.getValue()) goto L38;
        r118 = new zl0.a(r112, r114, r116, this);
        goto L44
    L38:
        if (r113 != ConditionId.EXIT_CARD_TIMES_LIMIT.getValue()) goto L41;
        r118 = new zl0.h(r112, r114, r116, this);
        goto L44
    L41:
        if (r113 != ConditionId.CARD_SHOW_INTERVAL_TIME_LIMIT.getValue()) goto L43;
        r118 = new zl0.g(r112, r114, r116, this);
        goto L44
    L43:
        r118 = null;
        goto L44
    L27:
        r116 = null;
    L46:
        DataCenter r119 = this.E;
        m1 r120 = this.D;
        if (r120 == null) goto L49;
        Integer r121 = r120.type;
    L50:
        if (r120 == null) goto L56;
        u1 r122 = r120.cardDisplayInfo;
        if (r122 == null) goto L56;
        vd r123 = r122.landScapeConfig;
        if (r123 == null) goto L56;
        Boolean r124 = r123.isLandscapeSupported;
    L57:
        int r125 = mm0.d.f514413a;
        ArrayList r126 = new ArrayList();
        r126.add(new m(r119, 0L, r121, this, r124));
        r126.add(new zl0.i(r119, 0L, r121, this));
        if (r121 != null) goto L61;
    L63:
        Iterator r127 = r126.iterator();
    L65:
        if (r127.hasNext() == false) goto L67;
        i((t71.a) r127.next());
        goto L65
    L67:
        i r128 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r128 == null) goto L71;
        CardAlogParamsBuilder r129 = new CardAlogParamsBuilder();
        r129.d("PortraitBottomRightCommonCard");
        r129.c("addCardCondition");
        r129.a("conditions", u().toString());
        Unit r130 = Unit.INSTANCE;
        r128.d(r129.b());
        goto L71
    L61:
        if (r121.intValue() != 1) goto L63;
        r126.add(new l(r119, 0L, r121, this));
        r126.add(new zl0.b(r119, 0L));
        r126.add(new zl0.a(r119, 0L, r121, this));
    L56:
        r124 = null;
        goto L57
    L49:
        r121 = null;
    L71:
        int r131 = m71.e.f512327a;
        if (m71.b.f512324a.getValue().a() == true) goto L74;
        a0();
    L74:
        m1 r132 = this.D;
        if (r132 == null) goto L85;
        u r133 = r132.animConfig;
        if (r133 == null) goto L85;
        Boolean r134 = r133.isAnimSupported;
        if (r134 == null) goto L85;
        if (r134.booleanValue() == false) goto L83;
        r101 = r134;
    L83:
        if (r101 == null) goto L85;
        r101.booleanValue();
        c(new b(this));
    L85:
        i r135 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r135 == null) goto L96;
        CardAlogParamsBuilder r136 = new CardAlogParamsBuilder();
        r136.d("PortraitBottomRightCommonCard");
        r136.c(WidgetCostModule.TYPE_ON_CREATE);
        Unit r137 = Unit.INSTANCE;
        r135.d(r136.b());
        return;
    L96:
        return;
    L12:
        r105 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // v61.a
    public final void K() {
        com.bytedance.android.live.messagewindow.business.presenter.b r100 = this.f82917x;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        r100.f0(this.f82909p, false);
        if (this.B <= 0) goto L9;
        this.C += System.currentTimeMillis() - this.B;
        this.B = -1;
    L9:
        DataCenter r101 = this.E;
        if (r101 == null) goto L12;
        r101.put("data_live_bottom_right_card_show", new f1(false, 0));
    L12:
        i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r102 == null) goto L17;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        r103.d("PortraitBottomRightCommonCard");
        r103.c("onHide");
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
        return;
    }

    @Override // v61.a
    public final void L() {
        com.bytedance.android.live.messagewindow.business.presenter.b r100 = this.f82917x;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        r100.f0(this.f82909p, true);
        this.B = System.currentTimeMillis();
        DataCenter r101 = this.E;
        if (r101 == null) goto L17;
        m1 r102 = this.D;
        if (r102 == null) goto L14;
        u1 r103 = r102.cardDisplayInfo;
        if (r103 == null) goto L14;
        Integer r104 = r103.width;
        if (r104 == null) goto L14;
        int r105 = UtilityKotlinExtentionsKt.i(r104.intValue());
    L15:
        r101.put("data_live_bottom_right_card_show", new f1(true, r105));
    L14:
        r105 = ((Number) this.f82914u.getValue()).intValue();
    L17:
        if (this.f82910q == false) goto L19;
        S();
    L19:
        i r106 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        Integer r107 = null;
        if (r106 == null) goto L54;
        CardAlogParamsBuilder r108 = new CardAlogParamsBuilder();
        r108.d("PortraitBottomRightCommonCard");
        r108.c(SendEventContainerMethodParamModel.EventKinds.onShow);
        if (this.f553375f == false) goto L53;
        StringBuilder r109 = new StringBuilder("卡片的页面类型为：");
        m1 r110 = this.D;
        if (r110 == null) goto L29;
        u1 r111 = r110.cardDisplayInfo;
        if (r111 == null) goto L29;
        Integer r112 = Integer.valueOf(r111.containerType);
    L30:
        if (r112 != null) goto L33;
    L35:
        if (r112 != null) goto L38;
    L40:
        if (r112 != null) goto L43;
    L45:
        String r113 = "Unknown";
    L46:
        r109.append(r113);
        r109.append("，地址为：");
        m1 r114 = this.D;
        if (r114 == null) goto L51;
        u1 r115 = r114.cardDisplayInfo;
        if (r115 == null) goto L51;
        String r116 = r115.url;
    L52:
        r109.append(r116);
        r108.c(r109.toString());
    L51:
        r116 = null;
        goto L52
    L43:
        if (r112.intValue() != 3) goto L45;
        r113 = "Schema";
        goto L46
    L38:
        if (r112.intValue() != 2) goto L40;
        r113 = "WebView";
        goto L46
    L33:
        if (r112.intValue() != 1) goto L35;
        r113 = "Lynx";
    L29:
        r112 = null;
    L53:
        Unit r117 = Unit.INSTANCE;
        r106.d(r108.b());
    L54:
        i r118 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r118 == null) goto L66;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r119 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_show");
        r119.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        m1 r120 = this.D;
        if (r120 == null) goto L60;
        Integer r121 = r120.type;
    L61:
        r119.b("type", r121);
        m1 r122 = this.D;
        if (r122 == null) goto L64;
        r107 = r122.priority;
    L64:
        r119.b("priority", r107);
        Unit r123 = Unit.INSTANCE;
        r118.b(r119.a());
        return;
    L60:
        r121 = null;
        goto L61
    }

    @Override // v61.a
    public final void M() {
        HybridCard r100 = this.G;
        if (r100 == null) goto L5;
        this.f82909p = r100;
        this.f82910q = true;
    L5:
        int r101 = m71.e.f512327a;
        if (m71.b.f512324a.getValue().a() == false) goto L8;
        a0();
    L8:
        DataCenter r102 = this.E;
        IRoom r103 = null;
        if (r102 == null) goto L11;
        r103 = (IRoom) r102.get("data_room", null);
    L11:
        this.f82918y = r103;
        T();
        i r104 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r104 == null) goto L16;
        CardAlogParamsBuilder r105 = new CardAlogParamsBuilder();
        r105.d("PortraitBottomRightCommonCard");
        r105.c(WidgetCostModule.TYPE_ON_START);
        Unit r106 = Unit.INSTANCE;
        r104.d(r105.b());
        return;
    }

    public final void S() {
        HybridCard r100 = this.f82909p;
        if (r100 == null) goto L14;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L7;
        r101 = null;
    L7:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 == null) goto L10;
        r102.removeView(r100);
    L10:
        ViewGroup r103 = this.f82908o;
        if (r103 == null) goto L15;
        r103.addView(r100, new ViewGroup.LayoutParams(-1, -1));
        return;
    L15:
        return;
    }

    public final void a0() {
        m1 r100 = this.D;
        if (r100 == null) goto L27;
        u1 r101 = r100.cardDisplayInfo;
        if (r101 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(b0(), Boolean.TRUE) == false) goto L9;
        CardConstraint r102 = V(r101.width, r101.height, r101.right, r101.bottom);
    L22:
        P(r102);
        i r103 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r103 == null) goto L29;
        CardAlogParamsBuilder r104 = new CardAlogParamsBuilder();
        r104.d("PortraitBottomRightCommonCard");
        r104.c("setConstraint");
        r104.a("width", Integer.valueOf(this.f553371b.f98979f));
        r104.a("height", Integer.valueOf(this.f553371b.f98980g));
        r104.a("right", Integer.valueOf(this.f553371b.f98977d));
        r104.a("bottom", Integer.valueOf(this.f553371b.f98978e));
        Unit r105 = Unit.INSTANCE;
        r103.d(r104.b());
        return;
    L29:
        return;
    L9:
        vd r106 = r101.landScapeConfig;
        Integer r107 = null;
        if (r106 == null) goto L12;
        Integer r108 = r106.width;
    L13:
        if (r106 == null) goto L15;
        Integer r109 = r106.height;
    L16:
        if (r106 == null) goto L18;
        Integer r110 = r106.right;
    L19:
        if (r106 == null) goto L21;
        r107 = r106.bottom;
    L21:
        r102 = V(r108, r109, r110, r107);
        goto L22
    L18:
        r110 = null;
        goto L19
    L15:
        r109 = null;
        goto L16
    L12:
        r108 = null;
        goto L13
    }

    public final Boolean b0() {
        IRoomContextService r100 = (IRoomContextService) k.f(IRoomContextService.class);
        boolean r101 = true;
        if (r100 == null) goto L12;
        o r102 = IRoomContextService.a.a(r100, this.E, 0, 2);
        if (r102 == null) goto L12;
        com.bytedance.live.datacontext.m<Integer> r103 = r102.v2();
        if (r103 == null) goto L12;
        Integer r104 = r103.getValue();
        if (r104 == null) goto L12;
        r101 = r104.equals(1);
    L12:
        return Boolean.valueOf(r101);
    }

    @Override // v61.c
    public final x61.h<?, ?> content() {
        x61.h.f562592a.getClass();
        return new x61.e();
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void CA() {
        S();
        m1 r100 = this.D;
        Integer r101 = null;
        if (r100 == null) goto L34;
        u r102 = r100.animConfig;
        if (r102 == null) goto L34;
        Boolean r103 = r102.isAnimSupported;
        if (r103 == null) goto L34;
        if (r103.booleanValue() == true) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == true) goto L17;
        r103 = null;
    L17:
        if (r103 == null) goto L34;
        r103.booleanValue();
        Animator r105 = this.f82912s;
        if (r105 == null) goto L21;
        r105.cancel();
    L21:
        int r106 = yl0.a.f568302a;
        m1 r107 = this.D;
        if (r107 == null) goto L26;
        u r108 = r107.animConfig;
        if (r108 == null) goto L26;
        Integer r109 = r108.enterAnimType;
    L27:
        Animator r110 = yl0.a.a(r109, true, this.f82908o);
        if (r110 == null) goto L30;
        r110.addListener(new com.bytedance.android.live.messagewindow.business.card.b(this));
        Unit r111 = Unit.INSTANCE;
    L31:
        this.f82912s = r110;
        if (r110 == null) goto L34;
        r110.start();
        goto L34
    L30:
        r110 = null;
    L26:
        r109 = null;
        goto L27
    L11:
        if (this.G != null) goto L13;
        r104 = true;
    L34:
        i r112 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r112 == null) goto L38;
        CardAlogParamsBuilder r113 = new CardAlogParamsBuilder();
        r113.d("PortraitBottomRightCommonCard");
        r113.c("onHybridCardLoadSuccess");
        Unit r114 = Unit.INSTANCE;
        r112.d(r113.b());
    L38:
        i r115 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r115 == null) goto L46;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r116 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_result");
        r116.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        m1 r117 = this.D;
        if (r117 == null) goto L44;
        Integer r118 = r117.type;
    L45:
        r116.b("type", r118);
        r116.b("result", Integer.valueOf(CommonCardConstant$Result.SUCCESS.getValue()));
        Unit r119 = Unit.INSTANCE;
        r115.b(r116.a());
        goto L46
    L44:
        r118 = null;
    L46:
        i r120 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r120 == null) goto L54;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r121 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_time_cost");
        r121.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        m1 r122 = this.D;
        if (r122 == null) goto L52;
        r101 = r122.type;
    L52:
        r121.b("type", r101);
        r121.b(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(System.currentTimeMillis() - this.A));
        Unit r123 = Unit.INSTANCE;
        r120.b(r121.a());
        return;
    }

    @Override // v61.a
    public final void J() {
        super.J();
        com.bytedance.android.live.messagewindow.business.presenter.b r100 = this.f82917x;
        if (r100 == null) goto L5;
        r100.detachView();
    L5:
        HybridCard r101 = this.f82909p;
        if (r101 == null) goto L8;
        r101.release();
    L8:
        ViewGroup r102 = this.f82908o;
        if (r102 == null) goto L11;
        r102.removeAllViews();
    L11:
        this.f82909p = null;
        this.f82910q = false;
        Disposable r103 = this.f82919z;
        if (r103 == null) goto L14;
        r103.dispose();
    L14:
        i r104 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r104 == null) goto L19;
        CardAlogParamsBuilder r105 = new CardAlogParamsBuilder();
        r105.d("PortraitBottomRightCommonCard");
        r105.c(LiveCommonConstants.REASON_ON_DEDTROY);
        Unit r106 = Unit.INSTANCE;
        r104.d(r105.b());
    L19:
        if (this.B <= 0) goto L22;
        this.C += System.currentTimeMillis() - this.B;
        this.B = -1;
    L22:
        i r107 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r107 == null) goto L34;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r108 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_show_duration");
        r108.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        m1 r109 = this.D;
        if (r109 == null) goto L28;
        Integer r110 = r109.type;
    L29:
        r108.b("type", r110);
        m1 r111 = this.D;
        if (r111 == null) goto L32;
        Integer r112 = r111.priority;
    L33:
        r108.b("priority", r112);
        r108.b("duration", Long.valueOf(this.C));
        Unit r113 = Unit.INSTANCE;
        r107.b(r108.a());
        goto L34
    L32:
        r112 = null;
        goto L33
    L28:
        r110 = null;
    L34:
        this.C = 0;
        Animator r114 = this.f82912s;
        if (r114 == null) goto L37;
        r114.removeAllListeners();
    L37:
        Animator r115 = this.f82913t;
        if (r115 == null) goto L40;
        r115.removeAllListeners();
    L40:
        Animator r116 = this.f82912s;
        if (r116 == null) goto L43;
        r116.cancel();
    L43:
        Animator r117 = this.f82913t;
        if (r117 == null) goto L46;
        r117.cancel();
    L46:
        this.f82912s = null;
        this.f82913t = null;
        this.f82911r = null;
    }

    public final void T() {
        Boolean r100 = b0();
        if (r100 == null) goto L20;
        Disposable r101 = null;
        if (r100.booleanValue() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L21;
        r100.booleanValue();
        Disposable r102 = this.f82919z;
        if (r102 == null) goto L12;
        r102.dispose();
    L12:
        com.bytedance.android.live.messagewindow.business.presenter.b r103 = this.f82917x;
        if (r103 == null) goto L22;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L16:
        if (r103 == null) goto L18;
        r101 = xs2.b.a().b(i1.class).subscribe(new com.bytedance.android.live.messagewindow.business.presenter.c(r103, this.f553373d, this.f82918y));
    L18:
        this.f82919z = r101;
        return;
    L22:
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void yA() {
        i r100 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r100 == null) goto L7;
        CardAlogParamsBuilder r101 = new CardAlogParamsBuilder();
        r101.d("PortraitBottomRightCommonCard");
        r101.c("onHybridCardLoadStart");
        Unit r102 = Unit.INSTANCE;
        r100.d(r101.b());
        return;
    }

    public final Context getContext() {
        return this.F;
    }

    @Override // v61.a, r61.b
    public final DataCenter getDataCenter() {
        return this.E;
    }

    @Override // v61.a
    public final void N(View r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        View r101 = this.f553373d;
        HybridCard r102 = null;
        if (r101 == null) goto L5;
        ViewGroup r103 = (ViewGroup) r101.findViewById(R.id.ttlive_layout_portrait_bottom_right_card);
    L7:
        if ((r103 instanceof ViewGroup) == true) goto L9;
        r103 = null;
    L9:
        this.f82908o = r103;
        View r104 = this.f553373d;
        if (r104 == null) goto L18;
        m1 r105 = this.D;
        if (r105 == null) goto L16;
        u1 r106 = r105.cardDisplayInfo;
        if (r106 == null) goto L16;
        String r107 = r106.accessibleName;
    L17:
        r104.setContentDescription(r107);
    L16:
        r107 = null;
    L18:
        com.bytedance.android.live.messagewindow.business.presenter.b r108 = this.f82917x;
        if (r108 == null) goto L21;
        r108.f531633a = this;
    L22:
        this.A = System.currentTimeMillis();
        HybridCard r109 = this.f82909p;
        if (r109 != null) goto L69;
        m1 r110 = this.D;
        if (r110 == null) goto L67;
        Uri r111 = mm0.c.c(r110);
        if (r111 == null) goto L67;
        com.bytedance.android.live.messagewindow.business.presenter.b r112 = this.f82917x;
        if (r112 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L31:
        Context r113 = this.F;
        m1 r114 = this.D;
        if (r114 == null) goto L38;
        u1 r115 = r114.cardDisplayInfo;
        if (r115 == null) goto L38;
        Integer r116 = r115.width;
        if (r116 == null) goto L38;
        int r117 = UtilityKotlinExtentionsKt.i(r116.intValue());
    L39:
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "uri");
        HybridCard r118 = ((IBaseBrowserService) k.n(IBaseBrowserService.class)).getHybridCard(r113, r111, r117, new com.bytedance.android.live.messagewindow.business.presenter.a(r112));
        if (r118 == null) goto L67;
        com.bytedance.android.live.messagewindow.business.presenter.b r119 = this.f82917x;
        if (r119 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L44:
        r119.h0();
        com.bytedance.android.live.messagewindow.business.presenter.b r120 = this.f82917x;
        if (r120 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L47:
        r120.i0();
        com.bytedance.android.live.messagewindow.business.presenter.b r121 = this.f82917x;
        if (r121 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L50:
        r121.e0(r118);
        com.bytedance.android.live.messagewindow.business.presenter.b r122 = this.f82917x;
        if (r122 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L53:
        Observable<p71.a> r123 = w();
        y61.a r124 = r122.c0();
        if (r124 == null) goto L56;
        r124.registerJsEvent(r118, r123);
    L56:
        com.bytedance.android.live.messagewindow.business.presenter.b r125 = this.f82917x;
        if (r125 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L59:
        if (r125 == null) goto L65;
        m1 r126 = this.D;
        CommonCardInitScene r127 = this.H;
        Intrinsics.checkNotNullParameter(r127, "initScene");
        y61.a r128 = r125.c0();
        if (r128 == null) goto L64;
        Map<String, Object> r129 = r128.generateCardData(r126, r127);
        if (r129 == null) goto L64;
    L66:
        r118.load(null, r129);
        r102 = r118;
    L64:
        r129 = new LinkedHashMap();
        goto L66
    L65:
        r129 = null;
    L38:
        r117 = ((Number) this.f82914u.getValue()).intValue();
    L67:
        this.f82909p = r102;
    L80:
        c r130 = new c(this);
        HybridCard r131 = this.f82909p;
        if (r131 == null) goto L83;
        r131.setOnTouchListener(r130);
    L83:
        T();
        i r132 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r132 == null) goto L88;
        CardAlogParamsBuilder r133 = new CardAlogParamsBuilder();
        r133.d("PortraitBottomRightCommonCard");
        r133.c("onViewCreate");
        Unit r134 = Unit.INSTANCE;
        r132.d(r133.b());
        return;
    L88:
        return;
    L69:
        if (this.G == null) goto L80;
        com.bytedance.android.live.messagewindow.business.presenter.b r135 = this.f82917x;
        if (r135 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L73:
        r135.h0();
        com.bytedance.android.live.messagewindow.business.presenter.b r136 = this.f82917x;
        if (r136 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L76:
        r136.i0();
        com.bytedance.android.live.messagewindow.business.presenter.b r137 = this.f82917x;
        if (r137 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L79:
        r137.e0(r109);
        goto L80
    L21:
        com.bytedance.android.live.messagewindow.business.presenter.b r138 = new com.bytedance.android.live.messagewindow.business.presenter.b(this.E);
        r138.f531633a = this;
        Unit r139 = Unit.INSTANCE;
        this.f82917x = r138;
        goto L22
    L5:
        r103 = null;
        goto L7
    }

    @Override // v61.a
    public final void Q(HybridCard r100) {
        this.G = r100;
    }

    public final void W(Map<String, ? extends Object> r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("activeClose");
    L6:
        Boolean r103 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r103) == false) goto L27;
        IRoom r104 = this.f82918y;
        if (r104 == null) goto L13;
        OfficialChannelExtraInfo r105 = r104.getOfficialChannelExtraInfo();
        if (r105 == null) goto L13;
        Long r106 = Long.valueOf(r105.getShowListId());
    L14:
        Boolean r107 = Boolean.valueOf(mm0.b.b(r106));
        IRoom r108 = this.f82918y;
        if (r108 == null) goto L17;
        Long r109 = Long.valueOf(r108.getId());
    L18:
        IRoom r110 = this.f82918y;
        if (r110 == null) goto L21;
        String r111 = r110.getOfficialChannelUidString();
    L22:
        String r112 = mm0.b.c(r107, r109, r111);
        m1 r113 = this.D;
        if (r113 == null) goto L25;
        Integer r114 = r113.type;
    L26:
        com.bytedance.android.live.messagewindow.business.util.c.a(r112, r114, true);
        goto L27
    L25:
        r114 = null;
        goto L26
    L21:
        r111 = null;
        goto L22
    L17:
        r109 = null;
    L13:
        r106 = null;
    L27:
        if (r100 == null) goto L30;
        r101 = r100.get("activeClose");
    L30:
        if (Intrinsics.areEqual(r101, r103) == false) goto L32;
        b71.a r115 = new b71.a.C0274a();
    L33:
        this.f553377h = r115;
        return;
    L32:
        r115 = new b71.a.b();
        goto L33
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void bi(String r100) {
        dismiss();
        i r101 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r101 == null) goto L6;
        CardAlogParamsBuilder r102 = new CardAlogParamsBuilder();
        r102.d("PortraitBottomRightCommonCard");
        r102.c("onHybridCadLoadFail");
        Unit r103 = Unit.INSTANCE;
        r101.d(r102.b());
    L6:
        i r104 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r104 == null) goto L15;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r105 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_result");
        r105.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        m1 r106 = this.D;
        if (r106 == null) goto L12;
        Integer r107 = r106.type;
    L13:
        r105.b("type", r107);
        r105.b("result", Integer.valueOf(CommonCardConstant$Result.FAIL.getValue()));
        r105.b("error_msg", r100);
        Unit r108 = Unit.INSTANCE;
        r104.b(r105.a());
        return;
    L12:
        r107 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void IG(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r102 == null) goto L6;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        r103.d("PortraitBottomRightCommonCard");
        r103.c("onHybridCardLoadFallback");
        r103.a("errorCode", String.valueOf(r100));
        r103.a("errorMessage", r101);
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
    L6:
        i r105 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r105 == null) goto L15;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r106 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_fallback");
        r106.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        m1 r107 = this.D;
        if (r107 == null) goto L12;
        Integer r108 = r107.type;
    L13:
        r106.b("type", r108);
        r106.b("error_code", String.valueOf(r100));
        r106.b("error_msg", r101);
        Unit r109 = Unit.INSTANCE;
        r105.b(r106.a());
        return;
    L12:
        r108 = null;
        goto L13
    }

    @Override // v61.a, v61.b
    public final void e(vh7.h r100, String r101) {
        String r102 = null;
        if ((r100 instanceof m1) == true) goto L5;
        r100 = null;
    L5:
        m1 r103 = (m1) r100;
        if (this.f82917x != null) goto L8;
        this.f82917x = new com.bytedance.android.live.messagewindow.business.presenter.b(this.E);
    L8:
        com.bytedance.android.live.messagewindow.business.presenter.b r104 = this.f82917x;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L11:
        if (r104 == null) goto L20;
        HybridCard r105 = this.f82909p;
        if (r105 != null) goto L15;
        r105 = this.G;
    L15:
        if (r103 == null) goto L19;
        u1 r106 = r103.cardDisplayInfo;
        if (r106 == null) goto L19;
        r102 = r106.containerPayload;
    L19:
        r104.g0(r105, r102, r101);
    L20:
        if (r103 == null) goto L23;
        this.D = r103;
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter.a
    public final void gG(JsEventType r100, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        i r101 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r101 == null) goto L6;
        CardAlogParamsBuilder r102 = new CardAlogParamsBuilder();
        r102.d("PortraitBottomRightCommonCard");
        r102.c("handleJsEvent");
        r102.a("eventType", r100);
        r102.a("params", String.valueOf(r110));
        Unit r103 = Unit.INSTANCE;
        r101.d(r102.b());
    L6:
        int r104 = com.bytedance.android.live.messagewindow.business.card.a.f82923a[r100.ordinal()];
        String r105 = "2";
        Object r106 = null;
        if (r104 != 1) goto L9;
        W(r110);
        i r107 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r107 == null) goto L51;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r108 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_destroy");
        r108.b("position", Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue()));
        m1 r109 = this.D;
        if (r109 == null) goto L41;
        Integer r111 = r109.type;
    L42:
        r108.b("type", r111);
        if (r110 == null) goto L45;
        Object r112 = r110.get("activeClose");
    L47:
        if (Intrinsics.areEqual(r112, Boolean.TRUE) == false) goto L49;
        Object r113 = "2";
    L50:
        r108.b("reason", r113);
        Unit r114 = Unit.INSTANCE;
        r107.b(r108.a());
        goto L51
    L49:
        r113 = "1";
        goto L50
    L45:
        r112 = null;
        goto L47
    L41:
        r111 = null;
    L51:
        i r115 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r115 == null) goto L66;
        CardAlogParamsBuilder r116 = new CardAlogParamsBuilder();
        r116.d("PortraitBottomRightCommonCard");
        StringBuilder r117 = new StringBuilder("handle js event: close card, card type: ");
        m1 r118 = this.D;
        if (r118 == null) goto L57;
        Integer r119 = r118.type;
    L58:
        r117.append(r119);
        r117.append(", reason: ");
        if (r110 == null) goto L62;
        r106 = r110.get("activeClose");
    L62:
        if (Intrinsics.areEqual(r106, Boolean.TRUE) == true) goto L65;
        r105 = "1";
    L65:
        r117.append(r105);
        r116.c(r117.toString());
        Unit r120 = Unit.INSTANCE;
        r115.d(r116.b());
        goto L66
    L57:
        r119 = null;
    L66:
        dismiss();
        return;
    L9:
        if (r104 != 2) goto L11;
        W(r110);
        hide();
        i r121 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r121 == null) goto L72;
        CardAlogParamsBuilder r122 = new CardAlogParamsBuilder();
        r122.d("PortraitBottomRightCommonCard");
        StringBuilder r123 = new StringBuilder("handle js event: hide card, card type: ");
        m1 r124 = this.D;
        if (r124 == null) goto L26;
        Integer r125 = r124.type;
    L27:
        r123.append(r125);
        r123.append("reason: ");
        if (r110 == null) goto L31;
        r106 = r110.get("activeClose");
    L31:
        if (Intrinsics.areEqual(r106, Boolean.TRUE) == true) goto L34;
        r105 = "1";
    L34:
        r123.append(r105);
        r122.c(r123.toString());
        Unit r126 = Unit.INSTANCE;
        r121.d(r122.b());
        return;
    L26:
        r125 = null;
        goto L27
    L72:
        return;
    L11:
        if (r104 != 3) goto L70;
        show();
        i r127 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r127 == null) goto L71;
        CardAlogParamsBuilder r128 = new CardAlogParamsBuilder();
        r128.d("PortraitBottomRightCommonCard");
        StringBuilder r129 = new StringBuilder("handle js event: show card, card type: ");
        m1 r130 = this.D;
        if (r130 == null) goto L19;
        r106 = r130.type;
    L19:
        r129.append(r106);
        r128.c(r129.toString());
        Unit r131 = Unit.INSTANCE;
        r127.d(r128.b());
        return;
    L71:
        return;
    }

    public final CardConstraint V(Integer r100, Integer r101, final Integer r102, final Integer r103) {
        if (mm0.b.a(r100) == false) goto L5;
    L15:
        int r104 = CardConstraint.f98973h;
        CardConstraint r105 = new CardConstraint(new CardConstraint(((Number) this.f82914u.getValue()).intValue(), ((Number) this.f82915v.getValue()).intValue()));
    L16:
        r105.b(CardConstraint.Position.BottomRight);
        r105.a(new BottomRightCommonCard$commonCardConstraint$$inlined$apply$lambda$1(this, r102, r103));
        return r105;
    L5:
        if (mm0.b.a(r101) == true) goto L15;
        int r106 = CardConstraint.f98973h;
        if (r100 == null) goto L10;
        int r107 = UtilityKotlinExtentionsKt.i(r100.intValue());
    L11:
        if (r101 == null) goto L13;
        int r108 = UtilityKotlinExtentionsKt.i(r101.intValue());
    L14:
        r105 = new CardConstraint(new CardConstraint(r107, r108));
        goto L16
    L13:
        r108 = ((Number) this.f82915v.getValue()).intValue();
        goto L14
    L10:
        r107 = ((Number) this.f82914u.getValue()).intValue();
        goto L11
    }

    public BottomRightCommonCard(m1 r100, DataCenter r101, int r102, int r103, Context r104, CommonCardInitScene r105) {
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "initScene");
        super(r101, Integer.valueOf(r102), r103);
        this.D = r100;
        this.E = r101;
        this.F = r104;
        this.G = null;
        this.H = r105;
        int r106 = s1.j(com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.a.a(Boolean.valueOf(a0.d(r101, false))));
        this.f82906m = r106;
        this.f82907n = r106 + s1.f(8.0f);
        this.f82914u = LazyKt.lazy(BottomRightCommonCard$DEFAULT_CARD_CONTAINER_WIDTH$2.INSTANCE);
        this.f82915v = LazyKt.lazy(BottomRightCommonCard$DEFAULT_CARD_CONTAINER_HEIGHT$2.INSTANCE);
        this.f82916w = LazyKt.lazy(BottomRightCommonCard$DEFAULT_CARD_CONTAINER_RIGHT$2.INSTANCE);
        this.A = System.currentTimeMillis();
        this.B = -1;
    }
}
