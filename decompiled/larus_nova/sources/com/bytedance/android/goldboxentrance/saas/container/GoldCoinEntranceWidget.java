package com.bytedance.android.goldboxentrance.saas.container;

import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.goldboxentrance.saas.container.view.GoldBoxFloatLayout;
import com.bytedance.android.goldboxentrance.saas.firstguide.NewBoxGuider;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;
import yz0.k;
import zg1.f3;
import zg1.m3;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/goldboxentrance/saas/container/GoldCoinEntranceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GoldCoinEntranceWidget extends LiveRecyclableWidget implements View.OnClickListener, Observer<KVData> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f58101g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NewGoldBoxViewModel f58102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f58103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GoldBoxFloatLayout f58104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintLayout f58105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HybridCard f58106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NewBoxGuider f58107f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GoldCoinEntranceWidget f58108a;

        public b(GoldCoinEntranceWidget r100) {
            this.f58108a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sw.a r101 = (sw.a) r100;
            String r102 = r101.url;
            boolean r103 = true;
            if (r102 != null) goto L5;
        L8:
            boolean r104 = true;
        L9:
            if (r104 == true) goto L28;
            GoldCoinEntranceWidget r105 = this.f58108a;
            int r106 = GoldCoinEntranceWidget.f58101g;
            if (r105.context == null) goto L30;
            NewBoxGuider r107 = r105.f58107f;
            if (r107 == null) goto L15;
            Function0<Unit> r108 = r107.f58150m;
        L16:
            String r109 = r101.url;
            if (uw.a.f551911e != uw.a.f551910d) goto L20;
            r103 = false;
        L20:
            if (r103 == false) goto L22;
            Uri.Builder r110 = UriProtector.parse(r109).buildUpon();
            r110.appendQueryParameter("orientation_changed", "1");
            r109 = r110.toString();
        L22:
            Uri r111 = UriProtector.parse(r109);
            HybridCard r112 = ((com.bytedance.android.livesdk.revenue.service.hybrid.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.hybrid.d.class)).w9(r105.context, r111, new com.bytedance.android.goldboxentrance.saas.container.a(r108));
            if (r112 == null) goto L31;
            r105.f58106e = r112;
            r112.setBackgroundColor(0);
            r112.setVisibility(0);
            r112.setLayoutParams(new FrameLayout.LayoutParams(s1.f(80.0f), s1.f(90.0f)));
            String r113 = UriProtector.getQueryParameter(r111, "url");
            HashMap r114 = new HashMap();
            r114.put(WsConstants.KEY_PAYLOAD, r101.payload);
            Unit r115 = Unit.INSTANCE;
            r112.load(r113, r114);
            GoldBoxFloatLayout r116 = r105.f58104c;
            if (r116 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("goldCoinView");
        L27:
            r116.addView(r112, 0);
            return;
        L31:
            return;
        L15:
            r108 = null;
            goto L16
        L30:
            return;
        L28:
            GoldCoinEntranceWidget.wq(this.f58108a);
            return;
        L5:
            if (r102.length() == 0) goto L8;
            r104 = false;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GoldCoinEntranceWidget f58109a;

        public c(GoldCoinEntranceWidget r100) {
            this.f58109a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            GoldCoinEntranceWidget.wq(this.f58109a);
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GoldCoinEntranceWidget f58110a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            View r100 = this.f58110a.contentView;
            if (r100 == null) goto L7;
            ViewTreeObserver r101 = r100.getViewTreeObserver();
            if (r101 == null) goto L7;
            r101.removeOnGlobalLayoutListener(this);
        L7:
            GoldCoinEntranceWidget r102 = this.f58110a;
            NewBoxGuider r103 = r102.f58107f;
            if (r103 == null) goto L13;
            ConstraintLayout r104 = r102.f58105d;
            if (r104 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("goldCoinContainer");
        L12:
            r103.f58145h = new PointF(r104.getX(), GoldCoinEntranceWidget.xq(this.f58110a).getY() - s1.f(40.0f));
        L13:
            GoldCoinEntranceWidget r105 = this.f58110a;
            NewBoxGuider r106 = r105.f58107f;
            if (r106 == null) goto L24;
            GoldBoxFloatLayout r107 = r105.f58104c;
            if (r107 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("goldCoinView");
        L18:
            float r108 = r107.getX() + GoldCoinEntranceWidget.xq(this.f58110a).getLeft();
            GoldBoxFloatLayout r109 = this.f58110a.f58104c;
            if (r109 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("goldCoinView");
        L21:
            r106.f58144g = new PointF(r108, r109.getY() + GoldCoinEntranceWidget.xq(this.f58110a).getTop());
            r106.f58142e = true;
            if (r106.f58143f == false) goto L24;
            r106.b();
        L24:
            Float r110 = uw.a.f551907a;
            float r111 = GoldCoinEntranceWidget.xq(this.f58110a).getWidth();
            float r112 = GoldCoinEntranceWidget.xq(this.f58110a).getHeight();
            uw.a.f551907a = Float.valueOf(r111);
            uw.a.f551908b = Float.valueOf(r112);
            ALogger.d("GoldBoxPositionCtl", "set ParentView Param, with: " + uw.a.f551907a + ",height: " + uw.a.f551908b);
        }

        public d(GoldCoinEntranceWidget r100) {
            this.f58110a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_right_container_portrait_widget;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        Disposable r100 = this.f58103b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        HybridCard r101 = this.f58106e;
        if (r101 == null) goto L8;
        r101.release();
    L8:
        this.f58106e = null;
    }

    public GoldCoinEntranceWidget() {
    }

    public static final void wq(GoldCoinEntranceWidget r100) {
        GoldBoxFloatLayout r101 = r100.f58104c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinView");
    L5:
        UIUtils.setViewVisibility(r101, 8);
        View r102 = r100.contentView;
        if (r102 == null) goto L15;
        ViewGroup r103 = (ViewGroup) r102;
        GoldBoxFloatLayout r104 = r100.f58104c;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinView");
    L10:
        r103.removeView(r104);
        Disposable r105 = r100.f58103b;
        if (r105 == null) goto L16;
        r105.dispose();
        return;
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final /* synthetic */ ConstraintLayout xq(GoldCoinEntranceWidget r100) {
        ConstraintLayout r101 = r100.f58105d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinContainer");
    L5:
        return r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        Object r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getKey();
    L6:
        if (r103 != null) goto L9;
        return;
    L9:
        switch(r103.hashCode()) {
            case -1518101862: goto L39;
            case -1381247050: goto L30;
            case 985679695: goto L21;
            case 1446063636: goto L12;
            default: goto L60;
        };
    L60:
        return;
    L12:
        if (r103.equals("data_right_bottom_banner_show") == true) goto L14;
        return;
    L14:
        if ((r101.getData() instanceof m3) == false) goto L49;
        Object r104 = r101.getData();
        if (r104 == null) goto L19;
        yq(((m3) r104).f571880a);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.event.VisibilityChangeEvent");
    L49:
        return;
    L21:
        if (r103.equals("data_bottom_right_state") == true) goto L23;
        return;
    L23:
        if ((r101.getData() instanceof f3) == false) goto L52;
        Object r105 = r101.getData();
        if (r105 == null) goto L28;
        yq(((f3) r105).f571830a);
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.event.ToolbarMiniAppState");
    L52:
        return;
    L30:
        if (r103.equals("data_promotion_right_card_container_show") == false) goto L54;
        Object r106 = r101.getData();
        if ((r106 instanceof Boolean) == false) goto L35;
        r102 = r106;
    L35:
        Boolean r107 = (Boolean) r102;
        if (r107 == null) goto L55;
        yq(r107.booleanValue());
        return;
    L55:
        return;
    L54:
        return;
    L39:
        if (r103.equals("data_live_interactive_component_show") == false) goto L57;
        Object r108 = r101.getData();
        if ((r108 instanceof Boolean) == false) goto L44;
        r102 = r108;
    L44:
        Boolean r109 = (Boolean) r102;
        if (r109 == null) goto L58;
        yq(r109.booleanValue());
        return;
    L58:
        return;
    L57:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        Pair r101 = com.bytedance.live.datacontext.d.a(GoldCoinEntranceWidget$onInit$pair$1.INSTANCE);
        this.f58102a = (NewGoldBoxViewModel) r101.getFirst();
        this.f58103b = (Disposable) r101.getSecond();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        DataCenter r111 = this.dataCenter;
        boolean r100 = true;
        if (r111 == null) goto L7;
        Boolean r112 = (Boolean) r111.get("data_is_portrait", Boolean.TRUE);
        if (r112 == null) goto L7;
        boolean r113 = r112.booleanValue();
    L8:
        uw.a r101 = uw.a.f551912f;
        uw.a.f551910d = uw.a.f551911e;
        uw.a.f551911e = r113;
        this.f58105d = new ConstraintLayout(this.containerView.getContext());
        ConstraintLayout.LayoutParams r102 = new ConstraintLayout.LayoutParams(-1, -1);
        r102.rightToRight = 0;
        r102.topToTop = 0;
        r102.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r102).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = 0;
        ConstraintLayout r103 = this.f58105d;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinContainer");
    L11:
        r103.setLayoutParams(r102);
        View r104 = this.contentView;
        if (r104 == null) goto L93;
        ViewGroup r105 = (ViewGroup) r104;
        ConstraintLayout r106 = this.f58105d;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinContainer");
    L16:
        r105.addView(r106);
        GoldBoxFloatLayout r107 = new GoldBoxFloatLayout(this.containerView.getContext());
        ConstraintLayout.LayoutParams r108 = new ConstraintLayout.LayoutParams(s1.f(80.0f), s1.f(90.0f));
        r108.rightToRight = 0;
        r108.bottomToBottom = 0;
        com.bytedance.tools.kcp.spongepreference.runtime.a r109 = uw.b.f551915c;
        KProperty<?>[] r114 = uw.b.f551913a;
        JSONObject r115 = null;
        if (((Number) ((Pair) r109.getValue(null, r114[1])).getFirst()).intValue() != 0) goto L20;
        tw.a r116 = new tw.a(0.0f, 0.0f);
    L36:
        if (r116.f547716a == 0.0f) goto L38;
    L47:
        if (r113 == false) goto L49;
        int r117 = s1.f(4.0f);
    L50:
        ((ViewGroup.MarginLayoutParams) r108).rightMargin = r117;
        ((ViewGroup.MarginLayoutParams) r108).bottomMargin = (int) r116.f547717b;
    L51:
        uw.a.e(((ViewGroup.MarginLayoutParams) r108).rightMargin, ((ViewGroup.MarginLayoutParams) r108).bottomMargin);
        r107.setLayoutParams(r108);
        ConstraintLayout r118 = this.f58105d;
        if (r118 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinContainer");
    L54:
        r118.addView(r107);
        if (r113 == false) goto L57;
        float r119 = 120.0f;
    L58:
        int r120 = s1.f(r119);
        if (r113 == false) goto L61;
        float r121 = 49.0f;
    L62:
        int r122 = s1.f(r121);
        float r123 = ((ViewGroup.MarginLayoutParams) r108).rightMargin;
        r107.f58121f = 0.0f;
        r107.f58122g = r120;
        r107.f58123h = r123;
        r107.f58124i = r122;
        r107.getViewTreeObserver().addOnGlobalLayoutListener(new vw.b(r107));
        r107.setOnPositionChangedListener(r101);
        r107.setOnDragUpListener(r101);
        this.f58104c = r107;
        View r124 = this.contentView;
        if (r124 == null) goto L91;
        this.f58107f = new NewBoxGuider((ViewGroup) r124);
        this.contentView.getViewTreeObserver().addOnGlobalLayoutListener(new d(this));
        k r125 = (k) f.d(j.C0.a(), k.class);
        if (r125 == null) goto L67;
        IRoom r126 = r125.getRoom();
    L68:
        if (r126 == null) goto L88;
        NewGoldBoxViewModel r127 = this.f58102a;
        if (r127 == null) goto L88;
        String r128 = r126.getOwnerUserIdString();
        long r129 = r126.getId();
        SettingKey<String> r130 = LiveInfraSettingKeys.LIVE_MOCK_EXPAND_COUPON_PARAM;
        String r131 = r130.getValue();
        if (r131 != null) goto L74;
    L77:
        if (r100 == true) goto L79;
        r115 = new JSONObject(r130.getValue());
    L85:
        Single<sw.a> r132 = r127.requestEntrance(r128, r129, r115);
        if (r132 == null) goto L88;
        r132.subscribe(new b(this), new c(this));
        goto L88
    L79:
        String r133 = (String) this.dataCenter.get("data_enter_ecom_live_params", "");
        if (by0.b.a(r133) == true) goto L94;
        Logger.e("GoldCoinEntranceWidget", "ecomParams is empty");
        goto L85
    L94:
        r115 = new JSONObject(r133).optJSONObject("expand_coupon");     // Catch: JSONException -> L83
    L83:
        Logger.e("GoldCoinEntranceWidget", "prepareExtraJSON error");
        goto L85
    L74:
        if (r131.length() == 0) goto L77;
        r100 = false;
    L88:
        this.dataCenter.observe("data_right_bottom_banner_show", this);
        this.dataCenter.observe("data_promotion_right_card_container_show", this);
        this.dataCenter.observe("data_live_interactive_component_show", this);
        this.dataCenter.observe("data_bottom_right_state", this);
        ((ObservableSubscribeProxy) ((com.bytedance.android.livesdk.revenue.service.hybrid.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.hybrid.d.class)).registerJsEventSubscriber("webcast.coin_box_pendant.on_click").observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new com.bytedance.android.goldboxentrance.saas.container.b(this));
        return;
    L67:
        r126 = null;
        goto L68
    L91:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L61:
        r121 = 45.0f;
        goto L62
    L57:
        r119 = 85.0f;
        goto L58
    L49:
        r117 = s1.f(5.0f);
        goto L50
    L38:
        if (r116.f547717b != 0.0f) goto L47;
        if (r113 == false) goto L41;
        int r134 = s1.f(4.0f);
    L42:
        ((ViewGroup.MarginLayoutParams) r108).rightMargin = r134;
        if (r113 == false) goto L45;
        float r135 = 95.0f;
    L46:
        ((ViewGroup.MarginLayoutParams) r108).bottomMargin = s1.f(r135);
        goto L51
    L45:
        r135 = 30.0f;
        goto L46
    L41:
        r134 = s1.f(5.0f);
        goto L42
    L20:
        if (((Number) ((Pair) r109.getValue(null, r114[1])).getFirst()).intValue() == uw.a.d()) goto L22;
        Float r136 = Float.valueOf(-1.0f);
        uw.b.a(new Pair(r136, r136));
        Pair r137 = new Pair(Integer.valueOf(uw.a.d()), Boolean.FALSE);
        Intrinsics.checkNotNullParameter(r137, "<set-?>");
        r109.setValue(null, r114[1], r137);
        r116 = new tw.a(0.0f, 0.0f);
        goto L36
    L22:
        Pair r138 = (Pair) uw.b.f551914b.getValue(null, r114[0]);
        if (((Number) r138.getFirst()).floatValue() != (-1.0f)) goto L25;
    L34:
        r116 = new tw.a(0.0f, 0.0f);
        goto L36
    L25:
        if (((Number) r138.getSecond()).floatValue() == (-1.0f)) goto L34;
        float r139 = ((Number) r138.getSecond()).floatValue();
        if (uw.a.f551911e == uw.a.f551910d) goto L33;
        ALogger.d("GoldBoxPositionCtl", "screen orientation was changed!");
        if (uw.a.f551911e == true) goto L32;
        r139 = r139 / 3.62f;
        goto L33
    L32:
        r139 = r139 * 3.62f;
    L33:
        ALogger.d("GoldBoxPositionCtl", "get init pos, marginB: " + r139);
        r116 = new tw.a(((Number) r138.getFirst()).floatValue(), r139);
        goto L36
    L93:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L7:
        r113 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void yq(boolean r110) {
        if (r110 == false) goto L49;
        Float r111 = uw.a.f551907a;
        float r112 = uw.a.c().f547717b;
        float r100 = uw.a.f551909c;
        if (r112 < r100) goto L6;
    L10:
        boolean r113 = false;
    L11:
        if (r113 == false) goto L50;
        ConstraintLayout r114 = this.f58105d;
        if (r114 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinContainer");
    L15:
        float r115 = r114.getWidth();
        com.bytedance.tools.kcp.spongepreference.runtime.a r101 = uw.b.f551914b;
        KProperty<?>[] r102 = uw.b.f551913a;
        float r116 = r115 - ((Number) ((Pair) r101.getValue(null, r102[0])).getFirst()).floatValue();
        ConstraintLayout r103 = this.f58105d;
        if (r103 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinContainer");
    L18:
        float r104 = r103.getHeight() - r100;
        ALogger.d("GoldCoinEntranceWidget", "gold view adjust new pos due to card dispatching Showed status, newX: " + r116 + ", newY: " + r104);
        GoldBoxFloatLayout r105 = this.f58104c;
        if (r105 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinView");
    L22:
        if (r105.f58127l == false) goto L25;
        r105.a(r116, r104, 200);
    L25:
        Pair r117 = new Pair(Integer.valueOf(uw.a.d()), Boolean.TRUE);
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        uw.b.f551915c.setValue(null, r102[1], r117);
        uw.b.a(new Pair(Float.valueOf(uw.a.c().f547716a), Float.valueOf(r100 - s1.f(90.0f))));
        NewBoxGuider r118 = this.f58107f;
        if (r118 == null) goto L34;
        ConstraintLayout r106 = this.f58105d;
        if (r106 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinContainer");
    L30:
        float r107 = r106.getX();
        ConstraintLayout r108 = this.f58105d;
        if (r108 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinContainer");
    L33:
        r118.f58145h = new PointF(r107, r108.getY() - s1.f(40.0f));
    L34:
        NewBoxGuider r119 = this.f58107f;
        if (r119 == null) goto L51;
        GoldBoxFloatLayout r109 = this.f58104c;
        if (r109 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinView");
    L39:
        float r120 = r109.getX();
        ConstraintLayout r121 = this.f58105d;
        if (r121 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinContainer");
    L42:
        float r122 = r120 + r121.getLeft();
        ConstraintLayout r123 = this.f58105d;
        if (r123 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("goldCoinContainer");
    L45:
        r119.f58144g = new PointF(r122, r104 + r123.getTop());
        r119.f58142e = true;
        if (r119.f58143f == false) goto L52;
        r119.b();
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L6:
        if (((Boolean) ((Pair) uw.b.f551915c.getValue(null, uw.b.f551913a[1])).getSecond()).booleanValue() == true) goto L10;
        if (uw.a.f551911e == false) goto L10;
        r113 = true;
        goto L11
    }
}
