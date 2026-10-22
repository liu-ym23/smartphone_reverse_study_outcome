package com.obric.autoaction.app.launcherpage.module.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.LocalDate;

/* JADX INFO: compiled from: AutoActionTaskListHistorySeparatorItem.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalDate f24011a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f24011a, r6.f24011a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f24011a.hashCode();
    }

    public String toString() {
        return "AutoActionTaskListHistorySeparatorItem(date=" + this.f24011a + ')';
    }

    public e(LocalDate r2) {
        o.e(r2, "date");
        super(null);
        this.f24011a = r2;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(com.obric.autoaction.app.launcherpage.ui.h r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r5, "other");
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(((e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin")).f24011a, this.f24011a) == false) goto L7;
        return true;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(com.obric.autoaction.app.launcherpage.ui.h r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r5, "other");
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(((e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin")).f24011a, this.f24011a) == false) goto L7;
        return true;
    }
}
