package com.obric.autoaction.app.launcherpage.module.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.LocalDate;

/* JADX INFO: compiled from: AutoActionTaskListItemDate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LocalDate f24012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocalDate f24013b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (o.a(this.f24012a, r6.f24012a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f24013b, r6.f24013b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f24012a.hashCode() * 31) + this.f24013b.hashCode();
    }

    public String toString() {
        return "AutoActionTaskListItemDate(date=" + this.f24012a + ", now=" + this.f24013b + ')';
    }

    public final LocalDate a() {
        return this.f24012a;
    }

    public /* synthetic */ g(LocalDate r1, LocalDate r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = LocalDate.now();
    L5:
        this(r1, r2);
    }

    public g(LocalDate r2, LocalDate r3) {
        o.e(r2, "date");
        o.e(r3, "now");
        super(null);
        this.f24012a = r2;
        this.f24013b = r3;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(com.obric.autoaction.app.launcherpage.ui.h r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r5, "other");
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(this.f24012a, ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).f24012a) == false) goto L7;
        return true;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(com.obric.autoaction.app.launcherpage.ui.h r5) {
        com.obric.autoaction.app.launcherpage.ui.h r6 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r6, "other");
        if (ZeusTransformUtils.instanceOf(r6, g.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (o.a(this.f24012a, ((g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.aiagent.plugin")).f24012a) == false) goto L9;
        if (o.a(this.f24013b, ((g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.aiagent.plugin")).f24013b) == false) goto L9;
        return true;
    }
}
