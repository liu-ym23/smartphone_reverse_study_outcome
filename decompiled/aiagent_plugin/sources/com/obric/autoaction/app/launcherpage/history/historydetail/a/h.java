package com.obric.autoaction.app.launcherpage.history.historydetail.a;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: HistoryDetailThoughtEndCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements com.obric.autoaction.app.launcherpage.ui.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23863a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f23864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23867e;

    /* JADX INFO: compiled from: HistoryDetailThoughtEndCell.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f23863a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23864b, r6.f23864b) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f23865c, r6.f23865c) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f23866d, r6.f23866d) == true) goto L18;
        return false;
    L18:
        if (this.f23867e == r6.f23867e) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f23864b;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f23865c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + this.f23866d.hashCode()) * 31) + Integer.hashCode(this.f23867e);
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "HistoryDetailThoughtEndData(icon=" + this.f23864b + ", packageName=" + this.f23865c + ", title=" + this.f23866d + ", type=" + this.f23867e + ')';
    }

    public h(Integer r2, String r3, String r4, int r5) {
        o.e(r4, DBDefinition.TITLE);
        this.f23864b = r2;
        this.f23865c = r3;
        this.f23866d = r4;
        this.f23867e = r5;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public Object c(com.obric.autoaction.app.launcherpage.ui.h r3) {
        return com.obric.autoaction.app.launcherpage.ui.h.a.a(this, (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"));
    }

    public final Integer a() {
        return this.f23864b;
    }

    public final String b() {
        return this.f23865c;
    }

    public final String c() {
        return this.f23866d;
    }

    public final int getType() {
        return this.f23867e;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(com.obric.autoaction.app.launcherpage.ui.h r2) {
        com.obric.autoaction.app.launcherpage.ui.h r1 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r1, "other");
        return ZeusTransformUtils.instanceOf(r1, h.class);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(com.obric.autoaction.app.launcherpage.ui.h r3) {
        com.obric.autoaction.app.launcherpage.ui.h r4 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r4, "other");
        return o.a(r4, this);
    }
}
