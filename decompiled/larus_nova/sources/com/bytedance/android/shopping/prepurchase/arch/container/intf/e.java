package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements i {
    public e() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.i
    public final void ensureNotReachHere(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        ECExceptionMonitor.e(r100);
    }
}
