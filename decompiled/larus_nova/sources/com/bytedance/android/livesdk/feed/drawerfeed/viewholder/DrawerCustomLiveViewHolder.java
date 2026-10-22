package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerUIManager;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.widget.LiveSportScoreBoardView;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.MatchData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MainCameraMatchInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSConfigDrawer;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.subjects.PublishSubject;
import j40.b4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerCustomLiveViewHolder;", "Lcom/bytedance/android/livesdk/feed/live/BaseLiveViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerCustomLiveViewHolder extends BaseLiveViewHolder {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LiveSportScoreBoardView f123854r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f123855s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final HSImageView f123856t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HSImageView f123857u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public k f123858v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f123859w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ViewGroup f123860x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final IFeedActionCallback f123861y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final IDrawerUIManager f123862z;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerCustomLiveViewHolder f123863a;

        public a(DrawerCustomLiveViewHolder r100) {
            this.f123863a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f123863a.itemView.setTag(R.id.ttlive_tag_sdk_params, Unit.INSTANCE);     // Catch: Throwable -> L4
            DrawerCustomLiveViewHolder r100 = this.f123863a;     // Catch: Throwable -> L4
            int r101 = r100.itemView.getMeasuredWidth() - s1.f(6.0f);     // Catch: Throwable -> L4
            int r102 = DrawerCustomLiveViewHolder.A;     // Catch: Throwable -> L4
            r100.c4(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerCustomLiveViewHolder f123864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FeedItem f123865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Room f123866c;

        public b(DrawerCustomLiveViewHolder r100, FeedItem r101, Room r102) {
            this.f123864a = r100;
            this.f123865b = r101;
            this.f123866c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            DrawerCustomLiveViewHolder r111 = this.f123864a;
            FeedItem r100 = this.f123865b;
            Room r101 = this.f123866c;
            int r102 = DrawerCustomLiveViewHolder.A;
            r111.getClass();
            if (r100 != null) goto L5;
        L12:
            Bundle r103 = new Bundle();
            r103.putLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME, System.currentTimeMillis());
            String r104 = r111.f124096c.f124004b;
            if (StringsKt.contains$default(r104, "live", false, 2, null) == false) goto L17;
            com.bytedance.android.livesdk.feed.feed.e r105 = r111.f124101h;
            if (r105 == null) goto L17;
            r104 = r105.e();
        L17:
            r103.putString("source", r104);
            Bundle r106 = new Bundle();
            LinkedHashMap r107 = new LinkedHashMap();
            r106.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SOURCE, "live_small_picture");
            r106.putString("subtab", r104);
            Map<String, String> r108 = r111.f124104k;
            String r109 = "";
            if (r108 != null) goto L20;
        L23:
            String r112 = "";
        L24:
            r106.putString("pull_type", r112);
            r106.putString(ILiveRoomPlayFragmentConstant.EXTRA_CAMERA_ENTER_FROM, "drawer_game");
            jw1.j.a(r101, r100.cameraType, r107);
            LinkedHashMap r113 = new LinkedHashMap();
            Iterator r114 = r107.entrySet().iterator();
        L26:
            if (r114.hasNext() == false) goto L30;
            Map.Entry r115 = (Map.Entry) r114.next();
            if (ArraysKt.contains(new String[]{"is_game_data", "is_tag"}, (String) r115.getKey()) == false) goto L26;
            r113.put(r115.getKey(), r115.getValue());
            goto L26
        L30:
            Iterator r116 = r113.entrySet().iterator();
        L32:
            if (r116.hasNext() == false) goto L34;
            Map.Entry r117 = (Map.Entry) r116.next();
            r106.putString((String) r117.getKey(), (String) r117.getValue());
            goto L32
        L34:
            r103.putBundle(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_EXTRA_V1, r106);
            r103.putString("log_pb", r100.logPb);
            r103.putString("request_id", r100.resId);
            r103.putInt(VSConstants.EXTRA_ITEM_TYPE, ArgumentsBuilder.getRoomType(r101));
            r103.putString("enter_from", "live");
            com.bytedance.android.livesdk.feed.feed.e r118 = r111.f124101h;
            if (r118 == null) goto L37;
            r103.putLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_FROM, r118.l());
        L37:
            r103.putString("enter_from_merge", "drawer_game");
            r103.putString("enter_method", "drawer_cover");
            r103.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_LOG_IS_FROM_MATCH_ROOM, true);
            r103.putInt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_ORDER, r111.f124108o);
            if (r100.isRecommendCard == false) goto L41;
            r103.putString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_MERGE_RECOMMEND, "pop_card");
        L41:
            if (TextUtils.isEmpty(r100.liveReason) == true) goto L44;
            r103.putString("live_reason", r100.liveReason);
        L44:
            if (r100.getRoom() != null) goto L46;
        L48:
            ILiveService r119 = TTLiveService.getLiveService();
            if (r119 == null) goto L54;
            ILiveOntologyInfoManager r120 = r119.getLiveOntologyRecord();
            if (r120 == null) goto L54;
            String r121 = r120.getEnterFromMerge();
            if (r121 == null) goto L54;
        L55:
            r103.putString(ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE, r121);
            r103.putString("drawer_inner_req_from", "");
            r103.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_DISABLE_INNER_DRAWER, true);
            com.bytedance.android.livesdk.log.filter.o r122 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
            if (r122.getMap().containsKey("action_type") == false) goto L61;
            String r123 = r122.getMap().get("action_type");
            if (r123 == null) goto L61;
            r109 = r123;
        L61:
            LiveVSLog.f153393r.getClass();
            LiveVSLog r124 = LiveVSLog.b.a(r101);
            HashMap r125 = new HashMap();
            r125.put("enter_from_merge", "drawer_game");
            r125.put("enter_method", "drawer_cover");
            r125.put("action_type", r109);
            r125.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_cover");
            r125.putAll(DrawerCustomLiveViewHolder.b4());
            r125.putAll(r124.a());
            jw1.j.a(r101, r100.cameraType, r125);
            com.bytedance.android.livesdk.log.filter.m0.J(r125);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_machine_click", r125, new Object[]{Room.class});
            r111.Y3(r100, false, "small_picture", r103);
            return;
        L54:
            r121 = "";
            goto L55
        L46:
            if (TextUtils.isEmpty(r100.getRoom().getItemExplicitInfo()) == true) goto L48;
            r103.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO, r100.getRoom().getItemExplicitInfo());
            goto L48
        L20:
            if (TextUtils.isEmpty(r108.get("pull_type")) == true) goto L23;
            r112 = r111.f124104k.get("pull_type");
            goto L24
        L5:
            if (r100.getRoom() == null) goto L12;
            Map<? extends String, ? extends String> r126 = DrawerCustomLiveViewHolder.b4();
            com.bytedance.android.livesdk.log.filter.o r127 = com.bytedance.android.livesdk.log.u.l().c(am2.o.class);
            if (r127 == null) goto L12;
            if (r127.getMap() == null) goto L12;
            r127.getMap().putAll(r126);
            am2.o r128 = new am2.o();
            r128.f4321a = r100.getRoom().f162599id;
            r127.setData(r128);
            goto L12
        }
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final String V3() {
        return "drawer_game";
    }

    public static Map b4() {
        HashMap r100 = new HashMap();
        ILiveService r101 = TTLiveService.getLiveService();
        if (r101 == null) goto L8;
        ILiveOntologyInfoManager r102 = r101.getLiveOntologyRecord();
        if (r102 == null) goto L8;
        String r103 = r102.getEnterFromMerge();
        if (r103 == null) goto L8;
    L9:
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE, r103);
        return r100;
    L8:
        r103 = "";
        goto L9
    }

    public final void a4() {
        IDrawerUIManager r100 = this.f123862z;
        if (r100 == null) goto L6;
        c4(((r100.panelSize() - s1.f(14.0f)) - s1.f(12.0f)) / 2);
        return;
    L6:
        if (this.itemView.getTag(R.id.ttlive_tag_sdk_params) != null) goto L10;
        this.itemView.post(new a(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder, com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        IFeedActionCallback r100 = this.f123861y;
        if (r100 == null) goto L6;
        r100.WS(IFeedActionCallback.FeedAction.FIRST_CARD_SHOWN, Unit.INSTANCE);
        return;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void unbind() {
        super.unbind();
        k r100 = this.f123858v;
        if (r100 == null) goto L7;
        ViewGroup r101 = this.f123860x;
        if (r101 == null) goto L7;
        r101.removeOnLayoutChangeListener(r100);
    L7:
        this.f123858v = null;
    }

    public final void c4(int r100) {
        if (r100 != this.f123859w) goto L5;
        return;
    L5:
        this.f123859w = r100;
        HSImageView r101 = this.f123856t;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L8;
        r102.height = r100;
        r102.width = r100;
        Unit r104 = Unit.INSTANCE;
    L9:
        r101.setLayoutParams(r102);
        LiveSportScoreBoardView r105 = this.f123854r;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L12;
        r106.height = r100;
        r106.width = r100;
        Unit r107 = Unit.INSTANCE;
    L13:
        r105.setLayoutParams(r106);
        TextView r108 = this.f123855s;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L16;
        r109.width = r100;
        Unit r110 = Unit.INSTANCE;
        r103 = r109;
    L16:
        r108.setLayoutParams(r103);
        return;
    L12:
        r106 = null;
        goto L13
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final void U3(FeedItem r110, Room r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "feedItem");
        Intrinsics.checkNotNullParameter(r111, "room");
        a4();
        if (b4.a() == false) goto L7;
        k r113 = new k(this);
        this.f123858v = r113;
        ViewGroup r100 = this.f123860x;
        if (r100 == null) goto L7;
        r100.addOnLayoutChangeListener(r113);
    L7:
        int r114 = r110.type;
        Object r101 = null;
        if (r114 != 1) goto L10;
        String r115 = r111.getTitle();
    L29:
        if (TextUtils.isEmpty(r115) == false) goto L31;
        r115 = r111.getTitle();
    L31:
        this.f123855s.setText(r115);
        r111.mo8271getOwner();
        int r116 = r110.type;
        if (r116 != 1) goto L34;
        py.k r117 = r111.getCover();
    L48:
        if (r117 != null) goto L51;
        r117 = r111.getCover();
    L51:
        if (r117 != null) goto L53;
    L58:
        a1.m(this.f123856t, R.drawable.ttlive_cover_err);
    L59:
        int r118 = r110.type;
        if (r118 == 1) goto L77;
        if (r118 != 27) goto L77;
        if (r110.cameraType != 1) goto L70;
        EpisodeExtraInfo r119 = r111.getEpisodeExtra2();
        if (r119 == null) goto L77;
        VSConfigDrawer r120 = r119.getVsConfigDrawer();
        if (r120 == null) goto L77;
        py.k r121 = r120.drawerLabel;
    L79:
        if (r121 == null) goto L81;
        UIUtils.setViewVisibility(this.f123857u, 0);
        HSImageView r102 = this.f123857u;
        ImageLoader.bindImageWithAnimation(r102, r121, new l(r102), r121.isAnimated());
    L83:
        if (r110.cameraType != 1) goto L252;
        Integer[] r122 = {0, 1};
        EpisodeExtraInfo r103 = r111.getEpisodeComponentData();
        if (r103 == null) goto L91;
        MainCameraMatchInfo r104 = r103.getMainCameraMatchInfo();
        if (r104 == null) goto L91;
        MatchData r105 = r104.getMatchData();
        if (r105 == null) goto L91;
        Integer r106 = Integer.valueOf(r105.getMatchStatus());
    L93:
        if (ArraysKt.contains(r122, r106) == false) goto L252;
        this.f123854r.setVisibility(0);
        LiveSportScoreBoardView r123 = this.f123854r;
        EpisodeExtraInfo r107 = r111.getEpisodeComponentData();
        if (r107 == null) goto L99;
        MainCameraMatchInfo r108 = r107.getMainCameraMatchInfo();
        if (r108 == null) goto L99;
        MatchData r109 = r108.getMatchData();
    L100:
        EpisodeExtraInfo r124 = r111.getEpisodeExtra2();
        if (r124 == null) goto L105;
        VSConfigDrawer r125 = r124.getVsConfigDrawer();
        if (r125 == null) goto L105;
        py.k r126 = r125.drawerBackground;
    L106:
        r123.getClass();
        if (r109 == null) goto L111;
        IAgainst r127 = r109.getAgainst();
        if (r127 == null) goto L111;
        String r128 = r127.getLeftGoal();
    L112:
        if (r109 == null) goto L116;
        IAgainst r129 = r109.getAgainst();
        if (r129 == null) goto L116;
        String r130 = r129.getRightGoal();
    L118:
        if (r128 != null) goto L120;
    L121:
        if (r130 == null) goto L125;
        if (new Regex("\\d{2}\\(.*\\)").matches(r130) != true) goto L125;
    L131:
        TextView r131 = r123.f161084d;
        if (r131 == null) goto L134;
        r131.setTextSize(10.0f);
    L134:
        TextView r132 = r123.f161085e;
        if (r132 == null) goto L156;
        r132.setTextSize(10.0f);
    L156:
        TextView r133 = r123.f161084d;
        String r134 = HTTP.URL_DEFAULT;
        if (r133 == null) goto L166;
        if (r109 == null) goto L164;
        IAgainst r135 = r109.getAgainst();
        if (r135 == null) goto L164;
        String r136 = r135.getLeftGoal();
        if (r136 == null) goto L164;
    L165:
        r133.setText(r136);
    L164:
        r136 = HTTP.URL_DEFAULT;
    L166:
        TextView r137 = r123.f161085e;
        if (r137 == null) goto L176;
        if (r109 == null) goto L174;
        IAgainst r138 = r109.getAgainst();
        if (r138 == null) goto L174;
        String r139 = r138.getRightGoal();
        if (r139 == null) goto L174;
    L175:
        r137.setText(r139);
    L174:
        r139 = HTTP.URL_DEFAULT;
    L176:
        TextView r140 = r123.f161082b;
        if (r140 == null) goto L186;
        if (r109 == null) goto L184;
        IAgainst r141 = r109.getAgainst();
        if (r141 == null) goto L184;
        String r142 = r141.getLeftName();
        if (r142 == null) goto L184;
    L185:
        r140.setText(r142);
    L184:
        r142 = HTTP.URL_DEFAULT;
    L186:
        TextView r143 = r123.f161083c;
        if (r143 == null) goto L195;
        if (r109 == null) goto L194;
        IAgainst r144 = r109.getAgainst();
        if (r144 == null) goto L194;
        String r145 = r144.getRightName();
        if (r145 == null) goto L194;
        r134 = r145;
    L194:
        r143.setText(r134);
    L195:
        TextView r146 = r123.f161086f;
        if (r146 == null) goto L206;
        StringBuilder r147 = new StringBuilder();
        if (r109 == null) goto L200;
        String r148 = r109.getMatchGroup();
    L201:
        r147.append(r148);
        r147.append(' ');
        if (r109 == null) goto L204;
        String r149 = r109.getMatchRound();
    L205:
        r147.append(r149);
        r146.setText(r147.toString());
        goto L206
    L204:
        r149 = null;
        goto L205
    L200:
        r148 = null;
    L206:
        if (r109 == null) goto L221;
        IAgainst r150 = r109.getAgainst();
        if (r150 == null) goto L221;
        py.k r151 = r150.getLeftLogo();
        if (r151 == null) goto L221;
        HSImageView r152 = r123.f161087g;
        if (r152 == null) goto L214;
        Object r153 = r152.getTag(R.id.ttlive_tag_image_request);
    L216:
        if ((!Intrinsics.areEqual(r153, r151.getUri())) == false) goto L221;
        HSImageView r154 = r123.f161087g;
        if (r154 == null) goto L220;
        r154.setTag(R.id.ttlive_tag_image_request, r151.getUri());
    L220:
        ImageUtil.loadImageWithRadius(r123.f161087g, r151, 0, 0);
        goto L221
    L214:
        r153 = null;
    L221:
        if (r109 == null) goto L236;
        IAgainst r155 = r109.getAgainst();
        if (r155 == null) goto L236;
        py.k r156 = r155.getRightLogo();
        if (r156 == null) goto L236;
        HSImageView r157 = r123.f161088h;
        if (r157 == null) goto L229;
        Object r158 = r157.getTag(R.id.ttlive_tag_image_request);
    L231:
        if ((!Intrinsics.areEqual(r158, r156.getUri())) == false) goto L236;
        HSImageView r159 = r123.f161088h;
        if (r159 == null) goto L235;
        r159.setTag(R.id.ttlive_tag_image_request, r156.getUri());
    L235:
        ImageUtil.loadImageWithRadius(r123.f161088h, r156, 0, 0);
        goto L236
    L229:
        r158 = null;
    L236:
        HSImageView r160 = r123.f161081a;
        if (r160 == null) goto L239;
        r160.setVisibility(8);
    L239:
        if (r126 == null) goto L253;
        HSImageView r161 = r123.f161081a;
        if (r161 == null) goto L243;
        r161.setVisibility(0);
    L243:
        HSImageView r162 = r123.f161081a;
        if (r162 == null) goto L247;
        r101 = r162.getTag(R.id.ttlive_tag_image_request);
    L247:
        if ((!Intrinsics.areEqual(r101, r126.getUri())) == false) goto L253;
        HSImageView r163 = r123.f161081a;
        if (r163 == null) goto L251;
        r163.setTag(R.id.ttlive_tag_image_request, r126.getUri());
    L251:
        ImageUtil.loadImage(r123.f161081a, r126, 0);
    L253:
        this.itemView.setOnClickListener(new b(this, r110, r111));
        return;
    L125:
        if (r128 != null) goto L127;
    L128:
        if (r130 == null) goto L138;
        if (new Regex(".*\\(\\d{2}\\).*").matches(r130) == true) goto L131;
    L138:
        if (r128 != null) goto L140;
    L141:
        if (r130 != null) goto L143;
    L150:
        TextView r164 = r123.f161084d;
        if (r164 == null) goto L153;
        r164.setTextSize(17.0f);
    L153:
        TextView r165 = r123.f161085e;
        if (r165 == null) goto L156;
        r165.setTextSize(17.0f);
        goto L156
    L143:
        if (new Regex(".*\\(.*\\)").matches(r130) != true) goto L150;
    L144:
        TextView r166 = r123.f161084d;
        if (r166 == null) goto L147;
        r166.setTextSize(14.0f);
    L147:
        TextView r167 = r123.f161085e;
        if (r167 == null) goto L156;
        r167.setTextSize(14.0f);
        goto L156
    L140:
        if (new Regex(".*\\(.*\\)").matches(r128) == true) goto L144;
    L127:
        if (new Regex(".*\\(\\d{2}\\).*").matches(r128) == true) goto L131;
    L120:
        if (new Regex("\\d{2}\\(.*\\)").matches(r128) == true) goto L131;
    L116:
        r130 = null;
    L111:
        r128 = null;
    L105:
        r126 = null;
    L99:
        r109 = null;
    L91:
        r106 = null;
    L252:
        this.f123854r.setVisibility(8);
        goto L253
    L81:
        UIUtils.setViewVisibility(this.f123857u, 8);
        goto L83
    L70:
        EpisodeExtraInfo r168 = r111.getEpisodeComponentData();
        if (r168 == null) goto L77;
        List<IVSCameraInfo> r169 = r168.getCameraInfos();
        if (r169 == null) goto L77;
        IVSCameraInfo r170 = (IVSCameraInfo) CollectionsKt.firstOrNull(r169);
        if (r170 == null) goto L77;
        r121 = r170.getLabel();
    L77:
        r121 = null;
        goto L79
    L53:
        if (Lists.isEmpty(r117.getUrls()) == true) goto L58;
        if ((!Intrinsics.areEqual(this.f123856t.getTag(R.id.ttlive_tag_image_request), r117.getUri())) == false) goto L59;
        this.f123856t.setTag(R.id.ttlive_tag_image_request, r117.getUri());
        ImageUtil.loadImage(this.f123856t, r117, R.drawable.ttlive_feed_cover_loading);
        goto L59
    L34:
        if (r116 == 27) goto L36;
    L47:
        r117 = null;
        goto L48
    L36:
        if (r110.cameraType != 1) goto L40;
        EpisodeExtraInfo r171 = r111.getEpisodeComponentData();
        if (r171 == null) goto L47;
        r117 = r171.getMainCameraCover();
        goto L48
    L40:
        EpisodeExtraInfo r172 = r111.getEpisodeComponentData();
        if (r172 == null) goto L47;
        List<IVSCameraInfo> r173 = r172.getCameraInfos();
        if (r173 == null) goto L47;
        IVSCameraInfo r174 = (IVSCameraInfo) CollectionsKt.firstOrNull(r173);
        if (r174 == null) goto L47;
        r117 = r174.getCover();
        goto L48
    L10:
        if (r114 == 27) goto L12;
    L27:
        r115 = null;
        goto L29
    L12:
        if (r110.cameraType != 1) goto L20;
        EpisodeExtraInfo r175 = r111.getEpisodeComponentData();
        if (r175 == null) goto L17;
        r115 = r175.getMainCameraTitle();
        if (r115 != null) goto L29;
    L17:
        EpisodeExtraInfo r176 = r111.getEpisodeComponentData();
        if (r176 == null) goto L27;
        r115 = r176.getTitle();
        goto L29
    L20:
        EpisodeExtraInfo r177 = r111.getEpisodeComponentData();
        if (r177 == null) goto L27;
        List<IVSCameraInfo> r178 = r177.getCameraInfos();
        if (r178 == null) goto L27;
        IVSCameraInfo r179 = (IVSCameraInfo) CollectionsKt.firstOrNull(r178);
        if (r179 == null) goto L27;
        r115 = r179.getTitle();
        goto L29
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final boolean Y3(FeedItem r100, boolean r101, String r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, "feedItem");
        Intrinsics.checkNotNullParameter("small_picture", "feedStyle");
        Intrinsics.checkNotNullParameter(r103, "enterExtra");
        boolean r104 = super.Y3(r100, false, "small_picture", r103);
        if (r104 == false) goto L5;
        xs2.b.a().post(new uv1.e(0));
    L5:
        return r104;
    }

    public DrawerCustomLiveViewHolder(View r110, tv1.c r111, com.bytedance.android.livesdk.feed.f r112, FeedDataKey r113, com.bytedance.android.livesdk.feed.j r114, ILiveRoomListDataSource r115, PublishSubject r116, PublishSubject r210, ViewGroup r211, Map r212, com.bytedance.android.livesdk.feed.h r213, IFeedActionCallback r214, IDrawerUIManager r215) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        super(r110, r111, r112, r113, r114, r115, r116, r210, r213);
        this.f123860x = r211;
        this.f123861y = r214;
        this.f123862z = r215;
        this.f123854r = (LiveSportScoreBoardView) r110.findViewById(R.id.live_score_board);
        this.f123855s = (TextView) r110.findViewById(R.id.live_title);
        this.f123856t = (HSImageView) r110.findViewById(R.id.live_cover);
        this.f123857u = (HSImageView) r110.findViewById(R.id.live_label);
        this.f124104k = r212;
        this.f124102i = true;
    }
}
