package com.bytedance.android.gamecp.business;

import com.bytedance.android.gamecp.business.download.e1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class l implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.c f56144a;

    @Override // com.bytedance.android.gamecp.business.download.e1
    public final void b(List<com.bytedance.android.gamecp.business.download.p> r100) {
        Intrinsics.checkNotNullParameter(r100, "downloadList");
    }

    public l(com.bytedance.android.gamecp.base.core.service.depend.c r100) {
        this.f56144a = r100;
    }

    @Override // com.bytedance.android.gamecp.business.download.e1
    public final void a(JSONObject r100) {
        com.bytedance.android.gamecp.base.core.service.depend.c r101 = this.f56144a;
        if (r101 == null) goto L6;
        r101.onResult(r100);
        return;
    }
}
