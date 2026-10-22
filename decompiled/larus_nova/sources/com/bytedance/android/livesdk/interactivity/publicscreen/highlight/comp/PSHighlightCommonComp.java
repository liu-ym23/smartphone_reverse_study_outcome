package com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp;

import ak6.g;
import am2.x;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.config.cl0;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.api.comment.keyboard.HintType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightRenderHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.TriggerKey;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.r;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.trigger.ComponentShowTrigger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.trigger.TopicDismissTrigger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.bytedance.android.livesdk.interactivity.api.settings.config.PSHighlightCommonConfig;
import com.bytedance.android.livesdk.interactivity.j;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.RoomHighlightAreaContainerMessage;
import com.bytedance.android.livesdk.message.model.b6;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tb2.e;
import tb2.f;

/* JADX INFO: loaded from: classes9.dex */
public final class PSHighlightCommonComp extends AbsPSHighlightComp implements m.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f138923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f138924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f138925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f138926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<b6.b, List<m>> f138927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RoomHighlightAreaContainerMessage f138928k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PSHighlightType f138929l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f138930m;

    public static final class a implements PSHighlightRenderHelper.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PSHighlightCommonComp f138931a;

        public a(PSHighlightCommonComp r100) {
            this.f138931a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightRenderHelper.a
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            b6 r101 = this.f138931a.u();
            if (r101 == null) goto L5;
            String r102 = r101.g();
        L6:
            xs2.b.a().post(new q42.a(this.f138931a));
            if (TextUtils.isEmpty(r102) == true) goto L14;
            IBaseLiveActionHandler r103 = (IBaseLiveActionHandler) k.f(IBaseLiveActionHandler.class);
            if (r103 != null) goto L11;
            return;
        L11:
            if (r103.handle(ContextUtil.contextToActivity(this.f138931a.f138930m), r102) != true) goto L16;
            this.f138931a.v("default", null);
            return;
        L16:
            return;
        L14:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightRenderHelper.a
        public final boolean b(View r100, ek6.c r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "action");
            int r102 = PSHighlightRenderHelper.f133410a;
            String r103 = null;
            if ((r101 instanceof ib2.a) == true) goto L5;
            r101 = null;
        L5:
            ib2.a r104 = (ib2.a) r101;
            if (r104 == null) goto L8;
            tb2.b r105 = r104.f488989a;
        L10:
            if ((r105 instanceof e) == true) goto L12;
            r105 = null;
        L12:
            e r106 = (e) r105;
            if (r106 != null) goto L15;
            return false;
        L15:
            if (f.a(r106) == false) goto L33;
            xs2.b.a().post(new q42.a(this.f138931a));
            String r107 = r106.a().f58893a;
            if (r107 != null) goto L19;
            return true;
        L19:
            if (Intrinsics.areEqual(r107, "main_btn") == false) goto L26;
            PSHighlightCommonComp r108 = this.f138931a;
            b6 r109 = r108.f138928k.getHighlightAreaContainer();
            if (r109 == null) goto L25;
            Map<String, String> r110 = r109.c();
            if (r110 == null) goto L25;
            r103 = r110.get("main_btn_txt");
        L25:
            r108.v(r107, r103);
            return true;
        L26:
            this.f138931a.v(r107, null);
            return true;
        L33:
            return false;
        L8:
            r105 = null;
            goto L10
        }
    }

    public static final class b implements ak6.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PSHighlightCommonComp f138932a;

        public b(PSHighlightCommonComp r100) {
            this.f138932a = r100;
        }

        @Override // ak6.e
        public final void a(g r100) {
            Intrinsics.checkNotNullParameter(r100, "rendResult");
            Intrinsics.checkNotNullParameter(r100, "rendResult");
        }

        @Override // ak6.e
        public final void b(g r100) {
            Intrinsics.checkNotNullParameter(r100, "rendResult");
            TextView r101 = this.f138932a.f138924g;
            if (r101 == null) goto L5;
            r101.setText(r100.f4074a);
        L5:
            PSHighlightCommonComp r102 = this.f138932a;
            if (PSHighlightCommonComp.r(r102, r102.f138928k) == false) goto L12;
            TextView r103 = this.f138932a.f138924g;
            if (r103 == null) goto L13;
            r103.post(new d(r103));
            return;
        L13:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void b() {
        Disposable r100 = this.f138925h;
        if (r100 != null) goto L5;
    L10:
        this.f138925h = null;
        super.b();
        return;
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final String e() {
        StringBuilder r100 = new StringBuilder();
        r100.append(getType().getType());
        r100.append('_');
        r100.append(getType().getBizScene());
        r100.append('_');
        b6 r101 = u();
        if (r101 == null) goto L5;
        Long r102 = r101.f();
    L6:
        r100.append(r102);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void j() {
        Disposable r100 = this.f138925h;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f138925h = null;
        this.f138926i.clear();
        Iterator r101 = ((LinkedHashMap) this.f138927j).values().iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        Iterator r102 = ((List) r101.next()).iterator();
    L10:
        if (r102.hasNext() == false) goto L7;
        ((m) r102.next()).release();
        goto L10
    L12:
        ((LinkedHashMap) this.f138927j).clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void k() {
        InteractivityPlatformContext r100 = j.a(this.f133406e);
        if (r100 == null) goto L12;
        com.bytedance.live.datacontext.j<t22.g> r101 = r100.getTopicTipManager();
        if (r101 == null) goto L13;
        t22.g r102 = r101.getValue();
        if (r102 == null) goto L14;
        r102.c(false);
        Disposable r103 = r102.f544224c;
        if (r103 == null) goto L15;
        r103.dispose();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void l() {
        Boolean r100 = (Boolean) c("extra_key_reshow_from_rotate");
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == true) goto L15;
        Disposable r102 = this.f138925h;
        if (r102 == null) goto L8;
        r102.dispose();
    L8:
        b6 r103 = u();
        if (r103 == null) goto L13;
        Long r104 = r103.h();
        if (r104 == null) goto L13;
        long r105 = r104.longValue();
    L14:
        int r106 = o.f133452a;
        o.c("highlight common comp show duration is " + r105);
        this.f138925h = RxUtilKt.h(Observable.timer(r105, TimeUnit.MILLISECONDS)).subscribe(new com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp.b(this));
    L13:
        PSHighlightCommonConfig.f133759b.getClass();
        r105 = ((PSHighlightCommonConfig) PSHighlightCommonConfig.f133758a.getValue()).a();
    L15:
        update(this.f138928k);
        s(true, PSHighlightCommonComp$onShow$1.INSTANCE);
        boolean r107 = Intrinsics.areEqual((Boolean) c("extra_key_reshow_from_rotate"), r101);
        String r108 = null;
        if (r107 == true) goto L49;
        Pair[] r109 = new Pair[1];
        b6 r110 = u();
        if (r110 == null) goto L21;
        Long r111 = r110.f();
    L22:
        r109[0] = TuplesKt.to("interaction_theme_id", String.valueOf(r111));
        Map r112 = MapsKt.mutableMapOf(r109);
        b6 r113 = u();
        if (r113 == null) goto L27;
        Map<String, String> r114 = r113.c();
        if (r114 == null) goto L27;
        String r115 = r114.get("interaction_theme_long_text");
    L28:
        if (r115 == null) goto L30;
        r112.put("interaction_theme_long_text", r115);
    L30:
        b6 r116 = u();
        if (r116 == null) goto L35;
        Map<String, String> r117 = r116.c();
        if (r117 == null) goto L35;
        String r118 = r117.get("interaction_theme_type");
    L36:
        if (r118 == null) goto L38;
        r112.put("interaction_theme_type", r118);
    L38:
        int r119 = o.f133452a;
        DataCenter r120 = this.f133406e;
        String r121 = getType().getBizScene();
        boolean r122 = z.e(this.f133406e, false);
        DataCenter r123 = this.f133406e;
        if (r123 == null) goto L43;
        Room r124 = z.o(r123);
        if (r124 == null) goto L43;
        Long r125 = Long.valueOf(r124.f162599id);
    L44:
        String r126 = String.valueOf(r125);
        Intrinsics.checkNotNullParameter(r121, "msgShowType");
        Intrinsics.checkNotNullParameter(r126, "roomId");
        Intrinsics.checkNotNullParameter(r112, "extra");
        LinkedHashMap r127 = new LinkedHashMap();
        r127.put("msg_show_type", r121);
        r127.put("live_type", o.b(r120));
        if (r122 == false) goto L47;
        String r128 = "1";
    L48:
        r127.put(IPerformanceManager.Params.is_anchor, r128);
        r127.put("room_id", r126);
        r127.put("live_sub_type", o.a(r120));
        r127.putAll(r112);
        j0.l().sendLog("livesdk_public_screen_emphasize_msg_show", r127, new Object[]{x.class, IRoom.class});
        goto L49
    L47:
        r128 = "0";
    L43:
        r125 = null;
    L35:
        r118 = null;
    L27:
        r115 = null;
        goto L28
    L21:
        r111 = null;
    L49:
        InteractivityPlatformContext r129 = j.a(this.f133406e);
        if (r129 == null) goto L79;
        com.bytedance.live.datacontext.j<t22.g> r130 = r129.getTopicTipManager();
        if (r130 == null) goto L79;
        t22.g r131 = r130.getValue();
        if (r131 == null) goto L79;
        RoomHighlightAreaContainerMessage r132 = this.f138928k;
        Intrinsics.checkNotNullParameter(r132, "message");
        if (r131.f544222a < r131.f544228g.getFrequency()) goto L58;
        ALogger.i(r131.f544227f, "超出展示次数，不展示底纹词");
        goto L79
    L58:
        b6 r133 = r132.getHighlightAreaContainer();
        if (r133 == null) goto L61;
        r108 = r133.a();
    L61:
        if (r108 == null) goto L74;
        int r134 = r108.hashCode();
        if (r134 == (-1105290417)) goto L72;
        if (r134 != 1917655083) goto L74;
        if (r108.equals("anchor_custom_topic") == false) goto L74;
        HintType r135 = HintType.ANCHOR_CUSTOM_TOPIC;
    L75:
        r131.f544226e = r135;
        r131.c(true);
        r131.f544222a++;
        Disposable r136 = r131.f544224c;
        if (r136 == null) goto L78;
        r136.dispose();
    L78:
        Observable<Long> r137 = Observable.timer(r131.f544228g.getDuration(), TimeUnit.SECONDS);
        int r138 = p.f267522a;
        r131.f544224c = r137.observeOn(AndroidSchedulers.mainThread()).subscribe(new t22.e(r131), new t22.f(r131));
        goto L79
    L72:
        if (r108.equals("comment_topic") == false) goto L74;
        r135 = HintType.COMMENT_TOPIC;
    L74:
        r135 = HintType.NORMAL;
    L79:
        Intrinsics.checkNotNullParameter("extra_key_reshow_from_rotate", "key");
        ((Map) this.f133402a.getValue()).remove("extra_key_reshow_from_rotate");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.ArrayList] */
    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void o() {
        TextView r100 = this.f138924g;
        if (r100 == null) goto L6;
        a r101 = new a(this);
        int r102 = PSHighlightRenderHelper.f133410a;
        Intrinsics.checkNotNullParameter(r101, "listener");
        r r103 = new r(r101);
        r100.setMovementMethod(new u());
        r100.setHighlightColor(0);
        r100.setOnClickListener(new q(r103));
    L6:
        if (Intrinsics.areEqual((Boolean) c("extra_key_reshow_from_rotate"), Boolean.TRUE) == true) goto L39;
        ((LinkedHashMap) this.f138927j).clear();
        b6 r104 = this.f138928k.getHighlightAreaContainer();
        if (r104 == null) goto L32;
        List<b6.b> r105 = r104.i();
        if (r105 == null) goto L32;
        Iterator r106 = r105.iterator();
    L14:
        if (r106.hasNext() == false) goto L32;
        b6.b r107 = (b6.b) r106.next();
        Map<b6.b, List<m>> r108 = this.f138927j;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k r109 = d();
        if (r109 == null) goto L28;
        m.c r110 = r109.getTriggerMapper();
        if (r110 == null) goto L28;
        DataCenter r111 = this.f133406e;
        if (r107 == null) goto L27;
        List<m.b> r112 = r110.f133451a;
        ?? r113 = new ArrayList();
        Iterator r114 = ((ArrayList) r112).iterator();
    L23:
        if (r114.hasNext() == false) goto L29;
        TopicDismissTrigger r115 = ((m.b) r114.next()).a(r111, r107);
        if (r115 == null) goto L23;
        r113.add(r115);
    L29:
        if (r113 != 0) goto L31;
        r113 = CollectionsKt.emptyList();
    L31:
        r108.put(r107, (List<m>) r113);
        goto L14
    L27:
        r113 = CollectionsKt.emptyList();
    L28:
        r113 = 0;
    L32:
        Map<b6.b, List<m>> r116 = this.f138927j;
        b6.b r117 = new b6.b();
        r117.c(2L);
        Unit r118 = Unit.INSTANCE;
        r116.put(r117, CollectionsKt.listOf(new ComponentShowTrigger(this.f133406e)));
        Iterator r119 = ((LinkedHashMap) this.f138927j).entrySet().iterator();
    L34:
        if (r119.hasNext() == false) goto L39;
        Map.Entry r120 = (Map.Entry) r119.next();
        b6.b r121 = (b6.b) r120.getKey();
        Iterator r122 = ((Iterable) r120.getValue()).iterator();
    L37:
        if (r122.hasNext() == false) goto L34;
        m r123 = (m) r122.next();
        r123.a(this);
        r123.b(r121);
    L39:
        DataCenter r124 = this.f133406e;
        if (r124 != null) goto L42;
        return;
    L42:
        if (z.e(r124, false) != true) goto L57;
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(this.f133406e).b(o42.b.class).subscribe(new c(this)), this.f138926i);
        return;
    }

    public final View t() {
        View r100 = this.f138923f;
        TextView r101 = null;
        if (r100 != null) goto L5;
        r100 = View.inflate(this.f138930m, R.layout.ttlive_ps_highlight_common_comp_view, null);
        this.f138923f = r100;
    L5:
        View r102 = this.f138923f;
        if (r102 == null) goto L8;
        r101 = (TextView) r102.findViewById(R.id.tvDisplay);
    L8:
        this.f138924g = r101;
        PSHighlightRenderHelper.b(this.f133406e, r101);
        return r100;
    }

    public final b6 u() {
        return this.f138928k.getHighlightAreaContainer();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.g
    public /* bridge */ /* synthetic */ n getType() {
        return getType();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.g
    public final View getView() {
        return t();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void i() {
        t();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.g
    public PSHighlightType getType() {
        return this.f138929l;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m.a
    public final void a(TriggerKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r101 = com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp.a.f138933a[r100.ordinal()];
        if (r101 == 1) goto L8;
        if (r101 == 2) goto L8;
        return;
    L8:
        if (g() == false) goto L10;
        return;
    L10:
        s(false, new PSHighlightCommonComp$onTrigger$1(this));
    }

    public final void update(RoomHighlightAreaContainerMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "areaContainerMessage");
        int r101 = PSHighlightRenderHelper.f133410a;
        TextView r102 = this.f138924g;
        if (r102 == null) goto L5;
        int r103 = PSHighlightRenderHelper.f133411b;
        int r104 = PSHighlightRenderHelper.f133412c;
        r102.setPadding(r103, r104, PSHighlightRenderHelper.f133413d, r104);
    L5:
        this.f138928k = r100;
        b6 r105 = u();
        if (r105 == null) goto L11;
        a5 r106 = r105.b();
        if (r106 == null) goto L12;
        int r107 = mb2.d.f512776a;
        Intrinsics.checkNotNullParameter(r106, "text");
        ek6.e r108 = mb2.d.a(r106, null, 1.0f);
        LiveRichContentEngine.a().a().c(r108, (com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) PSHighlightRenderHelper.f133414e.getValue(), new b(this));
        return;
    L12:
        return;
    }

    public static final boolean r(PSHighlightCommonComp r100, RoomHighlightAreaContainerMessage r101) {
        r100.getClass();
        if (cl0.f119962a.getValue().booleanValue() == false) goto L13;
        PublicAreaCommon r102 = r101.getPublicAreaCommon();
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.getHasTailButton() != true) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    }

    public final void s(boolean r100, final Function0<Unit> r101) {
        Function0<Unit> r102 = new PSHighlightCommonComp$doAnim$internalEnd$1(r101);
        PSHighlightRenderHelper.c(this.f138923f, r100, PSHighlightRenderHelper.AnimType.VerticalFadeSlide, r102).c();
    }

    public final void v(String r110, String r111) {
        Pair[] r100 = new Pair[1];
        b6 r101 = u();
        Long r102 = null;
        if (r101 == null) goto L5;
        Long r103 = r101.f();
    L6:
        r100[0] = TuplesKt.to("interaction_theme_id", String.valueOf(r103));
        Map r104 = MapsKt.mutableMapOf(r100);
        b6 r105 = u();
        if (r105 == null) goto L11;
        Map<String, String> r106 = r105.c();
        if (r106 == null) goto L11;
        String r107 = r106.get("interaction_theme_long_text");
    L12:
        if (r107 == null) goto L14;
        r104.put("interaction_theme_long_text", r107);
    L14:
        b6 r108 = u();
        if (r108 == null) goto L19;
        Map<String, String> r109 = r108.c();
        if (r109 == null) goto L19;
        String r112 = r109.get("interaction_theme_type");
    L20:
        if (r112 == null) goto L22;
        r104.put("interaction_theme_type", r112);
    L22:
        r104.put("live_type", o.b(this.f133406e));
        r104.put("live_sub_type", o.a(this.f133406e));
        if (r111 == null) goto L25;
        r104.put("btn_text", r111);
    L25:
        DataCenter r113 = this.f133406e;
        String r114 = getType().getBizScene();
        boolean r115 = z.e(this.f133406e, false);
        DataCenter r116 = this.f133406e;
        if (r116 == null) goto L30;
        Room r117 = z.o(r116);
        if (r117 == null) goto L30;
        r102 = Long.valueOf(r117.f162599id);
    L30:
        String r118 = String.valueOf(r102);
        Intrinsics.checkNotNullParameter(r114, "msgShowType");
        Intrinsics.checkNotNullParameter(r110, "clickArea");
        Intrinsics.checkNotNullParameter(r118, "roomId");
        Intrinsics.checkNotNullParameter(r104, "extra");
        LinkedHashMap r119 = new LinkedHashMap();
        r119.put("msg_show_type", r114);
        r119.put("live_type", o.b(r113));
        r119.put("live_sub_type", o.a(r113));
        if (r115 == false) goto L33;
        String r120 = "1";
    L34:
        r119.put(IPerformanceManager.Params.is_anchor, r120);
        r119.put("room_id", r118);
        r119.put(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r110);
        r119.putAll(r104);
        j0.l().sendLog("livesdk_public_screen_emphasize_msg_click", r119, new Object[]{x.class, IRoom.class});
        return;
    L33:
        r120 = "0";
    L19:
        r112 = null;
    L11:
        r107 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public PSHighlightCommonComp(RoomHighlightAreaContainerMessage r100, PSHighlightType r101, Context r102, DataCenter r103) {
        Intrinsics.checkNotNullParameter(r100, "containerMessage");
        Intrinsics.checkNotNullParameter(r101, "type");
        b6 r104 = r100.getHighlightAreaContainer();
        if (r104 == null) goto L5;
        Long r105 = r104.f();
    L6:
        super(String.valueOf(r105), r101, r103);
        this.f138928k = r100;
        this.f138929l = r101;
        this.f138930m = r102;
        this.f138926i = new CompositeDisposable();
        this.f138927j = new LinkedHashMap();
        return;
    L5:
        r105 = null;
        goto L6
    }
}
