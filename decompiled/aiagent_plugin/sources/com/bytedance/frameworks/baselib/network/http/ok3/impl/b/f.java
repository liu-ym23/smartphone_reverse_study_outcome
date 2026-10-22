package com.bytedance.frameworks.baselib.network.http.ok3.impl.b;

import android.net.Uri;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: DispatchStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    private static final String TAG = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f8448a;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.b.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: DispatchStrategy.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8449a = null;

        static {
            int[] r0 = new int[a.values().length];
            f8449a = r0;
            r0[a.f8451b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f8449a[a.g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    /* JADX INFO: compiled from: DispatchStrategy.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8450a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8451b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f8452c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f8453d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f8454e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        private static final /* synthetic */ a[] i = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(i.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("UNKNOWN_DISPATCH_STRATEGY", 0);
            f8450a = r0;
            a r1 = new a("STATIC_DISPATCH_STRATEGY", 1);
            f8451b = r1;
            a r3 = new a("WRR_DISPATCH_STRATEGY", 2);
            f8452c = r3;
            a r5 = new a("CONSERVATIVE_DISPATCH_STRATEGY", 3);
            f8453d = r5;
            a r7 = new a("OPTIMIZED_DISPATCH_STRATEGY", 4);
            f8454e = r7;
            a r9 = new a("ROUTE_SELECTION_DISPATCH_STRATEGY", 5);
            f = r9;
            a r11 = new a("REQUEST_HEADER_DISPATCH_STRATEGY", 6);
            g = r11;
            a r13 = new a("DISPATCH_STRATEGY_SUPPORTED_LAST", 7);
            h = r13;
            i = new a[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }
    }

    static {
    }

    public abstract String a(Uri r1);

    public abstract void a(m r1);

    public abstract boolean a();

    public f(a r1) {
        this.f8448a = r1;
    }

    public a b() {
        return this.f8448a;
    }

    public static f a(a r0, JSONObject r1, String r2, long r3, int r5) {
        int r4 = AnonymousClass1.f8449a[r0.ordinal()];
        if (r4 == 1) goto L14;
        if (r4 == 2) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "dispatch strategy " + r0 + " is not supported, fallback to default strategy");
    L10:
        return new b();
    L12:
        return new h(r1);
    L14:
        return new i(r1);
    }
}
