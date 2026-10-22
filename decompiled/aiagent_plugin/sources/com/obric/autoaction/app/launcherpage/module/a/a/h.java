package com.obric.autoaction.app.launcherpage.module.a.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AutoActionTaskListItemTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends f implements d, j, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f24014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f24016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.module.datasource.f f24017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f24018e;
    private final String f;
    private final String g;
    private final String h;
    private a i;
    private String j;
    private String k;
    private long l;
    private String m;
    private String n;
    private long o;
    private final boolean p;
    private final int q;
    private final String r;
    private String s;
    private int t;
    private final String u;
    private final String v;
    private final String w;
    private final String x;

    /* JADX INFO: compiled from: AutoActionTaskListItemTask.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f24019a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f24020b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f24021c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f24022d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f24023e = null;
        private static final /* synthetic */ a[] h = null;
        private static final /* synthetic */ d.d.a i = null;
        private final int f;
        private final int g;

        private static final /* synthetic */ a[] c() {
            return new a[]{f24019a, f24020b, f24021c, f24022d, f24023e};
        }

        private a(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.f = r3;
            this.g = r4;
        }

        public final int a() {
            return this.f;
        }

        public final int b() {
            return this.g;
        }

        static {
            f24019a = new a("Unknown", 0, ZeusTransformUtils.mapRes(R.string.tli_status_running, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_status_running"), ZeusTransformUtils.mapRes(R.drawable.ic_star_usr_term, "drawable", "ic_star_usr_term"));
            f24020b = new a("Running", 1, ZeusTransformUtils.mapRes(R.string.tli_status_running, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_status_running"), ZeusTransformUtils.mapRes(R.drawable.ic_star_usr_term, "drawable", "ic_star_usr_term"));
            f24021c = new a("Success", 2, ZeusTransformUtils.mapRes(R.string.tli_status_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_status_success"), ZeusTransformUtils.mapRes(R.drawable.ic_check_success, "drawable", "ic_check_success"));
            f24022d = new a("Failed", 3, ZeusTransformUtils.mapRes(R.string.tli_status_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_status_failed"), ZeusTransformUtils.mapRes(R.drawable.ic_task_error, "drawable", "ic_task_error"));
            f24023e = new a("UserTerm", 4, ZeusTransformUtils.mapRes(R.string.tli_status_user_term, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_status_user_term"), ZeusTransformUtils.mapRes(R.drawable.oic_minus_circle_fill, "drawable", "oic_minus_circle_fill"));
            a[] r0 = c();
            h = r0;
            i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(h.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, h.class) == true) goto L8;
        return false;
    L8:
        h r10 = (h) ZeusTransformUtils.preCheckCast(r9, h.class, "com.obric.aiagent.plugin");
        if (this.f24014a == r10.f24014a) goto L12;
        return false;
    L12:
        if (o.a(this.f24015b, r10.f24015b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f24016c, r10.f24016c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f24017d, r10.f24017d) == true) goto L21;
        return false;
    L21:
        if (this.f24018e == r10.f24018e) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (o.a(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r10.l) goto L45;
        return false;
    L45:
        if (o.a(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (o.a(this.n, r10.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r10.o) goto L54;
        return false;
    L54:
        if (this.p == r10.p) goto L57;
        return false;
    L57:
        if (this.q == r10.q) goto L60;
        return false;
    L60:
        if (o.a(this.r, r10.r) == true) goto L63;
        return false;
    L63:
        if (o.a(this.s, r10.s) == true) goto L66;
        return false;
    L66:
        if (this.t == r10.t) goto L69;
        return false;
    L69:
        if (o.a(this.u, r10.u) == true) goto L72;
        return false;
    L72:
        if (o.a(this.v, r10.v) == true) goto L75;
        return false;
    L75:
        if (o.a(this.w, r10.w) == true) goto L78;
        return false;
    L78:
        if (o.a(this.x, r10.x) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.f24014a) * 31;
        String r1 = this.f24015b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.f24016c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        com.obric.autoaction.app.launcherpage.module.datasource.f r8 = this.f24017d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((((r7 + r9) * 31) + Integer.hashCode(this.f24018e)) * 31) + this.f.hashCode()) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((((((((r13 + r15) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + Long.hashCode(this.l)) * 31;
        String r17 = this.m;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.n;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (((((((((r19 + r21) * 31) + Long.hashCode(this.o)) * 31) + Boolean.hashCode(this.p)) * 31) + Integer.hashCode(this.q)) * 31) + this.r.hashCode()) * 31;
        String r23 = this.s;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (((((r22 + r24) * 31) + Integer.hashCode(this.t)) * 31) + this.u.hashCode()) * 31;
        String r26 = this.v;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.w;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.x;
        if (r32 == null) goto L47;
        r2 = r32.hashCode();
    L47:
        return r31 + r2;
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AutoActionTaskListItemTask(dbId=").append(this.f24014a).append(", timerTaskId=").append(this.f24015b).append(", triggerId=").append(this.f24016c).append(", eventTask=").append(this.f24017d).append(", flags=").append(this.f24018e).append(", sessionKey=").append(this.f).append(", sessionId=").append(this.g).append(", omniTaskId=").append(this.h).append(", status=").append(this.i).append(", taskSource=").append(this.j).append(", taskQuery=").append(this.k).append(", execDurationMillis=");
        r0.append(this.l).append(", details=").append(this.m).append(", shareUrl=").append(this.n).append(", gmtStartedMillis=").append(this.o).append(", isRepeat=").append(this.p).append(", taskMode=").append(this.q).append(", complexTaskModel=").append(this.r).append(", journalPath=").append(this.s).append(", taskTermType=").append(this.t).append(", id=").append(this.u).append(", messageId=").append(this.v).append(", resourceId=").append(this.w);
        r0.append(", queryId=").append(this.x).append(')');
        return r0.toString();
    }

    public final long b() {
        return this.f24014a;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.j
    public String a() {
        return this.f24015b;
    }

    public final Long c() {
        return this.f24016c;
    }

    public com.obric.autoaction.app.launcherpage.module.datasource.f d() {
        return this.f24017d;
    }

    public final int e() {
        return this.f24018e;
    }

    public final String h() {
        return this.g;
    }

    public final String i() {
        return this.h;
    }

    public final a j() {
        return this.i;
    }

    public final String k() {
        return this.k;
    }

    public final long l() {
        return this.l;
    }

    public final String m() {
        return this.m;
    }

    public final void a(String r1) {
        this.n = r1;
    }

    public final String n() {
        return this.n;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.d
    public long f() {
        return this.o;
    }

    public final boolean o() {
        return this.p;
    }

    public final int p() {
        return this.q;
    }

    public final String q() {
        return this.r;
    }

    public /* synthetic */ h(long r32, String r34, Long r35, com.obric.autoaction.app.launcherpage.module.datasource.f r36, int r37, String r38, String r39, String r40, a r41, String r42, String r43, long r44, String r46, String r47, long r48, boolean r50, int r51, String r52, String r53, int r54, String r55, String r56, String r57, String r58, int r59, d.h.b.h r60) {
        if ((r59 & 128) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r59 & 2048) == 0) goto L9;
        long r16 = -1;
    L11:
        if ((r59 & 4096) == 0) goto L13;
        String r18 = null;
    L15:
        if ((r59 & 8192) == 0) goto L17;
        String r19 = null;
    L19:
        if ((32768 & r59) == 0) goto L21;
        boolean r22 = false;
    L23:
        if ((131072 & r59) == 0) goto L25;
        String r24 = IOmniModelService.Companion.a().defaultDisplayModel();
    L27:
        if ((262144 & r59) == 0) goto L29;
        String r25 = null;
    L31:
        if ((524288 & r59) == 0) goto L33;
        int r26 = 0;
    L35:
        if ((1048576 & r59) == 0) goto L37;
        String r27 = r32 + r34 + r35;
    L39:
        if ((2097152 & r59) == 0) goto L41;
        String r28 = null;
    L43:
        if ((4194304 & r59) == 0) goto L45;
        String r29 = null;
    L47:
        if ((r59 & UiType.FLAG_APPLET_CARD) == 0) goto L49;
        String r30 = null;
    L50:
        this(r32, r34, r35, r36, r37, r38, r39, r12, r41, r42, r43, r16, r18, r19, r48, r22, r51, r24, r25, r26, r27, r28, r29, r30);
        return;
    L49:
        r30 = r58;
        goto L50
    L45:
        r29 = r57;
        goto L47
    L41:
        r28 = r56;
        goto L43
    L37:
        r27 = r55;
        goto L39
    L33:
        r26 = r54;
        goto L35
    L29:
        r25 = r53;
        goto L31
    L25:
        r24 = r52;
        goto L27
    L21:
        r22 = r50;
        goto L23
    L17:
        r19 = r47;
        goto L19
    L13:
        r18 = r46;
        goto L15
    L9:
        r16 = r44;
        goto L11
    L5:
        r12 = r40;
        goto L7
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.k
    public String g() {
        return this.u;
    }

    public final String r() {
        return this.w;
    }

    public final String s() {
        return this.x;
    }

    public h(long r10, String r12, Long r13, com.obric.autoaction.app.launcherpage.module.datasource.f r14, int r15, String r16, String r17, String r18, a r19, String r20, String r21, long r22, String r24, String r25, long r26, boolean r28, int r29, String r30, String r31, int r32, String r33, String r34, String r35, String r36) {
        o.e(r16, "sessionKey");
        o.e(r19, "status");
        o.e(r20, "taskSource");
        o.e(r21, "taskQuery");
        o.e(r30, "complexTaskModel");
        o.e(r33, DbHelper.COL_ID);
        super(null);
        this.f24014a = r10;
        this.f24015b = r12;
        this.f24016c = r13;
        this.f24017d = r14;
        this.f24018e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
        this.l = r22;
        this.m = r24;
        this.n = r25;
        this.o = r26;
        this.p = r28;
        this.q = r29;
        this.r = r30;
        this.s = r31;
        this.t = r32;
        this.u = r33;
        this.v = r34;
        this.w = r35;
        this.x = r36;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(com.obric.autoaction.app.launcherpage.ui.h r8) {
        com.obric.autoaction.app.launcherpage.ui.h r9 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r9, "other");
        if (ZeusTransformUtils.instanceOf(r9, h.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (o.a(((h) ZeusTransformUtils.preCheckCast(r9, h.class, "com.obric.aiagent.plugin")).f, this.f) == false) goto L13;
        if (((h) ZeusTransformUtils.preCheckCast(r9, h.class, "com.obric.aiagent.plugin")).f24014a != this.f24014a) goto L13;
        if (o.a(((h) ZeusTransformUtils.preCheckCast(r9, h.class, "com.obric.aiagent.plugin")).f24016c, this.f24016c) == false) goto L13;
        if (o.a(((h) ZeusTransformUtils.preCheckCast(r9, h.class, "com.obric.aiagent.plugin")).a(), a()) == false) goto L13;
        return true;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(com.obric.autoaction.app.launcherpage.ui.h r3) {
        com.obric.autoaction.app.launcherpage.ui.h r4 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r4, "other");
        if (ZeusTransformUtils.instanceOf(r4, h.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r4, this) == false) goto L7;
        return true;
    }
}
