package com.bytedance.android.live.room.share.jsbridge;

import android.content.Context;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.xbridge.mix.IJavaMethod2Annie;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@XBridgeMethod(biz = "webcast", name = "share")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/share/jsbridge/ShareMethodV3;", "Lcom/bytedance/android/annie/xbridge/mix/IJavaMethod2Annie;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareMethodV3 extends IJavaMethod2Annie {
    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return "share";
    }

    public ShareMethodV3(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        super(r100);
    }

    @Override // com.bytedance.android.annie.xbridge.mix.IJavaMethod2Annie
    public final n56.c c(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        ue7.c r101 = (ue7.c) r100.c(ue7.c.class);
        JSBridgeManager r102 = (JSBridgeManager) r100.c(JSBridgeManager.class);
        com.bytedance.android.annie.card.g r103 = null;
        if (r101 == null) goto L5;
        Context r104 = r101.context();
    L6:
        WeakReference r105 = new WeakReference(r104);
        if (r102 == null) goto L10;
        r103 = r102.f38447t;
    L10:
        return new i(r105, r103);
    L5:
        r104 = null;
        goto L6
    }
}
