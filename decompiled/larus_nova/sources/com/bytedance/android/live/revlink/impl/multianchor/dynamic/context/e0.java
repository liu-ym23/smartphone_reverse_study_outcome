package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.data.RevPkResult;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.FormatType;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.link.domain.dependencyimpl.DynamicContextDependencyImpl;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.x2;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
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
public final class e0 implements d {
    public final Map<String, LiveData<Pair<String, JSONObject>>> A;
    public List<? extends IRegion> B;
    public final Function0<Integer> C;
    public final ld.a D;
    public final com.bytedance.android.livesdk.revenue.service.room.c E;
    public final com.bytedance.android.live.revlink.impl.global.c F;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e G;
    public final e H;
    public final i11.c I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final o f93967J;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i K;
    public final String L;
    public final com.bytedance.android.live.revlink.impl.global.c M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<JSONObject> f93968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<String> f93969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<f31.i> f93970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f93971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f93972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<JSONObject> f93973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<Long> f93974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<String> f93975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<String> f93976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<String> f93977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData<JSONObject> f93978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData<Integer> f93979l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableLiveData<Boolean> f93980m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f93981n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MutableLiveData<JSONObject> f93982o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MutableLiveData<List<com.bytedance.android.livesdk.link.model.e>> f93983p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> f93984q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MutableLiveData<Boolean> f93985r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final w f93986s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RevLinkDynamicDataContext$needShowLastResultObserver$1 f93987t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RevLinkDynamicDataContext$onPartnerEnableObserver$1 f93988u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RevLinkDynamicDataContext$onMixStreamObserver$1 f93989v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final d0 f93990w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final r f93991x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RevLinkDynamicDataContext$pkStateObserver$1 f93992y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final HashMap<String, LiveData<?>> f93993z;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final void g(zy0.b r100) {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final com.bytedance.android.live.revlink.impl.monitor.b a() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.F;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPkEnterRoomTracer();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveFullLinkPKMonitor d() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.F;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLiveFullLinkPKMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final MultiEnterRoomTracer e() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.F;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.i7();
    }

    public final JSONArray j() {
        JSONArray r100 = new JSONArray();
        ld.a r101 = this.D;
        if (r101 == null) goto L12;
        NextLiveData<List<m11.b>> r102 = r101.q2();
        if (r102 == null) goto L12;
        List<m11.b> r103 = r102.getValue();
        if (r103 == null) goto L12;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        m11.b r105 = (m11.b) r104.next();
        JSONObject r106 = new JSONObject();
        r106.put("id", r105.c());
        r106.put("talking", r105.e());
        r106.put("silence_status", r105.d());
        r106.put("belong_user_id", r105.b());
        r100.put(r106);
    L12:
        return r100;
    }

