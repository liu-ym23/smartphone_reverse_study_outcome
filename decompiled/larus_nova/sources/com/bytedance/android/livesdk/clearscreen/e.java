package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.utils.condition.base.Condition;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant$ConditionType;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements com.bytedance.android.livesdk.utils.condition.base.d {
    public e() {
    }

    @Override // com.bytedance.android.livesdk.utils.condition.base.d
    public final boolean b(HashMap<ConditionConstant$ConditionType, Condition> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "childConditions");
        if (r101 <= 5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.utils.condition.base.d
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.utils.condition.base.d
    public final void reset() {
    }

    @Override // com.bytedance.android.livesdk.utils.condition.base.d
    public final long a(com.bytedance.android.livesdk.utils.condition.base.b r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r100, "event");
        return 0;
    }

    @Override // com.bytedance.android.livesdk.utils.condition.base.d
    public final long c(com.bytedance.android.livesdk.utils.condition.base.b r100, long r101, HashMap<ConditionConstant$ConditionType, Condition> r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r102, "childConditions");
        Iterator<Condition> r103 = r102.values().iterator();
        long r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L6;
        r104 = r104 + r103.next().f158908b;
        goto L4
    L6:
        return r104;
    }
}
