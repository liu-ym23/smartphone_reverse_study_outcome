package com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.xplay.r;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamPushMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.google.gson.JsonObject;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ttvecamera.TECameraUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.d0;
import yq0.e;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/cloudgame/LiveMgXplayRtcContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMgXplayRtcContextService extends OpenPlatformContextService {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f85160k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e.a f85161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ei6.a f85162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f85163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f85164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f85165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f85166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f85167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AnchorMiniGameAppLogContextService f85168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f85169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f85170j;

    public static final class a {
    }

    static {
    }

    public final void g() {
        if (this.f85163c == false) goto L36;
        ei6.a r100 = this.f85162b;
        if (r100 == null) goto L9;
        si6.b r101 = r100.b();
        if (r101 == null) goto L9;
        si6.a.b(r101, false, "MgXplay", 3);
    L9:
        Iterator<String> r102 = this.f85165e.iterator();
    L11:
        if (r102.hasNext() == false) goto L17;
        String r103 = r102.next();
        ei6.a r104 = this.f85162b;
        if (r104 == null) goto L11;
        gi6.e r105 = r104.getEventManager();
        if (r105 == null) goto L11;
        r105.c(r103);
        goto L11
    L17:
        this.f85165e.clear();
        RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r106 == null) goto L24;
        j<com.bytedance.android.live.pushstream.d> r107 = r106.getLiveStream();
        if (r107 == null) goto L24;
        com.bytedance.android.live.pushstream.d r108 = r107.getValue();
        if (r108 == null) goto L24;
        r108.r1();
    L24:
        d r109 = this.f85164d;
        if (r109 == null) goto L27;
        r109.f85176a = false;
    L27:
        this.f85163c = false;
        qo0.a.c("LiveMgXplayRtcContextService", "leaveRTCRoom");
        return;
    }

    public LiveMgXplayRtcContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f85165e = new LinkedHashSet();
        this.f85168h = (AnchorMiniGameAppLogContextService) r100.getService(AnchorMiniGameAppLogContextService.class);
        this.f85170j = LazyKt.lazy(new LiveMgXplayRtcContextService$mRtcListener$2(this));
    }

    public final void i(JsonObject r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "liveCastRect");
        if (r100.has("width") == true) goto L5;
        return;
    L5:
        if (r100.has("height") == false) goto L15;
        int r102 = r100.get("width").getAsInt() * r100.get("height").getAsInt();
        double r103 = ((double) r101.width()) / ((double) r101.height());
        int r104 = (int) Math.sqrt(((double) r102) / r103);
        this.f85167g = r104;
        int r105 = (int) (((double) r104) * r103);
        this.f85166f = r105;
        if (r105 > 1920) goto L9;
        if (r104 > 1920) goto L9;
    L12:
        r100.addProperty("width", Integer.valueOf(this.f85166f));
        r100.addProperty("height", Integer.valueOf(this.f85167g));
        int r106 = qo0.a.f534145a;
        qo0.a.c("LiveMgXplayRtcContextService", "canvasW = " + this.f85166f + ", canvasH = " + this.f85167g);
        return;
    L9:
        if (r105 <= r104) goto L11;
        this.f85166f = TECameraUtils.CAPTURE_NORMAL;
        this.f85167g = (int) (((double) TECameraUtils.CAPTURE_NORMAL) / r103);
        goto L12
    L11:
        this.f85167g = TECameraUtils.CAPTURE_NORMAL;
        this.f85166f = (int) (((double) TECameraUtils.CAPTURE_NORMAL) * r103);
        goto L12
    }

    public static void f(final LiveMgXplayRtcContextService r110, boolean r111, Rect r112) {
        r110.getClass();
        Intrinsics.checkNotNullParameter(r112, "liveCastRect");
        e.a r100 = r110.f85161a;
        if (r100 == null) goto L7;
        e.b r101 = r100.b();
        if (r101 == null) goto L7;
        String r102 = r101.a();
    L8:
        if (r102 != null) goto L11;
        r110.h("0", "401", "rtc info null", "start");
        return;
    L11:
        if (r110.f85163c == true) goto L138;
        r110.f85169i = r111;
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L22;
        j<com.bytedance.android.live.pushstream.d> r104 = r103.getLiveStream();
        if (r104 == null) goto L22;
        com.bytedance.android.live.pushstream.d r105 = r104.getValue();
        if (r105 == null) goto L22;
        d0 r106 = r105.getLiveCore();
        if (r106 == null) goto L22;
        r106.h();
    L22:
        fi6.a r107 = new fi6.a();
        e.a r108 = r110.f85161a;
        if (r108 == null) goto L27;
        e.b r109 = r108.b();
        if (r109 == null) goto L27;
        String r113 = r109.a();
    L28:
        Intrinsics.checkNotNullParameter(r112, "liveCastRect");
        int r114 = qo0.a.f534145a;
        qo0.a.c("LiveMgXplayRtcContextService", "rtcExtInfo = " + r113);
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L31
        JsonObject r116 = (JsonObject) GsonHelper.get().fromJson(r113, JsonObject.class);     // Catch: Throwable -> L31
        JsonObject r117 = r116.getAsJsonObject("live_rtc_video_param");     // Catch: Throwable -> L31
        r110.i(r117.getAsJsonObject("rtc_video_param_server_define"), r112);     // Catch: Throwable -> L31
        r110.i(r117.getAsJsonObject("rtc_mix_param").getAsJsonObject("mix_video_param_server"), r112);     // Catch: Throwable -> L31
        String r118 = GsonHelper.get().toJson(r116);     // Catch: Throwable -> L31
        qo0.a.c("LiveMgXplayRtcContextService", "newRtcExtInfo = " + r118);     // Catch: Throwable -> L31
        r113 = r118;
    L33:
        e.a r119 = r110.f85161a;
        if (r119 == null) goto L48;
        e.b r120 = r119.b();
        if (r120 == null) goto L48;
        String r121 = r120.a();
        if (r121 == null) goto L48;
        Intrinsics.checkNotNullParameter(r121, "rtcExtInfo");
        if (TextUtils.isEmpty(r121) == true) goto L48;
        r r122 = new r(0);     // Catch: Exception -> L45
        JSONObject r123 = new JSONObject(r121);     // Catch: Exception -> L45
        JSONObject r124 = r123.optJSONObject("live_rtc_engine_config");     // Catch: Exception -> L45
        if (r124 == null) goto L46;
        String r125 = r124.optString("rtc_app_id");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r125, "<set-?>");     // Catch: Exception -> L45
        r122.f59517b = r125;     // Catch: Exception -> L45
        String r126 = r124.optString("rtc_token");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r126, "<set-?>");     // Catch: Exception -> L45
        r122.f59522g = r126;     // Catch: Exception -> L45
        r122.f59518c = r124.optInt("rtc_vendor");     // Catch: Exception -> L45
        r122.f59520e = Base64.decode(r124.optString("rtc_app_sign"), 0);     // Catch: Exception -> L45
        String r127 = r124.optString("rtc_channel_id");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r127, "<set-?>");     // Catch: Exception -> L45
        r122.f59521f = r127;     // Catch: Exception -> L45
        String r128 = r124.optString("rtc_user_id");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r128, "<set-?>");     // Catch: Exception -> L45
        r122.f59524i = r128;     // Catch: Exception -> L45
        r122.f59525j = r124.optInt("rtc_user_id_mode");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter("byte", "<set-?>");     // Catch: Exception -> L45
        r122.f59519d = "byte";     // Catch: Exception -> L45
        String r129 = r124.optString("user_id");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r129, "<set-?>");     // Catch: Exception -> L45
        r122.f59523h = r129;     // Catch: Exception -> L45
    L46:
        String r130 = r123.optString("rtc_business_id");     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r130, "<set-?>");     // Catch: Exception -> L45
        r122.f59526k = r130;     // Catch: Exception -> L45
        Intrinsics.checkNotNullParameter(r121, "<set-?>");     // Catch: Exception -> L45
        r122.f59516a = r121;     // Catch: Exception -> L45
    L49:
        r110.f85164d = new d(r107, r122, new Pair(Integer.valueOf(r110.f85166f), Integer.valueOf(r110.f85167g)), r112);
        if (r103 == null) goto L58;
        m<Room> r131 = r103.getRoom();
        if (r131 == null) goto L58;
        Room r132 = r131.getValue();
        if (r132 == null) goto L58;
        StreamUrl r133 = r132.getStreamUrl();
        if (r133 == null) goto L58;
        String r134 = r133.getRtmpPushUrl();
    L59:
        r107.f477380e = r134;
        r107.f477382f = r110.f85164d;
        r107.j(MixStreamType.SERVER_MIX);
        r107.g(Character.ANCHOR);
        String r135 = String.valueOf(r113);
        Intrinsics.checkNotNullParameter(r135, "info");
        r107.f477406v = r135;
        Intrinsics.checkNotNullParameter("douyin_live", "key");
        r107.f477407w = "douyin_live";
        r107.n(StreamType.VIDEO);
        r107.O = false;
        IMiddleWareHostContext r136 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r136 == null) goto L62;
        String r137 = r136.getChannel();
    L63:
        String r138 = String.valueOf(r137);
        Intrinsics.checkNotNullParameter(r138, "channel");
        r107.f477409y = r138;
        IMiddleWareHostContext r139 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r139 == null) goto L66;
        Integer r140 = Integer.valueOf(r139.appId());
    L67:
        String r141 = String.valueOf(r140);
        Intrinsics.checkNotNullParameter(r141, "id");
        r107.f477410z = r141;
        IMiddleWareHostContext r142 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r142 == null) goto L70;
        String r143 = r142.getVersionCode();
    L71:
        String r144 = String.valueOf(r143);
        Intrinsics.checkNotNullParameter(r144, "version");
        r107.A = r144;
        IMiddleWareHostContext r145 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r145 == null) goto L74;
        Integer r146 = Integer.valueOf(r145.getUpdateVersionCode());
    L75:
        String r147 = String.valueOf(r146);
        Intrinsics.checkNotNullParameter(r147, "version");
        r107.B = r147;
        r107.h(r110.getOpenPlatformContext().getContext());
        r107.W = false;
        r107.f477400p = true;
        LiveWrappedMixedStreamPushMode r148 = LiveWrappedMixedStreamPushMode.ON_START_REQUEST;
        Intrinsics.checkNotNullParameter(r148, "mTargetPushStreamMode");
        r107.f477401q = r148;
        if (r103 == null) goto L82;
        j<com.bytedance.android.live.pushstream.d> r149 = r103.getLiveStream();
        if (r149 == null) goto L82;
        com.bytedance.android.live.pushstream.d r150 = r149.getValue();
        if (r150 == null) goto L82;
        ei6.a r151 = r150.g1(r107);
    L83:
        r110.f85162b = r151;
        if (r151 == null) goto L91;
        si6.b r152 = r151.b();
        if (r152 == null) goto L91;
        if (r122 == null) goto L89;
        String r153 = r122.f59526k;
    L90:
        r152.g(r153);
        goto L91
    L89:
        r153 = null;
    L91:
        ei6.a r154 = r110.f85162b;
        if (r154 == null) goto L98;
        xi6.c r155 = r154.t();
        if (r155 == null) goto L98;
        com.bytedance.live.livelink.kmp.impl.core.video.b r156 = r155.f();
        if (r156 == null) goto L98;
        r156.j(true);
    L98:
        ei6.a r157 = r110.f85162b;
        if (r157 == null) goto L103;
        gi6.e r158 = r157.getEventManager();
        if (r158 == null) goto L103;
        r158.b((LiveMgXplayRtcContextService$mRtcListener$2.AnonymousClass1) r110.f85170j.getValue());
    L103:
        ei6.a r159 = r110.f85162b;
        if (r159 == null) goto L110;
        gi6.e r160 = r159.getEventManager();
        if (r160 == null) goto L110;
        String r161 = r160.a(EventCategory.RTC_ENGINE_EVENT, null, new LiveMgXplayRtcContextService$joinRTCRoom$2(r110));
        if (r161 == null) goto L110;
        r110.f85165e.add(r161);
    L110:
        ei6.a r162 = r110.f85162b;
        if (r162 == null) goto L115;
        vi6.a r163 = r162.v();
        if (r163 == null) goto L115;
        r163.f();
    L115:
        ei6.a r164 = r110.f85162b;
        if (r164 == null) goto L120;
        si6.b r165 = r164.b();
        if (r165 == null) goto L120;
        si6.a.a(r165, bj6.a.b(r110.f85162b), false, 14);
    L120:
        r110.f85163c = true;
        qo0.a.c("LiveMgXplayRtcContextService", "joinRTCRoom");
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r166 = AnchorMiniGameDataContext.a.a();
        if (r166 == null) goto L129;
        m<Rect> r167 = r166.getLittleWindowRect();
        if (r167 == null) goto L129;
        Observable<Rect> r168 = r167.a();
        if (r168 == null) goto L129;
        Disposable r169 = r168.subscribe(new com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame.a(r110));
        if (r169 == null) goto L129;
        r110.autoDispose(r169);
    L129:
        if (r111 == false) goto L137;
        r110.h("1", "", "", "localFirstFrame");
        return;
    L137:
        return;
    L82:
        r151 = null;
        goto L83
    L74:
        r146 = null;
        goto L75
    L70:
        r143 = null;
        goto L71
    L66:
        r140 = null;
        goto L67
    L62:
        r137 = null;
    L58:
        r134 = null;
    L48:
        r122 = null;
    L31:
        th = move-exception;
        Result.Companion r170 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L27:
        r113 = null;
        goto L28
    L138:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final void h(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "errCode");
        Intrinsics.checkNotNullParameter(r102, "errMsg");
        Intrinsics.checkNotNullParameter(r103, "phase");
        AnchorMiniGameAppLogContextService r104 = this.f85168h;
        HashMap<String, String> r105 = new HashMap();
        r105.put("status", r100);
        r105.put("error_code", r101);
        r105.put("error_msg", r102);
        r105.put("phase", r103);
        Unit r106 = Unit.INSTANCE;
        r104.reportLiveRoomMgAppLog("live_mg_server_merge_start", r105);
    }
}