    public final String k() {
        com.bytedance.android.livesdk.revenue.service.room.c r100 = this.E;
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

    public final ProfitInteractionDataContext l() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.F;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.vj();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final HashMap<String, LiveData<?>> b() {
        return this.f93993z;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData getChangeScreenEvent() {
        return this.f93985r;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData getWindowStatus() {
        return this.f93970c;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final Map<String, LiveData<Pair<String, JSONObject>>> h() {
        return this.A;
    }

    public static final void i(e0 r100) {
        r100.getClass();
        JSONObject r101 = new JSONObject();
        ld.a r102 = r100.D;
        Integer r103 = null;
        if (r102 == null) goto L7;
        NextLiveData<Boolean> r104 = r102.Fc();
        if (r104 == null) goto L7;
        Boolean r105 = r104.getValue();
    L8:
        Boolean r106 = Boolean.TRUE;
        if (Intrinsics.areEqual(r105, r106) == false) goto L11;
        List<ILinkPlayerInfoBridge> r107 = ((qr2.c) vh6.c.b(qr2.c.class)).yi(true);
    L12:
        ld.a r108 = r100.D;
        if (r108 == null) goto L17;
        NextLiveData<Boolean> r109 = r108.z9();
        if (r109 == null) goto L17;
        Boolean r110 = r109.getValue();
    L19:
        if (Intrinsics.areEqual(r110, r106) == false) goto L21;
        List<ILinkPlayerInfoBridge> r111 = ((qr2.c) vh6.c.b(qr2.c.class)).yi(false);
    L22:
        if (r107 == null) goto L24;
        Integer r112 = Integer.valueOf(r107.size());
    L25:
        r101.put("left_guest_count", r112);
        if (r107 == null) goto L31;
        List<ILinkPlayerInfoBridge> r113 = r107;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r115 = r113.iterator();
    L29:
        if (r115.hasNext() == false) goto L32;
        r114.add(new JSONObject(com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.e((ILinkPlayerInfoBridge) r115.next())));
    L32:
        int r116 = com.bytedance.revenue.platform.api.core.b.f267506a;
        List r117 = r114;
        if (r114 != null) goto L35;
        r117 = CollectionsKt.emptyList();
    L35:
        r101.put("left_guest_list", JSONObject.wrap(r117));
        if (r111 == null) goto L41;
        List<ILinkPlayerInfoBridge> r118 = r111;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator<T> r120 = r118.iterator();
    L39:
        if (r120.hasNext() == false) goto L42;
        r119.add(new JSONObject(com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.e((ILinkPlayerInfoBridge) r120.next())));
    L42:
        int r121 = com.bytedance.revenue.platform.api.core.b.f267506a;
        List r122 = r119;
        if (r119 != null) goto L45;
        r122 = CollectionsKt.emptyList();
    L45:
        r101.put("right_guest_list", JSONObject.wrap(r122));
        if (r111 == null) goto L48;
        r103 = Integer.valueOf(r111.size());
    L48:
        r101.put("right_guest_count", r103);
        r100.f93982o.setValue(r101);
        return;
    L41:
        r119 = null;
        goto L42
    L31:
        r114 = null;
        goto L32
    L24:
        r112 = null;
        goto L25
    L21:
        r111 = CollectionsKt.emptyList();
    L17:
        r110 = null;
        goto L19
    L11:
        r107 = CollectionsKt.emptyList();
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f93993z.containsKey(r100) == false) goto L35;
        LiveData<?> r101 = this.f93993z.get(r100);
        Object r102 = null;
        if (r101 == null) goto L7;
        Object r103 = r101.getValue();
    L9:
        if ((r103 instanceof String) == false) goto L17;
        LiveData<?> r104 = this.f93993z.get(r100);
        if (r104 == null) goto L13;
        r102 = r104.getValue();
    L13:
        if (r102 == null) goto L16;
        return (String) r102;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L17:
        LiveData<?> r105 = this.f93993z.get(r100);
        if (r105 == null) goto L20;
        Object r106 = r105.getValue();
    L22:
        if ((r106 instanceof JSONObject) == false) goto L30;
        LiveData<?> r107 = this.f93993z.get(r100);
        if (r107 == null) goto L79;
        Object r108 = r107.getValue();
        if (r108 == null) goto L80;
        String r109 = r108.toString();
        if (r109 != null) goto L86;
        return "";
    L86:
        return r109;
    L80:
        return "";
    L79:
        return "";
    L30:
        LiveData<?> r110 = this.f93993z.get(r100);
        if (r110 == null) goto L33;
        r102 = r110.getValue();
    L33:
        r109 = GsonProtectorUtils.toJson(l97.a.f508113a, r102);
        goto L86
    L20:
        r106 = null;
        goto L22
    L7:
        r103 = null;
        goto L9
    L35:
        if (Intrinsics.areEqual(r100, "linkmic_score") == false) goto L47;
        ProfitInteractionDataContext r111 = l();
        if (r111 == null) goto L44;
        com.bytedance.live.datacontext.n<c8> r112 = r111.getCurrentMessage();
        if (r112 == null) goto L44;
        c8 r113 = r112.getValue();
        if (r113 == null) goto L44;
        Object r114 = r113.getAnchorInfoMap();
        if (r114 == null) goto L44;
    L81:
        return r114.toString();
    L44:
        r114 = new JSONObject();
        goto L81
    L47:
        if (Intrinsics.areEqual(r100, "prop_card_info") == false) goto L56;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r115 = this.G;
        if (r115 == null) goto L82;
        LiveData<String> r116 = r115.getBattleEffectInfo();
        if (r116 == null) goto L83;
        r109 = r116.getValue();
        if (r109 != null) goto L86;
        return "";
    L83:
        return "";
    L82:
        return "";
    L56:
        if (Intrinsics.areEqual(r100, "battle_settings") == false) goto L66;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r117 = this.G;
        if (r117 == null) goto L84;
        IBattleConfigSetting r118 = r117.getConfigSetting();
        if (r118 == null) goto L85;
        r109 = r118.toString();
        if (r109 != null) goto L86;
        return "";
    L85:
        return "";
    L84:
        return "";
    L66:
        if (Intrinsics.areEqual(r100, "play_anchor_list") == false) goto L75;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r119 = this.G;
        if (r119 == null) goto L87;
        Map<String, IBattleUserInfo> r120 = r119.getUserInfoMap();
        if (r120 == null) goto L88;
        r109 = r120.toString();
        if (r109 != null) goto L86;
        return "";
    L88:
        return "";
    L87:
        return "";
    L75:
        if (Intrinsics.areEqual(r100, "play_duration") == true) goto L77;
        return "";
    L77:
        return String.valueOf(l51.a.j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r17v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void m(f31.i r210) {
        e0 r100 = this;
        com.bytedance.android.live.revlink.impl.global.c r101 = r100.F;
        if (r101 == null) goto L7;
        LinkCrossRoomDataHolder r102 = r101.getLinkCrossRoomDataHolder();
        if (r102 == null) goto L7;
        String r103 = String.valueOf(r102.c());
    L9:
        if ((!Intrinsics.areEqual(r103, r100.f93969b.getValue())) == false) goto L17;
        MutableLiveData<String> r104 = r100.f93969b;
        com.bytedance.android.live.revlink.impl.global.c r105 = r100.F;
        if (r105 == null) goto L15;
        LinkCrossRoomDataHolder r106 = r105.getLinkCrossRoomDataHolder();
        if (r106 == null) goto L15;
        String r107 = String.valueOf(r106.c());
    L16:
        r104.setValue(r107);
    L15:
        r107 = null;
    L17:
        if (r210 == null) goto L19;
        List<f31.k> r108 = r210.f475339a;
    L20:
        List<f31.k> r109 = r108;
        if (r109 != null) goto L23;
    L26:
        boolean r110 = true;
    L27:
        if (r110 == false) goto L29;
        return;
    L29:
        JSONObject r111 = new JSONObject();
        JSONObject r112 = r210.f475343e;
        RevSeiFrame r113 = r210.f475342d;
        d51.b r114 = d51.b.f466913m;
        r114.getClass();
        String r115 = "";
        String r116 = "ai_user_infos";
        if (((Boolean) d51.b.f466911k.getValue(r114, d51.b.f466901a[9])).booleanValue() == false) goto L36;
        if (r112 == null) goto L36;
        JSONArray r117 = j();
        if (r117.length() <= 0) goto L35;
        r112.put("ai_user_infos", r117);
    L35:
        List<f31.k> r118 = r108;
        JSONObject r119 = r111;
        String r211 = "";
        e0 r120 = r100;
        ?? r121 = r112;
    L158:
        ?? r122 = r119;
        r122.put("app_data", r121);
        int r123 = f31.l.e(r118);
        int r124 = f31.l.a(r118);
        f31.l.c(r118);
        f31.l.d(r118);
        JSONObject r125 = new JSONObject();
        b03.a r126 = b03.a.f16857a;
        r125.put("screen_width", Float.valueOf(b03.c.c(s1.y())));
        r125.put("screen_height", Float.valueOf(b03.c.c(s1.w())));
        r125.put("container_width", r123);
        r125.put("container_height", r124);
        com.bytedance.android.live.revlink.impl.global.c r127 = r120.F;
        if (r127 == null) goto L164;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r128 = r127.Ig();
        if (r128 == null) goto L164;
        List<String> r129 = r128.getAudioPunishUserIds();
        if (r129 == null) goto L164;
    L165:
        r125.put("punish_user_ids", new JSONArray(r129));
        Integer r130 = r210.f475344f;
        if (r130 == null) goto L168;
        r125.put("meta_sei_container_height", r130.intValue());
    L168:
        Integer r131 = r210.f475345g;
        if (r131 == null) goto L171;
        r125.put("meta_sei_container_width", r131.intValue());
    L171:
        String r132 = r210.f475340b;
        if (r132 != null) goto L174;
        r132 = r120.f93972e;
    L174:
        if (r132 != null) goto L176;
        String r133 = r211;
    L177:
        r122.put("meta_sei", r133);
        r122.put("extra_info", r125);
        r120.f93968a.setValue(r122);
        return;
    L176:
        r133 = r132;
    L164:
        r129 = CollectionsKt.emptyList();
    L36:
        if (r112 == null) goto L38;
        com.bytedance.android.livesdk.model.p0 r134 = com.bytedance.android.live.revlink.impl.utils.h.a(r112);
    L39:
        ?? r135 = new JSONObject();
        r135.put("ver", 6);
        o r136 = r100.f93967J;
        if (r136 == null) goto L42;
        String r137 = r136.c();
    L43:
        JSONObject r138 = new JSONObject();
        if (r137 != null) goto L46;
        r137 = "0";
    L46:
        r138.put("focus_id", r137);
        o r139 = r100.f93967J;
        if (r139 == null) goto L49;
        Integer r140 = r139.a();
    L50:
        r138.put("layout_type", r140);
        o r141 = r100.f93967J;
        if (r141 == null) goto L53;
        Integer r142 = r141.b();
    L54:
        r138.put("layout_range", r142);
        Iterator<f31.k> r143 = r108.iterator();
        int r144 = 0;
    L56:
        if (r143.hasNext() == false) goto L68;
        f31.k r145 = r143.next();
        String r146 = r100.L;
        if (r146 != null) goto L60;
    L64:
        boolean r147 = false;
    L65:
        if (r147 == true) goto L69;
        r144 = r144 + 1;
    L69:
        r138.put("owner_index", RangesKt.coerceAtLeast(r144, 0));
        com.bytedance.android.live.revlink.impl.global.c r148 = r100.F;
        if (r148 == null) goto L74;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r149 = r148.getMultiLinkUtil();
        if (r149 == null) goto L74;
        UILayout r150 = r149.b();
    L76:
        if (r150 != UILayout.FULL_RECORD) goto L78;
        r138.put("is_horizontal", 1);
    L78:
        r135.put("anchor_interact_info", r138);
        if (r113 == null) goto L89;
        if (r113.p() != true) goto L89;
        com.bytedance.android.livesdk.model.p0 r151 = r113.b();
        if (r151 == null) goto L86;
        String r152 = r151.c();
        if (r152 == null) goto L86;
    L87:
        r135.put("layout_key", r152);
    L105:
        ?? r153 = new JSONArray();
        Iterator r154 = r108.iterator();
        JSONObject r155 = r112;
        ?? r156 = r135;
    L107:
        if (r154.hasNext() == false) goto L132;
        f31.k r157 = (f31.k) r154.next();
        String r158 = r157.f475348a;
        double r159 = r157.f475350c;
        List<f31.k> r160 = r108;
        double r161 = r157.f475351d;
        JSONObject r162 = r111;
        Iterator r212 = r154;
        double r163 = r157.f475352e;
        String r213 = r115;
        String r214 = r116;
        double r164 = r157.f475353f;
        boolean r165 = r157.f475354g;
        JSONObject r215 = r155;
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r166 = r100.K;
        if (r166 == null) goto L111;
        ?? r167 = r166.j(null, r158);
    L112:
        if (r134 == null) goto L126;
        List<RevSeiRegion> r168 = r134.h();
        if (r168 == null) goto L126;
        Iterator r169 = r168.iterator();
    L117:
        if (r169.hasNext() == false) goto L122;
        Object r216 = r169.next();
        com.bytedance.android.livesdk.model.p0 r217 = r134;
        if (Intrinsics.areEqual(((RevSeiRegion) r216).getUidStr(), r157.f475348a) == true) goto L123;
        r134 = r217;
    L123:
        RevSeiRegion r218 = (RevSeiRegion) r216;
        if (r218 == null) goto L127;
        int r170 = r218.getTalkVolume();
    L128:
        IRegion.Status r171 = IRegion.Status.FOREGROUND;
        Intrinsics.checkNotNullParameter(r171, "status");
        ?? r172 = new JSONObject();
        ?? r173 = r156;
        if (r158 != null) goto L131;
        r158 = r213;
    L131:
        r172.put("uid_str", r158);
        r172.put("loading", r165 ? 1 : 0);
        r172.put("x", r159);
        r172.put("y", r161);
        r172.put("w", r163);
        r172.put("h", r164);
        r172.put("mute_audio", r167);
        r172.put("talk_volume", r170);
        r172.put(CloudControlInf.STAT, r171.toSeiFormat());
        r153.put(r172);
        r100 = this;
        r156 = r173;
        r108 = r160;
        r111 = r162;
        r154 = r212;
        r115 = r213;
        r116 = r214;
        r155 = r215;
        r134 = r217;
    L127:
        r170 = 0;
        goto L128
    L122:
        r217 = r134;
        r216 = null;
    L126:
        r217 = r134;
        goto L127
    L111:
        r167 = 0;
        goto L112
    L132:
        r118 = r108;
        r119 = r111;
        JSONObject r219 = r155;
        r211 = r115;
        String r220 = r116;
        ?? r174 = r156;
        r174.put("grids", r153);
        Object r175 = null;
        r120 = this;
        e r176 = r120.H;
        if (r176 == null) goto L139;
        com.bytedance.live.datacontext.m<Long> r177 = r176.getChannelId();
        if (r177 == null) goto L139;
        Long r178 = r177.getValue();
        if (r178 == null) goto L139;
        long r179 = r178.longValue();
    L140:
        r174.put("channel_id", r179);
        if (r120.f93981n == false) goto L146;
        JSONArray r180 = j();
        if (r180.length() <= 0) goto L157;
        r174.put(r220, r180);
    L157:
        r121 = r174;
        goto L158
    L146:
        if (r219 == null) goto L148;
        Object r181 = r219.opt(r220);
    L150:
        if ((r181 instanceof JSONArray) == false) goto L153;
        r175 = r181;
    L153:
        JSONArray r182 = (JSONArray) r175;
        if (r182 != null) goto L156;
        r182 = new JSONArray();
    L156:
        r174.put(r220, r182);
        goto L157
    L148:
        r181 = null;
    L139:
        r179 = 0;
    L86:
        r152 = "";
    L89:
        if (r100.f93981n == false) goto L105;
        com.bytedance.android.live.revlink.impl.global.c r183 = r100.F;
        if (r183 == null) goto L97;
        RevLinkWindowRegionContext r184 = r183.P8();
        if (r184 == null) goto L97;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r185 = r184.getPartnerService();
        if (r185 == null) goto L97;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r186 = r185.getValue();
    L98:
        if (r186 == null) goto L105;
        if (r186.n() != true) goto L105;
        String r187 = r186.mo8197c();
        if (r187 != null) goto L104;
        r187 = "";
    L104:
        r135.put("layout_key", r187);
    L97:
        r186 = null;
    L74:
        r150 = null;
        goto L76
    L60:
        if ((!StringsKt.isBlank(r146)) != true) goto L64;
        if (Intrinsics.areEqual(r100.L, r145.f475348a) == false) goto L64;
        r147 = true;
        goto L65
    L68:
        r144 = -1;
        goto L69
    L53:
        r142 = null;
        goto L54
    L49:
        r140 = null;
        goto L50
    L42:
        r137 = null;
        goto L43
    L38:
        r134 = null;
        goto L39
    L23:
        if (r109.isEmpty() == true) goto L26;
        r110 = false;
        goto L27
    L19:
        r108 = null;
    L7:
        r103 = null;
        goto L9
    }

    public static final JSONObject c(e0 r110, int r111) {
        r110.getClass();
        JSONObject r100 = new JSONObject();
        r100.put("state", r111);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r101 = r110.G;
        if (r101 == null) goto L7;
        IBaseBattleSetting r102 = r101.getBattleSettings();
        if (r102 == null) goto L7;
        JSONObject r103 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r102);
    L8:
        r100.put("battle_settings", r103);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r104 = r110.G;
        if (r104 == null) goto L11;
        Map<String, IBattleUserInfo> r105 = r104.getUserInfoMap();
    L12:
        if (r105 == null) goto L14;
        JSONObject r106 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r105);
    L15:
        r100.put("play_anchor_list", r106);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r107 = r110.G;
        if (r107 == null) goto L20;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r108 = r107.getPkSkinConfig();
        if (r108 == null) goto L20;
        Long r109 = Long.valueOf(r108.f92697a);
    L21:
        r100.put("skin_type", r109.longValue());
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r112 = r110.G;
        if (r112 == null) goto L28;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r113 = r112.getPkSkinConfig();
        if (r113 == null) goto L28;
        x2 r114 = r113.f92698b;
        if (r114 == null) goto L28;
        JSONObject r115 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r114);
    L29:
        r100.put("skin_config", r115);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r116 = r110.G;
        if (r116 == null) goto L34;
        LiveData<Long> r117 = r116.getBaseTimeLeft();
        if (r117 == null) goto L34;
        Long r118 = r117.getValue();
    L35:
        r100.put("remain_time", r118);
        Map<String, PkBaseResult> r119 = r110.G.getCurPkResultMap();
        if (r119 == null) goto L40;
        PkBaseResult r120 = r119.get(r110.k());
        if (r120 == null) goto L40;
        Integer r121 = Integer.valueOf(r120.ordinal());
    L41:
        r100.put("result", r121);
        Map<String, PkBaseResult> r122 = r110.G.getCurPkResultMap();
        if (r122 == null) goto L46;
        PkBaseResult r123 = r122.get(r110.k());
        if (r123 == null) goto L46;
        Integer r124 = Integer.valueOf(r123.ordinal());
    L48:
        if (r124 != null) goto L93;
        if (r111 == RevPkState.PK.ordinal()) goto L93;
        if (r105 == null) goto L55;
        IBattleUserInfo r125 = r105.get(r110.k());
        if (r125 == null) goto L55;
        Integer r126 = Integer.valueOf(r125.getPkResult());
    L57:
        if (r105 == null) goto L59;
        int r127 = r105.size();
    L61:
        if (r127 <= 2) goto L86;
        if (r105 == null) goto L76;
        Iterator<Map.Entry<String, IBattleUserInfo>> r128 = r105.entrySet().iterator();
        boolean r129 = true;
    L65:
        if (r128.hasNext() == false) goto L77;
        Map.Entry<String, IBattleUserInfo> r130 = r128.next();
        String r131 = r130.getKey();
        IBattleUserInfo r132 = r130.getValue();
        if (r132 == null) goto L69;
        Integer r133 = Integer.valueOf(r132.getPkResult());
    L70:
        int r134 = r133.intValue();
        if (r126 == null) goto L75;
        if (r134 == r126.intValue()) goto L65;
    L75:
        r129 = false;
        goto L65
    L69:
        r133 = null;
    L77:
        if (r129 == false) goto L79;
        int r135 = RevPkResult.EVEN.ordinal();
    L83:
        Integer r136 = Integer.valueOf(r135);
    L85:
        r100.put("result", r136);
        goto L93
    L79:
        if (r105 == null) goto L84;
        IBattleUserInfo r137 = r105.get(r110.k());
        if (r137 == null) goto L84;
        r135 = r137.getPkResult();
    L84:
        r136 = null;
        goto L85
    L76:
        r129 = true;
        goto L77
    L86:
        if (r105 == null) goto L90;
        IBattleUserInfo r138 = r105.get(r110.k());
        if (r138 == null) goto L90;
        Integer r139 = Integer.valueOf(r138.getPkResult());
    L91:
        r100.put("result", r139);
    L90:
        r139 = null;
        goto L91
    L59:
        r127 = 0;
    L55:
        r126 = null;
    L93:
        if (r110.G.getUserIdToTeamId() == null) goto L102;
        Map<String, Long> r140 = r110.G.getUserIdToTeamId();
        if (r140 == null) goto L100;
        LinkedHashMap r141 = new LinkedHashMap(MapsKt.mapCapacity(r140.size()));
        Iterator<T> r142 = r140.entrySet().iterator();
    L98:
        if (r142.hasNext() == false) goto L101;
        Map.Entry r143 = (Map.Entry) r142.next();
        r141.put(r143.getKey(), Integer.valueOf(((int) ((Number) r143.getValue()).longValue()) - 1));
    L101:
        r100.put("team_info", new JSONObject(GsonProtectorUtils.toJson(l97.a.f508113a, r141)));
        goto L102
    L100:
        r141 = null;
    L102:
        JSONObject r144 = new JSONObject();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r145 = r110.G.getBattleScoreData().getValue();
        if (r145 == null) goto L106;
        List<af2.b> r146 = r145.b();
        if (r146 == null) goto L106;
    L107:
        List<af2.b> r147 = r146;
        ArrayList r148 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r147, 10));
        Iterator<T> r149 = r147.iterator();
    L109:
        if (r149.hasNext() == false) goto L111;
        r148.add(new JSONObject(GsonProtectorUtils.toJson(l97.a.f508113a, r149.next())));
        goto L109
    L111:
        int r150 = com.bytedance.revenue.platform.api.core.b.f267506a;
        r144.put("battle_scores", JSONObject.wrap(r148));
        LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r151 = r110.G.getBattleScoreData();
        if (r151 == null) goto L118;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r152 = r151.getValue();
        if (r152 == null) goto L118;
        n3 r153 = r152.a();
        if (r153 == null) goto L118;
        JSONObject r154 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r153);
    L119:
        r144.put("pve_data", r154);
        LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r155 = r110.G.getBattleScoreData();
        if (r155 == null) goto L146;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r156 = r155.getValue();
        if (r156 == null) goto L146;
        int r157 = r156.c();
        if (r157 != PkBaseStateMachine.Source.Init.ordinal()) goto L126;
    L144:
        int r158 = 5;
    L145:
        r144.put("source", r158);
        goto L146
    L126:
        if (r157 == PkBaseStateMachine.Source.ChangeMode.ordinal()) goto L144;
        if (r157 == PkBaseStateMachine.Source.NormalToMultiple.ordinal()) goto L144;
        if (r157 == PkBaseStateMachine.Source.RelinkSuccess.ordinal()) goto L144;
        if (r157 == PkBaseStateMachine.Source.DoublePkLinkInPeak.ordinal()) goto L144;
        if (r157 != PkBaseStateMachine.Source.BattleMsg.ordinal()) goto L138;
        r158 = 3;
        goto L145
    L138:
        if (r157 == PkBaseStateMachine.Source.MetaUpdate.ordinal()) goto L140;
        r158 = 6;
        goto L145
    L140:
        if (r110.f93981n == true) goto L144;
        r158 = 7;
    L146:
        r100.put("play_scores", r144);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r159 = r110.G;
        if (r159 == null) goto L151;
        LiveData<String> r160 = r159.getTeamTaskLynxData();
        if (r160 == null) goto L151;
        String r161 = r160.getValue();
    L152:
        r100.put("team_task", r161);
        r100.put("contribution_list", null);
        r100.put("channel_id", r110.f93969b.getValue());
        return r100;
    L151:
        r161 = null;
    L118:
        r154 = null;
    L106:
        r146 = CollectionsKt.emptyList();
    L46:
        r124 = null;
    L40:
        r121 = null;
    L34:
        r118 = null;
    L28:
        r115 = null;
    L20:
        r109 = null;
        goto L21
    L14:
        r106 = null;
        goto L15
    L11:
        r105 = null;
    L7:
        r103 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkDynamicDataContext$needShowLastResultObserver$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkDynamicDataContext$onPartnerEnableObserver$1] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkDynamicDataContext$onMixStreamObserver$1] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkDynamicDataContext$pkStateObserver$1] */
    public e0(Function0 r110, ld.a r111, com.bytedance.android.livesdk.revenue.service.room.c r112, com.bytedance.android.live.revlink.impl.global.c r210, PkBaseDataContext r211, DynamicContextDependencyImpl r212, AnchorLinkUserCenterV2 r213, DynamicContextDependencyImpl r214, com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r215, com.bytedance.android.live.revlink.impl.multianchor.ui.i r216, String r217, com.bytedance.android.live.revlink.impl.global.c r218) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r211, "pkBaseDataContext");
        this.C = r110;
        this.D = r111;
        this.E = r112;
        this.F = r210;
        this.G = r211;
        this.H = r212;
        this.I = r213;
        this.f93967J = r215;
        this.K = r216;
        this.L = r217;
        this.M = r218;
        MutableLiveData<JSONObject> r100 = new MutableLiveData();
        this.f93968a = r100;
        MutableLiveData<String> r101 = new MutableLiveData();
        this.f93969b = r101;
        this.f93970c = new MutableLiveData();
        this.f93971d = new CompositeDisposable();
        MutableLiveData<JSONObject> r102 = new MutableLiveData();
        this.f93973f = r102;
        MutableLiveData<Long> r103 = new MutableLiveData();
        this.f93974g = r103;
        MutableLiveData<String> r104 = new MutableLiveData();
        this.f93975h = r104;
        MutableLiveData<String> r105 = new MutableLiveData();
        this.f93976i = r105;
        MutableLiveData<String> r106 = new MutableLiveData();
        this.f93977j = r106;
        MutableLiveData<JSONObject> r113 = new MutableLiveData();
        this.f93978k = r113;
        MutableLiveData<Integer> r114 = new MutableLiveData();
        this.f93979l = r114;
        MutableLiveData<Boolean> r115 = new MutableLiveData();
        this.f93980m = r115;
        com.bytedance.android.livesdk.revenue.room.a r107 = r112.getRoomContext();
        if (r107 == null) goto L7;
        boolean r116 = true;
        if (r107.getCommonIsAnchor() != true) goto L7;
    L8:
        this.f93981n = r116;
        MutableLiveData<JSONObject> r108 = new MutableLiveData();
        this.f93982o = r108;
        MutableLiveData<List<com.bytedance.android.livesdk.link.model.e>> r117 = new MutableLiveData();
        this.f93983p = r117;
        MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> r118 = new MutableLiveData();
        this.f93984q = r118;
        MutableLiveData r119 = new MutableLiveData();
        this.f93985r = new MutableLiveData();
        this.f93986s = new w(this);
        this.f93987t = new RevLinkDynamicDataContext$needShowLastResultObserver$1(this);
        this.f93988u = new RevLinkDynamicDataContext$onPartnerEnableObserver$1(this);
        this.f93989v = new RevLinkDynamicDataContext$onMixStreamObserver$1(this);
        this.f93990w = new d0(this);
        this.f93991x = new r(this);
        this.f93992y = new RevLinkDynamicDataContext$pkStateObserver$1(this);
        HashMap<String, LiveData<?>> r109 = new HashMap();
        r109.put("channel_id", r101);
        r109.put("sei", r100);
        r109.put("screen_info", r102);
        r109.put("interact_timer_count", r104);
        r109.put("interact_start_time", r103);
        r109.put("clean_screen", r115);
        r109.put("team_task", r211.getTeamTaskLynxData());
        LiveData<Long> r120 = r211.getBaseTimeLeft();
        MediatorLiveData r121 = new MediatorLiveData();
        r121.addSource(r120, new s(r121, this));
        r109.put("play_remain_time", r121);
        r109.put("show_last_result", r105);
        r109.put("double_mute_status", r106);
        r109.put("intercom_data", r113);
        MediatorLiveData r122 = new MediatorLiveData();
        r122.addSource(r114, new RevLinkDynamicDataContext$packagePlayStatus$$inlined$also$lambda$1(r122, this));
        r109.put("play_status", r122);
        MediatorLiveData r123 = new MediatorLiveData();
        r123.addSource(r118, new RevLinkDynamicDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1(r123, this));
        r109.put("link_anchor_list", r123);
        r109.put("game_data", r119);
        r109.put("intercom_data", r113);
        r109.put("guest_info", r108);
        MediatorLiveData r124 = new MediatorLiveData();
        r124.addSource(r117, new RevLinkDynamicDataContext$transformAIAnchorList$$inlined$also$lambda$1(r124, this));
        r109.put("ai_anchor_list", r124);
        Unit r125 = Unit.INSTANCE;
        this.f93993z = r109;
        LinkedHashMap r126 = new LinkedHashMap(MapsKt.mapCapacity(r109.size()));
        Iterator r127 = r109.entrySet().iterator();
    L10:
        if (r127.hasNext() == false) goto L12;
        Map.Entry r128 = (Map.Entry) r127.next();
        Object r129 = r128.getKey();
        String r130 = (String) r128.getKey();
        r126.put(r129, com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.b((LiveData) r128.getValue(), r130, FormatType.NEW));
        goto L10
    L12:
        this.A = r126;
        return;
    L7:
        r116 = false;
        goto L8
    }
}
