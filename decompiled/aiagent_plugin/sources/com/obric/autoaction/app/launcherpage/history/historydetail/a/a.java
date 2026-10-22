package com.obric.autoaction.app.launcherpage.history.historydetail.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: HistoryDetailBottomTipCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autoaction.app.launcherpage.ui.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23856a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23856a, r6.f23856a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f23856a.hashCode();
    }

    public String toString() {
        return "DetailBottomTipData(subTitle=" + this.f23856a + ')';
    }

    public final String a() {
        return this.f23856a;
    }

    public a(String r2) {
        o.e(r2, "subTitle");
        this.f23856a = r2;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(com.obric.autoaction.app.launcherpage.ui.h r2) {
        com.obric.autoaction.app.launcherpage.ui.h r1 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r1, "other");
        return ZeusTransformUtils.instanceOf(r1, a.class);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(com.obric.autoaction.app.launcherpage.ui.h r3) {
        com.obric.autoaction.app.launcherpage.ui.h r4 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        o.e(r4, "other");
        return o.a(r4, this);
    }
}
