package com.bytedance.android.ec.hybrid.list;

import com.bytedance.android.ec.hybrid.list.ability.g0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECHybridListAdapter f47000a;

    public b(ECHybridListAdapter r100) {
        this.f47000a = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.g0
    public final void a(String r100) {
        if (Intrinsics.areEqual(r100, "all") == false) goto L5;
    L6:
        com.bytedance.android.ec.hybrid.list.entity.b r101 = this.f47000a.f46848i;
        r101.f47067a = false;
        r101.f47068b = 0;
        r101.f47069c = false;
        r101.f47070d = false;
        return;
    L5:
        if (Intrinsics.areEqual(r100, "favorite_section") == true) goto L6;
    }
}
