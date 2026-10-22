package com.bytedance.android.shopping.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.anchorv4.launcher.PdpLauncher;
import com.bytedance.android.shopping.utils.z;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements bf.c {
    public h() {
    }

    @Override // bf.c
    public final void a() {
    }

    @Override // bf.c
    public final String b() {
        return "ec_goods_pdp";
    }

    @Override // bf.c
    public final boolean c(Context r210, Uri r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "uri");
        new PdpLauncher(r210).c(r211, new p83.h(r212, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 16777214));     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        int r100 = z.f187162a;
        z.c("ECPdpSchemaRouter.open err=" + th.getMessage(), null, 6);
        throw th;
    }
}
