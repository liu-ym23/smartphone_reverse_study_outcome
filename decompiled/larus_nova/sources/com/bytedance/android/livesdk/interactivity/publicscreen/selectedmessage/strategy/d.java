package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy;

import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements Comparator<f<?>> {
    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(f<?> r100, f<?> r101) {
        f<?> r102 = r100;
        f<?> r103 = r101;
        Intrinsics.checkNotNullParameter(r102, DevicePlans.DEVICE_PLAN_OPPO1);
        Intrinsics.checkNotNullParameter(r103, DevicePlans.DEVICE_PLAN_OPPO2);
        Object r104 = r103.f133141b;
        Object r105 = null;
        if ((r104 instanceof u3) == true) goto L5;
        r104 = null;
    L5:
        u3 r106 = (u3) r104;
        int r107 = 0;
        if (r106 == null) goto L10;
        IPublicAreaCommon r108 = r106.getOrInitPublicAreaCommon();
        if (r108 == null) goto L10;
        int r109 = r108.getIndividualPriority();
    L11:
        Object r110 = r102.f133141b;
        if ((r110 instanceof u3) == false) goto L15;
        r105 = r110;
    L15:
        u3 r111 = (u3) r105;
        if (r111 == null) goto L21;
        IPublicAreaCommon r112 = r111.getOrInitPublicAreaCommon();
        if (r112 == null) goto L21;
        r107 = r112.getIndividualPriority();
    L21:
        return r109 - r107;
    L10:
        r109 = 0;
        goto L11
    }
}
