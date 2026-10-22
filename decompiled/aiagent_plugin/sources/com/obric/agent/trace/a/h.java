package com.obric.agent.trace.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IntentListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
final class h extends androidx.recyclerview.widget.j.e<j> {
    public h() {
    }

    @Override // androidx.recyclerview.widget.j.e
    public /* synthetic */ boolean a(j r3, j r4) {
        return a2((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin"), (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.j.e
    public /* synthetic */ boolean b(j r3, j r4) {
        return b2((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin"), (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(j r1, j r2) {
        o.e(r1, "oldItem");
        o.e(r2, "newItem");
        return o.a(r1, r2);
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public boolean b2(j r1, j r2) {
        o.e(r1, "oldItem");
        o.e(r2, "newItem");
        return o.a(r1, r2);
    }
}
