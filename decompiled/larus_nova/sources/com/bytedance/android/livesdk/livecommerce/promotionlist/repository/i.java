package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tj2.c f151245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<List<String>, Boolean, UpdateLocalViewType, Unit> f151246b;

    public i(tj2.b r100, Function3 r101) {
        Intrinsics.checkNotNullParameter(r100, "localDataSource");
        Intrinsics.checkNotNullParameter(r101, "notifyDataChangedCallback");
        this.f151246b = r101;
        this.f151245a = r100.k();
    }
}
