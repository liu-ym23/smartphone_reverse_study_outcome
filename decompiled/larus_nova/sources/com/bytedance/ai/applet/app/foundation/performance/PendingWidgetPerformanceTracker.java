package com.bytedance.ai.applet.app.foundation.performance;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.sdk.account.platform.api.IVKService;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class PendingWidgetPerformanceTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f34245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f34246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f34247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ai.applet.base.log.d f34248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f34249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public State f34250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f34251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f34252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f34253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f34254l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Long f34255m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Long f34256n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f34257o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final t f34258p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/PendingWidgetPerformanceTracker$State;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "COMPLETED", "FAILED", "TIMED_OUT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State COMPLETED = null;
        public static final State FAILED = null;
        public static final State PENDING = null;
        public static final State TIMED_OUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f34259a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f34260b = null;

        public static EnumEntries<State> getEntries() {
            return f34260b;
        }

        static {
            State r100 = new State("PENDING", 0);
            PENDING = r100;
            State r101 = new State("COMPLETED", 1);
            COMPLETED = r101;
            State r102 = new State("FAILED", 2);
            FAILED = r102;
            State r103 = new State("TIMED_OUT", 3);
            TIMED_OUT = r103;
            State[] r104 = {r100, r101, r102, r103};
            f34259a = r104;
            f34260b = EnumEntriesKt.enumEntries(r104);
        }

        public static State[] values() {
            return (State[]) f34259a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements k5.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f34261a;

        public b(Map<String, ? extends Object> r100) {
            this.f34261a = r100;
        }

        @Override // k5.j
        public final void a(AppletMonitorableEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            r100.h(this.f34261a);
        }
    }

    static {
    }

    public PendingWidgetPerformanceTracker() {
        this(null, null, null, 31);
    }

    public final s a() {
        if (this.f34250h == State.PENDING) goto L5;
        return null;
    L5:
        Long r100 = this.f34252j;
        if (r100 == null) goto L12;
        long r101 = r100.longValue();
        Long r102 = b(this.f34253k, this.f34254l);
        if (r102 == null) goto L12;
        long r103 = r102.longValue();
        Long r104 = b(this.f34255m, this.f34256n);
        if (r104 == null) goto L12;
        s r105 = new s(this.f34257o, r101, r103, r104.longValue());
    L13:
        if (r105 != null) goto L16;
        c(AppletPerformanceErrorCode.INTERRUPTED, "incomplete timing at stage=" + this.f34251i);
        return null;
    L16:
        this.f34250h = State.COMPLETED;
        this.f34249g.removeCallbacks(this.f34258p);
        return r105;
    L12:
        r105 = null;
        goto L13
    }

    public final void d() {
        if (this.f34250h == State.PENDING) goto L5;
        return;
    L5:
        if (this.f34252j != null) goto L10;
        this.f34252j = Long.valueOf(System.currentTimeMillis());
        this.f34251i = "binding";
        return;
    }

    public final void e() {
        Long r100 = this.f34255m;
        if (r100 == null) goto L11;
        long r101 = r100.longValue();
        if (this.f34250h == State.PENDING) goto L7;
        return;
    L7:
        if (this.f34256n != null) goto L13;
        this.f34256n = Long.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis(), r101));
        this.f34251i = "manifestResourceLoaded";
        return;
    L13:
        return;
    }

    public final void f() {
        if (this.f34250h == State.PENDING) goto L5;
        return;
    L5:
        if (this.f34255m != null) goto L10;
        this.f34255m = Long.valueOf(System.currentTimeMillis());
        this.f34251i = "loadingManifestResource";
        return;
    }

    public final void g() {
        Long r100 = this.f34253k;
        if (r100 == null) goto L11;
        long r101 = r100.longValue();
        if (this.f34250h == State.PENDING) goto L7;
        return;
    L7:
        if (this.f34254l != null) goto L13;
        this.f34254l = Long.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis(), r101));
        this.f34251i = "widgetResourceLoaded";
        return;
    L13:
        return;
    }

    public final void h() {
        if (this.f34250h == State.PENDING) goto L5;
        return;
    L5:
        if (this.f34253k != null) goto L10;
        this.f34253k = Long.valueOf(System.currentTimeMillis());
        this.f34251i = "loadingWidgetResource";
        return;
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appName");
        if (this.f34250h == State.PENDING) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L9;
        this.f34245c = r100;
        return;
    }

    public static Long b(Long r100, Long r101) {
        if (r100 == null) goto L5;
        if (r101 == null) goto L5;
        return Long.valueOf(r101.longValue() - r100.longValue());
    L5:
        return null;
    }

    public final boolean c(AppletPerformanceErrorCode r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        if (this.f34250h == State.PENDING) goto L6;
        return false;
    L6:
        this.f34250h = State.FAILED;
        this.f34249g.removeCallbacks(this.f34258p);
        if (r101 != null) goto L9;
    L13:
        r101 = "failed at stage=" + this.f34251i;
    L14:
        com.bytedance.ai.applet.base.log.d r102 = this.f34248f;
        String r103 = "failed at stage=" + this.f34251i + ": errorCode=" + r100 + ", errorMessage=" + r101;
        AtomicInteger r104 = com.bytedance.ai.applet.base.log.d.f34519d;
        r102.a(r103, null);
        i(r100, r101);
        return true;
    L9:
        if ((!StringsKt.isBlank(r101)) == true) goto L12;
        r101 = null;
    L12:
        if (r101 != null) goto L14;
        goto L13
    }

    public final void i(AppletPerformanceErrorCode r210, String r211) {
        long r100 = System.currentTimeMillis();
        Long r101 = this.f34252j;
        if (r101 == null) goto L5;
        long r110 = r101.longValue();
    L6:
        j r102 = new j(this.f34244b, this.f34245c, 0, r110, r100 - r110, r210, r211, b(this.f34255m, this.f34256n), b(this.f34253k, this.f34254l), null, null, null, null, false, null, this.f34246d, this.f34247e, this.f34257o);
        Map<String, Object> r103 = r102.c();
        AtomicBoolean r104 = com.bytedance.ai.monitor.b.f37194a;
        com.bytedance.ai.monitor.b.d(r102.f34337s, new b(r103));
        return;
    L5:
        r110 = r100;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8, types: [com.bytedance.ai.applet.app.foundation.performance.t, java.lang.Runnable] */
    public PendingWidgetPerformanceTracker(String r100, String r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        long r101 = 15000;
    L7:
        if ((r112 & 2) == 0) goto L10;
        r100 = "";
    L10:
        if ((r112 & 4) == 0) goto L12;
        String r102 = "";
    L14:
        if ((r112 & 8) == 0) goto L17;
        r110 = "";
    L17:
        if ((r112 & 16) == 0) goto L19;
        r111 = "";
    L19:
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r102, "appName");
        Intrinsics.checkNotNullParameter(r110, "widgetId");
        Intrinsics.checkNotNullParameter(r111, "widgetInstanceId");
        this.f34243a = r101;
        this.f34244b = r100;
        this.f34245c = r102;
        this.f34246d = r110;
        this.f34247e = r111;
        if (r101 <= 0) goto L22;
        boolean r103 = true;
    L23:
        if (r103 == false) goto L27;
        this.f34248f = new com.bytedance.ai.applet.base.log.d("PendingWidgetPerformanceTracker", null);
        Handler r104 = new Handler(Looper.getMainLooper());
        this.f34249g = r104;
        this.f34250h = State.PENDING;
        this.f34251i = IVKService.ResponseConstants.CREATED;
        ?? r113 = new t(this);
        this.f34258p = r113;
        r104.postDelayed(r113, r101);
        return;
    L27:
        throw new IllegalArgumentException("timeoutMillis must be greater than 0".toString());
    L22:
        r103 = false;
        goto L23
    L12:
        r102 = null;
        goto L14
    L5:
        r101 = 0;
        goto L7
    }
}
