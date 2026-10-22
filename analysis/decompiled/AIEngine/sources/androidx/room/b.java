package androidx.room;

import androidx.work.impl.WorkDatabase_Impl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import q2.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    public static final Flow a(WorkDatabase_Impl workDatabase_Impl, String[] strArr, r.a aVar) {
        return FlowKt.flow(new CoroutinesRoom$Companion$createFlow$1(workDatabase_Impl, strArr, aVar, null));
    }
}
