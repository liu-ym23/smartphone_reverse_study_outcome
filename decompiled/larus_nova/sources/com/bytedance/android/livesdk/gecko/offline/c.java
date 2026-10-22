package com.bytedance.android.livesdk.gecko.offline;

import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements d {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.gecko.offline.d
    public final PolarisFileWrapper a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        boolean r101 = OfflineResourceClient.f125824a;
        d1 r102 = OfflineResourceClient.e(r100);
        if (r102 == null) goto L9;
        String r103 = r102.f247859b;
        if (r103 != null) goto L8;
        return null;
    L8:
        return new PolarisFileWrapper(r103);
    L9:
        return null;
    }
}
