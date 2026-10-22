package com.obric.autoaction.app.launcherpage.module.a.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AutoActionNormalFutureTaskItem.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f implements d, j, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.module.datasource.f f23992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f23994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f23995e;
    private final long f;
    private final String g;

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
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23991a, r10.f23991a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f23992b, r10.f23992b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f23993c, r10.f23993c) == true) goto L18;
        return false;
    L18:
        if (this.f23994d == r10.f23994d) goto L21;
        return false;
    L21:
        if (o.a(this.f23995e, r10.f23995e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.f23991a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        com.obric.autoaction.app.launcherpage.module.datasource.f r4 = this.f23992b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f23993c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((((((((r6 + r1) * 31) + Boolean.hashCode(this.f23994d)) * 31) + this.f23995e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode();
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AutoActionNormalFutureTaskItem(timerTaskId=" + this.f23991a + ", eventTask=" + this.f23992b + ", sessionKey=" + this.f23993c + ", isRepeat=" + this.f23994d + ", query=" + this.f23995e + ", gmtStartedMillis=" + this.f + ", id=" + this.g + ')';
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.j
    public String a() {
        return this.f23991a;
    }

    public com.obric.autoaction.app.launcherpage.module.datasource.f b() {
        return this.f23992b;
    }

    public final String c() {
        return this.f23993c;
    }

    public final boolean d() {
        return this.f23994d;
    }

    public final String e() {
        return this.f23995e;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.d
    public long f() {
        return this.f;
    }

    public /* synthetic */ a(String r11, com.obric.autoaction.app.launcherpage.module.datasource.f r12, String r13, boolean r14, String r15, long r16, String r18, int r19, d.h.b.h r20) {
        if ((r19 & 64) == 0) goto L5;
        String r9 = r11 + r13;
    L6:
        this(r11, r12, r13, r14, r15, r16, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.k
    public String g() {
        return this.g;
    }

    public a(String r2, com.obric.autoaction.app.launcherpage.module.datasource.f r3, String r4, boolean r5, String r6, long r7, String r9) {
        o.e(r6, DownloadConstants.QUERY_KEY);
        o.e(r9, DbHelper.COL_ID);
        super(null);
        this.f23991a = r2;
        this.f23992b = r3;
        this.f23993c = r4;
        this.f23994d = r5;
        this.f23995e = r6;
        this.f = r7;
        this.g = r9;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(com.obric.autoaction.app.launcherpage.ui.h r5) {
        com.obric.autoaction.app.launcherpage.ui.h r6 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r6, "other");
        if (ZeusTransformUtils.instanceOf(r6, a.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (o.a(((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.aiagent.plugin")).a(), a()) == false) goto L9;
        if (o.a(this.f23993c, ((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.aiagent.plugin")).f23993c) == false) goto L9;
        return true;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(com.obric.autoaction.app.launcherpage.ui.h r3) {
        com.obric.autoaction.app.launcherpage.ui.h r4 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r4, "other");
        if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r4, this) == false) goto L7;
        return true;
    }
}
