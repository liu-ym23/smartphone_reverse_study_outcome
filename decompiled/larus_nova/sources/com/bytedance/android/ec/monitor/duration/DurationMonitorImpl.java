package com.bytedance.android.ec.monitor.duration;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.bytedance.android.ec.opt.asynctask.k;
import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.ec.opt.asynctask.w;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class DurationMonitorImpl implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f47969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f47970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<h> f47971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f47972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f47973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f47974f;

    public final class PostThreeFrameTask implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DurationMonitorImpl f47975a;

        public PostThreeFrameTask(DurationMonitorImpl r100) {
            this.f47975a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            DurationMonitorImpl r101 = this.f47975a;
            int r102 = r101.f47972d + 1;
            r101.f47972d = r102;
            if (r102 != 3) goto L13;
            r101.f47969a.put("render_end", Long.valueOf(System.currentTimeMillis()));
            DurationMonitorImpl r103 = this.f47975a;
            r103.f47972d = -1;
            r103.getClass();
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
            Iterator r105 = ((ArrayList) r103.f47971c).iterator();     // Catch: Throwable -> L11
        L7:
            if (r105.hasNext() == false) goto L9;
            ((h) r105.next()).f(r103.f47969a);     // Catch: Throwable -> L11
            goto L7
        L9:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return;
        L13:
            r101.h(new DurationMonitorImpl$PostThreeFrameTask$doFrame$1(this));
        }
    }

    public static final class a implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DurationMonitorImpl f47976a;

        @Override // com.bytedance.android.ec.opt.asynctask.w
        public final k r() {
            r r100 = new r();
            r100.f48047b = true;
            return r100.f48051f;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f47976a.b(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
            this.f47976a.g(null);
            DurationMonitorManager.f47981d.getClass();
            DurationMonitorManager.a.a().remove(String.valueOf(this.f47976a.hashCode()));
        }

        public a(DurationMonitorImpl r100) {
            this.f47976a = r100;
        }
    }

    public static final class b implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DurationMonitorImpl f47977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f47978b;

        @Override // com.bytedance.android.ec.opt.asynctask.w
        public final k r() {
            r r100 = new r();
            r100.f48047b = true;
            return r100.f48051f;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f47977a.b(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
            this.f47977a.g(this.f47978b);
            DurationMonitorManager.f47981d.getClass();
            DurationMonitorManager.a.a().remove(String.valueOf(this.f47977a.hashCode()));
        }

        public b(DurationMonitorImpl r100, String r101) {
            this.f47977a = r100;
            this.f47978b = r101;
        }
    }

    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f47979a;

        public c(Function0 r100) {
            this.f47979a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f47979a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.ec.monitor.duration.d
    public final void report() {
        t.b(new a(this));
    }

    public DurationMonitorImpl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "business");
        this.f47974f = r100;
        this.f47969a = new ConcurrentHashMap();
        this.f47970b = new ConcurrentHashMap();
        this.f47971c = new ArrayList();
        this.f47972d = -1;
        this.f47973e = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.android.ec.monitor.duration.d
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (Intrinsics.areEqual(r100, "render_end") == false) goto L5;
        this.f47972d++;
        h(new DurationMonitorImpl$timestamp$1(this));
        return;
    L5:
        this.f47969a.put(r100, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.bytedance.android.ec.monitor.duration.d
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "forceBusinessId");
        t.b(new b(this, r100));
    }

    @Override // com.bytedance.android.ec.monitor.duration.d
    public final void e(h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) this.f47971c).contains(r100) == true) goto L6;
        ((ArrayList) this.f47971c).add(r100);
        return;
    }

    public final void g(String r310) {
        Iterator r100 = ((ArrayList) this.f47971c).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((h) r100.next()).a(this.f47969a);
        goto L4
    L6:
        Object r101 = this.f47969a.get("initial");
        if ((r101 instanceof Long) == true) goto L9;
        r101 = null;
    L9:
        Long r102 = (Long) r101;
        if (r102 == null) goto L12;
        long r103 = r102.longValue();
    L13:
        Object r104 = this.f47969a.get("reload");
        if ((r104 instanceof Long) == true) goto L16;
        r104 = null;
    L16:
        Long r105 = (Long) r104;
        if (r105 == null) goto L19;
        long r110 = r105.longValue();
    L21:
        if (r103 < 0) goto L23;
    L29:
        Object r111 = this.f47969a.get("request_start");
        if ((r111 instanceof Long) == true) goto L32;
        r111 = null;
    L32:
        Long r112 = (Long) r111;
        if (r112 == null) goto L35;
        long r106 = r112.longValue();
    L36:
        Object r113 = this.f47969a.get("request_end");
        if ((r113 instanceof Long) == true) goto L39;
        r113 = null;
    L39:
        Long r114 = (Long) r113;
        if (r114 == null) goto L42;
        long r115 = r114.longValue();
    L43:
        long r116 = r115 - r106;
        Object r107 = this.f47969a.get("render_start");
        if ((r107 instanceof Long) == true) goto L46;
        r107 = null;
    L46:
        Long r108 = (Long) r107;
        if (r108 == null) goto L49;
        long r117 = r108.longValue();
    L51:
        if (r117 >= 0) goto L57;
        Iterator r109 = ((ArrayList) this.f47971c).iterator();
    L54:
        if (r109.hasNext() == false) goto L56;
        ((h) r109.next()).b("renderStart < 0", this.f47969a);
        goto L54
    L56:
        return;
    L57:
        Object r118 = this.f47969a.get("render_end");
        long r210 = r115;
        if ((r118 instanceof Long) == true) goto L60;
        r118 = null;
    L60:
        Long r119 = (Long) r118;
        if (r119 == null) goto L63;
        long r120 = r119.longValue();
    L65:
        if (r120 < 0) goto L67;
    L82:
        long r121 = r106;
        long r122 = r120 - r117;
        if (r122 >= 0) goto L89;
        Iterator r123 = ((ArrayList) this.f47971c).iterator();
    L86:
        if (r123.hasNext() == false) goto L88;
        ((h) r123.next()).b("renderDuration < 0", this.f47969a);
        goto L86
    L88:
        return;
    L89:
        if (r103 <= 0) goto L91;
        long r211 = r103;
        long r124 = 0;
    L94:
        long r125 = r120 - r211;
        if (r125 >= r124) goto L101;
        Iterator r126 = ((ArrayList) this.f47971c).iterator();
    L98:
        if (r126.hasNext() == false) goto L100;
        ((h) r126.next()).b("duration < 0", this.f47969a);
        goto L98
    L100:
        return;
    L101:
        JSONObject r127 = new JSONObject();
        if (r103 <= 0) goto L105;
        r127.put("initial", r103);
    L107:
        Object r128 = this.f47969a.get("pre_page_click_start");
        if ((r128 instanceof Long) == true) goto L110;
        r128 = null;
    L110:
        Long r129 = (Long) r128;
        if (r129 == null) goto L115;
        long r130 = r129.longValue();
        long r131 = 0;
        if (r130 <= 0) goto L116;
        r127.putOpt("pre_page_click_start", Long.valueOf(r130));
        r127.putOpt("pre_page_to_render_duration", Long.valueOf(r120 - r130));
    L116:
        r127.put("request_start", r121);
        r127.put("request_end", r210);
        r127.put(com.bytedance.android.ec.core.event.a.KEY_API_DURATION, r116);
        r127.put("render_start", r117);
        r127.put("render_end", r120);
        r127.put("render_duration", r122);
        r127.put("duration", r125);
        if ((!this.f47970b.isEmpty()) == false) goto L137;
        Iterator<Map.Entry<String, Object>> r132 = this.f47970b.entrySet().iterator();
    L120:
        if (r132.hasNext() == false) goto L137;
        Map.Entry<String, Object> r133 = r132.next();
        if (Intrinsics.areEqual("ec_perf_duration_cart", this.f47974f) == true) goto L124;
        r127.put(r133.getKey(), r133.getValue());
        goto L120
    L124:
        if (Intrinsics.areEqual(r133.getKey(), "ectag_data_parse_time") == false) goto L135;
        StringCompanionObject r134 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L134
        Object[] r135 = new Object[1];     // Catch: Exception -> L134
        Object r136 = r133.getValue();     // Catch: Exception -> L134
        if ((r136 instanceof com.bytedance.android.ec.monitor.duration.c) == true) goto L128;
        r136 = null;
    L128:
        com.bytedance.android.ec.monitor.duration.c r137 = (com.bytedance.android.ec.monitor.duration.c) r136;     // Catch: Exception -> L134
        if (r137 == null) goto L131;
        long r138 = r137.f47986a;     // Catch: Exception -> L134
    L132:
        r135[0] = Float.valueOf(r138 / 1000000.0f);     // Catch: Exception -> L134
        r127.put(r133.getKey(), Float.valueOf(CastFloatProtector.parseFloat(String.format("%.3f", Arrays.copyOf(r135, 1)))));     // Catch: Exception -> L134
        goto L120
    L131:
        r138 = r131;
        goto L132
    L135:
        r127.put(r133.getKey(), r133.getValue());
    L137:
        LinkedHashSet r139 = new LinkedHashSet();
        Iterator<Map.Entry<String, Object>> r140 = this.f47969a.entrySet().iterator();
    L139:
        if (r140.hasNext() == false) goto L158;
        Map.Entry<String, Object> r141 = r140.next();
        if (ArraysKt.contains(com.bytedance.android.ec.monitor.duration.b.f47985a, r141.getKey()) == true) goto L139;
        if (StringsKt.endsWith$default(r141.getKey(), "_start", false, 2, null) == true) goto L144;
        if (StringsKt.endsWith$default(r141.getKey(), "_end", false, 2, null) == false) goto L139;
        String r142 = StringsKt.replace$default(r141.getKey(), "_end", "", false, 4, null);
        if (r139.contains(r142) == true) goto L139;
        if (this.f47969a.containsKey(r142 + "_start") == true) goto L156;
        r127.put(r141.getKey(), r141.getValue());
        goto L139
    L156:
        f(r142, r127);
        r139.add(r142);
        goto L139
    L144:
        String r143 = StringsKt.replace$default(r141.getKey(), "_start", "", false, 4, null);
        if (r139.contains(r143) == true) goto L139;
        if (this.f47969a.containsKey(r143 + "_end") == true) goto L148;
        r127.put(r141.getKey(), r141.getValue());
        goto L139
    L148:
        f(r143, r127);
        r139.add(r143);
        goto L139
    L158:
        r139.clear();
        DurationMonitorManager.f47981d.getClass();
        g r144 = DurationMonitorManager.a.a().b();
        if (r144 != null) goto L165;
        Iterator r145 = ((ArrayList) this.f47971c).iterator();
    L162:
        if (r145.hasNext() == false) goto L164;
        ((h) r145.next()).b("ReportDuration is null", this.f47969a);
        goto L162
    L164:
        return;
    L165:
        Iterator r146 = ((ArrayList) this.f47971c).iterator();
    L167:
        if (r146.hasNext() == false) goto L169;
        ((h) r146.next()).c(r127);
        goto L167
    L169:
        System.out.println("Django >> [DurationMonitor report]: report duration data: " + r127);
        if (r310 == null) goto L172;
        r144.onReport(r310, r127);     // Catch: Exception -> L177 Throwable -> L188
    L173:
        Iterator r147 = ((ArrayList) this.f47971c).iterator();
    L175:
        if (r147.hasNext() == false) goto L187;
        ((h) r147.next()).d(this.f47969a);
        goto L175
    L187:
        return;
    L172:
        r144.onReport(this.f47974f, r127);     // Catch: Exception -> L177 Throwable -> L188
    L188:
        th = move-exception;
        Iterator r148 = ((ArrayList) this.f47971c).iterator();
    L191:
        if (r148.hasNext() == false) goto L193;
        ((h) r148.next()).d(this.f47969a);
        goto L191
    L193:
        throw th;
    L177:
        e = move-exception;
        Iterator r149 = ((ArrayList) this.f47971c).iterator();     // Catch: Throwable -> L188
    L180:
        if (r149.hasNext() == false) goto L183;
        ((h) r149.next()).e(e, this.f47969a);     // Catch: Throwable -> L188
        goto L180
    L183:
        Iterator r150 = ((ArrayList) this.f47971c).iterator();
    L185:
        if (r150.hasNext() == false) goto L247;
        ((h) r150.next()).d(this.f47969a);
        goto L185
    L247:
        return;
    L115:
        r131 = 0;
        goto L116
    L105:
        if (r110 <= 0) goto L107;
        r127.put("reload", r110);
        goto L107
    L91:
        r124 = 0;
        if (r110 <= 0) goto L194;
        r211 = r110;
        goto L94
    L194:
        Iterator r151 = ((ArrayList) this.f47971c).iterator();
    L196:
        if (r151.hasNext() == false) goto L198;
        ((h) r151.next()).b("initial < 0 or reload < 0", this.f47969a);
        goto L196
    L198:
        return;
    L67:
        if (this.f47972d < 0) goto L82;
        Thread.sleep(1000);     // Catch: Exception -> L77
        Object r152 = this.f47969a.get("render_end");     // Catch: Exception -> L77
        if ((r152 instanceof Long) == true) goto L72;
        r152 = null;
    L72:
        Long r153 = (Long) r152;     // Catch: Exception -> L77
        if (r153 == null) goto L76;
        r120 = r153.longValue();     // Catch: Exception -> L77
    L79:
        if (r120 >= 0) goto L81;
        r120 = System.currentTimeMillis();
    L81:
        this.f47972d = -1;
        goto L82
    L76:
        r120 = -1;
    L77:
        r120 = System.currentTimeMillis();
        goto L79
    L63:
        r120 = -1;
        goto L65
    L49:
        r117 = -1;
        goto L51
    L42:
        r115 = 0;
        goto L43
    L35:
        r106 = 0;
        goto L36
    L23:
        if (r110 >= 0) goto L29;
        Iterator r154 = ((ArrayList) this.f47971c).iterator();
    L26:
        if (r154.hasNext() == false) goto L28;
        ((h) r154.next()).b("initial < 0 && reload < 0", this.f47969a);
        goto L26
    L28:
        return;
    L19:
        r110 = -1;
        goto L21
    L12:
        r103 = -1;
        goto L13
    }

    public final void h(Function0<Unit> r100) {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100.invoke();
        return;
    L8:
        this.f47973e.post(new c(r100));
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.ec.monitor.duration.d
    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f47970b.put(r100, r101);
    }

    @Override // com.bytedance.android.ec.monitor.duration.d
    public final void d(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f47969a.put(r100, Long.valueOf(r101));
    }

    public final void f(String r110, JSONObject r111) {
        String r100 = r110 + "_start";
        String r101 = r110 + "_end";
        String r112 = r110 + "_duration";
        Object r102 = this.f47969a.get(r100);
        Object r103 = null;
        if ((r102 instanceof Long) == true) goto L5;
        r102 = null;
    L5:
        Long r104 = (Long) r102;
        long r105 = -1;
        if (r104 == null) goto L8;
        long r106 = r104.longValue();
    L9:
        Object r107 = this.f47969a.get(r101);
        if ((r107 instanceof Long) == false) goto L13;
        r103 = r107;
    L13:
        Long r108 = (Long) r103;
        if (r108 == null) goto L16;
        r105 = r108.longValue();
    L16:
        r111.put(r100, r106);
        r111.put(r101, r105);
        r111.put(r112, r105 - r106);
        return;
    L8:
        r106 = -1;
        goto L9
    }
}
