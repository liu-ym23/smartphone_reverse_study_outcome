package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.utils.condition.base.Condition;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant$ConditionType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements com.bytedance.android.livesdk.utils.condition.base.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f119365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConditionConstant$ConditionType f119366b;

    @Override // com.bytedance.android.livesdk.utils.condition.base.d
    public final long a(com.bytedance.android.livesdk.utils.condition.base.b r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return r101 + 1;
    }

    @Override // com.bytedance.android.livesdk.utils.condition.base.d
    public final void reset() {
    }

    @Override // com.bytedance.android.livesdk.utils.condition.base.d
    public final void d() {
        xs2.b.a().post(new com.bytedance.android.livesdk.utils.condition.base.b(this.f119366b));
    }

    public d(ConditionConstant$ConditionType r100) {
        this.f119365a = 5;
        this.f119366b = r100;
    }

    @Override // com.bytedance.android.livesdk.utils.condition.base.d
    public final boolean b(HashMap<ConditionConstant$ConditionType, Condition> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "childConditions");
        if (r101 <= this.f119365a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.utils.condition.base.d
    public final long c(com.bytedance.android.livesdk.utils.condition.base.b r100, long r101, HashMap<ConditionConstant$ConditionType, Condition> r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r102, "childConditions");
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r102, "childConditions");
        return 0;
    }
}
