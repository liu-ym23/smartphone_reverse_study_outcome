package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import com.bytedance.android.annie.xbridge.mix.IJavaMethod2Annie;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "copyToClipboard")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/ClipboardMethodV3;", "Lcom/bytedance/android/annie/xbridge/mix/IJavaMethod2Annie;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClipboardMethodV3 extends IJavaMethod2Annie {
    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return "copyToClipboard";
    }

    public ClipboardMethodV3(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        super(r100);
    }

    @Override // com.bytedance.android.annie.xbridge.mix.IJavaMethod2Annie
    public final n56.c c(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        ue7.c r101 = (ue7.c) r100.c(ue7.c.class);
        if (r101 == null) goto L5;
        Context r102 = r101.context();
    L7:
        return new f0(new WeakReference(r102));
    L5:
        r102 = null;
        goto L7
    }
}
