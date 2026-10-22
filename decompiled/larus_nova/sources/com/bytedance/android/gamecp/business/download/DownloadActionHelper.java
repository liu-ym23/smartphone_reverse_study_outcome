package com.bytedance.android.gamecp.business.download;

import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.business.GamePromoteTrack;
import com.bytedance.android.gamecp.business.GamePromoteTrackViewModel;
import com.bytedance.android.gamecp.business.api.GamePromoteApi;
import com.bytedance.android.gamecp.business.datachannelmonitorlink.DataChannelMonitorLinkHandler;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.android.gamecp.business.monitorlink.GamePromoteMonitorLinkHandler;
import com.bytedance.android.gamecp.business.patch.GameApkMd5Manager;
import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.LiveBroadcastBaseClient;
import com.bytedance.android.gamecp.common.utils.NetworkUtils;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.downloadlib.constants.DownloadConstants;
import com.ss.android.downloadlib.constants.DownloadTaskKeyConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;
import wu.a4;
import wu.f4;

/* JADX INFO: loaded from: classes44.dex */
public final class DownloadActionHelper {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, DownloadActionHelper> f52310g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f52311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f52312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f52313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f52314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f52315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f52316f;

    public static final class a {
        public static DownloadActionHelper a(Integer r100) {
            Map<String, DownloadActionHelper> r101 = DownloadActionHelper.f52310g;
            String r102 = String.valueOf(r100);
            LinkedHashMap r103 = (LinkedHashMap) r101;
            Object r104 = r103.get(r102);
            if (r104 != null) goto L6;
            r104 = new DownloadActionHelper();
            r103.put(r102, r104);
        L6:
            return (DownloadActionHelper) r104;
        }
    }

    public static final class b implements dw.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadActionHelper f52317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2 f52318b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p f52319c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f52320d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f52321e;

        @Override // dw.e
        public final void onGranted() {
            this.f52317a.f(this.f52319c, this.f52320d, this.f52321e, this.f52318b);
        }

