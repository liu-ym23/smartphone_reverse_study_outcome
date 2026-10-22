package com.bytedance.android.gamecp.live_impl.timer;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.common.utils.t;
import com.bytedance.android.gamecp.host_api.model.introducecard.IntroduceShowType;
import com.bytedance.android.gamecp.host_api.model.introducecard.g;
import com.bytedance.android.gamecp.live_impl.RoomContext;
import com.bytedance.android.gamecp.live_impl.card.GamePromoteCardLogger;
import com.bytedance.android.gamecp.live_impl.preview.CardAnimationControllerPreView;
import com.bytedance.android.gamecp.live_impl.preview.e;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xr.f;
import xr.p;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class GameCardShowTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f57931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f57932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f57933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CardAnimationControllerPreView f57934d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/timer/GameCardShowTimer$TimerIntroFailReason;", "", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "CAN_SHOW", "CARD_SHOWING", "CARD_TYPE_NOT_GAME", "TIMES_LIMIT", "CARD_REVERSE_ORDER", "CARD_REVERSE_ARCHITECTURE_OLD_INTERCEPTED", "CARD_SMART_NOT_SUPPORT", "CARD_CLOSE_BY_MANUAL", "CARD_REQUEST_ERROR_1037", "APP_INSTALLED", "APP_DOWNLOADED", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TimerIntroFailReason extends Enum<TimerIntroFailReason> {
        public static final TimerIntroFailReason APP_DOWNLOADED = null;
        public static final TimerIntroFailReason APP_INSTALLED = null;
        public static final TimerIntroFailReason CAN_SHOW = null;
        public static final TimerIntroFailReason CARD_CLOSE_BY_MANUAL = null;
        public static final TimerIntroFailReason CARD_REQUEST_ERROR_1037 = null;
        public static final TimerIntroFailReason CARD_REVERSE_ARCHITECTURE_OLD_INTERCEPTED = null;
        public static final TimerIntroFailReason CARD_REVERSE_ORDER = null;
        public static final TimerIntroFailReason CARD_SHOWING = null;
        public static final TimerIntroFailReason CARD_SMART_NOT_SUPPORT = null;
        public static final TimerIntroFailReason CARD_TYPE_NOT_GAME = null;
        public static final TimerIntroFailReason TIMES_LIMIT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimerIntroFailReason[] f57935a = null;
        private final String msg;

        public static TimerIntroFailReason valueOf(String r100) {
            return (TimerIntroFailReason) r27.a.a(TimerIntroFailReason.class, r100);
        }

        public static TimerIntroFailReason[] values() {
            return (TimerIntroFailReason[]) f57935a.clone();
        }

        static {
            TimerIntroFailReason r100 = new TimerIntroFailReason("CAN_SHOW", 0, "can_show");
            CAN_SHOW = r100;
            TimerIntroFailReason r101 = new TimerIntroFailReason("CARD_SHOWING", 1, "card_showing");
            CARD_SHOWING = r101;
            TimerIntroFailReason r102 = new TimerIntroFailReason("CARD_TYPE_NOT_GAME", 2, "card_type_not_game");
            CARD_TYPE_NOT_GAME = r102;
            TimerIntroFailReason r103 = new TimerIntroFailReason("TIMES_LIMIT", 3, "times_limit");
            TIMES_LIMIT = r103;
            TimerIntroFailReason r104 = new TimerIntroFailReason("CARD_REVERSE_ORDER", 4, "has_reversed");
            CARD_REVERSE_ORDER = r104;
            TimerIntroFailReason r105 = new TimerIntroFailReason("CARD_REVERSE_ARCHITECTURE_OLD_INTERCEPTED", 5, "card_reverse_architecture_old_intercepted");
            CARD_REVERSE_ARCHITECTURE_OLD_INTERCEPTED = r105;
            TimerIntroFailReason r106 = new TimerIntroFailReason("CARD_SMART_NOT_SUPPORT", 6, "smart_card_not_support");
            CARD_SMART_NOT_SUPPORT = r106;
            TimerIntroFailReason r107 = new TimerIntroFailReason("CARD_CLOSE_BY_MANUAL", 7, "card_close_by_manual");
            CARD_CLOSE_BY_MANUAL = r107;
            TimerIntroFailReason r108 = new TimerIntroFailReason("CARD_REQUEST_ERROR_1037", 8, "card_request_error_1037");
            CARD_REQUEST_ERROR_1037 = r108;
            TimerIntroFailReason r109 = new TimerIntroFailReason("APP_INSTALLED", 9, "app_installed");
            APP_INSTALLED = r109;
            TimerIntroFailReason r110 = new TimerIntroFailReason("APP_DOWNLOADED", 10, "app_downloaded");
            APP_DOWNLOADED = r110;
            f57935a = new TimerIntroFailReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
        }

        public final String getMsg() {
            return this.msg;
        }

        public TimerIntroFailReason(String r100, int r101, String r102) {
            super(r100, r101);
            this.msg = r102;
        }
    }

    public final void f() {
        LocalTestManager.a(new Class[]{uv.a.class});
        Disposable r100 = this.f57932b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f57933c.clear();
        this.f57931a = false;
    }

    public final String a() {
        Object r100 = null;
        if (e.b(this.f57934d.f57913u) == false) goto L19;
        mw.a r101 = (mw.a) s.a(mw.a.class);
        if (r101 == null) goto L7;
        CardAnimationControllerPreView r102 = this.f57934d;
        Map<String, Object> r103 = r101.getPreviewTrackParams(r102.f57911s, r102.f57912t, r102.f57913u.name());
    L8:
        if (r103 == null) goto L10;
        Object r104 = r103.get("adId");
    L12:
        if ((r104 instanceof String) == false) goto L15;
        r100 = r104;
    L15:
        String r105 = (String) r100;
        if (r105 != null) goto L26;
        return "";
    L26:
        return r105;
    L10:
        r104 = null;
        goto L12
    L7:
        r103 = null;
        goto L8
    L19:
        Map<String, Object> r106 = com.bytedance.android.gamecp.host_api.a.b().getLogService().getAdLogExtra();
        if (r106 == null) goto L23;
        r100 = r106.get("adId");
    L23:
        if ((r100 instanceof String) == true) goto L25;
        return "";
    L25:
        return (String) r100;
    }

    public final RoomContext b() {
        RoomContext.a r100 = RoomContext.Companion;
        CardAnimationControllerPreView r101 = this.f57934d;
        String r102 = r101.f57911s;
        String r103 = r101.f57912t;
        String r104 = r101.f57913u.name();
        r100.getClass();
        return RoomContext.a.b(r102, r103, r104);
    }

    public GameCardShowTimer(CardAnimationControllerPreView r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        this.f57934d = r100;
        this.f57933c = new CompositeDisposable();
    }

    public static void e(g r110, TimerIntroFailReason r111) {
        if (r111 != TimerIntroFailReason.CAN_SHOW) goto L5;
        return;
    L5:
        String r100 = GamePromoteCardLogger.f57827c;
        GamePromoteCardLogger.b(r110, r111.getMsg());
        JSONObject r101 = new JSONObject();
        r101.put("previous_page", "start_page");
        String r102 = "";
        r101.put("previous_page_attr", "");
        JSONObject r103 = new JSONObject();
        r103.put("current_page", "live_detail");
        JSONObject r104 = new JSONObject();
        r104.put("show_time", "live");
        if (r110 == null) goto L13;
        IntroduceShowType r112 = r110.f57386f;
        if (r112 == null) goto L13;
        String r113 = r112.getType();
        if (r113 == null) goto L13;
        r102 = r113;
    L13:
        r104.put("show_type", r102);
        r104.put("status", "fail");
        r104.put("reason", r111);
        f r114 = (f) s.a(f.class);
        if (r114 == null) goto L18;
        p r115 = r114.getTrackService();
        if (r115 == null) goto L18;
        r115.f(MapsKt.mapOf(new Pair[]{TuplesKt.to(CloudControlInf.ROUTE, r101.toString()), TuplesKt.to("location", r103.toString()), TuplesKt.to("module_name", "game_ad"), TuplesKt.to(SlcElement.KEY_ATTR, r104.toString())}));
    L18:
        f r116 = (f) s.a(f.class);
        if (r116 == null) goto L24;
        p r117 = r116.getTrackService();
        if (r117 == null) goto L25;
        r117.f(MapsKt.mapOf(new Pair[]{TuplesKt.to(CloudControlInf.ROUTE, r101.toString()), TuplesKt.to("location", r103.toString()), TuplesKt.to("product_type", "game_ad_request_result"), TuplesKt.to(SlcElement.KEY_ATTR, r104.toString())}));
        return;
    L25:
        return;
    }

    public final void d(int r100, g r101, TimerIntroFailReason r102) {
        LiveTracingMonitor.EventModule r103 = t.f57302a;
        JSONObject r104 = new JSONObject();
        r104.put("game_id", com.bytedance.android.gamecp.common.utils.s.a(r101));
        r104.put(EventConstants.ExtraJson.GAME_NAME, com.bytedance.android.gamecp.common.utils.s.b(r101));
        if (r102 != null) goto L5;
    L7:
        Unit r105 = Unit.INSTANCE;
        JSONObject r106 = new JSONObject();
        RoomContext r107 = b();
        if (r107 == null) goto L10;
        long r108 = r107.getTimerCurLoopCount();
    L11:
        r106.put("show_times", r108);
        r106.put("ad_plan_id", a());
        t.c(r100, r104, r106);
        return;
    L10:
        r108 = 0;
        goto L11
    L5:
        if (r102 == TimerIntroFailReason.CAN_SHOW) goto L7;
        r104.put("fail_reason", r102.getMsg());
        goto L7
    }

    public static void c(GameCardShowTimer r100, String r101, g r102, TimerIntroFailReason r103, String r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = null;
    L8:
        r100.getClass();
        JSONObject r106 = new JSONObject();
        r106.put("game_id", com.bytedance.android.gamecp.common.utils.s.a(r102));
        r106.put(EventConstants.ExtraJson.GAME_NAME, com.bytedance.android.gamecp.common.utils.s.b(r102));
        if (r103 == null) goto L14;
        if (r103 == TimerIntroFailReason.CAN_SHOW) goto L14;
        r106.put("fail_reason", r103.getMsg());
    L16:
        RoomContext r107 = r100.b();
        if (r107 == null) goto L19;
        long r108 = r107.getTimerCurLoopCount();
    L20:
        r106.put("show_times", r108);
        r106.put("ad_plan_id", r100.a());
        Unit r109 = Unit.INSTANCE;
        yr.c.e(r101, r106.toString());
        return;
    L19:
        r108 = 0;
    L14:
        if (UtilsKt.c(r104) == false) goto L16;
        r106.put("fail_reason", r104);
        goto L16
    }
}
