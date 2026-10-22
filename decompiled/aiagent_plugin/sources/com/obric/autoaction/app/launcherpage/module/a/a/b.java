package com.obric.autoaction.app.launcherpage.module.a.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: AutoActionRepeatTaskManagementItem.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends f implements d, j, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.module.datasource.f f23997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<a> f24000e;
    private final String f;
    private final int g;
    private final int h;
    private final List<com.obric.autoaction.app.launcherpage.module.datasource.d> i;
    private final String j;
    private final long k;
    private final String l;

    /* JADX INFO: compiled from: AutoActionRepeatTaskManagementItem.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f24001a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f24002b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f24003c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f24004d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f24005e = null;
        public static final a f = null;
        public static final a g = null;
        private static final /* synthetic */ a[] k = null;
        private static final /* synthetic */ d.d.a l = null;
        private final int h;
        private final int i;
        private final int j;

        private static final /* synthetic */ a[] a() {
            return new a[]{f24001a, f24002b, f24003c, f24004d, f24005e, f, g};
        }

        private a(String r1, int r2, int r3, int r4, int r5) {
            super(r1, r2);
            this.h = r3;
            this.i = r4;
            this.j = r5;
        }

        static {
            f24001a = new a("TIMER_TASK", 0, ZeusTransformUtils.mapRes(R.drawable.time_active, "drawable", "time_active"), ZeusTransformUtils.mapRes(R.drawable.time, "drawable", "time"), ZeusTransformUtils.mapRes(R.color.bg_timer_task_cell, "color", "bg_timer_task_cell"));
            f24002b = new a("LOCATION", 1, ZeusTransformUtils.mapRes(R.drawable.location_active, "drawable", "location_active"), ZeusTransformUtils.mapRes(R.drawable.location, "drawable", "location"), ZeusTransformUtils.mapRes(R.color.bg_location_task_cell, "color", "bg_location_task_cell"));
            f24003c = new a("BATTERY", 2, ZeusTransformUtils.mapRes(R.drawable.ic_event_active, "drawable", "ic_event_active"), ZeusTransformUtils.mapRes(R.drawable.ic_event_not_active, "drawable", "ic_event_not_active"), ZeusTransformUtils.mapRes(R.color.bg_location_task_cell, "color", "bg_location_task_cell"));
            f24004d = new a("BLUETOOTH", 3, ZeusTransformUtils.mapRes(R.drawable.ic_event_active, "drawable", "ic_event_active"), ZeusTransformUtils.mapRes(R.drawable.ic_event_not_active, "drawable", "ic_event_not_active"), ZeusTransformUtils.mapRes(R.color.bg_location_task_cell, "color", "bg_location_task_cell"));
            f24005e = new a("WIFI", 4, ZeusTransformUtils.mapRes(R.drawable.ic_event_active, "drawable", "ic_event_active"), ZeusTransformUtils.mapRes(R.drawable.ic_event_not_active, "drawable", "ic_event_not_active"), ZeusTransformUtils.mapRes(R.color.bg_location_task_cell, "color", "bg_location_task_cell"));
            f = new a("STORAGE", 5, ZeusTransformUtils.mapRes(R.drawable.ic_event_active, "drawable", "ic_event_active"), ZeusTransformUtils.mapRes(R.drawable.ic_event_not_active, "drawable", "ic_event_not_active"), ZeusTransformUtils.mapRes(R.color.bg_location_task_cell, "color", "bg_location_task_cell"));
            g = new a("SMS", 6, ZeusTransformUtils.mapRes(R.drawable.ic_event_active, "drawable", "ic_event_active"), ZeusTransformUtils.mapRes(R.drawable.ic_event_not_active, "drawable", "ic_event_not_active"), ZeusTransformUtils.mapRes(R.color.bg_location_task_cell, "color", "bg_location_task_cell"));
            a[] r0 = a();
            k = r0;
            l = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(k.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.f, com.obric.autoaction.app.launcherpage.ui.h
    public Object c(com.obric.autoaction.app.launcherpage.ui.h r2) {
        com.obric.autoaction.app.launcherpage.ui.h r1 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r1, "newItem");
        return r1;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23996a, r10.f23996a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f23997b, r10.f23997b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f23998c, r10.f23998c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f23999d, r10.f23999d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f24000e, r10.f24000e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (o.a(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (o.a(this.l, r10.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r0 = this.f23996a.hashCode() * 31;
        com.obric.autoaction.app.launcherpage.module.datasource.f r1 = this.f23997b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((((((((r0 + r3) * 31) + this.f23998c.hashCode()) * 31) + this.f23999d.hashCode()) * 31) + this.f24000e.hashCode()) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + this.i.hashCode()) * 31;
        String r5 = this.j;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((r4 + r2) * 31) + Long.hashCode(this.k)) * 31) + this.l.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AutoActionRepeatTaskManagementItem(timerTaskId=").append(this.f23996a).append(", eventTask=").append(this.f23997b).append(", query=").append(this.f23998c).append(", condition=").append(this.f23999d).append(", conditionTypes=").append(this.f24000e).append(", action=").append(this.f).append(", enableStatus=").append(this.g).append(", allTriggerCount=").append(this.h).append(", triggerHistory=").append(this.i).append(", tagText=").append(this.j).append(", gmtStartedMillis=").append(this.k).append(", id=");
        r0.append(this.l).append(')');
        return r0.toString();
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.j
    public String a() {
        return this.f23996a;
    }

    public com.obric.autoaction.app.launcherpage.module.datasource.f b() {
        return this.f23997b;
    }

    public final String c() {
        return this.f23998c;
    }

    public final String d() {
        return this.f23999d;
    }

    public final String e() {
        return this.f;
    }

    public final int h() {
        return this.g;
    }

    public /* synthetic */ b(String r18, com.obric.autoaction.app.launcherpage.module.datasource.f r19, String r20, String r21, List r22, String r23, int r24, int r25, List r26, String r27, long r28, String r30, int r31, d.h.b.h r32) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        if ((r31 & 256) == 0) goto L5;
        r1 = p.b();
    L5:
        List r12 = r1;
        if ((r31 & 2048) == 0) goto L8;
        String r16 = String.valueOf(r18);
    L9:
        this(r18, r19, r20, r21, r8, r23, r24, r25, r12, r27, r28, r16);
        return;
    L8:
        r16 = r30;
        goto L9
    }

    public final String i() {
        return this.j;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.d
    public long f() {
        return this.k;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.k
    public String g() {
        return this.l;
    }

    public b(String r3, com.obric.autoaction.app.launcherpage.module.datasource.f r4, String r5, String r6, List<? extends a> r7, String r8, int r9, int r10, List<com.obric.autoaction.app.launcherpage.module.datasource.d> r11, String r12, long r13, String r15) {
        List<a> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<com.obric.autoaction.app.launcherpage.module.datasource.d> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "timerTaskId");
        o.e(r5, DownloadConstants.QUERY_KEY);
        o.e(r6, "condition");
        o.e(r14, "conditionTypes");
        o.e(r8, "action");
        o.e(r16, "triggerHistory");
        o.e(r15, DbHelper.COL_ID);
        super(null);
        this.f23996a = r3;
        this.f23997b = r4;
        this.f23998c = r5;
        this.f23999d = r6;
        this.f24000e = r14;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r16;
        this.j = r12;
        this.k = r13;
        this.l = r15;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(com.obric.autoaction.app.launcherpage.ui.h r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r5, "other");
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).a(), a()) == false) goto L7;
        return true;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(com.obric.autoaction.app.launcherpage.ui.h r5) {
        com.obric.autoaction.app.launcherpage.ui.h r6 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r6, "other");
        if (ZeusTransformUtils.instanceOf(r6, b.class) == true) goto L5;
    L19:
        return false;
    L5:
        if (o.a(((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin")).g(), g()) == false) goto L19;
        if (o.a(((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin")).j, this.j) == false) goto L19;
        if (((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin")).g != this.g) goto L19;
        if (o.a(((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin")).f, this.f) == false) goto L19;
        if (o.a(((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin")).f24000e, this.f24000e) == false) goto L19;
        if (o.a(((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin")).f23999d, this.f23999d) == false) goto L19;
        if (o.a(((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin")).f23998c, this.f23998c) == false) goto L19;
        return true;
    }
}
