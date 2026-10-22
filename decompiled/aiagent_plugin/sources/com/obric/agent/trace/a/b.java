package com.obric.agent.trace.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IntentDetailAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
final class b extends androidx.recyclerview.widget.j.e<c> {
    public b() {
    }

    @Override // androidx.recyclerview.widget.j.e
    public /* synthetic */ boolean a(c r3, c r4) {
        return a2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"), (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.j.e
    public /* synthetic */ boolean b(c r3, c r4) {
        return b2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"), (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(c r1, c r2) {
        o.e(r1, "oldItem");
        o.e(r2, "newItem");
        return o.a(r1, r2);
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public boolean b2(c r1, c r2) {
        o.e(r1, "oldItem");
        o.e(r2, "newItem");
        return o.a(r1, r2);
    }
}
