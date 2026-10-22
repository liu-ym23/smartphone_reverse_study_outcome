package com.bytedance.android.live.liveinteract.plantform.datamergev2.handler;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f76714a;

    public h(e r100) {
        this.f76714a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b r101 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.C1190b) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        long r102 = this.f76714a.f76704f.get();
        if (r101.f76421b.getTimestamp() <= r102) goto L5;
        this.f76714a.f76704f.set(r101.f76421b.getTimestamp());
        return true;
    L5:
        ALogger.e("MultiLinkDzy", "call sei sampling failure XXX, timestamp: " + r101.f76421b.getTimestamp() + ", last = " + r102 + ", compareResult[" + r101.f76422c + ", " + r101.f76423d + ']');
        return false;
    }
}
