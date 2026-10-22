package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.FormatType;
import com.bytedance.android.live.revlink.impl.multianchor.feed.wm.FeedMultiWindowManager;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.x2;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class o0 implements com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f94039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<String> f94040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<JSONObject> f94041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> f94042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.a f94043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MediatorLiveData f94044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f94045g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, LiveData<?>> f94046h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, LiveData<Pair<String, JSONObject>>> f94047i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c f94048j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FeedMultiWindowManager f94049k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a f94050l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Pair<Integer, Integer>> f94051m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final com.bytedance.android.live.revlink.impl.monitor.b a() {
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveFullLinkPKMonitor d() {
        com.bytedance.android.live.revlink.impl.global.c r100 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLiveFullLinkPKMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final MultiEnterRoomTracer e() {
        com.bytedance.android.live.revlink.impl.global.c r100 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.i7();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final HashMap<String, LiveData<?>> b() {
        return this.f94046h;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData<Boolean> getChangeScreenEvent() {
        return this.f94045g;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData<f31.i> getWindowStatus() {
        return this.f94044f;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final Map<String, LiveData<Pair<String, JSONObject>>> h() {
        return this.f94047i;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i
    public final void c(List<? extends com.bytedance.android.livesdk.link.model.p> r100) {
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r101 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97568m;
        r101.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97564i.getValue(r101, com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97556a[7])).booleanValue() == false) goto L12;
        if (r100 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return;
    L6:
        if (r100.isEmpty() == true) goto L9;
        r102 = false;
    L12:
        StringBuilder r103 = new StringBuilder("onOnlineListRefresh list = ");
        ArrayList r104 = null;
        if (r100 == null) goto L15;
        String r105 = r100.toString();
    L16:
        r103.append(r105);
        r103.append(", wrappedList = ");
        if (r100 == null) goto L22;
        r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r106 = r100.iterator();
    L20:
        if (r106.hasNext() == false) goto L22;
        r104.add(new com.bytedance.android.live.revlink.impl.multianchor.dynamic.f((com.bytedance.android.livesdk.link.model.p) r106.next()));
    L22:
        r103.append(String.valueOf(r104));
        jy0.b.d("multi_lynx", r103.toString());
        this.f94042d.setValue(r100);
        return;
    L15:
        r105 = null;
        goto L16
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final void g(zy0.b r100) {
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.a r101 = this.f94043e;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public final JSONObject j(k31.f r110) {
        JSONObject r100 = new JSONObject();
        RevSeiFrame.a r101 = RevSeiFrame.G;
        String r102 = r110.f501647c;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        int r103 = 0;
        RevSeiFrame r104 = RevSeiFrame.a.a(r101, r102, false, 6);
        List<f31.k> r105 = this.f94049k.f94338a.getValue();
        if (r105 == null) goto L8;
        int r106 = f31.l.e(r105);
    L9:
        if (r105 == null) goto L11;
        r103 = f31.l.a(r105);
    L11:
        JSONObject r107 = new JSONObject();
        r107.put("screen_width", s1.y());
        r107.put("screen_height", s1.w());
        r107.put("container_width", r106);
        r107.put("container_height", r103);
        r107.put("player_width", this.f94051m.invoke().getFirst().intValue());
        r107.put("player_height", this.f94051m.invoke().getSecond().intValue());
        r100.put("extra_info", r107);
        JSONObject r108 = new JSONObject();
        r108.put("ver", r104.n());
        JSONObject r109 = new JSONObject();
        com.bytedance.android.livesdk.model.p0 r111 = r110.f501646b;
        if (r111 == null) goto L17;
        com.bytedance.android.livesdk.model.m0 r112 = r111.f();
        if (r112 == null) goto L17;
        String r113 = r112.b();
        if (r113 == null) goto L17;
    L18:
        r109.put("focus_id", r113);
        com.bytedance.android.livesdk.model.p0 r114 = r110.f501646b;
        if (r114 == null) goto L23;
        com.bytedance.android.livesdk.model.m0 r115 = r114.f();
        if (r115 == null) goto L23;
        Integer r116 = Integer.valueOf(r115.c());
    L24:
        r109.put("layout_type", r116);
        com.bytedance.android.livesdk.model.p0 r117 = r110.f501646b;
        if (r117 == null) goto L29;
        com.bytedance.android.livesdk.model.m0 r118 = r117.f();
        if (r118 == null) goto L29;
        Integer r119 = Integer.valueOf(r118.d());
    L30:
        r109.put("owner_index", r119);
        com.bytedance.android.livesdk.model.p0 r120 = r110.f501646b;
        if (r120 == null) goto L37;
        com.bytedance.android.livesdk.model.m0 r121 = r120.f();
        if (r121 == null) goto L37;
        if (r121.c() != o51.f.d.f522062e.f522057b) goto L37;
        r109.put("is_horizontal", 1);
    L37:
        r108.put("anchor_interact_info", r109);
        JSONArray r122 = new JSONArray();
        com.bytedance.android.livesdk.model.p0 r123 = r110.f501646b;
        if (r123 == null) goto L50;
        List<RevSeiRegion> r124 = r123.e();
        if (r124 == null) goto L50;
        Iterator<T> r125 = r124.iterator();
    L43:
        if (r125.hasNext() == false) goto L50;
        String r126 = l97.a.f508113a.toJson((RevSeiRegion) r125.next());     // Catch: Exception -> L47
    L49:
        r122.put(new JSONObject(r126));
    L47:
        e = move-exception;
        jy0.b.c("RevNewDynamicFeedDataContext", "parse object failed " + e, null, 4);
        r126 = "";
    L50:
        r108.put("grids", r122);
        r108.put("channel_id", r110.a());
        r100.put("app_data", r108);
        r100.put("meta_sei", r110.f501647c);
        return r100;
    L29:
        r119 = null;
    L23:
        r116 = null;
    L17:
        r113 = "0";
        goto L18
    L8:
        r106 = 0;
        goto L9
    }

    public static final JSONObject i(o0 r100, int r101) {
        r100.getClass();
        JSONObject r102 = new JSONObject();
        r102.put("state", r101);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r103 = r100.f94048j;
        String r104 = null;
        if (r103 == null) goto L7;
        IBaseBattleSetting r105 = r103.f94138g;
        if (r105 == null) goto L7;
        JSONObject r106 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r105);
    L8:
        r102.put("battle_settings", r106);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r107 = r100.f94048j;
        if (r107 == null) goto L11;
        Map<String, ? extends IBattleUserInfo> r108 = r107.f94150s;
    L12:
        if (r108 == null) goto L14;
        JSONObject r109 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r108);
    L15:
        r102.put("play_anchor_list", r109);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r110 = r100.f94048j;
        if (r110 == null) goto L20;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r111 = r110.f94149r;
        if (r111 == null) goto L20;
        Long r112 = Long.valueOf(r111.f92697a);
    L21:
        r102.put("skin_type", r112);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r113 = r100.f94048j;
        if (r113 == null) goto L28;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r114 = r113.f94149r;
        if (r114 == null) goto L28;
        x2 r115 = r114.f92698b;
        if (r115 == null) goto L28;
        JSONObject r116 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r115);
    L29:
        r102.put("skin_config", r116);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r117 = r100.f94048j;
        if (r117 == null) goto L34;
        MutableLiveData<Long> r118 = r117.f94142k;
        if (r118 == null) goto L34;
        Long r119 = r118.getValue();
    L35:
        r102.put("remain_time", r119);
        r102.put("result", r100.f94048j.f94145n.getValue());
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r120 = r100.f94048j.F.f94285e;
        if ((r120 instanceof com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h) == true) goto L38;
        r120 = null;
    L38:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h r121 = (com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h) r120;
        if (r121 == null) goto L41;
        Map<String, Long> r122 = r121.f94305a;
    L42:
        if (r122 == null) goto L48;
        LinkedHashMap r123 = new LinkedHashMap(MapsKt.mapCapacity(r122.size()));
        Iterator<T> r124 = r122.entrySet().iterator();
    L45:
        if (r124.hasNext() == false) goto L47;
        Map.Entry r125 = (Map.Entry) r124.next();
        r123.put(r125.getKey(), Integer.valueOf(((int) ((Number) r125.getValue()).longValue()) - 1));
        goto L45
    L47:
        r102.put("team_info", new JSONObject(r123));
    L48:
        JSONObject r126 = new JSONObject();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r127 = r100.f94048j.f94144m.getValue();
        if (r127 == null) goto L52;
        List<af2.b> r128 = r127.b();
        if (r128 == null) goto L52;
    L53:
        List<af2.b> r129 = r128;
        ArrayList r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator<T> r131 = r129.iterator();
    L55:
        if (r131.hasNext() == false) goto L57;
        r130.add(new JSONObject(GsonProtectorUtils.toJson(l97.a.f508113a, r131.next())));
        goto L55
    L57:
        int r132 = com.bytedance.revenue.platform.api.core.b.f267506a;
        r126.put("battle_scores", JSONObject.wrap(r130));
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r133 = r100.f94048j.f94144m.getValue();
        if (r133 == null) goto L62;
        n3 r134 = r133.a();
        if (r134 == null) goto L62;
        JSONObject r135 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r134);
    L63:
        r126.put("pve_data", r135);
        r102.put("play_scores", r126);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r136 = r100.f94048j;
        if (r136 == null) goto L68;
        MutableLiveData<String> r137 = r136.f94146o;
        if (r137 == null) goto L68;
        r104 = r137.getValue();
    L68:
        r102.put("team_task", r104);
        r102.put("channel_id", r100.f94040b.getValue());
        return r102;
    L62:
        r135 = null;
    L52:
        r128 = CollectionsKt.emptyList();
        goto L53
    L41:
        r122 = null;
    L34:
        r119 = null;
    L28:
        r116 = null;
    L20:
        r112 = null;
        goto L21
    L14:
        r109 = null;
        goto L15
    L11:
        r108 = null;
    L7:
        r106 = null;
        goto L8
    }

    public o0(com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r100, FeedMultiWindowManager r101, com.bytedance.android.live.revlink.impl.pk.scopeservice.a r102, FeedMultiWindowManager r103, Function0 r104) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
        Intrinsics.checkNotNullParameter(r101, "windowManager");
        Intrinsics.checkNotNullParameter(r103, "dynamicWindowManager");
        Intrinsics.checkNotNullParameter(r104, "getPlayerWH");
        this.f94048j = r100;
        this.f94049k = r101;
        this.f94050l = r102;
        this.f94051m = r104;
        this.f94039a = new CompositeDisposable();
        MutableLiveData<String> r105 = new MutableLiveData();
        this.f94040b = r105;
        MutableLiveData<JSONObject> r106 = new MutableLiveData();
        this.f94041c = r106;
        MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> r107 = new MutableLiveData();
        this.f94042d = r107;
        MediatorLiveData r108 = new MediatorLiveData();
        r108.addSource(r101.f94338a, new y0(r108));
        Unit r109 = Unit.INSTANCE;
        this.f94044f = r108;
        this.f94045g = new MutableLiveData();
        HashMap<String, LiveData<?>> r110 = new HashMap();
        r110.put("channel_id", r105);
        r110.put("sei", r106);
        r110.put("team_task", r100.f94146o);
        r110.put("interact_timer_count", r100.f94147p);
        r110.put("interact_start_time", r100.f94143l);
        MutableLiveData<Long> r111 = r100.f94142k;
        final MediatorLiveData r112 = new MediatorLiveData();
        r112.addSource(r111, new RevNewDynamicFeedDataContext$packPkReMainTime$$inlined$also$lambda$1(r112, this));
        r110.put("play_remain_time", r112);
        MutableLiveData<Integer> r113 = r100.f94139h;
        MediatorLiveData r114 = new MediatorLiveData();
        r114.addSource(r113, new RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1(r114, this));
        r110.put("play_status", r114);
        MediatorLiveData r115 = new MediatorLiveData();
        r115.addSource(r107, new RevNewDynamicFeedDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1(r115, this));
        r110.put("link_anchor_list", r115);
        this.f94046h = r110;
        LinkedHashMap r116 = new LinkedHashMap(MapsKt.mapCapacity(r110.size()));
        Iterator r117 = r110.entrySet().iterator();
    L4:
        if (r117.hasNext() == false) goto L6;
        Map.Entry r118 = (Map.Entry) r117.next();
        Object r119 = r118.getKey();
        String r120 = (String) r118.getKey();
        r116.put(r119, com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.b((LiveData) r118.getValue(), r120, FormatType.NEW));
        goto L4
    L6:
        this.f94047i = r116;
    }
}
