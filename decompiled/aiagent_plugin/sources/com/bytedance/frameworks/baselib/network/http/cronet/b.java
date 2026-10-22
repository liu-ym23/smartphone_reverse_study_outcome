package com.bytedance.frameworks.baselib.network.http.cronet;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TTAppStateManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f8197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f8198b;

    /* JADX INFO: compiled from: TTAppStateManager.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8199a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8200b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f8201c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f8202d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f8203e = null;
        public static final a f = null;
        private static final /* synthetic */ a[] h = null;
        final int g;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(h.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("NormalStart", 0, -1);
            f8199a = r0;
            a r1 = new a("ColdStart", 1, 0);
            f8200b = r1;
            a r3 = new a("HotStart", 2, 1);
            f8201c = r3;
            a r5 = new a("WarmStart", 3, 2);
            f8202d = r5;
            a r7 = new a("WeakNet", 4, 3);
            f8203e = r7;
            a r9 = new a("Default", 5, 4);
            f = r9;
            h = new a[]{r0, r1, r3, r5, r7, r9};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.g = r3;
        }
    }

    public b() {
    }

    static {
        f8197a = a.f8199a;
        f8198b = a.f;
    }

    public static int a() {
        return f8197a.g;
    }
}