        public b(DownloadActionHelper r100, Function2 r101, p r102, String r103, Context r104) {
            this.f52317a = r100;
            this.f52318b = r101;
            this.f52319c = r102;
            this.f52320d = r103;
            this.f52321e = r104;
        }
    }

    static {
        f52310g = new LinkedHashMap();
    }

    public DownloadActionHelper() {
        this.f52311a = new CompositeDisposable();
        this.f52312b = a4.f561280a.getValue().booleanValue();
        this.f52314d = "";
    }

    public static String d(p r100) {
        int r101 = r100.f52859m;
        if (r101 != 0) goto L5;
        String r102 = r100.f52849h;
        if (r102 != null) goto L22;
    L18:
        return "";
    L22:
        return r102;
    L5:
        if (r101 != 1) goto L7;
        String r103 = r100.f52849h;
        if (r103 == null) goto L18;
        return r103;
    L7:
        if (r101 == 2) goto L18;
        if (r101 == 3) goto L18;
        String r104 = r100.f52849h;
        if (r104 == null) goto L18;
        return r104;
    }

    public static String e(p r100) {
        int r101 = r100.f52859m;
        if (r101 != 0) goto L5;
        String r102 = r100.f52851i;
        if (r102 != null) goto L26;
    L21:
        return "";
    L26:
        return r102;
    L5:
        if (r101 != 1) goto L7;
        String r103 = r100.f52869r;
        if (r103 == null) goto L21;
        return r103;
    L7:
        if (r101 == 2) goto L21;
        if (r101 == 3) goto L13;
        String r104 = r100.f52851i;
        if (r104 == null) goto L21;
        return r104;
    L13:
        String r105 = r100.O;
        if (r105 == null) goto L21;
        return r105;
    }

    public final void g(final p r110, Context r111, final Function2<? super Boolean, ? super Pair<Integer, String>, Unit> r112) {
        if (r110.f52853j == true) goto L8;
        xr.f r100 = (xr.f) xr.s.a(xr.f.class);
        if (r100 == null) goto L8;
        r100.i1(r110.f52855k);
    L8:
        if (r110.f52853j == false) goto L10;
        int r101 = GamePromoteTrack.f51759a;
        GamePromoteTrack.a(r110.f52836a0, r110.f52855k, null, null, null, r110.f52880w0);
    L15:
        int r102 = r110.f52880w0;
        if (r102 != 0) goto L18;
    L23:
        boolean r103 = true;
    L24:
        Function0<Unit> r104 = new DownloadActionHelper$internalClick$startDownloadWithoutWifi$1(r110, r112);
        if (r103 == false) goto L43;
        f4 r105 = f4.f561310a;
        if (r110.f52854j0 > r105.getValue().d()) goto L33;
        r104.invoke();
        if (NetworkUtils.c(r111) == false) goto L48;
        ToastUtil.b(r105.getValue().e(), 0);
        return;
    L48:
        return;
    L33:
        if (NetworkUtils.c(r111) == false) goto L43;
        LiveTracingMonitor.EventModule r106 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r107 = new JSONObject();
        r107.put(EventConstants.ExtraJson.GAME_NAME, r110.f52836a0);
        r107.put("game_id", r110.f52855k);
        r107.put("url", r110.f52840c0);
        r107.put(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP, r110.f52866p0);
        Unit r108 = Unit.INSTANCE;
        com.bytedance.android.gamecp.common.utils.t.b(1020, r107);
        u0 r109 = new u0(r111, new o(r110, r112));
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        String r114 = r105.getValue().c();
        if (r114 != null) goto L37;
        r114 = "";
    L37:
        String r115 = String.format(r114, Arrays.copyOf(new Object[]{Double.valueOf(r110.f52854j0)}, 1));
        String r116 = r105.getValue().a();
        String r117 = r105.getValue().b();
        r109.f52941a = r115;
        r109.f52942b = r116;
        r109.f52943c = r117;
        if (DialogLancet.shouldBlockDialogShow(r109) == false) goto L46;
        DialogLancet.handleBlockedDialogShow(r109);
        return;
    L46:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L41:
        DialogLancet.beforeDialogShow(r109);
        r109.show();
        DialogLancet.afterDialogShow(r109);
        return;
    L43:
        r112.invoke(Boolean.TRUE, null);
        return;
    L18:
        if (r102 == 5) goto L23;
        if (r102 == 7) goto L23;
        r103 = false;
        goto L24
    L10:
        Lazy r118 = LiveBroadcastBaseClient.f57176a;
        Observable<com.bytedance.android.gamecp.base.network.response.i<com.bytedance.android.gamecp.business.api.response.e>> r119 = ((GamePromoteApi) LiveBroadcastBaseClient.a(GamePromoteApi.class)).checkSharkResult("download_begin_shark", r110.f52855k, Long.valueOf(Integer.valueOf(r110.f52880w0).intValue()), Long.valueOf(r110.f52859m)).observeOn(AndroidSchedulers.mainThread());
        if (r119 == null) goto L15;
        Disposable r120 = r119.subscribe(new i(this, r110), new j(this, r110));
        if (r120 == null) goto L15;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r120, this.f52311a);
        goto L15
    }

    public final void h(p r100, int r101, Long r102) {
        LiveTracingMonitor.EventModule r103 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r104 = new JSONObject();
        r104.put(EventConstants.ExtraJson.GAME_NAME, r100.f52836a0);
        r104.put("game_id", r100.f52855k);
        Unit r105 = Unit.INSTANCE;
        JSONObject r106 = new JSONObject();
        r106.put("old_url", this.f52314d);
        if (r101 != 1033) goto L5;
    L6:
        r106.put(BindCardPayConfirmConstants.Key.TRACE_ID, r100.B);
        r106.put("new_url", r100.f52840c0);
        r106.put("duration", r102);
    L7:
        com.bytedance.android.gamecp.common.utils.t.c(r101, r104, r106);
        return;
    L5:
        if (r101 != 1034) goto L7;
        goto L6
    }

    public static final void a(DownloadActionHelper r310, p r311, String r312, Long r313) {
        r310.getClass();
        xr.j r100 = (xr.j) xr.s.a(xr.j.class);
        Boolean r101 = null;
        if (r100 != null) goto L5;
    L15:
        boolean r102 = false;
    L16:
        DataContext r103 = com.bytedance.live.datacontext.d.d(AudienceGamePromoteDetailViewModel.class);
        if ((r103 instanceof AudienceGamePromoteDetailViewModel) == true) goto L19;
        r103 = null;
    L19:
        AudienceGamePromoteDetailViewModel r104 = (AudienceGamePromoteDetailViewModel) r103;
        int r105 = GamePromoteTrack.f51759a;
        String r106 = r311.f52836a0;
        String r107 = r311.f52855k;
        String r108 = r311.L;
        String r109 = r311.f52845f;
        String r110 = r311.f52847g;
        if (r313 == null) goto L22;
        int r111 = (int) r313.longValue();
    L23:
        boolean r112 = r311.f52853j;
        String r113 = r311.f52849h;
        String r114 = GamePromoteTrack.f("");
        if (r104 == null) goto L28;
        com.bytedance.live.datacontext.m<String> r115 = r104.getCurrentTab();
        if (r115 == null) goto L28;
        String r116 = r115.getValue();
    L29:
        if (r104 == null) goto L31;
        r101 = Boolean.valueOf(r104.isFullScreen());
    L31:
        Boolean r210 = r101;
        Integer r211 = Integer.valueOf(r311.f52859m);
        String r212 = String.valueOf(r311.f52854j0);
        String r213 = r.a(r311.f52871s);
        String r117 = r311.M;
        if (Intrinsics.areEqual(r311.f52865p, Boolean.TRUE) == false) goto L34;
        String r118 = "true";
    L35:
        GamePromoteTrack.d(r106, r107, r102, r108, r109, r110, r111, r112, r113, r312, null, "", "", r114, r116, r210, r211, null, r212, r213, r117, 0, r118, 524288);
        return;
    L34:
        r118 = "false";
    L28:
        r116 = null;
        goto L29
    L22:
        r111 = 0;
        goto L23
    L5:
        if (r100.isCardVisible() != true) goto L15;
        mw.a r119 = (mw.a) xr.s.a(mw.a.class);
        if (r119 == null) goto L11;
        com.bytedance.android.gamecp.host_api.model.introducecard.g r120 = r119.getCardData();
        if (r120 == null) goto L11;
        String r121 = r120.gameId;
    L13:
        if (Intrinsics.areEqual(r121, String.valueOf(r311.f52855k)) == false) goto L15;
        r102 = true;
    L11:
        r121 = null;
        goto L13
    }

    public final void b(Context r110, p r111, String r112, Function2<? super Boolean, ? super Pair<Integer, String>, Unit> r113) {
        if (GameCpTargetUtils.h() == false) goto L8;
        bw.e r100 = com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService();
        String r101 = r111.f52855k;
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r100.f0(r101, new b(this, r113, r111, r112, r110));
        return;
    L8:
        f(r111, r112, r110, r113);
    }

    public final void f(p r210, String r211, Context r212, Function2<? super Boolean, ? super Pair<Integer, String>, Unit> r213) {
        if (this.f52312b == true) goto L5;
    L19:
        boolean r100 = false;
    L20:
        if (r100 == false) goto L104;
        this.f52313c = true;
        String r101 = r210.f52840c0;
        String r102 = "";
        if (r101 != null) goto L24;
        r101 = "";
    L24:
        this.f52314d = r101;
        Lazy r103 = GameApkMd5Manager.f56195a;
        String r104 = r210.f52855k;
        String r105 = r210.f52860m0;
        if (r105 != null) goto L27;
        r105 = "";
    L27:
        Pair r106 = GameApkMd5Manager.e(r104, r105, "DownloadActionHelper.requestGameDownloadInfo");
        GamePromoteApi r110 = (GamePromoteApi) bs.e.a().b(GamePromoteApi.class);
        Integer r111 = Integer.valueOf(r210.f52859m);
        String r107 = r210.f52855k;
        if (r107 != null) goto L30;
        String r112 = "";
    L31:
        String r113 = d(r210);
        String r114 = e(r210);
        if (r210.f52859m != 0) goto L36;
        String r108 = r210.A0;
        if (r108 != null) goto L119;
    L43:
        r108 = SliceInitService.DEFAULT_SWITCH;
    L119:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L49
        String r115 = new JSONObject(r108).optString(DownloadConstants.KEY_EXTRA_CLICK_ID, "");     // Catch: Throwable -> L49
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L52:
        String r116 = r115;
        String r117 = r210.f52879w;
        if (r117 != null) goto L55;
        String r118 = "";
    L56:
        String r119 = r210.f52863o;
        JSONObject r120 = new JSONObject();
        String r121 = r210.f52841d.get("is_ad");
        if (r121 != null) goto L123;
    L60:
        int r122 = 0;
    L61:
        r120.put("is_ad", r122);
        String r123 = r210.f52841d.get("ad_id");
        if (r123 == null) goto L65;
        r102 = r123;
    L65:
        r120.put("ad_id", r102);
        String r124 = r210.f52841d.get("ad_source_type");
        if (r124 != null) goto L117;
    L69:
        int r125 = 0;
    L70:
        r120.put("ad_source_type", r125);
        String r126 = r210.f52841d.get("stock_type");
        if (r126 != null) goto L111;
    L74:
        int r127 = 0;
    L75:
        r120.put("stock_type", r127);
        String r128 = r210.f52841d.get("original_system_origin");
        if (r128 != null) goto L121;
    L79:
        int r129 = 0;
    L80:
        r120.put("original_system_origin", r129);
        String r130 = r210.f52841d.get("if_dou");
        if (r130 != null) goto L115;
    L84:
        int r131 = 0;
    L85:
        r120.put("if_dou", r131);
        String r132 = r120.toString();
        String r133 = r210.U;
        if (r106 == null) goto L88;
        String r214 = (String) r106.getFirst();
    L89:
        if (r106 == null) goto L91;
        Integer r215 = (Integer) r106.getSecond();
    L92:
        Observable r134 = GamePromoteApi.a.a(r110, r111, r112, r113, r114, r116, r118, r119, null, r132, r133, r211, r214, r215, 1152);
        if (r134 == null) goto L125;
        hv.b r135 = hv.d.f487273a;
        Observable r136 = r134.compose(new hv.a());
        if (r136 == null) goto L126;
        Observable r137 = r136.doOnSubscribe(new k(this, r210));
        if (r137 == null) goto L127;
        Observable r138 = r137.doFinally(new l(this, r210));
        if (r138 == null) goto L128;
        Disposable r139 = r138.subscribe(new m(this, r210, r106, r212, r213), new n(r213, r210));
        if (r139 == null) goto L129;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r139, this.f52311a);
        return;
    L129:
        return;
    L128:
        return;
    L127:
        return;
    L126:
        return;
    L125:
        return;
    L91:
        r215 = null;
        goto L92
    L88:
        r214 = null;
        goto L89
    L115:
        r131 = CastIntegerProtector.parseInt(r130);     // Catch: NumberFormatException -> L106
    L121:
        r129 = CastIntegerProtector.parseInt(r128);     // Catch: NumberFormatException -> L107
    L111:
        r127 = CastIntegerProtector.parseInt(r126);     // Catch: NumberFormatException -> L108
    L117:
        r125 = CastIntegerProtector.parseInt(r124);     // Catch: NumberFormatException -> L109
    L123:
        r122 = CastIntegerProtector.parseInt(r121);     // Catch: NumberFormatException -> L110
    L55:
        r118 = r117;
    L47:
        th = th;
    L51:
        Result.Companion r140 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L49:
        th = th;
        r115 = "";
        goto L51
    L36:
        DataContext r141 = com.bytedance.live.datacontext.d.d(GamePromoteTrackViewModel.class);
        if ((r141 instanceof GamePromoteTrackViewModel) == true) goto L39;
        r141 = null;
    L39:
        GamePromoteTrackViewModel r142 = (GamePromoteTrackViewModel) r141;
        if (r142 == null) goto L43;
        r108 = r142.getAdLogExtra();
        if (r108 != null) goto L119;
    L30:
        r112 = r107;
        goto L31
    L104:
        g(r210, r212, r213);
        return;
    L5:
        if (r210.f52853j == true) goto L19;
        int r143 = r210.f52880w0;
        if (r143 != 0) goto L9;
    L14:
        boolean r144 = true;
    L15:
        if (r144 == false) goto L19;
        if (r210.f52870r0 == true) goto L19;
        r100 = true;
        goto L20
    L9:
        if (r143 == 5) goto L14;
        if (r143 == 7) goto L14;
        r144 = false;
        goto L15
    }

    public final void c(Context r310, p r311, String r312, Function2<? super Boolean, ? super Pair<Integer, String>, Unit> r313, boolean r314) {
        Intrinsics.checkNotNullParameter(r310, "ctx");
        Intrinsics.checkNotNullParameter(r311, "downloadInfo");
        Intrinsics.checkNotNullParameter(r313, "action");
        if (this.f52312b == true) goto L5;
    L8:
        int r100 = r311.f52880w0;
        if (r100 == 0) goto L13;
        if (r100 == 6) goto L13;
        String r110 = "";
    L114:
        HashMap<String, String> r101 = GamecpTracker.f56755a;
        com.bytedance.android.gamecp.common.track.filter.d r102 = GamecpTracker.i(zu.b.class, null);
        if ((r102 instanceof com.bytedance.android.gamecp.common.track.filter.c) == true) goto L117;
        com.bytedance.android.gamecp.common.track.filter.d r103 = null;
    L118:
        com.bytedance.android.gamecp.common.track.filter.c r104 = (com.bytedance.android.gamecp.common.track.filter.c) r103;
        if (r104 == null) goto L121;
        String r105 = r104.b();
    L123:
        if (TextUtils.isEmpty(r105) == false) goto L125;
    L129:
        int r106 = r311.f52880w0;
        if (r106 != 0) goto L133;
        String r107 = "download";
    L136:
        if (r107 == null) goto L158;
        Lazy r108 = GamePromoteMonitorLinkHandler.f56168a;
        int r109 = r311.f52859m;
        HashMap<String, String> r111 = r311.f52841d;
        String r112 = r311.f52855k;
        if (r112 != null) goto L141;
        r112 = r110;
    L141:
        r111.put("game_id", r112);
        String r113 = r311.f52849h;
        if (r113 != null) goto L144;
        r113 = r110;
    L144:
        r111.put("promote_id", r113);
        r111.put("btn_type", r107);
        if (r311.f52859m != 0) goto L150;
        String r114 = r311.f52851i;
        if (r114 != null) goto L149;
        r114 = r110;
    L149:
        r111.put("room_id", r114);
    L150:
        String r115 = r311.U;
        if (r115 != null) goto L153;
        r115 = r110;
    L153:
        r111.put(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, r115);
        String r116 = r311.f52845f;
        if (r116 != null) goto L156;
        String r117 = r110;
    L157:
        r111.put("download_page", r117);
        Unit r118 = Unit.INSTANCE;
        GamePromoteMonitorLinkHandler.a(r109, "livesdk_game_promote_user_btn_click", r111, r311.f52843e);
        goto L158
    L156:
        r117 = r116;
    L158:
        Integer r119 = r311.K;
        if (r119 != null) goto L162;
    L175:
        String r120 = r311.f52845f;
        if (r120 != null) goto L179;
    L196:
        int r121 = 1099;
    L197:
        LiveTracingMonitor.EventModule r122 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r123 = new JSONObject();
        r123.put(EventConstants.ExtraJson.GAME_NAME, r311.f52836a0);     // Catch: Exception -> L205
        r123.put("game_id", r311.f52855k);     // Catch: Exception -> L205
        r123.put("is_jump_detail", "0");     // Catch: Exception -> L205
        if (Intrinsics.areEqual(r311.f52845f, "promote_detail") == false) goto L203;
        r123.put("enter_from", null);     // Catch: Exception -> L205
        if (r311.f52853j == true) goto L203;
        r123.put("game_ad_type", null);     // Catch: Exception -> L205
    L203:
        r123.put("download_status", r311.f52880w0);     // Catch: Exception -> L205
    L206:
        Unit r124 = Unit.INSTANCE;
        com.bytedance.android.gamecp.common.utils.t.b(r121, r123);
        if (NetworkUtils.e(r310) == true) goto L210;
        r313.invoke(Boolean.FALSE, new Pair(6, "no network"));
        ToastUtil.a(R.string.ttlive_download_network_unavailable);
        return;
    L210:
        if (r314 == true) goto L214;
        f(r311, r312, r310, r313);
        return;
    L214:
        if (com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService().o2() == true) goto L216;
        b(r310, r311, r312, r313);
        return;
    L216:
        if (r311.f52880w0 != 6) goto L218;
    L220:
        b(r310, r311, r312, r313);
        return;
    L218:
        if (com.bytedance.android.gamecp.host_api.a.b().getUserService().user().isLogin() == true) goto L220;
        this.f52311a.add(com.bytedance.android.gamecp.host_api.a.b().getUserService().user().c(r310, new com.bytedance.android.gamecp.host_api.model.user.c(new com.bytedance.android.gamecp.host_api.model.user.c.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r310, r311, r312, r313), new h(r313, r311)));
        int r125 = GamePromoteTrack.f51759a;
        GamePromoteTrack.r("not_login", r311);
        return;
    L179:
        switch(r120.hashCode()) {
            case -195606640: goto L194;
            case 726863280: goto L188;
            case 962562691: goto L185;
            case 1109395646: goto L182;
            default: goto L196;
        };
    L182:
        if (r120.equals("download_hub") == false) goto L196;
        r121 = 1104;
        goto L197
    L185:
        if (r120.equals("anchor_recommendation") == false) goto L196;
        r121 = 203;
        goto L197
    L188:
        if (r120.equals("promote_detail") == false) goto L196;
        if (r311.f52853j == false) goto L192;
        r121 = 902;
        goto L197
    L192:
        r121 = 305;
        goto L197
    L194:
        if (r120.equals("game_ad") == false) goto L196;
        r121 = 107;
        goto L197
    L162:
        if (r119.intValue() != 1) goto L175;
        com.bytedance.android.gamecp.business.gamedetail.base.model.k r126 = r311.I;
        if (r126 == null) goto L175;
        String r127 = r126.a();
        if (r127 == null) goto L175;
        if ((true ^ Intrinsics.areEqual(r127, r311.f52855k)) == true) goto L175;
        HashMap r128 = new HashMap();
        r128.put("game_id", r127);
        r128.put("action_type", "promote_download_click");
        int r129 = GamePromoteTrack.f51759a;
        r128.put("status", GamePromoteTrack.g(r311.f52880w0));
        int r130 = r311.f52859m;
        r128.put("is_ads", com.bytedance.android.gamecp.business.i0.d(r130));
        r128.put("host_id", d(r311));
        r128.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, e(r311));
        r128.put("scene", String.valueOf(r130));
        r128.put("req_id", com.bytedance.android.gamecp.business.i0.f(r130));
        String r131 = r311.H;
        if (r131 != null) goto L174;
        r131 = "0";
    L174:
        r128.put("if_promote_icon", r131);
        DataChannelMonitorLinkHandler.h("douyin_game_content_consume_click_monitor", r128);
        goto L175
    L133:
        if (r106 != 7) goto L135;
        r107 = "update";
        goto L136
    L135:
        r107 = null;
        goto L136
    L125:
        if ((!Intrinsics.areEqual(r105, "0")) == false) goto L129;
        if (r311.f52880w0 != 0) goto L129;
        Lazy r132 = GamePromoteMonitorLinkHandler.f56168a;
        GamePromoteMonitorLinkHandler.b(r105, r311.f52860m0);
        goto L158
    L121:
        r105 = null;
        goto L123
    L117:
        r103 = r102;
    L13:
        LinkedHashMap r133 = new LinkedHashMap();
        String r134 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user().b().getRealNickName();
        if (r134 != null) goto L17;
        r134 = "";
    L17:
        String r135 = r311.f52849h;
        if (r135 != null) goto L21;
        r135 = "";
    L21:
        String r136 = r311.f52851i;
        if (r136 != null) goto L25;
        r136 = "";
    L25:
        String r137 = r311.f52855k;
        if (r137 != null) goto L29;
        r137 = "";
    L29:
        int r138 = Integer.valueOf(r311.f52859m).intValue();
        int r139 = r311.f52880w0;
        r110 = "";
        if (r139 != 0) goto L32;
        String r140 = "1";
    L37:
        if (r135.length() <= 0) goto L39;
        boolean r141 = true;
    L40:
        if (r141 == true) goto L43;
        r135 = null;
    L43:
        if (r135 != null) goto L45;
        r135 = "0";
    L45:
        r133.put("anchor_id", r135);
        if (r138 == 0) goto L48;
    L55:
        r136 = "0";
    L56:
        r133.put("room_id", r136);
        r133.put("game_id", r137);
        r133.put("upload_type", r140);
        r133.put("user_nick_name", r134);
        if (r138 != 2) goto L59;
        String r142 = "3";
    L60:
        r133.put("scene", r142);
        Integer r143 = r311.N;
        if (r143 == null) goto L64;
        String r144 = String.valueOf(r143.intValue());
        if (r144 == null) goto L64;
    L65:
        r133.put("biz_type", r144);
        Observable<com.bytedance.android.gamecp.base.network.response.i<Object>> r145 = ((GamePromoteApi) bs.e.a().b(GamePromoteApi.class)).logDownloadAction(r133);
        if (r145 == null) goto L71;
        Disposable r146 = r145.subscribe(e.f52703a, f.f52705a);
        if (r146 == null) goto L71;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r146, this.f52311a);
    L71:
        if (Intrinsics.areEqual(r140, "1") == false) goto L114;
        String r147 = r311.f52849h;
        if (r147 != null) goto L75;
    L84:
        String r210 = "0";
    L85:
        HashMap<String, String> r148 = GamecpTracker.f56755a;
        com.bytedance.android.gamecp.common.track.filter.d r149 = GamecpTracker.i(zu.b.class, null);
        if ((r149 instanceof com.bytedance.android.gamecp.common.track.filter.c) == true) goto L88;
        r149 = null;
    L88:
        com.bytedance.android.gamecp.common.track.filter.c r150 = (com.bytedance.android.gamecp.common.track.filter.c) r149;
        if (r150 == null) goto L91;
        String r151 = r150.b();
    L92:
        Lazy r152 = LiveBroadcastBaseClient.f57176a;
        GamePromoteApi r153 = (GamePromoteApi) LiveBroadcastBaseClient.a(GamePromoteApi.class);
        String r154 = r311.f52855k;
        String r155 = r311.f52836a0;
        int r156 = r311.f52859m;
        if (r156 != 2) goto L95;
        int r211 = 3;
    L96:
        String r157 = r311.f52851i;
        String r158 = r311.f52869r;
        Integer r159 = r311.N;
        if (r159 == null) goto L99;
        int r212 = r159.intValue();
    L100:
        if (r151 != null) goto L102;
        String r213 = r110;
    L103:
        String r160 = r311.f52863o;
        if (r160 != null) goto L106;
        String r214 = r110;
    L107:
        Observable r161 = GamePromoteApi.a.b(r153, r154, r155, r210, 0, r211, r157, r158, r212, r214, r213, r311.U, r311.f52860m0);
        if (r161 == null) goto L114;
        Observable r162 = r161.observeOn(AndroidSchedulers.mainThread());
        if (r162 == null) goto L114;
        Disposable r163 = r162.subscribe(c.f52543a, d.f52701a);
        if (r163 == null) goto L114;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r163, this.f52311a);
        goto L114
    L106:
        r214 = r160;
        goto L107
    L102:
        r213 = r151;
        goto L103
    L99:
        r212 = 0;
        goto L100
    L95:
        r211 = r156;
        goto L96
    L91:
        r151 = null;
        goto L92
    L75:
        if (r147.length() <= 0) goto L77;
        boolean r164 = true;
    L78:
        if (r164 == true) goto L81;
        r147 = null;
    L81:
        if (r147 == null) goto L84;
        r210 = r147;
        goto L85
    L77:
        r164 = false;
    L64:
        r144 = "0";
        goto L65
    L59:
        r142 = String.valueOf(r138);
        goto L60
    L48:
        if (r136.length() <= 0) goto L50;
        boolean r165 = true;
    L51:
        if (r165 == true) goto L54;
        r136 = null;
    L54:
        if (r136 != null) goto L56;
    L50:
        r165 = false;
        goto L51
    L39:
        r141 = false;
        goto L40
    L32:
        if (r139 == 6) goto L34;
        r140 = r110;
        goto L37
    L34:
        r140 = "2";
        goto L37
    L5:
        if (this.f52313c == false) goto L8;
        r313.invoke(Boolean.FALSE, new Pair(2, "get download"));
        yr.c.e("download view", "click when requesting trace_id");
    }
}
