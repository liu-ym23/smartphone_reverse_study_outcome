package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContextKt$convertPkBaseResultToInt$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.FormatType;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.link.domain.dependencyimpl.DynamicContextDependencyImpl;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.e5;
import com.bytedance.android.livesdk.link.model.h7;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.monitor.cloudmessage.consts.CloudControlInf;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Deprecated(message = "此处只负责老的没对齐之前的数据")
public final class k0 implements b, c, d {
    public final com.bytedance.android.livesdk.revenue.service.room.c A;
    public final com.bytedance.android.live.revlink.impl.global.c B;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e C;
    public final e D;
    public final i11.c E;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.b F;
    public final o G;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f94006J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f94007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f94008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f94009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<JSONObject> f94010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Boolean> f94011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Long> f94012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<f31.i> f94013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<String> f94014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<String> f94015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> f94016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData<String> f94017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final NextLiveData<ILinkMicBattleInviteMessage> f94018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final NextLiveData<e5> f94019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashMap<IBaseBattleSetting, JsonElement> f94020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RevLinkOldDynamicDataContext$battleInviteMsgObserver$1 f94021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RevLinkOldDynamicDataContext$battleReplyMsgObserver$1 f94022p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RevLinkOldDynamicDataContext$needShowLastResultObserver$1 f94023q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f94024r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j0 f94025s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final h0 f94026t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MutableLiveData<JSONObject> f94027u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap<String, LiveData<?>> f94028v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashMap<String, FormatType> f94029w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map<String, LiveData<Pair<String, JSONObject>>> f94030x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Function0<Integer> f94031y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ld.a f94032z;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final void g(zy0.b r100) {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final long G() {
        e r100 = this.D;
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<Long> r101 = r100.getChannelId();
        if (r101 == null) goto L9;
        Long r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.longValue();
    L9:
        return 0;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<PlayMode> H() {
        return this.C.getTeamMode();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<Long> I() {
        return this.C.getBaseTimeLeft();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final com.bytedance.android.live.revlink.impl.monitor.b a() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.B;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPkEnterRoomTracer();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveFullLinkPKMonitor d() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.B;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLiveFullLinkPKMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final MultiEnterRoomTracer e() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.B;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.i7();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final String getAnchorId() {
        com.bytedance.android.livesdk.revenue.service.room.c r100 = this.A;
        if (r100 == null) goto L12;
        com.bytedance.android.livesdk.revenue.room.a r101 = r100.getRoomContext();
        if (r101 == null) goto L12;
        IRoomBase r102 = r101.getCommonRoom();
        if (r102 == null) goto L12;
        IBaseUser r103 = r102.getOwnerKt();
        if (r103 == null) goto L12;
        String r104 = r103.getIdString();
        if (r104 == null) goto L12;
        return r104;
    L12:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final IBaseBattleSetting getBattleSettings() {
        return this.C.getBattleSettings();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final Map<String, IBattleUserInfo> getBattleUserInfoMap() {
        return this.C.getUserInfoMap();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<Integer> getPkResult() {
        LiveData<Map<String, PkBaseResult>> r100 = this.C.getPkBaseResult();
        final com.bytedance.android.live.revlink.impl.global.c r101 = this.B;
        Intrinsics.checkNotNullParameter(r100, "$this$convertPkBaseResultToInt");
        final MediatorLiveData r102 = new MediatorLiveData();
        r102.addSource(r100, new PkLynxDataContextKt$convertPkBaseResultToInt$$inlined$also$lambda$1(r102, r101));
        return r102;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> getScoreState() {
        return this.C.getBattleScoreData();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.b getSkinConfig() {
        return this.C.getPkSkinConfig();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<String> getTeamTaskLynxData() {
        return this.C.getTeamTaskLynxData();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final Map<String, Long> getUserIdToTeamId() {
        return this.C.getUserIdToTeamId();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final HashMap<String, LiveData<?>> b() {
        return this.f94028v;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData getChangeScreenEvent() {
        return this.f94011e;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData getWindowStatus() {
        return this.f94013g;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final Map<String, LiveData<Pair<String, JSONObject>>> h() {
        return this.f94030x;
    }

    public static final void i(k0 r100) {
        r100.getClass();
        JSONObject r101 = new JSONObject();
        ld.a r102 = r100.f94032z;
        Boolean r103 = null;
        if (r102 == null) goto L7;
        NextLiveData<Boolean> r104 = r102.Fc();
        if (r104 == null) goto L7;
        Boolean r105 = r104.getValue();
    L8:
        Boolean r106 = Boolean.TRUE;
        String r107 = "1";
        if (Intrinsics.areEqual(r105, r106) == false) goto L11;
        Object r108 = "1";
    L12:
        r101.put("left", r108);
        ld.a r109 = r100.f94032z;
        if (r109 == null) goto L18;
        NextLiveData<Boolean> r110 = r109.z9();
        if (r110 == null) goto L18;
        r103 = r110.getValue();
    L18:
        if (Intrinsics.areEqual(r103, r106) == true) goto L21;
        r107 = "0";
    L21:
        r101.put("right", r107);
        r100.f94010d.setValue(r101);
        return;
    L11:
        r108 = "0";
    L7:
        r105 = null;
        goto L8
    }

    public static JSONObject l(boolean r100) {
        JSONObject r101 = new JSONObject();
        b03.a r102 = b03.a.f16857a;
        r101.put("screen_width", Float.valueOf(b03.c.c(s1.y())));
        r101.put("screen_height", Float.valueOf(b03.c.c(s1.w())));
        int r103 = 1;
        if (r100 != true) goto L5;
        r103 = 0;
    L5:
        r101.put("screen_type", r103);
        r101.put("is_fold_full", FoldScreenUtils.f() ? 1 : 0);
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = null;
        Integer r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        Object r103 = null;
        Object r104 = null;
        com.bytedance.android.live.revlink.impl.utils.b r105 = null;
        ProfitInteractionDataContext r106 = null;
        Boolean r107 = null;
        r107 = null;
        if (Intrinsics.areEqual(r100, "pk_status") == false) goto L21;
        LiveData<?> r108 = this.f94028v.get(r100);
        if (r108 == null) goto L7;
        Object r109 = r108.getValue();
    L8:
        if (r109 != null) goto L21;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r110 = this.C;
        if (r110 == null) goto L19;
        LiveData<PkBaseStateMachine.c> r111 = r110.getPkBaseState();
        if (r111 == null) goto L19;
        PkBaseStateMachine.c r112 = r111.getValue();
        if (r112 == null) goto L19;
        RevPkState r113 = r112.c();
        if (r113 == null) goto L19;
        r102 = Integer.valueOf(r113.ordinal());
    L19:
        return k(r102).toString();
    L7:
        r109 = null;
    L21:
        if (Intrinsics.areEqual(r100, "meta_data") == false) goto L32;
        LiveData<c3> r114 = this.C.getBattleStatsMeta();
        if (r114 == null) goto L208;
        c3 r115 = r114.getValue();
        if (r115 == null) goto L209;
        String r116 = r115.getMetaLynxData();
        if (r116 != null) goto L30;
        return "";
    L30:
        return r116;
    L209:
        return "";
    L208:
        return "";
    L32:
        if (this.f94028v.containsKey(r100) == false) goto L64;
        LiveData<?> r117 = this.f94028v.get(r100);
        if (r117 == null) goto L36;
        Object r118 = r117.getValue();
    L38:
        if ((r118 instanceof String) == false) goto L46;
        LiveData<?> r119 = this.f94028v.get(r100);
        if (r119 == null) goto L42;
        r103 = r119.getValue();
    L42:
        if (r103 == null) goto L45;
        return (String) r103;
    L45:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L46:
        LiveData<?> r120 = this.f94028v.get(r100);
        if (r120 == null) goto L49;
        Object r121 = r120.getValue();
    L51:
        if ((r121 instanceof JSONObject) == false) goto L59;
        LiveData<?> r122 = this.f94028v.get(r100);
        if (r122 == null) goto L213;
        Object r123 = r122.getValue();
        if (r123 == null) goto L214;
        String r124 = r123.toString();
        if (r124 != null) goto L217;
        return "";
    L217:
        return r124;
    L214:
        return "";
    L213:
        return "";
    L59:
        LiveData<?> r125 = this.f94028v.get(r100);
        if (r125 == null) goto L62;
        r104 = r125.getValue();
    L62:
        r124 = GsonProtectorUtils.toJson(l97.a.f508113a, r104);
        goto L217
    L49:
        r121 = null;
        goto L51
    L36:
        r118 = null;
        goto L38
    L64:
        if (Intrinsics.areEqual(r100, "channel_id") == true) goto L205;
        if (Intrinsics.areEqual(r100, "channel_id_str") == true) goto L205;
        if (Intrinsics.areEqual(r100, "scene") == false) goto L72;
        return String.valueOf(this.f94031y.invoke().intValue());
    L72:
        if (Intrinsics.areEqual(r100, "lynx_data") == false) goto L79;
        IBaseBattleSetting r126 = getBattleSettings();
        if (r126 == null) goto L216;
        r124 = r126.getLynxData();
        if (r124 != null) goto L217;
        return "";
    L216:
        return "";
    L79:
        String r127 = "0";
        if (Intrinsics.areEqual(r100, "skin_type") == false) goto L87;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r128 = getSkinConfig();
        if (r128 == null) goto L220;
        String r129 = String.valueOf(r128.f92697a);
        if (r129 == null) goto L220;
        return r129;
    L220:
        return "0";
    L87:
        if (Intrinsics.areEqual(r100, "skin_config") == false) goto L93;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r130 = getSkinConfig();
        if (r130 != null) goto L91;
        return "";
    L91:
        return GsonProtectorUtils.toJson(l97.a.f508113a, r130.f92698b);
    L93:
        if (Intrinsics.areEqual(r100, "clean_screen") == false) goto L102;
        com.bytedance.android.live.revlink.impl.global.c r131 = this.B;
        if (r131 == null) goto L97;
        r105 = r131.getClearScreenLinkUtils();
    L97:
        if (r105 == null) goto L220;
        if (r105.b() != true) goto L220;
        return "1";
    L102:
        if (Intrinsics.areEqual(r100, "need_last_result") == false) goto L109;
        MutableLiveData<String> r132 = this.f94017k;
        if (r132 == null) goto L220;
        r124 = r132.getValue();
        if (r124 != null) goto L217;
    L109:
        if (Intrinsics.areEqual(r100, "interact_start_time") == false) goto L122;
        com.bytedance.android.live.revlink.impl.global.c r133 = this.B;
        if (r133 == null) goto L113;
        r106 = r133.vj();
    L113:
        if (r106 == null) goto L119;
        com.bytedance.live.datacontext.m<Long> r134 = r106.getLinkStartTimeStamp();
        if (r134 == null) goto L119;
        Long r135 = r134.getValue();
        if (r135 == null) goto L119;
        long r136 = r135.longValue();
    L221:
        return String.valueOf(r136);
    L119:
        r136 = 0;
        goto L221
    L122:
        if (Intrinsics.areEqual(r100, "user_infos") == false) goto L125;
        return GsonProtectorUtils.toJson(l97.a.f508113a, getBattleUserInfoMap());
    L125:
        if (Intrinsics.areEqual(r100, "pk_audience_count") == false) goto L146;
        JSONObject r137 = new JSONObject();
        ld.a r138 = this.f94032z;
        if (r138 == null) goto L131;
        NextLiveData<Boolean> r139 = r138.Fc();
        if (r139 == null) goto L131;
        Boolean r140 = r139.getValue();
    L132:
        Boolean r141 = Boolean.TRUE;
        if (Intrinsics.areEqual(r140, r141) == false) goto L135;
        Object r142 = "1";
    L136:
        r137.put("left", r142);
        ld.a r143 = this.f94032z;
        if (r143 == null) goto L142;
        NextLiveData<Boolean> r144 = r143.z9();
        if (r144 == null) goto L142;
        r107 = r144.getValue();
    L142:
        if (Intrinsics.areEqual(r107, r141) == false) goto L144;
        r127 = "1";
    L144:
        r137.put("right", r127);
        return r137.toString();
    L135:
        r142 = "0";
    L131:
        r140 = null;
        goto L132
    L146:
        if (Intrinsics.areEqual(r100, "online_cnt") == false) goto L153;
        List<com.bytedance.android.livesdk.link.model.p> r145 = this.f94016j.getValue();
        if (r145 == null) goto L150;
        int r146 = r145.size();
    L224:
        return String.valueOf(r146);
    L150:
        r146 = 0;
        goto L224
    L153:
        if (Intrinsics.areEqual(r100, "normal_to_multiple") == false) goto L162;
        com.bytedance.android.live.revlink.impl.global.c r147 = this.f94006J;
        if (r147 == null) goto L160;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r148 = r147.K8();
        if (r148 == null) goto L160;
        String r149 = String.valueOf(r148.canSwitchMulti());
        if (r149 == null) goto L160;
        return r149;
    L160:
        return "false";
    L162:
        if (Intrinsics.areEqual(r100, "pk_guest_info") == false) goto L173;
        com.bytedance.android.live.revlink.impl.global.c r150 = this.f94006J;
        if (r150 == null) goto L227;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r151 = r150.K8();
        if (r151 == null) goto L228;
        LiveData<String> r152 = r151.getPkGuestListStr();
        if (r152 == null) goto L229;
        r124 = r152.getValue();
        if (r124 != null) goto L217;
        return "";
    L229:
        return "";
    L228:
        return "";
    L227:
        return "";
    L173:
        if (Intrinsics.areEqual(r100, "play_duration") == false) goto L176;
        return String.valueOf(l51.a.j());
    L176:
        if (Intrinsics.areEqual(r100, "pk_settings") == false) goto L181;
        aa r153 = (aa) vh7.f.c(aa.class);
        r153.setVoteType(l51.a.g());
        r153.setVoteDes((String) l51.a.D0.getValue(null, l51.a.f507436a[91]));
        r153.setDurationTime(l51.a.f());
        HashMap r154 = new HashMap();
        r154.put("vote_setting", GsonProtectorUtils.toJson(l97.a.f508113a, r153));
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.c() == false) goto L180;
        r127 = "1";
    L180:
        r154.put("panel_list_opt", r127);
        return GsonProtectorUtils.toJson(l97.a.f508113a, r154);
    L181:
        IBaseBattleSetting r155 = getBattleSettings();
        if (this.f94020n.get(r155) != null) goto L206;
        this.f94020n.clear();
        this.f94020n.put(r155, GsonProtectorUtils.toJsonTree(l97.a.f508113a, r155));
    L206:
        Result.Companion r156 = Result.Companion;     // Catch: Throwable -> L194
        JsonElement r157 = this.f94020n.get(r155);     // Catch: Throwable -> L194
        if (r157 == null) goto L191;
        JsonObject r158 = r157.getAsJsonObject();     // Catch: Throwable -> L194
        if (r158 == null) goto L191;
        JsonElement r159 = r158.get(r100);     // Catch: Throwable -> L194
        if (r159 == null) goto L191;
        String r160 = r159.toString();     // Catch: Throwable -> L194
    L192:
        Object r161 = Result.m9449constructorimpl(r160);     // Catch: Throwable -> L194
    L197:
        if (Result.m9455isFailureimpl(r161) == true) goto L200;
        r101 = r161;
    L200:
        String r162 = (String) r101;
        if (r162 != null) goto L233;
        return "";
    L233:
        return r162;
    L191:
        r160 = null;
    L194:
        th = move-exception;
        Result.Companion r163 = Result.Companion;
        r161 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L205:
        return String.valueOf(G());
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c
    public final void j(int r100) {
        if (this.f94008b == false) goto L8;
        com.bytedance.android.live.revlink.impl.multianchor.ui.b r101 = this.F;
        if (r101 == null) goto L13;
        r101.requestLayout("updateTopReserve");
        return;
    L13:
        return;
    L8:
        if (((Boolean) this.f94009c.getValue()).booleanValue() == true) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.ui.b r102 = this.F;
        if (r102 == null) goto L16;
        r102.requestLayout("updateTopReserve");
        return;
    L16:
        return;
    }

    public final JSONObject k(Integer r100) {
        JSONObject r101 = new JSONObject();
        r101.put("state", com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.f(r100));
        IBaseBattleSetting r102 = getBattleSettings();
        int r103 = 0;
        if (r102 == null) goto L7;
        IBattleConfigSetting r104 = r102.getBattleConfigSetting();
        if (r104 == null) goto L7;
        int r105 = r104.getModType();
    L8:
        r101.put(FastStartLiveConfig.PLAY_MODE, r105);
        IBaseBattleSetting r106 = getBattleSettings();
        if (r106 == null) goto L13;
        IBattleConfigSetting r107 = r106.getBattleConfigSetting();
        if (r107 == null) goto L13;
        int r108 = r107.getPlayMode();
    L14:
        r101.put("battle_play_mode", r108);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r109 = getSkinConfig();
        if (r109 == null) goto L17;
        int r110 = (int) r109.f92697a;
    L18:
        r101.put("skin_type", r110);
        IBaseBattleSetting r111 = getBattleSettings();
        long r112 = 0;
        if (r111 == null) goto L21;
        long r113 = r111.getBattleId();
    L22:
        r101.put("battle_id", String.valueOf(r113));
        IBaseBattleSetting r114 = getBattleSettings();
        if (r114 == null) goto L25;
        r112 = r114.getBattleId();
    L25:
        r101.put("battle_id_str", String.valueOf(r112));
        r101.put("channel_id_str", String.valueOf(G()));
        IBaseBattleSetting r115 = getBattleSettings();
        if (r115 == null) goto L29;
        String r116 = r115.getLynxData();
        if (r116 == null) goto L29;
    L30:
        r101.put("lynx_data", r116);
        PlayMode r117 = H().getValue();
        if (r117 == null) goto L33;
        r103 = r117.ordinal();
    L33:
        r101.put("team_mode", r103);
        Map<String, Long> r118 = getUserIdToTeamId();
        if (r118 == null) goto L39;
        Map r119 = new LinkedHashMap(MapsKt.mapCapacity(r118.size()));
        Iterator<T> r120 = r118.entrySet().iterator();
    L37:
        if (r120.hasNext() == false) goto L40;
        Map.Entry r121 = (Map.Entry) r120.next();
        r119.put(r121.getKey(), Integer.valueOf(((int) ((Number) r121.getValue()).longValue()) - 1));
    L40:
        r101.put("pk_team_info", com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.d(r119));
        r101.put("pk_result", getPkResult().getValue());
        Map<String, IBattleUserInfo> r122 = getBattleUserInfoMap();
        if (r122 == null) goto L43;
        JSONObject r123 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.d(r122);
    L44:
        r101.put("pk_user_info", r123);
        return r101;
    L43:
        r123 = new JSONObject();
        goto L44
    L39:
        r119 = MapsKt.emptyMap();
    L29:
        r116 = "";
        goto L30
    L21:
        r113 = 0;
        goto L22
    L17:
        r110 = 0;
    L13:
        r108 = 0;
    L7:
        r105 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [int] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, org.json.JSONArray] */
    public static final void c(k0 r110, f31.i r210) {
        k0 r100 = r110;
        r110.getClass();
        if (r210 == null) goto L5;
        List<f31.k> r101 = r210.f475339a;
    L6:
        List<f31.k> r102 = r101;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L81;
        ?? r104 = new JSONObject();
        r104.put("ver", 6);
        String r105 = r100.G.c();
        JSONObject r106 = new JSONObject();
        if (r105 != null) goto L18;
        r105 = "0";
    L18:
        r106.put("focus_id", r105);
        r106.put("layout_type", r100.G.a());
        Iterator<f31.k> r107 = r101.iterator();
        int r108 = 0;
    L20:
        if (r107.hasNext() == false) goto L32;
        f31.k r111 = r107.next();
        String r112 = r100.I;
        if (r112 != null) goto L24;
    L28:
        boolean r113 = false;
    L29:
        if (r113 == true) goto L33;
        r108 = r108 + 1;
    L33:
        r106.put("owner_index", RangesKt.coerceAtLeast(r108, 0));
        com.bytedance.android.live.revlink.impl.global.c r109 = r100.B;
        if (r109 == null) goto L38;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r114 = r109.getMultiLinkUtil();
        if (r114 == null) goto L38;
        UILayout r115 = r114.b();
    L40:
        if (r115 != UILayout.FULL_RECORD) goto L42;
        r106.put("is_horizontal", 1);
    L42:
        r104.put("anchor_interact_info", r106);
        ?? r116 = new JSONArray();
        Iterator r117 = r101.iterator();
    L44:
        if (r117.hasNext() == false) goto L53;
        f31.k r118 = (f31.k) r117.next();
        String r119 = r118.f475348a;
        double r120 = r118.f475350c;
        double r121 = r118.f475351d;
        Iterator r122 = r117;
        double r123 = r118.f475352e;
        List<f31.k> r124 = r101;
        double r125 = r118.f475353f;
        boolean r126 = r118.f475354g;
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r127 = r100.H;
        if (r127 == null) goto L48;
        ?? r128 = r127.j(null, r119);
    L49:
        IRegion.Status r129 = IRegion.Status.FOREGROUND;
        Intrinsics.checkNotNullParameter(r129, "status");
        ?? r130 = new JSONObject();
        if (r119 != null) goto L52;
        r119 = "";
    L52:
        r130.put("uid_str", r119);
        r130.put("loading", r126 ? 1 : 0);
        r130.put("x", r120);
        r130.put("y", r121);
        r130.put("w", r123);
        r130.put("h", r125);
        r130.put("mute_audio", r128);
        r130.put("talk_volume", 0);
        r130.put(CloudControlInf.STAT, r129.toSeiFormat());
        r116.put(r130);
        r100 = r110;
        r117 = r122;
        r101 = r124;
        goto L44
    L48:
        r128 = 0;
        goto L49
    L53:
        List<f31.k> r131 = r101;
        r104.put("grids", r116);
        e r132 = r110.D;
        if (r132 == null) goto L60;
        com.bytedance.live.datacontext.m<Long> r133 = r132.getChannelId();
        if (r133 == null) goto L60;
        Long r134 = r133.getValue();
        if (r134 == null) goto L60;
        long r135 = r134.longValue();
    L61:
        r104.put("channel_id", r135);
        int r136 = f31.l.e(r131);
        int r137 = f31.l.a(r131);
        f31.l.c(r131);
        f31.l.d(r131);
        JSONObject r138 = new JSONObject();
        b03.a r139 = b03.a.f16857a;
        r138.put("screen_width", Float.valueOf(b03.c.c(s1.y())));
        r138.put("screen_height", Float.valueOf(b03.c.c(s1.w())));
        r138.put("container_width", r136);
        r138.put("container_height", r137);
        com.bytedance.android.live.revlink.impl.global.c r140 = r110.B;
        if (r140 == null) goto L67;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r141 = r140.Ig();
        if (r141 == null) goto L67;
        List<String> r142 = r141.getAudioPunishUserIds();
        if (r142 == null) goto L67;
    L68:
        r138.put("punish_user_ids", new JSONArray(r142));
        ?? r143 = new JSONObject();
        r143.put("app_data", r104);
        String r144 = r210.f475340b;
        if (r144 != null) goto L71;
        r144 = r110.f94024r;
    L71:
        if (r144 != null) goto L73;
        String r145 = "";
    L74:
        r143.put("sei_raw", r145);
        r143.put("extra_data", r138);
        r110.f94015i.setValue(r143.toString());
        return;
    L73:
        r145 = r144;
    L67:
        r142 = CollectionsKt.emptyList();
    L60:
        r135 = 0;
    L38:
        r115 = null;
        goto L40
    L24:
        if ((!StringsKt.isBlank(r112)) != true) goto L28;
        if (Intrinsics.areEqual(r100.I, r111.f475348a) == false) goto L28;
        r113 = true;
        goto L29
    L32:
        r108 = -1;
        goto L33
    L81:
        return;
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkOldDynamicDataContext$battleInviteMsgObserver$1] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkOldDynamicDataContext$battleReplyMsgObserver$1] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkOldDynamicDataContext$needShowLastResultObserver$1] */
    public k0(Function0 r110, ld.a r111, com.bytedance.android.livesdk.revenue.service.room.c r112, com.bytedance.android.live.revlink.impl.global.c r210, PkBaseDataContext r211, DynamicContextDependencyImpl r212, AnchorLinkUserCenterV2 r213, DynamicContextDependencyImpl r214, com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r215, com.bytedance.android.live.revlink.impl.multianchor.ui.i r216, String r217, com.bytedance.android.live.revlink.impl.global.c r218) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r211, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r215, "seiDependencies");
        this.f94031y = r110;
        this.f94032z = r111;
        this.A = r112;
        this.B = r210;
        this.C = r211;
        this.D = r212;
        this.E = r213;
        this.F = r214;
        this.G = r215;
        this.H = r216;
        this.I = r217;
        this.f94006J = r218;
        LiveData<List<h7.b>> r100 = r211.getLeftMvpRankList();
        LiveData<List<h7.b>> r101 = r211.getRightMvpRankList();
        LiveData<String> r102 = r211.getBattleEffectInfo();
        LiveData<String> r103 = r211.getPkGuestListStr();
        CompositeDisposable r104 = new CompositeDisposable();
        this.f94007a = r104;
        com.bytedance.android.livesdk.revenue.room.a r105 = r112.getRoomContext();
        if (r105 == null) goto L7;
        boolean r106 = true;
        if (r105.getCommonIsAnchor() != true) goto L7;
    L8:
        this.f94008b = r106;
        new MultiDynamicLocalContext();
        this.f94009c = LazyKt.lazy(RevLinkOldDynamicDataContext$isRelayoutOpt$2.INSTANCE);
        MutableLiveData<JSONObject> r107 = new MutableLiveData();
        this.f94010d = r107;
        this.f94011e = new MutableLiveData();
        MutableLiveData<Long> r108 = new MutableLiveData();
        this.f94012f = r108;
        this.f94013g = new MutableLiveData();
        MutableLiveData<String> r113 = new MutableLiveData();
        this.f94014h = r113;
        MutableLiveData<String> r114 = new MutableLiveData();
        this.f94015i = r114;
        MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> r115 = new MutableLiveData();
        this.f94016j = r115;
        MutableLiveData<String> r116 = new MutableLiveData();
        this.f94017k = r116;
        NextLiveData<ILinkMicBattleInviteMessage> r117 = new NextLiveData();
        this.f94018l = r117;
        NextLiveData<e5> r118 = new NextLiveData();
        this.f94019m = r118;
        this.f94020n = new HashMap();
        this.f94021o = new RevLinkOldDynamicDataContext$battleInviteMsgObserver$1(this);
        this.f94022p = new RevLinkOldDynamicDataContext$battleReplyMsgObserver$1(this);
        this.f94023q = new RevLinkOldDynamicDataContext$needShowLastResultObserver$1(this);
        this.f94025s = new j0(this);
        this.f94026t = new h0(this);
        MutableLiveData<JSONObject> r109 = new MutableLiveData();
        this.f94027u = r109;
        HashMap<String, LiveData<?>> r119 = new HashMap();
        LiveData<PkBaseStateMachine.c> r120 = r211.getPkBaseState();
        Intrinsics.checkNotNullParameter(r120, "$this$convertPkStateToMultiState");
        final MediatorLiveData r121 = new MediatorLiveData();
        r121.addSource(r120, new RevLinkOldDynamicDataContextKt$convertPkStateToMultiState$1$1(r121));
        MediatorLiveData r122 = new MediatorLiveData();
        r122.addSource(r121, new i0(r122, this));
        r119.put("pk_status", r122);
        r119.put("remain_time", I());
        r119.put("pk_score", getScoreState());
        r119.put("pk_result", getPkResult());
        r119.put("team_task", getTeamTaskLynxData());
        r119.put("clean_screen", r113);
        r119.put("sei_data", r114);
        r119.put("interact_start_time", r108);
        r119.put("change_screen", r109);
        r119.put("link_anchor_info", r115);
        if (r210 == null) goto L11;
        n21.a r123 = r210.ll();
    L12:
        if (r123 == null) goto L16;
        LiveData<?> r124 = r123.linkRecordTime();
        if (r124 == null) goto L16;
    L17:
        r119.put("link_record_time", r124);
        r119.put("need_last_result", r116);
        r119.put("left_mvp", r100);
        r119.put("right_mvp", r101);
        r119.put("pk_prop_card_info", r102);
        r119.put("pk_guest_info", r103);
        LiveData<PkBaseStateMachine.c> r125 = r211.getPkBaseState();
        Intrinsics.checkNotNullParameter(r125, "$this$convertPkStateToMultiState");
        final MediatorLiveData r126 = new MediatorLiveData();
        r126.addSource(r125, new RevLinkOldDynamicDataContextKt$convertPkStateToMultiState$1$1(r126));
        Intrinsics.checkNotNullParameter(r126, "$this$packagePlayStatus");
        Intrinsics.checkNotNullParameter(this, "dynamicContext");
        MediatorLiveData r127 = new MediatorLiveData();
        r127.addSource(r126, new DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1(r127, this, r104));
        r119.put("play_status", r127);
        Intrinsics.checkNotNullParameter(r115, "liveData");
        MediatorLiveData r128 = new MediatorLiveData();
        r128.addSource(r115, new RevLinkOldDynamicDataContextKt$transformLinkAnchorInfo$$inlined$also$lambda$1(r128, null));
        r119.put("link_anchor_list", r128);
        r119.put("pk_audience_count", r107);
        r119.put("battle_invite_msg", r117);
        r119.put("battle_reply_msg", r118);
        Unit r129 = Unit.INSTANCE;
        this.f94028v = r119;
        HashMap<String, FormatType> r130 = new HashMap();
        FormatType r131 = FormatType.NEW;
        r130.put("link_anchor_list", r131);
        r130.put("play_status", r131);
        this.f94029w = r130;
        LinkedHashMap r132 = new LinkedHashMap(MapsKt.mapCapacity(r119.size()));
        Iterator r133 = r119.entrySet().iterator();
    L19:
        if (r133.hasNext() == false) goto L24;
        Map.Entry r134 = (Map.Entry) r133.next();
        Object r135 = r134.getKey();
        String r136 = (String) r134.getKey();
        LiveData r137 = (LiveData) r134.getValue();
        FormatType r138 = this.f94029w.get(r136);
        if (r138 != null) goto L23;
        r138 = FormatType.OLD;
    L23:
        r132.put(r135, com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.b(r137, r136, r138));
        goto L19
    L24:
        this.f94030x = r132;
        return;
    L16:
        r124 = new MutableLiveData();
        goto L17
    L11:
        r123 = null;
    L7:
        r106 = false;
        goto L8
    }
}
