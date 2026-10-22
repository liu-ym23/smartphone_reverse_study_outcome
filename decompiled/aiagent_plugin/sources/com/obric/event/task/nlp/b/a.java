package com.obric.event.task.nlp.b;

import com.obric.eventkit.task.model.BatteryCondition;

/* JADX INFO: compiled from: BatteryConditionConvertor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32950a = null;

    private a() {
    }

    static {
        f32950a = new a();
        TAG = "BatteryConditionConvertor";
    }

    public final BatteryCondition a(int r4) {
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "parseChargeToCondition percent = " + r4);
        return new BatteryCondition(r4, true);
    }

    public final BatteryCondition b(int r4) {
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "parseDisChargeToCondition percent = " + r4);
        return new BatteryCondition(r4, false);
    }
}
