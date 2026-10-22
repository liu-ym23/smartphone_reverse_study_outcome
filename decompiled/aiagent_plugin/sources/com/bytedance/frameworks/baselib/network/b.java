package com.bytedance.frameworks.baselib.network;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTDelayStateManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f7966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f7967b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicLong f7968c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLong f7969d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicLong f7970e = null;
    private static final AtomicLong f = null;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: TTDelayStateManager.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7971a = null;

        static {
            int[] r0 = new int[a.values().length];
            f7971a = r0;
            r0[a.f7973b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f7971a[a.f7974c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f7971a[a.f7975d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: compiled from: TTDelayStateManager.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7972a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f7973b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f7974c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f7975d = null;
        private static final /* synthetic */ a[] f = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f7976e;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("NormalStart", 0, -1);
            f7972a = r0;
            a r1 = new a("ColdStart", 1, 0);
            f7973b = r1;
            a r3 = new a("HotStart", 2, 1);
            f7974c = r3;
            a r5 = new a("WarmStart", 3, 2);
            f7975d = r5;
            f = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f7976e = r3;
        }

        public int a() {
            return this.f7976e;
        }
    }

    public b() {
    }

    static {
        f7966a = a.f7972a;
        f7967b = new AtomicBoolean(false);
        f7968c = new AtomicLong(0);
        f7969d = new AtomicLong(0);
        f7970e = new AtomicLong(0);
        f = new AtomicLong(0);
    }

    public static a a() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "get coldDuration hostDuration warmDuration " + f7969d.get() + f7970e.get() + f.get());
    L5:
        int r0 = AnonymousClass1.f7971a[f7966a.ordinal()];
        if (r0 == 1) goto L24;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L14;
        return f7966a;
    L14:
        if (a(f7968c.get(), f.get()) == false) goto L17;
        f7966a = a.f7972a;
    L17:
        return f7966a;
    L19:
        if (a(f7968c.get(), f7970e.get()) == false) goto L22;
        f7966a = a.f7972a;
    L22:
        return f7966a;
    L24:
        if (a(f7968c.get(), f7969d.get()) == false) goto L27;
        f7966a = a.f7972a;
    L27:
        return f7966a;
    }

    public static a b() {
        return f7966a;
    }

    public static boolean c() {
        return f7967b.get();
    }

    private static boolean a(long r4, long r6) {
        if (((System.currentTimeMillis() / 1000) - r4) <= r6) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(JSONObject r6) {
        AtomicBoolean r0 = f7967b;
        if (r6.optInt("request_tag_enabled") <= 0) goto L5;
        boolean r1 = true;
    L6:
        r0.set(r1);
        AtomicLong r2 = f7969d;
        r2.set(r6.optInt("cold_start_seconds"));
        AtomicLong r3 = f7970e;
        r3.set(r6.optInt("hot_start_seconds"));
        AtomicLong r4 = f;
        r4.set(r6.optInt("warm_start_seconds"));
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "set coldDuration hostDuration warmDuration " + r2.get() + r3.get() + r4.get());
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
