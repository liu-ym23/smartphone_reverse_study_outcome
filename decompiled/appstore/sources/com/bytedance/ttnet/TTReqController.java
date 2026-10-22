package com.bytedance.ttnet;

import android.os.HandlerThread;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.retrofit2.SsHttpCall;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class TTReqController implements SsHttpCall.IHttpCallReqLevelControl, WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8126a = "TTReqController";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f8127b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f8128c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f8129d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f8130e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadWriteLock f8131f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lock f8132g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lock f8133h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Condition f8134i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static HandlerThread f8135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f8136k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set f8137l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set f8138m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f8139n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static long f8140o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f8141p;

    public static final enum P0DoneReasonEnum extends Enum<P0DoneReasonEnum> {
        private static final /* synthetic */ P0DoneReasonEnum[] $VALUES = null;
        public static final P0DoneReasonEnum MODULE_DISABLE = null;
        public static final P0DoneReasonEnum P0_COUNT_DONE = null;
        public static final P0DoneReasonEnum P0_NOT_DONE = null;
        public static final P0DoneReasonEnum P0_TIME_OUT = null;
        public static final P0DoneReasonEnum P1_MAX_SIZE = null;

        static {
            P0DoneReasonEnum r10 = new P0DoneReasonEnum("P0_NOT_DONE", 0);
            P0_NOT_DONE = r10;
            P0DoneReasonEnum r11 = new P0DoneReasonEnum("MODULE_DISABLE", 1);
            MODULE_DISABLE = r11;
            P0DoneReasonEnum r12 = new P0DoneReasonEnum("P0_COUNT_DONE", 2);
            P0_COUNT_DONE = r12;
            P0DoneReasonEnum r13 = new P0DoneReasonEnum("P1_MAX_SIZE", 3);
            P1_MAX_SIZE = r13;
            P0DoneReasonEnum r14 = new P0DoneReasonEnum("P0_TIME_OUT", 4);
            P0_TIME_OUT = r14;
            $VALUES = new P0DoneReasonEnum[]{r10, r11, r12, r13, r14};
        }

        private P0DoneReasonEnum(String r10, int r11) {
            super(r10, r11);
        }

        public static P0DoneReasonEnum valueOf(String r10) {
            return (P0DoneReasonEnum) Enum.valueOf(P0DoneReasonEnum.class, r10);
        }

        public static P0DoneReasonEnum[] values() {
            return (P0DoneReasonEnum[]) $VALUES.clone();
        }
    }

    public static final enum ReleaseReasonEnum extends Enum<ReleaseReasonEnum> {
        private static final /* synthetic */ ReleaseReasonEnum[] $VALUES = null;
        public static final ReleaseReasonEnum RELEASE_COUNTDOWN = null;
        public static final ReleaseReasonEnum RELEASE_P0BACK = null;
        public static final ReleaseReasonEnum RELEASE_SWITCH = null;

        static {
            ReleaseReasonEnum r10 = new ReleaseReasonEnum("RELEASE_COUNTDOWN", 0);
            RELEASE_COUNTDOWN = r10;
            ReleaseReasonEnum r11 = new ReleaseReasonEnum("RELEASE_SWITCH", 1);
            RELEASE_SWITCH = r11;
            ReleaseReasonEnum r12 = new ReleaseReasonEnum("RELEASE_P0BACK", 2);
            RELEASE_P0BACK = r12;
            $VALUES = new ReleaseReasonEnum[]{r10, r11, r12};
        }

        private ReleaseReasonEnum(String r10, int r11) {
            super(r10, r11);
        }

        public static ReleaseReasonEnum valueOf(String r10) {
            return (ReleaseReasonEnum) Enum.valueOf(ReleaseReasonEnum.class, r10);
        }

        public static ReleaseReasonEnum[] values() {
            return (ReleaseReasonEnum[]) $VALUES.clone();
        }
    }

    static {
        f8127b = new AtomicLong(0);
        f8128c = new AtomicInteger(0);
        f8129d = new AtomicInteger(0);
        f8130e = new ConcurrentHashMap();
        ReentrantReadWriteLock r10 = new ReentrantReadWriteLock();
        f8131f = r10;
        f8132g = r10.writeLock();
        ReentrantLock r11 = new ReentrantLock();
        f8133h = r11;
        f8134i = r11.newCondition();
        f8135j = new HandlerThread("RequestController-Handler");
        f8136k = false;
        f8137l = new CopyOnWriteArraySet();
        f8138m = new CopyOnWriteArraySet();
        f8139n = 0;
        f8140o = 0;
        f8141p = 10;
        f8135j.start();
    }

    public static void a(JSONObject r10) {
        f8136k = false;
        JSONObject r11 = r10.optJSONObject("runtime_req_ctl_config");
        if (r11 != null) goto L5;
        return;
    L5:
        f8136k = true;
        f8137l.clear();
        f8138m.clear();
        JSONArray r12 = r11.optJSONArray("p0");     // Catch: JSONException -> L12
        JSONArray r13 = r11.optJSONArray("p2");     // Catch: JSONException -> L12
        if (r12 == null) goto L14;
        int r14 = 0;
    L10:
        if (r14 >= r12.length()) goto L14;
        f8137l.add(r12.get(r14).toString());     // Catch: JSONException -> L12
        r14 = r14 + 1;     // Catch: JSONException -> L12
    L14:
        if (r13 == null) goto L21;
        int r15 = 0;
    L16:
        if (r15 >= r13.length()) goto L21;
        f8138m.add(r13.get(r15).toString());     // Catch: JSONException -> L12
        r15 = r15 + 1;
    L21:
        f8140o = r11.optInt("p0_countdown", 0);
        f8139n = r11.optInt("p1_random", 0);
        f8141p = r11.optInt("p1_maxCount", 10);
        if (Logger.debug() == false) goto L29;
        String r16 = f8126a;
        Logger.e(r16, "sP0PathSet is " + f8137l);
        Logger.e(r16, "sP2PathSet is " + f8138m);
        Logger.e(r16, "sP0Countdown is " + f8140o);
        Logger.e(r16, "sP1Random is " + f8139n);
        Logger.e(r16, "sP1MaxCount is " + f8141p);
        return;
    L29:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }
}
