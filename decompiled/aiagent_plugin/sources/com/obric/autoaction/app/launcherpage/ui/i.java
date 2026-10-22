package com.obric.autoaction.app.launcherpage.ui;

import com.obric.autoaction.app.launcherpage.ui.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PowerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
final class i<T extends h> extends com.obric.oui.orecyclerview.widget.j.e<T> {
    public i() {
    }

    @Override // com.obric.oui.orecyclerview.widget.j.e
    public /* synthetic */ boolean a(Object r3, Object r4) {
        return a((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"), (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.j.e
    public /* synthetic */ boolean b(Object r3, Object r4) {
        return b((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"), (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.j.e
    public /* synthetic */ Object c(Object r3, Object r4) {
        return c((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"), (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.aiagent.plugin"));
    }

    public boolean a(T r2, T r3) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "oldItem");
        d.h.b.o.e(r4, "newItem");
        return r1.a(r4);
    }

    public boolean b(T r2, T r3) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "oldItem");
        d.h.b.o.e(r4, "newItem");
        return r1.b(r4);
    }

    public Object c(T r2, T r3) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "oldItem");
        d.h.b.o.e(r4, "newItem");
        return r1.c(r4);
    }
}
