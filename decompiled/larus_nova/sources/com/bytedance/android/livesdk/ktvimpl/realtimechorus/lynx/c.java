package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.liveinteract.jsbridge.method.t;
import com.bytedance.android.live.liveinteract.linkbase.api.LoadDurationItemId;
import com.bytedance.android.live.revenue.platform.container.impl.d0;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.p;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements t, com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HybridCard f146698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HybridCard f146699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f146700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f146701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Map<String, List<Object>>> f146702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f146703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C2282c f146704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f146705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f146706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f146707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final KtvContext f146708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DataCenter f146709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Integer> f146710m;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.ktv.common.util.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function2<? super Boolean, ? super Long, Unit> f146711a;

        @Override // com.bytedance.android.live.ktv.common.util.b
        public final String getTypeName() {
            return KtvSubElement.EMPTY_SEAT;
        }

        public b() {
        }

        @Override // com.bytedance.android.live.ktv.common.util.c
        public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
            return this.f146711a;
        }

        @Override // com.bytedance.android.live.ktv.common.util.c
        public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r100) {
            this.f146711a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c$c, reason: collision with other inner class name */
    public static final class C2282c implements com.bytedance.android.live.ktv.common.util.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function2<? super Boolean, ? super Long, Unit> f146712a;

        @Override // com.bytedance.android.live.ktv.common.util.b
        public final String getTypeName() {
            return KtvSubElement.GUEST_SEAT;
        }

        public C2282c() {
        }

        @Override // com.bytedance.android.live.ktv.common.util.c
        public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
            return this.f146712a;
        }

        @Override // com.bytedance.android.live.ktv.common.util.c
        public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r100) {
            this.f146712a = r100;
        }
    }

    public static final class d implements uh6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HybridCard f146713a;

        public d(HybridCard r100) {
            this.f146713a = r100;
        }

        @Override // uh6.a
        public final void b(String r100, d0 r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
            this.f146713a.registerMethod(r100, new k(r101));
        }

        @Override // uh6.a
        public final void sendJsEvent(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f146713a.sendJsEvent(r100, r101);
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f146714a;

        public e(c r100) {
            this.f146714a = r100;
        }

        public final void a() {
            if (this.f146714a.f146710m.invoke().intValue() > 0) goto L5;
            boolean r100 = true;
        L6:
            Function2<? super Boolean, ? super Long, Unit> r101 = this.f146714a.f146703f.f146711a;
            if (r101 == null) goto L9;
            Unit r102 = r101.invoke(Boolean.valueOf(r100), Long.valueOf(System.currentTimeMillis()));
        L9:
            Function2<? super Boolean, ? super Long, Unit> r103 = this.f146714a.f146704g.f146712a;
            if (r103 == null) goto L13;
            Unit r104 = r103.invoke(Boolean.valueOf(r100), Long.valueOf(System.currentTimeMillis()));
            return;
        L13:
            return;
        L5:
            r100 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.jsbridge.method.t
    public final JsonObject T(ih0.e r100) {
        Intrinsics.checkNotNullParameter(r100, "getStatusData");
        return null;
    }

    public final void c() {
        this.f146708k.getStatisticHelper().b(this.f146703f);
        this.f146708k.getStatisticHelper().b(this.f146704g);
        ViewGroup r100 = this.f146705h;
        if (r100 == null) goto L6;
        r100.postDelayed(new e(this), vm2.h.A());
        return;
    }

    public final void e() {
        com.bytedance.live.datacontext.j<ylc.e> r100 = o3.f().w1();
        Integer r101 = null;
        if (r100 == null) goto L5;
        ylc.e r102 = r100.getValue();
    L6:
        Map<String, Map<String, List<Object>>> r103 = this.f146702e;
        HybridCard r104 = this.f146698a;
        if (r104 == null) goto L9;
        Integer r105 = Integer.valueOf(r104.hashCode());
    L10:
        Map r106 = (Map) ((LinkedHashMap) r103).get(String.valueOf(r105));
        if (r106 == null) goto L26;
        Set r107 = r106.keySet();
        if (r107 == null) goto L26;
        Iterator r108 = r107.iterator();
    L16:
        if (r108.hasNext() == false) goto L26;
        List r109 = (List) r106.get((String) r108.next());
        if (r109 == null) goto L16;
        Iterator r110 = r109.iterator();
    L21:
        if (r110.hasNext() == false) goto L16;
        Object r111 = r110.next();
        if ((r111 instanceof ylc.c) == false) goto L21;
        if (r102 == null) goto L21;
        r102.i((ylc.c) r111);
    L26:
        Map<String, Map<String, List<Object>>> r112 = this.f146702e;
        HybridCard r113 = this.f146699b;
        if (r113 == null) goto L29;
        r101 = Integer.valueOf(r113.hashCode());
    L29:
        Map r114 = (Map) ((LinkedHashMap) r112).get(String.valueOf(r101));
        if (r114 == null) goto L45;
        Set r115 = r114.keySet();
        if (r115 == null) goto L68;
        Iterator r116 = r115.iterator();
    L35:
        if (r116.hasNext() == false) goto L69;
        List r117 = (List) r114.get((String) r116.next());
        if (r117 == null) goto L35;
        Iterator r118 = r117.iterator();
    L40:
        if (r118.hasNext() == false) goto L35;
        Object r119 = r118.next();
        if ((r119 instanceof ylc.c) == false) goto L40;
        if (r102 == null) goto L40;
        r102.i((ylc.c) r119);
        goto L40
    L69:
        return;
    L68:
        return;
    L45:
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static Disposable b(HybridCard r100) {
        if (r100 == null) goto L4;
        cy0.e.f465759a.getClass();
        cy0.j r101 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r102 = com.bytedance.android.scope.m.b(r101).a(Reflection.getOrCreateKotlinClass(uh6.b.class));
        Intrinsics.checkNotNull(r102);
        return ((uh6.b) ((f80.a) r102)).h(new d(r100), null);
    L4:
        return Disposables.disposed();
    }

    public final void d(MessageHub r100) {
        Map<String, Map<String, List<Object>>> r101 = this.f146702e;
        HybridCard r102 = this.f146698a;
        Integer r103 = null;
        if (r102 == null) goto L5;
        Integer r104 = Integer.valueOf(r102.hashCode());
    L6:
        Map r105 = (Map) ((LinkedHashMap) r101).get(String.valueOf(r104));
        if (r105 == null) goto L16;
        List r106 = (List) r105.get(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA.getSyncKey());
        if (r106 == null) goto L16;
        Iterator r107 = r106.iterator();
    L12:
        if (r107.hasNext() == false) goto L16;
        Object r108 = r107.next();
        if ((r108 instanceof OnWRDSDataUpdateListener) == false) goto L12;
        r100.removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, (OnWRDSDataUpdateListener) r108);
    L16:
        Map<String, Map<String, List<Object>>> r109 = this.f146702e;
        HybridCard r110 = this.f146699b;
        if (r110 == null) goto L19;
        r103 = Integer.valueOf(r110.hashCode());
    L19:
        Map r111 = (Map) ((LinkedHashMap) r109).get(String.valueOf(r103));
        if (r111 == null) goto L29;
        List r112 = (List) r111.get(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA.getSyncKey());
        if (r112 == null) goto L40;
        Iterator r113 = r112.iterator();
    L25:
        if (r113.hasNext() == false) goto L41;
        Object r114 = r113.next();
        if ((r114 instanceof OnWRDSDataUpdateListener) == false) goto L25;
        r100.removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, (OnWRDSDataUpdateListener) r114);
        goto L25
    L41:
        return;
    L40:
        return;
    L29:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "linkUserWaveStatus");
        JSONObject r101 = new JSONObject();
        r101.put("eventName", "event_link_user_voice_wave_status");
        r101.put("wave_status", r100);
        HybridCard r102 = this.f146699b;
        if (r102 == null) goto L6;
        r102.sendJsEvent("event_link_user_voice_wave_status", r101);
        return;
    }

    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "songName");
        Intrinsics.checkNotNullParameter(r101, "ksongId");
        JSONObject r102 = new JSONObject();
        r102.put("eventName", "event_party_ktv_music_info_update");
        r102.put("song_name", r100);
        r102.put("ksong_id", r101);
        HybridCard r103 = this.f146698a;
        if (r103 == null) goto L6;
        r103.sendJsEvent("event_party_ktv_music_info_update", r102);
        return;
    }

    public final void h(boolean r100, boolean r101) {
        w.a("RealTimeChorusMicHybridCardManager", "updateSingStatus lynx isSing: " + r100 + " ; isLead: " + r101);
        JSONObject r102 = new JSONObject();
        r102.put("eventName", "event_party_ktv_sing_state_update");
        r102.put("is_sing", r100);
        r102.put("is_lead", r101);
        HybridCard r103 = this.f146698a;
        if (r103 == null) goto L6;
        r103.sendJsEvent("event_party_ktv_sing_state_update", r102);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.jsbridge.method.t
    public final void B1(ih0.f r110, ih0.h r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "updateStatus");
        Intrinsics.checkNotNullParameter(r111, "updateCallback");
        JsonObject r113 = r110.f489772d;
        JsonElement r100 = null;
        if (r113 != null) goto L6;
        ALogger.e("RealTimeChorusMicHybridCardManager", "update status but updateExtraInfo is empty");
        r111.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);
        return;
    L6:
        String r114 = r110.f489771c;
        boolean r101 = false;
        if (r114.length() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
    L50:
        ALogger.e("RealTimeChorusMicHybridCardManager", "update status but fromBizId is empty or not party ktv, fromBizId=".concat(r114));
        return;
    L12:
        if ((!Intrinsics.areEqual(r114, "party_ktv")) == true) goto L50;
        ALogger.i("RealTimeChorusMicHybridCardManager", "update status type=" + r110.getType() + " updateExtraInfo=" + r113);
        int r115 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.d.f146715a[r110.getType().ordinal()];
        if (r115 == 1) goto L53;
        if (r115 != 2) goto L58;
        JsonObject r116 = r110.f489772d;
        if (r116 == null) goto L22;
        r100 = r116.get("user_id");
    L22:
        String r117 = StringsKt.replace$default(String.valueOf(r100), "\"", "", false, 4, null);
        if (r117 != null) goto L25;
    L26:
        r101 = true;
    L27:
        if (r101 == false) goto L29;
        return;
    L29:
        ALogger.i("RealTimeChorusMicHybridCardManager", "OPEN_EMOJI_PANEL " + r110.f489772d + ' ' + r117);
        DataCenter r118 = this.f146709l;
        if (r118 == null) goto L56;
        r118.put("data_dynamic_show_emoji_panel", r117);
        return;
    L56:
        return;
    L25:
        if (r117.length() != 0) goto L27;
    L58:
        return;
    L53:
        ALogger.i("RealTimeChorusMicHybridCardManager", "ITEM_LOAD_DURATION " + r110.f489772d);     // Catch: Exception -> L47
        tf0.f r119 = (tf0.f) new GsonBuilder().create().fromJson(r110.f489772d, tf0.f.class);     // Catch: Exception -> L47
        if (r119 != null) goto L37;
    L52:
        return;
    L37:
        if (Intrinsics.areEqual(r119.a(), LoadDurationItemId.CHORUS_EMPTY_SEAT_LIST.getValue()) == false) goto L42;
        Function2<? super Boolean, ? super Long, Unit> r120 = this.f146703f.f146711a;     // Catch: Exception -> L47
        if (r120 == null) goto L52;
        Unit r121 = r120.invoke(Boolean.FALSE, Long.valueOf(d5.c(r119.c())));     // Catch: Exception -> L47
        goto L52
    L42:
        if (Intrinsics.areEqual(r119.a(), LoadDurationItemId.CHORUS_GUEST_SEAT_LIST.getValue()) == false) goto L52;
        Function2<? super Boolean, ? super Long, Unit> r122 = this.f146704g.f146712a;     // Catch: Exception -> L47
        if (r122 == null) goto L52;
        Unit r123 = r122.invoke(Boolean.FALSE, Long.valueOf(d5.c(r119.c())));     // Catch: Exception -> L47
    L47:
        e = move-exception;
        ALogger.e("RealTimeChorusMicHybridCardManager", "dynamicHandleLoadDuration gson failed!", e);
        return;
    L9:
        r102 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.b
    public final void a(List<p> r100, JSONObject r101, Float r110) {
        Intrinsics.checkNotNullParameter(r100, "midiUser");
        if (r101 != null) goto L26;
        JSONArray r102 = null;
    L8:
        if (r102 != null) goto L10;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L25
        r103.put("eventName", "event_party_ktv_midi_update");     // Catch: Exception -> L25
        JSONArray r111 = new JSONArray();     // Catch: Exception -> L25
        Iterator<T> r104 = r100.iterator();     // Catch: Exception -> L25
    L19:
        if (r104.hasNext() == false) goto L21;
        p r105 = (p) r104.next();     // Catch: Exception -> L25
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L25
        r106.put("userId", r105.b());     // Catch: Exception -> L25
        r106.put(KtvSubElement.MIDI, Float.valueOf(r105.a()));     // Catch: Exception -> L25
        r111.put(r106);     // Catch: Exception -> L25
        goto L19
    L21:
        r103.put("midiUsers", r111);     // Catch: Exception -> L25
        HybridCard r107 = this.f146698a;     // Catch: Exception -> L25
        if (r107 == null) goto L29;
        r107.sendJsEvent("event_party_ktv_midi_update", r103);     // Catch: Exception -> L25
        return;
    L29:
        return;
    L10:
        if (((Boolean) KtvSettingHelper.f70654q1.getValue()).booleanValue() == false) goto L13;
        if (r110 == null) goto L13;
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L25
        r108.put("userId", gh0.a.c());     // Catch: Exception -> L25
        r108.put(KtvSubElement.MIDI, r110);     // Catch: Exception -> L25
        Unit r112 = Unit.INSTANCE;     // Catch: Exception -> L25
        r102.put(r108);     // Catch: Exception -> L25
    L13:
        r101.put("eventName", "event_party_ktv_midi_update");     // Catch: Exception -> L25
        HybridCard r109 = this.f146698a;     // Catch: Exception -> L25
        if (r109 == null) goto L28;
        r109.sendJsEvent("event_party_ktv_midi_update", r101);     // Catch: Exception -> L25
        return;
    L28:
        return;
    L26:
        r102 = r101.optJSONArray("midiUsers");     // Catch: Exception -> L25
        goto L8
    }

    public c(ViewGroup r100, ViewGroup r101, Context r102, KtvContext r103, DataCenter r104, Function0<Integer> r105) {
        Intrinsics.checkNotNullParameter(r102, "mContext");
        Intrinsics.checkNotNullParameter(r103, IKtvService.KEY_OF_KTVCONTEXT_FOR_DATACENTER);
        Intrinsics.checkNotNullParameter(r105, "getChorusSingerCountAction");
        this.f146705h = r100;
        this.f146706i = r101;
        this.f146707j = r102;
        this.f146708k = r103;
        this.f146709l = r104;
        this.f146710m = r105;
        this.f146700c = Disposables.disposed();
        this.f146701d = Disposables.disposed();
        this.f146702e = new LinkedHashMap();
        this.f146703f = new b();
        this.f146704g = new C2282c();
    }
}
