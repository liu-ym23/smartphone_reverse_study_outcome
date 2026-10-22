package com.bytedance.android.livesdk.chatroom.end.vs;

import aj1.f;
import am2.x;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.vs.model.VSRoom;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fq1.p;
import fq1.t;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vr1.j;
import vr1.u;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/end/vs/AudienceEndFragmentForVs;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lim1/a;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$PublishStatusListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceEndFragmentForVs extends BaseFragment implements im1.a, ILiveRecordService.PublishStatusListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IRoom f106171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f106172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DataCenter f106173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Boolean> f106174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bundle f106175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclableWidgetManager f106176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f106177j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.end.vs.a f106178k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceEndFragmentForVs f106179a;

        public b(AudienceEndFragmentForVs r100) {
            this.f106179a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f106179a.getClass();
            r.f().w();
        }
    }

    static {
    }

    @Override // im1.a
    public final void a9() {
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, tw2.b
    public final String getSpm() {
        return "";
    }

    @Override // im1.a
    public final void onHideFragment() {
    }

    @Override // im1.a
    public final Fragment self() {
        return this;
    }

    @Override // im1.a
    public final void z3(boolean r100) {
    }

    @Override // im1.a
    public final boolean onBackPressed() {
        Function0<Boolean> r100 = this.f106174g;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.invoke().booleanValue() != true) goto L7;
        return true;
    }

    @Override // im1.a
    public final boolean ca() {
        return isVisible();
    }

    public AudienceEndFragmentForVs() {
    }

    @Override // im1.a
    public final View W5() {
        return this.f106177j;
    }

    @Override // im1.a
    public final IRoom getCurRoom() {
        return this.f106171d;
    }

    public static View S90(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (FoldScreenUtils.f() == false) goto L10;
        Resources r101 = getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.end.vs.a r103 = this.f106178k;
        if (r103 == null) goto L12;
        int r104 = r102.widthPixels;
        int r105 = r102.heightPixels;
        r103.f106189e.updateScreenMetrics(r104, r105);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L5;
    L10:
        super.onCreate(r100);
        if (this.f106171d != null) goto L14;
        ALogger.i("AudienceEndFragmentForVs", "room is null!!!");
        return;
    L14:
        r.f().d(this, new AnonymousClass1(this));
        r.f().i(this, new AnonymousClass2(this));
        j0.l().sendLog("livesdk_client_finish_show", null, new Object[]{IRoom.class, new x()});
        FoldScreenUtils.a();
        return;
    L5:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L10;
        FragmentActivity r101 = getActivity();
        Intrinsics.checkNotNull(r101);
        Window r102 = r101.getWindow();
        com.bytedance.android.live.core.utils.statusbar.a.C1098a r103 = com.bytedance.android.live.core.utils.statusbar.a.f66401b;
        r103.a();
        r102.addFlags(Integer.MIN_VALUE);
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L9;
        View r104 = S90(r102);
        r103.a();
        r104.setSystemUiVisibility(1024);
        r102.setStatusBarColor(0);
        goto L10
    L9:
        View r105 = S90(r102);
        int r106 = S90(r102).getSystemUiVisibility();
        r103.a();
        r105.setSystemUiVisibility(r106 & (-1025));
        r102.setStatusBarColor(-16777216);
        goto L10
    }

    @Override // im1.a
    public final void setDataCenter(DataCenter r100) {
        this.f106173f = r100;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        DataCenter r101 = this.f106173f;
        if (r101 == null) goto L6;
        r101.put("cmd_live_end_fragment_visible", Boolean.valueOf(r100));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRecordService.PublishStatusListener
    public final void onChange(ILiveRecordService.PublishStatus r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "status");
        if (r100 == ILiveRecordService.PublishStatus.PUBLISH_FINISH) goto L5;
        return;
    L5:
        if (this.f106172e == true) goto L9;
        f2.b(R.string.ttlive_live_record_publish_success, 0);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        RecyclableWidgetManager r112 = RecyclableWidgetManager.ga0(this, getView());
        this.f106176i = r112;
        r112.setDataCenter(this.f106173f);
        u r113 = r.u(this.f106173f, null, 2);
        if (r113 == null) goto L12;
        Room r114 = r113.j0();
        if (r114 == null) goto L12;
        VSRoom r115 = (VSRoom) r114.castToOrNull(VSRoom.class);
        if (r115 == null) goto L12;
        EpisodeExtraInfo r116 = r115.getEpisodeExtra();
        if (r116 == null) goto L12;
        String r117 = r116.getFinishUrl();
        if (r117 == null) goto L12;
    L14:
        if (r117.length() != 0) goto L16;
        boolean r100 = true;
    L17:
        if (r100 == false) goto L27;
        IRoom r118 = this.f106171d;
        if (r118 == null) goto L26;
        VSRoom r119 = (VSRoom) r118.castToOrNull(VSRoom.class);
        if (r119 == null) goto L26;
        EpisodeExtraInfo r120 = r119.getEpisodeExtra();
        if (r120 == null) goto L26;
        r117 = r120.getFinishUrl();
        if (r117 != null) goto L27;
    L26:
        r117 = "";
    L27:
        ALogger.i("AudienceEndFragmentForVs", "url-".concat(r117));
        if (r117.length() <= 0) goto L30;
        boolean r101 = true;
    L31:
        if (r101 == false) goto L141;
        j r102 = r.i();
        Uri r121 = UriProtector.parse(r117);
        DataCenter r103 = this.f106173f;
        Intrinsics.checkNotNull(r103);
        String r122 = String.valueOf(r102.E(r121, r103));
        IMiddlewareHostBusiness r104 = (IMiddlewareHostBusiness) k.f(IMiddlewareHostBusiness.class);
        if (r104 == null) goto L39;
        Uri.Builder r123 = UriProtector.parse(r122).buildUpon();
        if (r104.isEnablePersonalRecommend() == false) goto L37;
        r123.appendQueryParameter("is_enable_personal_recommend", "1");
    L38:
        r122 = r123.build().toString();
        goto L39
    L37:
        r123.appendQueryParameter("is_enable_personal_recommend", "0");
    L39:
        IRoom r105 = this.f106171d;
        if (r105 == null) goto L130;
        Uri r124 = UriProtector.parse(r122);
        Set<String> r106 = UriProtector.getQueryParameterNames(r124);
        Uri.Builder r125 = r124.buildUpon();
        Iterator<Map.Entry<String, String>> r107 = r.l().k(r105).entrySet().iterator();
    L43:
        if (r107.hasNext() == false) goto L49;
        Map.Entry<String, String> r108 = r107.next();
        String r126 = r108.getKey();
        String r127 = r108.getValue();
        if (r106.contains(r126) == true) goto L43;
        if (TextUtils.isEmpty(r108.getValue()) == true) goto L43;
        r125.appendQueryParameter(r126, r127);
        goto L43
    L49:
        Map<String, String> r109 = j0.l().c(x.class).getMap();
        if (r109 == null) goto L59;
        Iterator<Map.Entry<String, String>> r128 = r109.entrySet().iterator();
    L53:
        if (r128.hasNext() == false) goto L59;
        Map.Entry<String, String> r129 = r128.next();
        if (r106.contains(r129.getKey()) == true) goto L53;
        if (TextUtils.isEmpty(r129.getValue()) == true) goto L53;
        r125.appendQueryParameter(r129.getKey(), r129.getValue());
    L59:
        Map<String, String> r130 = j0.l().c(IRoom.class).getMap();
        if (r130 != null) goto L62;
    L74:
        String r131 = r105.getAnchorId();
        if (r106.contains("anchor_id") == false) goto L77;
    L79:
        IBaseUser r132 = r105.getOwner();
        if (r132 == null) goto L83;
        Intrinsics.checkNotNullParameter(r132, "$this$secUidExt");
        String r133 = r132.getCastSecUid();
        if (r133 == null) goto L83;
    L85:
        if (r106.contains("sec_anchor_id") == false) goto L87;
    L89:
        String r134 = t.a().getCurrentUserId();
        if (r106.contains("user_id") == false) goto L92;
    L94:
        u r135 = r.u(this.f106173f, null, 2);
        if (r135 == null) goto L122;
        Room r136 = r135.j0();
        if (r136 == null) goto L122;
        VSRoom r137 = (VSRoom) r136.castToOrNull(VSRoom.class);
        if (r137 == null) goto L122;
        EpisodeExtraInfo r138 = r137.getEpisodeExtra();
        if (r138 == null) goto L122;
        IBaseEpisodeMod r139 = r138.getMod();
        if (r139 != null) goto L105;
    L106:
        IBaseEpisodeMod r140 = r138.getEpisodeMod();
        if (r140 != null) goto L109;
    L111:
        boolean r141 = false;
    L112:
        if (r141 == false) goto L120;
        IEpisodeExtraInfo r142 = r105.getEpisodeExtra();
        if (r142 == null) goto L117;
        String r143 = String.valueOf(r142.getId());
        if (r143 == null) goto L117;
    L118:
        r125.appendQueryParameter("target_episode_id", r143);
    L117:
        r143 = "";
    L120:
        if (r138.getSeasonCoverVertical() == null) goto L122;
        r125.appendQueryParameter("season_cover_vertical", GsonProtectorUtils.toJson(GsonHelper.get(), r138.getSeasonCoverVertical()));
        goto L122
    L109:
        if (r140.getEpisodeStage() != EpisodeMod.EpisodeStageType.PREMIERE) goto L111;
    L110:
        r141 = true;
        goto L112
    L105:
        if (r139.getEpisodeStage() == EpisodeMod.EpisodeStageType.PREMIERE) goto L110;
    L122:
        r125.appendQueryParameter("enable_latch", "1").build();
        DataCenter r144 = this.f106173f;
        if (r144 == null) goto L125;
        String r145 = (String) r144.get("comment_id", "");
    L127:
        if (TextUtils.isEmpty(r145) == true) goto L129;
        r125.appendQueryParameter("insert_comment_id", r145);
    L129:
        r122 = r125.build().toString();
        goto L130
    L125:
        r145 = null;
        goto L127
    L92:
        if (TextUtils.isEmpty(r134) == true) goto L94;
        r125.appendQueryParameter("user_id", r134);
        goto L94
    L87:
        if (TextUtils.isEmpty(r133) == true) goto L89;
        r125.appendQueryParameter("sec_anchor_id", r133);
    L83:
        r133 = "";
        goto L85
    L77:
        if (TextUtils.isEmpty(r131) == true) goto L79;
        r125.appendQueryParameter("anchor_id", String.valueOf(r131));
        goto L79
    L62:
        if (r130.containsKey("room_id") == true) goto L64;
    L66:
        Iterator<Map.Entry<String, String>> r146 = r130.entrySet().iterator();
    L68:
        if (r146.hasNext() == false) goto L74;
        Map.Entry<String, String> r147 = r146.next();
        if (r106.contains(r147.getKey()) == true) goto L68;
        if (TextUtils.isEmpty(r147.getValue()) == true) goto L68;
        r125.appendQueryParameter(r147.getKey(), r147.getValue());
        goto L68
    L64:
        if (StringUtils.equal(r130.get("room_id"), String.valueOf(r105.getId())) == true) goto L66;
    L130:
        RecyclableWidgetManager r148 = this.f106176i;
        if (r148 == null) goto L133;
        EndContainerWidgetForVs r149 = (EndContainerWidgetForVs) r148.Y90(R.id.vs_end_hybrid_container, EndContainerWidgetForVs.class, false, new Serializable[]{r122, this.f106171d});
    L135:
        if (r149 == null) goto L140;
        com.bytedance.android.livesdk.chatroom.end.vs.a r150 = new com.bytedance.android.livesdk.chatroom.end.vs.a(r149);
        this.f106178k = r150;
        r150.f106186b = this.f106175h;
        r150.f106185a = this.f106173f;
        r150.f106187c = getContext();
        com.bytedance.android.livesdk.chatroom.end.vs.a r151 = this.f106178k;
        if (r151 == null) goto L153;
        r151.f106188d = new C100041(this);
    L153:
        View r152 = r110.findViewById(R.id.variety_end_close);
        this.f106177j = r152;
        if (r152 == null) goto L156;
        r152.setOnClickListener(new b(this));
    L156:
        UIUtils.getScreenWidth(getContext());
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L159;
    L163:
        IRoom r153 = this.f106171d;
        if (r153 == null) goto L168;
        IBaseUser r154 = r153.getOwner();
        if (r154 == null) goto L168;
        py.k r155 = r154.getAvatarLarge();
    L169:
        ImageLoader.bindImage(null, r155, new l3(5, 1.0f, null));
        ((ILiveDouPlusService) k.n(ILiveDouPlusService.class)).onLiveEnd();
        return;
    L168:
        r155 = null;
        goto L169
    L159:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L163;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L163;
        UIUtils.updateLayoutMargin(null, -3, -StatusBarUtil.getStatusBarHeight(getContext()), -3, -3);
        goto L163
    L140:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.end.vs.hybrid.WidgetHybridContainer");
    L133:
        r149 = null;
        goto L135
    L141:
        int r156 = VSEndTraceHelper.f106183a;
        VSEndTraceHelper.EventType r157 = VSEndTraceHelper.EventType.FINISH_URL_EMPTY;
        IRoom r158 = this.f106171d;
        if (r158 == null) goto L144;
        long r159 = r158.getId();
    L145:
        long r160 = r159;
        IRoom r161 = this.f106171d;
        if (r161 == null) goto L151;
        String r162 = r161.getAnchorId();
        if (r162 == null) goto L151;
        String r163 = r162;
    L152:
        VSEndTraceHelper.a(r157, "", r160, r163, t.a().getCurrentUserId());
    L151:
        r163 = "";
        goto L152
    L144:
        r159 = 0;
        goto L145
    L30:
        r101 = false;
        goto L31
    L16:
        r100 = false;
    L12:
        r117 = "";
        goto L14
    }

    @Override // im1.a
    public final void hv(IRoom r100, f r101, Bundle r102) {
        this.f106171d = r100;
        this.f106174g = r101;
        this.f106175h = r102;
        p.a().h(this.f106173f, getArguments());
        DataCenter r103 = this.f106173f;
        IRoom r104 = h.f118195a;
        if (r103 == null) goto L7;
        Boolean r105 = (Boolean) r103.get("data_is_anchor", Boolean.FALSE);
        if (r105 == null) goto L7;
        boolean r106 = r105.booleanValue();
    L8:
        this.f106172e = r106;
        return;
    L7:
        r106 = false;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return LayoutInflater.from(getContext()).inflate(R.layout.ttlive_fragment_variety_end, r101, false);
    }
}
