package com.bytedance.android.livesdk.chatroom.end.dynamic;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.backtrack.LiveVideoPreviewView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.fr0;
import com.bytedance.android.livesdk.config.kr;
import com.bytedance.android.livesdk.config.lr;
import com.bytedance.android.livesdk.config.xt;
import com.bytedance.android.livesdk.config.yt;
import com.bytedance.android.livesdk.config.zt;
import com.bytedance.android.livesdk.dsl.api.IDSLManagerService;
import com.bytedance.android.livesdk.end.EndingPageGuideCardInfo;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.end.SafeCardInfo;
import com.bytedance.android.livesdk.end.WindowCardType;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import yt1.k;
import yt1.n;
import yt1.o;

/* JADX INFO: loaded from: classes7.dex */
public final class i implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f106059a;

    public i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.end.dynamic.a
    public final boolean a(EndingPageGuideCardInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Long r101 = r100.getCardType();
        long r102 = WindowCardType.SECURITY_CARD.getType();
        if (r101 != null) goto L6;
    L12:
        return false;
    L6:
        if (r101.longValue() != r102) goto L12;
        if (PadConfigUtils.c() == true) goto L12;
        if (xt.f121630a.getValue().intValue() <= 0) goto L12;
        return true;
    }

    public static final void d(i r100, HashMap r101) {
        r100.getClass();
        if (r101 == null) goto L7;
        String r102 = com.bytedance.android.livesdk.dsl.util.c.c(r101, "track_data.click_params");
        if (r102 == null) goto L7;
        HashMap r103 = com.bytedance.android.livesdk.dsl.util.c.h(r102);
    L8:
        j0.l().sendLog("livesdk_live_end_punish_perception_click", r103, new Object[0]);
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final yt1.g e(Context r110, String r111) {
        View r100 = LayoutInflater.from(r110).inflate(R.layout.ttlive_layout_live_end_security_card, null, false);
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap r101 = com.bytedance.android.livesdk.dsl.util.c.g(r111);
        TextView r102 = (TextView) r100.findViewById(R.id.security_card_title);
        TextView r103 = (TextView) r100.findViewById(R.id.security_card_sub_title);
        LiveVideoPreviewView r112 = (LiveVideoPreviewView) r100.findViewById(R.id.security_card_video_player);
        View r113 = r100.findViewById(R.id.security_card_notice_tip);
        TextView r114 = (TextView) r100.findViewById(R.id.security_card_notice_title);
        ViewGroup r104 = (ViewGroup) r100.findViewById(R.id.security_card_notice_area);
        if (r102 == null) goto L8;
        r102.setText(f(r101, "title", "抖音直播「严厉打击色情低俗擦边内容」处罚公示"));
    L8:
        if (r103 == null) goto L11;
        r103.setText(f(r101, BdpAppEventConstant.PARAMS_SUB_TITLE, "平台倡导绿色直播，坚决禁止发布色情诱惑内容"));
    L11:
        if (r101 == null) goto L20;
        String r105 = com.bytedance.android.livesdk.dsl.util.c.c(r101, "video.play_url");
        if (r105 == null) goto L20;
        if (r105.length() <= 0) goto L17;
        boolean r106 = true;
    L18:
        if (r106 != true) goto L20;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L59;
        if (r112 == null) goto L52;
        UIUtils.setViewVisibility(r112, 0);
        if (r101 == null) goto L52;
        Map r108 = com.bytedance.android.livesdk.dsl.util.c.a(r101, "video");
        if (r108 == null) goto L52;
        String r109 = f(r108, "play_url", "");
        boolean r115 = com.bytedance.android.livesdk.dsl.util.c.b(r108, "auto_play");
        boolean r116 = com.bytedance.android.livesdk.dsl.util.c.b(r108, "is_mute");
        String r117 = f(r108, "first_frame_img", "");
        Object r118 = r108.get("track_event_name");
        if (r118 == null) goto L34;
        String r119 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r118);
        if (r119 == null) goto L34;
    L35:
        Map r120 = com.bytedance.android.livesdk.dsl.util.c.e(r108, "track_params");
        if (r120 == null) goto L38;
        Map r121 = MapsKt.toMutableMap(r120);
    L39:
        Object r122 = r108.get("hw_ratio");
        float r123 = 0.0f;
        if (r122 == null) goto L42;
        r123 = com.bytedance.android.ecom.arch.slice.render.util.b.c(r122, 0.0f);
    L42:
        r112.setTag("VideoPlayView");
        r112.setDataSource(r109);
        r112.post(new e(r112, r123));
        r112.f105181v = false;
        r112.setRadius(UtilityKotlinExtentionsKt.i(2));
        r112.setViewBg(null);
        r112.setTimeVisible(4);
        if (r117.length() <= 0) goto L45;
        boolean r124 = true;
    L46:
        if (r124 == false) goto L48;
        this.f106059a = a1.k(ImageModel.genBy(r117)).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(r112));
    L48:
        r112.setMute(r116);
        r112.f105178s = r115;
        r112.f105179t = new g(this, r121, r119);
        h r125 = new h(this, r121, r119, r112, r109);
        View r126 = r112.findViewById(R.id.full_play_video_btn);
        if (r126 == null) goto L51;
        UIUtils.setViewVisibility(r126, 0);
        r126.setOnClickListener(r125);
        goto L52
    L51:
        UIUtils.setViewVisibility(r126, 4);
        goto L52
    L45:
        r124 = false;
        goto L46
    L38:
        r121 = null;
    L34:
        r119 = "";
    L52:
        String r127 = f(r101, "short_notice", "");
        if (r127.length() <= 0) goto L55;
        boolean r128 = true;
    L56:
        if (r128 == false) goto L58;
        UIUtils.setViewVisibility(r113, 0);
        r114.setText(r127);
        r113.setOnClickListener(new b(this, r101, r100, f(r101, "notice_scheme", "")));
    L68:
        return new yt1.g(r100);
    L58:
        UIUtils.setViewVisibility(r113, 8);
        goto L68
    L55:
        r128 = false;
        goto L56
    L59:
        if (r104 == null) goto L68;
        UIUtils.setViewVisibility(r104, 0);
        r104.setOnClickListener(new c(this, r101, r104, f(r101, "notice_scheme", "")));
        String r129 = f(r101, "big_notice_img", "");
        if (r129.length() <= 0) goto L64;
        boolean r130 = true;
    L65:
        if (r130 == false) goto L68;
        this.f106059a = a1.k(ImageModel.genBy(r129)).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(r104));
        goto L68
    L64:
        r130 = false;
        goto L65
    L17:
        r106 = false;
    L20:
        r107 = false;
        goto L22
    }

    public static String f(Map r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return r102;
    L4:
        String r103 = com.bytedance.android.livesdk.dsl.util.c.d(r100, r101);
        if (r103 != null) goto L8;
        return r102;
    L8:
        return r103;
    }

    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.bytedance.android.livesdk.end.LiveEndPageData] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, java.util.Map] */
    @Override // com.bytedance.android.livesdk.chatroom.end.dynamic.a
    public final LiveEndPageData b(EndingPageGuideCardInfo r110, final DataCenter r111, final Context r210) {
        Intrinsics.checkNotNullParameter(r110, "info");
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        SafeCardInfo r100 = r110.getSafeCardInfo();
        if (r100 == null) goto L6;
        String r101 = r100.getTemplate();
        if (r101 == null) goto L6;
    L7:
        final String r112 = r101;
        SafeCardInfo r102 = r110.getSafeCardInfo();
        if (r102 == null) goto L11;
        String r103 = r102.getData();
        if (r103 == null) goto L11;
    L12:
        final String r113 = r103;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L46
        if (fr0.f120226a.getValue().booleanValue() == false) goto L16;
        ALogger.e("SecurityDynamicGenerator", "ForceNative");     // Catch: Throwable -> L46
        k r105 = e(r210, r113);     // Catch: Throwable -> L46
    L44:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L46
    L48:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 != null) goto L51;
        final i r108 = this;
        ?? r109 = 0;
    L52:
        final k r114 = (k) r106;
        if (r114 == null) goto L92;
        final Ref.ObjectRef r115 = new Ref.ObjectRef();
        r115.element = r109;
        ALogger.i("SecurityDynamicGenerator", r113);
        boolean r116 = true;
        if (r113 == null) goto L83;
        HashMap r117 = com.bytedance.android.livesdk.dsl.util.c.g(r113);
        if (r117 == null) goto L83;
        Object r118 = r117.get("track_data");
        if (r118 != null) goto L61;
        Map r119 = null;
    L65:
        if (r119 == null) goto L67;
        String r120 = com.bytedance.android.livesdk.dsl.util.c.d(r119, "exposure_track_name");
    L68:
        if (r120 != null) goto L70;
    L82:
        r115.element = com.bytedance.android.livesdk.dsl.util.c.a(r117, "video");
        goto L83
    L70:
        if (r120.length() <= 0) goto L72;
        boolean r121 = true;
    L73:
        if (r121 != true) goto L82;
        Map<String, String> r122 = com.bytedance.android.livesdk.dsl.util.c.e(r119, "exposure_track_params");
        if (zt.f121790a.getValue().booleanValue() == false) goto L81;
        if (r122 == null) goto L79;
        String r123 = r122.get("room_id");
        if (r123 == null) goto L79;
    L80:
        ALogger.i("SecurityDynamicGenerator", r123);
        j0.l().sendLog(r120, r122, new Object[0]);
    L79:
        r123 = "room id is null";
        goto L80
    L81:
        j0.l().sendLog(r120, r122, new Object[]{Room.class, x.class});
        goto L82
    L72:
        r121 = false;
        goto L73
    L67:
        r120 = null;
        goto L68
    L61:
        if ((r118 instanceof Map) == true) goto L63;
        r118 = null;
    L63:
        r119 = (Map) r118;
    L83:
        LiveEndPageData r124 = new LiveEndPageData();
        r124.setContent(r114.getView());
        r124.setTopView("name");
        r124.setMargins(CollectionsKt.arrayListOf(new Integer[]{0, 14, 0, 0}));
        String r125 = yt.f121714a.getValue();
        if (r125.length() > 0) goto L87;
        r116 = false;
    L87:
        if (r116 == false) goto L89;
        List<String> r126 = StringsKt.split$default(r125, new String[]{","}, false, 0, 6, null);
    L90:
        r124.setHideViews(r126);
        r124.setExtraData((Map) r115.element);
        r124.setOnExit(new SecurityDynamicGenerator$generateDynamicCard$$inlined$apply$lambda$1(r108, r114, r115));
        return r124;
    L89:
        r126 = CollectionsKt.arrayListOf(new String[]{LiveEndPageData.TAG_LIVE_TAB, "replay", LiveEndPageData.TAG_PREDICTION, LiveEndPageData.TAG_SUBSCRIPTION, "rank", LiveEndPageData.TAG_RESERVATION, LiveEndPageData.TAG_WINDOW, LiveEndPageData.TAG_APPOINTMENT_V2, LiveEndPageData.TAG_OPEN_PUSH});
        goto L90
    L92:
        return r109;
    L51:
        ALogger.e("SecurityDynamicGenerator", "SliceLoadError");
        r109 = 0;
        SafetyGuard.a(null, r107, "SliceLoadError");
        r108 = this;
        r106 = r108.e(r210, r113);
        goto L52
    L16:
        MiddlewareRoomContext.a r127 = MiddlewareRoomContext.Companion;     // Catch: Throwable -> L46
        r127.getClass();     // Catch: Throwable -> L46
        MiddlewareRoomContext r128 = MiddlewareRoomContext.a.a(r111, 0);     // Catch: Throwable -> L46
        if (r128 == null) goto L21;
        j<n> r129 = r128.getDslManager();     // Catch: Throwable -> L46
        if (r129 == null) goto L21;
        n r130 = r129.getValue();     // Catch: Throwable -> L46
    L22:
        if (r130 != null) goto L31;
        if (r111 == null) goto L31;
        MiddlewareRoomContext r131 = MiddlewareRoomContext.a.a(r111, 0);     // Catch: Throwable -> L46
        if (r131 == null) goto L31;
        j<n> r132 = r131.getDslManager();     // Catch: Throwable -> L46
        if (r132 == null) goto L31;
        final Long r133 = null;
        r132.e(new SecurityDynamicGenerator$generateDynamicCard$$inlined$runCatching$lambda$1(this, r210, r113, r111, r133, r112));     // Catch: Throwable -> L46
    L31:
        IDSLManagerService r134 = (IDSLManagerService) jc1.k.f(IDSLManagerService.class);     // Catch: Throwable -> L46
        if (r134 == null) goto L35;
        r134.registerCustomViewManger("VideoPlayView", new rg1.a(), "");     // Catch: Throwable -> L46
    L35:
        MiddlewareRoomContext r135 = MiddlewareRoomContext.a.c(r127, r111, 0, 2);     // Catch: Throwable -> L46
        if (r135 == null) goto L42;
        j<n> r136 = r135.getDslManager();     // Catch: Throwable -> L46
        if (r136 == null) goto L42;
        n r137 = r136.getValue();     // Catch: Throwable -> L46
        if (r137 == null) goto L42;
        o.f569030e.getClass();     // Catch: Throwable -> L46
        r105 = r137.c(o.a.a("end_page_dynamic_card", "", r112), r113, r210, null, null);     // Catch: Throwable -> L46
    L43:
        ALogger.i("SecurityDynamicGenerator", "SliceLoadSuccess");     // Catch: Throwable -> L46
    L42:
        r105 = null;
    L21:
        r130 = null;
    L46:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L11:
        r103 = kr.f120623a.getValue();
    L6:
        r101 = lr.f120702a.getValue();
        goto L7
    }

    public static final void c(i r100, Map r101, String r102, String r103) {
        r100.getClass();
        if (r101 == null) goto L5;
        String r104 = (String) r101.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, r103);
    L5:
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.length() <= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 != true) goto L14;
        j0.l().sendLog(r102, r101, new Object[]{Room.class, x.class});
        return;
    L14:
        return;
    L9:
        r105 = false;
        goto L10
    }
}
