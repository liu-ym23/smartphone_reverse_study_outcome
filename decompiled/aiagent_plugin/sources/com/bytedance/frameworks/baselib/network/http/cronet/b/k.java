package com.bytedance.frameworks.baselib.network.http.cronet.b;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TTDispatchResult.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    static final /* synthetic */ boolean h = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f8244e;
    public final Exception f;
    public final String g;

    /* JADX INFO: compiled from: TTDispatchResult.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8245a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8246b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f8247c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f8248d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f8249e = null;
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
            a r0 = new a("SUCCESS", 0);
            f8245a = r0;
            a r1 = new a("INVALID_ORIGIN_URL", 1);
            f8246b = r1;
            a r3 = new a("CRONET_NOT_INIT", 2);
            f8247c = r3;
            a r5 = new a("TIMEOUT", 3);
            f8248d = r5;
            a r7 = new a("INVALID_FINAL_URL", 4);
            f8249e = r7;
            a r9 = new a("WRONG_FORMAT", 5);
            f = r9;
            a r11 = new a("OKHTTP_DISPATCH_FAILED", 6);
            g = r11;
            a r13 = new a("NOT_REACHED", 7);
            h = r13;
            i = new a[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }
    }

    static {
    }

    public k(String r2, a r3, Exception r4) {
        if (h == false) goto L5;
    L9:
        this.f8240a = r2;
        this.f8241b = r2;
        this.f8242c = "0";
        this.f8243d = "0";
        this.f8244e = r3;
        this.f = r4;
        this.g = "";
        return;
    L5:
        if (r3 != a.f8245a) goto L9;
        throw new AssertionError();
    }

    public k(String r1, String r2, String r3, String r4, a r5, String r6) {
        this.f8240a = r1;
        this.f8241b = r2;
        if (TextUtils.isEmpty(r3) == true) goto L5;
        this.f8242c = r3;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L9;
        this.f8243d = r4;
    L11:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        this.g = r6;
    L14:
        this.f8244e = r5;
        this.f = null;
        return;
    L13:
        this.g = "";
        goto L14
    L9:
        this.f8243d = "0";
        goto L11
    L5:
        this.f8242c = "0";
        goto L7
    }

    public String a() {
        return this.f8241b;
    }
}
