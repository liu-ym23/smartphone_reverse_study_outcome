package com.bytedance.android.latch.internal.perf;

import android.os.Looper;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class LatchPerfMetricCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f58317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f58318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f58319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f58320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f58321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f58322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f58323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<b> f58324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<b> f58325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f58326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f58327k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f58328l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Long> f58329m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Long> f58330n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, Long> f58331o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f58332p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TransferType f58333q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f58334r;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/latch/internal/perf/LatchPerfMetricCollector$PerfPoints;", "", "HANDLE_SCHEME_INIT", "LATCH_START", "WORKER_READY", "FILES_LOADED", "EVALUATE_LATCH_INIT_START", "EVALUATE_PREFETCH_START", "EVALUATE_PREFETCH_END", "JSB_INIT", "JSB_END", "ATTACH_START", "ATTACH_CALLBACK_START", "ATTACH_CALLBACK_END_TIME", "ATTACH_CALLBACK_END", "SEND_JS_EVENT", "RECEIVE_JS_EVENT", "latch-core_release"}, k = 1, mv = {1, 4, 3})
    public static final enum PerfPoints extends Enum<PerfPoints> {
        public static final PerfPoints ATTACH_CALLBACK_END = null;
        public static final PerfPoints ATTACH_CALLBACK_END_TIME = null;
        public static final PerfPoints ATTACH_CALLBACK_START = null;
        public static final PerfPoints ATTACH_START = null;
        public static final PerfPoints EVALUATE_LATCH_INIT_START = null;
        public static final PerfPoints EVALUATE_PREFETCH_END = null;
        public static final PerfPoints EVALUATE_PREFETCH_START = null;
        public static final PerfPoints FILES_LOADED = null;
        public static final PerfPoints HANDLE_SCHEME_INIT = null;
        public static final PerfPoints JSB_END = null;
        public static final PerfPoints JSB_INIT = null;
        public static final PerfPoints LATCH_START = null;
        public static final PerfPoints RECEIVE_JS_EVENT = null;
        public static final PerfPoints SEND_JS_EVENT = null;
        public static final PerfPoints WORKER_READY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PerfPoints[] f58335a = null;

        public static PerfPoints valueOf(String r100) {
            return (PerfPoints) r27.a.a(PerfPoints.class, r100);
        }

        public static PerfPoints[] values() {
            return (PerfPoints[]) f58335a.clone();
        }

        static {
            PerfPoints r100 = new PerfPoints("HANDLE_SCHEME_INIT", 0);
            HANDLE_SCHEME_INIT = r100;
            PerfPoints r101 = new PerfPoints("LATCH_START", 1);
            LATCH_START = r101;
            PerfPoints r102 = new PerfPoints("WORKER_READY", 2);
            WORKER_READY = r102;
            PerfPoints r103 = new PerfPoints("FILES_LOADED", 3);
            FILES_LOADED = r103;
            PerfPoints r104 = new PerfPoints("EVALUATE_LATCH_INIT_START", 4);
            EVALUATE_LATCH_INIT_START = r104;
            PerfPoints r105 = new PerfPoints("EVALUATE_PREFETCH_START", 5);
            EVALUATE_PREFETCH_START = r105;
            PerfPoints r110 = new PerfPoints("EVALUATE_PREFETCH_END", 6);
            EVALUATE_PREFETCH_END = r110;
            PerfPoints r111 = new PerfPoints("JSB_INIT", 7);
            JSB_INIT = r111;
            PerfPoints r112 = new PerfPoints("JSB_END", 8);
            JSB_END = r112;
            PerfPoints r113 = new PerfPoints("ATTACH_START", 9);
            ATTACH_START = r113;
            PerfPoints r114 = new PerfPoints("ATTACH_CALLBACK_START", 10);
            ATTACH_CALLBACK_START = r114;
            PerfPoints r115 = new PerfPoints("ATTACH_CALLBACK_END_TIME", 11);
            ATTACH_CALLBACK_END_TIME = r115;
            PerfPoints r106 = new PerfPoints("ATTACH_CALLBACK_END", 12);
            ATTACH_CALLBACK_END = r106;
            PerfPoints r107 = new PerfPoints("SEND_JS_EVENT", 13);
            SEND_JS_EVENT = r107;
            PerfPoints r108 = new PerfPoints("RECEIVE_JS_EVENT", 14);
            RECEIVE_JS_EVENT = r108;
            f58335a = new PerfPoints[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        }

        public PerfPoints(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/latch/internal/perf/LatchPerfMetricCollector$TransferType;", "", "", CommonConstant.KEY_DISPLAY_NAME, "Ljava/lang/String;", "getDisplayName", "()Ljava/lang/String;", EffectConstants.NORMAL, "OPTIMIZE", "latch-core_release"}, k = 1, mv = {1, 4, 3})
    public static final enum TransferType extends Enum<TransferType> {
        public static final TransferType NORMAL = null;
        public static final TransferType OPTIMIZE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TransferType[] f58336a = null;
        private final String displayName;

        public static TransferType valueOf(String r100) {
            return (TransferType) r27.a.a(TransferType.class, r100);
        }

        public static TransferType[] values() {
            return (TransferType[]) f58336a.clone();
        }

        static {
            TransferType r100 = new TransferType(EffectConstants.NORMAL, 0, "normal");
            NORMAL = r100;
            TransferType r101 = new TransferType("OPTIMIZE", 1, "optimize");
            OPTIMIZE = r101;
            f58336a = new TransferType[]{r100, r101};
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public TransferType(String r100, int r101, String r102) {
            super(r100, r101);
            this.displayName = r102;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f58337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f58338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f58339c;

        public b(String r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "callbackId");
            Intrinsics.checkNotNullParameter(r101, "methodName");
            this.f58337a = r100;
            this.f58338b = r101;
            this.f58339c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f58340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f58341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f58342c;

        public c(String r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "callbackId");
            Intrinsics.checkNotNullParameter(r101, "methodName");
            this.f58340a = r100;
            this.f58341b = r101;
            this.f58342c = r102;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f58343a = null;

        static {
            int[] r100 = new int[PerfPoints.values().length];
            r100[PerfPoints.HANDLE_SCHEME_INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L53:
            r100[PerfPoints.LATCH_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L63:
            r100[PerfPoints.WORKER_READY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[PerfPoints.FILES_LOADED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[PerfPoints.EVALUATE_LATCH_INIT_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L49:
            r100[PerfPoints.EVALUATE_PREFETCH_START.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L59:
            r100[PerfPoints.EVALUATE_PREFETCH_END.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L45:
            r100[PerfPoints.ATTACH_START.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L55:
            r100[PerfPoints.ATTACH_CALLBACK_START.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[PerfPoints.ATTACH_CALLBACK_END.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L37:
            r100[PerfPoints.ATTACH_CALLBACK_END_TIME.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L51:
            r100[PerfPoints.JSB_INIT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[PerfPoints.JSB_END.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L35:
            r100[PerfPoints.SEND_JS_EVENT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L43:
            r100[PerfPoints.RECEIVE_JS_EVENT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L18:
            f58343a = r100;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LatchPerfMetricCollector f58344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f58345b;

        public e(LatchPerfMetricCollector r100, String r101) {
            this.f58344a = r100;
            this.f58345b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LatchPerfMetricCollector r100 = this.f58344a;     // Catch: Throwable -> L4
            r100.f58332p = this.f58345b;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LatchPerfMetricCollector f58346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TransferType f58347b;

        public f(LatchPerfMetricCollector r100, TransferType r101) {
            this.f58346a = r100;
            this.f58347b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LatchPerfMetricCollector r100 = this.f58346a;     // Catch: Throwable -> L4
            r100.f58333q = this.f58347b;     // Catch: Throwable -> L4
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

    public final void e() {
        Intrinsics.checkNotNullParameter("native", "value");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        com.bytedance.android.latch.internal.util.b.f58388a.post(new h(this));
        return;
    L5:
        this.f58334r = "native";
    }

    public LatchPerfMetricCollector() {
        this.f58324h = new ArrayList();
        this.f58325i = new ArrayList();
        this.f58329m = new LinkedHashMap();
        this.f58330n = new LinkedHashMap();
        this.f58331o = new LinkedHashMap();
        this.f58332p = "fullscreen";
        this.f58333q = TransferType.NORMAL;
        this.f58334r = "vmsdk";
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        com.bytedance.android.latch.internal.util.b.f58388a.post(new e(this, r100));
        return;
    L5:
        this.f58332p = r100;
    }

    public final void f(TransferType r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        com.bytedance.android.latch.internal.util.b.f58388a.post(new f(this, r100));
        return;
    L5:
        this.f58333q = r100;
    }

    public static final void b(final LatchPerfMetricCollector r310, hx.a r311, com.bytedance.android.latch.a.d r410) {
        long r100 = r310.f58317a;
        if (r100 > 0) goto L6;
        r100 = r310.f58318b;
    L6:
        long r101 = r310.f58318b;
        long r102 = r101 - r100;
        long r103 = Math.max(r310.f58319c - r101, 0);
        long r110 = r310.f58319c;
        if (r110 <= 0) goto L9;
        long r111 = Math.max(r310.f58320d - r110, 0);
    L10:
        long r112 = Math.max(r310.f58320d - r310.f58318b, 0);
        long r113 = r310.f58321e;
        if (r113 <= 0) goto L13;
        long r114 = Math.max(r310.f58322f - r113, 0);
    L14:
        long r115 = r310.f58322f;
        if (r115 <= 0) goto L17;
        long r116 = Math.max(r310.f58323g - r115, 0);
    L18:
        long r117 = r310.f58323g - r310.f58318b;
        ArrayList r104 = new ArrayList();
        if (((ArrayList) r310.f58324h).isEmpty() == false) goto L21;
        long r210 = r116;
        long r118 = 0;
    L32:
        Iterator r105 = ((ArrayList) r310.f58325i).iterator();
    L34:
        if (r105.hasNext() == false) goto L48;
        b r106 = (b) r105.next();
        Iterator r119 = ((ArrayList) r310.f58324h).iterator();
    L37:
        if (r119.hasNext() == false) goto L42;
        Object r211 = r119.next();
        Iterator r212 = r105;
        if (Intrinsics.areEqual(((b) r211).f58337a, r106.f58337a) == true) goto L40;
        r105 = r212;
        goto L37
    L40:
        Object r120 = r211;
    L43:
        b r121 = (b) r120;
        if (r121 == null) goto L47;
        r104.add(new c(r121.f58337a, r121.f58338b, r106.f58339c - r121.f58339c));
    L47:
        r105 = r212;
        r118 = r118;
        r111 = r111;
        goto L34
    L42:
        r212 = r105;
        r120 = null;
        goto L43
    L48:
        long r312 = r111;
        long r213 = r118;
        ArrayList r107 = new ArrayList();
        if (r310.f58333q != TransferType.NORMAL) goto L52;
        r107.add(new c("0", "", r310.f58328l - r310.f58327k));
    L52:
        if (r310.f58329m.size() != 1) goto L57;
        Iterator r108 = ((LinkedHashMap) r310.f58329m).entrySet().iterator();
    L55:
        if (r108.hasNext() == false) goto L57;
        Map.Entry r122 = (Map.Entry) r108.next();
        String r123 = (String) r122.getKey();
        long r124 = ((Number) r122.getValue()).longValue();
        r107.add(new c(r123, "", r124 - r310.f58327k));
        r104 = r104;
        r108 = r108;
    L57:
        ArrayList r125 = r104;
        Iterator r109 = ((LinkedHashMap) r310.f58331o).entrySet().iterator();
    L59:
        if (r109.hasNext() == false) goto L63;
        Map.Entry r126 = (Map.Entry) r109.next();
        Long r127 = (Long) ((LinkedHashMap) r310.f58330n).get(r126.getKey());
        if (r127 == null) goto L59;
        r107.add(new c((String) r126.getKey(), "", ((Number) r126.getValue()).longValue() - r127.longValue()));
        Unit r128 = Unit.INSTANCE;
        goto L59
    L63:
        long r129 = r310.f58328l;
        Iterator r130 = ((LinkedHashMap) r310.f58331o).entrySet().iterator();
        if (r130.hasNext() == true) goto L66;
        Object r131 = null;
    L75:
        Map.Entry r132 = (Map.Entry) r131;
        if (r132 == null) goto L78;
        long r133 = ((Number) r132.getValue()).longValue();
    L79:
        Iterator r134 = ((LinkedHashMap) r310.f58329m).entrySet().iterator();
        if (r134.hasNext() == true) goto L82;
        Object r135 = null;
    L91:
        Map.Entry r136 = (Map.Entry) r135;
        if (r136 == null) goto L94;
        long r137 = ((Number) r136.getValue()).longValue();
    L95:
        long r138 = Math.max(0, Math.max(r129, Math.max(r133, r137)) - r100);
        JSONObject r139 = new JSONObject();
        r139.put("pre_handle", r102);
        r139.put("env_ready", r103);
        r139.put(MonitorConstants.IO, r312);
        r139.put("latch_ready", r112);
        r139.put("evaluate_latch_init", r114);
        r139.put("evaluate_prefetch", r210);
        r139.put("1st_blood", r213);
        r139.put("all_latch_cost", r117);
        Iterator r140 = r125.iterator();
    L97:
        if (r140.hasNext() == false) goto L102;
        c r141 = (c) r140.next();
        StringBuilder r142 = new StringBuilder();
        r142.append(r141.f58341b);
        r142.append('_');
        Object r143 = StringsKt.toIntOrNull(r141.f58340a);
        if (r143 != null) goto L101;
        r143 = r141.f58340a;
    L101:
        r142.append(r143);
        r142.append("_jsb_cost");
        r139.put(r142.toString(), r141.f58342c);
        goto L97
    L102:
        Iterator r144 = r107.iterator();
    L104:
        if (r144.hasNext() == false) goto L109;
        c r145 = (c) r144.next();
        StringBuilder r146 = new StringBuilder();
        Object r147 = StringsKt.toIntOrNull(r145.f58340a);
        if (r147 != null) goto L108;
        r147 = r145.f58340a;
    L108:
        r146.append(r147);
        r146.append("_data_transfer");
        r139.put(r146.toString(), r145.f58342c);
        goto L104
    L109:
        r139.put("total_duration", r138);
        if (r310.f58333q == TransferType.NORMAL) goto L112;
        long r148 = 0;
    L117:
        r139.put("actual_profit", Math.max(r148, r310.f58326j - r310.f58322f));
        JSONObject r149 = new JSONObject();
        r149.put("display_type", r310.f58332p);
        r149.put("transfer_type", r310.f58333q.getDisplayName());
        r149.put("engine_type", r310.f58334r);
        JSONObject r150 = new JSONObject();
        JSONObject r151 = new JSONObject();
        JSONObject r152 = new JSONObject();
        long r153 = r310.f58317a;
        if (r153 > 0) goto L121;
        r153 = r310.f58318b;
    L121:
        String r154 = "start";
        r152.put("start", r153);
        r152.put("end", r310.f58318b);
        Unit r155 = Unit.INSTANCE;
        r151.put("pre_handle", r152);
        JSONObject r156 = new JSONObject();
        r156.put("start", r310.f58318b);
        r156.put("end", r310.f58319c);
        r151.put("env_ready", r156);
        JSONObject r157 = new JSONObject();
        r157.put("start", r310.f58319c);
        r157.put("end", r310.f58320d);
        r151.put(MonitorConstants.IO, r157);
        JSONObject r158 = new JSONObject();
        r158.put("start", r310.f58321e);
        r158.put("end", r310.f58322f);
        r151.put("evaluate_latch_init", r158);
        JSONObject r159 = new JSONObject();
        r159.put("start", r310.f58322f);
        r159.put("end", r310.f58323g);
        r151.put("evaluate_prefetch", r159);
        JSONArray r160 = new JSONArray();
        Iterator r161 = SequencesKt.mapNotNull(CollectionsKt.asSequence(r310.f58325i), new LatchPerfMetricCollector$reportInternal$latchPerfMetric$1$6$1(r310)).iterator();
    L123:
        if (r161.hasNext() == false) goto L131;
        Pair r162 = (Pair) r161.next();
        b r163 = (b) r162.component1();
        b r164 = (b) r162.component2();
        String r165 = r163.f58337a;
        String r166 = r163.f58338b;
        JSONObject r167 = r149;
        JSONObject r168 = r139;
        String r169 = r154;
        r125.add(new c(r165, r166, r164.f58339c - r163.f58339c));
        JSONObject r170 = new JSONObject();
        r170.put(com.alipay.sdk.m.p.e.f25671s, r166);
        r170.put("callbackId", r165);
        r170.put("jsb_start", r163.f58339c);
        r170.put("jsb_end", r164.f58339c);
        Long r171 = (Long) ((LinkedHashMap) r310.f58329m).get(r165);
        Long r172 = (Long) ((LinkedHashMap) r310.f58331o).get(r165);
        Long r173 = (Long) ((LinkedHashMap) r310.f58330n).get(r165);
        if (r171 == null) goto L127;
        r170.put("transfer_start", r310.f58327k);
        r170.put("transfer_end", r171.longValue());
    L130:
        r160.put(r170);
        r149 = r167;
        r154 = r169;
        r139 = r168;
        goto L123
    L127:
        if (r172 == null) goto L130;
        if (r173 == null) goto L130;
        r170.put("transfer_start", r172.longValue());
        r170.put("transfer_end", r173.longValue());
        goto L130
    L131:
        JSONObject r174 = r149;
        JSONObject r175 = r139;
        String r176 = r154;
        Iterator r177 = ((ArrayList) r310.f58325i).iterator();
    L133:
        if (r177.hasNext() == false) goto L142;
        b r178 = (b) r177.next();
        Iterator r179 = ((ArrayList) r310.f58324h).iterator();
    L136:
        if (r179.hasNext() == false) goto L140;
        Object r180 = r179.next();
        if (Intrinsics.areEqual(((b) r180).f58337a, r178.f58337a) == false) goto L136;
    L141:
        b r181 = (b) r180;
        goto L133
    L140:
        r180 = null;
        goto L141
    L142:
        Unit r182 = Unit.INSTANCE;
        r151.put(PrefetchTiming.JSB, r160);
        JSONObject r183 = new JSONObject();
        r183.put(r176, r310.f58326j);
        r151.put("lynx", r183);
        com.bytedance.android.latch.internal.perf.e r184 = new com.bytedance.android.latch.internal.perf.e(r175, r174, r150, r151);
        if (r311 == null) goto L181;
        r311.d(r410, r184);
        return;
    L181:
        return;
    L112:
        if (((ArrayList) r310.f58325i).size() <= 0) goto L114;
        long r185 = r310.f58323g - ((b) CollectionsKt.last(r310.f58325i)).f58339c;
    L115:
        r148 = 0;
        r139.put("transfer_profit", Math.max(0, r185));
        goto L117
    L114:
        r185 = 0;
        goto L115
    L94:
        r137 = 0;
        goto L95
    L82:
        r135 = r134.next();
        if (r134.hasNext() == false) goto L91;
        long r313 = ((Number) ((Map.Entry) r135).getValue()).longValue();
    L86:
        Object r186 = r134.next();
        long r314 = ((Number) ((Map.Entry) r186).getValue()).longValue();
        if (r313 >= r314) goto L90;
        r135 = r186;
        r313 = r314;
    L90:
        if (r134.hasNext() == false) goto L91;
        r112 = r112;
        r114 = r114;
        r213 = r213;
        r312 = r312;
        goto L86
    L78:
        r133 = 0;
        goto L79
    L66:
        r131 = r130.next();
        if (r130.hasNext() == false) goto L75;
        long r187 = ((Number) ((Map.Entry) r131).getValue()).longValue();
    L70:
        Object r188 = r130.next();
        long r315 = ((Number) ((Map.Entry) r188).getValue()).longValue();
        if (r187 >= r315) goto L74;
        r131 = r188;
        r187 = r315;
    L74:
        if (r130.hasNext() == false) goto L75;
        r112 = r112;
        r114 = r114;
        r213 = r213;
        r312 = r312;
        goto L70
    L21:
        List<b> r189 = r310.f58324h;
        ArrayList r190 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r189, 10));
        Iterator r191 = ((ArrayList) r189).iterator();
    L23:
        if (r191.hasNext() == false) goto L25;
        r190.add(Long.valueOf(((b) r191.next()).f58339c));
        goto L23
    L25:
        Iterator r192 = r190.iterator();
        if (r192.hasNext() == false) goto L149;
        Object r193 = r192.next();
    L29:
        if (r192.hasNext() == false) goto L31;
        r193 = Long.valueOf(Math.min(((Number) r193).longValue(), ((Number) r192.next()).longValue()));
        r116 = r116;
        goto L29
    L31:
        r210 = r116;
        r118 = ((Number) r193).longValue() - r310.f58318b;
        goto L32
    L149:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    L17:
        r116 = 0;
        goto L18
    L13:
        r114 = 0;
        goto L14
    L9:
        r111 = 0;
        goto L10
    }

    public static final void a(LatchPerfMetricCollector r100, PerfPoints r101, long r102, String r103, String r104) {
        r100.getClass();
        switch(d.f58343a[r101.ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            case 15: goto L5;
            default: goto L35;
        };
    L5:
        Long r105 = Long.valueOf(r102);
        r100.f58331o.put(r103, r105);
        return;
    L6:
        Long r106 = Long.valueOf(r102);
        r100.f58330n.put(r103, r106);
        return;
    L7:
        List<b> r107 = r100.f58325i;
        ArrayList r108 = (ArrayList) r107;
        r108.add(new b(r103, r104, r102));
        return;
    L8:
        List<b> r109 = r100.f58324h;
        ArrayList r110 = (ArrayList) r109;
        r110.add(new b(r103, r104, r102));
        return;
    L9:
        r100.f58328l = r102;
        return;
    L10:
        Long r111 = Long.valueOf(r102);
        r100.f58329m.put(r103, r111);
        return;
    L11:
        r100.f58327k = r102;
        return;
    L12:
        r100.f58326j = System.currentTimeMillis();
        return;
    L13:
        r100.f58323g = r102;
        return;
    L14:
        r100.f58322f = r102;
        return;
    L15:
        r100.f58321e = r102;
        return;
    L16:
        r100.f58320d = r102;
        return;
    L17:
        r100.f58319c = r102;
        return;
    L18:
        r100.f58318b = r102;
        return;
    L19:
        r100.f58317a = r102;
        return;
    }

    public static void c(LatchPerfMetricCollector r100, PerfPoints r110, String r111, String r112, long r113, int r114) {
        if ((r114 & 2) == 0) goto L6;
        r111 = "";
    L6:
        if ((r114 & 4) == 0) goto L9;
        r112 = "";
    L9:
        if ((r114 & 8) == 0) goto L11;
        r113 = -1;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "callbackId");
        Intrinsics.checkNotNullParameter(r112, "methodName");
        if (r113 >= 0) goto L15;
        r113 = System.currentTimeMillis();
    L15:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L17;
        com.bytedance.android.latch.internal.util.b.f58388a.post(new com.bytedance.android.latch.internal.perf.f(r100, r110, r113, r111, r112));
        return;
    L17:
        a(r100, r110, r113, r111, r112);
    }
}
