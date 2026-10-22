package com.obric.event.task.nlp.b;

import com.obric.eventkit.task.model.StorageCondition;

/* JADX INFO: compiled from: StorageConditionConvertor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f33004a = null;

    private j() {
    }

    static {
        f33004a = new j();
        TAG = "StorageConditionConvertor";
    }

    public final StorageCondition a(int r4) {
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "parseDto2Condition percent = " + r4);
        return new StorageCondition(r4);
    }
}
