package com.bytedance.android.livesdk.chatroom.tabliveguide;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.moreliveentrance.LiveTabForceRefreshStyle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.explore.view.AbsBaseFragment;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.resolution.IResolutionService;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tabliveguide/LiveInnerTabliveGuideFragment;", "Lcom/bytedance/android/livesdk/explore/view/AbsBaseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInnerTabliveGuideFragment extends AbsBaseFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f111653m = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f111654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f111655g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f111656h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView f111657i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LiveInnerCardSkyLightAdapter f111658j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ILivePlayerClient f111659k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AbsLivePlayerView f111660l;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInnerTabliveGuideFragment f111661a;

        public b(LiveInnerTabliveGuideFragment r100) {
            this.f111661a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            LiveInnerTabliveGuideFragment r102 = this.f111661a;
            int r103 = LiveInnerTabliveGuideFragment.f111653m;
            LiveInnerTabGuideManager r104 = r102.T90();
            if (r104 == null) goto L7;
            r104.stopTimer();
            return false;
        L7:
            return false;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInnerTabliveGuideFragment f111662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f111663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f111664c;

        public c(LiveInnerTabliveGuideFragment r100, String r101, String r102) {
            this.f111662a = r100;
            this.f111663b = r101;
            this.f111664c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveInnerTabliveGuideFragment r101 = this.f111662a;
            int r102 = LiveInnerTabliveGuideFragment.f111653m;
            LiveInnerTabGuideManager r103 = r101.T90();
            if (r103 == null) goto L5;
            r103.logCardClick("enter_tablive", this.f111663b, this.f111664c);
        L5:
            LiveInnerTabliveGuideFragment.S90(this.f111662a, this.f111663b);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInnerTabliveGuideFragment f111665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f111666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f111667c;

        public d(LiveInnerTabliveGuideFragment r100, String r101, String r102) {
            this.f111665a = r100;
            this.f111666b = r101;
            this.f111667c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveInnerTabliveGuideFragment r101 = this.f111665a;
            int r102 = LiveInnerTabliveGuideFragment.f111653m;
            LiveInnerTabGuideManager r103 = r101.T90();
            if (r103 == null) goto L5;
            r103.logCardClick("live_cell", this.f111666b, this.f111667c);
        L5:
            LiveInnerTabliveGuideFragment.S90(this.f111665a, this.f111666b);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInnerTabliveGuideFragment f111668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f111669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f111670c;

        public e(LiveInnerTabliveGuideFragment r100, String r101, String r102) {
            this.f111668a = r100;
            this.f111669b = r101;
            this.f111670c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveInnerTabliveGuideFragment r101 = this.f111668a;
            int r102 = LiveInnerTabliveGuideFragment.f111653m;
            LiveInnerTabGuideManager r103 = r101.T90();
            if (r103 == null) goto L5;
            r103.logCardClick(AppConstants.BUNDLE_DISLIKE, this.f111669b, this.f111670c);
        L5:
            LiveInnerTabGuideManager r104 = this.f111668a.T90();
            if (r104 == null) goto L9;
            r104.removeInnerCardItem();
            return;
        }
    }

    static {
    }

    public final long U90() {
        return ((Number) this.f111654f.getValue()).longValue();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final void forceSmoothExit() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final void onSlide() {
    }

    public final LiveInnerTabGuideManager T90() {
        LiveInnerTabGuideManager.Companion.getClass();
        return LiveInnerTabGuideManager.b.a();
    }

    public LiveInnerTabliveGuideFragment() {
        this.f111654f = LazyKt.lazy(new LiveInnerTabliveGuideFragment$roomId$2(this));
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final LiveMode getStreamType() {
        LiveInnerTabGuideManager r100 = T90();
        if (r100 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.tabliveguide.b r101 = r100.getInnerCardData();
        if (r101 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.tabliveguide.a r102 = r101.a();
        if (r102 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.tabliveguide.c r103 = r102.c();
        if (r103 == null) goto L23;
        List<FeedItem> r104 = r103.a();
        if (r104 == null) goto L24;
        FeedItem r105 = (FeedItem) ListProtector.get(r104, 0);
        if (r105 == null) goto L25;
        Room r106 = r105.getRoom();
        if (r106 != null) goto L18;
        return null;
    L18:
        return r106.getStreamType();
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    L19:
        return null;
    }

    @Override // com.bytedance.android.livesdk.explore.view.AbsBaseFragment, com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final void onScrolling() {
        LiveInnerTabGuideManager r100 = T90();
        if (r100 == null) goto L6;
        r100.stopTimer();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final as0.a roomPlayerContext() {
        return LivePlatformPlayerManager.e(U90(), false);
    }

    @Override // com.bytedance.android.livesdk.explore.view.AbsBaseFragment, com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final void startRoom() {
        LiveInnerTabGuideManager r100 = T90();
        if (r100 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.tabliveguide.b r101 = r100.getInnerCardData();
        if (r101 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.tabliveguide.a r102 = r101.a();
        if (r102 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.tabliveguide.c r103 = r102.c();
        if (r103 == null) goto L34;
        List<FeedItem> r104 = r103.a();
        if (r104 == null) goto L35;
        FeedItem r105 = (FeedItem) ListProtector.get(r104, 0);
        if (r105 == null) goto L36;
        Room r106 = r105.getRoom();
        if (r106 == null) goto L38;
        String r107 = r106.getCompoundStreamData();
        if (r107 != null) goto L20;
        return;
    L20:
        LiveRequest.Builder r108 = new LiveRequest.Builder().streamData(r107).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r106.getStreamType()));
        IResolutionService r109 = (IResolutionService) jc1.k.f(IResolutionService.class);
        if (r109 == null) goto L26;
        PlayerResolution.PickResult r110 = r109.getPullStreamResolution(U90(), r106.getStreamUrl(), true);
        if (r110 == null) goto L26;
        String r111 = r110.getResultSdkKey();
        if (r111 == null) goto L26;
    L27:
        LiveRequest r112 = r108.resolution(r111).build();
        ILivePlayerClient r113 = this.f111659k;
        if (r113 == null) goto L37;
        r113.stream(r112, null);
        return;
    L37:
        return;
    L26:
        r111 = PlayerResolution.SDKKEY.ORIGIN;
        goto L27
    L38:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        ALogger.i("LiveInnerTabliveGuideFragment", "onCreate " + hashCode());
        super.onCreate(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        if (r100 == false) goto L21;
        LiveInnerTabGuideManager r101 = T90();
        if (r101 == null) goto L7;
        r101.onPageSelected();
    L7:
        LiveInnerCardSkyLightAdapter r102 = this.f111658j;
        if (r102 == null) goto L25;
        RecyclerView r103 = this.f111657i;
        if (r103 == null) goto L14;
        RecyclerView.LayoutManager r104 = r103.getLayoutManager();
        if (r104 == null) goto L14;
        int r105 = r104.getChildCount();
    L15:
        LiveInnerTabGuideManager r106 = T90();
        if (r106 == null) goto L19;
        Map<String, String> r107 = r106.getCommonMobParams();
        if (r107 == null) goto L19;
    L20:
        r102.y2(r105, r107);
        return;
    L19:
        r107 = new LinkedHashMap();
    L14:
        r105 = 0;
        goto L15
    L25:
        return;
    L21:
        LiveInnerTabGuideManager r108 = T90();
        if (r108 == null) goto L27;
        r108.onPageUnSelected();
        return;
    }

    @Override // com.bytedance.android.livesdk.explore.view.AbsBaseFragment, com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final void stopRoom(String r100) {
        ILivePlayerClient r101 = this.f111659k;
        if (r101 == null) goto L6;
        r101.release();
        return;
    }

    public static final void S90(LiveInnerTabliveGuideFragment r100, String r110) {
        r100.getClass();
        IHostBusiness r101 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r101 == null) goto L6;
        Context r102 = r100.getContext();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("enter_method", "tablive_feed");
        Unit r104 = Unit.INSTANCE;
        Bundle r105 = new Bundle();
        r105.putString("insert_room_id_str", r110);
        r105.putString("guide_scene", "live_feed");
        r105.putString(ILiveRoomPlayFragmentConstant.EXTRA_INSERT_TYPE, "100");
        r101.enterLiveChannel(r102, r103, "inner_card", r105, true, true, LiveTabForceRefreshStyle.REFRESH_FULL);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f111655g;
        ILivePlayerClient r103 = null;
        if (r102 == null) goto L5;
        FrameLayout r104 = (FrameLayout) r102.findViewById(R.id.gesture_layout);
    L6:
        if (r104 == null) goto L8;
        r104.setOnTouchListener(new b(this));
    L8:
        View r105 = this.f111655g;
        if (r105 == null) goto L11;
        FrameLayout r106 = (FrameLayout) r105.findViewById(R.id.player_container);
    L12:
        this.f111656h = r106;
        View r107 = this.f111655g;
        if (r107 == null) goto L15;
        TextView r108 = (TextView) r107.findViewById(R.id.tablive_guide_title);
    L16:
        View r109 = this.f111655g;
        if (r109 == null) goto L19;
        TextView r110 = (TextView) r109.findViewById(R.id.often_living_sub_title);
    L20:
        if (r108 == null) goto L30;
        LiveInnerTabGuideManager r111 = T90();
        if (r111 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.tabliveguide.b r112 = r111.getInnerCardData();
        if (r112 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.tabliveguide.a r113 = r112.a();
        if (r113 == null) goto L28;
        String r114 = r113.b();
    L29:
        r108.setText(r114);
    L28:
        r114 = null;
    L30:
        if (r110 == null) goto L40;
        LiveInnerTabGuideManager r115 = T90();
        if (r115 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.tabliveguide.b r116 = r115.getInnerCardData();
        if (r116 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.tabliveguide.a r117 = r116.a();
        if (r117 == null) goto L38;
        String r118 = r117.a();
    L39:
        r110.setText(r118);
    L38:
        r118 = null;
    L40:
        View r119 = this.f111655g;
        if (r119 == null) goto L43;
        FrameLayout r120 = (FrameLayout) r119.findViewById(R.id.goto_see_button);
    L44:
        View r121 = this.f111655g;
        if (r121 == null) goto L47;
        FrameLayout r122 = (FrameLayout) r121.findViewById(R.id.dislike_button);
    L48:
        LiveInnerTabGuideManager r123 = T90();
        String r124 = "";
        if (r123 == null) goto L64;
        com.bytedance.android.livesdk.chatroom.tabliveguide.b r125 = r123.getInnerCardData();
        if (r125 == null) goto L64;
        com.bytedance.android.livesdk.chatroom.tabliveguide.a r126 = r125.a();
        if (r126 == null) goto L64;
        com.bytedance.android.livesdk.chatroom.tabliveguide.c r127 = r126.c();
        if (r127 == null) goto L64;
        List<FeedItem> r128 = r127.a();
        if (r128 == null) goto L64;
        FeedItem r129 = (FeedItem) ListProtector.get(r128, 0);
        if (r129 == null) goto L64;
        Room r130 = r129.getRoom();
        if (r130 == null) goto L64;
        String r131 = r130.getIdStr();
        if (r131 == null) goto L64;
    L65:
        LiveInnerTabGuideManager r132 = T90();
        if (r132 == null) goto L83;
        com.bytedance.android.livesdk.chatroom.tabliveguide.b r133 = r132.getInnerCardData();
        if (r133 == null) goto L83;
        com.bytedance.android.livesdk.chatroom.tabliveguide.a r134 = r133.a();
        if (r134 == null) goto L83;
        com.bytedance.android.livesdk.chatroom.tabliveguide.c r135 = r134.c();
        if (r135 == null) goto L83;
        List<FeedItem> r136 = r135.a();
        if (r136 == null) goto L83;
        FeedItem r137 = (FeedItem) ListProtector.get(r136, 0);
        if (r137 == null) goto L83;
        Room r138 = r137.getRoom();
        if (r138 == null) goto L83;
        String r139 = r138.getOwnerUserIdString();
        if (r139 == null) goto L83;
        r124 = r139;
    L83:
        if (r120 == null) goto L85;
        r120.setOnClickListener(new c(this, r131, r124));
    L85:
        FrameLayout r140 = this.f111656h;
        if (r140 == null) goto L88;
        r140.setOnClickListener(new d(this, r131, r124));
    L88:
        if (r122 == null) goto L90;
        r122.setOnClickListener(new e(this, r131, r124));
    L90:
        View r141 = this.f111655g;
        if (r141 == null) goto L93;
        RecyclerView r142 = (RecyclerView) r141.findViewById(R.id.often_skylight_recyclerview);
    L94:
        this.f111657i = r142;
        if (r142 == null) goto L97;
        final Context r143 = getContext();
        LinearLayoutManager r144 = new AnonymousClass5(r143);
        r144.setOrientation(0);
        Unit r145 = Unit.INSTANCE;
        r142.setLayoutManager(r144);
    L97:
        LiveInnerTabGuideManager r146 = T90();
        if (r146 == null) goto L110;
        com.bytedance.android.livesdk.chatroom.tabliveguide.b r147 = r146.getInnerCardData();
        if (r147 == null) goto L110;
        com.bytedance.android.livesdk.chatroom.tabliveguide.a r148 = r147.a();
        if (r148 == null) goto L110;
        com.bytedance.android.livesdk.chatroom.tabliveguide.c r149 = r148.c();
        if (r149 == null) goto L110;
        List<FeedItem> r150 = r149.a();
        if (r150 == null) goto L110;
        LiveInnerCardSkyLightAdapter r151 = new LiveInnerCardSkyLightAdapter(r150, new LiveInnerTabliveGuideFragment$onViewCreated$$inlined$let$lambda$1(this));
        this.f111658j = r151;
        RecyclerView r152 = this.f111657i;
        if (r152 == null) goto L110;
        r152.setAdapter(r151);
    L110:
        as0.a r153 = LivePlatformPlayerManager.c(U90(), false);
        Context r154 = getContext();
        if (r154 == null) goto L113;
        FrameLayout.LayoutParams r155 = new FrameLayout.LayoutParams(-1, -1);
        r155.gravity = 17;
        AbsLivePlayerView r156 = as0.a.C0216a.a(r153, r154, U90());
        r156.setClipToOutline(true);
        r156.setOutlineProvider(new k(this, r153));
        r156.setLayoutParams(r155);
        r156.getRenderView().setLayoutParams(r155);
        r156.setScaleType(2);
        Unit r157 = Unit.INSTANCE;
        this.f111660l = r156;
    L113:
        AbsLivePlayerView r158 = this.f111660l;
        if (r158 == null) goto L116;
        r103 = r158.getClient();
    L116:
        this.f111659k = r103;
        FrameLayout r159 = this.f111656h;
        if (r159 == null) goto L119;
        r159.addView(this.f111660l, 0);
    L119:
        ILivePlayerClient r160 = this.f111659k;
        if (r160 == null) goto L153;
        LifecycleOwner r161 = r160.getLifecycleOwner();
        if (r161 == null) goto L157;
        ILivePlayerClient r162 = this.f111659k;
        if (r162 == null) goto L131;
        IRoomEventHub r163 = r162.getEventHub();
        if (r163 == null) goto L131;
        MutableLiveData<Pair<Integer, Integer>> r164 = r163.getVideoSizeChanged();
        if (r164 == null) goto L131;
        r164.observe(r161, new l(this));
    L131:
        ILivePlayerClient r165 = this.f111659k;
        if (r165 == null) goto L138;
        IRoomEventHub r166 = r165.getEventHub();
        if (r166 == null) goto L138;
        MutableLiveData<String> r167 = r166.getPlayerMediaError();
        if (r167 == null) goto L138;
        r167.observe(r161, new m(this));
    L138:
        ILivePlayerClient r168 = this.f111659k;
        if (r168 == null) goto L145;
        IRoomEventHub r169 = r168.getEventHub();
        if (r169 == null) goto L145;
        MutableLiveData<Boolean> r170 = r169.getPlayComplete();
        if (r170 == null) goto L145;
        r170.observe(r161, new n(this));
    L145:
        ILivePlayerClient r171 = this.f111659k;
        if (r171 == null) goto L154;
        IRoomEventHub r172 = r171.getEventHub();
        if (r172 == null) goto L155;
        MutableLiveData<Boolean> r173 = r172.getFirstFrame();
        if (r173 == null) goto L156;
        r173.observe(r161, new o(this));
        return;
    L156:
        return;
    L155:
        return;
    L154:
        return;
    L157:
        return;
    L153:
        return;
    L93:
        r142 = null;
    L64:
        r131 = "";
        goto L65
    L47:
        r122 = null;
        goto L48
    L43:
        r120 = null;
        goto L44
    L19:
        r110 = null;
        goto L20
    L15:
        r108 = null;
        goto L16
    L11:
        r106 = null;
        goto L12
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_inner_card_tablive_guide_play, r101, false);
        this.f111655g = r103;
        return r103;
    }
}
