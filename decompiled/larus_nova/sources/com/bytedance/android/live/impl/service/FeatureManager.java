package com.bytedance.android.live.impl.service;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.k0;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.config.LiveAudioTagConfig;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;
import com.bytedance.android.live.impl.utils.KevaHelper;
import com.bytedance.android.live.impl.utils.SharedPrefHelper;
import com.bytedance.android.live.impl.utils.json.JsonHelper;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.RoomFeatureValue;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import defpackage.CdnTrackerInfo;
import defpackage.Condition;
import j40.c0;
import j40.j;
import j40.m2;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class FeatureManager implements z90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f69255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f69256b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LiveFeatureConfig f69257c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LiveAudioTagConfig f69258d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Map<String, RoomFeatureValue>> f69259e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReentrantLock f69260f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f69261g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f69262h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f69263i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f69264j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ConcurrentHashMap<z90.a.b, List<String>> f69265k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<String, z90.a.b> f69266l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final CopyOnWriteArrayList<z90.d> f69267m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile ScheduledExecutorService f69268n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static z90.a.c f69269o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static CdnTrackerInfo f69270p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final k0 f69271q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Calendar f69272r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f69273s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final b f69274t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final FeatureManager f69275u = null;

    public static final class a implements Runnable {
        public a() {
        }

        public final void a() {
            Map<String, Object> r100 = c0.f497176a.getValue().getFeatureTestMap();
            if (r100 != null) goto L5;
            return;
        L5:
            Iterator<Map.Entry<String, Object>> r101 = r100.entrySet().iterator();
        L7:
            if (r101.hasNext() == false) goto L9;
            Map.Entry<String, Object> r102 = r101.next();
            FeatureManager.f69275u.getFeature(r102.getKey(), r102.getValue());
            goto L7
        L9:
            i0.c().postDelayed(this, c0.f497176a.getValue().getFeatureTestFrequency());
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

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            Map<String, Object> r100 = c0.f497176a.getValue().getTimerUpdateFeatureMap();
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            return;
        L11:
            Iterator<Map.Entry<String, Object>> r102 = r100.entrySet().iterator();
        L13:
            if (r102.hasNext() == false) goto L17;
            Map.Entry<String, Object> r103 = r102.next();
            FeatureManager r104 = FeatureManager.f69275u;
            Object r105 = r104.getFeature(r103.getKey(), r103.getValue());
            if ((!Intrinsics.areEqual(r105, r103.getValue())) == false) goto L13;
            r104.c(r103.getKey(), r105);
            goto L13
        L17:
            FeatureManager.f69275u.getClass();
            if (FeatureManager.f69268n != null) goto L20;
            FeatureManager.f69268n = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("eatureManager"));
        L20:
            ScheduledExecutorService r106 = FeatureManager.f69268n;
            if (r106 == null) goto L29;
            r106.schedule(this, c0.f497176a.getValue().getTimerUpdateFrequency(), TimeUnit.MILLISECONDS);
            return;
        L29:
            return;
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L9
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

    public FeatureManager() {
    }

    static {
        f69275u = new FeatureManager();
        f69255a = new ConcurrentHashMap();
        f69256b = new ConcurrentHashMap();
        LiveFeatureConfig r100 = c0.f497176a.getValue();
        f69257c = r100;
        f69258d = j.f497242a.getValue();
        f69259e = new ConcurrentHashMap();
        f69260f = new ReentrantLock();
        f69261g = r100.getRecentFrequencyValue();
        f69262h = r100.getRecentSessionValue();
        f69263i = r100.getWatchSessionThreshold();
        f69264j = r100.getDeadlineValue();
        f69265k = new ConcurrentHashMap();
        f69266l = new LinkedHashMap();
        f69267m = new CopyOnWriteArrayList();
        if (r100.getKevaOptEnable() == false) goto L5;
        k0 r101 = KevaHelper.f69309b;
    L6:
        f69271q = r101;
        f69272r = Calendar.getInstance();
        f69273s = new a();
        f69274t = new b();
        return;
    L5:
        r101 = SharedPrefHelper.f69313c;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class k() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.huawei.system.BuildEx");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.huawei.system.BuildEx");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.huawei.system.BuildEx");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.huawei.system.BuildEx");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.huawei.system.BuildEx");
    }

    public static JSONObject o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorId");
        JSONObject r101 = null;
        if (StringsKt.isBlank(r100) == false) goto L5;
        return null;
    L5:
        Map<String, RoomFeatureValue> r102 = f69259e.get(r100);
        if (r102 == null) goto L18;
        r101 = new JSONObject();
        Iterator<Map.Entry<String, RoomFeatureValue>> r103 = r102.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L18;
        Map.Entry<String, RoomFeatureValue> r104 = r103.next();
        String r105 = r104.getKey();
        RoomFeatureValue r106 = r104.getValue();
        if (r106 == null) goto L9;
        String r107 = r106.getValue();
        if (r107 == null) goto L9;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L16
        Result.m9449constructorimpl(r101.putOpt(r105, r107));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L18:
        return r101;
    }

    @Override // z90.a
    public final void f(z90.a.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f69269o = r100;
    }

    @Override // z90.a
    public final void g(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        boolean r101 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.a("LFM-FeatureManager", new FeatureManager$removeFeature$1(r100));
        ConcurrentHashMap<String, Object> r102 = f69255a;
        if (r102.containsKey(r100) == false) goto L6;
        r102.remove(r100);
        return;
    }

    @Override // z90.a
    public final void h(z90.a.b r100) {
        if (r100 == null) goto L5;
        List<String> r101 = f69265k.remove(r100);
        return;
    }

    @Override // z90.a
    public final void j(z90.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((LinkedHashMap) f69266l).values().remove(r100);
    }

    public static void m(String r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorId");
        JSONObject r102 = o(r100);     // Catch: Exception -> L14
        if (r102 != null) goto L6;
        return;
    L6:
        Iterator<String> r103 = r102.keys();     // Catch: Exception -> L14
    L7:
        if (r103.hasNext() == false) goto L24;
        String r104 = r103.next();     // Catch: Exception -> L14
        Object r105 = r102.opt(r104);     // Catch: Exception -> L12
        FeatureManager r106 = f69275u;     // Catch: Exception -> L12
        String r107 = r104.toString();     // Catch: Exception -> L12
        r106.getClass();     // Catch: Exception -> L12
        q(r107, r105);     // Catch: Exception -> L12
        Unit r108 = (Unit) r101.invoke(r104, r105);     // Catch: Exception -> L12
    L12:
        ALogger.e("strategy_tag", "autoUpdateRealTimeFeatures, roomFeatures key error, anchorId is: " + r100);     // Catch: Exception -> L14
        goto L7
    L24:
        return;
    L14:
        ALogger.e("strategy_tag", "autoUpdateRealTimeFeatures, func error, anchorId is: ".concat(r100));
    }

    public static boolean n(final String r100, final Object r101) {
        if (r101 == null) goto L29;
        boolean r102 = r101 instanceof Float;
        if (r102 == false) goto L7;
    L10:
        if (r102 == false) goto L19;
        float r103 = ((Number) r101).floatValue();
        if (Float.isInfinite(r103) == false) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L19;
    L27:
        return true;
    L14:
        if (Float.isNaN(r103) == true) goto L16;
        r104 = true;
    L19:
        if ((r101 instanceof Double) == false) goto L28;
        double r105 = ((Number) r101).doubleValue();
        if (Double.isInfinite(r105) == false) goto L23;
    L25:
        boolean r106 = false;
    L26:
        if (r106 == false) goto L28;
    L23:
        if (Double.isNaN(r105) == true) goto L25;
        r106 = true;
    L28:
        boolean r107 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", new FeatureManager$checkValueValid$$inlined$let$lambda$1(r101, r100), null);
        goto L29
    L7:
        if ((r101 instanceof Double) == true) goto L10;
        return true;
    L29:
        return false;
    }

    public static Object p(Object r100, Object r101) {
        if (r101 != null) goto L4;
        return r100;
    L4:
        if (r100 != null) goto L6;
    L67:
        if ((r101 instanceof Object) == true) goto L72;
        return null;
    L72:
        return r101;
    L57:
        th = move-exception;
        boolean r102 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", FeatureManager$getSpecifiedType$1.INSTANCE, th);
        return r100;
    L6:
        if ((r101 instanceof Number) == false) goto L9;
        r101 = p(r100, r101.toString());
        goto L67
    L9:
        if ((r101 instanceof Boolean) == false) goto L12;
        r101 = p(r100, r101.toString());
        goto L67
    L12:
        if ((r101 instanceof String) == false) goto L42;
        if (((CharSequence) r101).length() != 0) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == true) goto L67;
        if ((r100 instanceof Integer) == false) goto L25;
        String r104 = (String) r101;
        int r105 = ((Number) r100).intValue();
        r105 = CastIntegerProtector.parseInt(r104);     // Catch: Throwable -> L60
    L23:
        r101 = Integer.valueOf(r105);
        goto L67
    L25:
        if ((r100 instanceof Boolean) == false) goto L28;
        r101 = d5.a((String) r101, ((Boolean) r100).booleanValue());
        goto L67
    L28:
        if ((r100 instanceof Long) == false) goto L33;
        String r106 = (String) r101;
        long r107 = ((Number) r100).longValue();
        r107 = CastLongProtector.parseLong(r106);     // Catch: Throwable -> L61
    L31:
        r101 = Long.valueOf(r107);
        goto L67
    L33:
        if ((r100 instanceof Float) == false) goto L38;
        String r108 = (String) r101;
        float r109 = ((Number) r100).floatValue();
        r109 = CastFloatProtector.parseFloat(r108);     // Catch: Throwable -> L62
    L36:
        r101 = Float.valueOf(r109);
        goto L67
    L38:
        if ((r100 instanceof Double) == false) goto L40;
        r101 = StringsKt.toDoubleOrNull((String) r101);
        goto L67
    L40:
        boolean r110 = r100 instanceof String;
        goto L67
    L16:
        r103 = false;
        goto L17
    L42:
        if ((r101 instanceof JSONObject) == false) goto L48;
        if ((r100 instanceof Map) == false) goto L46;
        int r111 = JsonHelper.f69322a;
        r101 = JsonHelper.b((JSONObject) r101);
        goto L67
    L46:
        boolean r112 = r100 instanceof JSONObject;
        goto L67
    L48:
        if ((r101 instanceof JSONArray) == false) goto L67;
        if ((r100 instanceof List) == false) goto L52;
        int r113 = JsonHelper.f69322a;
        r101 = JsonHelper.a((JSONArray) r101);
        goto L67
    L52:
        boolean r114 = r100 instanceof JSONArray;
        goto L67
    }

    public static void q(final String r100, final Object r101) {
        if (n(r100, r101) == true) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, Object> r102 = f69255a;
        if (r101 != null) goto L28;
    L26:
        boolean r103 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.a("LFM-FeatureManager", new FeatureManager$putFeature$1(r100, r101));
        return;
    L28:
    L24:
        e = move-exception;
        boolean r104 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", FeatureManager$safePut$3.INSTANCE, e);
        goto L26
    L9:
        if ((r101 instanceof Collection) == false) goto L16;
        JSONArray r105 = new JSONArray();     // Catch: JSONException -> L24
        Iterator r106 = ((Iterable) r101).iterator();     // Catch: JSONException -> L24
    L12:
        if (r106.hasNext() == false) goto L14;
        r105.put(r106.next());     // Catch: JSONException -> L24
        goto L12
    L14:
        Unit r107 = Unit.INSTANCE;     // Catch: JSONException -> L24
        r102.put(r100, r105);     // Catch: JSONException -> L24
        goto L26
    L16:
        if ((r101 instanceof Map) == false) goto L22;
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L24
        Iterator r109 = ((Map) r101).entrySet().iterator();     // Catch: JSONException -> L24
    L19:
        if (r109.hasNext() == false) goto L21;
        Map.Entry r110 = (Map.Entry) r109.next();     // Catch: JSONException -> L24
        Object r111 = r110.getKey();     // Catch: JSONException -> L24
        Object r112 = r110.getValue();     // Catch: JSONException -> L24
        d60.b.a(r108, String.valueOf(r111), r112);     // Catch: JSONException -> L24
        goto L19
    L21:
        Unit r113 = Unit.INSTANCE;     // Catch: JSONException -> L24
        r102.put(r100, r108);     // Catch: JSONException -> L24
        goto L26
    L22:
        r102.put(r100, r101);     // Catch: JSONException -> L24
        goto L26
    }

    public static void r(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        if ((r101 instanceof Object) == true) goto L5;
        JSONObject r102 = null;
    L6:
        q(r100, r102);
        if (StringsKt.isBlank(r100) == false) goto L9;
        String r103 = "";
    L10:
        Iterator<String> r104 = r101.keys();
    L12:
        if (r104.hasNext() == false) goto L14;
        String r105 = r104.next();
        q(r103 + r105, r101.get(r105));
        goto L12
    L14:
        return;
    L9:
        r103 = r100.concat("_");
        goto L10
    L5:
        r102 = r101;
        goto L6
    }

    @Override // z90.a
    public final void a(String r100, z90.a.b r101) {
        Intrinsics.checkNotNullParameter(r100, "names");
        Intrinsics.checkNotNullParameter(r101, "listener");
        f69266l.put(r100, r101);
    }

    @Override // z90.a
    public final boolean c(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return i(r100, r101, FeatureType.DYNAMIC_MONITOR);
    }

    @Override // z90.a
    public final void d(String r210, Map<String, RoomFeatureValue> r211) {
        String r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "anchorId");
        String r101 = "LFM-FeatureManager";
        if (m2.f497263a.getValue().booleanValue() == false) goto L26;
        Set r102 = SetsKt.setOf(new String[]{"live_tone_2nd", "live_cae_2nd", "live_cae_offline_2nd"});
        Map<String, RoomFeatureValue> r103 = new LinkedHashMap();
        Iterator r104 = ((LinkedHashMap) r211).entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L27;
        Map.Entry r105 = (Map.Entry) r104.next();
        final String r106 = (String) r105.getKey();
        RoomFeatureValue r107 = (RoomFeatureValue) r105.getValue();
        if (r102.contains(r106) == false) goto L25;
        if (r107 == null) goto L11;
        String r108 = r107.getType();
    L13:
        if (Intrinsics.areEqual(r108, "string") == false) goto L25;
        if (r107.getValue() == null) goto L25;
        JSONObject r109 = new JSONObject(r107.getValue());     // Catch: JSONException -> L23
        Iterator<String> r110 = r109.keys();     // Catch: JSONException -> L23
    L18:
        if (r110.hasNext() == false) goto L6;
        String r111 = r110.next();     // Catch: JSONException -> L23
        Object r112 = r109.opt(r111);     // Catch: JSONException -> L23
        if (r112 == null) goto L18;
        String r113 = String.valueOf(r111);     // Catch: JSONException -> L23
        RoomFeatureValue r114 = new RoomFeatureValue();     // Catch: JSONException -> L23
        r114.setType("float");     // Catch: JSONException -> L23
        r114.setValue(r112.toString());     // Catch: JSONException -> L23
        r114.setGenTimeMs(r107.getGenTimeMs());     // Catch: JSONException -> L23
        r114.setExpTimeMs(r107.getExpTimeMs());     // Catch: JSONException -> L23
        r103.put(r113, r114);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        boolean r115 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", new FeatureManager$processSpecialRoomFeatures$1(r106), e);
        r103.put(r106, r107);
        goto L6
    L11:
        r108 = null;
    L25:
        r103.put(r106, r107);
    L27:
        String r116 = "null";
        if (f69258d.getParseAudioTagEnable() == false) goto L135;
        r103 = MapsKt.toMutableMap(r103);
        String r117 = "live_stream_audio_tag";
        RoomFeatureValue r118 = r103.get("live_stream_audio_tag");
        if (r118 == null) goto L135;
        String r119 = r118.getValue();
        if (r119 == null) goto L135;
        JSONArray r120 = new JSONArray(r119);     // Catch: Exception -> L132
        ArrayList r121 = new ArrayList();     // Catch: Exception -> L132
        ArrayList r122 = new ArrayList();     // Catch: Exception -> L132
        ArrayList r123 = new ArrayList();     // Catch: Exception -> L132
        ArrayList r124 = new ArrayList();     // Catch: Exception -> L132
        ArrayList r125 = new ArrayList();     // Catch: Exception -> L132
        int r126 = r120.length();     // Catch: Exception -> L132
        int r127 = 0;
    L37:
        boolean r128 = true;
        if (r127 >= r126) goto L100;
        int r129 = r126;
        JSONObject r130 = r120.optJSONObject(r127);     // Catch: Exception -> L98
        if (r130 != null) goto L43;
        String r212 = r117;
        String r213 = r101;
        String r131 = r116;
        JSONArray r214 = r120;
    L193:
        r127 = r127 + 1;     // Catch: Exception -> L130
        r126 = r129;
        r116 = r131;
        r120 = r214;
        r117 = r212;
        r101 = r213;
    L130:
        e = e;
    L131:
        r100 = r210;
    L134:
        boolean r132 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.b(r213, FeatureManager$processAudioTag$12.INSTANCE, e);
    L137:
        if (f69257c.getRoomFeatureOptMerge() == true) goto L148;
        f69259e.put(r100, r103);
        StringBuilder r133 = new StringBuilder("[putRoomFeatures] anchor_id is: ");
        r133.append(r100);
        r133.append(", keys: ");
        r133.append(r103.keySet());
        r133.append(" values: ");
        Collection<RoomFeatureValue> r134 = r103.values();
        ArrayList r135 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r134, 10));
        Iterator<T> r136 = r134.iterator();
    L140:
        if (r136.hasNext() == false) goto L147;
        RoomFeatureValue r137 = (RoomFeatureValue) r136.next();
        if (r137 == null) goto L145;
        String r138 = r137.getValue();
        if (r138 == null) goto L145;
    L146:
        r135.add(r138);
    L145:
        r138 = r131;
        goto L146
    L147:
        r133.append(r135);
        ALogger.i("LFM-strategy_tag", r133.toString());
    L163:
        int r139 = f69257c.getLimitRoomFeaturesSize();
        ConcurrentHashMap<String, Map<String, RoomFeatureValue>> r140 = f69259e;
        if (r140.size() <= r139) goto L222;
        ReentrantLock r141 = f69260f;
        r141.lock();
        int r142 = r140.size();     // Catch: Throwable -> L177
        if (r142 <= r139) goto L174;
        List r143 = CollectionsKt.take(r140.entrySet(), Math.max(0, r142 - r139));     // Catch: Throwable -> L177
        ArrayList r144 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r143, 10));     // Catch: Throwable -> L177
        Iterator r145 = r143.iterator();     // Catch: Throwable -> L177
    L171:
        if (r145.hasNext() == false) goto L173;
        r144.add((String) ((Map.Entry) r145.next()).getKey());     // Catch: Throwable -> L177
        goto L171
    L173:
        f69259e.keySet().removeAll(r144);     // Catch: Throwable -> L177
    L174:
        Unit r146 = Unit.INSTANCE;     // Catch: Throwable -> L177
        r141.unlock();
        return;
    L177:
        th = move-exception;
        r141.unlock();
        throw th;
    L222:
        return;
    L148:
        ReentrantLock r147 = f69260f;
        r147.lock();
        ConcurrentHashMap<String, Map<String, RoomFeatureValue>> r148 = f69259e;     // Catch: Throwable -> L180
        Map<String, RoomFeatureValue> r149 = r148.get(r100);     // Catch: Throwable -> L180
        if (r149 != null) goto L152;
        r149 = MapsKt.emptyMap();     // Catch: Throwable -> L180
    L152:
        Map<String, RoomFeatureValue> r150 = MapsKt.plus(r149, r103);     // Catch: Throwable -> L180
        r148.put(r100, r150);     // Catch: Throwable -> L180
        StringBuilder r151 = new StringBuilder();     // Catch: Throwable -> L180
        r151.append("[putRoomFeatures222] anchor_id is: ");     // Catch: Throwable -> L180
        r151.append(r100);     // Catch: Throwable -> L180
        r151.append(", features: ");     // Catch: Throwable -> L180
        ArrayList r152 = new ArrayList(r150.size());     // Catch: Throwable -> L180
        Iterator<Map.Entry<String, RoomFeatureValue>> r153 = r150.entrySet().iterator();     // Catch: Throwable -> L180
    L154:
        if (r153.hasNext() == false) goto L161;
        Map.Entry<String, RoomFeatureValue> r154 = r153.next();     // Catch: Throwable -> L180
        StringBuilder r155 = new StringBuilder();     // Catch: Throwable -> L180
        r155.append(r154.getKey());     // Catch: Throwable -> L180
        r155.append(": ");     // Catch: Throwable -> L180
        RoomFeatureValue r156 = r154.getValue();     // Catch: Throwable -> L180
        if (r156 == null) goto L159;
        String r157 = r156.getValue();     // Catch: Throwable -> L180
        if (r157 == null) goto L159;
    L160:
        r155.append(r157);     // Catch: Throwable -> L180
        r152.add(r155.toString());     // Catch: Throwable -> L180
    L159:
        r157 = r131;
        goto L160
    L161:
        r151.append(CollectionsKt.joinToString$default(r152, null, null, null, 0, null, null, 63, null));     // Catch: Throwable -> L180
        ALogger.i("LFM-strategy_tag", r151.toString());     // Catch: Throwable -> L180
        Unit r158 = Unit.INSTANCE;     // Catch: Throwable -> L180
        r147.unlock();
    L180:
        th = move-exception;
        r147.unlock();
        throw th;
    L43:
        r131 = r116;
        r214 = r120;
        int r159 = r130.optInt("slice_cnt", 0);     // Catch: Exception -> L96
        r212 = r117;
        double r160 = r130.optDouble("ratio_avg", AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Exception -> L96
        LiveAudioTagConfig r161 = f69258d;     // Catch: Exception -> L96
        r213 = r101;
        if (r159 < r161.getAudioTagSliceCnt()) goto L193;
        if (r160 < r161.getAudioTagRatioThreshold()) goto L193;
        String r162 = r130.optString("t0");     // Catch: Exception -> L130
        if (r162.length() <= 0) goto L53;
        boolean r163 = true;
    L54:
        if (r163 == true) goto L57;
        r162 = null;
    L57:
        if (r162 == null) goto L59;
        r121.add(r162);     // Catch: Exception -> L130
    L59:
        String r164 = r130.optString("t1");     // Catch: Exception -> L130
        if (r164.length() <= 0) goto L62;
        boolean r165 = true;
    L63:
        if (r165 == true) goto L66;
        r164 = null;
    L66:
        if (r164 == null) goto L68;
        r122.add(r164);     // Catch: Exception -> L130
    L68:
        String r166 = r130.optString("t2");     // Catch: Exception -> L130
        if (r166.length() <= 0) goto L71;
        boolean r167 = true;
    L72:
        if (r167 == true) goto L75;
        r166 = null;
    L75:
        if (r166 == null) goto L77;
        r123.add(r166);     // Catch: Exception -> L130
    L77:
        String r168 = r130.optString("t3");     // Catch: Exception -> L130
        if (r168.length() <= 0) goto L80;
        boolean r169 = true;
    L81:
        if (r169 == true) goto L84;
        r168 = null;
    L84:
        if (r168 == null) goto L86;
        r124.add(r168);     // Catch: Exception -> L130
    L86:
        String r170 = r130.optString("tag_id");     // Catch: Exception -> L130
        if (r170.length() > 0) goto L90;
        r128 = false;
    L90:
        if (r128 == true) goto L93;
        r170 = null;
    L93:
        if (r170 == null) goto L193;
        r125.add(r170);     // Catch: Exception -> L130
        goto L193
    L80:
        r169 = false;
        goto L81
    L71:
        r167 = false;
        goto L72
    L62:
        r165 = false;
        goto L63
    L53:
        r163 = false;
    L96:
        e = e;
        r213 = r101;
    L98:
        e = e;
        r213 = r101;
        r131 = r116;
        goto L131
    L100:
        String r215 = r117;
        r213 = r101;
        r131 = r116;
        if ((!r121.isEmpty()) == false) goto L104;
        l(r103, "audiotag0_mix", r121, r118);     // Catch: Exception -> L130
    L104:
        if ((!r122.isEmpty()) == false) goto L107;
        l(r103, "audiotag1_mix", r122, r118);     // Catch: Exception -> L130
    L107:
        if ((!r123.isEmpty()) == false) goto L110;
        l(r103, "audiotag2_mix", r123, r118);     // Catch: Exception -> L130
    L110:
        if ((!r124.isEmpty()) == false) goto L113;
        l(r103, "audiotag3_mix", r124, r118);     // Catch: Exception -> L130
    L113:
        if ((!r125.isEmpty()) == false) goto L115;
        l(r103, "audiotagid_mix", r125, r118);     // Catch: Exception -> L130
    L115:
        r103.remove(r215);     // Catch: Exception -> L130
        StringBuilder r171 = new StringBuilder();     // Catch: Exception -> L130
        r171.append("[processAudioTag], anchorId=");     // Catch: Exception -> L130
        r100 = r210;
        r171.append(r100);     // Catch: Exception -> L128
        r171.append(",features: ");     // Catch: Exception -> L128
        ArrayList r172 = new ArrayList(r103.size());     // Catch: Exception -> L128
        Iterator<Map.Entry<String, RoomFeatureValue>> r173 = r103.entrySet().iterator();     // Catch: Exception -> L128
    L119:
        if (r173.hasNext() == false) goto L126;
        Map.Entry<String, RoomFeatureValue> r174 = r173.next();     // Catch: Exception -> L128
        StringBuilder r175 = new StringBuilder();     // Catch: Exception -> L128
        r175.append(r174.getKey());     // Catch: Exception -> L128
        r175.append(": ");     // Catch: Exception -> L128
        RoomFeatureValue r176 = r174.getValue();     // Catch: Exception -> L128
        if (r176 == null) goto L124;
        String r177 = r176.getValue();     // Catch: Exception -> L128
        if (r177 == null) goto L124;
    L125:
        r175.append(r177);     // Catch: Exception -> L128
        r172.add(r175.toString());     // Catch: Exception -> L128
    L124:
        r177 = r131;
        goto L125
    L126:
        r171.append(CollectionsKt.joinToString$default(r172, null, null, null, 0, null, null, 63, null));     // Catch: Exception -> L128
        ALogger.i("LFM-strategy_tag", r171.toString());     // Catch: Exception -> L128
    L128:
        e = e;
    L132:
        e = e;
        r213 = "LFM-FeatureManager";
        r131 = "null";
    L135:
        r131 = "null";
        goto L137
    L26:
        r103 = r211;
        goto L27
    }

    @Override // z90.a
    public final boolean e(z90.a.b r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (r101 == null) goto L11;
        ConcurrentHashMap<z90.a.b, List<String>> r102 = f69265k;
        List<String> r103 = r102.get(r100);
        if (r103 != null) goto L7;
        r103 = CollectionsKt.emptyList();
    L7:
        List<String> r104 = r101;
        if (r103.containsAll(r104) == true) goto L11;
        r102.put(r100, CollectionsKt.distinct(CollectionsKt.plus(r104, r103)));
        return true;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v64, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v65, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v66, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v67 */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r1v86 */
    /* JADX WARN: Type inference failed for: r1v87 */
    /* JADX WARN: Type inference failed for: r1v88 */
    /* JADX WARN: Type inference failed for: r1v89 */
    /* JADX WARN: Type inference failed for: r1v90 */
    /* JADX WARN: Type inference failed for: r1v91 */
    /* JADX WARN: Type inference failed for: r1v92 */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r1v94 */
    /* JADX WARN: Type inference failed for: r1v95 */
    /* JADX WARN: Type inference failed for: r1v96 */
    /* JADX WARN: Type inference failed for: r1v97 */
    /* JADX WARN: Type inference failed for: r1v98 */
    /* JADX WARN: Type inference failed for: r1v99 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.bytedance.android.live.impl.service.FeatureManager] */
    /* JADX WARN: Type inference failed for: r4v22, types: [com.bytedance.android.live.impl.service.FeatureManager] */
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
    @Override // z90.a
    public final <T> T getFeature(String r210, T r211) {
        final String r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "name");
        LiveFeatureConfig r101 = f69257c;
        if (r101.getMockFeatureEnable() == false) goto L10;
        Map<String, Object> r102 = r101.getMockFeatureMap();
        if (r102 == null) goto L7;
        T r103 = (T) r102.get(r100);
    L9:
        if ((r103 instanceof Object) == false) goto L10;
    L12:
        if (r103 == null) goto L16;
        boolean r104 = com.bytedance.android.live.impl.utils.a.f69317a;
        final T r105 = r103;
        com.bytedance.android.live.impl.utils.a.c("LFM-FeatureManager", new FeatureManager$getFeature$$inlined$let$lambda$1(r105, r100));
        return r103;
    L16:
        if (StringsKt.contains$default(r100, '#', false, 2, null) == false) goto L27;
        List r106 = StringsKt.split$default(r210, new char[]{'#'}, false, 0, 6, null);
        if ((!r106.isEmpty()) == false) goto L25;
        Iterator<z90.d> r107 = f69267m.iterator();
    L21:
        if (r107.hasNext() == false) goto L25;
        z90.d r108 = r107.next();
        if ((r108 instanceof com.bytedance.android.live.impl.logfilter.d) == false) goto L21;
        ((com.bytedance.android.live.impl.logfilter.d) r108).b((String) ListProtector.get(r106, 0), (String) ListProtector.get(r106, 1));
    L25:
        final String r109 = r100;
    L201:
        ?? r110 = 2;
        if (StringsKt.startsWith$default(r109, "aweme_", false, 2, null) == false) goto L294;
        List<String> r111 = FeedFeatureManager.f69276a;
        Object r112 = FeedFeatureManager.a(r210, r211);
        ?? r113 = r211;
    L204:
        ?? r114 = r113;
    L274:
        if (r112 == null) goto L276;
    L278:
        final boolean r115 = false;
    L279:
        if (r112 != null) goto L281;
        r112 = p((Object) r114, f69255a.get(r109));
    L281:
        if (r112 == null) goto L284;
        r114 = (T) r112;
    L284:
        boolean r116 = com.bytedance.android.live.impl.utils.a.f69317a;
        final Object r117 = (Object) r114;
        com.bytedance.android.live.impl.utils.a.c("LFM-FeatureManager", new AnonymousClass13(r109, r117, r115));
        return (T) r114;
    L276:
        if (f69255a.containsKey(r109) == true) goto L278;
        r115 = true;
        goto L279
    L294:
        if (StringsKt.startsWith$default(r109, "pitaya_features_", false, 2, null) == true) goto L291;
        r110 = r211;
        if (StringsKt.startsWith$default(r109, "solaria_features_", false, 2, null) == false) goto L237;
        LivePortraitCenterService r118 = LivePortraitCenterService.f69280b;     // Catch: Exception -> L286
        String r119 = r118.getPortrait(StringsKt.removePrefix(r109, "solaria_features_"));     // Catch: Exception -> L286
        if (r119 == null) goto L226;
        f69275u.getClass();     // Catch: Exception -> L286
        Object r120 = p(r110, r119);     // Catch: Exception -> L286
        r110 = r110;
    L293:
    L260:
        r112 = r120;
        r113 = r110;
        goto L204
    L226:
        r118.a();     // Catch: Exception -> L286
        Object r121 = f69255a.get("solaria_features");     // Catch: Exception -> L286
        if ((r121 instanceof JSONObject) == true) goto L229;
        r121 = null;
    L229:
        JSONObject r122 = (JSONObject) r121;     // Catch: Exception -> L286
        if (r122 == null) goto L235;
        Object r123 = r122.opt(StringsKt.removePrefix(r109, "solaria_features_"));     // Catch: Exception -> L286
        if (r123 == null) goto L235;
        r120 = p(r110, r123);     // Catch: Exception -> L286
        r110 = r110;
    L235:
        r112 = null;
        r113 = r110;
        goto L204
    L237:
        if (StringsKt.startsWith$default(r109, "player_monitor_features_", false, 2, null) == false) goto L248;
        Object r124 = f69255a.get("player_monitor_features");
        if ((r124 instanceof JSONObject) == true) goto L241;
        r124 = null;
    L241:
        JSONObject r125 = (JSONObject) r124;
        r110 = r110;
        if (r125 == null) goto L246;
        Object r126 = r125.opt(StringsKt.removePrefix(r109, "player_monitor_features_"));
        r110 = r110;
        if (r126 == null) goto L246;
        f69275u.getClass();
        Object r127 = p(r110, r126);
        f69256b.put(r109, r126);
        r112 = r127;
        r113 = r110;
    L246:
        Object r128 = null;
    L273:
        r112 = r128;
        r114 = r110;
        goto L274
    L248:
        if (StringsKt.startsWith$default(r109, "linkage_room_features_", false, 2, null) == false) goto L251;
        String r129 = StringsKt.removePrefix(r109, "linkage_room_features_");
        r112 = f69275u.b(StringsKt.substringAfter(r129, Typography.dollar, ""), StringsKt.substringBefore$default(r129, Typography.dollar, null, 2, null), r110);
        r113 = r110;
        goto L204
    L251:
        if (StringsKt.startsWith$default(r109, "preview_wormhole_pre_aweme_features_", false, 2, null) == false) goto L261;
        String r130 = StringsKt.removePrefix(r109, "preview_wormhole_pre_aweme_features_");
        Object r131 = f69255a.get("preview_wormhole_pre_aweme_features");
        if ((r131 instanceof JSONObject) == true) goto L255;
        r131 = null;
    L255:
        JSONObject r132 = (JSONObject) r131;
        FeatureManager r133 = f69275u;
        if (r132 == null) goto L258;
        Object r134 = r132.opt(r130);
    L259:
        r133.getClass();
        r120 = p(r110, r134);
        goto L260
    L258:
        r134 = null;
        goto L259
    L261:
        r128 = null;
        if (StringsKt.startsWith$default(r109, "video_features_", false, 2, null) == false) goto L273;
        LivePortraitCenterService r135 = LivePortraitCenterService.f69280b;     // Catch: Exception -> L272
        String r136 = StringsKt.removePrefix(r109, "video_features_");     // Catch: Exception -> L272
        Intrinsics.checkNotNullParameter(r136, "name");     // Catch: Exception -> L272
        IMiddleHostService r137 = TTMiddlewareLiveSDK.hostMiddlewareService();     // Catch: Exception -> L272
        if (r137 == null) goto L268;
        IMiddlewareHostAction r138 = r137.action();     // Catch: Exception -> L272
        if (r138 == null) goto L268;
        Object r139 = r138.getVideoFeature(r136);     // Catch: Exception -> L272
    L269:
        if (r139 == null) goto L273;
        f69275u.getClass();     // Catch: Exception -> L272
        r112 = p(r110, r139);     // Catch: Exception -> L272
        r114 = r110;
    L268:
        r139 = null;
        goto L269
    L291:
        Object r140 = f69255a.get("pitaya_features");     // Catch: Exception -> L219
        if ((r140 instanceof JSONObject) == true) goto L210;
        r140 = null;
    L210:
        JSONObject r141 = (JSONObject) r140;     // Catch: Exception -> L219
        if (r141 == null) goto L220;
        Object r142 = r141.opt(StringsKt.removePrefix(r109, "pitaya_features_"));     // Catch: Exception -> L219
        if (r142 == null) goto L220;
        f69275u.getClass();     // Catch: Exception -> L219
        T r143 = r211;
        r120 = p(r143, r142);     // Catch: Exception -> L286
        r110 = r143;
    L220:
        r110 = r211;
    L219:
        r110 = r211;
    L218:
        r110 = r110;
        goto L246
    L27:
        switch(r210.hashCode()) {
            case -1542114302: goto L147;
            case -742483987: goto L144;
            case -742482220: goto L141;
            case -742479337: goto L138;
            case -547415821: goto L94;
            case -108322226: goto L91;
            case 149071930: goto L88;
            case 317334266: goto L85;
            case 557945987: goto L82;
            case 930975679: goto L33;
            case 1138410282: goto L30;
            default: goto L342;
        };
    L342:
        r109 = r100;
    L188:
        Object r144 = (T) null;
    L189:
        if (r144 == null) goto L191;
        f69275u.getClass();
        q(r109, r144);
    L191:
        if (r144 == null) goto L194;
        boolean r145 = com.bytedance.android.live.impl.utils.a.f69317a;
        final Object r146 = r144;
        com.bytedance.android.live.impl.utils.a.a("LFM-FeatureManager", new FeatureManager$getFeature$$inlined$let$lambda$2(r146, r109));
        return (T) r144;
    L194:
        Iterator<z90.d> r147 = f69267m.iterator();
    L196:
        if (r147.hasNext() == false) goto L201;
        final T r148 = (T) r147.next().getFeature(r109);
        if (r148 == null) goto L196;
        boolean r149 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.c("LFM-FeatureManager", new FeatureManager$getFeature$$inlined$forEach$lambda$1(r148, r148, r109));
        return r148;
    L30:
        if (r100.equals("cur_hour_in_cdn_peak_60") == true) goto L287;
        r109 = r100;
    L287:
        String r150 = (String) f69275u.getFeature("solaria_features_live_cdn_tracker_info", "");     // Catch: Exception -> L43
        if (f69270p != null) goto L44;
        if (r150.length() <= 0) goto L39;
        boolean r151 = true;
    L40:
        if (r151 == false) goto L44;
        f69270p = (CdnTrackerInfo) GsonHelper.get().fromJson("{\"conditions\":" + r150 + '}', CdnTrackerInfo.class);     // Catch: Exception -> L43
        goto L44
    L39:
        r151 = false;
    L44:
        int r152 = r210.hashCode();
        if (r152 == 930975679) goto L66;
        if (r152 == 1138410282) goto L50;
        r109 = r100;
        goto L188
    L50:
        if (r100.equals("cur_hour_in_cdn_peak_60") == false) goto L322;
        CdnTrackerInfo r153 = f69270p;
        if (r153 == null) goto L323;
        Condition r154 = r153.getConditionByKey("live_cdn_night_degradation_abtest_60mins");
        if (r154 == null) goto L324;
        FeatureManager r155 = f69275u;
        long r156 = r154.getFilterStartTime();
        long r157 = r154.getFilterEndTime();
        r155.getClass();
        long r158 = System.currentTimeMillis() / ((long) 1000);
        if (r156 <= r158) goto L59;
    L61:
        int r159 = 0;
    L62:
        r144 = (T) Integer.valueOf(r159);
        if ((r144 instanceof Object) == false) goto L344;
    L136:
        r109 = r100;
        goto L189
    L344:
        r109 = r100;
        goto L188
    L59:
        if (r157 < r158) goto L61;
        r159 = 1;
        goto L62
    L324:
        r109 = r100;
        goto L188
    L323:
        r109 = r100;
        goto L188
    L322:
        r109 = r100;
        goto L188
    L66:
        if (r100.equals("cur_hour_in_cdn_peak_120") == false) goto L325;
        CdnTrackerInfo r160 = f69270p;
        if (r160 == null) goto L326;
        Condition r161 = r160.getConditionByKey("live_cdn_night_degradation_abtest_120mins");
        if (r161 == null) goto L327;
        FeatureManager r162 = f69275u;
        long r163 = r161.getFilterStartTime();
        long r164 = r161.getFilterEndTime();
        r162.getClass();
        long r165 = System.currentTimeMillis() / ((long) 1000);
        if (r163 <= r165) goto L75;
    L77:
        int r166 = 0;
    L78:
        r144 = (T) Integer.valueOf(r166);
        if ((r144 instanceof Object) == true) goto L136;
        r109 = r100;
        goto L188
    L75:
        if (r164 < r165) goto L77;
        r166 = 1;
        goto L78
    L327:
        r109 = r100;
        goto L188
    L326:
        r109 = r100;
        goto L188
    L325:
        r109 = r100;
        goto L188
    L33:
        if (r100.equals("cur_hour_in_cdn_peak_120") == true) goto L287;
        r109 = r100;
        goto L188
    L82:
        if (r100.equals("cur_hour") == true) goto L96;
        r109 = r100;
    L96:
        if (c0.f497176a.getValue().getTimeOptEnable() == false) goto L99;
        f69272r.setTimeInMillis(com.bytedance.android.livesdk.utils.ntp.a.f159087a + System.currentTimeMillis());
    L99:
        switch(r210.hashCode()) {
            case -547415821: goto L132;
            case -108322226: goto L127;
            case 149071930: goto L112;
            case 317334266: goto L107;
            case 557945987: goto L102;
            default: goto L346;
        };
    L346:
        r109 = r100;
        goto L188
    L102:
        if (r100.equals("cur_hour") == false) goto L333;
        r144 = Integer.valueOf(f69272r.get(11));
        if ((r144 instanceof Object) == true) goto L136;
        r109 = r100;
        goto L188
    L333:
        r109 = r100;
        goto L188
    L107:
        if (r100.equals("cur_day_of_month") == false) goto L334;
        r144 = Integer.valueOf(f69272r.get(5));
        if ((r144 instanceof Object) == true) goto L136;
        r109 = r100;
        goto L188
    L334:
        r109 = r100;
        goto L188
    L112:
        if (r100.equals("cur_day_of_week") == false) goto L335;
        Calendar r167 = f69272r;
        if (r167.getFirstDayOfWeek() != 1) goto L116;
        boolean r168 = true;
    L117:
        int r169 = 7;
        int r170 = r167.get(7);
        if (r168 == false) goto L122;
        r170 = r170 - 1;
        if (r170 != 0) goto L122;
    L123:
        r144 = Integer.valueOf(r169);
        if ((r144 instanceof Object) == true) goto L136;
        r109 = r100;
    L122:
        r169 = r170;
        goto L123
    L116:
        r168 = false;
        goto L117
    L335:
        r109 = r100;
        goto L188
    L127:
        if (r100.equals("cur_minute_in_day") == false) goto L336;
        Calendar r171 = f69272r;
        r144 = Integer.valueOf((r171.get(11) * 60) + r171.get(12));
        if ((r144 instanceof Object) == true) goto L136;
        r109 = r100;
        goto L188
    L336:
        r109 = r100;
        goto L188
    L132:
        if (r100.equals("cur_minute") == false) goto L337;
        r144 = Integer.valueOf(f69272r.get(12));
        if ((r144 instanceof Object) == true) goto L136;
        r109 = r100;
        goto L188
    L337:
        r109 = r100;
        goto L188
    L85:
        if (r100.equals("cur_day_of_month") == true) goto L96;
        r109 = r100;
        goto L188
    L88:
        if (r100.equals("cur_day_of_week") == true) goto L96;
        r109 = r100;
        goto L188
    L91:
        if (r100.equals("cur_minute_in_day") == true) goto L96;
        r109 = r100;
        goto L188
    L94:
        if (r100.equals("cur_minute") == true) goto L96;
        r109 = r100;
        goto L188
    L138:
        if (r100.equals("stall_counter_60s") == false) goto L338;
    L148:
        List r172 = (List) getFeature("stall_counter", new ArrayList());
        long r173 = System.currentTimeMillis();
        int r174 = r172.size();
        if (r174 < 1) goto L183;
        Iterator<T> r175 = r172.iterator();
    L152:
        if (r175.hasNext() == false) goto L183;
        long r176 = ((Number) r175.next()).longValue();
        long r177 = r173 - r176;
        if (r177 < 0) goto L152;
        switch(r210.hashCode()) {
            case -1542114302: goto L176;
            case -742483987: goto L171;
            case -742482220: goto L165;
            case -742479337: goto L159;
            default: goto L152;
        };
    L165:
        r109 = r100;
        if (r109.equals("stall_counter_30s") == false) goto L170;
        long r212 = r173;
        if (r177 < 30000) goto L169;
    L181:
        r100 = r109;
        r173 = r212;
        goto L152
    L169:
        r144 = (T) Integer.valueOf(r174 - r172.indexOf(Long.valueOf(r176)));
    L185:
        if ((r144 instanceof Object) == true) goto L189;
    L170:
        r212 = r173;
        goto L181
    L171:
        r212 = r173;
        r109 = r100;
        if (r109.equals("stall_counter_15s") == false) goto L181;
        if (r177 >= 15000) goto L181;
        r144 = (T) Integer.valueOf(r174 - r172.indexOf(Long.valueOf(r176)));
        goto L185
    L176:
        r212 = r173;
        r109 = r100;
        if (r109.equals("stall_counter_300s") == false) goto L181;
        if (r177 >= 300000) goto L181;
        r144 = (T) Integer.valueOf(r174 - r172.indexOf(Long.valueOf(r176)));
        goto L185
    L159:
        if (r100.equals("stall_counter_60s") == true) goto L161;
        r100 = r210;
        goto L152
    L161:
        if (r177 < 60000) goto L162;
        r109 = r210;
        goto L170
    L162:
        r144 = (T) Integer.valueOf(r174 - r172.indexOf(Long.valueOf(r176)));
        r109 = r210;
    L183:
        r109 = r100;
        r144 = 0;
        goto L185
    L338:
        r109 = r100;
        goto L188
    L141:
        if (r100.equals("stall_counter_30s") == true) goto L148;
        r109 = r100;
        goto L188
    L144:
        if (r100.equals("stall_counter_15s") == true) goto L148;
        r109 = r100;
        goto L188
    L147:
        if (r100.equals("stall_counter_300s") == true) goto L148;
        r109 = r100;
        goto L188
    L7:
        r103 = null;
    L10:
        r103 = (T) null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r7v0, types: [T] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    @Override // z90.a
    public final <T> T b(String r100, String r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        Map<String, RoomFeatureValue> r103 = f69259e.get(r101);
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        return r102;
    L11:
        RoomFeatureValue r105 = r103.get(r100);
        if (r105 != null) goto L14;
    L91:
        return r102;
    L14:
        if (r105.getValue() == null) goto L91;
        Long r106 = r105.getExpTimeMs();
        if (r106 == null) goto L19;
        long r107 = r106.longValue();
    L21:
        if (r107 > 0) goto L23;
    L25:
        if (r102 != 0) goto L27;
        String r108 = r105.getType();     // Catch: Exception -> L95
        if (r108 != null) goto L61;
    L87:
        Object r109 = r105.getValue();     // Catch: Exception -> L95
    L88:
        r102 = (T) r109;
        goto L90
    L61:
        switch(r108.hashCode()) {
            case -1325958191: goto L82;
            case -891985903: goto L79;
            case 104431: goto L74;
            case 3029738: goto L69;
            case 97526364: goto L64;
            default: goto L87;
        };     // Catch: Exception -> L95
    L64:
        if (r108.equals("float") == false) goto L87;
        String r110 = r105.getValue();     // Catch: Exception -> L95
        if (r110 == null) goto L86;
        r109 = Float.valueOf(CastFloatProtector.parseFloat(r110));     // Catch: Exception -> L95
    L86:
        r102 = (T) null;
        goto L90
    L69:
        if (r108.equals("bool") == false) goto L87;
        String r111 = r105.getValue();     // Catch: Exception -> L95
        if (r111 == null) goto L86;
        r109 = Boolean.valueOf(Boolean.parseBoolean(r111));     // Catch: Exception -> L95
        goto L88
    L74:
        if (r108.equals("int") == false) goto L87;
        String r112 = r105.getValue();     // Catch: Exception -> L95
        if (r112 == null) goto L86;
        r109 = Integer.valueOf(CastIntegerProtector.parseInt(r112));     // Catch: Exception -> L95
        goto L88
    L79:
        if (r108.equals("string") == false) goto L87;
        r109 = r105.getValue();     // Catch: Exception -> L95
        goto L88
    L82:
        if (r108.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L87;
        String r113 = r105.getValue();     // Catch: Exception -> L95
        if (r113 == null) goto L86;
        r109 = Double.valueOf(CastDoubleProtector.parseDouble(r113));     // Catch: Exception -> L95
    L90:
        return (T) r102;
    L27:
        if ((r102 instanceof Long) == false) goto L32;
        String r114 = r105.getValue();
        long r115 = ((Number) r102).longValue();
        r115 = CastLongProtector.parseLong(r114);     // Catch: Throwable -> L92
    L105:
        return (T) Long.valueOf(r115);
    L32:
        if ((r102 instanceof Integer) == false) goto L39;
        String r116 = r105.getValue();
        int r117 = ((Number) r102).intValue();
        if (r116 == null) goto L106;
        r117 = CastIntegerProtector.parseInt(r116);     // Catch: Throwable -> L93
    L106:
        return (T) Integer.valueOf(r117);
    L39:
        if ((r102 instanceof Float) == false) goto L44;
        String r118 = r105.getValue();
        float r119 = ((Number) r102).floatValue();
        r119 = CastFloatProtector.parseFloat(r118);     // Catch: Throwable -> L94
    L107:
        return (T) Float.valueOf(r119);
    L44:
        if ((r102 instanceof Double) == false) goto L51;
        double r120 = CastDoubleProtector.parseDouble(r105.getValue());     // Catch: Throwable -> L48
    L108:
        return (T) Double.valueOf(r120);
    L48:
        r120 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L108
    L51:
        if ((r102 instanceof Boolean) == false) goto L54;
        return (T) d5.a(r105.getValue(), ((Boolean) r102).booleanValue());
    L54:
        if ((r102 instanceof String) == false) goto L111;
        return (T) r105.getValue();
    L111:
        return (T) r105.getValue();
    L23:
        if (r107 >= System.currentTimeMillis()) goto L25;
        return r102;
    L19:
        r107 = -1;
        goto L21
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    @Override // z90.a
    public final boolean i(final String r100, final Object r101, final FeatureType r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, "type");
        if (r101 != null) goto L6;
        return false;
    L6:
        if (n(r100, r101) == false) goto L71;
        ConcurrentHashMap<String, Object> r103 = f69255a;
        if (r102 != FeatureType.DYNAMIC_MONITOR) goto L11;
    L14:
        Object r104 = r103.get(r100);
    L16:
        if (Intrinsics.areEqual(r100, "player_monitor_features") == true) goto L18;
    L20:
        q(r100, r101);
        int r105 = com.bytedance.android.live.impl.service.b.f69292a[r102.ordinal()];
        if (r105 == 1) goto L38;
        if (r105 == 2) goto L53;
    L51:
        return true;
    L53:
        boolean r106 = com.bytedance.android.live.impl.utils.a.f69317a;     // Catch: Exception -> L27
        com.bytedance.android.live.impl.utils.a.d("LFM-FeatureManager", new FeatureManager$realPutFeature$4(r100, r101, r102));     // Catch: Exception -> L27
    L29:
        Iterator<Map.Entry<z90.a.b, List<String>>> r107 = f69265k.entrySet().iterator();
    L31:
        if (r107.hasNext() == false) goto L51;
        Map.Entry<z90.a.b, List<String>> r108 = r107.next();
        if (r108.getValue().contains(r100) == false) goto L31;
        z90.a.b r109 = r108.getKey();
        if (r109 == null) goto L31;
        r109.a(r100, r101);
    L27:
        e = move-exception;
        boolean r110 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", new FeatureManager$realPutFeature$5(r100, r102), e);
        goto L29
    L38:
        if ((!Intrinsics.areEqual(r104, r101)) == false) goto L51;
        boolean r111 = com.bytedance.android.live.impl.utils.a.f69317a;     // Catch: Exception -> L41
        com.bytedance.android.live.impl.utils.a.d("LFM-FeatureManager", new FeatureManager$realPutFeature$1(r100, r101, r102));     // Catch: Exception -> L41
    L43:
        Iterator<Map.Entry<z90.a.b, List<String>>> r112 = f69265k.entrySet().iterator();
    L45:
        if (r112.hasNext() == false) goto L51;
        Map.Entry<z90.a.b, List<String>> r113 = r112.next();
        if (r113.getValue().contains(r100) == false) goto L45;
        z90.a.b r114 = r113.getKey();
        if (r114 == null) goto L45;
        r114.a(r100, r101);
    L41:
        e = move-exception;
        boolean r115 = com.bytedance.android.live.impl.utils.a.f69317a;
        com.bytedance.android.live.impl.utils.a.b("LFM-FeatureManager", new FeatureManager$realPutFeature$2(r100, r102), e);
        goto L43
    L18:
        if ((r101 instanceof JSONObject) == false) goto L20;
        f69256b.forEach(new c(r101));
        goto L20
    L11:
        if (r102 == FeatureType.MONITOR) goto L14;
        r104 = null;
        goto L16
    L71:
        return false;
    }

    public static void l(Map r100, String r110, List r111, RoomFeatureValue r112) {
        String r113 = CollectionsKt.joinToString$default(CollectionsKt.distinct(r111), " & ", null, null, 0, null, null, 62, null);
        RoomFeatureValue r101 = new RoomFeatureValue();
        r101.setValue(r113);
        r101.setType("string");
        r101.setGenTimeMs(r112.getGenTimeMs());
        r101.setExpTimeMs(r112.getExpTimeMs());
        ALogger.i("LFM-strategy_tag", "[addAudioMixFeature] key=" + r110 + ",value=" + r101.getValue() + ",type=" + r101.getType());
        r100.put(r110, r101);
    }
}
