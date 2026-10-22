package com.obric.autoaction.app.launcherpage.history.historydetail.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: HistoryDetailItemContentCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.autoaction.app.launcherpage.ui.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23858a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23858a, r6.f23858a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f23858a.hashCode();
    }

    public String toString() {
        return "DetailItemContentData(content=" + this.f23858a + ')';
    }

    public final String a() {
        return this.f23858a;
    }

    public c(String r2) {
        o.e(r2, "content");
        this.f23858a = r2;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(com.obric.autoaction.app.launcherpage.ui.h r2) {
        com.obric.autoaction.app.launcherpage.ui.h r1 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r1, "other");
        return ZeusTransformUtils.instanceOf(r1, c.class);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(com.obric.autoaction.app.launcherpage.ui.h r3) {
        com.obric.autoaction.app.launcherpage.ui.h r4 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r4, "other");
        return o.a(r4, this);
    }
}
