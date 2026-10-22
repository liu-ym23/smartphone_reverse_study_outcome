package com.obric.autoaction.app.launcherpage.condition.config.a;

import com.obric.autoaction.app.launcherpage.ui.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ConditionListCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c> f22951a;

    public e(List<c> r3) {
        List<c> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "itemList");
        this.f22951a = r4;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public Object c(h r3) {
        return h.a.a(this, (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin"));
    }

    public final List<c> a() {
        return this.f22951a;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(h r2) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        o.e(r1, "other");
        return ZeusTransformUtils.instanceOf(r1, e.class);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(h r9) {
        h r10 = (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.aiagent.plugin");
        o.e(r10, "other");
        if (ZeusTransformUtils.instanceOf(r10, e.class) == true) goto L6;
        return false;
    L6:
        if (this.f22951a.size() == ((e) ZeusTransformUtils.preCheckCast(r10, e.class, "com.obric.aiagent.plugin")).f22951a.size()) goto L8;
        return false;
    L8:
        int r1 = ((Collection) ZeusTransformUtils.preCheckCast(this.f22951a, Collection.class, "com.obric.aiagent.plugin")).size();
        int r4 = 0;
    L9:
        if (r4 >= r1) goto L17;
        if (r4 >= ((e) ZeusTransformUtils.preCheckCast(r10, e.class, "com.obric.aiagent.plugin")).f22951a.size()) goto L12;
        if (((c) ZeusTransformUtils.preCheckCast(this.f22951a.get(r4), c.class, "com.obric.aiagent.plugin")).b((h) ZeusTransformUtils.preCheckCast(((e) ZeusTransformUtils.preCheckCast(r10, e.class, "com.obric.aiagent.plugin")).f22951a.get(r4), h.class, "com.obric.aiagent.plugin")) == false) goto L15;
        r4 = r4 + 1;
        goto L9
    L15:
        return false;
    L12:
        return false;
    L17:
        return true;
    }
}
