package com.obric.autoaction.app.launcherpage.module.a.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AutoActionSimpleFutureTaskItem.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends f implements d, j, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.module.datasource.f f24007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f24008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f24009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f24010e;
    private final String f;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
        return false;
    L8:
        c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f24006a, r10.f24006a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f24007b, r10.f24007b) == true) goto L15;
        return false;
    L15:
        if (this.f24008c == r10.f24008c) goto L18;
        return false;
    L18:
        if (o.a(this.f24009d, r10.f24009d) == true) goto L21;
        return false;
    L21:
        if (this.f24010e == r10.f24010e) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = this.f24006a.hashCode() * 31;
        com.obric.autoaction.app.launcherpage.module.datasource.f r1 = this.f24007b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((r0 + r2) * 31) + Boolean.hashCode(this.f24008c)) * 31) + this.f24009d.hashCode()) * 31) + Long.hashCode(this.f24010e)) * 31) + this.f.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AutoActionSimpleFutureTaskItem(timerTaskId=" + this.f24006a + ", eventTask=" + this.f24007b + ", isRepeat=" + this.f24008c + ", query=" + this.f24009d + ", gmtStartedMillis=" + this.f24010e + ", id=" + this.f + ')';
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.j
    public String a() {
        return this.f24006a;
    }

    public final boolean b() {
        return this.f24008c;
    }

    public final String c() {
        return this.f24009d;
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.d
    public long f() {
        return this.f24010e;
    }

    public /* synthetic */ c(String r10, com.obric.autoaction.app.launcherpage.module.datasource.f r11, boolean r12, String r13, long r14, String r16, int r17, d.h.b.h r18) {
        if ((r17 & 32) == 0) goto L5;
        String r8 = String.valueOf(r10);
    L6:
        this(r10, r11, r12, r13, r14, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.module.a.a.k
    public String g() {
        return this.f;
    }

    public c(String r2, com.obric.autoaction.app.launcherpage.module.datasource.f r3, boolean r4, String r5, long r6, String r8) {
        o.e(r2, "timerTaskId");
        o.e(r5, DownloadConstants.QUERY_KEY);
        o.e(r8, DbHelper.COL_ID);
        super(null);
        this.f24006a = r2;
        this.f24007b = r3;
        this.f24008c = r4;
        this.f24009d = r5;
        this.f24010e = r6;
        this.f = r8;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(com.obric.autoaction.app.launcherpage.ui.h r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r5, "other");
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin")).a(), a()) == false) goto L7;
        return true;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(com.obric.autoaction.app.launcherpage.ui.h r3) {
        com.obric.autoaction.app.launcherpage.ui.h r4 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r4, "other");
        if (ZeusTransformUtils.instanceOf(r4, c.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r4, this) == false) goto L7;
        return true;
    }
}
