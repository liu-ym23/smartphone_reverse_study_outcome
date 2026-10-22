package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f130102a = null;

    static {
        f130102a = new a();
    }

    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        com.bytedance.android.livesdk.gift.model.m r102 = (com.bytedance.android.livesdk.gift.model.m) r100;
        com.bytedance.android.livesdk.gift.model.m r103 = (com.bytedance.android.livesdk.gift.model.m) r101;
        Intrinsics.checkNotNullParameter(r102, DevicePlans.DEVICE_PLAN_OPPO1);
        Intrinsics.checkNotNullParameter(r103, DevicePlans.DEVICE_PLAN_OPPO2);
        return r103.leftGiftCount - r102.leftGiftCount;
    }
}
