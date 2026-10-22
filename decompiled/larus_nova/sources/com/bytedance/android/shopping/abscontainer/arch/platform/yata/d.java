package com.bytedance.android.shopping.abscontainer.arch.platform.yata;

import com.bytedance.android.shopping.extensions.k;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements z33.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.kmp.ec.yata.store.node.c f164215a;

    @Override // z33.a
    public final String d() {
        return this.f164215a.getKey();
    }

    @Override // z33.a
    public final Map<String, Object> e() {
        Map<String, Object> r100 = this.f164215a.e();
        if (r100 != null) goto L7;
        return null;
    L7:
        return k.b(r100);
    }

    @Override // z33.a
    public final String getNodeName() {
        return this.f164215a.getNodeName();
    }

    public d(com.bytedance.kmp.ec.yata.store.node.c r100) {
        this.f164215a = r100;
    }
}
