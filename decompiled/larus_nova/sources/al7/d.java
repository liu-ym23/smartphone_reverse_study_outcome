package al7;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.h;
import com.bytedance.ug.sdk.luckydog.api.stage.LuckyActivityBlockStage;
import com.google.gson.Gson;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxTemplateRender;
import gk7.j;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import rk7.m;
import rk7.u;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f4167a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f4168b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Pair<Integer, Long>> f4169c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WeakHandler f4170d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<String, ArrayList<al7.a>> f4171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<al7.b, Map<String, Long>> f4172f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f4173g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f4174h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicBoolean f4175i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicBoolean f4176j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static j f4177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f4178l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AtomicBoolean f4179m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f4180n = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final al7.b f4181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final al7.a f4182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f4183c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L17:
            return true;
        L5:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f4181a, r101.f4181a) == false) goto L16;
            if (Intrinsics.areEqual(this.f4182b, r101.f4182b) == false) goto L16;
            if (this.f4183c != r101.f4183c) goto L13;
            boolean r102 = true;
        L14:
            if (r102 == false) goto L16;
        L13:
            r102 = false;
        L16:
            return false;
        }

        public final int hashCode() {
            al7.b r100 = this.f4181a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            al7.a r104 = this.f4182b;
            if (r104 == null) goto L9;
            r101 = r104.hashCode();
        L9:
            int r105 = (r103 + r101) * 31;
            long r106 = this.f4183c;
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "MessageBean(listener=" + this.f4181a + ", stageBean=" + this.f4182b + ", aheadTime=" + this.f4183c + ")";
        }

        public a(al7.b r100, al7.a r101, long r102) {
            this.f4181a = r100;
            this.f4182b = r101;
            this.f4183c = r102;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f4184a;

        public b(a r100) {
            this.f4184a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "checkFinishActivity activity finished data = " + this.f4184a.f4182b);     // Catch: Throwable -> L4
            this.f4184a.f4181a.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Comparator<al7.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f4185a = null;

        static {
            f4185a = new c();
        }

        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(al7.a r100, al7.a r101) {
            al7.a r102 = r100;
            al7.a r103 = r101;
            if (r102 == null) goto L9;
            long r104 = r102.f4159d;
            if (r103 == null) goto L7;
            long r105 = r103.f4159d;
        L11:
            return (r104 > r105 ? 1 : (r104 == r105 ? 0 : -1));
        L7:
            r105 = 0;
            goto L11
        L9:
            return 0;
        }
    }

    /* JADX INFO: renamed from: al7.d$d, reason: collision with other inner class name */
    public static final class C0081d<T> implements Comparator<al7.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0081d f4186a = null;

        static {
            f4186a = new C0081d();
        }

        public C0081d() {
        }

        @Override // java.util.Comparator
        public final int compare(al7.a r100, al7.a r101) {
            al7.a r102 = r100;
            al7.a r103 = r101;
            if (r102 == null) goto L9;
            long r104 = r102.f4159d;
            if (r103 == null) goto L7;
            long r105 = r103.f4159d;
        L11:
            return (r104 > r105 ? 1 : (r104 == r105 ? 0 : -1));
        L7:
            r105 = 0;
            goto L11
        L9:
            return 0;
        }
    }

    public d() {
    }

    static {
        d r100 = new d();
        f4180n = r100;
        f4167a = new AtomicInteger(0);
        f4168b = new AtomicLong(0);
        f4169c = new ConcurrentHashMap();
        f4170d = new WeakHandler(Looper.getMainLooper(), r100);
        f4171e = new ConcurrentHashMap();
        f4172f = new ConcurrentHashMap();
        f4173g = new CopyOnWriteArrayList();
        f4174h = new ConcurrentHashMap();
        f4175i = new AtomicBoolean(false);
        f4176j = new AtomicBoolean(false);
        f4178l = new ConcurrentHashMap();
        f4179m = new AtomicBoolean(false);
        rk7.a.a();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "init activity stage from app launch");
        i();
    }

    public static void h() {
        ConcurrentHashMap<al7.b, Map<String, Long>> r100 = f4172f;
        monitor-enter(r100);
        Iterator<T> r101 = r100.keySet().iterator();     // Catch: Throwable -> L21
    L6:
        if (r101.hasNext() == false) goto L18;
        al7.b r102 = (al7.b) r101.next();     // Catch: Throwable -> L21
        Map<String, Long> r103 = f4172f.get(r102);     // Catch: Throwable -> L21
        if (r103 == null) goto L6;
        Set<String> r104 = r103.keySet();     // Catch: Throwable -> L21
        if (r104 == null) goto L6;
        Iterator<T> r105 = r104.iterator();     // Catch: Throwable -> L21
    L13:
        if (r105.hasNext() == false) goto L6;
        String r106 = (String) r105.next();     // Catch: Throwable -> L21
        Long r107 = r103.get(r106);     // Catch: Throwable -> L21
        if (r107 != null) goto L17;
        Intrinsics.throwNpe();     // Catch: Throwable -> L21
    L17:
        n(r102, r106, r107.longValue());     // Catch: Throwable -> L21
        goto L13
    L18:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r100);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public static void i() {
        if (f4175i.get() == true) goto L116;
        ILuckyDogCommonSettingsService.Channel r100 = ILuckyDogCommonSettingsService.Channel.DYNAMIC;
        h r101 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;
        xk7.e r102 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(r100);
        boolean r103 = true;
        Object r104 = null;
        String r105 = "";
        if (r102 == null) goto L13;
        Object r106 = r102.j("data.entry_info");
        StringBuilder r107 = new StringBuilder("initDynamicStages, dynamicActivityInfo is null? ");
        if (r106 != null) goto L9;
        boolean r108 = true;
    L10:
        r107.append(r108);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", r107.toString());
        if ((r106 instanceof JSONObject) == false) goto L40;
        s(r100, (JSONObject) r106, false);
    L40:
        ILuckyDogCommonSettingsService.Channel r109 = ILuckyDogCommonSettingsService.Channel.STATIC;
        h r110 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;
        xk7.e r111 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(r109);
        if (r111 != null) goto L43;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "initStaticStages, static settings is not init");
        Context r112 = m.f538361o.e();
        if (r112 == null) goto L74;
        com.bytedance.ug.sdk.luckydog.api.settings.h.b(r112);
        LuckyDogLocalSettings r113 = com.bytedance.ug.sdk.luckydog.api.settings.h.a();
        if (r113 == null) goto L57;
        String r114 = r113.getStaticSettings();
        if (r114 == null) goto L57;
    L58:
        StringBuilder r115 = new StringBuilder("initStaticStages, staticSettingStr is empty? ");
        if (r114.length() != 0) goto L61;
        boolean r116 = true;
    L62:
        r115.append(r116);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", r115.toString());
        JSONObject r117 = new JSONObject(r114);     // Catch: Exception -> L65
    L67:
        Object r118 = yk7.c.d(r117, "data.entry_info");
        StringBuilder r119 = new StringBuilder("initStaticStages, staticActivityInfo is null? ");
        if (r118 != null) goto L70;
        boolean r120 = true;
    L71:
        r119.append(r120);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", r119.toString());
        if ((r118 instanceof JSONObject) == false) goto L74;
        s(r109, new JSONObject(r118.toString()), false);
        goto L74
    L70:
        r120 = false;
    L65:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyActivityStageManager", "static settings load cache fail " + e);
        r117 = new JSONObject();
        goto L67
    L61:
        r116 = false;
    L57:
        r114 = "";
    L74:
        ILuckyDogCommonSettingsService.Channel r121 = ILuckyDogCommonSettingsService.Channel.POLL;
        h r122 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;
        xk7.e r123 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(r121);
        if (r123 != null) goto L77;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "initPollingStages, polling settings is not init");
        LuckyDogLocalSettings r124 = com.bytedance.ug.sdk.luckydog.api.settings.h.a();
        if (r124 == null) goto L91;
        String r125 = r124.getPollSettings();
        if (r125 == null) goto L91;
        r105 = r125;
    L91:
        StringBuilder r126 = new StringBuilder("initPollingStages, pollSettingStr is empty? ");
        if (r105.length() != 0) goto L94;
        boolean r127 = true;
    L95:
        r126.append(r127);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", r126.toString());
        JSONObject r128 = new JSONObject(r105);     // Catch: Exception -> L98
        Application r129 = m.f538347a;     // Catch: Exception -> L98
        JSONObject r130 = r128.optJSONObject(m.j());     // Catch: Exception -> L98
    L100:
        if (r130 == null) goto L102;
        r104 = yk7.c.d(r130, "data.entry_info");
    L102:
        StringBuilder r131 = new StringBuilder("initPollingStages, pollActivityInfo is null? ");
        if (r104 == null) goto L106;
        r103 = false;
    L106:
        r131.append(r103);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", r131.toString());
        if ((r104 instanceof JSONArray) == false) goto L120;
        s(r121, new JSONObject(r104.toString()), false);
        return;
    L120:
        return;
    L98:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyActivityStageManager", "poll settings load cache fail " + e);
        r130 = new JSONObject();
        goto L100
    L94:
        r127 = false;
        goto L95
    L77:
        if (r123.f() == false) goto L79;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "initPollingStages, settings not update");
        return;
    L79:
        Object r132 = r123.j("data.entry_info");
        StringBuilder r133 = new StringBuilder("initPollingStages, pollActivityInfo is null? ");
        if (r132 == null) goto L83;
        r103 = false;
    L83:
        r133.append(r103);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", r133.toString());
        if ((r132 instanceof JSONObject) == false) goto L118;
        s(r121, (JSONObject) r132, false);
        return;
    L118:
        return;
    L43:
        if (r111.f() == false) goto L45;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "initStaticStages, settings not update");
        goto L74
    L45:
        Object r134 = r111.j("data.entry_info");
        if (r134 == null) goto L74;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "initStaticStages, staticActivityInfo is null? false");
        if ((r134 instanceof JSONObject) == false) goto L74;
        s(r109, (JSONObject) r134, false);
        goto L74
    L9:
        r108 = false;
        goto L10
    L13:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "initDynamicStages, dynamic settings is not init");
        Context r135 = m.f538361o.e();
        if (r135 == null) goto L40;
        com.bytedance.ug.sdk.luckydog.api.settings.h.b(r135);
        LuckyDogLocalSettings r136 = com.bytedance.ug.sdk.luckydog.api.settings.h.a();
        if (r136 == null) goto L20;
        String r137 = r136.getDynamicSettings();
        if (r137 == null) goto L20;
    L21:
        StringBuilder r138 = new StringBuilder("initDynamicStages, dynamicSettingStr is empty? ");
        if (r137.length() != 0) goto L24;
        boolean r139 = true;
    L25:
        r138.append(r139);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", r138.toString());
        JSONObject r140 = new JSONObject(r137).optJSONObject(m.j());     // Catch: Exception -> L28
    L30:
        if (r140 == null) goto L32;
        Object r141 = yk7.c.d(r140, "data.entry_info");
    L33:
        StringBuilder r142 = new StringBuilder("initDynamicStages, dynamicActivityInfo is null? ");
        if (r141 != null) goto L36;
        boolean r143 = true;
    L37:
        r142.append(r143);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", r142.toString());
        if ((r141 instanceof JSONObject) == false) goto L40;
        s(r100, new JSONObject(r141.toString()), false);
        goto L40
    L36:
        r143 = false;
        goto L37
    L32:
        r141 = null;
    L28:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyActivityStageManager", "dynamic settings load cache fail " + e);
        r140 = new JSONObject();
        goto L30
    L24:
        r139 = false;
    L20:
        r137 = "";
        goto L21
    }

    public static long g() {
        long r100 = hl7.b.b().a();
        int r101 = 1;
        if (r100 > 0) goto L15;
        f4176j.set(true);
        if (f4177k != null) goto L7;
        f4177k = f.f4188a;
        hl7.b r102 = hl7.b.b();
        r102.f485693e.add(f4177k);
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "use local time: " + r100);
    L15:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L14
        if (r100 > 0) goto L11;
        r101 = 0;
    L11:
        r103.put("status_code", r101);     // Catch: Throwable -> L14
        o("check_time", r103);     // Catch: Throwable -> L14
    L13:
        return r100 / ((long) 1000);
    }

    public static void b(ConcurrentHashMap r110) {
        f4170d.removeMessages(1);
        long r100 = g();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "checkFinishActivity currentTime = " + r100);
        Iterator<a> r101 = f4173g.iterator();
    L4:
        if (r101.hasNext() == false) goto L29;
        a r102 = r101.next();
        al7.a r103 = r102.f4182b;
        if (r100 < r103.f4159d) goto L4;
        if (r100 >= r103.f4160e) goto L4;
        Iterator r104 = r110.keySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L28;
        String r105 = (String) r104.next();
        if (Intrinsics.areEqual(r105, r102.f4182b.f4156a) == false) goto L11;
        ArrayList r106 = (ArrayList) r110.get(r105);
        if (r106 == null) goto L11;
        Iterator r107 = r106.iterator();
    L18:
        if (r107.hasNext() == false) goto L11;
        al7.a r108 = (al7.a) r107.next();
        r108.f4165j = f4176j.get();
        if (Intrinsics.areEqual(r108.f4157b, r102.f4182b.f4157b) == false) goto L18;
        if (Intrinsics.areEqual(r108.f4158c, r102.f4182b.f4158c) == false) goto L18;
        if (r100 < r108.f4159d) goto L18;
        if (r100 >= r108.f4160e) goto L18;
    L28:
        f4170d.post(new b(r102));
        goto L4
    L29:
        f4173g.clear();
    }

    public static ConcurrentHashMap c(al7.c r210) {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        if (r210 == null) goto L80;
        List<al7.c.b> r101 = r210.a();
        if (r101 == null) goto L80;
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L80;
        al7.c.b r103 = (al7.c.b) r102.next();
        String r104 = "";
        if (r103 == null) goto L14;
        String r105 = r103.a();
        if (r105 == null) goto L14;
    L15:
        ArrayList r110 = new ArrayList();
        ConcurrentHashMap<String, String> r106 = f4178l;
        String r107 = r106.get(r105);
        if (r103 == null) goto L20;
        String r108 = r103.b();
        if (r108 == null) goto L20;
    L21:
        boolean r109 = Intrinsics.areEqual(r107, r108);
        boolean r111 = true;
        boolean r112 = !r109;
        AtomicBoolean r113 = f4179m;
        if (r113.get() == true) goto L26;
        if (r112 == true) goto L26;
        boolean r114 = false;
    L27:
        r113.set(r114);
        r(f4180n, r105, r112);
        if (r103 == null) goto L32;
        String r115 = r103.b();
        if (r115 == null) goto L32;
    L33:
        r106.put(r105, r115);
        if (r103 == null) goto L36;
        List<al7.c.a> r116 = r103.c();
    L37:
        List<al7.c.a> r117 = r116;
        if (r117 != null) goto L40;
    L43:
        boolean r118 = true;
    L44:
        if (r118 == false) goto L46;
    L78:
        Iterator r211 = r102;
    L79:
        r102 = r211;
        goto L8
    L46:
        if (r105.length() > 0) goto L49;
        r111 = false;
    L49:
        if (r111 == false) goto L78;
        if (r103 == null) goto L77;
        List<al7.c.a> r119 = r103.c();
        if (r119 == null) goto L77;
        Iterator<T> r120 = r119.iterator();
    L55:
        if (r120.hasNext() == false) goto L77;
        al7.c.a r121 = (al7.c.a) r120.next();
        if (r121 == null) goto L75;
        String r122 = r121.e();
        if (r122 == null) goto L61;
        String r123 = r122;
    L62:
        String r124 = r121.b();
        if (r124 == null) goto L65;
        String r125 = r124;
    L66:
        long r126 = r121.f();
        long r127 = r121.d();
        String r128 = r121.c();
        String r129 = r121.e();
        if (r129 != null) goto L70;
        r129 = r104;
    L70:
        String r130 = r121.b();
        if (r130 == null) goto L73;
        String r131 = r130;
    L74:
        ArrayList r132 = r110;
        r132.add(new al7.a(r105, r123, r125, r126, r127, r128, d(r105, r129, r131, Integer.valueOf(r121.a())), r103.b(), r121.g(), f4176j.get()));
    L76:
        r110 = r132;
        r104 = r104;
        r103 = r103;
        r102 = r102;
        goto L55
    L73:
        r131 = r104;
        goto L74
    L65:
        r125 = r104;
        goto L66
    L61:
        r123 = r104;
        goto L62
    L75:
        r132 = r110;
    L77:
        r211 = r102;
        r100.put(r105, r110);
        goto L79
    L40:
        if (r117.isEmpty() == true) goto L43;
        r118 = false;
        goto L44
    L36:
        r116 = null;
    L32:
        r115 = "";
    L26:
        r114 = true;
    L20:
        r108 = "";
    L14:
        r105 = "";
    L80:
        l("merge new data: ", new ConcurrentHashMap(r100), new ConcurrentHashMap(f4178l));
        return r100;
    }

    public static JSONObject e(ConcurrentHashMap r100) {
        JSONObject r101 = new JSONObject();
        Iterator r102 = CollectionsKt.iterator(r100.keys());
    L4:
        if (r102.hasNext() == false) goto L12;
        String r103 = (String) r102.next();
        JSONObject r104 = new JSONObject();
        ArrayList r105 = (ArrayList) r100.get(r103);
        if (r105 == null) goto L11;
        Iterator r106 = r105.iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        al7.a r107 = (al7.a) r106.next();
        r104.put(r107.f4157b, r107.f4158c);
    L11:
        r101.put(r103, r104);
        goto L4
    L12:
        return r101;
    }

    public static boolean j(al7.c r110) {
        ConcurrentHashMap r111 = c(r110);
        if (f4171e.isEmpty() == false) goto L5;
    L51:
        f4171e = new ConcurrentHashMap(r111);
        q(true);
        return true;
    L5:
        if (r111.isEmpty() == true) goto L51;
        boolean r100 = f4179m.get();
        ConcurrentHashMap r101 = new ConcurrentHashMap(f4171e);
        ConcurrentHashMap r102 = new ConcurrentHashMap();
        Iterator r103 = r111.keySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L49;
        String r104 = (String) r103.next();
        ArrayList r105 = (ArrayList) r111.get(r104);
        ArrayList r106 = (ArrayList) r101.get(r104);
        ArrayList r107 = new ArrayList();
        if (r105 == null) goto L48;
        Iterator r108 = r105.iterator();
    L14:
        if (r108.hasNext() == false) goto L48;
        al7.a r109 = (al7.a) r108.next();
        if (r106 != null) goto L18;
    L21:
        boolean r112 = true;
    L22:
        d r113 = f4180n;
        if (r112 == true) goto L27;
        if (r106.contains(r109) == false) goto L27;
    L29:
        if (r106 == null) goto L14;
        Iterator r114 = r106.iterator();
    L32:
        if (r114.hasNext() == false) goto L14;
        al7.a r115 = (al7.a) r114.next();
        if ((!Intrinsics.areEqual(r109.f4163h, r115.f4163h)) == false) goto L37;
        r(r113, r104, true);
        r115.f4163h = r109.f4163h;
        r100 = true;
    L37:
        if (Intrinsics.areEqual(r115.f4157b, r109.f4157b) == false) goto L32;
        if (Intrinsics.areEqual(r115.f4158c, r109.f4158c) == false) goto L32;
        if (r115.f4164i < r109.f4164i) goto L46;
        if (r107.contains(r115) == true) goto L46;
        r107.add(r115);
    L46:
        if (r107.contains(r109) == true) goto L32;
        r(r113, r104, true);
        r107.add(r109);
        r100 = true;
    L27:
        if (r107.contains(r109) == true) goto L29;
        r(r113, r104, true);
        r107.add(r109);
        r100 = true;
        goto L14
    L18:
        if (r106.isEmpty() == true) goto L21;
        r112 = false;
    L48:
        CollectionsKt.sortWith(r107, c.f4185a);
        r102.put(r104, r107);
        goto L9
    L49:
        f4171e.clear();
        f4171e = new ConcurrentHashMap(r102);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "newStageMap, update = " + r100);
        return r100;
    }

    public static void q(boolean r100) {
        Iterator<T> r101 = f4174h.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = (String) r101.next();
        r(f4180n, r102, r100);
        goto L4
    }

    public static void t(ILuckyDogCommonSettingsService.Channel r100) {
        h r101 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;
        xk7.e r102 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(r100);
        Object r103 = null;
        if (r102 == null) goto L5;
        Object r104 = r102.j("data.entry_info");
    L6:
        AtomicBoolean r105 = u.f538372v;
        if (u.c.f538395a.f538391r.get() == false) goto L10;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "updateSettingStatus disable");
    L18:
        if (r100 == ILuckyDogCommonSettingsService.Channel.POLL) goto L24;
        if (r102 == null) goto L24;
        if (r102.f() != true) goto L24;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "upDateResourceData settings not update, channel = " + r100);
        return;
    L24:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "upDateResourceData settings channel = " + r100);
        if (r102 == null) goto L28;
        r103 = r102.j("data.entry_info");
    L28:
        if ((r103 instanceof JSONObject) == false) goto L31;
        s(r100, (JSONObject) r103, true);
        return;
    L31:
        return;
    L10:
        if (r100 == ILuckyDogCommonSettingsService.Channel.DYNAMIC) goto L12;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "updateSettingStatus not dynamic");
        goto L18
    L12:
        AtomicLong r106 = f4168b;
        r106.set(hl7.b.b().a());
        if (r104 != null) goto L15;
        f4167a.set(1);
    L16:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "updateSettingStatus dynamicSettingsStatusTime = " + r106.get() + " , dynamicSettingsStatus = " + f4167a.get());
        goto L18
    L15:
        f4167a.set(2);
        goto L16
    L5:
        r104 = null;
        goto L6
    }

    public static void v(String r100) {
        AtomicBoolean r101 = u.f538372v;
        if (u.c.f538395a.f538391r.get() == false) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "updateMidSettingsStatus disable");
        return;
    L6:
        ConcurrentHashMap<String, Pair<Integer, Long>> r102 = f4169c;
        monitor-enter(r102);
        AtomicInteger r103 = f4167a;     // Catch: Throwable -> L11
        Integer r104 = Integer.valueOf(r103.get());     // Catch: Throwable -> L11
        AtomicLong r105 = f4168b;     // Catch: Throwable -> L11
        r102.put(r100, new Pair(r104, Long.valueOf(r105.get())));     // Catch: Throwable -> L11
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "updateMidSettingsStatus entryId = " + r100 + " , dynamicSettingsStatus = " + r103.get() + " , dynamicSettingsStatusTime = " + r105.get());     // Catch: Throwable -> L11
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean w(al7.c r310) {
        ConcurrentHashMap r100 = c(r310);
        boolean r101 = true;
        if (f4171e.isEmpty() == false) goto L6;
        f4171e = new ConcurrentHashMap(r100);
        q(true);
        return true;
    L6:
        boolean r102 = f4179m.get();
        ConcurrentHashMap r103 = new ConcurrentHashMap(f4171e);
        Iterator r104 = r103.keySet().iterator();
    L7:
        boolean r105 = r104.hasNext();
        d r106 = f4180n;
        if (r105 == false) goto L164;
        String r107 = (String) r104.next();
        ArrayList r110 = (ArrayList) r103.get(r107);
        ArrayList r111 = (ArrayList) r100.get(r107);
        ArrayList<al7.a> r112 = new ArrayList();
        if (r110 != null) goto L12;
    L15:
        boolean r108 = true;
    L16:
        if (r108 == false) goto L35;
        if (r111 != null) goto L19;
    L22:
        boolean r109 = true;
    L23:
        if (r109 == true) goto L35;
        ArrayList<al7.a> r113 = f4171e.get(r107);
        if (r113 != null) goto L27;
    L30:
        boolean r114 = true;
    L31:
        if (r114 == false) goto L35;
        ArrayList<al7.a> r115 = f(r107, r310);
        if (r115 == null) goto L162;
        r(r106, r107, r101);
        f4171e.put(r107, r115);
        ConcurrentHashMap r311 = r100;
        ConcurrentHashMap r312 = r103;
        Iterator r313 = r104;
        r102 = true;
    L163:
        r103 = r312;
        r104 = r313;
        r100 = r311;
        r101 = true;
    L162:
        r311 = r100;
        r312 = r103;
        r313 = r104;
        goto L163
    L27:
        if (r113.isEmpty() == true) goto L30;
        r114 = false;
        goto L31
    L19:
        if (r111.isEmpty() == true) goto L22;
        r109 = false;
    L35:
        if (r110 == null) goto L162;
        Iterator r210 = r110.iterator();
    L38:
        if (r210.hasNext() == false) goto L162;
        al7.a r116 = (al7.a) r210.next();
        if (r310 == null) goto L154;
        List<al7.c.b> r117 = r310.a();
        if (r117 == null) goto L154;
        Iterator<T> r211 = r117.iterator();
    L45:
        if (r211.hasNext() == false) goto L154;
        al7.c.b r212 = (al7.c.b) r211.next();
        if (r212 == null) goto L51;
        String r118 = r212.a();
        if (r118 == null) goto L51;
    L53:
        if (r212 == null) goto L55;
        List<al7.c.a> r119 = r212.c();
    L56:
        List<al7.c.a> r120 = r119;
        if (r120 != null) goto L59;
    L62:
        boolean r121 = true;
    L63:
        if (r121 == true) goto L152;
        List<al7.c.a> r122 = r212.c();
        if (r122 == null) goto L69;
        if (r122.isEmpty() == r101) goto L152;
    L69:
        if (r107.length() != 0) goto L71;
        boolean r123 = true;
    L72:
        if (r123 == true) goto L152;
        if (r118.length() != 0) goto L76;
        boolean r124 = true;
    L77:
        if (r124 == true) goto L152;
        if ((Intrinsics.areEqual(r118, r107) ^ r101) == true) goto L152;
        if ((Intrinsics.areEqual(r116.f4163h, r212.b()) ^ r101) == false) goto L84;
        r(r106, r107, r101);
        r116.f4163h = r212.b();
        r102 = true;
    L84:
        List<al7.c.a> r125 = r212.c();
        if (r125 == null) goto L152;
        Iterator<T> r213 = r125.iterator();
    L88:
        if (r213.hasNext() == false) goto L151;
        al7.c.a r214 = (al7.c.a) r213.next();
        if (r214 == null) goto L94;
        String r126 = r214.e();
        if (r126 == null) goto L94;
        String r127 = r126;
    L95:
        if (r214 == null) goto L99;
        String r128 = r214.b();
        if (r128 == null) goto L99;
    L100:
        long r129 = -1;
        if (r214 == null) goto L103;
        long r130 = r214.f();
    L104:
        if (r214 == null) goto L106;
        r129 = r214.d();
    L106:
        if (r214 == null) goto L108;
        String r215 = r214.c();
    L109:
        if (r214 == null) goto L113;
        String r216 = r214.e();
        if (r216 == null) goto L113;
        String r131 = r216;
    L114:
        if (r214 == null) goto L118;
        String r217 = r214.b();
        if (r217 == null) goto L118;
        String r132 = r217;
    L119:
        if (r214 == null) goto L121;
        Integer r133 = Integer.valueOf(r214.a());
    L122:
        LuckyActivityBlockStage r134 = d(r107, r131, r132, r133);
        String r135 = r212.b();
        if (r214 == null) goto L125;
        int r136 = r214.g();
    L126:
        String r314 = r128;
        String r315 = r127;
        ConcurrentHashMap r316 = r103;
        Iterator r317 = r104;
        al7.a r137 = r116;
        ConcurrentHashMap r318 = r100;
        ArrayList r138 = r111;
        ArrayList<al7.a> r139 = r112;
        ArrayList r140 = r110;
        al7.a r141 = new al7.a(r107, r315, r314, r130, r129, r215, r134, r135, r136, f4176j.get());
        if (r140.contains(r141) == true) goto L134;
        if (r139.contains(r141) == true) goto L134;
        if (r214.h() == true) goto L134;
        r(r106, r107, true);
        r139.add(r141);
    L145:
        r102 = true;
    L150:
        r110 = r140;
        r112 = r139;
        r116 = r137;
        r103 = r316;
        r104 = r317;
        r100 = r318;
        r111 = r138;
    L134:
        if (Intrinsics.areEqual(r137.f4157b, r315) == true) goto L136;
    L149:
        r102 = r102;
        goto L150
    L136:
        if (Intrinsics.areEqual(r137.f4158c, r314) == false) goto L149;
        if (r137.f4164i >= r136) goto L147;
        if (r139.contains(r141) == true) goto L147;
        r(r106, r107, true);
        if (r214.h() == true) goto L145;
        r139.add(r141);
    L147:
        if (r139.contains(r137) == true) goto L149;
        r139.add(r137);
        goto L149
    L125:
        r136 = 0;
        goto L126
    L121:
        r133 = null;
    L118:
        r132 = "";
    L113:
        r131 = "";
        goto L114
    L108:
        r215 = null;
        goto L109
    L103:
        r130 = -1;
    L99:
        r128 = "";
    L94:
        r127 = "";
        goto L95
    L151:
        ConcurrentHashMap r319 = r100;
    L153:
        r110 = r110;
        r112 = r112;
        r116 = r116;
        r103 = r103;
        r104 = r104;
        r100 = r319;
        r111 = r111;
        r101 = true;
        goto L45
    L76:
        r124 = false;
        goto L77
    L71:
        r123 = false;
    L152:
        r319 = r100;
        goto L153
    L59:
        if (r120.isEmpty() == true) goto L62;
        r121 = false;
        goto L63
    L55:
        r119 = null;
    L51:
        r118 = "";
    L154:
        ConcurrentHashMap r320 = r100;
        ConcurrentHashMap r321 = r103;
        Iterator r322 = r104;
        al7.a r142 = r116;
        ArrayList r323 = r111;
        ArrayList<al7.a> r143 = r112;
        ArrayList r144 = r110;
        if (r323 == null) goto L161;
        if (r323.contains(r142) == true) goto L161;
        if (r143.contains(r142) == true) goto L161;
        r143.add(r142);
    L161:
        CollectionsKt.sortWith(r143, C0081d.f4186a);
        f4171e.put(r107, r143);
        r110 = r144;
        r112 = r143;
        r111 = r323;
        r103 = r321;
        r104 = r322;
        r100 = r320;
        r101 = true;
        r310 = r310;
        goto L38
    L12:
        if (r110.isEmpty() == true) goto L15;
        r108 = false;
        goto L16
    L164:
        ConcurrentHashMap r324 = r100;
        Iterator r145 = r324.keySet().iterator();
    L166:
        if (r145.hasNext() == false) goto L181;
        String r146 = (String) r145.next();
        ConcurrentHashMap r147 = r324;
        ArrayList r148 = (ArrayList) r147.get(r146);
        if (f4171e.keySet().contains(r146) == true) goto L180;
        if (r148 != null) goto L171;
    L174:
        boolean r149 = true;
    L175:
        if (r149 == true) goto L180;
        ArrayList<al7.a> r150 = f(r146, r310);
        if (r150 == null) goto L180;
        r(r106, r146, true);
        f4171e.put(r146, r150);
        r102 = true;
        goto L180
    L171:
        if (r148.isEmpty() == true) goto L174;
        r149 = false;
    L180:
        r324 = r147;
        goto L166
    L181:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "updateStageMap, update = " + r102);
        return r102;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.what);
    L6:
        if (r102 != null) goto L9;
    L21:
        if (r102 != null) goto L24;
        return;
    L24:
        if (r102.intValue() != 2) goto L38;
        Object r103 = r100.obj;
        if ((r103 instanceof a) == false) goto L29;
        r101 = r103;
    L29:
        a r104 = (a) r101;
        if (r104 != null) goto L32;
        return;
    L32:
        if (r104.f4182b.f4162g == LuckyActivityBlockStage.UNKNOWN) goto L34;
        r104.f4181a.a();
        return;
    L34:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "update bk unknown");
        return;
    L38:
        return;
    L9:
        if (r102.intValue() != 1) goto L21;
        Object r105 = r100.obj;
        if ((r105 instanceof a) == false) goto L14;
        r101 = r105;
    L14:
        a r106 = (a) r101;
        if (r106 != null) goto L17;
        return;
    L17:
        if (r100.arg1 != 1) goto L19;
        r106.f4181a.b();
    L20:
        f4173g.remove(r106);
        return;
    L19:
        r106.f4181a.d();
        goto L20
    L5:
        r102 = null;
        goto L6
    }

    public static void a(al7.a r100, al7.b r101) {
        long r102 = g();
        r100.f4165j = f4176j.get();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "checkActivityBlock current_time = " + r102);
        if (r102 >= r100.f4159d) goto L5;
        return;
    L5:
        if (r102 >= r100.f4160e) goto L9;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "checkActivityBlock send block data = " + r100);
        WeakHandler r103 = f4170d;
        Message r104 = Message.obtain();
        r104.what = 2;
        r104.obj = new a(r101, r100, 0);
        r103.sendMessage(r104);
        return;
    }

    public static ArrayList f(String r210, al7.c r211) {
        ArrayList r110 = new ArrayList();
        boolean r111 = false;
        if (r211 == null) goto L71;
        List<al7.c.b> r100 = r211.a();
        if (r100 == null) goto L71;
        Iterator<T> r112 = r100.iterator();
        boolean r101 = false;
    L8:
        if (r112.hasNext() == false) goto L70;
        al7.c.b r113 = (al7.c.b) r112.next();
        if (r113 == null) goto L12;
        String r102 = r113.a();
    L13:
        if (r113 == null) goto L15;
        List<al7.c.a> r103 = r113.c();
    L16:
        List<al7.c.a> r104 = r103;
        if (r104 != null) goto L19;
    L22:
        boolean r105 = true;
    L23:
        if (r105 == true) goto L8;
        List<al7.c.a> r106 = r113.c();
        if (r106 == null) goto L28;
        if (r106.isEmpty() == true) goto L8;
    L28:
        if (r210 != null) goto L30;
    L33:
        boolean r107 = true;
    L34:
        if (r107 == true) goto L8;
        if (r102 != null) goto L37;
    L40:
        boolean r108 = true;
    L41:
        if (r108 == true) goto L8;
        if ((!Intrinsics.areEqual(r102, r210)) == true) goto L8;
        List<al7.c.a> r109 = r113.c();
        if (r109 == null) goto L8;
        Iterator<T> r114 = r109.iterator();
        boolean r212 = r101;
    L49:
        if (r114.hasNext() == false) goto L69;
        al7.c.a r213 = (al7.c.a) r114.next();
        String r115 = r213.e();
        String r116 = "";
        if (r115 == null) goto L53;
        String r117 = r115;
    L54:
        String r118 = r213.b();
        if (r118 == null) goto L57;
        String r119 = r118;
    L58:
        long r120 = r213.f();
        long r121 = r213.d();
        String r122 = r213.c();
        String r123 = r213.e();
        if (r123 != null) goto L62;
        r123 = "";
    L62:
        String r124 = r213.b();
        if (r124 == null) goto L65;
        r116 = r124;
    L65:
        al7.a r125 = new al7.a(r210, r117, r119, r120, r121, r122, d(r210, r123, r116, Integer.valueOf(r213.a())), r113.b(), r213.g(), f4176j.get());
        if (r213.h() == true) goto L49;
        r110.add(r125);
        r212 = true;
        goto L49
    L57:
        r119 = "";
        goto L58
    L53:
        r117 = "";
        goto L54
    L69:
        r101 = r212;
        goto L8
    L37:
        if (r102.length() == 0) goto L40;
        r108 = false;
        goto L41
    L30:
        if (r210.length() == 0) goto L33;
        r107 = false;
        goto L34
    L19:
        if (r104.isEmpty() == true) goto L22;
        r105 = false;
        goto L23
    L15:
        r103 = null;
        goto L16
    L12:
        r102 = null;
        goto L13
    L70:
        r111 = r101;
    L71:
        if (r111 == true) goto L94;
        return null;
    L94:
        return r110;
    }

    public static void m(ILuckyDogCommonSettingsService.Channel r100, boolean r101) {
        AtomicBoolean r102 = u.f538372v;
        if (u.c.f538395a.f538390q == false) goto L5;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "sendMsgToFe is forbidden");
    L12:
        ConcurrentHashMap<al7.b, Map<String, Long>> r103 = f4172f;
        monitor-enter(r103);
        Iterator<T> r104 = r103.keySet().iterator();     // Catch: Throwable -> L41
    L16:
        if (r104.hasNext() == false) goto L38;
        al7.b r105 = (al7.b) r104.next();     // Catch: Throwable -> L41
        Map<String, Long> r106 = f4172f.get(r105);     // Catch: Throwable -> L41
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L41
        if (r106 == null) goto L45;
        Set<String> r108 = r106.keySet();     // Catch: Throwable -> L41
        if (r108 == null) goto L45;
        Iterator<T> r109 = r108.iterator();     // Catch: Throwable -> L41
    L23:
        if (r109.hasNext() == false) goto L45;
        String r110 = (String) r109.next();     // Catch: Throwable -> L41
        if (Intrinsics.areEqual(f4174h.get(r110), Boolean.TRUE) == false) goto L23;
        v(r110);     // Catch: Throwable -> L41
        ArrayList<al7.a> r111 = f4171e.get(r110);     // Catch: Throwable -> L41
        r105.c();     // Catch: Throwable -> L41
        r107.add(r110);     // Catch: Throwable -> L41
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L41
        r112.append("notifyDataChange rid = ");     // Catch: Throwable -> L41
        r112.append(r110);     // Catch: Throwable -> L41
        r112.append(" , data = ");     // Catch: Throwable -> L41
        Object r113 = (ArrayList) f4171e.get(r110);     // Catch: Throwable -> L41
        if (r113 != null) goto L30;
        r113 = "";
    L30:
        r112.append(r113);     // Catch: Throwable -> L41
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", r112.toString());     // Catch: Throwable -> L41
    L45:
        JSONObject r114 = new JSONObject();     // Catch: Throwable -> L44
        r114.put("change_list", r107);     // Catch: Throwable -> L44
        if (r101 == false) goto L35;
        String r115 = "settings did update";
    L36:
        r114.put("change_scene", r115);     // Catch: Throwable -> L44
        o("activity_data_change", r114);     // Catch: Throwable -> L44
        goto L16
    L35:
        r115 = LynxTemplateRender.RENDER_PHASE_SETUP;
        goto L36
    L38:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r103);
        return;
    L41:
        th = move-exception;
        throw th;
    L5:
        int r117 = e.f4187a[r100.ordinal()];
        int r118 = 1;
        if (r117 != 1) goto L8;
        r118 = 0;
    L11:
        HashMap r119 = new HashMap();
        r119.put("type", Integer.valueOf(r118));
        r119.put("key", "entry_info");
        Event r120 = new Event("luckyActivityStage", System.currentTimeMillis(), null);
        r120.setMapParams(r119);
        EventCenter.enqueueEvent(r120);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "sendMsgToFe type = " + r119.get("type") + ", key = " + r119.get("key"));
        goto L12
    L8:
        if (r117 == 2) goto L11;
        r118 = 2;
        goto L11
    }

    public static void o(String r100, JSONObject r101) {
        h r102 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;
        xk7.e r103 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(ILuckyDogCommonSettingsService.Channel.DYNAMIC);
        String r104 = null;
        if ((r103 instanceof com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.f) == true) goto L5;
        r103 = null;
    L5:
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.f r105 = (com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.f) r103;
        r101.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        r101.put("lucky_timestamp", hl7.b.b().a());
        if (r105 == null) goto L16;
        JSONObject r106 = r105.f564223c;
        if (r106 == null) goto L10;
        Object r107 = yk7.c.d(r106, "data.settings_meta.dynamic_settings_meta.version");
    L12:
        if ((r107 instanceof Integer) == false) goto L14;
        int r108 = ((Number) r107).intValue();
    L15:
        Integer r109 = Integer.valueOf(r108);
    L17:
        r101.put("lucky_dynamic_settings_version", r109);
        if (r105 == null) goto L22;
        JSONObject r110 = r105.f564223c;
        if (r110 == null) goto L22;
        r104 = r110.optString("key_setting_hash");
    L22:
        r101.put("lucky_dynamic_settings_hash", r104);
        com.bytedance.ug.sdk.luckydog.api.log.b.a("lucky_activity_stage_events", r101);
        return;
    L14:
        r108 = 0;
        goto L15
    L10:
        r107 = null;
        goto L12
    L16:
        r109 = null;
        goto L17
    }

    public static boolean u(ConcurrentHashMap r110, ConcurrentHashMap r111) {
        Iterator r100 = r110.keySet().iterator();
        boolean r101 = false;
    L3:
        boolean r102 = r100.hasNext();
        d r103 = f4180n;
        if (r102 == false) goto L13;
        String r104 = (String) r100.next();
        Iterator r105 = r111.keySet().iterator();
        boolean r106 = false;
    L7:
        if (r105.hasNext() == false) goto L11;
        if (Intrinsics.areEqual((String) r105.next(), r104) == false) goto L7;
        r106 = true;
        goto L7
    L11:
        if (r106 == true) goto L3;
        r(r103, r104, true);
        r101 = true;
        goto L3
    L13:
        Iterator r107 = r110.keySet().iterator();
    L15:
        if (r107.hasNext() == false) goto L32;
        String r108 = (String) r107.next();
        ArrayList r109 = (ArrayList) r110.get(r108);
        ArrayList r112 = (ArrayList) r111.get(r108);
        if (r109 == null) goto L15;
        Iterator r113 = r109.iterator();
    L20:
        if (r113.hasNext() == false) goto L15;
        al7.a r114 = (al7.a) r113.next();
        if (r112 == null) goto L29;
        Iterator r115 = r112.iterator();
        boolean r116 = false;
    L25:
        if (r115.hasNext() == false) goto L30;
        if (r114.equals((al7.a) r115.next()) == false) goto L25;
        r116 = true;
    L30:
        if (r116 == true) goto L20;
        r(r103, r108, true);
        r101 = true;
        goto L20
    L29:
        r116 = false;
        goto L30
    L32:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "updateChangeStatus, change = " + r101);
        return r101;
    }

    public static Message k(al7.a r100, long r101, al7.b r102) {
        Message r103 = Message.obtain();
        int r104 = 1;
        r103.what = 1;
        a r105 = new a(r102, r100, r101);
        r103.obj = r105;
        if (r101 >= 0) goto L6;
        r104 = 0;
    L6:
        r103.arg1 = r104;
        f4173g.add(r105);
        return r103;
    }

    public static void l(String r100, ConcurrentHashMap r101, ConcurrentHashMap r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append("\n");
        Iterator r104 = r101.keySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L15;
        String r105 = (String) r104.next();
        ArrayList r106 = (ArrayList) r101.get(r105);
        StringBuilder r107 = new StringBuilder("入口: ");
        r107.append(r105);
        r107.append(" , 资源数: ");
        if (r106 == null) goto L8;
        int r108 = r106.size();
    L9:
        r107.append(r108);
        r103.append(r107.toString());
        r103.append("\n");
        if (r106 == null) goto L4;
        Iterator r109 = r106.iterator();
    L13:
        if (r109.hasNext() == false) goto L4;
        r103.append(((al7.a) r109.next()).toString());
        r103.append("\n");
        goto L13
    L8:
        r108 = 0;
        goto L9
    L15:
        r103.append("兜底数据输出:\n");
        Iterator r110 = r102.keySet().iterator();
    L17:
        if (r110.hasNext() == false) goto L19;
        String r111 = (String) r110.next();
        r103.append("入口: " + r111 + " , 兜底数据: " + ((String) r102.get(r111)));
        r103.append("\n");
        goto L17
    L19:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "printDataALog, " + r103);
    }

    public static void n(al7.b r100, String r101, long r110) {
        rk7.a.a();
        JSONObject r102 = new JSONObject();
        ConcurrentHashMap<String, ArrayList<al7.a>> r103 = f4171e;
        monitor-enter(r103);
        Iterator<T> r104 = f4171e.keySet().iterator();     // Catch: Throwable -> L21
    L6:
        if (r104.hasNext() == false) goto L17;
        String r105 = (String) r104.next();     // Catch: Throwable -> L21
        if (Intrinsics.areEqual(r101, r105) == false) goto L6;
        ArrayList<al7.a> r106 = f4171e.get(r105);     // Catch: Throwable -> L21
        if (r106 == null) goto L6;
        Iterator<T> r107 = r106.iterator();     // Catch: Throwable -> L21
    L13:
        if (r107.hasNext() == false) goto L6;
        al7.a r108 = (al7.a) r107.next();     // Catch: Throwable -> L21
        p(r108, r110, r100);     // Catch: Throwable -> L21
        a(r108, r100);     // Catch: Throwable -> L21
        String r109 = r108.f4156a;     // Catch: Throwable -> L24
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L24
        r111.put(r108.f4157b, r108.f4162g);     // Catch: Throwable -> L24
        r102.put(r109, r111);     // Catch: Throwable -> L24
        goto L13
    L17:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r103);
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L25
        r113.put("change_list", r102);     // Catch: Throwable -> L25
        r113.put("change_scene", "settings did update");     // Catch: Throwable -> L25
        o("activity_stage_change", r113);     // Catch: Throwable -> L25
        return;
    L41:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public static void p(al7.a r110, long r111, al7.b r112) {
        long r100 = g();
        long r101 = r110.f4159d - r100;
        long r102 = r110.f4160e - r100;
        r110.f4165j = f4176j.get();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "sendSchedule current_time = " + r100 + ", data = " + r110 + ", start_time = " + r101 + ", end_time = " + r102);
        if (r101 <= r111) goto L6;
        StringBuilder r113 = new StringBuilder("sendSchedule, ");
        r113.append(r110.f4156a);
        r113.append(" resource_id = ");
        r113.append(r110.f4157b);
        r113.append(" cycle_id = ");
        r113.append(r110.f4158c);
        r113.append(" handle start callback after ");
        long r103 = r101 - r111;
        r113.append(1000 * r103);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", r113.toString());
        f4170d.sendMessageDelayed(k(r110, r111, r112), r103 * ((long) 1000));
    L9:
        if (r102 <= 0) goto L12;
        StringBuilder r104 = new StringBuilder("sendSchedule, ");
        r104.append(r110.f4156a);
        r104.append(" resource_id = ");
        r104.append(r110.f4157b);
        r104.append(" cycle_id = ");
        r104.append(r110.f4158c);
        r104.append("  handle end callback after ");
        long r105 = r102 * ((long) 1000);
        r104.append(r105);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", r104.toString());
        f4170d.sendMessageDelayed(k(r110, -1, r112), r105);
        return;
    L12:
        return;
    L6:
        if (r102 <= 0) goto L9;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "sendSchedule,  " + r110.f4156a + " resource_id = " + r110.f4157b + " cycle_id = " + r110.f4158c + "  handle start callback right now");
        f4170d.sendMessage(k(r110, r111, r112));
        goto L9
    }

    public static void r(d r100, String r101, boolean r102) {
        r100.getClass();
        ConcurrentHashMap<String, Boolean> r103 = f4174h;
        monitor-enter(r103);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r103.keySet().contains(r101) == false) goto L7;
        r103.put(r101, Boolean.valueOf(r102));     // Catch: Throwable -> L10
    L7:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean, int] */
    public static void s(ILuckyDogCommonSettingsService.Channel r110, JSONObject r111, boolean r210) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "sync settings, isSettingsUpdate: " + r210);
        AtomicBoolean r100 = f4175i;
        if (r100.get() == false) goto L7;
        if (r210 == true) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "syncSettingsStages, already init &&  settings not update");
        return;
    L7:
        boolean r101 = true;
        r100.set(true);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl((al7.c) new Gson().fromJson(r111.toString(), al7.c.class));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r103) == false) goto L15;
        r103 = null;
    L15:
        al7.c r104 = (al7.c) r103;
        JSONArray r105 = r111.optJSONArray("entry_items");
        ?? r106 = 0;
        if (r105 == null) goto L81;
        int r107 = 0;
    L19:
        if (r107 >= r105.length()) goto L81;
        Object r108 = r105.get(r107);
        if ((r108 instanceof JSONObject) == true) goto L23;
        r108 = null;
    L23:
        JSONObject r109 = (JSONObject) r108;
        r107 = r107 + 1;
        if (r109 == null) goto L26;
        String r112 = r109.optString("entry_id");
    L27:
        if (r109 == null) goto L81;
        JSONArray r113 = r109.optJSONArray("resource_items");
        if (r113 == null) goto L81;
        int r114 = 0;
    L32:
        if (r114 >= r113.length()) goto L19;
        Object r115 = r113.get(r114);
        if ((r115 instanceof JSONObject) == true) goto L36;
        r115 = null;
    L36:
        JSONObject r116 = (JSONObject) r115;
        r114 = r114 + 1;
        if (r116 == null) goto L39;
        String r117 = r116.optString("resource_id", "");
    L40:
        if (r116 == null) goto L42;
        String r118 = r116.optString("cycle_id", "");
    L43:
        int r119 = -1;
        if (r116 == null) goto L46;
        r119 = r116.optInt("bk", -1);
    L46:
        if (r104 == null) goto L80;
        List<al7.c.b> r120 = r104.a();
        if (r120 == null) goto L80;
        Iterator<T> r121 = r120.iterator();
    L51:
        if (r121.hasNext() == false) goto L80;
        al7.c.b r122 = (al7.c.b) r121.next();
        if (r122 == null) goto L55;
        String r123 = r122.a();
    L57:
        if ((Intrinsics.areEqual(r123, r112) ^ r101) == true) goto L79;
        if (r122 == null) goto L79;
        List<al7.c.a> r124 = r122.c();
        if (r124 == null) goto L79;
        Iterator<T> r125 = r124.iterator();
    L64:
        if (r125.hasNext() == false) goto L51;
        al7.c.a r126 = (al7.c.a) r125.next();
        if (r126 == null) goto L68;
        String r127 = r126.e();
    L70:
        if (Intrinsics.areEqual(r127, r117) == false) goto L78;
        if (r126 == null) goto L73;
        String r128 = r126.b();
    L75:
        if (Intrinsics.areEqual(r128, r118) == false) goto L78;
        if (r126 == null) goto L78;
        r126.i(r119);
        goto L78
    L73:
        r128 = null;
    L78:
        r101 = true;
        goto L64
    L68:
        r127 = null;
    L79:
        r101 = true;
        goto L51
    L55:
        r123 = null;
    L80:
        r101 = true;
        goto L32
    L42:
        r118 = null;
        goto L43
    L39:
        r117 = null;
        goto L40
    L26:
        r112 = null;
    L81:
        q(false);
        f4179m.set(false);
        ConcurrentHashMap<String, ArrayList<al7.a>> r129 = f4171e;
        monitor-enter(r129);
        ConcurrentHashMap r130 = new ConcurrentHashMap(f4171e);     // Catch: Throwable -> L113
        ConcurrentHashMap<String, String> r131 = f4178l;     // Catch: Throwable -> L113
        l("before " + r110 + " merge: ", r130, new ConcurrentHashMap(r131));     // Catch: Throwable -> L113
        ConcurrentHashMap r132 = new ConcurrentHashMap(f4171e);     // Catch: Throwable -> L113
        if (r110 != ILuckyDogCommonSettingsService.Channel.POLL) goto L86;
        boolean r133 = w(r104);     // Catch: Throwable -> L113
    L87:
        l("after " + r110 + " merge: ", new ConcurrentHashMap(f4171e), new ConcurrentHashMap(r131));     // Catch: Throwable -> L113
        if (u(r132, f4171e) == true) goto L90;
        if (r133 == true) goto L90;
    L92:
        if (r110 != ILuckyDogCommonSettingsService.Channel.DYNAMIC) goto L97;
        JSONObject r134 = e(r132);     // Catch: Throwable -> L113
        JSONObject r135 = e(f4171e);     // Catch: Throwable -> L113
        JSONObject r136 = new JSONObject();     // Catch: Throwable -> L96
        r136.put("has_diff", r106);     // Catch: Throwable -> L96
        r136.put("new_data", r135);     // Catch: Throwable -> L96
        r136.put("old_data", r134);     // Catch: Throwable -> L96
        o("dynamic_settings_merge", r136);     // Catch: Throwable -> L96
    L97:
        if (r210 == false) goto L100;
        if (r106 == 0) goto L100;
        b(f4171e);     // Catch: Throwable -> L113
    L100:
        Unit r137 = Unit.INSTANCE;     // Catch: Throwable -> L113
        monitor-exit(r129);
        ConcurrentHashMap r138 = new ConcurrentHashMap(f4174h);
        StringBuilder r139 = new StringBuilder();
        r139.append("整体数据是否变更: " + r106);
        r139.append("\n");
        Iterator r140 = r138.keySet().iterator();
    L104:
        if (r140.hasNext() == false) goto L106;
        String r141 = (String) r140.next();
        r139.append("入口: " + r141 + " , 数据变更(true为变更): " + ((Boolean) r138.get(r141)));
        r139.append("\n");
        goto L104
    L106:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "printChangeStatus, " + r139);
        if (r210 == false) goto L110;
        if (r106 == 0) goto L110;
        h();
    L110:
        if (r106 == 0) goto L141;
        m(r110, r210);
        return;
    L141:
        return;
    L90:
        r106 = 1;
        goto L92
    L86:
        r133 = j(r104);     // Catch: Throwable -> L113
    L113:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static LuckyActivityBlockStage d(String r100, String r101, String r102, Integer r110) {
        int r103 = -1;
        if (r110 == null) goto L5;
        int r111 = r110.intValue();
    L6:
        LuckyActivityBlockStage r104 = LuckyActivityBlockStage.PLAYED;
        if (r111 == r104.getValue()) goto L35;
        int r105 = LuckyActivityBlockStage.UNKNOWN.getValue();
        boolean r106 = true;
        boolean r107 = false;
        if (r101.length() <= 0) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == true) goto L14;
    L32:
        if (r105 < r111) goto L35;
        r111 = r105;
        goto L35
    L14:
        if (r102.length() <= 0) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == false) goto L32;
        il7.m r112 = il7.m.b("luckydog_block_storage.prefs");
        Application r113 = m.f538347a;
        String r114 = m.i();
        if (r114.length() == 0) goto L22;
        r106 = false;
    L22:
        if (r106 == false) goto L24;
        r114 = m.j();
    L24:
        String r115 = "lucky_block_" + r100 + "_status_" + r114 + "_resource_" + r101 + "_cycle_" + r102;
        SharedPreferences r116 = r112.f490336a;
        if (r116 == null) goto L28;
        r107 = r116.contains(r115);
    L28:
        if (r107 == true) goto L30;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "getStorageData, no key = " + r115);
    L31:
        r105 = r103;
        goto L32
    L30:
        r103 = r112.c(r115, -1);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyActivityStageManager", "getStorageData, data = " + r103);
        goto L31
    L16:
        r109 = false;
        goto L17
    L11:
        r108 = false;
    L35:
        if (r111 == r104.getValue()) goto L42;
        LuckyActivityBlockStage r117 = LuckyActivityBlockStage.NOT_PLAY;
        if (r111 != r117.getValue()) goto L41;
        return r117;
    L41:
        return LuckyActivityBlockStage.UNKNOWN;
    L42:
        return r104;
    L5:
        r111 = -1;
        goto L6
    }
}
