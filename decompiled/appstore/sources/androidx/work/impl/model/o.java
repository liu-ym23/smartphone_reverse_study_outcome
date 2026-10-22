package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.BackoffPolicy;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.UiType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.u;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f5667u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f5668v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Function f5669w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WorkInfo.State f5671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.work.c f5674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.work.c f5675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f5678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public androidx.work.a f5679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BackoffPolicy f5681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f5682m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f5683n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f5684o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f5685p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5686q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OutOfQuotaPolicy f5687r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5688s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f5689t;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WorkInfo.State f5691b;

        public b(String r10, WorkInfo.State r11) {
            kotlin.jvm.internal.q.g(r10, "id");
            kotlin.jvm.internal.q.g(r11, WsConstants.KEY_CONNECTION_STATE);
            this.f5690a = r10;
            this.f5691b = r11;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (kotlin.jvm.internal.q.b(this.f5690a, r11.f5690a) == true) goto L12;
            return false;
        L12:
            if (this.f5691b == r11.f5691b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f5690a.hashCode() * 31) + this.f5691b.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.f5690a + ", state=" + this.f5691b + ')';
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WorkInfo.State f5693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.work.c f5694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f5696e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f5697f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f5698g;

        public c(String r10, WorkInfo.State r11, androidx.work.c r12, int r13, int r14, List r15, List r16) {
            kotlin.jvm.internal.q.g(r10, "id");
            kotlin.jvm.internal.q.g(r11, WsConstants.KEY_CONNECTION_STATE);
            kotlin.jvm.internal.q.g(r12, "output");
            kotlin.jvm.internal.q.g(r15, TracingConstants.KEY_TAGS);
            kotlin.jvm.internal.q.g(r16, "progress");
            this.f5692a = r10;
            this.f5693b = r11;
            this.f5694c = r12;
            this.f5695d = r13;
            this.f5696e = r14;
            this.f5697f = r15;
            this.f5698g = r16;
        }

        public final WorkInfo a() {
            if (this.f5698g.isEmpty() == true) goto L6;
            androidx.work.c r10 = (androidx.work.c) this.f5698g.get(0);
        L5:
            androidx.work.c r11 = r10;
            return new WorkInfo(UUID.fromString(this.f5692a), this.f5693b, this.f5694c, this.f5697f, r11, this.f5695d, this.f5696e);
        L6:
            r10 = androidx.work.c.f5406c;
            goto L5
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (kotlin.jvm.internal.q.b(this.f5692a, r11.f5692a) == true) goto L12;
            return false;
        L12:
            if (this.f5693b == r11.f5693b) goto L15;
            return false;
        L15:
            if (kotlin.jvm.internal.q.b(this.f5694c, r11.f5694c) == true) goto L18;
            return false;
        L18:
            if (this.f5695d == r11.f5695d) goto L21;
            return false;
        L21:
            if (this.f5696e == r11.f5696e) goto L24;
            return false;
        L24:
            if (kotlin.jvm.internal.q.b(this.f5697f, r11.f5697f) == true) goto L27;
            return false;
        L27:
            if (kotlin.jvm.internal.q.b(this.f5698g, r11.f5698g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            return (((((((((((this.f5692a.hashCode() * 31) + this.f5693b.hashCode()) * 31) + this.f5694c.hashCode()) * 31) + Integer.hashCode(this.f5695d)) * 31) + Integer.hashCode(this.f5696e)) * 31) + this.f5697f.hashCode()) * 31) + this.f5698g.hashCode();
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.f5692a + ", state=" + this.f5693b + ", output=" + this.f5694c + ", runAttemptCount=" + this.f5695d + ", generation=" + this.f5696e + ", tags=" + this.f5697f + ", progress=" + this.f5698g + ')';
        }
    }

    static {
        f5667u = new a(null);
        String r10 = androidx.work.i.i("WorkSpec");
        kotlin.jvm.internal.q.f(r10, "tagWithPrefix(\"WorkSpec\")");
        f5668v = r10;
        f5669w = new n();
    }

    public o(String r11, WorkInfo.State r12, String r13, String r14, androidx.work.c r15, androidx.work.c r16, long r17, long r19, long r21, androidx.work.a r23, int r24, BackoffPolicy r25, long r26, long r28, long r30, long r32, boolean r34, OutOfQuotaPolicy r35, int r36, int r37) {
        kotlin.jvm.internal.q.g(r11, "id");
        kotlin.jvm.internal.q.g(r12, WsConstants.KEY_CONNECTION_STATE);
        kotlin.jvm.internal.q.g(r13, "workerClassName");
        kotlin.jvm.internal.q.g(r15, "input");
        kotlin.jvm.internal.q.g(r16, "output");
        kotlin.jvm.internal.q.g(r23, "constraints");
        kotlin.jvm.internal.q.g(r25, "backoffPolicy");
        kotlin.jvm.internal.q.g(r35, "outOfQuotaPolicy");
        this.f5670a = r11;
        this.f5671b = r12;
        this.f5672c = r13;
        this.f5673d = r14;
        this.f5674e = r15;
        this.f5675f = r16;
        this.f5676g = r17;
        this.f5677h = r19;
        this.f5678i = r21;
        this.f5679j = r23;
        this.f5680k = r24;
        this.f5681l = r25;
        this.f5682m = r26;
        this.f5683n = r28;
        this.f5684o = r30;
        this.f5685p = r32;
        this.f5686q = r34;
        this.f5687r = r35;
        this.f5688s = r36;
        this.f5689t = r37;
    }

    public static /* synthetic */ List a(List r10) {
        return b(r10);
    }

    public static final List b(List r10) {
        if (r10 == null) goto L7;
        ArrayList r11 = new ArrayList(u.r(r10, 10));
        Iterator r12 = r10.iterator();
    L5:
        if (r12.hasNext() == false) goto L10;
        r11.add(((c) r12.next()).a());
        goto L5
    L10:
        return r11;
    L7:
        return null;
    }

    public final long c() {
        if (g() == true) goto L5;
        long r10 = 0;
        if (h() == false) goto L23;
        int r11 = this.f5688s;
        long r12 = this.f5683n;
        if (r11 != 0) goto L14;
        r12 = r12 + this.f5676g;
    L14:
        long r13 = this.f5678i;
        long r14 = this.f5677h;
        if (r13 == r14) goto L20;
        if (r11 != 0) goto L18;
        r10 = ((long) (-1)) * r13;
    L18:
        r12 = r12 + r14;
    L29:
        return r12 + r10;
    L20:
        if (r11 == 0) goto L29;
        r10 = r14;
        goto L29
    L23:
        long r15 = this.f5683n;
        if (r15 != 0) goto L27;
        r15 = System.currentTimeMillis();
    L27:
        return r15 + this.f5676g;
    L5:
        if (this.f5681l != BackoffPolicy.LINEAR) goto L7;
        long r16 = this.f5682m * ((long) this.f5680k);
    L28:
        return this.f5683n + bg.h.h(r16, 18000000);
    L7:
        r16 = (long) Math.scalb(this.f5682m, this.f5680k - 1);
        goto L28
    }

    public final int d() {
        return this.f5689t;
    }

    public final int e() {
        return this.f5688s;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof o) == true) goto L8;
        return false;
    L8:
        o r11 = (o) r10;
        if (kotlin.jvm.internal.q.b(this.f5670a, r11.f5670a) == true) goto L12;
        return false;
    L12:
        if (this.f5671b == r11.f5671b) goto L15;
        return false;
    L15:
        if (kotlin.jvm.internal.q.b(this.f5672c, r11.f5672c) == true) goto L18;
        return false;
    L18:
        if (kotlin.jvm.internal.q.b(this.f5673d, r11.f5673d) == true) goto L21;
        return false;
    L21:
        if (kotlin.jvm.internal.q.b(this.f5674e, r11.f5674e) == true) goto L24;
        return false;
    L24:
        if (kotlin.jvm.internal.q.b(this.f5675f, r11.f5675f) == true) goto L27;
        return false;
    L27:
        if (this.f5676g == r11.f5676g) goto L30;
        return false;
    L30:
        if (this.f5677h == r11.f5677h) goto L33;
        return false;
    L33:
        if (this.f5678i == r11.f5678i) goto L36;
        return false;
    L36:
        if (kotlin.jvm.internal.q.b(this.f5679j, r11.f5679j) == true) goto L39;
        return false;
    L39:
        if (this.f5680k == r11.f5680k) goto L42;
        return false;
    L42:
        if (this.f5681l == r11.f5681l) goto L45;
        return false;
    L45:
        if (this.f5682m == r11.f5682m) goto L48;
        return false;
    L48:
        if (this.f5683n == r11.f5683n) goto L51;
        return false;
    L51:
        if (this.f5684o == r11.f5684o) goto L54;
        return false;
    L54:
        if (this.f5685p == r11.f5685p) goto L57;
        return false;
    L57:
        if (this.f5686q == r11.f5686q) goto L60;
        return false;
    L60:
        if (this.f5687r == r11.f5687r) goto L63;
        return false;
    L63:
        if (this.f5688s == r11.f5688s) goto L66;
        return false;
    L66:
        if (this.f5689t == r11.f5689t) goto L68;
        return false;
    L68:
        return true;
    }

    public final boolean f() {
        return !kotlin.jvm.internal.q.b(androidx.work.a.f5393j, this.f5679j);
    }

    public final boolean g() {
        if (this.f5671b == WorkInfo.State.ENQUEUED) goto L5;
    L7:
        return false;
    L5:
        if (this.f5680k <= 0) goto L7;
        return true;
    }

    public final boolean h() {
        if (this.f5677h == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32, types: [int] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v39 */
    public int hashCode() {
        int r10 = ((((this.f5670a.hashCode() * 31) + this.f5671b.hashCode()) * 31) + this.f5672c.hashCode()) * 31;
        String r11 = this.f5673d;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (((((((((((((((((((((((((r10 + r12) * 31) + this.f5674e.hashCode()) * 31) + this.f5675f.hashCode()) * 31) + Long.hashCode(this.f5676g)) * 31) + Long.hashCode(this.f5677h)) * 31) + Long.hashCode(this.f5678i)) * 31) + this.f5679j.hashCode()) * 31) + Integer.hashCode(this.f5680k)) * 31) + this.f5681l.hashCode()) * 31) + Long.hashCode(this.f5682m)) * 31) + Long.hashCode(this.f5683n)) * 31) + Long.hashCode(this.f5684o)) * 31) + Long.hashCode(this.f5685p)) * 31;
        boolean r14 = this.f5686q;
        ?? r15 = r14;
        if (r14 == false) goto L10;
        r15 = 1;
    L10:
        return ((((((r13 + r15) * 31) + this.f5687r.hashCode()) * 31) + Integer.hashCode(this.f5688s)) * 31) + Integer.hashCode(this.f5689t);
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public String toString() {
        return "{WorkSpec: " + this.f5670a + '}';
    }

    public /* synthetic */ o(String r31, WorkInfo.State r32, String r33, String r34, androidx.work.c r35, androidx.work.c r36, long r37, long r39, long r41, androidx.work.a r43, int r44, BackoffPolicy r45, long r46, long r48, long r50, long r52, boolean r54, OutOfQuotaPolicy r55, int r56, int r57, int r58, DefaultConstructorMarker r59) {
        if ((r58 & 2) == 0) goto L5;
        WorkInfo.State r10 = WorkInfo.State.ENQUEUED;
    L7:
        if ((r58 & 8) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r58 & 16) == 0) goto L13;
        androidx.work.c r12 = androidx.work.c.f5406c;
        kotlin.jvm.internal.q.f(r12, "EMPTY");
        androidx.work.c r13 = r12;
    L15:
        if ((r58 & 32) == 0) goto L17;
        androidx.work.c r14 = androidx.work.c.f5406c;
        kotlin.jvm.internal.q.f(r14, "EMPTY");
        androidx.work.c r15 = r14;
    L19:
        if ((r58 & 64) == 0) goto L21;
        long r16 = 0;
    L23:
        if ((r58 & 128) == 0) goto L25;
        long r17 = 0;
    L27:
        if ((r58 & 256) == 0) goto L29;
        long r18 = 0;
    L31:
        if ((r58 & 512) == 0) goto L33;
        androidx.work.a r19 = androidx.work.a.f5393j;
    L35:
        if ((r58 & 1024) == 0) goto L37;
        int r110 = 0;
    L39:
        if ((r58 & 2048) == 0) goto L41;
        BackoffPolicy r111 = BackoffPolicy.EXPONENTIAL;
    L43:
        if ((r58 & 4096) == 0) goto L45;
        long r112 = PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS;
    L47:
        if ((r58 & 8192) == 0) goto L49;
        long r20 = 0;
    L51:
        if ((r58 & 16384) == 0) goto L53;
        long r22 = 0;
    L55:
        if ((32768 & r58) == 0) goto L57;
        long r24 = -1;
    L59:
        if ((65536 & r58) == 0) goto L61;
        boolean r26 = false;
    L63:
        if ((131072 & r58) == 0) goto L65;
        OutOfQuotaPolicy r27 = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
    L67:
        if ((262144 & r58) == 0) goto L69;
        int r28 = 0;
    L71:
        if ((r58 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L73;
        int r29 = 0;
    L74:
        this(r31, r10, r33, r11, r13, r15, r16, r17, r18, r19, r110, r111, r112, r20, r22, r24, r26, r27, r28, r29);
        return;
    L73:
        r29 = r57;
        goto L74
    L69:
        r28 = r56;
        goto L71
    L65:
        r27 = r55;
        goto L67
    L61:
        r26 = r54;
        goto L63
    L57:
        r24 = r52;
        goto L59
    L53:
        r22 = r50;
        goto L55
    L49:
        r20 = r48;
        goto L51
    L45:
        r112 = r46;
        goto L47
    L41:
        r111 = r45;
        goto L43
    L37:
        r110 = r44;
        goto L39
    L33:
        r19 = r43;
        goto L35
    L29:
        r18 = r41;
        goto L31
    L25:
        r17 = r39;
        goto L27
    L21:
        r16 = r37;
        goto L23
    L17:
        r15 = r36;
        goto L19
    L13:
        r13 = r35;
        goto L15
    L9:
        r11 = r34;
        goto L11
    L5:
        r10 = r32;
        goto L7
    }

    public o(String r31, String r32) {
        kotlin.jvm.internal.q.g(r31, "id");
        kotlin.jvm.internal.q.g(r32, "workerClassName_");
        WorkInfo.State r10 = null;
        String r11 = null;
        androidx.work.c r12 = null;
        androidx.work.c r13 = null;
        long r14 = 0;
        long r15 = 0;
        long r16 = 0;
        androidx.work.a r17 = null;
        int r18 = 0;
        BackoffPolicy r19 = null;
        long r110 = 0;
        long r111 = 0;
        long r20 = 0;
        long r22 = 0;
        boolean r24 = false;
        OutOfQuotaPolicy r25 = null;
        int r26 = 0;
        int r27 = 0;
        this(r31, r10, r32, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r22, r24, r25, r26, r27, 1048570, null);
    }

    public o(String r33, o r34) {
        kotlin.jvm.internal.q.g(r33, "newId");
        kotlin.jvm.internal.q.g(r34, AppInfo.SEARCH_SOURCE_EXTENAL);
        String r10 = r34.f5672c;
        int r28 = 0;
        this(r33, r34.f5671b, r10, r34.f5673d, new androidx.work.c(r34.f5674e), new androidx.work.c(r34.f5675f), r34.f5676g, r34.f5677h, r34.f5678i, new androidx.work.a(r34.f5679j), r34.f5680k, r34.f5681l, r34.f5682m, r34.f5683n, r34.f5684o, r34.f5685p, r34.f5686q, r34.f5687r, r34.f5688s, r28, UiType.FLAG_WIFI_QRCODE_CARD, null);
    }
}
