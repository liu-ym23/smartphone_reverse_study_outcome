package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f32068a = null;

    static {
        f32068a = new u();
    }

    private u() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r3) {
        d.h.b.o.e(r3, "instance");
        int r2 = ((((((r3.getId().hashCode() + 0) * 31) + Long.hashCode(r3.getCreateTime())) * 31) + Integer.hashCode(r3.getType())) * 31) + r3.get_packageName().hashCode();
        String r4 = r3.getExtraData();
        if (r4 != null) goto L5;
        return r2;
    L5:
        return (r2 * 31) + r4.hashCode();
    }
}
