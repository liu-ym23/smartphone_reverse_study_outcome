package com.bytedance.android.shopping.anchorv4.voavhs;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements com.bytedance.android.ecom.arch.slice.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, SlcElement> f169918a;

    public j() {
        this.f169918a = new HashMap();
    }

    @Override // com.bytedance.android.ecom.arch.slice.e
    public final void b(Map<String, SlcElement> r100) {
        Intrinsics.checkNotNullParameter(r100, "templateMap");
        com.bytedance.android.ecom.arch.slice.e.a.a(this, r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.e
    public final SlcElement getTemplate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f169918a.get(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.e
    public final void a(String r100, SlcElement r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "element");
        this.f169918a.put(r100, r101);
    }
}
