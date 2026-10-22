package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import android.view.ViewGroup;
import android.widget.Toast;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.g0;
import com.bytedance.android.live.broadcastgame.api.model.h0;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.openplatform.miniapp.OpenOPAppHelper;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.wc;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.InteractOpenExtra;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenPlatformMiniAppDebugger extends OpenPlatformBaseDebugger implements vlc.l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f59980h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vlc.d f59981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f59982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f59983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f59984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f59985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PluginType f59986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i20.a f59987g;

    public static final class Companion {
        public static boolean b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            if (r100.length() != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            return false;
        L8:
            Uri r102 = UriProtector.parse(r100);
            if (Intrinsics.areEqual(r102.getHost(), AppbrandHostConstants.Micro_Host.HOST_APPBRAND) == false) goto L35;
            String r103 = UriProtector.getQueryParameter(r102, AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT);
            if (r103 != null) goto L13;
        L16:
            boolean r104 = true;
        L17:
            if (r104 == true) goto L35;
            String r105 = UriProtector.getQueryParameter(r102, "ide_inspect_version");
            if (r105 != null) goto L21;
        L24:
            boolean r106 = true;
        L25:
            if (r106 == true) goto L35;
            String r107 = UriProtector.getQueryParameter(r102, "ide_config");
            if (r107 != null) goto L29;
        L32:
            boolean r108 = true;
        L33:
            if (r108 == true) goto L35;
            return true;
        L29:
            if (r107.length() == 0) goto L32;
            r108 = false;
            goto L33
        L21:
            if (r105.length() == 0) goto L24;
            r106 = false;
            goto L25
        L13:
            if (r103.length() == 0) goto L16;
            r104 = false;
        L35:
            return false;
        L5:
            r101 = false;
            goto L6
        }

        public static void a(final String r100, final a r101) {
            Intrinsics.checkNotNullParameter(r100, "shortLinkStr");
            Intrinsics.checkNotNullParameter(r101, "callback");
            ThreadPoolHelper.c().execute(new OpenPlatformMiniAppDebugger$Companion$getDeepLink$1(r100, r101));
        }
    }

    public interface a {
        void onError(Throwable r100);

        void onSuccess(String r100);
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenPlatformMiniAppDebugger f59990a;

        public b(OpenPlatformMiniAppDebugger r100) {
            this.f59990a = r100;
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformMiniAppDebugger.a
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            Context r101 = this.f59990a.getContextWeakRef().get();
            if (r101 == null) goto L6;
            Toast r102 = Toast.makeText(r101, s1.B(R.string.ttlive_open_game_debug_invalid_qrcode_error), 0);
            r102.setGravity(17, 0, 0);
            r102.show();
            return;
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformMiniAppDebugger.a
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "httpsLink");
            int r101 = q.f60744a;
            q.g("访问短链，重定向后的 url : " + r100, "OP_MP_DEBUGGER");
            this.f59990a.getClass();
            boolean r102 = false;
            if (r100.length() != 0) goto L5;
            boolean r103 = true;
        L7:
            if (r103 == true) goto L31;
            String r104 = UriProtector.parse(r100).getEncodedQuery();
            if (r104 != null) goto L12;
        L15:
            boolean r105 = true;
        L16:
            if (r105 == true) goto L31;
            String r106 = UriProtector.getQueryParameter(UriProtector.parse(r100), BdpAppEventConstant.PARAMS_TECH_TYPE);
            if (r106 == null) goto L21;
            Integer r107 = Integer.valueOf(CastIntegerProtector.parseInt(r106));
        L22:
            PluginType.a r108 = PluginType.Companion;
            if (r107 == null) goto L31;
            Integer r109 = Integer.valueOf(r107.intValue());
            r108.getClass();
            PluginType r110 = PluginType.a.b(r109);
            if (r110 == null) goto L31;
            if (l.f60025b[r110.ordinal()] != 1) goto L31;
            String r111 = UriProtector.parse("snssdk1128://live_open_platform?").buildUpon().appendQueryParameter("timor_schema", "snssdk1128://microapp?" + r104).appendQueryParameter("enter_from", "IDE").appendQueryParameter("open_type", "developer_debug").build().toString();
        L32:
            q.g("url 适配为长链后 : " + r111, "OP_MP_DEBUGGER");
            OpenPlatformMiniAppDebugger r112 = this.f59990a;
            r112.getClass();
            if (r111.length() != 0) goto L35;
            boolean r113 = true;
        L36:
            if (r113 == true) goto L60;
            Uri r114 = UriProtector.parse(r111);
            String r115 = UriProtector.getQueryParameter(r114, "timor_schema");
            String r116 = UriProtector.getQueryParameter(r114, "open_type");
            String r117 = UriProtector.getQueryParameter(r114, "enter_from");
            if (r115 != null) goto L41;
        L44:
            boolean r118 = true;
        L45:
            if (r118 == true) goto L60;
            if (r116 != null) goto L48;
        L51:
            boolean r119 = true;
        L52:
            if (r119 == true) goto L60;
            if (r117 != null) goto L55;
        L56:
            r102 = true;
        L57:
            if (r102 == true) goto L60;
            int r120 = r112.d(r115);
        L61:
            r112.e(r120);
            q.g("完成扫码校验，schema = " + this.f59990a.f59984d, "OP_MP_DEBUGGER");
            return;
        L55:
            if (r117.length() != 0) goto L57;
        L48:
            if (r116.length() == 0) goto L51;
            r119 = false;
            goto L52
        L41:
            if (r115.length() == 0) goto L44;
            r118 = false;
        L60:
            r120 = 101;
            goto L61
        L35:
            r113 = false;
            goto L36
        L21:
            r107 = null;
            goto L22
        L12:
            if (r104.length() == 0) goto L15;
            r105 = false;
        L31:
            r111 = "";
            goto L32
        L5:
            r103 = false;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f59991a = null;

        static {
            f59991a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if ((((h0.c) sh6.c.b((sh6.b) r100)) instanceof h0.a) == false) goto L6;
            f2.b(R.string.ttlive_open_game_intro_download_error, 0);
            int r101 = q.f60744a;
            q.g("调试打开小游戏，加载失败", "OP_MP_DEBUGGER");
            return;
        }
    }

    static {
    }

    public final void h() {
        int r100 = q.f60744a;
        q.g("执行 startDebug()", "OP_MP_DEBUGGER");
        String r101 = "";
        String r102 = JSONObjectProtectorUtils.getString(new JSONObject(this.f59985e), "name");     // Catch: JSONException -> L8
        r101 = JSONObjectProtectorUtils.getString(new JSONObject(this.f59985e), "icon");     // Catch: JSONException -> L6
    L12:
        if (r102.length() <= 0) goto L14;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L19;
        r102 = "调试";
    L19:
        String r104 = "{\"game_id\":" + getGameId() + ",\"game_type\":1,\"group_type\":1,\"text_intro\" : \"当前直播间本地调试 : " + r102 + "\",\"need_game_desc\":false,\"rank\":99999,\"show_anchor_float_entrance\":true,\"show_audience_float_entrance\":true,\"app_id\":\"" + getAppId() + "\",\"schema\":\"" + this.f59984d + "\"}";
        if (l.f60024a[this.f59986f.ordinal()] == 1) goto L22;
        int r105 = InteractID.Unknown.getValue();
    L23:
        int r110 = r105;
        u r111 = new u(r110, r102, CollectionsKt.emptyList(), 1, 1, CollectionsKt.emptyList(), r104);
        if (r111.c() == null) goto L70;
        r111.iconUrl = CollectionsKt.listOf(r101);
        Map r106 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_debug", Boolean.TRUE), TuplesKt.to("game", r111), TuplesKt.to("app_id", getAppId()), TuplesKt.to("game_id", Long.valueOf(getGameId())), TuplesKt.to("OPEN_APP_ICON_URL", r101)});
        if (r102.length() != 0) goto L28;
        boolean r107 = true;
    L29:
        if (r107 == false) goto L31;
        String r112 = "调试";
    L32:
        ImageModel r108 = new ImageModel();
        r108.setUrls(CollectionsKt.listOf(r101));
        Unit r109 = Unit.INSTANCE;
        InteractEntranceCell r113 = new InteractEntranceCell(r110, r112, "当前直播间本地调试", r108, 1, r104, 130976);
        r113.f59324f.f59362a = true;
        xs2.b.a().post(new g0(true, r113));
        if (this.f59986f != PluginType.MINI_APP) goto L53;
        int r114 = OpenOPAppHelper.f61709a;
        Context r115 = getContextWeakRef().get();
        if (r115 != null) goto L37;
        return;
    L37:
        com.bytedance.android.live.broadcastgame.api.openplatform.b r116 = getPluginManager();
        if (r116 != null) goto L40;
        return;
    L40:
        Intrinsics.checkNotNullParameter(r115, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r106, "params");
        Intrinsics.checkNotNullParameter(r116, "pluginManager");
        ArrayList r117 = new ArrayList();
        RoomContext r118 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r118 == null) goto L52;
        com.bytedance.live.datacontext.n<DataCenter> r119 = r118.getDataCenter();
        if (r119 == null) goto L52;
        DataCenter r120 = r119.getValue();
        if (r120 == null) goto L52;
        OpenOPAppHelper.CheckOpenPlatformPluginRunningNode r121 = new OpenOPAppHelper.CheckOpenPlatformPluginRunningNode(r111, r120, r115, true);
        Intrinsics.checkNotNullParameter(r121, "node");
        r117.add(r121);
        OpenOPAppHelper.CheckGameConflictNode r122 = new OpenOPAppHelper.CheckGameConflictNode(r111, r120, r115);
        Intrinsics.checkNotNullParameter(r122, "node");
        r117.add(r122);
        OpenOPAppHelper.e r123 = new OpenOPAppHelper.e(r111, r106, r116);
        Intrinsics.checkNotNullParameter(r123, "node");
        r117.add(r123);
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r124 = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.a();
        Iterator r125 = r117.iterator();
    L49:
        if (r125.hasNext() == false) goto L51;
        ((ArrayList) r124.f61737a).add((com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.b) r125.next());
        goto L49
    L51:
        r124.f61738b = 0;
        r124.a();
    L52:
        int r126 = q.f60744a;
        q.g("调试打开小程序，schema : " + this.f59984d, "OP_MP_DEBUGGER");
    L53:
        InteractGameContext r127 = InteractGameContext.Companion.getContext();
        if (r127 == null) goto L71;
        com.bytedance.live.datacontext.n<h0.c> r128 = r127.getOpenGameLaunchResult();
        if (r128 == null) goto L72;
        Observable<sh6.b<h0.c>> r129 = r128.a();
        if (r129 == null) goto L73;
        Observable<sh6.b<h0.c>> r130 = r129.observeOn(AndroidSchedulers.mainThread());
        if (r130 == null) goto L74;
        Disposable r131 = r130.subscribe(c.f59991a);
        if (r131 == null) goto L75;
        Intrinsics.checkNotNullParameter(r131, "$this$autoDispose");
        this.f59987g.a(r131);
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L31:
        r112 = r102;
        goto L32
    L28:
        r107 = false;
        goto L29
    L70:
        return;
    L22:
        r105 = InteractID.OpenMicroApp.getValue();
        goto L23
    L14:
        r103 = false;
    L6:
        e = e;
    L10:
        e.printStackTrace();
        q.j(e, "OP_MP_DEBUGGER", 4);
    L8:
        e = e;
        r102 = "";
        goto L10
    }

    public OpenPlatformMiniAppDebugger() {
        this.f59987g = new i20.a();
        this.f59984d = "";
        this.f59985e = "";
        this.f59986f = PluginType.UNKNOWN_TYPE;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.i
    public final void releaseDebug() {
        super.releaseDebug();
        Disposable r100 = this.f59982b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f59982b = null;
        this.f59987g.b();
        vlc.d r101 = this.f59981a;
        if (r101 == null) goto L8;
        r101.removeMessageListener(this);
    L8:
        this.f59981a = null;
        int r102 = q.f60744a;
        q.g("执行完 releaseDebug()", "OP_MP_DEBUGGER");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.debug.c
    public final PluginType getPluginType() {
        return this.f59986f;
    }

    public final int d(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        return 101;
    L9:
        PluginType r102 = this.f59986f;
        PluginType.Companion.getClass();
        if (r102 == PluginType.a.a(r100)) goto L12;
        return 101;
    L12:
        Uri r103 = UriProtector.parse(r100);
        String r104 = UriProtector.getQueryParameter(r103, "app_id");
        String r105 = "";
        if ((!Intrinsics.areEqual(getAppId(), "")) == true) goto L15;
    L21:
        return 102;
    L15:
        if (Intrinsics.areEqual(r104, getAppId()) == false) goto L21;
        this.f59984d = r100;
        String r106 = UriProtector.getQueryParameter(r103, "url");
        if (r106 == null) goto L20;
        r105 = r106;
    L20:
        this.f59985e = r105;
        return 1;
    L5:
        r101 = false;
        goto L7
    }

    public final void e(int r100) {
        boolean r101 = true;
        if (r100 != 1) goto L5;
        h();
        String r102 = "可以调试";
    L15:
        int r103 = q.f60744a;
        if (r100 == 1) goto L19;
        r101 = false;
    L19:
        q.b(r101, r102);
        return;
    L5:
        if (r100 == 102) goto L10;
        Context r104 = getContextWeakRef().get();
        if (r104 == null) goto L9;
        Toast r105 = Toast.makeText(r104, s1.B(R.string.ttlive_open_game_debug_invalid_qrcode_error), 0);
        r105.setGravity(17, 0, 0);
        r105.show();
    L9:
        r102 = s1.B(R.string.ttlive_open_game_debug_appid_error);
        goto L15
    L10:
        Context r106 = getContextWeakRef().get();
        if (r106 == null) goto L13;
        Toast r107 = Toast.makeText(r106, s1.B(R.string.ttlive_open_game_debug_appid_error), 0);
        r107.setGravity(17, 0, 0);
        r107.show();
    L13:
        r102 = s1.B(R.string.ttlive_open_game_debug_invalid_qrcode_error);
        goto L15
    }

    public final void g(Context r100) {
        x0.d r101 = new x0.d();
        r101.f162243b = r100;
        r101.f162242a = 4;
        r101.f162244c = "提示";
        r101.f162245d = "无法唤起调试工具, 请尝试重新开播";
        o r102 = o.f60028a;
        x0.c[] r103 = r101.f162248g;
        x0.c r104 = r103[0];
        if (r104 != null) goto L5;
        r104 = new x0.c();
        r103[0] = r104;
    L5:
        r104.f162239a = "确定";
        r104.f162240b = r102;
        x0.b.g(new x0(r101.f162243b, r101));
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if ((r110 instanceof wc) == false) goto L24;
        int r100 = q.f60744a;
        q.g("收到调试 IM：\n" + r110, "OP_MP_DEBUGGER");
        this.f59983c = true;
        Disposable r101 = this.f59982b;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        long r102 = 0;
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L15;
        com.bytedance.live.datacontext.m<Room> r104 = r103.getRoom();
        if (r104 == null) goto L15;
        Room r105 = r104.getValue();
        if (r105 == null) goto L15;
        r102 = r105.f162599id;
    L15:
        wc r111 = (wc) r110;
        setGameId(r111.getGameId());
        if (i(r102, getAppId(), r111.G(), r111.H(), r111.E()) == true) goto L18;
        UtilityKotlinExtentionsKt.s(0, false, false, OpenPlatformMiniAppDebugger$onMessage$1$1.INSTANCE, 7);
        f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：IM 消息校验失败"));
        return;
    L18:
        if (r111.E() != 8) goto L20;
        setPluginType(PluginType.MINI_APP);
    L20:
        f(true, null);
        createDebugFloatBall();
        h();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final boolean onScanFail(int r100) {
        f2.c(s1.B(R.string.ttlive_open_game_debug_invalid_qrcode_error), 0);
        int r101 = q.f60744a;
        q.j(new Throwable("扫码错误，errorType = " + r100), "OP_MP_DEBUGGER", 4);
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final boolean onScanSuccess(String r100) {
        int r101 = q.f60744a;
        q.g("扫码结果 : " + r100, "OP_MP_DEBUGGER");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        f2.c(s1.B(R.string.ttlive_open_game_debug_invalid_qrcode_error), 0);
    L15:
        return false;
    L11:
        PluginType.Companion.getClass();
        if (PluginType.a.a(r100) != PluginType.MINI_APP) goto L14;
        e(d(r100));
        goto L15
    L14:
        Companion.a(r100, new b(this));
        goto L15
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final void setPluginType(PluginType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f59986f = r100;
    }

    public final void f(boolean r100, Throwable r101) {
        if (r100 == false) goto L6;
        com.bytedance.android.live.broadcastgame.opengame.i.a r102 = getInitCallback();
        if (r102 == null) goto L11;
        r102.onInitSuccess();
    L11:
        setInitCallback(null);
        return;
    L6:
        com.bytedance.android.live.broadcastgame.opengame.i.a r103 = getInitCallback();
        if (r103 == null) goto L11;
        if (r101 != null) goto L10;
        r101 = new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：未知错误");
    L10:
        r103.a(r101);
        goto L11
    }

    public final boolean i(long r100, String r101, int r102, String r110, long r111) {
        boolean r103 = false;
        if (r111 == 8) goto L5;
    L7:
        boolean r112 = false;
    L8:
        StringBuilder r113 = new StringBuilder();
        r113.append(String.valueOf(r100));
        r113.append(r101);
        r113.append(String.valueOf(r102));
        int r104 = o10.a.f521690a;
        byte[] r105 = Base64.decode("MWVlMTExZmVjZmZjMTJkMTcxOWE5NzBkZDE3N2UxZGE=", 0);
        Charset r106 = Charsets.UTF_8;
        r113.append(new String(r105, r106));
        String r107 = r113.toString();
        if (r112 == true) goto L11;
    L13:
        if (r103 == false) goto L15;
        String r108 = "可以展示调试悬浮球";
    L16:
        int r109 = q.f60744a;
        q.a(r103, r108);
        return r103;
    L15:
        r108 = "无法展示调试悬浮求，签名校验失败，";
        goto L16
    L11:
        if (o10.a.a(r107, new String(Base64.decode("TUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUFzY1BaL08vek00MjV3N1BLYXU5cHYzVUtZL0I2VmtzaHhjMlpodW02Vm12Q082dTVHeXl2R0dWUHlsWWF6Wi9lNFQ2a1orOVBEc0V6UHZUbzVRb0ZDaTdkZTZlcktEa0o5VW4wY3NwbWFKKzlnT0JiaHZodEw4d2xYREVVUDBlMzRpdmJXMWw3NGNFelJjT1hNTUJIYVNWNlZWZEJteVZhemdVYzFtZmFKK09rT3BLRFdveDFwOXUvU3BlVXJEQ2pzZXJvajJ1aldwYjArYW92bnd4M2VOSVR5ZnJuN2NkNFlSYnFTMXkwalk3U3BhMTVJaFVWTkdlU1VabGFkbkZmbUZZaXRhb2JEdGttQ2h4UWo1OG5BZ1ZrTnBwZHF1VXBza1g5Zk1tNURINUI4QUppSzJTaGhQNUJQa2FjYUVERllHdkNhdzBQMWVsdkNjbmZnbHlDSHdJREFRQUI=", 0), r106), r110) == false) goto L13;
        r103 = true;
        goto L13
    L5:
        if (this.f59986f != PluginType.MINI_APP) goto L7;
        r112 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.i
    public final void initDebug(Context r110, DataCenter r111, ViewGroup r112, com.bytedance.android.live.broadcastgame.api.openplatform.b r113, Map<String, ? extends Object> r210, com.bytedance.android.live.broadcastgame.opengame.i.a r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "dataCenter");
        Intrinsics.checkNotNullParameter(r112, "containerView");
        Intrinsics.checkNotNullParameter(r113, "gameManager");
        Intrinsics.checkNotNullParameter(r210, "extraParams");
        Intrinsics.checkNotNullParameter(r211, "callback");
        super.initDebug(r110, r111, r112, r113, r210, r211);
        int r100 = q.f60744a;
        q.g("执行 initDebug()", "OP_MP_DEBUGGER");
        long r101 = 0;
        String r102 = "";
        boolean r114 = true;
        Object r115 = null;
        if (((Boolean) r111.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L55;
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.j<vlc.d> r104 = r103.getMessageManager();
        if (r104 == null) goto L9;
        vlc.d r105 = r104.getValue();
    L10:
        this.f59981a = r105;
        if (r105 == null) goto L53;
        r105.addMessageListener(MessageType.INTERACT_OPEN_DEVELOP_MESSAGE.getIntType(), this);
        Object r106 = r210.get("source_params");
        if ((r106 instanceof String) == false) goto L16;
        r115 = r106;
    L16:
        String r116 = (String) r115;
        if (r116 != null) goto L107;
        r116 = "";
    L107:
        JSONObject r107 = new JSONObject(r116);     // Catch: JSONException -> L51
        this.f59984d = JSONObjectProtectorUtils.getString(r107, "timor_schema");     // Catch: JSONException -> L51
        String r108 = JSONObjectProtectorUtils.getString(r107, "open_type");     // Catch: JSONException -> L51
        String r109 = JSONObjectProtectorUtils.getString(r107, "enter_from");     // Catch: JSONException -> L51
        if (this.f59984d.length() != 0) goto L24;
        boolean r117 = true;
    L25:
        if (r117 == false) goto L27;
    L50:
        f2.c(s1.B(R.string.ttlive_open_game_debug_appid_error), 0);
        f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：调试所需参数为空"));
        return;
    L27:
        if (r108.length() != 0) goto L29;
        boolean r118 = true;
    L30:
        if (r118 == true) goto L50;
        if (r109.length() == 0) goto L35;
        r114 = false;
    L35:
        if (r114 == true) goto L50;
        Uri r119 = UriProtector.parse(this.f59984d);
        String r120 = UriProtector.getQueryParameter(r119, "app_id");
        if (r120 != null) goto L40;
        r120 = "";
    L40:
        setAppId(r120);
        String r121 = UriProtector.getQueryParameter(r119, "url");
        if (r121 == null) goto L44;
        r102 = r121;
    L44:
        this.f59985e = r102;
        Disposable r122 = this.f59982b;
        if (r122 == null) goto L47;
        r122.dispose();
    L47:
        Disposable r123 = Observable.timer(1, TimeUnit.MINUTES).compose(RxUtil.rxSchedulerHelper()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(this), new n(this));
        this.f59982b = r123;
        if (r123 == null) goto L109;
        Intrinsics.checkNotNullParameter(r123, "$this$autoDispose");
        this.f59987g.a(r123);
        return;
    L109:
        return;
    L29:
        r118 = false;
        goto L30
    L24:
        r117 = false;
    L51:
        e = move-exception;
        e.printStackTrace();
        f2.c(s1.B(R.string.ttlive_open_game_debug_appid_error), 0);
        f(false, e);
        return;
    L53:
        g(r110);
        f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：messageManager 为空"));
        return;
    L9:
        r105 = null;
        goto L10
    L55:
        RoomContext r124 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r124 == null) goto L60;
        com.bytedance.live.datacontext.m<Room> r125 = r124.getRoom();
        if (r125 == null) goto L60;
        Room r126 = r125.getValue();
    L61:
        if (r126 == null) goto L105;
        InteractOpenExtra r127 = r126.interactOpenExtra;
        if (r127 == null) goto L70;
        Map<String, String> r128 = r127.getDebugInfo();
        if (r128 == null) goto L70;
        String r129 = r128.get("app_id");
        if (r129 == null) goto L70;
        r102 = r129;
    L70:
        setAppId(r102);
        InteractOpenExtra r130 = r126.interactOpenExtra;
        if (r130 == null) goto L77;
        Map<String, String> r131 = r130.getDebugInfo();
        if (r131 == null) goto L77;
        String r132 = r131.get(OpenPlatformBaseDebugger.DEBUG_GAME_ID);
        if (r132 == null) goto L77;
        r101 = CastLongProtector.parseLong(r132);
    L77:
        setGameId(r101);
        InteractOpenExtra r133 = r126.interactOpenExtra;
        if (r133 == null) goto L84;
        Map<String, String> r134 = r133.getDebugInfo();
        if (r134 == null) goto L84;
        String r135 = r134.get("app_kind");
        if (r135 == null) goto L84;
        long r136 = CastLongProtector.parseLong(r135);
    L85:
        long r137 = r136;
        long r138 = r126.f162599id;
        String r139 = getAppId();
        InteractOpenExtra r140 = r126.interactOpenExtra;
        if (r140 == null) goto L105;
        Map<String, String> r141 = r140.getDebugInfo();
        if (r141 == null) goto L105;
        String r142 = r141.get("develop");
        if (r142 == null) goto L105;
        int r143 = CastIntegerProtector.parseInt(r142);
        InteractOpenExtra r144 = r126.interactOpenExtra;
        if (r144 == null) goto L105;
        Map<String, String> r145 = r144.getDebugInfo();
        if (r145 == null) goto L105;
        String r146 = r145.get("sign");
        if (r146 == null) goto L105;
        if (i(r138, r139, r143, r146, r137) == true) goto L101;
        f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：观众端 room extra消息校验失败"));
        goto L105
    L101:
        if (r137 != 8) goto L103;
        setPluginType(PluginType.MINI_APP);
    L103:
        f(true, null);
    L84:
        r136 = -1;
    L105:
        f(false, new Throwable("OpenPlatformMiniAppDebugger 初始化失败。原因：小程序观众端不需要 debugger"));
        return;
    L60:
        r126 = null;
        goto L61
    }
}
