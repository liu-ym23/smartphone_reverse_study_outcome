package com.obric.autoaction.app.launcherpage.condition.config.a;

import com.obric.autoaction.app.launcherpage.condition.config.condition.GroupInfo;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConditionGroupTitleCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f22944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GroupInfo f22945b;

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public Object c(h r2) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        o.e(r1, "newItem");
        return r1;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f22944a == r6.f22944a) goto L12;
        return false;
    L12:
        if (o.a(this.f22945b, r6.f22945b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f22944a) * 31) + this.f22945b.hashCode();
    }

    public String toString() {
        return "ConditionGroupTitleItem(active=" + this.f22944a + ", groupInfo=" + this.f22945b + ')';
    }

    public b(boolean r2, GroupInfo r3) {
        o.e(r3, "groupInfo");
        this.f22944a = r2;
        this.f22945b = r3;
    }

    public final GroupInfo a() {
        return this.f22945b;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(h r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
        o.e(r5, "other");
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(this.f22945b, ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).f22945b) == false) goto L7;
        return true;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        o.e(r4, "other");
        return o.a(this, r4);
    }
}
