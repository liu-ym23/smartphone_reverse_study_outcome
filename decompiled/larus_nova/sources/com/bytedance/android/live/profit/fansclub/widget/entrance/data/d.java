package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f87401a;

    public d(i r100) {
        this.f87401a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        IFollowPair r101 = (IFollowPair) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Intrinsics.areEqual(r101.getUserIdString(), this.f87401a.f());
    }
}
