package com.bytedance.android.gamecp.business.props;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.gamecp.base.network.exception.ApiServerException;
import com.bytedance.android.gamecp.business.api.GamePromoteApi;
import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import com.bytedance.android.gamecp.common.utils.LiveBroadcastBaseClient;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.a1;
import com.bytedance.android.gamecp.common.utils.l1;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.android.gamecp.common.utils.s1;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.common.utility.Logger;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wu.o3;

/* JADX INFO: loaded from: classes44.dex */
public final class j {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f56352m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wt.g f56354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f56355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f56356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f56357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f56358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.props.b f56359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.gamecp.common.ui.k f56360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f56361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f56362j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f56363k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f56364l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f56365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ wt.c f56366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Boolean f56367c;

        public b(j r100, wt.c r101, Boolean r102) {
            this.f56365a = r100;
            this.f56366b = r101;
            this.f56367c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.gamecp.base.network.response.i r101 = (com.bytedance.android.gamecp.base.network.response.i) r100;
            j.a(this.f56365a);
            j r102 = this.f56365a;
            wt.g r103 = r102.f56354b;
            if (r103 == null) goto L5;
            r103.accountInfo = this.f56366b;
        L5:
            com.bytedance.android.gamecp.business.props.b r104 = r102.f56359g;
            if (r104 == null) goto L9;
            r104.u0(this.f56366b);
        L9:
            if (Intrinsics.areEqual(this.f56367c, Boolean.TRUE) == false) goto L11;
            ToastUtil.a(R.string.ttlive_game_promote_prop_account_has_bind_tip);
        L11:
            LiveTracingMonitor.EventModule r105 = com.bytedance.android.gamecp.common.utils.t.f57302a;
            JSONObject r106 = this.f56365a.g();
            r106.put("error_code", 0);
            Unit r107 = Unit.INSTANCE;
            JSONObject r108 = new JSONObject();
            r108.put("guid", this.f56366b.guid);
            com.bytedance.android.gamecp.common.utils.t.c(MediaPlayer.MEDIA_PLAYER_OPTION_CREATE_AUDIOTRACK_EARLY, r106, r108);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f56368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ wt.c f56369b;

        public c(j r100, wt.c r101) {
            this.f56368a = r100;
            this.f56369b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            yr.c.b("bindGameAccountInfo", "error: " + r101);
            LiveTracingMonitor.EventModule r102 = com.bytedance.android.gamecp.common.utils.t.f57302a;
            JSONObject r103 = this.f56368a.g();
            r103.put("error_code", l1.a(r101));
            Unit r104 = Unit.INSTANCE;
            JSONObject r105 = new JSONObject();
            r105.put("guid", this.f56369b.guid);
            com.bytedance.android.gamecp.common.utils.t.c(MediaPlayer.MEDIA_PLAYER_OPTION_CREATE_AUDIOTRACK_EARLY, r103, r105);
            j.a(this.f56368a);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f56370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Room f56371b;

        public d(j r100, Room r101) {
            this.f56370a = r100;
            this.f56371b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.gamecp.base.network.response.i r111 = (com.bytedance.android.gamecp.base.network.response.i) r110;
            LiveTracingMonitor.EventModule r100 = com.bytedance.android.gamecp.common.utils.t.f57302a;
            JSONObject r101 = this.f56370a.g();
            boolean r102 = false;
            r101.put("error_code", 0);
            wt.b r103 = ((wt.a) r111.data).checkResultInfo;
            String r104 = null;
            if (r103 == null) goto L5;
            Integer r105 = r103.checkCode;
        L6:
            r101.put("check_code", r105);
            Unit r106 = Unit.INSTANCE;
            JSONObject r107 = new JSONObject();
            wt.g r108 = this.f56370a.f56354b;
            if (r108 == null) goto L11;
            wt.e r109 = r108.gamePropInfo;
            if (r109 == null) goto L11;
            Long r112 = r109.skuId;
        L12:
            r107.put(com.bytedance.android.ec.core.event.a.KEY_SKU_ID, r112);
            Room r113 = this.f56371b;
            if (r113 == null) goto L15;
            Long r114 = r113.getRoomId();
        L16:
            r107.put("room_id", r114);
            com.bytedance.android.gamecp.common.utils.t.c(MediaPlayer.MEDIA_PLAYER_OPTION_EXTEND_CODEC_NUMS, r101, r107);
            j.a(this.f56370a);
            j r115 = this.f56370a;
            wt.a r116 = (wt.a) r111.data;
            r115.getClass();
            wt.b r117 = r116.checkResultInfo;
            if (r117 == null) goto L19;
            Integer r118 = r117.checkCode;
        L20:
            String r119 = "";
            if (r118 != null) goto L24;
        L36:
            if (r118 != null) goto L39;
        L41:
            if (r118 != null) goto L44;
        L59:
            if (r118 != null) goto L62;
        L77:
            if (r118 == null) goto L80;
            r118.intValue();
        L80:
            JSONObject r120 = r115.g();
            JSONObject r121 = new JSONObject();
            r121.put("order_id", r116.orderId);
            com.bytedance.android.gamecp.common.utils.t.c(MediaPlayer.MEDIA_PLAYER_OPTION_CODECPOOL_RESPONSE, r120, r121);
            bw.b r122 = com.bytedance.android.gamecp.host_api.a.b().getHostAppService();
            Context r123 = r115.f56358f;
            String r124 = String.valueOf(com.bytedance.android.gamecp.host_api.a.b().getHostContext().hostAppId());
            String r125 = com.bytedance.android.gamecp.host_api.a.b().getHostContext().M();
            LinkedHashMap r126 = new LinkedHashMap();
            bw.d r127 = com.bytedance.android.gamecp.host_api.a.b().getHostContext();
            if (r127 == null) goto L84;
            String r128 = r127.getChannel();
            if (r128 == null) goto L84;
        L85:
            r126.put("channel", r128);
            String r129 = r116.cashierParam;
            LinkedHashMap r130 = new LinkedHashMap();
            if (r129 == null) goto L92;
            JSONObject r131 = new JSONObject(r129);
            Iterator<String> r132 = r131.keys();
        L90:
            if (r132.hasNext() == false) goto L92;
            String r133 = r132.next();
            r130.put(r133, r131.optString(r133));
        L92:
            LinkedHashMap r134 = new LinkedHashMap();
            String r135 = com.bytedance.android.gamecp.host_api.a.b().getHostAppService().getSessionId();
            if (r135 == null) goto L96;
            r119 = r135;
        L96:
            r134.put(InteractConst.INTENT_SESSION_ID, r119);
            r122.G1(r123, r124, r125, r126, r130, r134, new k(r115, r116));
            return;
        L84:
            r128 = "";
            goto L85
        L62:
            if (r118.intValue() != 4) goto L77;
            wt.b r136 = r116.checkResultInfo;
            if (r136 == null) goto L69;
            String r137 = r136.scene;
            if (r137 == null) goto L69;
            String r138 = r137;
        L70:
            if (r136 == null) goto L75;
            String r139 = r136.flow;
            if (r139 == null) goto L75;
            String r140 = r139;
        L76:
            com.bytedance.android.gamecp.host_api.a.b().getLiveService().s2(s1.a(r115.f56358f), r138, r140, true, new r(r115));
            return;
        L75:
            r140 = "";
        L69:
            r138 = "";
            goto L70
        L44:
            if (r118.intValue() != 3) goto L59;
            wt.b r141 = r116.checkResultInfo;
            if (r141 == null) goto L51;
            String r142 = r141.scene;
            if (r142 == null) goto L51;
            String r143 = r142;
        L52:
            if (r141 == null) goto L57;
            String r144 = r141.flow;
            if (r144 == null) goto L57;
            String r145 = r144;
        L58:
            com.bytedance.android.gamecp.host_api.a.b().getLiveService().s2(s1.a(r115.f56358f), r143, r145, false, new r(r115));
            return;
        L57:
            r145 = "";
        L51:
            r143 = "";
            goto L52
        L39:
            if (r118.intValue() != 2) goto L41;
        L24:
            if (r118.intValue() != 1) goto L36;
            wt.b r146 = r116.checkResultInfo;
            if (r146 == null) goto L80;
            String r147 = r146.verifyDecisionDetail;
            if (r147 == null) goto L80;
            if (r147.length() <= 0) goto L32;
            r102 = true;
        L32:
            if (r102 == false) goto L34;
            r104 = r147;
        L34:
            if (r104 == null) goto L80;
            Context r148 = r115.f56358f;
            Logger.d("showCaptchaV2", "showVerifyCodeDialog, sharkDecision=".concat(r104));
            com.bytedance.android.gamecp.common.utils.t.b(MediaPlayer.MEDIA_PLAYER_OPTION_USER_EXIT_TIME, r115.g());
            com.bytedance.android.gamecp.host_api.a.b().getHostVerifyService().Z1(s1.a(r148), r104, new t(r115));
            return;
        L19:
            r118 = null;
            goto L20
        L15:
            r114 = null;
        L11:
            r112 = null;
            goto L12
        L5:
            r105 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f56372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Room f56373b;

        public e(j r100, Room r101) {
            this.f56372a = r100;
            this.f56373b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            yr.c.b("buyGoods", "error: " + r101);
            LiveTracingMonitor.EventModule r102 = com.bytedance.android.gamecp.common.utils.t.f57302a;
            JSONObject r103 = this.f56372a.g();
            r103.put("error_code", l1.a(r101));
            Unit r104 = Unit.INSTANCE;
            JSONObject r105 = new JSONObject();
            wt.g r106 = this.f56372a.f56354b;
            String r107 = null;
            if (r106 == null) goto L7;
            wt.e r108 = r106.gamePropInfo;
            if (r108 == null) goto L7;
            Long r109 = r108.skuId;
        L8:
            r105.put("skuId", r109);
            Room r110 = this.f56373b;
            if (r110 == null) goto L11;
            Long r111 = r110.getRoomId();
        L12:
            r105.put("room_id", r111);
            com.bytedance.android.gamecp.common.utils.t.c(MediaPlayer.MEDIA_PLAYER_OPTION_EXTEND_CODEC_NUMS, r103, r105);
            if ((r101 instanceof ApiServerException) == true) goto L15;
            r101 = null;
        L15:
            ApiServerException r112 = (ApiServerException) r101;
            if (r112 == null) goto L27;
            String r113 = r112.getPrompt();
            if (r113 == null) goto L27;
            if (r113.length() <= 0) goto L22;
            boolean r114 = true;
        L23:
            if (r114 == false) goto L25;
            r107 = r113;
        L25:
            if (r107 == null) goto L27;
            ToastUtil.b(r107, 0);
            goto L27
        L22:
            r114 = false;
        L27:
            j.a(this.f56372a);
            return;
        L11:
            r111 = null;
        L7:
            r109 = null;
            goto L8
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f56374a;

        public f(j r100) {
            this.f56374a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.gamecp.base.network.response.i r101 = (com.bytedance.android.gamecp.base.network.response.i) r100;
            j r102 = this.f56374a;
            wt.g r103 = (wt.g) r101.data;
            r102.f56354b = r103;
            com.bytedance.android.gamecp.business.props.b r104 = r102.f56359g;
            if (r104 == null) goto L5;
            r104.o0(r103);
        L5:
            LiveTracingMonitor.EventModule r105 = com.bytedance.android.gamecp.common.utils.t.f57302a;
            JSONObject r106 = this.f56374a.g();
            wt.c r107 = ((wt.g) r101.data).accountInfo;
            if (r107 != null) goto L8;
        L10:
            int r108 = 0;
        L11:
            r106.put("has_account", r108);
            r106.put("error_code", 0);
            Unit r109 = Unit.INSTANCE;
            JSONObject r110 = new JSONObject();
            r110.put("load_duration", System.currentTimeMillis() - this.f56374a.f56355c);
            com.bytedance.android.gamecp.common.utils.t.a(MediaPlayer.MEDIA_PLAYER_OPTION_FLUSH_WHEN_SETSURFACE, r106, r110, null, LiveTracingMonitor.EventType.SERVER_API_CALL);
            return;
        L8:
            if (r107.guid == null) goto L10;
            r108 = 1;
            goto L11
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f56375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f56376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f56377c;

        public g(j r100, String r101, String r102) {
            this.f56375a = r100;
            this.f56376b = r101;
            this.f56377c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            yr.c.b("fetchDetailInfo", "error: " + r101);
            LiveTracingMonitor.EventModule r102 = com.bytedance.android.gamecp.common.utils.t.f57302a;
            JSONObject r103 = this.f56375a.g();
            r103.put("error_code", l1.a(r101));
            r103.put("game_id", this.f56376b);
            r103.put("prop_id", this.f56377c);
            Unit r104 = Unit.INSTANCE;
            JSONObject r105 = new JSONObject();
            r105.put("load_duration", System.currentTimeMillis() - this.f56375a.f56355c);
            com.bytedance.android.gamecp.common.utils.t.a(MediaPlayer.MEDIA_PLAYER_OPTION_FLUSH_WHEN_SETSURFACE, r103, r105, null, LiveTracingMonitor.EventType.SERVER_API_CALL);
            com.bytedance.android.gamecp.business.props.b r106 = this.f56375a.f56359g;
            if (r106 == null) goto L6;
            r106.u();
        L6:
            if ((r101 instanceof ApiServerException) == false) goto L16;
            ApiServerException r107 = (ApiServerException) r101;
            String r108 = r107.getPrompt();
            if (r108 == null) goto L16;
            if (r108.length() <= 0) goto L12;
            boolean r109 = true;
        L13:
            if (r109 != true) goto L16;
            ToastUtil.b(r107.getPrompt(), 0);
            goto L16
        L12:
            r109 = false;
        L16:
            if (l1.a(r101) != 4014091) goto L18;
        L19:
            com.bytedance.android.gamecp.business.props.b r110 = this.f56375a.f56359g;
            if (r110 == null) goto L24;
            r110.R();
            return;
        L24:
            return;
        L18:
            if (l1.a(r101) == 4014093) goto L19;
        }
    }

    static {
    }

    public final JSONObject g() {
        JSONObject r100 = new JSONObject();
        wt.g r101 = this.f56354b;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.gameId;
    L6:
        r100.put("game_id", r103);
        wt.g r104 = this.f56354b;
        if (r104 == null) goto L9;
        String r105 = r104.gameName;
    L10:
        r100.put(EventConstants.ExtraJson.GAME_NAME, r105);
        wt.g r106 = this.f56354b;
        if (r106 == null) goto L15;
        wt.e r107 = r106.gamePropInfo;
        if (r107 == null) goto L15;
        String r108 = r107.propId;
    L16:
        r100.put("prop_id", r108);
        wt.g r109 = this.f56354b;
        if (r109 == null) goto L21;
        wt.e r110 = r109.gamePropInfo;
        if (r110 == null) goto L21;
        r102 = r110.propName;
    L21:
        r100.put("prod_name", r102);
        return r100;
    L15:
        r108 = null;
        goto L16
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final void h() {
        com.bytedance.android.gamecp.common.ui.k r100 = this.f56360h;
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public final void e() {
        h();
        Room r100 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        Lazy r101 = LiveBroadcastBaseClient.f57176a;
        GamePromoteApi r102 = (GamePromoteApi) LiveBroadcastBaseClient.a(GamePromoteApi.class);
        String r103 = this.f56363k;
        wt.g r104 = this.f56354b;
        Long r105 = null;
        if (r104 == null) goto L7;
        wt.e r106 = r104.gamePropInfo;
        if (r106 == null) goto L7;
        Long r107 = r106.skuId;
    L8:
        if (r100 == null) goto L10;
        Long r108 = r100.getRoomId();
    L11:
        wt.g r109 = this.f56354b;
        if (r109 == null) goto L16;
        wt.e r110 = r109.gamePropInfo;
        if (r110 == null) goto L16;
        r105 = r110.propType;
    L16:
        Observable<com.bytedance.android.gamecp.base.network.response.i<wt.a>> r111 = r102.buyGoods(r103, r107, r108, 1L, r105, Long.valueOf(this.f56364l), this.f56356d, this.f56357e).observeOn(AndroidSchedulers.mainThread());
        if (r111 == null) goto L22;
        Disposable r112 = r111.subscribe(new d(this, r100), new e(this, r100));
        if (r112 == null) goto L23;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r112, this.f56361i);
        return;
    L23:
        return;
    L22:
        return;
    L10:
        r108 = null;
    L7:
        r107 = null;
        goto L8
    }

    public static final void a(j r100) {
        com.bytedance.android.gamecp.common.ui.k r101 = r100.f56360h;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r103 == null) goto L16;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r102.getLooper()) goto L7;
        r102.post(DialogLancet.createDismissRunnable(r101));
    }

    public static final void c(j r100) {
        long r101 = r100.f56362j;
        if (r101 != 1) goto L5;
        return;
    L5:
        if (r101 != 3) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(o3.f561363a.getValue(), Boolean.FALSE) == false) goto L11;
        return;
    L11:
        if (a1.b().getInt("live.pref.SHOW_PLAYER_RANK_SETTING_PROP_DIALOG", 1) != 1) goto L17;
        a1.a().putInt("live.pref.SHOW_PLAYER_RANK_SETTING_PROP_DIALOG", 0).apply();
        xr.f r102 = (xr.f) xr.s.a(xr.f.class);
        if (r102 == null) goto L18;
        r102.Z("live_prop", new s(r100));
        return;
    L18:
        return;
    }

    public final void f(String r100, String r110) {
        this.f56355c = System.currentTimeMillis();
        Room r101 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        Lazy r102 = LiveBroadcastBaseClient.f57176a;
        GamePromoteApi r103 = (GamePromoteApi) LiveBroadcastBaseClient.a(GamePromoteApi.class);
        String r104 = this.f56363k;
        if (r101 == null) goto L5;
        Long r105 = r101.getRoomId();
    L6:
        Observable<com.bytedance.android.gamecp.base.network.response.i<wt.g>> r106 = r103.getPropDetail(r104, r100, r105, r110, Long.valueOf(this.f56362j)).observeOn(AndroidSchedulers.mainThread());
        if (r106 == null) goto L12;
        Disposable r107 = r106.subscribe(new f(this), new g(this, r110, r100));
        if (r107 == null) goto L13;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r107, this.f56361i);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public static final void b(final j r100, boolean r101, wt.a r102) {
        r100.getClass();
        int r103 = 1;
        if (r101 == false) goto L13;
        jv.a.a().b(new rs.b());
        jv.a.a().b(new com.bytedance.android.gamecp.business.gamedetail.g());
        jv.a.a().b(new rs.a());
        if ((!p0.a()) == true) goto L8;
        bw.i r104 = com.bytedance.android.gamecp.host_api.a.b().getLiveService();
        int r105 = bw.v.f20979a;
        r104.D();
    L8:
        if (GameCpTargetUtils.b() == false) goto L10;
        com.bytedance.android.gamecp.common.utils.rxutils.e.b(com.bytedance.android.gamecp.host_api.a.b().getBrowserService().registerJsEventSubscriber("ticket_buy_result_jump_room").observeOn(AndroidSchedulers.mainThread()), new PropDetailPresenter$onQueryOrderStatusResult$1(r100));
        com.bytedance.android.gamecp.common.utils.rxutils.e.b(com.bytedance.android.gamecp.host_api.a.b().getBrowserService().registerJsEventSubscriber("ticket_buy_result_close").observeOn(AndroidSchedulers.mainThread()), new PropDetailPresenter$onQueryOrderStatusResult$2(r100));
        com.bytedance.android.gamecp.common.utils.rxutils.e.b(com.bytedance.android.gamecp.host_api.a.b().getBrowserService().registerJsEventSubscriber("ticket_order_detail_close").observeOn(AndroidSchedulers.mainThread()), new PropDetailPresenter$onQueryOrderStatusResult$3(r100));
    L10:
        com.bytedance.android.gamecp.host_api.a.b().getActionHandleService().handle(r100.f56358f, r102.payResultLink);
        com.bytedance.android.gamecp.business.props.b r106 = r100.f56359g;
        if (r106 == null) goto L14;
        r106.R();
    L14:
        LiveTracingMonitor.EventModule r107 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r108 = new JSONObject();
        wt.g r109 = r100.f56354b;
        String r110 = null;
        if (r109 == null) goto L17;
        String r111 = r109.gameId;
    L18:
        r108.put("game_id", r111);
        wt.g r112 = r100.f56354b;
        if (r112 == null) goto L21;
        String r113 = r112.gameName;
    L22:
        r108.put(EventConstants.ExtraJson.GAME_NAME, r113);
        wt.g r114 = r100.f56354b;
        if (r114 == null) goto L27;
        wt.e r115 = r114.gamePropInfo;
        if (r115 == null) goto L27;
        String r116 = r115.propId;
    L28:
        r108.put("prop_id", r116);
        wt.g r117 = r100.f56354b;
        if (r117 == null) goto L33;
        wt.e r118 = r117.gamePropInfo;
        if (r118 == null) goto L33;
        r110 = r118.propName;
    L33:
        r108.put("prop_name", r110);
        if (r101 == true) goto L37;
        r103 = 2;
    L37:
        r108.put("jump_type", r103);
        Unit r119 = Unit.INSTANCE;
        JSONObject r120 = new JSONObject();
        if (r101 == false) goto L40;
        String r121 = r102.payResultLink;
    L41:
        r120.put("jump_link", r121);
        com.bytedance.android.gamecp.common.utils.t.c(MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_NUMS_IN_MEDIACODEC, r108, r120);
        return;
    L40:
        r121 = r102.orderDetailLink;
    L27:
        r116 = null;
        goto L28
    L21:
        r113 = null;
        goto L22
    L17:
        r111 = null;
        goto L18
    L13:
        com.bytedance.android.gamecp.host_api.a.b().getActionHandleService().handle(r100.f56358f, r102.orderDetailLink);
        goto L14
    }

    public final void d(wt.c r110, Boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "info");
        h();
        Lazy r100 = LiveBroadcastBaseClient.f57176a;
        Observable<com.bytedance.android.gamecp.base.network.response.i<Object>> r113 = ((GamePromoteApi) LiveBroadcastBaseClient.a(GamePromoteApi.class)).bindAccountInfo(r110.gameId, r110.guid, r110.nickName, r110.avatarIcon, r110.serviceId, r110.serviceName, r110.realRoleId, r112).observeOn(AndroidSchedulers.mainThread());
        if (r113 == null) goto L8;
        Disposable r114 = r113.subscribe(new b(this, r110, r111), new c(this, r110));
        if (r114 == null) goto L9;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r114, this.f56361i);
        return;
    L9:
        return;
    }

    public j(Context r100, com.bytedance.android.gamecp.business.props.b r101, com.bytedance.android.gamecp.common.ui.k r102, CompositeDisposable r103, long r104, String r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r102, "mLoadingDialog");
        Intrinsics.checkNotNullParameter(r103, "mCompositeDisposable");
        Intrinsics.checkNotNullParameter(r105, "mAnchorId");
        this.f56358f = r100;
        this.f56359g = r101;
        this.f56360h = r102;
        this.f56361i = r103;
        this.f56362j = r104;
        this.f56363k = r105;
        this.f56364l = r106;
        this.f56353a = "PropDetailPresenter";
        this.f56357e = 0L;
    }
}
