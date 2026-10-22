package com.bytedance.android.ec.core.anchorv3;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class t implements fj.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<fj.b> f43824a;

    public t() {
        this.f43824a = new ArrayList();
    }

    @Override // fj.c
    public final void a(fj.b r100) {
        List<fj.b> r101 = this.f43824a;
        if (r101 == null) goto L7;
        TypeIntrinsics.asMutableCollection(r101).remove(r100);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @Override // fj.c
    public final void b(fj.b r100) {
        if (r100 == null) goto L5;
        ((ArrayList) this.f43824a).add(r100);
        return;
    }
}
