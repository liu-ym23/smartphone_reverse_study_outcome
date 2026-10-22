package com.bytedance.android.ec.window.base.common.taskgraph;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PipelineNode<?, ?> f49178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PipelineNode<?, ?> f49179b;

    public final String toString() {
        return "NodePair(first=" + this.f49178a + ", second=" + this.f49179b + ")";
    }

    public final int hashCode() {
        return (this.f49178a.hashCode() * 31) + this.f49179b.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L19;
        a r102 = (a) r100;
        if ((true ^ Intrinsics.areEqual(this.f49178a, r102.f49178a)) == false) goto L17;
        return false;
    L17:
        return Intrinsics.areEqual(this.f49179b, r102.f49179b);
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.common.taskgraph.NodePair");
    L8:
        r101 = null;
        goto L10
    }

    public a(PipelineNode<?, ?> r100, PipelineNode<?, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r101, "second");
        this.f49178a = r100;
        this.f49179b = r101;
    }
}
