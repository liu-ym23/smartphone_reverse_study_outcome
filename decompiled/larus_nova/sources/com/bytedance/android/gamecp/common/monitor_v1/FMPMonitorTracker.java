package com.bytedance.android.gamecp.common.monitor_v1;

import android.os.Handler;
import android.os.SystemClock;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.texturerender.TextureRenderKeys;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class FMPMonitorTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.gamecp.base.cache.c<String, b> f56549a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f56550b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f56551c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Runnable> f56552d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f56553e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f56554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final FMPMonitorTracker f56555g = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f56556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f56557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f56558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f56559d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (this.f56556a == r101.f56556a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f56557b, r101.f56557b) == true) goto L10;
            return false;
        L10:
            if (this.f56558c == r101.f56558c) goto L12;
            return false;
        L12:
            if (this.f56559d == r101.f56559d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        public final int hashCode() {
            long r100 = this.f56556a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f56557b;
            if (r102 == null) goto L5;
            int r103 = r102.hashCode();
        L6:
            long r104 = this.f56558c;
            int r105 = (((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            boolean r106 = this.f56559d;
            ?? r107 = r106;
            if (r106 == false) goto L10;
            r107 = 1;
        L10:
            return r105 + r107;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "DurationRecord(startTime=" + this.f56556a + ", durationKey=" + this.f56557b + ", duration=" + this.f56558c + ", isExtra=" + this.f56559d + ")";
        }

        public a(long r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "durationKey");
            this.f56556a = r100;
            this.f56557b = r101;
            this.f56558c = -1;
            this.f56559d = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f56560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f56561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f56562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f56563d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f56564e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, b> f56565f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, a> f56566g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, String> f56567h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<String, String> f56568i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f56569j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f56570k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f56571l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f56572m;

        public b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L32;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f56560a, r101.f56560a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f56561b, r101.f56561b) == true) goto L10;
            return false;
        L10:
            if (this.f56562c == r101.f56562c) goto L12;
            return false;
        L12:
            if (this.f56563d == r101.f56563d) goto L14;
            return false;
        L14:
            if (this.f56564e == r101.f56564e) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f56565f, r101.f56565f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f56566g, r101.f56566g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.f56567h, r101.f56567h) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.f56568i, r101.f56568i) == true) goto L24;
            return false;
        L24:
            if (this.f56569j == r101.f56569j) goto L26;
            return false;
        L26:
            if (this.f56570k == r101.f56570k) goto L28;
            return false;
        L28:
            if (this.f56571l == r101.f56571l) goto L30;
            return false;
        L30:
            if (this.f56572m == r101.f56572m) goto L49;
            return false;
        L49:
            return true;
        L32:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22, types: [int] */
        /* JADX WARN: Type inference failed for: r0v24, types: [int] */
        /* JADX WARN: Type inference failed for: r0v26, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19, types: [int] */
        /* JADX WARN: Type inference failed for: r2v20 */
        public final int hashCode() {
            String r100 = this.f56560a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f56561b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (((r103 + r105) * 31) + this.f56562c) * 31;
            long r107 = this.f56563d;
            int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
            long r109 = this.f56564e;
            int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
            Map<String, b> r111 = this.f56565f;
            if (r111 == null) goto L13;
            int r112 = r111.hashCode();
        L14:
            int r113 = (r110 + r112) * 31;
            Map<String, a> r114 = this.f56566g;
            if (r114 == null) goto L17;
            int r115 = r114.hashCode();
        L18:
            int r116 = (r113 + r115) * 31;
            Map<String, String> r117 = this.f56567h;
            if (r117 == null) goto L21;
            int r118 = r117.hashCode();
        L22:
            int r119 = (r116 + r118) * 31;
            Map<String, String> r120 = this.f56568i;
            if (r120 == null) goto L25;
            r101 = r120.hashCode();
        L25:
            int r121 = (r119 + r101) * 31;
            boolean r122 = this.f56569j;
            ?? r123 = 1;
            ?? r124 = r122;
            if (r122 == false) goto L28;
            r124 = 1;
        L28:
            int r125 = (r121 + r124) * 31;
            boolean r126 = this.f56570k;
            ?? r127 = r126;
            if (r126 == false) goto L31;
            r127 = 1;
        L31:
            int r128 = (r125 + r127) * 31;
            boolean r129 = this.f56571l;
            ?? r130 = r129;
            if (r129 == false) goto L34;
            r130 = 1;
        L34:
            int r131 = (r128 + r130) * 31;
            boolean r132 = this.f56572m;
            if (r132 == true) goto L39;
            r123 = r132;
        L39:
            return r131 + r123;
        L21:
            r118 = 0;
            goto L22
        L17:
            r115 = 0;
            goto L18
        L13:
            r112 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "TrackNode(trackId=" + this.f56560a + ", eventName=" + this.f56561b + ", result=" + this.f56562c + ", startTime=" + this.f56563d + ", startLocalTime=" + this.f56564e + ", eventNode=" + this.f56565f + ", durationFields=" + this.f56566g + ", commonParams=" + this.f56567h + ", extra=" + this.f56568i + ", isCheckFCP=" + this.f56569j + ", hasFCPResult=" + this.f56570k + ", isCheckRealFMP=" + this.f56571l + ", hasRealFMPResult=" + this.f56572m + ")";
        }

        public final void setResult(int r100) {
            this.f56562c = r100;
        }

        public b(String r100, String r101, long r110) {
            long r102 = System.currentTimeMillis();
            LinkedHashMap r103 = new LinkedHashMap();
            LinkedHashMap r104 = new LinkedHashMap();
            LinkedHashMap r105 = new LinkedHashMap();
            LinkedHashMap r106 = new LinkedHashMap();
            Intrinsics.checkNotNullParameter(r100, "trackId");
            Intrinsics.checkNotNullParameter(r101, "eventName");
            Intrinsics.checkNotNullParameter(r103, "eventNode");
            Intrinsics.checkNotNullParameter(r104, "durationFields");
            Intrinsics.checkNotNullParameter(r105, "commonParams");
            Intrinsics.checkNotNullParameter(r106, "extra");
            this.f56560a = r100;
            this.f56561b = r101;
            this.f56562c = -1;
            this.f56563d = r110;
            this.f56564e = r102;
            this.f56565f = r103;
            this.f56566g = r104;
            this.f56567h = r105;
            this.f56568i = r106;
            this.f56569j = false;
            this.f56570k = false;
            this.f56571l = false;
            this.f56572m = false;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f56573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f56574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f56575c;

        public c(String r100, String r101, long r102) {
            this.f56573a = r100;
            this.f56574b = r101;
            this.f56575c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.gamecp.base.cache.c<String, b> r100 = FMPMonitorTracker.f56549a;     // Catch: Throwable -> L10
            b r101 = FMPMonitorTracker.g(this.f56573a);     // Catch: Throwable -> L10
            if (r101 == null) goto L13;
            a r102 = r101.f56566g.get(this.f56574b);     // Catch: Throwable -> L10
            if (r102 == null) goto L17;
            r102.f56558c = (this.f56575c - r101.f56563d) - r102.f56556a;     // Catch: Throwable -> L10
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f56576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f56577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f56578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f56579d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f56580e;

        public d(String r100, String r101, long r102, String r103, boolean r104) {
            this.f56576a = r100;
            this.f56577b = r101;
            this.f56578c = r102;
            this.f56579d = r103;
            this.f56580e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.gamecp.base.cache.c<String, b> r100 = FMPMonitorTracker.f56549a;     // Catch: Throwable -> L7
            b r101 = FMPMonitorTracker.g(this.f56576a);     // Catch: Throwable -> L7
            if (r101 == null) goto L10;
            r101.f56566g.put(this.f56577b, new a(this.f56578c - r101.f56563d, this.f56579d, this.f56580e));     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f56581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f56582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f56583c;

        public e(String r100, String r101, long r102) {
            this.f56581a = r100;
            this.f56582b = r101;
            this.f56583c = r102;
        }

        public final void a() {
            com.bytedance.android.gamecp.base.cache.c<String, b> r100 = FMPMonitorTracker.f56549a;
            b r101 = FMPMonitorTracker.f(this.f56581a, this.f56582b);
            if (r101 != null) goto L5;
            return;
        L5:
            r101.f56569j = true;
            long r102 = this.f56583c - r101.f56563d;
            r101.f56567h.put("render_begin", String.valueOf(r102));
            r101.f56567h.put("fcp_v2_render_begin", String.valueOf(r102));
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

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f56584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f56585b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f56586a;

            public a(f r100) {
                this.f56586a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FMPMonitorTracker.f56549a.delete(this.f56586a.f56584a);     // Catch: Throwable -> L4
                FMPMonitorTracker.f56553e.remove(this.f56586a.f56584a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public f(String r100, String r101) {
            this.f56584a = r100;
            this.f56585b = r101;
        }

        public final void a() {
            FMPMonitorTracker r100 = FMPMonitorTracker.f56555g;
            b r101 = FMPMonitorTracker.g(this.f56584a);
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.f56562c != (-1)) goto L8;
            FMPMonitorTracker.a(r100, this.f56584a, "fail_reason", this.f56585b, false, 8);
            FMPMonitorTracker.q(this.f56584a, null, true);
        L8:
            FMPMonitorTracker.e().post(new a(this));
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

    public FMPMonitorTracker() {
    }

    public static boolean d() {
        return ((Boolean) f56550b.getValue()).booleanValue();
    }

    public static Handler e() {
        return (Handler) f56551c.getValue();
    }

    static {
        f56555g = new FMPMonitorTracker();
        f56549a = new com.bytedance.android.gamecp.base.cache.c(10);
        f56550b = LazyKt.lazy(FMPMonitorTracker$fmpTrackerEnable$2.INSTANCE);
        f56551c = LazyKt.lazy(FMPMonitorTracker$fmpTrackerHandler$2.INSTANCE);
        f56552d = new ConcurrentHashMap();
        f56553e = new ConcurrentHashMap();
        f56554f = "empty_track_id";
    }

    public static b g(String r100) {
        return f56549a.a(r100);
    }

    public static void c(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        if (d() == true) goto L5;
        return;
    L5:
        LocalTestManager.a(new Class[]{uv.a.class});
        if (r101 == false) goto L8;
        f56549a.delete(r100);
        f56553e.remove(r100);
    L8:
        e().post(new com.bytedance.android.gamecp.common.monitor_v1.e(r100));
    }

    public static b f(String r100, String r101) {
        if (d() == true) goto L5;
        return null;
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        return null;
    L13:
        b r103 = g(r100);
        if (r103 != null) goto L17;
        return null;
    L17:
        if (r103.f56565f.containsKey(r101) == true) goto L20;
        r103.f56565f.put(r101, new b(r100, r101, r103.f56563d));
    L20:
        return r103.f56565f.get(r101);
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    public static /* synthetic */ void i(String r100, String r101) {
        h(r100, r101, SystemClock.elapsedRealtime());
    }

    public final void p(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r110, "reason");
        LocalTestManager.a(new Class[]{uv.a.class});
        if (d() == true) goto L5;
        return;
    L5:
        Runnable r101 = f56552d.remove(r100);
        if (r101 == null) goto L9;
        e().removeCallbacks(r101);
    L9:
        if (Intrinsics.areEqual(r110, "exit_early") == false) goto L12;
        a(this, r100, "exit_time", String.valueOf(SystemClock.elapsedRealtime()), true, 16);
        long r102 = 2500;
    L16:
        e().postDelayed(new f(r100, r110), r102);
        return;
    L12:
        if (com.bytedance.android.gamecp.host_api.a.b().getHostAppService().isAppBackground() == false) goto L14;
        String r103 = "1";
    L15:
        a(this, r100, "is_host_background", r103, true, 16);
        r102 = 0;
        goto L16
    L14:
        r103 = "0";
        goto L15
    }

    public static void h(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (d() == true) goto L5;
        return;
    L5:
        e().post(new c(r100, r101, r102));
    }

    public static void l(String r100, String r101, String r110) {
        long r102 = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r110, "action");
        if (d() == false) goto L7;
        e().post(new com.bytedance.android.gamecp.common.monitor_v1.f(r100, r101, r110, r102));
        return;
    }

    public static void n(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        if (d() == true) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, String> r103 = f56553e;
        String r104 = r103.get(r100);
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L17;
        if (r101 != null) goto L15;
        String r106 = "";
    L16:
        r103.put(r100, r106);
        goto L17
    L15:
        r106 = r101;
    L17:
        e().post(new e(r100, r101, r102));
        return;
    L8:
        if (r104.length() == 0) goto L11;
        r105 = false;
        goto L12
    }

    public static void q(String r100, String r110, boolean r111) {
        if (d() == true) goto L5;
        return;
    L5:
        Runnable r101 = f56552d.remove(r100);
        if (r101 == null) goto L8;
        e().removeCallbacks(r101);
    L8:
        b r102 = g(r100);
        if (r102 != null) goto L11;
        return;
    L11:
        boolean r103 = true;
        if (r102.f56562c != 1) goto L15;
        return;
    L15:
        if (r111 == false) goto L24;
        if (r110 != null) goto L18;
    L21:
        boolean r104 = true;
    L22:
        if (r104 == false) goto L24;
        String r105 = f56553e.get(r100);
        LocalTestManager.a(new Class[]{uv.a.class});
        b r106 = f(r100, r105);
    L25:
        LinkedHashMap r107 = new LinkedHashMap();
        JsonObject r108 = new JsonObject();
        FMPMonitorTracker$buildParams$addNodeParams$1 r109 = FMPMonitorTracker$buildParams$addNodeParams$1.INSTANCE;
        r109.invoke(r102, r107, r108);
        r109.invoke(r106, r107, r108);
        r108.addProperty("local_time", String.valueOf(r102.f56564e));
        String r112 = r102.f56568i.get("exit_time");
        if (r112 == null) goto L30;
        Long r113 = StringsKt.toLongOrNull(r112);
        if (r113 == null) goto L30;
        long r114 = r113.longValue();
    L32:
        if (r114 <= 0) goto L34;
        r108.addProperty("exit_duration", String.valueOf(r114 - r102.f56563d));
    L34:
        r107.put("extra", r108.toString());
        if (r110 != null) goto L37;
    L40:
        if (r103 == true) goto L42;
        r107.put("module_name", r110);
    L42:
        r102.setResult(r111 ? 1 : 0);
        r107.put("result", String.valueOf(r102.f56562c));
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3(r102.f56561b, r107);
        return;
    L37:
        if (r110.length() == 0) goto L40;
        r103 = false;
    L30:
        r114 = 0;
        goto L32
    L18:
        if (r110.length() == 0) goto L21;
        r104 = false;
    L24:
        r106 = f(r100, r110);
        goto L25
    }

    public static void m(String r110, String r111, String r112, String r113) {
        long r100 = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullParameter(r110, "trackId");
        Intrinsics.checkNotNullParameter(r111, TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r112, "action");
        Intrinsics.checkNotNullParameter(r113, "durationKey");
        if (d() == false) goto L16;
        ConcurrentHashMap<String, String> r101 = f56553e;
        String r102 = r101.get(r110);
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        r101.put(r110, r111);
    L14:
        e().post(new g(r110, r111, r112, r100, r113, false));
        return;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6, types: [T, java.lang.String] */
    public static String o(String r100, String r101, long r102, int r103) {
        ?? r104 = r101;
        if ((r103 & 2) == 0) goto L6;
        r104 = "empty_track_id";
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = SystemClock.elapsedRealtime();
    L8:
        Intrinsics.checkNotNullParameter(r100, "trackEvent");
        Intrinsics.checkNotNullParameter(r104, "trackId");
        if (d() == false) goto L21;
        boolean r105 = true;
        LocalTestManager.a(new Class[]{uv.a.class});
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        r106.element = r104;
        if (r104.length() == 0) goto L15;
        r105 = false;
    L15:
        if (r105 == false) goto L17;
    L18:
        r106.element = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getDeviceId() + '#' + System.currentTimeMillis();
    L19:
        e().post(new j(r106, r100, r102));
        return (String) r106.element;
    L17:
        if (Intrinsics.areEqual(r104, "empty_track_id") == false) goto L19;
    L21:
        return r104;
    }

    public static void j(String r100, String r110, String r111, boolean r112, long r113) {
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r110, "action");
        Intrinsics.checkNotNullParameter(r111, "durationKey");
        if (d() == true) goto L5;
        return;
    L5:
        e().post(new d(r100, r110, r113, r111, r112));
    }

    public static /* synthetic */ void k(String r100, String r101, String r102, boolean r103, int r110) {
        if ((r110 & 8) == 0) goto L5;
        boolean r104 = false;
    L7:
        if ((r110 & 16) == 0) goto L9;
        long r105 = SystemClock.elapsedRealtime();
    L10:
        j(r100, r101, r102, r104, r105);
        return;
    L9:
        r105 = 0;
        goto L10
    L5:
        r104 = r103;
        goto L7
    }

    public static void a(FMPMonitorTracker r100, String r101, String r102, String r103, boolean r104, int r105) {
        boolean r106 = false;
        if ((r105 & 8) == 0) goto L6;
        r104 = false;
    L6:
        if ((r105 & 16) == 0) goto L8;
        r106 = true;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "trackId");
        Intrinsics.checkNotNullParameter(r102, "field");
        if (d() == false) goto L22;
        if (r106 == false) goto L13;
        e().post(new com.bytedance.android.gamecp.common.monitor_v1.c(r101, r104, r103, r102));
        return;
    L13:
        b r107 = g(r101);
        if (r107 == null) goto L23;
        if (r104 == false) goto L18;
        r107.f56568i.put(r102, r103);
        return;
    L18:
        r107.f56567h.put(r102, r103);
        return;
    L23:
        return;
    }

    public static void b(String r100, String r101, String r110, String r111, boolean r112, int r113) {
        boolean r102 = false;
        if ((r113 & 16) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r113 & 32) == 0) goto L9;
        r102 = true;
    L9:
        Intrinsics.checkNotNullParameter(r100, "trackId");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r110, "field");
        if (d() == false) goto L23;
        if (r102 == false) goto L14;
        e().post(new com.bytedance.android.gamecp.common.monitor_v1.d(r100, r101, r103, r111, r110));
        return;
    L14:
        b r104 = f(r100, r101);
        if (r104 == null) goto L24;
        if (r103 == false) goto L19;
        r104.f56568i.put(r110, r111);
        return;
    L19:
        r104.f56567h.put(r110, r111);
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r103 = r112;
        goto L7
    }
}
