package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: compiled from: DisasterRecovery.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f37165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f37166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f37167c;

    /* JADX INFO: renamed from: com.ss.android.common.applog.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: DisasterRecovery.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: DisasterRecovery.java */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f37168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[][] f37169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Map<String, C1016a> f37170c;

        /* JADX INFO: renamed from: com.ss.android.common.applog.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DisasterRecovery.java */
        class C1016a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f37171a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f37172b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f37173c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f37174d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            long f37175e;
            final /* synthetic */ a f;

            C1016a(a r1) {
                this.f = r1;
            }

            void a(C1016a r3) {
                this.f37171a = r3.f37171a;
                this.f37172b = r3.f37172b;
                this.f37173c = r3.f37173c;
                this.f37174d = r3.f37174d;
                this.f37175e = r3.f37175e;
            }
        }

        /* synthetic */ a(f r1, AnonymousClass1 r2) {
            this(r1);
        }

        private a(f r4) {
            this.f37168a = r4;
            this.f37169b = new long[][]{new long[]{120000, 0, 12}, new long[]{120000, 5, 1}, new long[]{240000, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
            this.f37170c = new HashMap();
        }

        public synchronized void a(String r9) {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (com.bytedance.common.utility.j.a(r9) == false) goto L6;
        L12:
            monitor-exit(this);
            return;
        L6:
            if (this.f37170c.containsKey(r9) == true) goto L12;
            C1016a r0 = new C1016a(this);     // Catch: Throwable -> L14
            SharedPreferences r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(f.a(this.f37168a), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0);     // Catch: Throwable -> L14
            if ((System.currentTimeMillis() - r1.getLong(r9 + "_downgrade_time", 0)) >= 10800000) goto L10;
            r0.f37171a = r1.getInt(r9 + "_downgrade_index", 0);     // Catch: Throwable -> L14
        L11:
            this.f37170c.put(r9, r0);     // Catch: Throwable -> L14
            goto L12
        L10:
            r1.edit().remove(r9 + "_downgrade_time").remove(r9 + "_downgrade_index").commit();     // Catch: Throwable -> L14
            goto L11
        }

        public synchronized boolean b(String r10) {
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L4:
            if (com.bytedance.common.utility.j.a(r10) == false) goto L6;
        L16:
            monitor-exit(this);
            return true;
        L6:
            if (this.f37170c.containsKey(r10) == false) goto L16;
            C1016a r11 = (C1016a) ZeusTransformUtils.preCheckCast(this.f37170c.get(r10), C1016a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
            long r2 = System.currentTimeMillis();     // Catch: Throwable -> L18
            if ((r2 - r11.f37174d) < this.f37169b[r11.f37171a][0]) goto L11;
            r11.f37172b = 1;     // Catch: Throwable -> L18
            r11.f37174d = r2;     // Catch: Throwable -> L18
            goto L16
        L11:
            if (r11.f37172b >= this.f37169b[r11.f37171a][2]) goto L14;
            r11.f37172b++;     // Catch: Throwable -> L18
            goto L16
        L14:
            monitor-exit(this);
            return false;
        }

        public synchronized void a(int r10, String[] r11, Throwable r12) {
            monitor-enter(this);
        L29:
            th = move-exception;
            throw th;
        L4:
            if (ZeusTransformUtils.instanceOf(r12, com.bytedance.common.utility.b.class) == false) goto L27;
            int r13 = ((com.bytedance.common.utility.b) ZeusTransformUtils.preCheckCast(r12, com.bytedance.common.utility.b.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L29
            if (r13 < 500) goto L27;
            if (r13 >= 600) goto L27;
            String r14 = r11[r10];     // Catch: Throwable -> L29
            if (com.bytedance.common.utility.j.a(r14) == true) goto L27;
            if (this.f37170c.containsKey(r14) == false) goto L27;
            C1016a r15 = (C1016a) ZeusTransformUtils.preCheckCast(this.f37170c.get(r14), C1016a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
            int r3 = 0;
            if (r15.f37171a >= (this.f37169b.length - 1)) goto L26;
            r15.f37171a++;     // Catch: Throwable -> L29
            r15.f37172b = 1;     // Catch: Throwable -> L29
            r15.f37173c = 0;     // Catch: Throwable -> L29
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L29
            r15.f37174d = r0;     // Catch: Throwable -> L29
            r15.f37175e = r0;     // Catch: Throwable -> L29
            SharedPreferences.Editor r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(f.a(this.f37168a), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).edit();     // Catch: Throwable -> L29
            int r4 = r11.length;     // Catch: Throwable -> L29
        L16:
            if (r3 >= r4) goto L25;
            String r5 = r11[r3];     // Catch: Throwable -> L29
            if (com.bytedance.common.utility.j.a(r5) == true) goto L24;
            if (r5.equals(r14) == true) goto L24;
            if (this.f37170c.containsKey(r5) == false) goto L24;
            C1016a r6 = (C1016a) ZeusTransformUtils.preCheckCast(this.f37170c.get(r5), C1016a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
            r6.a(r15);     // Catch: Throwable -> L29
            r2.putLong(r5 + "_downgrade_time", r0);     // Catch: Throwable -> L29
            r2.putInt(r5 + "_downgrade_index", r6.f37171a);     // Catch: Throwable -> L29
        L24:
            r3 = r3 + 1;     // Catch: Throwable -> L29
            goto L16
        L25:
            r2.putLong(r14 + "_downgrade_time", r0);     // Catch: Throwable -> L29
            r2.putInt(r14 + "_downgrade_index", r15.f37171a);     // Catch: Throwable -> L29
            r2.commit();     // Catch: Throwable -> L29
            goto L27
        L26:
            r15.f37173c = 0;     // Catch: Throwable -> L29
        L27:
            monitor-exit(this);
        }

        public synchronized void a(int r11, String[] r12) {
            monitor-enter(this);
            String r13 = r12[r11];     // Catch: Throwable -> L28
            if (com.bytedance.common.utility.j.a(r13) == false) goto L6;
        L26:
            monitor-exit(this);
            return;
        L6:
            if (this.f37170c.containsKey(r13) == false) goto L26;
            C1016a r0 = (C1016a) ZeusTransformUtils.preCheckCast(this.f37170c.get(r13), C1016a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
            long r1 = System.currentTimeMillis();     // Catch: Throwable -> L28
            if (r0.f37173c >= this.f37169b[r0.f37171a][1]) goto L14;
            if ((r1 - r0.f37175e) > 1800000) goto L14;
            r0.f37173c++;     // Catch: Throwable -> L28
        L14:
            if (r0.f37171a <= 0) goto L26;
            r0.f37171a--;     // Catch: Throwable -> L28
            r0.f37172b = 1;     // Catch: Throwable -> L28
            r0.f37173c = 1;     // Catch: Throwable -> L28
            r0.f37174d = r1;     // Catch: Throwable -> L28
            r0.f37175e = r1;     // Catch: Throwable -> L28
            int r5 = 0;
            SharedPreferences.Editor r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(f.a(this.f37168a), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).edit();     // Catch: Throwable -> L28
            int r4 = r12.length;     // Catch: Throwable -> L28
        L16:
            if (r5 >= r4) goto L25;
            String r6 = r12[r5];     // Catch: Throwable -> L28
            if (com.bytedance.common.utility.j.a(r6) == true) goto L24;
            if (r6.equals(r13) == true) goto L24;
            if (this.f37170c.containsKey(r6) == false) goto L24;
            C1016a r7 = (C1016a) ZeusTransformUtils.preCheckCast(this.f37170c.get(r6), C1016a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
            r7.a(r0);     // Catch: Throwable -> L28
            r3.putLong(r6 + "_downgrade_time", r1);     // Catch: Throwable -> L28
            r3.putInt(r6 + "_downgrade_index", r7.f37171a);     // Catch: Throwable -> L28
        L24:
            r5 = r5 + 1;     // Catch: Throwable -> L28
            goto L16
        L25:
            r3.putLong(r13 + "_downgrade_time", r1);     // Catch: Throwable -> L28
            r3.putInt(r13 + "_downgrade_index", r0.f37171a);     // Catch: Throwable -> L28
            r3.commit();     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: DisasterRecovery.java */
    public class b {
        private static final String TAG = "RatioDowngradeStrategy";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f37176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f37177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f37178c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f37179d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f37180e;

        public b(f r3) {
            this.f37176a = r3;
            this.f37177b = 0;
            this.f37178c = 6;
            this.f37179d = 0;
            this.f37180e = 0;
        }

        static /* synthetic */ int a(b r0, long r1) {
            return r0.a(r1);
        }

        static /* synthetic */ void a(b r0, JSONObject r1) {
            r0.a(r1);
        }

        private void a(JSONObject r9) {
            if (r9 != null) goto L4;
            return;
        L4:
            int r0 = r9.optInt("backoff_ratio", 0);
            this.f37177b = r0;
            if (r0 >= 0) goto L7;
        L8:
            this.f37177b = 0;
        L10:
            if (this.f37177b <= 0) goto L12;
            int r1 = 1;
        L13:
            int r10 = r9.optInt("max_request_frequency", r1);
            this.f37178c = r10;
            if (r10 < 1) goto L16;
            if (r10 > 6) goto L16;
        L17:
            int r11 = this.f37177b;
            if (r11 > 0) goto L20;
        L22:
            if (r11 != 0) goto L24;
            this.f37179d = 0;
            this.f37180e = 0;
        L24:
            com.ss.android.common.util.e.d("RatioDowngradeStrategy updateRatioDowngradeParams mBackoffRatio: " + this.f37177b + ", mMaxRequestFrequency: " + this.f37178c + ", mBackoffWindowStartTime: " + this.f37179d + ", mBackoffWindowSendCount: " + this.f37180e);
            return;
        L20:
            if (this.f37179d != 0) goto L22;
            this.f37179d = System.currentTimeMillis();
            this.f37180e = 1;
        L16:
            this.f37178c = r1;
            goto L17
        L12:
            r1 = 6;
            goto L13
        L7:
            if (r0 <= 10000) goto L10;
            goto L8
        }

        private int a(long r9) {
            if (this.f37177b > 0) goto L5;
        L14:
            int r10 = this.f37177b;
            if (r10 < 10000) goto L17;
            return -1;
        L17:
            if (r10 <= 0) goto L22;
            if (r10 < 10000) goto L20;
            return 0;
        L20:
            if (new Random().nextInt(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) >= this.f37177b) goto L25;
            return -1;
        L25:
            return 0;
        L22:
            return 0;
        L5:
            if (com.ss.android.common.applog.a.c(r9) == true) goto L7;
            r9 = 60000;
        L7:
            long r2 = System.currentTimeMillis();
            long r4 = this.f37179d;
            if (r2 >= (r4 + r9)) goto L13;
            int r11 = this.f37180e;
            if (r11 < this.f37178c) goto L12;
            return -1;
        L12:
            this.f37180e = r11 + 1;
            goto L14
        L13:
            this.f37179d = r4 + (((r2 - r4) / r9) * r9);
            this.f37180e = 1;
            goto L14
        }
    }

    static /* synthetic */ Context a(f r0) {
        return r0.f37165a;
    }

    public f(Context r3) {
        this.f37165a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f37166b = new a(this, null);
        this.f37167c = new b(this);
    }

    public void a(String r1) {
        this.f37166b.a(r1);
    }

    public boolean b(String r1) {
        return this.f37166b.b(r1);
    }

    public void a(int r1, String[] r2, Throwable r3) {
        this.f37166b.a(r1, r2, r3);
    }

    public void a(int r1, String[] r2) {
        this.f37166b.a(r1, r2);
    }

    void a(JSONObject r1) {
        b r0 = this.f37167c;
        if (r0 == null) goto L6;
        b.a(r0, r1);
        return;
    }

    int a(long r1) {
        b r0 = this.f37167c;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return b.a(r0, r1);
    }
}
