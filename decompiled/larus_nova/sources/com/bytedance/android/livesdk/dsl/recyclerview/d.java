package com.bytedance.android.livesdk.dsl.recyclerview;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import yt1.o;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, o> f122799a;

    public d() {
        this.f122799a = new HashMap();
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.f
    public final o a(int r100) {
        return this.f122799a.get(Integer.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.f
    public final void b(int r100, o r101) {
        Intrinsics.checkNotNullParameter(r101, "element");
        this.f122799a.put(Integer.valueOf(r100), r101);
    }
}
