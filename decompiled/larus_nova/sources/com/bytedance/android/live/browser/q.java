package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.browser.utils.LiveBrowserDomainUtils;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.browser.webview.fragment.LiveAnnieFragment;
import com.bytedance.android.live.browser.webview.fragment.LiveAnnieXFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.g1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.g91;
import com.bytedance.android.livesdk.config.ky0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.s0;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdk.v5;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.LiveCardReleaseOpt;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.common.applog.AppLog;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class q implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<DialogFragment> f64154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<WeakReference<DialogFragment>> f64155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, BaseWebDialogFragment> f64156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TokenCert f64157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TokenCert f64158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Inject
    public v f64159f;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.monitor.webview.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f64160a = null;

        static {
            f64160a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.android.monitor.webview.a
        public final void a(String r100, JSONObject r101) {
            LiveSlardarMonitor.monitorStatusAndDurationDirect(r100, 0, null, r101);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.u
    public final LiveAnnieFragment c() {
        return new LiveAnnieFragment();
    }

    @Override // com.bytedance.android.live.browser.u
    public final LiveAnnieXFragment e() {
        return new LiveAnnieXFragment();
    }

    @Override // com.bytedance.android.live.browser.u
    public final void g() {
        if (LiveCardReleaseOpt.INSTANCE.useWeakRef() == false) goto L16;
        Iterator<WeakReference<DialogFragment>> r100 = this.f64155b.iterator();
    L6:
        if (r100.hasNext() == false) goto L15;
        DialogFragment r101 = r100.next().get();
        if (r101 == null) goto L6;
        r101.dismissAllowingStateLoss();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L6;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L6
    L15:
        this.f64155b.clear();
        return;
    L16:
        Iterator<DialogFragment> r103 = this.f64154a.iterator();
    L18:
        if (r103.hasNext() == false) goto L26;
        r103.next().dismissAllowingStateLoss();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L18;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L18
    L26:
        this.f64154a.clear();
    }

    public q() {
        this.f64154a = new CopyOnWriteArrayList();
        this.f64155b = new CopyOnWriteArrayList();
        this.f64156c = new LinkedHashMap();
        TokenCert.Companion r100 = TokenCert.Companion;
        this.f64157d = r100.with("bpea-live_webService_request_calendar_permission");
        this.f64158e = r100.with("bpea-live_webService_request_calendar_write_permission");
        BrowserServiceImpl.Companion.getClass();
        s20.b r101 = (s20.b) BrowserServiceImpl.access$getDiComponent$cp();
        r101.getClass();
        v r102 = r101.f540209b.f540212e.get();
        this.f64159f = r102;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L5:
        r102.registerExternalMethodFactory(g0.f62639a).subscribe();
        v r103 = this.f64159f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L8:
        r103.b(a0.f62576c).subscribe();
    }

    @Override // com.bytedance.android.live.browser.u
    public final void a() {
        g91 r100 = LiveInitSettingKeys.get_LIVW_WEBVIEW_MONITOR_CONFIG();
        n30.f r101 = n30.f.f516908a;
        com.bytedance.android.monitor.webview.b r102 = r101.e().buildConfig();
        r102.f162899g = b.f64160a;
        r102.f162898f = new ly2.c();
        r102.f162905m = r100.h();
        r102.f162900h = LiveInitSettingKeys.get_WEBVIEW_MONITOR_SLARDAR_SWITCH_SET();
        r102.f162894b = com.bytedance.android.monitor.webview.d.x();
        r102.f162908p = r100.g();
        r102.f162901i = r100.f();
        r102.f162902j = r100.c();
        r101.e().d(r102);
    }

    @Override // com.bytedance.android.live.browser.u
    public final void d() {
        g91 r100 = LiveInitSettingKeys.get_LIVW_WEBVIEW_MONITOR_CONFIG();
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        com.bytedance.android.monitorV2.webview.c r101 = n30.f.f516908a.e().b();
        r101.f163342g = "webcast_cn_container";
        r101.f163341f = r100.h();
        r101.f163339d = LiveInitSettingKeys.get_WEBVIEW_MONITOR_SLARDAR_SWITCH_SET();
    L9:
        n30.f.f516908a.e().c(r101);
        return;
    L5:
        v30.a r102 = n30.g.f516909a;
        if (LiveInitSettingKeys.get_LIVE_WEBVIEW_USE_MONITOR() == false) goto L8;
        r102 = n30.e.f516907b;
    L8:
        r101 = r102.b();
        r101.f163342g = "webcast_cn_container";
        r101.f163341f = r100.h();
        r101.f163339d = LiveInitSettingKeys.get_WEBVIEW_MONITOR_SLARDAR_SWITCH_SET();
        goto L9
    }

    @Override // com.bytedance.android.live.browser.u
    public final String appendCommonParams(String r310) {
        Intrinsics.checkNotNullParameter(r310, "url");
        RoomContext.Companion.getClass();
        RoomContext r100 = RoomContext.a.a(null, 0);
        if (r100 == null) goto L5;
        Room r101 = r100.getRoom().getValue();
    L6:
        if (r101 != null) goto L8;
        long r102 = 0;
    L10:
        if (r101 != null) goto L12;
        String r110 = "0";
    L14:
        if (r101 != null) goto L17;
        String r111 = String.valueOf(r110);
    L20:
        String r112 = ((IUserService) jc1.k.f(IUserService.class)).user().n();
        String r113 = ((IUserService) jc1.k.f(IUserService.class)).user().b().getCastSecUid();
        if (r101 != null) goto L23;
        String r114 = "";
    L24:
        if (r101 != null) goto L26;
        String r115 = "";
    L27:
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        Room r210 = r101;
        String r104 = "action_type";
        if ((r103 instanceof n0) == false) goto L48;
        n0 r105 = (n0) r103;
        if (r105.f153291b.containsKey("enter_from") == false) goto L33;
        String r106 = r105.f153291b.get("enter_from");
    L33:
        if (r105.f153291b.containsKey("source") == false) goto L36;
        String r107 = r105.f153291b.get("source");
    L36:
        if (r105.f153291b.containsKey("action_type") == false) goto L38;
        String r108 = r105.f153291b.get("action_type");
    L40:
        if (r105.f153291b.containsKey("video_id") == false) goto L42;
        String r116 = r105.f153291b.get("video_id");
    L44:
        if (r105.f153291b.containsKey(AppConstants.BUNDLE_GD_LABEL) == false) goto L46;
        String r109 = r105.f153291b.get(AppConstants.BUNDLE_GD_LABEL);
    L47:
        Map<String, String> r117 = r105.f153291b;
        Map<String, String> r211 = com.bytedance.android.livesdk.log.e0.f153286a;
        String r212 = r117.get("enter_from_merge");
        String r118 = r117.get("enter_method");
        String r213 = r109;
        String r119 = r108;
        String r214 = r116;
        String r120 = r212;
    L49:
        com.bytedance.android.livesdk.log.filter.o r121 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        String r215 = r119;
        if ((r121 instanceof s0) == false) goto L52;
        String r122 = ((s0) r121).f153291b.get("lottery_id");
    L53:
        Uri r123 = UriProtector.parse(r310);
        String r216 = r122;
        List r124 = (List) LiveBrowserDomainUtils.f64297a.getValue();
        boolean r217 = false;
        if (r123.getHost() == null) goto L62;
        Iterator r125 = r124.iterator();
    L57:
        if (r125.hasNext() == false) goto L62;
        String r311 = r104;
        if (x30.a.a(r123.getHost(), (String) r125.next()) == true) goto L60;
        r104 = r311;
        goto L57
    L60:
        boolean r126 = true;
    L63:
        if (r126 == true) goto L66;
        HashMap r127 = new HashMap();
        r127.put("url", r310);
        r127.put("safeJsbHostList", r124);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError(LiveSlardarConstants.SERVICE_WEBVIEW_JSB_SAFE_HOST), 1, r127);
    L66:
        Set<String> r128 = UriProtector.getQueryParameterNames(r123);
        if (r126 == false) goto L219;
        if (r128 == null) goto L220;
        Uri.Builder r129 = UriProtector.parse(r310).buildUpon();
        if (r128.contains("room_id") == true) goto L75;
        if (r102 == 0) goto L75;
        r129.appendQueryParameter("room_id", String.valueOf(r102));
    L75:
        if (r128.contains("anchor_id") == true) goto L80;
        if (com.bytedance.android.live.base.model.user.n0.b(r110) == false) goto L80;
        r129.appendQueryParameter("anchor_id", String.valueOf(r110));
    L80:
        if (r128.contains("sec_anchor_id") == true) goto L83;
        r129.appendQueryParameter("sec_anchor_id", r111);
    L83:
        if (r128.contains("user_id") == true) goto L86;
        r129.appendQueryParameter("user_id", String.valueOf(r112));
    L86:
        if (r128.contains("sec_user_id") == true) goto L89;
        r129.appendQueryParameter("sec_user_id", r113);
    L89:
        if (r128.contains("enter_from_merge") == true) goto L92;
        r129.appendQueryParameter("enter_from_merge", r120);
    L92:
        if (r128.contains("enter_method") == true) goto L94;
        r129.appendQueryParameter("enter_method", r118);
    L94:
        String r130 = r311;
        if (r128.contains(r130) == true) goto L97;
        String r131 = r215;
        r129.appendQueryParameter(r130, r131);
    L99:
        if (r128.contains("log_pb") == true) goto L104;
        if (TextUtils.isEmpty(r114) == true) goto L104;
        r129.appendQueryParameter("log_pb", r114);
    L104:
        if (r128.contains("request_id") == true) goto L109;
        if (TextUtils.isEmpty(r115) == true) goto L109;
        r129.appendQueryParameter("request_id", r115);
    L109:
        if (r128.contains("video_id") == true) goto L114;
        if (TextUtils.isEmpty(r214) == true) goto L114;
        r129.appendQueryParameter("video_id", r214);
    L114:
        if (r128.contains(r130) == true) goto L119;
        if (TextUtils.isEmpty(r131) == true) goto L119;
        r129.appendQueryParameter(r130, r131);
    L119:
        if (r128.contains(AppConstants.BUNDLE_GD_LABEL) == true) goto L124;
        if (TextUtils.isEmpty(r213) == true) goto L124;
        r129.appendQueryParameter(AppConstants.BUNDLE_GD_LABEL, r213);
    L124:
        if (r128.contains("lottery_id") == true) goto L129;
        if (TextUtils.isEmpty(r216) == true) goto L129;
        r129.appendQueryParameter("lottery_id", r216);
    L129:
        if (r210 != null) goto L131;
    L137:
        if (r210 != null) goto L139;
    L149:
        if (r210 != null) goto L151;
    L157:
        if (r210 == null) goto L166;
        if (r128.contains("is_paidlive") == true) goto L166;
        if (r210.isPaidRoom() == false) goto L163;
        String r132 = "1";
    L164:
        r129.appendQueryParameter("is_paidlive", r132);
        goto L166
    L163:
        r132 = "0";
    L166:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L176;
        HostBoeParams r133 = ((IHostContext) jc1.k.f(IHostContext.class)).getHostBoeParams();
        if (r133 == null) goto L176;
        if (r133.getPpeEnable() == false) goto L172;
    L175:
        r129.appendQueryParameter("device_id", AppLog.v());
        goto L176
    L172:
        if (r133.getBoeEnable() == true) goto L175;
        if (ky0.f120638a.getValue().booleanValue() == true) goto L175;
    L176:
        if (r100 == null) goto L184;
        Map<String, String> r134 = r100.getLiveActivityContext().getValue();
        if (r134 == null) goto L184;
        Iterator<Map.Entry<String, String>> r135 = r134.entrySet().iterator();
    L181:
        if (r135.hasNext() == false) goto L184;
        Map.Entry<String, String> r136 = r135.next();
        r129.appendQueryParameter(r136.getKey(), r136.getValue());
    L184:
        if (v5.f159243a.getValue().booleanValue() == false) goto L192;
        int r137 = g1.f66172a;
        if (r210 != null) goto L188;
    L190:
        String r138 = "unknown";
    L191:
        r129.appendQueryParameter("hybrid_live_scene", r138);
        ALogger.i("Hybrid_Params", "appendLiveCommonParam::: cur room scene  : ".concat(r138));
        goto L192
    L188:
        if (r210.getRoomId() == 0) goto L190;
        r138 = "during_live";
    L192:
        r129.appendQueryParameter("currency_name", r3.c());
        r129.appendQueryParameter("short_currency_name", r3.b());
        j40.m r139 = j40.m.f497260a;
        r129.appendQueryParameter("currency_full_name", r139.getValue().getCoinFullDesc());
        r129.appendQueryParameter("point_name", r139.getValue().getPoint());
        r129.appendQueryParameter("recharge_desc", e4.a());
        if (r210 != null) goto L195;
    L204:
        lm1.b r140 = pm1.f.d(null);
        if (r140 == null) goto L213;
        if (r140.getEpisode().getValue() == null) goto L213;
        int r141 = am2.a0.L;
        Iterator r142 = ((HashMap) am2.a0.a.a(r140.getEpisode().getValue()).a()).entrySet().iterator();
    L210:
        if (r142.hasNext() == false) goto L213;
        Map.Entry r143 = (Map.Entry) r142.next();
        r129.appendQueryParameter((String) r143.getKey(), (String) r143.getValue());
    L213:
        return r129.build().toString();
    L195:
        if (r210.isMergeVSRoom() == false) goto L204;
        r129.appendQueryParameter("vs_is_merge", "1");
        if (r100.isPortraitInteraction().getValue().booleanValue() == false) goto L199;
        String r144 = "portrait";
    L200:
        r129.appendQueryParameter("vs_screen_type", r144);
        Iterator<Map.Entry<String, String>> r145 = AnnieParamUtil.i().entrySet().iterator();
    L202:
        if (r145.hasNext() == false) goto L204;
        Map.Entry<String, String> r146 = r145.next();
        r129.appendQueryParameter(r146.getKey(), r146.getValue());
        goto L202
    L199:
        r144 = "landscape";
        goto L200
    L151:
        if (r210.getDesireInfo() == null) goto L157;
        if (r210.getDesireInfo().desireIdStr == null) goto L157;
        if (r128.contains("desire_id") == true) goto L157;
        r129.appendQueryParameter("desire_id", r210.getDesireInfo().desireIdStr);
        goto L157
    L139:
        if (r128.contains("allow_exchange") == true) goto L149;
        com.bytedance.android.live.incentive.exchange.c r147 = (com.bytedance.android.live.incentive.exchange.c) qa0.c.f532212b.getService(com.bytedance.android.live.incentive.exchange.c.class);
        if (r147 != null) goto L143;
    L145:
        if (r217 == false) goto L147;
        String r148 = "1";
    L148:
        r129.appendQueryParameter("allow_exchange", r148);
        goto L149
    L147:
        r148 = "0";
        goto L148
    L143:
        if (r147.a() == false) goto L145;
        r217 = true;
        goto L145
    L131:
        if (r128.contains("allow_gift") == true) goto L137;
        if (r210.allowGift() == false) goto L135;
        String r149 = "1";
    L136:
        r129.appendQueryParameter("allow_gift", r149);
        goto L137
    L135:
        r149 = "0";
        goto L136
    L97:
        r131 = r215;
        goto L99
    L220:
        return r310;
    L219:
        return r310;
    L62:
        r311 = r104;
        r126 = false;
        goto L63
    L52:
        r122 = "";
        goto L53
    L46:
        r109 = "";
        goto L47
    L42:
        r116 = "";
        goto L44
    L38:
        r108 = "";
        goto L40
    L48:
        r118 = "";
        r119 = r118;
        r120 = r119;
        r214 = r120;
        r213 = r214;
        goto L49
    L26:
        r115 = r101.getRequestId();
        goto L27
    L23:
        r114 = r101.getLog_pb();
        goto L24
    L17:
        if (r101.getBaseOwner() == null) goto L19;
        r111 = r101.getBaseOwner().getCastSecUid();
        goto L20
    L19:
        r111 = "";
        goto L20
    L12:
        r110 = r101.getOwnerUserIdString();
        goto L14
    L8:
        r102 = r101.getId();
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.u
    public final void b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        throw new UnsupportedOperationException("主线直播不支持");
    }

    @Override // com.bytedance.android.live.browser.u
    public final com.bytedance.android.live.browser.webview.fragment.i createBrowserFragment(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        return new com.bytedance.android.live.browser.webview.fragment.i(r100);
    }

    @Override // com.bytedance.android.live.browser.u
    public final com.bytedance.android.live.browser.webview.fragment.i createSimpleBrowserFragment(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        return new com.bytedance.android.live.browser.webview.fragment.i(r100);
    }

    @Override // com.bytedance.android.live.browser.u
    public final boolean f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return u30.e.f548562a.getValue().a(r100);
    }

    @Override // com.bytedance.android.live.browser.u
    public final String appendFeedCommonParams(String r210, IRoom r211) {
        Intrinsics.checkNotNullParameter(r210, "url");
        Intrinsics.checkNotNullParameter(r211, "room");
        Room r100 = (Room) com.bytedance.android.live.base.model.m.b(r211, Room.class);
        if (r100 != null) goto L5;
        long r101 = 0;
    L6:
        String r102 = "0";
        if (r100 != null) goto L9;
        String r103 = "0";
    L10:
        String r104 = "";
        if (r100 != null) goto L14;
        String r110 = String.valueOf(r103);
    L17:
        String r111 = ((IUserService) jc1.k.f(IUserService.class)).user().n();
        String r112 = ((IUserService) jc1.k.f(IUserService.class)).user().b().getCastSecUid();
        if (r100 != null) goto L20;
        String r113 = "";
    L21:
        if (r100 == null) goto L24;
        r104 = r100.getRequestId();
    L24:
        Uri r114 = UriProtector.parse(r210);
        List r115 = (List) LiveBrowserDomainUtils.f64297a.getValue();
        boolean r116 = false;
        if (r114.getHost() == null) goto L33;
        Iterator r105 = r115.iterator();
    L28:
        if (r105.hasNext() == false) goto L33;
        String r106 = (String) r105.next();
        Iterator r117 = r105;
        if (x30.a.a(r114.getHost(), r106) == true) goto L31;
        r105 = r117;
        goto L28
    L31:
        boolean r107 = true;
    L34:
        if (r107 == true) goto L37;
        HashMap r108 = new HashMap();
        r108.put("url", r210);
        r108.put("safeJsbHostList", r115);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError(LiveSlardarConstants.SERVICE_WEBVIEW_JSB_SAFE_HOST), 1, r108);
    L37:
        Set<String> r109 = UriProtector.getQueryParameterNames(r114);
        if (r107 == false) goto L129;
        if (r109 == null) goto L130;
        Uri.Builder r118 = UriProtector.parse(r210).buildUpon();
        if (r109.contains("room_id") == true) goto L46;
        if (r101 == 0) goto L46;
        r118.appendQueryParameter("room_id", String.valueOf(r101));
    L46:
        if (r109.contains("anchor_id") == true) goto L51;
        if (com.bytedance.android.live.base.model.user.n0.b(r103) == false) goto L51;
        r118.appendQueryParameter("anchor_id", String.valueOf(r103));
    L51:
        if (r109.contains("sec_anchor_id") == true) goto L54;
        r118.appendQueryParameter("sec_anchor_id", r110);
    L54:
        if (r109.contains("user_id") == true) goto L57;
        r118.appendQueryParameter("user_id", String.valueOf(r111));
    L57:
        if (r109.contains("sec_user_id") == true) goto L60;
        r118.appendQueryParameter("sec_user_id", r112);
    L60:
        if (r109.contains("log_pb") == true) goto L65;
        if (TextUtils.isEmpty(r113) == true) goto L65;
        r118.appendQueryParameter("log_pb", r113);
    L65:
        if (r109.contains("request_id") == true) goto L70;
        if (TextUtils.isEmpty(r104) == true) goto L70;
        r118.appendQueryParameter("request_id", r104);
    L70:
        if (r100 != null) goto L72;
    L78:
        if (r100 != null) goto L80;
    L90:
        if (r100 != null) goto L92;
    L98:
        if (r100 == null) goto L106;
        if (r109.contains("is_paidlive") == true) goto L106;
        if (r100.isPaidRoom() == false) goto L104;
        r102 = "1";
    L104:
        r118.appendQueryParameter("is_paidlive", r102);
    L106:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L117;
        HostBoeParams r119 = ((IHostContext) jc1.k.f(IHostContext.class)).getHostBoeParams();
        if (r119 == null) goto L117;
        if (r119.getPpeEnable() == false) goto L112;
    L115:
        r118.appendQueryParameter("device_id", AppLog.v());
        goto L117
    L112:
        if (r119.getBoeEnable() == true) goto L115;
        if (ky0.f120638a.getValue().booleanValue() == true) goto L115;
    L117:
        if (v5.f159243a.getValue().booleanValue() == false) goto L125;
        int r120 = g1.f66172a;
        if (r100 != null) goto L121;
    L123:
        String r121 = "unknown";
    L124:
        r118.appendQueryParameter("hybrid_live_scene", r121);
        ALogger.i("Hybrid_Params", "appendLiveCommonParam::: cur room scene  : ".concat(r121));
        goto L125
    L121:
        if (r100.getRoomId() == 0) goto L123;
        r121 = "during_live";
    L125:
        r118.appendQueryParameter("currency_name", r3.c());
        r118.appendQueryParameter("short_currency_name", r3.b());
        j40.m r122 = j40.m.f497260a;
        r118.appendQueryParameter("currency_full_name", r122.getValue().getCoinFullDesc());
        r118.appendQueryParameter("point_name", r122.getValue().getPoint());
        r118.appendQueryParameter("recharge_desc", e4.a());
        return r118.build().toString();
    L92:
        if (r100.getDesireInfo() == null) goto L98;
        if (r100.getDesireInfo().desireIdStr == null) goto L98;
        if (r109.contains("desire_id") == true) goto L98;
        r118.appendQueryParameter("desire_id", r100.getDesireInfo().desireIdStr);
        goto L98
    L80:
        if (r109.contains("allow_exchange") == true) goto L90;
        com.bytedance.android.live.incentive.exchange.c r123 = (com.bytedance.android.live.incentive.exchange.c) qa0.c.f532212b.getService(com.bytedance.android.live.incentive.exchange.c.class);
        if (r123 != null) goto L84;
    L86:
        if (r116 == false) goto L88;
        String r124 = "1";
    L89:
        r118.appendQueryParameter("allow_exchange", r124);
        goto L90
    L88:
        r124 = "0";
        goto L89
    L84:
        if (r123.a() == false) goto L86;
        r116 = true;
        goto L86
    L72:
        if (r109.contains("allow_gift") == true) goto L78;
        if (r100.allowGift() == false) goto L76;
        String r125 = "1";
    L77:
        r118.appendQueryParameter("allow_gift", r125);
        goto L78
    L76:
        r125 = "0";
        goto L77
    L130:
        return r210;
    L129:
        return r210;
    L33:
        r107 = false;
        goto L34
    L20:
        r113 = r100.getLog_pb();
        goto L21
    L14:
        if (r100.getBaseOwner() == null) goto L16;
        r110 = r100.getBaseOwner().getCastSecUid();
        goto L17
    L16:
        r110 = "";
        goto L17
    L9:
        r103 = r100.getOwnerUserIdString();
        goto L10
    L5:
        r101 = r100.getId();
        goto L6
    }

    @Override // com.bytedance.android.live.browser.u
    public final u30.a i(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        return new u30.a(r100, r101);
    }

    @Override // com.bytedance.android.live.browser.u
    public final r h(Context r100, PublishSubject r101, Fragment r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "permissionResponse");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        return new r(this, r100, r101, r102);
    }
}
