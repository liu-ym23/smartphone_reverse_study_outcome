package com.bytedance.apm6.foundation.trace;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class TraceBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f190806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f190807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f190808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f190809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f190810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f190811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TraceType f190812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f190813h;

    public static final enum TraceType extends Enum<TraceType> {
        public static final TraceType ASYNC_SLICE_BEGIN = null;
        public static final TraceType ASYNC_SLICE_END = null;
        public static final TraceType COUNTER = null;
        public static final TraceType FLOAT_COUNTER = null;
        public static final TraceType SLICE_BEGIN = null;
        public static final TraceType SLICE_END = null;
        public static final TraceType SLICE_INSTANT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TraceType[] f190814a = null;
        private final int value;

        static {
            TraceType r100 = new TraceType("SLICE_BEGIN", 0, 0);
            SLICE_BEGIN = r100;
            TraceType r101 = new TraceType("SLICE_END", 1, 1);
            SLICE_END = r101;
            TraceType r102 = new TraceType("ASYNC_SLICE_BEGIN", 2, 2);
            ASYNC_SLICE_BEGIN = r102;
            TraceType r103 = new TraceType("ASYNC_SLICE_END", 3, 3);
            ASYNC_SLICE_END = r103;
            TraceType r104 = new TraceType("SLICE_INSTANT", 4, 4);
            SLICE_INSTANT = r104;
            TraceType r105 = new TraceType("COUNTER", 5, 5);
            COUNTER = r105;
            TraceType r110 = new TraceType("FLOAT_COUNTER", 6, 6);
            FLOAT_COUNTER = r110;
            f190814a = new TraceType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static TraceType[] values() {
            return (TraceType[]) f190814a.clone();
        }

        public static /* synthetic */ int access$000(TraceType r100) {
            return r100.value;
        }

        public static TraceType valueOf(String r100) {
            return (TraceType) r27.a.a(TraceType.class, r100);
        }

        public TraceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public TraceBean() {
    }

    public final void a() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("processName", this.f190806a).putOpt("processId", Long.valueOf(this.f190807b)).putOpt("traceName", this.f190808c).putOpt("timestamp", Long.valueOf(this.f190811f)).putOpt("traceType", Integer.valueOf(TraceType.access$000(this.f190812g)));     // Catch: JSONException -> L24
        TraceType r101 = this.f190812g;     // Catch: JSONException -> L24
        if (r101 != TraceType.COUNTER) goto L7;
        r100.putOpt("counterValue", 0);     // Catch: JSONException -> L24
    L14:
        TraceType r102 = this.f190812g;     // Catch: JSONException -> L24
        if (r102 != TraceType.ASYNC_SLICE_BEGIN) goto L17;
    L18:
        r100.putOpt("asyncTag", Integer.valueOf(this.f190810e));     // Catch: JSONException -> L24
    L19:
        JSONObject r103 = this.f190813h;     // Catch: JSONException -> L24
        if (r103 == null) goto L22;
        r100.putOpt("debugAnnotation", r103);     // Catch: JSONException -> L24
    L22:
        r100.toString();
        return;
    L17:
        if (r102 != TraceType.ASYNC_SLICE_END) goto L19;
    L7:
        if (r101 != TraceType.FLOAT_COUNTER) goto L10;
        r100.putOpt("floatCounterValue", Float.valueOf(0.0f));     // Catch: JSONException -> L24
        goto L14
    L10:
        if (r101 == TraceType.SLICE_END) goto L14;
        if (r101 == TraceType.ASYNC_SLICE_END) goto L14;
        r100.putOpt("name", this.f190809d);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
