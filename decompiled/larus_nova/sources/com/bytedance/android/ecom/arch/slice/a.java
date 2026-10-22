package com.bytedance.android.ecom.arch.slice;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, SlcElement> f49964a;

    public a() {
        this.f49964a = new HashMap();
    }

    @Override // com.bytedance.android.ecom.arch.slice.e
    public final void b(Map<String, SlcElement> r100) {
        Intrinsics.checkNotNullParameter(r100, "templateMap");
        e.a.a(this, r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.e
    public final SlcElement getTemplate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f49964a.get(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.e
    public final void a(String r100, SlcElement r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "element");
        if (this.f49964a.containsKey(r100) == true) goto L6;
        this.f49964a.put(r100, r101);
        return;
    }
}
