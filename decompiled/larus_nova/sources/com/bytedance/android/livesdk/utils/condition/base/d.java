package com.bytedance.android.livesdk.utils.condition.base;

import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public interface d {
    long a(b r100, long r101);

    boolean b(HashMap<ConditionConstant$ConditionType, Condition> r100, long r101);

    long c(b r100, long r101, HashMap<ConditionConstant$ConditionType, Condition> r102);

    void d();

    void reset();
}
