package com.obric.autoaction.app.launcherpage.history.historydetail.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: HistoryDetailSubTitleCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.obric.autoaction.app.launcherpage.ui.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23860a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23860a, r6.f23860a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f23860a.hashCode();
    }

    public String toString() {
        return "DetailSubTitleData(subTitle=" + this.f23860a + ')';
    }

    public final String a() {
        return this.f23860a;
    }

    public e(String r2) {
        o.e(r2, "subTitle");
        this.f23860a = r2;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(com.obric.autoaction.app.launcherpage.ui.h r2) {
        com.obric.autoaction.app.launcherpage.ui.h r1 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r1, "other");
        return ZeusTransformUtils.instanceOf(r1, e.class);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(com.obric.autoaction.app.launcherpage.ui.h r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r5, "other");
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(((e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin")).f23860a, this.f23860a) == false) goto L7;
        return true;
    }
}
