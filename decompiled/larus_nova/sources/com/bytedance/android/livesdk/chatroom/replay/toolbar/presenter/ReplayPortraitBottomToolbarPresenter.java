package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layout.ViewPools;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.IToolbarManagerHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.metrics.ReplayUILatch;
import com.bytedance.android.livesdk.chatroom.vs_base.metrics.ReplayUIMetrics;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSToolbarConfigData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mq1.e0;
import mq1.t;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\nR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/presenter/ReplayPortraitBottomToolbarPresenter;", "Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/presenter/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroidx/fragment/app/FragmentActivity;", "q", "Landroidx/fragment/app/FragmentActivity;", "getContext", "()Landroidx/fragment/app/FragmentActivity;", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ReplayPortraitBottomToolbarPresenter extends com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a implements Observer<KVData> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f110131r = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<ToolbarButton> f110132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<View> f110133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f110134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f110135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f110136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f110137n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f110138o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f110139p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FragmentActivity f110140q;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayPortraitBottomToolbarPresenter f110141a;

        public b(ReplayPortraitBottomToolbarPresenter r100) {
            this.f110141a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            ALogger.d("VS_TOOLBAR", "buttonApplyCountForMetrics count change to " + r101);
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.intValue() != 0) goto L9;
            ReplayPortraitBottomToolbarPresenter r102 = this.f110141a;
            int r103 = ReplayPortraitBottomToolbarPresenter.f110131r;
            r102.getClass();
            ReplayUILatch.MAIN_UI.countDown(new cr1.a(ReplayUIMetrics.TOOLBAR, System.currentTimeMillis()), this.f110141a.f110154h);
            this.f110141a.l("applyDynamicButtons");
            return;
        }
    }

    public static final class c implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayPortraitBottomToolbarPresenter f110142a;

        @Override // mq1.e0
        public final void qj() {
        }

        public c(ReplayPortraitBottomToolbarPresenter r100) {
            this.f110142a = r100;
        }

        @Override // mq1.e0
        public final void FY(tq1.g r100) {
            Episode r101 = r100.f547123a;
            ReplayPortraitBottomToolbarPresenter r102 = this.f110142a;
            int r103 = ReplayPortraitBottomToolbarPresenter.f110131r;
            r102.k(r101);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a
    public final void d(ToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a
    public final boolean f() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a
    public final void g() {
        this.f110148b.clear();
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L6;
        y3.j();
        return;
    }

    public void m() {
        Iterator r100 = ((ArrayList) this.f110132i).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        ToolbarButton r101 = (ToolbarButton) r100.next();
        ExtendedToolbarButton.f115618h.getClass();
        ExtendedToolbarButton.b r102 = ExtendedToolbarButton.a.a(r101);
        View r103 = (View) ((HashMap) c()).get(r102);
        if (r103 == null) goto L4;
        ((ViewGroup) this.f110134k.getValue()).removeView(r103);
        b().C(r102, r103);
        goto L4
    }

    public void n() {
        if (this.f110154h != null) goto L6;
        return;
    L6:
        if (((ArrayList) this.f110132i).size() > 4) goto L8;
        this.f110154h.put("data_replay_toolbar_cast_screen_folded", Boolean.FALSE);
        return;
    L8:
        if (r.d().isSaas() == false) goto L10;
        ToolbarButton r100 = ToolbarButton.REPLAY_CAST_SCREEN;
    L11:
        ((ArrayList) this.f110132i).remove(r100);
        b().i(r100.extended());
        this.f110154h.put("data_replay_toolbar_cast_screen_folded", Boolean.TRUE);
        return;
    L10:
        r100 = ToolbarButton.VS_CAST_SCREEN;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a
    public void i() {
        super.i();
        DataCenter r100 = this.f110154h;
        if (r100 == null) goto L5;
        vlc.d r101 = (vlc.d) r100.get("data_message_manager", null);
    L5:
        this.f110148b.clear();
        DataCenter r102 = this.f110154h;
        if (r102 == null) goto L8;
        r102.removeObserver(this);
    L8:
        m();
        ((ArrayList) this.f110132i).clear();
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L11;
        y3.k(this.f110154h);
    L11:
        y3.g(this.f110154h);
        t r103 = s.e();
        if (r103 == null) goto L17;
        mq1.p r104 = r103.a(this.f110154h);
        if (r104 == null) goto L18;
        r104.unregisterReplaySwitchListener(this.f110138o);
        return;
    L18:
        return;
    }

    public final FragmentActivity getContext() {
        return this.f110140q;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a
    public void h(Object[] r110) {
        if (this.f110154h != null) goto L5;
        return;
    L5:
        super.h(r110);
        t r111 = s.e();
        if (r111 == null) goto L10;
        mq1.p r112 = r111.a(this.f110154h);
        if (r112 == null) goto L10;
        r112.registerReplaySwitchListener(this.f110138o, true);
    L10:
        Iterator r113 = CollectionsKt.listOf(new String[]{"data_screen_record_is_open", "data_keyboard_status", "cmd_hide_other_toolbar", "data_broadcast_pause_state", "cmd_toolbar_visibility_controller", "cmd_hide_in_douyin_commerce"}).iterator();
    L12:
        if (r113.hasNext() == false) goto L14;
        this.f110154h.observe((String) r113.next(), this);
        goto L12
    L14:
        this.f110152f.observe(this.f110153g, new b(this));
        c0 r114 = y3.m(this.f110154h);
        DataCenter r100 = this.f110154h;
        Episode r101 = null;
        if (r100 == null) goto L19;
        IToolbarManagerHelper r102 = (IToolbarManagerHelper) jc1.k.f(IToolbarManagerHelper.class);
        if (r102 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.utils.c0 r103 = r102.toolbarHelper(r100);
    L20:
        r114.m(r103);
        y3.f(this.f110154h).m(null);
        b().E(this.f110154h);
        g3 r115 = y3.f(this.f110154h);
        if (r115 == null) goto L69;
        r115.E(this.f110154h);
        List<ToolbarButton> r104 = com.bytedance.android.livesdk.chatroom.replay.toolbar.d.d(this.f110154h, this.f110140q);
        ((ArrayList) this.f110132i).clear();
        ((ArrayList) this.f110132i).addAll(r104);
        Episode r105 = (Episode) this.f110154h.get("data_vs_episode_data", null);
        if (r105 == null) goto L25;
        o(r105);
    L25:
        ALogger.i("ReplayToolbarWidget", "start configToolbarViews,size:" + ((ArrayList) this.f110132i).size());
        LayoutInflater r106 = LayoutInflater.from(this.f110140q);
        int r107 = ((ArrayList) this.f110132i).size();
        int r108 = 0;
    L26:
        if (r108 >= r107) goto L54;
        ToolbarButton r109 = (ToolbarButton) ListProtector.get(this.f110132i, r108);
        ExtendedToolbarButton.f115618h.getClass();
        ExtendedToolbarButton.b r116 = ExtendedToolbarButton.a.a(r109);
        ViewGroup r117 = (ViewGroup) this.f110134k.getValue();
        Intrinsics.checkNotNullParameter(r106, "layoutInflater");
        Intrinsics.checkNotNullParameter(r109, "config");
        View r118 = (View) ((EnumMap) this.f110149c).get(r109);
        if (r118 != null) goto L36;
        FragmentActivity r119 = this.f110140q;
        if ((r119 instanceof AppCompatActivity) == false) goto L32;
        View r120 = ViewPools.a((AppCompatActivity) r119).b(r109.getLayoutId(), r117, false);
    L33:
        r118 = r120;
        if (r109.getLayoutId() != R.layout.ttlive_view_toolbar_common) goto L36;
        ((EnumMap) this.f110149c).put(r109, r118);
        goto L36
    L32:
        r120 = LayoutInflater.from(r119).inflate(r109.getLayoutId(), r117, false);
    L36:
        if (r118 != null) goto L39;
    L47:
        ((HashMap) c()).put(r116, r118);
        Intrinsics.checkNotNull(r118);
        ViewParent r121 = r118.getParent();
        if ((r121 instanceof ViewGroup) == false) goto L50;
        ((ViewGroup) r121).removeView(r118);
    L50:
        ViewGroup r122 = j(r109);
        if (r122 == null) goto L53;
        r122.addView(r118);
    L53:
        Intrinsics.checkNotNullParameter(r109, "button");
        b().D(r116, r118);
        r108 = r108 + 1;
        goto L26
    L39:
        if (r109.getLayoutId() != R.layout.ttlive_view_toolbar_common) goto L43;
        View r123 = r118.findViewById(R.id.icon);
        if (r123 == null) goto L43;
        r123.setBackgroundResource(r109.getDrawableUnfolded());
    L43:
        com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a.e(r109, r118, true);
        r118.setTag(r109);
        r118.setVisibility(8);
        a(r109, r118);
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r124 = ReplayRoomFragmentScopeUtil.f117917a;
        ((com.bytedance.android.livesdk.chatroom.replay.ui.e0) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.e0.class)).getClass();
        Intrinsics.checkNotNullParameter(r109, "config");
        Intrinsics.checkNotNullParameter(r118, "view");
        int r125 = (int) UtilityKotlinExtentionsKt.b(6.0f);
        if (r.j().c() == false) goto L46;
        com.bytedance.android.livesdk.chatroom.vs_base.util.k.b(r118, UtilityKotlinExtentionsKt.c(36));
        r118.setScaleX(0.8f);
        r118.setScaleY(0.8f);
        r125 = (int) (r125 * 0.5f);
    L46:
        UIUtils.updateLayoutMargin(r118, r125, -3, 0, -3);
        r3.i(r118, r109);
        goto L47
    L54:
        this.f110137n = System.currentTimeMillis();
        Integer r126 = this.f110152f.getValue();
        if (r126 != null) goto L58;
    L60:
        Disposable r127 = Observable.timer(400, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(this));
        if (r127 == null) goto L63;
        RxUtilKt.c(r127, this.f110148b);
    L63:
        fq1.a r128 = fq1.b.a();
        if (r128 == null) goto L66;
        r101 = r128.f478400a;
    L66:
        k(r101);
        Disposable r129 = b().f116835i.subscribe(new k(this), l.f110167a);
        Disposable r130 = r115.f116835i.subscribe(new m(r115), n.f110169a);
        this.f110148b.add(r129);
        this.f110148b.add(r130);
        ALogger.i("ReplayToolbarWidget", "load.");
        return;
    L58:
        if (r126.intValue() != 0) goto L60;
        l("configToolbarViews");
        goto L63
    L69:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    L19:
        r103 = null;
        goto L20
    }

    public ViewGroup j(ToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return (ViewGroup) this.f110134k.getValue();
    }

    public final void k(Episode r100) {
        if (r100 == null) goto L4;
        IMainEpisode r101 = (IMainEpisode) r100.castToOrNull(IMainEpisode.class);
    L5:
        if (r101 != null) goto L7;
    L13:
        b().i(ToolbarButton.REPLAY_TICKET_SALE.extended());
        return;
    L7:
        if (r101.isPaidReplay() != true) goto L13;
        ReplayPaidInfo r102 = r101.getReplayPaidInfo();
        if (r102 == null) goto L13;
        if (r102.hasViewRight() == true) goto L13;
        b().c(ToolbarButton.REPLAY_TICKET_SALE.extended());
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterSource");
        if (this.f110136m == true) goto L10;
        this.f110136m = true;
        DataCenter r101 = this.f110154h;
        if (r101 == null) goto L7;
        r101.put("cmd_vs_video_portrait_toolbar_apply_count_zero", Boolean.TRUE);
    L7:
        View r102 = this.f110139p;
        if (r102 == null) goto L10;
        Handler r103 = UtilityKotlinExtentionsKt.f118187a;
        Intrinsics.checkNotNullParameter(r102, "$this$fadeIn");
        UtilityKotlinExtentionsKt.j(r102);
        r102.animate().alpha(1.0f).setDuration(200).start();
    L10:
        ALogger.i("ReplayToolbarWidget", "do onApplyButtonCountForMetricsZero in [" + r100 + "], cost:" + (System.currentTimeMillis() - this.f110137n));
    }

    public final void o(Episode r100) {
        if (this.f110154h != null) goto L6;
        return;
    L6:
        if (((ArrayList) this.f110132i).isEmpty() == false) goto L8;
        return;
    L8:
        List<ToolbarButton> r101 = this.f110132i;
        ArrayList r102 = (ArrayList) r101;
        boolean r103 = r102.contains(ToolbarButton.VS_SHARE);
        List<VSToolbarConfigData> r104 = r100.toolbarList;
        boolean r105 = false;
        if (r104 == null) goto L23;
        Iterator<T> r106 = r104.iterator();
    L12:
        if (r106.hasNext() == false) goto L19;
        Object r107 = r106.next();
        if (((VSToolbarConfigData) r107).getToolbarType() != 9) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == false) goto L12;
    L20:
        VSToolbarConfigData r109 = (VSToolbarConfigData) r107;
        if (r109 == null) goto L23;
        List<? extends VSToolbarConfigData> r110 = hm1.a.f485714a;
        r105 = hm1.a.a(r109.getDisplayType());
        goto L23
    L16:
        r108 = false;
        goto L17
    L19:
        r107 = null;
    L23:
        if (r103 == r105) goto L27;
        if (r105 == false) goto L26;
        List<ToolbarButton> r111 = com.bytedance.android.livesdk.chatroom.replay.toolbar.d.d(this.f110154h, this.f110140q);
        ((ArrayList) this.f110132i).clear();
        ((ArrayList) this.f110132i).addAll(r111);
        b().c(ToolbarButton.VS_SHARE.extended());
        goto L27
    L26:
        List<ToolbarButton> r112 = this.f110132i;
        ToolbarButton r113 = ToolbarButton.VS_SHARE;
        ((ArrayList) r112).remove(r113);
        b().i(r113.extended());
    L27:
        n();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getKey() != null) goto L7;
        return;
    L7:
        if (r101.getData() == null) goto L110;
        String r102 = r101.getKey();
        int r103 = 4;
        switch(r102.hashCode()) {
            case -2061887717: goto L72;
            case -1755796428: goto L43;
            case -968289056: goto L31;
            case 1060055221: goto L21;
            case 1939188655: goto L13;
            default: goto L111;
        };
    L111:
        return;
    L13:
        if (r102.equals("data_screen_record_is_open") == false) goto L93;
        Object r104 = r101.getData();
        Intrinsics.checkNotNull(r104);
        if (((Boolean) r104).booleanValue() == true) goto L17;
        r103 = 0;
    L17:
        View r105 = this.f110139p;
        if (r105 == null) goto L94;
        r105.setVisibility(r103);
        return;
    L94:
        return;
    L93:
        return;
    L21:
        if (r102.equals("data_keyboard_status") == false) goto L96;
        Object r106 = r101.getData();
        Intrinsics.checkNotNull(r106);
        if (((Boolean) r106).booleanValue() == false) goto L27;
        View r107 = this.f110139p;
        if (r107 == null) goto L97;
        r107.setVisibility(4);
        return;
    L97:
        return;
    L27:
        View r108 = this.f110139p;
        if (r108 == null) goto L99;
        r108.setVisibility(0);
        return;
    L99:
        return;
    L96:
        return;
    L31:
        if (r102.equals("cmd_toolbar_visibility_controller") == false) goto L101;
        Pair r109 = (Pair) r101.getData();
        if (r109 == null) goto L102;
        ExtendedToolbarButton r110 = (ExtendedToolbarButton) r109.getFirst();
        if (r110 == ToolbarButton.GAME_GUESS.extended()) goto L112;
        int r111 = ((Number) r109.getSecond()).intValue();
        View r112 = (View) ((HashMap) c()).get(r110);
        if (r112 == null) goto L103;
        if (r111 != 0) goto L41;
        UIUtils.setViewVisibility(r112, 8);
        ((ArrayList) this.f110133j).add(r112);
        return;
    L41:
        ((ArrayList) this.f110133j).remove(r112);
        return;
    L103:
        return;
    L112:
        return;
    L102:
        return;
    L101:
        return;
    L43:
        if (r102.equals("cmd_hide_other_toolbar") == false) goto L106;
        Object r113 = r101.getData(Boolean.FALSE);
        Intrinsics.checkNotNull(r113);
        boolean r114 = ((Boolean) r113).booleanValue();
        List<ToolbarButton> r115 = this.f110132i;
        if (r114 == false) goto L64;
        if (this.f110135l == true) goto L113;
        this.f110135l = true;
        ((ArrayList) this.f110133j).clear();
        Iterator r116 = ((ArrayList) r115).iterator();
    L51:
        if (r116.hasNext() == false) goto L115;
        ToolbarButton r117 = (ToolbarButton) r116.next();
        Map<ExtendedToolbarButton, View> r118 = c();
        ExtendedToolbarButton.f115618h.getClass();
        HashMap r119 = (HashMap) r118;
        View r120 = (View) r119.get(ExtendedToolbarButton.a.a(r117));
        if (r120 == null) goto L51;
        if (r117 == ToolbarButton.GAME_EXIT) goto L51;
        if (r117 == ToolbarButton.MORE) goto L51;
        if (r117 == ToolbarButton.GAME_GUESS) goto L51;
        if (r120.getVisibility() != 0) goto L51;
        r120.setVisibility(8);
        ((ArrayList) this.f110133j).add(r120);
        goto L51
    L115:
        return;
    L113:
        return;
    L64:
        if (this.f110135l == false) goto L114;
        this.f110135l = false;
        Iterator r121 = ((ArrayList) this.f110133j).iterator();
    L68:
        if (r121.hasNext() == false) goto L70;
        ((View) r121.next()).setVisibility(0);
        goto L68
    L70:
        ((ArrayList) this.f110133j).clear();
        return;
    L114:
        return;
    L106:
        return;
    L72:
        if (r102.equals("data_vs_episode_data") == false) goto L108;
        Episode r122 = (Episode) r101.getData();
        if (r122 == null) goto L109;
        o(r122);
        return;
    L109:
        return;
    L108:
        return;
    }

    public ReplayPortraitBottomToolbarPresenter(View r100, FragmentActivity r101, LifecycleOwner r102, DataCenter r103) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "owner");
        super(r102, r103);
        this.f110139p = r100;
        this.f110140q = r101;
        this.f110132i = new ArrayList();
        this.f110133j = new ArrayList();
        this.f110134k = LazyKt.lazy(new ReplayPortraitBottomToolbarPresenter$mToolbarContainer$2(this));
        this.f110138o = new c(this);
    }
}
