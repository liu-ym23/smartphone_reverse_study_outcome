package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PKBizType;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final PKBizType a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$pkBizType");
        IBaseBattleSetting r101 = r100.f92901a;
        if (r101 == null) goto L7;
        PKBizType r102 = b(r101);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return PKBizType.ClassicDouble;
    }

    public static final PKBizType b(IBaseBattleSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$pkBizType");
        int r101 = r100.getBattleType();
        PKBizType r102 = PKBizType.ClassicMulti;
        if (r101 != r102.ordinal()) goto L6;
        return r102;
    L6:
        return PKBizType.ClassicDouble;
    }
}
